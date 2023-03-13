package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.CONST_HOW_TO_PAY6;
import static constants.hotel.contentCoinPage.ConstHBARPageEN.*;
import static interfaces.hotel.coinLanding.HBARPageUI.*;

public class HBARPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;

    public HBARPage(WebDriver driver_) {
        this.driver = driver_;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnHBARPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnHBARPage(String coin) {
        String[] contentExp = {CONST_HBAR_WHAT_IS_TITLE, CONST_HBAR_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_HBAR_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_HBAR_WHAT_IS_TITLE, getTextElement(driver, HBAR_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_HBAR_USE_CASE_CONTENT1, CONST_HBAR_USE_CASE_CONTENT2, CONST_HBAR_USE_CASE_CONTENT3};
        String[] useCaseItemTitle = {CONST_HBAR_USE_CASE_ITEM_TITLE1, CONST_HBAR_USE_CASE_ITEM_TITLE2, CONST_HBAR_USE_CASE_ITEM_TITLE3};
        verifyUseCase(HBAR_USE_CASE_ITEM_TITLE, HBAR_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnHBARPage(coin, howToPay);

        String[] nameTeam = {CONST_HBAR_TEAM_ITEM_TITLE1, CONST_HBAR_TEAM_ITEM_TITLE2, CONST_HBAR_TEAM_ITEM_TITLE3, CONST_HBAR_TEAM_ITEM_TITLE4, CONST_HBAR_TEAM_ITEM_TITLE5, CONST_HBAR_TEAM_ITEM_TITLE6};
        String[] positionTeam = {CONST_HBAR_TEAM_ITEM_POSITION1, CONST_HBAR_TEAM_ITEM_POSITION2, CONST_HBAR_TEAM_ITEM_POSITION3, CONST_HBAR_TEAM_ITEM_POSITION4, CONST_HBAR_TEAM_ITEM_POSITION5, CONST_HBAR_TEAM_ITEM_POSITION6};
        String[] desTeam = {CONST_HBAR_TEAM_ITEM_DES1, CONST_HBAR_TEAM_ITEM_DES2, CONST_HBAR_TEAM_ITEM_DES3, CONST_HBAR_TEAM_ITEM_DES4, CONST_HBAR_TEAM_ITEM_DES5, CONST_HBAR_TEAM_ITEM_DES6, CONST_HBAR_TEAM_ITEM_DES7};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_HBAR_TRADE_ICON_HITBTC, CONST_HBAR_TRADE_ICON_KUCOIN, CONST_HBAR_TRADE_ICON_BINANCE_US, CONST_HBAR_TRADE_ICON_GATEIO};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_HBAR_STORE_ICON_HASHPACK, CONST_HBAR_STORE_ICON_LEDGER_NANO, CONST_HBAR_STORE_ICON_BLADE, CONST_HBAR_STORE_ICON_TREZOR_ONE, CONST_HBAR_STORE_ICON_COINOMI};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_HBAR_FAQ_TITLE1, CONST_HBAR_FAQ_TITLE2, CONST_HBAR_FAQ_TITLE3, CONST_HBAR_FAQ_TITLE4};
        String[] faqContent = {CONST_HBAR_FAQ_CONTENT1, CONST_HBAR_FAQ_CONTENT2, CONST_HBAR_FAQ_CONTENT3, CONST_HBAR_FAQ_CONTENT4};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}
