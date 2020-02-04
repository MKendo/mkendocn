
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

object commoncss extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Stylesheet -->
<link href=""""),_display_(/*2.14*/routes/*2.20*/.Assets.versioned("css/bootstrap.min.css")),format.raw/*2.62*/("""" rel="stylesheet" type="text/css">
<link href=""""),_display_(/*3.14*/routes/*3.20*/.Assets.versioned("css/jquery-ui.min.css")),format.raw/*3.62*/("""" rel="stylesheet" type="text/css">
<link href=""""),_display_(/*4.14*/routes/*4.20*/.Assets.versioned("css/animate.css")),format.raw/*4.56*/("""" rel="stylesheet" type="text/css">
<link href=""""),_display_(/*5.14*/routes/*5.20*/.Assets.versioned("css/css-plugin-collections.css")),format.raw/*5.71*/("""" rel="stylesheet"/>"""))
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
                  SOURCE: D:/products/mkendocn/app/views/head/commoncss.scala.html
                  HASH: 2c776530c195464b28ee54e4e581b2f9eb8cd338
                  MATRIX: 820->0|880->34|894->40|956->82|1032->132|1046->138|1108->180|1184->230|1198->236|1254->272|1330->322|1344->328|1415->379
                  LINES: 26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|29->4|29->4|30->5|30->5|30->5
                  -- GENERATED --
              */
          