
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

object coursegird extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 剑道教室", loginedUserInfo,false)/*2.46*/{_display_(Seq[Any](format.raw/*2.47*/("""
    """),_display_(/*3.6*/nav/*3.9*/.innerheadernav("首页","/","剑道教室")),format.raw/*3.41*/("""
        """),format.raw/*4.9*/("""<!-- Section: Course gird -->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-9 blog-pull-right">
                        <div class="row">
                            """),_display_(/*10.30*/widgets/*10.37*/.coursedesc("剑道的礼","原则上，剑道练习的礼节，分有三种对象：神、老师、对手。道场一词起源于佛教，带有学习、修道的意思，并且代表了神圣的场域。","0")),format.raw/*10.122*/("""
                            """),_display_(/*11.30*/widgets/*11.37*/.coursedesc("正确的中段","从古代日本剑术中，现代剑道保留了五种「构 」或称「架势」，当中以中段为最常用和 最基本的架势。中段可攻可守。。。","0")),format.raw/*11.120*/("""
                            """),_display_(/*12.30*/widgets/*12.37*/.coursedesc("剑道用具","竹刀是日本剑道练习时所使用的攻击器具，以竹片制成。竹刀的普及不但降低了练习时的风险，也让剑道能以运动的层次发展。","0")),format.raw/*12.119*/("""
                            """),_display_(/*13.30*/widgets/*13.37*/.coursedesc("折衣服","剑道的道服每次练习完都要工整的折叠起来，回家洗干净之后，仍然要工工整整的折叠，以便于下次练习时带回道场，穿着整齐干净的衣服.","0")),format.raw/*13.124*/("""
                            """),_display_(/*14.30*/widgets/*14.37*/.coursedesc("冥想","许多人认为冥想时，脑海应该努力放空。这显然​​很难办到。当你无法放空时，你就让自己的思想自然流动，随着思绪漫步宇宙。","0")),format.raw/*14.119*/("""
                            """),_display_(/*15.30*/widgets/*15.37*/.coursedesc("剑道基本技稽古法","又称九刀十三形，把剑道稽古时常的技术一一展示了出来，平常要通过木刀的练习来体会剑理，调整姿势，练习观察。","0")),format.raw/*15.119*/("""
                        """),format.raw/*16.25*/("""</div>
                    </div>
                    <div class="col-sm-12 col-md-3">
                        <div class="sidebar sidebar-left mt-sm-30">
                            """),_display_(/*20.30*/widgets/*20.37*/.search("课程")),format.raw/*20.50*/("""
                            """),_display_(/*21.30*/widgets/*21.37*/.articlecatgories("课程",Array("剑道的礼","正确的中段","剑道用具","折衣服","冥想","剑道基本技稽古法"))),format.raw/*21.111*/("""
                            """),format.raw/*22.29*/("""<!--
                            widgets.latestarticle("课程",Map("剑道基本技稽古法"->"又称九刀十三形，把剑道稽古时常的技术一一展示...","冥想"->"法放空时，让自己的思想自然流动，让思绪漫步宇宙...","如何打蝴蝶结"->"衣服的蝴蝶结要打平，胴绳要打平，面绳要打平..."))
                            -->
                        </div>
                    </div>
                </div>
                <!--
                <div class="row">
                    <div class="col-sm-12">
                       @widgets.pagesplitter()
                    </div>
                </div>
                -->
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
                  DATE: Fri Feb 14 11:46:48 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/coursegird.scala.html
                  HASH: c1e985f8e1647ee3294d1d4c832ba5548de2a090
                  MATRIX: 734->1|853->25|881->28|933->72|971->73|1003->80|1013->83|1065->115|1101->125|1382->379|1398->386|1505->471|1563->502|1579->509|1684->592|1742->623|1758->630|1862->712|1920->743|1936->750|2045->837|2103->868|2119->875|2223->957|2281->988|2297->995|2401->1077|2455->1103|2670->1291|2686->1298|2720->1311|2778->1342|2794->1349|2890->1423|2948->1453
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|45->20|45->20|45->20|46->21|46->21|46->21|47->22
                  -- GENERATED --
              */
          