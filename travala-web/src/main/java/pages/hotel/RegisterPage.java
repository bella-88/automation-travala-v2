package pages.hotel;

import com.mashape.unirest.http.exceptions.UnirestException;
//import interfaces.LoginRegisterJourneyPageUI;
import interfaces.hotel.LoginRegisterJourneyPageUI;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import pages.hotel.mailsac.MailsacService;

import commons.hotel.CommonHotelPages;

import static commons.CommonsTravalaXpath.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.LandingPageUI.CONFIRM_PASSWORD_ERROR;

public class RegisterPage extends CommonHotelPages {
  WebDriver driver;

  public RegisterPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public ForgotPasswordPage clickForgotPassword() {
    clickToElementByJavascript(driver, LOGIN_ICON_HEADER);
    clickToElementByJavascript(driver, FORGOT_PASSWORD_LINK);
    return new ForgotPasswordPage(driver);
  }

  public void verifyRegisterForm() {
    clickToElementByJavascript(driver, REGISTER_LINK);
    waitFoElementVisible(driver, REGISTER_TITLE);
    String[] content = {"REGISTER_TITLE", "PERSONAL_DETAIL_FIRST_NAME", "PERSONAL_DETAIL_LAST_NAME", "EMAIL_TITLE", "CREATE_PASSWORD_TITLE", "CONFIRM_PASSWORD_TITLE", "REGISTER_TITLE", "POLICY_REGISTER", "ALREADY_REGISTER"};
    String[] xpath = {REGISTER_TITLE, FIRST_NAME_TITLE, LAST_NAME_TITLE, REGISTER_EMAIL_TITLE, CREATE_PASSWORD_TITLE, CONFIRM_PASSWORD_TITLE, REGISTER_BTN, POLICY_REGISTER, ALREADY_REGISTER};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text on register form Wrong");
    } else {
      System.out.println("Text on register form correct");
    }
  }

  public void verifyEmptyRegister() {
    clickToElement(driver, FIRST_NAME_TXT);
    clickToElement(driver, LAST_NAME_TXT);
    clickToElement(driver, REGISTER_EMAIL_TXT);
    clickToElement(driver, CREATE_PASSWORD_TXT);
    clickToElement(driver, CONFIRM_PASSWORD_TXT);
    clickToElement(driver, REGISTER_TITLE);
    String[] content = {"FIRST_NAME_ERROR", "LAST_NAME_ERROR", "EMAIL_ERROR", "SETTING_NEW_PASSWORD_MES", "CONFIRM_PASSWORD_ERROR"};
    String[] xpath = {FIRST_NAME_ERROR, LAST_NAME_ERROR, REGISTER_EMAIL_ERROR, CREATE_PASSWORD_ERROR, CONFIRM_PASSWORD_ERROR};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Error message after input empty textbox when Register wrong ");
    } else {
      System.out.println("Error message after input empty textbox when Register Correct ");
    }
  }

  public void verifyErrorMessageRegister() {
//    clickToElementByJavascript(driver, FIRST_NAME_TXT);
    sendkeysToElement(driver, FIRST_NAME_TXT, "");
    clickToElementByJavascript(driver, FIRST_NAME_TITLE);
    wait2sTime();
    boolean b1 = StringUtils.contains(getTextElement(driver, FIRST_NAME_ERROR), getTextFromReadFile("FIRST_NAME_ERROR"));
    sendkeysToElement(driver, FIRST_NAME_TXT, " ");
    waitFoElementVisible(driver, FIRST_NAME_ERROR);
    boolean a1 = StringUtils.contains(getTextElement(driver, FIRST_NAME_ERROR), getTextFromReadFile("ERROR_USE_OTHER_LANGUAGE"));

    clickToElementByJavascript(driver, LAST_NAME_TXT);
    clickToElementByJavascript(driver, LAST_NAME_TITLE);
    waitFoElementVisible(driver, LAST_NAME_ERROR);
    boolean b2 = StringUtils.contains(getTextElement(driver, LAST_NAME_ERROR), getTextFromReadFile("LAST_NAME_ERROR"));

    sendkeysToElement(driver, LAST_NAME_TXT, " ");
    waitFoElementVisible(driver, LAST_NAME_ERROR);
    boolean a2 = StringUtils.contains(getTextElement(driver, LAST_NAME_ERROR), getTextFromReadFile("ERROR_USE_OTHER_LANGUAGE"));

    clickToElementByJavascript(driver, REGISTER_EMAIL_TXT);
    clickToElementByJavascript(driver, REGISTER_EMAIL_TITLE);
    waitFoElementVisible(driver, REGISTER_EMAIL_ERROR);
    boolean b3 = StringUtils.contains(getTextElement(driver, REGISTER_EMAIL_ERROR), getTextFromReadFile("EMAIL_ERROR"));

    clickToElementByJavascript(driver, CREATE_PASSWORD_TXT);
    clickToElementByJavascript(driver, CREATE_PASSWORD_TITLE);
    waitFoElementVisible(driver, CREATE_PASSWORD_ERROR);
    boolean b4 = StringUtils.contains(getTextElement(driver, CREATE_PASSWORD_ERROR), getTextFromReadFile("SETTING_NEW_PASSWORD_MES"));

    clickToElementByJavascript(driver, CONFIRM_PASSWORD_TXT);
    clickToElementByJavascript(driver, CONFIRM_PASSWORD_TITLE);
    waitFoElementVisible(driver, CONFIRM_PASSWORD_ERROR);
    boolean b5 = StringUtils.contains(getTextElement(driver, CONFIRM_PASSWORD_ERROR), getTextFromReadFile("CONFIRM_PASSWORD_ERROR"));
    if (a1 && a2 && b1 && b2 && b3 && b4 && b5) {
      System.out.println("Error message on register form correct! ");
    }
  }

//  public void doRegisterJourney(String email, String password) throws UnirestException {
//    MailsacService mailsacAPIPage = new MailsacService();
//    sendkeysToElement(driver, LoginRegisterJourneyPageUI.EMAIL_TEXTBOX_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP, email);
//    clickToElement(driver, LoginRegisterJourneyPageUI.CONTINUE_BUTTON_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP);
//
//    sendkeysToElement(driver, LoginRegisterJourneyPageUI.PASSWORD_TEXTBOX_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP, password);
//    verifyConditionPassword(driver);
//    clickToElement(driver, LoginRegisterJourneyPageUI.CONTINUE_BUTTON_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP);
//
//    wait5sTime();
//    String verificationCode = mailsacAPIPage.getVerificationCodeInMailsacInbox(email);
//    wait1sTime();
//    sendkeysToElement(driver, LoginRegisterJourneyPageUI.VERIFICATION_CODE_TEXTBOX, verificationCode);
//    clickToElement(driver, LoginRegisterJourneyPageUI.SUBMIT_BUTTON);
//    clickToElement(driver, LoginRegisterJourneyPageUI.OK_BUTTON_AT_REGISTER_SUCCESS_POP_UP);
//    System.out.println("Signup success! Email/Password: " + email + "/" + password);
//  }
//
//  public void verifyLoginRegisterJourneyPopUpDisplayed(String utm_campaign, String utm_term, String camp_voucher_discount, String camp_credit) {
//      Assert.assertTrue(isElementDisplayed(driver, LoginRegisterJourneyPageUI.LOGIN_OR_SIGNUP_JOURNEY_POP_UP));
//      switch (utm_term) {
//        case "discount":
//          verifyUIRegisterJourneyWithDiscountTermPopUp(utm_campaign);
//          break;
//        case "credit":
//          verifyUIRegisterJourneyWithCreditTermPopUp();
//          break;
//        default:
//          Assert.assertTrue(isElementDisplayed(driver, ""));
//          break;
//      }
//  }

  private void verifyUIRegisterJourneyWithDiscountTermPopUp(String utm_campaign) {
    Assert.assertTrue(isElementDisplayed(driver, ""));

  }

  private void verifyUIRegisterJourneyWithCreditTermPopUp() {
    Assert.assertTrue(isElementDisplayed(driver, ""));

  }

//  private void verifyConditionPassword(WebDriver driver) {
//    String[] listConditonElements = {LoginRegisterJourneyPageUI.CONDITION_LOWERCASE_CHECKBOX, LoginRegisterJourneyPageUI.CONDITION_CHARACTER_LONG_CHECKBOX, LoginRegisterJourneyPageUI.CONDITION_NUMERAL_CHECKBOX,
//            LoginRegisterJourneyPageUI.CONDITION_SPECIAL_CHARACTER_CHECKBOX, LoginRegisterJourneyPageUI.CONDITION_WHITE_SPACE_CHECKBOX, LoginRegisterJourneyPageUI.CONDITION_UPPERCASE_CHECKBOX};
//    for (String condition : listConditonElements) {
//      WebElement element = driver.findElement(By.xpath(condition));
//      if(element.getAttribute("class").length() > 0) {
//        System.out.println("Condition password [" + element.getText() + "] verified");
//      } else {
//        System.out.println("Condition password [" + element.getText() + "] incorrectly");
//      }
//    }
//  }
//
  public void closeSignUpJourneyPopUp() {
    int maxtimeDisplayPopUp = 30;
    for(int i=0; i < maxtimeDisplayPopUp/5; i++) {
      if(!isElementDisplayed(driver, LoginRegisterJourneyPageUI.LOGIN_OR_SIGNUP_JOURNEY_POP_UP)) {
        System.out.println("Sign up journey pop up is not displayed in time " + (i+1)*5);
      } else {
        clickToElement(driver, LoginRegisterJourneyPageUI.CLOSE_BUTTON_ON_SIGN_UP_JOURNEY_POP_UP);
        break;
      }
    }
  }

}
