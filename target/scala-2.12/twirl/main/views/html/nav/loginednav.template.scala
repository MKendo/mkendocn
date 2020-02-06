
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

object loginednav extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""
"""),format.raw/*2.1*/("""<li><a href="#">网站管理</a>
    <ul class="dropdown">
        <li><a href="/postnews">发布新闻</a></li>
        <li><a href="#">会员管理</a></li>
        <li><a href="/bookinglist/ALL">预约管理</a></li>
        <li><a href="/logout">退出</a></li>
    </ul>
</li>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Feb 06 19:04:42 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/nav/loginednav.scala.html
                  HASH: 48695090afb39a5e9fad6e262df4c0e294ca2195
                  MATRIX: 731->1|827->3|855->5
                  LINES: 21->1|26->1|27->2
                  -- GENERATED --
              */
          