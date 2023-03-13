package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelXpath.COIN_FAQ_QUESTION;
import static constants.hotel.contentCoinPage.ConstXNOPageEN.*;



public class NANOPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public NANOPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage(String coinName) {
    verifyMetaTitleOfCoinPage(CONST_NANO_FULL_NAME);
//    verifyTextBanner(coinName, COIN_BANNER_TITLE1, COIN_BANNER_TITLE2);
    verifyMarketLabel();
    verifyPaySection(coinName);
//    verifyTitleSection(CONST_NANO_FULL_NAME);
//,CONST_NANO_DISTRIBUTION, CONST_NANO_DISTRIBUTION_CONTENT, ,NANO_DISTRIBUTION_TITLE,NANO_DISTRIBUTION_CONTENT
    String[] nameTeam = {CONST_NANO_TEAM_ITEM_TITLE1, CONST_NANO_TEAM_ITEM_TITLE2};
    String[] positionTeam = {CONST_NANO_TEAM_ITEM_POSITION1, CONST_NANO_TEAM_ITEM_POSITION2};
    verifyTeamName(nameTeam, positionTeam);
    String[] teamContent = {CONST_NANO_TEAM_CONTENT1, CONST_NANO_TEAM_CONTENT3};
    verifyTeamDes(teamContent);
    String[] useCaseContent = {CONST_NANO_USE_CASE_CONTENT1, CONST_NANO_USE_CASE_CONTENT2, CONST_NANO_USE_CASE_CONTENT3, CONST_NANO_USE_CASE_CONTENT4,
      CONST_NANO_USE_CASE_CONTENT5, CONST_NANO_USE_CASE_CONTENT6};
    verifyMoreUseCase(useCaseContent);
    String[] useCaseTitle = {CONST_NANO_USE_CASE_TITLE1, CONST_NANO_USE_CASE_TITLE2, CONST_NANO_USE_CASE_TITLE3, CONST_NANO_USE_CASE_TITLE4,
      CONST_NANO_USE_CASE_TITLE5, CONST_NANO_USE_CASE_TITLE6};


    clickToListElement(driver, COIN_FAQ_QUESTION);
    String[] titleFAQ = {CONST_NANO_FAQ_TITLE1, CONST_NANO_FAQ_TITLE2, CONST_NANO_FAQ_TITLE3};
    String[] faqContent = {CONST_NANO_FAQ_CONTENT1, CONST_NANO_FAQ_CONTENT2, CONST_NANO_FAQ_CONTENT3};
    verifyFAQSection(titleFAQ, faqContent);
  }

  public void verifyTextOnNanoPage(String coinName) {
//    openNewTab(driver, "https://travala-pr-2120.herokuapp.com/payment/nano-xno");
    verifyTextOnThePage(coinName);
  }
}
