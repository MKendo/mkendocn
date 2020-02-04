
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[Article],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo: String,newslist: List[Article]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("HOMEPAGE",loginedUserInfo,false)/*2.40*/{_display_(Seq[Any](format.raw/*2.41*/("""
	"""),format.raw/*3.2*/("""<!-- Revolution Slider 5.x CSS settings -->
	"""),_display_(/*4.3*/head/*4.7*/.revolutionslider5css()),format.raw/*4.30*/("""
	"""),format.raw/*5.2*/("""<!-- JS | jquery plugin collection for this theme -->
	"""),_display_(/*6.3*/js/*6.5*/.jqueryplugincollectionjs()),format.raw/*6.32*/("""
	"""),format.raw/*7.2*/("""<!-- Revolution Slider 5.x SCRIPTS -->
	"""),_display_(/*8.3*/js/*8.5*/.revolutionslider5js()),format.raw/*8.27*/("""

		"""),format.raw/*10.3*/("""<!-- Section: home @widgets.home() 巨大的轮播广告 暂时屏蔽-->
		<!-- Section: About -->
		"""),_display_(/*12.4*/widgets/*12.11*/.aboutimportant()),format.raw/*12.28*/("""	
        """),format.raw/*13.9*/("""<!-- widgets.calltoaction()	-->	
		<!-- widgets.aboutdetail() -->
		<!-- Divider: Funfact -->
		"""),_display_(/*16.4*/widgets/*16.11*/.dividerqrcode()),format.raw/*16.27*/("""
		
		"""),format.raw/*18.3*/("""<!-- Section: Why Choose Us -->
		<section id="event" class="">
			<div class="container pb-50">
				<div class="section-content">
					<div class="row">
						<div class="col-md-6">"""),_display_(/*23.30*/widgets/*23.37*/.lastnews(loginedUserInfo,newslist)),format.raw/*23.72*/("""</div>
						<div class="col-md-6">"""),_display_(/*24.30*/widgets/*24.37*/.whychooseus()),format.raw/*24.51*/("""</div>
					</div>
				</div>
			</div>
		</section>   
	
		<!-- Section: Gallery 
		widgets.gallery()  -->
		<!-- Section: COURSES
		widgets.ourcourses() -->
		<!-- end main-content -->

    """),_display_(/*36.6*/js/*36.8*/.sliderrevolution5extensions()),format.raw/*36.38*/("""
""")))}),format.raw/*37.2*/("""
"""))
      }
    }
  }

  def render(loginedUserInfo:String,newslist:List[Article]): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,newslist)

  def f:((String,List[Article]) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,newslist) => apply(loginedUserInfo,newslist)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:13 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/index.scala.html
                  HASH: 56ffc2713b0ae53d8eb40302a06e8bf67bf8ef6c
                  MATRIX: 743->1|886->52|932->90|970->91|998->93|1069->139|1080->143|1123->166|1151->168|1232->224|1241->226|1288->253|1316->255|1382->296|1391->298|1433->320|1464->324|1570->405|1586->412|1624->429|1661->439|1784->536|1800->543|1837->559|1870->565|2080->748|2096->755|2152->790|2215->826|2231->833|2266->847|2485->1040|2495->1042|2546->1072|2578->1074
                  LINES: 21->1|26->2|26->2|26->2|27->3|28->4|28->4|28->4|29->5|30->6|30->6|30->6|31->7|32->8|32->8|32->8|34->10|36->12|36->12|36->12|37->13|40->16|40->16|40->16|42->18|47->23|47->23|47->23|48->24|48->24|48->24|60->36|60->36|60->36|61->37
                  -- GENERATED --
              */
          