
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,Boolean,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titleType: String,loginUserInfo: String,isNeedLogin: Boolean)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html dir="ltr" lang="en">
    <head>
        <title>
        """),_display_(/*8.10*/{val title = titleType match {
            case "HOMEPAGE" => "深圳剑道 明剑馆 首页"
            case "NEWS" => "深圳剑道 明剑馆 新闻与活动"
            case "ABOUTUS" => "深圳剑道 明剑馆 关于我们"
            case "POSTNEWS" => "深圳剑道 明剑馆 发布新闻"
            case "BOOKING" => "深圳剑道 明剑馆 预约管理"
            case "MEMBERS" => "深圳剑道 明剑馆 会员管理"
            case _ => titleType
          }
          title
        }),format.raw/*18.10*/("""
		"""),format.raw/*19.3*/("""</title>

        <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="深圳剑道 明剑馆" />
        <meta name="keywords" content="深圳剑道,剑道,明剑,明剑馆,academy, course, education, education html theme, elearning, learning" />
        <meta name="author" content="明剑馆" />
        <!-- Favicon and Touch Icons -->
        """),_display_(/*27.10*/head/*27.14*/.touchicons()),format.raw/*27.27*/("""
        """),format.raw/*28.9*/("""<!-- Stylesheet -->
        """),_display_(/*29.10*/head/*29.14*/.commoncss()),format.raw/*29.26*/("""
        """),format.raw/*30.9*/("""<!-- CSS | menuzord megamenu skins -->
        """),_display_(/*31.10*/head/*31.14*/.menuskins()),format.raw/*31.26*/("""
        """),format.raw/*32.9*/("""<!-- CSS | Main style file -->
        """),_display_(/*33.10*/head/*33.14*/.maincss()),format.raw/*33.24*/("""
        """),format.raw/*34.9*/("""<!-- CSS | Preloader Styles  -->
        """),_display_(/*35.10*/head/*35.14*/.preloadercss()),format.raw/*35.29*/("""
        """),format.raw/*36.9*/("""<!-- CSS | Custom Margin Padding Collection -->
        """),_display_(/*37.10*/head/*37.14*/.custombootstrapmarginpaddingcss()),format.raw/*37.48*/("""
        """),format.raw/*38.9*/("""<!-- CSS | Responsive media queries -->
        """),_display_(/*39.10*/head/*39.14*/.responsivecss()),format.raw/*39.30*/(""" """),format.raw/*39.31*/("""<!--登录页，老师页列表页-->
        <!-- CSS | Theme Color -->
        """),_display_(/*41.10*/head/*41.14*/.themskincolorset1css()),format.raw/*41.37*/("""
        """),format.raw/*42.9*/("""<!-- external javascripts -->
        """),_display_(/*43.10*/head/*43.14*/.exjs()),format.raw/*43.21*/("""
        """),_display_(/*44.10*/head/*44.14*/.forie9js()),format.raw/*44.25*/("""
    """),format.raw/*45.5*/("""</head>
    <body>
    <div id="wrapper" class="clearfix">
        <!-- preloader @widgets.preloader() -->


        <!-- Header -->
        <header id="header" class="header">
            <!--nav.headertop()-->
	        """),_display_(/*54.11*/nav/*54.14*/.headermiddle()),format.raw/*54.29*/("""
			"""),_display_(/*55.5*/nav/*55.8*/.headernav(titleType,loginUserInfo)),format.raw/*55.43*/("""
        """),format.raw/*56.9*/("""</header>

        """),_display_(/*58.10*/if(isNeedLogin && loginUserInfo.isEmpty)/*58.50*/ {_display_(Seq[Any](format.raw/*58.52*/("""
            """),format.raw/*59.13*/("""<div class="container">
                <div class="esc-heading heading-line-bottom lr-line left-heading">
                    <h4>您尚未登录，没有权限访问此页面，如果需要请先登录，或者联系西瓜师姐哦。</h4>
                </div>
            </div>
        """)))}/*64.10*/else/*64.14*/{_display_(Seq[Any](format.raw/*64.15*/("""
            """),format.raw/*65.13*/("""<!-- Start main-content -->
            <div class="main-content">
            """),_display_(/*67.14*/content),format.raw/*67.21*/("""
            """),format.raw/*68.13*/("""<!-- end main-content -->
            """),_display_(/*69.14*/footer/*69.20*/.first()),format.raw/*69.28*/("""
            """),format.raw/*70.13*/("""</div>
        """)))}),format.raw/*71.10*/("""
    """),format.raw/*72.5*/("""</div><!-- end wrapper -->
    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
    <!-- Footer Scripts -->
    """),_display_(/*75.6*/js/*75.8*/.customjs()),format.raw/*75.19*/("""
    """),format.raw/*76.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(titleType:String,loginUserInfo:String,isNeedLogin:Boolean,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(titleType,loginUserInfo,isNeedLogin)(content)

  def f:((String,String,Boolean) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (titleType,loginUserInfo,isNeedLogin) => (content) => apply(titleType,loginUserInfo,isNeedLogin)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/main.scala.html
                  HASH: 0a5b6ca219be0481638aced498223d86f1ac54a4
                  MATRIX: 748->1|919->79|946->80|1052->160|1447->534|1477->537|1948->981|1961->985|1995->998|2031->1007|2087->1036|2100->1040|2133->1052|2169->1061|2244->1109|2257->1113|2290->1125|2326->1134|2393->1174|2406->1178|2437->1188|2473->1197|2542->1239|2555->1243|2591->1258|2627->1267|2711->1324|2724->1328|2779->1362|2815->1371|2891->1420|2904->1424|2941->1440|2970->1441|3059->1503|3072->1507|3116->1530|3152->1539|3218->1578|3231->1582|3259->1589|3296->1599|3309->1603|3341->1614|3373->1619|3622->1842|3634->1845|3670->1860|3701->1865|3712->1868|3768->1903|3804->1912|3851->1932|3900->1972|3940->1974|3981->1987|4223->2210|4236->2214|4275->2215|4316->2228|4423->2308|4451->2315|4492->2328|4558->2367|4573->2373|4602->2381|4643->2394|4690->2410|4722->2415|4879->2546|4889->2548|4921->2559|4953->2564
                  LINES: 21->1|26->2|27->3|32->8|42->18|43->19|51->27|51->27|51->27|52->28|53->29|53->29|53->29|54->30|55->31|55->31|55->31|56->32|57->33|57->33|57->33|58->34|59->35|59->35|59->35|60->36|61->37|61->37|61->37|62->38|63->39|63->39|63->39|63->39|65->41|65->41|65->41|66->42|67->43|67->43|67->43|68->44|68->44|68->44|69->45|78->54|78->54|78->54|79->55|79->55|79->55|80->56|82->58|82->58|82->58|83->59|88->64|88->64|88->64|89->65|91->67|91->67|92->68|93->69|93->69|93->69|94->70|95->71|96->72|99->75|99->75|99->75|100->76
                  -- GENERATED --
              */
          