package service

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import anorm.{Macro, RowParser, SQL, SqlParser}
import javax.inject.Inject
import models.{CalendarInstance, Member, MkendoCalendar}
import play.api.db.DBApi
import service.Common.formate

import scala.collection.mutable.ListBuffer

class CalendarService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def createCalendarInstance(instance:CalendarInstance): Int ={
    if(instance==null){
      println(s"需要创建的CalendarInstance不可以为空")
      throw(new NullPointerException("需要创建的CalendarInstance为空"))
    }
    val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
    try {
      if(isExist(instance.userId,instance.calendarId,instance.startDatetime,instance.endDatetime)){//更新，主要就是更新enable为取反
        val enable = isEnable(instance.userId,instance.calendarId,instance.startDatetime,instance.endDatetime)
        println("enable="+enable)
        db.withConnection {
          implicit c: java.sql.Connection =>
            val result: Option[Long] = SQL("update calendar_instances set enable={db_enable} " +
              "where userid={db_userid} and calendarid={db_calendarid} and startdatetime={db_startdatetime} and enddatetime={db_enddatetime}").on(
              "db_enable" -> !enable,
              "db_userid" -> instance.userId,
              "db_calendarid" -> instance.calendarId,
            "db_startdatetime" -> instance.startDatetime,
            "db_enddatetime" -> instance.endDatetime).executeInsert()

            return if (result.get > 0) result.get.toInt else -1
        }
      }else{//增加
          db.withConnection {
            implicit c: java.sql.Connection =>
              val id: Option[Long] = SQL("insert into calendar_instances(" +
                "calendarid ,userid ,startdatetime ,enddatetime ,description ,commitdatetime,enable) " +
                "values({db_calendarid},{db_userid},{db_startdatetime},{db_enddatetime},{db_description},{db_commitdatetime},1)").on(
                "db_calendarid" -> instance.calendarId,
                "db_userid" -> instance.userId,
                "db_startdatetime" -> instance.startDatetime,
                "db_enddatetime" -> instance.endDatetime,
                "db_description" -> instance.description,
                "db_commitdatetime" -> commitDatetime).executeInsert()

              if (id.get.toInt > 0) id.get.toInt else -1
          }
        }
      }catch{
      case ex: Exception => {
        throw(ex)
      }
    }
  }

  def isExist(userId:Int,calendarId:Int,startdatetime:String,enddatetime:String): Boolean ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val count:Option[Int] = SQL(s"select count(*) cc from calendar_instances " +
            s"where userid=$userId and calendarid=$calendarId and " +
            s"startdatetime='$startdatetime' and enddatetime ='$enddatetime'")
            .as(SqlParser.int("cc").singleOpt)
          if(count.get>0) true else false
      }
    }catch{
      case ex:Exception =>{
        println(ex.getMessage+" "+ex.getCause)
        false
      }
    }
  }

  def isEnable(userId:Int,calendarId:Int,startdatetime:String,enddatetime:String): Boolean ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val count:Option[Int] = SQL(s"select enable cc from calendar_instances " +
            s"where userid=$userId and calendarid=$calendarId and " +
            s"startdatetime='$startdatetime' and enddatetime ='$enddatetime'")
            .as(SqlParser.int("cc").singleOpt)
          if(count.get>0) true else false
      }
    }catch{
      case ex:Exception =>{
        println(ex.getMessage+" "+ex.getCause)
        false
      }
    }
  }

  /**
    *
    * @param dateperiod 支持的格式：CURRENT_WEEK,NEXT_WEEK
    * @return
    */
  def findInstanceByDatePeriod(dateperiod:String, userMobile:String):List[CalendarInstance]={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val userService = new UserService(dbapi)
          val dbusr = userService.findByMobile(userMobile)
          if(dbusr==null){
            throw(new Exception("Calendar.findInstanceByDatePeriod() 用手机号查找用户失败：userMobile=$userMobile"))
          }
          val userid = userService.findByMobile(userMobile).id
          val roleService = new RoleService(dbapi)
          val roleids = roleService.findRoleIdsByMobile(userMobile)
          val rolenameStrs = roleService.findRolesByMobile(userMobile)
          val newsParser: RowParser[MkendoCalendar] = Macro.namedParser[MkendoCalendar]

          var calendars: List[MkendoCalendar] = Nil
          if(rolenameStrs.contains("超级管理员")){
            calendars = SQL("select c.id id,cr.id roleid,cr.code roleCode,cr.name roleName," +
              "c.recurrencerule,c.starttime,c.endtime,c.event,c.eventtype,c.eventplace,c.actorlessthan,c.description,c.enable " +
              "from calendars c " +
              "left join simpletypes cr on c.roleid=cr.id where c.enable={db_enable} order by cr.id desc"
            ).on("db_enable" -> 1).as(newsParser.*)
          }else {
            calendars = SQL("select c.id,cr.id roleid,cr.code roleCode,cr.name roleName," +
              "c.recurrencerule recurrenceRule, c.starttime startTime, c.endtime endTime, " +
              "c.event, c.eventtype eventType, c.eventplace eventPlace, " +
              "c.actorlessthan actorLessThan, c.description " +
              "from calendars c " +
              "left join simpletypes cr on c.roleid=cr.id where cr.id in ({db_rolesids}) and c.enable={db_enable} order by cr.id desc"
            ).on("db_rolesids" -> roleids, "db_enable" -> 1).as(newsParser.*)
          }

          //生成List[CalendarInstance]列表返回出去
          val calInstances: ListBuffer[CalendarInstance] = ListBuffer[CalendarInstance]()
          val commitDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date)
          for(calendar <- calendars) {

            //按MkendoCalendar中的规则定义返回指定时间区间内的所有实际日期
            for (ruleDay <- getDateTimesByPeriodRule(dateperiod,calendar.recurrenceRule)) {
              val startDatetime = Common.getDateTime(ruleDay,calendar.startTime)
              val endDatetime = Common.getDateTime(ruleDay,calendar.endTime)
              val exist = isExist(userid,calendar.id,startDatetime,endDatetime)
              val doneActorCount = this.getDoneActorCount(calendar.id,startDatetime,endDatetime); //当前日历已完成人数
              val enableBollean = isEnable(userid,calendar.id,startDatetime,endDatetime)
              val enable = if(enableBollean)1 else 0
              val calInstance = new CalendarInstance(-1,
                calendar.id,
                userid,
                "",
                calendar.roleid,
                calendar.roleCode,
                calendar.roleName,
                calendar.event,
                calendar.eventType,
                calendar.eventPlace,
                startDatetime,
                endDatetime,
                calendar.actorLessThan, //最大人数
                doneActorCount, //已完成（预约/打卡）人数
                if(exist && enableBollean) "EXIST" else "",//表示是否已存在当前用户与当前日历的组合（是否已预约或已签到）
                commitDatetime,
                enable)
              calInstances.append(calInstance)
            }
          }
          return calInstances.toList;
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        throw(ex)
      }
    }
  }

  /**
    * 根据时间设置规则，获取实际的日期
    * 目前支持的格式有：
    * 1. WEEKLY;BYDAY=MO,WE,FR --每周哪几天固定重复
    * 2. MONTHLY;BYDAY=-1SU --每月最后一个周日
    * 3. ONTIME;2020-05-01 --仅一次的事件（自己定义的）
    * @param dataPeriod
    * @param recurrenceRule
    * @return
    */
  def getDateTimesByPeriodRule(dataPeriod:String,recurrenceRule:String): List[Calendar] ={
    var wd1:Calendar = Common.getInstance(dataPeriod)
    wd1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
    var wd2:Calendar = Common.getInstance(dataPeriod)
    wd2.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY)
    var wd3:Calendar = Common.getInstance(dataPeriod)
    wd3.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY)
    var wd4:Calendar = Common.getInstance(dataPeriod)
    wd4.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY)
    var wd5:Calendar = Common.getInstance(dataPeriod)
    wd5.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY)
    var wd6:Calendar = Common.getInstance(dataPeriod)
    wd6.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
    var wd7:Calendar = Common.getInstance(dataPeriod)
    wd7.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
    wd7.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人的本周日的日期

    val result: ListBuffer[Calendar] = ListBuffer[Calendar]()
    if(recurrenceRule.equals("MONTHLY;BYDAY=-1SU")){
      //按月重复，每月最后一个周日
      val lastSunday = Common.getLastSunday(wd7)
      //如果当前时间段的周日就是月未的周日，则返回
      if(Common.formate(wd7,"yyyy-MM-dd").equals(Common.formate(lastSunday,"yyyy-MM-dd"))) {
        result.append(lastSunday)
        result.toList
      }else{
        Nil
      }
    }else if(recurrenceRule.startsWith("ONTIME;")){
      //一次性的事件
      val calendarDate = Common.getInstanceByDateString(recurrenceRule.substring(7))
      //如果在当前查询的时间段以内就返回
      if(calendarDate.compareTo(wd1)>=0 || calendarDate.compareTo(wd7)<=0) {
        result.append(calendarDate)
        println("one time in dataPeriod")
        result.toList
      }else{
        Nil
      }
    }else {
      //按周重复，每周几。。。
      val ruleDays = recurrenceRule.split("=")(1).split(",") //目前只处理这种结构：“WEEKLY;BYDAY=MO,WE,FR”
      for (ruleDay <- ruleDays) {
        val calendar: Calendar = ruleDay match {
          case "MO" => wd1
          case "TU" => wd2
          case "WE" => wd3
          case "TH" => wd4
          case "FR" => wd5
          case "SA" => wd6
          case "SU" => wd7
          case _ => null
        }
        if (calendar != null) {
          result.append(calendar)
        }
      }
      result.toList
    }
  }

  /**
    * 当前日历已完成人数
    * @param calendarId
    * @param startDatetime
    * @param endDatetime
    * @return
    */
  def getDoneActorCount(calendarId:Int,startDatetime:String, endDatetime:String): Int ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val count:Option[Int] = SQL(
            "select count(*) count " +
            "from calendar_instances " +
              "where calendarid={db_calendarid} and startdatetime={db_startdt} and enddatetime={db_enddt} and enable=1"
          ).on("db_startdt" -> startDatetime,
          "db_enddt" -> endDatetime,
          "db_calendarid" -> calendarId).as(SqlParser.int("count").singleOpt)
          if(count.get>0) count.get else 0
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        0
      }
    }
  }

  def findNamesByCalendarTimePeriod(calendarId:Int,startDatetime:String,endDatetime:String): List[String] ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          val roleids: List[String] = SQL("select ifnull(u.name,'') name " +
            "from calendar_instances ci left join users u on ci.userid=u.id " +
            "where ci.calendarid={db_calendarid} and " +
            "ci.startdatetime={db_startdatetime} and " +
            "ci.enddatetime={db_enddatetime} and ci.enable=1").on(
            "db_calendarid" -> calendarId,
            "db_startdatetime" -> startDatetime,
            "db_enddatetime" -> endDatetime).as(
            SqlParser.str("name").*)

          roleids
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage+" "+ex.getCause)
        throw(ex)
      }
    }
  }

//  /**
//    * 按startDatetime模糊差找
//    * @param startDateTime 例如：2020-01-01
//    * @return
//    */
//  def findByStartDatetime(startDateTime:String) : List[CalendarInstance] = {
//    try {
//      val newsParser: RowParser[CalendarInstance] = Macro.namedParser[CalendarInstance]
//      db.withConnection {
//        implicit c: java.sql.Connection =>
//          val instances: List[CalendarInstance] = SQL("select * " +
//            "from calendar_instances " +
//            "where startdatetime like {db_startDateTime} and ci.enable=1").on(
//            "db_startDateTime" -> s"%$startDateTime%").as(newsParser.*)
//
//          for(instance <- instances){
//            println("将要被提醒的 calendar instance = " + instance.startDatetime)
//          }
//
//          instances
//      }
//    }catch{
//      case ex: Exception => {
//        println("calendarService.findByStartDatetime() "+ex.getMessage+" "+ex.getCause)
//        throw(ex)
//      }
//    }
//  }

}
