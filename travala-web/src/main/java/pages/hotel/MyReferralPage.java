package pages.hotel;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static interfaces.hotel.MyRefferalPageUI.*;


public class MyReferralPage extends CommonHotelPages {
  WebDriver driver;
  private static WebElement element1 = null;

  public MyReferralPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyReferralPage() {
    String[] contentP = {"MY_REFERRAL_POPUP_TITLE", "MY_REFERRAL_POPUP_CONTENT", "POPUP_OK_BTN"};
    String[] xpathP = {MY_REFERRAL_POPUP_TITLE, MY_REFERRAL_POPUP_CONTENT, MY_REFERRAL_POPUP_BUTTON};
    verifyTwoListByKey(contentP, xpathP);
    clickToElementByJavascript(driver,MY_REFERRAL_POPUP_BUTTON );

//       String[] content = {"MY_REFERRAL_TITLE", "MY_REFERRAL_SUB", "MY_REFERRAL_REGISTER_BTN", "MY_REFERRAL_EXPIRE_TXT",  "Invite_TITLE2",
//      "INVITE_WORK_TITLE1", "MY_REFERRAL_HOW_IT_WORK_REGISTER_CONTENT", "INVITE_WORK_TITLE2", "MY_REFERRAL_HOW_IT_WORK_BOOK_CONTENT",
//      "INVITE_WORK_TITLE3", "MY_REFERRAL_HOW_IT_WORK_REWARDED_CONTENT", "MY_REFERRAL_POP_UP_TITLE", "MY_REFERRAL_POP_UP_CONTENT"};
//    String[] xpath = {MY_REFERRAL_TITLE, MY_REFERRAL_SUB, MY_REFERRAL_REGISTER_BTN, MY_REFERRAL_EXPIRE_TXT, MY_REFERRAL_HOW_IT_WORK_TITLE,
//      MY_REFERRAL_HOW_IT_WORK_REGISTER, MY_REFERRAL_HOW_IT_WORK_REGISTER_CONTENT, MY_REFERRAL_HOW_IT_WORK_BOOK, MY_REFERRAL_HOW_IT_WORK_BOOK_CONTENT,
//      MY_REFERRAL_HOW_IT_WORK_REWARDED, MY_REFERRAL_HOW_IT_WORK_REWARDED_CONTENT, MY_REFERRAL_POP_UP_TITLE, MY_REFERRAL_POP_UP_CONTENT};
//    wait1sTime();
//    if (verifyTwoListByKey(content, xpath)&& verifyTextByKey("MY_REFERRAL_OFFER_TXT", MY_REFERRAL_OFFER_TXT)) {
//      System.out.println("Text on Referral Page is displayed correct");
//    } else {
//      System.out.println("Text on Referral Page is displayed wrong");
//    }
//    clickToElementByJavascript(driver, MY_REFERRAL_BTN);
  }

}
