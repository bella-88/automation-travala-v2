package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstXDCPageEN.*;
import static interfaces.hotel.coinLanding.XDCPageUI.*;


public class XDCPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public XDCPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextOnThePage(String coinName) {
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
    verifyMetaTitleOfCoinPage(CONST_XDC_FULL_NAME);
    String[] contentExp = {CONST_XDC_WHAT_IS_TITLE, CONST_XDC_MISSION_CONTENT,CONST_XDC_TEAM_CONTENT};
    String[] xpathAct = {COIN_WHAT_IS_TITLE, COIN_MISSION_CONTENT,COIN_TEAM_CONTENT};
    boolean a = verifyTwoListByContent(contentExp, xpathAct);
    boolean b = verifyTextByConst(CONST_XDC_USE_CASE_CONTENT, XDC_USE_CASE_CONTENT);
    boolean c = verifyTextByConst(CONST_XDC_WHAT_IS_CONTENT, COIN_WHAT_IS_CONTENT);
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);

    String[] nameTeam = {CONST_XDC_TEAM_ITEM_TITLE1, CONST_XDC_TEAM_ITEM_TITLE2, CONST_XDC_TEAM_ITEM_TITLE3, CONST_XDC_TEAM_ITEM_TITLE4, CONST_XDC_TEAM_ITEM_TITLE5, CONST_XDC_TEAM_ITEM_TITLE6};
    String[] positionTeam = {CONST_XDC_TEAM_ITEM_POSITION1, CONST_XDC_TEAM_ITEM_POSITION2, CONST_XDC_TEAM_ITEM_POSITION3, CONST_XDC_TEAM_ITEM_POSITION4, CONST_XDC_TEAM_ITEM_POSITION5, CONST_XDC_TEAM_ITEM_POSITION6};
    String[] desTeam = {CONST_XDC_TEAM_ITEM_DES1, CONST_XDC_TEAM_ITEM_DES2, CONST_XDC_TEAM_ITEM_DES3, CONST_XDC_TEAM_ITEM_DES4, CONST_XDC_TEAM_ITEM_DES5, CONST_XDC_TEAM_ITEM_DES6};

    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
    String[] moreUseCaseTitle = {CONST_XDC_MORE_USE_TITLE1, CONST_XDC_MORE_USE_TITLE2, CONST_XDC_MORE_USE_TITLE3, CONST_XDC_MORE_USE_TITLE4};
    boolean moreUseCaseT = compareTwoListByConst(moreUseCaseTitle, "//div[contains(@class,'useCaseItem')]/h5/span");
    String[] moreUseCaseContent = {CONST_XDC_MORE_USE_CONTENT1, CONST_XDC_MORE_USE_CONTENT2, CONST_XDC_MORE_USE_CONTENT3, CONST_XDC_MORE_USE_CONTENT4};
    boolean moreUseCaseC = compareTwoListByConst(moreUseCaseContent, "//div[contains(@class,'useCaseItem')]/p");
    String[] nameWallet = {CONST_XDC_WALLET1, CONST_XDC_WALLET2, CONST_XDC_WALLET3, CONST_XDC_WALLET4,CONST_XDC_WALLET5,CONST_XDC_WALLET6,
      CONST_XDC_WALLET7,CONST_XDC_WALLET8,CONST_XDC_WALLET9,CONST_XDC_WALLET10};
     clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_XDC_FAQ_TITLE1, CONST_XDC_FAQ_TITLE2, CONST_XDC_FAQ_TITLE3, CONST_XDC_FAQ_TITLE4};
    String[] faqContent = {CONST_XDC_FAQ_CONTENT1, CONST_XDC_FAQ_CONTENT2, CONST_XDC_FAQ_CONTENT3, CONST_XDC_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);
    status = a && b&&c&&moreUseCaseT && moreUseCaseC;
//    System.out.println("status: "+ status);
    return status;
  }

  public void verifyTextOnXDCPage(String coinName) {
    if (verifyTextOnThePage(coinName)) {
      System.out.println("Content at " + coinName + " page correct! ");
    }
  }
}

