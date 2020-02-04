package controllers

import java.io.File

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.db.DBApi
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._
import service.NewsService

import scala.concurrent.{ExecutionContext, Future}

class MkendoController @Inject()(cc: MessagesControllerComponents)(dbapi: DBApi)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {


  /**
    * The index action.
    */
  def index = Action { implicit request =>
    val service = new NewsService(dbapi)
    val newslist = service.findLastNews(10)
    val loginedUserInfo = Common.loginConfirm(request.session)
    println("loginedUserInfo = " + loginedUserInfo)
    Ok(views.html.index(loginedUserInfo, newslist))
  }

  /**
    * The login action.
    */
  def login = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.login(loginedUserInfo))
  }

  /**
    * The loginb action.
    */
  def loginb = Action { implicit request =>
    Ok(views.html.loginb())
  }

  /**
    * The loginc action.
    */
  def loginc = Action { implicit request =>
    Ok(views.html.loginc())
  }

  /**
    * The teachers action.
    */
  def teachers = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.teachers(loginedUserInfo))
  }

  /**
    * 剑道教室
    */
  def kendoroom = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.coursegird(loginedUserInfo))
  }

  /**
    * 剑道生活
    */
  def kendoliving = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.kendoliving(loginedUserInfo))
  }

  /**
    * 相册
    */
  def photos = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.photos(loginedUserInfo))
  }

  /**
    * 新闻
    */
  def news = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    val newService = new NewsService(dbapi)
    val articles: List[Article] = newService.findLastNews(10)
    Ok(views.html.news(loginedUserInfo, articles, if (articles.isEmpty) null else articles(0)))
  }

  def postnews = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.postnews(loginedUserInfo))
  }

  /**
    * 新闻
    */
  def shownews(articalCode: String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    val newService = new NewsService(dbapi)
    val articles: List[Article] = newService.findLastNews(10)
    val article: Article = newService.findByCode(articalCode.substring(1))
    Ok(views.html.news(loginedUserInfo, articles, article))
  }

  /**
    * 活动报名
    */
  def events = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.events(loginedUserInfo))
  }

  /**
    * 关于我们
    */
  def aboutus = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.aboutus(loginedUserInfo))
  }

  /**
    * 预约体验
    */
  def booking = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.booking(loginedUserInfo))
  }

  /**
    * 常见问题FAQ
    */
  def faq = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.faq(loginedUserInfo))
  }

  /**
    * 博客
    */
  def blogs = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.blogs(loginedUserInfo))
  }

  /**
    * 会员商店
    */
  def shop = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.shop(loginedUserInfo))
  }

  /**
    * 产品详情
    */
  def product = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.product(loginedUserInfo))
  }

  /**
    * 上传文件
    *
    * @return 返回文件的相对路径和文件名，例如：user/IU001.jpg
    */
  def uploadImage() = Action(parse.multipartFormData) { implicit request => {
    request.body.file("form_imagefile").map(imgfile => {
      val fileName = imgfile.filename
      val toFile = new File(s"public/images/users/$fileName")
      toFile.createNewFile()
      //上传文件保存到指定位置
      imgfile.ref.moveFileTo(toFile, true)
      Ok("图片上传成功")
    }
    ).getOrElse(
      Ok("图片上传失败")
    )
  }
  }
}