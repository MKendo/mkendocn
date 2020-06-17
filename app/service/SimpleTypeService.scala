package service

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import models.SimpleType
import play.api.db.DBApi

class SimpleTypeService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def findNameByCode(code: String): Option[String] ={
    println("code="+code)
    db.withConnection {
      implicit c: java.sql.Connection =>
        val name:Option[String] = SQL("SELECT name FROM simpletypes WHERE code={db_code}").on(
          "db_code" -> code).as(SqlParser.str("simpletypes.name").singleOpt)
        return name
    }
  }

  def findByTypeCode(typeCode:String):List[SimpleType] = {
    println("findByTypeCode SimpleType = "+typeCode)
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[SimpleType] = Macro.namedParser[SimpleType]
        val sql = SQL("select * from simpletypes where typecode={db_typecode} and enable=1 order by code asc")
          .on("db_typecode" -> s"$typeCode")

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

}
