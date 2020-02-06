
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

object custombootstrapmarginpaddingcss extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- CSS | Custom Margin Padding Collection -->
<link href=""""),_display_(/*2.14*/routes/*2.20*/.Assets.versioned("css/custom-bootstrap-margin-padding.css")),format.raw/*2.80*/("""" rel="stylesheet" type="text/css">"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:31 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/head/custombootstrapmarginpaddingcss.scala.html
                  HASH: f348cbb9671b802e6a4ec26c2c72f3adf535486c
                  MATRIX: 842->0|930->62|944->68|1024->128
                  LINES: 26->1|27->2|27->2|27->2
                  -- GENERATED --
              */
          