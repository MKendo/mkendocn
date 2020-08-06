package service

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import models.{Member, SimpleType}
import play.api.db.DBApi

class RoleService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def findRoles():List[SimpleType] = {
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[SimpleType] = Macro.namedParser[SimpleType]
        val sql = SQL("select * from simpletypes where typecode='ROLE'")

        val simpleTypes: List[SimpleType] = {
          try {
            sql.as(newsParser.*)
          }catch{
            case ex: ArrayIndexOutOfBoundsException => {
              println(ex.getMessage+" "+ex.getCause)
              return Nil;
            }
          }
        }

        simpleTypes
    }
  }

  def findByCodes(roleCodes:List[String]):List[SimpleType] = {
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[SimpleType] = Macro.namedParser[SimpleType]
        val sql = SQL("select * from simpletypes where typecode='ROLE' and code in ({db_rolecodes})")
          .on("db_rolecodes" -> roleCodes)

        val simpleTypes: List[SimpleType] = {
          try {
            sql.as(newsParser.*)
          }catch{
            case ex: ArrayIndexOutOfBoundsException => {
              println(ex.getMessage+" "+ex.getCause)
              return Nil;
            }
          }
        }

        simpleTypes
    }
  }

  def findByUser(userId:Int):List[SimpleType] = {
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[SimpleType] = Macro.namedParser[SimpleType]
        val sql = SQL("select r.* from users u " +
          "join user_roles ur on ur.userid=u.id " +
          "join simpletypes r on ur.roleid=r.id where u.id={db_userid}")
          .on("db_userid" -> userId)

        val simpleTypes: List[SimpleType] = {
          try {
            sql.as(newsParser.*)
          }catch{
            case ex: ArrayIndexOutOfBoundsException => {
              println(ex.getMessage+" "+ex.getCause)
              return Nil;
            }
          }
        }

        simpleTypes
    }
  }

  def createUserRole(userId:Int,roleCode:String): Int ={
    println("createUserRole....")
    println("userId = " + userId)
    println("roleCode = " + roleCode)
    val userService = new UserService(dbapi)
    val user = userService.findByUserId(userId)
    val role = findByCode(roleCode)

    db.withConnection {
      implicit c: java.sql.Connection =>
        val id: Option[Long] = SQL("insert into user_roles(" +
          "userid ,roleid ,description ,enable) " +
          "values({db_userid},{db_roleid},{db_des},1)").on(
          "db_userid" -> userId,
          "db_roleid" -> role.id,
          "db_des" -> (user.name+" "+role.name)).executeInsert()

        if(id.get>0) id.get.toInt else -1
    }
  }

  def createUserRole2(userId:Int,userName:String,roleCode:String): Int ={
    val role = findByCode(roleCode)

    db.withConnection {
      implicit c: java.sql.Connection =>
        val id: Option[Long] = SQL("insert into user_roles(" +
          "userid ,roleid ,description ,enable) " +
          "values({db_userid},{db_roleid},{db_des},1)").on(
          "db_userid" -> userId,
          "db_roleid" -> role.id,
          "db_des" -> (userName+" "+role.name)).executeInsert()

        if(id.get>0) id.get.toInt else -1
    }
  }


  def findRoleIdsByMobile(mobile:String):List[Int] = {
    db.withConnection {
      implicit c:java.sql.Connection =>
        val roleids: List[Int] = SQL("select r.id rid from users u " +
          "left join user_roles ur on ur.userid=u.id " +
          "left join simpletypes r on ur.roleid=r.id " +
          "where u.mobile={db_mobile}").on(
          "db_mobile" -> mobile).as(
          SqlParser.int("rid").*)

        roleids
    }
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

  def findByCode(rodeCode:String):SimpleType = {
    val newsParser: RowParser[SimpleType] = Macro.namedParser[SimpleType]

    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val role: SimpleType = SQL("select * from simpletypes " +
            "where typecode='ROLE' and code={db_code}").on(
            "db_code" -> rodeCode).as(newsParser.single)

          role
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage+" "+ex.getCause)
        throw ex
      }
    }
  }


  def removeUserRole(userid:Int):Int = {
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val result : Int = SQL("delete from user_roles " +
            "where userid={db_userid}").on(
            "db_userid" -> userid).executeUpdate()

          println("delete result = " + result)
          return if(result>0) result else -1
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        throw(ex)
      }
    }
  }
}
