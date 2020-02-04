
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

object teamwithoutdetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: Team -->
<section id="team">
    <div class="container">
        <div class="row mtli-row-clearfix">
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-30 mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> David Zakaria</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-30 mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Sakib Smith</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-30 mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Ismail Jhon</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-30 mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Andre Smith</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> David Zakaria</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Sakib Smith</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Ismail Jhon</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 sm-text-center mb-sm-30">
                <div class="team-members maxwidth400">
                    <div class="team-thumb">
                        <img class="img-fullwidth" alt="" src="http://placehold.it/260x230">
                    </div>
                    <div class="team-bottom-part border-bottom-theme-color-2-2px bg-lighter border-1px text-center p-10 pt-20 pb-10">
                        <h4 class="text-uppercase font-raleway font-weight-600 m-0"><a class="text-theme-color-2" href="page-teachers-details.html"> Andre Smith</a></h4>
                        <h5 class="text-theme-color">Teacher - MBA</h5>
                        <ul class="styled-icons icon-sm icon-dark icon-theme-colored">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        </ul>
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/teamwithoutdetail.scala.html
                  HASH: cc9938da3b00fc7126aa421a3b95bd3f890f659c
                  MATRIX: 831->0
                  LINES: 26->1
                  -- GENERATED --
              */
          