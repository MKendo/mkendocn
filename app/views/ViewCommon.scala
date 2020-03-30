package views

object ViewCommon {

  def isAuthorized(loginedUserinfo:String,allowAuthorites:String*): Boolean ={
    //println("isAuthorized...." + allowAuthorites)
    //println("loginedUserinfo...." + loginedUserinfo)
    var isAuth = false
    if(allowAuthorites.length==1 && allowAuthorites(0).isEmpty){
      isAuth = true
    }else{
      for(auth <- allowAuthorites){
        isAuth = isAuth || loginedUserinfo.indexOf(auth)>=0
      }
    }
    return isAuth
  }

}
