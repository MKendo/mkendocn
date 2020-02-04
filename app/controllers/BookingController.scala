package controllers

import java.text.SimpleDateFormat
import java.util.Date

import javax.inject.Inject
import play.api.db.DBApi
import play.api.mvc._
import service.BookingService
import models.BookingDescription

class BookingController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  def createBooking =  Action {
    implicit request => {
      println("createBooking....")

      val name = request.body.asFormUrlEncoded.get("name").head
      val mobile = request.body.asFormUrlEncoded.get("mobile").head
      val classdate = request.body.asFormUrlEncoded.get("classdate").head
      val coursename = request.body.asFormUrlEncoded.get("coursename").head

      val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
      val bookingDesc = BookingDescription(
        name,
        mobile,
        request.body.asFormUrlEncoded.get("wechat").head,
        request.body.asFormUrlEncoded.get("placetime").head,
        classdate,
        request.body.asFormUrlEncoded.get("whereknowus").head,
        coursename,
        commitDatetime)

      val result = createBookingImpl(bookingDesc)
      if(result == "SUCCESS") {
        Ok(views.html.message(name + " 恭喜您预约成功！", "请您" + classdate + "准时到来，我们不剑不散！",""))
      }else{
        Ok(views.html.message(name + " 预约出了点问题，请看下面的信息：", result,""))
      }
    }
  }

  /**
    * 预约信息提交到数据库
    * @param bookingDescription
    * @return
    */
  def createBookingImpl(bookingDescription: BookingDescription): String = {
      val bookingService = new BookingService(dbapi,bookingDescription)
      return bookingService.createBooking()
  }

}
