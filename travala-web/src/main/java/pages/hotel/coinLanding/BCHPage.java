package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;

import static constants.hotel.contentCoinPage.ConstBiFiPageEN.*;

public class BCHPage extends CommonHotelPages {
  WebDriver driver;

  public BCHPage(WebDriver driver_) {
    this.driver = driver_;
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

    String[] titleFAQ = {CONST_BIFI_FAQ_TITLE1, CONST_BIFI_FAQ_TITLE2, CONST_BIFI_FAQ_TITLE3, CONST_BIFI_FAQ_TITLE4};
    String[] faqContent = {CONST_BIFI_FAQ_CONTENT1, CONST_BIFI_FAQ_CONTENT2, CONST_BIFI_FAQ_CONTENT3, CONST_BIFI_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);

  }

  public void verifyTextOnBCHPage(String coinName) {
    verifyTextOnThePage(coinName);
  }
}
