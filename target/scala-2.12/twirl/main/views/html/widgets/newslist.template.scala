
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

object newslist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: blog -->
<section id="blog" class="bg-lighter">
    <div class="container">
        <div class="section-title mb-10">
            <div class="row">
                <div class="col-md-8">
                    <h2 class="mt-0 text-uppercase font-28 line-bottom line-height-1">Latest <span class="text-theme-color-2 font-weight-400">News</span></h2>
                </div>
            </div>
        </div>
        <div class="section-content">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-4 wow fadeInLeft" data-wow-duration="1s" data-wow-delay="0.3s">
                    <article class="post clearfix mb-sm-30">
                        <div class="entry-header">
                            <div class="post-thumb thumb">
                                <img src="http://placehold.it/330x225" alt="" class="img-responsive img-fullwidth">
                            </div>
                        </div>
                        <div class="entry-content p-20 pr-10 bg-white">
                            <div class="entry-meta media mt-0 no-bg no-border">
                                <div class="entry-date media-left text-center flip bg-theme-colored pt-5 pr-15 pb-5 pl-15">
                                    <ul>
                                        <li class="font-16 text-white font-weight-600 border-bottom">28</li>
                                        <li class="font-12 text-white text-uppercase">Feb</li>
                                    </ul>
                                </div>
                                <div class="media-body pl-15">
                                    <div class="event-content pull-left flip">
                                        <h4 class="entry-title text-white text-uppercase m-0 mt-5"><a href="#">Post title here</a></h4>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-commenting-o mr-5 text-theme-colored"></i> 214 Comments</span>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-heart-o mr-5 text-theme-colored"></i> 895 Likes</span>
                                    </div>
                                </div>
                            </div>
                            <p class="mt-10">Lorem ipsum dolor sit amet, consectetur adipisi cing elit. Molestias eius illum libero dolor nobis deleniti, sint assumenda Pariatur iste.</p>
                            <a href="#" class="btn-read-more">Read more</a>
                            <div class="clearfix"></div>
                        </div>
                    </article>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4 wow fadeInLeft" data-wow-duration="1s" data-wow-delay="0.4s">
                    <article class="post clearfix mb-sm-30">
                        <div class="entry-header">
                            <div class="post-thumb thumb">
                                <img src="http://placehold.it/330x225" alt="" class="img-responsive img-fullwidth">
                            </div>
                        </div>
                        <div class="entry-content p-20 pr-10 bg-white">
                            <div class="entry-meta media mt-0 no-bg no-border">
                                <div class="entry-date media-left text-center flip bg-theme-colored pt-5 pr-15 pb-5 pl-15">
                                    <ul>
                                        <li class="font-16 text-white font-weight-600 border-bottom">28</li>
                                        <li class="font-12 text-white text-uppercase">Feb</li>
                                    </ul>
                                </div>
                                <div class="media-body pl-15">
                                    <div class="event-content pull-left flip">
                                        <h4 class="entry-title text-white text-uppercase m-0 mt-5"><a href="#">Post title here</a></h4>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-commenting-o mr-5 text-theme-colored"></i> 214 Comments</span>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-heart-o mr-5 text-theme-colored"></i> 895 Likes</span>
                                    </div>
                                </div>
                            </div>
                            <p class="mt-10">Lorem ipsum dolor sit amet, consectetur adipisi cing elit. Molestias eius illum libero dolor nobis deleniti, sint assumenda Pariatur iste.</p>
                            <a href="#" class="btn-read-more">Read more</a>
                            <div class="clearfix"></div>
                        </div>
                    </article>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4 wow fadeInLeft" data-wow-duration="1s" data-wow-delay="0.4s">
                    <article class="post clearfix">
                        <div class="entry-header">
                            <div class="post-thumb thumb">
                                <img src="http://placehold.it/330x225" alt="" class="img-responsive img-fullwidth">
                            </div>
                        </div>
                        <div class="entry-content p-20 pr-10 bg-white">
                            <div class="entry-meta media mt-0 no-bg no-border">
                                <div class="entry-date media-left text-center flip bg-theme-colored pt-5 pr-15 pb-5 pl-15">
                                    <ul>
                                        <li class="font-16 text-white font-weight-600 border-bottom">28</li>
                                        <li class="font-12 text-white text-uppercase">Feb</li>
                                    </ul>
                                </div>
                                <div class="media-body pl-15">
                                    <div class="event-content pull-left flip">
                                        <h4 class="entry-title text-white text-uppercase m-0 mt-5"><a href="#">Post title here</a></h4>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-commenting-o mr-5 text-theme-colored"></i> 214 Comments</span>
                                        <span class="mb-10 text-gray-darkgray mr-10 font-13"><i class="fa fa-heart-o mr-5 text-theme-colored"></i> 895 Likes</span>
                                    </div>
                                </div>
                            </div>
                            <p class="mt-10">Lorem ipsum dolor sit amet, consectetur adipisi cing elit. Molestias eius illum libero dolor nobis deleniti, sint assumenda Pariatur iste.</p>
                            <a href="#" class="btn-read-more">Read more</a>
                            <div class="clearfix"></div>
                        </div>
                    </article>
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/newslist.scala.html
                  HASH: 1eb1dc03329180cadcad2b6c77db2473f6540867
                  MATRIX: 822->0
                  LINES: 26->1
                  -- GENERATED --
              */
          