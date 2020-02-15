
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

object aboutdojo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[String,String,String,String,String,List[List[String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(dojoname: String, description: String, address: String, phone: String, email: String, courses: List[List[String]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.117*/("""

        """),format.raw/*3.9*/("""<h4 class="line-bottom">"""),_display_(/*3.34*/dojoname),format.raw/*3.42*/("""</h4>
        <div class="volunteer-address">
            <ul>
                <li>
                    <div class="bg-light media border-bottom p-15 mb-20">
                        <div class="media-left">
                            <i class="pe-7s-pen text-theme-colored font-24 mt-5"></i>
                        </div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-0">道场介绍</h5>
                            <p>"""),_display_(/*13.33*/description),format.raw/*13.44*/("""</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="bg-light media border-bottom p-15 mb-20">
                        <div class="media-left">
                            <i class="fa fa-map-marker text-theme-colored font-24 mt-5"></i>
                        </div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-0">地址:</h5>
                            <p>"""),_display_(/*24.33*/address),format.raw/*24.40*/("""</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="bg-light media border-bottom p-15">
                        <div class="media-left">
                            <i class="fa fa-phone text-theme-colored font-24 mt-5"></i>
                        </div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-0">联系方式:</h5>
                            <p><span>Phone:</span>"""),_display_(/*35.52*/phone),format.raw/*35.57*/("""<br><span>Email:</span> """),_display_(/*35.82*/email),format.raw/*35.87*/("""</p>
                        </div>
                    </div>
                </li>
				<li>
                    <div class="bg-light media border-bottom p-15">
                        <div class="media-left">
                            <i class="fa fa-book text-theme-colored font-24 mt-5"></i>
                        </div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-0">课程设置:</h5>
							<p>
							"""),_display_(/*47.9*/for(course <- courses) yield /*47.31*/ {_display_(Seq[Any](format.raw/*47.33*/("""
                                """),format.raw/*48.33*/("""<span>"""),_display_(/*48.40*/course(0)),format.raw/*48.49*/(""":</span>"""),_display_(/*48.58*/course(1)),format.raw/*48.67*/("""<br>
							""")))}),format.raw/*49.9*/("""
							"""),format.raw/*50.8*/("""</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>"""))
      }
    }
  }

  def render(dojoname:String,description:String,address:String,phone:String,email:String,courses:List[List[String]]): play.twirl.api.HtmlFormat.Appendable = apply(dojoname,description,address,phone,email,courses)

  def f:((String,String,String,String,String,List[List[String]]) => play.twirl.api.HtmlFormat.Appendable) = (dojoname,description,address,phone,email,courses) => apply(dojoname,description,address,phone,email,courses)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/aboutdojo.scala.html
                  HASH: 201cd4c1c409ac51168acb071cfc9485044d48e9
                  MATRIX: 788->1|999->116|1037->128|1088->153|1116->161|1618->636|1650->647|2181->1151|2209->1158|2750->1672|2776->1677|2828->1702|2854->1707|3350->2177|3388->2199|3428->2201|3490->2235|3524->2242|3554->2251|3590->2260|3620->2269|3664->2283|3700->2292
                  LINES: 21->1|26->1|28->3|28->3|28->3|38->13|38->13|49->24|49->24|60->35|60->35|60->35|60->35|72->47|72->47|72->47|73->48|73->48|73->48|73->48|73->48|74->49|75->50
                  -- GENERATED --
              */
          