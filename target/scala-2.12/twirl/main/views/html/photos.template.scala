
package views.html

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

object photos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 相册", loginedUserInfo,false)/*2.44*/{_display_(Seq[Any](format.raw/*2.45*/("""
"""),_display_(/*3.2*/nav/*3.5*/.innerheadernav("剑道","/kendo","相册")),format.raw/*3.40*/(""" """),format.raw/*3.41*/("""<!--TODO ： kendo页面要补上-->
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Works Filter -->
                <div class="portfolio-filter font-alt align-center">
                    <a href="#" class="active" data-filter="*">全部</a>
                    <a href="#select1" class="" data-filter=".select1">日常练习</a>
                    <a href="#select2" class="" data-filter=".select2">比赛视频</a>
                    <a href="#select3" class="" data-filter=".select3">其它</a>
                </div>
                <!-- End Works Filter -->

                <!-- Portfolio Gallery Grid -->
                <div id="grid" class="gallery-isotope grid-3 gutter clearfix">

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select1">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select1">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select2">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select3">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select1">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select3">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select2">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select3">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                    <!-- Portfolio Item Start -->
                    <div class="gallery-item select1">
                        <div class="thumb">
                            <img class="img-fullwidth" src="http://placehold.it/450x250" alt="project">
                            <div class="overlay-shade"></div>
                            <div class="icons-holder">
                                <div class="icons-holder-inner">
                                    <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                        <a data-lightbox="image" href="http://placehold.it/450x250"><i class="fa fa-plus"></i></a>
                                        <a href="#"><i class="fa fa-link"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a class="hover-link" data-lightbox="image" href="http://placehold.it/450x250">View more</a>
                        </div>
                    </div>
                    <!-- Portfolio Item End -->

                </div>
                <!-- End Portfolio Gallery Grid -->
            </div>
        </div>
    </div>
</section>

<!-- end main-content -->

""")))}))
      }
    }
  }

  def render(loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo) => apply(loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:32 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/photos.scala.html
                  HASH: c72b642214039137416c65346483a3c93effe2eb
                  MATRIX: 730->1|849->25|877->28|927->70|965->71|993->74|1003->77|1058->112|1086->113
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|28->3
                  -- GENERATED --
              */
          