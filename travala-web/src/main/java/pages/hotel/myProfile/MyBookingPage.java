package pages.hotel.myProfile;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.BookingSummaryPage;
import pages.hotel.PropertyPage;
import pages.hotel.HomePage;

import static interfaces.hotel.myProfile.MyBookingPageUI.*;


public class MyBookingPage extends CommonHotelPages {
  WebDriver driver;
  private HomePage homePage;

  public MyBookingPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }


  public void verifyFilterStatus() {
    boolean a =verifyTextByKeyWithAttribute("LANDING_MY_TRIP_SEARCH",MY_BOOKING_SEARCH_TEXTBOX,"placeholder" );
    boolean text = verifyTextByKey("CHECKOUT_PAYMENT_CHECK_IN_LABEL", MY_BOOKING_CHECK_IN) && verifyTextByKey("CHECKOUT_PAYMENT_CHECK_OUT_LABEL", MY_BOOKING_CHECK_OUT) && verifyTextByKey(
      "LANDING_MY_TRIP_SEARCH", MY_BOOKING_SEARCH_BTN);
    clickToElement(driver, MY_BOOKING_STATUS_FILTER);
    wait300Time();
    String[] content = {"MY_BOOKING_STATUS_ALL", "MY_BOOKING_STATUS_SUCCESS", "MY_BOOKING_STATUS_PROCESSING", "MY_BOOKING_STATUS_EXPIRED"
      , "MY_BOOKING_STATUS_FAILED", "MY_BOOKING_STATUS_CANCEL", "MY_BOOKING_STATUS_REJECT","MY_BOOKING_CREDITT"};
    if (!(text && compareTwoListByKey(content,MY_BOOKING_STATUS_LIST) && a)) {
      System.out.println("Text at filter my booking wrong!");
    }
    clickToElement(driver, MY_BOOKING_STATUS_FILTER);
  }

  public boolean verifySearchBar() {
    String[] content = {"MY_BOOKING_CHECK_IN", "MY_BOOKING_CHECK_OUT", "LANDING_MY_TRIP_SEARCH"};
    String[] xpath = {MY_BOOKING_CHECK_IN, MY_BOOKING_CHECK_OUT, MY_BOOKING_SEARCH_BTN};
    boolean a = StringUtils.contains(getAttribute(driver, MY_BOOKING_SEARCH_TEXTBOX, "placeholder"), getTextFromReadFile("LANDING_MY_TRIP_SEARCH"));
    if (!a) {
      System.out.println("EXPECT=" + getTextFromReadFile("LANDING_MY_TRIP_SEARCH"));
      System.out.println("ACTUAL=" + getAttribute(driver, MY_BOOKING_SEARCH_TEXTBOX, "placeholder"));
    }
    return verifyTwoListByKey(content, xpath) && a;
  }

  public boolean verifyBookingDetail() {
    String[] content = {"MY_BOOKING_CODE_LIST", "MY_BOOKING_HOTEL_CONFIRM_LIST", "MY_BOOKING_SEE_MAP_LIST", "CHECKOUT_PAYMENT_CHECK_IN_LABEL", "CHECKOUT_PAYMENT_CHECK_OUT_LABEL", "MY_BOOKING_BOOK_AGAIN_LIST", "MY_BOOKING_VIEW_BOOK_LIST"};
    String[] xpath = {MY_BOOKING_CODE_LIST, MY_BOOKING_HOTEL_CONFIRM_LIST, MY_BOOKING_SEE_MAP_LIST, MY_BOOKING_CHECK_IN_BOOKING, MY_BOOKING_CHECK_OUT_BOOKING, MY_BOOKING_BOOK_AGAIN_FIRST, MY_BOOKING_VIEW_BOOKING_FIRST};
    wait1sTime();
    return verifyTwoListByKey(content, xpath);
  }

  public BookingSummaryPage clickViewBooking() {
    if (verifyBookingDetail() && verifySearchBar()) {
      System.out.println("Text at My Booking detail Correct");
    }
    verifyFilterStatus();
    clickElement(driver, MY_BOOKING_VIEW_BOOKING_FIRST);
    return new BookingSummaryPage(driver);
  }
public PropertyPage clickBookAgain() {
    clickToElement(driver, MY_BOOKING_BOOK_AGAIN_FIRST);
    return new PropertyPage(driver);
}
}
