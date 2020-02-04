package service

import anorm.{SQL, SqlParser}
import javax.inject.Inject
import play.api.Logger
import play.api.db.DBApi
import models.BookingDescription

class BookingService @Inject()(dbapi: DBApi, bookingDescription: BookingDescription) {

  private val logger = Logger(getClass)
  private val db = dbapi.database("default")

  private val bookingInfo = bookingDescription
  private var s_placetimeid: Int = -1;
  private var s_whereknowusid: Int = -1

  /**
    * 创建预约（提交预约体验表格）
    * @return 成功返回提交者姓名，失败返回 “ERROR+失败原因”
    */
  def createBooking(): String = {

    if(bookingInfo.name.isEmpty){
      return "请填写您的真实姓名"
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where code={placetimeCode}").on(
          "placetimeCode" -> bookingInfo.placetimeCode).as(
          SqlParser.int("simpletypes.id").singleOpt)
        s_placetimeid = Integer.valueOf(id.get)
    }

    if(s_placetimeid <0 ){
      return "请选择正确的场次";
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where code={whereknowusCode}").on(
          "whereknowusCode" -> bookingInfo.whereknowusCode).as(
          SqlParser.int("simpletypes.id").singleOpt)
        s_whereknowusid = Integer.valueOf(id.get)
    }

    if(s_whereknowusid <0 ){
      return "请选择正确的怎么找到我们的";
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val result: Option[Long] = SQL("insert into bookings(name, mobile, wxopenid, placetimeid, classdate, whereknowusid, coursename, commitdatetime) " +
          "values({db_name},{db_mobile},{db_wxopenid},{db_placetimeid},{db_classdate},{db_whereknowusid},{db_coursename},{db_commitdatetime})").on(
          "db_name" -> bookingInfo.name,
                  "db_mobile" -> bookingInfo.mobile,
                  "db_wxopenid" -> bookingInfo.wxopenid,
                  "db_placetimeid" -> s_placetimeid,
                  "db_classdate" -> bookingInfo.classdate,
                  "db_whereknowusid" -> s_whereknowusid,
                  "db_coursename" -> bookingInfo.coursename,
                  "db_commitdatetime" -> bookingInfo.commitdatetime).executeInsert()

        return "SUCCESS"
    }
    return "未知问题，请联系管理员或重试一次。";
  }

}
