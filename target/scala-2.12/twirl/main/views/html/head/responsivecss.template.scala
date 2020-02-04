
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

object responsivecss extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- CSS | Responsive media queries -->
<link href=""""),_display_(/*2.14*/routes/*2.20*/.Assets.versioned("css/responsive.css")),format.raw/*2.59*/("""" rel="stylesheet" type="text/css">
<!-- CSS | Style css. This is the file where you can place your own custom css code. Just uncomment it and use it. -->
<!-- <link href=""""),_display_(/*4.19*/routes/*4.25*/.Assets.versioned("css/style.css")),format.raw/*4.59*/("""" rel="stylesheet" type="text/css"> -->
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
                  SOURCE: D:/products/mkendocn/app/views/head/responsivecss.scala.html
                  HASH: 8d4e6e50778787e73b4aa90bfe48634579a118a9
                  MATRIX: 824->0|904->54|918->60|977->99|1178->274|1192->280|1246->314
                  LINES: 26->1|27->2|27->2|27->2|29->4|29->4|29->4
                  -- GENERATED --
              */
          