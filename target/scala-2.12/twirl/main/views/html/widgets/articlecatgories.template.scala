
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

object articlecatgories extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Array[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(articleType: String, articleTitles: Array[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.53*/("""
"""),format.raw/*2.1*/("""<div class="widget">
    <h5 class="widget-title line-bottom">"""),_display_(/*3.43*/articleType),format.raw/*3.54*/(""" """),format.raw/*3.55*/("""<span class="text-theme-color-2">分类</span></h5>
    <div class="categories">
        <ul class="list list-border angle-double-right">
            """),_display_(/*6.14*/for(title <- articleTitles) yield /*6.41*/{_display_(Seq[Any](format.raw/*6.42*/("""
                """),format.raw/*7.17*/("""<li><a href="#">"""),_display_(/*7.34*/title),format.raw/*7.39*/("""<span>(19)</span></a></li>
            """)))}),format.raw/*8.14*/("""
        """),format.raw/*9.9*/("""</ul>
    </div>
</div>"""))
      }
    }
  }

  def render(articleType:String,articleTitles:Array[String]): play.twirl.api.HtmlFormat.Appendable = apply(articleType,articleTitles)

  def f:((String,Array[String]) => play.twirl.api.HtmlFormat.Appendable) = (articleType,articleTitles) => apply(articleType,articleTitles)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/articlecatgories.scala.html
                  HASH: 191ba5b6502be1d2e81af43e1a2474f22d6e1333
                  MATRIX: 762->1|908->52|936->54|1026->118|1057->129|1085->130|1261->280|1303->307|1341->308|1386->326|1429->343|1454->348|1525->389|1561->399
                  LINES: 21->1|26->1|27->2|28->3|28->3|28->3|31->6|31->6|31->6|32->7|32->7|32->7|33->8|34->9
                  -- GENERATED --
              */
          