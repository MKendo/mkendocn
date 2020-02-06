
package views.html.js

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

object summernotejs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<script>
  $(document).ready(function() """),format.raw/*2.32*/("""{"""),format.raw/*2.33*/("""
    """),format.raw/*3.5*/("""$('#summernote').summernote("""),format.raw/*3.33*/("""{"""),format.raw/*3.34*/("""
      """),format.raw/*4.7*/("""lang: 'zh-CN',
      height:500
    """),format.raw/*6.5*/("""}"""),format.raw/*6.6*/(""");
  """),format.raw/*7.3*/("""}"""),format.raw/*7.4*/(""");
</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:32 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/js/summernotejs.scala.html
                  HASH: 760101f9ceda74e3d56602b8e7c02570cdfb9f7c
                  MATRIX: 821->0|889->41|917->42|949->48|1004->76|1032->77|1066->85|1130->123|1157->124|1189->130|1216->131
                  LINES: 26->1|27->2|27->2|28->3|28->3|28->3|29->4|31->6|31->6|32->7|32->7
                  -- GENERATED --
              */
          