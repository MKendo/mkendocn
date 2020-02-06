
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

object summernotecssjs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!--富文本编辑器-->
<!--<link href=""""),_display_(/*2.18*/routes/*2.24*/.Assets.versioned("js/summernote/bootstrap.min.css")),format.raw/*2.76*/("""" rel="stylesheet">
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.versioned("js/summernote/jquery-3.4.1.min.js")),format.raw/*3.75*/(""""></script>
<script src=""""),_display_(/*4.15*/routes/*4.21*/.Assets.versioned("js/jquery-2.2.4.min.js")),format.raw/*4.64*/(""""></script>
<script src=""""),_display_(/*5.15*/routes/*5.21*/.Assets.versioned("js/summernote/bootstrap.min.js")),format.raw/*5.72*/(""""></script>-->
<link href=""""),_display_(/*6.14*/routes/*6.20*/.Assets.versioned("js/summernote/summernote.min.css")),format.raw/*6.73*/("""" rel="stylesheet">
<script src=""""),_display_(/*7.15*/routes/*7.21*/.Assets.versioned("js/summernote/summernote.min.js")),format.raw/*7.73*/(""""></script>
<script src=""""),_display_(/*8.15*/routes/*8.21*/.Assets.versioned("js/summernote/lang/summernote-zh-CN.js")),format.raw/*8.80*/(""""></script>"""))
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
                  SOURCE: D:/products/mkendocn/app/views/head/summernotecssjs.scala.html
                  HASH: da974f1ae3385ae112ca7819aadbc158f6b7ef79
                  MATRIX: 826->0|884->32|898->38|970->90|1031->125|1045->131|1119->185|1172->212|1186->218|1249->261|1302->288|1316->294|1387->345|1442->374|1456->380|1529->433|1590->468|1604->474|1676->526|1729->553|1743->559|1822->618
                  LINES: 26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|29->4|29->4|30->5|30->5|30->5|31->6|31->6|31->6|32->7|32->7|32->7|33->8|33->8|33->8
                  -- GENERATED --
              */
          