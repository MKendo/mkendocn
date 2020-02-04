
package views.html.js

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

object revolutionslider5js extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Revolution Slider 5.x SCRIPTS -->
<script src=""""),_display_(/*2.15*/routes/*2.21*/.Assets.versioned("js/revolution-slider/js/jquery.themepunch.tools.min.js")),format.raw/*2.96*/(""""></script>
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.versioned("js/revolution-slider/js/jquery.themepunch.revolution.min.js")),format.raw/*3.101*/(""""></script>

"""))
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
                  SOURCE: D:/products/mkendocn/app/views/js/revolutionslider5js.scala.html
                  HASH: 149ebc69482829f0b68c7d9005ffe783d5de192e
                  MATRIX: 828->0|908->54|922->60|1017->135|1070->162|1084->168|1185->248
                  LINES: 26->1|27->2|27->2|27->2|28->3|28->3|28->3
                  -- GENERATED --
              */
          