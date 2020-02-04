
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

object news extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,List[Article],Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String, articles: List[Article], currentArticle: Article):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.76*/("""
"""),_display_(/*2.2*/main("NEWS", loginedUserInfo,false)/*2.37*/{_display_(Seq[Any](format.raw/*2.38*/("""
"""),format.raw/*3.1*/("""<!--nav.innerheadernav("首页","/","新闻")-->
<!-- Section: Blog -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-3">
                <div class="sidebar sidebar-left mt-sm-30">
                    """),_display_(/*10.22*/widgets/*10.29*/.search("NEWS")),format.raw/*10.44*/("""
                    """),_display_(/*11.22*/widgets/*11.29*/.latestarticle("新闻",articles)),format.raw/*11.58*/("""
                    """),_display_(/*12.22*/widgets/*12.29*/.photosfromflickr()),format.raw/*12.48*/("""
                """),format.raw/*13.17*/("""</div>
            </div>
            <div class="col-md-9 blog-pull-right">
                <div class="blog-posts single-post">
                    """),_display_(/*17.22*/if(currentArticle==null && articles.nonEmpty)/*17.67*/{_display_(Seq[Any](format.raw/*17.68*/("""
                        """),format.raw/*18.25*/("""currentArticle = if(articles.isEmpty)"""),format.raw/*18.62*/("""{"""),format.raw/*18.63*/("""null"""),format.raw/*18.67*/("""}"""),format.raw/*18.68*/(""" """),format.raw/*18.69*/("""else"""),format.raw/*18.73*/("""{"""),format.raw/*18.74*/("""articles(0)"""),format.raw/*18.85*/("""}"""),format.raw/*18.86*/("""
                    """)))}),format.raw/*19.22*/("""
                    """),_display_(/*20.22*/widgets/*20.29*/.articledetail(currentArticle)),format.raw/*20.59*/("""
                    """),format.raw/*21.21*/("""<!--
                    widgets.articletagsline()
                    widgets.articleauthordetail()
                    widgets.commentarea()
                    widgets.commentform()
                    -->
                </div>
            </div>
        </div>
    </div>
</section>
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(loginedUserInfo:String,articles:List[Article],currentArticle:Article): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,articles,currentArticle)

  def f:((String,List[Article],Article) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,articles,currentArticle) => apply(loginedUserInfo,articles,currentArticle)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/news.scala.html
                  HASH: 546394ba404ec5dc097871ec27bc5aca5c24422d
                  MATRIX: 750->1|919->75|947->78|990->113|1028->114|1056->116|1344->377|1360->384|1396->399|1446->422|1462->429|1512->458|1562->481|1578->488|1618->507|1664->525|1846->680|1900->725|1939->726|1993->752|2058->789|2087->790|2119->794|2148->795|2177->796|2209->800|2238->801|2277->812|2306->813|2360->836|2410->859|2426->866|2477->896|2527->918|2857->1218
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|37->12|38->13|42->17|42->17|42->17|43->18|43->18|43->18|43->18|43->18|43->18|43->18|43->18|43->18|43->18|44->19|45->20|45->20|45->20|46->21|57->32
                  -- GENERATED --
              */
          