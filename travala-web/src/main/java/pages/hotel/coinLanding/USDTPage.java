package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;

import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstUsdtPageEN.*;
import static interfaces.hotel.coinLanding.USDTPageUI.USDT_WHAT_IS_TITLE;


public class USDTPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;
  public USDTPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
}

  public void verifyTextOnUsdtPage(String coin) {
    String[] contentExp = {CONST_USDT_WHAT_IS_CONTENT,  COIN_MISSION_TITLE};
    boolean t1 = StringUtils.contains(CONST_USDT_WHAT_IS_TITLE, getTextElement(driver,USDT_WHAT_IS_TITLE ));
    if(!t1){
      System.out.println("Actual usdt Page:" +getTextElement(driver, USDT_WHAT_IS_TITLE));
      System.out.println("Expect usdt Page:" +CONST_USDT_WHAT_IS_TITLE);
    }
   verifyWhatSection(contentExp);

    String[] titleSection = {CONST_TEAM_TITLE, CONST_USDT_TEAM_CONTENT, CONST_USDT_MARKET_TITLE, CONST_USDT_USE_CASE_TITLE,
            CONST_USDT_USE_CASE_SUB2, CONST_USDT_PAY_TITLE, CONST_USDT_TRADE_TITLE, CONST_USDT_TRADE_SUB, CONST_USDT_STORE_TITLE, CONST_USDT_STORE_SUB, CONST_FAQ_TITLE};
//      verifyTitleSection("USDT");
    String[] titleFAQ = {CONST_USDT_FAQ_TITLE1, CONST_USDT_FAQ_TITLE2, CONST_USDT_FAQ_TITLE3, CONST_USDT_FAQ_TITLE4};
    String[] faqContent = {CONST_USDT_FAQ_CONTENT1, CONST_USDT_FAQ_CONTENT2, CONST_USDT_FAQ_CONTENT3, CONST_USDT_FAQ_CONTENT4};
//   if( verifyNameWalletOnLandingCoinPage()){
//     System.out.println("correct");}else {
//     System.out.println("wrong");
//   }  if(  verifyUrlPage(USDT_ERC_URL)){
//     System.out.println("wrong");}else {
//     System.out.println("correct");
//   }

    String[] nameTeam = {CONST_USDT_TEAM_ITEM_TITLE1, CONST_USDT_TEAM_ITEM_TITLE2, CONST_USDT_TEAM_ITEM_TITLE3};
    String[] positionTeam = {CONST_USDT_TEAM_ITEM_POSITION1, CONST_USDT_TEAM_ITEM_POSITION2, CONST_USDT_TEAM_ITEM_POSITION3};
    String[] desTeam = {CONST_USDT_TEAM_ITEM_DES1, CONST_USDT_TEAM_ITEM_DES2, CONST_USDT_TEAM_ITEM_DES3};
     verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes( desTeam);
  verifyPaySection(coin);
    String[] titleMoreUseCase = {CONST_USDT_MORE_USE_CASE_TITLE1, CONST_USDT_MORE_USE_CASE_TITLE2, CONST_USDT_MORE_USE_CASE_TITLE3};
    String[] useCaseContent = {CONST_USDT_USE_CASE_CONTENT1, CONST_USDT_USE_CASE_CONTENT2, CONST_USDT_MORE_USE_CASE_CONTENT1, CONST_USDT_MORE_USE_CASE_CONTENT2, CONST_USDT_MORE_USE_CASE_CONTENT3};
    verifyMoreUseCase( useCaseContent);
  }
//    if (verifyTextBanner(CONST_USDT_BANNER_TITLE1, "CONST_USDT_BANNER_TITLE1", CONST_USDT_BANNER_TITLE2, "CONST_USDT_BANNER_TITLE2") && verifyTextOnThePage()) {
//      System.out.println("Content at Hotel tab correct! ");
//    }
//    verifyClickToLinkLandingCoin(CONST_USDT_PATH);
//    clickToElement(driver, ACTIVITIES_TAB);
//    wait1sTime();
//    if (verifyTextBanner(CONST_USDT_BANNER_TITLE1, "CONST_USDT_BANNER_TITLE_ACTIVITIES1", CONST_USDT_BANNER_TITLE2, "CONST_USDT_BANNER_TITLE_ACTIVITIES2")) {
//      System.out.println("Content at Activities tab correct! ");
//    }
//    clickToElement(driver, FLIGHT_TAB);
//    wait1sTime();
//    if (verifyTextBanner(CONST_USDT_BANNER_TITLE1, "CONST_USDT_BANNER_TITLE_FLIGHT1", CONST_USDT_BANNER_TITLE2, "CONST_USDT_BANNER_TITLE_FLIGHT2")) {
//      System.out.println("Content at Flight tab correct! ");
//    }
  }
