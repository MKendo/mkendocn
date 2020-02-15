
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

object latestarticle extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[Article],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(typeName: String, articles: List[Article]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*2.1*/("""<div class="widget">
    <h5 class="widget-title line-bottom">最新 <span class="text-theme-color-2">"""),_display_(/*3.79*/typeName),format.raw/*3.87*/("""</span></h5>
    <div class="latest-posts">
        """),_display_(/*5.10*/for(article <- articles) yield /*5.34*/ {_display_(Seq[Any](format.raw/*5.36*/("""
            """),_display_(/*6.14*/articledescwithimg(article)),format.raw/*6.41*/("""
        """)))}),format.raw/*7.10*/("""
    """),format.raw/*8.5*/("""</div>
</div>"""))
      }
    }
  }

  def render(typeName:String,articles:List[Article]): play.twirl.api.HtmlFormat.Appendable = apply(typeName,articles)

  def f:((String,List[Article]) => play.twirl.api.HtmlFormat.Appendable) = (typeName,articles) => apply(typeName,articles)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/latestarticle.scala.html
                  HASH: da89fafa4885f0a4a6f040e42e62ade0d96ee034
                  MATRIX: 759->1|897->44|925->46|1051->146|1079->154|1160->209|1199->233|1238->235|1279->250|1326->277|1367->288|1399->294
                  LINES: 21->1|26->1|27->2|28->3|28->3|30->5|30->5|30->5|31->6|31->6|32->7|33->8
                  -- GENERATED --
              */
          