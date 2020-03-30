package controllers

import akka.actor.ActorSystem
import javax.inject.Inject
import models.Article
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{ArticleService, MemberService, NewsService}

class SearchController @Inject()(cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi) extends AbstractController(cc) {

  /**
    * 搜索的文章类型，文章表中的typeid所对应的simpletypes表中的code
    *
    * @param searchType
    * @return
    */
  def search(searchType: String) = Action { implicit request => {
    val searchText = request.body.asFormUrlEncoded.get("searchtext").head.mkString
    val loginedUserInfo = Common.loginConfirm(request.session)

    searchType match {
      case "NEWS" => {
        val searchService = new ArticleService(dbapi)
        val articles = searchService.findByKeyword(searchText)
        val article: Article = if (articles.isEmpty) null else articles(0)
        Ok(views.html.news(loginedUserInfo, articles, article))
      }
      case "MEMBERS" => {
        val memberService = new MemberService(dbapi)
        val members = memberService.findByKeyword(searchText)
        Ok(views.html.memberlist(loginedUserInfo, "ALL", members))
      }
      case _ => {
        Ok(views.html.message("搜索出错了", s"页面指定的searchType不合法：$searchType", ""))
      }
    }
   }
  }
}
