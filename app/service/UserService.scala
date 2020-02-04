package service


import anorm.{SQL, SqlParser}
import javax.inject.Inject
import play.api.db.DBApi

class UserService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def login(mobile: String, password: String): String ={
    db.withConnection {
      implicit c:java.sql.Connection =>
        val name: Option[String] = SQL("select name from users where mobile={db_mobile} and password={db_password}").on(
          "db_mobile" -> mobile,"db_password" -> password).as(
          SqlParser.str("users.name").singleOpt)
        val username = String.valueOf(name.get)
        if(username.nonEmpty) return "SUCCESS_"+username
    }
    return "用户名或密码不对请重新登录"
  }

}