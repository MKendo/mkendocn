package controllers

import akka.actor.ActorSystem
import javax.inject.Inject
import models.Member
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{MemberService, SimpleTypeService}

class MemberController @Inject()(cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi) extends AbstractController(cc) {

    def memberPayment(idNumber: String) = Action{
      implicit request => {
        println("memberPayment....")

        val startValidate = request.body.asFormUrlEncoded.get("form_dstartvalidate").head
        val endValidate = request.body.asFormUrlEncoded.get("form_dendvalidate").head
        val feetypeCode = request.body.asFormUrlEncoded.get("form_dfeetype").head
        val amount = request.body.asFormUrlEncoded.get("form_damount").head
        val description = request.body.asFormUrlEncoded.get("form_ddesc").head

        val memberService = new MemberService(dbapi)
        val result = memberService.createValidateByMember(idNumber, feetypeCode,amount.toInt,startValidate,endValidate,description)

        //增加成功
        if(result == "SUCCESS") {
          val loginedUserInfo = Common.loginConfirm(request.session)
          val memberService = new MemberService(dbapi)
          val member:Member = memberService.findByIdnumber(idNumber)
          val validates = memberService.findValidatesByIdnumber(idNumber)
          Ok(views.html.memberdetail(loginedUserInfo,member,validates))
        }else{
          Ok(views.html.message(" 续费出了点问题：", result,""))
        }
      }
    }

}
