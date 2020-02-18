package models

case class Member(
                 id:Int,
                 name: String,
                 mobile: String,
                 idTypeName: String,
                 idNumber: String,
                 description: String,
                 startValidate: String,
                 endValidate: String,
                 feeTypeCode: String, //费用标准编码，例如：PY6000
                 feeTypeName: String, //费用标准名称，例如6000/年
                 enable: Int
                 )