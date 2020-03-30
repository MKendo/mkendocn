package controllers

import controllers.wx.WxInterface.{SEND_MESSAGE_URL, TOKEN_URL2}
import play.api.db.DBApi
import play.api.libs.json.Json
import play.api.mvc.ControllerComponents
import javax.inject.Inject

import scala.concurrent.Future
import play.api.mvc._
import play.api.libs.ws._

import scala.concurrent.ExecutionContext
import play.api.libs.ws.{WSClient, WSResponse}
import service.{MemberService, UserService}


class SendWxMessageController @Inject()(cc: ControllerComponents)
                                       (dbapi: DBApi)
                                       (ws: WSClient, val controllerComponents: ControllerComponents)
                                       (ec: ExecutionContext) extends BaseController {

  def sendWxMessage() = Action{
    implicit request => {
      val tokenJson = scala.io.Source.fromURL(TOKEN_URL2).mkString
      val tokenJsonValue = Json.parse(tokenJson)
      println(s"tokenJsonValue = $tokenJsonValue")
      val token = (tokenJsonValue \\ "access_token").mkString.replace("\"","")
      val sendmesssageUrl = SEND_MESSAGE_URL + token

      val openid = "o1DyJt2_8pZUsNjzpF1FbiGwjx8s" //request.body.asFormUrlEncoded.get("name").head
      val first = "您好，您的会员即将到期，请您注意。"
      val name = "明剑馆剑道会员"
      val endValidate = "2020-6-26"
      val remark = "欢迎联系西瓜师姐续费，扫码后切记备注姓名"

      val data = Json.obj(
        "touser" -> openid,
        "template_id" -> "ggorp-ZvIw-MKxlwGs8rj8eHj7BFCZwJhYZKkh2BgUY",
        "data" -> Json.obj(
          "first" -> Json.obj("value" -> first),
          "name" -> Json.obj("value" -> name),
          "expDate" -> Json.obj("value" -> endValidate),
          "remark" -> Json.obj("value" -> remark)
        )
      )
      val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)

      futureResponse.map{ response =>
         println(response.body)
      }(ec)

      val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.message("有效期提醒发送完成","",loginedUserInfo))
    }
    }

  def sendValidteMessage(userId:String) = Action{
    implicit request => {
      println("sendValidteMessage......")
      val userService = new UserService(dbapi)
      val user = userService.findByUserId(userId.toInt)
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
        val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)

        futureResponse.map { response =>
          println(response.body)
        }(ec)

        val loginedUserInfo = Common.loginConfirm(request.session)
        Ok(views.html.message(member.name+"的有效期提醒发送完成", "", loginedUserInfo))
      }
    }
  }
}
