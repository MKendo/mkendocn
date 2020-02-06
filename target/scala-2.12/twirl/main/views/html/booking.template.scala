
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

object booking extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("BOOKING",loginedUserInfo,false)/*2.39*/{_display_(Seq[Any](format.raw/*2.40*/("""
"""),format.raw/*3.1*/("""<!--nav.innerheadernav("首页","/","预约体验")-->
"""),_display_(/*4.2*/widgets/*4.9*/.bookingWidget()),format.raw/*4.25*/("""
""")))}),format.raw/*5.2*/("""
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
                  DATE: Wed Feb 05 19:16:31 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/booking.scala.html
                  HASH: 430c87514006bce7acfff26f357e1e0fa95d9349
                  MATRIX: 731->1|850->25|878->28|923->65|961->66|989->68|1059->113|1073->120|1109->136|1141->139
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|29->4|29->4|29->4|30->5
                  -- GENERATED --
              */
          