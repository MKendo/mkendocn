
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
		"""),_display_(/*8.4*/if(titleType=="HOMEPAGE")/*8.29*/{_display_(Seq[Any](format.raw/*8.30*/("""
		    """),format.raw/*9.7*/(""""深圳剑道 明剑馆 首页"   
		""")))}/*10.4*/else if(titleType=="ABOUTUS")/*10.33*/{_display_(Seq[Any](format.raw/*10.34*/("""
		    """),format.raw/*11.7*/(""""深圳剑道 明剑馆 关于我们"
		""")))}/*12.4*/else if(titleType=="NEWS")/*12.30*/{_display_(Seq[Any](format.raw/*12.31*/("""
            """),format.raw/*13.13*/(""""深圳剑道 明剑馆 新闻与活动"
        """)))}/*14.10*/else/*14.14*/{_display_(Seq[Any](format.raw/*14.15*/("""
            """),_display_(/*15.14*/titleType),format.raw/*15.23*/("""
         """)))}),format.raw/*16.11*/("""
		"""),format.raw/*17.3*/("""</title>

        <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="深圳剑道 明剑馆" />
        <meta name="keywords" content="深圳剑道,剑道,明剑,明剑馆,academy, course, education, education html theme, elearning, learning" />
        <meta name="author" content="明剑馆" />
        <!-- Favicon and Touch Icons -->
        """),_display_(/*25.10*/head/*25.14*/.touchicons()),format.raw/*25.27*/("""
        """),format.raw/*26.9*/("""<!-- Stylesheet -->
        """),_display_(/*27.10*/head/*27.14*/.commoncss()),format.raw/*27.26*/("""
        """),format.raw/*28.9*/("""<!-- CSS | menuzord megamenu skins -->
        """),_display_(/*29.10*/head/*29.14*/.menuskins()),format.raw/*29.26*/("""
        """),format.raw/*30.9*/("""<!-- CSS | Main style file -->
        """),_display_(/*31.10*/head/*31.14*/.maincss()),format.raw/*31.24*/("""
        """),format.raw/*32.9*/("""<!-- CSS | Preloader Styles  -->
        """),_display_(/*33.10*/head/*33.14*/.preloadercss()),format.raw/*33.29*/("""
        """),format.raw/*34.9*/("""<!-- CSS | Custom Margin Padding Collection -->
        """),_display_(/*35.10*/head/*35.14*/.custombootstrapmarginpaddingcss()),format.raw/*35.48*/("""
        """),format.raw/*36.9*/("""<!-- CSS | Responsive media queries -->
        """),_display_(/*37.10*/head/*37.14*/.responsivecss()),format.raw/*37.30*/(""" """),format.raw/*37.31*/("""<!--登录页，老师页列表页-->
        <!-- CSS | Theme Color -->
        """),_display_(/*39.10*/head/*39.14*/.themskincolorset1css()),format.raw/*39.37*/("""
        """),format.raw/*40.9*/("""<!-- external javascripts -->
        """),_display_(/*41.10*/head/*41.14*/.exjs()),format.raw/*41.21*/("""
        """),_display_(/*42.10*/head/*42.14*/.forie9js()),format.raw/*42.25*/("""
    """),format.raw/*43.5*/("""</head>
    <body>
    <div id="wrapper" class="clearfix">
        <!-- preloader @widgets.preloader() -->


        <!-- Header -->
        <header id="header" class="header">
            <!--nav.headertop()-->
	        """),_display_(/*52.11*/nav/*52.14*/.headermiddle()),format.raw/*52.29*/("""
			"""),_display_(/*53.5*/nav/*53.8*/.headernav(titleType,loginUserInfo)),format.raw/*53.43*/("""
        """),format.raw/*54.9*/("""</header>

        """),_display_(/*56.10*/if(isNeedLogin && loginUserInfo.isEmpty)/*56.50*/ {_display_(Seq[Any](format.raw/*56.52*/("""
            """),format.raw/*57.13*/("""<div class="container">
                <div class="esc-heading heading-line-bottom lr-line left-heading">
                    <h4>您尚未登录，没有权限访问此页面，如果需要请先登录，或者联系西瓜师姐哦。</h4>
                </div>
            </div>
        """)))}/*62.10*/else/*62.14*/{_display_(Seq[Any](format.raw/*62.15*/("""
            """),format.raw/*63.13*/("""<!-- Start main-content -->
            <div class="main-content">
            """),_display_(/*65.14*/content),format.raw/*65.21*/("""
            """),format.raw/*66.13*/("""<!-- end main-content -->
            """),_display_(/*67.14*/footer/*67.20*/.first()),format.raw/*67.28*/("""
            """),format.raw/*68.13*/("""</div>
        """)))}),format.raw/*69.10*/("""
    """),format.raw/*70.5*/("""</div><!-- end wrapper -->
    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
    <!-- Footer Scripts -->
    """),_display_(/*73.6*/js/*73.8*/.customjs()),format.raw/*73.19*/("""
    """),format.raw/*74.5*/("""</body>
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
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/main.scala.html
                  HASH: d9479cbc82255aa2a2dd56f5ae35018397d3ea28
                  MATRIX: 748->1|919->79|946->80|1045->154|1078->179|1116->180|1149->187|1187->207|1225->236|1264->237|1298->244|1335->263|1370->289|1409->290|1450->303|1495->329|1508->333|1547->334|1588->348|1618->357|1660->368|1690->371|2161->815|2174->819|2208->832|2244->841|2300->870|2313->874|2346->886|2382->895|2457->943|2470->947|2503->959|2539->968|2606->1008|2619->1012|2650->1022|2686->1031|2755->1073|2768->1077|2804->1092|2840->1101|2924->1158|2937->1162|2992->1196|3028->1205|3104->1254|3117->1258|3154->1274|3183->1275|3272->1337|3285->1341|3329->1364|3365->1373|3431->1412|3444->1416|3472->1423|3509->1433|3522->1437|3554->1448|3586->1453|3835->1676|3847->1679|3883->1694|3914->1699|3925->1702|3981->1737|4017->1746|4064->1766|4113->1806|4153->1808|4194->1821|4436->2044|4449->2048|4488->2049|4529->2062|4636->2142|4664->2149|4705->2162|4771->2201|4786->2207|4815->2215|4856->2228|4903->2244|4935->2249|5092->2380|5102->2382|5134->2393|5166->2398
                  LINES: 21->1|26->2|27->3|32->8|32->8|32->8|33->9|34->10|34->10|34->10|35->11|36->12|36->12|36->12|37->13|38->14|38->14|38->14|39->15|39->15|40->16|41->17|49->25|49->25|49->25|50->26|51->27|51->27|51->27|52->28|53->29|53->29|53->29|54->30|55->31|55->31|55->31|56->32|57->33|57->33|57->33|58->34|59->35|59->35|59->35|60->36|61->37|61->37|61->37|61->37|63->39|63->39|63->39|64->40|65->41|65->41|65->41|66->42|66->42|66->42|67->43|76->52|76->52|76->52|77->53|77->53|77->53|78->54|80->56|80->56|80->56|81->57|86->62|86->62|86->62|87->63|89->65|89->65|90->66|91->67|91->67|91->67|92->68|93->69|94->70|97->73|97->73|97->73|98->74
                  -- GENERATED --
              */
          