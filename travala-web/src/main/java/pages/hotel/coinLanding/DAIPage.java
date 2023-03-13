package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstDAIPageEN.*;
import static interfaces.hotel.coinLanding.DAIPageUI.*;


public class DAIPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;
  public DAIPage(WebDriver _driver) {
    this.driver = _driver;
    super.setDriver(driver);
  }

  public void verifyPaySectionOnDAIPage(String coinName, String[] howToPay) {
    if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
            && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
      System.out.println("Content at How to pay of " + coinName + " wrong!");
    } else {
      System.out.println("Content at How to pay of " + coinName + " correctly!");
    }
  }

  public void verifyTextOnDAIPage(String coin) {
    String[] contentExp = {CONST_DAI_WHAT_IS_TITLE, CONST_DAI_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_DAI_MISSION_CONTENT};
    verifyWhatSection(contentExp);
    status = StringUtils.contains(CONST_DAI_WHAT_IS_TITLE, getTextElement(driver, DAI_WHAT_IS_TITLE));

    String[] useCaseContent = {CONST_DAI_USE_CASE_CONTENT1, CONST_DAI_USE_CASE_CONTENT2, CONST_DAI_USE_CASE_CONTENT3, CONST_DAI_USE_CASE_CONTENT4};
    String[] useCaseItemTitle = {CONST_DAI_USE_CASE_ITEM_TITLE1, CONST_DAI_USE_CASE_ITEM_TITLE2, CONST_DAI_USE_CASE_ITEM_TITLE3, CONST_DAI_USE_CASE_ITEM_TITLE4};
    verifyUseCase(DAI_USE_CASE_ITEM_TITLE, DAI_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

    String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
    verifyPaySectionOnDAIPage(coin, howToPay);

    String[] nameTeam = {CONST_DAI_TEAM_ITEM_TITLE1};
    String[] positionTeam = {CONST_DAI_TEAM_ITEM_POSITION1};
    String[] desTeam = {CONST_DAI_TEAM_ITEM_DES1, CONST_DAI_TEAM_ITEM_DES2};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);

    String[] listTrades = {CONST_DAI_TRADE_ICON_BINANCE, CONST_DAI_TRADE_ICON_KRAKEN, CONST_DAI_TRADE_ICON_COINBASE, CONST_DAI_TRADE_ICON_KUCOIN, CONST_DAI_TRADE_ICON_UNISWAP, CONST_DAI_TRADE_ICON_BITFINEX};
    verifyTradeSection(coin, listTrades);
    String[] listStores = {CONST_DAI_STORE_ICON_LEDGER_NANO_S, CONST_DAI_STORE_ICON_TRUST_WALLET, CONST_DAI_STORE_ICON_LEDGER_NANO_X, CONST_DAI_STORE_ICON_TREZOR_ONE, CONST_DAI_STORE_ICON_METAMASK};
    verifyStoreSection(coin, listStores);

    String[] titleFAQ = {CONST_DAI_FAQ_TITLE1, CONST_DAI_FAQ_TITLE2, CONST_DAI_FAQ_TITLE3};
    String[] faqContent = {CONST_DAI_FAQ_CONTENT1, CONST_DAI_FAQ_CONTENT2, CONST_DAI_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
    if (status) {
      System.out.println("All content at "+coin+" page correct! ");
    } else {
      System.out.println("Content at "+coin+" page wrong! ");
    }
  }
}
