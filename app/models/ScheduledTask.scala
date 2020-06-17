package models

case class ScheduledTask(id:Int,
                         userId:Int,
                         wxTemplateId:String,
                         wxTemplate:String,
                         msgurl:String,
                         keywords:String, //-- 以"__"分割的多个关键词
                         description:String,
                         sendDatetime:String,//发送时间
                         isSent:Int, //0:未发送 1:已发送
                         enable:Int)
