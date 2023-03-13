package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstXCURPageEN.*;
import static interfaces.hotel.coinLanding.XCURPageUI.*;

public class XCURPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;
    public XCURPage(WebDriver _driver) {
        this.driver = _driver;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnXCURPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnXCURPage(String coin) {
        String[] contentExp = {CONST_XCUR_WHAT_IS_TITLE, CONST_XCUR_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_XCUR_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_XCUR_WHAT_IS_TITLE, getTextElement(driver, XCUR_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_XCUR_USE_CASE_CONTENT1, CONST_XCUR_USE_CASE_CONTENT2, CONST_XCUR_USE_CASE_CONTENT3, CONST_XCUR_USE_CASE_CONTENT4};
        String[] useCaseItemTitle = {CONST_XCUR_USE_CASE_ITEM_TITLE1, CONST_XCUR_USE_CASE_ITEM_TITLE2, CONST_XCUR_USE_CASE_ITEM_TITLE3, CONST_XCUR_USE_CASE_ITEM_TITLE4};
        verifyUseCase(XCUR_USE_CASE_ITEM_TITLE, XCUR_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnXCURPage(coin, howToPay);

        String[] nameTeam = {CONST_XCUR_TEAM_ITEM_TITLE1, CONST_XCUR_TEAM_ITEM_TITLE2, CONST_XCUR_TEAM_ITEM_TITLE3};
        String[] positionTeam = {CONST_XCUR_TEAM_ITEM_POSITION1, CONST_XCUR_TEAM_ITEM_POSITION2, CONST_XCUR_TEAM_ITEM_POSITION3};
        String[] desTeam = {CONST_XCUR_TEAM_ITEM_DES1, CONST_XCUR_TEAM_ITEM_DES2, CONST_XCUR_TEAM_ITEM_DES3, CONST_XCUR_TEAM_ITEM_DES4};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_XCUR_TRADE_ICON_GATEIO, CONST_XCUR_TRADE_ICON_HUOBI_GLOBAL, CONST_XCUR_TRADE_ICON_KUCOIN};

        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_XCUR_STORE_ICON_LEDGER_NANO_S, CONST_XCUR_STORE_ICON_METAMASK, CONST_XCUR_STORE_ICON_COINOMI, CONST_XCUR_STORE_ICON_TREZOR_ONE, CONST_XCUR_STORE_ICON_LEDGER_NANO_X, CONST_XCUR_STORE_ICON_EXODUS, CONST_XCUR_STORE_ICON_IMTOKEN};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_XCUR_FAQ_TITLE1, CONST_XCUR_FAQ_TITLE2, CONST_XCUR_FAQ_TITLE3};
        String[] faqContent = {CONST_XCUR_FAQ_CONTENT1, CONST_XCUR_FAQ_CONTENT2, CONST_XCUR_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}




