package controllers

import akka.actor.ActorSystem
import javax.inject.Inject
import models.Article
import play.api.db.DBApi
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{ArticleService, NewsService}

class SearchController @Inject()(cc: ControllerComponents, system: ActorSystem)(dbapi: DBApi) extends AbstractController(cc) {

  /**
    * 搜索的文章类型，文章表中的typeid所对应的simpletypes表中的code
    * @param searchType
    * @return
    */
  def search(searchType: String) = Action { implicit request => {
    val searchText = request.body.asFormUrlEncoded.get("searchtext").head.mkString

    val searchService = new ArticleService(dbapi)
    val articles = searchService.findByKeyword(searchText)

    if (searchType == "NEWS") {
      val loginedUserInfo = Common.loginConfirm(request.session)
      val article: Article = if(articles.isEmpty){null} else{articles(0)}
      Ok(views.html.news(loginedUserInfo,articles,article))
    }else{
      Ok(views.html.message("搜索出错了", s"页面指定的searchType不合法：$searchType", ""))
    }
    }
  }

}
