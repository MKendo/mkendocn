package service

import java.text.SimpleDateFormat
import java.util.Date

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import models.{Member, MemberValidate}
import play.api.db.DBApi

class MemberService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  /**
    * 两个参数都是“”的话，就是查全部
    * @param startDatetime
    * @param endDatetime
    * @return
    */
  def findByTimePeriod(startDatetime:String, endDatetime: String): List[Member] = {
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[Member] = Macro.namedParser[Member]

        println(s"startDatetime = $startDatetime")
        println(s"endDatetime = $endDatetime")

        if(!startDatetime.isEmpty && !endDatetime.isEmpty) {
          SQL("select * from (select m.*,m.enable menable,mv.startvalidate startvalidate,mv.endvalidate endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "left join member_validates mv on mv.memberid=m.id " +
            "left join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate)) " +
            "where endvalidate>={db_startDatetime} and endvalidate<={db_endDatetime} and menable=1 order by endvalidate desc"
          ).on("db_startDatetime" -> startDatetime,"db_endDatetime" -> endDatetime).as(newsParser.*)
        }else{
          return SQL("select * from (select m.*,m.enable menable,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "left join member_validates mv on mv.memberid=m.id " +
            "left join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate))" +
            "where menable=1 order by endvalidate asc"
          ).as(newsParser.*)
        }

    }
  }

  def findById(id:Int): Member ={
    println("id="+id)

    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val newsParser: RowParser[Member] = Macro.namedParser[Member]
          return SQL("select * from (select m.*,m.id id,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "join member_validates mv on mv.memberid=m.id " +
            "join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate)) " +
            "where id={db_id}"
          ).on("db_id" -> id).as(newsParser.single)
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return null;
      }
    }
  }

  def findByIdNumber(idNumber:String): Member ={
    println("idNumber="+idNumber)

    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val newsParser: RowParser[Member] = Macro.namedParser[Member]
          return SQL("select * from (select m.*,m.idnumber idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "join member_validates mv on mv.memberid=m.id " +
            "join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate)) " +
            "where id={db_idnumber}"
          ).on("db_idnumber" -> idNumber).as(newsParser.single)
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return null;
      }
    }
  }

  def findValidatesById(id:Int): List[MemberValidate] = {
     println("id="+id)
     db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[MemberValidate] = Macro.namedParser[MemberValidate]

        return SQL("select m.id,m.idNumber memberIdNumber,m.description description, ft.code feeTypeCode,ft.name feeTypeName,mv.startvalidate,mv.endvalidate,mv.commitdatetime,mv.amount,mv.description " +
          "from member_validates mv " +
          "join members m on mv.memberid=m.id " +
          "join simpletypes ft on mv.feetypeid = ft.id " +
          "where m.id={db_id} order by mv.endvalidate desc"
        ).on("db_id" -> id).as(newsParser.*)
    }
  }

  private var s_memberid: Int = -1
  private var s_feetypeid: Int = -1

  def createValidateByMemberId(memberId:Int,feeTypeCode:String,amount:Int,startValidate:String,endValidate:String,description:String): String =
  {
    println(s"memberId = $memberId")
    if(memberId<0){
      return "会员ID不能为0"
    }

    if(startValidate.isEmpty()){
      return "有效期开始时间不能为空"
    }

    if(endValidate.isEmpty()){
      return "有效期结束时间不能为空"
    }

    if(description.isEmpty()){
      return "缴费描述信息不能为空"
    }

    if(amount<=0){
      return "缴费金额必须大于0"
    }

    s_memberid = memberId

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where typecode='MemberFeeType' and code={db_feetypecode}").on(
          "db_feetypecode" -> feeTypeCode).as(
          SqlParser.int("simpletypes.id").singleOpt)
        s_feetypeid = Integer.valueOf(id.get)
    }

    if(s_feetypeid<0){
      return s"按照费用类型编码“$feeTypeCode”没有找到相应的费用类型"
    }
    println(s"s_feetypeid = $s_feetypeid")

    val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
    db.withConnection {
      implicit c:java.sql.Connection =>
        val result: Option[Long] = SQL("insert into member_validates(memberid,startvalidate,endvalidate,feetypeid,amount,description,commitdatetime,enable) " +
          "values({db_memberid},{db_startvlidate},{db_endvalidate},{db_feetypeid},{db_amount},{db_description},{db_commitdatetime},1)").on(
          "db_memberid" -> s_memberid,
          "db_startvlidate" -> startValidate,
          "db_endvalidate" -> endValidate,
          "db_feetypeid" -> s_feetypeid,
          "db_amount" -> amount,
          "db_description" -> description,
          "db_commitdatetime" -> commitDatetime).executeInsert()

        return "SUCCESS"
    }
    return "未知问题，请联系管理员或重试一次。"
  }


  def createValidateByMember(idNumber:String,feeTypeCode:String,amount:Int,startValidate:String,endValidate:String,description:String): String =
  {
    println(s"idNumber = $idNumber")
    if(idNumber.isEmpty){
      return "身份证号不能为空"
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from members where idnumber={db_idnumber}").on(
          "db_idnumber" -> idNumber).as(
          SqlParser.int("members.id").singleOpt)
        s_memberid = Integer.valueOf(id.get)
    }

    return createValidateByMemberId(s_memberid, feeTypeCode, amount, startValidate, endValidate, description)
  }

  def createMember(member: Member): String ={
    if(member==null){
      return s"需要创建的会员信息为空，无法创建新会员哦"
    }
    val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          SQL("insert into members(name,mobile,idtypename,idnumber,commitdatetime) " +
            "values({db_name},{db_mobile},{db_idtypename},{db_idnumber},{db_commitdatetime})").on(
            "db_name" -> member.name,
            "db_mobile" -> member.mobile,
            "db_idtypename" -> member.idTypeName,
            "db_idnumber" -> member.idNumber,
            "db_commitdatetime" -> commitDatetime).executeInsert()

          return "SUCCESS"
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return "更新会员信息时发生错误了:"+ex.getMessage;
      }
    }

  }

  /**
    * 更新会员信息
    * @param memberId
    * @param newMember
    */
  def updateMember(memberId:Int, newMember: Member): String ={
    if(memberId<0){
      return s"会员ID不合法。Member Id = $memberId"
    }

    if(newMember==null){
      return s"新的会员信息为空，无法更新哦"
    }

    val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
    println("newMember.name = " + newMember.name)
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          SQL("update members set name={db_name},mobile={db_mobile},idtypename={db_idtypename},idnumber={db_idnumber},commitdatetime={db_commitdatetime},description={db_description},enable={db_enable} " +
            "where id={db_memberId}").on(
            "db_name" -> newMember.name,
            "db_mobile" -> newMember.mobile,
            "db_idtypename" -> newMember.idTypeName,
            "db_idnumber" -> newMember.idNumber,
            "db_commitdatetime" -> commitDatetime,
            "db_memberId" -> memberId,
            "db_description" -> newMember.description,
            "db_enable" -> newMember.enable).executeInsert()

          return "SUCCESS"
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return "更新会员信息时发生错误了:"+ex.getMessage;
      }
    }
  }

}
