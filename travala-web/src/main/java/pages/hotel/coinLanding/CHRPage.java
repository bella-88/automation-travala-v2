package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;


import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCHRPageEN.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static interfaces.hotel.coinLanding.CHRPageUI.*;

public class CHRPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;
    public CHRPage(WebDriver _driver) {
        this.driver = _driver;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnCHRPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnCHRPage(String coin) {
        String[] contentExp = {CONST_CHR_WHAT_IS_TITLE, CONST_CHR_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_CHR_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_CHR_WHAT_IS_TITLE, getTextElement(driver, CHR_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_CHR_USE_CASE_CONTENT1, CONST_CHR_USE_CASE_CONTENT2, CONST_CHR_USE_CASE_CONTENT3, CONST_CHR_USE_CASE_CONTENT4};
        String[] useCaseItemTitle = {CONST_CHR_USE_CASE_ITEM_TITLE1, CONST_CHR_USE_CASE_ITEM_TITLE2, CONST_CHR_USE_CASE_ITEM_TITLE3, CONST_CHR_USE_CASE_ITEM_TITLE4};
        verifyUseCase(CHR_USE_CASE_ITEM_TITLE, CHR_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnCHRPage(coin, howToPay);

        String[] nameTeam = {CONST_CHR_TEAM_ITEM_TITLE1, CONST_CHR_TEAM_ITEM_TITLE2, CONST_CHR_TEAM_ITEM_TITLE3};
        String[] positionTeam = {CONST_CHR_TEAM_ITEM_POSITION1, CONST_CHR_TEAM_ITEM_POSITION2, CONST_CHR_TEAM_ITEM_POSITION3};
        String[] desTeam = {CONST_CHR_TEAM_ITEM_DES1, CONST_CHR_TEAM_ITEM_DES2, CONST_CHR_TEAM_ITEM_DES3, CONST_CHR_TEAM_ITEM_DES4};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_CHR_TRADE_ICON_BINANCE, CONST_CHR_TRADE_ICON_GATEIO, CONST_CHR_TRADE_ICON_HUOBI_GLOBAL, CONST_CHR_TRADE_ICON_FTX, CONST_CHR_TRADE_ICON_KRAKEN, CONST_CHR_TRADE_ICON_KUCOIN, CONST_CHR_TRADE_ICON_HITBTC};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_CHR_STORE_ICON_LEDGER_NANO_S, CONST_CHR_STORE_ICON_TREZOR_ONE, CONST_CHR_STORE_ICON_LEDGER_NANO_X, CONST_CHR_STORE_ICON_TRUST_WALLET, CONST_CHR_STORE_ICON_METAMASK, CONST_CHR_STORE_ICON_IMTOKEN, CONST_CHR_STORE_ICON_ATOMIC_WALLET};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_CHR_FAQ_TITLE1, CONST_CHR_FAQ_TITLE2, CONST_CHR_FAQ_TITLE3};
        String[] faqContent = {CONST_CHR_FAQ_CONTENT1, CONST_CHR_FAQ_CONTENT2, CONST_CHR_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}

