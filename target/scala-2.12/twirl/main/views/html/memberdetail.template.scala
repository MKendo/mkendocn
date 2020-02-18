
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

object memberdetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,Member,List[MemberValidate],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(loginedUserInfo:String,member:Member,validataes:List[MemberValidate],message:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.87*/("""

"""),_display_(/*6.2*/main("会员详细信息", loginedUserInfo,true)/*6.38*/{_display_(Seq[Any](format.raw/*6.39*/("""
"""),format.raw/*7.1*/("""<section class="">
    <div class="container">
        <div class="section-content">
            <div class="col-md-12">
                <h3 class="mt-0 mb-20">明剑馆<span class="text-theme-color-2">会员详细信息</span></h3>
                <hr>
                """),_display_(/*13.18*/if(!message.isEmpty())/*13.40*/{_display_(Seq[Any](format.raw/*13.41*/("""
                  """),format.raw/*14.19*/("""<div class="alert alert-success" role="alert">"""),_display_(/*14.66*/message),format.raw/*14.73*/("""</div>
                """)))}),format.raw/*15.18*/("""
                """),format.raw/*16.17*/("""<form id="form_postmember" name="form_postmember" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*16.134*/routes/*16.140*/.MemberController.createOrUpdateMember(""+member.id)),format.raw/*16.192*/(""">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="form_name">姓名</label>
                            <input id="form_name" name="form_name" class="form-control" type="text" required="true" value=""""),_display_(/*20.125*/if(member!=null)/*20.141*/{_display_(_display_(/*20.143*/member/*20.149*/.name))}),format.raw/*20.155*/("""" """),_display_(/*20.158*/if(member.enable==0)/*20.178*/{_display_(Seq[Any](format.raw/*20.179*/("""disabled="disabled"""")))}),format.raw/*20.199*/(""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_mobile">手机</label>
                            <input id="form_mobile" name="form_mobile" class="form-control" type="text" required="true" value=""""),_display_(/*24.129*/if(member!=null)/*24.145*/{_display_(_display_(/*24.147*/member/*24.153*/.mobile))}),format.raw/*24.161*/("""" """),_display_(/*24.164*/if(member.enable==0)/*24.184*/{_display_(Seq[Any](format.raw/*24.185*/("""disabled="disabled"""")))}),format.raw/*24.205*/(""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_idtype">证件类型</label>
                            <input id="form_idtype" name="form_idtype" class="form-control" type="text" required="true" value=""""),_display_(/*28.129*/if(member!=null)/*28.145*/{_display_(_display_(/*28.147*/member/*28.153*/.idTypeName))}),format.raw/*28.165*/("""" """),_display_(/*28.168*/if(member.enable==0)/*28.188*/{_display_(Seq[Any](format.raw/*28.189*/("""disabled="disabled"""")))}),format.raw/*28.209*/(""">
                        </div>
                        <div class="col-sm-6">
                            <label for="form_idnumber">证件号</label>
                            <input id="form_idnumber" name="form_idnumber" class="form-control" type="text" required="true" value=""""),_display_(/*32.133*/if(member!=null)/*32.149*/{_display_(_display_(/*32.151*/member/*32.157*/.idNumber))}),format.raw/*32.167*/("""" """),_display_(/*32.170*/if(member.enable==0)/*32.190*/{_display_(Seq[Any](format.raw/*32.191*/("""disabled="disabled"""")))}),format.raw/*32.211*/(""">
                        </div>
                        <div class="col-sm-12">
                            <label for="form_desc">摘要</label>
                            <textarea id="form_desc" name="form_desc" class="form-control" rows="3" """),_display_(/*36.102*/if(member.enable==0)/*36.122*/{_display_(Seq[Any](format.raw/*36.123*/("""disabled="disabled"""")))}),format.raw/*36.143*/(""">"""),_display_(/*36.145*/if(member!=null)/*36.161*/{_display_(_display_(/*36.163*/member/*36.169*/.description))}),format.raw/*36.182*/("""</textarea>
                        </div>
                        <div class="col-sm-12">
                            <label for="form_feetype">费用类型</label>
                            <div class="form-group mb-20">
                                <div class="styled-select">
                                    <select id="form_feetype" name="form_feetype" class="form-control" required="true" disabled="disabled">
                                        <option value="">费用类型</option>
                                        <option value="FCPY6000" """),_display_(/*44.67*/if(member!=null && member.feeTypeCode=="FCPY6000")/*44.117*/{_display_(Seq[Any](format.raw/*44.118*/("""selected""")))}),format.raw/*44.127*/(""">续费一年6000</option>
                                        <option value="FCPY4500" """),_display_(/*45.67*/if(member!=null && member.feeTypeCode=="FCPY4500")/*45.117*/{_display_(Seq[Any](format.raw/*45.118*/("""selected""")))}),format.raw/*45.127*/(""">续费一年4500</option>
                                        <option value="FCPY3500" """),_display_(/*46.67*/if(member!=null && member.feeTypeCode=="FCPY3500")/*46.117*/{_display_(Seq[Any](format.raw/*46.118*/("""selected""")))}),format.raw/*46.127*/(""">续费一年3500</option>
                                        <option value="FCPY3000" """),_display_(/*47.67*/if(member!=null && member.feeTypeCode=="FCPY3000")/*47.117*/{_display_(Seq[Any](format.raw/*47.118*/("""selected""")))}),format.raw/*47.127*/(""">续费一年3000</option>
                                        <option value="FCPY3000" """),_display_(/*48.67*/if(member!=null && member.feeTypeCode=="FCHY3500")/*48.117*/{_display_(Seq[Any](format.raw/*48.118*/("""selected""")))}),format.raw/*48.127*/(""">续费半年4000</option>
                                        <option value="FCPY3000" """),_display_(/*49.67*/if(member!=null && member.feeTypeCode=="FCHY4000")/*49.117*/{_display_(Seq[Any](format.raw/*49.118*/("""selected""")))}),format.raw/*49.127*/(""">续费半年3500</option>
                                        <option value="FNPY10000" """),_display_(/*50.68*/if(member!=null && member.feeTypeCode=="FNPY10000")/*50.119*/{_display_(Seq[Any](format.raw/*50.120*/("""selected""")))}),format.raw/*50.129*/(""">首次缴费一年10000</option>
                                        <option value="FNPY6500" """),_display_(/*51.67*/if(member!=null && member.feeTypeCode=="FNPY6500")/*51.117*/{_display_(Seq[Any](format.raw/*51.118*/("""selected""")))}),format.raw/*51.127*/(""">首次缴费一年6500</option>
                                        <option value="FNHY4000" """),_display_(/*52.67*/if(member!=null && member.feeTypeCode=="FNHY4000")/*52.117*/{_display_(Seq[Any](format.raw/*52.118*/("""selected""")))}),format.raw/*52.127*/(""">首次缴费半年4500</option>
                                        <option value="FCPYVIP0" """),_display_(/*53.67*/if(member!=null && member.feeTypeCode=="FCPYVIP0")/*53.117*/{_display_(Seq[Any](format.raw/*53.118*/("""selected""")))}),format.raw/*53.127*/(""">VIP免费</option>
                                        <option value="FTOTHER" """),_display_(/*54.66*/if(member!=null && member.feeTypeCode=="FTOTHER")/*54.115*/{_display_(Seq[Any](format.raw/*54.116*/("""selected""")))}),format.raw/*54.125*/(""">其它优惠类型</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <label for="form_startvalidate">最新有效期 从</label>
                                <input id="form_startvalidate" name="form_startvalidate" class="form-control required date-picker" type="text" disabled="disabled" placeholder="开始日期" required="true" value=""""),_display_(/*62.207*/if(member!=null)/*62.223*/{_display_(_display_(/*62.225*/member/*62.231*/.startValidate))}),format.raw/*62.246*/("""">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-10">
                                <label for="form_endvalidate">到</label>
                                <input id="form_endvalidate" name="form_endvalidate" class="form-control required date-picker" type="text" disabled="disabled" placeholder="结束日期" required="true" value=""""),_display_(/*69.203*/if(member!=null)/*69.219*/{_display_(_display_(/*69.221*/member/*69.227*/.endValidate))}),format.raw/*69.240*/("""">
                                <i class="fa fa-calendar form-control-feedback mt-15 mr-10 font-15 text-gray-lightgray"></i>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="form-group mb-0 mt-20">
                                <input type="hidden" id="form_enable" name="form_enable" value="1">
                                <button type="submit" id="form_updatesubmit" name="form_updatesubmit" class="btn btn-colored btn-theme-color-2 text-white" data-loading-text="请稍候...">更新会员信息</button>
                                <button type="submit" id="form_disablesubmit" name="form_disablesubmit" class="btn btn-colored btn-theme-color-1" onclick="document.getElementById('form_enable').value=0">屏蔽该会员</button>
                            </div>
                        </div>
                    </div>
                </form>
                """),_display_(/*82.18*/if(member!=null)/*82.34*/{_display_(Seq[Any](format.raw/*82.35*/("""
                """),format.raw/*83.17*/("""<hr/>
                <h4>缴费明细</h4>
                <button type="button" class="btn btn-primary text-white" data-toggle="modal" data-target=".bs-example-modal-lg">续费</button>
                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <form id="form_postvalidate" name="form_postvalidate" class="booking-form form-home bg-white p-30" method="post" action="""),_display_(/*89.150*/routes/*89.156*/.MemberController.memberPayment(""+member.id)),format.raw/*89.201*/(""">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel2"><span class="text-theme-color-2">续费</span></h4>
                                    """),_display_(/*93.38*/if(validataes.nonEmpty)/*93.61*/{_display_(Seq[Any](format.raw/*93.62*/("""
                                      """),format.raw/*94.39*/("""<p>上次续费情况："""),_display_(/*94.50*/validataes(0)/*94.63*/.commitDatetime),format.raw/*94.78*/(""" """),_display_(/*94.80*/validataes(0)/*94.93*/.description),format.raw/*94.105*/(""" """),format.raw/*94.106*/("""金额：￥+"""),_display_(/*94.112*/validataes(0)/*94.125*/.amount),format.raw/*94.132*/(""" """),format.raw/*94.133*/("""有效期："""),_display_(/*94.138*/validataes(0)/*94.151*/.startValidate),format.raw/*94.165*/(""" """),format.raw/*94.166*/("""-- """),_display_(/*94.170*/validataes(0)/*94.183*/.endValidate),format.raw/*94.195*/(""" """),format.raw/*94.196*/("""</p>
                                    """)))}),format.raw/*95.38*/("""
                                """),format.raw/*96.33*/("""</div>
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
                                                        <option value="FCPY6000" """),_display_(/*121.83*/if(member.feeTypeCode=="FCPY6000")/*121.117*/{_display_(Seq[Any](format.raw/*121.118*/("""selected""")))}),format.raw/*121.127*/(""">续费一年6000</option>
                                                        <option value="FCPY4500" """),_display_(/*122.83*/if(member.feeTypeCode=="FCPY4500")/*122.117*/{_display_(Seq[Any](format.raw/*122.118*/("""selected""")))}),format.raw/*122.127*/(""">续费一年4500</option>
                                                        <option value="FCPY3500" """),_display_(/*123.83*/if(member.feeTypeCode=="FCPY3500")/*123.117*/{_display_(Seq[Any](format.raw/*123.118*/("""selected""")))}),format.raw/*123.127*/(""">续费一年3500</option>
                                                        <option value="FCPY3000" """),_display_(/*124.83*/if(member.feeTypeCode=="FCPY3000")/*124.117*/{_display_(Seq[Any](format.raw/*124.118*/("""selected""")))}),format.raw/*124.127*/(""">续费一年3000</option>
                                                        <option value="FNPY10000" """),_display_(/*125.84*/if(member.feeTypeCode=="FNPY10000")/*125.119*/{_display_(Seq[Any](format.raw/*125.120*/("""selected""")))}),format.raw/*125.129*/(""">首次缴费一年10000</option>
                                                        <option value="FNPY6500" """),_display_(/*126.83*/if(member.feeTypeCode=="FNPY6500")/*126.117*/{_display_(Seq[Any](format.raw/*126.118*/("""selected""")))}),format.raw/*126.127*/(""">首次缴费一年6500</option>
                                                        <option value="FNHY4000" """),_display_(/*127.83*/if(member.feeTypeCode=="FNHY4000")/*127.117*/{_display_(Seq[Any](format.raw/*127.118*/("""selected""")))}),format.raw/*127.127*/(""">首次缴费半年4500</option>
                                                        <option value="FCPYVIP0" """),_display_(/*128.83*/if(member.feeTypeCode=="FCPYVIP0")/*128.117*/{_display_(Seq[Any](format.raw/*128.118*/("""selected""")))}),format.raw/*128.127*/(""">VIP免费</option>
                                                        <option value="FTOTHER" """),_display_(/*129.82*/if(member.feeTypeCode=="FTOTHER")/*129.115*/{_display_(Seq[Any](format.raw/*129.116*/("""selected""")))}),format.raw/*129.125*/(""">其它优惠类型</option>
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
                """)))}),format.raw/*154.18*/("""

                """),format.raw/*156.17*/("""<hr/>
                <table class="table table-striped">
                    <tr>
                        <td>续费时间</td>
                        <td>有效期从</td>
                        <td>到</td>
                        <td>缴费信息</td>
                        <td>缴费金额</td>
                    </tr>
                    """),_display_(/*165.22*/for(validate <- validataes) yield /*165.49*/ {_display_(Seq[Any](format.raw/*165.51*/("""
                    """),format.raw/*166.21*/("""<tr>
                        <td>"""),_display_(/*167.30*/validate/*167.38*/.commitDatetime),format.raw/*167.53*/("""</td>
                        <td>"""),_display_(/*168.30*/validate/*168.38*/.startValidate),format.raw/*168.52*/("""</td>
                        <td>"""),_display_(/*169.30*/validate/*169.38*/.endValidate),format.raw/*169.50*/("""</td>
                        <td>"""),_display_(/*170.30*/validate/*170.38*/.description),format.raw/*170.50*/("""</td>
                        <td>"""),_display_(/*171.30*/validate/*171.38*/.amount),format.raw/*171.45*/("""</td>
                    </tr>
                    """)))}),format.raw/*173.22*/("""
                """),format.raw/*174.17*/("""</table>


            </div>
        </div>
    </div>
</section>

""")))}))
      }
    }
  }

  def render(loginedUserInfo:String,member:Member,validataes:List[MemberValidate],message:String): play.twirl.api.HtmlFormat.Appendable = apply(loginedUserInfo,member,validataes,message)

  def f:((String,Member,List[MemberValidate],String) => play.twirl.api.HtmlFormat.Appendable) = (loginedUserInfo,member,validataes,message) => apply(loginedUserInfo,member,validataes,message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Feb 18 17:01:04 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/memberdetail.scala.html
                  HASH: c3d619399395ab0c2eea1ec4768edf2bf920981e
                  MATRIX: 432->1|462->26|498->57|890->105|1070->190|1100->195|1144->231|1182->232|1210->234|1496->493|1527->515|1566->516|1614->536|1688->583|1716->590|1772->615|1818->633|1963->750|1979->756|2053->808|2358->1085|2384->1101|2415->1103|2431->1109|2461->1115|2492->1118|2522->1138|2562->1139|2614->1159|2918->1435|2944->1451|2975->1453|2991->1459|3023->1467|3054->1470|3084->1490|3124->1491|3176->1511|3482->1789|3508->1805|3539->1807|3555->1813|3591->1825|3622->1828|3652->1848|3692->1849|3744->1869|4055->2152|4081->2168|4112->2170|4128->2176|4162->2186|4193->2189|4223->2209|4263->2210|4315->2230|4591->2478|4621->2498|4661->2499|4713->2519|4743->2521|4769->2537|4800->2539|4816->2545|4853->2558|5442->3120|5502->3170|5542->3171|5583->3180|5696->3266|5756->3316|5796->3317|5837->3326|5950->3412|6010->3462|6050->3463|6091->3472|6204->3558|6264->3608|6304->3609|6345->3618|6458->3704|6518->3754|6558->3755|6599->3764|6712->3850|6772->3900|6812->3901|6853->3910|6967->3997|7028->4048|7068->4049|7109->4058|7225->4147|7285->4197|7325->4198|7366->4207|7481->4295|7541->4345|7581->4346|7622->4355|7737->4443|7797->4493|7837->4494|7878->4503|7987->4585|8046->4634|8086->4635|8127->4644|8723->5212|8749->5228|8780->5230|8796->5236|8835->5251|9444->5832|9470->5848|9501->5850|9517->5856|9554->5869|10550->6838|10575->6854|10614->6855|10660->6873|11252->7437|11268->7443|11335->7488|11752->7878|11784->7901|11823->7902|11891->7942|11929->7953|11951->7966|11987->7981|12016->7983|12038->7996|12072->8008|12102->8009|12136->8015|12159->8028|12188->8035|12218->8036|12251->8041|12274->8054|12310->8068|12340->8069|12372->8073|12395->8086|12429->8098|12459->8099|12533->8142|12595->8176|14798->10351|14843->10385|14884->10386|14926->10395|15056->10497|15101->10531|15142->10532|15184->10541|15314->10643|15359->10677|15400->10678|15442->10687|15572->10789|15617->10823|15658->10824|15700->10833|15831->10936|15877->10971|15918->10972|15960->10981|16093->11086|16138->11120|16179->11121|16221->11130|16353->11234|16398->11268|16439->11269|16481->11278|16613->11382|16658->11416|16699->11417|16741->11426|16867->11524|16911->11557|16952->11558|16994->11567|18616->13157|18665->13177|19019->13503|19063->13530|19104->13532|19155->13554|19218->13589|19236->13597|19273->13612|19337->13648|19355->13656|19391->13670|19455->13706|19473->13714|19507->13726|19571->13762|19589->13770|19623->13782|19687->13818|19705->13826|19734->13833|19821->13888|19868->13906
                  LINES: 17->1|18->2|19->3|24->4|29->4|31->6|31->6|31->6|32->7|38->13|38->13|38->13|39->14|39->14|39->14|40->15|41->16|41->16|41->16|41->16|45->20|45->20|45->20|45->20|45->20|45->20|45->20|45->20|45->20|49->24|49->24|49->24|49->24|49->24|49->24|49->24|49->24|49->24|53->28|53->28|53->28|53->28|53->28|53->28|53->28|53->28|53->28|57->32|57->32|57->32|57->32|57->32|57->32|57->32|57->32|57->32|61->36|61->36|61->36|61->36|61->36|61->36|61->36|61->36|61->36|69->44|69->44|69->44|69->44|70->45|70->45|70->45|70->45|71->46|71->46|71->46|71->46|72->47|72->47|72->47|72->47|73->48|73->48|73->48|73->48|74->49|74->49|74->49|74->49|75->50|75->50|75->50|75->50|76->51|76->51|76->51|76->51|77->52|77->52|77->52|77->52|78->53|78->53|78->53|78->53|79->54|79->54|79->54|79->54|87->62|87->62|87->62|87->62|87->62|94->69|94->69|94->69|94->69|94->69|107->82|107->82|107->82|108->83|114->89|114->89|114->89|118->93|118->93|118->93|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|119->94|120->95|121->96|146->121|146->121|146->121|146->121|147->122|147->122|147->122|147->122|148->123|148->123|148->123|148->123|149->124|149->124|149->124|149->124|150->125|150->125|150->125|150->125|151->126|151->126|151->126|151->126|152->127|152->127|152->127|152->127|153->128|153->128|153->128|153->128|154->129|154->129|154->129|154->129|179->154|181->156|190->165|190->165|190->165|191->166|192->167|192->167|192->167|193->168|193->168|193->168|194->169|194->169|194->169|195->170|195->170|195->170|196->171|196->171|196->171|198->173|199->174
                  -- GENERATED --
              */
          