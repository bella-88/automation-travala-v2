package commons;

public class CommonHotelXpath {





  //===================SEARCH BAR=======================
  public static final String DOMAIN_TAB_LIST = "//div[contains(@class,'tabElement')]/span";
  public static final String DOMAIN_TAB_LIST_DYNAMIC = "(//div[contains(@class,'tabElement')]/span)[%s]";
  public static final String ACTIVITIES_TAB = "//img[contains(@src,'activities')]/following-sibling::span";

  public static final String FLIGHT_TAB = "//img[contains(@src,'flight')]/following-sibling::span";
  public static final String LANDING_PAGE_STAY_LINK = "(//div[contains(@class,'d-flex-center-y')]/ul/li)[1]/a";
  public static final String SEARCH_PRE_MONTH_BTN = "//button[@class='rdrNextPrevButton rdrPprevButton']";
  public static final String SEARCH_CURRENT_DAY = "//button[contains(@class,'rdrDay rdrDayToday')]";
  public static final String SEARCH_MONTH_NAME = "(//div[@class='rdrMonth'])[position()=1]/div[@class='rdrMonthName']";
  public static final String POPUP_EMPTY_SEARCH_CONTENT = "//div[contains(@class,'popup-content')]/div";
  public static final String POPUP_CONFIRM_BTN = "//button[contains(@class,'confirmBtn')]";
  public static final String POPUP_CLOSE_BTN = "//div[contains(@class,'Popup_close')]//*[name()='svg']";
  public static final String ICON_CLOSE_BTN = "//img[contains(@class,'Popup_close')]";
  public static final String POPUP_ERROR_CONTENT = "(//img[contains(@class,'close')]/following-sibling::h3)[1]";


  //===================SEARCH ADD ROOM=======================
  public static final String SELECT_ROOM = "(//div[contains(@class,'fullRoomInfo')]/span)[1]";
  public static final String SELECT_ADULT = "(//div[contains(@class,'fullRoomInfo')]/span)[2]";
  public static final String ADULT_LABEL = "//span[contains(@class,'RoomPickerPC_label')]";
  public static final String ADULT_SELECTED_LABEL = "//span[contains(@class,'selectedOption')]";
  public static final String ROOM_BTN = "//div[contains(@class,'RoomPickerPC_btn')]";
  public static final String ROOM_TITLE = "//div[contains(@class,'roomTitleCustom')]";
  public static final String COUNT_ROOM_TXT = "//div[contains(@class,'roomTitleCustom')]";
  public static final String HOTEL_ADD_ROOM_BTN = "//div[contains(@class,'btnAddRoom')]";
  public static final String HOTEL_DONE_ROOM_BTN = "//div[contains(@class,'btnDone')]";
  public static final String HOTEL_CANCEL_ROOM_BTN = "//div[contains(@class,'btnAddRoom')]/following-sibling::div";

  //===================WITHDRAW CONFIRMATION=======================
  public static final String EMAIL_WITHDRAW_REQUEST_CONFIRMATION_TITLE = "//span[@id=':2m']/span[text()='Withdraw request confirmation']";
  public static final String EMAIL_WITHDRAW_REQUEST_CONFIRMATION_BUTTON = "//a[contains(@href,'https://staging.travalia.cc/confirm-withdraw') and text()='Confirm'][last()]";
  public static final String EMAIL_WITHDRAW_REQUEST_CONFIRMATION_LINK = "(//a[contains(@href,'https://staging.travalia.cc/confirm-withdraw')])[2][last()]";


  public static final String CLOSE_POPUP_BTN = "//button[@class='Setting_btnClose___1k-fh']";
  public static final String COUNTRY_PAGE_REGION_FIRST = "(//span[contains(@class,'CountryPagePC_hotelUrl')])[1]";
  public static final String COUNTRY_PAGE_REGION_SECOND = "(//span[contains(@class,'CountryPagePC_hotelUrl')])[2]";
  public static final String COUNTRY_PAGE_REGION_THIRD = "(//span[contains(@class,'CountryPagePC_hotelUrl')])[2]";
  //========================================================SEARCH RESULT PAGE============================================================



  //=====================================================CRYPTO==========================================
  public static final String SELECT_CRYPTO_TXT = "//div[contains(@class,'selectCrypto')]/div/div/span";
  public static final String INPUT_CRYPTO_TXT = "//input[contains(@class,'inputSearch')]";
  public static final String INPUT_CRYPTO_SELECTED = "(//div[contains(@class,'Crypto_selected')])[1]";
  public static final String INPUT_CRYPTO_NETWORK_SELECTED = "(//div[contains(@class,'Crypto_selected')])[2]";
  public static final String CRYPTO_DYNAMIC = "(//input[@value='%s'])[2]";
  public static final String CRYPTO_MINIMUM_VALUE = "(//div[contains(@class,'minimumValue')])/i";
  public static final String CRYPTO_SELECT_COIN_CLOSE_ICON = "//img[contains(@src,'close.svg')]";
  public static final String CRYPTO_MINI_PRICE = "//div[contains(@class,'minimumValue')]/i";
  public static final String CRYPTO_POPUP_TITLE = "//div[contains(@class,'Processing_title')]/h3";

  //==========================================================MY WISHLIST===========================================
  public static final String MY_WISHLIST_TAB_LIST = "//ul[contains(@class,'tabWrapper')]/li";
  public static final String MY_WISHLIST_TAB_DYNAMIC = "(//ul[contains(@class,'tabWrapper')]/li)[2]";
  public static final String MY_WISHLIST_STAY_TOTAl_ITEM = "//p[contains(@class,'totalItem')]";
  public static final String MY_WISHLIST_LIST_ITEM = "//div[contains(@class,'itemWishlistPC')]";
  public static final String MY_WISHLIST_ACT_TOTAl_ITEM = "//div[contains(@class,'totalItem')]";
  public static final String MY_WISHLIST_ACT_TXT = "//div[contains(@class,'notData')]/h4";
  public static final String MY_WISHLIST_ACT_STEP_LIST = "//div[contains(@class,'notData')]/p";
  public static final String MY_WISHLIST_CLOSE_ICON = "//div[contains(@class,'itemWishlistClosePC')]";
  public static final String MY_WISHLIST_CLOSE_FIRST = "(//div[contains(@class,'itemWishlistClosePC')])[1]";
  public static final String MY_WISHLIST_LIST_HOTEL = "//div[contains(@class,'detailsPC')]";
  public static final String MY_WISHLIST_ITEM_BOOK_BTN = "//div[contains(@class,'detailsPC')]/button";
//  public static final String MY_WISHLIST_ITEM_BOOK_BTN = "//div[contains(@class,'detailsPC')]/button";

  public static final String POPUP_SUCCESS_PAYMENT = "//div[contains(@class, 'TvlPopup_close')]";
  public static final String MY_PROFILE_SMART = "//a[contains(@href,'my-travel-credits')]";
  public static final String MY_PROFILE_INVITE = "//a[contains(@href,'my-travel-credits')]";
  public static final String LINK_STATIC_PAGE = "(//div[contains(@class,'breadcrumb')]/span)[2]";
  //=====================MENU FOOTER===========================================
  public static final String MENU_FOOTER_LIST = "//div[contains(@class,'menuSidebar')]/a/span";
  public static final String MENU_TRAVEL_SMART_PROTECTION_URL = "//a[contains(@href,'travelsmart-protection')]";

  //==========================================================LANDING PAGE OF COIN===========================================
  public static final String COIN_BANNER_TITLE1="//div[contains(@class,'bannerContent')]/h1";
  public static final String COIN_BANNER_TITLE2="//div[contains(@class,'bannerContent')]/p";

  public static final String COIN_WHAT_IS_TITLE = "//div[@id='token-block-what']/h2";
  public static final String COIN_WHAT_IS_CONTENT="//div[@id='token-block-what']/p";

  public static final String COIN_MARKET_LABEL_LIST ="//div[contains(@class,'market')]/div/p";
  public static final String COIN_MISSION_TITLE="//div[@id='token-block-mission']//h2";
  public static final String COIN_MISSION_CONTENT ="//div[@id='token-block-mission']//p";
  public static final String COIN_MISSION_CONTENT1 ="(//div[contains(@id,'mission')]/div/p)[1]";
  public static final String COIN_MISSION_CONTENT2 ="(//div[contains(@id,'mission')]/div/p)[2]";

  public static final String COIN_TEAM_TITLE = "//div[contains(@id,'team')]/h2";
  public static final String COIN_TEAM_CONTENT = "//div[contains(@id,'team')]/p";
  public static final String COIN_MARKET_TITLE = "//div[contains(@id,'metrics')]/h2";

  public static final String COIN_USE_CASE_TITLE = "//div[contains(@class,'useCase')]/div/h2";
  public static final String COIN_PAY_TITLE = "//div[@id='token-block-pay']//h2";
  public static final String COIN_PAY_CONTENT= "//div[@id='token-block-pay']//p";

  public static final String COIN_TRADE_TITLE = "//div[@id='token-block-trade']//h2";
  public static final String COIN_TRADE_CONTENT = "//div[@id='token-block-trade']//p";

  public static final String COIN_STORE_TITLE = "//div[@id='token-block-store']//h2";
  public static final String COIN_STORE_SUB = "//div[@id='token-block-store']//p[not(@class)]";
  public static final String COIN_STORE_CONTENT = "//div[@id='token-block-store']//p[contains(@class, 'Store_storeDes')]";

  public static final String COIN_FAQ_TITLE = "//div[@id='token-block-faqs']//h2";

  public static final String COIN_TEAM_NAME = "//div[@id='token-block-team']//h5";
  public static final String COIN_TEAM_POSITION = "//div[@id='token-block-team']//span";
  public static final String COIN_TEAM_DESCRIPTION = "//div[@id='token-block-team']//p";

  public static final String COIN_TRAVEL_BOOKING_TITLE = "//img[contains(@src,'use-case')]/preceding-sibling::div/h4";
  public static final String COIN_TRAVEL_BOOKING_CONTENT = "//img[contains(@src,'use-case')]/preceding-sibling::div/p";

  public static final String COIN_USE_CASE_SUB_CONTENT = "//div[contains(@class,'useCase')]/p";

  public static final String COIN_MORE_USE_CASE_TITLE = "//img[contains(@src,'use-more')]/following-sibling::div[not(@p)]";

  public static final String COIN_MORE_USE_CASE_SUB_TITLE = "//div[contains(@class,'ContentItem')]/div/h5";
  public static final String COIN_MORE_USE_CASE_SUB_CONTENT = "//div[contains(@class,'ContentItem')]/div/p";

  public static final String COIN_TRADE_LOGO = "//div[contains(@class,'trade')]//a/img";
  public static final String COIN_TRADE_LOGO_DYNAMIC = "(//div[contains(@class,'trade')]//a/img)[%s]";
  public static final String COIN_STORE_LOGO = "//div[contains(@class,'store')]/div/div/a/img";
  public static final String COIN_STORE_LOGO_DYNAMIC = "(//div[contains(@class,'store')]/div/div/a/img)[%s]";

  public static final String COIN_FAQ_ICON = "//div[contains(@class,'faqItem')]/h5//*[name()='svg']";
  public static final String COIN_FAQ_ICON_DYNAMIC = "(//div[contains(@class,'faqItem')]/h5//*[name()='svg'])[%s]";
  public static final String COIN_FAQ_QUESTION = "//div[@id='token-block-faqs']//h5";
  public static final String COIN_FAQ_FIRST_QUESTION = "(//div[@id='token-block-faqs']//h5)[1]";
  public static final String COIN_FAQ_CONTENT = "//div[@id='token-block-faqs']//p";

//============================NFT=========================================
  public static final String BUY_NFT_HEADER = "//a[contains(@href,'/nft')]/div";
  public static final String FAQ_HEADER = "//a[text()='FAQ']";
  public static final String WHAT_NFT_HEADER = "//a[text()='What ']";
  public static final String COLLECTION_HEADER = "//a[text()='collection']";
  public static final String HOW_BUY_NFT_HEADER = "//a[contains(text(),'Buy Travala NFT')]";

  //============================INPUT AMOUNT TC - GC=========================================
  public static final String INPUT_AMOUNT_TXT="//input[@name='custom_amount']";
  public static final String ERROR_MESSAGE_AMOUNT = "//span[@class='error-message']";

  //============================YOP MAIL=========================================
  public static final String YOP_MAIL_TXT = "//input[@title='Login']";
  public static final String YOP_MAIL_SUBMIT_BTN = "//div[@id='refreshbut']";
}
