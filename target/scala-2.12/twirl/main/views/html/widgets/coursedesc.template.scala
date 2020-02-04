
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

object coursedesc extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, description: String, price: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.53*/("""
"""),format.raw/*2.1*/("""<div class="col-sm-6 col-md-4">
    <div class="service-block bg-white">
        <div class="thumb"> <img alt="featured project" src="http://placehold.it/265x195" class="img-fullwidth">
            <h4 class="text-white mt-0 mb-0"><span class="price">￥"""),_display_(/*5.68*/price),format.raw/*5.73*/("""</span></h4>
        </div>
        <div class="content text-left flip p-25 pt-0">
            <h4 class="line-bottom mb-10">"""),_display_(/*8.44*/title),format.raw/*8.49*/("""</h4>
            <p>"""),_display_(/*9.17*/description),format.raw/*9.28*/("""</p>
            <a class="btn btn-dark btn-theme-colored btn-sm text-uppercase mt-10" href="page-courses-accounting-technologies.html">了解更多</a>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(title:String,description:String,price:String): play.twirl.api.HtmlFormat.Appendable = apply(title,description,price)

  def f:((String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (title,description,price) => apply(title,description,price)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/coursedesc.scala.html
                  HASH: 6e40351a9c8e21adbc6b57d291a4316a59d08038
                  MATRIX: 756->1|902->52|930->54|1212->310|1237->315|1392->444|1417->449|1466->472|1497->483
                  LINES: 21->1|26->1|27->2|30->5|30->5|33->8|33->8|34->9|34->9
                  -- GENERATED --
              */
          