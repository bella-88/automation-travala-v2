package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.COIN_FAQ_QUESTION;
import static constants.hotel.contentCoinPage.ConstXNOPageEN.*;


import static constants.hotel.contentCoinPage.ConstNEARPageEN.*;


public class NearPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public NearPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_NEAR_WHAT_IS_TITLE, CONST_NEAR_WHAT_IS_CONTENT, CONST_NEAR_MISSION_CONTENT, CONST_NEAR_TEAM_CONTENT};
    verifyWhatSection(contentExp);
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    String[] nameTeam = {CONST_NEAR_TEAM_ITEM_TITLE1, CONST_NEAR_TEAM_ITEM_TITLE2, CONST_NEAR_TEAM_ITEM_TITLE3, CONST_NEAR_TEAM_ITEM_TITLE4, CONST_NEAR_TEAM_ITEM_TITLE5, CONST_NEAR_TEAM_ITEM_TITLE6};
    String[] positionTeam = {CONST_NEAR_TEAM_ITEM_POSITION1, CONST_NEAR_TEAM_ITEM_POSITION2, CONST_NEAR_TEAM_ITEM_POSITION3, CONST_NEAR_TEAM_ITEM_POSITION4, CONST_NEAR_TEAM_ITEM_POSITION5, CONST_NEAR_TEAM_ITEM_POSITION6};
    String[] desTeam = {CONST_NEAR_TEAM_ITEM_DES1, CONST_NEAR_TEAM_ITEM_DES2, CONST_NEAR_TEAM_ITEM_DES3, CONST_NEAR_TEAM_ITEM_DES4, CONST_NEAR_TEAM_ITEM_DES5, CONST_NEAR_TEAM_ITEM_DES6};

    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
    String[] moreUseCaseContent = {CONST_NEAR_MORE_USE_CONTENT1, CONST_NEAR_MORE_USE_CONTENT2, CONST_NEAR_MORE_USE_CONTENT3};
    verifyMoreUseCase(moreUseCaseContent);
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_NEAR_FAQ_TITLE1, CONST_NEAR_FAQ_TITLE2, CONST_NEAR_FAQ_TITLE3, CONST_NEAR_FAQ_TITLE4};
    String[] faqContent = {CONST_NEAR_FAQ_CONTENT1, CONST_NEAR_FAQ_CONTENT2, CONST_NEAR_FAQ_CONTENT3, CONST_NEAR_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);
  }


  public void verifyTextOnNearPage(String coinName) {
//    openNewTab(driver, "https://www.travala.com/payment/near-protocol");
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
    verifyTextOnThePage(coinName);
  }
}
