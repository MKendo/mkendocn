
package views.html.head

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

object menuskins extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- CSS | menuzord megamenu skins -->
<link id="menuzord-menu-skins" href=""""),_display_(/*2.39*/routes/*2.45*/.Assets.versioned("css/menuzord-skins/menuzord-rounded-boxed.css")),format.raw/*2.111*/("""" rel="stylesheet"/>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:13 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/head/menuskins.scala.html
                  HASH: c373ac91724359de850912e95bd921f9f106e284
                  MATRIX: 820->0|924->78|938->84|1025->150
                  LINES: 26->1|27->2|27->2|27->2
                  -- GENERATED --
              */
          