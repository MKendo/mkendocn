
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

object revolutionslider5css extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Revolution Slider 5.x CSS settings -->
<link href=""""),_display_(/*2.14*/routes/*2.20*/.Assets.versioned("css/settings.css")),format.raw/*2.57*/("""" rel="stylesheet" type="text/css">
<link href=""""),_display_(/*3.14*/routes/*3.20*/.Assets.versioned("css/layers.css")),format.raw/*3.55*/("""" rel="stylesheet" type="text/css">
<link href=""""),_display_(/*4.14*/routes/*4.20*/.Assets.versioned("css/navigation.css")),format.raw/*4.59*/("""" rel="stylesheet" type="text/css">"""))
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
                  SOURCE: D:/products/mkendocn/app/views/head/revolutionslider5css.scala.html
                  HASH: 3b626acc5a47b5a5f9fef697771ca4a033f70570
                  MATRIX: 831->0|915->58|929->64|986->101|1062->151|1076->157|1131->192|1207->242|1221->248|1280->287
                  LINES: 26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|29->4|29->4
                  -- GENERATED --
              */
          