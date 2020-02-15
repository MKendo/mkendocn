
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

object tipwithimg extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, description: String, nexttip: String, imgurl: String, detailurl: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*2.1*/("""<div class="col-xs-12 col-sm-6 col-md-3 pb-sm-20">
    <div class="image-box-thum">
        <img class="img-fullwidth" alt="" src=""""),_display_(/*4.49*/imgurl),format.raw/*4.55*/("""">
    </div>
    <div class="image-box-details pt-20 pb-sm-20">
        <h4 class="title text-uppercase line-bottom mt-0">"""),_display_(/*7.60*/title),format.raw/*7.65*/("""</h4>
        <p class="desc mb-10">"""),_display_(/*8.32*/description),format.raw/*8.43*/("""</p>
        <a href=""""),_display_(/*9.19*/detailurl),format.raw/*9.28*/("""" target="_blank" class="btn btn-xs btn-theme-colored">"""),_display_(/*9.84*/nexttip),format.raw/*9.91*/("""</a>
    </div>
</div>"""))
      }
    }
  }

  def render(title:String,description:String,nexttip:String,imgurl:String,detailurl:String): play.twirl.api.HtmlFormat.Appendable = apply(title,description,nexttip,imgurl,detailurl)

  def f:((String,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (title,description,nexttip,imgurl,detailurl) => apply(title,description,nexttip,imgurl,detailurl)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/tipwithimg.scala.html
                  HASH: 148af40ffcfb4c7f94d4e2f4cd1d78ae17e0c126
                  MATRIX: 770->1|953->89|981->91|1141->225|1167->231|1320->358|1345->363|1409->401|1440->412|1490->436|1519->445|1601->501|1628->508
                  LINES: 21->1|26->1|27->2|29->4|29->4|32->7|32->7|33->8|33->8|34->9|34->9|34->9|34->9
                  -- GENERATED --
              */
          