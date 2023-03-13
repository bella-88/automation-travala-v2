package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstNTVRKPageEN.*;

public class NTVRKPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public NTVRKPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_NTVRK_WHAT_IS_TITLE, CONST_NTVRK_WHAT_IS_CONTENT, CONST_NTVRK_MISSION_CONTENT};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT, COIN_MISSION_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    if (!a) {
      System.out.println("Text at What is Coin to Team Content wrong");
    }
    verifyMetaTitleOfCoinPage(CONST_NTVRK_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1,  COIN_BANNER_TITLE2);
    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    
    String[] nameTeam = {CONST_NTVRK_TEAM_ITEM_TITLE1, CONST_NTVRK_TEAM_ITEM_TITLE2, CONST_NTVRK_TEAM_ITEM_TITLE3, CONST_NTVRK_TEAM_ITEM_TITLE4,CONST_NTVRK_TEAM_ITEM_TITLE5, CONST_NTVRK_TEAM_ITEM_TITLE6};
    String[] positionTeam = {CONST_NTVRK_TEAM_ITEM_POSITION1, CONST_NTVRK_TEAM_ITEM_POSITION2, CONST_NTVRK_TEAM_ITEM_POSITION3, CONST_NTVRK_TEAM_ITEM_POSITION4, CONST_NTVRK_TEAM_ITEM_POSITION5, CONST_NTVRK_TEAM_ITEM_POSITION6};
    String[] desTeam = {CONST_NTVRK_TEAM_ITEM_DES1, CONST_NTVRK_TEAM_ITEM_DES2, CONST_NTVRK_TEAM_ITEM_DES3, CONST_NTVRK_TEAM_ITEM_DES4, CONST_NTVRK_TEAM_ITEM_DES5, CONST_NTVRK_TEAM_ITEM_DES6};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);

    String[] moreUseCaseContent = {CONST_NTVRK_USE_CASE_CONTENT1, CONST_NTVRK_USE_CASE_CONTENT2, CONST_NTVRK_USE_CASE_CONTENT3, CONST_NTVRK_USE_CASE_CONTENT4};
//    verifyMoreUseCase(moreUseCaseContent);
compareTwoListByConst(moreUseCaseContent,"//div[contains(@class,'CaseItem')]/div/p");
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_NTVRK_FAQ_TITLE1, CONST_NTVRK_FAQ_TITLE2, CONST_NTVRK_FAQ_TITLE3,CONST_NTVRK_FAQ_TITLE4};
    String[] faqContent = {CONST_NTVRK_FAQ_CONTENT1, CONST_NTVRK_FAQ_CONTENT2, CONST_NTVRK_FAQ_CONTENT3,CONST_NTVRK_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);

  }


  public void verifyTextOnNTVRKPage(String coinName) {
//    openNewTab(driver, "https://travala-pr-2155.herokuapp.com/payment/ntvrk");
//    verifyNavigatePageFromLink();
    verifyTextOnThePage(coinName);
  }
}
