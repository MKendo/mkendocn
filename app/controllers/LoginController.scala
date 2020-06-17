package controllers

import java.net.URLEncoder

import controllers.wx.WxInterface
import javax.inject.Inject
import models.User
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{MemberService, RoleService, UserService}

class LoginController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  def login() = Action {
    implicit request => {
      val mobile = request.body.asFormUrlEncoded.get("form_username_mobile").head
      val password = request.body.asFormUrlEncoded.get("form_password").head

      val userService = new UserService(dbapi)
      val result = userService.login(mobile,password)
      if(result.startsWith("SUCCESS")){
        val name = result.substring(8)
        val loginedUserInfo =  getLoginedInfo(mobile,name)
        Ok(views.html.message(name + " 恭喜您登录成功！", "您已获得更多的操作权限！请看菜单栏。",loginedUserInfo)).withSession("LIGINED"->(loginedUserInfo))
      }else
        Ok(views.html.message(" 登录失败 :(", result,""))
    }
  }

  def getLoginedInfo(mobile:String, name:String):String = {
    val roleService = new RoleService(dbapi)
    val roles = roleService.findRolesByMobile(mobile)
    return mobile+"__"+name+"__"+roles
  }

  def logout() = Action {
    implicit request => {
      Ok(views.html.login("")).withSession(request.session - "LIGINED")
    }
  }

  def wxLogout() = Action {
    implicit request => {
      Ok(views.html.forwx.wxindex("")).withSession(request.session - "LIGINED")
    }
  }

  /**
    * 直接转到，微信授权连接：https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb22ad90722b75c13&redirect_uri=https%3A%2F%2Fwww.mkendo.cn%2Fwxmkkservice%2Flogin&response_type=code&scope=snsapi_userinfo&state=gongzhonghao#wechat_redirect
    * 使用场景：当用户从微信访问某页面，main里面判断没有登录时，调用的连接，为了请求用户同意授权，此时的currentUri没有用户登录信息
    * @return
    */
  def gotoWxFromWx(sourceurl:String) = Action {
    implicit request => {
      println("sourceurl = " + sourceurl)
      println("request.domain = " + request.domain)
      println("request.remoteAddress = " + request.remoteAddress)
      val currentUri = sourceurl
      Redirect(s"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb22ad90722b75c13&redirect_uri=https%3A%2F%2Fwww.mkendo.cn%2Fwxmkkservice%2Flogin&response_type=code&scope=snsapi_userinfo&state=$currentUri#wechat_redirect")
    }
  }

  /**
    * 使用 WxInterface.WXAUTH_URL 连接登录（url生成的二维码可扫描），此方法是微信获取授权code成功后回调的函数
    * @return
    */
  def wxLogin() = Action {
    implicit request => {
      val code = request.getQueryString("code").get
      println(s"code = $code")
      val state = request.getQueryString("state").get
      println(s"state = $state")

      //获取微信的基本信息
      //val wxInterface = new WxInterface()
      val wxUserInfo = WxInterface.getToken(code)
      println("token = " + wxUserInfo.token)
      println("openid = " + wxUserInfo.openid)
      println("unionid = " + wxUserInfo.unionid)

      //保存基本信息
      val user = User(-1,
        "未关联会员",
        "",
        "mkendo.cn", //暂定密码
        wxUserInfo.openid,
        wxUserInfo.unionid,
        wxUserInfo.wxname,
        wxUserInfo.wximgurl,
        "",
        "")

      val userService = new UserService(dbapi)
      try {
        val dbUser = userService.findByUnionId(user.wxUnionid)
        if(dbUser==null){
          val userid = userService.createUser(user)
          println("增加用户成功：userid = " + userid)
          binding(userid,"")
        }else{//此处也没有保存openid,wxname,wximgurl等信息，需要的时候再加上
          println("已存在 wxuionid="+user.wxOpenid +" 的用户，不需要增加")
          //看是否需要绑定
          if(dbUser.mobile.isEmpty){//说明需要绑定
            println("有user基本信息但是没绑定过(users.mobile为空)，去填写信息绑个吧")
            binding(dbUser.id,"")//打开绑定界面，填写用户名手机号
          }else{
            val loginedInfo = getLoginedInfo(dbUser.mobile,dbUser.name)
              if(state=="123") {
                Ok(views.html.forwx.wxindex(loginedInfo)).withSession("LIGINED" -> loginedInfo)
              }else {
                //val param = URLEncoder.encode(s"$loginedInfo","utf-8") //url参数中有中文需要编码
                val url = s"https://www.mkendo.cn/$state"
                println("url = " + url)
                Redirect(url).withSession("LIGINED" -> loginedInfo)
              }
          }
        }
      }catch {
        case ex: Exception => {
          println("通过微信登录时出现异常：" + ex.getMessage + " " + ex.getCause)
          Ok(views.html.message("通过微信登录时出现异常，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。",
            "","")).withSession(request.session - "LIGINED")
        }
      }

    }
  }

  private def binding(userid: Int,loginedUserInfo:String) = {
    if (userid > 0) {
      //打开一个登录页面，输入手机号和member绑定
      Ok(views.html.bindmember(userid.toString(),loginedUserInfo))
    } else {
      Ok("增加用户时发生错误，返回的userid = " + userid)
    }
  }

  def bindMember() = Action {
    implicit request => {
      try {
        println("bindMember...")
        val userid = request.body.asFormUrlEncoded.get("form_userid").head.toInt
        println("userid=" + userid)
        val mobile = request.body.asFormUrlEncoded.get("form_username_mobile").head
        println("mobile=" + mobile)
        val name = request.body.asFormUrlEncoded.get("form_name").head
        println("name=" + name)
        val isKendoMember = request.body.asFormUrlEncoded.get("form_ismember").head.toString.equals("KENDOMEMBER")

        //姓名和手机更新到user表
        val userService = new UserService(dbapi)
        val updateResult = userService.updateUserBaseInfo(userid, mobile, name)
        if(updateResult<0){
          println("绑定用户时出现错误：更新user信息时返回值为 updateResult="+updateResult)
          Ok(views.html.message(s"亲爱的 $name 出错了 :(",
            "绑定用户时出现错误，user信息更新时出错，请联系西瓜师姐协助您解决问题。<br/>",
            "")).withSession(request.session - "LIGINED")
        }else {
          //找到 member
          val memberService = new MemberService(dbapi)
          val member = memberService.findBy(mobile, name)
          val roleService = new RoleService(dbapi)
          if (member == null) {
            println("绑定用户时没有找到member：根据手机号和姓名没有找到相应的member信息 userid =" + userid)

            //不是剑道会员，则先分配注册用户的角色
            val registerRoleId = roleService.createUserRole2(userid,name,"RESTER_MEMBER")
            println("如果这里没有大于0，说明非剑道会员分配角色时出错了。registerRoleId = " + registerRoleId)
            if(registerRoleId<0)
              throw(new Exception(s"非剑道会员分配角色时出错了 registerRoleId = $registerRoleId"))

            //如果不是剑道会员，此情况属于正常，不需要绑定
            val loginedInfo = getLoginedInfo(mobile, name)
            if(isKendoMember) {
              Ok(views.html.forwx.wxmessage(s"亲爱的 $name :",
                s"根据手机号（$mobile）和姓名（$name）没有找到您的剑道会员信息。如果您实际上是剑道会员，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。<br/>",
                "")).withSession("LIGINED" -> loginedInfo)
            }else{
//              Ok(views.html.forwx.wxmessage("亲爱的 " + name + " 恭喜您注册成功！",
//                "您已成功登录。<br/>",
//                loginedInfo)).withSession("LIGINED" -> loginedInfo)
              Ok(views.html.forwx.wxindex(loginedInfo)).withSession("LIGINED" -> loginedInfo)
            }
          } else {
            //更新member.userid 进行绑定
            var result = -1
            if(mobile.equals(member.mobile)) {
              result = memberService.updateMemberUserId(member.id, userid)
            }else{
              result = memberService.updateMemberUserIdMobile(member.id, userid, mobile)
            }

            if (result < 0) {
              println(s"绑定用户时出现错误：更新member的userid时出错 result = $result")
              Ok(views.html.forwx.wxmessage(s"亲爱的 $name 出错了 :(",
                s"根据手机号（$mobile）和姓名（$name）更新绑定关系时出现错误（result=$result），请不要担心，立即联系西瓜师姐协助您解决这个问题吧。<br/>",
                "")).withSession(request.session - "LIGINED")
            } else {
              //找到member，分配为：剑道会会员 角色
              val userRoleId = roleService.createUserRole(userid,"KENDO_MEMBER")
              val loginedInfo = getLoginedInfo(mobile, name)
              if(userRoleId > 0) {
                Ok(views.html.forwx.wxmessage("亲爱的" + name + " 恭喜您绑定成功！您已成功登录。",
                  "您绑定的会员是：" + member.name + "（身份证号：" + member.idNumber + "） <br/>" +
                    "如果绑定错误，请点此取消绑定，然后联系西瓜师姐协助您解决问题。<br/>",
                  loginedInfo)).withSession("LIGINED" -> loginedInfo)
              }else{
                Ok(views.html.forwx.wxmessage(s"亲爱的 $name 出错了 :(",s"为你分配用户角色时出现错误，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。",loginedInfo))
              }
            }
          }
        }

      }catch{
        case ex:Exception => {
          println("绑定用户时出现异常："+ex.getMessage + " " + ex.getCause)
          throw(ex)
        }
      }
    }
  }
}
