package interfaces.hotel;

public class LandingPageUI {

  //Header

  public static final String TRAVALA_LOGO = "//section[@class='page-header']//a[@class='navbar-brand app-logo']";
  public static final String MY_TRIP_LINK_HEADER = "//a[@class='social-auth register my-trip header-link ng-scope']";

  public static final String LANGUAGE_ICON = "//img[contains(@class,'TopHeader_langFlag')]";
  public static final String DESTINATION_LANGUAGE = "//img[contains(@src,'%s')]";
  public static final String SUBTITLE = "//h2[@class='HomePagePC_heroSubTitle___1mW14']";
  public static final String FORGOT_PASSWORD_LINK = "//a[contains(@href,'/forgot-password')]";
  //===============REGISTER FORM=======================
  public static final String REGISTER_LINK = "//a[contains(@href,'register')]/div";
  public static final String REGISTER_TITLE = "//div[contains(@class,'RegisterPC_container')]/preceding-sibling::h1";
  public static final String FIRST_NAME_TITLE = "//input[@name='first_name']/preceding-sibling::label";
  public static final String FIRST_NAME_TXT = "//input[@name='first_name']";
  public static final String FIRST_NAME_ERROR = "//input[@name='first_name']/following-sibling::span";
  public static final String LAST_NAME_TITLE = "//input[@name='last_name']/preceding-sibling::label";
  public static final String LAST_NAME_TXT = "//input[@name='last_name']";
  public static final String LAST_NAME_ERROR = "//input[@name='last_name']/following-sibling::span";
  public static final String REGISTER_EMAIL_TITLE = "//input[@name='email']/preceding-sibling::label";
  public static final String REGISTER_EMAIL_TXT = "//input[@name='email']";
  public static final String REGISTER_EMAIL_ERROR = "//input[@name='email']/following-sibling::span";
  public static final String CREATE_PASSWORD_TXT = "//input[@name='password']";
  public static final String CREATE_PASSWORD_TITLE = "//label[@for='password']";
  public static final String CREATE_PASSWORD_ERROR = "//label[@for='password']/following-sibling::span";
  public static final String CONFIRM_PASSWORD_TITLE = "//label[@for='passwordConfirm']";
  public static final String CONFIRM_PASSWORD_TXT = "//input[@name='passwordConfirm']";
  public static final String CONFIRM_PASSWORD_ERROR = "//label[@for='passwordConfirm']/following-sibling::span";
  public static final String REGISTER_BTN = "//p[@class='RegisterPC_policy___2tyv4']/preceding-sibling::button";
  public static final String POLICY_REGISTER = "//p[@class='RegisterPC_policy___2tyv4']";
  public static final String ALREADY_REGISTER = "//p[@class='RegisterPC_conditionMsg___2lxFo']";

  public static final String LANGUAGE = "//div[@class='language-switcher-wrapper__flag']//img[@class='ng-scope']";
  public static final String LOGIN_GOOGLE = "//div[@class='button-group']//button[@class='btn btn-default btn-google-login ng-isolate-scope']";
  public static final String CURRENCIES_DYNAMIC = "//div[@class='TvlTopHeader_currencyOption___firnn ' and contains(text(),'%s')]";

  //POPUP HEADER
  public static final String LANDING_STAY_LINK = "(//ul[contains(@class,'TvlTopHeader_navTabHome')]/li/a)[1]";
  public static final String LANDING_FLIGHT_LINK = "(//ul[contains(@class,'TvlTopHeader_navTabHome')]/li/a)[2]";
  public static final String LANDING_ACTIVITIES_LINK = "(//ul[contains(@class,'TvlTopHeader_navTabHome')]/li/a)[3]";

  public static final String HEADER_ACTIVATE_NFT_URL = "//a[contains(@href,'smart-program?app_active')]";
  public static final String HEADER_EXPLORE_NFT_URL = "//a[contains(@href,'nft')]";
  public static final String HEADER_MY_TRIP_URL = "//span[contains(@class,'textUpper')]";
  public static final String HEADER_GOVERNANCE_URL = "//a[contains(@href,'governance')]";
  public static final String HEADER_SIGN_UP_URL = "//a[contains(@href,'register')]/div";
  public static final String HEADER_WALLET_URL = "//li[contains(@class,'totalBalance')]/div/img";
  public static final String HEADER_AVATAR = "//div[contains(@class,'TopHeader_avatar')]";
  public static final String HEADER_LOGIN_URL = "//li[contains(@class, 'TvlTopHeader_loginNavItem')]";

  public static final String LANDING_MY_TRIP_LINK = "//span[@class='TvlTopHeader_textUpper__rzjpk TvlTopHeader_color__EeDl3']";
  public static final String LANDING_MY_TRIP_CLOSE = "//button[contains(@class,'SearchMyTrip_close')]";
  public static final String LANDING_MY_TRIP_LIST_HOTEL = "//div[@class='SearchMyTrip_selectedDomain___1969X']";
  public static final String LANDING_MY_TRIP_LIST_DOMAIN = "//ul[@class='SearchMyTrip_dropdown___Ko2Dk']/li";
  public static final String LANDING_MY_TRIP_DYNAMIC_DOMAIN = "(//ul[@class='SearchMyTrip_dropdown___Ko2Dk']/li)[%s]";
  public static final String LANDING_MY_TRIP_ORDER_NUMBER_LABEL = "//label[@for='order_id']";
  public static final String LANDING_MY_TRIP_LAST_NAME_LABEL = "//label[@for='last_name']";
  public static final String LANDING_MY_TRIP_SEARCH = "//button[@class='SearchMyTrip_btnSave___3OPCV']";
  public static final String LANDING_MY_TRIP_ERROR_ORDER = "(//span[@class='error-message'])[1]";
  public static final String LANDING_MY_TRIP_ERROR_LAST_NAME = "(//span[@class='error-message'])[1]";

  public static final String MY_TRIP_POPUP_EXPECT_TEXT = "//hr[@class='hr-text']";


  //======================BANNER====================
  public static final String BANNER_TITLE = "//h1[contains(@class,'heroTitle')]";
  public static final String BANNER_TITLE_SUB = "//h2[contains(@class,'heroSubTitle')]";


  //Body
  public static final String LANDING_CUSTOMER_SUPPORT_TEXT = "(//h3[contains(@class,'mainFeaturesTitle')])[1]";
  public static final String LANDING_FOUR_BENEFIT_LIST = "//h3[contains(@class,'mainFeaturesTitle')]";
  public static final String LANDING_FOUR_BENEFIT_DYNAMIC = "(//h3[contains(@class,'mainFeaturesTitle')])[%s]";
  public static final String LANDING_FOUR_BENEFIT_CONTENT_LIST = "//p[contains(@class,'main-features__subtitle')]";
  public static final String LANDING_FOUR_BENEFIT_CONTENT_DYNAMIC = "(//p[contains(@class,'main-features__subtitle')])[%s]";


  public static final String LANDING_SECTION_LIST = "//h2[contains(@class,'HomePagePC_sectionTitle')]";
  public static final String LANDING_SECTION_DYNAMIC = "(//h2[contains(@class,'HomePagePC_sectionTitle')])[%s]";

  public static final String LANDING_DESTINATION_LIST = "//img[contains(@src,'top-destination')]";
  public static final String LANDING_DESTINATION_DYNAMIC = "(//h4[contains(@class,'locationItemTitle')])[%s]";
  public static final String LANDING_COUNTRY_LIST = "//h5[contains(@class,'ItemCountry')]";

  public static final String LANDING_DESTINATION_FIRST = "(//div[@class='HomePagePC_locationItemHoverInfo___3ydTa'])[1]";
  public static final String LANDING_DESTINATION_LAST = "(//div[@class='HomePagePC_locationItemHoverInfo___3ydTa'])[12]";
  public static final String LANDING_DESTINATION_STARTING_PRICE = "(//div[@class='HomePagePC_locationItemHoverInfo___3ydTa']/div[@class='HomePagePC_locationItemPrice___2OAoR'])/span[1]";
  public static final String LANDING_DESTINATION_STARTING_PRICE_FIRST = "((//div[@class='HomePagePC_locationItemHoverInfo___3ydTa']/div[@class='HomePagePC_locationItemPrice___2OAoR'])/span[1])[1]";
  public static final String LANDING_DESTINATION_STARTING_PRICE_LAST = "((//div[@class='HomePagePC_locationItemHoverInfo___3ydTa']/div[@class='HomePagePC_locationItemPrice___2OAoR'])/span[1])[12]";
  public static final String LANDING_DESTINATION_SEARCH_PROPERTY = "//div[@class='HomePagePC_locationItemSearchInLocationTitle___3UzV3']";
  public static final String LANDING_DESTINATION_SEARCH_PROPERTY_FIRST = "(//div[@class='HomePagePC_locationItemSearchInLocationTitle___3UzV3'])[1]";
  public static final String LANDING_DESTINATION_SEARCH_PROPERTY_LAST = "(//div[@class='HomePagePC_locationItemSearchInLocationTitle___3UzV3'])[12]";

  //Destinations
  public static final String DESTINATION_DYNAMIC = "//div[contains(@class,'HomePagePC_locationItemMainInfo')]/h4[contains(text(),'%s')]";

  public static final String LANDING_TOP_COUNTRY_TXT = "//div[contains(@class,'HomePagePC_topCountriesItem')]/h5";
  public static final String LANDING_TOP_COUNTRY_DISPLAY = "//div[@aria-hidden='false']//div[contains(@class,'HomePagePC_topCountriesItem')]/h5";
  public static final String LANDING_DESTINATION = "//div[@aria-hidden='false']//div[contains(@class,'HomePagePC_locationItemMainInfo')]/h4";
  public static final String LANDING_DESTINATION_TXT = "(//div[@aria-hidden='false']//div[contains(@class,'HomePagePC_locationItemMainInfo')]/h4)[%s]";
  public static final String LANDING_LIST_DESTINATION_DISPLAY = "//div[@aria-hidden='false']//div[contains(@class,'HomePagePC_locationItemMainInfo')]/..";

  public static final String TITLE_COUNTRY = "(//h2[@class='HomePagePC_sectionTitle___3-2ua']/text()[last()]";
  public static final String TOP_COUNTRY_LIST = "//div[contains(@class,'topCountriesItem')]/h5";
  public static final String TOP_COUNTRY_TEXT = "//div[contains(@class,'topCountriesSection')]/div/h2/span";
  public static final String TOP_COUNTRY_DYNAMIC = "//div[contains(@style,'%s')]/h5";

  //======================BANNER CAMPAIGN PROMOTION====================
  public static final String CAMPAIGN_FIRST_TITLE = "//div[contains(@class,'Home_bannerNft')]/h3";
  public static final String NFT_BANNER_TITLE = "//div[contains(@class,'Home_bannerContent')]/h3";
  public static final String NFT_BANNER_LEARN_MORE = "//div[contains(@class,'Home_bannerItem')]/h5";

  //==============================PAYMENT OPTION==============================================================================
  public static final String PAYMENT_OPTION_BTN = "//div[contains(@class,'CryptoFriendlyFooter')]/a";
  public static final String PREV_ARROW_ICON = "//div[@class='slick-arrow slick-prev']//*[name()='svg']";
  public static final String NEXT_ARROW_ICON = "//div[@class='slick-arrow slick-next']//*[name()='svg']";
  public static final String CRYPTO_CURRENT_FRIENDLY_TITLE = "//h2[contains(@class,'Footer_title')]";
  public static final String CRYPTO_CURRENT_FRIENDLY_CONTENT = "//p[contains(@class,'Footer_desc')]";
  public static final String AVA_PAYMENT_TEST = "(//div[contains(@class,'slick-current')])[position()=3]//div//div";
  public static final String AVA_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'travala.png')]";
  public static final String CREDIT_CARD_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'ic-credit-card.svg')]";
  public static final String SWIPE_CARD_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'swipe.svg')]";
  public static final String CRYPTO_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'Crypto.comPay.png')]";
  public static final String UTRUST_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'utrust.svg')]";
  public static final String VNPAY_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'vn_pay.png')]";
  public static final String BTC_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'btc.png')]";
  public static final String ETH_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'eth.png')]";
  public static final String XRP_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'ripple.png')]";
  public static final String USDT_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'USDT.png')]";
  public static final String BCH_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'bch.png')]";
  public static final String LTC_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'ltc.png')]";
  public static final String EOS_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'eos.png')]";
  public static final String BNB_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'bnb.png')]";
  public static final String LINK_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'chainlink.svg')]";
  public static final String XRM_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'XMR.png')]";
  public static final String VET_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'VET.svg')]";
  public static final String XYO_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'XYO.png')]";
  public static final String ADA_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'ada.png')]";
  public static final String TRX_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'trx.png')]";
  public static final String SXP_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'SXP.svg')]";
  public static final String STPT_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'STPT.svg')]";
  public static final String USDC_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'USDC.png')]";
  public static final String DASH_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'dash.png')]";
  public static final String XEM_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'NEM.png')]";
  public static final String BAT_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'travala_bat_coin-min.png')]";
  public static final String ZIL_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'zil.svg')]";
  public static final String BUSD_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'BUSD.png')]";
  public static final String PAX_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'pax.png')]";
  public static final String WAVES_PAYMENT = "//div[contains(@class,'slick-slide')]//img[contains(@src,'WAVES.png')]";
  public static final String TUSD_PAYMENT = "//div[contains(@class,'slick-slide')]//img[contains(@src,'TUSD.png')]";
  public static final String ARK_PAYMENT = "//div[contains(@class,'slick-slide')]//img[contains(@src,'ark.svg')]";
  public static final String DAI_PAYMENT = "//div[contains(@class,'slick-slide)]//img[contains(@src,'dai.png')]";
  public static final String NANO_PAYMENT = "(//div[contains(@class,'slick-slide')]//img[contains(@src,'nano.png')])[position()=2]";
  public static final String DGB_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'dgb.png')]";
  public static final String KMD_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'kmd.png')]";
  public static final String XZC_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'zcoin.svg')]";
  public static final String GUSD_PAYMENT = "//div[contains(@class,'slick-slide slick-active')]//img[contains(@src,'GUSD.png')]";
  //===============================================Footer==============  0============================================

  public static final String FOOTER_CONTENT_ACCEPT_PAYMENT = "//div[contains(@class,'footerLogoBlock')]/p";
  public static final String FOOTER_PAGE_LIST = "//div[contains(@class,'linkGroup')]/ul/li/a";
  public static final String FOOTER_ACCEPT_PAYMENT_LIST = "//div[contains(@class,'acceptPayments')]/img";

  //TRAVALA.COM
  public static final String TRAVALA_COLUMN = "(//div[contains(@class,'linkGroup')]/span)[1]";
  public static final String COLUMN_COMMUNITY_LIST = "//span[text()='COMMUNITY']/following-sibling::ul/li/a";
  public static final String COLUMN_COMMUNITY_DYNAMIC = "(//span[text()='COMMUNITY']/following-sibling::ul/li/a)[%s]";
  public static final String COLUMN_LIST = "//a[contains(@href,'%s')]";
  public static final String SMART_PROGRAM_LINK_FOOTER = "(//a[contains(@href,'smart')])[2]";
  public static final String GIFT_CARD_FOOTER_LINK = "//a[contains(@href,'gift-cards')]";

  public static final String SUPPORT_COLUMN = "(//div[contains(@class,'linkGroup')]/span)[2]";
  public static final String USEFUL_COLUMN = "(//div[contains(@class,'linkGroup')]/span)[3]";
  public static final String RESOURCES_COLUMN = "(//div[contains(@class,'linkGroup')]/span)[4]";
  public static final String COMMUNITY_COLUMN = "(//div[contains(@class,'linkGroup')]/span)[5]";

  //==================================SEARCH HOTEL======================================================================================

  public static final String SEARCH_HOTEL_TEXTBOX_FIRST = "//input[contains(@class,'searchInput')]";
  public static final String SEARCH_HOTEL_TEXTBOX_SECOND = "(//input[contains(@class,'TvlSearchBoxPC_searchInput')])[2]";
  public static final String SEARCH_HOTEL_TEXTBOX_COUNTRY = "//li[contains(@class,'SearchBoxPC_country')]/span/mark";
  public static final String RESULT_TYPE_FIRST = "(//span[contains(@class,'TvlSearchBoxPC_searchResultsType')])[1]";
  public static final String SELECTBOX_SEARCH = "//div[contains(@class,'TvlSearchBoxPC_searchResults')]";
  public static final String NO_RESULT_SEARCH = "//p[contains(@class,'notResults')]";
  public static final String NO_RESULT_SEARCH_CLOSE = "//img[contains(@class,'closeSearch')]";

  public static final String HOTEL_PROPERTY_TEXTBOX = "(//li[contains(@class,'PC_property')]/span)[2]";
  public static final String SELECT_BOX_COUNTRY = "(//li[contains(@class,'PC_country')]/span)[2]";


  public static final String ADULTS_CHILD_TEXTBOX = "//div[@class='TvlSearchBoxPC_block___149G8 ']/span";

  public static final String CHECKINOUT_DATETIME = "(//input[@custom-date-picker])[position()=2]";
  public static final String HOTEL_DATEPICKER = "//div[contains(@class,'dateBlock')]/span";
  public static final String MONTH_NAME = "(//div[@class='rdrMonthName'])[1]";
  public static final String CALENDAR_LIST = "//div[contains(@class,'rdrCalendarWrapper')]";
  public static final String MONTH_LIST = "//div[contains(@class,'rdrMonthsHorizontal')]";
  public static final String POPUP_CALENDAR = "//div[@class='rdrMonthAndYearWrapper']";
  public static final String LEFT_MONTH_BTN_OLD = "(//div[@class='calendar left']//th[@class='month'])[position()=4]";
  public static final String LEFT_MONTH_BTN = "(//div[@class='rdrDays'])[position()=2]";
  public static final String RIGHT_MONTH_BTN = "(//div[@class='rdrDays'])[position()=1]";
  public static final String RIGHT_MONTH_BTN_OLD = "//div[@class='calendar right']//th[@class='month']";
  public static final String LEFT_ARROW_ICON = "//i[@class='fa fa-chevron-left glyphicon glyphicon-chevron-left']";
  public static final String ALERT_ENTER_NAME_SEARCH = "//div[@class='modal-body ng-scope']//button[@class='close']";

  public static final String LANDING_SEARCH_BUTTON = "//button[contains(@class,'btnSearch')]";
  public static final String SEARCH_BUTTON_ADULTS = "//button[@class='TvlSearchBoxPC_searchBtn___3McoI']";




  public static final String FOOTER_LIST_TEXT = "//div[contains(@class,'footerLogoBlock')]/p | //div[@class=' TvlFooter_linkGroup__nftlV']/span";
  public static final String FOOTER_LIST_TEXT_DYNAMIC = "(//div[contains(@class,'footerLogoBlock')]/p | //div[@class=' TvlFooter_linkGroup__nftlV']/span)[%s]";
  public static final String FOOTER_LIST_TEXT_IN_TRAVALA_COLUMN = "//span[text()='TRAVALA.COM']/following-sibling::ul//a";
  public static final String FOOTER_LIST_TEXT_IN_TRAVALA_COLUMN_DYNAMIC = "(//span[text()='TRAVALA.COM']/following-sibling::ul//a)[%s]";
  public static final String FOOTER_LIST_TEXT_IN_SUPPORT_COLUMN = "//span[text()='SUPPORT']/following-sibling::ul//a";
  public static final String FOOTER_LIST_TEXT_IN_SUPPORT_COLUMN_DYNAMIC = "(//span[text()='SUPPORT']/following-sibling::ul//a)[%s]";
  public static final String FOOTER_LIST_TEXT_IN_USEFUL_LINKS_COLUMN = "//span[text()='USEFUL LINKS']/following-sibling::ul//a";
  public static final String FOOTER_LIST_TEXT_IN_USEFUL_LINKS_COLUMN_DYNAMIC = "(//span[text()='USEFUL LINKS']/following-sibling::ul//a)[%s]";
  public static final String FOOTER_LIST_TEXT_IN_RESOURCES_COLUMN = "//span[text()='RESOURCES']/following-sibling::ul//a";
  public static final String FOOTER_LIST_TEXT_IN_RESOURCES_COLUMN_DYNAMIC = "(//span[text()='RESOURCES']/following-sibling::ul//a)[%s]";
  public static final String FOOTER_LIST_TEXT_IN_COMMUNITY_COLUMN = "//span[text()='COMMUNITY']/following-sibling::ul//a";
  public static final String FOOTER_LIST_TEXT_IN_COMMUNITY_COLUMN_DYNAMIC = "(//span[text()='COMMUNITY']/following-sibling::ul//a)[%s]";
  
  //===================SEARCH BAR=======================
  public static final String SEARCH_BAR_LIST_TAB = "//div[contains(@class, 'HomePagePC_tabElement')]";
  public static final String SEARCH_BAR_BUTTON_SEARCH = "//button[contains(@class,'btnSearch')]";

  //Search bar for Hotel
  public static final String SEARCH_HOTEL_TEXTBOX = "//input[contains(@class,'TvlSearchBoxPC_searchInput')]";
  public static final String SEARCH_HOTEL_DATE_BLOCK = "//div[contains(@class,'TvlSearchBoxPC_dateBlock')]";
  public static final String SEARCH_HOTEL_ROOM_INFO = "//div[contains(@class,'TvlSearchBoxPC_fullRoomInfo')]";
  //Search bar for Flight
  public static final String SEARCH_FLIGHTS_SELECT_FLIGHT_TYPE = "//div[contains(@class,'TvlSearchFlight_flightType')]//span";
  public static final String SEARCH_FLIGHTS_FROM_LOCATION = "//div[contains(@class,'TvlSearchFlight_fromSelect')]//input";
  public static final String SEARCH_FLIGHTS_TO_LOCATION = "//div[contains(@class,'TvlSearchFlight_pc')]/input";
  public static final String SEARCH_FLIGHTS_DATE_BLOCK = "//div[contains(@class,'TvlSearchFlight_dateBlock')]";
  public static final String SEARCH_FLIGHTS_PASSENGER = "//div[contains(@class,'TvlSearchFlight_passenger')]";
  //Search bar for Activities
  public static final String SEARCH_ACTIVITIES_TEXTBOX = "//div[contains(@class,'TvlSearchActivitiesPC_searchInput')]/input";
  public static final String SEARCH_ACTIVITIES_DATE_BLOCK = "//div[contains(@class,'TvlSearchActivitiesPC_dateBlock')]";

  //===================HOME PAGE CONTENT TEXT=======================
  public static final String HOME_PAGE_MAIN_FEATURE_TITLE = "//div[contains(@class, 'HomePagePC_mainFeaturesItem')]//h3";
  public static final String HOME_PAGE_MAIN_FEATURE_TITLE_DYNAMIC = "(//div[contains(@class, 'HomePagePC_mainFeaturesItem')]//h3)[%s]";
  public static final String HOME_PAGE_MAIN_FEATURE_CONTENT = "//div[contains(@class, 'HomePagePC_mainFeaturesItem')]//p";
  public static final String HOME_PAGE_MAIN_FEATURE_CONTENT_DYNAMIC = "(//div[contains(@class, 'HomePagePC_mainFeaturesItem')]//p)[%s]";
  public static final String HOME_PAGE_SECTION_TITLE_LIST = "//h2[contains(@class, 'HomePagePC_sectionTitle')]";
}