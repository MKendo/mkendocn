
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

object dividerfunface extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Divider: Funfact -->
<section class="divider parallax layer-overlay overlay-theme-colored-9" data-bg-img="http://placehold.it/1920x1280" data-parallax-ratio="0.7">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                    <i class="pe-7s-smile mt-5 text-theme-color-2"></i>
                    <h2 data-animation-duration="2000" data-value="5248" class="animate-number text-white mt-0 font-38 font-weight-500">0</h2>
                    <h5 class="text-white text-uppercase mb-0">关注公众号</h5>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                    <i class="pe-7s-note2 mt-5 text-theme-color-2"></i>
                    <h2 data-animation-duration="2000" data-value="675" class="animate-number text-white mt-0 font-38 font-weight-500">0</h2>
                    <h5 class="text-white text-uppercase mb-0">预约免费体验</h5>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                    <i class="pe-7s-users mt-5 text-theme-color-2"></i>
                    <h2 data-animation-duration="2000" data-value="248" class="animate-number text-white mt-0 font-38 font-weight-500">0</h2>
                    <h5 class="text-white text-uppercase mb-0">加馆长微信</h5>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-0">
                <div class="funfact text-center">
                    <i class="pe-7s-cup mt-5 text-theme-color-2"></i>
                    <h2 data-animation-duration="2000" data-value="24" class="animate-number text-white mt-0 font-38 font-weight-500">0</h2>
                    <h5 class="text-white text-uppercase mb-0">报名表</h5>
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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/dividerfunface.scala.html
                  HASH: dd129587978fc9ae1bd90f1383bde0450d675896
                  MATRIX: 828->0
                  LINES: 26->1
                  -- GENERATED --
              */
          