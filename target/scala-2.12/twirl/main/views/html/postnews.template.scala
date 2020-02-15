
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

"""),_display_(/*6.2*/main("POSTNEWS", loginedUserInfo,true)/*6.40*/{_display_(Seq[Any](format.raw/*6.41*/("""
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
                                <input id="form_datetime" name="form_datetime" class="form-control required date-picker" type="text" placeholder="事件发生日期" required="true">
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

                                """),format.raw/*48.33*/("""let summer = $('#summernote');

                                summer.summernote("""),format.raw/*50.51*/("""{"""),format.raw/*50.52*/("""
                                  """),format.raw/*51.35*/("""lang: 'zh-CN',
                                  height:500,
                                  callbacks: """),format.raw/*53.46*/("""{"""),format.raw/*53.47*/("""
                                        """),format.raw/*54.41*/("""onImageUpload: function (files) """),format.raw/*54.73*/("""{"""),format.raw/*54.74*/("""
                                            """),format.raw/*55.45*/("""sendFile(files);
                                        """),format.raw/*56.41*/("""}"""),format.raw/*56.42*/("""
                                    """),format.raw/*57.37*/("""}"""),format.raw/*57.38*/("""
                                """),format.raw/*58.33*/("""}"""),format.raw/*58.34*/(""");

                                // summernote.blur
                                summer.on('summernote.blur', function() """),format.raw/*61.73*/("""{"""),format.raw/*61.74*/("""
                                  """),format.raw/*62.35*/("""htmlcontent = $('#summernote').summernote('code');
                                  document.getElementById("article_content").value = htmlcontent;
                                """),format.raw/*64.33*/("""}"""),format.raw/*64.34*/(""");

                                /** * 发送图片文件给服务器端 */
                                function sendFile(files) """),format.raw/*67.58*/("""{"""),format.raw/*67.59*/("""
                                    """),format.raw/*68.37*/("""let imageData = new FormData();
                                    imageData.append("imageData", files[0]);
                                    $.ajax("""),format.raw/*70.44*/("""{"""),format.raw/*70.45*/("""
                                        """),format.raw/*71.41*/("""url: '/summer/upload', // 图片上传url
                                        type: 'POST',
                                        data: imageData,
                                        cache: false,
                                        contentType: false,
                                        processData: false,
                                        dataType: 'json',     // 以json的形式接收返回的数据
                                        // 图片上传成功
                                        success: function ($result) """),format.raw/*79.69*/("""{"""),format.raw/*79.70*/("""
                                            """),format.raw/*80.45*/("""let imgNode = document.createElement("img");
                                            imgNode.src = $result.img;
                                            summer.summernote('insertNode', imgNode);
                                        """),format.raw/*83.41*/("""}"""),format.raw/*83.42*/(""",
                                        // 图片上传失败
                                        error: function () """),format.raw/*85.60*/("""{"""),format.raw/*85.61*/("""
                                            """),format.raw/*86.45*/("""console.log('图片上传失败');
                                        """),format.raw/*87.41*/("""}"""),format.raw/*87.42*/("""
                                    """),format.raw/*88.37*/("""}"""),format.raw/*88.38*/(""");
                                 """),format.raw/*89.34*/("""}"""),format.raw/*89.35*/("""

                              """),format.raw/*91.31*/("""}"""),format.raw/*91.32*/(""");


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
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/postnews.scala.html
                  HASH: 62e159f236dc80e2c3a772e2865c177269bc6603
                  MATRIX: 432->1|462->26|498->57|851->105|970->129|1000->134|1046->172|1084->173|1112->175|1550->585|1566->591|1616->619|3383->2359|3396->2363|3435->2381|3493->2411|3872->2762|3901->2763|3965->2799|4077->2883|4106->2884|4170->2920|4306->3028|4335->3029|4405->3071|4465->3103|4494->3104|4568->3150|4654->3208|4683->3209|4749->3247|4778->3248|4840->3282|4869->3283|5027->3413|5056->3414|5120->3450|5331->3633|5360->3634|5505->3751|5534->3752|5600->3790|5782->3944|5811->3945|5881->3987|6435->4513|6464->4514|6538->4560|6811->4805|6840->4806|6981->4919|7010->4920|7084->4966|7176->5030|7205->5031|7271->5069|7300->5070|7365->5107|7394->5108|7456->5142|7485->5143
                  LINES: 17->1|18->2|19->3|24->4|29->4|31->6|31->6|31->6|32->7|40->15|40->15|40->15|66->41|66->41|66->41|67->42|71->46|71->46|73->48|75->50|75->50|76->51|78->53|78->53|79->54|79->54|79->54|80->55|81->56|81->56|82->57|82->57|83->58|83->58|86->61|86->61|87->62|89->64|89->64|92->67|92->67|93->68|95->70|95->70|96->71|104->79|104->79|105->80|108->83|108->83|110->85|110->85|111->86|112->87|112->87|113->88|113->88|114->89|114->89|116->91|116->91
                  -- GENERATED --
              */
          