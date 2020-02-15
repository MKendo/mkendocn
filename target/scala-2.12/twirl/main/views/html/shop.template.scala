
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

object shop extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 会员商店", loginedUserInfo,false)/*2.46*/{_display_(Seq[Any](format.raw/*2.47*/("""
"""),_display_(/*3.2*/nav/*3.5*/.innerheadernav("首页","/","明剑馆会员商店")),format.raw/*3.40*/("""
"""),format.raw/*4.1*/("""<section class="">
    <div class="container">
        <div class="section-content">
            <div class="row">
                <div class="col-sm-12 col-md-9">
                    <div class="row multi-row-clearfix">
                       """),_display_(/*10.25*/widgets/*10.32*/.productlist()),format.raw/*10.46*/("""
                    """),format.raw/*11.21*/("""</div>
                </div>
                <div class="col-sm-12 col-md-3">
                    <div class="sidebar sidebar-right mt-sm-30">
                        """),_display_(/*15.26*/widgets/*15.33*/.search("商品")),format.raw/*15.46*/("""
                        """),_display_(/*16.26*/widgets/*16.33*/.articlecatgories("商品",Array("竹剑","木刀","护具","箱包","小物件","文化周边"))),format.raw/*16.96*/("""
                        """),_display_(/*17.26*/widgets/*17.33*/.topsellers()),format.raw/*17.46*/("""
                    """),format.raw/*18.21*/("""</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    """),_display_(/*23.22*/widgets/*23.29*/.pagesplitter()),format.raw/*23.44*/("""
                    """),format.raw/*24.21*/("""</nav>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
<!-- end main-content -->
""")))}),format.raw/*32.2*/("""
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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/shop.scala.html
                  HASH: f3fe49729977c7b128320e7635ebe29108d8163b
                  MATRIX: 728->1|847->25|875->28|927->72|965->73|993->76|1003->79|1058->114|1086->116|1364->367|1380->374|1415->388|1465->410|1665->583|1681->590|1715->603|1769->630|1785->637|1869->700|1923->727|1939->734|1973->747|2023->769|2195->914|2211->921|2247->936|2297->958|2455->1086
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|35->10|35->10|35->10|36->11|40->15|40->15|40->15|41->16|41->16|41->16|42->17|42->17|42->17|43->18|48->23|48->23|48->23|49->24|57->32
                  -- GENERATED --
              */
          