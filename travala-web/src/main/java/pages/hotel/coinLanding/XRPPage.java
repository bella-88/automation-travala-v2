package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstXRPPageEN.*;
import static interfaces.hotel.coinLanding.LinkPageUI.*;


public class XRPPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public XRPPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextOnThePage() {
    String[] contentExp = {CONST_XRP_WHAT_IS_TITLE, CONST_XRP_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_XRP_MISSION_CONTENT};
    String[] xpathAct = {LINK_WHAT_IS_TITLE, COIN_WHAT_IS_CONTENT, COIN_MISSION_TITLE, COIN_MISSION_CONTENT};
    boolean t = verifyTwoListByContent(contentExp, xpathAct);

    String[] titleMoreUseCase = {CONST_XRP_MORE_USE_CASE_TITLE1, CONST_XRP_MORE_USE_CASE_TITLE2, CONST_XRP_MORE_USE_CASE_TITLE3};
    String[] useCaseContent = {CONST_XRP_USE_CASE_CONTENT1, CONST_XRP_USE_CASE_CONTENT2, CONST_XRP_USE_CASE_CONTENT3, CONST_XRP_MORE_USE_CASE_CONTENT1, CONST_XRP_MORE_USE_CASE_CONTENT2, CONST_XRP_MORE_USE_CASE_CONTENT3};
    String[] howtoPayExp = {CONST_XRP_HOW_TO_PAY1, CONST_XRP_HOW_TO_PAY2, CONST_XRP_HOW_TO_PAY3, CONST_XRP_HOW_TO_PAY4, CONST_XRP_HOW_TO_PAY5, CONST_XRP_HOW_TO_PAY6};
    verifyMoreUseCase( useCaseContent);
    verifyPaySection("XRP");

//    String[] titleSection = {CONST_XRP_TITLE_SECTION1, CONST_XRP_TITLE_SECTION3,
//            CONST_XRP_TITLE_SECTION4, CONST_XRP_TITLE_SECTION5, CONST_XRP_TITLE_SECTION6, CONST_XRP_TITLE_SECTION7, CONST_XRP_TITLE_SECTION8,
//            CONST_XRP_USE_CASE_SUB2, COIN_TRADE_SUB, COIN_STORE_SUB, COIN_TEAM_SUB};
//    boolean t2= verifyTitleSection(titleSection);

    String[] nameTeam = {CONST_XRP_TEAM_ITEM_TITLE1, CONST_XRP_TEAM_ITEM_TITLE2, CONST_XRP_TEAM_ITEM_TITLE3,
      CONST_XRP_TEAM_ITEM_TITLE4, CONST_XRP_TEAM_ITEM_TITLE5, CONST_XRP_TEAM_ITEM_TITLE6, CONST_XRP_TEAM_ITEM_TITLE7,CONST_XRP_TEAM_ITEM_TITLE8};
    String[] positionTeam = {CONST_XRP_TEAM_ITEM_POSITION1, CONST_XRP_TEAM_ITEM_POSITION2, CONST_XRP_TEAM_ITEM_POSITION3,
      CONST_XRP_TEAM_ITEM_POSITION4, CONST_XRP_TEAM_ITEM_POSITION5, CONST_XRP_TEAM_ITEM_POSITION6, CONST_XRP_TEAM_ITEM_POSITION7,CONST_XRP_TEAM_ITEM_POSITION8};
    String[] desTeam = {CONST_XRP_TEAM_ITEM_DES1, CONST_XRP_TEAM_ITEM_DES2, CONST_XRP_TEAM_ITEM_DES3,
      CONST_XRP_TEAM_ITEM_DES4, CONST_XRP_TEAM_ITEM_DES5, CONST_XRP_TEAM_ITEM_DES6, CONST_XRP_TEAM_ITEM_DES7,CONST_XRP_TEAM_ITEM_DES8};
 verifyTeamName(nameTeam, positionTeam);
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_XRP_FAQ_TITLE1, CONST_XRP_FAQ_TITLE2, CONST_XRP_FAQ_TITLE3};
    String[] faqContent = {CONST_XRP_FAQ_CONTENT1, CONST_XRP_FAQ_CONTENT2, CONST_XRP_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
    status = t ;
    return status;
  }
//
//  public void verifyNavigatePageFromLink() {
//    String[] nameWallet = {AVA_LINK_WALLET1, AVA_LINK_WALLET2, AVA_LINK_WALLET3, AVA_LINK_WALLET4, AVA_LINK_WALLET5,
//      AVA_LINK_WALLET6, AVA_LINK_WALLET7, AVA_LINK_WALLET8, AVA_LINK_WALLET9, AVA_LINK_WALLET10, AVA_LINK_WALLET11,
//      AVA_LINK_WALLET12, AVA_LINK_WALLET13, AVA_LINK_WALLET14, AVA_LINK_WALLET15, AVA_LINK_WALLET16, AVA_LINK_WALLET17,
//      AVA_LINK_WALLET18, AVA_LINK_WALLET19, AVA_LINK_WALLET20, AVA_LINK_WALLET21, AVA_LINK_WALLET22, AVA_LINK_WALLET28,
//      AVA_LINK_WALLET23, AVA_LINK_WALLET24, AVA_LINK_WALLET25, AVA_LINK_WALLET26, AVA_LINK_WALLET27, AVA_LINK_WALLET28,
//      WALLET_NAME1, WALLET_NAME2, WALLET_NAME3, WALLET_NAME4, WALLET_NAME5, WALLET_NAME6, WALLET_NAME7,
//      WALLET_NAME8, WALLET_NAME9, WALLET_NAME10, WALLET_NAME11, WALLET_NAME12, WALLET_NAME13, WALLET_NAME14, WALLET_NAME15,
//      WALLET_NAME16, WALLET_NAME17, WALLET_NAME18, WALLET_NAME19, WALLET_NAME20};
//    verifyNameWalletCoinLanding(nameWallet);
//    clickOnWalletLink(COIN_URL_LINKIN, COIN_URL_LINKIN_DYNAMIC, LINK_PATH);
//    clickToElementByJavascript(driver, LINK_URL_LINKIN_OTHER1);
//    backToPreviousPage(driver);
//    clickToElementByJavascript(driver, LINK_URL_LINKIN_OTHER1);
//    backToPreviousPage(driver);
//    clickToElementByJavascript(driver, LINK_URL_PAYMENT);
//    switchToWindowByUrlContainsString(driver, LINK_PATH);
//    clickToElementByJavascript(driver, LINK_URL_TRAVALA);
//    switchToWindowByUrlContainsString(driver, LINK_PATH);
//
//  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_XRP_WHAT_IS_TITLE, CONST_XRP_WHAT_IS_CONTENT, CONST_XRP_MISSION_CONTENT, CONST_XRP_TEAM_CONTENT};
    verifyWhatSection(contentExp);
   verifyPaySection(coinName);
//  verifyTitleSection(coinName);
    String[] nameTeam = {CONST_XRP_TEAM_ITEM_TITLE1, CONST_XRP_TEAM_ITEM_TITLE2, CONST_XRP_TEAM_ITEM_TITLE3, CONST_XRP_TEAM_ITEM_TITLE4, CONST_XRP_TEAM_ITEM_TITLE5, CONST_XRP_TEAM_ITEM_TITLE6};
    String[] positionTeam = {CONST_XRP_TEAM_ITEM_POSITION1, CONST_XRP_TEAM_ITEM_POSITION2, CONST_XRP_TEAM_ITEM_POSITION3, CONST_XRP_TEAM_ITEM_POSITION4, CONST_XRP_TEAM_ITEM_POSITION5, CONST_XRP_TEAM_ITEM_POSITION6};
    String[] desTeam = {CONST_XRP_TEAM_ITEM_DES1, CONST_XRP_TEAM_ITEM_DES2, CONST_XRP_TEAM_ITEM_DES3, CONST_XRP_TEAM_ITEM_DES4, CONST_XRP_TEAM_ITEM_DES5, CONST_XRP_TEAM_ITEM_DES6};
   verifyTeamName(nameTeam, positionTeam);
    String[] useCaseTitle = {CONST_XRP_MORE_USE_CASE_TITLE1, CONST_XRP_MORE_USE_CASE_TITLE2, CONST_XRP_MORE_USE_CASE_TITLE3,CONST_XRP_MORE_USE_CASE_TITLE4};
    boolean t5 =compareTwoListByConst(useCaseTitle,"//div[contains(@class,'useCaseItem')]/h5");
    String[] useCaseContent = {CONST_XRP_MORE_USE_CASE_CONTENT1, CONST_XRP_MORE_USE_CASE_CONTENT2, CONST_XRP_MORE_USE_CASE_CONTENT3,CONST_XRP_MORE_USE_CASE_CONTENT4};
    boolean t7 =compareTwoListByConst(useCaseContent,"//div[contains(@class,'useCaseItem')]/p");
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_XRP_FAQ_TITLE1, CONST_XRP_FAQ_TITLE2, CONST_XRP_FAQ_TITLE3};
    String[] faqContent = {CONST_XRP_FAQ_CONTENT1, CONST_XRP_FAQ_CONTENT2, CONST_XRP_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
    status = t5 &&t7;
  }

  public void verifyTextOnXRPPage(String coinName) {
//    verifyNavigatePageFromLink();
    verifyTextOnThePage(coinName);
  }
}
