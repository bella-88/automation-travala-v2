package pages.hotel.myProfile;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static commons.CommonDataTravala.*;
import static commons.CommonsTravalaXpath.*;

import static interfaces.hotel.HomePageUI.*;



public class MyAccountPage extends CommonHotelPages {
  WebDriver driver;
  private static WebElement element1 = null;
  boolean check = true;

  public MyAccountPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  //========================MY ACCOUNT=======================
  public boolean verifyPersonalDetailTextHolder() {
    boolean b1 = StringUtils.contains(getAttribute(driver, PERSONAL_DETAIL_ADDRESS_HOLDER, "placeholder").trim(), getTextFromReadFile("PERSONAL_DETAIL_ADDRESS_HOLDER"));
    boolean b2 = StringUtils.contains(getAttribute(driver, PERSONAL_DETAIL_AFFILIATE_HOLDER, "placeholder").trim(), getTextFromReadFile("PERSONAL_DETAIL_AFFILIATE_HOLDER"));
    boolean b3 = StringUtils.contains(getAttribute(driver, PERSONAL_DETAIL_ZIP_CODE_HOLDER, "placeholder").trim(), getTextFromReadFile("PERSONAL_DETAIL_ZIP_CODE_HOLDER"));
    boolean b4 = StringUtils.contains(getAttribute(driver, PERSONAL_DETAIL_CITY_HOLDER, "placeholder").trim(), getTextFromReadFile("PERSONAL_DETAIL_CITY_HOLDER"));
    if (!b1 && !b2 & !b3 && !b4) {
      check = false;
    }
    return check;
  }

  public void verifyMessageUpdatePersonalDetail() {
    WebElement element = driver.findElement(By.xpath(PERSONAL_DETAIL_ADDRESS_HOLDER));
    element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    String text = "HaNoi" + randomData();
    sendkeysToElement(driver, PERSONAL_DETAIL_ADDRESS_HOLDER, text);
    clickToElementByAction(driver, PERSONAL_DETAIL_PHONE_TXT);
    clickToElementByJavascript(driver, PERSONAL_DETAIL_PHONE_TXT);
    clickToElementByJavascript(driver, PERSONAL_DETAIL_SAVE_BTN);
    boolean b1 = verifyTextByKey("PERSONAL_CONGRATULATION", CONSTANT_POPUP_MES_TITLE);
    boolean b2 = verifyTextByKey("PERSONAL_CONGRATULATION_MES", CONSTANT_POPUP_MES_CONTENT);
    boolean b3 = verifyTextByKey("POPUP_OK_BTN", PERSONAL_CONGRATULATION_OK);
    if (!b1 || !b2 || !b3) {
      System.out.println("=========Message when Update Personal Detail is display Wrong=========");
    }
    clickToElementByJavascript(driver, PERSONAL_CONGRATULATION_OK);
  }

  public boolean verifyPersonalDetail() {
    String[] label = {"PERSONAL_DETAIL_FORM_TITLE", "PERSONAL_DETAIL_FIRST_NAME", "PERSONAL_DETAIL_AFFILIATE",
      "PERSONAL_DETAIL_NATIONALITY", "PERSONAL_DETAIL_NATIONALITY_LABEL", "PERSONAL_DETAIL_LAST_NAME", "PERSONAL_DETAIL_ADDRESS", "PERSONAL_DETAIL_PHONE", "PERSONAL_DETAIL_CITY",
      "PERSONAL_DETAIL_STATE", "PERSONAL_DETAIL_AFFILIATE_LINK", "PERSONAL_DETAIL_ZIP_CODE", "PERSONAL_DETAIL_BIRTH_DAY", "PERSONAL_DETAIL_DOCUMENT_TYPE",
      "PERSONAL_DETAIL_ISSUED", "PERSONAL_DETAIL_PASSPORT_NUMBER", "PERSONAL_DETAIL_PASSPORT_EXPIRATION", "PERSONAL_DETAIL_SAVE_BTN", "PERSONAL_DETAIL_PASSPORT_SELECT"};
    boolean b = verifyListItemByListExpect(label, PERSONAL_DETAIL_LABEL, PERSONAL_DETAIL_LABEL_DYNAMIC);
    if (!b) {
      System.out.println("Label at Personal Detail Wrong");
    }
    String[] content = {"PERSONAL_DETAIL_CONTENT_TITLE", "PERSONAL_DETAIL_CONTENT_SUB", "PERSONAL_DETAIL_PASSPORT_TITLE", "PERSONAL_DETAIL_PASSPORT_SUB"};
    String[] xpath = {PERSONAL_DETAIL_NOTE_TITLE, PERSONAL_DETAIL_NOTE_CONTENT, PERSONAL_DETAIL_PASSPORT_ID, PERSONAL_DETAIL_PASSPORT_CONTENT};
    check = b && verifyPersonalDetailTextHolder() && verifyTwoListByKey(content, xpath);
    clickToElement(driver, PERSONAL_DETAIL_AFFILIATE_LINK);
    switchTab(driver);
    return check;
  }

  public boolean verifyConnectAccount() {
    boolean connectExp = true;
    String[] content = {"CONNECT_SOCIAL_NETWORK_TITLE", "CONNECT_SOCIAL_NETWORK_SUB"};
    String[] xpath = {CONNECT_ACC_SOCIAL_NETWORK_TITLE, CONNECT_ACC_SOCIAL_NETWORK_SUB};
    boolean connectAcc = verifyTwoListByKey(content, xpath);
    String[] connect = {"CONNECT_DISCONNECT_TEXT", "CONNECT_CONNECT_TEXT"};
    connectExp = connectAcc && verifyTwoList(addListActualFromListXpath(CONNECT_ACC_BTN, CONNECT_ACC_BTN_DYNAMIC), addListExpectByKey(connect));
    if (!connectExp) {
      System.out.println("Text at connect account wrong");
    }
    return connectExp;
  }

  public boolean verifySettingTab() {
    String[] content = {"SETTING_EMAIL_TITLE", "SETTING_PASSWORD_TITLE", "CHANGE_PASSWORD_CONTENT", "CHANGE_BTN", "CHANGE_BTN"};
    String[] xpath = {CHANGE_EMAIL_LABEL, CHANGE_PASS_LABEL, CHANGE_PASS_CONTENT,CHANGE_EMAIL_BTN, CHANGE_PASS_BTN};
    boolean b = verifyTwoListByKey(content, xpath);
    if (!b) {
      System.out.println("Text at setting wrong");
    }
    return b;
  }

  public boolean verifyTextAtSecurityTab() {
    String[] content = {"SECURITY_AUTHEN_GOOGLE", "SECURITY_AUTHEN_GOOGLE_USE"};
    String[] xpath = {SECURITY_AUTHEN_GOOGLE, SECURITY_AUTHEN_GOOGLE_USE};
    if (!verifyTwoListByKey(content, xpath)) {
      check = false;
    }
    return check;
  }

  public void inputEmailToChange(String email, String password) {
    clearTextBox(driver, SETTING_NEW_EMAIL_TXT);
    sendkeysToTxt(SETTING_NEW_EMAIL_TXT, email);
    sendkeysToTxt(SETTING_INPUT_PASSWORD, password);
    clickToElementByJavascript(driver, POPUP_CHANGE_PASSWORD_BTN);
  }

  public void verifyChangeEmail() {
    clickToElementByJavascript(driver, CHANGE_EMAIL_BTN);
    String[] existEmail = {"POPUP_ERROR_TITLE", "SETTING_ENTER_EMAIL_EXIST", "MY_INVITE_PEOPLE_POPUP_ERROR_OK"};
    String[] invalidPass = {"POPUP_ERROR_TITLE", "CURRENT_PASSWORD_ERROR", "MY_INVITE_PEOPLE_POPUP_ERROR_OK"};
    inputEmailToChange(EMAIL_TRAVALA_ACC, PASSWORD_ACC);
    boolean b = verifyContentPopup(existEmail);
    inputEmailToChange(randomString() + randomNumber() + "@gmail.com", randomString());
    boolean b1 = verifyContentPopup(invalidPass);
    if (!b) {
      System.out.println("Content when change exist email wrong");
    }
    if (!b1) {
      System.out.println("Content when change email with invalid password wrong");
    }
    if (b & b1) {
      System.out.println("Message when change invalid email and password correct! ");
    }
  }

  public void verifyChangeEmailSuccess() {
    inputEmailToChange(randomString() + "@gmail.com", PASSWORD_ACC);
    String[] content = {"SETTING_CHANGE_EMAIL_SUCCESS_TITLE", "SETTING_CHANGE_EMAIL_SUCCESS_CONTENT", "SETTING_CHANGE_EMAIL_VERIFY_TITLE", "SETTING_CHANGE_EMAIL_SEND_CODE", "SETTING_CHANGE_EMAIL_SUBMIT"};
    String[] xpath = {CHANGE_EMAIL_SUCCESS_TITLE, CHANGE_EMAIL_SUCCESS_CONTENT, CHANGE_EMAIL_VERIFY_TITLE, CHANGE_EMAIL_SEND_CODE_BTN, CHANGE_EMAIL_SUBMIT};
    clickToElementByJavascript(driver, CHANGE_EMAIL_SUBMIT);
    boolean b = verifyTextByKey("SETTING_CHANGE_EMAIL_INVALID_CODE", CHANGE_EMAIL_INVALID_CODE) && verifyTwoListByKey(content, xpath) && verifyTextByKeyWithAttribute("CHANGE_EMAIL_INPUT_CODE",
      CHANGE_EMAIL_INPUT_CODE, "placeholder");
    if (!b) {
      System.out.println("Text on Popup Confirmation change Email wrong");
    } else {
      System.out.println("Text on Popup Confirmation change Email correct");
    }
    clickToElement(driver, SETTING_CHANGE_EMAIL_CLOSE_BTN);
    clickToElement(driver, SETTING_CHANGE_EMAIL_CANCEL_BTN);

  }

  public void inputPasswordToChange(String oldPassword, String newPassword, String confirmNewPass) {
    sendkeysToTxt(CURRENT_PASSWORD_TXT, oldPassword);
    sendkeysToTxt(NEW_PASSWORD_TXT, newPassword);
    sendkeysToTxt(NEW_CONFIRM_PASSWORD_TXT, confirmNewPass);
    clickToElementByJavascript(driver, POPUP_CHANGE_PASSWORD_BTN);
  }

  public boolean verifyChangePassWord(String passWord) {
    String regex = "^(?=.*[0-9])"
      + "(?=.*[a-z])(?=.*[A-Z])"
      + "(?=.*[@#$%^&+=])"
      + "(?=\\S+$).{8,64}$";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public void verifyErrorWhenInputInvalidPassWord(String newPass, String confirmPass) {

    inputPasswordToChange(PASSWORD_ACC, newPass, confirmPass);
    sendkeysToTxt(NEW_PASSWORD_TXT, newPass);
    clickToElementByJavascript(driver, NEW_CONFIRM_PASSWORD_TXT);
    switch (newPass) {
      case "":
        if (!verifyTextByKey("PASSWORD_ERROR_EMPTY", NEW_PASSWORD_MESSAGE_ERROR)) {
          System.out.println("Error message when input empty new password wrong");
        } else {
          System.out.println("Error message when input empty new password correct");
        }
      case "a":
        if (!verifyTextByKey("PASSWORD_ERROR_NOT_CONDITION", NEW_PASSWORD_MESSAGE_ERROR)) {
          System.out.println("Error message when input new password not belong condition wrong");
        } else {
          System.out.println("Error message when input new password not belong condition correct");
        }

    }
//    if (!verifyChangePassWord(newPass)) {
//      verifyTextByKey("PASSWORD_ERROR_INVALID", NEW_PASSWORD_MESSAGE_ERROR);
//      System.out.println("Error message when input invalid new password wrong");
//    }
//    if (!verifyChangePassWord(confirmPass)) {
//      verifyTextByKey("PASSWORD_ERROR_INVALID", CONFIRM_PASSWORD_MESSAGE_ERROR);
//      System.out.println("Error message when input invalid confirm password wrong");
//    }
//    if (!StringUtils.equals(newPass, confirmPass)) {
//      verifyTextByKey("PASSWORD_ERROR_NOT_MATCH", CONFIRM_PASSWORD_MESSAGE_ERROR);
//      System.out.println("Error message when input not match confirm password wrong");
//    }
//    if (!StringUtils.equals(newPass, getAttribute(driver, CURRENT_PASSWORD_TXT, "value"))) {
//      verifyTextByKey("PASSWORD_ERROR_SAME_OLD", CONFIRM_PASSWORD_MESSAGE_ERROR);
//      System.out.println("Error message when input new password same as your old password wrong");
//    }
  }

  public void verifyErrorWhenInputCurrentPasswordWrong(String newPass, String confirmPass) {
    inputPasswordToChange(randomString(), newPass, confirmPass);
    String[] content = {"POPUP_ERROR_TITLE", "CURRENT_PASSWORD_ERROR", "MY_INVITE_PEOPLE_POPUP_ERROR_OK"};
    String[] xpath = {POPUP_PASSWORD_ERROR_TITLE, POPUP_PASSWORD_ERROR_CONTENT, POPUP_PASSWORD_ERROR_OK};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text on popup when input wrong old password wrong");
    } else {
      System.out.println("Text on popup when input wrong old password correct!");
    }
    clickToElementByJavascript(driver, POPUP_PASSWORD_ERROR_OK);
  }

  public void verifyChangeEmailWithInvalidPassword() {
//    String newPass, String confirmPass
//    String st1 ="BADJASFKAF";
//    String st1 ="12345678";
//    String st1 ="@^&%*^&%&^%(&*^*(^*(&";
//    String st1 ="adbcndnnnnnnnnnnn";
//    String st1 ="Bel   a@1   2345678";
//    String st1 ="     ";
    String st1 = "Bella@1";
    System.out.println(verifyChangePassWord(st1));
//    inputPasswordToChange(PASSWORD_ACC, newPass, confirmPass);
//    boolean lengthPass = true;
//    boolean confirmPassB = true;
//    if ((newPass.length() < 8 && newPass.length() > 64) || (confirmPass.length() < 8 && confirmPass.length() > 64)) {
//      if (!verifyTextByKey("PASSWORD_ERROR_MESSAGE", CONFIRM_PASSWORD_ERROR)) {
//        System.out.println("Error message when input pass and confirm pass with invalid length wrong!");
//      }
//      lengthPass = false;
//
//
//    }
//
//
////    verifyTextByKey("SETTING_CONFIRM_PASSWORD_ERROR", SETTING_CONFIRM_PASSWORD_ERROR);
//    inputPasswordToChange(randomPhone(), "123456789", "123456789");
//    String[] currentPass = {"SETTING_ENTER_INVALID_PASSWORD_TITLE", "SETTING_ENTER_INVALID_PASSWORD_MES", "MY_INVITE_PEOPLE_POPUP_ERROR_OK"};
//    boolean b = verifyContentPopup(currentPass);
//    if (!b) {
//      System.out.println("Content when change password wrong");
//    } else {
//      System.out.println("Content when change password correct");
//    }
  }

}