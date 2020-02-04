
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

object aboutimportant extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: About -->
<section class="">
    <div class="container">
        <div class="section-content">
            <div class="row">
                <div class="col-md-6">
                    <h6 class="letter-space-4 text-gray-darkgray text-uppercase mt-0 mb-0">从这里开始了解我们</h6>
                    <h2 class="text-uppercase font-weight-600 mt-0 font-28 line-bottom">什么是剑道？</h2>
                    <h4 class="text-theme-colored">经常会被问到什么是剑道，剑道有什么用，剑道馆存在有什么价值和意义？摘录世界剑道冠军荣花直辉先生采访录供大家参考吧：</h4>
                    <p>在剑道的训练中，会得到全面而系统的心技体的提高，不仅仅技术和身体，还有精神集中的禅的修习，焦点不仅仅是局限于赢得胜利，更重要的是你能在比赛中学习到，你应该怎样克服自己的缺点。当然你要打败对手，但最重要的一点，是打败自己，超越自我。这意味着在刻苦锻炼的枯燥时刻，艰难和痛苦面前，你不会逃避，不会在重大困难面前低头，直面人生，挑战人生……</p>
                    <a class="btn btn-theme-colored btn-flat btn-lg mt-10 mb-sm-30" href="/aboutus">继续了解明剑馆 →</a>
                </div>
                <div class="col-md-6">
                    <div class="video-popup">
                        <a href=""""),_display_(/*15.35*/routes/*15.41*/.Assets.versioned("video/mkendoad.mp4")),format.raw/*15.80*/("""" data-lightbox-gallery="youtube-video" title="Video">
                            <img alt="" src=""""),_display_(/*16.47*/routes/*16.53*/.Assets.versioned("images/aboutimport555.jpg")),format.raw/*16.99*/("""" class="img-responsive img-fullwidth">
                        </a>
                    </div>
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/aboutimportant.scala.html
                  HASH: d20cdb80130c382774994199eb1b937ee1b2eef9
                  MATRIX: 828->0|1818->963|1833->969|1893->1008|2022->1110|2037->1116|2104->1162
                  LINES: 26->1|40->15|40->15|40->15|41->16|41->16|41->16
                  -- GENERATED --
              */
          