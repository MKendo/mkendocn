
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

object productdesc extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Boolean,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(isSale: Boolean, name: String, starrating: String, price: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*2.1*/("""<div class="product">
    """),_display_(/*3.6*/if(isSale)/*3.16*/{_display_(Seq[Any](format.raw/*3.17*/("""
      """),format.raw/*4.7*/("""<span class="tag-sale">Sale!</span>
    """)))}),format.raw/*5.6*/("""
    """),format.raw/*6.5*/("""<div class="product-thumb">
        <img alt="" src="http://placehold.it/285x300" class="img-responsive img-fullwidth">
        <div class="overlay">
            <div class="btn-add-to-cart-wrapper">
                <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="#">加入购物车</a>
            </div>
            <div class="btn-product-view-details">
                <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="/product">查看详情</a>
            </div>
        </div>
    </div>
    <div class="product-details text-center">
        <a href="#"><h5 class="product-title">"""),_display_(/*18.48*/name),format.raw/*18.52*/("""</h5></a>
        <div class="star-rating" ><span style="width: """),_display_(/*19.56*/starrating),format.raw/*19.66*/(""";"></span></div>
        <div class="price"><del><span class="amount">$110.00</span></del><ins><span class="amount">￥"""),_display_(/*20.102*/price),format.raw/*20.107*/("""</span></ins></div>
    </div>
</div>"""))
      }
    }
  }

  def render(isSale:Boolean,name:String,starrating:String,price:String): play.twirl.api.HtmlFormat.Appendable = apply(isSale,name,starrating,price)

  def f:((Boolean,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (isSale,name,starrating,price) => apply(isSale,name,starrating,price)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/productdesc.scala.html
                  HASH: 56c2465315fd2803cc33805ca5562a9c4fe5ccc2
                  MATRIX: 765->1|926->67|954->69|1007->97|1025->107|1063->108|1097->116|1168->158|1200->164|1951->888|1976->892|2069->958|2100->968|2247->1087|2274->1092
                  LINES: 21->1|26->1|27->2|28->3|28->3|28->3|29->4|30->5|31->6|43->18|43->18|44->19|44->19|45->20|45->20
                  -- GENERATED --
              */
          