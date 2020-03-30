package controllers


import akka.actor.ActorSystem
import javax.inject.Inject
import models.{Member}
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{MemberService}

class MemberController @Inject()(cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi) extends AbstractController(cc) {

  def createMember() = Action{
    implicit request => {

      try {
        val memberService = new MemberService(dbapi)
        val name = request.body.asFormUrlEncoded.get("form_name").head
        val mobile = request.body.asFormUrlEncoded.get("form_mobile").head
        val idTypeName = request.body.asFormUrlEncoded.get("form_idtype").head
        val idNumber = request.body.asFormUrlEncoded.get("form_idnumber").head
        val description = request.body.asFormUrlEncoded.get("form_desc").head
        val enable = if(request.body.asFormUrlEncoded.get("form_enable").head=="0"){0}else{1}
        val newMember = Member(-1, name, mobile, idTypeName, idNumber, description, "", "", "", "", enable,-1) //新的会员信息


        //增加会员
        println(s"准备增加会员add " + newMember)
        val createResult = memberService.createMember(newMember)

        val loginedUserInfo = Common.loginConfirm(request.session)
        if(createResult.startsWith("SUCCESS")) {
          val memberid = createResult.substring(8).toInt
          val dbMember = Member(memberid,newMember.name,newMember.mobile,newMember.idTypeName,newMember.idNumber,newMember.description,"","","","",1,-1)
          Ok(views.html.memberdetail(loginedUserInfo, dbMember, Nil, "会员增加成功"))
        }else{
          Ok(views.html.message("增加会员时出现错误",createResult, loginedUserInfo))
        }
      }catch{
        case ex:Exception =>{
          val loginedUserInfo = Common.loginConfirm(request.session)
          Ok(views.html.message("增加会员时出现错误",ex.getMessage(), loginedUserInfo))
        }
      }
    }
  }

  /**
    * 增加或者更新会员信息
    * @return
    */
  def createOrUpdateMember(memberId: String) = Action{
    implicit request => {

        try {
          val memberService = new MemberService(dbapi)
          val name = request.body.asFormUrlEncoded.get("form_name").head
          val mobile = request.body.asFormUrlEncoded.get("form_mobile").head
          val idTypeName = request.body.asFormUrlEncoded.get("form_idtype").head
          val idNumber = request.body.asFormUrlEncoded.get("form_idnumber").head
          val description = request.body.asFormUrlEncoded.get("form_desc").head
          val iid = if(memberId.startsWith(":")){memberId.substring(1).toInt} else{memberId.toInt}
          val enable = if(request.body.asFormUrlEncoded.get("form_enable").head=="0"){0}else{1}
          val newMember = Member(iid, name, mobile, idTypeName, idNumber, description, "", "", "", "", enable,-1)

          val oldMember: Member = memberService.findById(iid)
          val loginedUserInfo = Common.loginConfirm(request.session)

          if (oldMember != null) {
            //更新会员信息
            println(s"更新会员信息update $newMember.name")
            memberService.updateMember(iid, newMember)
            val dbnewMember = memberService.findById(iid)
            val validates = memberService.findValidatesById(iid)
            Ok(views.html.memberdetail(loginedUserInfo, dbnewMember, validates,"会员信息更新成功"))
          } else {
            Ok(views.html.message("要更新的会员信息不存在",s"传入的会员ID=$memberId ", loginedUserInfo))
          }
        }catch{
          case ex:Exception =>{
            val loginedUserInfo = Common.loginConfirm(request.session)
            Ok(views.html.message("提交会员信息出错",s"传入的会员ID=$memberId "+ex.getMessage(), loginedUserInfo))
          }
        }
      }
  }

  /**
    * 会员缴费续费
    * @param idNumber
    * @return
    */
  def memberPayment(memberId: String) = Action{
    implicit request => {
      println("memberPayment....")

      try {
        val iid = if(memberId.startsWith(":")){memberId.substring(1).toInt} else{memberId.toInt}

        val startValidate = request.body.asFormUrlEncoded.get("form_dstartvalidate").head
        val endValidate = request.body.asFormUrlEncoded.get("form_dendvalidate").head
        val feetypeCode = request.body.asFormUrlEncoded.get("form_dfeetype").head
        val amount = request.body.asFormUrlEncoded.get("form_damount").head
        val description = request.body.asFormUrlEncoded.get("form_ddesc").head

        val memberService = new MemberService(dbapi)
        val result = memberService.createValidateByMemberId(iid, feetypeCode,amount.toInt,startValidate,endValidate,description)

        //增加成功
        if(result == "SUCCESS") {
          val loginedUserInfo = Common.loginConfirm(request.session)
          val memberService = new MemberService(dbapi)
          val member:Member = memberService.findById(iid)
          val validates = memberService.findValidatesById(member.id)
          Ok(views.html.memberdetail(loginedUserInfo,member,validates,""))
        }else{
          val loginedUserInfo = Common.loginConfirm(request.session)
          Ok(views.html.message(" 续费出了点问题：", result,loginedUserInfo))
        }
      }catch{
        case ex:Exception =>{
          val loginedUserInfo = Common.loginConfirm(request.session)
          Ok(views.html.message("会员续费出错",s"传入的会员ID=$memberId", loginedUserInfo))
        }
      }
    }
  }

}
