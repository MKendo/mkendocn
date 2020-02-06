
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

object product extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 会员商店", loginedUserInfo,false)/*2.46*/{_display_(Seq[Any](format.raw/*2.47*/("""
  """),_display_(/*3.4*/nav/*3.7*/.innerheadernav("会员商店","/shop","产品详情")),format.raw/*3.45*/("""
  """),_display_(/*4.4*/widgets/*4.11*/.productdetail("明心剑性头巾", "100%", "80", "50")),format.raw/*4.55*/("""
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
                  DATE: Wed Feb 05 19:16:32 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/product.scala.html
                  HASH: 490fa9c92196576179e5539d901deb15fbd9d040
                  MATRIX: 731->1|850->25|878->28|930->72|968->73|998->78|1008->81|1066->119|1096->124|1111->131|1175->175
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|29->4|29->4
                  -- GENERATED --
              */
          