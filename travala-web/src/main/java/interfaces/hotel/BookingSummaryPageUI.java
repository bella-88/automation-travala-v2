package interfaces.hotel;

public class BookingSummaryPageUI {
  public static final String SUMMARY_TITLE_STATUS_TEXT = "//div[contains(@class,'StatusBar')]/a";
  public static final String TOTAL_CHARGE_COIN_TEXT = "//span[@class='TvlPrice_container___bBjsa  ']/img/following-sibling::span";
  public static final String SUB_TOTAL_TEXT = "//span[contains(@style,'16px; font-weight:')][2]";
  public static final String PRICE_PER_NIGHT_TEXT = "//span[contains(@style,'14px; font-weight:')][2]";
  public static final String BOOKING_STATUS = "//div[contains(text(),'Booking status')]/following-sibling::div";
  //=======================GET INFORMATION HOTEL============================
  public static final String SUMMARY_NUMBER_ROOM = "//img[contains(@src,'top-right-arrow')]/parent::p";
  public static final String SUMMARY_CHECK_IN = "(//div[contains(@class,'infoRow')]/div[contains(text(),',') and not(contains(@class,'success'))])[1]";
  public static final String SUMMARY_CHECK_OUT = "(//div[contains(@class,'infoRow')]/div[contains(text(),',') and not(contains(@class,'success'))])[2]";
  public static final String SUMMARY_ORDER_ID = "(//div[contains(@class,'infoRow')]/div[contains(text(),'vu')]/parent::div/preceding-sibling::div/div)[2]";

  //============================LABEL==========================================
  public static final String SUMMARY_INFORMATION_HOTEL_LABEL = "//div[contains(@class,'MainInfo_infoRow')]/div[not(contains(@style,'400')) and(not(contains(text(),'2')))and(not(contains(text(),'1')))and(not(contains(text(),')')))and(not(contains(@class,'amenities')))]";
  public static final String SUMMARY_INFORMATION_HOTEL_LABEL_LIST = "(//div[contains(@class,'MainInfo_infoRow')]/div[not(contains(@style,'400')) and(not(contains(text(),'2')))and(not(contains(text(),'1')))and(not(contains(text(),')')))and(not(contains(@class,'amenities')))])[%s]";
  public static final String SUMMARY_ORDER_ID_DYNAMIC = "(//div[contains(@class,'MainInfo_infoRow')]/div[not(contains(@style,'400')) and(not(contains(text(),',')))])[%s]";
  public static final String SUMMARY_INFORMATION_LIST = "//div[contains(@class,'callapseContent')]/h6";
  public static final String SUMMARY_INFORMATION_DYNAMIC = "(//div[contains(@class,'callapseContent')]/h6)[%s]";
  public static final String SUMMARY_PAYMENT_DETAIL_TITLE = "//div[contains(@class,'Summary_title')]";
  public static final String SUMMARY_PAYMENT_DETAIL_LIST = "//div[contains(@class,'Summary_infoRow')]/div";
  public static final String SUMMARY_PAYMENT_DETAIL_DYNAMIC = "(//div[contains(@class,'Summary_infoRow')]/div)[%s]";
  public static final String SUMMARY_PAYMENT_DETAIL_METHOD = "//div[contains(@class,'Summary_infoRow')]/strong";

  public static final String SUMMARY_PAYMENT_TOTAL_CHARGE_LABEL = "//div[contains(@class,'Summary_highLight')]/span[not(contains(@class,'container'))]";
  public static final String SUMMARY_PAYMENT_TOTAL_CHARGE = "((//div[contains(@class,'totalCharge')]/div)[2]/div)[1]";
  public static final String SUMMARY_PAYMENT_TOTAL_CHARGE_AMOUNT = "//div[contains(@class,'Summary_highLight')]/span/span[not(contains(text(),'US'))]";

  public static final String SUMMARY_INVITE_BANNER_TITLE = "//h3[contains(@class,'InviteBanner_title')]";
  public static final String SUMMARY_INVITE_BANNER_SUB_TITLE = "//p[contains(@class,'InviteBanner_subtitle')]";
  public static final String SUMMARY_INVITE_BTN = "//a[contains(@class,'InviteBanner_btn')]";
  public static final String SUMMARY_NEED_HELP = "//div[contains(@class,'NeedHelp_title')]";
  public static final String SUMMARY_NEED_HELP_CONTENT = "//div[contains(@class,'NeedHelp_content')]/p";

}
