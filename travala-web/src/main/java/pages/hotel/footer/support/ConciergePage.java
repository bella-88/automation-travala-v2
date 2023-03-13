package pages.hotel.footer.support;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.CONCIERGE_URL;
import static interfaces.hotel.footer.support.ConciergePageUI.*;

public class ConciergePage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;
  String email = null;

  public ConciergePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTermConditionConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_TERM_LINK_FOOTER);
    String[] title = {"CONCIERGE_TERM_TITLE1", "CONCIERGE_TERM_TITLE2", "CONCIERGE_TERM_TITLE3", "CONCIERGE_TERM_TITLE4", "CONCIERGE_TERM_TITLE5",
      "CONCIERGE_TERM_TITLE6", "CONCIERGE_TERM_TITLE7"};
    boolean b1 = compareTwoListByKey(title, CONCIERGE_TERM_TITLE);
    if (!b1) {
      System.out.println(" title of Term Condition Concierge Page wrong! ");
    }
    String[] content = {"CONCIERGE_TERM_CONTENT1", "CONCIERGE_TERM_CONTENT2", "CONCIERGE_TERM_CONTENT3", "CONCIERGE_TERM_CONTENT4", "CONCIERGE_TERM_CONTENT5",
      "CONCIERGE_TERM_CONTENT6", "CONCIERGE_TERM_CONTENT7", "CONCIERGE_TERM_CONTENT8", "CONCIERGE_TERM_CONTENT9", "CONCIERGE_TERM_CONTENT10"};
    boolean b2 = compareTwoListByKey(content, CONCIERGE_TERM_CONTENT);
    if (!b2) {
      System.out.println(" content of Term Condition Concierge Page wrong! ");
    }
    String[] subContent = {"CONCIERGE_TERM_SUB_CONTENT1", "CONCIERGE_TERM_SUB_CONTENT2", "CONCIERGE_TERM_SUB_CONTENT3", "CONCIERGE_TERM_SUB_CONTENT4", "CONCIERGE_TERM_SUB_CONTENT5",
      "CONCIERGE_TERM_SUB_CONTENT6", "CONCIERGE_TERM_SUB_CONTENT7", "CONCIERGE_TERM_SUB_CONTENT8", "CONCIERGE_TERM_SUB_CONTENT9", "CONCIERGE_TERM_SUB_CONTENT10",
      "CONCIERGE_TERM_SUB_CONTENT11", "CONCIERGE_TERM_SUB_CONTENT12", "CONCIERGE_TERM_SUB_CONTENT13", "CONCIERGE_TERM_SUB_CONTENT14"};
    boolean b3 = compareTwoListByKey(subContent, CONCIERGE_TERM_SUB_CONTENT);
    if (!b3) {
      System.out.println(" Sub content of Term Condition Concierge Page wrong!");
    }
    if (b1 && b2 && b3 && verifyTextByKey("CONCIERGE_TERM_BANNER", CONCIERGE_TERM_BANNER) && verifyTextByKey("CONCIERGE_TERM_DATE_UPDATE", CONCIERGE_TERM_DATE_UPDATE)) {
      System.out.println(" Term Condition Concierge Page correct!");
    }
    backToPreviousPage(driver);
  }

  public void verifyPrivacyPolicyConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_PRIVACY_LINK_FOOTER);
    String[] title = {"CONCIERGE_PRIVACY_TITLE1", "CONCIERGE_PRIVACY_TITLE2", "CONCIERGE_PRIVACY_TITLE3", "CONCIERGE_PRIVACY_TITLE4", "CONCIERGE_PRIVACY_TITLE5",
      "CONCIERGE_PRIVACY_TITLE6", "CONCIERGE_PRIVACY_TITLE7", "CONCIERGE_PRIVACY_TITLE8", "CONCIERGE_PRIVACY_TITLE9", "CONCIERGE_PRIVACY_TITLE10",
      "CONCIERGE_PRIVACY_TITLE11", "CONCIERGE_PRIVACY_TITLE12", "CONCIERGE_PRIVACY_TITLE13", "CONCIERGE_PRIVACY_TITLE14"};
    boolean b1 = compareTwoListByKey(title, CONCIERGE_PRIVACY_TITLE);
    if (!b1) {
      System.out.println(" title of Privacy Policy Concierge Page wrong! ");
    }
    String[] content = {"CONCIERGE_PRIVACY_CONTENT1", "CONCIERGE_PRIVACY_CONTENT2", "CONCIERGE_PRIVACY_CONTENT3", "CONCIERGE_PRIVACY_CONTENT4",
      "CONCIERGE_PRIVACY_CONTENT5", "CONCIERGE_PRIVACY_CONTENT6", "CONCIERGE_PRIVACY_CONTENT7", "CONCIERGE_PRIVACY_CONTENT8", "CONCIERGE_PRIVACY_CONTENT9",
      "CONCIERGE_PRIVACY_CONTENT10", "CONCIERGE_PRIVACY_CONTENT11", "CONCIERGE_PRIVACY_CONTENT12", "CONCIERGE_PRIVACY_CONTENT13", "CONCIERGE_PRIVACY_CONTENT14",
      "CONCIERGE_PRIVACY_CONTENT15", "CONCIERGE_PRIVACY_CONTENT16", "CONCIERGE_PRIVACY_CONTENT17", "CONCIERGE_PRIVACY_CONTENT18", "CONCIERGE_PRIVACY_CONTENT19"};
    boolean b2 = compareTwoListByKey(content, CONCIERGE_PRIVACY_CONTENT);
    if (!b2) {
      System.out.println(" content of Privacy Policy Concierge Page wrong! ");
    }
    String[] subContent = {"CONCIERGE_PRIVACY_SUB_CONTENT1", "CONCIERGE_PRIVACY_SUB_CONTENT2", "CONCIERGE_PRIVACY_SUB_CONTENT3", "CONCIERGE_PRIVACY_SUB_CONTENT4",
      "CONCIERGE_PRIVACY_SUB_CONTENT5", "CONCIERGE_PRIVACY_SUB_CONTENT6", "CONCIERGE_PRIVACY_SUB_CONTENT7", "CONCIERGE_PRIVACY_SUB_CONTENT8", "CONCIERGE_PRIVACY_SUB_CONTENT9",
      "CONCIERGE_PRIVACY_SUB_CONTENT10", "CONCIERGE_PRIVACY_SUB_CONTENT11", "CONCIERGE_PRIVACY_SUB_CONTENT12", "CONCIERGE_PRIVACY_SUB_CONTENT13", "CONCIERGE_PRIVACY_SUB_CONTENT14",
      "CONCIERGE_PRIVACY_SUB_CONTENT15", "CONCIERGE_PRIVACY_SUB_CONTENT16", "CONCIERGE_PRIVACY_SUB_CONTENT17", "CONCIERGE_PRIVACY_SUB_CONTENT18", "CONCIERGE_PRIVACY_SUB_CONTENT19",
      "CONCIERGE_PRIVACY_SUB_CONTENT20", "CONCIERGE_PRIVACY_SUB_CONTENT21", "CONCIERGE_PRIVACY_SUB_CONTENT22", "CONCIERGE_PRIVACY_SUB_CONTENT23", "CONCIERGE_PRIVACY_SUB_CONTENT24",
      "CONCIERGE_PRIVACY_SUB_CONTENT25", "CONCIERGE_PRIVACY_SUB_CONTENT26"};
    boolean b3 = compareTwoListByKey(subContent, CONCIERGE_PRIVACY_SUB_CONTENT);
    if (!b3) {
      System.out.println(" Sub content of Privacy Policy Concierge Page wrong!");
    }
    if (b1 && b2 && b3 && verifyTextByKey("CONCIERGE_PRIVACY_BANNER", CONCIERGE_PRIVACY_BANNER) && verifyTextByKey("CONCIERGE_PRIVACY_DATE_UPDATE", CONCIERGE_PRIVACY_DATE_UPDATE)) {
      System.out.println(" Privacy Policy Concierge Page correct!");
    }
    backToPreviousPage(driver);
  }

  public void verifyContactUsConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_CONTACT_US_LINK_FOOTER);
    backToPreviousPage(driver);
  }

  public boolean verifyLeisureMenu() {
    String[] menuHeader = {"CONCIERGE_HEADER_MENU1", "CONCIERGE_HEADER_MENU2", "CONCIERGE_HEADER_MENU4", "CONCIERGE_FOOTER4","CONCIERGE_HEADER_MENU5"};
    boolean b1 = compareTwoListByKey(menuHeader, CONCIERGE_HEADER_MENU_LIST);
    if (!b1) {
      System.out.println("Menu Header Concierge Page wrong! ");
    }
    String[] title = {"CONCIERGE_TITLE1", "CONCIERGE_TITLE2", "CONCIERGE_TITLE3", "CONCIERGE_TITLE4"};
    boolean b2 = compareTwoListByKey(title, CONCIERGE_TITLE_LIST);
    if (!b2) {
      System.out.println("Sub Title Concierge Page wrong! ");
    }
    String[] weAre = {"CONCIERGE_WE_ARE1", "CONCIERGE_WE_ARE2", "CONCIERGE_SERVICES", "CONCIERGE_SUB_CONCIERGE"};
    String[] xpath = {CONCIERGE_WE_ARE1, CONCIERGE_WE_ARE2, CONCIERGE_SERVICES, CONCIERGE_SUB_CONCIERGE};
    if (!verifyTwoListByKey(weAre, xpath)) {
      System.out.println(" We Are Concierge Page wrong! ");
    }
    String[] services = {"CONCIERGE_SERVICES1", "CONCIERGE_SERVICES2", "CONCIERGE_SERVICES3", "CONCIERGE_SERVICES4"};
    boolean b4 = compareTwoListByKey(services, CONCIERGE_SERVICES_LIST);
    if (!b4) {
      System.out.println("Services Concierge Page wrong! ");
    }
    String[] titleConcierge = {"CONCIERGE_CONCIERGE_TITLE1", "CONCIERGE_CONCIERGE_TITLE2", "CONCIERGE_CONCIERGE_TITLE3"};
    boolean b5 = compareTwoListByKey(titleConcierge, CONCIERGE_CONCIERGE_TITLE_LIST);
    if (!b5) {
      System.out.println(" Title Concierge Concierge Page wrong! ");
    }
    String[] desConcierge = {"CONCIERGE_CONCIERGE_DESC1", "CONCIERGE_CONCIERGE_DESC2", "CONCIERGE_CONCIERGE_DESC3"};
    boolean b6 = compareTwoListByKey(desConcierge, CONCIERGE_CONCIERGE_DESC_LIST);
    if (!b6) {
      System.out.println(" Des Concierge Concierge Page wrong! ");
    }
    String[] guide = {"CONCIERGE_GUIDE1", "CONCIERGE_GUIDE2", "CONCIERGE_GUIDE3"};
    boolean b7 = compareTwoListByKey(guide, CONCIERGE_GUIDE_LIST);
    if (!b7) {
      System.out.println(" Guide Concierge Page wrong! ");
    }
    String[] footer = {"CONCIERGE_FOOTER1", "CONCIERGE_FOOTER2", "CONCIERGE_FOOTER3", "CONCIERGE_HEADER_MENU3"};
    boolean b8 = compareTwoListByKey(footer, CONCIERGE_FOOTER_LIST);
    if (!b8) {
      System.out.println("Menu footer Concierge Page wrong! ");
    }
    check = b1 && b2 && b4 && b5 && b6 && b7 && b8;
    if (!check) {
      System.out.println(" Concierge Page wrong! ");
    }
    return check;
  }

  public boolean verifyTextLeisureConcierge() {
    String[] content = {"CONCIERGE_CONTENT2", "CONCIERGE_CONTENT3", "CONCIERGE_CONTENT4", "CONCIERGE_CONTENT5"};
    scrollToElement(driver, CONCIERGE_SERVICES);
    List<WebElement> services = driver.findElements(By.xpath(CONCIERGE_SERVICES_LIST));
    List<String> listServices = new ArrayList<>();
    int i = 1;
    while (i < services.size() + 1) {
      String item = String.format(CONCIERGE_SERVICES_DYNAMIC, i);
      clickToElement(driver, item);
      wait1sTime();
      String getTextXpath = String.format(CONCIERGE_CONTENT_SERVICES, i);
      listServices.add(getTextElement(driver, getTextXpath));
      i++;
    }
    boolean contentService = verifyTwoList(listServices, addListExpectByKey(content));
    if (!contentService) {
      System.out.println(" Content Service at Leisure Page wrong! ");
    }
    List<WebElement> test = driver.findElements(By.xpath(CONCIERGE_CONTENT_TEST));
    List<String> listTest = new ArrayList<>();
    int j = 1;
    while (j < test.size() + 1) {
      String item = String.format(CONCIERGE_CONTENT_TEST_LIST, j);
      clickToElement(driver, item);
      wait2sTime();
      String getTextXpath = String.format(CONCIERGE_CONTENT_TEST_DYNAMIC, j);
      listTest.add(getTextElement(driver, getTextXpath));
      j++;
    }
    boolean url = StringUtils.contains(getCurrentUrl(driver), CONCIERGE_URL);
    if (!url) {
      System.out.println(getCurrentUrl(driver));
      System.out.println(" Url at Leisure Page wrong! ");
    }
    String[] content1 = {"CONCIERGE_CONTENT6", "CONCIERGE_CONTENT7", "CONCIERGE_CONTENT8", "CONCIERGE_CONTENT9"};
    boolean contentTest = verifyTwoList(listTest, addListExpectByKey(content1));
    if (!contentTest) {
      System.out.println(" Content Test at Leisure Page wrong! ");
    }

    if (!(contentService &&contentTest &&url)) {
      System.out.println(" Content at Tab Leisure wrong! ");
    }
    return contentService && contentTest && url;
  }

  public void verifyContentPost1() {
    String[] title = {"INSPIRATION_POST1_TITLE1", "INSPIRATION_POST1_TITLE2", "INSPIRATION_POST1_TITLE3", "INSPIRATION_POST1_TITLE4",
      "INSPIRATION_POST1_TITLE6", "INSPIRATION_POST1_TITLE7", "INSPIRATION_POST1_TITLE8", "INSPIRATION_POST1_TITLE9", "INSPIRATION_POST1_TITLE10",
      "INSPIRATION_POST1_TITLE11", "INSPIRATION_POST1_TITLE12", "INSPIRATION_POST1_TITLE13", "INSPIRATION_POST1_TITLE14",
      "INSPIRATION_POST1_TITLE16", "INSPIRATION_POST1_TITLE17", "INSPIRATION_POST1_TITLE18", "INSPIRATION_POST1_TITLE19",
      "INSPIRATION_POST1_TITLE20", "INSPIRATION_POST1_TITLE21", "INSPIRATION_POST1_TITLE22", "INSPIRATION_POST1_TITLE23"};
    boolean bTitle = compareTwoListByKey(title, INSPIRATION_TITLE);
    if (!bTitle) {
      System.out.println("Title on Post From Buffalo to Bordeaux wrong!");
    }else {
      System.out.println("Title on Post From Buffalo to Bordeaux correct!");
    }
    String[] content = {"INSPIRATION_POST1_CONTENT1", "INSPIRATION_POST1_CONTENT2", "INSPIRATION_POST1_CONTENT3", "INSPIRATION_POST1_CONTENT4", "INSPIRATION_POST1_CONTENT5",
      "INSPIRATION_POST1_CONTENT6", "INSPIRATION_POST1_CONTENT7", "INSPIRATION_POST1_CONTENT8", "INSPIRATION_POST1_CONTENT9", "INSPIRATION_POST1_CONTENT10",
      "INSPIRATION_POST1_CONTENT11", "INSPIRATION_POST1_CONTENT12", "INSPIRATION_POST1_CONTENT13", "INSPIRATION_POST1_CONTENT14",
      "INSPIRATION_POST1_CONTENT15", "INSPIRATION_POST1_CONTENT16", "INSPIRATION_POST1_CONTENT17", "INSPIRATION_POST1_CONTENT18", "INSPIRATION_POST1_CONTENT19",
      "INSPIRATION_POST1_CONTENT20", "INSPIRATION_POST1_CONTENT21", "INSPIRATION_POST1_CONTENT22", "INSPIRATION_POST1_CONTENT23", "INSPIRATION_POST1_CONTENT24",
      "INSPIRATION_POST1_CONTENT25", "INSPIRATION_POST1_CONTENT26", "INSPIRATION_POST1_CONTENT27", "INSPIRATION_POST1_CONTENT28", "INSPIRATION_POST1_CONTENT29",
      "INSPIRATION_POST1_CONTENT30", "INSPIRATION_POST1_CONTENT31", "INSPIRATION_POST1_CONTENT32", "INSPIRATION_POST1_CONTENT33", "INSPIRATION_POST1_CONTENT34",
      "INSPIRATION_POST1_CONTENT35", "INSPIRATION_POST1_CONTENT36", "INSPIRATION_POST1_CONTENT37", "INSPIRATION_POST1_CONTENT38", "INSPIRATION_POST1_CONTENT38",
      "INSPIRATION_POST1_CONTENT39", "INSPIRATION_POST1_CONTENT40", "INSPIRATION_POST1_CONTENT41", "INSPIRATION_POST1_CONTENT42", "INSPIRATION_POST1_CONTENT43",
      "INSPIRATION_POST1_CONTENT44", "INSPIRATION_POST1_CONTENT45", "INSPIRATION_POST1_CONTENT46", "INSPIRATION_POST1_CONTENT47", "INSPIRATION_POST1_CONTENT48",
      "INSPIRATION_POST1_CONTENT49", "INSPIRATION_POST1_CONTENT50"};
    boolean bContent = compareTwoListByKey(content, INSPIRATION_CONTENT);
    if (!bContent) {
      System.out.println("Content on From Buffalo to Bordeaux wrong!");
    }else {
      System.out.println("Content on From Buffalo to Bordeaux correct!");
    }
  }

  public void verifyContentPost2() {
    String[] title = {"INSPIRATION_POST2_TITLE1", "INSPIRATION_POST2_TITLE2", "INSPIRATION_POST2_TITLE3", "INSPIRATION_POST2_TITLE4", "INSPIRATION_POST2_TITLE5", "INSPIRATION_POST2_TITLE6"};
    boolean bTitle = compareTwoListByKey(title, INSPIRATION_TITLE);
    if (!bTitle) {
      System.out.println("Title on post Sights, Stupas and Safaris wrong!");
    }else {
      System.out.println("Title on post Sights, Stupas and Safaris correct!");
    }
    String[] content = {"INSPIRATION_POST2_CONTENT1", "INSPIRATION_POST2_CONTENT2", "INSPIRATION_POST2_CONTENT3", "INSPIRATION_POST2_CONTENT4", "INSPIRATION_POST2_CONTENT5",
      "INSPIRATION_POST2_CONTENT6", "INSPIRATION_POST2_CONTENT7", "INSPIRATION_POST2_CONTENT8", "INSPIRATION_POST2_CONTENT9", "INSPIRATION_POST2_CONTENT10",
      "INSPIRATION_POST2_CONTENT11", "INSPIRATION_POST2_CONTENT12", "INSPIRATION_POST2_CONTENT13", "INSPIRATION_POST2_CONTENT14",
      "INSPIRATION_POST2_CONTENT15", "INSPIRATION_POST2_CONTENT16", "INSPIRATION_POST2_CONTENT17", "INSPIRATION_POST2_CONTENT18", "INSPIRATION_POST2_CONTENT19",
      "INSPIRATION_POST2_CONTENT20", "INSPIRATION_POST2_CONTENT21", "INSPIRATION_POST2_CONTENT22", "INSPIRATION_POST2_CONTENT23", "INSPIRATION_POST2_CONTENT24",
      "INSPIRATION_POST2_CONTENT25", "INSPIRATION_POST2_CONTENT26", "INSPIRATION_POST2_CONTENT27", "INSPIRATION_POST2_CONTENT28", "INSPIRATION_POST2_CONTENT29",
      "INSPIRATION_POST2_CONTENT30", "INSPIRATION_POST2_CONTENT31", "INSPIRATION_POST2_CONTENT32", "INSPIRATION_POST2_CONTENT33", "INSPIRATION_POST2_CONTENT34",
      "INSPIRATION_POST2_CONTENT35", "INSPIRATION_POST2_CONTENT36", "INSPIRATION_POST2_CONTENT37", "INSPIRATION_POST2_CONTENT38", "INSPIRATION_POST2_CONTENT39",
      "INSPIRATION_POST2_CONTENT40", "INSPIRATION_POST2_CONTENT41", "INSPIRATION_POST2_CONTENT42", "INSPIRATION_POST2_CONTENT43", "INSPIRATION_POST2_CONTENT44",
      "INSPIRATION_POST2_CONTENT45", "INSPIRATION_POST2_CONTENT46", "INSPIRATION_POST2_CONTENT47", "INSPIRATION_POST2_SUB_TITLE1", "INSPIRATION_POST2_SUB_TITLE2",
      "INSPIRATION_POST2_SUB_TITLE3", "INSPIRATION_POST2_SUB_TITLE4", "INSPIRATION_POST2_SUB_TITLE5", "INSPIRATION_POST2_SUB_TITLE6", "INSPIRATION_POST2_SUB_TITLE7",
      "INSPIRATION_POST2_SUB_TITLE8", "INSPIRATION_POST2_SUB_TITLE9", "INSPIRATION_POST2_SUB_TITLE10", "INSPIRATION_POST2_SUB_TITLE11", "INSPIRATION_POST2_SUB_TITLE12"};
    boolean bContent = compareTwoListByKey(content, INSPIRATION_CONTENT);
    if (!bContent) {
      System.out.println("Content on post Sights, Stupas and Safaris wrong!");
    }else {
      System.out.println("Content on post Sights, Stupas and Safaris correct!");
    }
  }

  public void verifyContentPost3() {
    String[] title = {"INSPIRATION_POST3_TITLE1", "INSPIRATION_POST3_TITLE2"};
    boolean bTitle = compareTwoListByKey(title, INSPIRATION_TITLE);
    if (!bTitle) {
      System.out.println("Title on post Tanzania Was the Dream Holiday wrong!");
    }else {
      System.out.println("Title on post Tanzania Was the Dream Holiday correct!");
    }
    String[] content = {"INSPIRATION_POST3_CONTENT1", "INSPIRATION_POST3_CONTENT2", "INSPIRATION_POST3_CONTENT3", "INSPIRATION_POST3_CONTENT4",
      "INSPIRATION_POST3_CONTENT5", "INSPIRATION_POST3_CONTENT6", "INSPIRATION_POST3_CONTENT7", "INSPIRATION_POST3_CONTENT8", "INSPIRATION_POST3_CONTENT9",
      "INSPIRATION_POST3_CONTENT10", "INSPIRATION_POST3_CONTENT11", "INSPIRATION_POST3_CONTENT12", "INSPIRATION_POST3_CONTENT13", "INSPIRATION_POST3_CONTENT14",
      "INSPIRATION_POST3_CONTENT15", "INSPIRATION_POST3_CONTENT16", "INSPIRATION_POST3_CONTENT17", "INSPIRATION_POST3_CONTENT18", "INSPIRATION_POST3_CONTENT19",
      "INSPIRATION_POST3_CONTENT20", "INSPIRATION_POST3_CONTENT21", "INSPIRATION_POST3_CONTENT22", "INSPIRATION_POST3_CONTENT23", "INSPIRATION_POST3_CONTENT24",
      "INSPIRATION_POST3_CONTENT25", "INSPIRATION_POST3_CONTENT26", "INSPIRATION_POST3_CONTENT27", "INSPIRATION_POST3_CONTENT28", "INSPIRATION_POST3_SUB_TITLE1",
      "INSPIRATION_POST3_SUB_TITLE2", "INSPIRATION_POST3_SUB_TITLE3", "INSPIRATION_POST3_SUB_TITLE4",
      "INSPIRATION_POST3_SUB_TITLE5", "INSPIRATION_POST3_SUB_TITLE6", "INSPIRATION_POST3_SUB_TITLE7", "INSPIRATION_POST3_SUB_TITLE8"};
    boolean bContent = compareTwoListByKey(content, INSPIRATION_CONTENT);
    if (!bContent) {
      System.out.println("Content on post Tanzania Was the Dream Holiday wrong!");
    }else {
      System.out.println("Content on post Tanzania Was the Dream Holiday correct!");
    }
  }

  public void verifyTravelInspiration() {
    List<WebElement> posts = driver.findElements(By.xpath(CONCIERGE_TRAVEL_INSPIRATION_TITLE_POST));
    int i = 1;
    while (i < posts.size() + 1) {
      clickElementByDynamicLocator(driver, CONCIERGE_TRAVEL_INSPIRATION_POST_DYNAMIC, String.valueOf(i));
      String title = getTextElement(driver, String.format(CONCIERGE_TRAVEL_INSPIRATION_POST_DYNAMIC, i));
      switch (title) {
        case "From Buffalo to Bordeaux: Why Africa is the Newest Luxury Holiday Destination":
          wait300Time();
          verifyContentPost1();
          backToPreviousPage(driver);
          break;
        case "Sights, Stupas and Safaris: My Sublime Sri Lankan Experience":
          wait300Time();
          verifyContentPost2();
          backToPreviousPage(driver);
          break;
        case "Tanzania Was the Dream Holiday I Didn’t Know I Needed":
          wait300Time();
          verifyContentPost3();
          backToPreviousPage(driver);
          break;
        default: {
          System.out.println("Please view other post!");
          break;
        }
      }
      i++;
    }
    backToPreviousPage(driver);
  }

  public void verifyFAQConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_FAQ_URL);
    verifyTextByKey("TRAVEL_GIFT_CARD_FAQ", CONCIERGE_FAQ_BANNER);
    String[] question = {"CONCIERGE_FAQ_QUESTION1", "CONCIERGE_FAQ_QUESTION2", "CONCIERGE_FAQ_QUESTION3", "CONCIERGE_FAQ_QUESTION4", "CONCIERGE_FAQ_QUESTION5",
      "CONCIERGE_FAQ_QUESTION6", "CONCIERGE_FAQ_QUESTION7", "CONCIERGE_FAQ_QUESTION8"};
    boolean b1 = compareTwoListByKey(question, CONCIERGE_FAQ_QUESTION_LIST);
    if (!b1) {
      System.out.println("List Question Concierge Page wrong! ");
    }
    String[] title = {"CONCIERGE_FAQ_TITLE1", "CONCIERGE_FAQ_TITLE2", "CONCIERGE_FAQ_TITLE3", "CONCIERGE_FAQ_TITLE4", "CONCIERGE_FAQ_TITLE5",
      "CONCIERGE_FAQ_TITLE6", "CONCIERGE_FAQ_TITLE7", "CONCIERGE_FAQ_TITLE8"};
    boolean b2 = compareTwoListByKey(title, CONCIERGE_FAQ_TITLE);
    if (!b2) {
      System.out.println("Title FAQ Concierge Page wrong!");
    }
    String[] content = {"CONCIERGE_FAQ_CONTENT1", "CONCIERGE_FAQ_CONTENT2", "CONCIERGE_FAQ_CONTENT3", "CONCIERGE_FAQ_CONTENT4", "CONCIERGE_FAQ_CONTENT5",
      "CONCIERGE_FAQ_CONTENT6", "CONCIERGE_FAQ_CONTENT7", "CONCIERGE_FAQ_CONTENT8"};
    boolean b3 = compareTwoListByKey(content, CONCIERGE_FAQ_CONTENT);
    if (!b3) {
      System.out.println("Answers FAQ Concierge Page wrong! ");
    }
    if (b1 && b2 && b3) {
      System.out.println("FAQ of Concierge Page correct!");
    } else {
      System.out.println("FAQ of Concierge Page wrong!");
    }
  }

  public void verifyApplyConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_APPLY_HEADER);
    String[] step = {"CONCIERGE_APPLY_STEP1", "CONCIERGE_APPLY_STEP2", "CONCIERGE_APPLY_STEP3", "CONCIERGE_APPLY_STEP4"};
    boolean b1 = compareTwoListByKey(step, CONCIERGE_APPLY_STEP);
    if (!b1) {
      System.out.println("Step in Apply Tab of Concierge Page wrong! ");
    }
    sendkeysToElement(driver, CONCIERGE_APPLY_FIRST_NAME, randomString());
    sendkeysToElement(driver, CONCIERGE_APPLY_LAST_NAME, randomString());
    sendkeysToElement(driver, CONCIERGE_APPLY_EMAIL, randomNumber());
    sendkeysToElement(driver, CONCIERGE_APPLY_PHONE, randomNumber());
    clickToElementByJavascript(driver, CONCIERGE_APPLY_NEXT_BTN);
    String[] message = {"CONCIERGE_APPLY_ERROR_MESSAGE1", "CONCIERGE_APPLY_ERROR_MESSAGE2"};
    if (!compareTwoListByKey(message, CONCIERGE_APPLY_ERROR_MESSAGE)) {
      System.out.println("Error message when input Apply form Concierge is show wrong! ");
    } else {
      System.out.println("Error message when input Apply form Concierge is show correct! ");
    }
  }

  public void verifyInputValidApplyForm() {
    clearTextElement(driver, CONCIERGE_APPLY_EMAIL);
    email = randomEmail();
    sendkeysToElement(driver, CONCIERGE_APPLY_EMAIL, email);
    clickToElementByJavascript(driver, CONCIERGE_APPLY_PHONE_FLAG);
    sendkeysToElement(driver, CONCIERGE_APPLY_PHONE_SELECT_COUNTRY, "Viet");
    clickToElementByJavascript(driver, CONCIERGE_APPLY_PHONE_ITEM);
    sendkeysToElement(driver, CONCIERGE_APPLY_PHONE, "999111222");
    clickToElementByJavascript(driver, CONCIERGE_APPLY_NEXT_BTN);
    String[] xpath = {CONCIERGE_APPLY_QUESTION1, CONCIERGE_APPLY_QUESTION2, CONCIERGE_APPLY_AGREE_LABEL, CONCIERGE_APPLY_AGREE_TEXT, CONCIERGE_APPLY_BTN};
    String[] title = {"CONCIERGE_APPLY_QUESTION1", "CONCIERGE_APPLY_QUESTION2", "CONCIERGE_APPLY_AGREE_LABEL", "CONCIERGE_APPLY_AGREE_TEXT", "CONCIERGE_APPLY_BTN"};
    if (!verifyTwoListByKey(title, xpath)) {
      System.out.println("Form Apply Concierge wrong!");
    } else {
      System.out.println("Form Apply Concierge correct!");
    }
    clickToElementByJavascript(driver, CONCIERGE_APPLY_PAYMENT_SELECT);
    wait300Time();
    String[] listPayment = {"CONCIERGE_APPLY_PAYMENT1", "CONCIERGE_APPLY_PAYMENT2", "CONCIERGE_APPLY_PAYMENT3", "CONCIERGE_APPLY_PAYMENT4"};
    if (!compareTwoListByKey(listPayment, CONCIERGE_APPLY_PAYMENT_LIST)) {
      System.out.println("List payment to selected wrong!");
    }
    clickToElementByJavascript(driver, CONCIERGE_APPLY_PAYMENT_FIRST);
    clickToElementByJavascript(driver, CONCIERGE_APPLY_AGREE_LABEL);
    clickToElementByJavascript(driver, CONCIERGE_APPLY_BTN);
  }

  public void verifyConfirmEmail() {
    wait300Time();
    String expectEmailConfirm = getTextFromReadFile("CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT1") + " "+email + getTextFromReadFile(
      "CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT2");
    String actualEmail = getTextElement(driver, CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT1);
    String[] xpath = {CONCIERGE_APPLY_CONFIRM_EMAIL_BANNER, CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT2, CONCIERGE_APPLY_CONFIRM_EDIT_EMAIL_BTN, CONCIERGE_APPLY_CONFIRM_RESEND_EMAIL_BTN};
    String[] title = {"CONCIERGE_APPLY_CONFIRM_EMAIL_BANNER", "CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT3", "CONCIERGE_APPLY_CONFIRM_EDIT_EMAIL_BTN", "CONCIERGE_APPLY_CONFIRM_RESEND_EMAIL_BTN"};
    if (!(verifyTwoListByKey(title, xpath) && StringUtils.equals(actualEmail, expectEmailConfirm)) ){
      System.out.println("Actual text: " + actualEmail);
      System.out.println("Expect text: " + expectEmailConfirm);
      System.out.println("Confirm Email Concierge wrong!");
    } else {
      System.out.println("Confirm Email Concierge correct!");
    }
    verifyClickOnLinkConfirmEmail();
  }

  public void verifyClickOnLinkConfirmEmail() {
    if (StringUtils.contains(getAttribute(driver,CONCIERGE_APPLY_CONFIRM_CONTACT_US,"href"), "contact-us")) {
      System.out.println("Link to Contact Us from Confirm Email correct");
    }
    clickToElementByJavascript(driver, CONCIERGE_APPLY_CONFIRM_EDIT_EMAIL_BTN);
    if (StringUtils.contains(getCurrentUrl(driver), "apply")) {
      System.out.println("Back to Apply from Confirm Email of Concierge correct");
    }
  }

  public void verifyBusinessConcierge() {
    clickToElementByJavascript(driver, CONCIERGE_BUSINESS_HEADER);
  }

  public void verifyCustomPackage(){

  }
}
