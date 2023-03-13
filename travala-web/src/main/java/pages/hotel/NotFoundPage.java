package pages.hotel;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.EMAIL_WITHDRAW_REQUEST_CONFIRMATION_BUTTON;
import static interfaces.hotel.NotFoundPageUI.NOT_FOUND_HELPFUL_TXT;
import static interfaces.hotel.NotFoundPageUI.NOT_FOUND_MESSAGE_TXT;


public class NotFoundPage extends CommonHotelPages {
  WebDriver driver;

  public NotFoundPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyText() {
    boolean b = StringUtils.contains(getTextElement(driver, NOT_FOUND_MESSAGE_TXT), getTextFromReadFile("NOT_FOUND_MESSAGE_TXT"));
    boolean b1 = StringUtils.contains(getTextElement(driver, NOT_FOUND_HELPFUL_TXT), getTextFromReadFile("NOT_FOUND_HELPFUL_TXT"));
    boolean check = b && b1;
    if (!check) {
      System.out.println("ACTUAL MESSAGE: " + getTextElement(driver, NOT_FOUND_MESSAGE_TXT));
      System.out.println("EXPECT MESSAGE: " + getTextFromReadFile("NOT_FOUND_MESSAGE_TXT"));
      System.out.println("ACTUAL HELPFUL: " + getTextElement(driver, NOT_FOUND_HELPFUL_TXT));
      System.out.println("EXPECT HELPFUL: " + getTextFromReadFile("NOT_FOUND_HELPFUL_TXT"));
    }
  }

  public ConfirmWithDrawPage openGmailTabToClickConfirmBtn() {
    System.out.println("current title: " + driver.getTitle());
    ((JavascriptExecutor) driver).executeScript("window.open()");
 wait1sTime();
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get(GOOGLE_LOGIN_URL);
    clickToElement(driver, "//span[@class='bog']/span[text()='Withdraw request confirmation']");
    wait1sTime();
    try {
      scrollToBottomPage(driver);
      clickToElement(driver, EMAIL_WITHDRAW_REQUEST_CONFIRMATION_BUTTON);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return new ConfirmWithDrawPage(driver);
  }

}
