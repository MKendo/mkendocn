package service

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import play.api.Logger
import play.api.db.DBApi
import models.{Booking}

class BookingService @Inject()(dbapi: DBApi) {

  private val logger = Logger(getClass)
  private val db = dbapi.database("default")

  private var s_placetimeid: Int = -1
  private var s_whereknowusid: Int = -1

  /**
    * 创建预约（提交预约体验表格）
    * @return 成功返回提SUCCESS，失败返回 “ERROR+失败原因”
    */
  def createBooking(booking: Booking): String = {

    if(booking.name.isEmpty){
      return "请填写您的真实姓名"
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where code={placetimeCode}").on(
          "placetimeCode" -> booking.placetimeCode).as(
          SqlParser.int("simpletypes.id").singleOpt)
        s_placetimeid = Integer.valueOf(id.get)
    }

    if(s_placetimeid <0 ){
      return "请选择正确的场次"
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val id: Option[Int] = SQL("select id from simpletypes where code={whereknowusCode}").on(
          "whereknowusCode" -> booking.whereknowusCode).as(
          SqlParser.int("simpletypes.id").singleOpt)
        s_whereknowusid = Integer.valueOf(id.get)
    }

    if(s_whereknowusid <0 ){
      return "请选择正确的怎么找到我们的"
    }

    db.withConnection {
      implicit c:java.sql.Connection =>
        val result: Option[Long] = SQL("insert into bookings(name, mobile, wxopenid, placetimeid, classdate, whereknowusid, coursename,height,weight, commitdatetime,enable) " +
          "values({db_name},{db_mobile},{db_wxopenid},{db_placetimeid},{db_classdate},{db_whereknowusid},{db_coursename},{db_height},{db_weight},{db_commitdatetime},1)").on(
          "db_name" -> booking.name,
                  "db_mobile" -> booking.mobile,
                  "db_wxopenid" -> booking.wxopenid,
                  "db_placetimeid" -> s_placetimeid,
                  "db_classdate" -> booking.classdate,
                  "db_whereknowusid" -> s_whereknowusid,
                  "db_coursename" -> booking.coursename,
                  "db_height" -> booking.height,
                  "db_weight" -> booking.weight,
                  "db_commitdatetime" -> booking.commitdatetime).executeInsert()

        return "SUCCESS_"+result.get.toInt
    }
    return "未知问题，请联系管理员或重试一次。"
  }

  /**
    * 两个参数都是“”的话，就是查全部
    * @param startDatetime
    * @param endDatetime
    * @return
    */
  def findByTimePeriod(startDatetime:String, endDatetime: String): List[Booking] = {
          db.withConnection {
          implicit c: java.sql.Connection =>
          val newsParser: RowParser[Booking] = Macro.namedParser[Booking]

          println(s"startDatetime = $startDatetime")
          println(s"endDatetime = $endDatetime")

          if(!startDatetime.isEmpty && !endDatetime.isEmpty) {
            return SQL("select b.*,ifnull(b.height,'') height, ifnull(b.weight,'') weight,ifnull(b.description,'') description, ptn.code placetimeCode, ptn.name placetimeName,wn.code whereknowusCode,wn.name whereknowusName " +
              "from bookings b " +
              "join simpletypes ptn on b.placetimeid=ptn.id " +
              "join simpletypes wn on b.whereknowusid=wn.id " +
              "where classdate>={db_startDatetime} and classdate<={db_endDatetime} ORDER BY classdate desc,id desc"
            ).on("db_startDatetime" -> startDatetime,"db_endDatetime" -> endDatetime).as(newsParser.*)
          }else{
            return SQL("select b.*,ifnull(b.height,'') height, ifnull(b.weight,'') weight,ifnull(b.description,'') description,ptn.code placetimeCode, ptn.name placetimeName,wn.code whereknowusCode,wn.name whereknowusName " +
              "from bookings b " +
              "join simpletypes ptn on b.placetimeid=ptn.id " +
              "join simpletypes wn on b.whereknowusid=wn.id " +
              "ORDER BY classdate desc,id desc" ).as(newsParser.*)
          }

     }
  }

  def findById(id:Int):Booking = {
    println(s"findById id = $id")
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val newsParser: RowParser[Booking] = Macro.namedParser[Booking]
          return SQL("select b.*,ifnull(b.height,'') height, ifnull(b.weight,'') weight,ifnull(b.description,'') description," +
            "pt.code placetimeCode,pt.name placetimeName, " +
            "wn.code whereknowusCode,wn.name whereknowusName " +
            "from bookings b " +
            "left join simpletypes pt on b.placetimeid = pt.id " +
            "left join simpletypes wn on b.whereknowusid = wn.id " +
            "where b.id={db_id}"
          ).on("db_id" -> id).as(newsParser.single)
      }
    }catch{
      case ex: Exception => {
        throw ex
      }
    }
  }

  def disable(id:Int):Int = {
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val result : Int = SQL("update bookings set enable=0 " +
            "where id={db_bookingsId}").on(
            "db_bookingsId" -> id).executeUpdate()

          return if(result>0) result else -1
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        throw(ex)
      }
    }
  }

  def updateDescription(id:Int,description:String):Int = {
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val result : Int = SQL("update bookings set description={db_description} " +
            "where id={db_bookingsId}").on(
            "db_description" -> description,
            "db_bookingsId" -> id).executeUpdate()

          return if(result>0) result else -1
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        throw(ex)
      }
    }
  }

}
