package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;
import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstILVPageEN.*;

public class ILVPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public ILVPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    String[] contentExp = {CONST_ILV_WHAT_IS_TITLE, CONST_ILV_WHAT_IS_CONTENT, CONST_ILV_MISSION_CONTENT, CONST_ILV_TEAM_CONTENT1};
   verifyWhatSection(contentExp);
    verifyMetaTitleOfCoinPage(CONST_ILV_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1,  COIN_BANNER_TITLE2);
    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    
    String[] nameTeam = {CONST_ILV_TEAM_ITEM_TITLE1, CONST_ILV_TEAM_ITEM_TITLE2, CONST_ILV_TEAM_ITEM_TITLE3, CONST_ILV_TEAM_ITEM_TITLE4};
    String[] positionTeam = {CONST_ILV_TEAM_ITEM_POSITION1, CONST_ILV_TEAM_ITEM_POSITION2, CONST_ILV_TEAM_ITEM_POSITION3, CONST_ILV_TEAM_ITEM_POSITION4};
    String[] desTeam = {CONST_ILV_TEAM_ITEM_DES1, CONST_ILV_TEAM_ITEM_DES2, CONST_ILV_TEAM_ITEM_DES3, CONST_ILV_TEAM_ITEM_DES4};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);

    String[] useCaseContent = {CONST_ILV_USE_CASE_CONTENT1, CONST_ILV_USE_CASE_CONTENT2, CONST_ILV_USE_CASE_CONTENT3};
//    verifyUseCase(useCaseContent);

    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_ILV_FAQ_TITLE1, CONST_ILV_FAQ_TITLE2, CONST_ILV_FAQ_TITLE3,CONST_ILV_FAQ_TITLE4};
    String[] faqContent = {CONST_ILV_FAQ_CONTENT1, CONST_ILV_FAQ_CONTENT2, CONST_ILV_FAQ_CONTENT3,CONST_ILV_FAQ_CONTENT4};
    verifyFAQSection(titleFAQ, faqContent);


  }


  public void verifyTextOnILVPage(String coinName) {
//    openNewTab(driver, "https://travala-pr-2136.herokuapp.com/payment/illuvium-ilv");

//    verifyNavigatePageFromLink();
    verifyTextOnThePage(coinName);
  }
}
