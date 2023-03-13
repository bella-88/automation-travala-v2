package commons.hotel;

import commons.CommonTravalaPages;
import commons.CommonsTravalaXpath;
import enumerable.DateTime;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.SearchPage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static commons.CommonDataTravala.*;
import static commons.CommonsTravalaXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.CheckOutPageUI.*;
import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.*;
//import static constants.hotel.contentCoinPage.ConstCoinPage.*;
//import static interfaces.hotel.CheckOutPageUI.*;
//import static interfaces.hotel.LandingPageUI.*;
//import static interfaces.hotel.hotel.footer.support.HelpCenterPageUI.*;
//import static interfaces.hotel.footer.travala.TravelGiftCardPageUI.TRAVEL_GIFT_CARD_BUY_GIFT_CARD_LINK;
import static interfaces.hotel.footer.support.HelpCenterPageUI.*;
import static interfaces.hotel.footer.travala.TravelGiftCardPageUI.TRAVEL_GIFT_CARD_BUY_GIFT_CARD_LINK;
import static interfaces.hotel.myProfile.MySmartPageUI.*;
import static interfaces.hotel.myProfile.MyTravelCreditsPageUI.*;
//import static java.interfaces.LandingActPageUI.*;

public class CommonHotelPages extends CommonTravalaPages {
  //Method set driver từ con sang cha
  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver driver;
  private boolean status = true;
  private boolean check = true;
  private boolean compareList = true;
  
 

  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>LANDING PAGE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  public void inputLocationSearch(String searchTxt) {
    waitFoElementVisible(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
    clickToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
    WebElement element = driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX_FIRST));
    element.sendKeys(searchTxt);
    wait2sTime();
    WebElement searchDestination = driver.findElement(By.xpath(RESULT_TYPE_FIRST));
    searchDestination.click();
  }

  public void inputPropertySearch(String searchTxt) {
    clickToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
    WebElement search = driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX_FIRST));
    search.sendKeys(searchTxt);
    wait2sTime();
    waitFoElementVisible(driver, SELECTBOX_SEARCH);
    scrollToElement(driver, HOTEL_PROPERTY_TEXTBOX);
//    WebElement searchProperty = driver.findElement(By.xpath(HOTEL_PROPERTY_TEXTBOX));
//    wait2sTime();
//    searchProperty.click();
    clickToElementByJavascript(driver, HOTEL_PROPERTY_TEXTBOX);
  }

//  public void inputDestination(String destination) {
//    clickToElementByJavascript(driver, ACT_INPUT_TEXTBOX);
//    sendkeysToElement(driver, ACT_INPUT_TEXTBOX, destination);
//    waitFoElementVisible(driver, SUGGESTION_POPUP);
//    clickToElementByJavascript(driver, FIRST_SUGGESTION_DESTINATION);
//  }

  public SearchPage clickSearchHotelBtn(WebDriver driver) {
    clickToElementByAction(driver, LANDING_SEARCH_BUTTON);
    return new SearchPage(driver);
  }
  public void verifyTextSearchBar() {
    int i = 1;
    boolean checkUrl = StringUtils.contains(getCurrentUrl(driver), PAYMENT_PATH);
    List<WebElement> elements = driver.findElements(By.xpath(DOMAIN_TAB_LIST));
    while (i < elements.size() + 1) {
      String xpath = String.format(DOMAIN_TAB_LIST_DYNAMIC, i);
      waitFoElementVisible(driver, xpath);
      clickToElementByJavascript(driver, xpath);
      waitFoElementVisible(driver, xpath);
      String domain = getTextElement(driver, xpath);
      switch (domain) {
        case "Stays":
          if (checkUrl) {
            String[] bannerCoinLandingHotel = {CONST_BANNER_TITLE1, CONST_BANNER_TITLE2};
            verifyTextBannerCoinLanding(bannerCoinLandingHotel);
          } else {
            String[] bannerHotel = {"HOTEL_BANNER_TITLE", "HOTEL_BANNER_SUB_TITLE"};
            verifyTextBanner(bannerHotel);
          }
//          verifyDefaultSearchHotel();
          break;
//        case "Flights":
//          if (checkUrl) {
//            String[] bannerCoinLandingFlight = {CONST_BANNER_TITLE_FLIGHT1, CONST_BANNER_TITLE_FLIGHT2};
//            verifyTextBannerCoinLanding(bannerCoinLandingFlight);
//          } else {
//            String[] bannerFlight = {"FLIGHT_BANNER_TITLE", "FLIGHT_BANNER_SUB_TITLE"};
//            verifyTextBanner(bannerFlight);
//          }
//          verifyDefaultSearchFlight();
//          break;
//        case "Activities":
//          if (checkUrl) {
//            String[] bannerCoinLandingAct = {CONST_BANNER_TITLE_ACTIVITIES1, CONST_BANNER_TITLE_ACTIVITIES2};
//            verifyTextBannerCoinLanding(bannerCoinLandingAct);
//          } else {
//            String[] bannerAct = {"ACT_BANNER_TITLE", "ACT_BANNER_SUB_TITLE"};
//            verifyTextBanner(bannerAct);
//          }
//          verifyDefaultSearchAct();
//          break;
      }
      i++;
    }
    clickBackToTravala(driver);
  }
  public void verifyDisplayDateTimeDefaultSearch() {
    String getDateTimeAct = getTextElement(driver, HOTEL_DATEPICKER);
    boolean time = true;
    DateFormat df = new SimpleDateFormat("dd MMM yyyy");
    Date dateAct = null;
    try {
      dateAct = df.parse(getTextBySplit(getDateTimeAct, "-", 0));
    } catch (ParseException e) {
      System.out.println(e.getErrorOffset());
    }
    Long dateChange = (dateAct.getTime() - getDateSystem().getTime()) / (24 * 60 * 60 * 1000);
    if (!(dateChange == 6)) {
      System.out.println("Date default wrong: " + dateChange);
      time = false;
    }
    clickToElementByJavascript(driver, HOTEL_DATEPICKER);
    boolean month = true;
    if (!verifyTextByGetTextElement(getDateTimeAct, MONTH_NAME)) {
      System.out.println("Month Name Act: " + getDateTimeAct);
      System.out.println("Month Name Exp: " + getTextElement(driver, MONTH_NAME));
      month = false;
    }
    if ((month && time)) {
      System.out.println("Date time displayed in search textbox Hotel correct!");
    } else {
      System.out.println("Date time displayed in search textbox Hotel wrong!");
    }
    clickToElementByJavascript(driver, HOTEL_DATEPICKER);
  }

//  public void verifyErrorSearch(String xpathBtn) {
//    clickToElementByJavascript(driver, xpathBtn);
//    waitFoElementVisible(driver, POPUP_EMPTY_SEARCH_CONTENT);
//    if (!verifyTextByKey("NOT_FOUND_SEARCH", POPUP_ERROR_SEARCH_ACT_TEXT)) {
//      System.out.println("Show message when don't input text to search wrong");
//      System.out.println("EXPECT=" + getTextFromReadFile("NOT_FOUND_SEARCH"));
//      System.out.println("ACTUAL=" + getTextElement(driver, POPUP_ERROR_SEARCH_ACT_TEXT));
//      System.out.println("=============================================================");
//    } else {
//      System.out.println("Show message when don't input text to search correct");
//    }
//    clickToElement(driver, ICON_CLOSE_BTN);
//  }

  public void verifyDisplayAVAFirstPlace(String xpath, String fullNameCoin) {
    if (!StringUtils.contains(getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "), fullNameCoin)) {
      System.out.println("The first coin is: " + getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "));
      System.out.println("AVA is not displayed on the first place!");
    }
  }

  public void verifyDisplayRoomInfoHotel() {
    boolean roomB = true;
    boolean adultB = true;
    if (!(verifyTextByKey("SEARCH_ROOM", SELECT_ROOM) && verifyTextByKey("SEARCH_ADULT", SELECT_ADULT))) {
      System.out.println("Default room at search textbox Hotel wrong!");
      roomB = false;
    }
    clickToElement(driver, SELECT_ROOM);
    String[] adult = {"PROPERTY_ROOM_ADULT_LABEL", "PROPERTY_ROOM_CHILDREN_LABEL"};
    String[] adultSelected = {"SEARCH_SELECTED_ADULT", "SEARCH_SELECTED_CHILDREN"};
    String[] roomBtn = {"PROPERTY_ROOM_ADD_BTN", "PROPERTY_ROOM_CANCEL_BTN", "PROPERTY_ROOM_DONE_BTN"};
    adultB = verifyTextByKey("PROPERTY_ROOM_TITLE", ROOM_TITLE) && compareTwoListByKey(adult, ADULT_LABEL) && compareTwoListByKey(adultSelected, ADULT_SELECTED_LABEL) && compareTwoListByKey(roomBtn,
      ROOM_BTN);
    if (roomB && adultB) {
      System.out.println("Default Adult of Search textbox Hotel correct!");
    } else {
      System.out.println("Default Adult of Search textbox Hotel wrong!");
    }
    clickToElement(driver, SELECT_ROOM);
  }

  public void verifyFourOptionLandingPage() {
    scrollToElement(driver, LANDING_CUSTOMER_SUPPORT_TEXT);
    String[] title = {"LandingPage_CustomerSupport", "MENU_BestPrice", "LandingPage_MultiPaymentOption", "LandingPage_RealValueRewards"};
    String[] content = {"LandingPage_CustomerSupport_Content", "LandingPage_BestPriceGuarantee_Content", "LandingPage_MultiPaymentOption_Content", "LandingPage_RealValueRewards_Content"};
    boolean b = verifyListItemByListExpect(title, LANDING_FOUR_BENEFIT_LIST, LANDING_FOUR_BENEFIT_DYNAMIC);
    boolean b1 = verifyListItemByListExpect(content, LANDING_FOUR_BENEFIT_CONTENT_LIST, LANDING_FOUR_BENEFIT_CONTENT_DYNAMIC);
    if (!b) {
      System.out.println("Title of Four Benefit are displayed wrong");
    }
    if (!b1) {
      System.out.println("Content of Four Benefit are displayed wrong");
    }
    if (b && b1) {
      System.out.println("Four Benefit at Landing Page correct!");
    }
  }
  public void verifySearchLanguageHeader(String language) {
    clickToElementByJavascript(driver, SEARCH_CURRENCY_TXT);
    sendkeysToElement(driver, SEARCH_CURRENCY_TXT, language);
    if ((checkShowElement(driver, SEARCH_NOT_FOUND_HEADER) != 0)) {
      verifyTextAfterSearchHeader();
      System.out.println("Display when no result found for " + language + "correct!");
    } else {
      if (!verifyTextByGetTextElement(language, HEADER_LANGUAGE_RESULT)) {
        System.out.println("Search " + language + " at header wrong!");
      } else {
        System.out.println("Search " + language + " at header correct!");
      }
      clearTextElement(driver, SEARCH_CURRENCY_TXT);
    }
  }

  //================================PAYMENT CHECKOUT============================

  //===================================-===============VERIFY CREDIT CARD================================================





  //===================================-===============VERIFY AMOUNT TRAVEL - GIFT CARD================================================

  public void clickVNPayOption(WebDriver driver) {
    waitFoElementVisible(driver, VNPAY_BUTTON);
    clickToElement(driver, VNPAY_BUTTON);
    wait1sTime();
  }

  public void clickBinancePayOption(WebDriver driver) {
    waitFoElementVisible(driver, BINANCE_PAY_BUTTON);
    clickToElement(driver, BINANCE_PAY_BUTTON);
    wait1sTime();
  }

  public void clickWeChatOption(WebDriver driver) {
    waitFoElementVisible(driver, PAYMENT_BUTTON);
    clickToElement(driver, PAYMENT_BUTTON);
    wait1sTime();
  }

  //===================================-===============VERIFY CREDIT CARD================================================
  public void inputCreditCard(String cardNumber, String expDate, String cvc) {
    clickToElementByJavascript(driver, CommonsTravalaXpath.CREDIT_CARD_OPTION);
    switchToIframe(driver, IFRAME_CARD_NUMBER);
    clickToElementByJavascript(driver, CARD_NUMBER_TXT);
    sendkeysToElement(driver, CARD_NUMBER_TXT, cardNumber);
    driver.findElement(By.xpath(CARD_NUMBER_TXT)).sendKeys(Keys.TAB);
    driver.findElement(By.xpath(EXP_DATE_TXT)).sendKeys(expDate);
    driver.findElement(By.xpath(CVC_TXT)).sendKeys(cvc);
    driver.switchTo().parentFrame();
  }



  public boolean verifyTextCreditCardOption(WebDriver driver) {
    clickToElementByJavascript(driver, CommonsTravalaXpath.CREDIT_CARD_OPTION);
    switchToIframe(driver, IFRAME_CARD_NUMBER);
    if (!StringUtils.contains(getAttribute(driver, CARD_NUMBER_TXT, "placeholder"), getTextFromReadFile("CREDIT_CARD_NUMBER_HOLDER"))) {
      System.out.println("ACTUAL=" + getAttribute(driver, CARD_NUMBER_TXT, "placeholder"));
      System.out.println("EXPECT=" + getTextFromReadFile("CREDIT_CARD_NUMBER_HOLDER"));
      System.out.println("=============================================================");
      check = false;
    }
    driver.switchTo().parentFrame();
    if (!verifyTextByKey("CREDIT_CARD_NUMBER_NOTE", NOTE_CREDIT_CARD_TXT) || !verifyTextByKey("CREDIT_CARD_NUMBER_HOLDER", CARD_NUMBER_LABEL)) {
      System.out.println("ACTUAL NOTE_CREDIT_CARD_TXT=" + getTextElement(driver, NOTE_CREDIT_CARD_TXT));
      System.out.println("ACTUAL CARD_NUMBER_LABEL=" + getTextElement(driver, CARD_NUMBER_LABEL));
    }
    return check;
  }

  //===================================-===============VERIFY AMOUNT TRAVEL - GIFT CARD================================================



  public void inputAmount(String amountGc) {
    waitFoElementVisible(driver, INPUT_AMOUNT_TXT);
    clearTextBox(driver, INPUT_AMOUNT_TXT);
    clickToElementByJavascript(driver, INPUT_AMOUNT_TXT);
    sendkeysToElement(driver, INPUT_AMOUNT_TXT, amountGc);
  }

  public void verifyTextInvalidAmount(String mesMin, String mesMax) {
    inputAmount("0");
    boolean min = verifyTextByKey(mesMin, ERROR_MESSAGE_AMOUNT);
    inputAmount("60000");
    boolean max = verifyTextByKey(mesMax, ERROR_MESSAGE_AMOUNT);
    if (!(max && min)) {
      System.out.println("Error message when input invalid amount GC wrong");
    } else {
      System.out.println("Error message when input invalid amount GC correct");
    }
    clearTextElement(driver, INPUT_AMOUNT_TXT);
  }

  public boolean checkDisplayTAmountTravelCredit() {
    status = false;
    String[] listExpectTC = new String[] {"50", "100", "500", "1000", "2000", "5000"};
    List<WebElement> listTC = driver.findElements(By.xpath(AMOUNT_BUTTON_LIST));
    int listSize = listTC.size();
    for (int i = 0; i < listSize; i++) {
      listTC.get(i).click();
      String actualTotal = driver.findElement(By.xpath(TOTAL_TC)).getText();
      String actualSubTotal = driver.findElement(By.xpath(SUB_TOTAL_TC)).getText();
      for (int j = 0; j < listExpectTC.length; j++) {
        if ((StringUtils.contains(listExpectTC[j], actualSubTotal)) && (StringUtils.contains(listExpectTC[j], actualTotal))) {
          status = true;
        } else {
          System.out.println(" Sub total: " + (StringUtils.contains(listExpectTC[j], actualSubTotal)));
          System.out.println("actualTotal: " + actualTotal + "->" + listExpectTC[i]);
          System.out.println(" Total: " + (StringUtils.contains(listExpectTC[j], actualTotal)));
          System.out.println("actualSubTotal: " + actualSubTotal + "->" + listExpectTC[i]);
          status = false;
        }
      }
    }
    return status;
  }

  //===================================-===============VERIFY CRYPTO ================================================

  public boolean verifyDisplayListCrypto(String listXpathCurrency, String[] expectCurrency) {
    List<WebElement> currency = driver.findElements(By.xpath(listXpathCurrency));
    List<String> currencyActual = new ArrayList<String>();
    boolean coin = true;
    for (int i = 0; i < currency.size(); i++) {
      String crypto = currency.get(i).getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
      currencyActual.add(crypto);
    }
    int count = 0;
    for (String element : currencyActual) {
      if (!addListExpByConst(expectCurrency).contains(element)) {
        count = count + 1;
        System.out.println("Coin Actual failed:\"" + element + "\"");
        coin = false;
      }
    }
    if (currencyActual.size() > addListExpByConst(expectCurrency).size()) {
      System.out.println("Total currency Actual: " + currencyActual.size());
      System.out.println("Total currency Expect: " + addListExpByConst(expectCurrency).size());
    }
    if (count != 0) {
      System.out.println("Number coin wrong is: " + count);
    }
    return coin;
  }

  //===================================-===============VERIFY MY WALLET ================================================
  public boolean verifyWalletName() {
    String[] labelWallet = {"MY_WALLET_BALANCE_AVA", "MY_TC_PAYMENT_WALLET_BNB", "MY_TC_PAYMENT_WALLET_BUSD"};
    return compareTwoListByKey(labelWallet, PAYMENT_WALLET_NAME_LIST);
  }

  public void datePickerAnyDayHotel(int day) {
//    WebElement elm = driver.findElement(By.xpath(HOTEL_DATEPICKER));
//    elm.click();
    clickToElementByJavascript(driver, HOTEL_DATEPICKER);
//    waitFoElementVisible(driver, POPUP_CALENDAR);
    WebElement preMonth = driver.findElement(By.xpath(SEARCH_PRE_MONTH_BTN));
    preMonth.click();
    WebElement currentDay = driver.findElement(By.xpath(SEARCH_CURRENT_DAY));
    currentDay.click();
    String leftMonthName = driver.findElement(By.xpath(SEARCH_MONTH_NAME)).getText().trim();
    String[] strs = leftMonthName.split(" ");
    String monthAfterPlus = getCurrentMonthByCalendar(day);
    WebElement futureDay = null;
    String flag = null;
    String[] strFlag = getCurrentUrl(driver).split(".com/", 2);
    if (strFlag.length == 1) {
      flag = strFlag[0];
    } else {
      flag = strFlag[1];
    }
    int dateTime = 0;
    if (StringUtils.contains(flag, "/search?")) {
      flag = flag.split("/search?", 2)[0];
    }
    if (StringUtils.contains(flag, "hotels")) {
      flag = flag.split("/hotel/", 2)[0];
    }
    switch (flag) {
      case "":
        dateTime = DateTime.MyMonthEng.valueOf(strs[0]).getMonth();
        wait100Time();
        break;
      case "en-US":
        dateTime = DateTime.MyMonthEng.valueOf(strs[0]).getMonth();
        System.out.println();
        break;
      case "kr":
        dateTime = Integer.parseInt(strs[0].replace("월", ""));
        break;
      case "ko":
        dateTime = Integer.parseInt(strs[0].replace("월", ""));
        System.out.println("Date Time kr: " + dateTime);
        break;
      case "es":
        dateTime = DateTime.MyMonthEs.valueOf(strs[0]).getMonth();
        break;
      case "fr":
        dateTime = DateTime.MyMonthFr.valueOf(getTextBySplit(leftMonthName, " ", 0).replace(".", "")).getMonth();
        break;
      case "vn":
        wait100Time();
        dateTime = Integer.parseInt(strs[1]);
        break;
      case "cn":
        dateTime = Integer.parseInt(strs[0].replace("月", ""));
        wait100Time();
        break;
      case "zh":
        dateTime = Integer.parseInt(strs[0].replace("月", ""));
        wait200Time();
        break;
      case "de":
        dateTime = DateTime.MyMonthDe.valueOf(strs[0]).getMonth();
        break;
      case "ru":
        wait100Time();
        dateTime = DateTime.MyMonthRu.valueOf(getTextBySplit(leftMonthName, " ", 0).replace(".", "")).getMonth();
        break;
      default:
        System.out.println("Flag is returned from URL wrong! ");
    }
    String dayPlus = getDayAfterPlusDate(day);
    if (Integer.parseInt(monthAfterPlus) == dateTime) {
      futureDay = driver.findElement(By.xpath(
        "((//div[@class='rdrDays'])[position()=1]/button[contains(@class,'rdrDay') and not(contains(@class,'rdrDayDisabled'))]/span[contains(@class,'rdrDayNumber')]/span[contains(text()," + dayPlus + ")]/..)[1]"));
    } else {
      futureDay = driver.findElement(By.xpath(
        "((//div[@class='rdrDays'])[position()=2]/button[contains(@class,'rdrDay') and not(contains(@class,'rdrDayDisabled'))]/span[contains(@class,'rdrDayNumber')]/span[contains(text()," + dayPlus + ")]/..)[1]"));
    }
    futureDay.click();
  }






  public void verifyNameWallet() {
    String[] name = {"CHECKOUT_PAYMENT_WALLET_NAME1", "CHECKOUT_PAYMENT_WALLET_NAME2", "CHECKOUT_PAYMENT_WALLET_NAME3"};
    boolean b = verifyListItemByListExpect(name, PAYMENT_WALLET_NAME_LIST, PAYMENT_WALLET_NAME_DYNAMIC);
    if (!b) {
      System.out.println("Name Wallet wrong");
    }
  }

  public Double getWalletBalance(String coin) {
    String getWalletBalance = null;
    switch (coin) {
      case "AVA":
        getWalletBalance = getTextElement(driver, String.format(CHECKOUT_WALLET_MAIN_BALANCE_DYNAMIC, coin)).replace(",", "");
        break;
      case "BNB":
//        clickElementByDynamicLocator(driver, CHECKOUT_WALLET_RADIO_DYNAMIC, coin);
        wait300Time();
        getWalletBalance = getTextElement(driver, String.format(CHECKOUT_WALLET_MAIN_BALANCE_DYNAMIC, coin)).replace(",", "");
        break;
      case "BUSD":
//        clickElementByDynamicLocator(driver, CHECKOUT_WALLET_RADIO_DYNAMIC, coin);
        wait100Time();
        getWalletBalance = getTextElement(driver, String.format(CHECKOUT_WALLET_MAIN_BALANCE_DYNAMIC, coin)).replace(",", "");
        break;
      default:
        System.out.println("Can not get balance a coin at my wallet");
        break;
    }
    return Double.parseDouble(getWalletBalance);
  }

  public boolean verifyTextNotEnoughCoin(String[] infoExpect, String[] xpathWallet, String coinWallet) {
    String[] content = infoExpect;
    boolean a = true;
    boolean b = true;
    boolean c = true;
    String[] xpath = xpathWallet;
    switch (coinWallet) {
      case "AVA":
        if (!verifyTwoListByConst(addListExpectAfterFormatFromKey(infoExpect, coinWallet), xpathWallet)) {
          a = false;
        }
        break;
      case "BNB":
        if (!verifyTwoListByConst(addListExpectAfterFormatFromKey(infoExpect, coinWallet), xpathWallet)) {
          b = false;
        }
        break;
      case "BUSD":
        if (!verifyTwoListByConst(addListExpectAfterFormatFromKey(infoExpect, coinWallet), xpathWallet)) {
          c = false;
        }
        break;
      default:
        System.out.println("Can not choice a coin at my wallet to Payment");
        break;
    }
    return a & b & c;
  }

  public void verifyPaySection(String coinName) {
//    String[] howtoPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6, CONST_HOW_TO_PAY7, CONST_HOW_TO_PAY8, CONST_HOW_TO_PAY9, CONST_HOW_TO_PAY10, CONST_HOW_TO_PAY11};
    String[] howtoPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
    if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howtoPay, coinName), COIN_PAY_CONTENT)
      && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
      System.out.println("Content at How to pay of " + coinName + " wrong!");
    } else {
      System.out.println("Content at How to pay of " + coinName + " correctly!");
    }
  }

  public void verifyMarketLabel() {
    String[] market = {CONST_MARKET_LABEL, CONST_CIRCULATION_LABEL, CONST_TOTAL_LABEL};
    boolean b = compareTwoListByConst(market, COIN_MARKET_LABEL_LIST);
    if (!b) {
      System.out.println("Market label wrong!");
    }
  }


  public boolean verifyListTitleQuestion(String[] listExp, String namePage) {
    waitFoElementVisible(driver, HELP_COMMON_QUESTION_LIST);
    boolean title = compareTwoListByKey(listExp, HELP_COMMON_QUESTION_LIST);
    String page = getTextFromReadFile(namePage);
    if (!title) {
      System.out.println("List title question " + page + " is displayed wrong");
    }
    return title;
  }

  public boolean verifyListQuestionFAQ(String[] expQuestion, String namePage, String xpathToClick) {
    List<WebElement> element = driver.findElements(By.xpath(HELP_COMMON_QUESTION_LIST));
    wait100Time();
    boolean sQuestion = true;
    int i = 1;
    while (i < element.size() + 1) {
      String xpath = String.format(HELP_COMMON_QUESTION_DYNAMIC, i);
      clickToElement(driver, xpath);
      if (!verifyTwoList(addActualFromElement(HELP_GROUP_QUESTION_TITLE), addListExpectByKey(expQuestion))) {
        sQuestion = false;
      }
      clickToElementByJavascript(driver, xpathToClick);
      i++;
    }
    String page = getTextFromReadFile(namePage);
    if (!sQuestion) {
      System.out.println("Question in " + page + " is displayed wrong");
    }
    return sQuestion;
  }

  public boolean verifyListAnswersFAQ(String[] expAnswers, String namePage, String xpathToClick) {
    List<WebElement> element = driver.findElements(By.xpath(HELP_COMMON_QUESTION_LIST));
    wait100Time();
    int i = 1;
    boolean sAnswers = true;
    while (i < element.size() + 1) {
      String xpath = String.format(HELP_COMMON_QUESTION_DYNAMIC, i);
      clickToElement(driver, xpath);
      wait100Time();
      if (!verifyTwoList(addActualFromElement(HELP_GROUP_ANSWERS_LIST), addListExpectByKey(expAnswers))) {
        sAnswers = false;
//        System.out.println("Expect: "+ addListExpectByKey(expAnswers));
        System.out.println("Answers at " + i + " position wrong");
      }
      clickToElementByJavascript(driver, xpathToClick);
      i++;
    }
    if (!sAnswers) {
      System.out.println("Answers in " + getTextFromReadFile(namePage) + " is displayed wrong");
    }
    return sAnswers;
  }



  public void clickToShowAllItems(String listXpath) {
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    for (WebElement i : elements) {
      i.click();
      wait100Time();
    }
  }


  public boolean verifyMenuStaticPage() {
    String[] content = {"MENU_AboutUs", "MENU_InviteProgram", "MENU_SmartProgram", "MENU_BestPrice", "MENU_TravelGiftCard", "MENU_TravelCredit", "FOOTER_PAGE_PAYMENT_OPTION",
      "MENU_PrivacyPolicy", "MENU_CookiePolicy", "MENU_ContactUs", "MENU_TermsConditions", "MENU_ACTIVE_NFT", "HELP_FLIGHT_TRAVEL_SMART_PROTECTION"};
    boolean b = compareTwoListByKey(content, MENU_FOOTER_LIST);
    if (!b) {
      System.out.println("Menu at " + getTextElement(driver, LINK_STATIC_PAGE) + " page wrong");
    }
    return b;
  }

  public boolean verifyUrlPage(String urlExpect) {
    String expUrl = null;
    String actUrl = null;
    boolean checkUrl = true;
//    if (StringUtils.contains(Flag.valueOf(LANGUAGE).getFlg(), "us")) {
//      expUrl = getEvn() + "/en-US/" + urlExpect;
//    } else {
//      if (StringUtils.contains("en", Flag.valueOf(LANGUAGE).getFlg())) {
//        expUrl = getEvn() + "/" + urlExpect;
//      } else {
//        expUrl = getEvn() + "/" + Flag.valueOf(LANGUAGE).getFlg() + "/" + urlExpect;
//      }
//    }
//
//    if (StringUtils.contains(expUrl, HELP_CENTER_PATH)) {
//      expUrl = expUrl.replace("common", "help/common");
//    } else if (StringUtils.contains(expUrl, PAYMENT_OPTIONS_PATH)) {
//      expUrl = expUrl.replaceAll("en-US/", "");
//    }
//    expUrl = expUrl.replaceAll("m//", "m/");
//    actUrl = getCurrentUrl(driver).replaceAll("www.", "");
//    if (!StringUtils.contains(expUrl, actUrl)) {
//      System.out.println("Url of " + urlExpect + " wrong!");
//      System.out.println("Actual:=" + actUrl + "=");
//      System.out.println("Expect:=" + expUrl + "=");
//      checkUrl = false;
//    }
    return checkUrl;
  }

  public void verifyMetaPage(String key) {
    if (!StringUtils.contains(getTitlePage(driver).trim(), getTextFromReadFile(key).trim())) {
      System.out.println("Actual Meta Page: " + getTitlePage(driver));
      System.out.println("Expect Meta Page: " + getTextFromReadFile(key));
      System.out.println("Meta page wrong");
    }
  }

  //============================VERIFY LANDING PAGE OF COIN==============================================================

  public void verifyMetaTitleOfCoinPage(String coinName) {
    boolean meta = true;
    String metaAct = getTitlePage(driver);
    String metaExp = null;
    if (StringUtils.contains(metaAct, "AVA")) {
      metaExp = CONST_META_AVA_HOTEL_TITLE.replaceAll("%s", coinName.trim());
    } else {
      metaExp = CONST_META_HOTEL_TITLE.replaceAll("%s", coinName.trim());
    }
    if (!StringUtils.equals(metaAct.replaceAll("\\r\\n|\\r|\\n", " ").trim(), metaExp.replaceAll("\\r\\n|\\r|\\n", " ").trim())) {
      System.out.println("Meta Actual:" + metaAct + ":");
      System.out.println("Meta Expect:" + metaExp + ":");
      meta = false;
    }
    if (!meta) {
      System.out.println(" Meta Title " + coinName + " Page Failed");
    }
  }
  public void verifyTeamName(String[] teamName, String[] teamPosition) {
    String coin = getTextBySplit(getCurrentUrl(driver), "payment/", 1);
    boolean a = compareTwoListByConst(teamName, COIN_TEAM_NAME);
    if (!a) {
      System.out.println("Name of team member " + coin + " wrong!");
    } else {
      System.out.println("Name of team member " + coin + " correctly!");
    }
    boolean a1 = compareTwoListByConst(teamPosition, COIN_TEAM_POSITION);
    if (!(a1 && a)) {
      System.out.println("Position of team member " + coin + " wrong!");
    } else {
      System.out.println("Position of team member " + coin + " correctly!");
    }
  }

  public void verifyTeamDes(String[] teamDes) {
    if (!compareTwoListByConst(teamDes, COIN_TEAM_DESCRIPTION)) {
      System.out.println("Description of team member " + getTextBySplit(getCurrentUrl(driver), "payment/", 1) + " wrong!");
    } else {
      System.out.println("Description of team member correctly.");
    }
  }

  public void verifyMoreUseCase(String[] moreUseCaseContent) {
    String[] useCaseTitle = {CONST_USE_CASE_SUB_TITLE1, CONST_USE_CASE_SUB_TITLE2, CONST_USE_CASE_SUB_TITLE3, CONST_USE_CASE_SUB_TITLE4, CONST_USE_CASE_SUB_TITLE5,
      CONST_USE_CASE_SUB_TITLE6, CONST_USE_CASE_SUB_TITLE7, CONST_USE_CASE_SUB_TITLE8, CONST_USE_CASE_SUB_TITLE9, CONST_USE_CASE_SUB_TITLE10, CONST_USE_CASE_SUB_TITLE11,
      CONST_USE_CASE_SUB_TITLE12, CONST_USE_CASE_SUB_TITLE13, CONST_USE_CASE_SUB_TITLE14, CONST_USE_CASE_SUB_TITLE15, CONST_USE_CASE_SUB_TITLE16, CONST_USE_CASE_SUB_TITLE17,
      CONST_USE_CASE_SUB_TITLE18, CONST_USE_CASE_SUB_TITLE19};
//      CONST_NANO_USE_CASE_TITLE1, CONST_NANO_USE_CASE_TITLE2, CONST_NANO_USE_CASE_TITLE3, CONST_NANO_USE_CASE_TITLE4,
//      CONST_NANO_USE_CASE_TITLE5, CONST_NANO_USE_CASE_TITLE6};
    if (!(compareTwoListByConst(useCaseTitle, COIN_MORE_USE_CASE_SUB_TITLE) && compareTwoListByConst(moreUseCaseContent, COIN_MORE_USE_CASE_SUB_CONTENT))) {
      System.out.println("More use case wrong!");
    } else {
      System.out.println("More use case correct!");
    }
  }

  public void verifyFAQSection(String[] faqExp, String[] faqContentExp) {
    verifyTextByConst(CONST_FAQ_TITLE, COIN_FAQ_TITLE);
    clickToListElement(driver, COIN_FAQ_QUESTION);
    clickToElementByJavascript(driver, COIN_FAQ_FIRST_QUESTION);
    if (!(compareTwoListByConst(faqExp, COIN_FAQ_QUESTION) && compareTwoListByConst(faqContentExp, COIN_FAQ_CONTENT))) {
      System.out.println("Content of FAQs wrong!");
    } else {
      System.out.println("Content of FAQs correct!");
    }
  }
  public void verifyTextBannerCoinLanding(String[] bannerCoinLanding) {
    String[] bannerText = bannerCoinLanding;
    String coin = null;
    String getUrl = getCurrentUrl(driver).replace("https://www.travala.com/payment/", "").replace("/flights", "").replace("/activities", "");
    if (StringUtils.contains(getUrl, "-")) {
      coin = getTextBySplit(getCurrentUrl(driver).replace("https://www.travala.com/payment/", ""), "-", 1).toUpperCase();
    } else {
      coin = getUrl.toUpperCase();
    }
    System.out.println("coin: " + coin);
    for (int j = 0; j < bannerText.length; j++) {
      if (StringUtils.contains(bannerText[j], "%s")) {
        bannerText[j] = bannerText[j].replaceAll("%s", coin.toUpperCase());
      }
    }
    if (!(compareTwoListByConst(bannerText, COIN_BANNER_TITLE1) && compareTwoListByConst(bannerText, COIN_BANNER_TITLE2))) {
      System.out.println("Banner domain Stays of Landing " + coin + " wrong");
    }
  }
  public void verifyWhatSection(String[] contentExp) {
    String[] marketCap = {CONST_MARKET_LABEL, CONST_CIRCULATION_LABEL, CONST_TOTAL_LABEL};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT, COIN_MISSION_TITLE, COIN_MISSION_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    boolean b = compareTwoListByConst(marketCap, COIN_MARKET_LABEL_LIST);
    if (!(a && b)) {
      System.out.println("Text at What is Coin wrong");
    }
  }

  public void verifyUseCase(String xpathTitle, String xpathContent, String[] useCaseContent, String[] useCaseTitle) {
    if (!(compareTwoListByConst(useCaseTitle, xpathTitle) && compareTwoListByConst(useCaseContent, xpathContent))) {
      System.out.println("Sub Title and Content of Use Case wrong!");
    } else {
      System.out.println("Sub Title and Content of Use Case correct!");
    }
  }
  public void verifyTradeSection(String coinName, String[] tradeLogo) {
    boolean text = verifyTextByConst(CONST_TRADE_TITLE.replaceAll("%s", coinName), COIN_TRADE_TITLE) && verifyTextByConst(CONST_TRADE_CONTENT1.replaceAll("%s", coinName),
      COIN_TRADE_CONTENT) || verifyTextByConst(CONST_TRADE_CONTENT.replaceAll("%s", coinName), COIN_TRADE_CONTENT);
    List<WebElement> elements = driver.findElements(By.xpath(COIN_TRADE_LOGO));
    int i = 1;
    boolean trade = true;
    if (elements.size() != tradeLogo.length) {
      System.out.println("Number Logo at Trade Actual: " + elements.size());
      System.out.println("Number Logo at Trade Expect: " + tradeLogo.length);
      System.out.println("Number Logo at Trade wrong");
    }
    while (i < elements.size() + 1) {
      String xpathLogo = String.format(COIN_TRADE_LOGO_DYNAMIC, i);
      String tradeLogoAct = getAttribute(driver, xpathLogo, "alt");
      if (!StringUtils.contains(tradeLogoAct, tradeLogo[i - 1])) {
        System.out.println("Expect Logo Trade at position: " + i + " is: " + tradeLogo[i - 1]);
        System.out.println("Actual Logo Trade at position: " + i + " is: " + tradeLogoAct);
        trade = false;
      }
      i++;
    }
    if (!(trade && text)) {
      System.out.println("Logo at Trade of " + coinName + " wrong");
    } else {
      System.out.println("Logo at Trade of " + coinName + " correctly");
    }
  }
  public void verifyStoreSection(String coinName, String[] storeLogo) {
    boolean text = verifyTextByConst(CONST_STORE_TITLE.replaceAll("%s", coinName), COIN_STORE_TITLE) && verifyTextByConst(CONST_STORE_SUB.replaceAll("%s", coinName),
      COIN_STORE_SUB) && verifyTextByConst(CONST_STORE_CONTENT.replaceAll("%s", coinName), COIN_STORE_CONTENT);
    List<WebElement> elements = driver.findElements(By.xpath(COIN_STORE_LOGO));
    int i = 1;
    boolean store = true;
    if (elements.size() != storeLogo.length) {
      System.out.println("Number Logo at Store Actual: " + elements.size());
      System.out.println("Number Logo at Store Expect: " + storeLogo.length);
      System.out.println("Number Logo at Store wrong");
    }
    while (i < elements.size() + 1) {
      String xpathLogo = String.format(COIN_STORE_LOGO_DYNAMIC, i);
      String storeLogoAct = getAttribute(driver, xpathLogo, "alt");
      if (!StringUtils.contains(storeLogoAct, storeLogo[i - 1])) {
        System.out.println("Expect Logo Store at position: " + i + " is: " + storeLogo[i - 1]);
        System.out.println("Actual Logo Store at position: " + i + " is: " + storeLogoAct);
        store = false;
      }
      i++;
    }
    if (!(store && text)) {
      System.out.println("Logo at Store of " + coinName + " wrong");
    } else {
      System.out.println("Logo at Store of " + coinName + " correctly");
    }
  }

  public boolean verifyTable() {
    boolean basicC = true;
    boolean steelC = true;
    boolean bronzeC = true;
    boolean silverC = true;
    boolean goldC = true;
    boolean platinumC = true;
    boolean diamondC = true;
    int i = 0;
    List<WebElement> elements = driver.findElements(By.xpath(INTRO_TABLE_TITLE));
    while (i < elements.size()) {
      elements.get(i).click();
      wait300Time();
      String xpath = String.format(INTRO_ICON_TABLE_DYNAMIC, i + 1);
      String amount = getAttribute(driver, xpath, "src").replaceAll("/images/smart/", "").replaceAll("-sm.svg", "").replaceAll("https://www.travala.com", "");
      String[] title = {"SMART_INTRO_PLATINUM_TITLE1", "SMART_INTRO_DIAMOND_TITLE3", "SMART_INTRO_DIAMOND_TITLE4", "SMART_INTRO_DIAMOND_TITLE5", "SMART_INTRO_DIAMOND_TITLE6", "SMART_INTRO_DIAMOND_TITLE7"};
      switch (amount) {
        case "basic":
          String[] basic = {"SMART_INTRO_DIAMOND_TITLE3", "SMART_INTRO_DIAMOND_TITLE4", "SMART_INTRO_DIAMOND_TITLE5", "SMART_INTRO_DIAMOND_TITLE6", "SMART_INTRO_DIAMOND_TITLE7"};
          String[] basicSub = {"SMART_INTRO_BASIC_SUB_TITLE1", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_BASIC_SUB_TITLE4", "SMART_INTRO_BASIC_SUB_TITLE5"};
          basicC = compareTwoListByKey(basic, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(basicSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!basicC) {
            System.out.println("Title of table is basicC Wrong");
          }
          break;
        case "steel":
          String[] steelSub = {"SMART_INTRO_STEEL_SUB_TITLE1", "SMART_INTRO_BASIC_SUB_TITLE1", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_STEEL_SUB_TITLE5", "SMART_INTRO_BASIC_SUB_TITLE5"};
          steelC = compareTwoListByKey(title, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(steelSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!steelC) {
            System.out.println("Title of table is steelC Wrong");
          }
          break;
        case "bronze":
          String[] bronzeSub = {"SMART_INTRO_BRONZE_SUB_TITLE1", "SMART_INTRO_BASIC_SUB_TITLE1", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_BRONZE_SUB_TITLE5", "SMART_INTRO_BASIC_SUB_TITLE5"};
          bronzeC = compareTwoListByKey(title, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(bronzeSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!bronzeC) {
            System.out.println("Title of table is bronzeC Wrong");
          }
          break;
        case "silver":
          String[] silverSub = {"SMART_INTRO_SILVER_SUB_TITLE1", "SMART_INTRO_SILVER_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_SILVER_SUB_TITLE5", "SMART_INTRO_BASIC_SUB_TITLE5"};
          silverC = compareTwoListByKey(title, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(silverSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!silverC) {
            System.out.println("Title of table is silverC Wrong");
          }
          break;
        case "gold":
          String[] goldSub = {"SMART_INTRO_GOLD_SUB_TITLE1", "SMART_INTRO_GOLD_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_GOLD_SUB_TITLE5", "SMART_INTRO_BASIC_SUB_TITLE5"};
          goldC = compareTwoListByKey(title, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(goldSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!goldC) {
            System.out.println("Title of table is goldC Wrong");
          }
          break;
        case "platinum":
          String[] platinumSub = {"SMART_INTRO_PLATINUM_SUB_TITLE1", "SMART_INTRO_PLATINUM_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_BASIC_SUB_TITLE3", "SMART_INTRO_DIAMOND_SUB_TITLE7", "SMART_INTRO_BASIC_SUB_TITLE5"};
          platinumC = compareTwoListByKey(title, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(platinumSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!platinumC) {
            System.out.println("Title of table is platinumC Wrong");
          }
          break;
        case "diamond":
          String[] diamond = {"SMART_INTRO_DIAMOND_TITLE1", "SMART_INTRO_DIAMOND_TITLE2", "SMART_INTRO_DIAMOND_TITLE3", "SMART_INTRO_DIAMOND_TITLE4", "SMART_INTRO_DIAMOND_TITLE5", "SMART_INTRO_DIAMOND_TITLE6", "SMART_INTRO_DIAMOND_TITLE7", "SMART_INTRO_DIAMOND_TITLE8", "SMART_INTRO_DIAMOND_TITLE9", "SMART_INTRO_DIAMOND_TITLE10"};
          String[] diamondSub = {"SMART_INTRO_DIAMOND_SUB_TITLE1", "SMART_INTRO_DIAMOND_SUB_TITLE2", "SMART_INTRO_DIAMOND_SUB_TITLE3", "SMART_INTRO_DIAMOND_SUB_TITLE4", "SMART_INTRO_DIAMOND_SUB_TITLE5", "SMART_INTRO_BASIC_SUB_TITLE5", "SMART_INTRO_DIAMOND_SUB_TITLE7", "SMART_INTRO_DIAMOND_SUB_TITLE8", "SMART_INTRO_DIAMOND_SUB_TITLE9", "SMART_INTRO_DIAMOND_SUB_TITLE10"};
          diamondC = compareTwoListByKey(diamond, INTRO_TABLE_CONTENT_TITLE) && compareTwoListByKey(diamondSub, INTRO_TABLE_CONTENT_SUB_TITLE);
          if (!diamondC) {
            System.out.println("Title of table is DiamondC Wrong");
          }
          break;
        default:
          System.out.println("Table is displayed wrong");
          break;
      }
      i++;
    }
    boolean check = basicC && steelC && silverC && goldC && platinumC && diamondC && bronzeC;
    return check;
  }

  public boolean verifyTableContent() {
    boolean status = true;
    String[] titleTableExp = {"SMART_INTRO_TABLE_TITLE1", "SMART_INTRO_TABLE_TITLE2", "SMART_INTRO_TABLE_TITLE3", "SMART_INTRO_TABLE_TITLE7", "SMART_INTRO_TABLE_TITLE4", "SMART_INTRO_TABLE_TITLE5", "SMART_INTRO_TABLE_TITLE6"};
    boolean title = compareTwoListByKey(titleTableExp, INTRO_TABLE_TITLE);
    if (!title) {
      System.out.println("Title table Wrong");
    }
    String[] contentTableExp = {"SMART_INTRO_TABLE_CONTENT1", "SMART_INTRO_TABLE_CONTENT2", "SMART_INTRO_TABLE_CONTENT3", "SMART_INTRO_TABLE_CONTENT7", "SMART_INTRO_TABLE_CONTENT4", "SMART_INTRO_TABLE_CONTENT5", "SMART_INTRO_TABLE_CONTENT6"};
    boolean subTitle = compareTwoListByKey(contentTableExp, INTRO_TABLE_TXT);
    if (!subTitle) {
      System.out.println("Sub Title table Wrong");
    }
    status = title && subTitle && verifyTable();
    return status;
  }

  public void selectCoinFromCryptoOption(String coin) {
    clickToElementByJavascript(driver, SELECT_CRYPTO_TXT);
//    verifyDisplayAVAFirstPlace(CRYPTO_COIN_NAME_FIRST, "AVA Travala");
    String namePage = null;
    if (StringUtils.contains(getCurrentUrl(driver), "booking")) {
      namePage = "Check-out page";
    } else {
      namePage = getTextBySplit(getCurrentUrl(driver), ".com/", 1);
    }
    if (!verifyDisplayListCrypto(CRYPTO_COIN_NAME, LIST_CRYPTO_PAYMENT)) {
      System.out.println("========List coin is displayed at Crypto Option of " + namePage + " wrong========");
    }
    clickToElementByJavascript(driver, INPUT_CRYPTO_TXT);
    sendkeysToElement(driver, INPUT_CRYPTO_TXT, coin);
    wait1sTime();
    String xpath = String.format(CRYPTO_DYNAMIC, coin);
    if ((checkShowElement(driver, CRYPTO_MINIMUM_VALUE) != 0) && (!StringUtils.contains(getTextElement(driver, CRYPTO_MINIMUM_VALUE),
      getTextFromReadFile("CRYPTO_POPUP_MINIMUM")))) {
      sendkeysToElement(driver, INPUT_CRYPTO_TXT, "AVA");
      System.out.println("Token " + coin + " Maintenance");
      clickToElementByJavascript(driver, String.format(CRYPTO_DYNAMIC, "AVA"));
    } else {
      clickToElementByJavascript(driver, xpath);
    }
  }

  public void verifyDisplayLogoCrypto(String coin) {
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    selectCoinFromCryptoOption(coin);
    wait2sTime();
  }

  public void clickOnUrlToLinkBuyGC() {
//    scrollToLoadMore(driver);
    scrollToBottomPage(driver);
    waitFoElementVisible(driver, GIFT_CARD_FOOTER_LINK);
    clickToElementByJavascript(driver, GIFT_CARD_FOOTER_LINK);
    switchToOtherWindowbyUrl(driver, TRAVEL_GIFT_CARD_URL);
    clickToElementByJavascript(driver, TRAVEL_GIFT_CARD_BUY_GIFT_CARD_LINK);
  }
  public boolean verifyDisplayTextAtFooter() {
    scrollToLoadMore(driver);
    String[] pageFooter = {"FOOTER_PAGE_ABOUT_US", "FOOTER_PAGE_AVA_TOKEN", "FOOTER_PAGE_SMART_PROGRAM", "FOOTER_PAGE_INVITE_PROGRAM", "FOOTER_PAGE_PRICE_GUARANTEE", "FOOTER_PAGE_AFFILIATE",
      "FOOTER_PAGE_TRAVEL_CREDIT", "FOOTER_PAGE_TRAVEL_GIFT_CARD", "FOOTER_PAGE_TRAVEL_MEMBER", "FOOTER_PAGE_HELP_CENTER", "FOOTER_PAGE_MY_TRIP",
      "FOOTER_PAGE_TERM_CONDITION", "FOOTER_PAGE_COOKIE", "FOOTER_PAGE_PRIVACY", "FOOTER_PAGE_CONTACT_US", "FOOTER_PAGE_PARTNER_SHIP", "FOOTER_PAGE_CONCIERGE",
      "FOOTER_PAGE_MEDIA", "FOOTER_PAGE_MOBILE_APP", "FOOTER_PAGE_BUSINESS_TRAVEL", "FOOTER_PAGE_PAYMENT_OPTION", "FOOTER_PAGE_BINANCE_TRAVEL",
      "FOOTER_PAGE_PARTNER_NETWORK", "FOOTER_PAGE_BUG_REPORT", "FOOTER_PAGE_SITE_MAP", "FOOTER_PAGE_OFFICIAL_BLOG", "FOOTER_PAGE_TRAVEL_ADVICES",
      "FOOTER_PAGE_TRAVEL_GUIDES", "FOOTER_PAGE_READ_REVIEW", "FOOTER_PAGE_OUR_PARTNER", "FOOTER_PAGE_COIN_LISTING", "FOOTER_PAGE_CAREERS", "MENU_ACTIVE_NFT",
      "FOOTER_PAGE_TWITTER", "FOOTER_PAGE_FACEBOOK", "FOOTER_PAGE_TELEGRAM", "FOOTER_PAGE_INSTAGRAM", "FOOTER_PAGE_REDDIT", "FOOTER_PAGE_LINKEDIN"};
    boolean b = compareTwoListByKey(pageFooter, FOOTER_PAGE_LIST);
    if (!b) {
      System.out.println("The items link at footer is display wrong! ");
    }
    String[] content = {"TRAVALA_COLUMN", "SUPPORT_COLUMN", "USEFUL_COLUMN", "RESOURCES_COLUMN", "COMMUNITY_COLUMN", "CRYPTO_CURRENT_FRIENDLY_TITLE", "CRYPTO_CURRENT_FRIENDLY_CONTENT", "FOOTER_PAGE_PAYMENT_OPTION", "FOOTER_CONTENT_ACCEPT_PAYMENT"};
    String[] xpath = {TRAVALA_COLUMN, SUPPORT_COLUMN, USEFUL_COLUMN, RESOURCES_COLUMN, COMMUNITY_COLUMN, CRYPTO_CURRENT_FRIENDLY_TITLE, CRYPTO_CURRENT_FRIENDLY_CONTENT, PAYMENT_OPTION_BTN, FOOTER_CONTENT_ACCEPT_PAYMENT};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("We accept Credit Card is displayed wrong");
    }
    String[] acceptPayment = {"FOOTER_ACCEPT_PAYMENT1", "FOOTER_ACCEPT_PAYMENT1", "FOOTER_ACCEPT_PAYMENT2", "FOOTER_ACCEPT_PAYMENT3", "FOOTER_ACCEPT_PAYMENT4",
      "FOOTER_ACCEPT_PAYMENT5", "FOOTER_ACCEPT_PAYMENT6", "FOOTER_ACCEPT_PAYMENT7", "FOOTER_ACCEPT_PAYMENT8"};
    boolean b1 = compareTwoListByKeyAndAttribute(acceptPayment, FOOTER_ACCEPT_PAYMENT_LIST, "alt");
    if (!b1) {
      System.out.println("The items accept payment at footer is display wrong! ");
    }
    return b && b1;
  }



}
