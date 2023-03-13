package pages.hotel.footer.travala;

import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;
import pages.hotel.myProfile.MyTravelCreditsPage;

import static commons.CommonHotelURL.TRAVEL_CREDITS_PATH;
import static interfaces.hotel.footer.travala.TravelCreditPageUI.*;

public class TravelCreditPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public TravelCreditPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public MyTravelCreditsPage clickBuyTravelCreditBtn() {
    scrollToElement(driver, BUY_TRAVEL_CREDITS_BTN);
    clickToElement(driver, BUY_TRAVEL_CREDITS_BTN);
    return new MyTravelCreditsPage(driver);
  }

  public boolean verifyTextTravelCredits() {
    String[] content = {"TRAVEL_CREDITS_TITLE", "TRAVEL_CREDITS_BANNER", "TRAVEL_CREDITS_BANNER_SUB", "HELP_CREDIT_ANSWERS1",
      "TRAVEL_CREDITS_CONTENT_SUB2", "TRAVEL_CREDITS_BUY_TC_BTN"};
    String[] xpath = {TRAVEL_CREDITS_TITLE, TRAVEL_CREDITS_BANNER, TRAVEL_CREDITS_BANNER_SUB, TRAVEL_CREDITS_CONTENT_SUB1, TRAVEL_CREDITS_CONTENT_SUB2, BUY_TRAVEL_CREDITS_BTN};
    boolean verifyMainContent = verifyTwoListByKey(content, xpath);
    if (!verifyMainContent) {
      System.out.println("Text at Main Content wrong! ");
    }
    String[] question = {"TRAVEL_CREDITS_FAQ1", "TRAVEL_CREDITS_FAQ2", "TRAVEL_CREDITS_FAQ3"};
    boolean questionFAQ = verifyListItemByListExpect(question, TRAVEL_CREDITS_FAQ_LIST, TRAVEL_CREDITS_FAQ_DYNAMIC);
    if (!questionFAQ) {
      System.out.println(" FAQ Question Travel Credit wrong! ");
    }
    String[] answerFAQ = {"TRAVEL_CREDITS_FAQ1_ANSWERS", "TRAVEL_CREDITS_FAQ2_ANSWERS", "TRAVEL_CREDITS_FAQ3_ANSWERS"};
    boolean contentFAQ = verifyListItemByListExpect(answerFAQ, TRAVEL_CREDITS_FAQ_CONTENT_LIST, TRAVEL_CREDITS_FAQ_CONTENT_DYNAMIC);
    if (!contentFAQ) {
      System.out.println(" FAQ Content Travel Credit  wrong! ");
    }
    String[] section = {"TRAVEL_CREDITS_WHAT_ARE_TC", "TRAVEL_CREDITS_TERM", "TRAVEL_CREDITS_FAQ_QUESTION", "TRAVEL_CREDITS_HOW_GET_TC", "TRAVEL_CREDITS_HOW_USE_TC"};
    boolean sectionTitle = verifyListItemByListExpect(section, TRAVEL_CREDITS_SECTION_LIST, TRAVEL_CREDITS_SECTION_DYNAMIC);
    if (!sectionTitle) {
      System.out.println(" Title section Travel Credit wrong! ");
    }
    String[] sectionExp = {"TRAVEL_CREDITS_SECTION_CONTENT1", "TRAVEL_CREDITS_SECTION_CONTENT2", "TRAVEL_CREDITS_SECTION_CONTENT3"};
    boolean sectionContent = verifyListItemByListExpect(sectionExp, TRAVEL_CREDITS_SECTION_CONTENT, TRAVEL_CREDITS_SECTION_CONTENT_DYNAMIC);
    if (!sectionContent) {
      System.out.println(" Title section Content Travel Credit wrong! ");
    }
    String[] contentTerm = {"TRAVEL_CREDITS_TERM1", "TRAVEL_CREDITS_TERM2", "TRAVEL_CREDITS_TERM3", "TRAVEL_CREDITS_TERM4", "TRAVEL_CREDITS_TERM5",
      "TRAVEL_CREDITS_TERM6", "TRAVEL_CREDITS_TERM7", "TRAVEL_CREDITS_TERM8", "TRAVEL_CREDITS_TERM9"};
    boolean termContent = verifyListItemByListExpect(contentTerm, TRAVEL_CREDITS_TERM_CONTENT_LIST, TRAVEL_CREDITS_TERM_CONTENT_DYNAMIC);
    if (!termContent) {
      System.out.println("Travel Credits Term Content wrong! ");
    }
    check = questionFAQ && verifyMainContent && contentFAQ && sectionTitle && sectionContent && termContent && verifyMenuStaticPage() && verifyUrlPage(TRAVEL_CREDITS_PATH);
    return check;
  }

}
