
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

object lastnews extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[Article],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String, newslist: List[Article]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.51*/("""
    """),format.raw/*2.5*/("""<h3 class="text-uppercase line-bottom mt-0 line-height-1"><i class="fa fa-calendar mr-10"></i>最近的<span class="text-theme-color-2">新闻与活动</span></h3>
    """),_display_(/*3.6*/for(news <- newslist) yield /*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
    """),format.raw/*4.5*/("""<article class="post media-post clearfix pb-0 mb-10">
        <a href="/news/:"""),_display_(/*5.26*/news/*5.30*/.code),format.raw/*5.35*/("""" class="post-thumb mr-20"><img alt="" width="120" height="120" src=""""),_display_(/*5.105*/routes/*5.111*/.Assets.versioned("images/users/" + news.imgurl)),format.raw/*5.159*/(""""></a>
        <div class="post-right">
            <h4 class="mt-0 mb-5"><a target="_blank" href="/news/:"""),_display_(/*7.68*/news/*7.72*/.code),format.raw/*7.77*/("""">"""),_display_(/*7.80*/news/*7.84*/.title),format.raw/*7.90*/("""</a></h4>
            <ul class="list-inline font-12 mb-5">
                <li class="pr-0"><i class="fa fa-calendar mr-5"></i> """),_display_(/*9.71*/news/*9.75*/.eventStartDatetime),format.raw/*9.94*/(""" """),format.raw/*9.95*/("""|</li>
                <li class="pl-5"><i class="fa fa-map-marker mr-5"></i>"""),_display_(/*10.72*/news/*10.76*/.eventAddress),format.raw/*10.89*/("""</li>
            </ul>
            <p class="mb-0 font-13">"""),_display_(/*12.38*/news/*12.42*/.shortcontent),format.raw/*12.55*/("""</p>
            <a class="text-theme-colored font-13" target="_blank" href="/news/:"""),_display_(/*13.81*/news/*13.85*/.code),format.raw/*13.90*/("""">阅读全文 →</a>
        </div>
    </article>
    """)))}))
      }
    }
  }

  def render(loginedUserInfo:String,newslist:List[Article]): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,newslist)

  def f:((String,List[Article]) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,newslist) => apply(loginedUserInfo,newslist)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/lastnews.scala.html
                  HASH: 40608d885c4d99e6062b882fec6ac3c183052f31
                  MATRIX: 754->1|898->50|930->56|1109->210|1145->231|1184->233|1216->239|1322->319|1334->323|1359->328|1456->398|1471->404|1540->452|1675->561|1687->565|1712->570|1741->573|1753->577|1779->583|1937->715|1949->719|1988->738|2016->739|2122->818|2135->822|2169->835|2259->898|2272->902|2306->915|2419->1001|2432->1005|2458->1010
                  LINES: 21->1|26->1|27->2|28->3|28->3|28->3|29->4|30->5|30->5|30->5|30->5|30->5|30->5|32->7|32->7|32->7|32->7|32->7|32->7|34->9|34->9|34->9|34->9|35->10|35->10|35->10|37->12|37->12|37->12|38->13|38->13|38->13
                  -- GENERATED --
              */
          