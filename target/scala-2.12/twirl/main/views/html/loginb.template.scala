
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

object loginb extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>

<!-- Meta Tags -->
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<meta name="description" content="StudyPress | Education & Courses HTML Template" />
<meta name="keywords" content="academy, course, education, education html theme, elearning, learning," />
<meta name="author" content="ThemeMascot" />

<!-- Page Title -->
<title>StudyPress | Education & Courses HTML Template</title>

"""),_display_(/*15.2*/head/*15.6*/.touchicons()),format.raw/*15.19*/("""

"""),_display_(/*17.2*/head/*17.6*/.commoncss()),format.raw/*17.18*/("""

"""),_display_(/*19.2*/head/*19.6*/.menuskins()),format.raw/*19.18*/("""
"""),_display_(/*20.2*/head/*20.6*/.maincss()),format.raw/*20.16*/("""
"""),_display_(/*21.2*/head/*21.6*/.exjs()),format.raw/*21.13*/("""
"""),format.raw/*22.1*/("""</head>
<body class="">
<div id="wrapper" class="clearfix">
"""),_display_(/*25.2*/widgets/*25.9*/.preloader()),format.raw/*25.21*/("""
  
  """),format.raw/*27.3*/("""<!-- start main-content -->
  <div class="main-content"> 
    <!-- Section: home -->
    <section id="home" class="divider parallax fullscreen layer-overlay overlay-white-9" data-bg-img="http://placehold.it/1920x1280">
      <div class="display-table">
        <div class="display-table-cell">
          <div class="container">
            <div class="row">
              <div class="col-md-6 col-md-push-3">
                <div class="text-center mb-60"><a href="#" class=""><img alt="" src=""""),_display_(/*36.87*/routes/*36.93*/.Assets.versioned("images/logo-wide.png")),format.raw/*36.134*/(""""></a></div>
                <h4 class="text-theme-colored mt-0 pt-5"> Login</h4>
                <p>Lorem ipsum dolor sit amet, consectetur elit.</p>
                <form name="login-form" class="form-transparent clearfix">
                  <div class="row">
                    <div class="form-group col-md-12">
                      <label for="form_username_email">Username/Email</label>
                      <input id="form_username_email" name="form_username_email" class="form-control" type="text">
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-md-12">
                      <label for="form_password">Password</label>
                      <input id="form_password" name="form_password" class="form-control" type="text">
                    </div>
                  </div>
                  <div class="checkbox pull-left mt-15">
                    <label for="form_checkbox">
                      <input id="form_checkbox" name="form_checkbox" type="checkbox">
                      Remember me </label>
                  </div>
                  <div class="form-group pull-right mt-10">
                    <button type="submit" class="btn btn-dark btn-sm">Login</button>
                  </div>
                  <div class="clear text-center pt-10">
                    <a class="text-theme-colored font-weight-600 font-12" href="#">Forgot Your Password?</a>
                  </div>
                  <div class="clear text-center pt-10">
                    <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="#" data-bg-color="#3b5998">Login with facebook</a>
                    <a class="btn btn-dark btn-lg btn-block no-border" href="#" data-bg-color="#00acee">Login with twitter</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
	  </div>
    </section>
  </div>
  <!-- end main-content --> 

<!-- Footer -->
  <footer id="footer" class="footer text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="mb-0">Copyright ©2016 KodeSolution. All Rights Reserved</p>
        </div>
      </div>
    </div>
  </footer>
  <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- end wrapper -->

<!-- Footer Scripts -->
"""),_display_(/*93.2*/js/*93.4*/.customjs()),format.raw/*93.15*/("""
"""),format.raw/*94.1*/("""</body>
</html>"""))
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
                  SOURCE: D:/products/mkendocn/app/views/loginb.scala.html
                  HASH: 1e640f1a2af1301ab3828851a4e04e537fc277cc
                  MATRIX: 812->0|1383->545|1395->549|1429->562|1460->567|1472->571|1505->583|1536->588|1548->592|1581->604|1610->607|1622->611|1653->621|1682->624|1694->628|1722->635|1751->637|1841->701|1856->708|1889->720|1924->728|2455->1232|2470->1238|2533->1279|5034->3754|5044->3756|5076->3767|5105->3769
                  LINES: 26->1|40->15|40->15|40->15|42->17|42->17|42->17|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|47->22|50->25|50->25|50->25|52->27|61->36|61->36|61->36|118->93|118->93|118->93|119->94
                  -- GENERATED --
              */
          