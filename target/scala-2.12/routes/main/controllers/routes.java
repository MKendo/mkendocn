// @GENERATOR:play-routes-compiler
// @SOURCE:D:/products/mkendocn/conf/routes
// @DATE:Tue Feb 04 16:32:13 CST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBookingController BookingController = new controllers.ReverseBookingController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseNewsController NewsController = new controllers.ReverseNewsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLoginController LoginController = new controllers.ReverseLoginController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSearchController SearchController = new controllers.ReverseSearchController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMkendoController MkendoController = new controllers.ReverseMkendoController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBookingController BookingController = new controllers.javascript.ReverseBookingController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseNewsController NewsController = new controllers.javascript.ReverseNewsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLoginController LoginController = new controllers.javascript.ReverseLoginController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSearchController SearchController = new controllers.javascript.ReverseSearchController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMkendoController MkendoController = new controllers.javascript.ReverseMkendoController(RoutesPrefix.byNamePrefix());
  }

}
