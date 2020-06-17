package service

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import play.api.mvc.Session

import scala.collection.mutable.ListBuffer

object Common {

  def loginConfirm(session: Session): String ={
    session
      .get("LIGINED")
      .map { userinfo =>
        println("logined userinfo = " + userinfo)
        return userinfo
      }
      .getOrElse {
        return ""
      }
  }

  def getCurrentInstance():Calendar = {
    return Calendar.getInstance()
  }

  /**
    * 获取日期实例
    * @param dateString yyyy-MM-dd 格式的字符串
    * @return
    */
  def getInstanceByDateString(dateString:String): Calendar ={
    val format = new SimpleDateFormat("yyyy-MM-dd")
    val date = format.parse(dateString)
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar
  }

  /**
    * 获取日期实例
    * @param dateString yyyy-MM-dd HH:mm:ss 格式的字符串
    * @return
    */
  def getInstanceByDateString2(dateString:String): Calendar ={
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = format.parse(dateString)
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar
  }

  /**
    * 获致日期实例
    * @param key 可选值为：LAST_WEEK,CURRENT_WEEK, NEXT_WEEK
    * @return
    */
  def getInstance(key:String): Calendar ={
    if(key.equals("CURRENT_WEEK")){
      var cal = Calendar.getInstance()
      if(cal.get(Calendar.DAY_OF_WEEK)==1){
        //说明是周日，往前取一天，再取周一（因为西方国家，周日算一周的第一天，而我们要算成第7天）
        cal.add(Calendar.DAY_OF_YEAR,-1)
      }
      cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      return cal
    }else if(key.equals("NEXT_WEEK")){
      var cal:Calendar =Calendar.getInstance();
      if(cal.get(Calendar.DAY_OF_WEEK)>1){
        cal.add(Calendar.DAY_OF_YEAR,7)
      }
      cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      return cal
    }else if(key.equals("LAST_WEEK")){ //上周
      var cal:Calendar =Calendar.getInstance();
      if(cal.get(Calendar.DAY_OF_WEEK)==1) {
        cal.add(Calendar.DAY_OF_YEAR, -8)
      }else {
        cal.add(Calendar.DAY_OF_YEAR, -7)
      }
      cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      return cal
    }else{
      return null
    }
  }

  /**
    *
    * @param day
    * @param time 格式：00:00:00 表示0点0分0秒 24小时制
    * @return
    */
  def getDateTime(day:Calendar, time:String): String ={
    val timee = time.split(":")
    day.set(Calendar.HOUR_OF_DAY, timee(0).toInt)
    day.set(Calendar.MINUTE, timee(1).toInt)
    day.set(Calendar.SECOND, timee(2).toInt)
    val df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    val datetime = df.format(day.getTime)
    datetime
  }

  def formate(calendar:Calendar,pattern:String):String = {
    var dateFormat:SimpleDateFormat = new SimpleDateFormat(pattern)
    dateFormat.format(calendar.getTime)
  }

  /**
    * 获取今天的日期
    * @return
    */
  def getNowDate():String={
    var now:Date = new Date()
    var  dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd")
    var hehe = dateFormat.format( now )
    hehe
  }

  /**
    * 获取昨天的日期
    * @return
    */
  def getYesterday():String = {
    var dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd")
    var cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, -1)
    var yesterday = dateFormat.format(cal.getTime())
    yesterday
  }

  /**
    * 获取明天的日期 yyyy/MM/dd
    * @return
    */
  def getTomorrow():String = {
    var dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd")
    var cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, 1)
    var tomorrow = dateFormat.format(cal.getTime())
    tomorrow
  }

  /**
    * 获取明天的日期 yyyy-MM-dd
    * @return
    */
  def getTomorrow2():String = {
    var dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    var cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, 1)
    var tomorrow = dateFormat.format(cal.getTime())
    tomorrow
  }

  /**
    * 获取本周第一天
    * @return
    */
  def getCurrentWeekStart():String={
    var period:String=""
    var cal:Calendar =getInstance("CURRENT_WEEK")
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd")
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
    //获取本周一的日期
    period=df.format(cal.getTime())
    period
  }

  /**
    * 获取本周最后一天
    * @return
    */
  def getCurrentWeekEnd():String={
    var period:String=""
    var cal:Calendar = getInstance("CURRENT_WEEK")

    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//这种输出的是上个星期周日的日期，因为老外把周日当成第一天
    cal.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人的本周日的日期
    period=df.format(cal.getTime())
    period
  }

  /**
    * 获取下周第一天
    * @return
    */
  def getNextWeekStart():String={
    var period:String=""
    var cal:Calendar = getInstance("NEXT_WEEK")
//    cal.add(Calendar.DAY_OF_YEAR,7)
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
    //获取本周一的日期
    period=df.format(cal.getTime())
    period
  }

  /**
    * 获取下周最后一天
    * @return
    */
  def getNextWeekEnd():String={
    var period:String=""
    var cal:Calendar = getInstance("NEXT_WEEK")
//    cal.add(Calendar.DAY_OF_YEAR,7)
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//这种输出的是上个星期周日的日期，因为老外把周日当成第一天
    cal.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人的本周日的日期
    period=df.format(cal.getTime())
    period
  }

  /**
    * 获取本月第一天
    * @return
    */
  def getCurrentMonthStart():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DATE, 1)
    period=df.format(cal.getTime())//本月第一天
    period
  }

  /**
    * 获取本月最后一天
    * @return
    */
  def getCurrentMonthEnd():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DATE, 1)
    cal.roll(Calendar.DATE,-1)
    period=df.format(cal.getTime())//本月最后一天
    period
  }

  /**
    * 获取下个月第一天
    * @return
    */
  def getNextMonthStart():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.add(Calendar.MONTH, 1)
    cal.set(Calendar.DATE, 1)
    period=df.format(cal.getTime())//本月第一天
    period
  }

  /**
    * 获取下个月最后一天
    * @return
    */
  def getNextMonthEnd():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance()
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.add(Calendar.MONTH, 2)
    cal.set(Calendar.DATE, 1)
    cal.roll(Calendar.DAY_OF_YEAR,-1)
    period=df.format(cal.getTime())//本月最后一天
    period
  }

  def getWeeknDate(timePeriodKey:String, value:Int): String ={
    var period:String=""
    var cal:Calendar = getInstance(timePeriodKey)
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    cal.set(Calendar.DAY_OF_WEEK, value)
    if(value.equals(Calendar.SUNDAY)) {
      cal.add(Calendar.WEEK_OF_YEAR, 1) // 增加一个星期，才是我们中国人的本周日的日期
    }

    period=df.format(cal.getTime())
    period
  }

  def getWeek1(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.MONDAY)
  }

  def getWeek2(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.TUESDAY)
  }

  def getWeek3(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.WEDNESDAY)
  }

  def getWeek4(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.THURSDAY)
  }

  def getWeek5(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.FRIDAY)
  }

  def getWeek6(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.SATURDAY)
  }

  def getWeek7(timePeriodKey:String):String = {
    getWeeknDate(timePeriodKey,Calendar.SUNDAY)
  }

  /**
    * 按周几返回日期
    * @param weekn  周几，例如：1，3，5，4，7
    * @param nextCount 往后取几周，例如：3 （目前只支持2周先）
    */
  def getDatesByWeekn(weekn:Int,nextCount:Int,includeToday:Boolean): List[String] = {
    val calendarWeekn = weekn match{
      case 1 => Calendar.MONDAY
      case 2 => Calendar.TUESDAY
      case 3 => Calendar.WEDNESDAY
      case 4 => Calendar.THURSDAY
      case 5 => Calendar.FRIDAY
      case 6 => Calendar.SATURDAY
      case 7 => Calendar.SUNDAY
      case _ => Calendar.MONDAY
    }

    var dates:ListBuffer[String] = new ListBuffer[String]()
    val currentDate = getWeeknDate("CURRENT_WEEK", calendarWeekn)
    //今天以前的日期不可以再预约，所以只显示大于今天的
    if(includeToday) {//包含今天
      if (currentDate.compareTo(getNowDate().replace("/", "-")) >= 0) {
        dates.append(currentDate)
      }
    }else{//不包含今天
      if (currentDate.compareTo(getNowDate().replace("/", "-")) > 0) {
        dates.append(currentDate)
      }
    }
    val nextDate = getWeeknDate("NEXT_WEEK", calendarWeekn)
    dates.append(nextDate)
    dates.toList
  }

  /**
    * 按周几取得（包括本周之后2周的）日期列表
    * @param placeTimeCode
    * @return
    */
  def getDatesByPlaceTimeCode(placeTimeCode:String,includeToday:Boolean): List[String] ={
    println("getDatesByPlaceTimeCode placeTimeCode = " + placeTimeCode)
    val pattern = "[0-9]+".r
    val firstDigtal = pattern.findFirstIn(placeTimeCode).getOrElse("")

    val weekn =
      if(firstDigtal.startsWith("0")){
        firstDigtal.substring(1).toInt
      }else{
        firstDigtal.toInt
      }

    return getDatesByWeekn(weekn,2,includeToday)
  }

  /**
    * 取指定月份的最后一个周日
    * @param month
    */
  def getLastSunday(calendar:Calendar): Calendar ={
    println("getLastSunday calendar = " + formate(calendar,"yyyy-MM-dd") )
    var instance = calendar;
    instance.add(Calendar.MONTH, 1) //月份+1
    instance.set(Calendar.DAY_OF_MONTH, 1) //天设为一个月的第一天
    instance.add(Calendar.DAY_OF_YEAR, -1) //本月最后一天
    instance.add(Calendar.DAY_OF_MONTH, 1 - instance.get(Calendar.DAY_OF_WEEK)) //根据月末最后一天是星期几，向前偏移至最近的周日
    println("getLastSunday lastSunday = " + formate(instance,"yyyy-MM-dd") )
    instance
  }

}
