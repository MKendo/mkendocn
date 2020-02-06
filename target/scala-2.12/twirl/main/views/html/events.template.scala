
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

object events extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 活动报名", loginedUserInfo,false)/*2.46*/{_display_(Seq[Any](format.raw/*2.47*/("""
"""),_display_(/*3.2*/nav/*3.5*/.innerheadernav("首页","/","活动报名")),format.raw/*3.37*/("""
"""),format.raw/*4.1*/("""<!-- Section: Event List -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-9 blog-pull-right">
                <div class="upcoming-events bg-white-f3 mb-20">
                    <div class="row">
                        <div class="col-sm-4 pr-0 pr-sm-15">
                            <div class="thumb p-15">
                                <img class="img-fullwidth" src="https://placehold.it/220x160" alt="...">
                            </div>
                        </div>
                        <div class="col-sm-4 pl-0 pl-sm-15">
                            <div class="event-details p-15 mt-20">
                                <h4 class="media-heading text-uppercase font-weight-500">明剑馆2019年5月考级报名</h4>
                                <p>明剑馆2到8级考试目的，意在帮助大家建立具体的剑道阶段性修习目标，能够顺利度过剑道的入门阶段，打好坚实的基础。。新同学就可以从8级开始报名了。</p>
                                <a href="#" class="btn btn-flat btn-dark btn-theme-colored btn-sm">我要报名 <i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="event-count p-15 mt-15">
                                <ul class="event-date list-inline font-16 text-uppercase mt-10 mb-20">
                                    <li class="p-15 bg-lightest">2019</li>
                                    <li class="p-15 mr-5 bg-lightest">5</li>
                                    <li class="p-15 pl-20 pr-20 mr-5 bg-lightest"> 31</li>
                                </ul>
                                <ul>
                                    <li class="mb-10 text-theme-colored"><i class="fa fa-clock-o mr-5"></i>考级时间：14.00 - 18.30</li>
                                    <li class="text-theme-colored"><i class="fa fa-map-marker mr-5"></i>福田保税区道场</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="upcoming-events bg-white-f3 mb-20">
                    <div class="row">
                        <div class="col-sm-4 pr-0 pr-sm-15">
                            <div class="thumb p-15">
                                <img class="img-fullwidth" src="https://placehold.it/220x160" alt="...">
                            </div>
                        </div>
                        <div class="col-sm-4 pl-0 pl-sm-15">
                            <div class="event-details p-15 mt-20">
                                <h4 class="media-heading text-uppercase font-weight-500">明剑馆2019年4月考级报名</h4>
                                <p>明剑馆2到8级考试目的，意在帮助大家建立具体的剑道阶段性修习目标，能够顺利度过剑道的入门阶段，打好坚实的基础。。新同学就可以从8级开始报名了。</p>
                                <a href="#" class="btn btn-flat btn-dark btn-theme-colored btn-sm">我要报名 <i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="event-count p-15 mt-15">
                                <ul class="event-date list-inline font-16 text-uppercase mt-10 mb-20">
                                    <li class="p-15 bg-lightest">2019</li>
                                    <li class="p-15 mr-5 bg-lightest">4</li>
                                    <li class="p-15 pl-20 pr-20 mr-5 bg-lightest"> 31</li>
                                </ul>
                                <ul>
                                    <li class="mb-10 text-theme-colored"><i class="fa fa-clock-o mr-5"></i>考级时间：14.00 - 18.30</li>
                                    <li class="text-theme-colored"><i class="fa fa-map-marker mr-5"></i>福田保税区道场</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="upcoming-events bg-white-f3 mb-20">
                    <div class="row">
                        <div class="col-sm-4 pr-0 pr-sm-15">
                            <div class="thumb p-15">
                                <img class="img-fullwidth" src="https://placehold.it/220x160" alt="...">
                            </div>
                        </div>
                        <div class="col-sm-4 pl-0 pl-sm-15">
                            <div class="event-details p-15 mt-20">
                                <h4 class="media-heading text-uppercase font-weight-500">2019三星杯开始报名了</h4>
                                <p>三星杯，个人赛，香港，只有一天时间，非常适合不想住宿的剑友。</p>
                                <a href="#" class="btn btn-flat btn-dark btn-theme-colored btn-sm">我要报名 <i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="event-count p-15 mt-15">
                                <ul class="event-date list-inline font-16 text-uppercase mt-10 mb-20">
                                    <li class="p-15 bg-lightest">2019</li>
                                    <li class="p-15 mr-5 bg-lightest">3</li>
                                    <li class="p-15 pl-20 pr-20 mr-5 bg-lightest">10</li>
                                </ul>
                                <ul>
                                    <li class="mb-10 text-theme-colored"><i class="fa fa-clock-o mr-5"></i>比赛时间：8.30 - 18.30</li>
                                    <li class="text-theme-colored"><i class="fa fa-map-marker mr-5"></i>香港体育公园</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="upcoming-events bg-white-f3 mb-20">
                    <div class="row">
                        <div class="col-sm-4 pr-0 pr-sm-15">
                            <div class="thumb p-15">
                                <img class="img-fullwidth" src="https://placehold.it/220x160" alt="...">
                            </div>
                        </div>
                        <div class="col-sm-4 pl-0 pl-sm-15">
                            <div class="event-details p-15 mt-20">
                                <h4 class="media-heading text-uppercase font-weight-500">广州赛开始报名了</h4>
                                <p>在广州的比赛，又名华南剑道公开赛，第一届，很多人哦，已经上了护具的新同学要积极参加啊。.</p>
                                <a href="#" class="btn btn-flat btn-dark btn-theme-colored btn-sm">我要报名 <i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="event-count p-15 mt-15">
                                <ul class="event-date list-inline font-16 text-uppercase mt-10 mb-20">
                                    <li class="p-15 bg-lightest">2019</li>
                                    <li class="p-15 mr-5 bg-lightest">5</li>
                                    <li class="p-15 pl-20 pr-20 mr-5 bg-lightest">15</li>
                                </ul>
                                <ul>
                                    <li class="mb-10 text-theme-colored"><i class="fa fa-clock-o mr-5"></i>比赛时间 ：9.00 pm - 18.00</li>
                                    <li class="text-theme-colored"><i class="fa fa-map-marker mr-5"></i>广州越秀区全民健身体育馆</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <nav>
                            <ul class="pagination theme-colored pull-right xs-pull-center mb-xs-40">
                                <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">«</span> </a> </li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">...</a></li>
                                <li> <a href="#" aria-label="Next"> <span aria-hidden="true">»</span> </a> </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="sidebar sidebar-left mt-sm-30">
                    <div class="widget">
                        <h5 class="widget-title line-bottom">已完成的活动</h5>
                        <ul class="list list-divider list-border">
                            <li><a href="#"><i class="fa fa-check-square-o mr-10 text-black-light"></i>2019年1月考级</a></li>
                            <li><a href="#"><i class="fa fa-check-square-o mr-10 text-black-light"></i>2019年亚洲赛报名</a></li>
                            <li><a href="#"><i class="fa fa-check-square-o mr-10 text-black-light"></i>2019年2月考级</a></li>
                            <li><a href="#"><i class="fa fa-check-square-o mr-10 text-black-light"></i>2019年大中华报名</a></li>
                            <li><a href="#"><i class="fa fa-check-square-o mr-10 text-black-light"></i>2019年3月考级</a></li>
                        </ul>
                    </div>
                    <div class="widget">
                        <h5 class="widget-title line-bottom">活动照片</h5>
                        <div class="widget-image-carousel">
                            <div class="item">
                                <img src="https://placehold.it/365x230" alt="">
                                <h4 class="title">考级开始！</h4>
                                <p>认真擦地的小朋友。。</p>
                            </div>
                            <div class="item">
                                <img src="https://placehold.it/365x230" alt="">
                                <h4 class="title">三星杯成绩喜人</h4>
                                <p>恭喜冠军小朋友，冠军小师妹</p>
                            </div>
                            <div class="item">
                                <img src="https://placehold.it/365x230" alt="">
                                <h4 class="title">广州赛的大奖杯</h4>
                                <p>奖杯墙上又多了一个金光灿灿！</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
""")))}),format.raw/*179.2*/("""

"""))
      }
    }
  }

  def render(loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo) => apply(loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 05 19:16:31 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/events.scala.html
                  HASH: f763a3cd3382f333dce236e5b629e6d127a9934a
                  MATRIX: 730->1|849->25|877->28|929->72|967->73|995->76|1005->79|1057->111|1085->113|11932->10929
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|28->3|28->3|29->4|204->179
                  -- GENERATED --
              */
          