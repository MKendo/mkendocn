
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

object calltoaction_0 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Divider: Call To Action -->
<section class="bg-theme-color-2">
    <div class="container pt-10 pb-20">
        <div class="row">
            <div class="call-to-action">
                <div class="col-md-6">
                    <h3 class="mt-5 mb-5 text-white vertical-align-middle"><i class="pe-7s-mail mr-10 font-48 vertical-align-middle"></i> SUBSCRIBE TO OUR NEWSLETTER</h3>
                </div>
                <div class="col-md-6">
                    <!-- Mailchimp Subscription Form Starts Here -->
                    <form id="mailchimp-subscription-form" class="newsletter-form mt-10">
                        <div class="input-group">
                            <input type="email" value="" name="EMAIL" placeholder="Your Email" class="form-control input-lg font-16" data-height="45px" id="mce-EMAIL-footer">
                            <span class="input-group-btn">
                    <button data-height="45px" class="btn bg-theme-colored text-white btn-xs m-0 font-14" type="submit">Subscribe</button>
                  </span>
                        </div>
                    </form>
                    <!-- Mailchimp Subscription Form Validation-->
                    <script type="text/javascript">
                $('#mailchimp-subscription-form').ajaxChimp("""),format.raw/*21.61*/("""{"""),format.raw/*21.62*/("""
                    """),format.raw/*22.21*/("""callback: mailChimpCallBack,
                    url: '//thememascot.us9.list-manage.com/subscribe/post?u=a01f440178e35febc8cf4e51f&amp;id=49d6d30e1e'
                """),format.raw/*24.17*/("""}"""),format.raw/*24.18*/(""");

                function mailChimpCallBack(resp) """),format.raw/*26.50*/("""{"""),format.raw/*26.51*/("""
                    """),format.raw/*27.21*/("""// Hide any previous response text
                    var $mailchimpform = $('#mailchimp-subscription-form'),
                        $response = '';
                    $mailchimpform.children(".alert").remove();
                    if (resp.result === 'success') """),format.raw/*31.52*/("""{"""),format.raw/*31.53*/("""
                        """),format.raw/*32.25*/("""$response = '<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + resp.msg + '</div>';
                    """),format.raw/*33.21*/("""}"""),format.raw/*33.22*/(""" """),format.raw/*33.23*/("""else if (resp.result === 'error') """),format.raw/*33.57*/("""{"""),format.raw/*33.58*/("""
                        """),format.raw/*34.25*/("""$response = '<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + resp.msg + '</div>';
                    """),format.raw/*35.21*/("""}"""),format.raw/*35.22*/("""
                    """),format.raw/*36.21*/("""$mailchimpform.prepend($response);
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/("""
              """),format.raw/*38.15*/("""</script>
                    <!-- Mailchimp Subscription Form Ends Here -->
                </div>
            </div>
        </div>
    </div>
</section>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:33 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/calltoaction_0.scala.html
                  HASH: 495c7bcfef9746867005193b74147fb6fe74bcbd
                  MATRIX: 828->0|2169->1313|2198->1314|2248->1336|2445->1505|2474->1506|2557->1561|2586->1562|2636->1584|2934->1854|2963->1855|3017->1881|3261->2097|3290->2098|3319->2099|3381->2133|3410->2134|3464->2160|3707->2375|3736->2376|3786->2398|3866->2450|3895->2451|3939->2467
                  LINES: 26->1|46->21|46->21|47->22|49->24|49->24|51->26|51->26|52->27|56->31|56->31|57->32|58->33|58->33|58->33|58->33|58->33|59->34|60->35|60->35|61->36|62->37|62->37|63->38
                  -- GENERATED --
              */
          