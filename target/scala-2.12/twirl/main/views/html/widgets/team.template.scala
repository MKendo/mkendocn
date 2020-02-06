
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

object team extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: team -->
<section>
    <div class="container">
        <div class="section-title mb-10">
            <div class="row">
                <div class="col-md-8">
                    <h2 class="mt-0 text-uppercase font-28 line-bottom line-height-1">Our <span class="text-theme-color-2 font-weight-400">Teachers</span></h2>
                </div>
            </div>
        </div>
        <div class="section-content">
            <div class="row multi-row-clearfix">
                <div class="col-sm-6 col-md-3 sm-text-center mb-sm-30">
                    <div class="team maxwidth400">
                        <div class="thumb"><img class="img-fullwidth" src="http://placehold.it/262x300" alt=""></div>
                        <div class="content border-1px border-bottom-theme-color-2-2px p-15 bg-light clearfix">
                            <h4 class="name text-theme-color-2 mt-0">Andre Smith - <small>Teacher</small></h4>
                            <p class="mb-20">Lorem ipsum dolor sit amet, con amit sectetur adipisicing elit.</p>
                            <ul class="styled-icons icon-dark icon-circled icon-theme-colored icon-sm pull-left flip">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                            <a class="btn btn-theme-colored btn-sm pull-right flip" href="page-teachers-details.html">view details</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 sm-text-center mb-sm-30">
                    <div class="team maxwidth400">
                        <div class="thumb"><img class="img-fullwidth" src="http://placehold.it/262x300" alt=""></div>
                        <div class="content border-1px border-bottom-theme-color-2-2px p-15 bg-light clearfix">
                            <h4 class="name mt-0 text-theme-color-2">Sakib Smith - <small>Teacher</small></h4>
                            <p class="mb-20">Lorem ipsum dolor sit amet, con amit sectetur adipisicing elit.</p>
                            <ul class="styled-icons icon-dark icon-circled icon-theme-colored icon-sm pull-left flip">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                            <a class="btn btn-theme-colored btn-sm pull-right flip" href="page-teachers-details.html">view details</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 sm-text-center mb-sm-30">
                    <div class="team maxwidth400">
                        <div class="thumb"><img class="img-fullwidth" src="http://placehold.it/262x300" alt=""></div>
                        <div class="content border-1px border-bottom-theme-color-2-2px p-15 bg-light clearfix">
                            <h4 class="name mt-0 text-theme-color-2">David Zakaria - <small>Teacher</small></h4>
                            <p class="mb-20">Lorem ipsum dolor sit amet, con amit sectetur adipisicing elit.</p>
                            <ul class="styled-icons icon-dark icon-circled icon-theme-colored icon-sm pull-left flip">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                            <a class="btn btn-theme-colored btn-sm pull-right flip" href="page-teachers-details.html">view details</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 sm-text-center">
                    <div class="team maxwidth400">
                        <div class="thumb"><img class="img-fullwidth" src="http://placehold.it/262x300" alt=""></div>
                        <div class="content border-1px border-bottom-theme-color-2-2px p-15 bg-light clearfix">
                            <h4 class="name mt-0 text-theme-color-2">Ismail Jon - <small>Teacher</small></h4>
                            <p class="mb-20">Lorem ipsum dolor sit amet, con amit sectetur adipisicing elit.</p>
                            <ul class="styled-icons icon-dark icon-circled icon-theme-colored icon-sm pull-left flip">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                            <a class="btn btn-theme-colored btn-sm pull-right flip" href="page-teachers-details.html">view details</a>
                        </div>
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
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/team.scala.html
                  HASH: efb16be0c1a99af602636f9b5fed79ee3c5f55ee
                  MATRIX: 818->0
                  LINES: 26->1
                  -- GENERATED --
              */
          