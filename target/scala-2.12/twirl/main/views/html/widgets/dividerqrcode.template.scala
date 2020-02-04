
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

object dividerqrcode extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Divider: QR Code -->
<section class="divider parallax layer-overlay overlay-theme-colored-9" data-parallax-ratio="0.7">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                  <img alt="" src=""""),_display_(/*7.37*/routes/*7.43*/.Assets.versioned("images/qrcode/mkendo120.jpg")),format.raw/*7.91*/("""">
                  <h4 class="text-white text-uppercase mb-0">1 关注公众号</h4>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                    <img alt="" src=""""),_display_(/*13.39*/routes/*13.45*/.Assets.versioned("images/qrcode/freeexperience120.png")),format.raw/*13.101*/("""">
                    <h4 class="text-white text-uppercase mb-0">2 预约免费体验</h4>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                <div class="funfact text-center">
                    <img alt="" src=""""),_display_(/*19.39*/routes/*19.45*/.Assets.versioned("images/qrcode/wechat120.jpg")),format.raw/*19.93*/("""">
                    <h4 class="text-white text-uppercase mb-0">3 加馆长微信</h4>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-0">
                <div class="funfact text-center">
                    <img alt="" src=""""),_display_(/*25.39*/routes/*25.45*/.Assets.versioned("images/qrcode/membership120.png")),format.raw/*25.97*/("""">
                    <h4 class="text-white text-uppercase mb-0">4 报名表</h4>
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
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/dividerqrcode.scala.html
                  HASH: 8437de89d8cc68238ca7f1af7899c841a2a81388
                  MATRIX: 827->0|1187->334|1201->340|1269->388|1572->664|1587->670|1665->726|1971->1005|1986->1011|2055->1059|2359->1336|2374->1342|2447->1394
                  LINES: 26->1|32->7|32->7|32->7|38->13|38->13|38->13|44->19|44->19|44->19|50->25|50->25|50->25
                  -- GENERATED --
              */
          