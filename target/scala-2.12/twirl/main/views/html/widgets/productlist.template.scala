
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

object productlist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="products">
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*3.10*/widgets/*3.17*/.productdesc(false, "武风（男）", "90%", "150")),format.raw/*3.59*/("""
    """),format.raw/*4.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*6.10*/widgets/*6.17*/.productdesc(false, "武风（女）", "90%", "150")),format.raw/*6.59*/("""
    """),format.raw/*7.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*9.10*/widgets/*9.17*/.productdesc(false, "明心剑性头巾", "100%", "50")),format.raw/*9.60*/("""
    """),format.raw/*10.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*12.10*/widgets/*12.17*/.productdesc(false, "抗菌汗取", "100%", "80")),format.raw/*12.58*/("""
    """),format.raw/*13.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*15.10*/widgets/*15.17*/.productdesc(false, "全鹿皮护具 明", "199%", "4000")),format.raw/*15.63*/("""
    """),format.raw/*16.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*18.10*/widgets/*18.17*/.productdesc(false, "一之濑老师甲手", "100%", "2800")),format.raw/*18.63*/("""
    """),format.raw/*19.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*21.10*/widgets/*21.17*/.productdesc(false, "熊猫包", "100%", "30")),format.raw/*21.57*/("""
    """),format.raw/*22.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*24.10*/widgets/*24.17*/.productdesc(false, "邓小汪钥匙扣", "100%", "20")),format.raw/*24.60*/("""
    """),format.raw/*25.5*/("""</div>
    <div class="col-sm-6 col-md-4 col-lg-4 mb-30">
        """),_display_(/*27.10*/widgets/*27.17*/.productdesc(false, "明剑雨伞", "100%", "45")),format.raw/*27.58*/("""
    """),format.raw/*28.5*/("""</div>
</div>"""))
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
                  SOURCE: D:/products/mkendocn/app/views/widgets/productlist.scala.html
                  HASH: ef7ab313487367ed2eb5e390e2ce2477c110aa78
                  MATRIX: 825->0|936->85|951->92|1013->134|1045->140|1140->209|1155->216|1217->258|1249->264|1344->333|1359->340|1422->383|1455->389|1551->458|1567->465|1629->506|1662->512|1758->581|1774->588|1841->634|1874->640|1970->709|1986->716|2053->762|2086->768|2182->837|2198->844|2259->884|2292->890|2388->959|2404->966|2468->1009|2501->1015|2597->1084|2613->1091|2675->1132|2708->1138
                  LINES: 26->1|28->3|28->3|28->3|29->4|31->6|31->6|31->6|32->7|34->9|34->9|34->9|35->10|37->12|37->12|37->12|38->13|40->15|40->15|40->15|41->16|43->18|43->18|43->18|44->19|46->21|46->21|46->21|47->22|49->24|49->24|49->24|50->25|52->27|52->27|52->27|53->28
                  -- GENERATED --
              */
          