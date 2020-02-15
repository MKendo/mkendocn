
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

object memberdetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Member,List[MemberValidate],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(loginedUserInfo:String,member:Member,validataes:List[MemberValidate]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.72*/("""

"""),_display_(/*6.2*/main("会员详细信息", loginedUserInfo,true)/*6.38*/{_display_(Seq[Any](format.raw/*6.39*/("""
"""),format.raw/*7.1*/("""<section class="">
    <div class="container">
        <div class="section-content">
            <div class="col-md-12">
                <h3 class="mt-0 mb-20">明剑馆<span class="text-theme-color-2">会员详细信息</span></h3>
                <hr>
                <p>在这里可以修改会员信息，可以为会员续费、暂停等.</p>
                <form id="form_postnews" name="form_postnews" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*14.130*/routes/*14.136*/.NewsController.createNews()),format.raw/*14.164*/(""">

                    <div class="row">
                        <div class="col-sm-6">
                            <label for="form_name">姓名</label>
                            <input id="form_name" name="form_name" class="form-control" type="text" required="true" value=""""),_display_(/*19.125*/member/*19.131*/.name),format.raw/*19.136*/("""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_mobile">手机</label>
                            <input id="form_mobile" name="form_mobile" class="form-control" type="text" required="true" value=""""),_display_(/*23.129*/member/*23.135*/.mobile),format.raw/*23.142*/("""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_idtype">证件类型</label>
                            <input id="form_idtype" name="form_idtype" class="form-control" type="text" required="true" value=""""),_display_(/*27.129*/member/*27.135*/.idTypeName),format.raw/*27.146*/("""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_idnumber">证件号</label>
                            <input id="form_idnumber" name="form_idnumber" class="form-control" type="text" required="true" value=""""),_display_(/*31.133*/member/*31.139*/.idNumber),format.raw/*31.148*/("""">
                        </div>
                        <div class="col-sm-12">
                            <label for="form_feetype">费用类型</label>
                            <div class="form-group mb-20">
                                <div class="styled-select">
                                    <select id="form_feetype" name="form_feetype" class="form-control" required="true">
                                        <option value="">费用类型</option>
                                        <option value="FCPY6000" """),_display_(/*39.67*/if(member.feeTypeCode=="FCPY6000")/*39.101*/{_display_(Seq[Any](format.raw/*39.102*/("""selected""")))}),format.raw/*39.111*/(""">续费一年6000</option>
                                        <option value="FCPY4500" """),_display_(/*40.67*/if(member.feeTypeCode=="FCPY4500")/*40.101*/{_display_(Seq[Any](format.raw/*40.102*/("""selected""")))}),format.raw/*40.111*/(""">续费一年4500</option>
                                        <option value="FCPY3500" """),_display_(/*41.67*/if(member.feeTypeCode=="FCPY3500")/*41.101*/{_display_(Seq[Any](format.raw/*41.102*/("""selected""")))}),format.raw/*41.111*/(""">续费一年3500</option>
                                        <option value="FCPY3000" """),_display_(/*42.67*/if(member.feeTypeCode=="FCPY3000")/*42.101*/{_display_(Seq[Any](format.raw/*42.102*/("""selected""")))}),format.raw/*42.111*/(""">续费一年3000</option>
                                        <option value="FNPY10000" """),_display_(/*43.68*/if(member.feeTypeCode=="FNPY10000")/*43.103*/{_display_(Seq[Any](format.raw/*43.104*/("""selected""")))}),format.raw/*43.113*/(""">首次缴费一年10000</option>
                                        <option value="FNPY6500" """),_display_(/*44.67*/if(member.feeTypeCode=="FNPY6500")/*44.101*/{_display_(Seq[Any](format.raw/*44.102*/("""selected""")))}),format.raw/*44.111*/(""">首次缴费一年6500</option>
                                        <option value="FNHY4000" """),_display_(/*45.67*/if(member.feeTypeCode=="FNHY4000")/*45.101*/{_display_(Seq[Any](format.raw/*45.102*/("""selected""")))}),format.raw/*45.111*/(""">首次缴费半年4500</option>
                                        <option value="FCPYVIP0" """),_display_(/*46.67*/if(member.feeTypeCode=="FCPYVIP0")/*46.101*/{_display_(Seq[Any](format.raw/*46.102*/("""selected""")))}),format.raw/*46.111*/(""">VIP免费</option>
                                        <option value="FTOTHER" """),_display_(/*47.66*/if(member.feeTypeCode=="FTOTHER")/*47.99*/{_display_(Seq[Any](format.raw/*47.100*/("""selected""")))}),format.raw/*47.109*/(""">其它优惠类型</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <label for="form_startvalidate">最新有效期 从</label>
                                <input id="form_startvalidate" name="form_startvalidate" class="form-control required date-picker" type="text" placeholder="开始日期" required="true" value=""""),_display_(/*55.187*/member/*55.193*/.startValidate),format.raw/*55.207*/("""">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <label for="form_endvalidate">到</label>
                                <input id="form_endvalidate" name="form_endvalidate" class="form-control required date-picker" type="text" placeholder="结束日期" required="true" value=""""),_display_(/*62.183*/member/*62.189*/.endValidate),format.raw/*62.201*/("""">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                    </div>
                </form>
                <h4>缴费明细</h4>
                <button type="button" class="btn btn-primary text-white" data-toggle="modal" data-target=".bs-example-modal-lg">续费</button>
                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <form id="form_postvalidate" name="form_postvalidate" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*73.150*/routes/*73.156*/.MemberController.memberPayment(member.idNumber)),format.raw/*73.204*/(""">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel2"><span class="text-theme-color-2">续费</span></h4>
                                    """),_display_(/*77.38*/if(validataes.nonEmpty)/*77.61*/{_display_(Seq[Any](format.raw/*77.62*/("""
                                      """),format.raw/*78.39*/("""<p>上次续费情况："""),_display_(/*78.50*/validataes(0)/*78.63*/.commitDatetime),format.raw/*78.78*/(""" """),_display_(/*78.80*/validataes(0)/*78.93*/.description),format.raw/*78.105*/(""" """),format.raw/*78.106*/("""金额：￥+"""),_display_(/*78.112*/validataes(0)/*78.125*/.amount),format.raw/*78.132*/(""" """),format.raw/*78.133*/("""有效期："""),_display_(/*78.138*/validataes(0)/*78.151*/.startValidate),format.raw/*78.165*/(""" """),format.raw/*78.166*/("""-- """),_display_(/*78.170*/validataes(0)/*78.183*/.endValidate),format.raw/*78.195*/(""" """),format.raw/*78.196*/("""</p>
                                    """)))}),format.raw/*79.38*/("""
                                """),format.raw/*80.33*/("""</div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group mb-10">
                                                <label for="form_dstartvalidate">最新有效期 从</label>
                                                <input id="form_dstartvalidate" name="form_dstartvalidate" class="form-control required date-picker" type="text" placeholder="开始日期" required="true">
                                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group mb-10">
                                                <label for="form_dendvalidate">到</label>
                                                <input id="form_dendvalidate" name="form_dendvalidate" class="form-control required date-picker" type="text" placeholder="结束日期" required="true">
                                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="form_dfeetype">费用类型</label>
                                            <div class="form-group mb-20">
                                                <div class="styled-select">
                                                    <select id="form_dfeetype" name="form_dfeetype" class="form-control" required="true">
                                                        <option value="">费用类型</option>
                                                        <option value="FCPY6000" """),_display_(/*105.83*/if(member.feeTypeCode=="FCPY6000")/*105.117*/{_display_(Seq[Any](format.raw/*105.118*/("""selected""")))}),format.raw/*105.127*/(""">续费一年6000</option>
                                                        <option value="FCPY4500" """),_display_(/*106.83*/if(member.feeTypeCode=="FCPY4500")/*106.117*/{_display_(Seq[Any](format.raw/*106.118*/("""selected""")))}),format.raw/*106.127*/(""">续费一年4500</option>
                                                        <option value="FCPY3500" """),_display_(/*107.83*/if(member.feeTypeCode=="FCPY3500")/*107.117*/{_display_(Seq[Any](format.raw/*107.118*/("""selected""")))}),format.raw/*107.127*/(""">续费一年3500</option>
                                                        <option value="FCPY3000" """),_display_(/*108.83*/if(member.feeTypeCode=="FCPY3000")/*108.117*/{_display_(Seq[Any](format.raw/*108.118*/("""selected""")))}),format.raw/*108.127*/(""">续费一年3000</option>
                                                        <option value="FNPY10000" """),_display_(/*109.84*/if(member.feeTypeCode=="FNPY10000")/*109.119*/{_display_(Seq[Any](format.raw/*109.120*/("""selected""")))}),format.raw/*109.129*/(""">首次缴费一年10000</option>
                                                        <option value="FNPY6500" """),_display_(/*110.83*/if(member.feeTypeCode=="FNPY6500")/*110.117*/{_display_(Seq[Any](format.raw/*110.118*/("""selected""")))}),format.raw/*110.127*/(""">首次缴费一年6500</option>
                                                        <option value="FNHY4000" """),_display_(/*111.83*/if(member.feeTypeCode=="FNHY4000")/*111.117*/{_display_(Seq[Any](format.raw/*111.118*/("""selected""")))}),format.raw/*111.127*/(""">首次缴费半年4500</option>
                                                        <option value="FCPYVIP0" """),_display_(/*112.83*/if(member.feeTypeCode=="FCPYVIP0")/*112.117*/{_display_(Seq[Any](format.raw/*112.118*/("""selected""")))}),format.raw/*112.127*/(""">VIP免费</option>
                                                        <option value="FTOTHER" """),_display_(/*113.82*/if(member.feeTypeCode=="FTOTHER")/*113.115*/{_display_(Seq[Any](format.raw/*113.116*/("""selected""")))}),format.raw/*113.125*/(""">其它优惠类型</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="form_damount">金额</label>
                                            <input id="form_damount" name="form_damount" class="form-control" type="text" required="true">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <label for="form_ddesc">描述</label>
                                            <textarea id="form_ddesc" name="form_ddesc" class="form-control" rows="3" required="true"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary text-white" id="form_submit" name="form_submit">保存</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <hr/>
                <table class="table table-striped">
                    <tr>
                        <td>续费时间</td>
                        <td>有效期从</td>
                        <td>到</td>
                        <td>缴费信息</td>
                        <td>缴费金额</td>
                    </tr>
                    """),_display_(/*148.22*/for(validate <- validataes) yield /*148.49*/ {_display_(Seq[Any](format.raw/*148.51*/("""
                    """),format.raw/*149.21*/("""<tr>
                        <td>"""),_display_(/*150.30*/validate/*150.38*/.commitDatetime),format.raw/*150.53*/("""</td>
                        <td>"""),_display_(/*151.30*/validate/*151.38*/.startValidate),format.raw/*151.52*/("""</td>
                        <td>"""),_display_(/*152.30*/validate/*152.38*/.endValidate),format.raw/*152.50*/("""</td>
                        <td>"""),_display_(/*153.30*/validate/*153.38*/.description),format.raw/*153.50*/("""</td>
                        <td>"""),_display_(/*154.30*/validate/*154.38*/.amount),format.raw/*154.45*/("""</td>
                    </tr>
                    """)))}),format.raw/*156.22*/("""
                """),format.raw/*157.17*/("""</table>


            </div>
        </div>
    </div>
</section>

""")))}))
      }
    }
  }

  def render(loginedUserInfo:String,member:Member,validataes:List[MemberValidate]): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,member,validataes)

  def f:((String,Member,List[MemberValidate]) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,member,validataes) => apply(loginedUserInfo,member,validataes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Feb 15 12:06:42 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/memberdetail.scala.html
                  HASH: 9c61d02f4ab8bd3cd69d2dd7e1e5d920257e9d0b
                  MATRIX: 432->1|462->26|498->57|883->105|1048->175|1078->180|1122->216|1160->217|1188->219|1636->639|1652->645|1702->673|2009->952|2025->958|2052->963|2357->1240|2373->1246|2402->1253|2709->1532|2725->1538|2758->1549|3070->1833|3086->1839|3117->1848|3677->2381|3721->2415|3761->2416|3802->2425|3915->2511|3959->2545|3999->2546|4040->2555|4153->2641|4197->2675|4237->2676|4278->2685|4391->2771|4435->2805|4475->2806|4516->2815|4630->2902|4675->2937|4715->2938|4756->2947|4872->3036|4916->3070|4956->3071|4997->3080|5112->3168|5156->3202|5196->3203|5237->3212|5352->3300|5396->3334|5436->3335|5477->3344|5586->3426|5628->3459|5668->3460|5709->3469|6285->4017|6301->4023|6337->4037|6926->4598|6942->4604|6976->4616|7812->5424|7828->5430|7898->5478|8315->5868|8347->5891|8386->5892|8454->5932|8492->5943|8514->5956|8550->5971|8579->5973|8601->5986|8635->5998|8665->5999|8699->6005|8722->6018|8751->6025|8781->6026|8814->6031|8837->6044|8873->6058|8903->6059|8935->6063|8958->6076|8992->6088|9022->6089|9096->6132|9158->6166|11361->8341|11406->8375|11447->8376|11489->8385|11619->8487|11664->8521|11705->8522|11747->8531|11877->8633|11922->8667|11963->8668|12005->8677|12135->8779|12180->8813|12221->8814|12263->8823|12394->8926|12440->8961|12481->8962|12523->8971|12656->9076|12701->9110|12742->9111|12784->9120|12916->9224|12961->9258|13002->9259|13044->9268|13176->9372|13221->9406|13262->9407|13304->9416|13430->9514|13474->9547|13515->9548|13557->9557|15502->11474|15546->11501|15587->11503|15638->11525|15701->11560|15719->11568|15756->11583|15820->11619|15838->11627|15874->11641|15938->11677|15956->11685|15990->11697|16054->11733|16072->11741|16106->11753|16170->11789|16188->11797|16217->11804|16304->11859|16351->11877
                  LINES: 17->1|18->2|19->3|24->4|29->4|31->6|31->6|31->6|32->7|39->14|39->14|39->14|44->19|44->19|44->19|48->23|48->23|48->23|52->27|52->27|52->27|56->31|56->31|56->31|64->39|64->39|64->39|64->39|65->40|65->40|65->40|65->40|66->41|66->41|66->41|66->41|67->42|67->42|67->42|67->42|68->43|68->43|68->43|68->43|69->44|69->44|69->44|69->44|70->45|70->45|70->45|70->45|71->46|71->46|71->46|71->46|72->47|72->47|72->47|72->47|80->55|80->55|80->55|87->62|87->62|87->62|98->73|98->73|98->73|102->77|102->77|102->77|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|103->78|104->79|105->80|130->105|130->105|130->105|130->105|131->106|131->106|131->106|131->106|132->107|132->107|132->107|132->107|133->108|133->108|133->108|133->108|134->109|134->109|134->109|134->109|135->110|135->110|135->110|135->110|136->111|136->111|136->111|136->111|137->112|137->112|137->112|137->112|138->113|138->113|138->113|138->113|173->148|173->148|173->148|174->149|175->150|175->150|175->150|176->151|176->151|176->151|177->152|177->152|177->152|178->153|178->153|178->153|179->154|179->154|179->154|181->156|182->157
                  -- GENERATED --
              */
          