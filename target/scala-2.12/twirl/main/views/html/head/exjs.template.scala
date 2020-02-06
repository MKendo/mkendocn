
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

object exjs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!-- external javascripts-->
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.versioned("js/jquery-2.2.4.min.js")),format.raw/*3.64*/(""""></script>
<!--<script src=""""),_display_(/*4.19*/routes/*4.25*/.Assets.versioned("js/summernote/jquery-3.4.1.min.js")),format.raw/*4.79*/(""""></script>-->
<script src=""""),_display_(/*5.15*/routes/*5.21*/.Assets.versioned("js/jquery-ui.min.js")),format.raw/*5.61*/(""""></script>
<script src=""""),_display_(/*6.15*/routes/*6.21*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*6.61*/(""""></script>
<!-- JS | jquery plugin collection for this theme -->
<script src=""""),_display_(/*8.15*/routes/*8.21*/.Assets.versioned("js/jquery-plugin-collection.js")),format.raw/*8.72*/(""""></script>

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
                  DATE: Wed Feb 05 19:16:31 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/head/exjs.scala.html
                  HASH: cf846c70ea7597152cbf84b530e2c0a1bdeb2bdd
                  MATRIX: 815->2|885->46|899->52|962->95|1019->126|1033->132|1107->186|1163->216|1177->222|1237->262|1290->289|1304->295|1364->335|1472->417|1486->423|1557->474
                  LINES: 26->2|27->3|27->3|27->3|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|32->8|32->8|32->8
                  -- GENERATED --
              */
          