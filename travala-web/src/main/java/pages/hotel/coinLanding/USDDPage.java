package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstUSDDPageEN.*;
import static interfaces.hotel.coinLanding.USDDPageUI.*;

public class USDDPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;

    public USDDPage(WebDriver driver_) {
        this.driver = driver_;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnUSDDPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnUSDDPage(String coin) {
        String[] contentExp = {CONST_USDD_WHAT_IS_TITLE, CONST_USDD_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_USDD_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_USDD_WHAT_IS_TITLE, getTextElement(driver, USDD_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_USDD_USE_CASE_CONTENT1, CONST_USDD_USE_CASE_CONTENT2, CONST_USDD_USE_CASE_CONTENT3, CONST_USDD_USE_CASE_CONTENT4};
        String[] useCaseItemTitle = {CONST_USDD_USE_CASE_ITEM_TITLE1, CONST_USDD_USE_CASE_ITEM_TITLE2, CONST_USDD_USE_CASE_ITEM_TITLE3, CONST_USDD_USE_CASE_ITEM_TITLE4};
        verifyUseCase(USDD_USE_CASE_ITEM_TITLE, USDD_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnUSDDPage(coin, howToPay);

        String[] nameTeam = {CONST_USDD_TEAM_ITEM_TITLE1, CONST_USDD_TEAM_ITEM_TITLE2, CONST_USDD_TEAM_ITEM_TITLE3, CONST_USDD_TEAM_ITEM_TITLE4};
        String[] positionTeam = {CONST_USDD_TEAM_ITEM_POSITION1, CONST_USDD_TEAM_ITEM_POSITION2, CONST_USDD_TEAM_ITEM_POSITION3, CONST_USDD_TEAM_ITEM_POSITION4};
        String[] desTeam = {CONST_USDD_TEAM_ITEM_DES1, CONST_USDD_TEAM_ITEM_DES2, CONST_USDD_TEAM_ITEM_DES3, CONST_USDD_TEAM_ITEM_DES4, CONST_USDD_TEAM_ITEM_DES5};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_USDD_TRADE_ICON_GATEIO, CONST_USDD_TRADE_ICON_POLONIEX, CONST_USDD_TRADE_ICON_HUOBI_GLOBAL, CONST_USDD_TRADE_ICON_KUCOIN, CONST_USDD_TRADE_ICON_MEXC};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_USDD_STORE_ICON_LEDGER_NANO_S, CONST_USDD_STORE_ICON_METAMASK, CONST_USDD_STORE_ICON_TRUST_WALLET, CONST_USDD_STORE_ICON_TREZOR_ONE, CONST_USDD_STORE_ICON_LEDGER_NANO_X};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_USDD_FAQ_TITLE1, CONST_USDD_FAQ_TITLE2, CONST_USDD_FAQ_TITLE3};
        String[] faqContent = {CONST_USDD_FAQ_CONTENT1, CONST_USDD_FAQ_CONTENT2, CONST_USDD_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}
