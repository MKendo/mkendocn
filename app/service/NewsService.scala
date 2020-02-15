package service

import java.text.SimpleDateFormat
import java.util.Date

import javax.inject.Inject
import anorm._
import anorm.{SQL, SqlParser}
import play.api.db.DBApi
import anorm.{Macro, RowParser}
import models.Article

/**
  * 新闻类
  * @param dbapi
  * @param userid
  */
class NewsService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def findLastNews(count: Int): List[Article] ={
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[Article] = Macro.namedParser[Article]

        val result: List[Article] = SQL(
          "SELECT * FROM articles " +
          "where typeid=(select id from simpletypes where code='NEWS') " +
            "ORDER BY eventstartdatetime desc limit {acount}").on(
                                "acount" -> count).as(newsParser.*)
        return result
    }
  }

  def findByCode(code: String): Article ={
    println("code="+code)
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[Article] = Macro.namedParser[Article]
        try {
          val article: Article = SQL("SELECT * FROM articles WHERE code={db_code}").on(
            "db_code" -> code).as(newsParser.single)

          return article
        }catch{
          case ex: Exception => {
             return null
        }
        }
    }
  }

  def createNews(news: Article): String = {
    if(news.code.isEmpty){
      return "程序发生异常：new.code不能为空"
    }

    if(news.title.isEmpty){
      return "文章标题不能为空"
    }

    if(news.content.isEmpty){
      return "文章内容不能为空"
    }

    var newshortContent = news.shortcontent
    if(news.shortcontent.isEmpty) {
      val newshortContent = news.content.substring(if (news.content.length() > 100) 100 else news.content.length()-1)
    }

    var typeid = -1
    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where code='NEWS'").as(
          SqlParser.int("simpletypes.id").singleOpt)
        typeid = Integer.valueOf(id.get)
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val result: Option[Long] = SQL("insert into articles(code,typeid,title,subtitle,shortcontent,content,imgurl,eventstartdatetime,eventaddress,creatername,createdatetime,enable) " +
          "values({db_code},{db_typeid},{db_title},{db_subtitle},{db_shortcontent},{db_content},{db_imgurl},{db_eventstartdatetime},{db_eventaddress},{db_creatername},{db_createdatetime},{db_enable})").on(
          "db_code" -> news.code,
          "db_typeid" -> typeid,
          "db_title" -> news.title,
          "db_subtitle" -> news.title,
          "db_shortcontent" -> newshortContent,
          "db_content" -> news.content,
          "db_imgurl" -> news.imgurl,
          "db_eventstartdatetime" -> news.eventStartDatetime,
          "db_eventaddress" -> news.eventAddress,
          "db_creatername" -> news.createrName,
          "db_createdatetime" -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date),
          "db_enable" -> 1
        ).executeInsert()
        return "SUCCESS"
    }
    return "未知问题，请联系管理员或重试一次。";
    }
}