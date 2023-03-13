package pages.hotel.footer.support;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import static commons.CommonHotelURL.CONTACT_US_PATH;
import static interfaces.hotel.footer.support.ContactUsPageUI.*;


import commons.hotel.CommonHotelPages;
public class ContactUsPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public ContactUsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyContactUs() {
    String[] content = {"TERM_MAIN_LINK1", "CONTACT_LINK2", "CONTACT_TITLE", "CONTACT_YOUR_NAME", "CONTACT_EMAIL", "CONTACT_YOUR_MESSAGE", "CONTACT_SUBMIT"};
    String[] xpath = {CONTACT_LINK1, CONTACT_LINK2, CONTACT_TITLE, CONTACT_YOUR_NAME_LABEL, CONTACT_EMAIL_LABEL, CONTACT_YOUR_MESSAGE_LABEL, CONTACT_SUBMIT};
    check=  verifyTwoListByKey(content, xpath) &&     verifyMenuStaticPage() && verifyUrlPage(CONTACT_US_PATH);
    return check;
  }

  public void verifyEmptyContent() {
    clickToElement(driver, CONTACT_YOUR_NAME_TXT);
    clickToElement(driver, CONTACT_EMAIL_TXT);
    wait100Time();
    clickToElement(driver, CONTACT_YOUR_MESSAGE_TXT);
    wait100Time();
    clickToElement(driver, CONTACT_EMAIL_TXT);
    wait100Time();
    boolean b1 = StringUtils.contains(getTextFromReadFile("CONTACT_ERROR_MESSAGE_TEXTBOX"), getTextElement(driver, CONTACT_INVALID_YOUR_NAME));
    boolean b2 = StringUtils.contains(getTextFromReadFile("CONTACT_ERROR_MESSAGE_TEXTBOX"), getTextElement(driver, CONTACT_INVALID_EMAIL));
    boolean b3 = StringUtils.contains(getTextFromReadFile("CONTACT_ERROR_MESSAGE_TEXTBOX"), getTextElement(driver, CONTACT_INVALID_YOUR_MESSAGE));
    if (!b1 || !b2 || !b3) {
      System.out.println("Error message at Contact Us wrong! ");
      System.out.println("Name: " + getTextElement(driver, CONTACT_INVALID_YOUR_NAME));
      System.out.println("Email: " + getTextElement(driver, CONTACT_INVALID_EMAIL));
      System.out.println("Message: " + getTextElement(driver, CONTACT_INVALID_YOUR_MESSAGE));
    }
  }

  public boolean verifyValidEmail() {
    clickToElementByJavascript(driver, CONTACT_YOUR_NAME_TXT);
    sendkeysToElement(driver, CONTACT_YOUR_NAME_TXT, "bella");
    clickToElementByJavascript(driver, CONTACT_EMAIL_TXT);
    sendkeysToElement(driver, CONTACT_EMAIL_TXT, "content");
    clickToElementByJavascript(driver, CONTACT_YOUR_MESSAGE_TXT);
    sendkeysToElement(driver, CONTACT_YOUR_MESSAGE_TXT, "This field is required");
    boolean checkMes = true;
    if (!StringUtils.equals(getTextFromReadFile("CONTACT_INVALID_EMAIL"), getTextElement(driver, CONTACT_INVALID_EMAIL))) {
      checkMes = false;
    }
    return checkMes;
  }

  public boolean verifySubmitSuccess() {
    sendkeysToElement(driver, CONTACT_YOUR_NAME_LABEL, "bella");
    sendkeysToElement(driver, CONTACT_EMAIL_LABEL, "abcd@gmail.com");
    sendkeysToElement(driver, CONTACT_YOUR_MESSAGE_LABEL, "This field is required");
    clickToElement(driver, CONTACT_SUBMIT);
    boolean checkMes = true;

    if (!StringUtils.equals(getTextFromReadFile("CONTACT_SENT_SUCCESS"), getTextElement(driver, CONTACT_INVALID_EMAIL))) {
      checkMes = false;
    }
    return checkMes;
  }
}
