package interfaces.hotel.myProfile;

public class MyWishListPageUI {
  public static String language = System.getProperty("language");
  {
    System.out.println("language: " + language);
  }
  public static final String USER_NAME_LOGGED = "//*[@class='home-hero__subtitle ng-scope']";
  public static final String MY_WISH_LIST_TITLE = "//div[@class='MyWishlist_header___1KMfQ']/h1";
  public static final String MY_WISH_LIST_HOTEL = "//li[@class='TabsPC_active___3z3xl']";
  public static final String MY_WISH_LIST_ACTIVITIES = "(//ul[@class='TabsPC_tabWrapper___3Y2vs']/li)[2]";
  public static final String MY_WISH_LIST_HOTEL_FAVOURITES = "//div[@class='MyWishlist_itemWishlistClosePC___e_aoO']";
  public static final String MY_WISH_LIST_HOTEL_SAVED = "//p[@class='MyWishlist_totalItem___1jO7P']";
  public static final String MY_WISH_LIST_ACTIVITIES_SAVED = "//div[@class='MyWishlist_totalItem___1jO7P']";
  public static final String MY_WISH_LIST_STEP_GET_STARTED = "//div[@class='MyWishlist_notData___2SFNn']/h4";
  public static final String MY_WISH_LIST_STEP_ONE = "(//div[@class='MyWishlist_notData___2SFNn']/p)[1]";
  public static final String MY_WISH_LIST_STEP_TWO = "(//div[@class='MyWishlist_notData___2SFNn']/p)[2]";
  public static final String MY_WISH_LIST_STEP_THREE = "(//div[@class='MyWishlist_notData___2SFNn']/p)[3]";
  public static final String MY_WISH_PREVIOUS_TXT = "//a[@aria-label='Go to previous page']";
  public static final String MY_WISH_NEXT_TXT = "//a[@aria-label='Go to next page']";


}
