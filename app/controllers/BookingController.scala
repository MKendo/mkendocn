package controllers

import java.text.SimpleDateFormat
import java.util.Date

import javax.inject.Inject
import play.api.db.DBApi
import play.api.mvc._
import service.{BookingService, SimpleTypeService}
import models.Booking

class BookingController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  def createBooking =  Action {
    implicit request => {
      println("createBooking....")

      val name = request.body.asFormUrlEncoded.get("name").head
      val mobile = request.body.asFormUrlEncoded.get("mobile").head
      val placetime = request.body.asFormUrlEncoded.get("placetime").head
      val classdate = request.body.asFormUrlEncoded.get("classdate").head
      val coursename = request.body.asFormUrlEncoded.get("coursename").head

      val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
      val bookingDesc = Booking(
        name,
        mobile,
        request.body.asFormUrlEncoded.get("wechat").head,
        placetime,
        "",
        classdate,
        request.body.asFormUrlEncoded.get("whereknowus").head,
        "",
        coursename,
        commitDatetime)

      val result = createBookingImpl(bookingDesc)

      //预约成功
      if(result == "SUCCESS") {
        val service = new SimpleTypeService(dbapi)
        val placetimename = service.findNameByCode(placetime).getOrElse("")
        val nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
        Ok(views.html.message(s"亲爱的 $name：", s"您已成功预约剑道体验课<b>“$coursename”</b>。<br/>请您于 <b>$classdate</b> 准时参加 <b>$placetimename</b> 的课程，我们不剑不散！<br/><br/>明剑官网：<a href='www.mkendo.cn'>www.mkendo.cn</a><br/>馆长微信：15889489370 <br/>$nowtime",""))
      }else{
        Ok(views.html.message(name + " 预约出了点问题，请看下面的信息：", result,""))
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
