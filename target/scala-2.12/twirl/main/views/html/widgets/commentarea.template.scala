
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

object commentarea extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="comments-area">
    <h5 class="comments-title">Comments</h5>
    <ul class="comment-list">
        <li>
            <div class="media comment-author"> <a class="media-left pull-left flip" href="#"><img class="img-thumbnail" src="http://placehold.it/75x75" alt=""></a>
                <div class="media-body">
                    <h5 class="media-heading comment-heading">John Doe says:</h5>
                    <div class="comment-date">23/06/2014</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna et sed aliqua. Ut enim ea commodo consequat...</p>
                    <a class="replay-icon pull-right text-theme-colored" href="#"> <i class="fa fa-reply text-theme-colored"></i> Replay</a> </div>
            </div>
        </li>
        <li>
            <div class="media comment-author"> <a class="media-left pull-left flip" href="#"><img class="img-thumbnail" src="http://placehold.it/75x75" alt=""></a>
                <div class="media-body">
                    <h5 class="media-heading comment-heading">John Doe says:</h5>
                    <div class="comment-date">23/06/2014</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna et sed aliqua. Ut enim ea commodo consequat...</p>
                    <a class="replay-icon pull-right text-theme-colored" href="#"> <i class="fa fa-reply text-theme-colored"></i> Replay</a>
                    <div class="clearfix"></div>
                    <div class="media comment-author nested-comment"> <a href="#" class="media-left pull-left flip pt-20"><img alt="" src="http://placehold.it/75x75" class="img-thumbnail"></a>
                        <div class="media-body p-20 bg-lighter">
                            <h5 class="media-heading comment-heading">John Doe says:</h5>
                            <div class="comment-date">23/06/2014</div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna et sed aliqua. Ut enim ea commodo consequat...</p>
                            <a class="replay-icon pull-right text-theme-colored" href="#"> <i class="fa fa-reply text-theme-colored"></i> Replay</a>
                        </div>
                    </div>
                    <div class="media comment-author nested-comment"> <a href="#" class="media-left pull-left flip pt-20"><img alt="" src="http://placehold.it/75x75" class="img-thumbnail"></a>
                        <div class="media-body p-20 bg-lighter">
                            <h5 class="media-heading comment-heading">John Doe says:</h5>
                            <div class="comment-date">23/06/2014</div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna et sed aliqua. Ut enim ea commodo consequat...</p>
                            <a class="replay-icon pull-right text-theme-colored" href="#"> <i class="fa fa-reply text-theme-colored"></i> Replay</a>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <div class="media comment-author"> <a class="media-left pull-left flip" href="#"><img class="img-thumbnail" src="http://placehold.it/75x75" alt=""></a>
                <div class="media-body">
                    <h5 class="media-heading comment-heading">John Doe says:</h5>
                    <div class="comment-date">23/06/2014</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna et sed aliqua. Ut enim ea commodo consequat...</p>
                    <a class="replay-icon pull-right text-theme-colored" href="#"> <i class="fa fa-reply text-theme-colored"></i> Replay</a> </div>
            </div>
        </li>
    </ul>
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/commentarea.scala.html
                  HASH: 0920cf35f80cfd148c3028cc112605a45de012e4
                  MATRIX: 825->0
                  LINES: 26->1
                  -- GENERATED --
              */
          