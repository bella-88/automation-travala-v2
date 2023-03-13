package pages.hotel;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static commons.CommonDataTravala.*;
import static commons.CommonHotelXpath.*;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static commons.CommonTravalaURL.*;
import static interfaces.hotel.CheckOutPageUI.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.LandingPageUI.FIRST_NAME_TXT;
import static interfaces.hotel.LandingPageUI.LAST_NAME_TXT;
import static interfaces.hotel.PropertyPageUI.*;
import static interfaces.hotel.SearchPageUI.*;
public class CheckOutPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;
  boolean check = true;

  public CheckOutPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void inputContactNotLogin() {
    sendkeysToElementAtTravala(driver, FIRST_NAME_TXT, randomString());
    wait300Time();
    sendkeysToElement(driver, LAST_NAME_TXT, randomString());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    wait300Time();
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", randomNumber());
    sendkeysToElementByCSS(driver, "input[class*='TvlPhoneSelectPC_input']", " ");
    wait2sTime();
    String email = randomString() + "@gmail.com";
    sendkeysToElementAtTravala(driver, EMAIL_TEXTBOX, email);
  }

  public void inputToRoomGuest() {
    sendKeysToListElement(ROOM_GUEST_LIST, randomString());
  }

  //==================================VERIFY CHECK OUT PAGE========================================================
  public boolean verifyContactRoomNotLogin() {
    boolean t = verifyTextByKey("CHECKOUT_NOTE_LOGIN", CHECKOUT_NOTE_LOGIN);
    if (!t) {
      System.out.println("Text at contact information when not login Wrong");
    }
    return verifyContactRoomLogin() && t;
  }

  public boolean verifyContactRoomLogin() {
    String[] content = {"CHECKOUT_STEP1", "CHECKOUT_STEP2", "CHECKOUT_STEP3", "CHECKOUT_NOTE_SECURE", "CHECKOUT_CONTACT_INFO", "CHECKOUT_FIRST_NAME_LABEL", "CHECKOUT_LAST_NAME_LABEL", "CHECKOUT_PHONE_LABEL", "EMAIL_TITLE", "CHECKOUT_NOTE_BOOKING", "CHECKOUT_BED_PREFERENCE", "CHECKOUT_RESERVATION_NAME"};
    String[] xpath = {CHECKOUT_STEP1, CHECKOUT_STEP2, CHECKOUT_STEP3, CHECKOUT_NOTE_SECURE, CHECKOUT_CONTACT_INFO, CHECKOUT_FIRST_NAME_LABEL, CHECKOUT_LAST_NAME_LABEL, CHECKOUT_PHONE_LABEL, CHECKOUT_EMAIL_LABEL, CHECKOUT_NOTE_BOOKING, CHECKOUT_BED_PREFERENCE, CHECKOUT_RESERVATION_NAME};
    boolean t = verifyTextByKey("CHECKOUT_RESERVATION_NAME_SUB", CHECKOUT_RESERVATION_NAME_SUB);
    if (!verifyTwoListByKey(content, xpath) && t) {
      System.out.println("Text at contact information when not login Wrong");
    }
    return verifyTwoListByKey(content, xpath) && t;
  }

  public boolean verifyListItemSubText(String[] listExpect, String listXpath, String dynamicXpath) {
    List<WebElement> listOptionActual = driver.findElements(By.xpath(listXpath));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String xpathActual = String.format(dynamicXpath, i);
      String actual = getTextBySplit(getTextElement(driver, xpathActual).replaceAll("\\r\\n|\\r|\\n", " ").trim(), " ", 0);
      listActual.add(actual);
    }
    return verifyTwoList(addListExpectByKey(listExpect), listActual);
  }

  public void verifyReservationText() {
    wait5sTime();
    String[] content = {"RESERVATION_ROOM_TITLE"};
    if (!verifyListItemSubText(content, RESERVATION_ROOM_TITLE_LIST, RESERVATION_ROOM_TITLE_DYNAMIC)) {
      System.out.println(" ROOM wrong");
    }
    if (!verifyContentWithListActual(RESERVATION_FIRST_NAME_LABEL_LIST, "CHECKOUT_FIRST_NAME_LABEL")) {
      System.out.println(" FIRST_NAME wrong");
    }
    if (!verifyContentWithListActual(RESERVATION_LAST_NAME_LABEL_LIST, "CHECKOUT_LAST_NAME_LABEL")) {
      System.out.println(" LAST_NAME wrong");
    }
    if (!verifyContentWithListActual(CHECKOUT_ADDITIONAL_LABEL_LIST, "CHECKOUT_ADDITIONAL_LABEL")) {
      System.out.println(" ADDITIONAL wrong");
    }
  }

  public void verifyTextAtPaymentDetail() {
    String[] content = {"CHECKOUT_SELECT_PAYMENT_TXT", "CHECKOUT_TERM_CONDITION", "CHECKOUT_TERM_CONDITION_SUB", "CHECKOUT_PAYMENT_CHECK_IN_LABEL", "CHECKOUT_PAYMENT_CHECK_OUT_LABEL", "CHECKOUT_PAYMENT_FULL_PAYMENT_MESSAGE", "CHECKOUT_PAYMENT_CANCEL_POLICY_BTN", "CHECKOUT_PAYMENT_IMPORTANT_POLICY_BTN", "PROPERTY_GIVE_BACK_STANDAR", "PROPERTY_ROOM_TYPE", "CHECKOUT_PAYMENT_DETAIL_MEAL_TYPE", "PROPERTY_REFUNDABILITY", "CHECKOUT_PAYMENT_DETAIL_LABEL", "CHECKOUT_PAYMENT_DETAIL_TOTAL_CHARGE", "CHECKOUT_PAYMENT_DETAIL_BEST_PRICE_CONTENT", "COMPLETE_RESERVATION_BUTTON"};
    String[] xpath = {CHECKOUT_SELECT_PAYMENT_TXT, CHECKOUT_TERM_CONDITION, CHECKOUT_TERM_CONDITION_SUB, CHECKOUT_PAYMENT_CHECK_IN_LABEL, CHECKOUT_PAYMENT_CHECK_OUT_LABEL, CHECKOUT_PAYMENT_FULL_PAYMENT_MESSAGE, CHECKOUT_PAYMENT_CANCEL_POLICY_BTN, CHECKOUT_PAYMENT_IMPORTANT_POLICY_BTN, CHECKOUT_PAYMENT_GIVEBACK_TOOLTIP, CHECKOUT_PAYMENT_DETAIL_ROOM_TYPE, CHECKOUT_PAYMENT_DETAIL_MEAL_TYPE, CHECKOUT_PAYMENT_DETAIL_REFUND, CHECKOUT_PAYMENT_DETAIL_LABEL, CHECKOUT_TOTAL_CHARGE_LABEL, CHECKOUT_BEST_PRICE_CONTENT, COMPLETE_RESERVATION_BUTTON};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at payment detail Wrong");
    }
  }

  public void verifyTextPaymentOptionNotLogin() {
    List<WebElement> elements = driver.findElements(By.xpath(CHECK_OUT_TYPE_PAYMENT));
    int i = 1;
    while (i < elements.size() + 1) {
      String typePayment = getAttribute(driver, CHECK_OUT_TYPE_PAYMENT, "value");
      clickElementByDynamicLocator(driver, CHECK_OUT_TYPE_PAYMENT_DYNAMIC, String.valueOf(i));
//      System.out.println("test: "+ String.format(CHECK_OUT_TYPE_PAYMENT_DYNAMIC,i));
      switch (typePayment) {
        case "wechat_pay":
          if (!verifyTextByKey("CHECKOUT_WE_CHAT_CONTENT", CHECKOUT_PAYMENT_NOTE_CONTENT)) {
            System.out.println("Text at App We Chat option wrong! ");
          }
          break;
        case "crypto":
          verifyTextByKey("CHECKOUT_NOTE_REFUND_TITLE", CHECKOUT_NOTE_REFUND_CRYPTO);
          verifyTextByKey("CHECKOUT_NOTE_REFUND_CRYPTO", CHECKOUT_NOTE_REFUND_CRYPTO_CONTENT);
          if (!(verifyDisplayListCrypto(CRYPTO_COIN_NAME_LIST, LIST_CRYPTO_PAYMENT))) {
          }
          break;
        case "binance_pay":
          verifyTextByKey("CHECKOUT_NOTE_REFUND_TITLE", CHECKOUT_NOTE_REFUND_CRYPTO);
          verifyTextByKey("CHECKOUT_NOTE_REFUND_BINANCE", CHECKOUT_NOTE_REFUND_CRYPTO_CONTENT);
          if (!verifyTextByKey("CHECKOUT_BINANCE_PAY_CONTENT", CHECKOUT_PAYMENT_NOTE_CONTENT)) {
            System.out.println("Text at Binance option wrong! ");
          }
          break;
        case "vnpay":
          break;
        case "crypto_com":
          verifyTextByKey("CHECKOUT_NOTE_REFUND_TITLE", CHECKOUT_NOTE_REFUND_CRYPTO);
          verifyTextByKey("CHECKOUT_NOTE_REFUND_CRYPTO_APP", CHECKOUT_NOTE_REFUND_CRYPTO_CONTENT);
          if (!verifyTextByKey("CHECKOUT_APP_CRYPTO_CONTENT", CHECKOUT_PAYMENT_NOTE_CONTENT)) {
            System.out.println("Text at App Crypto option wrong! ");
          }
          break;
        case "credit_cards":
          if (!verifyTextCreditCardOption(driver) || !verifyTextByKey("CHECKOUT_CREDIT_CARD_CONTENT", CHECKOUT_PAYMENT_NOTE_CONTENT)) {
            System.out.println("Text at credit card in checkout page wrong");
          }
          break;
        default:
          System.out.println("Please re select other payment!");
          break;
      }
      i++;
      wait100Time();
    }
  }

  public boolean verifyBalanceToPaymentCheckOut(String balanceXpath, String totalXpath) {
    boolean verify = true;
    Float balanceWallet = Float.valueOf(getTextElement(driver, balanceXpath).replace("US$", "").replace(",", ""));
    if (getTotalCharge(totalXpath) > balanceWallet) {
      verify = false;
    } else {
      verify = true;
    }
    return verify;
  }

  public boolean verifyTextPartial() {
    String[] content = {"CHECKOUT_PARTIAL_VOUCHER_TITLE", "CHECKOUT_PARTIAL_PAYMENT_LABEL", "CHECKOUT_PARTIAL_AVA_REMAIN", "CHECKOUT_PARTIAL_AVA_BTN"};
    String[] xpath = {CHECKOUT_PARTIAL_VOUCHER_TITLE, CHECKOUT_PARTIAL_PAYMENT_LABEL, CHECKOUT_PARTIAL_AVA_REMAIN, CHECKOUT_PARTIAL_AVA_BTN};
    return verifyTwoListByKey(content, xpath);
  }

  public void verifyTextPartialAVA() {
    clickToElementByJavascript(driver, CHECKOUT_PARTIAL_PAYMENT_CHECKBOX);
    boolean b = StringUtils.contains(getTextElement(driver, CHECKOUT_PARTIAL_AVA_TITLE), getTextFromReadFile("CHECKOUT_PARTIAL_AVA"));
    boolean b1 = StringUtils.contains(getAttribute(driver, CHECKOUT_PARTIAL_VALUE_TXT, "placeholder"), getTextFromReadFile("CHECKOUT_PARTIAL_AVA_TXT"));
    status = verifyTextPartial() && b && b1;
    if (!status) {
      System.out.println("Text at Partial AVA Voucher Wrong");
    }
    clickToElementByJavascript(driver, CHECKOUT_PARTIAL_PAYMENT_CHECKBOX);
  }

  public void verifyTextPartialTC() {
    clickToElementByJavascript(driver, CHECKOUT_PARTIAL_PAYMENT_CHECKBOX);
    boolean b1 = verifyTextByKeyWithAttribute("CHECKOUT_PARTIAL_TC_TXT", CHECKOUT_PARTIAL_VALUE_TXT, "placeholder");
    status = verifyTextPartial() && b1;
    if (!status) {
      System.out.println("Text at Partial Travel Credit Voucher Wrong");
    }
    clickToElementByJavascript(driver, CHECKOUT_PARTIAL_PAYMENT_CHECKBOX);
  }

  public void verifyTextWalletCheckOut(String coin) {
    verifyWalletName();
    boolean a = verifyTextByKey("CHECKOUT_WALLET_CONTENT", CHECKOUT_PAYMENT_NOTE_CONTENT);
    boolean a1 = verifyTextByKey("CHECKOUT_PAYMENT_WALLET_DISCOUNT", CHECKOUT_PAYMENT_WALLET_DISCOUNT);
    if (!verifyBalanceToPaymentCheckOut(String.format(CHECKOUT_WALLET_MAIN_BALANCE_DYNAMIC, coin), CHECKOUT_TOTAL_CHARGE_WALLET)) {
      String[] xpathWallet = {PAYMENT_WALLET_ADDRESS, PAYMENT_WALLET_MEMO, PAYMENT_ENOUGH_FUND};
      switch (coin) {
        case "AVA":
          boolean avaImport = verifyTextByKey("CHECKOUT_AVA_WALLET_IMPORTANT", CHECKOUT_PAYMENT_IMPORTANT);
//          StringUtils.contains(getTextFromReadFile(""),
//            getTextElement(driver, ).replaceAll("\\r\\n|\\r|\\n", " "));
          String[] avaExpect = {"PAYMENT_AVA_DEPOSIT_ADDRESS", "PAYMENT_AVA_DEPOSIT_MEMO", "CHECKOUT_WALLET_AVA_NOT_ENOUGH"};
          if (!verifyTwoListByKey(avaExpect, xpathWallet) || !avaImport) {
            System.out.println("Warning don't have enough AVA  wrong");
          }
          break;
        case "BNB":
          clickElementByDynamicLocator(driver, CHECKOUT_WALLET_RADIO_DYNAMIC, coin);
          boolean bnbImport = verifyTextByKey("CHECKOUT_BNB_WALLET_IMPORTANT", CHECKOUT_PAYMENT_IMPORTANT);
          String[] bnbExpect = {"PAYMENT_WALLET_BNB_ADDRESS", "PAYMENT_WALLET_BNB_MEMO", "CHECKOUT_WALLET_BNB_NOT_ENOUGH"};
          if (!verifyTwoListByKey(bnbExpect, xpathWallet) || !bnbImport) {
            System.out.println("Warning don't have enough BNB  wrong");
          }
          break;
        case "BUSD":
          clickElementByDynamicLocator(driver, CHECKOUT_WALLET_RADIO_DYNAMIC, coin);
          boolean busdImport = verifyTextByKey("CHECKOUT_BUSD_WALLET_IMPORTANT", CHECKOUT_PAYMENT_IMPORTANT);
          String[] busdExpect = {"PAYMENT_WALLET_BUSD_ADDRESS", "PAYMENT_WALLET_BUSD_MEMO", "CHECKOUT_WALLET_BUSD_NOT_ENOUGH"};
          if (!verifyTwoListByKey(busdExpect, xpathWallet) || !busdImport) {
            System.out.println("Warning don't have enough BUSD  wrong");
          }
          break;
        default:
          System.out.println("Can not choice a coin at my wallet");
          break;
      }
      verifyTextPartialTC();
      wait1sTime();
      if (!a || !a1) {
        System.out.println("Text at My Wallet option wrong! ");
      }
    }
  }

  public void verifyTextTravelOption() {
    String[] content = {"CHECKOUT_PAYMENT_TRAVEL_IMPORTANT", "CHECKOUT_PAYMENT_TC_BALANCE", "MY_TRAVEL_CREDIT_BUY_TAB", "CHECKOUT_TRAVEL_CREDIT_CONTENT"};
    String[] xpath = {CHECKOUT_PAYMENT_IMPORTANT, CHECKOUT_PAYMENT_TC_BALANCE_LABEL, CHECKOUT_PAYMENT_BUY_TC_BTN, CHECKOUT_PAYMENT_NOTE_CONTENT};
    boolean b1 = true;
    if (!verifyBalanceToPaymentCheckOut(CHECKOUT_PAYMENT_TC_BALANCE, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT)) {
      b1 = verifyTextByKey("CHECKOUT_PAYMENT_TC_NOT_ENOUGH", PAYMENT_ENOUGH_FUND);
    }
    boolean b = verifyTwoListByKey(content, xpath);
    if (!b || !b1) {
      System.out.println("Text at Travel Credit tab on check-out page wrong! ");
    }
    verifyTextPartialAVA();
  }

  public Float getTotalCharge(String totalXpath) {
    return Float.valueOf(getTextElement(driver, totalXpath).replace("US$", ""));
  }

  //=====================================PAYMENT CHECKOUT============================================

  public void verifyPopUpCrypto(String coin) {
    clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
    wait5sTime();
    if (checkShowElement(driver, CRYPTO_POPUP_TITLE_CHECKOUT) == 0) {
      System.out.println("The message is: " + getTextElement(driver, POPUP_ERROR_CONTENT));
      System.out.println("======Error payment by " + coin + " ===========");
      clickToElement(driver, POPUP_CLOSE_BTN);
      clickBackToTravala(driver);
    } else {
      String[] expCrypto = {"BOOKING_CRYPTO_POPUP_TITLE", "BOOKING_CRYPTO_POPUP_PAYMENT_TITLE", "BOOKING_CRYPTO_POPUP_PAYMENT_CONTENT", "CRYPTO_POPUP_LABEL2", "PERSONAL_DETAIL_ADDRESS"};
      String[] xpath = {CRYPTO_POPUP_TITLE_CHECKOUT, CRYPTO_POPUP_PAYMENT_TITLE, CRYPTO_POPUP_PAYMENT_CONTENT, CRYPTO_POPUP_LABEL1, CRYPTO_POPUP_LABEL2};
      String coinIconExp = getTextBySplit(getAttribute(driver, "//div[contains(@class,'paymentAmount')]/p/img", "src"), "logo/", 1);
      if (verifyTwoListByKey(expCrypto, xpath)) {
        System.out.println("Content popup payment by Crypto " + coin + " correct");
      }
      clickToElementByJavascript(driver, PAYMENT_SENT_BTN);
      wait1sTime();
      switchToWindowByUrlContainsString(driver, "booking-summary");
      String coinIconAct = getTextBySplit(getAttribute(driver, "//div[contains(@class,'mainPayment')]/div/span/img", "src"), "logo/", 1);
      if (StringUtils.contains(coinIconExp, coinIconAct)) {
        System.out.println("Booking hotel payment by " + coin + " success!");
      }
    }
    clickBackToTravala(driver);
  }

  public void verifyPopUpCryptoWithNowPayment(String coin) {
    clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
    wait1sTime();
    if (checkShowElement(driver, CRYPTO_POPUP_TITLE_CHECKOUT) == 0) {
      if (!StringUtils.contains(getTextElement(driver, POPUP_ERROR_CONTENT), getTextFromReadFile("POPUP_ERROR_TITLE"))) {
        System.out.println("Actual Content Error Payment: "+getTextElement(driver, POPUP_ERROR_CONTENT));
        System.out.println("Expect Content Error Payment: "+getTextFromReadFile("POPUP_ERROR_CONTENT"));
        System.out.println("Content Error payment by " + coin + " wrong");
      } else {
        if (!StringUtils.contains(getTextElement(driver, POPUP_ERROR_CONTENT), getTextFromReadFile("POPUP_ERROR_CONTENT"))) {
        System.out.println("Content Error payment by " + coin + " correct!");
      }
      clickToElement(driver, POPUP_CONFIRM_BTN);
      clickBackToTravala(driver);
    }} else {
      String[] expCrypto = {"BOOKING_CRYPTO_POPUP_TITLE", "BOOKING_CRYPTO_POPUP_PAYMENT_TITLE", "BOOKING_CRYPTO_POPUP_PAYMENT_CONTENT", "CRYPTO_POPUP_LABEL2", "PERSONAL_DETAIL_ADDRESS"};
      String[] xpath = {CRYPTO_POPUP_TITLE_CHECKOUT, CRYPTO_POPUP_PAYMENT_TITLE, CRYPTO_POPUP_PAYMENT_CONTENT, CRYPTO_POPUP_LABEL1, CRYPTO_POPUP_LABEL2};
      if (verifyTwoListByKey(expCrypto, xpath)) {
        System.out.println("Content popup payment by Crypto " +getTextElement(driver, CRYPTO_POPUP_COIN) + " correct");
      } else {
        System.out.println("Content popup payment by Crypto " + getTextElement(driver, CRYPTO_POPUP_COIN) + " wrong");
      }
    }
//    if (checkShowElement(driver, CRYPTO_POPUP_PAYMENT_CONTENT) != 0)
//    else {
//      System.out.println("This is other error! ");
//    }
    clickBackToTravala(driver);
  }

  public BookingSummaryPage paymentBookingByWallet(String coin) throws Throwable {
    boolean a = (getTotalCharge(CHECKOUT_TOTAL_CHARGE_WALLET) <= getWalletBalance(coin));
    if (a) {
      clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
      wait5sTime();
      String exp = getTextFromReadFile("BOOKING_WALLET_POPUP_TITLE") + " " + getTotalCharge(
        CHECKOUT_TOTAL_CHARGE_WALLET) + " " + WALLET_AVA + " " + getTextFromReadFile("BOOKING_WALLET_POPUP_TITLE");
      clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
      String act = getTextElement(driver, BOOKING_WALLET_POPUP_CONTENT);
      String[] expWallet = {"BOOKING_WALLET_POPUP_TITLE", "MY_INVITE_PEOPLE_POPUP_ERROR_OK", "MY_SMART_ACTIVE_CANCEL_BTN"};
      String[] xpath = {BOOKING_WALLET_POPUP_TITLE, BOOKING_WALLET_POPUP_OK_BTN, BOOKING_WALLET_POPUP_OK_CANCEL};
      if (!verifyTwoListByKey(expWallet, xpath) && StringUtils.contains(exp, act)) {
        System.out.println("Text at popup payment booking hotel by Wallet wrong!");
      }
      wait1sTime();
      clickToElementByJavascript(driver, BOOKING_WALLET_POPUP_OK_BTN);
    } else {
      System.out.println("You don't have enough " + coin + " to payment");
    }
    return new BookingSummaryPage(driver);
  }

  public BookingSummaryPage bookingByTravelCredit() {
    clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
    wait2sTime();
    return new BookingSummaryPage(driver);
  }


  private void selectPhoneByCountry(String country) {
    clickToElement(driver, ICON_SELECT_PHONE_COUNTRY);
    clickToElementByJavascript(driver, String.format(SELECT_PHONE_COUNTRY_BY_COUNTRY_NAME, country));
  }

  public void inputCustomserInformation(int room) {
    waitElement(driver, CHECKOUT_STEP_1_ACTIVE);
    for (int i=0; i<room; i++) {
      sendkeysToElement(driver, String.format(FIRST_NAME_TEXTBOX_BY_ROOM, i+1), fakeData().get("firstname"));
      sendkeysToElement(driver, String.format(LAST_NAME_TEXTBOX_BY_ROOM, i+1), fakeData().get("lastname"));
    }
    selectPhoneByCountry("Vietnam");
    sendkeysToElement(driver, PHONE_NUMBER_TEXTBOX, fakeNumberPhoneVN());
  }

  public void verifyUserReceiveVoucherCodeInCheckOutPage(String expectVoucherCode, String expectDiscountPercent) {
    String actualVoucherCode = "";
    String actualDiscountPercent = "";

    waitElement(driver, CHECKOUT_STEP_2_ACTIVE);
    Assert.assertEquals(actualVoucherCode, expectVoucherCode);
    Assert.assertEquals(actualDiscountPercent, expectDiscountPercent);
  }
}

