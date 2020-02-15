
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

object articledetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentArticle: Article):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.27*/("""
"""),_display_(/*2.2*/if(currentArticle == null)/*2.28*/{_display_(Seq[Any](format.raw/*2.29*/("""
   """),format.raw/*3.4*/("""<p></p>
""")))}/*4.2*/else/*4.6*/{_display_(Seq[Any](format.raw/*4.7*/("""
    """),format.raw/*5.5*/("""<article class="post clearfix mb-0">
        <div class="entry-header">
            <div class="post-thumb thumb">
                <img src=""""),_display_(/*8.28*/routes/*8.34*/.Assets.versioned("images/users/" + currentArticle.imgurl)),format.raw/*8.92*/("""" alt="" class="img-responsive img-fullwidth">
            </div>
        </div>
        <div class="entry-title pt-10 pl-15">
            <h4><a class="text-uppercase" href="/news/:"""),_display_(/*12.57*/currentArticle/*12.71*/.code),format.raw/*12.76*/("""">"""),_display_(/*12.79*/currentArticle/*12.93*/.title),format.raw/*12.99*/("""</a></h4>
        </div>
        <div class="entry-meta pl-15">
            <ul class="list-inline">
                <li>日期: <span class="text-theme-color-2"> """),_display_(/*16.60*/currentArticle/*16.74*/.eventStartDatetime),format.raw/*16.93*/("""</span></li>
                <li>By: <span class="text-theme-color-2">"""),_display_(/*17.59*/currentArticle/*17.73*/.createrName),format.raw/*17.85*/("""</span></li>
            </ul>
        </div>
        <div class="entry-content mt-10">
            <p class="mb-15">"""),_display_(/*21.31*/Html(currentArticle.content)),format.raw/*21.59*/("""</p>
        </div>
    </article>
""")))}))
      }
    }
  }

  def render(currentArticle:Article): play.twirl.api.HtmlFormat.Appendable = apply(currentArticle)

  def f:((Article) => play.twirl.api.HtmlFormat.Appendable) = (currentArticle) => apply(currentArticle)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 15 11:43:31 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/articledetail.scala.html
                  HASH: 956fef2982c4d3c2c0a065f2cf55651350f7ea26
                  MATRIX: 746->1|866->26|894->29|928->55|966->56|997->61|1024->71|1035->75|1072->76|1104->82|1275->227|1289->233|1367->291|1581->478|1604->492|1630->497|1660->500|1683->514|1710->520|1901->684|1924->698|1964->717|2063->789|2086->803|2119->815|2268->937|2317->965
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|29->4|29->4|29->4|30->5|33->8|33->8|33->8|37->12|37->12|37->12|37->12|37->12|37->12|41->16|41->16|41->16|42->17|42->17|42->17|46->21|46->21
                  -- GENERATED --
              */
          