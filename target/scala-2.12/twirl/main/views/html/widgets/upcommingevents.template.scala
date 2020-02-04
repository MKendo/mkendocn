
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

object upcommingevents extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-6">
    <h3 class="text-uppercase line-bottom mt-0 line-height-1"><i class="fa fa-calendar mr-10"></i>近期的<span class="text-theme-color-2">活动报名</span></h3>
    <article class="post media-post clearfix pb-0 mb-10">
        <a href="#" class="post-thumb mr-20"><img alt="" src="http://placehold.it/120x120"></a>
        <div class="post-right">
            <h4 class="mt-0 mb-5"><a href="#">剑道夏令营开始预报名了</a></h4>
            <ul class="list-inline font-12 mb-5">
                <li class="pr-0"><i class="fa fa-calendar mr-5"></i> 2019年7月1日 |</li>
                <li class="pl-5"><i class="fa fa-map-marker mr-5"></i>福保道场</li>
            </ul>
            <p class="mb-0 font-13">期待已久的暑期剑道夏令营开始预报名了！</p>
            <a class="text-theme-colored font-13" href="#">点击立即报名 →</a>
        </div>
    </article>
    <article class="post media-post clearfix pb-0 mb-10">
        <a href="#" class="post-thumb mr-20"><img alt="" src="http://placehold.it/120x120"></a>
        <div class="post-right">
            <h4 class="mt-0 mb-5"><a href="#">明剑馆2019年5月考级报名</a></h4>
            <ul class="list-inline font-12 mb-5">
                <li class="pr-0"><i class="fa fa-calendar mr-5"></i> 2019年5月31日 |</li>
                <li class="pl-5"><i class="fa fa-map-marker mr-5"></i>福保道场</li>
            </ul>
            <p class="mb-0 font-13">考级了考级了，坚持考级，剑道精进！</p>
            <a class="text-theme-colored font-13" href="#">点击立即报名 →</a>
        </div>
    </article>
    <article class="post media-post clearfix pb-0 mb-10">
        <a href="#" class="post-thumb mr-20"><img alt="" src="http://placehold.it/120x120"></a>
        <div class="post-right">
            <h4 class="mt-0 mb-5"><a href="#">2019三星杯开始报名了</a></h4>
            <ul class="list-inline font-12 mb-5">
                <li class="pr-0"><i class="fa fa-calendar mr-5"></i> 2019年3月10日 |</li>
                <li class="pl-5"><i class="fa fa-map-marker mr-5"></i>香港公园体育馆</li>
            </ul>
            <p class="mb-0 font-13">三星杯比赛全部个人赛，大家积极参加，小朋友们也可以报名哟。</p>
            <a class="text-theme-colored font-13" href="#">点击立即报名 →</a>
        </div>
    </article>
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
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/upcommingevents.scala.html
                  HASH: 5359911eab9b20d97c7d4c3d6091e30d99f29337
                  MATRIX: 829->0
                  LINES: 26->1
                  -- GENERATED --
              */
          