package pages.hotel.footer.travala;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonsTravalaXpath.LOGIN_ICON_HEADER;
import static interfaces.hotel.footer.travala.SmartPageUI.*;

public class SmartProgramPage extends CommonHotelPages {
  WebDriver driver;

  public SmartProgramPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextLandingSmart() {
    String[] titleExp = {"SMART_INTRO_TITLE", "SMART_INTRO_TITLE2"};
    boolean title = compareTwoListByKey(titleExp, INTRO_TITLE);
    if(!title){
      System.out.println("Title Landing Smart Wrong");
    }
    String[] subTitleExp = {"SMART_INTRO_SUB_TITLE1", "SMART_INTRO_SUB_TITLE2"};
    boolean subTitle = compareTwoListByKey(subTitleExp, INTRO_SUB_TITLE);
    if(!subTitle){
      System.out.println("Sub Title Landing Smart Wrong");
    }
    String[] titleContentExp = {"SMART_INTRO_CONTENT_TITLE1", "SMART_INTRO_CONTENT_TITLE2", "SMART_INTRO_CONTENT_TITLE3", "SMART_INTRO_CONTENT_TITLE4"};
    boolean titleContent = compareTwoListByKey(titleContentExp, INTRO_CONTENT);
    if(!titleContent){
      System.out.println("Title Content Landing Smart Wrong");
    }
    String[] benefitTitleExp = {"SMART_INTRO_BENEFIT_TITLE1", "SMART_INTRO_BENEFIT_TITLE2", "SMART_INTRO_BENEFIT_TITLE3", "SMART_INTRO_BENEFIT_TITLE8",
      "SMART_INTRO_BENEFIT_TITLE4", "SMART_INTRO_BENEFIT_TITLE5", "SMART_INTRO_BENEFIT_TITLE6", "SMART_INTRO_BENEFIT_TITLE7", "SMART_INTRO_BENEFIT_TITLE9"};
    boolean benefitTitle = compareTwoListByKey(benefitTitleExp, INTRO_BENEFIT_TITLE);
    if(!benefitTitle){
      System.out.println("Benefit Title Landing Smart Wrong");
    }
    String[] benefitContentExp = {"SMART_INTRO_BENEFIT_CONTENT1", "SMART_INTRO_BENEFIT_CONTENT2", "SMART_INTRO_BENEFIT_CONTENT3", "SMART_INTRO_BENEFIT_CONTENT8",
      "SMART_INTRO_BENEFIT_CONTENT4", "SMART_INTRO_BENEFIT_CONTENT5", "SMART_INTRO_BENEFIT_CONTENT6", "SMART_INTRO_BENEFIT_CONTENT7", "SMART_INTRO_BENEFIT_CONTENT9"};
    boolean benefitContent = compareTwoListByKey(benefitContentExp, INTRO_BENEFIT_CONTENT);
    if(!benefitContent){
      System.out.println("Benefit Content Landing Smart Wrong");
    }
//    System.out.println("title: "+ title);
//    System.out.println("subTitle: "+ subTitle);
//    System.out.println("titleContent: "+ titleContent);
//    System.out.println("benefitTitle: "+ benefitTitle);
//    System.out.println("benefitContent: "+ benefitContent);
//    System.out.println("verifyFAQSmart: "+ verifyFAQSmart());
//    System.out.println("verifyTableContent: "+ verifyTableContent());
    boolean check = title && subTitle && titleContent && benefitTitle && benefitContent && verifyFAQSmart() && verifyTableContent();
    if (!check) {
      System.out.println("Content Landing Smart wrong");
    } else {
      System.out.println("Content Landing Smart correct");
    }
  }

  public boolean verifyFAQSmart() {
    String[] question = {"Smart_QUESTION1", "Smart_QUESTION2", "Smart_QUESTION3", "Smart_QUESTION4"};
    String[] answers = {"SMART_CONTENT3", "Smart_ANSWERS1", "Smart_ANSWERS2", "Smart_ANSWERS4"};
    String[] content = {"Smart_FAQS_SMART_PROGRAM", "Smart_ACTIVE_BOOK_STAY", "Smart_JOIN_US_BTN", "Smart_JOIN_US_SUB", "Smart_JOIN_US_LINK"};
    String[] xpath = {FAQS_SMART_PROGRAM, ACTIVE_BOOK_STAY, SMART_PROGRAM_BTN, JOIN_US_SUB, SMART_PROGRAM_TERM_LINK};
    boolean faqSmartQuestion = verifyListItemByListExpect(question, FAQS_SMART_PROGRAM_QUESTION_LIST, FAQS_SMART_PROGRAM_QUESTION_DYNAMIC);
    if (!faqSmartQuestion) {
      System.out.println("Question on FAQs SMART PROGRAM wrong");
    }
    boolean faqSmartContent = verifyListItemByListExpect(answers, FAQS_SMART_ANSWERS_LIST, FAQS_SMART_ANSWERS_DYNAMIC);
    if (!faqSmartContent) {
      System.out.println("Answers on FAQs SMART PROGRAM wrong");
    }
    boolean faq = verifyTwoListByKey(content, xpath) && faqSmartQuestion && faqSmartContent;
    if (!faq) {
      System.out.println(" FAQs SMART PROGRAM wrong");
    }
    return faq;
  }


  public void clickSmartBtn() {
    if(checkShowElement(driver,LOGIN_ICON_HEADER)!=0){
      clickToElement(driver, SMART_PROGRAM_SMART_NOW_BTN);
      if(!StringUtils.contains(getCurrentUrl(driver),"login")){
        System.out.println("Link page from landing smart wrong ");
      }
    }
  }

}
