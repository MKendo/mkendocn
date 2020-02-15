
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

object blogs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 博客", loginedUserInfo,false)/*2.44*/{_display_(Seq[Any](format.raw/*2.45*/("""
"""),_display_(/*3.2*/nav/*3.5*/.innerheadernav("首页","/","博客")),format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!-- Section: Blog -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-3">
                <div class="sidebar sidebar-left mt-sm-30">
                    """),_display_(/*10.22*/widgets/*10.29*/.search("博客")),format.raw/*10.42*/("""
                    """),format.raw/*11.21*/("""<!--
                    widgets.latestarticle("博客",Map("今天白石洲的练习"->"小佳超级VIP啊！","周六大家一起复习比赛视频"->"赛后看视频学习非常重要啊，师姐们好用心","我们有了专业编辑"->"期待有更好的干货文章，更好的活动总结..."))
                    -->
                    """),_display_(/*14.22*/widgets/*14.29*/.photosfromflickr()),format.raw/*14.48*/("""
                """),format.raw/*15.17*/("""</div>
            </div>
            <div class="col-md-9 blog-pull-right">
                <div class="blog-posts single-post">
                    <!--
                    widgets.articledetail()
                    -->
                    """),_display_(/*22.22*/widgets/*22.29*/.articletagsline()),format.raw/*22.47*/("""
                    """),format.raw/*23.21*/("""<!--
                    widgets.articleauthordetail()
                    -->
                    """),_display_(/*26.22*/widgets/*26.29*/.commentarea()),format.raw/*26.43*/("""
                    """),_display_(/*27.22*/widgets/*27.29*/.commentform()),format.raw/*27.43*/("""
                """),format.raw/*28.17*/("""</div>
            </div>
        </div>
    </div>
</section>
<!-- end main-content -->
""")))}),format.raw/*34.2*/("""
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
                  DATE: Fri Feb 14 11:46:48 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/blogs.scala.html
                  HASH: 4d0ef76c007859d4f87e1ec0d326866b561cfc27
                  MATRIX: 729->1|848->25|876->28|926->70|964->71|992->74|1002->77|1052->107|1080->109|1326->328|1342->335|1376->348|1426->370|1657->574|1673->581|1713->600|1759->618|2037->869|2053->876|2092->894|2142->916|2272->1019|2288->1026|2323->1040|2373->1063|2389->1070|2424->1084|2470->1102|2596->1198
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|35->10|35->10|35->10|36->11|39->14|39->14|39->14|40->15|47->22|47->22|47->22|48->23|51->26|51->26|51->26|52->27|52->27|52->27|53->28|59->34
                  -- GENERATED --
              */
          