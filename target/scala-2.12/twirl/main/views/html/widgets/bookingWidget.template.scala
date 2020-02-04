
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
/*1.2*/import play.api.data._
/*2.2*/import play.api.data.Forms._
/*3.2*/import play.api.data.validation.Constraints._

object bookingWidget extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""<!-- Appointment Form Starts -->
<section class="">
    <div class="container">
        <div class="section-content">
            <div class="col-md-12">
                <form id="home_appointment_form" name="home_appointment_form" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*10.146*/routes/*10.152*/.BookingController.createBooking()),format.raw/*10.186*/(""">
                    <h3 class="mt-0 mb-20">请填写 <span class="text-theme-color-2">预约信息</span></h3>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group mb-10">
                                <input name="name" class="form-control required" type="text" placeholder="真实姓名" required="true" aria-required="true">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <input name="mobile" class="form-control required" type="text" placeholder="联系手机" required="true" aria-required="true">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <input name="wechat" class="form-control required" type="text" placeholder="微信号(不填默认为同手机号)" required="true" aria-required="false">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-20">
                                <div class="styled-select">
                                    <select id="placetime" name="placetime" class="form-control" required="true">
                                        <option value="">请选择练习场次</option>
                                        <option value="FT01PM">福田道场 周一晚19:30--21:30</option>
                                        <option value="FT03PM">福田道场 周三晚19:30--21:30</option>
                                        <option value="FT05PM">福田道场 周五晚19:30--21:30</option>
                                        <option value="FT06PM">福田道场少儿剑道 周六下午 14:00--16:00</option>
                                        <option value="FT06PM2">福田道场 周六下午 16:00--18:00</option>
                                        <option value="NS02PM">南山道场 周二晚20:00--22:00</option>
                                        <option value="NS04PM">南山道场 周四晚20:00--22:00</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <input name="classdate" class="form-control required date-picker" type="text" placeholder="上课日期" required="true" aria-required="true">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="form-group mb-20">
                                <div class="styled-select">
                                    <select id="coursename" name="coursename" class="form-control" required="true">
                                        <option value="">选择体验课程</option>
                                        <option value="剑道入门初心课程58元">剑道入门初心课程58元</option>
                                        <option value="剑道标准初心课程99元（有剑道服）">剑道标准初心课程99元（有剑道服）</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="form-group mb-20">
                                <div class="styled-select">
                                    <select id="whereknowus" name="whereknowus" class="form-control" required="true">
                                        <option value="">从哪里知道我们的?</option>
                                        <option value="DZMT">大众美团看到哒</option>
                                        <option value="NETSEARCH">网上搜到哒</option>
                                        <option value="FRIEND">好朋友告诉我哒</option>
                                        <option value="MOMENTS">朋友圈看到哒</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mb-0 mt-20">
                        <input name="form_botcheck" class="form-control" type="hidden" value="">
                        <button type="submit" class="btn btn-colored btn-theme-color-2 text-white btn-lg btn-block" data-loading-text="请稍候...">立即预约</button>
                    </div>
                </form>
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
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/bookingWidget.scala.html
                  HASH: 573fe8368056566e512ba550eaf84ecc2305d11a
                  MATRIX: 440->1|470->26|506->57|946->106|1278->410|1294->416|1350->450
                  LINES: 17->1|18->2|19->3|29->5|34->10|34->10|34->10
                  -- GENERATED --
              */
          