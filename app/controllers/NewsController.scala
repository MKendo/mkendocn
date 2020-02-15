package controllers

import java.io.File

import akka.actor.ActorSystem
import javax.inject.Inject
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents, Session}
import models.Article
import service.NewsService

import scala.util.Random

class NewsController @Inject()(cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi) extends AbstractController(cc) {

  def createNews() = Action(parse.multipartFormData) {
    implicit request => {

      println("createNews....")

      val newsTitle = request.body.asFormUrlEncoded.get("form_title").head.mkString
      println("newsTitle = "+ newsTitle)
      val newsAuthor = request.body.asFormUrlEncoded.get("form_author").head.mkString
      println("newsAuthor = "+ newsAuthor)
      val newsDate = request.body.asFormUrlEncoded.get("form_datetime").head.mkString
      println("newsDate = "+ newsDate)
      val newAddress = request.body.asFormUrlEncoded.get("form_address").head.mkString
      println("newAddress = "+ newAddress)
      val newsDesc = request.body.asFormUrlEncoded.get("form_desc").head.mkString
      println("newsDesc = "+ newsDesc)
      val newsContent = request.body.asFormUrlEncoded.get("article_content").head.mkString
      println("article_content = "+ newsContent)
      val newsImageFielname = request.body.file("form_imagefile").map(imgfile=>{imgfile.filename}).getOrElse("")
      println("newsImageFielname = "+ newsImageFielname)
      val randomm = Random.nextInt(30)
      val newsCode = "NEWS" + BigInt(2000, scala.util.Random).toString(36).substring(randomm,randomm+10)
      println("newsCode = "+ newsCode)

      val news = Article(
              newsCode, //code 取个随机值
              newsTitle,
              newsDesc,
              newsContent,
              newsDate,
              newAddress,
              newsAuthor,
              newsImageFielname
            )

      //上传主图
      request.body.file("form_imagefile").map(imgfile => {
        val fileName = imgfile.filename
        val toFile = new File(s"public/images/users/$fileName")
        toFile.createNewFile()
        //上传文件保存到指定位置
        imgfile.ref.moveFileTo(toFile, true)
        println(s"新闻图片上传成功：$fileName")

        //图片上传成功之后，存入数据库
        val newsService = new NewsService(dbapi)
        val result = newsService.createNews(news)

        //存入数据库也成功，转到显示页面
        if(result.equals("SUCCESS")){
          println(s"新闻数据保存成功：$newsCode $newsTitle")
          val loginedUserInfo = Common.loginConfirm(request.session)
          val newService = new NewsService(dbapi)
          val articles: List[Article] = newService.findLastNews(10)
          val article: Article = newService.findByCode(newsCode)
          Ok(views.html.news(loginedUserInfo,articles,article))
        }else{
          Ok(views.html.message("提交新闻搞时出错了", s"存入数据库时出现错误：$result", ""))
        }
      }
      ).getOrElse(
        Ok(views.html.message("提交新闻搞时出错了", "主图上传失败", ""))
      )
    }
  }
}
