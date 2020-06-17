package service

import java.util.Calendar

import anorm.{Macro, RowParser, SQL}
import javax.inject.Inject
import models.ScheduledTask
import play.api.db.DBApi

class ScheduledTaskService @Inject()(dbapi: DBApi) {

  private val db = dbapi.database("default")

  def create(task: ScheduledTask): String ={
    try {
      println("ScheduledTaskService.create " + task)
      db.withConnection {
        implicit c: java.sql.Connection =>
          val id: Option[Long] = SQL("insert into scheduled_tasks(userid,wxtemplateid,wxtemplate,msgurl,keywords,description,senddatetime,issent,enable) " +
            "values({db_userid},{db_wxtemplateid},{db_wxtemplate},{db_msgurl},{db_keywords},{db_description},{db_senddatetime},0,1)").on(
            "db_userid" -> task.userId,
            "db_wxtemplateid" -> task.wxTemplateId,
            "db_wxtemplate" -> task.wxTemplate,
            "db_msgurl" -> task.msgurl,
            "db_keywords" -> task.keywords,
            "db_description" -> task.description,
            "db_senddatetime" -> task.sendDatetime
          ).executeInsert()

          val result = "SUCCESS_"+id.getOrElse("")
          println(result)
          return result
      }
    }catch{
      case ex: Exception => {
        println(ex.getMessage)
        return "增加定时发送消息时发生错误了:"+ex.getMessage+" "+ex.getCause;
      }
    }
  }

  /**
    * 按当前小时数获取需要发送的提醒任务
    * @param hour24
    */
  def findByCurrentHour(): List[ScheduledTask] ={
    val currentDatetime = Common.formate(Calendar.getInstance(),"yyyy-MM-dd HH:mm:ss")
    val key = currentDatetime.split(":")(0) //取得 yyyy-MM-dd HH 部分
    db.withConnection {
      implicit c: java.sql.Connection =>
        val newsParser: RowParser[ScheduledTask] = Macro.namedParser[ScheduledTask]
        val sql = SQL("select * from scheduled_tasks where senddatetime like {db_senddatetime} and issent=0 and enable=1")
          .on("db_senddatetime" -> s"$key%")

        val tasks: List[ScheduledTask] = {
          try {
            sql.as(newsParser.*)
          }catch{
            case ex: Exception => {
              println(ex.getMessage+" "+ex.getCause)
              return Nil;
            }
          }
        }

        tasks
    }
  }

  /**
    * 更新为已发送
    */
  def updateSent(id:Int): String ={
    try {
      db.withConnection {
        implicit c: java.sql.Connection =>
          SQL("update scheduled_tasks set issent=1 " +
            "where id={db_id}").on(
            "db_id" -> id).executeUpdate()

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
