package pages.hotel;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import static commons.CommonDataTravala.*;
import static interfaces.hotel.BookingSummaryPageUI.*;


public class BookingSummaryPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public BookingSummaryPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
    driver_.manage().deleteAllCookies();
  }

  public String getTotalCoinBookingSummary() {
    return getTextElement(driver, TOTAL_CHARGE_COIN_TEXT).trim();
  }

  public String getCheckOutBookingSummary() {
    return getTextElement(driver, SUMMARY_CHECK_IN).trim();
  }

  public String getCheckInBookingSummary() {
    return getTextElement(driver, SUMMARY_CHECK_OUT).trim();
  }

  public String getTotalChargeBookingSummary() {
    return getTextElement(driver, SUB_TOTAL_TEXT).trim();
  }

  public String getStatusBookingSummary() {
    waitFoElementVisible(driver, BOOKING_STATUS);
    return getTextElement(driver, BOOKING_STATUS).trim();
  }

  public String getOrderBooking() {
    return getTextElement(driver, SUMMARY_ORDER_ID).trim();
  }

  public boolean verifyTextHotelInfoBooking() {
    String[] hotelInfo = {"SUMMARY_ADDRESS_LABEL", "SUMMARY_PHONE_LABEL", "CHECKOUT_PAYMENT_CHECK_IN_LABEL", "CHECKOUT_PAYMENT_CHECK_OUT_LABEL", "SUMMARY_STATUS_LABEL",
      "SUMMARY_STATUS_SUCCESS", "SUMMARY_ORDER_NUMBER_LABEL", "SUMMARY_BOOKING_CODE_LABEL", "SUMMARY_GUEST_NAME_LABEL", "SUMMARY_NUMBER_ROOM_LABEL",
      "SUMMARY_NUMBER_ROOM_CONTENT", "SUMMARY_NUMBER_GUEST_LABEL", "SUMMARY_GUEST_NAME_CONTENT", "SUMMARY_ROOM_TYPE_LABEL", "SUMMARY_MEAL_TYPE_LABEL", "SUMMARY_BED_LABEL",
      "SUMMARY_AMENITIES_LABEL", "SUMMARY_CANCEL_POLICY_LABEL", "SUMMARY_HOTEL_POLICY_LABEL", "CHECKOUT_PAYMENT_CHECK_IN_LABEL", "CHECKOUT_PAYMENT_CHECK_OUT_LABEL",
      "SUMMARY_INFORMATION_LABEL", "SUMMARY_STATUS_PROCESS", "SUMMARY_ROOM_POLICY"};
    String[] amenities = {"SUMMARY_INFORMATION1", "SUMMARY_INFORMATION2", "SUMMARY_INFORMATION3", "SUMMARY_INFORMATION4", "SUMMARY_INFORMATION5", "SUMMARY_INFORMATION6",
      "SUMMARY_INFORMATION7"};
    List<WebElement> listOptionActual = driver.findElements(By.xpath(SUMMARY_INFORMATION_HOTEL_LABEL));
    List<String> listActual = new ArrayList<>();
    int i = 1;
    while (i < listOptionActual.size() - 1) {
      String xpathActual = String.format(SUMMARY_INFORMATION_HOTEL_LABEL_LIST, i);
      String st = getTextElement(driver, xpathActual).replaceAll("\\r\\n|\\r|\\n", " ").trim();
      boolean t = StringUtils.contains(st, "Travala") && StringUtils.contains(st, "vu");
      boolean t1 = st.matches("[\\w0-9A-Z]*");
      String actual = st.replaceAll("[0-9]*", "");
      boolean t2 = st.contains("TEST");
      if (!t && !t1 && !StringUtils.contains(getAttribute(driver, xpathActual, "class"), "success") && !t2) {
        listActual.add(actual.trim());
      }
      i++;
    }
    boolean b = verifyListItemByListExpect(amenities, SUMMARY_INFORMATION_LIST, SUMMARY_INFORMATION_DYNAMIC);
    boolean b1 = verifyTwoList(listActual, addListExpectByKey(hotelInfo));
    if (!b) {
      System.out.println("Text at Amenities of Booking Summary wrong");
    }
    if (!b1) {
      System.out.println("Information Hotel at Booking Summary Wrong!");
    }
    return b1 && b;
  }

  public boolean verifyTextPaymentBooking() {
    boolean paymentBooking = true;
    String[] paymentExp = {"SUMMARY_PURCHASE_DATE", "SUMMARY_PRICE_PER_NIGHT", "SUMMARY_PER_NIGHT", "SUMMARY_PAYMENT_DETAIL_METHOD",
      "SUMMARY_NUMBER_ROOM_NIGHT", "SUMMARY_TAX", "SUMMARY_PROMOTION1", "SUMMARY_PROMOTION2"};
    List<WebElement> listOptionActual = driver.findElements(By.xpath(SUMMARY_PAYMENT_DETAIL_LIST));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String xpathActual = String.format(SUMMARY_PAYMENT_DETAIL_DYNAMIC, i);
      String st = getTextElement(driver, xpathActual).replaceAll("\\r\\n|\\r|\\n", " ").trim();
      boolean a = StringUtils.contains(st, "US$");
      boolean b = StringUtils.contains(st, "(GMT");
      if (!b) {
        if (!a) {
          listActual.add(st.replaceAll("[0-9]*", "").trim());
        }
      }
    }
    boolean detailPayment = verifyTwoList(listActual, addListExpectByKey(paymentExp));
    if (!detailPayment) {
      System.out.println("Detail Payment at Booking Summary Wrong");
    }
    String[] content = {"SUMMARY_PAYMENT_DETAIL_TITLE", "SUMMARY_TOTAL_CHARGE", "MY_INVITE_PEOPLE_TITLE_MAIN", "Invite_BANNER_TITLE2",
      "Invite_BANNER_TITLE3", "SUMMARY_NEED_HELP"};
    String[] xpath = {SUMMARY_PAYMENT_DETAIL_TITLE, SUMMARY_PAYMENT_TOTAL_CHARGE_LABEL, SUMMARY_INVITE_BANNER_TITLE, SUMMARY_INVITE_BANNER_SUB_TITLE,
      SUMMARY_INVITE_BTN, SUMMARY_NEED_HELP};
    String act = getTextElement(driver, SUMMARY_NEED_HELP_CONTENT);
    String exp = getTextFromReadFile("SUMMARY_NEED_HELP_CONTENT1") + " " + getOrderBooking() + getTextFromReadFile(
      "SUMMARY_NEED_HELP_CONTENT2");
    boolean helpContent = StringUtils.contains(exp, act);
    boolean invite = verifyTwoListByKey(content, xpath);
    if (!invite) {
      System.out.println("CONTENT INVITE at Booking Summary wrong");
    }
    paymentBooking = detailPayment && invite && helpContent;
    return paymentBooking;
  }

  public void verifyPaymentMethodBooking(String totalChargeCheckOut) {
    String paymentMethodAct = getTextElement(driver, SUMMARY_PAYMENT_DETAIL_METHOD);
    String paymentTotalChargeAct = getTextElement(driver, SUMMARY_PAYMENT_TOTAL_CHARGE);
    boolean a = StringUtils.equals(paymentMethodAct, paymentTotalChargeAct);
    if (StringUtils.equals(totalChargeCheckOut, getTextElement(driver, SUMMARY_PAYMENT_TOTAL_CHARGE_AMOUNT))) {
      System.out.println("Total Charge at CheckOut same Total Charge at Booking Summary: " + totalChargeCheckOut);
    } else {
      System.out.println("Total charge at Checkout: " + totalChargeCheckOut);
      System.out.println("Total charge at Booking Summary: " + getTextElement(driver, SUMMARY_PAYMENT_TOTAL_CHARGE_AMOUNT));
      System.out.println("Total Charge at CheckOut is consistent with Total Charge at Booking Summary");
    }
    if (!verifyTwoList(addActualFromElement(SUMMARY_PAYMENT_DETAIL_METHOD), addListExpByConst(LIST_CRYPTO_PAYMENT)) || !a) {
      System.out.println("Payment Method When booking Wrong!");
    }
  }

  public boolean verifyInfoBookingSummary() {
    if (verifyTextByKey("SUMMARY_TITLE_STATUS_TEXT", SUMMARY_TITLE_STATUS_TEXT) && verifyTextHotelInfoBooking() && verifyTextPaymentBooking()) {
      verifyTextPaymentBooking();
      status = true;
    } else {
      status = false;
    }
    return status;
  }
}

