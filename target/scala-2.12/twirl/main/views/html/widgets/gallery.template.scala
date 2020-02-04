
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

object gallery extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: Gallery -->
<section id="gallery" class="bg-lighter">
    <div class="container">
        <div class="section-title mb-10">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="mt-0 text-uppercase text-theme-colored title line-bottom line-height-1">Our<span class="text-theme-color-2 font-weight-400"> Gllery</span></h2>
                </div>
            </div>
        </div>
        <div class="section-content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Works Filter -->
                    <div class="portfolio-filter font-alt align-center">
                        <a href="#" class="active" data-filter="*">All</a>
                        <a href="#select1" class="" data-filter=".select1">Photos</a>
                        <a href="#select2" class="" data-filter=".select2">Campus</a>
                        <a href="#select3" class="" data-filter=".select3">Students</a>
                    </div>
                    <!-- End Works Filter -->

                    <!-- Portfolio Gallery Grid -->
                    <div id="grid" class="gallery-isotope grid-4 gutter clearfix">

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select1">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/1.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/1.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select1">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/2.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/2.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select2">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/3.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/3.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select3">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/4.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/4.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select1">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/5.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/5.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select3">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/6.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/6.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select2">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/7.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/7.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select3">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/8.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/8.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select1">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/9.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/9.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select2">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/10.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/10.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select1">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/11.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/11.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                        <!-- Portfolio Item Start -->
                        <div class="gallery-item select3">
                            <div class="thumb">
                                <img class="img-fullwidth" src="http://placehold.it/280x160" alt="project">
                                <div class="overlay-shade"></div>
                                <div class="icons-holder">
                                    <div class="icons-holder-inner">
                                        <div class="styled-icons icon-sm icon-dark icon-circled icon-theme-colored">
                                            <a data-lightbox="image" href="images/gallery/12.jpg"><i class="fa fa-plus"></i></a>
                                            <a href="#"><i class="fa fa-link"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <a class="hover-link" data-lightbox="image" href="images/gallery/12.jpg">View more</a>
                            </div>
                        </div>
                        <!-- Portfolio Item End -->

                    </div>
                    <!-- End Portfolio Gallery Grid -->
                </div>
            </div>
        </div>
    </div >
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/gallery.scala.html
                  HASH: a0eb3ea00bf27bfe126dd4ccea1a03a898382e95
                  MATRIX: 821->0
                  LINES: 26->1
                  -- GENERATED --
              */
          