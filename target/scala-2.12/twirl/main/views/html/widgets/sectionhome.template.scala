
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

object sectionhome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<section id="home">
    <div class="container-fluid p-0">

        <!-- Slider Revolution Start -->
        <div class="rev_slider_wrapper">
            <div class="rev_slider" data-version="5.0">
                <ul>

                    <!-- SLIDE 1 -->
                    <li data-index="rs-1" data-transition="slidingoverlayhorizontal" data-slotamount="default" data-easein="default" data-easeout="default" data-masterspeed="default" data-thumb="http://placehold.it/1920x1280" data-rotate="0" data-saveperformance="off" data-title="Slide 1" data-description="">
                        <!-- MAIN IMAGE -->
                        <img src="http://placehold.it/1920x1280"  alt=""  data-bgposition="center 10%" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-bgparallax="10" data-no-retina>
                        <!-- LAYERS -->

                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption tp-resizeme text-uppercase text-white font-raleway"
                             id="rs-1-layer-1"

                             data-x="['left']"
                             data-hoffset="['30']"
                             data-y="['middle']"
                             data-voffset="['-110']"
                             data-fontsize="['100']"
                             data-lineheight="['110']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:700;">Education
                        </div>

                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption tp-resizeme text-uppercase text-white font-raleway bg-theme-colored-transparent border-left-theme-color-2-6px pl-20 pr-20"
                             id="rs-1-layer-2"

                             data-x="['left']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['-25']"
                             data-fontsize="['35']"
                             data-lineheight="['54']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:600;">Education For Everyone
                        </div>

                        <!-- LAYER NR. 3 -->
                        <div class="tp-caption tp-resizeme text-white"
                             id="rs-1-layer-3"

                             data-x="['left']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['35']"
                             data-fontsize="['16']"
                             data-lineheight="['28']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:0px; font-weight:400;">We provides always our best services for our clients and  always<br> try to achieve our client's trust and satisfaction.
                        </div>

                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption tp-resizeme"
                             id="rs-1-layer-4"

                             data-x="['left']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['100']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;"
                             data-transform_in="y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;s:2000;e:Power4.easeInOut;"
                             data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                             data-mask_in="x:0px;y:[100%];s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:1px;"><a class="btn btn-colored btn-lg btn-flat btn-theme-colored border-left-theme-color-2-6px pl-20 pr-20" href="#">View Details</a>
                        </div>
                    </li>

                    <!-- SLIDE 2 -->
                    <li data-index="rs-2" data-transition="slidingoverlayhorizontal" data-slotamount="default" data-easein="default" data-easeout="default" data-masterspeed="default" data-thumb="http://placehold.it/1920x1280" data-rotate="0" data-saveperformance="off" data-title="Slide 2" data-description="">
                        <!-- MAIN IMAGE -->
                        <img src="http://placehold.it/1920x1280"  alt=""  data-bgposition="center 40%" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-bgparallax="10" data-no-retina>
                        <!-- LAYERS -->

                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption tp-resizeme text-uppercase  bg-dark-transparent-5 text-white font-raleway border-left-theme-color-2-6px border-right-theme-color-2-6px pl-30 pr-30"
                             id="rs-2-layer-1"

                             data-x="['center']"
                             data-hoffset="['0']"
                             data-y="['middle']"
                             data-voffset="['-90']"
                             data-fontsize="['28']"
                             data-lineheight="['54']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:400; border-radius: 30px;">Feed Your Knowledge
                        </div>

                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption tp-resizeme text-uppercase bg-theme-colored-transparent text-white font-raleway pl-30 pr-30"
                             id="rs-2-layer-2"

                             data-x="['center']"
                             data-hoffset="['0']"
                             data-y="['middle']"
                             data-voffset="['-20']"
                             data-fontsize="['48']"
                             data-lineheight="['70']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:700; border-radius: 30px;"> World’s Best University
                        </div>

                        <!-- LAYER NR. 3 -->
                        <div class="tp-caption tp-resizeme text-white text-center"
                             id="rs-2-layer-3"

                             data-x="['center']"
                             data-hoffset="['0']"
                             data-y="['middle']"
                             data-voffset="['50']"
                             data-fontsize="['16']"
                             data-lineheight="['28']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:0px; font-weight:400;">We provides always our best services for our clients and  always<br> try to achieve our client's trust and satisfaction.
                        </div>

                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption tp-resizeme"
                             id="rs-2-layer-4"

                             data-x="['center']"
                             data-hoffset="['0']"
                             data-y="['middle']"
                             data-voffset="['115']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;"
                             data-transform_in="y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;s:2000;e:Power4.easeInOut;"
                             data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                             data-mask_in="x:0px;y:[100%];s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:1px;"><a class="btn btn-default btn-circled btn-transparent pl-20 pr-20" href="#">Apply Now</a>
                        </div>
                    </li>

                    <!-- SLIDE 3 -->
                    <li data-index="rs-3" data-transition="slidingoverlayhorizontal" data-slotamount="default" data-easein="default" data-easeout="default" data-masterspeed="default" data-thumb="http://placehold.it/1920x1280" data-rotate="0" data-saveperformance="off" data-title="Slide 3" data-description="">
                        <!-- MAIN IMAGE -->
                        <img src="http://placehold.it/1920x1280"  alt=""  data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg" data-bgparallax="10" data-no-retina>
                        <!-- LAYERS -->

                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption tp-resizeme text-uppercase text-white font-raleway bg-theme-colored-transparent border-right-theme-color-2-6px pr-20 pl-20"
                             id="rs-3-layer-1"

                             data-x="['right']"
                             data-hoffset="['30']"
                             data-y="['middle']"
                             data-voffset="['-90']"
                             data-fontsize="['64']"
                             data-lineheight="['72']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:600;">Best Education
                        </div>

                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption tp-resizeme text-uppercase bg-dark-transparent-6 text-white font-raleway pl-20 pr-20"
                             id="rs-3-layer-2"

                             data-x="['right']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['-25']"
                             data-fontsize="['32']"
                             data-lineheight="['54']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1000"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 7; white-space: nowrap; font-weight:600;">For Your Better Future
                        </div>

                        <!-- LAYER NR. 3 -->
                        <div class="tp-caption tp-resizeme text-white text-right"
                             id="rs-3-layer-3"

                             data-x="['right']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['30']"
                             data-fontsize="['16']"
                             data-lineheight="['28']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;s:500"
                             data-transform_in="y:100;scaleX:1;scaleY:1;opacity:0;"
                             data-transform_out="x:left(R);s:1000;e:Power3.easeIn;s:1000;e:Power3.easeIn;"
                             data-mask_in="x:0px;y:0px;s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:0px; font-weight:400;">We provides always our best services for our clients and  always<br> try to achieve our client's trust and satisfaction.
                        </div>

                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption tp-resizeme"
                             id="rs-3-layer-4"

                             data-x="['right']"
                             data-hoffset="['35']"
                             data-y="['middle']"
                             data-voffset="['95']"
                             data-width="none"
                             data-height="none"
                             data-whitespace="nowrap"
                             data-transform_idle="o:1;"
                             data-transform_in="y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;s:2000;e:Power4.easeInOut;"
                             data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
                             data-mask_in="x:0px;y:[100%];s:inherit;e:inherit;"
                             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
                             data-start="1400"
                             data-splitin="none"
                             data-splitout="none"
                             data-responsive_offset="on"
                             style="z-index: 5; white-space: nowrap; letter-spacing:1px;"><a class="btn btn-colored btn-lg btn-flat btn-theme-colored btn-theme-colored border-right-theme-color-2-6px pl-20 pr-20""""),
format.raw(""" href="#">Apply Now</a>
                        </div>
                    </li>

                </ul>
            </div>
            <!-- end .rev_slider -->
        </div>
        <!-- end .rev_slider_wrapper -->
        <script>
          $(document).ready(function(e) """),format.raw/*330.41*/("""{"""),format.raw/*330.42*/("""
            """),format.raw/*331.13*/("""$(".rev_slider").revolution("""),format.raw/*331.41*/("""{"""),format.raw/*331.42*/("""
              """),format.raw/*332.15*/("""sliderType:"standard",
              sliderLayout: "auto",
              dottedOverlay: "none",
              delay: 5000,
              navigation: """),format.raw/*336.27*/("""{"""),format.raw/*336.28*/("""
                  """),format.raw/*337.19*/("""keyboardNavigation: "off",
                  keyboard_direction: "horizontal",
                  mouseScrollNavigation: "off",
                  onHoverStop: "off",
                  touch: """),format.raw/*341.26*/("""{"""),format.raw/*341.27*/("""
                      """),format.raw/*342.23*/("""touchenabled: "on",
                      swipe_threshold: 75,
                      swipe_min_touches: 1,
                      swipe_direction: "horizontal",
                      drag_block_vertical: false
                  """),format.raw/*347.19*/("""}"""),format.raw/*347.20*/(""",
                arrows: """),format.raw/*348.25*/("""{"""),format.raw/*348.26*/("""
                  """),format.raw/*349.19*/("""style:"zeus",
                  enable:true,
                  hide_onmobile:true,
                  hide_under:600,
                  hide_onleave:true,
                  hide_delay:200,
                  hide_delay_mobile:1200,
                  tmp:'<div class="tp-title-wrap">    <div class="tp-arr-imgholder"></div> </div>',
                  left: """),format.raw/*357.25*/("""{"""),format.raw/*357.26*/("""
                    """),format.raw/*358.21*/("""h_align:"left",
                    v_align:"center",
                    h_offset:30,
                    v_offset:0
                  """),format.raw/*362.19*/("""}"""),format.raw/*362.20*/(""",
                  right: """),format.raw/*363.26*/("""{"""),format.raw/*363.27*/("""
                    """),format.raw/*364.21*/("""h_align:"right",
                    v_align:"center",
                    h_offset:30,
                    v_offset:0
                  """),format.raw/*368.19*/("""}"""),format.raw/*368.20*/("""
                """),format.raw/*369.17*/("""}"""),format.raw/*369.18*/(""",
                bullets: """),format.raw/*370.26*/("""{"""),format.raw/*370.27*/("""
                  """),format.raw/*371.19*/("""enable:true,
                  hide_onmobile:true,
                  hide_under:600,
                  style:"metis",
                  hide_onleave:true,
                  hide_delay:200,
                  hide_delay_mobile:1200,
                  direction:"horizontal",
                  h_align:"center",
                  v_align:"bottom",
                  h_offset:0,
                  v_offset:30,
                  space:5,
                  tmp:'<span class="tp-bullet-img-wrap">  <span class="tp-bullet-image"></span></span><span class="tp-bullet-title">"""),format.raw/*384.133*/("""{"""),format.raw/*384.134*/("""{"""),format.raw/*384.135*/("""title"""),format.raw/*384.140*/("""}"""),format.raw/*384.141*/("""}"""),format.raw/*384.142*/("""</span>'
                """),format.raw/*385.17*/("""}"""),format.raw/*385.18*/("""
              """),format.raw/*386.15*/("""}"""),format.raw/*386.16*/(""",
              responsiveLevels: [1240, 1024, 778],
              visibilityLevels: [1240, 1024, 778],
              gridwidth: [1170, 1024, 778, 480],
              gridheight: [650, 768, 960, 720],
              lazyType: "none",
              parallax: """),format.raw/*392.25*/("""{"""),format.raw/*392.26*/("""
                  """),format.raw/*393.19*/("""origo: "slidercenter",
                  speed: 1000,
                  levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 100, 55],
                  type: "scroll"
              """),format.raw/*397.15*/("""}"""),format.raw/*397.16*/(""",
              shadow: 0,
              spinner: "off",
              stopLoop: "on",
              stopAfterLoops: 0,
              stopAtSlide: -1,
              shuffle: "off",
              autoHeight: "off",
              fullScreenAutoWidth: "off",
              fullScreenAlignForce: "off",
              fullScreenOffsetContainer: "",
              fullScreenOffset: "0",
              hideThumbsOnMobile: "off",
              hideSliderAtLimit: 0,
              hideCaptionAtLimit: 0,
              hideAllCaptionAtLilmit: 0,
              debugMode: false,
              fallbacks: """),format.raw/*414.26*/("""{"""),format.raw/*414.27*/("""
                  """),format.raw/*415.19*/("""simplifyAll: "off",
                  nextSlideOnWindowFocus: "off",
                  disableFocusListener: false,
              """),format.raw/*418.15*/("""}"""),format.raw/*418.16*/("""
            """),format.raw/*419.13*/("""}"""),format.raw/*419.14*/(""");
          """),format.raw/*420.11*/("""}"""),format.raw/*420.12*/(""");
        </script>
        <!-- Slider Revolution Ends -->

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
                  SOURCE: D:/products/mkendocn/app/views/widgets/sectionhome.scala.html
                  HASH: 29dcaf7680ce142d7cb85f33d6858641a18335f6
                  MATRIX: 825->0|21157->20283|21187->20284|21230->20298|21287->20326|21317->20327|21362->20343|21544->20496|21574->20497|21623->20517|21846->20711|21876->20712|21929->20736|22190->20968|22220->20969|22276->20996|22306->20997|22355->21017|22746->21379|22776->21380|22827->21402|22996->21542|23026->21543|23083->21571|23113->21572|23164->21594|23334->21735|23364->21736|23411->21754|23441->21755|23498->21783|23528->21784|23577->21804|24185->22382|24216->22383|24247->22384|24282->22389|24313->22390|24344->22391|24399->22417|24429->22418|24474->22434|24504->22435|24796->22698|24826->22699|24875->22719|25101->22916|25131->22917|25770->23527|25800->23528|25849->23548|26011->23681|26041->23682|26084->23696|26114->23697|26157->23711|26187->23712
                  LINES: 26->1|356->330|356->330|357->331|357->331|357->331|358->332|362->336|362->336|363->337|367->341|367->341|368->342|373->347|373->347|374->348|374->348|375->349|383->357|383->357|384->358|388->362|388->362|389->363|389->363|390->364|394->368|394->368|395->369|395->369|396->370|396->370|397->371|410->384|410->384|410->384|410->384|410->384|410->384|411->385|411->385|412->386|412->386|418->392|418->392|419->393|423->397|423->397|440->414|440->414|441->415|444->418|444->418|445->419|445->419|446->420|446->420
                  -- GENERATED --
              */
          