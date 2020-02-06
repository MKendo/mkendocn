package service

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
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

}
