// @GENERATOR:play-routes-compiler
// @SOURCE:D:/products/mkendocn/conf/routes
// @DATE:Fri Feb 14 15:28:41 CST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
