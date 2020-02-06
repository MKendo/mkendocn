
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

object articledesc extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(article: Article):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<div class="col-sm-6 col-md-4">
    <div class="service-block bg-white">
        <div class="thumb"> <img alt="featured project" src=""""),_display_(/*4.63*/routes/*4.69*/.Assets.versioned("images/users/" + article.imgurl)),format.raw/*4.120*/("""" class="img-fullwidth">
            <h4 class="text-white mt-0 mb-0"></h4>
        </div>
        <div class="content text-left flip p-25 pt-0">
            <h4 class="line-bottom mb-10">"""),_display_(/*8.44*/article/*8.51*/.title),format.raw/*8.57*/("""</h4>
            <p>"""),_display_(/*9.17*/article/*9.24*/.content),format.raw/*9.32*/("""</p>
            <a class="btn btn-dark btn-theme-colored btn-sm text-uppercase mt-10" href="page-courses-accounting-technologies.html">查看全文</a>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(article:Article): play.twirl.api.HtmlFormat.Appendable = apply(article)

  def f:((Article) => play.twirl.api.HtmlFormat.Appendable) = (article) => apply(article)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:33 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/articledesc.scala.html
                  HASH: 2d1a455153c364480ba57a1b2ccdafc04a844746
                  MATRIX: 744->1|857->19|885->21|1048->158|1062->164|1134->215|1353->408|1368->415|1394->421|1443->444|1458->451|1486->459
                  LINES: 21->1|26->1|27->2|29->4|29->4|29->4|33->8|33->8|33->8|34->9|34->9|34->9
                  -- GENERATED --
              */
          