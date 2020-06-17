package models

import java.text.SimpleDateFormat
import java.util.Calendar

import service.Common

case class CalendarInstance(id:Int,
                            calendarId:Int,
                            userId:Int,
                            userName:String,
                            roleId:Int,roleCode:String,roleName:String,
                            event:String,eventType:String,eventPlace:String,
                            startDatetime:String,
                            endDatetime:String,
                            acctorLessThan:Int, //最大人数
                            doneActorCount:Int, //已完成（预约/打卡）人数
                            description:String,
                            commitDatetime:String,
                            enable:Int){

  /**
    * 获得还还有多少预约/打卡名额
    * @return
    */
  def getBalanceCount:Int = this.acctorLessThan - this.doneActorCount
  def getStartDate:String = this.startDatetime.split(' ')(0)
  def getStartTime:String = this.startDatetime.split(' ')(1)
  def getEndDate:String = this.endDatetime.split(' ')(0)
  def getEndTime:String = this.endDatetime.split(' ')(1)

  /**
    * 与今天的关系
    * 今天之前返回数字 < 0
    * 今天返回数字 = 0
    * 今天之后返回数字 > 0
    * @return
    */
  def compareToday(): Int ={
    val todayCalendar = Calendar.getInstance().getTime
    val df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startCalendar = df.parse(startDatetime)
    return startCalendar.compareTo(todayCalendar)
  }

  def compareYesterday(): Int ={
    var yesterdayCalendar = Calendar.getInstance()
    yesterdayCalendar.add(Calendar.DAY_OF_YEAR,-1)
    yesterdayCalendar.set(Calendar.HOUR_OF_DAY,0)
    yesterdayCalendar.set(Calendar.MINUTE,0)
    yesterdayCalendar.set(Calendar.SECOND,0)
    yesterdayCalendar.set(Calendar.MILLISECOND,0)
    val df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startCalendar = df.parse(startDatetime.substring(0,10)+" 00:00:00")
    return startCalendar.compareTo(yesterdayCalendar.getTime)
  }

}
