
package views.html.widgets

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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-xs-12 col-sm-6 col-md-3 pb-sm-20 ">
    <h2 class="line-bottom font-20 text-theme-colored text-uppercase mb-10 mt-0">欢迎来到<span class="text-theme-color-2"> 明剑馆</span></h2>
    <p class="lead font-18">新手指南，跟我来</p>
    <p>由于剑道在中国仍然属于小众运动，一开始接触剑道的同学们基本上都是零基础，所以不用担心，我们为您特别设计了各种体验课程。</p>
	<p>一起来试试吧，欢迎你。--> </p>
    <!--<a class="btn btn-colored btn-theme-colored btn-sm" href="#">View Details</a>-->
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/welcome.scala.html
                  HASH: 5f8c5f2a683f06f43a2e164017003f3be419a5c3
                  MATRIX: 821->0
                  LINES: 26->1
                  -- GENERATED --
              */
          