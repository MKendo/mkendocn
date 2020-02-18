
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

object loginednav extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*2.1*/("""<li><a href="#">网站管理</a>
    <ul class="dropdown">
        <li><a href="/postnews">发布新闻</a></li>
        """),_display_(/*5.10*/if(loginedUserInfo.startsWith("13128855200"))/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""
          """),format.raw/*6.11*/("""<li><a href="/memberlist/ALL">会员管理</a></li>
        """)))}),format.raw/*7.10*/("""
        """),format.raw/*8.9*/("""<li><a href="/bookinglist/ALL">预约管理</a></li>
        <li><a href="/memberlist/ALL">退出</a></li>
    </ul>
</li>"""))
      }
    }
  }

  def render(loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo) => apply(loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Feb 17 18:42:00 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/nav/loginednav.scala.html
                  HASH: 057c4728bb17b8845cc5903d03de75e0d502677c
                  MATRIX: 738->1|857->25|885->27|1020->136|1073->181|1112->183|1151->195|1235->249|1271->259
                  LINES: 21->1|26->1|27->2|30->5|30->5|30->5|31->6|32->7|33->8
                  -- GENERATED --
              */
          