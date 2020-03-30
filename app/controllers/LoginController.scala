package controllers

import controllers.wx.WxInterface
import javax.inject.Inject
import models.{User}
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{MemberService, UserService}

class LoginController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  def login() = Action {
    implicit request => {
      val mobile = request.body.asFormUrlEncoded.get("form_username_mobile").head
      val password = request.body.asFormUrlEncoded.get("form_password").head

      val userService = new UserService(dbapi)
      val result = userService.login(mobile,password)
      if(result.startsWith("SUCCESS")){
        val name = result.substring(8)
        val loginedUserInfo =  getRoleNames(mobile,name)
        Ok(views.html.message(name + " 恭喜您登录成功！", "您已获得更多的操作权限！请看菜单栏。",loginedUserInfo)).withSession("LIGINED"->(loginedUserInfo))
      }else
        Ok(result);
    }
  }

  def getRoleNames(mobile:String,name:String):String = {
    val userService = new UserService(dbapi)
    val roles = userService.findRolesByMobile(mobile)
    return mobile+"|"+name+"|"+roles
  }

  def logout() = Action {
    implicit request => {
      Ok(views.html.login("")).withSession(request.session - "LIGINED")
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
        "",
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
          binding(userid)
        }else{//此处也没有保存openid,wxname,wximgurl等信息，需要的时候再加上
          println("已存在 wxuionid="+user.wxOpenid +" 的用户，不需要增加")
          //看是否需要绑定
          if(dbUser.mobile.isEmpty){//说明需要绑定
            println("有user基本信息但是没绑定过(users.mobile为空)，去填写信息绑个吧")
            binding(dbUser.id)
          }else{//看member上的userid是否匹配
            val memberService = new MemberService(dbapi)
            val member = memberService.findBy(dbUser.mobile,dbUser.name)
            val dbuserid = dbUser.id
            println(s"dbuserid = $dbuserid")
            if(member!=null) println(s"member.userid = ${member.userid}")
            if(member!=null && member.userid>0 && member.userid.equals(dbuserid)){
              //已绑定不需要绑定，直接恭喜登录成功
              Ok(views.html.message(dbUser.name + " 恭喜您登录成功！", "您已获得更多的操作权限！请看菜单栏。",
                (dbUser.mobile+"|"+dbUser.name))).withSession("LIGINED"->(getRoleNames(dbUser.mobile,dbUser.name)+"|"))
            }else{
              //直接更新userid
              val result = memberService.updateMemberUserId(member.id,dbuserid)
              if(result>0){
                //绑定成功
                Ok(views.html.message(dbUser.name + " 恭喜您登录成功！", "您已获得更多的操作权限！请看菜单栏。",
                  (dbUser.mobile+"|"+dbUser.name))).withSession("LIGINED"->(getRoleNames(dbUser.mobile,dbUser.name)))
              }else{
                Ok(views.html.message(s"亲爱的 ${dbUser.name} 出错了 :(",
                  s"找到您的会员信息（${member.name}）但自动关联时（更新usesrid时）出了点差错，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。<br/>",
                  "")).withSession(request.session - "LIGINED")
              }
            }
          }
        }
      }catch {
        case ex: Exception => {
          println("扫码登录时出现异常：" + ex.getMessage + " " + ex.getCause)
          Ok(views.html.message("扫码登录时出现异常，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。",
            "","")).withSession(request.session - "LIGINED")
        }
      }

    }
  }

  private def binding(userid: Int) = {
    if (userid > 0) {
      //打开一个登录页面，输入手机号和member绑定
      Ok(views.html.bindmember(userid.toString()))
    } else {
      Ok("增加用户时发生错误，返回的userid = " + userid)
    }
  }

  def bindMember() = Action {
    implicit request => {
      try {
        println("bindMember...")
        val userid = request.body.asFormUrlEncoded.get("form_userid").head
        println("userid=" + userid)
        val mobile = request.body.asFormUrlEncoded.get("form_username_mobile").head
        println("mobile=" + mobile)
        val name = request.body.asFormUrlEncoded.get("form_name").head
        println("name=" + name)

        //姓名和手机更新到user表
        val userService = new UserService(dbapi)
        val dbUserid = userService.updateUserBaseInfo(userid.toInt, mobile, name)
        if(dbUserid<0){
          println("绑定用户时出现错误：更新user信息时返回值为 dbUserid="+dbUserid)
          Ok(views.html.message(s"亲爱的 $name 出错了 :(",
            "绑定用户时出现错误，user信息更新时出错，请联系西瓜师姐协助您解决问题。<br/>",
            "")).withSession(request.session - "LIGINED")
        }else {
          //找到 member
          val memberService = new MemberService(dbapi)
          val member = memberService.findBy(mobile, name)
          if (member == null) {
            println("绑定用户时没有找到member：根据手机号和姓名没有找到相应的member信息" + dbUserid)
            Ok(views.html.message(s"亲爱的 $name 出错了 :(",
              s"根据手机号（$mobile）和姓名（$name）没有找到您的会员信息，请不要担心，立即联系西瓜师姐协助您解决这个问题吧。<br/>",
              "")).withSession(request.session - "LIGINED")
          } else {
            //更新member.userid
            val result = memberService.updateMemberUserId(member.id, userid.toInt)
            if (result < 0) {
              println(s"绑定用户时出现错误：更新member的userid时出错 result = $result")
              Ok(views.html.message(s"亲爱的 $name 出错了 :(",
                s"根据手机号（$mobile）和姓名（$name）更新绑定关系时出现错误（result=$result），请不要担心，立即联系西瓜师姐协助您解决这个问题吧。<br/>",
                "")).withSession(request.session - "LIGINED")
            } else {
              Ok(views.html.message("亲爱的" + name + " 恭喜您绑定成功！您已成功登录。",
                "您绑定的会员是：" + member.name + "（身份证号：" + member.idNumber + "） <br/>" +
                  "如果绑定错误，请点此取消绑定，然后联系西瓜师姐协助您解决问题。<br/>", //TODO
                (mobile + "|" + name))).withSession("LIGINED" -> (getRoleNames(mobile,name)))
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
