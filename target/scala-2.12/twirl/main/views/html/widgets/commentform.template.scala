
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

object commentform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="comment-box">
    <div class="row">
        <div class="col-sm-12">
            <h5>Leave a Comment</h5>
            <div class="row">
                <form role="form" id="comment-form">
                    <div class="col-sm-6 pt-0 pb-0">
                        <div class="form-group">
                            <input type="text" class="form-control" required name="contact_name" id="contact_name" placeholder="Enter Name">
                        </div>
                        <div class="form-group">
                            <input type="text" required class="form-control" name="contact_email2" id="contact_email2" placeholder="Enter Email">
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="Enter Website" required class="form-control" name="subject">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <textarea class="form-control" required name="contact_message2" id="contact_message2"  placeholder="Enter Message" rows="7"></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-dark btn-flat pull-right m-0" data-loading-text="Please wait...">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/commentform.scala.html
                  HASH: 8c81c4eb7d5a1b8256d33654b1e32cbedc095af6
                  MATRIX: 825->0
                  LINES: 26->1
                  -- GENERATED --
              */
          