package interfaces.hotel;

public class SearchPageUI {
  //==========================Multi language=========================

  public static final String SEARCH_TXT_TITLE = "//img[contains(@src,'magnifying-glass.svg')]/following-sibling::input";
  public static final String SEARCH_RESULT_LINK1 = "//ul[@class='NormalView_breadcrumb___14Pin']/li[1]";
  public static final String SEARCH_RESULT_LINK2 = "//ul[@class='NormalView_breadcrumb___14Pin']/li[2]";
  public static final String SEARCH_RESULT_HEADER_MENU = "//h2[contains(@class,'labelSearch')]";
  public static final String SEARCH_RESULT_RESET_FILTER_BTN = "//h2[contains(@class,'labelSearch')]/button";
  public static final String SEARCH_RESULT_TEXT_BOX_SEARCH = "//input[@name='hotel_name']";
  public static final String SEARCH_RESULT_SIDE_PRICE_MIN = "(//div[contains(@class,'FilterSidebar_priceGroup')]/p)[1]";
  public static final String SEARCH_RESULT_SIDE_PRICE_MAX = "(//div[contains(@class,'FilterSidebar_priceGroup')]/p)[2]";
  public static final String SEARCH_RESULT_ICON_FIRST_COIN = "//span[contains(@class,'mainPrice')]/img";
  public static final String SEARCH_RESULT_FIRST_PRICE = "(//span[contains(@class,'mainPrice')]/span)[2]";

  public static final String RESULTS_SEARCH_TXT1 = "(//h2[@class='NormalView_hotelCount___u6zch']/span)[position()=2]";
  public static final String COUNT_RESULTS_HOTEL = "(//div[contains(@class,'totalItems')]/div/span)[1]";
  public static final String RESULTS_SEARCH_FAILED_TXT = "//div[contains(@class,'NoItemsMessage')]/h3";
  public static final String RESET_FILTER_BTN = "//h2[contains(@class,'labelSearch')]/button";
  public static final String LOADING_SEARCH_RESULT_ICON = "//*[contains(@class,'fa-spin')]";
  public static final String SEARCH_HOTELS_NAME_TXT = "//input[@name='hotel_name']";
  public static final String HOTELS_NAME_LINK_PROPERTY = "//a[contains(@class,'itemName')]";

  //=============VIEW_SEARCH- RESULT=============================================
  public static final String OK_BUTTON_FAILED = "//button[@class='TvlButtonPC_btn___I_--R ']";
  public static final String MINI_MAP_VIEW = "//div[contains(@class,'miniMap')]/span";
    public static final String MAP_VIEW_LIST_HOTEL = "//div[contains(@class,'MiniPC_main')]";
    public static final String MAP_VIEW_SEARCH_RESULT_TXT = "//div[contains(@class,'listHeader')]/span";
    public static final String MAP_VIEW_SEE_MORE_BTN = "//div[contains(@class,'seeMore')]/button/span";
  public static final String MAP_VIEW_CLOSE_BTN = "//button[contains(@class,'btnCloseMap')]";
  public static final String MAP_VIEW_SEARCH_TXT = "//div[contains(@class,'hotelSearch')]/input";
  public static final String MAP_VIEW_FILTER_LABEL = "//div[contains(@class,'barWrap')]/span";
  public static final String MAP_VIEW_FILTER_LIST = "//div[contains(@class,'Bar_headButton')]/span";


  //================== SORT BY SEARCH RESULT=============================================
  public static final String CHOOSE_ROOM_BTN = "(//a[@class='PriceBlock_btnSelect___fqpKK'])[position()=1]";
  public static final String SORT_BY_PRICE = "//span[contains(text(), 'Price')]/ancestor::div[contains(@class,'sortItem')]";
  public static final String SORT_BY_RANK = "//span[contains(text(), 'Property Rank')]/ancestor::div[contains(@class,'sortItem')]";
  public static final String SORT_BY_RATING = "//span[contains(text(), 'Rating')]/ancestor::div[contains(@class,'sortItem')]";
  public static final String SORT_BY_TOP_RATE = "//span[contains(text(), 'Top Rated')]/ancestor::div[contains(@class,'sortItem')]";
  public static final String SORTED_BY_PRICE = "//img[contains(@src,'icon-sort')]//preceding-sibling::span";
  public static final String SORT_BY_DISTANCE = "//span[contains(text(), 'Distance from downtown')]/ancestor::div[contains(@class,'sortItem')]";
  public static final String SORT_LIST = "//div[contains(@class,'sortItem')]/span";
  public static final String SORT_LIST_DYNAMIC = "(//div[contains(@class,'sortItem')]/span)[%s]";
  public static final String SORT_TITLE_TXT = "//span[contains(@class,'SortControl_title')]";

  //================== TEXT AT PROPERTY ON SEARCH RESULT=============================================
  public static final String LIST_PROPERTY_NAME = "//a[contains(@class,'itemName')]";
  public static final String FIRST_PROPERTY = "(//a[contains(@class,'itemName')])[1]";
  public static final String LIST_PROPERTY = "//div[contains(@class,'ItemHotel')]";
  public static final String BOOK_NOW_BUTTON = "//div[contains(@class,'PriceBlock_btnSelect')]";
  public static final String BOOK_NOW_BUTTON_FIRST = "(//div[contains(@class,'PriceBlock_btnSelect')])[1]";
  public static final String SEARCH_RESULT_SEE_MAP_LIST = "//a[contains(@class,'viewMapBtn')]";
  public static final String SEARCH_RESULT_SEE_MAP_FIRST = "(//a[contains(@class,'viewMapBtn')])[1]";
  public static final String SEARCH_RESULT_REVIEW = "//div[contains(@class,'trustyouInner')]/p[1]";
  public static final String SEARCH_RESULT_GUEST_REVIEW = "//div[contains(@class,'trustyouInner')]/p[2]";
  public static final String SEARCH_RESULT_GIVEBACK_LIST = "//img[contains(@src,'images/icons/notice.svg')]/preceding-sibling::span";
  public static final String SEARCH_RESULT_GIVEBACK_DYNAMIC = "(//img[contains(@src,'images/icons/notice.svg')]/preceding-sibling::span)[%s]";
  public static final String SEARCH_RESULT_REFUND_LIST = "//p[contains(@class,'refund')]";
  public static final String SEARCH_RESULT_REFUND_DYNAMIC = "(//p[contains(@class,'refund')])[%s]";
  public static final String SEARCH_PROPERTY_FROM_TXT = "//p[contains(@class,'_mainPriceWra')]/span[1]";
  public static final String SEARCH_PROPERTY_FROM_FIRST = "(//p[contains(@class,'_mainPriceWra')]/span[1])[1]";
  public static final String SEARCH_PROPERTY_PER_NIGHT_TXT = "//p[contains(@class,'PriceBlock_perNight')]";
  public static final String SEARCH_PROPERTY_PER_NIGHT_FIRST = "(//p[contains(@class,'PriceBlock_perNight')])[1]";
  public static final String PRICE_BEFORE_SALE_FIRST = "(//span[@class='TvlPrice_container___bBjsa  ']/span)[1]";
  public static final String FAVOURITES_FIRST = "(//label[contains(@for,'checkbox')]//*[name()='svg'])[1]";
  public static final String FIRST_CHOOSE_ROOM_BUTTON_IN_SEARCH_RESULT = "(//div[contains(@class, 'ItemHotel_container')])[1]//button";

  //============================================PROPERTY======================================================
  public static final String BOOKING_PRICE_PROPERTY_FIRST = "(//span[contains(@class,'PriceBlock')]/span[not(contains(text(),'US'))])[1]";
  public static final String SEARCH_PRICE_PROPERTY = "//span[text()='From']/following-sibling::span/span[not(contains(text(),'US'))]";
  public static final String SEARCH_DISTANCE_PROPERTY = "//p[contains(@class,'streetAddr')]/following-sibling::p";
  public static final String SEARCH_RESULT_AMENITIES = "//li[contains(@class,'ItemContent_viewAll')]";
  public static final String SEARCH_RESULT_AMENITIES_DYNAMIC = "(//li[contains(@class,'ItemContent_viewAll')])[%s]";
  public static final String SEARCH_RESULT_LIST_AMENITIES = "(//ul[contains(@class,'ItemContent_hotelAmenities')])[1]/li/img";
  public static final String SEARCH_RESULT_LIST_AMENITIES_DYNAMIC = "((//ul[contains(@class,'ItemContent_hotelAmenities')])[1]/li/img)[%s]";
  //================== TOOLTIP AT PROPERTY ON SEARCH RESULT=============================================

  public static final String PROMOTION_FIRST = "(//div[@class='HighlightedTag_content___2bfKS'])[1]";
  public static final String PROMOTION_TOOL_TIP_NOT_LOGIN_CONTENT1 = "(//div[@class='HighlightedTag_tooltip___3VgPv']/ul/li)[1]";
  public static final String PROMOTION_TOOL_TIP_NOT_LOGIN_CONTENT2 = "(//div[@class='HighlightedTag_tooltip___3VgPv']/ul/li)[2]";
  public static final String SEARCH_RESULT_EVENT_SALE_FIRST = "(//div[@class='tvl-wrap-event-sale'])[1]";
  public static final String GIVEBACK_TOOL_TIP = "(//img[contains(@src,'images/icons/notice.svg')]/preceding-sibling::span)[1]";
  public static final String EVENT_SALE_TOOL_TIP = "//div[@class='popup-content tvl-tooltip-pc-content']";
  public static final String PRICE_TOOL_TIP = "//div[@class='popup-content tvl-tooltip-pc-content']";

  public static final String ITEM_PROMOTION_LOW_PRICE = "(//p[contains(@class,'ItemPromotion')])[1]";
  public static final String ITEM_PROMOTION_LOW_PRICE_SUB = "(//p[contains(@class,'ItemPromotion')])[1]/following-sibling::p";
  public static final String ITEM_PROMOTION_GIVEBACK = "(//p[contains(@class,'ItemPromotion')])[2]";
  public static final String ITEM_PROMOTION_GIVEBACK_SUB = "(//p[contains(@class,'ItemPromotion')])[2]/following-sibling::p";
  public static final String ITEM_INVITE = "(//p[contains(@class,'ItemPromotion_title')])[3]";
  public static final String ITEM_INVITE_SUB = "(//p[contains(@class,'ItemPromotion_title')])[3]/following-sibling::p";
  public static final String ITEM_GET_UP = "(//p[contains(@class,'ItemPromotion_title')])[4]";
  public static final String ITEM_GET_UP_SUB = "(//p[contains(@class,'ItemPromotion_title')])[4]/following-sibling::p";

  public static final String FREE_BREAKFAST_PROPERTY = "(//div[contains(@class,'ItemHotel_freeBreakfast')])[1]";
  public static final String HOTEL_ITEM_MAIN_LINK = "(//div[@class='item-hotel__info-main'])/h4/a";

  //=============GET TEXT POPULAR FILTER========================
   public static final String FILTER_OPTION_DYNAMIC = "//div[contains(@class,'filterHeader')][%s]";
   public static final String FILTER_OPTION_LIST = "//div[contains(@class,'filterHeader')]/h3";
   public static final String FILTER_POPULAR_LIST = "//input[contains(@name,'popular')]/following-sibling::span";
   public static final String FILTER_POPULAR_DYNAMIC = "(//input[contains(@name,'popular')]/following-sibling::span)[%s]";

  public static final String FILTER_PROPERTY_LIST = "//input[contains(@name,'hotel_types')]/following-sibling::span";
  public static final String FILTER_PROPERTY_DYNAMIC = "(//input[contains(@name,'hotel_types')]/following-sibling::span)[%s]";
  public static final String FILTER_GUEST_REVIEW_LIST = "//input[contains(@name,'trustyou_rating')]/following-sibling::span";
  public static final String FILTER_PAYMENT_TYPE_LIST = "//input[contains(@name,'payment_types')]/following-sibling::span";
  public static final String FILTER_GUEST_REVIEW_DYNAMIC = "(//input[contains(@name,'trustyou_rating')]/following-sibling::span)[%s]";
  public static final String FILTER_AMENITIES_LIST = "//input[contains(@name,'amenities')]/following-sibling::span";
  public static final String FILTER_AMENITIES_DYNAMIC = "(//input[contains(@name,'amenities')]/following-sibling::span)[%s]";
  public static final String FILTER_ROOM_BOARDS_LIST = "//input[contains(@name,'roomBoards')]/following-sibling::span";
  public static final String FILTER_ROOM_BOARDS_DYNAMIC = "(//input[contains(@name,'roomBoards')]/following-sibling::span)[%s]";
  public static final String FILTER_ROOM_TYPE_LIST = "//input[contains(@name,'roomTypes')]/following-sibling::span";
  public static final String FILTER_ROOM_TYPE_DYNAMIC = "(//input[contains(@name,'roomTypes')]/following-sibling::span)[%s]";
  public static final String FILTER_EXPAND_OPTION = "//div[contains(@class,'FilterSidebar_collapsed')]";

  public static final String FILTER_ROOM_CLASS_LIST = "//input[contains(@name,'roomClasses')]/following-sibling::span";
  public static final String FILTER_ROOM_CLASS_DYNAMIC = "(//input[contains(@name,'roomClasses')]/following-sibling::span)[%s]";
  public static final String FILTER_HOTEL_CHAIN_LIST = "//input[contains(@name,'hotel_chains')]/following-sibling::span";
  public static final String FILTER_HOTEL_CHAIN_DYNAMIC = "(//input[contains(@name,'hotel_chains')]/following-sibling::span)[%s]";
   public static final String FREE_BREAKFAST_FILTER_CHECKBOX = "//input[@value='FB']";
  //=============================POPULAR FILTER====================================================
  public static final String FILTER_PRICE_PER_NIGHT = "(//div[contains(@class,'filterHeader')])[1]/h3";
  public static final String PRICE_MAX_TEXTBOX = "max_price_val";
  public static final String PRICE_MIN_TEXTBOX = "min_price_val";
  public static final String FILTER_HOTE_CHAIN = "(//div[contains(@class,'filterHeader')])[7]/h3";
  public static final String FILTER_BEST_PRICE = "//div[contains(@class,'Guarantee_content')]/p";
  public static final String BEST_PRICE_LINK = "//a[contains(@class,'bestPriceGuarantee')]";
  public static final String MATCH_YOUR_SEARCH_RESULT = "//div[contains(@class,'totalItems')]/h2";
  public static final String MATCH_YOUR_SEARCH_RESULT_MAP = "//div[@class='MapView_listHeader___ejRuX']/span";
  public static final String POPULAR_FILTER_LABEL = "(//div[contains(@class,'filterHeader')])[2]/h3";
  public static final String START_RATING_FILTER_LABEL = "(//div[contains(@class,'filterHeader')])[4]/h3";
  public static final String GUEST_REVIEW_FILTER_LABEL = "(//div[contains(@class,'filterHeader')])[5]/h3";
  public static final String AMENITIES_FILTER_LABEL = "(//div[contains(@class,'filterHeader')])[6]/h3";
  //============= POPULAR CHECKBOX FILTER========================
  public static final String FREE_BREAKFAST_CHECKBOX = "(//input[@value='FB'])[1]";
  public static final String REFUNDABLE_FILTER_CHECKBOX = "//input[@value='RF']";
  public static final String RATING_FIVE_START_RATING_FILTER_CHECKBOX = "//input[@value='FS']";
  public static final String EXCELLENT_RATING_FILTER_CHECKBOX = "//input[@value='EXCELLENT']";
  public static final String VACATION_RENTAL_FILTER_CHECKBOX = "//input[@value='VR']";
  public static final String MEMBER_DEAL_FILTER_CHECKBOX = "//input[@value='MD']";
  public static final String ESSENTIAL_WORK_FILTER_CHECKBOX = "//input[@value='EW']";
  public static final String PAY_AT_PROPERTY_FILTER_CHECKBOX = "//input[@value='PP']";
  public static final String AMENITIES_FILTER_CHECKBOX = "(//input[contains(@name,'amenities')])[1]";
  public static final String AMENITIES_FILTER_EXPECT = "(//input[contains(@name,'amenities')]/following-sibling::span)[1]";
  public static final String AMENITIES_FILTER_LIST = "//ul[contains(@class,'hotelAmenities')]/li/img";
  public static final String AMENITIES_FILTER_DYNAMIC = "(//ul[contains(@class,'hotelAmenities')]/li/img)[%s]";
  public static final String STAR_RATING_CHECKBOX = "//input[@value='%s' and @name='star_rating']";
  public static final String STAR_RATING_GROUP= "(//div[contains(@class,'ratingGroup')]/span)";
  public static final String STAR_RATING_DYNAMIC= "(//div[contains(@class,'ratingGroup')]/span)[%s]//*[name()='svg']";
  public static final String SHOW_MORE_AMENITIES = "(//button[@class='FilterSidebar_showMore___2etnA'])[1]";
  public static final String SHOW_MORE_HOTEL_CHAIN = "(//button[@class='FilterSidebar_showMore___2etnA'])[2]";
  //=============CONDITION POPULAR FILTER========================
  public static final String LIST_START_RATING = "//div[@class='ItemContent_ratingGroup___2Ea8y']//span[@class='TvlStarRating']";
  public static final String ONE_START_RATING = "//div[@rate='item.star_rating']//ul[@class='list-inline']//li//i[@class='fa fa-star']";
  public static final String SMART_OFERS_CONDITION = "(//div[@class='ml-3 ng-isolate-scope'])";
  public static final String FREE_BREAKFAST_CONDITION = "//div[contains(@class,'freeBreakfast')]";
  public static final String EXCELLENT_RATING_CONDITION = "//div[contains(@class,'trustyouInner')]/p[not(contains(text(),'Guest'))]";
  public static final String NO_RESULTS_MES_TITLE = "//div[@class='NoItemsMessage_container___36g3k']/h3";
  public static final String NO_RESULTS_MES_SUB = "//div[@class='NoItemsMessage_container___36g3k']/p";
  public static final String OK_RELOAD_BUTTON = "//div[@class='NoItemsMessage_container___36g3k']/button";

  //=============================STAR RATING====================================================
  public static final String FIVE_START_RATING_FILTER_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=9]/label/input";
  public static final String FOUR_START_RATING_FILTER_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=10]/label/input";
  public static final String THREE_START_RATING_FILTER_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=11]/label/input";
  public static final String TWO_START_RATING_FILTER_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=12]/label/input";
  public static final String ONE_START_RATING_FILTER_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=13]/label/input";
  //=============================TRUSTYOU RATING====================================================
  public static final String EXCELLENT_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=8]/label/input";
  public static final String VERY_GOOD_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=8]/label/input";
  public static final String GOOD_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=8]/label/input";
  public static final String FAIR_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=8]/label/input";
  public static final String NO_RATING_CHECKBOX = "(//div[@class='filter-label ng-scope'])[position()=8]/label/input";
  //=============================AMENITIES====================================================

}
