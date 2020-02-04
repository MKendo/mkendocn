package controllers

import play.api.mvc.Session

object Common {

  def loginConfirm(session: Session): String ={
    session
      .get("LIGINED")
      .map { userinfo =>
        print("logined userinfo = " + userinfo)
        return userinfo
      }
      .getOrElse {
        return ""
      }
  }

}
