
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

object aboutdetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Section: Experts Details -->
<section>
    <div class="container">
        <div class="section-content">
            <div class="row">
                <div class="col-md-4">
                    <div class="thumb">
                        <img src=""""),_display_(/*8.36*/routes/*8.42*/.Assets.versioned("images/budongxinxf.jpg")),format.raw/*8.85*/("""" alt=""><!--img:360*360-->
                    </div>
                </div>
                <div class="col-md-8">
                    <h4 class="name font-24 mt-0 mb-0">明剑馆介绍</h4>
                    <h5 class="mt-5 text-theme-color-2">深圳最早期的剑道馆、深圳地区认证中心</h5>
                    <p>剑道是籍由有形与无形的剑理，去完善人格的一种约束性炼习。剑道锻炼我们更加的专注、冷静、理智、果断、温和、有责任心。剑道用她自身魅力带我们逐渐认识自己了解他人。</p>
                    <p>明剑馆是一家全日制国际剑道馆，全称深圳市剑友剑道俱乐部明剑馆，始于2006年，是国际剑道连盟（FIK）深圳地区认证中心。是深圳早期的剑道馆，明剑创始之初就希望把纯正的剑道带给大家，因此明剑一直秉承传统的剑道精神，严格遵守剑道传统文化和训练机制，为剑友提供有益身心的剑道环境。</p>
                    <p>为提升剑道水平，明剑每年会自主举办CKOU深圳地区剑道级位考试、馆内赛、剑道师范讲习会等活动。组织剑友参加由国际剑道联盟（FIK）所属国家和地区举办的各种比赛，考段，集训和剑道讲习。为同时提高剑友的日语水平，促进剑道文化交流。明剑在剑道修习的基础上还提供专业的剑道日语课程。</p>
                    <p>剑道是自身的修练，尽力为有志于剑道的剑友提供“每日剑道修行”的环境是明剑的职责。从明剑的创立到今天，剑友们对剑道的越来越多的热爱，也是让明剑不断前行的动力。明剑唯有努力完善自己，让更多的人认识剑道，开始剑道。</p>
                    <!--<ul class="styled-icons icon-dark icon-theme-colored icon-sm mt-15 mb-0">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-skype"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    </ul>-->
                </div>
            </div>
            <div class="row mt-30">
				<div class="col-md-4">
					"""),_display_(/*27.7*/whychooseus()),format.raw/*27.20*/("""
				"""),format.raw/*28.5*/("""</div>
                <div class="col-md-4">
                    """),_display_(/*30.22*/aboutdojo("福田保税区道场","全日制的剑道道道场，工作日晚上和休息日全天都有练习。","福田保税区红棉道4号智立方创新园3楼 明剑馆","15889489370","46561847@@qq.com",
					    List(
						    List("周一三五晚 19:30--21:30","新人基础练习"),
							List("周二四晚 19:30--21:30","前辈进阶练习"),
							List("周六上午 09:30--12:30","比赛练习"),
							List("周六下午 14:00--16:00","少儿剑道"),
							List("周六下午 16:30--18:30","新人基础练习"),
							List("周日上午 09:30--12:00","前辈进阶练习")
							)
						)),format.raw/*39.8*/("""
                """),format.raw/*40.17*/("""</div>
                <div class="col-md-4">
                    """),_display_(/*42.22*/aboutdojo("南山道场","目前只有每周二四晚有练习，位置临近科技园，下班后来练习非常方便。","南山区白石洲沙河东路118号世纪村小区会所4楼 U乐街舞培训中心 大教室","15889489370","46561847@@qq.com",
					    List(
						    List("周二晚 20:00--22:00","新人基础练习"),
							List("周四晚 20:00--22:00","新人基础练习")
							)
					)),format.raw/*47.7*/("""
                """),format.raw/*48.17*/("""</div>				
                <!--"""),_display_(/*49.22*/quickcontact()),format.raw/*49.36*/("""-->
            </div>
        </div>
    </div>
</section>

</div>
<!-- end main-content -->
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:32 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/aboutdetail.scala.html
                  HASH: a05202b7853c04ac30cd0be16e206d4545cbae27
                  MATRIX: 825->0|1112->261|1126->267|1189->310|2540->1635|2574->1648|2607->1654|2703->1723|3128->2128|3174->2146|3270->2215|3536->2461|3582->2479|3642->2512|3677->2526
                  LINES: 26->1|33->8|33->8|33->8|52->27|52->27|53->28|55->30|64->39|65->40|67->42|72->47|73->48|74->49|74->49
                  -- GENERATED --
              */
          