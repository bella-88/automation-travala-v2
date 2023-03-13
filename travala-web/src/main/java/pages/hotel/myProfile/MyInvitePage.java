package pages.hotel.myProfile;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static interfaces.hotel.myProfile.MyInvitePageUI.*;

public class MyInvitePage extends CommonHotelPages {
  WebDriver driver;
  private static WebElement element1 = null;

  public MyInvitePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyInvitePeople() {
    String[] content = {"MY_INVITE_LINK_TITLE", "MY_INVITE_LINK_SUB", "MY_INVITE_REGISTERED", "MY_INVITE_EARNED", "MY_INVITE_INVITE_PEOPLE",
      "MY_INVITE_INVITE_DETAILS", "MY_INVITE_PEOPLE_TITLE_MAIN", "Invite_BANNER_TITLE2", "MY_INVITE_PEOPLE_CONTENT", "MY_INVITE_PEOPLE_EMAIL_TXT",
      "MY_INVITE_PEOPLE_SEND_INVITE", "MY_INVITE_PEOPLE_SHARE", "Invite_TITLE2", "INVITE_WORK_TITLE1", "INVITE_WORK_CONTENT1", "INVITE_WORK_TITLE2",
      "INVITE_WORK_CONTENT2", "INVITE_WORK_TITLE3", "INVITE_WORK_CONTENT3", "MY_INVITE_PEOPLE_TERM"};
    String[] xpath = {MY_INVITE_LINK_TITLE, MY_INVITE_LINK_SUB, MY_INVITE_REGISTERED, MY_INVITE_EARNED, MY_INVITE_INVITE_PEOPLE,
      MY_INVITE_INVITE_DETAILS, MY_INVITE_PEOPLE_TITLE_MAIN, MY_INVITE_PEOPLE_SUB_MAIN, MY_INVITE_PEOPLE_CONTENT, MY_INVITE_PEOPLE_EMAIL_TXT, MY_INVITE_PEOPLE_SEND_INVITE_BTN,
      MY_INVITE_PEOPLE_SHARE, MY_INVITE_PEOPLE_HOW_IT_WORKS, MY_INVITE_PEOPLE_REGISTER, MY_INVITE_PEOPLE_REGISTER_CONTENT, MY_INVITE_PEOPLE_BOOK, MY_INVITE_PEOPLE_BOOK_CONTENT,
      MY_INVITE_PEOPLE_GET_REWARD, MY_INVITE_PEOPLE_GET_REWARD_CONTENT, MY_INVITE_PEOPLE_TERM};
    wait1sTime();
    if (!(verifyTwoListByKey(content, xpath) && verifyTextByKey("MY_INVITE_INVITEE", MY_INVITE_INVITEE))) {
      System.out.println("Text at Invite People wrong! ");
    }
  }

  public void verifyInviteDetail() {
    clickToElementByJavascript(driver, MY_INVITE_INVITE_DETAILS);
    if (!verifyTextByKey("MY_INVITE_DETAIL_NO_HAVE_INVITE", MY_INVITE_NO_INVITES)) {
      System.out.println("Text at Invite Detail wrong! ");
    }
    clickToElementByJavascript(driver, MY_INVITE_INVITE_PEOPLE);
  }

  public void sendEmailToInvite(String email) {
    sendkeysToElement(driver, MY_INVITE_PEOPLE_EMAIL_HOLDER, email);
    clickToElementByJavascript(driver, MY_INVITE_SEND_INVITE_BTN);
  }

  public void verifyValidEmailInvite() {
    sendEmailToInvite(randomString());
    String[] contentP = {"POPUP_ERROR_TITLE", "POP_UP_INVALID_EMAIL", "POPUP_OK_BTN"};
    String[] xpathP = {MY_INVITE_PEOPLE_POPUP_TITLE, MY_INVITE_PEOPLE_POPUP_CONTENT, MY_INVITE_PEOPLE_POPUP_ERROR_OK};
    boolean invalid = verifyTwoListByKey(contentP, xpathP);
    clickToElementByJavascript(driver, MY_INVITE_PEOPLE_POPUP_ERROR_OK);
    sendEmailToInvite(randomYopMail());
    String[] contentValidP = {"MY_INVITE_POPUP_SUCCESS_TITLE", "MY_INVITE_POPUP_SUCCESS_CONTENT", "POPUP_OK_BTN"};
    boolean success = verifyTwoListByKey(contentValidP, xpathP);
    for (int i = 1; i <= 4; i++) {
      sendEmailToInvite(randomYopMail());
    }
    String[] invite5 = {"MY_INVITE_POPUP_SUCCESS_TITLE", "MY_INVITE_SEND_EMAIL_5_TIMES", "POPUP_OK_BTN"};
    boolean invite5Times = verifyTwoListByKey(invite5, xpathP);
    if (!invite5Times) {
      System.out.println("Content Message when invite greater than 5 times per day wrong");
    }
    clickToElementByJavascript(driver, MY_INVITE_PEOPLE_POPUP_ERROR_OK);
    if (invalid && success && invite5Times) {
      System.out.println("Content popup when input email invite correct!");
    } else {
      System.out.println("Content popup when input email invite wrong!");
    }
  }

  public void verifyNavigateLink() {
    boolean social = verifyLinkToPageFromListUrl(MY_INVITE_SOCIAL_LIST, MY_INVITE_SOCIAL_DYNAMIC);
    boolean url = verifyLinkToPageFromUrl(MY_INVITE_TERM_URL);
    if (social && url) {
      System.out.println("Link Social Icon form my Invite Correct!");
    } else {
      System.out.println("Link Social Icon form my Invite Wrong!");
    }

  }

  public String openReferralPage() {
//    String path = getTextBySplitLimitSegment(getAttribute(driver, MY_INVITE_PEOPLE_REFERRAL_LINK, "value"), "ref/", 1);
//    String domain = getTextBySplitLimitSegment(getCurrentUrl(driver), "/my", 0);
    String referralLink = getTextBySplitLimitSegment(getCurrentUrl(driver), "/my", 0) + "/ref/" + getTextBySplitLimitSegment(getAttribute(driver, MY_INVITE_PEOPLE_REFERRAL_LINK, "value"), "ref/", 1);

    return referralLink;
  }
}
