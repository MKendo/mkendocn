package models
import java.text.SimpleDateFormat

import org.joda.time.DateTime

/**
  * 新闻，还缺少主图url
  * @param title
  * @param shotcontext
  * @param context
  * @param eventStartDatetime
  * @param eventAddress
  */
case class Article(code: String,
                   title: String,
                   shortcontent: String,
                   content: String,
                   eventStartDatetime: String,
                   eventAddress: String,
                   createrName:String,
                   imgurl: String){

  private def formatData(line:DateTime)={
    val date=new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
    val dateFormated=date.format(line)
    val dateFf=date.parse(dateFormated).getTime
    dateFf
  }

}

