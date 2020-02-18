
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

object memberlist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,List[Member],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String,timePeriodKeyword:String,members:List[Member]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.72*/("""
"""),_display_(/*2.2*/main("MEMBERS",loginedUserInfo,true)/*2.38*/{_display_(Seq[Any](format.raw/*2.39*/("""

"""),format.raw/*4.1*/("""<section>
    <div class="container">
        <div class="row">
            <h3 class="mt-0 mb-20">明剑馆<span class="text-theme-color-2">会员信息</span></h3>
            <i class="fa fa-search"></i>
            """),_display_(/*9.14*/if(timePeriodKeyword=="ALL")/*9.42*/{_display_(Seq[Any](format.raw/*9.43*/("""
            """),format.raw/*10.13*/("""<span class="text-theme-color-2">全部</span>
            """)))}/*11.14*/else/*11.18*/{_display_(Seq[Any](format.raw/*11.19*/("""
            """),format.raw/*12.13*/("""<a href="""),_display_(/*12.22*/routes/*12.28*/.MkendoController.memberlist("ALL")),format.raw/*12.63*/(""">全部</a>
            """)))}),format.raw/*13.14*/("""
            """),_display_(/*14.14*/if(timePeriodKeyword=="CURRENT_MONTH")/*14.52*/{_display_(Seq[Any](format.raw/*14.53*/("""
            """),format.raw/*15.13*/("""<span class="text-theme-color-2">本月到期</span>
            """)))}/*16.14*/else/*16.18*/{_display_(Seq[Any](format.raw/*16.19*/("""
            """),format.raw/*17.13*/("""<a href="""),_display_(/*17.22*/routes/*17.28*/.MkendoController.memberlist("CURRENT_MONTH")),format.raw/*17.73*/(""">本月到期</a>
            """)))}),format.raw/*18.14*/("""
            """),_display_(/*19.14*/if(timePeriodKeyword=="NEXT_MONTY")/*19.49*/{_display_(Seq[Any](format.raw/*19.50*/("""
            """),format.raw/*20.13*/("""<span class="text-theme-color-2">下月到期</span>
            """)))}/*21.14*/else/*21.18*/{_display_(Seq[Any](format.raw/*21.19*/("""
            """),format.raw/*22.13*/("""<a href="""),_display_(/*22.22*/routes/*22.28*/.MkendoController.memberlist("NEXT_MONTY")),format.raw/*22.70*/(""">下月到期</a>
            """)))}),format.raw/*23.14*/("""
            """),format.raw/*24.13*/("""<table class="table table-striped">
                <tr>
                    <td>姓名</td>
                    <td>手机号</td>
                    <td>费用标准</td>
                    <td>开始日期</td>
                    <td>结束日期</td>
                    <td>明细</td>
                </tr>
                """),_display_(/*33.18*/for(member <- members) yield /*33.40*/ {_display_(Seq[Any](format.raw/*33.42*/("""
                """),format.raw/*34.17*/("""<tr>
                    <td>"""),_display_(/*35.26*/member/*35.32*/.name),format.raw/*35.37*/("""</td>
                    <td>"""),_display_(/*36.26*/member/*36.32*/.mobile),format.raw/*36.39*/("""</td>
                    <td>"""),_display_(/*37.26*/member/*37.32*/.feeTypeName),format.raw/*37.44*/("""</td>
                    <td>"""),_display_(/*38.26*/member/*38.32*/.startValidate),format.raw/*38.46*/("""</td>
                    <td>"""),_display_(/*39.26*/member/*39.32*/.endValidate),format.raw/*39.44*/("""</td>
                    <td><a href="/memberdetail/:"""),_display_(/*40.50*/member/*40.56*/.id),format.raw/*40.59*/("""">查看明细</a></td>
                </tr>
                """)))}),format.raw/*42.18*/("""
            """),format.raw/*43.13*/("""</table>
        </div>
    </div>
</section>
""")))}),format.raw/*47.2*/("""

"""))
      }
    }
  }

  def render(loginedUserInfo:String,timePeriodKeyword:String,members:List[Member]): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,timePeriodKeyword,members)

  def f:((String,String,List[Member]) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,timePeriodKeyword,members) => apply(loginedUserInfo,timePeriodKeyword,members)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 18 13:20:24 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/memberlist.scala.html
                  HASH: 83dad9b9c5588e0fb86405ab756613a9c0f8e4c2
                  MATRIX: 754->1|919->71|947->74|991->110|1029->111|1059->115|1296->326|1332->354|1370->355|1412->369|1488->426|1501->430|1540->431|1582->445|1618->454|1633->460|1689->495|1742->517|1784->532|1831->570|1870->571|1912->585|1990->644|2003->648|2042->649|2084->663|2120->672|2135->678|2201->723|2256->747|2298->762|2342->797|2381->798|2423->812|2501->871|2514->875|2553->876|2595->890|2631->899|2646->905|2709->947|2764->971|2806->985|3137->1289|3175->1311|3215->1313|3261->1331|3319->1362|3334->1368|3360->1373|3419->1405|3434->1411|3462->1418|3521->1450|3536->1456|3569->1468|3628->1500|3643->1506|3678->1520|3737->1552|3752->1558|3785->1570|3868->1626|3883->1632|3907->1635|3995->1692|4037->1706|4118->1757
                  LINES: 21->1|26->1|27->2|27->2|27->2|29->4|34->9|34->9|34->9|35->10|36->11|36->11|36->11|37->12|37->12|37->12|37->12|38->13|39->14|39->14|39->14|40->15|41->16|41->16|41->16|42->17|42->17|42->17|42->17|43->18|44->19|44->19|44->19|45->20|46->21|46->21|46->21|47->22|47->22|47->22|47->22|48->23|49->24|58->33|58->33|58->33|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|67->42|68->43|72->47
                  -- GENERATED --
              */
          