package pages.hotel.footer.travala;

import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;

import static interfaces.hotel.footer.travala.InvitePageUI.*;

public class InviteProgramPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public InviteProgramPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }


  public void verifyTextInvite() {
    String[] title = {"Invite_TITLE1", "Invite_TITLE2", "Invite_TITLE3"};
    boolean bTitle = compareTwoListByKey(title, INVITE_TITLE);
    if (!bTitle) {
      System.out.println("Title on the page wrong");
    }
    String[] benefitTitle = {"INVITE_BENEFITS_1", "INVITE_BENEFITS_2", "INVITE_BENEFITS_3"};
    boolean bBenefitTitle = compareTwoListByKey(benefitTitle, INVITE_BENEFIT_TITLE);
    if (!bBenefitTitle) {
      System.out.println("Title of benefit on the page wrong");
    }
    String[] benefitTContent = {"INVITE_BENEFITS_1_CONTENT", "INVITE_BENEFITS_2_CONTENT", "INVITE_BENEFITS_3_CONTENT"};
    boolean bBenefitContent = compareTwoListByKey(benefitTContent, INVITE_BENEFIT_CONTENT);
    if (!bBenefitTitle) {
      System.out.println("Title of benefit on the page wrong");
    }
    String[] workTitle = {"INVITE_WORK_TITLE1", "INVITE_WORK_TITLE2", "INVITE_WORK_TITLE3"};
    boolean bWorkTitle = compareTwoListByKey(workTitle, INVITE_WORK_TITLE);
    if (!bWorkTitle) {
      System.out.println("Work Title on the page wrong");
    }
    String[] workContent = {"INVITE_WORK_CONTENT1", "INVITE_WORK_CONTENT2", "INVITE_WORK_CONTENT3"};
    boolean bWorkContent = compareTwoListByKey(workContent, INVITE_WORK_CONTENT);
    if (!bWorkContent) {
      System.out.println("Work content on the page wrong");
    }
    String[] question = {"INVITE_QUESTION1", "INVITE_QUESTION2", "INVITE_QUESTION3", "INVITE_QUESTION4"};
    boolean bQuestion = compareTwoListByKey(question, FREQUENTLY_QUESTION);
    if (!bQuestion) {
      System.out.println("Question on the page wrong");
    }
    String[] answers = {"Invite_FREQUENTLY_QUESTION1_ANSWERS", "HELP_INVITE_ANSWERS2", "Invite_FREQUENTLY_QUESTION3_ANSWERS", "Invite_FREQUENTLY_QUESTION4_ANSWERS"};
    boolean bAnswers = compareTwoListByKey(answers, FREQUENTLY_ANSWERS);
    if (!bAnswers) {
      System.out.println("Answers on the page wrong");
    }
    String[] content = {"Invite_BANNER_TITLE1", "Invite_BANNER_TITLE2", "Invite_BANNER_TITLE3", "INVITE_CATION", "INVITE_FOOTER_TXT1",
      "INVITE_FOOTER_BTN", "INVITE_FOOTER_TXT2", "INVITE_FOOTER_TERM"};
    String[] xpath = {INVITE_BANNER1, INVITE_BANNER2, INVITE_BANNER3, INVITE_CATION, INVITE_FOOTER_TXT1, INVITE_FOOTER_BTN,
      INVITE_FOOTER_TXT2, INVITE_FOOTER_TERM};
    boolean b = verifyTwoListByKey(content, xpath);
    if (!b) {
      System.out.println("Text on the page wrong");
    }
    check = bTitle && bBenefitTitle && bBenefitContent && bWorkTitle && bWorkContent && bQuestion && bAnswers && b;
    if (check) {
      System.out.println("Text at Invite page correct! ");
    } else {
      System.out.println("Text at Invite page wrong! ");
    }
  }


}
