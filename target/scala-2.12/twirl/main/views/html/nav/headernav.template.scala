
package views.html.nav

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

object headernav extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activePage: String,loginUserInfo: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*2.1*/("""<div class="header-nav">
      <div class="header-nav-wrapper navbar-scrolltofixed bg-theme-colored border-bottom-theme-color-2-1px">
        <div class="container">
          <nav id="menuzord" class="menuzord bg-theme-colored pull-left flip menuzord-responsive">
            <ul class="menuzord-menu">
              <li """),_display_(/*7.20*/if(activePage=="HOMEPAGE")/*7.46*/{_display_(Seq[Any](format.raw/*7.47*/(""" """),format.raw/*7.48*/("""class="active" """)))}),format.raw/*7.64*/("""><a href="/">明剑馆</a></li>
			  <!--
                <ul class="dropdown">
                  <li><a href="/">首页</a></li>
                  <li><a href="/teachers">师范阵</a></li>
                  <li><a href="#">剑士名牌</a></li>
                </ul>
			  -->

			  <!--
              <li><a href="#">剑道</a>
                <ul class="dropdown">
                  <li><a href="/kendoroom">剑道教室</a></li>
                  <li><a href="/kendoliving">剑道生活</a></li>
                  <li><a href="/photos">明剑相册</a></li>
                </ul>
              </li>
			  -->
              <li """),_display_(/*25.20*/if(activePage=="NEWS")/*25.42*/{_display_(Seq[Any](format.raw/*25.43*/(""" """),format.raw/*25.44*/("""class="active" """)))}),format.raw/*25.60*/("""><a href="/news">新闻与活动</a></li>
                <!--<li><a href="/news">新闻与活动 <span class="label label-info">New</span></a>
                   <ul class="dropdown">
                     <li><a href="/news">新闻</a></li>
                     <li><a href="/events">活动报名</a></li>
                   </ul>
                </li>
                -->
              <li """),_display_(/*33.20*/if(activePage=="ABOUTUS")/*33.45*/{_display_(Seq[Any](format.raw/*33.46*/(""" """),format.raw/*33.47*/("""class="active" """)))}),format.raw/*33.63*/("""><a href="/aboutus">关于我们</a></li>
              <!--
			  <li><a href="#">明剑实验室</a>
			  <li><a href="/shop">会员商店</a></li>
			  -->

              <li><a href="https://www.weibo.com/openkendo" target="_blank">微博</a></li>

              """),_display_(/*41.16*/if(loginUserInfo.nonEmpty)/*41.42*/ {_display_(Seq[Any](format.raw/*41.44*/("""
                """),_display_(/*42.18*/loginednav(loginUserInfo)),format.raw/*42.43*/("""
              """)))}),format.raw/*43.16*/("""

            """),format.raw/*45.13*/("""</ul>
            <ul class="pull-right flip hidden-sm hidden-xs">
              <li>
                <!-- Modal: Book Now Starts -->
                <a class="btn btn-colored btn-flat bg-theme-color-2 text-white font-14 bs-modal-ajax-load mt-0 p-25 pr-15 pl-15" data-toggle="modal" target="_blank" href="""),_display_(/*49.172*/routes/*49.178*/.MkendoController.booking()),format.raw/*49.205*/(""">我要体验</a><!--data-target="#BSParentModal" -->
                <!-- Modal: Book Now End -->
              </li>
            </ul>
            <div id="top-search-bar" class="collapse">
              <div class="container">
                <form role="search" action="#" class="search_form_top" method="get">
                  <input type="text" placeholder="Type text and press Enter..." name="s" class="form-control" autocomplete="off">
                  <span class="search-close"><i class="fa fa-search"></i></span>
                </form>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>"""))
      }
    }
  }

  def render(activePage:String,loginUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(activePage,loginUserInfo)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (activePage,loginUserInfo) => apply(activePage,loginUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Feb 17 18:41:15 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/nav/headernav.scala.html
                  HASH: 7477b13fe0a7ca1f8faec95809dc375d8bf670e8
                  MATRIX: 744->1|881->43|909->45|1263->373|1297->399|1335->400|1363->401|1409->417|2034->1015|2065->1037|2104->1038|2133->1039|2180->1055|2576->1424|2610->1449|2649->1450|2678->1451|2725->1467|2997->1712|3032->1738|3072->1740|3118->1759|3164->1784|3212->1801|3256->1817|3593->2126|3609->2132|3658->2159
                  LINES: 21->1|26->1|27->2|32->7|32->7|32->7|32->7|32->7|50->25|50->25|50->25|50->25|50->25|58->33|58->33|58->33|58->33|58->33|66->41|66->41|66->41|67->42|67->42|68->43|70->45|74->49|74->49|74->49
                  -- GENERATED --
              */
          