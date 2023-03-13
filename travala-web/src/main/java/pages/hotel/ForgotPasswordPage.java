package pages.hotel;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.ForgotPasswordPageUI.*;


public class ForgotPasswordPage extends CommonHotelPages {
  WebDriver driver;


  public ForgotPasswordPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextForgotPassword() {
    boolean email = StringUtils.contains(getAttribute(driver, FORGOT_PASSWORD_EMAIL, "placeholder"), getTextFromReadFile("FORGOT_PASSWORD_EMAIL"));
    String[] content = {"FORGOT_PASSWORD_TITLE", "FORGOT_PASSWORD_SUB", "FORGOT_PASSWORD_RESET_BTN"};
    String[] xpath = {FORGOT_PASSWORD_TITLE, FORGOT_PASSWORD_SUB, FORGOT_PASSWORD_RESET_BTN};
    if (!email ||  !verifyTwoListByKey(content, xpath)) {
      System.out.println("ACTUAL: "+ getAttribute(driver, FORGOT_PASSWORD_EMAIL, "placeholder"));
      System.out.println("EXPECT: "+ getTextFromReadFile("FORGOT_PASSWORD_EMAIL"));
      System.out.println("Text forgot password wrong! ");
    }
  }

  public void inputEmailToForgotPassword(String email) {
    sendkeysToElement(driver, FORGOT_PASSWORD_EMAIL, email);
    clickToElementByJavascript(driver, FORGOT_PASSWORD_RESET_BTN);
//    boolean b = StringUtils.contains(getTextElement(driver, FORGOT_PASSWORD_NOTICE_SENT), getTextFromReadFile("FORGOT_PASSWORD_NOTICE_SENT"));
//    boolean b1 = StringUtils.contains(getTextElement(driver, FORGOT_PASSWORD_BACK_TO_PREVIOUS), getTextFromReadFile("FORGOT_PASSWORD_BACK_TO_PREVIOUS"));
//    if (!(b && b1)) {
//      System.out.println("Forgot password not success");
//    }
  }
}
