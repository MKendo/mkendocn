package controllers

import java.io.File

import javax.inject.Inject
import play.api.db.DBApi
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

class CommonController @Inject()(cc: ControllerComponents)(dbapi: DBApi) extends AbstractController(cc) {

  /**
    * 上传文件
    *
    * @return 返回文件的相对路径和文件名，例如：user/IU001.jpg
    */
  def uploadImage() = Action(parse.multipartFormData) { implicit request => {
    request.body.file("form_imagefile").map(imgfile => {
      val fileName = imgfile.filename
      val toFile = new File(s"public/images/users/$fileName")
      toFile.createNewFile()
      //上传文件保存到指定位置
      imgfile.ref.moveFileTo(toFile, true)
      Ok("图片上传成功")
    }
    ).getOrElse(
      Ok("图片上传失败")
    )
  }
  }

  def summerUpload() = Action(parse.multipartFormData) { implicit request => {
    println("summerUpload...")
    request.body.file("imageData").map(imgfile => {
      val fileName = imgfile.filename
      val toFilePath = s"public/images/users/$fileName"
      val toFile = new File(toFilePath)

      toFile.createNewFile()
      //上传文件保存到指定位置
      imgfile.ref.moveFileTo(toFile, true)
      Ok(Json.obj(
        "status" -> 1,
        "message"->"文件上传成功",
        "img" -> s"/assets/images/users/$fileName"
      ))
    }
    ).getOrElse(
      Ok(Json.obj(
        "status" -> 0,
        "message"->"文件上传失败"
      ))
    )
  }
  }

}
