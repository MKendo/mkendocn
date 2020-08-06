package models

case class Booking( id:Int,
                    name: String,
                    mobile: String,
                    wxopenid: String,
                    placetimeCode: String,
                    placetimeName:String,
                    classdate: String,
                    whereknowusCode: String,
                    whereknowusName: String,
                    coursename: String,
                    commitdatetime: String,
                    height: String,
                    weight: String,
                    description: String
                  ){

  def getStartDatetime(): String ={
    println("placetimeName = " + placetimeName)
    return s"$classdate ${placetimeName.substring(placetimeName.indexOf('1'))}"
  }

  def getLastDescription(): String = {
    val deses = description.split("__")
    return deses(deses.size-1)
  }

  def getSimpleCourseName():String = {
    val pattern = "[a-zA-Z0-9]*\\元".r
    pattern.findFirstIn(coursename).getOrElse(coursename)
  }
}
