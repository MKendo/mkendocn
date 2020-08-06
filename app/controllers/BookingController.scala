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
      val service = new SimpleTypeService(dbapi)
      val loginedInfo = Common.loginConfirm(request.session)
      val user = userService.findByMobile(loginedInfo.substring(0,11)) //谁填写的预约提醒就发给谁，因为被填写的人没有user
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
        val placetimename = service.findNameByCode(placetime).getOrElse("")
        //获得练习时间
        val pattern = "[0-9]+".r
        val firstDigtal = pattern.findFirstIn(placetimename).getOrElse("")
        val firstIndex = placetimename.indexOf(firstDigtal)
        val datetime = s"$classdate ${placetimename.substring(firstIndex)}"
        if(user!=null) {
          //发送“预约申请已提交“的消息
          sc.sendBookingCommitedToRegister(
            user.id,
            name,
            coursename,
            datetime,
            "明剑馆 福田保税区道场")
        }

        //屏幕反馈
        val nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
        title = s"亲爱的 $name："
        content = s"<b>$coursename</b><br/>课程申请已提交，我们正加紧准备。<br/><b>$classdate</b> <b>$placetimename</b><br/>不剑不散！<br/><br/>$nowtime"
      }else{
        title = name + " 预约出了点问题："
        content = result
      }

      if(fromm=="wx"){
        Ok(views.html.forwx.wxbookingresult(
          title,
          content,
          loginedInfo))
      }else {
        Ok(views.html.bookingresult(
          title,
          content,
          loginedInfo))
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

  /**
    * 提交预约审核情况
    * @return
    */
  def confirm() = Action {
    implicit request => {
      val bookingresult = request.body.asFormUrlEncoded.get("bookingresult").head
      val failreason = request.body.asFormUrlEncoded.get("failreason").head
      val bookingid = request.body.asFormUrlEncoded.get("bookingid").head.toInt
      val description = request.body.asFormUrlEncoded.get("description").head

      val name = request.body.asFormUrlEncoded.get("name").head
      val mobile = request.body.asFormUrlEncoded.get("mobile").head
      val height = request.body.asFormUrlEncoded.get("height").head
      val weight = request.body.asFormUrlEncoded.get("weight").head

      val placetimecode = request.body.asFormUrlEncoded.get("placetimecode").head
      val placetimeName = request.body.asFormUrlEncoded.get("placetimename").head
      val classdate = request.body.asFormUrlEncoded.get("classdate").head
      val coursename = request.body.asFormUrlEncoded.get("coursename").head

      val userService = new UserService(dbapi)
      val user = userService.findByMobile(mobile)
      val sc = new SendWxMessageController(cc)(dbapi)(ws, controllerComponents)(ec)
      val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)

      val bookingService = new BookingService(dbapi)

      //FOR 屏幕提示
      var title = ""
      var content = ""

      if(user==null){
        content = s"按手机号找不到用户，可能的情况是其它人代约。<br/>用户信息：${name}（$mobile）"
        //更新数据库
        bookingService.updateDescription(bookingid,s"${description}__无用户信息可能是其他人代约")
      }else {
        val bookingDesc = Booking(-1,
          name,
          mobile,
          user.wxOpenid,
          placetimecode,
          placetimeName,
          classdate,
          "",
          "",
          coursename,
          commitDatetime,
          height,
          weight,
          description)

        if (bookingresult.equals("BOOKONG_SUCCESS")) {
          //发送成功消息给体验者
          //获得练习时间
          val pattern = "[0-9]+".r
          val firstDigtal = pattern.findFirstIn(placetimeName).getOrElse("")
          val firstIndex = placetimeName.indexOf(firstDigtal)
          val datetime = s"$classdate ${placetimeName.substring(firstIndex)}"
          sc.sendBookingSuccessToRegister(
            user.id,
            coursename,
            datetime,
            "明剑馆 福田保税区道场")

          //更新数据库
          bookingService.updateDescription(bookingid,s"${description}__确认预约成功")

          //为体验者创建定时提醒任务
          sc.preSendTimeArriveOnTimeMessage(user.id, bookingDesc)
          //屏幕显示
          content = s"${user.name}的预约确认完成：成功"
        } else {
          //发失败消息给体验者，使其重新填写预约信息
          sc.sendBookingFailMessage(user.id, failreason, coursename)

          //更新数据库
          bookingService.updateDescription(bookingid,s"${description}__确认预约失败:$failreason")

          //屏幕显示
          content = s"${user.name}的预约确认完成：失败，$failreason"
        }
      }

      title="预约体验确认"
      val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.message(
        title,
        content,
        loginedUserInfo))
    }
  }

  def updateDesc() = Action {
    implicit request => {
      val bookingid = request.body.asFormUrlEncoded.get("bookingid").head.toInt
      val description = request.body.asFormUrlEncoded.get("description").head
      val odescription = request.body.asFormUrlEncoded.get("odescription").head

      val bookingService = new BookingService(dbapi)
      val newDescription = if(odescription.trim=="") description else s"${odescription}__$description"
      bookingService.updateDescription(bookingid,newDescription)

      val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.message(
        "预约备注修改成功",
        s"备注内容：$description",
        loginedUserInfo))
    }
  }

}
