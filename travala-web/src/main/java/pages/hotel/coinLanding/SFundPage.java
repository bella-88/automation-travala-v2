package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;
import static commons.CommonHotelXpath.*;
import static constants.hotel.contentCoinPage.ConstCoinPage.*;
import static constants.hotel.contentCoinPage.ConstSFundPageEN.*;

public class SFundPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public SFundPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1,  COIN_BANNER_TITLE2);
    verifyMetaTitleOfCoinPage(CONST_SFUND_FULL_NAME);
    verifyMarketLabel();
    verifyTextByConst(CONST_SFUND_WHAT_IS_TITLE,COIN_WHAT_IS_TITLE);
    verifyTextByConst(CONST_SFUND_MISSION_CONTENT,COIN_MISSION_CONTENT);
    verifyTextByConst(CONST_SFUND_WHAT_IS_CONTENT,COIN_WHAT_IS_CONTENT);
    verifyPaySection(coinName);
//    verifyTitleSection(coinName);
    String[] nameTeam = {CONST_SFUND_TEAM_ITEM_TITLE1};
    String[] positionTeam = {CONST_SFUND_TEAM_ITEM_POSITION1};
    String[] desTeam = {CONST_SFUND_TEAM_ITEM_DES1};
    verifyTeamName(nameTeam, positionTeam);
    verifyTeamDes(desTeam);
    String[] useCaseContent = {CONST_SFUND_USE_CASE_CONTENT1, CONST_SFUND_USE_CASE_CONTENT2, CONST_SFUND_USE_CASE_CONTENT3,CONST_SFUND_USE_CASE_CONTENT4, CONST_SFUND_USE_CASE_CONTENT5};
//    verifyUseCase(useCaseContent);
    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_SFUND_FAQ_TITLE1, CONST_SFUND_FAQ_TITLE2, CONST_SFUND_FAQ_TITLE3};
    String[] faqContent = {CONST_SFUND_FAQ_CONTENT1, CONST_SFUND_FAQ_CONTENT2, CONST_SFUND_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);

  }

  public void verifyTextOnSFundPage(String coinName) {
//    openNewTab(driver, "https://travala-pr-2141.herokuapp.com/payment/sfund");
    verifyTextOnThePage(coinName);

  }
}
