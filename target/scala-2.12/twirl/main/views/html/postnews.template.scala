
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
/*1.2*/import play.api.data._
/*2.2*/import play.api.data.Forms._
/*3.2*/import play.api.data.validation.Constraints._

object postnews extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(loginedUserInfo:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.26*/("""

"""),_display_(/*6.2*/main("深圳剑道 明剑馆 发布新闻", loginedUserInfo,true)/*6.45*/{_display_(Seq[Any](format.raw/*6.46*/("""
"""),format.raw/*7.1*/("""<section class="">
    <div class="container">
        <div class="section-content">
            <div class="col-md-12">

                <h3 class="mt-0 mb-20">发布新闻</h3>
                    <hr>
                    <p>在这里可以发布新闻或活动通知.</p>
                    <form id="form_postnews" name="form_postnews" class="booking-form form-home bg-white p-30" enctype="multipart/form-data" method="post" action="""),_display_(/*15.164*/routes/*15.170*/.NewsController.createNews()),format.raw/*15.198*/(""">
                    <div class="row">
                        <div class="col-sm-10">
                            <label for="form_title">标题</label>
                            <input id="form_title" name="form_title" class="form-control" type="text" required="true">
                        </div>
                        <div class="col-sm-2">
                            <label for="form_author">作者</label>
                            <input id="form_author" name="form_author" class="form-control" type="text" required="true">
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <label for="form_datetime">日期</label>
                                <input id="form_datetime" name="form_datetime" class="form-control required date-picker" type="text" placeholder="上课日期" required="true">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="form_address">地点</label>
                            <input id="form_address" name="form_address" class="form-control" type="text" required="true">
                        </div>
                        <div class="col-sm-12">
                            <label for="form_desc">摘要</label>
                            <textarea id="form_desc" name="form_desc" class="form-control" rows="3" required="true"></textarea>
                        </div>
                        <div class="col-sm-12">
                            """),_display_(/*41.30*/head/*41.34*/.summernotecssjs()),format.raw/*41.52*/("""
                            """),format.raw/*42.29*/("""<label for="summernote">内容</label>
                            <div id="summernote" name="summernote" required="true"><p></p></div>
                            <input type="hidden" id="article_content" name="article_content" value="" required="true">
                            <script>
                              $(document).ready(function() """),format.raw/*46.60*/("""{"""),format.raw/*46.61*/("""
                                """),format.raw/*47.33*/("""$('#summernote').summernote("""),format.raw/*47.61*/("""{"""),format.raw/*47.62*/("""
                                  """),format.raw/*48.35*/("""lang: 'zh-CN',
                                  height:500
                                """),format.raw/*50.33*/("""}"""),format.raw/*50.34*/(""");

                                // summernote.blur
                                $('#summernote').on('summernote.blur', function() """),format.raw/*53.83*/("""{"""),format.raw/*53.84*/("""
                                  """),format.raw/*54.35*/("""htmlcontent = $('#summernote').summernote('code');
                                  document.getElementById("article_content").value = htmlcontent;
                                """),format.raw/*56.33*/("""}"""),format.raw/*56.34*/(""");

                              """),format.raw/*58.31*/("""}"""),format.raw/*58.32*/(""");
                            </script>
                        </div>
                        <div class="col-sm-12">
                            <div class="form-group mb-10">
                                <label for="form_imagefile">请为新闻选择一张主图</label>
                                <input type="file" id="form_imagefile" name="form_imagefile" required="true">
                                <p class="help-block"></p>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mb-0 mt-20">
                        <input name="form_botcheck" class="form-control" type="hidden" value="">
                        <button type="submit" id="form_submit" name="form_submit" class="btn btn-colored btn-theme-color-2 text-white btn-lg btn-block" data-loading-text="请稍候...">立即发布</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
                  DATE: Tue Feb 04 16:32:14 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/postnews.scala.html
                  HASH: 3f368f61dfac4a82cf25720de9a1546317eb7bbe
                  MATRIX: 432->1|462->26|498->57|851->105|970->129|1000->134|1051->177|1089->178|1117->180|1555->590|1571->596|1621->624|3386->2362|3399->2366|3438->2384|3496->2414|3875->2765|3904->2766|3966->2800|4022->2828|4051->2829|4115->2865|4237->2959|4266->2960|4434->3100|4463->3101|4527->3137|4738->3320|4767->3321|4831->3357|4860->3358
                  LINES: 17->1|18->2|19->3|24->4|29->4|31->6|31->6|31->6|32->7|40->15|40->15|40->15|66->41|66->41|66->41|67->42|71->46|71->46|72->47|72->47|72->47|73->48|75->50|75->50|78->53|78->53|79->54|81->56|81->56|83->58|83->58
                  -- GENERATED --
              */
          