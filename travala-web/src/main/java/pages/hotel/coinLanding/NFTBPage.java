package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.CONST_HOW_TO_PAY6;
import static constants.hotel.contentCoinPage.ConstNFTBPageEN.*;
import static interfaces.hotel.coinLanding.NFTBPageUI.*;

public class NFTBPage extends CommonHotelPages {
    WebDriver driver;
    boolean status = true;
    public NFTBPage(WebDriver _driver) {
        this.driver = _driver;
        super.setDriver(driver);
    }

    public void verifyPaySectionOnNFTBPage(String coinName, String[] howToPay) {
        if (!(compareTwoListByConst(addListExpectAfterFormatFromConst(howToPay, coinName), COIN_PAY_CONTENT)
                && verifyTextByConst(CONST_PAY_TITLE.replaceAll("%s", coinName), COIN_PAY_TITLE))) {
            System.out.println("Content at How to pay of " + coinName + " wrong!");
        } else {
            System.out.println("Content at How to pay of " + coinName + " correctly!");
        }
    }

    public void verifyTextOnNFTBPage(String coin) {
        String[] contentExp = {CONST_NFTB_WHAT_IS_TITLE, CONST_NFTB_WHAT_IS_CONTENT, CONST_MISSION_TITLE, CONST_NFTB_MISSION_CONTENT};
        verifyWhatSection(contentExp);
        status = StringUtils.contains(CONST_NFTB_WHAT_IS_TITLE, getTextElement(driver, NFTB_WHAT_IS_TITLE));

        String[] useCaseContent = {CONST_NFTB_USE_CASE_CONTENT1, CONST_NFTB_USE_CASE_CONTENT2, CONST_NFTB_USE_CASE_CONTENT3, CONST_NFTB_USE_CASE_CONTENT4};
        String[] useCaseItemTitle = {CONST_NFTB_USE_CASE_ITEM_TITLE1, CONST_NFTB_USE_CASE_ITEM_TITLE2, CONST_NFTB_USE_CASE_ITEM_TITLE3, CONST_NFTB_USE_CASE_ITEM_TITLE4};
        verifyUseCase(NFTB_USE_CASE_ITEM_TITLE, NFTB_USE_CASE_ITEM_CONTENT, useCaseContent, useCaseItemTitle);

        String[] howToPay = {CONST_HOW_TO_PAY1, CONST_HOW_TO_PAY2, CONST_HOW_TO_PAY3, CONST_HOW_TO_PAY4, CONST_HOW_TO_PAY5, CONST_HOW_TO_PAY6};
        verifyPaySectionOnNFTBPage(coin, howToPay);

        String[] nameTeam = {CONST_NFTB_TEAM_ITEM_TITLE1, CONST_NFTB_TEAM_ITEM_TITLE2};
        String[] positionTeam = {CONST_NFTB_TEAM_ITEM_POSITION1, CONST_NFTB_TEAM_ITEM_POSITION2};
        String[] desTeam = {CONST_NFTB_TEAM_ITEM_DES1, CONST_NFTB_TEAM_ITEM_DES2, CONST_NFTB_TEAM_ITEM_DES3};
        verifyTeamName(nameTeam, positionTeam);
        verifyTeamDes(desTeam);

        String[] listTrades = {CONST_NFTB_TRADE_ICON_GATEIO, CONST_NFTB_TRADE_ICON_KUCOIN};

        verifyTradeSection(coin, listTrades);
        String[] listStores = {CONST_NFTB_STORE_ICON_TRUST_WALLET, CONST_NFTB_STORE_ICON_METAMASK, CONST_NFTB_STORE_ICON_WALLET_CONNECT, CONST_NFTB_STORE_ICON_MATH_WALLET};
        verifyStoreSection(coin, listStores);

        String[] titleFAQ = {CONST_NFTB_FAQ_TITLE1, CONST_NFTB_FAQ_TITLE2, CONST_NFTB_FAQ_TITLE3};
        String[] faqContent = {CONST_NFTB_FAQ_CONTENT1, CONST_NFTB_FAQ_CONTENT2, CONST_NFTB_FAQ_CONTENT3};
        verifyFAQSection(titleFAQ, faqContent);
        if (status) {
            System.out.println("All content at "+coin+" page correct! ");
        } else {
            System.out.println("Content at "+coin+" page wrong! ");
        }
    }
}



