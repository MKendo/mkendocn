
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
    <div class="container">
                <form id="home_appointment_form" name="home_appointment_form" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*7.146*/routes/*7.152*/.BookingController.createBooking()),format.raw/*7.186*/(""">
                        <div class="row">
                        <h3 class="mt-0 mb-20">请填写 <span class="text-theme-color-2">预约信息</span></h3>
                        <p>请先了解课程内容，选择适合自己的，购买之后填写预约信息即可。</p>
                        <div class="col-sm-12">
                            <h4 class="widget-title">一、明剑馆剑道入门初心课程</h4>
                            <ul>
                                <li class="clearfix"><b>价格：</b>￥58.00 </li>
                                <li class="clearfix"><b>课程目的：</b>完成初心课程的训练您对剑道会有一个整体的了解，并且可以判断剑道是否值得自己花费时间长期练习。</li>
                                <li class="clearfix"><b>课程内容：</b>剑道概况说明、剑道礼仪基础、剑道基本步法、剑道中段构型、基础打击方法、完整的打击流程。。</li>
                                <li class="clearfix"><b>注意事项：</b>剑道是有一项认真的运动，请带上最真实的自己。入门级初心课程没有剑道服和护具穿哦。</li>
                                <li class="clearfix"><b>购买连接：</b><a target="_blank" href="http://t.dianping.com/deal/610907216"><span class="text-theme-color-2">立即购买明剑馆剑道入门初心课程（￥58）</span></a></li>
                            </ul>
                            <br/>
                            <h4 class="widget-title">二、明剑馆剑道标准初心课程（有剑道服穿哦）</h4>
                            <ul class="list-border">
                                <li class="clearfix"><b>价格：</b>￥99.00 </li>
                                <li class="clearfix"><b>课程目的：</b>完成初心课程的训练您对剑道会有一个整体的了解，并且可以判断剑道是否值得自己花费时间长期练习。看看穿上剑道服的自己好看吗？</li>
                                <li class="clearfix"><b>课程内容：</b>剑道概况说明、穿剑道服、剑道礼仪基础、剑道基本步法、剑道中段构型、基础打击方法、完整的打击流程、拍照片、折叠剑道服。。</li>
                                <li class="clearfix"><b>注意事项：</b>剑道是有一项认真的运动，请带上最真实的自己。入门级初心课程没有剑道服和护具穿哦。</li>
                                <li class="clearfix"><b>购买连接：</b><a target="_blank" href="http://t.dianping.com/deal/610522899"><span class="text-theme-color-2">立即购买明剑馆剑道标准初心课程（￥99）</span></a></li>
                            </ul>
                            <br/>
                            <h4><i class="fa fa-phone"> 填表后欢迎加馆长微信确认报名（请至少提前一天哦）</i></h4>
                            <p>电话&微信：15889489370</p>
                            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                                <div class="funfact text-center">
                                    <img alt="" src=""""),_display_(/*34.55*/routes/*34.61*/.Assets.versioned("images/qrcode/wechat120.jpg")),format.raw/*34.109*/("""">
                                    <h4>加馆长微信</h4>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-3 mb-md-50">
                                <div class="funfact text-center">
                                    <img alt="" src=""""),_display_(/*40.55*/routes/*40.61*/.Assets.versioned("images/qrcode/mkendo120.jpg")),format.raw/*40.109*/("""">
                                    <h4>关注公众号</h4>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="col-sm-12">
                            <h4><i class="fa fa-book"> 购买成功之后请填写下列预约表格，剑道欢迎你！</i></h4>
                        </div>
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
                                        <option value="">已购买的体验课程是？</option>
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
                        <div class="form-group mb-0 mt-20">
                            <input name="form_botcheck" class="form-control" type="hidden" value="">
                            <button type="submit" class="btn btn-colored btn-theme-color-2 text-white btn-lg btn-block" data-loading-text="请稍候...">立即预约</button>
                        </div>
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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/bookingWidget.scala.html
                  HASH: 6da33d23c3e7511992b53c9e993359f9732583f3
                  MATRIX: 440->1|470->26|506->57|946->106|1181->314|1196->320|1251->354|3539->2615|3554->2621|3624->2669|3984->3002|3999->3008|4069->3056
                  LINES: 17->1|18->2|19->3|29->5|31->7|31->7|31->7|58->34|58->34|58->34|64->40|64->40|64->40
                  -- GENERATED --
              */
          