
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

object articletagsline extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="tagline p-0 pt-20 mt-5">
    <div class="row">
        <div class="col-md-8">
            <div class="tags">
                <p class="mb-0"><i class="fa fa-tags text-theme-color-2"></i> <span>Tags:</span> Engine, Wheel, Oil, Brake</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="share text-right">
                <p><i class="fa fa-share-alt text-theme-color-2"></i> Share</p>
            </div>
        </div>
    </div>
</div>"""))
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/articletagsline.scala.html
                  HASH: a2438c131e68a307faf10ed218d83ba267cb5b31
                  MATRIX: 829->0
                  LINES: 26->1
                  -- GENERATED --
              */
          