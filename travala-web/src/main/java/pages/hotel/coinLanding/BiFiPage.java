package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstADAPageEN.*;
import static constants.hotel.contentCoinPage.ConstBiFiPageEN.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
public class BiFiPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public BiFiPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_BIFI_WHAT_IS_TITLE, CONST_BIFI_WHAT_IS_CONTENT};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    if (!(a && verifyTextByConst(CONST_BIFI_MISSION_CONTENT, COIN_MISSION_CONTENT))) {
      System.out.println("Text at What is Coin to Team Content wrong");
    }
    verifyMetaTitleOfCoinPage(CONST_BIFI_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
    verifyTextSearchBar();
    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    String[] moreUseCaseTitle = {CONST_BIFI_USE_CASE_TITLE1, CONST_BIFI_USE_CASE_TITLE2, CONST_BIFI_USE_CASE_TITLE3, CONST_BIFI_USE_CASE_TITLE4};
    compareTwoListByConst(moreUseCaseTitle, "//div[contains(@class,'usecaseTitle')]/h5");
    String[] moreUseCaseContent = {CONST_BIFI_USE_CASE_CONTENT1, CONST_BIFI_USE_CASE_CONTENT2, CONST_BIFI_USE_CASE_CONTENT3, CONST_BIFI_USE_CASE_CONTENT4};
    compareTwoListByConst(moreUseCaseContent, "//div[contains(@class,'usecaseItem')]/p");
//    clickToListElement(driver, COIN_FAQ_QUESTION);
//    clickToElementByJavascript(driver, COIN_FAQ_FRIST_QUESTION);
//    String[] titleFAQ = {CONST_BIFI_FAQ_TITLE1, CONST_BIFI_FAQ_TITLE2, CONST_BIFI_FAQ_TITLE3, CONST_BIFI_FAQ_TITLE4};
//    String[] faqContent = {CONST_BIFI_FAQ_CONTENT1, CONST_BIFI_FAQ_CONTENT2, CONST_BIFI_FAQ_CONTENT3, CONST_BIFI_FAQ_CONTENT4};
//    verifyFAQByConst(titleFAQ, faqContent);
    String[] nameWallet = {CONST_BIFI_WALLET1, CONST_BIFI_WALLET2, CONST_BIFI_WALLET3, CONST_BIFI_WALLET4, CONST_BIFI_WALLET5, CONST_BIFI_WALLET6,
      CONST_BIFI_WALLET7, CONST_BIFI_WALLET8, CONST_BIFI_WALLET9, CONST_BIFI_WALLET10};

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

  public void verifyTextOnBifiPage(String coinName) {
    String[] titleFAQ = {CONST_BIFI_FAQ_TITLE1, CONST_BIFI_FAQ_TITLE2, CONST_BIFI_FAQ_TITLE3, CONST_BIFI_FAQ_TITLE4};
    String[] faqContent = {CONST_BIFI_FAQ_CONTENT1, CONST_BIFI_FAQ_CONTENT2, CONST_BIFI_FAQ_CONTENT3, CONST_BIFI_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);
//    verifyNavigatePageFromLink();
//    verifyTextOnThePage(coinName);
  }
}
