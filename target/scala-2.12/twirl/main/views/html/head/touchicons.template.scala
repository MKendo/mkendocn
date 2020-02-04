
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

object touchicons extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<link rel="shortcut icon" type="image/png" href=""""),_display_(/*1.51*/routes/*1.57*/.Assets.versioned("images/favicon.png")),format.raw/*1.96*/(""""/>
<!-- Favicon and Touch Icons -->
<link href=""""),_display_(/*3.14*/routes/*3.20*/.Assets.versioned("images/favicon.png")),format.raw/*3.59*/("""" rel="shortcut icon" type="image/png">
<link href=""""),_display_(/*4.14*/routes/*4.20*/.Assets.versioned("images/apple-touch-icon.png")),format.raw/*4.68*/("""" rel="apple-touch-icon">
<link href=""""),_display_(/*5.14*/routes/*5.20*/.Assets.versioned("images/apple-touch-icon-72x72.png")),format.raw/*5.74*/("""" rel="apple-touch-icon" sizes="72x72">
<link href=""""),_display_(/*6.14*/routes/*6.20*/.Assets.versioned("images/apple-touch-icon-114x114.png")),format.raw/*6.76*/("""" rel="apple-touch-icon" sizes="114x114">
<link href=""""),_display_(/*7.14*/routes/*7.20*/.Assets.versioned("images/apple-touch-icon-144x144.png")),format.raw/*7.76*/("""" rel="apple-touch-icon" sizes="144x144">
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
                  SOURCE: D:/products/mkendocn/app/views/head/touchicons.scala.html
                  HASH: a352552b8cafe86e27a719ff0eda5b6489d41c23
                  MATRIX: 821->0|897->50|911->56|970->95|1048->147|1062->153|1121->192|1201->246|1215->252|1283->300|1349->340|1363->346|1437->400|1517->454|1531->460|1607->516|1689->572|1703->578|1779->634
                  LINES: 26->1|26->1|26->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|30->5|30->5|30->5|31->6|31->6|31->6|32->7|32->7|32->7
                  -- GENERATED --
              */
          