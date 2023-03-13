package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static constants.hotel.contentCoinPage.ConstPOOLZPageEN.*;
import static constants.hotel.contentCoinPage.ConstPOOLZPageEN.CONST_POOLZ_WHAT_IS_TITLE;
import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
public class POOLZPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public POOLZPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_POOLZ_WHAT_IS_TITLE, CONST_POOLZ_WHAT_IS_CONTENT, CONST_POOLZ_MISSION_CONTENT};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT, COIN_MISSION_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    if (!a) {
      System.out.println("Text at What is Coin to Team Content wrong");
    }
    verifyMetaTitleOfCoinPage(CONST_POOLZ_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);

    String[] nameTeam = {CONST_POOLZ_TEAM_ITEM_TITLE1, CONST_POOLZ_TEAM_ITEM_TITLE2, CONST_POOLZ_TEAM_ITEM_TITLE3, CONST_POOLZ_TEAM_ITEM_TITLE4, CONST_POOLZ_TEAM_ITEM_TITLE5, CONST_POOLZ_TEAM_ITEM_TITLE6};
    String[] positionTeam = {CONST_POOLZ_TEAM_ITEM_POSITION1, CONST_POOLZ_TEAM_ITEM_POSITION2, CONST_POOLZ_TEAM_ITEM_POSITION3, CONST_POOLZ_TEAM_ITEM_POSITION4, CONST_POOLZ_TEAM_ITEM_POSITION5, CONST_POOLZ_TEAM_ITEM_POSITION6};
    String[] desTeam = {CONST_POOLZ_TEAM_ITEM_DES1, CONST_POOLZ_TEAM_ITEM_DES2, CONST_POOLZ_TEAM_ITEM_DES3, CONST_POOLZ_TEAM_ITEM_DES4, CONST_POOLZ_TEAM_ITEM_DES5, CONST_POOLZ_TEAM_ITEM_DES6};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
    verifyTextByConst(CONST_POOLZ_USE_CASE_CONTENT1, "//div[contains(@class,'useTravel')]/div/p");
    String[] moreUseCaseTitle = {CONST_POOLZ_USE_CASE_TITLE1, CONST_POOLZ_USE_CASE_TITLE2, CONST_POOLZ_USE_CASE_TITLE3, CONST_POOLZ_USE_CASE_TITLE4};
    compareTwoListByConst(moreUseCaseTitle, "//div[contains(@class,'CaseItem')]/h5/span");
    String[] moreUseCaseContent = {CONST_POOLZ_USE_CASE_CONTENT1, CONST_POOLZ_USE_CASE_CONTENT2, CONST_POOLZ_USE_CASE_CONTENT3, CONST_POOLZ_USE_CASE_CONTENT4, CONST_POOLZ_USE_CASE_CONTENT5};

    compareTwoListByConst(moreUseCaseContent, "//div[contains(@class,'CaseItem')]/p");
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_POOLZ_FAQ_TITLE1, CONST_POOLZ_FAQ_TITLE2, CONST_POOLZ_FAQ_TITLE3};
    String[] faqContent = {CONST_POOLZ_FAQ_CONTENT1, CONST_POOLZ_FAQ_CONTENT2, CONST_POOLZ_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
    String[] nameWallet = {CONST_POOLZ_WALLET1, CONST_POOLZ_WALLET2, CONST_POOLZ_WALLET3, CONST_POOLZ_WALLET4, CONST_POOLZ_WALLET5, CONST_POOLZ_WALLET6,
      CONST_POOLZ_WALLET7, CONST_POOLZ_WALLET8, CONST_POOLZ_WALLET9, CONST_POOLZ_WALLET10};
  }

  public void verifyTextOnPoolzPage(String coinName) {
    verifyTextOnThePage(coinName);
  }
}
