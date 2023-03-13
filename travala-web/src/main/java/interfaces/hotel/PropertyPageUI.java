package interfaces.hotel;

public class PropertyPageUI {

  public static final String LIST_PACKAGES = "//div[contains(@class,'ItemHotel_container___')]";
  public static final String CHOOSE_ROOM = "//a[@class='PriceBlock_btnSelect___fqpKK' and @target='_blank']";
  public static final String PROPERTY_LOADING_MESSAGE = "//div[@class='HotelPackageLoading_loadingContainer___3fOZK']/p";
  public static final String LOADING_PACKAGE_MSG = "//p[@translate='propertyPage.loadingPackageMsg']";

  public static final String PROPERTY_PER_NIGHT_PACKAGE_LIST = "(//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO'])/preceding-sibling::p";
  public static final String PROPERTY_PER_NIGHT_PACKAGE_DYNAMIC = "(//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO'])[%s]/preceding-sibling::p";
  public static final String PER_NIGHT_TEXT_TOP = "//div[contains(@class,'TopGallery_rightInfo')]/p";
  public static final String PER_NIGHT_TEXT_FIRST_PACKAGE= "((//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO'])/preceding-sibling::p)[1]";
  public static final String PROPERTY_TITLE= "//div[contains(@class,'leftInfo')]/h1";
  public static final String PROPERTY_TITLE_LINK= "//div[contains(@class,'HotelPagePC_breadcrumb')]/span";


  public static final String BEST_PRICE_BOOK_NOW_LIST = "(//button[contains(@class,'RoomItem_btnBook')])[1]";
  public static final String BEST_PRICE_BOOK_NOW_FIRST = "(//button[contains(@class,'RoomItem_btnBook')])[1]";
  public static final String PACKAGE_REFUNDABLILITY_PROPERTY = "//p[contains(@class,'RoomItem_refundability')]/span";
  public static final String PACKAGE_REFUNDABLILITY_PROPERTY_DYNAMIC = "(//p[contains(@class,'RoomItem_refundability')]/span)[%s]";
  public static final String PACKAGE_REFUNDABLILITY_FIRST = "(//p[contains(@class,'RoomItem_refundability')]/span)[1]";

  public static final String PACKAGE_NON_REFUNDABLILITY_TOOL_TIP = "//div[contains(@class,'tvl-tooltip-pc-content')]";
  public static final String PACKAGE_REFUNDABLILITY_TOOL_TIP1 = "(//ul[@class='tvl-content-cancellation']/li)[1]";
  public static final String PACKAGE_REFUNDABLILITY_TOOL_TIP2 = "(//ul[@class='tvl-content-cancellation']/li)[2]";
  public static final String PACKAGE_REFUNDABLILITY_TOOL_TIP3 = "(//ul[@class='tvl-content-cancellation']/li)[3]";
  public static final String PACKAGE_ADULT_TOOL_TIP = "//div[contains(@class,'tvl-tooltip-pc-content')]";
  public static final String BOOKING_PRICE_PROPERTY = "//div[@class='RoomItem_container___1K4na RoomItem_bestPriceWrap___38EFl']//div[@class='RoomItem_priceInfo___3KNVV']/span/span[2]";
  public static final String TOTAL_CHARGE_PROPERTY_EVENT_SALE = "(//span[@class='TvlPrice_container___bBjsa  ']//span[not(contains(text(),'US'))])[position()=6]";
  public static final String ORIGINAL_PRICE_PROPERTY_NO_EVENT_SALE = "(//p[@class='TvlPriceDiscountPC_discountPrice___2YP94']/span/span)[position()=2]";
  public static final String ROOM_TYPE_PROPERTY = "(//div[@id='package-block']/following-sibling::div/div/h2)[1]";
  public static final String EVENT_SALE_TAG_PROPERTY = "(//div[@class='RoomItem_eventSales___2pUA6']//div[@class='tvl-wrap-event-sale'])[position()=1]/img";
  //============================LANGUAGE===========================
  //========================INFO PROPERTY ON TOP PAGE====================

  public static final String PROPERTY_LINK1 = "(//div[@class='HotelPagePC_breadcrumb___1w9WZ']/a)[1]";
  public static final String PROPERTY_VIEW_ON_MAP = "//p[@class='TopGallery_location___5qs77']/a";
  public static final String PROPERTY_FROM_TOP = "//div[contains(@class,'TopGallery_fromPrice')]";
  public static final String PROPERTY_PER_NIGHT_TOP = "(//div[@class='TopGallery_fromPrice___3ELbN'])/following-sibling::p";
  public static final String PROPERTY_COUNT_REVIEW = "//div[@class='TopGallery_reviewCount___301o5']/span";
  public static final String PROPERTY_SHARE_LINK = "//div[@class='TopGallery_shareLink___3uWxo']/span";
  public static final String PROPERTY_FROM_PRICE_HEADER = "//div[@class='TopGallery_fromPrice___3ELbN']";
  public static final String PROPERTY_SELECT_ROOM = "//div[@class='TopGallery_rightInfo___1P5Mz']/button[@target='#search-block']";
  public static final String PROPERTY_SEE_ALL_PHOTO = "//div[contains(@class,'TopGallery_inner')]/span";
  public static final String PROPERTY_AMENITIES_BTN = "//button[@target='#amenities-block']";
  public static final String PROPERTY_SEE_MAP = "//div[@class='TopGallery_miniMap___2MmJC']/span";
  //========================INFO PROPERTY ON TOP PAGE - NO HAVE PACKAGE====================
  public static final String PROPERTY_CHECK_AVAILABILITY_BTN ="//div[@class='TopGallery_rightInfo___1P5Mz']/button";
  public static final String PROPERTY_NO_PACKAGE_TITLE = "//div[contains(@class,'HotelPagePC_noAvailability')]/h4";
  public static final String PROPERTY_NO_PACKAGE_CONTENT = "//div[contains(@class,'HotelPagePC_noAvailability')]/p";

  //========================AVAILABLE ROOM====================
  public static final String PROPERTY_AVAILABLE_ROOM = "//div[@id='search-block']/h2";
  public static final String PROPERTY_NUMBER_ROOM = "//div[contains(@class,'fullRoomInfo___12j13')]/span[1]";
  public static final String PROPERTY_ADULTS = "//div[contains(@class,'fullRoomInfo___12j13')]/span[2]";
  public static final String PROPERTY_UPDATE_SEARCH_BTN = "//button[@class='TvlSearchBoxPC_searchBtn___3McoI']";
  public static final String PROPERTY_UPDATE_SEARCH_ROOM = "(//div[contains(@class,'SearchBoxPC_fullRoomInfo')]/span)[1]";
  public static final String PROPERTY_ROOM_TITLE = "//div[contains(@class,'roomTitleCustom')]";
  public static final String PROPERTY_ROOM_ADULT_LABEL = "(//span[@class='RoomPickerPC_label___1MG-x'])[1]";
  public static final String PROPERTY_ROOM_ADULT_LIST = "(//span[@class='TvlSelectPC_selectedOption___TDNxI'])[1]";
  public static final String PROPERTY_ROOM_CHILDREN_LABEL = "(//span[@class='RoomPickerPC_label___1MG-x'])[2]";
  public static final String PROPERTY_ROOM_CHILDREN_LIST = "(//span[@class='TvlSelectPC_selectedOption___TDNxI'])[2]";
  public static final String PROPERTY_ROOM_ADD_BTN = "//div[contains(@class,'btnAddRoom')]";
  public static final String PROPERTY_ROOM_CANCEL_BTN = "(//div[contains(@class,'btnAddRoom')]/following-sibling::div)[1]";
  public static final String PROPERTY_ROOM_DONE_BTN = "//div[contains(@class,'btnDone')]";
  public static final String PROPERTY_UPDATE_SEARCH_ADULT = "(//div[contains(@class,'SearchBoxPC_fullRoomInfo')]/span)[2]";
    //=====================PROPERTY_FILTER_BY=====================================
  public static final String PROPERTY_FILTER_BY = "//div[@class='Filters_container___K6sqH']/span";
  public static final String PROPERTY_ROOM_TYPE = "(//div[contains(@class,'Filters_filterItem')]/button)[1]";
  public static final String PROPERTY_ROOM_TYPE_FILTER_LIST = "(//div[contains(@class,'Filters_itemWrapper')]/div/label/span)[%s]";
  public static final String PROPERTY_FILTER_ROOM_TYPE1 = "(//label[@class='Filters_checkbox___3C1Uj']/span)[1]";
  public static final String PROPERTY_FILTER_ROOM_TYPE2 = "(//label[@class='Filters_checkbox___3C1Uj']/span)[2]";
  public static final String PROPERTY_FILTER_ROOM_TYPE3 = "(//label[@class='Filters_checkbox___3C1Uj']/span)[3]";
  public static final String PROPERTY_FILTER_ROOM_TYPE4 = "(//label[@class='Filters_checkbox___3C1Uj']/span)[4]";
  public static final String PROPERTY_FILTER_ROOM_TYPE5 = "(//label[@class='Filters_checkbox___3C1Uj']/span)[5]";
  public static final String PROPERTY_ROOM_CLASSES = "(//button[@class='Filters_groupBtn___ef2Ww '])[2]";
  public static final String PROPERTY_ROOM_BOARDS = "(//button[@class='Filters_groupBtn___ef2Ww '])[3]";
  public static final String PROPERTY_REFUNDABILITY = "(//button[@class='Filters_groupBtn___ef2Ww '])[4]";
  public static final String PROPERTY_FILTER_BENEFIT = "(//button[@class='Filters_groupBtn___ef2Ww '])[5]";
  public static final String PROPERTY_CLEAR_FITER = "//button[@class='Filters_btnClear___1dB6F']";
  //==============TITLE PACKAGE====================
  public static final String PROPERTY_ROOM_CHOICE_LABEL = "//div[contains(@class,'RoomPackage_roomChoise')]";
  public static final String PROPERTY_SLEEP_LABEL = "//div[contains(@class,'RoomPackage_sleeps')]";
  public static final String PROPERTY_ROOMS_LABEL = "//div[contains(@class,'RoomPackage_rooms')]";
  public static final String PROPERTY_REFUND_LABEL = "//div[contains(@class,'RoomPackage_refundabilities')]";
  public static final String PROPERTY_YOUR_CHOICES_LABEL = "//div[contains(@class,'RoomPackage_benefit')]";
  public static final String PROPERTY_PRICE_LABEL = "//div[contains(@class,'RoomPackage_price')]";

  //======================LEFT PACKAGE=============================
  public static final String PROPERTY_ROOM_DETAIL_PHOTOS_LIST = "//button[@class='RoomPackage_btnMoreImg___1_sis'] ";
  public static final String PROPERTY_ROOM_DETAIL_TXT = "(//button[@class='RoomPackage_btnMoreImg___1_sis'])[1]";
  public static final String PROPERTY_ROOM_SIZE_LIST = "//div[@class='RoomPackage_roomInfo___iq46q'] /p[2]/span";
  public static final String PROPERTY_ROOM_SIZE_TXT = "(//div[@class='RoomPackage_roomInfo___iq46q'] /p[2]/span)[1]";
  public static final String PROPERTY_ROOM_ONLY_LIST = "//p[@class='RoomItem_foodType___1wxFA']/span";
  public static final String PROPERTY_ROOM_ONLY_TXT = "(//p[contains(@class,'RoomItem_foodTypeIco')]/span)[1]";
  //======================LIST PACKAGE=============================

  public static final String PROPERTY_GIVE_BACK_LIST = "//div[@class='RoomItem_paymentMethods___1x2ZF']/p[1]/span";
  public static final String PROPERTY_YOUR_PRICE_LABEL = "(//div[contains(@class,'RoomItem_blockHr')]/preceding-sibling::h5)[1]";
  public static final String PROPERTY_PAYMENT_LABEL = "  (//div[contains(@class,'RoomItem_blockHr')]/following-sibling::h5)[1]";
  public static final String PROPERTY_CANCEL_POLICY_LABEL = "(//div[contains(@class,'RoomItem_refundabilityBlock')]/h5)[1]";
  public static final String PROPERTY_VIEW_ALL_POLICY_LABEL = "//div[contains(@class,'RoomItem_allOption')]/img";
  public static final String PROPERTY_VIEW_ALL_POLICY_LABEL_FIRST = "(//div[contains(@class,'RoomItem_allOption')])[1]";

  public static final String PROPERTY_PRICE_BEFORE_SALE_FIRST = "(//p[@class='TvlPriceDiscountPC_discountPrice___2YP94']/img)[1]";
  public static final String PROPERTY_GIVE_BACK_TXT = "(//div[contains(@class,'RoomItem_blockHr')]/preceding-sibling::p/span)[1]";
  public static final String PROPERTY_GIVE_BACK_TOOL_TIP_LIST = "//div[@class='RoomItem_paymentMethods___1x2ZF']/p[1]/img";
  public static final String PROPERTY_GIVE_BACK_TOOL_TIP_CONTENT = "//span[@class='PromotionInfoPC_content___30CxO']";
  public static final String PROPERTY_VOUCHER_SUPPORT_LIST = "//span[@class='eventName']";
  public static final String PROPERTY_VOUCHER_SUPPORT_LIST_FIRST = "(//span[@class='eventName'])[1]";
  public static final String PROPERTY_VOUCHER_SUPPORT_TOOL_TIP_LIST = "//p[@class='eventInfo']/img";
  public static final String PROPERTY_PAY_CREDIT_LIST = "//p[@class='eventInfo']/following-sibling::p[1]";
  public static final String PROPERTY_PAY_CREDIT_TXT = "//div[contains(@class,'RoomItem_blockHr')][1]/following-sibling::p[1]";
  public static final String PROPERTY_PAY_CRYPTO_LIST = "//p[@class='eventInfo']/following-sibling::p[2]";
  public static final String PROPERTY_PAY_CRYPTO_TXT = "//div[contains(@class,'RoomItem_blockHr')][1]/following-sibling::p[2]";
  public static final String PROPERTY_TAX_FEE_LIST = "//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO']/span";
  public static final String PROPERTY_TAX_FEE_TXT = "(//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO']/span)[1]";
  public static final String PROPERTY_TAX_FEE_TOOL_TIP_TITLE = "//h6[contains(@class,'PropertyTaxesAndFeePC_subTaxesTitle___1Y0YY')]";
  public static final String PROPERTY_TAX_FEE_TOOL_TIP_CONTENT1 = "((//ul[contains(@class,'TaxesAndFee')])[1]/li/span)[1]";
  public static final String PROPERTY_TAX_FEE_TOOL_TIP_CONTENT2 = "((//ul[contains(@class,'TaxesAndFee')])[1]/li/span)[3]";
  public static final String PROPERTY_PROMOTION_TXT = "(//img[contains(@src,'gift.svg')]/following-sibling::span)[1]";
  public static final String PROPERTY_TAX_FEE_TOOL_TIP_LIST = "//div[@class='PropertyTaxesAndFeePC_wrapper___nFotO']/img";
  public static final String PROPERTY_TAX_FEE_TOOL_TIP_CONTENT_TITLE = "//div[@class='subTaxesWrap']/h6";
  public static final String PROPERTY_BOOK_NOW_BTN_LIST = "//button[contains(@class,'RoomItem_btnBook')]";
  public static final String PROPERTY_BEST_PRICE_ICON = "//div[contains(@class,'RoomItem_bestPrice___3Px8P')]";
  public static final String PROPERTY_PRICE_BEFORE_SALE_TOOL_TIP = "//p[@class='TvlPriceDiscountPC_discountPrice___2YP94']/img";
  public static final String PROPERTY_PRICE_BEFORE_SALE_TOOL_TIP_CONTENT = "//span[@class='TvlPriceDiscountPC_tooltip___1m_1F']";
  public static final String PROPERTY_ADULT_PACKAGE = "(//img[contains(@src,'sleep.svg')])[1]";
  public static final String PROPERTY_PROMOTION = "//div[@class='HighlightedTag_content___2bfKS']/span";
  public static final String PROPERTY_PROMOTION_TOOL_TIP_CONTENT = "//div[@class='HighlightedTag_tooltip___3VgPv']/ul/li";
  public static final String PROPERTY_ROOM_TYPE_LIST_TOOL_TIP_CONTENT = "//p[@class='RoomItem_roomType___29Jk6']/div[2]";
  public static final String PROPERTY_ROOM_TYPE_LIST = "//p[@class='RoomItem_roomType___29Jk6']/img";
//==========================REVIEW=========================================
  public static final String PROPERTY_HOTEL_DESCRIPTION = "//div[@id='hotel-description-block']/h3";
  public static final String PROPERTY_HOTEL_POLICIES = "(//div[@class='HotelDescription_wrapPolicy___34jBv']/div/h4)[1]";
  public static final String PROPERTY_CLEANING_SAFE = "(//div[@class='HotelDescription_wrapPolicy___34jBv']/div/h4)[2]";
  public static final String PROPERTY_IMPORTANT = "(//div[@class='HotelDescription_wrapPolicy___34jBv']/div/h4)[3]";
  public static final String PROPERTY_HOTEL_AMENITIES = "//div[@id='amenities-block']/h3";
  public static final String PROPERTY_HOTEL_REVIEW = "//div[@id='trustyou-frame']/h3";
  public static final String PROPERTY_HOTEL_TRUST_YOU = "//div[@class='ResumeReview_ratingLabel___1vKyw']/span[1]";
  public static final String PROPERTY_MOST_POPULAR = "(//div[@class='HotelAmenities_block___3i0IU']/h4)[1]";
  public static final String PROPERTY_OTHER = "(//div[@class='HotelAmenities_block___3i0IU']/h4)[2]";
}
