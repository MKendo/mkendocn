package models

case class MemberValidate(
                         memberIdNumber: String,
                         feeTypeCode: String,
                         feeTypeName: String,
                         startValidate: String,
                         endValidate: String,
                         commitDatetime: String,
                         amount: Int,
                         description: String,
                         )
