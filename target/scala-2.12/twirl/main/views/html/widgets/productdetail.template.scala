
package views.html.widgets

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object productdetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, starrating: String, priceold: String, pricenew: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*2.1*/("""<section>
    <div class="container">
        <div class="section-content">
            <div class="row">
                <div class="product">
                    <div class="col-md-5">
                        <div class="product-image">
                            <div class="zoom-gallery">
                                <a href="http://placehold.it/460x460" title="Title Here 1"><img src="http://placehold.it/460x460" alt=""></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="product-summary">
                            <h2 class="product-title">"""),_display_(/*16.56*/title),format.raw/*16.61*/("""</h2>
                            <div class="product_review">
                                <ul class="review_text list-inline">
                                    <li>
                                        <div class="star-rating"><span style="width: """),_display_(/*20.87*/starrating),format.raw/*20.97*/(""";"></span></div>
                                    </li>
                                    <li><a href="#"><span>2</span>Reviews</a></li>
                                    <li><a href="#">Add reviews</a></li>
                                </ul>
                            </div>
                            <div class="price"> <del><span class="amount">￥"""),_display_(/*26.77*/priceold),format.raw/*26.85*/("""</span></del> <ins><span class="amount">￥"""),_display_(/*26.127*/pricenew),format.raw/*26.135*/("""</span></ins> </div>
                            <div class="short-description">
                                <p>Donec volutpat purus tempor sem molestie, sed blandit lacus posuere. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut posuere mollis nulla ut consectetur.</p>
                            </div>
                            <div class="tags"><strong>SKU:</strong> EA34</div>
                            <div class="category"><strong>Category:</strong> <a href="#">Book</a>, <a href="#">Note Book</a></div>
                            <div class="tags"><strong>Tags:</strong> <a href="#">Bag</a>, <a href="#">Ladies Bag</a></div>
                            <div class="cart-form-wrapper mt-30">
                                <form enctype="multipart/form-data" method="post" class="cart">
                                    <input type="hidden" value="productID" name="add-to-cart">
                                    <table class="table variations no-border">
                                        <tbody>
                                        <tr>
                                            <td class="name">Amount</td>
                                            <td class="value">
                                                <div class="quantity buttons_added">
                                                    <input type="button" class="minus" value="-">
                                                    <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                                    <input type="button" class="plus" value="+">
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <button class="single_add_to_cart_button btn btn-theme-colored" type="submit">加入购物车</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="horizontal-tab product-tab">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1" data-toggle="tab">详细</a></li>
                                <li><a href="#tab2" data-toggle="tab">规格</a></li>
                                <li><a href="#tab3" data-toggle="tab">评价</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab1">
                                    <h3>"""),_display_(/*64.42*/title),format.raw/*64.47*/(""" """),format.raw/*64.48*/("""详细说明</h3>
                                    <p>One Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quaerat, iste, architecto ullam tenetur quia nemo ratione tempora consectetur quos minus voluptates nisi hic alias libero explicabo reiciendis sint ut quo nulla ipsa aliquid neque molestias et qui sunt. Odit, molestiae. One Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quaerat, iste, architecto ullam tenetur quia nemo ratione tempora consectetur quos minus voluptates nisi hic alias libero explicabo reiciendis sint ut quo nulla ipsa aliquid neque molestias et qui sunt. Odit, molestiae.</p>
                                    <p>One Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quaerat, iste, architecto ullam tenetur quia nemo ratione tempora consectetur quos minus voluptates nisi hic alias libero explicabo reiciendis sint ut quo nulla ipsa aliquid neque molestias et qui sunt. Odit, molestiae.</p>
                                </div>
                                <div class="tab-pane fade" id="tab2">
                                    <table class="table table-striped">
                                        <tbody>
                                        <tr>
                                            <th>Brand</th>
                                            <td><p>Envato</p></td>
                                        </tr>
                                        <tr>
                                            <th>Color</th>
                                            <td><p>Black</p></td>
                                        </tr>
                                        <tr>
                                            <th>Size</th>
                                            <td><p>Large, Medium</p></td>
                                        </tr>
                                        <tr>
                                            <th>Weight</th>
                                            <td>27 kg</td>
                                        </tr>
                                        <tr>
                                            <th>Dimensions</th>
                                            <td>16 x 22 x 123 cm</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane fade" id="tab3">
                                    <div class="reviews">
                                        <ol class="commentlist">
                                            <li class="comment">
                                                <div class="media"> <a href="#" class="media-left"><img class="img-circle" alt="" src="https://placehold.it/75x75" width="75"></a>
                                                    <div class="media-body">
                                                        <ul class="review_text list-inline">
                                                            <li>
                                                                <div title="Rated 5.00 out of 5" class="star-rating"><span style="width: 100%;">5.00</span></div>
                                                            </li>
                                                            <li>
                                                                <h5 class="media-heading meta"><span class="author">Tom Joe</span> – Mar 15, 2015:</h5>
                                                            </li>
                                                        </ul>
                                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec volutpat purus tempor sem molestie, sed blandit lacus posuere. Lorem ipsum dolor sit amet.</div>
                                                </div>
                                            </li>
                                            <li class="comment">
                                                <div class="media"> <a href="#" class="media-left"><img class="img-circle" alt="" src="https://placehold.it/75x75" width="75"></a>
                                                    <div class="media-body">
                                                        <ul class="review_text list-inline">
                                                            <li>
                                                                <div title="Rated 4.00 out of 5" class="star-rating"><span style="width: 80%;">4.00</span></div>
                                                            </li>
                                                            <li>
                                                                <h5 class="media-heading meta"><span class="author">Mark Doe</span> – Jan 23, 2015:</h5>
                                                            </li>
                                                        </ul>
                                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec volutpat purus tempor sem molestie, sed blandit lacus posuere. Lorem ipsum dolor sit amet.</div>
                                                </div>
                                            </li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <h3 class="line-bottom">相关推荐</h3>
                    <div class="row multi-row-clearfix">
                        <div class="products related">
                            <div class="col-sm-6 col-md-3 col-lg-3 mb-sm-30">
                                """),_display_(/*137.34*/widgets/*137.41*/.productdesc(false, "明心剑性头巾", "100%", "50")),format.raw/*137.84*/("""
                            """),format.raw/*138.29*/("""</div>
                            <div class="col-sm-6 col-md-3 col-lg-3 mb-sm-30">
                                """),_display_(/*140.34*/widgets/*140.41*/.productdesc(false, "抗菌汗取", "100%", "80")),format.raw/*140.82*/("""
                            """),format.raw/*141.29*/("""</div>
                            <div class="col-sm-6 col-md-3 col-lg-3 mb-sm-30">
                                """),_display_(/*143.34*/widgets/*143.41*/.productdesc(false, "熊猫包", "100%", "30")),format.raw/*143.81*/("""
                            """),format.raw/*144.29*/("""</div>
                            <div class="col-sm-6 col-md3 col-lg-3">
                                """),_display_(/*146.34*/widgets/*146.41*/.productdesc(false, "明剑雨伞", "100%", "45")),format.raw/*146.82*/("""
                            """),format.raw/*147.29*/("""</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
<!-- end main-content -->
"""))
      }
    }
  }

  def render(title:String,starrating:String,priceold:String,pricenew:String): play.twirl.api.HtmlFormat.Appendable = apply(title,starrating,priceold,pricenew)

  def f:((String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (title,starrating,priceold,pricenew) => apply(title,starrating,priceold,pricenew)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Feb 14 11:46:49 CST 2020
                  SOURCE: D:/products/mkendocn/app/views/widgets/productdetail.scala.html
                  HASH: 68a19032dade63f131e956ccb22b6567d6afb991
                  MATRIX: 766->1|932->72|960->74|1682->769|1708->774|1998->1037|2029->1047|2426->1417|2455->1425|2525->1467|2555->1475|5425->4318|5451->4323|5480->4324|11476->10292|11493->10299|11558->10342|11617->10372|11765->10492|11782->10499|11845->10540|11904->10570|12052->10690|12069->10697|12131->10737|12190->10767|12328->10877|12345->10884|12408->10925|12467->10955
                  LINES: 21->1|26->1|27->2|41->16|41->16|45->20|45->20|51->26|51->26|51->26|51->26|89->64|89->64|89->64|162->137|162->137|162->137|163->138|165->140|165->140|165->140|166->141|168->143|168->143|168->143|169->144|171->146|171->146|171->146|172->147
                  -- GENERATED --
              */
          