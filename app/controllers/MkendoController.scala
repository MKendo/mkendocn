package controllers

import javax.inject._
import models._
import play.api.db.DBApi
import play.api.mvc._
import service.{BookingService, MemberService, NewsService}

import scala.concurrent.{ExecutionContext}

class MkendoController @Inject()(cc: MessagesControllerComponents)(dbapi: DBApi)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
    * The index action.
    */
  def index = Action { implicit request =>
    val service = new NewsService(dbapi)
    val newslist = service.findLastNews(3)
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
    * 从微信登录
    */
  def loginb = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.loginb(loginedUserInfo))
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
    * 预约管理页面
    * @param timePeriodKeyword
    * @return
    */
  def bookinglist(timePeriodKeyword:String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)

    val bookingService = new BookingService(dbapi)
    var bookings: List[Booking] = timePeriodKeyword match{
      case "ALL" => bookingService.findByTimePeriod("","")
      case "CURRENT_WEEK" => bookingService.findByTimePeriod(Common.getCurrentWeekStart(),Common.getCurrentWeekEnd())
      case "NEXT_WEEK" => bookingService.findByTimePeriod(Common.getNextWeekStart(),Common.getNextWeekEnd())
      case _ => bookingService.findByTimePeriod("","")
    }

    Ok(views.html.bookinglist(loginedUserInfo,timePeriodKeyword,bookings))
  }

  /**
    * 会员管理页面
    * @param timePeriodKeyword
    * @return
    */
  def memberlist(timePeriodKeyword:String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    println("timePeriodKeyword = " + timePeriodKeyword)

    val memberService = new MemberService(dbapi)
    var members: List[Member] = timePeriodKeyword match{
      case "ALL" => memberService.findByTimePeriod("","")
      case "CURRENT_MONTH" => memberService.findByTimePeriod(Common.getCurrentMonthStart(),Common.getCurrentMonthEnd())
      case "NEXT_MONTY" => memberService.findByTimePeriod(Common.getNextMonthStart(),Common.getNextMonthEnd())
      case _ => memberService.findByTimePeriod("","")
    }

    Ok(views.html.memberlist(loginedUserInfo,timePeriodKeyword,members))
  }

  /**
    * 会员明细页面
    * @param idNumber
    * @return
    */
  def memberdetail(id: String)= Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)

    try {
      val iid = id.substring(1).toInt
      val memberService = new MemberService(dbapi)
      val member: Member = memberService.findById(iid)
      val validates = memberService.findValidatesById(iid)
      Ok(views.html.memberdetail(loginedUserInfo, member, validates,""))
    }catch{
      case ex:Exception =>{
        Ok(views.html.message("访问会员信息页面出错 "+ex.getMessage,s"传入的ID=$id", loginedUserInfo))
      }
    }
  }

  def sendWxMessage() = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.sendwxmessage(loginedUserInfo))
  }

  def addmember() = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.addmember(loginedUserInfo))
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


}
