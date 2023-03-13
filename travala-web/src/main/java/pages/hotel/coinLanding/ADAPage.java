package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstADAPageEN.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static interfaces.hotel.coinLanding.ADAPageUI.*;
import static interfaces.hotel.coinLanding.LinkPageUI.*;
public class ADAPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public ADAPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextOnThePage() {
    String[] contentExp = {CONST_ADA_WHAT_IS_CONTENT, CONST_TOKEN_PRICE, CONST_MISSION_TITLE};
    verifyWhatSection(contentExp);
    boolean t = StringUtils.contains(CONST_ADA_WHAT_IS_TITLE, getTextElement(driver, ADA_WHAT_IS_TITLE));
        String[] useCaseContent = {CONST_ADA_USE_CASE_CONTENT1, CONST_ADA_USE_CASE_CONTENT2, CONST_ADA_MORE_USE_CASE_CONTENT1,
      CONST_ADA_MORE_USE_CASE_CONTENT2, CONST_ADA_MORE_USE_CASE_CONTENT3, CONST_ADA_MORE_USE_CASE_CONTENT4};
  verifyMoreUseCase( useCaseContent);
    String[] howtoPayExp = {CONST_ADA_HOW_TO_PAY1, CONST_ADA_HOW_TO_PAY2, CONST_ADA_HOW_TO_PAY3, CONST_ADA_HOW_TO_PAY4, CONST_ADA_HOW_TO_PAY5, CONST_ADA_HOW_TO_PAY6};
   verifyPaySection("ADA");
    String[] titleSection = {CONST_TEAM_TITLE, CONST_ADA_TEAM_SUB, CONST_ADA_MARKET_TITLE, CONST_ADA_USE_CASE_TITLE,
      CONST_ADA_USE_CASE_SUB2, CONST_ADA_PAY_TITLE, CONST_ADA_TRADE_TITLE, CONST_ADA_TRADE_SUB, CONST_ADA_STORE_TITLE, CONST_ADA_STORE_SUB, CONST_FAQ_TITLE};
// verifyTitleSection("ADA");
    String[] nameTeam = {CONST_ADA_TEAM_ITEM_TITLE1, CONST_ADA_TEAM_ITEM_TITLE2, CONST_ADA_TEAM_ITEM_TITLE3};
    String[] positionTeam = {CONST_ADA_TEAM_ITEM_POSITION1, CONST_ADA_TEAM_ITEM_POSITION2, CONST_ADA_TEAM_ITEM_POSITION3};
    String[] desTeam = {CONST_ADA_TEAM_ITEM_DES1, CONST_ADA_TEAM_ITEM_DES2, CONST_ADA_TEAM_ITEM_DES3};
    verifyTeamName(nameTeam, positionTeam);
   verifyTeamDes( desTeam);

    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_ADA_FAQ_TITLE1, CONST_ADA_FAQ_TITLE2, CONST_ADA_FAQ_TITLE3, CONST_ADA_FAQ_TITLE4};
    String[] faqContent = {CONST_ADA_FAQ_CONTENT1, CONST_ADA_FAQ_CONTENT2, CONST_ADA_FAQ_CONTENT3, CONST_ADA_FAQ_CONTENT4};
   verifyFAQSection(titleFAQ, faqContent);
    status = t;
    if (!status) {
      System.out.println("ADA Landing page wrong");
    }
    return status;
  }

  public void verifyTextOnADAPage(String coin) {
    boolean t = verifyTextOnThePage();
//   verifyTextBanner( coin, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
//    verifyClickToLinkLandingCoin(ADA_PATH);
    if (t) {
      System.out.println("Content at "+coin+"  page correct! ");
    } else {
      System.out.println("Content at "+coin+"  page wrong! ");
    }
  }
}
