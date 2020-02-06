
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

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(searchType: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""<div class="widget">
    <h5 class="widget-title line-bottom">搜索 <span class="text-theme-color-2">"""),_display_(/*3.79*/if(searchType=="NEWS")/*3.101*/{_display_(Seq[Any](format.raw/*3.102*/("""新闻""")))}),format.raw/*3.105*/("""</span></h5>
    <div class="search-form">
        <form id="form_search" name="form_search" method="post" action="""),_display_(/*5.73*/routes/*5.79*/.SearchController.search(searchType)),format.raw/*5.115*/(""">
            <div class="input-group">
                <input type="text" placeholder="请输入要搜索的内容" class="form-control search-input" id="searchtext" name="searchtext">
                <span class="input-group-btn">
                      <button type="submit" class="btn search-button"><i class="fa fa-search"></i></button>
                </span>
            </div>
        </form>
    </div>
</div>"""))
      }
    }
  }

  def render(searchType:String): play.twirl.api.HtmlFormat.Appendable = apply(searchType)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (searchType) => apply(searchType)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:34 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/search.scala.html
                  HASH: b401bfaa85c2471d7d273ff4918d4a093a93162a
                  MATRIX: 738->1|853->21|881->23|1007->123|1038->145|1077->146|1111->149|1254->266|1268->272|1325->308
                  LINES: 21->1|26->1|27->2|28->3|28->3|28->3|28->3|30->5|30->5|30->5
                  -- GENERATED --
              */
          