// @GENERATOR:play-routes-compiler
// @SOURCE:D:/products/mkendocn/conf/routes
// @DATE:Tue Feb 18 15:56:25 CST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers.javascript {

  // @LINE:56
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseBookingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def createBooking: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookingController.createBooking",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createbooking"})
        }
      """
    )
  
  }

  // @LINE:48
  class ReverseMemberController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def memberPayment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.memberPayment",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "memberpayment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:48
    def createOrUpdateMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.createOrUpdateMember",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "memberpost/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseNewsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def createNews: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NewsController.createNews",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "postnews"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:13
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "loginpost"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseCommonController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def summerUpload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CommonController.summerUpload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "summer/upload"})
        }
      """
    )
  
    // @LINE:27
    def uploadImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CommonController.uploadImage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadimage"})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseSearchController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SearchController.search",
      """
        function(searchType0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "search/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchType", searchType0))})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseMkendoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def news: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.news",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "news"})
        }
      """
    )
  
    // @LINE:24
    def shownews: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.shownews",
      """
        function(articleCode0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "news/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("articleCode", articleCode0))})
        }
      """
    )
  
    // @LINE:45
    def memberlist: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.memberlist",
      """
        function(timePeriodKeyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memberlist/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("timePeriodKeyword", timePeriodKeyword0))})
        }
      """
    )
  
    // @LINE:42
    def bookinglist: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.bookinglist",
      """
        function(timePeriodKeyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bookinglist/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("timePeriodKeyword", timePeriodKeyword0))})
        }
      """
    )
  
    // @LINE:25
    def postnews: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.postnews",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "postnews"})
        }
      """
    )
  
    // @LINE:46
    def memberdetail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.memberdetail",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memberdetail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:39
    def booking: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.booking",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/booking"})
        }
      """
    )
  
    // @LINE:32
    def aboutus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.aboutus",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "aboutus"})
        }
      """
    )
  
    // @LINE:10
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:11
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MkendoController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }


}
