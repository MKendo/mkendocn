
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

object teachers extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 师范阵", loginedUserInfo,false)/*2.45*/{_display_(Seq[Any](format.raw/*2.46*/("""
        """),_display_(/*3.10*/nav/*3.13*/.innerheadernav("首页","/","师范阵")),format.raw/*3.44*/("""
        """),_display_(/*4.10*/widgets/*4.17*/.teamwithoutdetail()),format.raw/*4.37*/("""
        """),_display_(/*5.10*/widgets/*5.17*/.dividerfunface()),format.raw/*5.34*/("""
        """),_display_(/*6.10*/widgets/*6.17*/.calltoaction()),format.raw/*6.32*/("""
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
                  SOURCE: D:/products/mkendocn/app/views/teachers.scala.html
                  HASH: 11b3157338bdea9015475fc6756f6628563da052
                  MATRIX: 732->1|851->25|879->28|930->71|968->72|1005->83|1016->86|1067->117|1104->128|1119->135|1159->155|1196->166|1211->173|1248->190|1285->201|1300->208|1335->223
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|29->4|29->4|30->5|30->5|30->5|31->6|31->6|31->6
                  -- GENERATED --
              */
          