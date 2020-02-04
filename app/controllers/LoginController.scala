package controllers

import javax.inject.Inject
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.UserService

class LoginController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  def login() = Action {
    implicit request => {
      val mobile = request.body.asFormUrlEncoded.get("form_username_mobile").head
      val password = request.body.asFormUrlEncoded.get("form_password").head

      val userService = new UserService(dbapi)
      val result = userService.login(mobile,password)
      if(result.startsWith("SUCCESS")){
        val name = result.substring(8)
        Ok(views.html.message(name + " 恭喜您登录成功！", "您已获得更多的操作权限！请看菜单栏。",(mobile+"|"+name))).withSession("LIGINED"->(mobile+"|"+name))
      }else
        Ok(result);
    }
  }

  def logout() = Action {
    implicit request => {
      Ok(views.html.login("")).withSession(request.session - "LIGINED")
    }
  }
}
