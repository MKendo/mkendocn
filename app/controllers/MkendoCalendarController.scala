package controllers

import akka.actor.ActorSystem
import javax.inject.Inject
import models.CalendarInstance
import play.api.db.DBApi
import play.api.libs.ws.WSClient
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{CalendarService, UserService}

import scala.concurrent.ExecutionContext

class MkendoCalendarController @Inject()(ws: WSClient, cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi)(ec: ExecutionContext) extends AbstractController(cc) {

  def postEvent() = Action{
    implicit request => {
      val loginedUserInfo = request.body.asFormUrlEncoded.get("loginedUserInfo").head.toString
      val calendarid = request.body.asFormUrlEncoded.get("calendarid").head.toInt
      val roleid = request.body.asFormUrlEncoded.get("roleid").head.toInt
      val startdatetime = request.body.asFormUrlEncoded.get("startdatetime").head.toString.replace('_',' ')
      val enddatetime = request.body.asFormUrlEncoded.get("enddatetime").head.toString.replace('_',' ')
      val event = request.body.asFormUrlEncoded.get("event").head.toString
      val eventtype = request.body.asFormUrlEncoded.get("eventType").head.toString
      val from = request.body.asFormUrlEncoded.get("from").head.toString

      val userService = new UserService(dbapi)
      val mobile = loginedUserInfo.split("__")(0)
      val userid = userService.findByMobile(mobile).id

      //保存为calendarInstancce
      val calendarService = new CalendarService(dbapi)
      val instance = CalendarInstance(-1,
        calendarid,
        userid,"",
        roleid,"","","","","",
        startdatetime,
        enddatetime,
        -1, //最大人数
        -1, //已完成（预约/打卡）人数
        "",
        "",
        -1)
      calendarService.createCalendarInstance(instance)

      //发送微信模板消息到公众号
      val sc = new SendWxMessageController(cc)(dbapi)(ws,controllerComponents)(ec)
      sc.sendBookingSuccessMessage(userid,calendarid,event,eventtype,startdatetime,enddatetime)

      val names = calendarService.findNamesByCalendarTimePeriod(calendarid,startdatetime,enddatetime)
      println("names = " + names.mkString(","))
      val name = loginedUserInfo.split("__")(1)
      val title = s"$name $event $eventtype 成功!"

      if(from.startsWith("/wx/")) {
        Ok(views.html.forwx.wxcalendarmembers(title,calendarid,startdatetime,enddatetime,names, from, loginedUserInfo))
      }else{
        Ok(views.html.calendarmembers(title,calendarid,startdatetime,enddatetime,names, from,loginedUserInfo))
      }
    }
  }
}
