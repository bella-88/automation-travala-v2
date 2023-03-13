package pages.hotel.footer.travala;

import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;

import static interfaces.hotel.footer.travala.AffiliateProgramPageUI.*;

public class AffiliateProgramPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public AffiliateProgramPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyContentTextAffiliateProgramePage() {
    switchToLanguage();
    return check = verifyBanner() && verifyWhatAndWhySections() && verifyWorkAndCommissionsAndFAQs();
  }

  private boolean verifyBanner() {
    String[] banner = {"AFFILIATE_PROGRAM_PAGE_BANNER_HEADING", "AFFILIATE_PROGRAM_PAGE_BANNER_SUB_HEADING1", "AFFILIATE_PROGRAM_PAGE_BANNER_SUB_HEADING2", "AFFILIATE_PROGRAM_PAGE_BANNER_SIGNUP_BUTTON"};
    String[] xpath = {AFFILIATE_BANNER_TXT_HEADING, AFFILIATE_BANNER_TXT_SUB_HEADING1, AFFILIATE_BANNER_TXT_SUB_HEADING2, AFFILIATE_SIGN_UP};

    check = verifyTwoListByKey(banner, xpath);;
    if (!check) {
      System.out.println("Text at banner affiliate wrong! ");
    }
    return check ;
  }

  private boolean verifyWhatAndWhySections() {
    String[] titles = {"AFFILIATE_PROGRAM_PAGE_WHAT_IS_AFFILIATE_HEADING", "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_HEADING"};
    String[] xpathOfTitle = {AFFILIATE_WHAT_IS_AFFILIATE_TITLE_TXT, AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_HEADING_TXT};
    boolean  isTitlesCorrectly = verifyTwoListByKey(titles, xpathOfTitle);

    String[] contentOfWhatIsAffiliate = {"AFFILIATE_PROGRAM_PAGE_WHAT_IS_AFFILIATE_DESC1", "AFFILIATE_PROGRAM_PAGE_WHAT_IS_AFFILIATE_DESC2", "AFFILIATE_PROGRAM_PAGE_WHAT_IS_AFFILIATE_DESC3"};
    boolean isContentOfWhatIsAffiliate = verifyListItemByListExpect(contentOfWhatIsAffiliate, AFFILIATE_WHAT_IS_AFFILIATE_CONTENT_TXT, AFFILIATE_WHAT_IS_AFFILIATE_CONTENT_TXT_DYNAMIC);


    String[] titleOfWhyJoinAffiliate = {"AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_TITLE1", "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_TITLE2"
            , "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_TITLE3", "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_TITLE4"};
    String[] contentOfWhyJoinAffiliate = {"AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_DESC1"
            , "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_DESC2", "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_DESC3", "AFFILIATE_PROGRAM_PAGE_WHY_IS_AFFILIATE_DESC4"};

    boolean isTitleOfWhyJoinAffiliate = verifyListItemByListExpect(titleOfWhyJoinAffiliate, AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_TXT_LIST, AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_TXT_DYNAMIC);
    boolean isContentOfWhyJoinAffiliate = verifyListItemByListExpect(contentOfWhyJoinAffiliate, AFFILIATE_WHY_JOIN_AFFILIATE_CONTENT_TXT_LIST, AFFILIATE_WHY_JOIN_AFFILIATE_CONTENT_TXT_DYNAMIC);
    check = isTitlesCorrectly && isContentOfWhatIsAffiliate && isTitleOfWhyJoinAffiliate && isContentOfWhyJoinAffiliate;
    if (!check) {
      System.out.println("Text at banner affiliate wrong! ");
    }
    return check;
  }

  private boolean verifyWorkAndCommissionsAndFAQs() {
    String[] titleHeading = {"AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_HEADING", "AFFILIATE_PROGRAM_PAGE_COMMISSIONS_HEADING", "AFFILIATE_PROGRAM_PAGE_FAQS_HEADING"};
    String[] xpathOfTitle = {AFFILIATE_HOW_DO_IT_WORK_HEADING, AFFILIATE_COMMISSIONS_HEADING, AFFILIATE_FAQS_HEADING};
    boolean  isTitlesCorrectly = verifyTwoListByKey(titleHeading, xpathOfTitle);

    String[] titleOfHowItWork = {"AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_TITLE1", "AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_TITLE2", "AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_TITLE3"};
    String[] contentTitleOfHowItWork = {"AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_DESC1", "AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_DESC2", "AFFILIATE_PROGRAM_PAGE_HOW_IT_WORK_DESC3"};
    boolean isTitleOfHowItWorkAffiliate = verifyListItemByListExpect(titleOfHowItWork, AFFILIATE_HOW_DO_IT_WORK_TITLE_TXT_LIST, AFFILIATE_HOW_DO_IT_WORK_TITLE_TXT_DYNAMIC);
    boolean isContentTitleOfHowItWorkAffiliate = verifyListItemByListExpect(contentTitleOfHowItWork, AFFILIATE_HOW_DO_IT_WORK_CONTENT_TXT_LIST, AFFILIATE_HOW_DO_IT_WORK_CONTENT_TXT_LIST_DYNAMIC);

    String[] textInCommissions = {"AFFILIATE_PROGRAM_PAGE_COMMISSIONS_PARTER_LEVEL"
            , "AFFILIATE_PROGRAM_PAGE_COMMISSIONS_PERCENTAGE", "AFFILIATE_PROGRAM_PAGE_COMMISSIONS_GOLD_LEVEL", "AFFILIATE_PROGRAM_PAGE_COMMISSIONS_CONTENT2"};
    String[] xpathsOfContentInCommisstions = {AFFILIATE_COMMISSIONS_PARTNER_LEVEL, AFFILIATE_COMMISSIONS_COMMISSIONS_PERCENT
            , AFFILIATE_COMMISSIONS_GOLD_LEVEL, AFFILIATE_COMMISSIONS_CONTENT_TXT_2};
    boolean  isContentCommissionsAffiliate = verifyTwoListByKey(textInCommissions, xpathsOfContentInCommisstions);

    String[] listQuestion = {"AFFILIATE_PROGRAM_PAGE_FAQS_TITLE1", "AFFILIATE_PROGRAM_PAGE_FAQS_TITLE2", "AFFILIATE_PROGRAM_PAGE_FAQS_TITLE3"};
    boolean  isQuestionCorrectly = verifyListItemByListExpect(listQuestion, AFFILIATE_FAQS_TITLE_TXT_LIST, AFFILIATE_FAQS_TITLE_TXT_DYNAMIC);

    String[] listAnswer = {"AFFILIATE_PROGRAM_PAGE_FAQS_DESC1", "AFFILIATE_PROGRAM_PAGE_FAQS_DESC2", "AFFILIATE_PROGRAM_PAGE_FAQS_DESC3"};
    boolean  isAnswerCorrectly = verifyListItemByListExpect(listAnswer, AFFILIATE_FAQS_CONTENT_TXT_LIST, AFFILIATE_FAQS_CONTENT_TXT_DYNAMIC);

    check = isTitlesCorrectly && isTitleOfHowItWorkAffiliate && isContentTitleOfHowItWorkAffiliate && isContentCommissionsAffiliate
            && isQuestionCorrectly && isAnswerCorrectly;
    if (!check) {
      System.out.println("Text at How do it work and commissions affiliate wrong! ");
    }
    return check;
  }
}
