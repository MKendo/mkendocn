package controllers

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import play.api.mvc.Session

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
  def getYesterday():String= {
    var dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd")
    var cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, -1)
    var yesterday = dateFormat.format(cal.getTime())
    yesterday
  }

  /**
    * 获取本周未第一天
    * @return
    */
  def getCurrentWeekStart():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
    var cal:Calendar =Calendar.getInstance();
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
    var cal:Calendar =Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR,7)
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
    var cal:Calendar =Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR,7)
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//这种输出的是上个星期周日的日期，因为老外把周日当成第一天
    cal.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人的本周日的日期
    period=df.format(cal.getTime())
    period
  }

}
