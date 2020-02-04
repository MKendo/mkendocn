
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

object quickcontact extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-4">
    <div class="clearfix">
        <h4 class="line-bottom">Quick Contact:</h4>
    </div>
    <form id="contact-form" class="contact-form-transparent">
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <input type="text" placeholder="Enter Name" id="contact_name" name="contact_name" required="" class="form-control">
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <input type="text" placeholder="Enter Email" id="contact_email" name="contact_email" class="form-control" required="">
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <input type="text" placeholder="Enter Subject" id="contact_subject" name="contact_subject" class="form-control" required="">
                </div>
            </div>
        </div>
        <div class="form-group">
            <textarea rows="5" placeholder="Enter Message" id="contact_message" name="contact_message" required class="form-control"></textarea>
        </div>
        <div class="form-group">
            <button data-loading-text="Please wait..." class="btn btn-flat btn-dark btn-theme-colored mt-5" type="submit">Send your message</button>
        </div>
    </form>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/quickcontact.scala.html
                  HASH: d5f45f57f722a04255ecebc7d1da13526b9655b4
                  MATRIX: 826->0
                  LINES: 26->1
                  -- GENERATED --
              */
          