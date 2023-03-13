package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstSTRAXPageEN.*;
import static interfaces.hotel.coinLanding.STRAXPageUI.*;

public class STRAXPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;
    public STRAXPage(WebDriver _driver) {
        this.driver = _driver;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnSTRAXPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnSTRAXPage(String coin) {
        String[] contentExp = {CONST_STRAX_WHAT_IS_TITLE, CONST_STRAX_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_STRAX_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_STRAX_WHAT_IS_TITLE, getTextElement(driver, STRAX_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_STRAX_USE_CASE_CONTENT1, CONST_STRAX_USE_CASE_CONTENT2, CONST_STRAX_USE_CASE_CONTENT3, CONST_STRAX_USE_CASE_CONTENT4};
        String[] useCaseItemTitle = {CONST_STRAX_USE_CASE_ITEM_TITLE1, CONST_STRAX_USE_CASE_ITEM_TITLE2, CONST_STRAX_USE_CASE_ITEM_TITLE3, CONST_STRAX_USE_CASE_ITEM_TITLE4};
        verifyUseCase(STRAX_USE_CASE_ITEM_TITLE, STRAX_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnSTRAXPage(coin, howToPay);

        String[] nameTeam = {CONST_STRAX_TEAM_ITEM_TITLE1, CONST_STRAX_TEAM_ITEM_TITLE2, CONST_STRAX_TEAM_ITEM_TITLE3};
        String[] positionTeam = {CONST_STRAX_TEAM_ITEM_POSITION1, CONST_STRAX_TEAM_ITEM_POSITION2, CONST_STRAX_TEAM_ITEM_POSITION3};
        String[] desTeam = {CONST_STRAX_TEAM_ITEM_DES1, CONST_STRAX_TEAM_ITEM_DES2, CONST_STRAX_TEAM_ITEM_DES3};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_STRAX_TRADE_ICON_BINANCE, CONST_STRAX_TRADE_ICON_GATEIO, CONST_STRAX_TRADE_ICON_BITHUMB, CONST_STRAX_TRADE_ICON_UPBIT, CONST_STRAX_TRADE_ICON_BITTREX};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_STRAX_STORE_ICON_STRAX_WALLET, CONST_STRAX_STORE_ICON_STRATIS_MOBILE_WALLET};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_STRAX_FAQ_TITLE1, CONST_STRAX_FAQ_TITLE2, CONST_STRAX_FAQ_TITLE3};
        String[] faqContent = {CONST_STRAX_FAQ_CONTENT1, CONST_STRAX_FAQ_CONTENT2, CONST_STRAX_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}




