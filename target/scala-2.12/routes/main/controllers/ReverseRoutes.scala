// @GENERATOR:play-routes-compiler
// @SOURCE:D:/products/mkendocn/conf/routes
// @DATE:Fri Feb 14 15:28:41 CST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers {

  // @LINE:54
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:54
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:41
  class ReverseBookingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def createBooking(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user/createbooking")
    }
  
  }

  // @LINE:48
  class ReverseMemberController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def memberPayment(idnumber:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "memberpayment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("idnumber", idnumber)))
    }
  
  }

  // @LINE:29
  class ReverseNewsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def createNews(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "postnews")
    }
  
  }

  // @LINE:13
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:13
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "loginpost")
    }
  
  }

  // @LINE:27
  class ReverseCommonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:51
    def summerUpload(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "summer/upload")
    }
  
    // @LINE:27
    def uploadImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "uploadimage")
    }
  
  }

  // @LINE:31
  class ReverseSearchController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def search(searchType:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "search/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchType", searchType)))
    }
  
  }

  // @LINE:10
  class ReverseMkendoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def news(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "news")
    }
  
    // @LINE:24
    def shownews(articleCode:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "news/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("articleCode", articleCode)))
    }
  
    // @LINE:45
    def memberlist(timePeriodKeyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "memberlist/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("timePeriodKeyword", timePeriodKeyword)))
    }
  
    // @LINE:42
    def bookinglist(timePeriodKeyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "bookinglist/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("timePeriodKeyword", timePeriodKeyword)))
    }
  
    // @LINE:25
    def postnews(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "postnews")
    }
  
    // @LINE:46
    def memberdetail(idnumber:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "memberdetail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("idnumber", idnumber)))
    }
  
    // @LINE:39
    def booking(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/booking")
    }
  
    // @LINE:32
    def aboutus(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "aboutus")
    }
  
    // @LINE:10
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:11
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }


}
