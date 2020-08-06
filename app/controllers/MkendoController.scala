package controllers

import javax.inject._
import models._
import play.api.db.DBApi
import play.api.mvc._
import service._

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext

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
    * 明剑日语
    */
  def courselist = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    Ok(views.html.courselist(loginedUserInfo))
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
    val stSefvice = new SimpleTypeService(dbapi)
    val placeTimes = stSefvice.findByTypeCode("IntroLessonPlaceTime")
    Ok(views.html.booking(loginedUserInfo,placeTimes))
  }

  /**
    * 从微信打开的预约体验
    * @return
    */
  def wxBooking = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    val stSefvice = new SimpleTypeService(dbapi)
    val placeTimes = stSefvice.findByTypeCode("IntroLessonPlaceTime")
    Ok(views.html.forwx.wxbooking(loginedUserInfo,placeTimes))
  }

  /**
    * 查看预约详情
    * @return
    */
  def bookingDetail(id:String) =  Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    val bookingSefvice = new BookingService(dbapi)
    val booking = bookingSefvice.findById(id.toInt)
    Ok(views.html.bookingdetail(loginedUserInfo,booking))
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
      val roleService = new RoleService(dbapi)
      val roles = roleService.findRoles()
      val userRoleCodes = if(member.userid<0) Nil else {
        roleService.findByUser(member.userid).map(role => role.code)
      }
      Ok(views.html.memberdetail(loginedUserInfo, member, validates,roles,userRoleCodes,""))
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

  def calendar(dateperiod:String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    val userMobile = loginedUserInfo.split("__")(0)
    val calendarService = new CalendarService(dbapi)
    val calInstances = calendarService.findInstanceByDatePeriod(dateperiod,userMobile)
    var calInstanceMap:Map[String,CalendarInstance] = Map()

    val timesBurrer:ListBuffer[String] = ListBuffer[String]()
    for(calInstance <- calInstances){
      val timer = calInstance.getStartTime.substring(0,5) + "-" + calInstance.getEndTime.substring(0,5)
      timesBurrer.append(timer)

      val key = calInstance.getStartDate+timer+calInstance.hashCode()
      println("key = " + key)
      calInstanceMap = calInstanceMap ++ Map(key -> calInstance)
    }
    val times = timesBurrer.toList.distinct.sorted

    val weekDates: scala.List[_root_.scala.Predef.String] = getWeekDates(dateperiod)
    Ok(views.html.calendar(loginedUserInfo,dateperiod,calInstanceMap,weekDates,times))

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
    * 微信公众号首页
    * @return
    */
  def wxindex() = Action { implicit request =>
      val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.forwx.wxindex(loginedUserInfo)).withSession("LIGINED" -> (loginedUserInfo))
  }

  /**
    * 公众号上预约练习剑道
    * @param loginedinfo
    * @return
    */
  def bookingKendo(timePeriodKey:String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    if(loginedUserInfo.isEmpty){
      Ok(views.html.forwx.bookingkendostudy("",timePeriodKey,null,Nil,Nil))
    }else {
      val userMobile = loginedUserInfo.split("__")(0)
      val calendarService = new CalendarService(dbapi)
      val calInstances = calendarService.findInstanceByDatePeriod(timePeriodKey,userMobile)
      var calInstanceMap:Map[String,CalendarInstance] = Map()

      val timesBurrer:ListBuffer[String] = ListBuffer[String]()
      for(calInstance <- calInstances){
        if(calInstance.roleCode.equals("KENDO_MEMBER")) {//只显示“剑道会员角色的calendar”
          val timer = calInstance.getStartTime.substring(0, 5) + "-" + calInstance.getEndTime.substring(0, 5)
          timesBurrer.append(timer)

          val key = calInstance.getStartDate + timer + calInstance.hashCode()
          //println("key = " + key)
          calInstanceMap = calInstanceMap ++ Map(key -> calInstance)
        }
      }
      val times = timesBurrer.toList.distinct.sorted

      val weekDates: List[String] = getWeekDates(timePeriodKey)

      Ok(views.html.forwx.bookingkendostudy(loginedUserInfo,timePeriodKey,calInstanceMap,weekDates,times)).withSession("LIGINED" -> (loginedUserInfo))
    }
  }

  /**
    * 公众号上预约带课签到
    * @param loginedinfo
    * @return
    */
  def bookingKendoTeach(timePeriodKey:String) = Action { implicit request =>
    val loginedUserInfo = Common.loginConfirm(request.session)
    if(loginedUserInfo.isEmpty){
      Ok(views.html.forwx.bookingkendostudy("",timePeriodKey,null,Nil,Nil))
    }else {
      val userMobile = loginedUserInfo.split("__")(0)
      val calendarService = new CalendarService(dbapi)
      val calInstances:List[CalendarInstance] = calendarService.findInstanceByDatePeriod(timePeriodKey,userMobile)
      var calInstanceMap:Map[String,CalendarInstance] = Map()

      val timesBurrer:ListBuffer[String] = ListBuffer[String]()
      for(calInstance <- calInstances){
        if(calInstance.roleCode.equals("KENDO_TEACHER") || calInstance.roleCode.equals("JA_TEACHER")) {//只显示“老师“角色的calendar”
        val timer = calInstance.getStartTime.substring(0, 5) + "-" + calInstance.getEndTime.substring(0, 5)
          timesBurrer.append(timer)

          val key = calInstance.getStartDate + timer + calInstance.hashCode()
          //println("key = " + key)
          calInstanceMap = calInstanceMap ++ Map(key -> calInstance)
        }
      }
      val times = timesBurrer.toList.distinct.sorted

      val weekDates: List[String] = getWeekDates(timePeriodKey)

      Ok(views.html.forwx.bookingkendoteach(loginedUserInfo,timePeriodKey,calInstanceMap,weekDates,times)).withSession("LIGINED" -> (loginedUserInfo))
    }
  }

  private def getWeekDates(timePeriodKey:String) = {
    val weekDates: List[String] = List[String](
      Common.getWeek1(timePeriodKey),
      Common.getWeek2(timePeriodKey),
      Common.getWeek3(timePeriodKey),
      Common.getWeek4(timePeriodKey),
      Common.getWeek5(timePeriodKey),
      Common.getWeek6(timePeriodKey),
      Common.getWeek7(timePeriodKey))
    weekDates
  }


  def bindMember(userid:String) = Action {
    implicit request =>{
    val loginedUserInfo = Common.loginConfirm(request.session)
      Ok(views.html.bindmember(userid,loginedUserInfo)).withSession("LIGINED" -> (loginedUserInfo))
    }
  }

  /**
    * 格式：[WX]__[TITLE]__[CONTENT]
    * 例如：
    * "WX__恭喜预约成功__和你同场的小伙伴们是XXX"
    * "WEBSITE__恭喜预约成功__和你同场的小伙伴们是XXX"
    * @param msg
    * @return
    */
  def message(msg:String) = Action {
    implicit request =>{
      val loginedUserInfo = Common.loginConfirm(request.session)
      val from = msg.split("__")(0)
      val title = msg.split("__")(1)
      val content = msg.split("__")(2)
      if(from=="WX"){
        Ok(views.html.forwx.wxmessage(title, content, loginedUserInfo))
      }else {
        Ok(views.html.message(title, content, loginedUserInfo))
      }
    }
  }

  def calendarInstanceNames(fromm:String) = Action {
    implicit request =>{

      val loginedUserInfo = Common.loginConfirm(request.session)
      val title = "title title"
      val content = "content content"
      if(fromm.equals("WX")){
        Ok(views.html.forwx.wxmessage(title, content, loginedUserInfo))
      }else {
        Ok(views.html.message(title, content, loginedUserInfo))
      }
    }
  }

  /**
    * 查看某场事件的参与者
    * @param calendarKey 格式：calendarid##startDatetime##endDatetime##title##fromurl
    * @return
    */
  def calendarMembers(calendarKey:String) = Action {
    implicit request =>{
      val keys = calendarKey.split("##")
      val calendarId = keys(0).toInt
      val startDatetime = keys(1).replace("+"," ")
      val endDatetime = keys(2).replace("+"," ")
      val title = keys(3).replace("+"," ")
      val fromurl = keys(4).replace("+"," ")
      val loginedUserInfo = Common.loginConfirm(request.session)
      val calendarService = new CalendarService(dbapi)
      val names = calendarService.findNamesByCalendarTimePeriod(calendarId,startDatetime,endDatetime)
      Ok(views.html.calendarmembers(title,calendarId,startDatetime,endDatetime,names,fromurl,loginedUserInfo))
    }
  }

  def wxCalendarMembers(calendarKey:String) = Action {
    implicit request =>{
      val keys = calendarKey.split("##")
      val calendarId = keys(0).toInt
      val startDatetime = keys(1).replace("+"," ")
      val endDatetime = keys(2).replace("+"," ")
      val title = keys(3).replace("+"," ")
      val fromurl = keys(4).replace("+"," ")
      val loginedUserInfo = Common.loginConfirm(request.session)
      val calendarService = new CalendarService(dbapi)

      println("calendarid = " + calendarId)
      println("startdatetime = " + startDatetime)
      println("enddatetime = " + endDatetime)
      val names = calendarService.findNamesByCalendarTimePeriod(calendarId,startDatetime,endDatetime)
      println("names = " + names.mkString(","))
      Ok(views.html.forwx.wxcalendarmembers(title,calendarId,startDatetime,endDatetime,names,fromurl,loginedUserInfo))
    }
  }

}
