
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

object kendoliving extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 剑道生活", loginedUserInfo,false)/*2.46*/{_display_(Seq[Any](format.raw/*2.47*/("""
    """),_display_(/*3.6*/nav/*3.9*/.innerheadernav("首页","/","剑道生活")),format.raw/*3.41*/("""
        """),format.raw/*4.9*/("""<!-- Section: Course gird -->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-9 blog-pull-right">
                        <div class="row">
                            <!--
                           widgets.articledesc("重拾旧时光","当我开始好奇护具之下眼睛里能够看到的世界，那一刻我知道剑道之路于我还很长很长。")
                            widgets.articledesc("优秀剑道人共有的特质","他们无论在做着什么，他们目标清晰，计划性好，精力无限，全力以赴，开心着向前。。。")
                            widgets.articledesc("汪的漫画_武神上身","汪的漫画很好看，很真实，这就是明剑馆的日常！")
                            -->
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-3">
                        <div class="sidebar sidebar-left mt-sm-30">
                            <!--
                            widgets.search("文章")
                            widgets.latestarticle("文章",Map("重拾旧时光"->"当我开始好奇护具之下眼睛里能够看到的世界，那一刻我知道剑道之路于我还很长很长。","优秀剑道人共有的特质"->"他们无论在做着什么，他们目标清晰，计划性好，精力无限，全力以赴，开心着向前。。。","汪的漫画_武神上身"->"汪的漫画很好看，很真实，这就是明剑馆的日常！"))
                            -->
                            """),_display_(/*23.30*/widgets/*23.37*/.photosfromflickr()),format.raw/*23.56*/("""
                        """),format.raw/*24.25*/("""</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                       """),_display_(/*29.25*/widgets/*29.32*/.pagesplitter()),format.raw/*29.47*/("""
                    """),format.raw/*30.21*/("""</div>
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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/kendoliving.scala.html
                  HASH: 1111d9d9f4d71597f755bf34444680e5398c77c5
                  MATRIX: 735->1|854->25|882->28|934->72|972->73|1004->80|1014->83|1066->115|1102->125|2250->1246|2266->1253|2306->1272|2360->1298|2551->1462|2567->1469|2603->1484|2653->1506
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|48->23|48->23|48->23|49->24|54->29|54->29|54->29|55->30
                  -- GENERATED --
              */
          