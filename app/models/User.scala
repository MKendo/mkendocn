package models

case class User(
                 id:Int,
                 name:String,
                 mobile:String,
                 password:String,
                 wxOpenid:String,
                 wxUnionid:String,
                 wxName:String,
                 wxImgurl:String,
                 description:String,
                 memberName:String)
