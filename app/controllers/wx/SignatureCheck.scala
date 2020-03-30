package controllers.wx

/**
  * Created by momos_000 on 2017/9/12.
  */
object SignatureCheck {
//  def token = {"mkendojiaojianzhiai"}
def token = {"mkendo"}

  def doChecksg(signature: String, timestamp: String, nonce: String, echostr: String, token: String): Boolean ={
    val sortedArray = Array(token,timestamp,nonce).sorted
    val sortedString = sortedArray.mkString("")
    println(s"sortedString = $sortedString")
    val hashcode = HashLib.getSha1(sortedString)
    println(s"hashcode = $hashcode")

    if(signature.equals(hashcode)){
      println("signature.equals(hashcode). 正确返回")
      return true
    }else {
      println("错误返回")
      return false
    }
  }
}
