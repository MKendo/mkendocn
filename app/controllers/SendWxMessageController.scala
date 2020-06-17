package controllers

import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import controllers.wx.WxInterface.{SEND_MESSAGE_URL, TOKEN_URL2}
import play.api.db.DBApi
import play.api.libs.json.{JsObject, JsValue, Json}
import play.api.mvc.ControllerComponents
import javax.inject.Inject
import models.{Booking, ScheduledTask}

import scala.concurrent.Future
import play.api.mvc._
import play.api.libs.ws._

import scala.concurrent.ExecutionContext
import play.api.libs.ws.{WSClient, WSResponse}
import service._

class SendWxMessageController @Inject()(cc: ControllerComponents)
                                       (dbapi: DBApi)
                                       (ws: WSClient, val controllerComponents: ControllerComponents)
                                       (ec: ExecutionContext) extends BaseController {

  /**
    * 页面调用的通用消息发送
    * @return
    */
  def sendWxMessage() = Action{
    implicit request => {
      val tokenJson = scala.io.Source.fromURL(TOKEN_URL2).mkString
      val tokenJsonValue = Json.parse(tokenJson)
      println(s"tokenJsonValue = $tokenJsonValue")
      val token = (tokenJsonValue \\ "access_token").mkString.replace("\"","")
      val sendmesssageUrl = SEND_MESSAGE_URL + token

      val openid = request.body.asFormUrlEncoded.get("form_openid").head.toString
      val templateid = request.body.asFormUrlEncoded.get("form_templateid").head.toString
      val template = request.body.asFormUrlEncoded.get("form_template").head.toString
      val message = request.body.asFormUrlEncoded.get("form_message").head.toString
      val msgurl = request.body.asFormUrlEncoded.get("form_url").head.toString

      val templatePattern = "\\{\\{[a-zA-Z0-9]*\\.DATA\\}\\}".r

      val templateKeys:List[String] = templatePattern.findAllIn(template).toList //获取模板里所有的{{XXX.DATA}}
      val templateRealKeys = templateKeys.map(key=>{ key.substring(2,key.indexOf(".DATA}}")) }) //获取模板里所有真实的的参数名称


      val messagePattern = "\\{\\{.*\\.DATA\\}\\}".r
      val messageValues:List[String] = messagePattern.findAllIn(message).toList //获取内容里所有的{{XXX.DATA}}
      val messageRealValues:List[String] = messageValues.map(value=>{ value.substring(2,value.indexOf(".DATA}}")) })  //获取内容里所有的{{XXX.DATA}}中的XXX

      println("templateRealKeys.length = " + templateRealKeys.length)
      println("messageRealValues = " + messageRealValues)
      assert(templateRealKeys.length>0 && templateRealKeys.length==messageRealValues.length)
      var keyValueMap:Map[String,String] = Map[String,String]()

      var dataSeq = Seq[(String,JsValue)]()
      for (i <- 0 to templateRealKeys.length-1){
        keyValueMap = keyValueMap ++ Map(templateRealKeys(i) -> messageRealValues(i))
        dataSeq = dataSeq ++ List(templateRealKeys(i) ->  Json.obj("value" -> messageRealValues(i)))
      }
      val datas:JsObject = JsObject(dataSeq)

      val data = Json.obj(
        "touser" -> openid,
        "template_id" -> templateid,
        "url" -> msgurl,
        "data" -> datas
      )
      println("data=" + data.toString())
      val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)

      futureResponse.map{ response =>
        println(response.body)
      }(ec)

      val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.message("消息发送完成","",loginedUserInfo))

    }
    }

  /**
    * 到期日提醒
    * @param userId
    * @return
    */
  def sendValidteMessage(userId:String) = Action{
    implicit request => {
      println("sendValidteMessage......")
      val userService = new UserService(dbapi)
      val user = userService.findByUserId(userId.toInt)
      println("userId.toInt = " + userId.toInt)
      println("user = " + user.toString)
      val memberService = new MemberService(dbapi)
      val member = memberService.findByUserId(userId.toInt)
      if(member==null){
        val loginedUserInfo = Common.loginConfirm(request.session)
        Ok(views.html.message("没有对应的user信息，请确认该会员已经绑定微信用户？","",loginedUserInfo))
      }else {
        val tokenJson = scala.io.Source.fromURL(TOKEN_URL2).mkString
        val tokenJsonValue = Json.parse(tokenJson)
        println(s"tokenJsonValue = $tokenJsonValue")
        val token = (tokenJsonValue \\ "access_token").mkString.replace("\"", "")
        val sendmesssageUrl = SEND_MESSAGE_URL + token

        val openid = user.wxOpenid
        val first = s"亲爱的 ${member.name}："
        val name = "明剑馆会员"
        val endValidate = member.endValidate
        val remark = "感谢一直以来对明剑的支持，对所爱的坚持。继续携手去看更美的风景吧！"

        val data = Json.obj(
          "touser" -> openid,
          "template_id" -> "ggorp-ZvIw-MKxlwGs8rj8eHj7BFCZwJhYZKkh2BgUY",
          "url" -> "https://www.mkendo.cn/assets/images/yinlianpay.jpg",
          "data" -> Json.obj(
            "first" -> Json.obj("value" -> first),
            "name" -> Json.obj("value" -> name),
            "expDate" -> Json.obj("value" -> endValidate),
            "remark" -> Json.obj("value" -> remark)
          )
        )
        println("data=" + data.toString())
        val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)

        futureResponse.map { response =>
          println(response.body)
        }(ec)

        val loginedUserInfo = Common.loginConfirm(request.session)
        Ok(views.html.message(member.name+"的有效期提醒发送完成", "", loginedUserInfo))
      }
    }
  }

  /**
    * 发送微信消息的通用方法
    * @param openid
    * @param templateid
    * @param template
    * @param msgurl
    * @param keyword
    * @return
    */
  def sendWxTemplateMessage(openid:String,templateid:String,template:String,msgurl:String,keyword:String*) = {
      val tokenJson = scala.io.Source.fromURL(TOKEN_URL2).mkString
      val tokenJsonValue = Json.parse(tokenJson)
      println(s"tokenJsonValue = $tokenJsonValue")
      val token = (tokenJsonValue \\ "access_token").mkString.replace("\"","")
      val sendmesssageUrl = SEND_MESSAGE_URL + token

      val templatePattern = "\\{\\{[a-zA-Z0-9]*\\.DATA\\}\\}".r

      val templateKeys:List[String] = templatePattern.findAllIn(template).toList //获取模板里所有的{{XXX.DATA}}
      val templateRealKeys = templateKeys.map(key=>{ key.substring(2,key.indexOf(".DATA}}")) }) //获取模板里所有真实的的参数名称

      val messageRealValues:List[String] =  keyword.toList

      println("templateRealKeys = " + templateRealKeys)
      println("messageRealValues = " + messageRealValues)
      assert(templateRealKeys.length>0 && templateRealKeys.length==messageRealValues.length)

      var dataSeq = Seq[(String,JsValue)]()
      for (i <- 0 to templateRealKeys.length-1){
        dataSeq = dataSeq ++ List(templateRealKeys(i) ->  Json.obj("value" -> messageRealValues(i)))
      }
      val datas:JsObject = JsObject(dataSeq)

      val data = Json.obj(
        "touser" -> openid,
        "template_id" -> templateid,
        "url" -> msgurl,
        "data" -> datas
      )
      println("data=" + data.toString())
      val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)

      futureResponse.map{ response =>
        println(response.body)
      }(ec)
  }

  /**
    * 发送预约体验消息给相关负责人
    * @param username
    * @param mobile
    * @param courseCode 体验课code也就是simpletypes表中typecode='IntroLessonPlaceTime'的code
    * @param place 地点
    */
  def sendBookingMessageToAdmin(bookingId:Int, username:String, mobile:String, courseCode:String, place:String): Unit ={

    val stService = new SimpleTypeService(dbapi)
    val courseName = stService.findNameByCode(courseCode).getOrElse("")

    val templateid = "7vfPlRrtX1iAvdIilfIPJU-kFAiT19LUCdTJeBPMvx8"
    val template = "{{first.DATA}}\n会员名称：{{keyword1.DATA}}\n预约时间：{{keyword2.DATA}}\n{{remark.DATA}}"
    val msgurl = "https://www.mkendo.cn/user/bookingdetail/"+bookingId
    val first = s"明剑馆$place 有新同学预约体验了。"
    val keyword1 = s"$username（$mobile）"
    val remark = "请及时关注哦。"

    val userService = new UserService(dbapi)
    val users = userService.findByRoleCode("SUPER_ADMIN")

    //发送给所有管理员
    for(user <- users) {
      val openid = user.wxOpenid
      sendWxTemplateMessage(openid, templateid, template, msgurl, first, keyword1, courseName, remark)
    }
  }

  /**
    * 发送预约体验课成功消息给预约体验者（角色：注册用户）
    * @param userId
    * @param calendarid
    * @param event
    * @param eventType
    * @param startDatetime
    * @param endDatetime
    */
  def sendBookingSuccessToRegister(userId:Int,courseName:String,datetime:String,place:String): Unit ={
    val userService = new UserService(dbapi)
    val user = userService.findByUserId(userId)

    val openid = user.wxOpenid
    val templateid = "_PpIguHsbJl16Fmg7bX-a4UJY14IeM91acLtzr0oR1A"
    val template = "{{first.DATA}}\n课程名称：{{keyword1.DATA}}\n上课时间：{{keyword2.DATA}}\n地址：{{keyword3.DATA}}\n{{remark.DATA}}"

    val first = s"亲爱的 ${user.name} 明剑馆剑道体验预约成功！"
    val keyword1 = courseName
    val keyword2 = datetime
    val keyword3 = place
    val remark = "准时到来不剑不散哦！点击“查看详情”跟着导航过来吧。"
    val msgurl = "https://router.map.qq.com/short?l=16cd10685c1194ecb8c66b8f0da7de80" //腾讯地图连接地址
    sendWxTemplateMessage(openid,templateid,template,msgurl,first,keyword1,keyword2,keyword3,remark)
  }

  /**
    * 发送预约/签到成功消息到个人的微信公众号
    * @param userId
    * @param event
    * @param eventType
    * @param datetime
    * @param place
    */
  def sendBookingSuccessMessage(userId:Int,calendarid:Int,event:String,eventType:String,startDatetime:String,endDatetime:String): Unit ={
    val userService = new UserService(dbapi)
    val user = userService.findByUserId(userId)

    val openid = user.wxOpenid
    val templateid = "_PpIguHsbJl16Fmg7bX-a4UJY14IeM91acLtzr0oR1A"
    val template = "{{first.DATA}}\n课程名称：{{keyword1.DATA}}\n上课时间：{{keyword2.DATA}}\n地址：{{keyword3.DATA}}\n{{remark.DATA}}"
    //calendarid##startDatetime##endDatetime##title##fromurl
    val params = s"$calendarid##$startDatetime##$endDatetime## ## ##"
    val msgurl = eventType match{
      case "预约练习" => "https://www.mkendo.cn/wx/wxcalendarmembers/"+URLEncoder.encode(params,"UTF-8")
      case "带课签到" => "https://www.mkendo.cn/wx/wxcalendarmembers/"+URLEncoder.encode(params,"UTF-8")
      case _ => ""
    }
    val place = eventType match{
      case "预约练习" => "福田保税区道场"
      case "带课签到" => "福田保税区道场"
      case "讲课签到" => "明剑日语直播课堂"
      case _ => "明剑馆"
    }
    //val msgurl = if(eventType.contains("取消")){""}else{s"https://www.mkendo.cn/wx/wxcalendarmembers/${URLEncoder.encode(params,"UTF-8")}"}
    val first = s"亲爱的 ${user.name} $eventType 成功！"
    val keyword1 = event
    val keyword2 = startDatetime
    val keyword3 = place
    val remark = eventType match{
      case "预约练习" => "准时到来不剑不散哦！点击“查看详情”，看看一起的小伙伴都有谁。"
      case "带课签到" => "感谢辛劳的付出，苦口婆心的教诲，同学们爱您么么哒。点击“查看详情”，看看一起带课的老师都有谁。"
      case "讲课签到" => "感谢辛劳的付出，苦口婆心的教诲，同学们爱您么么哒。"
      case _ => ""
    }
    //val remark = if(eventType.contains("取消")){""}else{"准时到来不剑不散哦！点击“查看详情”，看看一起的小伙伴都有谁。"}
    sendWxTemplateMessage(openid,templateid,template,msgurl,first,keyword1,keyword2,keyword3,remark)
  }

  /**
    * 预发送准时到来提醒，放到数据库中的提醒队列（scheduled_tasks）
    */
  def preSendTimeArriveOnTimeMessage(userId:Int,booking:Booking): Unit ={
    val stService = new SimpleTypeService(dbapi)
    val placetimeName = stService.findNameByCode(booking.placetimeCode).getOrElse("")

    //拼装开始时间
    val startDatetime = s"${booking.classdate} ${placetimeName.substring(placetimeName.indexOf('1')).split("--")(0)}:00"
    println("startDatetime = " + startDatetime)

    //计算提醒时间（提前2小时）
    var sendDatetimeIns = Common.getInstanceByDateString2(startDatetime)
    sendDatetimeIns.add(Calendar.HOUR,-2)
    val sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val sendDatetime = sd.format(sendDatetimeIns.getTime)
    println("sendDatetime = " + sendDatetime)

    //存入数据库
    val taskService = new ScheduledTaskService(dbapi)
    val keywords = s"您预约的明剑馆剑道初心课程快要开始了，准时等你哟。__${startDatetime}__${booking.coursename}__明剑馆__点击“查看详情”跟着导航过来吧。"
    val msgurl = "https://router.map.qq.com/short?l=16cd10685c1194ecb8c66b8f0da7de80" //腾讯地图连接地址
    taskService.create(ScheduledTask(-1,userId,
      "78jrikt1rEzcpu0s6OSyP-oy1PppyT-OF-AMomg_DwY",
      "{{first.DATA}}\n预约时间：{{keyword1.DATA}}\n预约内容：{{keyword2.DATA}}\n创建人：{{keyword3.DATA}}\n{{remark.DATA}}",
      msgurl,keywords,"",sendDatetime,0,1))
  }

}
