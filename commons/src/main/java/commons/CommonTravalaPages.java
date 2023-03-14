package commons;

import com.github.javafaker.Faker;
import configs.ReaderConfigLanguage;
import enumerable.Env;
import enumerable.Flag;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

  import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
  import org.jsoup.safety.Whitelist;
  import org.openqa.selenium.By;
  import org.openqa.selenium.Keys;
  import org.openqa.selenium.WebDriver;


  import java.io.File;
  import java.io.FileInputStream;
  import java.nio.charset.StandardCharsets;
import java.util.*;

import static commons.CommonDataTravala.*;
import static commons.CommonDataTravala.*;
import static commons.CommonTravalaURL.*;
import static commons.CommonsTravalaXpath.*;

public class CommonTravalaPages extends AbstractPage {
  //Method set driver từ con sang cha
  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver driver;
  private boolean status = true;
  private boolean check = true;
  private boolean compareList = true;


  public static String getEvn() {
    String env = "https://" + Env.valueOf(ENVIRONMENT).getEnv();
    return env;
  }

  public static String getFlag() {
    String flag = Flag.valueOf(GET_LANGUAGE).getFlg();
    return flag;
  }

  //========================VERRIFY SCRIPT GA ON THE PAGE=================================
  public boolean verifyScriptGA(WebDriver driver) {
    String pageSource = driver.getPageSource();
    int i = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST);
    int i1 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST1);
    int i2 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST2);
    int i3 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST3);
    int i4 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST4);
    int i5 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST5);
    int i6 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST6);
    int i7 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST7);
    int i8 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST8);
    int i9 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST9);
    int i10 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST_BODY);
    int i11 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST_BODY1);
    int i12 = org.apache.commons.lang3.StringUtils.countMatches(pageSource, ST_BODY2);
    String[] expectHeader = new String[] {ST, ST1, ST2, ST3, ST4, ST5, ST6, ST7, ST8, ST9, ST_BODY, ST_BODY1, ST_BODY2};
    int[] totalHeader = {i, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12};
    if (i > 0 && i1 > 0 && i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0 && i6 > 0 && i7 > 0 && i8 > 0 && i9 > 0 && i10 > 0 && i11 > 0 && i12 > 0) {
      status = true;
    } else {
      for (int j = 0; j < totalHeader.length; j++) {
        if (totalHeader[j] == 0) {
          System.out.println("Script at position " + j + " ISN'T displayed");
          System.out.println("This script: " + expectHeader[j]);
        }
      }
      System.out.println("This script at ISN'T displayed ");
      status = false;
    }
    System.out.println("======================================================");
    return status;
  }

  public void loginWithTravalaAcc() {
    clickToElementByJavascript(driver, LOGIN_ICON_HEADER);
    switchToWindowByUrlContainsString(driver, TRAVALA_LOGIN_URL);
    loginWithTravalaByEmail(EMAIL_TRAVALA_ACC, PASSWORD_ACC);
  }

  public void loginWithBellaAcc() {
    clickToElementByJavascript(driver, LOGIN_ICON_HEADER);
    switchToWindowByUrlContainsString(driver, TRAVALA_LOGIN_URL);
    loginWithTravalaByEmail(EMAIL_BELLA_ACC, PASSWORD_ACC);
  }

  public void loginEmailCaptcha() {
    clickToElementByJavascript(driver, LOGIN_ICON_HEADER);
    switchToWindowByUrlContainsString(driver, TRAVALA_LOGIN_URL);
    loginWithTravalaByEmail(randomEmail(), randomString());
  }

  public void loginToSystem(String user, String password) {
    clickToElementByJavascript(driver, LOGIN_ICON_HEADER);
    switchToWindowByUrlContainsString(driver, TRAVALA_LOGIN_URL);
    loginWithTravalaByEmail(user, password);
  }

  public void sendkeysToTxt(String xpath, String value) {
    clearTextBox(driver, xpath);
    sendkeysToElement(driver, xpath, value);
  }

  //========================LOGIN BY EMAIL=================================
  public void inputTextByTab(String locator, String value) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.sendKeys(Keys.TAB);
    clearTextBox(driver, locator);
    element.sendKeys(value);
  }

  public void loginWithTravalaByEmail(String email, String password) {
    clickToElementByJavascript(driver, LANDING_EMAIL_TXT);
    sendkeysToElement(driver, LANDING_EMAIL_TXT, email);
//    inputTextByTab(LANDING_EMAIL_TXT, email);
    wait100Time();
    clickToElementByJavascript(driver, LANDING_PASSWORD_TXT);
//    inputTextByTab(LANDING_PASSWORD_TXT, password);
    sendkeysToElement(driver, LANDING_PASSWORD_TXT, password);
    clickToElementByJavascript(driver, LANDING_LOGIN_BTN);
    wait100Time();
  }

  public void logoutAcc() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    waitFoElementVisible(driver, LOG_OUT_BTN);
    clickToElementByJavascript(driver, LOG_OUT_BTN);
    wait1sTime();
  }
  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>LANDING PAGE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

  public void verifyClickOnURLDomainHeader() {
    List<WebElement> elements = driver.findElements(By.xpath(TOP_HEADER_DOMAIN));
    int i = 1;
    boolean b = true;
    while (i < elements.size() + 1) {
      clickElementByDynamicLocator(driver, TOP_HEADER_DOMAIN_LIST, String.valueOf(i));
      wait100Time();
      if (!StringUtils.contains(getAttribute(driver, String.format(LIST_DOMAIN_ACTIVE, i), "class"), "headerActive")) {
        System.out.println("Link to Domain on Top Header Wrong: " + String.format(TOP_HEADER_DOMAIN_LIST, i));
        b = false;
      }
      i++;
    }
    if (b) {
      System.out.println("Link to Domain on Top Header Correct ");
    }
  }

  public void verifyLanguageAtHeader(String language) {
    String[] lang = {"LANGUAGE1", "LANGUAGE2", "LANGUAGE3", "LANGUAGE4", "LANGUAGE5", "LANGUAGE6", "LANGUAGE7", "LANGUAGE8"};
    if (!compareTwoListByKey(lang, LANGUAGE_LIST)) {
      System.out.println("List language at header popup wrong");
    }
    verifySearchCoinHeader(language);
  }

  public void verifyDisplayAVAFirstPlace(String xpath, String fullNameCoin) {
    if (!StringUtils.contains(getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "), fullNameCoin)) {
      System.out.println("The first coin is: " + getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "));
      System.out.println("AVA is not displayed on the first place!");
    }
  }

  public String verifyListCurrencyHeader(String coin) {
    clickToElementByJavascript(driver, GLOBE_ICON_HEADER);
    String[] title = {"LANDING_LANGUAGE_OPTION", "LANDING_CURRENCY_OPTION"};
    boolean b = compareTwoListByKey(title, CURRENCY_LIST);
    clickToElementByJavascript(driver, CURRENCY_OPTION);
    String[] currency = {"LANDING_CURRENCY_FIAT", "LANDING_CURRENCY_CRYPTO"};
    boolean b1 = compareTwoListByKey(currency, CURRENCY_TXT_LIST);
    boolean listF = verifyDisplayListCrypto(LANDING_FIAT_LIST, listFiat);
    if (!listF) {
      System.out.println("List Fiat at header part is displayed wrong");
    }
    boolean currenciesC = verifyDisplayListCrypto(LANDING_CURRENCY_LIST, CURRENCY_HEADER);
    verifyDisplayAVAFirstPlace(LANDING_CURRENCY_FIRST, "Travala AVA");
    if (!currenciesC) {
      System.out.println("List currency at header page is displayed wrong");
    }
    String getCoin = verifySearchCoinHeader(coin);
    if (b && b1 && listF && currenciesC) {
      System.out.println("List currencies at header part is shown correct! ");
    }
    return getCoin;
  }

  public void switchToLanguage() {
    clickToElementByJavascript(driver, GLOBE_ICON_HEADER);
    clickElementByDynamicLocator(driver, LANGUAGE_OPTION, GET_LANGUAGE);
    wait5sTime();
    wait2sTime();
  }


  public void verifyTextAfterSearchHeader() {
    if (verifyTextByKey("SEARCH_CURRENCY_NO_RESULT", SEARCH_NOT_FOUND_HEADER) && verifyTextByKey("SEARCH_CURRENCY_RESULT_ALERT", SEARCH_NOT_FOUND_MESSAGE)) {
      System.out.println("Text when no result found wrong");
    } else {
      System.out.println("Text when no result found correct");
    }
    clickToElementByJavascript(driver, POPUP_CURRENCY_CLOSE);
  }
  public String verifySearchCoinHeader(String coin) {
    clickToElementByJavascript(driver, GLOBE_ICON_HEADER);
    clickToElementByJavascript(driver, HEADER_CURRENCIES_OPTION);
    clickToElementByJavascript(driver, SEARCH_CURRENCY_TXT);
    sendkeysToElement(driver, SEARCH_CURRENCY_TXT, coin);
    String getCoin = null;
    if (checkShowElement(driver, HEADER_CURRENCY_RESULT) != 0) {
      getCoin = getTextBySplit(getTextElement(driver, HEADER_CURRENCY_RESULT), " ", 1);
      if (StringUtils.contains(getTextElement(driver, HEADER_CURRENCY_RESULT), coin)) {
        System.out.println("Display when search " + coin + " at header correct!");
      } else {
        System.out.println("Display when search " + coin + " at header wrong!");
      }
      clickToElementByJavascript(driver, HEADER_CURRENCY_RESULT_COIN);
    } else {
      verifyTextAfterSearchHeader();
      System.out.println("Display when no result found for " + coin + " correct!");
    }

//    if ((checkShowElement(driver, SEARCH_NOT_FOUND_HEADER) != 0) && verifyTextAfterSearchHeader()) {
//      System.out.println("Display when no result found for " + coin + "correct!");
//    } else {
//      if (StringUtils.contains(getTextElement(driver, HEADER_CURRENCY_RESULT), coin)) {
//        System.out.println("Display when search " + coin + " at header correct!");
//        getCoin = getTextBySplit(getTextElement(driver, HEADER_CURRENCY_RESULT), " ", 1);
//      } else {
//        System.out.println("Display when search " + coin + " at header wrong!");
//      }
//      clickToElementByJavascript(driver, HEADER_CURRENCY_RESULT_COIN);
//    }
    return getCoin;
  }





  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SEARCH PAGE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//  public void inputActivities(String destination) {
//    clickToElementByJavascript(driver, ACT_INPUT_TEXTBOX);
//    sendkeysToElement(driver, ACT_INPUT_TEXTBOX, destination);
//    waitFoElementVisible(driver, SUGGESTION_POPUP);
//    clickToElementByAction(driver, FIRST_SUGGESTION_ACTIVITIES);
//  }
//
//  public int inputDestinationWithSuggestion(String destination) {
//    clickToElementByJavascript(driver, ACT_INPUT_TEXTBOX);
//    sendkeysToElement(driver, ACT_INPUT_TEXTBOX, destination);
//    waitFoElementVisible(driver, SUGGESTION_POPUP);
//    wait2sTime();
//    List<WebElement> list = driver.findElements(By.xpath(MAX_SUGGESTION_LIST));
//    int suggestionSize = list.size();
//    return suggestionSize;
//  }
//
//  public void inputActivitiesToSelectSecond(String destination) {
//    clickToElementByJavascript(driver, ACT_INPUT_TEXTBOX);
//    sendkeysToElement(driver, ACT_INPUT_TEXTBOX, destination);
//    waitFoElementVisible(driver, SUGGESTION_POPUP);
//    clickToElementByAction(driver, SECOND_SUGGESTION_ACTIVITIES);
//  }
//


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
  
  
  //===================================-===============ADD LIST TO ACTUAL AND EXPECT ================================================

  public List<String> addListExpectByKey(String[] content) {
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      expect.add(ReaderConfigLanguage.getStringLanguage(content[i]).trim());
    }
    return expect;
  }

  public List<String> addListExpByConst(String[] content) {
    List<String> listExpect = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      listExpect.add(content[i].trim());
    }
    return listExpect;
  }

  public List<String> addActualFromElement(String xpath) {
    List<String> actual = new ArrayList<>();
    actual.add(getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " ").trim());
    return actual;
  }

  public List<String> addListActualFromListXpath(String listXpath, String dynamicXpath) {
    List<WebElement> list = driver.findElements(By.xpath(listXpath));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < list.size() + 1; i++) {
      String xpath = String.format(dynamicXpath, i);
      listActual.add(getTextElement(driver, xpath).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("<br>", "").replaceAll("\\r", "").replaceAll("\\n", ""));
    }
    return listActual;
  }

  public List<String> addListActualFromListXpath(String listXpath) {
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    waitFoElementVisible(driver, listXpath);
    List<String> listAct = new ArrayList<String>();
    for (int i = 0; i < elements.size(); i++) {
      String elementAct = elements.get(i).getText().trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("<br>", "").replaceAll("\\r", "").replaceAll("\\n", "");
      listAct.add(elementAct);
    }
    return listAct;
  }

  public List<String> addListActualFromAttribute(String listXpath, String attribute) {
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    List<String> listAct = new ArrayList<String>();
    for (int i = 0; i < elements.size(); i++) {
      String elementAct = elements.get(i).getAttribute(attribute).trim().replaceAll("\\r\\n|\\r|\\n", " ");
      listAct.add(elementAct);
    }
    return listAct;
  }

  public List<String> addListActualAfterSplitText(String listXpath, String xpathDynamic, String regex, int position) {
    List<String> listAct = new ArrayList<String>();
    int i = 1;
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    while (i < elements.size() + 1) {
      String element = String.format(xpathDynamic, i);
      listAct.add(getTextBySplit(getTextElement(driver, element), regex, position));
      i++;
    }
    return listAct;
  }

  public String[] addListExpectAfterFormatFromConst(String[] expectContent, String coinName) {
    String[] content = expectContent;
    for (int i = 0; i < content.length; i++) {
      if (StringUtils.contains(content[i], "%s")) {
        content[i] = content[i].replaceAll("%s", coinName);
      }
    }
    return content;
  }

  public String[] addListExpectAfterFormatFromKey(String[] expectContent, String coinName) {
    String[] content = expectContent;
    for (int i = 0; i < content.length; i++) {
      content[i] = ReaderConfigLanguage.getStringLanguage(content[i]).replaceAll("%s", coinName);
//      System.out.println("code: "+ content[i]);
//      System.out.println("content: "+ getTextFromReadFile(content[i]).replaceAll("%s",coinName));
    }
    return content;
  }

  //===================================-===============VERIFY TWO LIST ================================================
  public boolean verifyTextByKey(String codeExp, String xpath) {
    boolean verify = StringUtils.contains(getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "), getTextFromReadFile(codeExp.trim()));
    if (!verify) {
      System.out.println("Actual text: " + getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "));
      System.out.println("Expect text: " + getTextFromReadFile(codeExp));
    }
    return verify;
  }

  public boolean verifyTextByConst(String constKey, String xpath) {
    boolean verify = StringUtils.contains(constKey, getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("<br>", ""));
    if (!verify) {
      System.out.println("Actual text: " + getTextElement(driver, xpath).replaceAll("\\r\\n|\\r|\\n", " "));
      System.out.println("Expect text: " + constKey);
    }
    return verify;
  }

  public boolean verifyTextByKeyWithAttribute(String codeExp, String xpath, String attribute) {
    boolean verify = StringUtils.contains(getAttribute(driver, xpath, attribute).replaceAll("\\r\\n|\\r|\\n", " "), getTextFromReadFile(codeExp.trim()));
    if (!verify) {
      System.out.println("Actual text: " + getAttribute(driver, xpath, attribute).replaceAll("\\r\\n|\\r|\\n", " "));
      System.out.println("Expect text: " + getTextFromReadFile(codeExp));
    }
    return verify;
  }

  public boolean compareTwoListByConst(String[] expectList, String xpathList) {
    boolean compareConst = true;
    if (addListActualFromListXpath(xpathList).size() > addListExpByConst(expectList).size()) {
      System.out.println("Size Element Actual: " + addListActualFromListXpath(xpathList).size());
      System.out.println("Size Element Expect: " + addListExpByConst(expectList).size());
    }
    for (String element : addListActualFromListXpath(xpathList)) {
      if (!addListExpByConst(expectList).contains(element)) {
        System.out.println("Actual failed: " + element);
        compareConst = false;
      }
    }
    for (String element : addListExpByConst(expectList)) {
      if (!addListActualFromListXpath(xpathList).contains(element)) {
        System.out.println("Expect not exist in Actual: " + element);
        compareConst = false;
      }
    }
    return compareConst;
  }

  public boolean compareTwoListByKey(String[] expectList, String xpathList) {
    boolean compareKey = true;
    if (addListActualFromListXpath(xpathList).size() > addListExpectByKey(expectList).size()) {
      System.out.println("Size Element Actual: " + addListActualFromListXpath(xpathList).size());
      System.out.println("Size Element Expect: " + addListExpectByKey(expectList).size());
    }
    for (String element : addListActualFromListXpath(xpathList)) {
      if (!addListExpectByKey(expectList).contains(element.trim())) {
        System.out.println("Actual not exist in Expect:" + element);
        compareKey = false;
      }
    }
    for (String element : addListExpectByKey(expectList)) {
      if (!addListActualFromListXpath(xpathList).contains(element.trim())) {
        System.out.println("Expect not exist in Actual: " + element);
      }
    }
    return compareKey;
  }

  public boolean compareTwoListByKeyAndAttribute(String[] expectList, String xpathList, String attribute) {
    boolean compareKey = true;
    if (addListActualFromAttribute(xpathList, attribute).size() != addListExpectByKey(expectList).size()) {
      System.out.println("Xpath wrong: " + xpathList);
      System.out.println("Size Element Actual: " + addListActualFromAttribute(xpathList, attribute).size());
      System.out.println("Size Element Expect: " + addListExpectByKey(expectList).size());
    }
    for (String element : addListActualFromAttribute(xpathList, attribute)) {
      if (!addListExpectByKey(expectList).contains(element.trim())) {
        System.out.println("Actual failed:" + element);
        compareKey = false;
      }
    }
    return compareKey;
  }

  public boolean verifyTwoList(List<String> listActual, List<String> listExpect) {
    for (String element : listActual) {
      if (!listExpect.contains(element.trim())) {
        System.out.println(" ACTUAL FAILED: " + element);
        System.out.println("=======================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyTwoListWithListXpath(List<String> listExpect, String xpath) {
    for (String element : addListActualFromListXpath(xpath)) {
      if (!listExpect.contains(element.trim())) {
        System.out.println(" ACTUAL FAILED: " + element);
        System.out.println("=======================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyTwoListByConst(String[] listActual, String[] listExpect) {
    boolean title = true;
    for (int i = 0; i < listExpect.length; i++) {
      if (!StringUtils.contains(listExpect[i].trim(),
        getTextElement(driver, listActual[i]).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("<br>", "").replaceAll("\\r", "").replaceAll("\\n", ""))) {
        System.out.println("Wrong text at the position " + i + ":" + listActual[i]);
        System.out.println("EXPECT " + i + "=" + listExpect[i]);
        System.out.println("ACTUAL=" + getTextElement(driver, listActual[i]));
        System.out.println("=============================================================");
        title = false;
      }
    }
    return title;
  }

  public boolean verifyContentWithListActual(String xpathList, String code) {
    boolean check = true;
    List<WebElement> listReview = driver.findElements(By.xpath(xpathList));
    int i = 0;
    while (i < listReview.size()) {
      boolean a = StringUtils.contains(listReview.get(i).getText(), getTextFromReadFile(code));
      if (a) {
        check = true;
      } else {
        System.out.println("actual " + code + ":" + listReview.get(i).getText());
        System.out.println("expect " + code + ":" + getTextFromReadFile(code));
        System.out.println("=================================================");
        check = false;
        break;
      }
      i++;
    }
    return check;
  }

  public boolean verifyListItemByListExpect(String[] listExpect, String xpathList, String xpathDynamic) {
    boolean verify = true;
    int index = 0;
    for (String element : addListActualFromListXpath(xpathList, xpathDynamic)) {
      index += 1;
      if (!addListExpectByKey(listExpect).contains(element)) {
        System.out.println("ACTUAL: " + element);
        System.out.println("EXPECT: " + addListExpectByKey(listExpect).get(index-1));
        verify = false;
      }
    }
    return verify;
  }

  public boolean verifyListExpectWithItem(String[] listExpect, String xpath) {
    List<String> listActual = new ArrayList<>();
    String actual = getTextElement(driver, xpath);
    listActual.add(actual);
    String[] listItemExpect = listExpect;
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < listItemExpect.length; i++) {
      expect.add(getTextFromReadFile(listItemExpect[i]));
    }
    for (String element : listActual) {
      if (!expect.contains(element)) {
        System.out.println(" ACTUAL failed: " + element);
        check = false;
      }
    }
    return check;
  }

  public boolean verifyTwoListByKey(String[] expectKey, String[] xpath) {
    String[] content = expectKey;
    String[] actual = xpath;
    for (int i = 0; i < content.length; i++) {
      if (!StringUtils.contains(getTextFromReadFile(content[i]).trim(),
        getTextElement(driver, actual[i]).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("\\r", "").replaceAll("\\n", "").replaceAll("<br>", ""))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT " + i + "=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, actual[i]).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("\\r", "").replaceAll("\\n", "").replaceAll("<br>", ""));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyTwoListByContent(String[] contentExp, String[] xpath) {
    String[] expect = contentExp;
    String[] actual = xpath;
    for (int i = 0; i < expect.length; i++) {
//      System.out.println("act"+getTextElement(driver, actual[i]).trim());
      if (!StringUtils.contains(expect[i].trim(), getTextElement(driver, actual[i]).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("\\r", "").replaceAll("\\n", ""))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT " + i + "=" + expect[i]);
        System.out.println("ACTUAL=" + getTextElement(driver, actual[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyTwoListByAttribute(String[] contentExp, String[] xpathAct, String attribute) {
    String[] content = contentExp;
    String[] xpath = xpathAct;
    for (int i = 0; i < content.length; i++) {
      if (!org.apache.commons.lang3.StringUtils.contains(getAttribute(driver, xpath[i], attribute).replaceAll("\\r", "").replaceAll("\\n", ""), getTextFromReadFile(content[i]))) {
        System.out.println("Wrong text at the position " + i + ":" + xpath[i]);
        System.out.println("EXPECT=" + getTextFromReadFile(content[i]));
        System.out.println("ACTUAL=" + getTextElement(driver, xpath[i]));
        System.out.println("=============================================================");
        check = false;
      }
    }
    return check;
  }

  public boolean verifyContentPopup(String[] contentExp) {
    String[] xpath = {CONSTANT_POPUP_MES_TITLE, CONSTANT_POPUP_MES_CONTENT, CONSTANT_POPUP_MES_OK_BTN};
    String[] content = contentExp;
    boolean verifyEmail = verifyTwoListByKey(content, xpath);
    clickToElementByJavascript(driver, CONSTANT_POPUP_MES_OK_BTN);
    return verifyEmail;
  }



  public void readFile() {
    try {
      File file = new File("C:/Users/Admin/Downloads/Spanish FE/best-price-guarantee-es.json");
      FileInputStream fis = new FileInputStream(file.getAbsolutePath());
      String dataBefore = IOUtils.toString(fis, StandardCharsets.UTF_8);
      System.out.println("======Noi Dung File Truoc khi remove HTML==========");
      System.out.println(dataBefore);
      System.out.println("======Noi Dung File SAU khi remove HTML==========");
      System.out.println("===============================================================");
      String dataAfter = Jsoup.clean(dataBefore, new Whitelist());
      System.out.println(dataAfter);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String removeBreakString(String st) {
    String expectStr = st.replaceAll("\\r", "").replaceAll("\\n", "");
    return expectStr;
  }

  public void clickToShowAllItems(String listXpath) {
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    for (WebElement i : elements) {
      i.click();
      wait100Time();
    }
  }

  public void sendKeysToListElement(String listXpath, String value) {
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    for (WebElement i : elements) {
      i.sendKeys(value);
      wait300Time();
    }
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
 
  public void verifyTextBanner(String[] bannerText) {
    String[] banner = bannerText;
    String[] xpath = {BANNER_TITLE, BANNER_SUB_TITLE};
    if (!verifyTwoListByKey(banner, xpath)) {
      System.out.println("Text banner domain wrong");
    }
  }

  public Double checkRateCoin(String coin) {
    Double rate = null;
    openNewTab(driver, COIN_MARKET_URL);
    switchToOtherWindowbyUrl(driver, COIN_MARKET_URL);
    clickToElement(driver, "//button[text()='Sign up']/following-sibling::div/div/div[text()='Search']");
    wait300Time();
    sendkeysToElement(driver, "(//input[@type='text'])[1]", coin);
    clickToElement(driver, String.format("//p[text()='Cryptoassets']/following-sibling::a/div/div/p[text()='%s']", coin));
    wait1sTime();
    StringBuilder sb = new StringBuilder();
    String rateC = getTextElement(driver, "//div[@class='priceValue ']/span");
    sb.append(rateC);
    sb.deleteCharAt(0);
    rateC = sb.toString();
    rate = Double.valueOf(rateC);
    System.out.println("Rate of " + coin + " on Market Cap is: " + rate);
    openNewTab(driver, TRAVALA_LIVE_URL);
    return rate;
  }

  public void paymentByTravelCredit() {
    clickToElementByJavascript(driver, TRAVEL_CREDIT_OPTION);
    if (checkShowElement(driver, CHECKOUT_BUY_TRAVEL_CREDIT) != 0) {
      clickToElementByJavascript(driver, PURCHASE_SUBMIT_BTN);
    } else {
      System.out.println("You do not have enough travel credits");
    }
  }
  public void inputCreditCardAndSubmitSuccess(String cardNumber, String expDate, String cvc) {
    switchToIframe(driver, IFRAME_CARD_NUMBER);
    clickToElementByJavascript(driver, CARD_NUMBER_TXT);
    sendkeysToElement(driver, CARD_NUMBER_TXT, cardNumber);
    driver.findElement(By.xpath(CARD_NUMBER_TXT)).sendKeys(Keys.TAB);
    driver.findElement(By.xpath(EXP_DATE_TXT)).sendKeys(expDate);
    driver.findElement(By.xpath(CVC_TXT)).sendKeys(cvc);
    driver.switchTo().parentFrame();
    clickToElementByJavascript(driver, PURCHASE_SUBMIT_BTN);
  }
  public boolean verifyTextByGetTextElement(String expectStr, String xpath) {
    boolean value = StringUtils.contains(expectStr, getTextElement(driver, xpath));
    if(!value){
      System.out.println("Expect: "+ expectStr);
      System.out.println("Actual: "+ getTextElement(driver, xpath));
    }
    return value;
  }

  public boolean verifyTextByGetAttribute(String expectStr, String xpath, String attribute) {
    return org.apache.commons.lang3.StringUtils.contains(expectStr, getAttribute(driver, xpath, attribute));
  }

  public boolean verifyLinkToPageFromListUrl(String xpathList, String xpathDynamic) {
    List<WebElement> element = driver.findElements(By.xpath(xpathList));
    int i = 1;
    boolean url = true;
    while (i < element.size() + 1) {
      String xpath = String.format(xpathDynamic, i);
      String getAttributeLink = getAttribute(driver, xpath, "href");
      clickToElementByJavascript(driver, xpath);
      wait100Time();
      switchToOtherWindowbyUrl(driver, getAttributeLink);
      String str = getCurrentUrl(driver).replace(getCurrentUrl(driver).substring(0, 7), "").replace("/www.", "");
      String getCurrentUrl = null;
      if (!StringUtils.contains(getTextBySplit(str, "/", 0), " ")) {
        getCurrentUrl = getTextBySplit(str, "/", 0);
      } else {
        getCurrentUrl = getTextBySplit(str.substring(1), "/", 0);
      }
      if (!StringUtils.contains(getAttributeLink, getCurrentUrl)) {
        System.out.println("Expect Url: " + getAttributeLink);
        System.out.println("Actual Url: " + getCurrentUrl);
        url = false;
      }
      switchTab(driver);
      i++;
    }
    return url;
  }

  public boolean verifyLinkToPageFromUrl(String xpath) {
    boolean urlP = true;
    String getHrefLink = getAttribute(driver, xpath, "href");
    clickToElementByJavascript(driver, xpath);
    wait100Time();
    switchToOtherWindowbyUrl(driver, getHrefLink);
    String getCurrentUrl = driver.getCurrentUrl().replace("https://www.", "");
    if (!StringUtils.contains(getHrefLink, getCurrentUrl)) {
      urlP = false;
    }
    switchTab(driver);
    return urlP;
  }

  public String getCurrentDateTime(String formatTime)
  {
    DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern(formatTime);
    LocalDateTime currentDateTime = LocalDateTime.now();
    return formatDateTime.format(currentDateTime);
  }

  public String getDateTimePlusDayByTimezone(String formatDateTime, String timeZone, int plusDay) {
    DateTimeFormatter formateDT = DateTimeFormatter.ofPattern(formatDateTime);
    Date currentDate = new Date();
    return formateDT.format(LocalDateTime.from(currentDate.toInstant().atZone(ZoneId.of(timeZone))).plusDays(plusDay));
  }

  public String fakeNumberPhoneVN() {
    Random random = new Random();
    return "0989" + String.format("%06d", random.nextInt(999999));
  }

  public Map<String, String> fakeData() {
    Map<String, String> fakeData = new HashMap<>();
    Faker faker = new Faker();
    fakeData.put("firstname", faker.name().firstName());
    fakeData.put("lastname", faker.name().lastName());
    fakeData.put("fullname", faker.name().fullName());
    fakeData.put("address", faker.address().streetAddress());
    fakeData.put("job", faker.job().position());
    fakeData.put("numberPhone", faker.phoneNumber().phoneNumber());
    return fakeData;
  }
  public void clickBackToTravala(WebDriver driver) {
    clickToElementByJavascript(driver, BACK_TO_TRAVAL_LINK);
    wait2sTime();
  }
}
