package controllers

import java.text.SimpleDateFormat
import java.util.Date

import javax.inject.Inject
import play.api.db.DBApi
import play.api.mvc._
import service._
import models.{Booking, ScheduledTask}
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext

class BookingController @Inject()(ws: WSClient,cc: ControllerComponents)(dbapi: DBApi)(ec: ExecutionContext) extends AbstractController(cc) {

  def createBooking =  Action {
    implicit request => {
      println("createBooking....")

      val name = request.body.asFormUrlEncoded.get("name").head
      val mobile = request.body.asFormUrlEncoded.get("mobile").head
      val placetime = request.body.asFormUrlEncoded.get("placetime").head
      val classdate = request.body.asFormUrlEncoded.get("classdate").head
      val coursename = request.body.asFormUrlEncoded.get("coursename").head
      val fromm = request.body.asFormUrlEncoded.get("fromm").head
      val height = request.body.asFormUrlEncoded.get("height").head
      val weight = request.body.asFormUrlEncoded.get("weight").head
      val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
      val userService = new UserService(dbapi)
      val user = userService.findByMobile(mobile)//loginedInfo.substring(0,11) //原来是找当前用户，现在是找填写的用户，同时适用于帮别人填写的情景
      val wxOpenid = if(user==null) "" else user.wxOpenid

      val bookingDesc = Booking(-1,
        name,
        mobile,
        wxOpenid,
        placetime,
        "",
        classdate,
        request.body.asFormUrlEncoded.get("whereknowus").head,
        "",
        coursename,
        commitDatetime,
        height,
        weight,"")

      val result = createBookingImpl(bookingDesc)
      val bookingid = if(result.startsWith("SUCCESS")) result.substring(8).toInt else -1

      //预约成功
      var title = ""
      var content = ""
      if(bookingid > 0) {
        //发送消息给管理员和代课老师们
        val sc = new SendWxMessageController(cc)(dbapi)(ws, controllerComponents)(ec)
        sc.sendBookingMessageToAdmin(bookingid, name, mobile, placetime, "福田保税区道场")

        //发送消息给预约者本人
        val service = new SimpleTypeService(dbapi)
        val placetimename = service.findNameByCode(placetime).getOrElse("")
        val loginedInfo = Common.loginConfirm(request.session)
        val pattern = "[0-9]+".r
        val firstDigtal = pattern.findFirstIn(placetimename).getOrElse("")
        val firstIndex = placetimename.indexOf(firstDigtal)
        val datetime = s"$classdate ${placetimename.substring(firstIndex)}"

        if(user!=null) {
          sc.sendBookingSuccessToRegister(
            user.id,
            coursename,
            datetime,
            "明剑馆 福田保税区道场")

          //创建定时发送提醒任务
          sc.preSendTimeArriveOnTimeMessage(user.id,bookingDesc)
        }

        //屏幕反馈
        val nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
        title = s"亲爱的 $name："
        content = s"您已成功预约剑道体验课<b>“$coursename”</b><br/><b>$classdate</b> <b>$placetimename</b><br/>我们不剑不散！<br/><br/>明剑官网：<a href='www.mkendo.cn'>www.mkendo.cn</a><br/>馆长微信：15889489370 <br/>$nowtime"
      }else{
        title = name + " 预约出了点问题："
        content = result
      }

      if(fromm=="wx"){
        Ok(views.html.forwx.wxbookingresult(
          title,
          content,
          ""))
      }else {
        Ok(views.html.bookingresult(
          title,
          content,
          ""))
      }
    }
  }

  /**
    * 预约信息提交到数据库
    * @param booking
    * @return
    */
  def createBookingImpl(booking: Booking): String = {
      val bookingService = new BookingService(dbapi)
      return bookingService.createBooking(booking)
  }

}
