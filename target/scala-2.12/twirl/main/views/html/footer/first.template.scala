
package views.html.footer

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

object first extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.2*/("""<!-- Footer -->
  <footer id="footer" class="footer" data-bg-color="#1f1f1f">
    <div class="container pt-70 pb-40">
      <div class="row">
        <div class="col-md-6 col-md-offset-3 text-center">
          <img src="images/logo-white-footer.png" alt="">
          <p class="font-12 mt-20 mb-20">剑道是籍由有形与无形的剑理，去完善人格的一种约束性炼习。剑道锻炼我们更加的专注、冷静、理智、果断、温和、有责任心。剑道用她自身魅力带我们逐渐认识自己了解他人。</p>
          <ul class="styled-icons flat medium list-inline mb-40">
		    <li><img src=""""),_display_(/*9.22*/routes/*9.28*/.Assets.versioned("images/mkendologo_200_fan.png")),format.raw/*9.78*/("""" alt=""></li>
		  </ul>
		  <!--
		  <ul class="styled-icons flat medium list-inline mb-40">
            <li><a href="#"><i class="fa fa-facebook"></i></a> </li>
            <li><a href="#"><i class="fa fa-twitter"></i></a> </li>
            <li><a href="#"><i class="fa fa-pinterest"></i></a> </li>
            <li><a href="#"><i class="fa fa-google-plus"></i></a> </li>
            <li><a href="#"><i class="fa fa-youtube"></i></a> </li>
          </ul>
		  -->
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-md-3">
          <div class="widget dark">
            <h4 class="widget-title line-bottom-theme-colored-2">联络我们</h4>
            <div class="opening-hours">
              <ul class="list-border">
                <li class="clearfix"> <span>中国深圳</span>
                  <div class="value pull-right">明剑馆</div>
                </li>
                <li class="clearfix"> <span>电话: </span>
                  <div class="value pull-right">13128855200</div>
                </li>
                <li class="clearfix"> <span>电邮: </span>
                  <div class="value pull-right">46561847@qq.com</div>
                </li>
                <li class="clearfix"> <span>微信公众号: </span>
                  <div class="value pull-right">Openkendo</div>
                </li>
                <li class="clearfix"> <span>馆长微信: </span>
                  <div class="value pull-right">15889489370</div>
                </li>
                <li class="clearfix"> <span>馆长QQ: </span>
                  <div class="value pull-right">46561847</div>
                </li>
                <li class="clearfix"> <span>深圳剑道新人入门咨询QQ群: </span>
                  <div class="value pull-right">38814129</div>
                </li>
                <li class="clearfix"> <span>地址: </span>
                  <div class="value pull-right">福田保税区红棉道4号智立方创新园3楼 明剑馆</div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3">
          <div class="widget dark">
            <h4 class="widget-title line-bottom-theme-colored-2">福保道场</h4>
            <h5 class="widget-title line-bottom-theme-colored-2">道场地址：</h5>
            <div class="opening-hours">
              <ul class="list-border">
                <li class="clearfix"> <span></span>
                  <div class="value pull-right">福田保税区红棉道4号智立方创新园3楼 明剑馆</div>
                </li>
              </ul>
            </div>
            <h5 class="widget-title line-bottom-theme-colored-2">练习时间：</h5>
            <div class="opening-hours">
              <ul class="list-border">
                <li class="clearfix"> <span>周一三五晚 新人练习:  </span>
                  <div class="value pull-right">19:30 - 21.30</div>
                </li>
                <li class="clearfix"> <span>周二四晚 进阶练习:  </span>
                  <div class="value pull-right">19:30 - 21.30</div>
                </li>
                <li class="clearfix"> <span>周六上午 比赛练习：</span>
                  <div class="value pull-right">9:30 - 12:30 </div>
                </li>
                <li class="clearfix"> <span>周六下午 少儿班: </span>
                  <div class="value pull-right">14:00 - 16.00</div>
                </li>
                <li class="clearfix"> <span>周六下午 新人练习: </span>
                  <div class="value pull-right">16:30 - 18:30 </div>
                </li>
                <li class="clearfix"> <span>周日上午 进阶练习:</span>
                  <div class="value pull-right">9:30 - 12:30 </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3">
          <div class="widget dark">
            <h4 class="widget-title line-bottom-theme-colored-2">白石洲道场</h4>
            <h5 class="widget-title line-bottom-theme-colored-2">道场地址：</h5>
            <div class="opening-hours">
              <ul class="list-border">
                <li class="clearfix"> <span></span>
                  <div class="value pull-right">南山白石洲世纪村小区会所4楼 U乐街舞培训中心 大教室</div>
                </li>
              </ul>
            </div>
            <h5 class="widget-title line-bottom-theme-colored-2">练习时间：</h5>
            <div class="opening-hours">
              <ul class="list-border">
                <li class="clearfix"> <span>周二晚 综合练习:  </span>
                  <div class="value pull-right">20:00 - 22.00</div>
                </li>
                <li class="clearfix"> <span>周四晚 综合练习:  </span>
                  <div class="value pull-right">20:00 - 22.00</div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3">
          <div class="widget dark">
            <h5 class="widget-title">关键字</h5>
            <div class="tags">
              <a href="#">剑道</a>
              <a href="#">教育</a>
              <a href="#">课程</a>
              <a href="#">深圳</a>
              <a href="#">学习剑道</a>
              <a href="#">专业剑道场</a>
              <a href="#">深圳</a>
              <a href="#">深圳福田</a>
              <a href="#">深圳南山</a>
              <a href="#">剑道用品</a>
              <a href="#">会员商店</a>
              <a href="#">剑道周边</a>
              <a href="#">日本老师</a>
              <a href="#">剑道是什么</a>
              <a href="#">明剑</a>
			  <a href="#">明剑馆</a>
			  <a href="#">锻炼</a>
			  <a href="#">专注</a>
			  <a href="#">冷静</a>
			  <a href="#">责任</a>
			  <a href="#">挑战</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-bottom" data-bg-color="#2f2f2f">
      <div class="container pt-15 pb-10">
        <div class="row">
          <div class="col-md-6">
            <p class="font-11 text-black-777 m-0">版权所有 &copy;2019 -深圳市剑友剑道俱乐部明剑馆. </p>
          </div>
          <div class="col-md-6 text-right">
            <div class="font-11 text-black-777 m-0"><a href="http://www.miitbeian.gov.cn" target="_blank">备案号：粤ICP备17117703号-1</a>
			<!-- widget no-border m-0 -->
			<!--
              <ul class="list-inline sm-text-center mt-5 font-12">
                <li>
                  <a href="#">FAQ</a>
                </li>
                <li>|</li>
                <li>
                  <a href="#">Help Desk</a>
                </li>
                <li>|</li>
                <li>
                  <a href="#">Support</a>
                </li>
              </ul>
			  -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 04 16:32:13 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/footer/first.scala.html
                  HASH: 4b567d77d423e624d946e27585ce8661a6713531
                  MATRIX: 818->1|1323->480|1337->486|1407->536
                  LINES: 26->1|34->9|34->9|34->9
                  -- GENERATED --
              */
          