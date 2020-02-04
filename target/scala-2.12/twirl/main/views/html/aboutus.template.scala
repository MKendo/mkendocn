
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

object aboutus extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("ABOUTUS",loginedUserInfo,false)/*2.39*/{_display_(Seq[Any](format.raw/*2.40*/("""
"""),format.raw/*3.1*/("""<!--nav.innerheadernav("首页","/","关于我们")-->
"""),_display_(/*4.2*/widgets/*4.9*/.aboutdetail()),format.raw/*4.23*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dividerqrcode()),format.raw/*5.25*/("""
"""),format.raw/*6.1*/("""<section>
    <div class="container">
        <div class="section-content">
            <div class="row">
                """),_display_(/*10.18*/widgets/*10.25*/.welcome()),format.raw/*10.35*/("""
                """),_display_(/*11.18*/widgets/*11.25*/.tipwithimg("1.体验一下", "从来没有接触过剑道？可以亲自体验一次，给我们一节课的时间，让您全面了解剑道是否适合自己。", "立即申请","#", "https://jinshuju.net/f/6uwTbM")),format.raw/*11.139*/("""
                """),_display_(/*12.18*/widgets/*12.25*/.tipwithimg("2.加入明剑", "已经体验过了，觉得非常适合自己，想要立刻报名，加入明剑馆。请联系馆长（15889489370）后，填写报名表。", "填写报名表", "#", "https://jinshuju.net/f/tcyySF")),format.raw/*12.152*/("""
                """),_display_(/*13.18*/widgets/*13.25*/.tipwithimg("3.在线课程", "暂时不能来馆里练习，不过非常喜爱剑道，想学习一些理论知识，那么从这里开始吧。。", "剑道教室（建设中...）", "#", "#")),format.raw/*13.115*/("""
            """),format.raw/*14.13*/("""</div>
        </div>
    </div>
</section>
<!--
widgets.ourfeatures()
widgets.dividerclients()
-->
""")))}),format.raw/*22.2*/("""
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
                  DATE: Tue Feb 04 16:32:13 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/aboutus.scala.html
                  HASH: 4261f0d191c450e26f2f2f7113d69af545099c27
                  MATRIX: 731->1|850->25|878->28|923->65|961->66|989->68|1059->113|1073->120|1107->134|1135->137|1149->144|1185->160|1213->162|1367->289|1383->296|1414->306|1460->325|1476->332|1612->446|1658->465|1674->472|1823->599|1869->618|1885->625|1997->715|2039->729|2178->838
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|29->4|29->4|29->4|30->5|30->5|30->5|31->6|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|37->12|38->13|38->13|38->13|39->14|47->22
                  -- GENERATED --
              */
          