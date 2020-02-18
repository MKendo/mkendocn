// @GENERATOR:play-routes-compiler
// @SOURCE:D:/products/mkendocn/conf/routes
// @DATE:Tue Feb 18 15:56:25 CST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:10
  MkendoController_6: controllers.MkendoController,
  // @LINE:13
  LoginController_2: controllers.LoginController,
  // @LINE:27
  CommonController_3: controllers.CommonController,
  // @LINE:29
  NewsController_0: controllers.NewsController,
  // @LINE:31
  SearchController_1: controllers.SearchController,
  // @LINE:41
  BookingController_5: controllers.BookingController,
  // @LINE:48
  MemberController_4: controllers.MemberController,
  // @LINE:56
  Assets_7: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:10
    MkendoController_6: controllers.MkendoController,
    // @LINE:13
    LoginController_2: controllers.LoginController,
    // @LINE:27
    CommonController_3: controllers.CommonController,
    // @LINE:29
    NewsController_0: controllers.NewsController,
    // @LINE:31
    SearchController_1: controllers.SearchController,
    // @LINE:41
    BookingController_5: controllers.BookingController,
    // @LINE:48
    MemberController_4: controllers.MemberController,
    // @LINE:56
    Assets_7: controllers.Assets
  ) = this(errorHandler, MkendoController_6, LoginController_2, CommonController_3, NewsController_0, SearchController_1, BookingController_5, MemberController_4, Assets_7, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, MkendoController_6, LoginController_2, CommonController_3, NewsController_0, SearchController_1, BookingController_5, MemberController_4, Assets_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.MkendoController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.MkendoController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loginpost""", """controllers.LoginController.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """news""", """controllers.MkendoController.news"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """news/""" + "$" + """articleCode<[^/]+>""", """controllers.MkendoController.shownews(articleCode:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postnews""", """controllers.MkendoController.postnews"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uploadimage""", """controllers.CommonController.uploadImage"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postnews""", """controllers.NewsController.createNews"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search/""" + "$" + """searchType<[^/]+>""", """controllers.SearchController.search(searchType:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """aboutus""", """controllers.MkendoController.aboutus"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/booking""", """controllers.MkendoController.booking"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/createbooking""", """controllers.BookingController.createBooking"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """bookinglist/""" + "$" + """timePeriodKeyword<[^/]+>""", """controllers.MkendoController.bookinglist(timePeriodKeyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """memberlist/""" + "$" + """timePeriodKeyword<[^/]+>""", """controllers.MkendoController.memberlist(timePeriodKeyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """memberdetail/""" + "$" + """id<[^/]+>""", """controllers.MkendoController.memberdetail(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """memberpost/""" + "$" + """id<[^/]+>""", """controllers.MemberController.createOrUpdateMember(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """memberpayment/""" + "$" + """id<[^/]+>""", """controllers.MemberController.memberPayment(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """summer/upload""", """controllers.CommonController.summerUpload"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:10
  private[this] lazy val controllers_MkendoController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_MkendoController_index0_invoker = createInvoker(
    MkendoController_6.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_MkendoController_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_MkendoController_login1_invoker = createInvoker(
    MkendoController_6.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_LoginController_login2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loginpost")))
  )
  private[this] lazy val controllers_LoginController_login2_invoker = createInvoker(
    LoginController_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      this.prefix + """loginpost""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:14
  private[this] lazy val controllers_LoginController_logout3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout3_invoker = createInvoker(
    LoginController_2.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_MkendoController_news4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("news")))
  )
  private[this] lazy val controllers_MkendoController_news4_invoker = createInvoker(
    MkendoController_6.news,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "news",
      Nil,
      "GET",
      this.prefix + """news""",
      """ GET     /loginb                       controllers.MkendoController.loginb
 GET     /loginc                       controllers.MkendoController.loginc
 GET     /teachers                     controllers.MkendoController.teachers
 GET     /kendoroom                    controllers.MkendoController.kendoroom
 GET     /kendoliving                  controllers.MkendoController.kendoliving
 GET     /photos                       controllers.MkendoController.photos
 GET     /events                       controllers.MkendoController.events""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_MkendoController_shownews5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("news/"), DynamicPart("articleCode", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MkendoController_shownews5_invoker = createInvoker(
    MkendoController_6.shownews(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "shownews",
      Seq(classOf[String]),
      "GET",
      this.prefix + """news/""" + "$" + """articleCode<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_MkendoController_postnews6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postnews")))
  )
  private[this] lazy val controllers_MkendoController_postnews6_invoker = createInvoker(
    MkendoController_6.postnews,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "postnews",
      Nil,
      "GET",
      this.prefix + """postnews""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_CommonController_uploadImage7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadimage")))
  )
  private[this] lazy val controllers_CommonController_uploadImage7_invoker = createInvoker(
    CommonController_3.uploadImage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CommonController",
      "uploadImage",
      Nil,
      "POST",
      this.prefix + """uploadimage""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:29
  private[this] lazy val controllers_NewsController_createNews8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postnews")))
  )
  private[this] lazy val controllers_NewsController_createNews8_invoker = createInvoker(
    NewsController_0.createNews,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NewsController",
      "createNews",
      Nil,
      "POST",
      this.prefix + """postnews""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:31
  private[this] lazy val controllers_SearchController_search9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search/"), DynamicPart("searchType", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SearchController_search9_invoker = createInvoker(
    SearchController_1.search(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SearchController",
      "search",
      Seq(classOf[String]),
      "POST",
      this.prefix + """search/""" + "$" + """searchType<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:32
  private[this] lazy val controllers_MkendoController_aboutus10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("aboutus")))
  )
  private[this] lazy val controllers_MkendoController_aboutus10_invoker = createInvoker(
    MkendoController_6.aboutus,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "aboutus",
      Nil,
      "GET",
      this.prefix + """aboutus""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_MkendoController_booking11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/booking")))
  )
  private[this] lazy val controllers_MkendoController_booking11_invoker = createInvoker(
    MkendoController_6.booking,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "booking",
      Nil,
      "GET",
      this.prefix + """user/booking""",
      """ Booking""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_BookingController_createBooking12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/createbooking")))
  )
  private[this] lazy val controllers_BookingController_createBooking12_invoker = createInvoker(
    BookingController_5.createBooking,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookingController",
      "createBooking",
      Nil,
      "POST",
      this.prefix + """user/createbooking""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:42
  private[this] lazy val controllers_MkendoController_bookinglist13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("bookinglist/"), DynamicPart("timePeriodKeyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MkendoController_bookinglist13_invoker = createInvoker(
    MkendoController_6.bookinglist(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "bookinglist",
      Seq(classOf[String]),
      "GET",
      this.prefix + """bookinglist/""" + "$" + """timePeriodKeyword<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_MkendoController_memberlist14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("memberlist/"), DynamicPart("timePeriodKeyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MkendoController_memberlist14_invoker = createInvoker(
    MkendoController_6.memberlist(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "memberlist",
      Seq(classOf[String]),
      "GET",
      this.prefix + """memberlist/""" + "$" + """timePeriodKeyword<[^/]+>""",
      """ Members""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_MkendoController_memberdetail15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("memberdetail/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MkendoController_memberdetail15_invoker = createInvoker(
    MkendoController_6.memberdetail(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MkendoController",
      "memberdetail",
      Seq(classOf[String]),
      "GET",
      this.prefix + """memberdetail/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_MemberController_createOrUpdateMember16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("memberpost/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MemberController_createOrUpdateMember16_invoker = createInvoker(
    MemberController_4.createOrUpdateMember(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "createOrUpdateMember",
      Seq(classOf[String]),
      "POST",
      this.prefix + """memberpost/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:50
  private[this] lazy val controllers_MemberController_memberPayment17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("memberpayment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MemberController_memberPayment17_invoker = createInvoker(
    MemberController_4.memberPayment(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "memberPayment",
      Seq(classOf[String]),
      "POST",
      this.prefix + """memberpayment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:53
  private[this] lazy val controllers_CommonController_summerUpload18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("summer/upload")))
  )
  private[this] lazy val controllers_CommonController_summerUpload18_invoker = createInvoker(
    CommonController_3.summerUpload,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CommonController",
      "summerUpload",
      Nil,
      "POST",
      this.prefix + """summer/upload""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:56
  private[this] lazy val controllers_Assets_versioned19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned19_invoker = createInvoker(
    Assets_7.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:10
    case controllers_MkendoController_index0_route(params@_) =>
      call { 
        controllers_MkendoController_index0_invoker.call(MkendoController_6.index)
      }
  
    // @LINE:11
    case controllers_MkendoController_login1_route(params@_) =>
      call { 
        controllers_MkendoController_login1_invoker.call(MkendoController_6.login)
      }
  
    // @LINE:13
    case controllers_LoginController_login2_route(params@_) =>
      call { 
        controllers_LoginController_login2_invoker.call(LoginController_2.login)
      }
  
    // @LINE:14
    case controllers_LoginController_logout3_route(params@_) =>
      call { 
        controllers_LoginController_logout3_invoker.call(LoginController_2.logout)
      }
  
    // @LINE:23
    case controllers_MkendoController_news4_route(params@_) =>
      call { 
        controllers_MkendoController_news4_invoker.call(MkendoController_6.news)
      }
  
    // @LINE:24
    case controllers_MkendoController_shownews5_route(params@_) =>
      call(params.fromPath[String]("articleCode", None)) { (articleCode) =>
        controllers_MkendoController_shownews5_invoker.call(MkendoController_6.shownews(articleCode))
      }
  
    // @LINE:25
    case controllers_MkendoController_postnews6_route(params@_) =>
      call { 
        controllers_MkendoController_postnews6_invoker.call(MkendoController_6.postnews)
      }
  
    // @LINE:27
    case controllers_CommonController_uploadImage7_route(params@_) =>
      call { 
        controllers_CommonController_uploadImage7_invoker.call(CommonController_3.uploadImage)
      }
  
    // @LINE:29
    case controllers_NewsController_createNews8_route(params@_) =>
      call { 
        controllers_NewsController_createNews8_invoker.call(NewsController_0.createNews)
      }
  
    // @LINE:31
    case controllers_SearchController_search9_route(params@_) =>
      call(params.fromPath[String]("searchType", None)) { (searchType) =>
        controllers_SearchController_search9_invoker.call(SearchController_1.search(searchType))
      }
  
    // @LINE:32
    case controllers_MkendoController_aboutus10_route(params@_) =>
      call { 
        controllers_MkendoController_aboutus10_invoker.call(MkendoController_6.aboutus)
      }
  
    // @LINE:39
    case controllers_MkendoController_booking11_route(params@_) =>
      call { 
        controllers_MkendoController_booking11_invoker.call(MkendoController_6.booking)
      }
  
    // @LINE:41
    case controllers_BookingController_createBooking12_route(params@_) =>
      call { 
        controllers_BookingController_createBooking12_invoker.call(BookingController_5.createBooking)
      }
  
    // @LINE:42
    case controllers_MkendoController_bookinglist13_route(params@_) =>
      call(params.fromPath[String]("timePeriodKeyword", None)) { (timePeriodKeyword) =>
        controllers_MkendoController_bookinglist13_invoker.call(MkendoController_6.bookinglist(timePeriodKeyword))
      }
  
    // @LINE:45
    case controllers_MkendoController_memberlist14_route(params@_) =>
      call(params.fromPath[String]("timePeriodKeyword", None)) { (timePeriodKeyword) =>
        controllers_MkendoController_memberlist14_invoker.call(MkendoController_6.memberlist(timePeriodKeyword))
      }
  
    // @LINE:46
    case controllers_MkendoController_memberdetail15_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MkendoController_memberdetail15_invoker.call(MkendoController_6.memberdetail(id))
      }
  
    // @LINE:48
    case controllers_MemberController_createOrUpdateMember16_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MemberController_createOrUpdateMember16_invoker.call(MemberController_4.createOrUpdateMember(id))
      }
  
    // @LINE:50
    case controllers_MemberController_memberPayment17_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MemberController_memberPayment17_invoker.call(MemberController_4.memberPayment(id))
      }
  
    // @LINE:53
    case controllers_CommonController_summerUpload18_route(params@_) =>
      call { 
        controllers_CommonController_summerUpload18_invoker.call(CommonController_3.summerUpload)
      }
  
    // @LINE:56
    case controllers_Assets_versioned19_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned19_invoker.call(Assets_7.versioned(path, file))
      }
  }
}
