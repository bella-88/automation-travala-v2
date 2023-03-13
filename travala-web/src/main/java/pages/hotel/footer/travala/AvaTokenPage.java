package pages.hotel.footer.travala;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.travala.AvaTokenPageUI.*;

import java.util.List;

import commons.hotel.CommonHotelPages;
public class AvaTokenPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public AvaTokenPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyAVATokenPage(String coin) {
    jsWaitForPageToLoad(driver, 3000);
    boolean flag = true;
    String[] bannerContentActivities = {"AVA_TOKEN_PAGE_BANNER_TITLE_ACTIVITIES", "AVA_TOKEN_PAGE_BANNER_SUB_TITLE_ACTIVITIES"};
    String[] bannerContentFlights = {"AVA_TOKEN_PAGE_BANNER_TITLE_FLIGHTS", "AVA_TOKEN_PAGE_BANNER_SUB_TITLE_FLIGHTS"};
    String[] bannerContentStays = {"AVA_TOKEN_PAGE_BANNER_TITLE_STAYS", "AVA_TOKEN_PAGE_BANNER_SUB_TITLE_STAYS"};
    String[] listXpathOfBannerContent = {AVA_BANNER_TITLE, AVA_BANNER_SUB_TITLE};
    clickToElementByJavascript(driver, AVA_SEARCH_TAB_ACTIVITIES);
    wait5sTime();
    wait5sTime();
    boolean isBannerContentActivities = verifyTwoListByKey(bannerContentActivities, listXpathOfBannerContent);
    clickToElementByJavascript(driver, AVA_SEARCH_TAB_FLIGHTS);
    wait5sTime();
    wait5sTime();
    boolean isBannerContentFlights = verifyTwoListByKey(bannerContentFlights, listXpathOfBannerContent);
    clickToElementByJavascript(driver, AVA_SEARCH_TAB_STAYS);
    wait5sTime();
    wait5sTime();
    boolean isBannerContentStays = verifyTwoListByKey(bannerContentStays, listXpathOfBannerContent);

    String[] contentInSearchBar = {"AVA_TOKEN_PAGE_SEARCH_TAB_ACTIVITIES", "AVA_TOKEN_PAGE_SEARCH_TAB_FLIGHTS", "AVA_TOKEN_PAGE_SEARCH_TAB_STAYS", "AVA_TOKEN_PAGE_SEARCH_BUTTON"};
    String[] listXpathsOfSearchBar = {AVA_SEARCH_TAB_ACTIVITIES, AVA_SEARCH_TAB_FLIGHTS, AVA_SEARCH_TAB_STAYS, AVA_SEARCH_BUTTON};
    boolean isNameDomains = verifyTwoListByKey(contentInSearchBar, listXpathsOfSearchBar);

    String[] contentInWhatIsAVA = {"AVA_TOKEN_PAGE_WHAT_IS_TITLE", "AVA_TOKEN_PAGE_WHAT_IS_DESC", "AVA_TOKEN_PAGE_CURRENT_PRICE", "AVA_TOKEN_PAGE_MARKET_CAP", "AVA_TOKEN_PAGE_CIRCULATING_SUPPLY", "AVA_TOKEN_PAGE_TOTAL_SUPPLY"};
    String[] listXpathsOfWhatIsAVA = {AVA_WHAT_TITLE, AVA_WHAT_CONTENT, AVA_CURRENT_PRICE, AVA_MARKET_CAP, AVA_CIRCULATING_SUPPLY, AVA_TOTAL_SUPPLY};
    boolean isContentInWhatIsAVA = verifyTwoListByKey(contentInWhatIsAVA, listXpathsOfWhatIsAVA);

    String[] contentInMission = {"AVA_TOKEN_PAGE_MISSION_TITLE", "AVA_TOKEN_PAGE_MISSION_DESC1", "AVA_TOKEN_PAGE_MISSION_DESC2"};
    String[] listXpathOfMission = {AVA_TITLE_MISSION, AVA_MISSION_CONTENT1, AVA_MISSION_CONTENT2};
    boolean isContentInMission = verifyTwoListByKey(contentInMission, listXpathOfMission);

    String[] contentInMarketAVA = {"AVA_TOKEN_PAGE_MARKET_TITLE", "AVA_TOKEN_PAGE_SOURCE_IN_MARKETS", "AVA_TOKEN_PAGE_PAIRS_IN_MARKETS", "AVA_TOKEN_PAGE_PRICE_IN_MARKETS", "AVA_TOKEN_PAGE_VOLUME_IN_MARKETS", "AVA_TOKEN_PAGE_SPREAD_IN_MARKETS", "AVA_TOKEN_PAGE_LAST_TRADED_IN_MARKETS", "AVA_TOKEN_PAGE_TRUST_SCORE_IN_MARKETS"};
    String[] listXpathOfMarkets = {AVA_MARKETS_TITLE, AVA_SOURCE_IN_MARKETS, AVA_PAIRS_IN_MARKETS, AVA_PRICE_IN_MARKETS, AVA_VOLUME_IN_MARKETS, AVA_SPREAD_IN_MARKETS, AVA_LAST_TRADED_IN_MARKETS, AVA_TRUST_SCORE_IN_MARKETS};
    boolean isContentInMarketAVA = verifyTwoListByKey(contentInMarketAVA, listXpathOfMarkets);

    String[] contentTravelBooking = {"AVA_TOKEN_PAGE_TRAVEL_BOOKINGS_TITLE_IN_AVA_USE_CASES", "AVA_TOKEN_PAGE_TRAVEL_BOOKINGS_DESC1_IN_AVA_USE_CASES", "AVA_TOKEN_PAGE_TRAVEL_BOOKINGS_DESC2_IN_AVA_USE_CASES"};
    String[] listXpathTravelBooking = {AVA_TRAVEL_BOOKING_TITLE, AVA_TRAVEL_BOOKING_DESC1, AVA_TRAVEL_BOOKING_DESC2};
    boolean isContentTravelBooking = verifyTwoListByKey(contentTravelBooking, listXpathTravelBooking);

    String[] contentTheSmartProgram = {"AVA_TOKEN_PAGE_SMART_PROGRAM_TITLE", "AVA_TOKEN_PAGE_SMART_PROGRAM_DESC"};
    String[] listXpathSmartProgram = {AVA_THE_SMART_PROGRAM_TITLE, AVA_THE_SMART_PROGRAM_DESC};
    boolean isContentTheSmartProgram = verifyTwoListByKey(contentTheSmartProgram, listXpathSmartProgram);

    String[] expectListTitleInSmartProgram = {"AVA_TOKEN_PAGE_SMART_DISCOUNTS_TITLE", "AVA_TOKEN_PAGE_SMART_LOYALTY_TITLE", "AVA_TOKEN_PAGE_PROOF_TRAVEL_TITLE", "AVA_TOKEN_PAGE_VOTING_RIGHTS_TITLE",
                                             "AVA_TOKEN_PAGE_EXCLUSIVE_ACCESS_TITLE", "AVA_TOKEN_PAGE_CONCIERGE_ACCESS_TITLE", "AVA_TOKEN_PAGE_AMBASSADOR_PROGRAM_TITLE", "AVA_TOKEN_PAGE_TRAVEL_DROPS_TITLE"};
    boolean isListTitleInSmartPrograme = verifyListItemByListExpect(expectListTitleInSmartProgram, AVA_THE_SMART_PROGRAM_TITLE_LIST, AVA_THE_SMART_PROGRAM_TITLE_DYNAMIC);

    String[] expectListContentInSmartProgram = {"AVA_TOKEN_PAGE_SMART_DISCOUNTS_DESC", "AVA_TOKEN_PAGE_SMART_LOYALTY_DESC", "AVA_TOKEN_PAGE_PROOF_TRAVEL_DESC", "AVA_TOKEN_PAGE_VOTING_RIGHTS_DESC",
                                              "AVA_TOKEN_PAGE_EXCLUSIVE_ACCESS_DESC", "AVA_TOKEN_PAGE_CONCIERGE_ACCESS_DESC", "AVA_TOKEN_PAGE_AMBASSADOR_PROGRAM_DESC", "AVA_TOKEN_PAGE_TRAVEL_DROPS_DESC"};
    boolean isListContentInSmartProgram = verifyListItemByListExpect(expectListContentInSmartProgram, AVA_THE_SMART_PROGRAM_CONTENT_LIST, AVA_THE_SMART_PROGRAM_CONTENT_DYNAMIC);

    String[] contentMoreUseCases = {"AVA_TOKEN_PAGE_MORE_USE_CASES_TITLE", "AVA_TOKEN_PAGE_MORE_USE_CASES_DESC"};
    String[] listXpathMoreUseCases = {AVA_MORE_TITLE, AVA_MORE_SUB_TITLE};
    boolean isContentMoreUseCase = verifyTwoListByKey(contentMoreUseCases, listXpathMoreUseCases);

    String[] expectListTitleInMoreUseCases = {"AVA_TOKEN_PAGE_SPEND_SHOP_TITLE", "AVA_TOKEN_PAGE_TRAVAL_ADS_TITLE", "AVA_TOKEN_PAGE_PAY_BILLS_TITLE", "AVA_TOKEN_PAGE_REVIEW_REWARDS_TITLE"};
    boolean isListTitleInMoreUseCases = verifyListItemByListExpect(expectListTitleInMoreUseCases, AVA_MORE_USE_CASE_TITLE_LIST, AVA_MORE_USE_CASE_TITLE_DYNAMIC);

    String[] expectListContentInMoreUseCases = {"AVA_TOKEN_PAGE_SPEND_SHOP_DESC", "AVA_TOKEN_PAGE_TRAVAL_ADS_DESC", "AVA_TOKEN_PAGE_PAY_BILLS_DESC", "AVA_TOKEN_PAGE_REVIEW_REWARDS_DESC"};
    boolean isListContentInMoreUseCases = verifyListItemByListExpect(expectListContentInMoreUseCases, AVA_MORE_USE_CASE_CONTENT_LIST, AVA_MORE_USE_CASE_CONTENT_DYNAMIC);

    String[] expectListContentInHowToPay = {"AVA_TOKEN_PAGE_HOW_TO_PAY_STEP1", "AVA_TOKEN_PAGE_HOW_TO_PAY_STEP2", "AVA_TOKEN_PAGE_HOW_TO_PAY_STEP3", "AVA_TOKEN_PAGE_HOW_TO_PAY_STEP4", "AVA_TOKEN_PAGE_HOW_TO_PAY_STEP5", "AVA_TOKEN_PAGE_HOW_TO_PAY_STEP6"};
    boolean isListContentInHowToPay = verifyListItemByListExpect(expectListContentInHowToPay, AVA_HOW_TO_PAY_STEP_LIST, AVA_HOW_TO_PAY_STEP_DYNAMIC);

    String[] listTitle = {"AVA_TOKEN_PAGE_USE_CASES_TITLE", "AVA_TOKEN_PAGE_HOW_TO_PAY_TITLE", "AVA_TOKEN_PAGE_TRADE_TITLE", "AVA_TOKEN_PAGE_STORE_TITLE", "AVA_TOKEN_PAGE_FAQS_TITLE"};
    String[] xpathOfListTitle = {AVA_USE_CASE_TITLE, AVA_HOW_TO_PAY_TITLE, AVA_TRADE_TITLE, AVA_STORE_TITLE, AVA_FAQS_TITLE};
    boolean isListTitle = verifyTwoListByKey(listTitle, xpathOfListTitle);

    String[] listContentInTradeAndStore = {"AVA_TOKEN_PAGE_TRADE_DESC", "AVA_TOKEN_PAGE_STORE_DESC1", "AVA_TOKEN_PAGE_STORE_DESC2"};
    String[] xpathOfListContentInTradeAndStore = {AVA_TRADE_SUB, AVA_STORE_SUB1, AVA_STORE_SUB2};
    boolean isListContentInTradeAndStore = verifyTwoListByKey(listContentInTradeAndStore, xpathOfListContentInTradeAndStore);
    boolean isFAQS = verifyContentFAQInAVAPage();

    flag = isBannerContentActivities && isBannerContentFlights && isBannerContentStays && isNameDomains
            && isContentInWhatIsAVA && isContentInMission && isContentInMarketAVA
            && isContentTravelBooking && isContentTheSmartProgram && isListTitleInSmartPrograme && isListContentInSmartProgram
            && isContentMoreUseCase && isListTitleInMoreUseCases && isListContentInMoreUseCases && isListContentInHowToPay
            && isListTitle && isListContentInTradeAndStore && isFAQS;
    if(flag) {
      System.out.println("Content of AVA Page CORRECTLY");
    } else {
      System.out.println("Content of AVA Page INCORRECTLY");
    }
  }

  private boolean verifyContentFAQInAVAPage() {
    boolean flag = true;
    String[] expectListQuestion = {"AVA_TOKEN_PAGE_FAQS_QUESTION1", "AVA_TOKEN_PAGE_FAQS_QUESTION2", "AVA_TOKEN_PAGE_FAQS_QUESTION3", "AVA_TOKEN_PAGE_FAQS_QUESTION4"};
    flag = verifyListItemByListExpect(expectListQuestion, AVA_FAQS_QUESTION_LIST, AVA_FAQS_QUESTION_DYNAMIC);
    List<WebElement> elements = driver.findElements(By.xpath(AVA_FAQS_QUESTION_LIST));
    for (int i=0; i<elements.size(); i++) {
      WebElement element = driver.findElement(By.xpath(String.format(AVA_FAQS_QUESTION_LIST, String.valueOf(i+1))));
      element.click();
    }
    String[] expectListAnswer = {"AVA_TOKEN_PAGE_FAQS_ANSWER1", "AVA_TOKEN_PAGE_FAQS_ANSWER2", "AVA_TOKEN_PAGE_FAQS_ANSWER3", "AVA_TOKEN_PAGE_FAQS_ANSWER4"};
    flag = verifyListItemByListExpect(expectListAnswer, AVA_FAQS_ANSWER_LIST, AVA_FAQS_ANSWER_DYNAMIC);
    if(flag) {
      System.out.println("Content FAQs in AVA Page correctly");
    } else {
      System.out.println("Content FAQs in AVA Page incorrectly");
    }
    return flag;
  }

}
