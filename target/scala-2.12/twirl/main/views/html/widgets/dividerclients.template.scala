
package views.html.widgets

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

object dividerclients extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Divider: Clients -->
<section class="clients bg-theme-color-2">
    <div class="container pt-10 pb-0">
        <div class="row">
            <div class="col-md-12">
                <!-- Section: Clients -->
                <div class="owl-carousel-6col clients-logo transparent text-center owl-nav-top">
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                    <div class="item"> <a href="#"><img src="http://placehold.it/200x120" alt=""></a></div>
                </div>
            </div>
        </div>
    </div>
</section>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:33 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/dividerclients.scala.html
                  HASH: 090230d4eb27042002a4e41809000c7f56a6ab1f
                  MATRIX: 828->0
                  LINES: 26->1
                  -- GENERATED --
              */
          