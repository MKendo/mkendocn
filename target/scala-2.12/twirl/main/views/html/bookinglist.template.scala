
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

object bookinglist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,List[Booking],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String,timePeriodKeyword:String,bookings:List[Booking]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.74*/("""
"""),_display_(/*2.2*/main("BOOKING",loginedUserInfo,true)/*2.38*/{_display_(Seq[Any](format.raw/*2.39*/("""

"""),format.raw/*4.1*/("""<section>
<div class="container">
    <div class="row">
        <h3 class="mt-0 mb-20">查看近期的<span class="text-theme-color-2">预约信息</span></h3>
        <i class="fa fa-search"></i>
        """),_display_(/*9.10*/if(timePeriodKeyword=="ALL")/*9.38*/{_display_(Seq[Any](format.raw/*9.39*/("""
            """),format.raw/*10.13*/("""<span class="text-theme-color-2">全部</span>
        """)))}/*11.10*/else/*11.14*/{_display_(Seq[Any](format.raw/*11.15*/("""
        """),format.raw/*12.9*/("""<a href="""),_display_(/*12.18*/routes/*12.24*/.MkendoController.bookinglist("ALL")),format.raw/*12.60*/(""">全部</a>
        """)))}),format.raw/*13.10*/("""
        """),_display_(/*14.10*/if(timePeriodKeyword=="CURRENT_WEEK")/*14.47*/{_display_(Seq[Any](format.raw/*14.48*/("""
            """),format.raw/*15.13*/("""<span class="text-theme-color-2">本周</span>
        """)))}/*16.10*/else/*16.14*/{_display_(Seq[Any](format.raw/*16.15*/("""
            """),format.raw/*17.13*/("""<a href="""),_display_(/*17.22*/routes/*17.28*/.MkendoController.bookinglist("CURRENT_WEEK")),format.raw/*17.73*/(""">本周</a>
        """)))}),format.raw/*18.10*/("""
        """),_display_(/*19.10*/if(timePeriodKeyword=="NEXT_WEEK")/*19.44*/{_display_(Seq[Any](format.raw/*19.45*/("""
            """),format.raw/*20.13*/("""<span class="text-theme-color-2">下周</span>
        """)))}/*21.10*/else/*21.14*/{_display_(Seq[Any](format.raw/*21.15*/("""
            """),format.raw/*22.13*/("""<a href="""),_display_(/*22.22*/routes/*22.28*/.MkendoController.bookinglist("NEXT_WEEK")),format.raw/*22.70*/(""">下周</a>
        """)))}),format.raw/*23.10*/("""
        """),format.raw/*24.9*/("""<table class="table table-striped">
            <tr>
                <td>预约时间</td>
                <td>预约人</td>
                <td>手机号</td>
                <td>练习场次</td>
                <td>课程</td>
            </tr>
            """),_display_(/*32.14*/for(booking <- bookings) yield /*32.38*/ {_display_(Seq[Any](format.raw/*32.40*/("""
            """),format.raw/*33.13*/("""<tr>
                <td>"""),_display_(/*34.22*/booking/*34.29*/.classdate),format.raw/*34.39*/("""</td>
                <td>"""),_display_(/*35.22*/booking/*35.29*/.name),format.raw/*35.34*/("""</td>
                <td>"""),_display_(/*36.22*/booking/*36.29*/.mobile),format.raw/*36.36*/("""</td>
                <td>"""),_display_(/*37.22*/booking/*37.29*/.placetimeName),format.raw/*37.43*/("""</td>
                <td>"""),_display_(/*38.22*/booking/*38.29*/.coursename),format.raw/*38.40*/("""</td>
            </tr>
            """)))}),format.raw/*40.14*/("""
        """),format.raw/*41.9*/("""</table>
    </div>
</div>
</section>
""")))}),format.raw/*45.2*/("""

"""),format.raw/*47.1*/("""<!---->
"""))
      }
    }
  }

  def render(loginedUserInfo:String,timePeriodKeyword:String,bookings:List[Booking]): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,timePeriodKeyword,bookings)

  def f:((String,String,List[Booking]) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,timePeriodKeyword,bookings) => apply(loginedUserInfo,timePeriodKeyword,bookings)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:48 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/bookinglist.scala.html
                  HASH: 195c62c736257f0945aedd8cc4c74d1716ba0759
                  MATRIX: 756->1|923->73|951->76|995->112|1033->113|1063->117|1282->310|1318->338|1356->339|1398->353|1470->406|1483->410|1522->411|1559->421|1595->430|1610->436|1667->472|1716->490|1754->501|1800->538|1839->539|1881->553|1953->606|1966->610|2005->611|2047->625|2083->634|2098->640|2164->685|2213->703|2251->714|2294->748|2333->749|2375->763|2447->816|2460->820|2499->821|2541->835|2577->844|2592->850|2655->892|2704->910|2741->920|3006->1158|3046->1182|3086->1184|3128->1198|3182->1225|3198->1232|3229->1242|3284->1270|3300->1277|3326->1282|3381->1310|3397->1317|3425->1324|3480->1352|3496->1359|3531->1373|3586->1401|3602->1408|3634->1419|3704->1458|3741->1468|3814->1511|3845->1515
                  LINES: 21->1|26->1|27->2|27->2|27->2|29->4|34->9|34->9|34->9|35->10|36->11|36->11|36->11|37->12|37->12|37->12|37->12|38->13|39->14|39->14|39->14|40->15|41->16|41->16|41->16|42->17|42->17|42->17|42->17|43->18|44->19|44->19|44->19|45->20|46->21|46->21|46->21|47->22|47->22|47->22|47->22|48->23|49->24|57->32|57->32|57->32|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|65->40|66->41|70->45|72->47
                  -- GENERATED --
              */
          