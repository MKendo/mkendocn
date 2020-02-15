
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

object faq extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 常见问题FAQ", loginedUserInfo,false)/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
"""),_display_(/*3.2*/nav/*3.5*/.innerheadernav("首页","/","常见问题FAQ")),format.raw/*3.40*/("""
"""),format.raw/*4.1*/("""<section class="position-inherit">
    <div class="container">
        <div class="row">
            <div class="col-md-3 scrolltofixed-container">
                <div class="list-group scrolltofixed z-index-0">
                    <a href="#section-one" class="list-group-item smooth-scroll-to-target">剑道如何划分阶段？</a>
                    <a href="#section-two" class="list-group-item smooth-scroll-to-target">剑道的训练模式和过程是怎样的？</a>
                    <a href="#section-three" class="list-group-item smooth-scroll-to-target">明剑馆是怎样的剑道俱乐部？</a>
                    <a href="#section-four" class="list-group-item smooth-scroll-to-target">我什么也不懂，会有人指导我吗？</a>
                    <a href="#section-five" class="list-group-item smooth-scroll-to-target">我该如何报名以及费用如何？</a>
                </div>
            </div>
            <div class="col-md-9">
                <div id="section-one" class="mb-50">
                    <h3>剑道如何划分阶段？</h3>
                    <hr>
                    <p class="mb-20">国际剑道联盟（FIK）拥有一套全世界统一的级位和段位体系，从开始接触剑道，从低到高，依次是新人，上甲，8到1级，1段，2段。。。8段，目前8段最高。每阶段都有详细的训练大纲和规范及目标，任何剑道练习者，皆可参考进行剑道练习。</p>
                </div>
                <div id="section-two" class="mb-50">
                    <h3>剑道的训练模式和过程是怎样的？</h3>
                    <hr>
                    <p class="mb-20">剑道是属于学会很容易，练习也不难，但练好需要大量时间的技艺，所以更多的是资深者和初学者在一起的练习，以及前辈和老师对后辈的指导，训练模式是一种类似军队分组群体训练，有认真的礼仪和传统文化，以及道场纪律，一般初心课程，即可感受到剑道的气场。</p>
                </div>
                <div id="section-three" class="mb-50">
                    <h3>剑友会和明剑馆是怎样的剑道俱乐部？</h3>
                    <hr>
                    <p class="mb-20">我们是目前唯一在深圳民政局正式注册的专业剑道团体，也是深圳第一家和规模最大的剑道俱乐部，每周和我们一起练习的仅师范就有数十位，同时我们专注于剑道的自我修炼，让大家在众多老师和前辈的一个剑道社区中成长，传统的剑道道场机制中，你可能会受到非常多的前辈和老师的指导和帮助，和大家一起进步，老师和你一样，也是互相平等及一起练习的剑道爱好者。</p>
                </div>
                <div id="section-four" class="mb-50">
                    <h3>我什么也不懂，会有人指导我吗？</h3>
                    <hr>
                    <p class="mb-20">不用担心，新人会安排前辈专门手把手指导，不同水平和阶段的一般会分组练习，由相应的前辈和老师带领练习，剑道的基础非常简单，只是需要大量的练习和纠正，老师和前辈只要看到你的错误，都会协助你纠正。任何人只要坚持来道场，如何练习，馆长和老师会妥善安排的。</p>
                </div>
                <div id="section-five" class="mb-50">
                    <h3>我该如何报名以及费用如何？</h3>
                    <hr>
                    <p class="mb-20">首先，你可以发短信到15889489370预约参加免费的初心课程，对剑道和道馆有了初步了解后再决定是否报名。以后每年只需缴纳固定年费即可。年费会员可以在明剑馆所有道场不限时不限地点练习剑道，还将拥有考级考段费用补贴。如果出差或假期来深等非长期练习者请与馆长（15889489370）联系确认具体费用。</p>
                </div>
            </div>
        </div>
    </div>
</section>
""")))}),format.raw/*46.2*/("""

"""))
      }
    }
  }

  def render(loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo) => apply(loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:48 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/faq.scala.html
                  HASH: 81650ace1c1049a033f059d6b9ffd76b68a56e25
                  MATRIX: 727->1|846->25|874->28|929->75|967->76|995->79|1005->82|1060->117|1088->119|3664->2665
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|71->46
                  -- GENERATED --
              */
          