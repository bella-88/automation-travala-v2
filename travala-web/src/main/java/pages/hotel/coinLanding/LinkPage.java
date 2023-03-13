package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;


import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstLINKPageEN.*;
import static interfaces.hotel.coinLanding.LinkPageUI.LINK_WHAT_IS_TITLE;

public class LinkPage extends CommonHotelPages {
  WebDriver driver;
  boolean b = true;
  boolean b1 = true;
  boolean b2 = true;
  boolean b3 = true;
  boolean b4 = true;
  boolean b5 = true;
  boolean b6 = true;
  boolean b7 = true;
  boolean b8 = true;
  boolean b9 = true;
  boolean b10 = true;
  boolean b11 = true;
  boolean b12 = true;
  boolean b13 = true;
  boolean status = true;


  public LinkPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage() {
    String[] contentExp = {CONST_LINK_WHAT_IS_TITLE, CONST_LINK_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_LINK_MISSION_CONTENT};
    String[] xpathAct = {LINK_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT, COIN_MISSION_TITLE, COIN_MISSION_CONTENT};
    if (!verifyTwoListByContent(contentExp, xpathAct)) {
      System.out.println("Text at Heading wrong");
    }

    String[] moreUseCase = {CONST_LINK_MORE_USE_CASE_CONTENT1, CONST_LINK_MORE_USE_CASE_CONTENT2, CONST_LINK_MORE_USE_CASE_CONTENT3};
    String[] useCaseContent = {CONST_LINK_USE_CASE_CONTENT1, CONST_LINK_USE_CASE_CONTENT2, CONST_LINK_USE_CASE_CONTENT3, CONST_LINK_MORE_USE_CASE_CONTENT1, CONST_LINK_MORE_USE_CASE_CONTENT2, CONST_LINK_MORE_USE_CASE_CONTENT3};

//    verifyUseCase(useCaseContent);
    verifyMoreUseCase(moreUseCase);
    verifyPaySection("LINK");// Run nhanh
//    verifyTitleSection("LINK");

    String[] nameTeam = {CONST_LINK_TEAM_ITEM_TITLE1, CONST_LINK_TEAM_ITEM_TITLE2, CONST_LINK_TEAM_ITEM_TITLE3, CONST_LINK_TEAM_ITEM_TITLE4, CONST_LINK_TEAM_ITEM_TITLE5, CONST_LINK_TEAM_ITEM_TITLE6, CONST_LINK_TEAM_ITEM_TITLE7};
    String[] positionTeam = {CONST_LINK_TEAM_ITEM_POSITION1, CONST_LINK_TEAM_ITEM_POSITION2, CONST_LINK_TEAM_ITEM_POSITION3, CONST_LINK_TEAM_ITEM_POSITION4, CONST_LINK_TEAM_ITEM_POSITION5, CONST_LINK_TEAM_ITEM_POSITION6, CONST_LINK_TEAM_ITEM_POSITION7};
    String[] desTeam = {CONST_LINK_TEAM_ITEM_DES1, CONST_LINK_TEAM_ITEM_DES2, CONST_LINK_TEAM_ITEM_DES3, CONST_LINK_TEAM_ITEM_DES4, CONST_LINK_TEAM_ITEM_DES5, CONST_LINK_TEAM_ITEM_DES6, CONST_LINK_TEAM_ITEM_DES7};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_LINK_FAQ_TITLE1, CONST_LINK_FAQ_TITLE2, CONST_LINK_FAQ_TITLE3, CONST_LINK_FAQ_TITLE4};
    String[] faqContent = {CONST_LINK_FAQ_CONTENT1, CONST_LINK_FAQ_CONTENT2, CONST_LINK_FAQ_CONTENT3, CONST_LINK_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);// Run nhanh

  }



  public void verifyTextOnLinkPage(String coin) {
//    verifyTextBanner(coin, COIN_BANNER_TITLE1,  COIN_BANNER_TITLE2);
    verifyTextOnThePage();
//    verifyNavigatePageFromLink();

  }

}
