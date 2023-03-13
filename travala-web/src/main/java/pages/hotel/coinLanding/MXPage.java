package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstMXPageEN.*;
import static interfaces.hotel.coinLanding.MXPageUI.*;

public class MXPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;

    public MXPage(WebDriver driver_) {
        this.driver = driver_;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnMXPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnMXPage(String coin) {
        String[] contentExp = {CONST_MX_WHAT_IS_TITLE, CONST_MX_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_MX_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_MX_WHAT_IS_TITLE, getTextElement(driver, MX_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_MX_USE_CASE_CONTENT1, CONST_MX_USE_CASE_CONTENT2, CONST_MX_USE_CASE_CONTENT3, CONST_MX_USE_CASE_CONTENT4};
        String[] useCaseTitle = {CONST_MX_USE_CASE_ITEM_TITLE1, CONST_MX_USE_CASE_ITEM_TITLE2, CONST_MX_USE_CASE_ITEM_TITLE3, CONST_MX_USE_CASE_ITEM_TITLE4 };
        verifyUseCase(MX_USE_CASE_ITEM_TITLE, MX_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnMXPage(coin, howToPay);

        String[] nameTeam = {CONST_MX_TEAM_ITEM_TITLE1};
        String[] positionTeam = {CONST_MX_TEAM_ITEM_POSITION1};
        String[] desTeam = {CONST_MX_TEAM_ITEM_DES1};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_MX_TRADE_ICON_MEXC, CONST_MX_TRADE_ICON_UNISWAP, CONST_MX_TRADE_ICON_BYBIT, CONST_MX_TRADE_ICON_HOUBI};
        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_MX_STORE_ICON_LEDGER_NANO, CONST_MX_STORE_ICON_IMTOKEN, CONST_MX_STORE_ICON_COINOMI, CONST_MX_STORE_ICON_TREZOR_MODEL, CONST_MX_STORE_ICON_TRUST_WALLET};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_MX_FAQ_TITLE1, CONST_MX_FAQ_TITLE2, CONST_MX_FAQ_TITLE3};
        String[] faqContent = {CONST_MX_FAQ_CONTENT1, CONST_MX_FAQ_CONTENT2, CONST_MX_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);

        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}
