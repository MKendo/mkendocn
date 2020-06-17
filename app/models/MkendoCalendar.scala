package models

case class MkendoCalendar(id:Int,roleid:Int, roleCode:String, roleName:String,
                          recurrenceRule:String, startTime:String, endTime:String,
                          event:String, eventType:String, eventPlace:String,
                          actorLessThan:Int, description:String)
