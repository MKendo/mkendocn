package schedule

import javax.inject.Inject
import akka.actor.ActorSystem
import controllers.SendWxMessageController
import play.api.db.DBApi
import play.api.libs.ws.WSClient
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{ScheduledTaskService, UserService}

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext

/**
  * 定时任务运行器
  */
class ScheduledTaskRunner @Inject()(actorSystem: ActorSystem)(dbapi: DBApi)(ws: WSClient,cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc)
{
  actorSystem.scheduler.schedule(
    initialDelay = 0.microseconds,
    interval = 1.hours  //每小时执行一次
  ){
    println("定时任务：预约体验提醒")
    //查找当前几点范围内应该提醒的消息，发送
    val taskService = new ScheduledTaskService(dbapi)
    val tasks = taskService.findByCurrentHour()
    println("查到当前小时需要被提醒的消息数量为：" + tasks.length)

    for(task <- tasks){
      val userService = new UserService(dbapi)
      val openid = userService.findByUserId(task.userId).wxOpenid
      val sc = new SendWxMessageController(cc)(dbapi)(ws, controllerComponents)(ec)
      val keys:Array[String] = task.keywords.split("__")
      sc.sendWxTemplateMessage(openid,task.wxTemplateId,task.wxTemplate,task.msgurl,keys:_*)

      //更新状态为已发送
      taskService.updateSent(task.id)
    }
  }

}

