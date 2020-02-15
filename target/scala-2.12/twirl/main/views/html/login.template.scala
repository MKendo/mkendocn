
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""
"""),_display_(/*2.2*/main("深圳剑道 明剑馆 登录", loginedUserInfo,false)/*2.44*/{_display_(Seq[Any](format.raw/*2.45*/("""
"""),format.raw/*3.1*/("""<!-- nav.innerheadernav("明剑会员账号","/","登录") -->


    <section>
      <div class="container">

        """),_display_(/*9.10*/if(loginedUserInfo.nonEmpty)/*9.38*/ {_display_(Seq[Any](format.raw/*9.40*/("""
        """),format.raw/*10.9*/("""<div class="esc-heading heading-line-bottom lr-line left-heading">
          <h4>亲爱的 """),_display_(/*11.20*/loginedUserInfo/*11.35*/.substring(12)),format.raw/*11.49*/(""" """),format.raw/*11.50*/("""：</h4>
        </div>
        <div class="row">
          <div class="col-md-12">
            <p>您已登录，从这里可以 <a href="/logout">退出</a></p>
          </div>
        </div>
        """)))}/*18.10*/else/*18.14*/{_display_(Seq[Any](format.raw/*18.15*/("""

        """),format.raw/*20.9*/("""<div class="row">
          <div class="col-md-6 col-md-push-3">
            <h4 class="text-gray mt-0 pt-5">会员登录</h4>
            <hr>
            <p>登录后您可以进行更多的操作，拥有更多会员权益.</p>
            <form name="login-form" class="clearfix" method="post" action="""),_display_(/*25.76*/routes/*25.82*/.LoginController.login()),format.raw/*25.106*/(""">
              <div class="row">
                <div class="form-group col-md-12">
                  <label for="form_username_mobile">手机号</label>
                  <input id="form_username_mobile" name="form_username_mobile" class="form-control" type="text">
                </div>
              </div>
              <div class="row">
                <div class="form-group col-md-12">
                  <label for="form_password">密码</label>
                  <input id="form_password" name="form_password" class="form-control" type="password">
                </div>
              </div>
              <!--
              <div class="checkbox pull-left mt-15">
                <label for="form_checkbox">
                  <input id="form_checkbox" name="form_checkbox" type="checkbox">
                  记住我的账号</label>
              </div>
              -->
              <div class="form-group pull-right mt-10">
                <button type="submit" class="btn btn-dark btn-sm">登录</button>
              </div>
              <!--
              <div class="clear text-center pt-10">
                <a class="text-theme-colored font-weight-600 font-12" href="#">忘记密码?</a>
              </div>
              <div class="clear text-center pt-10">
                <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="#" data-bg-color="#3b5998">通过微信登录</a>
                <a class="btn btn-dark btn-lg btn-block no-border" href="#" data-bg-color="#00acee">通过支付宝登录</a>
              </div>
              -->
            </form>
          </div>
        </div>

        """)))}),format.raw/*61.10*/("""
      """),format.raw/*62.7*/("""</div>
    </section>
""")))}))
      }
    }
  }

  def render(loginedUserInfo:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo) => apply(loginedUserInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/login.scala.html
                  HASH: 6293d08af6c5a4f21e9c3d4b5584fc22c5f019a9
                  MATRIX: 729->1|848->25|876->28|926->70|964->71|992->73|1127->182|1163->210|1202->212|1239->222|1353->309|1377->324|1412->338|1441->339|1645->524|1658->528|1697->529|1736->541|2022->800|2037->806|2083->830|3736->2452|3771->2460
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|34->9|34->9|34->9|35->10|36->11|36->11|36->11|36->11|43->18|43->18|43->18|45->20|50->25|50->25|50->25|86->61|87->62
                  -- GENERATED --
              */
          