package service

import anorm.{Macro, RowParser, SQL}
import javax.inject.Inject
import models.Article
import play.api.db.DBApi

/**
  * 文章，不特指哪种类型
  * @param dbapi
  */
class ArticleService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  /**
    * 根据关键字模糊搜索
    * @param keyword
    * @return
    */
  def findByKeyword(keyword: String): List[Article] ={
    println("keyword="+keyword)
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[Article] = Macro.namedParser[Article]
        val sql = SQL("select * from articles where title like {db_keyword} or shortcontent like{db_keyword} or content like {db_keyword} ").on(
          "db_keyword" -> s"%$keyword%")

        val articles: List[Article] = {
          try {
            sql.as(newsParser.*)
          }catch{
            case ex: ArrayIndexOutOfBoundsException => {
              return Nil;
            }
          }
        }

        return articles
    }
  }

}
