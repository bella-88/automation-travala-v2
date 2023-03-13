package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstXLMPageEN.*;
import static interfaces.hotel.coinLanding.XLMPageUI.*;

public class XLMPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;
  public XLMPage(WebDriver _driver) {
    this.driver = _driver;
    super.setDriver(driver);
  }

  public void verifyPaySectionOnXLMPage(String coinName, String[] howToPay) {
    if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
            && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
      System.out.println("Content at How to pay of " + coinName + " wrong!");
    } else {
      System.out.println("Content at How to pay of " + coinName + " correctly!");
    }
  }

  public void verifyTextOnXLMPage(String coin) {
    String[] contentExp = {CONST_XLM_WHAT_IS_TITLE, CONST_XLM_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_XLM_MISSION_CONTENT};
    verifyWhatSection(contentExp);
    status = StringUtils.contains(CONST_XLM_WHAT_IS_TITLE, getTextElement(driver, XLM_WHAT_IS_TITLE));

    String[] useCaseContent = {CONST_XLM_USE_CASE_CONTENT1, CONST_XLM_USE_CASE_CONTENT2, CONST_XLM_USE_CASE_CONTENT3, CONST_XLM_USE_CASE_CONTENT4};
    String[] useCaseItemTitle = {CONST_XLM_USE_CASE_ITEM_TITLE1, CONST_XLM_USE_CASE_ITEM_TITLE2, CONST_XLM_USE_CASE_ITEM_TITLE3, CONST_XLM_USE_CASE_ITEM_TITLE4};
    verifyUseCase(XLM_USE_CASE_ITEM_TITLE, XLM_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

    String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
    verifyPaySectionOnXLMPage(coin, howToPay);

    String[] nameTeam = {CONST_XLM_TEAM_ITEM_TITLE1, CONST_XLM_TEAM_ITEM_TITLE2, CONST_XLM_TEAM_ITEM_TITLE3, CONST_XLM_TEAM_ITEM_TITLE4};
    String[] positionTeam = {CONST_XLM_TEAM_ITEM_POSITION1, CONST_XLM_TEAM_ITEM_POSITION2, CONST_XLM_TEAM_ITEM_POSITION3, CONST_XLM_TEAM_ITEM_POSITION4};
    String[] desTeam = {CONST_XLM_TEAM_ITEM_DES1, CONST_XLM_TEAM_ITEM_DES2, CONST_XLM_TEAM_ITEM_DES3, CONST_XLM_TEAM_ITEM_DES4, CONST_XLM_TEAM_ITEM_DES5};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);

    String[] listTrades = {CONST_XLM_TRADE_ICON_BINANCE, CONST_XLM_TRADE_ICON_COINBASE, CONST_XLM_TRADE_ICON_KRAKEN, CONST_XLM_TRADE_ICON_GATEIO, CONST_XLM_TRADE_ICON_HUOBI_GLOBAL,
            CONST_XLM_TRADE_ICON_KUCOIN, CONST_XLM_TRADE_ICON_BITSTAMP, CONST_XLM_TRADE_ICON_BITFINEX, CONST_XLM_TRADE_ICON_BYBIT, CONST_XLM_TRADE_ICON_MEXC};

    verifyTradeSection(coin, listTrades);
    String[] listStores = {CONST_XLM_STORE_ICON_LEDGER_NANO_S, CONST_XLM_STORE_ICON_TRUST_WALLET, CONST_XLM_STORE_ICON_BLOCKCHAIN, CONST_XLM_STORE_ICON_LEDGER_NANO_X,
            CONST_XLM_STORE_ICON_TREZOR_ONE, CONST_XLM_STORE_ICON_KEYBASE, CONST_XLM_STORE_ICON_SOLAR_WALLET, CONST_XLM_STORE_ICON_LOBSTR};
    verifyStoreSection(coin, listStores);

    String[] titleFAQ = {CONST_XLM_FAQ_TITLE1, CONST_XLM_FAQ_TITLE2, CONST_XLM_FAQ_TITLE3};
    String[] faqContent = {CONST_XLM_FAQ_CONTENT1, CONST_XLM_FAQ_CONTENT2, CONST_XLM_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
    if (status) {
      System.out.println("All content at "+coin+" page correct! ");
    } else {
      System.out.println("Content at "+coin+" page wrong! ");
    }
  }
}

