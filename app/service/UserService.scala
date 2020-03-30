package service


import java.text.SimpleDateFormat
import java.util.Date

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import models.User
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

  def findRolesByMobile(mobile:String): String ={
    db.withConnection {
      implicit c:java.sql.Connection =>
        val rolenames: List[String] = SQL("select r.name rname from users u " +
          "left join user_roles ur on ur.userid=u.id " +
          "left join simpletypes r on ur.roleid=r.id " +
          "where u.mobile={db_mobile}").on(
          "db_mobile" -> mobile).as(
          SqlParser.str("rname").*)

        var result = ""
        for(name <- rolenames){
          result = s"$result$name "
        }

        return result
    }
  }

  def createUser(user:User): Int = {
    println("createUser.....")
    if(user.wxOpenid.isEmpty || user.wxUnionid.isEmpty){
      throw(new Exception("增加用户失败，原因是：用户信息中的openid或unionid为空"))
    }

    try {
      db.withConnection {
        val commitdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
        implicit c: java.sql.Connection =>
          val result: Option[Long] = SQL("insert into users(name, mobile, password, wxopenid, wxunionid,wxname,wximgurl, commitdatetime, description, enable) " +
            "values({db_name},{db_mobile},{db_password},{db_wxopenid},{db_wxunionid},{db_wxname},{db_wximgurl},{db_commitdatetime},{db_description},1)").on(
            "db_name" -> user.name,
            "db_mobile" -> user.mobile,
            "db_password" -> user.password,
            "db_wxopenid" -> user.wxOpenid,
            "db_wxunionid" -> user.wxUnionid,
            "db_wxname" -> user.wxName,
            "db_wximgurl" -> user.wxImgurl,
            "db_commitdatetime" -> commitdatetime,
            "db_description" -> user.description
          ).executeInsert()

          return if(result.get>0) result.get.toInt else -1
      }
    }catch{
      case ex:Exception => {
        throw ex
      }
    }
  }

  def findByUnionId(unionid:String): User ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val newsParser: RowParser[User] = Macro.namedParser[User]
          return SQL("select u.id,u.name,u.mobile,u.password,u.wxopenid wxOpenid ,u.wxunionid wxUnionid ,u.wxname wxName,u.wximgurl wxImgurl, u.description, m.name memberName " +
            "from users u left join members m on m.userid=u.id " +
            "where u.wxunionid={db_wxunionid}"
          ).on("db_wxunionid" -> unionid).as(newsParser.single)
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return null
      }
    }
  }

  def findByUserId(userId:Int): User ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val newsParser: RowParser[User] = Macro.namedParser[User]
          return SQL("select u.id,u.name,u.mobile,u.password,u.wxopenid wxOpenid ,u.wxunionid wxUnionid ,u.wxname wxName,u.wximgurl wxImgurl, u.description, m.name memberName " +
            "from users u left join members m on m.userid=u.id " +
            "where u.id={db_userid}"
          ).on("db_userid" -> userId).as(newsParser.single)
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return null
      }
    }
  }

  def updateUserBaseInfo(userId:Int, mobile:String, name:String):Int ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val result: Option[Long] = SQL("update users set name={db_name},mobile={db_mobile} " +
            "where id={db_userid}").on(
            "db_name" -> name,
            "db_mobile" -> mobile,
            "db_userid" -> userId
          ).executeInsert()
        return if(result.get>0) result.get.toInt else -1
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        throw(ex)
      }
    }
  }

}