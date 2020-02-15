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
          SQL("select * from (select m.*,mv.startvalidate startvalidate,mv.endvalidate endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "left join member_validates mv on mv.memberid=m.id " +
            "left join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate)) " +
            "where endvalidate>={db_startDatetime} and endvalidate<={db_endDatetime}"
          ).on("db_startDatetime" -> startDatetime,"db_endDatetime" -> endDatetime).as(newsParser.*)
        }else{
          return SQL("select m.*,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
            "from members m " +
            "left join member_validates mv on mv.memberid=m.id " +
            "left join simpletypes ft on ft.id=mv.feetypeid " +
            "group by m.id " +
            "having mv.startvalidate=max(mv.startvalidate) "
          ).as(newsParser.*)
        }

    }
  }

  def findByIdnumber(idNumber:String): Member ={
    println("idNumber="+idNumber)

    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[Member] = Macro.namedParser[Member]
        return SQL("select * from (select m.*,m.idnumber idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName " +
          "from members m " +
          "join member_validates mv on mv.memberid=m.id " +
          "join simpletypes ft on ft.id=mv.feetypeid " +
          "group by m.id " +
          "having mv.startvalidate=max(mv.startvalidate)) " +
          "where idnumber={db_idnumber}"
        ).on("db_idnumber" -> idNumber).as(newsParser.single)
    }
  }

  def findValidatesByIdnumber(idNumber:String): List[MemberValidate] = {
     println("idNumber="+idNumber)
     db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[MemberValidate] = Macro.namedParser[MemberValidate]

        return SQL("select m.idnumber memberIdNumber, ft.code feeTypeCode,ft.name feeTypeName,mv.startvalidate,mv.endvalidate,mv.commitdatetime,mv.amount,mv.description " +
          "from member_validates mv " +
          "join members m on mv.memberid=m.id " +
          "join simpletypes ft on mv.feetypeid = ft.id " +
          "where m.idnumber={db_idnumber} order by mv.startvalidate desc"
        ).on("db_idnumber" -> idNumber).as(newsParser.*)
    }
  }

  private var s_memberid: Int = -1
  private var s_feetypeid: Int = -1
  def createValidateByMember(idNumber:String,feeTypeCode:String,amount:Int,startValidate:String,endValidate:String,description:String): String =
  {
    println(s"idNumber = $idNumber")
    if(idNumber.isEmpty){
      return "身份证号不能为空"
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

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from members where idnumber={db_idnumber}").on(
          "db_idnumber" -> idNumber).as(
          SqlParser.int("members.id").singleOpt)
        s_memberid = Integer.valueOf(id.get)
    }

    if(s_memberid<0){
      return s"按照身份证号“$idNumber”没有找到会员记录"
    }
    println(s"s_memberid = $s_memberid")

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

}
