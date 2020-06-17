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

}
