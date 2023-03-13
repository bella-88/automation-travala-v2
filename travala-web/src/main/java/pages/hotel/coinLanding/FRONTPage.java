package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.CONST_HOW_TO_PAY6;
import static constants.hotel.contentCoinPage.ConstFRONTPageEN.*;
import static interfaces.hotel.coinLanding.FRONTPageUI.*;

public class FRONTPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;
    public FRONTPage(WebDriver _driver) {
        this.driver = _driver;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnFRONTPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnFRONTPage(String coin) {
        String[] contentExp = {CONST_FRONT_WHAT_IS_TITLE, CONST_FRONT_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_FRONT_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_FRONT_WHAT_IS_TITLE, getTextElement(driver, FRONT_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_FRONT_USE_CASE_CONTENT1, CONST_FRONT_USE_CASE_CONTENT2, CONST_FRONT_USE_CASE_CONTENT3, CONST_FRONT_USE_CASE_CONTENT4, CONST_FRONT_USE_CASE_CONTENT5};
        String[] useCaseItemTitle = {CONST_FRONT_USE_CASE_ITEM_TITLE1, CONST_FRONT_USE_CASE_ITEM_TITLE2, CONST_FRONT_USE_CASE_ITEM_TITLE3, CONST_FRONT_USE_CASE_ITEM_TITLE4, CONST_FRONT_USE_CASE_ITEM_TITLE5};
        verifyUseCase(FRONT_USE_CASE_ITEM_TITLE, FRONT_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnFRONTPage(coin, howToPay);

        String[] nameTeam = {CONST_FRONT_TEAM_ITEM_TITLE1, CONST_FRONT_TEAM_ITEM_TITLE2, CONST_FRONT_TEAM_ITEM_TITLE3, CONST_FRONT_TEAM_ITEM_TITLE4, CONST_FRONT_TEAM_ITEM_TITLE5};
        String[] positionTeam = {CONST_FRONT_TEAM_ITEM_POSITION1, CONST_FRONT_TEAM_ITEM_POSITION2, CONST_FRONT_TEAM_ITEM_POSITION3, CONST_FRONT_TEAM_ITEM_POSITION4, CONST_FRONT_TEAM_ITEM_POSITION5};
        String[] desTeam = {CONST_FRONT_TEAM_ITEM_DES1, CONST_FRONT_TEAM_ITEM_DES2, CONST_FRONT_TEAM_ITEM_DES3, CONST_FRONT_TEAM_ITEM_DES4, CONST_FRONT_TEAM_ITEM_DES5, CONST_FRONT_TEAM_ITEM_DES6};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_FRONT_TRADE_ICON_BINANCE, CONST_FRONT_TRADE_ICON_OKX, CONST_FRONT_TRADE_ICON_ASCENDEX, CONST_FRONT_TRADE_ICON_PROBIT_GLOBAL, CONST_FRONT_TRADE_ICON_MEXC, CONST_FRONT_TRADE_ICON_KUCOIN, CONST_FRONT_TRADE_ICON_GATEIO, CONST_FRONT_TRADE_ICON_HUOBI_GLOBAL, CONST_FRONT_TRADE_ICON_COINBASE};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_FRONT_STORE_ICON_FRONTIER, CONST_FRONT_STORE_ICON_LEDGER_NANO_X, CONST_FRONT_STORE_ICON_TRUST_WALLET, CONST_FRONT_STORE_ICON_LEDGER_NANO_S, CONST_FRONT_STORE_ICON_METAMASK, CONST_FRONT_STORE_ICON_RAINBOW, CONST_FRONT_STORE_ICON_ARGENT};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_FRONT_FAQ_TITLE1, CONST_FRONT_FAQ_TITLE2, CONST_FRONT_FAQ_TITLE3};
        String[] faqContent = {CONST_FRONT_FAQ_CONTENT1, CONST_FRONT_FAQ_CONTENT2, CONST_FRONT_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}
