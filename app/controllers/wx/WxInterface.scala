package controllers.wx
import models.WxUserInfo
import play.api.libs.json._

object WxInterface {

  val MKKSERVICE_APPID = "wxb22ad90722b75c13"
  val MKKSERVICE_SECRET = "5f7c90901fff3fecbac9617ca0701399"

  val REDIRECT_URI = "http://www.mkendo.cn/wxmkkservice/login"//授权成功后重定向到自己服务器的url
  val STATE = ""//重定向后可以携带的参数值
  //此参数是给微信用的，一定要在微信客户端打开
  val WXAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb22ad90722b75c13&redirect_uri=https%3A%2F%2Fwww.mkendo.cn%2Fwxmkkservice%2Flogin&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect"

  val TOKEN_URL = s"https://api.weixin.qq.com/sns/oauth2/access_token?appid=$MKKSERVICE_APPID&secret=$MKKSERVICE_SECRET&code=**CODE**&grant_type=authorization_code"
  val TOKEN_URL2 = s"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=$MKKSERVICE_APPID&secret=$MKKSERVICE_SECRET"

  val SEND_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="

  def getTokenUrl(authCode:String):String = {
    val tokenUrl = TOKEN_URL.replace("**CODE**",authCode)
    println(s"tokenUrl = $tokenUrl")
    return tokenUrl
  }

  def getToken(authCode:String): WxUserInfo = {
    //用code 换 token
    val tokenJson = scala.io.Source.fromURL(getTokenUrl(authCode)).mkString
    println("tokenJson = " + tokenJson)
    val tokenJsonValue = Json.parse(tokenJson)
    val token = (tokenJsonValue \\ "access_token").mkString.replace("\"","")
    val openid = (tokenJsonValue \\ "openid").mkString.replace("\"","")
    val unionid = (tokenJsonValue \\ "unionid").mkString.replace("\"","")

    return WxUserInfo(token,openid,unionid,"","")
  }

//  def sendTemplateMessage():String = {
//    val tokenJson = scala.io.Source.fromURL(TOKEN_URL2).mkString
//    val tokenJsonValue = Json.parse(tokenJson)
//    val token = (tokenJsonValue \\ "access_token").mkString.replace("\"","")
//    val sendmesssageUrl = SEND_MESSAGE_URL + token
//
//    val data = Json.obj(
//      "key1" -> "value1",
//      "key2" -> "value2"
//    )
//    val futureResponse: Future[WSResponse] = ws.url(sendmesssageUrl).post(data)
//
//    return ""
//  }

}
