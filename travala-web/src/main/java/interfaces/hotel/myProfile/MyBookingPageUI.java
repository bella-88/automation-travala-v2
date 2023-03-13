package interfaces.hotel.myProfile;

public class MyBookingPageUI {
  public static final String MY_BOOKING_SEARCH_TEXTBOX = "//div[contains(@class,'MyBookingSearchBox_searchBox')]/input";
  public static final String MY_BOOKING_CHECK_IN = "(//span[contains(@class,'MyBookingSearchBox_dateTimeFormat')])[1]";
  public static final String MY_BOOKING_CHECK_OUT = "(//span[contains(@class,'MyBookingSearchBox_dateTimeFormat')])[2]";
  public static final String MY_BOOKING_SEARCH_BTN = "//button[contains(@class,'searchBookingsBtn')]";
  public static final String MY_BOOKING_STATUS_LABEL = "//span[contains(@class,'MyBookingFilter_bookingStatus')]/preceding-sibling::span";
  public static final String MY_BOOKING_STATUS_FILTER = "//span[contains(@class,'MyBookingFilter_bookingStatus')]";
  public static final String MY_BOOKING_STATUS_LIST = "//div[contains(@class,'listStatuses')]/label/span";
  public static final String MY_BOOKING_STATUS_DYNAMIC = "(//div[contains(@class,'listStatuses')]/label/span)[%s]";
  public static final String MY_BOOKING_SEE_MAP_LIST = "(//span[contains(@class,'yBookingItemPC_seeMap')])[1]";
  public static final String MY_BOOKING_CODE_LIST = "(//div[contains(@class,'MyBookingItemPC_code')]/span)[1]";
  public static final String MY_BOOKING_HOTEL_CONFIRM_LIST = "(//div[contains(@class,'MyBookingItemPC_confirm')]/span)[1]";
  public static final String MY_BOOKING_CHECK_IN_LIST = "//div[contains(@class,'MyBookingItemPC_checkInItem')]/div[contains(@class,'MyBookingItemPC_label')]";
  public static final String MY_BOOKING_CHECK_IN_BOOKING = "(//div[contains(@class,'MyBookingItemPC_checkInItem')]/div)[1]";
  public static final String MY_BOOKING_CHECK_OUT_LIST = "//div[contains(@class,'MyBookingItemPC_checkInItem')]/div[contains(@class,'MyBookingItemPC_label')]";
  public static final String MY_BOOKING_CHECK_OUT_BOOKING = "(//div[contains(@class,'MyBookingItemPC_checkOutItem')]/div)[1]";
  public static final String MY_BOOKING_BOOK_AGAIN_LIST = "((//div[contains(@class,'ItemPC_optionsInfo')])[1]/button)[1]";
  public static final String MY_BOOKING_STATUS = "(//span[contains(@class,'bookingStatus')]/span)[1]";
  public static final String MY_BOOKING_LIST_FILTER = "//div[contains(@class,'listStatuses')]/label/span";
  public static final String MY_BOOKING_LIST_FILTER_DYNAMIC = "(//div[contains(@class,'listStatuses')]/label/span)[%s]";
  public static final String MY_BOOKING_BOOK_AGAIN_FIRST = "((//div[contains(@class,'ItemPC_optionsInfo')])[1]/button)[1]";
  public static final String MY_BOOKING_VIEW_BOOKING_FIRST = "((//div[contains(@class,'ItemPC_optionsInfo')])[1]/button)[2]";

}
