package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstDotPageEN.*;


public class DotPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public DotPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage() {
    String[] contentExp = {CONST_DOT_WHAT_IS_TITLE, CONST_DOT_WHAT_IS_CONTENT, CONST_DOT_MISSION_CONTENT, CONST_DOT_TEAM_CONTENT};
  verifyWhatSection(contentExp);

    String[] moreUseCaseContent = {CONST_DOT_USE_CASE_CONTENT1, CONST_DOT_USE_CASE_CONTENT2, CONST_DOT_MORE_USE_CASE_CONTENT1, CONST_DOT_MORE_USE_CASE_CONTENT2, CONST_DOT_MORE_USE_CASE_CONTENT3};
 verifyMoreUseCase(moreUseCaseContent);
 verifyPaySection("DOT");
//    verifyTitleSection("DOT");
    System.out.println("text"+getTextElement(driver, COIN_TRAVEL_BOOKING_TITLE));
    String[] nameTeam = {CONST_DOT_TEAM_ITEM_TITLE1, CONST_DOT_TEAM_ITEM_TITLE2, CONST_DOT_TEAM_ITEM_TITLE3};
    String[] positionTeam = {CONST_DOT_TEAM_ITEM_POSITION1, CONST_DOT_TEAM_ITEM_POSITION2, CONST_DOT_TEAM_ITEM_POSITION3};
    String[] desTeam = {CONST_DOT_TEAM_ITEM_DES1, CONST_DOT_TEAM_ITEM_DES2, CONST_DOT_TEAM_ITEM_DES3};

    verifyTeamName(nameTeam, positionTeam);
   verifyTeamDes( desTeam);
    clickToElementByJavascript(driver, COIN_FAQ_FIRST_QUESTION);
    clickToShowAllItems(COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_DOT_FAQ_TITLE1, CONST_DOT_FAQ_TITLE2, CONST_DOT_FAQ_TITLE3, CONST_DOT_FAQ_TITLE4};
    String[] faqContent = {CONST_DOT_FAQ_CONTENT1, CONST_DOT_FAQ_CONTENT2, CONST_DOT_FAQ_CONTENT3, CONST_DOT_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);
  }

  public void verifyTextOnDotPage(String coin) {
  verifyTextOnThePage() ;
//      verifyTextBanner( coin, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
//    verifyClickToLinkLandingCoin(DOT_PATH);
    if (status) {
      System.out.println("Dot Page is displayed correct!");
    } else {
      System.out.println("DOT Landing page wrong");
    }
  }
}
