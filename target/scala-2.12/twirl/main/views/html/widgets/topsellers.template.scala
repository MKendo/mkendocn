
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

object topsellers extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="widget">
    <h5 class="widget-title line-bottom">Top Sellers</h5>
    <div class="top-sellers">
        <article class="post media-post clearfix pb-0 mb-10">
            <a class="post-thumb" href="#"><img src="http://placehold.it/85x85" alt=""></a>
            <div class="post-right">
                <h5 class="post-title font-weight-600 mt-0 mb-0"><a href="#">Brake Disk</a></h5>
                <div class="product-detail">
                    <div class="price mb-10"><ins><span class="amount">$480.00</span></ins></div>
                    <div title="Rated 3.50 out of 5" class="star-rating ml-0"><span style="width: 60%;">3.50</span></div>
                </div>
            </div>
        </article>
        <article class="post media-post clearfix pb-0 mb-10">
            <a class="post-thumb" href="#"><img src="http://placehold.it/85x85" alt=""></a>
            <div class="post-right">
                <h5 class="post-title font-weight-600 mt-0 mb-0"><a href="#">Brake Disk</a></h5>
                <div class="product-detail">
                    <div class="price mb-10"><ins><span class="amount">$480.00</span></ins></div>
                    <div title="Rated 3.50 out of 5" class="star-rating ml-0"><span style="width: 60%;">3.50</span></div>
                </div>
            </div>
        </article>
        <article class="post media-post clearfix pb-0 mb-10">
            <a class="post-thumb" href="#"><img src="http://placehold.it/85x85" alt=""></a>
            <div class="post-right">
                <h5 class="post-title font-weight-600 mt-0 mb-0"><a href="#">Brake Disk</a></h5>
                <div class="product-detail">
                    <div class="price mb-10"><ins><span class="amount">$480.00</span></ins></div>
                    <div title="Rated 3.50 out of 5" class="star-rating ml-0"><span style="width: 60%;">3.50</span></div>
                </div>
            </div>
        </article>
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
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/topsellers.scala.html
                  HASH: a0465c17918972557bca401c3d7def311c4bc94b
                  MATRIX: 824->0
                  LINES: 26->1
                  -- GENERATED --
              */
          