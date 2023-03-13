package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;


import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstInchPageEN.*;

public class InchPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public InchPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_INCH_WHAT_IS_TITLE, CONST_INCH_WHAT_IS_CONTENT};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    if (!(a && verifyTextByConst(CONST_INCH_MISSION_CONTENT, COIN_MISSION_CONTENT))) {
      System.out.println("Text at What is Coin to Team Content wrong");
    }
    verifyMetaTitleOfCoinPage(CONST_INCH_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);

    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    String[] moreUseCaseTitle = { CONST_INCH_USE_CASE_TITLE2, CONST_INCH_USE_CASE_TITLE3, CONST_INCH_USE_CASE_TITLE4};
    compareTwoListByConst(moreUseCaseTitle, "//div[contains(@class,'usecaseItem')]/div/h3");
    String[] moreUseCaseContent = {CONST_INCH_USE_CASE_CONTENT2, CONST_INCH_USE_CASE_CONTENT3};
    compareTwoListByConst(moreUseCaseContent, "//div[contains(@class,'usecaseItem')]/div/p");
    String[] nameTeam = {CONST_INCH_TEAM_ITEM_TITLE1, CONST_INCH_TEAM_ITEM_TITLE2, CONST_INCH_TEAM_ITEM_TITLE3, CONST_INCH_TEAM_ITEM_TITLE4, CONST_INCH_TEAM_ITEM_TITLE5, CONST_INCH_TEAM_ITEM_TITLE6, CONST_INCH_TEAM_ITEM_TITLE7,CONST_INCH_TEAM_ITEM_TITLE8};
    String[] positionTeam = {CONST_INCH_TEAM_ITEM_POSITION1, CONST_INCH_TEAM_ITEM_POSITION2, CONST_INCH_TEAM_ITEM_POSITION3, CONST_INCH_TEAM_ITEM_POSITION4, CONST_INCH_TEAM_ITEM_POSITION5, CONST_INCH_TEAM_ITEM_POSITION6, CONST_INCH_TEAM_ITEM_POSITION7, CONST_INCH_TEAM_ITEM_POSITION8};
    String[] desTeam = {CONST_INCH_TEAM_ITEM_DES1, CONST_INCH_TEAM_ITEM_DES2, CONST_INCH_TEAM_ITEM_DES3, CONST_INCH_TEAM_ITEM_DES4, CONST_INCH_TEAM_ITEM_DES5, CONST_INCH_TEAM_ITEM_DES6, CONST_INCH_TEAM_ITEM_DES7, CONST_INCH_TEAM_ITEM_DES8};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
//    clickToListElement(driver, COIN_FAQ_QUESTION);
//    clickToElementByJavascript(driver, COIN_FAQ_FRIST_QUESTION);
//    String[] titleFAQ = {CONST_INCH_FAQ_TITLE1, CONST_INCH_FAQ_TITLE2, CONST_INCH_FAQ_TITLE3, CONST_INCH_FAQ_TITLE4};
//    String[] faqContent = {CONST_INCH_FAQ_CONTENT1, CONST_INCH_FAQ_CONTENT2, CONST_INCH_FAQ_CONTENT3, CONST_INCH_FAQ_CONTENT4};
//    verifyFAQByConst(titleFAQ, faqContent);

//    verifyTextSearchBar();
  }

  public void verifyTextOnInchPage(String coinName) {
//    verifyNavigatePageFromLink();
    verifyTextOnThePage(coinName);

  }
}
