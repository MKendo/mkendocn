
package views.html.nav

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

object innerheadernav extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(prepageTitle: String, prepageLink: String, currentTitle: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*2.1*/("""<!-- Section: inner-header -->
<section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="http://placehold.it/1920x1280">
    <div class="container pt-70 pb-20">
        <!-- Section Content -->
        <div class="section-content">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="title text-white">"""),_display_(/*9.51*/currentTitle),format.raw/*9.63*/("""</h2>
                    <ol class="breadcrumb text-left text-black mt-10">
                        <li><a href=""""),_display_(/*11.39*/prepageLink),format.raw/*11.50*/("""">"""),_display_(/*11.53*/prepageTitle),format.raw/*11.65*/("""</a></li>
                        <li class="active text-gray-silver">"""),_display_(/*12.62*/currentTitle),format.raw/*12.74*/("""</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>"""))
      }
    }
  }

  def render(prepageTitle:String,prepageLink:String,currentTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(prepageTitle,prepageLink,currentTitle)

  def f:((String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (prepageTitle,prepageLink,currentTitle) => apply(prepageTitle,prepageLink,currentTitle)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/nav/innerheadernav.scala.html
                  HASH: b4cc97deb9f44d21010ca938f4e56d93ea3d156e
                  MATRIX: 756->1|916->66|944->68|1360->458|1392->470|1536->587|1568->598|1598->601|1631->613|1730->685|1763->697
                  LINES: 21->1|26->1|27->2|34->9|34->9|36->11|36->11|36->11|36->11|37->12|37->12
                  -- GENERATED --
              */
          