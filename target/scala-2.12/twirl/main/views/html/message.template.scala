
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

object message extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, content: String, loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.58*/("""
"""),_display_(/*2.2*/main("MESSAGE", loginedUserInfo,false)/*2.40*/{_display_(Seq[Any](format.raw/*2.41*/("""
"""),format.raw/*3.1*/("""<!--nav.innerheadernav("首页","/","信息提示")-->
<section>
    <div class="container">

        <!-- Textblock -->
        <div class="esc-heading heading-line-bottom lr-line left-heading">
            <h4>"""),_display_(/*9.18*/title),format.raw/*9.23*/("""</h4>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p>"""),_display_(/*13.21*/content),format.raw/*13.28*/("""</p>
                <!--
                <p>Lorem ipsum dolor sit amet, <span class="text-highlight">consectetur adipiscing</span> elit, sed do eiusmod tempor incididunt ut labore et aliqua. Ut enim ad <span class="text-highlight text-theme-colored">minim veniam</span> quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor <span class="text-highlight light">dolore magna</span> sit amet, consectetur adipiscing elit. Integer posuere erat a ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et aliqua. Ut <span class="text-highlight bg-theme-colored">enim ad minim veniam, quis</span> nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor dolore magna sit amet, consectetur adipiscing elit. Integer posuere erat a ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do <span class="text-highlight light">eiusmod</span> tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                -->
            </div>
        </div>

    </div>
</section>
""")))}),format.raw/*23.2*/("""
"""))
      }
    }
  }

  def render(title:String,content:String,loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(title,content,loginedUserInfo)

  def f:((String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (title,content,loginedUserInfo) => apply(title,content,loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/message.scala.html
                  HASH: fb53096928875552b02083b5434365a0941d7ffa
                  MATRIX: 745->1|896->57|924->60|970->98|1008->99|1036->101|1269->308|1294->313|1428->420|1456->427|2973->1914
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|34->9|34->9|38->13|38->13|48->23
                  -- GENERATED --
              */
          