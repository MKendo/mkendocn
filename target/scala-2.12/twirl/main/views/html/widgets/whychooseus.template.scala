
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

object whychooseus extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.21*/("""<h3 class="line-bottom mt-0 line-height-1">为什么选择<span class="text-theme-color-2">明剑馆？</span></h3>
                    <p class="mb-10">是深圳早期的剑道馆，明剑创始之初就希望把纯正的剑道带给大家，因此明剑一直秉承传统的剑道精神，严格遵守剑道传统文化和训练机制，为剑友提供有益身心的剑道环境……</p>
                    <div id="accordion1" class="panel-group accordion">
                        <div class="panel">
                            <div class="panel-title"> <a data-parent="#accordion1" data-toggle="collapse" href="#accordion12" class="" aria-expanded="true"> <span class="open-sub"></span>明剑馆剑道的专业性如何？</a> </div>
                            <div id="accordion12" class="panel-collapse collapse" role="tablist" aria-expanded="true">
                                <div class="panel-content">
                                    <p>明剑馆全称：深圳剑友剑道俱乐部明剑馆，是深圳最早期的剑道馆，在剑道这个小小的世界里长达十余年的探索、学习与历练，让明剑馆初步具备了能够从零基础开始培养剑道人的能力，明剑馆从2018年开始也拥有了从本馆成长起来的四段老师，这是无数前辈们共同的努力，是明剑的骄傲，但这只是开始，我们仍会继续探索，不断学习，一直前行。</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-title"> <a data-parent="#accordion1" data-toggle="collapse" href="#accordion13" class="" aria-expanded="true"> <span class="open-sub"></span>明剑馆的师资如何？</a> </div>
                            <div id="accordion13" class="panel-collapse collapse" role="tablist" aria-expanded="true">
                                <div class="panel-content">
                                    <p>明剑馆非常幸运的是从一开始，就有高段位的日本老师，一届一届的悉心指导，不同的老师来了又回了，相同的是他们都为明剑馆给予了无私的指导，让明剑馆人从一开始就接受了最正统的剑道理念和练习方法。</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-title"> <a data-parent="#accordion1" data-toggle="collapse" href="#accordion15" class="" aria-expanded="true"> <span class="open-sub"></span>明剑馆的场地如何？</a> </div>
                            <div id="accordion15" class="panel-collapse collapse" role="tablist" aria-expanded="true">
                                <div class="panel-content">
                                    <p>明剑馆从2017年开始第二次全面升级道场环境，拥有200平米的实用练习场地，专业的剑道木地板，能够最大限度的为脚和膝盖提供支撑保护（因为剑道练习是光脚的），有专用的剑栏、每人独立护具架可以存放剑道装备，让每次的练习可以轻装上阵，有榻榻米讨论区，有大电视可以用来讨论比赛视频，做练习讲评，研究技术动作……</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-title"> <a data-parent="#accordion1" data-toggle="collapse" href="#accordion14" class="" aria-expanded="true"> <span class="open-sub"></span>明剑馆与健身培训机构的区别是什么？</a> </div>
                            <div id="accordion14" class="panel-collapse collapse" role="tablist" aria-expanded="true">
                                <div class="panel-content">
                                    <p>嗯，这个区别可能不是每人都喜欢哦，明剑馆的地板要自己擦哦，垃圾桶要自己倒哦，因为明剑馆是大家来共同修习的道场，不是享受他人服务的场所，剑道的道场需要每个人悉心的维护，剑道之礼包括如何对待道场，如果对待竹剑，如何对待老师、前辈、后辈等等。付出总会有收获，正因为大家都如此的用心，因此在明剑馆不仅可以收获专业的剑道，还会收获不凡的友谊，这友谊是长年累月共同拼搏共同努力沉淀出来的。</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-title"> <a class="active" data-parent="#accordion1" data-toggle="collapse" href="#accordion11" aria-expanded="true"> <span class="open-sub"></span>明剑馆具备怎样的剑道资质？</a> </div>
                            <div id="accordion11" class="panel-collapse collapse in" role="tablist" aria-expanded="true"> 
                                <div class="panel-content">
                                    <p>明剑馆是一家全日制国际剑道馆，全称深圳市剑友剑道俱乐部明剑馆，始于2006年，是国际剑道连盟（FIK）深圳地区认证中心（段级位证书全球通用）。为提升剑道水平，明剑每年会自主举办CKOU深圳地区剑道级位考试、馆内赛、剑道师范讲习会等活动。组织剑友参加由国际剑道联盟（FIK）所属国家和地区举办的各种比赛，考段，集训和剑道讲习。</p>
                                </div>
                            </div>
                        </div>
                    </div>
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
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/whychooseus.scala.html
                  HASH: 506f793da2ddacdd6aebadc43d84d3bc82e5460b
                  MATRIX: 826->38
                  LINES: 26->2
                  -- GENERATED --
              */
          