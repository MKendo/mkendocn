
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

object articledescwithimg extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(article: Article):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<article class="post media-post clearfix pb-0 mb-10">
    <a class="post-thumb" href="/news/:"""),_display_(/*3.41*/article/*3.48*/.code),format.raw/*3.53*/(""""><img src=""""),_display_(/*3.66*/routes/*3.72*/.Assets.versioned("images/users/" + article.imgurl)),format.raw/*3.123*/("""" alt=""></a>
    <div class="post-right">
        <h4 class="post-title mt-0"><a href="/news/:"""),_display_(/*5.54*/article/*5.61*/.code),format.raw/*5.66*/("""">"""),_display_(/*5.69*/article/*5.76*/.title),format.raw/*5.82*/("""</a></h4>
        <ul class="list-inline font-12 mb-5">
            <li class="pr-0"><i class="fa fa-calendar mr-5"></i> """),_display_(/*7.67*/article/*7.74*/.eventStartDatetime),format.raw/*7.93*/(""" """),format.raw/*7.94*/("""|</li>
            <li class="pl-5"><i class="fa fa-map-marker mr-5"></i>"""),_display_(/*8.68*/article/*8.75*/.eventAddress),format.raw/*8.88*/("""</li>
        </ul>
        <p class="mb-0 font-13">"""),_display_(/*10.34*/article/*10.41*/.shortcontent),format.raw/*10.54*/("""</p>
    </div>
</article>"""))
      }
    }
  }

  def render(article:Article): play.twirl.api.HtmlFormat.Appendable = apply(article)

  def f:((Article) => play.twirl.api.HtmlFormat.Appendable) = (article) => apply(article)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/articledescwithimg.scala.html
                  HASH: cc683b726bad27e6e36cba79280b07aff3f125a2
                  MATRIX: 751->1|864->19|892->21|1013->116|1028->123|1053->128|1092->141|1106->147|1178->198|1302->296|1317->303|1342->308|1371->311|1386->318|1412->324|1562->448|1577->455|1616->474|1644->475|1745->550|1760->557|1793->570|1875->625|1891->632|1925->645
                  LINES: 21->1|26->1|27->2|28->3|28->3|28->3|28->3|28->3|28->3|30->5|30->5|30->5|30->5|30->5|30->5|32->7|32->7|32->7|32->7|33->8|33->8|33->8|35->10|35->10|35->10
                  -- GENERATED --
              */
          