package pages.hotel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import commons.hotel.CommonHotelPages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static commons.CommonHotelURL.*;
import static commons.CommonTravalaURL.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.PropertyPageUI.*;
import static interfaces.hotel.SearchPageUI.*;


public class PropertyPage extends CommonHotelPages {
  WebDriver driver;

  public PropertyPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void linkToProperty() {
    switchToWindowByUrlContainsString(driver, TRAVALA_LIVE_URL);
    inputLocationSearch(randomDestination());
    switchToWindowByUrlContainsString(driver, SEARCH_PATH);
    clickToElementByJavascript(driver, FIRST_PROPERTY);
    switchToWindowByUrlContainsString(driver, HOTEL_PROPERTY);
    clickToElementByJavascript(driver, BEST_PRICE_BOOK_NOW_FIRST);
  }

  public int getNumberNight() {
    Double totalCharge = Double.parseDouble(driver.findElement(By.xpath(TOTAL_CHARGE_PROPERTY_EVENT_SALE)).getText().trim());
    String removeBookingPrice = driver.findElement(By.xpath(BOOKING_PRICE_PROPERTY)).getText().trim().replace(",", "");
    Double bookingPrice = Double.parseDouble(removeBookingPrice);
    int numberNight = (int) Math.round(totalCharge / bookingPrice * 10) / 10;
    return numberNight;
  }

  public String getRoomTypeBestChoiceText() {
    waitLoadingPackages();
    TakesScreenshot scrShot = ((TakesScreenshot) driver);
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("test1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    waitForAllElementsPresence(driver, ROOM_TYPE_PROPERTY);
    File srcFile2 = scrShot.getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile2, new File("test2.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return driver.findElement(By.xpath(ROOM_TYPE_PROPERTY)).getText();
  }

  public void waitLoadingPackages() {
    waitFoElementInvisible(driver, LOADING_PACKAGE_MSG);
  }

//  public boolean getRefundable() {
//    List<WebElement> listRefundable = driver.findElements(By.xpath(REFUNDABLE_PROPERTY));
//    if (listRefundable.size() != 0) {
//      System.out.println(listRefundable.toString());
//      for (WebElement refundable : listRefundable) {
//        System.out.println("refundable: " + refundable);
//        if (!StringUtils.equals(refundable.getText(), REFUNDABLE_EXPECT_TEXT)) {
//          status = false;
//          System.out.println("Display property has non refundable");
//        } else {
//          System.out.println("Display property has refundable");
//          status = true;
//        }
//      }
//    }
//    return status;
//  }

  public CheckOutPage clickBookNowBtn() {
    wait1sTime();
    wait1sTime();
    if (checkShowElement(driver, BEST_PRICE_BOOK_NOW_LIST) != 0) {
      clickToElement(driver, BEST_PRICE_BOOK_NOW_FIRST);
    } else {
      System.out.println("No have package for this property! Please re-search! ");
      clickBackToTravala(driver);
      inputPropertySearch("Sofitel Saigon Plaza");
      clickToElementByJavascript(driver, LANDING_SEARCH_BUTTON);
      clickToElement(driver, BEST_PRICE_BOOK_NOW_FIRST);
    }

    return new CheckOutPage(driver);
  }

  public boolean verifyPrice() {
    boolean check = true;
    String price = getTextElement(driver, PROPERTY_FROM_PRICE_HEADER);
    String str = getTextBySplit(price, "", 0);
    if (!StringUtils.contains(str, getTextFromReadFile("PROPERTY_FROM_PRICE_HEADER"))) {
      System.out.println("EXPECT=" + getTextFromReadFile("PROPERTY_FROM_PRICE_HEADER"));
      System.out.println("ACTUAL=" + str);
      System.out.println("=============================================================");
      check = false;
    }
    return check;
  }

  public boolean verifyCountReviewTop() {
    boolean check = true;
    String[] content = {"PROPERTY_COUNT_REVIEW"};
    String[] xpath = {PROPERTY_COUNT_REVIEW};
    for (int i = 0; i < content.length; i++) {
      String actual = String.valueOf(getTextBySplit(getTextElement(driver, xpath[i]), "", 0));
      if (!StringUtils.contains(actual, getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyFilterBenefitLogin() {
    boolean check = true;
    boolean element = checkDisplayElement(driver, PROPERTY_FILTER_BENEFIT);
    wait2sTime();
    if (element) {
      if (!StringUtils.contains(getTextElement(driver, PROPERTY_FILTER_BENEFIT), getTextFromReadFile("PROPERTY_BENEFITS"))) {
        System.out.println("EXPECT=" + getTextFromReadFile("PROPERTY_BENEFITS"));
        System.out.println("ACTUAL=" + getTextElement(driver, PROPERTY_FILTER_BENEFIT));
        System.out.println("=============================================================");
        check = false;
      }
    } else {
      System.out.println("Property no have benefits");
    }

    return check;
  }

  public boolean verifyFilterProperty() throws Throwable {
    boolean check = true;
    boolean check1 = true;
    String[] content = {"PROPERTY_FILTER_BY", "PROPERTY_ROOM_TYPE", "PROPERTY_ROOM_CLASSES", "PROPERTY_ROOM_BOARDS", "PROPERTY_REFUNDABILITY", "PROPERTY_CLEAR_FITER"};
    String[] xpath = {PROPERTY_FILTER_BY, PROPERTY_ROOM_TYPE, PROPERTY_ROOM_CLASSES, PROPERTY_ROOM_BOARDS, PROPERTY_REFUNDABILITY, PROPERTY_CLEAR_FITER};
    for (int i = 0; i < content.length; i++) {

      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    if (!verifyFilterBenefitLogin()) {
      check1 = false;
    }
    return check && check1;
  }

  public void verifyDisplayRoomTypeFilter() {
    scrollToElement(driver, PROPERTY_ROOM_TYPE);
    boolean check = true;
    String[] listPaymentExpect = {"2 twin beds", "Twin", "Queen", "King", "Twin beds", "Suite"};
    clickToElementByJavascript(driver, PROPERTY_ROOM_TYPE);
    String actual = getTextToolTip(driver, PROPERTY_ROOM_TYPE, "(//div[contains(@class,'Filters_itemWrapper')]/div/label/span)[1]");
    System.out.println("actual: " + actual);
//    List<WebElement> listPaymentActual = driver.findElements(By.xpath(PROPERTY_ROOM_TYPE));
//
//    List<String> listActual = new ArrayList<>();
//    for (int i = 1; i < listPaymentActual.size() + 1; i++) {
//      String xpathPaymentActual = String.format(PROPERTY_ROOM_TYPE_FILTER_LIST, i);
//      String actual = getTextToolTip(driver,PROPERTY_ROOM_TYPE, xpathPaymentActual);
//      listActual.add(actual);
//    }
//    List<String> listExpect = new ArrayList<>();
//    for (int i = 0; i < listPaymentExpect.length; i++) {
//      listExpect.add(listPaymentExpect[i]);
//    }
//    for (String element : listActual
//    ) {
//      if (!listExpect.contains(element)) {
//        System.out.println("ACTUAL: "+ element);
//        System.out.println("EXPECT: "+ listExpect.contains(element));
//        check = false;
//      }
//    }
//    if (!check) {
//      System.out.println("List room type is display wrong!");
//    }
  }

  public boolean verifyAvailiableRoom() {
    boolean check = true;
    String[] content = {"PROPERTY_AVAILABLE_ROOM", "PROPERTY_NUMBER_ROOM", "PROPERTY_ADULTS", "PROPERTY_UPDATE_SEARCH", "PROPERTY_ROOM_CHOICE_LABEL", "PROPERTY_SLEEP_LABEL", "PROPERTY_ROOMS_LABEL", "PROPERTY_REFUNDABILITY", "PROPERTY_YOUR_CHOICES_LABEL", "PROPERTY_FROM_PRICE_HEADER"};
    String[] xpath = {PROPERTY_AVAILABLE_ROOM, PROPERTY_NUMBER_ROOM, PROPERTY_ADULTS, PROPERTY_UPDATE_SEARCH_BTN, PROPERTY_ROOM_CHOICE_LABEL, PROPERTY_SLEEP_LABEL, PROPERTY_ROOMS_LABEL, PROPERTY_REFUND_LABEL, PROPERTY_YOUR_CHOICES_LABEL, PROPERTY_PRICE_LABEL};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyUpdateSearch() {
    boolean room = StringUtils.contains(getTextElement(driver, PROPERTY_UPDATE_SEARCH_ROOM), getTextFromReadFile("PROPERTY_NUMBER_ROOM"));
    boolean adult = StringUtils.contains(getTextElement(driver, PROPERTY_UPDATE_SEARCH_ADULT), getTextFromReadFile("PROPERTY_ADULTS"));
    if (!room) {
      System.out.println("Text default at Room - Update Search is display wrong! ");
    } else if (!adult) {
      System.out.println("Text default at Adult - Update Search is display wrong! ");
    }
    clickToElement(driver, PROPERTY_UPDATE_SEARCH_ROOM);
    boolean check = true;
    String actual1 = String.valueOf(getTextBySplit(getTextElement(driver, PROPERTY_ROOM_ADULT_LIST), "", 0));
    String actual2 = String.valueOf(getTextBySplit(getTextElement(driver, PROPERTY_ROOM_CHILDREN_LIST), "", 0));
    boolean roomList = StringUtils.contains(actual1, getTextFromReadFile("PROPERTY_ROOM_ADULT_LABEL"));
    boolean adultList = StringUtils.contains(actual2, getTextFromReadFile("PROPERTY_ROOM_CHILDREN_LABEL"));
    if (!roomList || !adultList) {
      System.out.println("Text default at combo box room is display wrong! ");
    }
    String[] content = {"PROPERTY_ROOM_TITLE", "PROPERTY_ROOM_ADULT_LABEL", "PROPERTY_ROOM_CHILDREN_LABEL", "PROPERTY_ROOM_ADD_BTN", "PROPERTY_ROOM_CANCEL_BTN", "PROPERTY_ROOM_DONE_BTN"};
    String[] xpath = {PROPERTY_ROOM_TITLE, PROPERTY_ROOM_ADULT_LABEL, PROPERTY_ROOM_CHILDREN_LABEL, PROPERTY_ROOM_ADD_BTN, PROPERTY_ROOM_CANCEL_BTN, PROPERTY_ROOM_DONE_BTN};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    clickToElement(driver, PROPERTY_ROOM_CANCEL_BTN);
    return check;
  }

  public boolean verifyPackageNotLogin() {
    boolean check = true;
    boolean a = StringUtils.equals(getTextBySplit(getTextElement(driver, PROPERTY_ROOM_SIZE_TXT), ":", 0).trim(), getTextFromReadFile("PROPERTY_ROOM_SIZE"));
    if (!a) {
      System.out.println("act " + getTextBySplit(getTextElement(driver, PROPERTY_ROOM_SIZE_TXT), ":", 0).trim());
      System.out.println("ex" + getTextFromReadFile("PROPERTY_ROOM_SIZE"));
    }
    String[] content = {"PROPERTY_BEST_PRICE_ICON", "PROPERTY_ROOM_DETAIL_TXT", "PROPERTY_GIVE_BACK_STANDAR", "PROPERTY_TAX_FEE_LIST", "PROPERTY_BOOK_NOW_LIST", "PROPERTY_YOUR_PRICE_LABEL", "PROPERTY_PAYMENT_LABEL",
      "PROPERTY_CANCEL_POLICY_LABEL", "PROPERTY_VIEW_ALL_POLICY_LABEL"};
    String[] xpath = {PROPERTY_BEST_PRICE_ICON, PROPERTY_ROOM_DETAIL_TXT, PROPERTY_GIVE_BACK_TXT, PROPERTY_TAX_FEE_TXT, BEST_PRICE_BOOK_NOW_FIRST,
      PROPERTY_YOUR_PRICE_LABEL, PROPERTY_PAYMENT_LABEL, PROPERTY_CANCEL_POLICY_LABEL, PROPERTY_VIEW_ALL_POLICY_LABEL_FIRST};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check && a;
  }

  public boolean verifyTextToolTipPaymentNotLogin() throws Throwable {
    boolean check = true;
    boolean b = StringUtils.contains(getTextToolTip(driver, PROPERTY_GIVE_BACK_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("NOT_LOGIN_GIVE_BACK_TOOL_TIP"));
    Thread.sleep(1000);
    boolean b1 = StringUtils.contains(getTextToolTip(driver, PROPERTY_PAY_CREDIT_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_PAY_CREDIT_TOOL_TIP"));
    Thread.sleep(1000);
    boolean b2 = StringUtils.contains(getTextToolTip(driver, PROPERTY_PAY_CRYPTO_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_PAY_CRYPTO_TOOL_TIP"));
    Thread.sleep(1000);
    if (b && b1 && b2) {
      check = true;
    } else {
      System.out.println(" PROPERTY_GIVE_BACK_TXT actual:" + getTextToolTip(driver, PROPERTY_GIVE_BACK_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_GIVE_BACK_TXT exp:" + getTextFromReadFile("NOT_LOGIN_GIVE_BACK_TOOL_TIP"));
      System.out.println("============================");
      System.out.println(" PROPERTY_PAY_CREDIT_TXT actual:" + getTextToolTip(driver, PROPERTY_PAY_CREDIT_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_PAY_CREDIT_TXT exp:" + getTextFromReadFile("PROPERTY_PAY_CREDIT_TOOL_TIP"));
      System.out.println("============================");
      System.out.println(" PROPERTY_PAY_CRYPTO_TXT actual:" + getTextToolTip(driver, PROPERTY_PAY_CRYPTO_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_PAY_CRYPTO_TXT exp:" + getTextFromReadFile("PROPERTY_PAY_CRYPTO_TOOL_TIP"));
      System.out.println("============================");
      check = false;
    }
    return check;
  }

  public boolean verifyTextToolTipPaymentLogin() throws Throwable {
    boolean check = true;
    boolean b = StringUtils.contains(getTextToolTip(driver, PROPERTY_GIVE_BACK_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_GIVE_BACK_TOOL_TIP_CONTENT_LOGIN"));
    Thread.sleep(1000);
    boolean b1 = StringUtils.contains(getTextToolTip(driver, PROPERTY_PAY_CREDIT_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_PAY_CREDIT_TOOL_TIP"));
    Thread.sleep(1000);
    boolean b2 = StringUtils.contains(getTextToolTip(driver, PROPERTY_PAY_CRYPTO_TXT, PACKAGE_ADULT_TOOL_TIP).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_PAY_CRYPTO_TOOL_TIP"));
    Thread.sleep(1000);
    if (b && b1 && b2) {
      check = true;
    } else {
      System.out.println("Login");
      System.out.println(" PROPERTY_GIVE_BACK_TXT actual:" + getTextToolTip(driver, PROPERTY_GIVE_BACK_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_GIVE_BACK_TXT exp:" + getTextFromReadFile("PROPERTY_GIVE_BACK_TOOL_TIP_CONTENT"));
      System.out.println("============================");
      System.out.println(" PROPERTY_PAY_CREDIT_TXT actual:" + getTextToolTip(driver, PROPERTY_PAY_CREDIT_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_PAY_CREDIT_TXT exp:" + getTextFromReadFile("PROPERTY_PAY_CREDIT_TOOL_TIP"));
      System.out.println("============================");
      System.out.println(" PROPERTY_PAY_CRYPTO_TXT actual:" + getTextToolTip(driver, PROPERTY_PAY_CRYPTO_TXT, PACKAGE_ADULT_TOOL_TIP));
      System.out.println(" PROPERTY_PAY_CRYPTO_TXT exp:" + getTextFromReadFile("PROPERTY_PAY_CRYPTO_TOOL_TIP"));
      System.out.println("============================");
      check = false;
    }
    return check;
  }

  public boolean verifyTextToolTipTaxFee() throws Throwable {
    boolean check = true;
    boolean taxTitle = StringUtils.contains(getTextToolTip(driver, PROPERTY_TAX_FEE_TXT, PROPERTY_TAX_FEE_TOOL_TIP_TITLE).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_TAX_FEE_TOOL_TIP_CONTENT_TITLE"));
    Thread.sleep(1000);
    boolean taxContent = StringUtils.contains(getTextToolTip(driver, PROPERTY_TAX_FEE_TXT, PROPERTY_TAX_FEE_TOOL_TIP_CONTENT1).replaceAll("\\r|\\n", ""),
      getTextFromReadFile("PROPERTY_TAX_FEE_TOOL_TIP_CONTENT1"));
    Thread.sleep(1000);
    if (taxTitle && taxContent) {
      check = true;
    } else {
      System.out.println(" Title fee actual:" + getTextToolTip(driver, PROPERTY_TAX_FEE_TXT, PROPERTY_TAX_FEE_TOOL_TIP_TITLE) + ":");
      System.out.println(" Title fee exp:" + getTextFromReadFile("PROPERTY_TAX_FEE_TOOL_TIP_CONTENT_TITLE") + ":");
      System.out.println("============================");
      System.out.println(" content fee actual:" + getTextToolTip(driver, PROPERTY_TAX_FEE_TXT, PROPERTY_TAX_FEE_TOOL_TIP_CONTENT1) + ":");
      System.out.println(" content fee exp:" + getTextFromReadFile("PROPERTY_TAX_FEE_TOOL_TIP_CONTENT1") + ":");
      System.out.println("============================");
      check = false;
    }

    return check;
  }

  public boolean verifyInfoHotelTop() {
    boolean check = true;
    String[] content = {"PROPERTY_VIEW_ON_MAP", "PROPERTY_SHARE_LINK", "PROPERTY_SELECT_ROOM", "PROPERTY_AMENITIES_BTN", "PROPERTY_SEE_MAP"};
    StringBuilder stringBuilder = new StringBuilder(getTextElement(driver, PROPERTY_SEE_ALL_PHOTO));
    boolean b = StringUtils.contains(stringBuilder.substring(0, 8), getTextFromReadFile("PROPERTY_SEE_ALL_PHOTO"));
    boolean a = StringUtils.contains(getTextBySplit(getTextElement(driver, PROPERTY_FROM_TOP).trim(), " ", 0), getTextFromReadFile("PROPERTY_FROM_TOP"));
    if (!a) {
      System.out.println("ACTUAL Price form: " + getTextBySplit(getTextElement(driver, PROPERTY_FROM_TOP).trim(), " ", 0));
      System.out.println("EXPECT  Price form: " + getTextFromReadFile("PROPERTY_FROM_TOP"));
    } else if (!b) {
      System.out.println("ACTUAL: " + stringBuilder.substring(0, 8));
      System.out.println("EXPECT: " + getTextFromReadFile("PROPERTY_SEE_ALL_PHOTO"));
    }
    String[] xpath = {PROPERTY_VIEW_ON_MAP, PROPERTY_SHARE_LINK, PROPERTY_SELECT_ROOM, PROPERTY_AMENITIES_BTN, PROPERTY_SEE_MAP};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check && a && b;
  }

  public boolean verifyPerNight() {
    boolean check = true;
    boolean b = StringUtils.contains(getTextElement(driver, PROPERTY_PER_NIGHT_TOP).replaceAll("\\r|\\n", ""), getTextFromReadFile("PER_NIGHT_TEXT"));
    List<WebElement> list = driver.findElements(By.xpath(PROPERTY_PER_NIGHT_PACKAGE_LIST));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < list.size() + 1; i++) {
      String xpath = String.format(PROPERTY_PER_NIGHT_PACKAGE_DYNAMIC, i);
      listActual.add(getTextElement(driver, xpath));
    }
    List<String> listExpect = new ArrayList<>();
    listExpect.add(getTextFromReadFile("PER_NIGHT_TEXT"));
    for (String element : addListActualFromListXpath(PROPERTY_PER_NIGHT_PACKAGE_LIST, PROPERTY_PER_NIGHT_PACKAGE_DYNAMIC)) {
      if (!listExpect.contains(element)) {
        System.out.println("ACTUAL: " + element);
        System.out.println("EXPECT:" + getTextFromReadFile("PER_NIGHT_TEXT"));
        check = false;
      }
    }
    return check && b;
  }

  public boolean verifyPerNights() {
    boolean check = true;
    boolean b = StringUtils.contains(getTextBySplitLimitSegment(getTextElement(driver, PER_NIGHT_TEXT_TOP), " ", 1), getTextFromReadFile("PROPERTY_PER_NIGHTS_TOP"));
    boolean b1 = StringUtils.contains(getTextBySplitLimitSegment(getTextElement(driver, PER_NIGHT_TEXT_FIRST_PACKAGE), " ", 1), getTextFromReadFile("PROPERTY_PER_NIGHTS_TOP"));
    if (!b || !b1) {
      System.out.println("EXPECT=" + getTextFromReadFile("PROPERTY_PER_NIGHTS_TOP"));
      System.out.println("ACTUAL Top=" + getTextBySplitLimitSegment(getTextElement(driver, PER_NIGHT_TEXT_TOP), " ", 1));
      System.out.println("ACTUAL Package=" + getTextBySplitLimitSegment(getTextElement(driver, PER_NIGHT_TEXT_FIRST_PACKAGE), " ", 1));
      System.out.println("=============================================================");
      check = false;

    }
    return check;
  }

  public boolean verifyNoHavePackage() {
    boolean check = true;
    String[] content = {"PROPERTY_CHECK_AVAILABILITY_BTN", "PROPERTY_WARNING_MESSAGE", "PROPERTY_RESEARCH_MESSAGE"};
    String[] xpath = {PROPERTY_CHECK_AVAILABILITY_BTN, PROPERTY_NO_PACKAGE_TITLE, PROPERTY_NO_PACKAGE_CONTENT};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT CHECK NO HAVE PACKAGE=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL CHECK NO HAVE PACKAGE=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyHotelDescription() {
    boolean check = true;
    String[] content = {"PROPERTY_HOTEL_DESCRIPTION", "PROPERTY_HOTEL_POLICIES", "PROPERTY_CLEANING_SAFE", "PROPERTY_IMPORTANT", "PROPERTY_MOST_POPULAR", "PROPERTY_OTHER", "PROPERTY_HOTEL_AMENITIES", "PROPERTY_HOTEL_REVIEW"};
    String[] xpath = {PROPERTY_HOTEL_DESCRIPTION, PROPERTY_HOTEL_POLICIES, PROPERTY_CLEANING_SAFE, PROPERTY_IMPORTANT, PROPERTY_MOST_POPULAR, PROPERTY_OTHER, PROPERTY_HOTEL_AMENITIES, PROPERTY_HOTEL_REVIEW};
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextElement(driver, xpath[i]), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyReviewBottomLogin() {
    boolean check = false;
    boolean a = StringUtils.contains(getTextElement(driver, PROPERTY_HOTEL_TRUST_YOU), getTextFromReadFile("REVIEW_VERY_GOOD"));
    boolean b = StringUtils.contains(getTextElement(driver, PROPERTY_HOTEL_TRUST_YOU), getTextFromReadFile("REVIEW_EXCELLENT"));
    boolean c = StringUtils.contains(getTextElement(driver, PROPERTY_HOTEL_TRUST_YOU), getTextFromReadFile("REVIEW_FAIR"));
    if (a || b || c) {
      check = true;
    }
    return check;
  }

  public boolean verifyHaveVoucherLogin() {
    clickToElementByJavascript(driver, PROPERTY_FILTER_BENEFIT);
    boolean check = true;
    boolean b = StringUtils.contains(getTextElement(driver, PROPERTY_VOUCHER_SUPPORT_LIST_FIRST), getTextFromReadFile("PROPERTY_VOUCHER_SUPPORT_LIST"));
    boolean b1 = StringUtils.contains(getTextToolTip(driver, PROPERTY_VOUCHER_SUPPORT_LIST_FIRST, PACKAGE_ADULT_TOOL_TIP),
      getTextFromReadFile("PROPERTY_VOUCHER_SUPPORT_TOOL_TIP"));
    if (!b && !b1) {
      System.out.println("EXPECT package=" + getTextFromReadFile("PROPERTY_VOUCHER_SUPPORT_LIST"));
      System.out.println("ACTUAL package=" + getTextElement(driver, PROPERTY_VOUCHER_SUPPORT_LIST_FIRST));
      System.out.println("EXPECT Tool tip=" + getTextFromReadFile("PROPERTY_VOUCHER_SUPPORT_TOOL_TIP"));
      System.out.println("ACTUAL Tool tip=" + getTextToolTip(driver, PROPERTY_VOUCHER_SUPPORT_LIST_FIRST, PACKAGE_ADULT_TOOL_TIP));
      System.out.println("=============================================================");
      check = false;

    }
    return check;
  }

  public void verifyToolTipRefundablePackage() {
    scrollToElement(driver, PROPERTY_CANCEL_POLICY_LABEL);
    String refundPackage = getTextElement(driver, PACKAGE_REFUNDABLILITY_FIRST);
    if (StringUtils.contains(refundPackage, getTextFromReadFile("REFUNDABLE_FILTER_TXT"))) {
      boolean getTextToolTipRefund = StringUtils.equals(getTextToolTip(driver, PROPERTY_VIEW_ALL_POLICY_LABEL_FIRST, PACKAGE_REFUNDABLILITY_TOOL_TIP3),
        getTextFromReadFile("PACKAGE_REFUNDABLILITY_TOOL_TIP3"));
      if (!getTextToolTipRefund) {
        System.out.println("Tooltip refundability wrong");
      }
    } else {
      boolean getTextToolTipNonRefund = StringUtils.equals(getTextToolTip(driver, PROPERTY_VIEW_ALL_POLICY_LABEL_FIRST, PACKAGE_NON_REFUNDABLILITY_TOOL_TIP),
        getTextFromReadFile("PACKAGE_NON_REFUNDABLILITY_TOOL_TIP"));
      if (!getTextToolTipNonRefund) {
        System.out.println("Tooltip Non Refundability wrong");
      }
    }
  }

  public boolean verifyRefundable() {
    boolean check = true;
    List<String> listExpect = new ArrayList<>();
    listExpect.add(getTextFromReadFile("REFUNDABLE_FILTER_TXT"));
    listExpect.add(getTextFromReadFile("PROPERTY_NON_REFUNDABLILITY"));
    for (String element : addListActualFromListXpath(PACKAGE_REFUNDABLILITY_PROPERTY, PACKAGE_REFUNDABLILITY_PROPERTY_DYNAMIC)) {
      if (!listExpect.contains(element)) {
        System.out.println("ACTUAL: " + element);
        System.out.println("EXPECT:" + addListActualFromListXpath(PACKAGE_REFUNDABLILITY_PROPERTY, PACKAGE_REFUNDABLILITY_PROPERTY_DYNAMIC));
        check = false;
      }
    }
    return check;
  }

  public boolean verifyRoom() {
    boolean check = false;
    boolean b1 = StringUtils.contains(getTextElement(driver, PROPERTY_ROOM_ONLY_TXT), getTextFromReadFile("PROPERTY_ROOM_ONLY"));
    boolean b2 = StringUtils.contains(getTextElement(driver, PROPERTY_ROOM_ONLY_TXT), getTextFromReadFile("PROPERTY_ROOM_INCLUDE"));
    if (b1 || b2) {
      check = true;
    } else {
      System.out.println("PROPERTY_ROOM_ONLY" + getTextElement(driver, PROPERTY_ROOM_ONLY_TXT));
      System.out.println("PROPERTY_ROOM_ONLY exp1: " + getTextFromReadFile("PROPERTY_ROOM_INCLUDE"));
      System.out.println("PROPERTY_ROOM_ONLY exp2: " + getTextFromReadFile("PROPERTY_ROOM_ONLY"));
    }
    return check;
  }
}
