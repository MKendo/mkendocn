
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

object calltoaction extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.5*/("""<!-- Divider: Call To Action -->
    <section class="bg-theme-color-2">
      <div class="container pt-0 pb-15">
        <div class="row">
          <div class="call-to-action pt-20 pb-15">
            <div class="col-xs-12 col-sm-6 col-md-4 mb-sm-30">
              <i class="fa fa-certificate text-white font-36 pull-left flip mt-15 mr-20"></i>
              <h4 class="text-white font-16 font-weight-600">国际剑道联盟认可的专业剑道馆</h4>
              <h6 class="text-white">剑道级段位证书全球通用；您的信任是我们的成就。</h6>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4 mb-sm-30">
              <i class="fa fa-map-marker text-white font-36 pull-left flip mt-15 mr-20"></i>
              <h4 class="text-white font-16 font-weight-600">总馆地址：深圳市福田保税区</h4>
              <h6 class="text-white">深圳市福田保税区红棉道4号3楼明剑馆</h6>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
              <i class="fa fa-phone text-white font-36 pull-left flip mt-15 mr-20"></i>
              <h4 class="font-16 text-white font-weight-600">咨询电话 : +15889489370</h4>
              <h6 class="text-white">欢迎关注微信公众号 ：Openkendo</h6>
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/calltoaction.scala.html
                  HASH: 9bbbf1a1c1f3fb310a8c8d21952df15451d4f1d4
                  MATRIX: 826->4
                  LINES: 26->1
                  -- GENERATED --
              */
          