package pages.hotel.myProfile;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.ConfirmWithDrawPage;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static commons.CommonDataTravala.randomData;
import static commons.CommonsTravalaXpath.*;

import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.*;
import static interfaces.hotel.myProfile.MyWalletPageUI.*;


public class MyWalletPage extends CommonHotelPages {
  WebDriver driver;
  private static WebElement element1 = null;

  public MyWalletPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void navigateToWithDrawOption() {
    try {
      clickToElementByJavascript(driver, PROFILE_ICON);
      clickToElementByJavascript(driver, MY_WALLET_LINK);
      clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_TAB);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  public boolean verifyOverviewWallet() {
    wait1sTime();
    String[] content = {"MY_WALLET_OVERVIEW_TAB", "MY_WALLET_SUMMARY_TAB", "MY_WALLET_WITHDRAW_TAB", "MY_WALLET_DEPOSIT_TAB",
      "MY_WALLET_MY_WALLET_TTTLE", "MY_WALLET_TOTAL_BALANCE", "MY_WALLET_AVA_WALLET", "MY_WALLET_BALANCE_AVA", "MY_WALLET_LOCK_AVA", "MY_WALLET_BNB_WALLET", "MY_WALLET_BUSD_WALLET"};
    String[] xpath = {MY_WALLET_OVERVIEW_TAB, MY_WALLET_SUMMARY_TAB, MY_WALLET_WITHDRAW_TAB, MY_WALLET_DEPOSIT_TAB, MY_WALLET_MY_WALLET_TITLE, MY_WALLET_TOTAL_BALANCE, MY_WALLET_AVA_WALLET, MY_WALLET_BALANCE_AVA,
      MY_WALLET_LOCK_AVA, MY_WALLET_BNB_WALLET, MY_WALLET_BUSD_WALLET};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at Overview  Wallet Wrong");
    }
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifySummaryWallet() {
    String[] content = {"MY_WALLET_SUMMARY_FILTER", "MY_WALLET_SUMMARY_FILTER_SELECT", "MY_WALLET_SUMMARY_CRYPTO", "MY_WALLET_SUMMARY_CRYPTO_SELECT", "MY_WALLET_DEPOSIT_DATE"};
    String[] xpath = {MY_WALLET_SUMMARY_FILTER, MY_WALLET_SUMMARY_FILTER_SELECT, MY_WALLET_SUMMARY_CRYPTO, MY_WALLET_SUMMARY_CRYPTO_SELECT, MY_WALLET_SUMMARY_DATE, MY_WALLET_SUMMARY_DATE_SELECT};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at Summary Wallet Wrong");
    }
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifyHeaderTable() {
    String[] content = {"MY_WALLET_SUMMARY_TYPE_HEADER", "MY_WALLET_SUMMARY_STATUS_HEADER", "MY_WALLET_SUMMARY_AMOUNT_HEADER", "MY_WALLET_SUMMARY_CRYPTO",
      "MY_WALLET_SUMMARY_DATE_HEADER", "MY_WALLET_SUMMARY_NOTE_HEADER", "MY_WALLET_SUMMARY_INFO_HEADER"};
    String[] xpath = {MY_WALLET_SUMMARY_TYPE_HEADER, MY_WALLET_SUMMARY_STATUS_HEADER, MY_WALLET_SUMMARY_AMOUNT_HEADER, MY_WALLET_SUMMARY_CRYPTO_HEADER, MY_WALLET_SUMMARY_DATE_HEADER, MY_WALLET_SUMMARY_NOTE_HEADER,
      MY_WALLET_SUMMARY_INFO_HEADER};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at Header Table Summary Wrong");
    }
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifySummaryFilter() {
    clickToElement(driver, MY_WALLET_SUMMARY_FILTER_SELECT);
    String[] content = {"MY_WALLET_SUMMARY_FILTER_TRANSACTION", "MY_WALLET_SUMMARY_FILTER_GIVEBACK","MY_WALLET_DEPOSIT_TAB", "MY_WALLET_WITHDRAW_TAB", "MY_WALLET_SUMMARY_FILTER_SELECT_SMART", "MY_WALLET_SUMMARY_FILTER_SELECT_GIVEBACK",
      "MY_WALLET_SUMMARY_FILTER_SELECT_ROLLBACK", "HELP_MENU_FLIGHTS_BOOKING", "MY_WALLET_SUMMARY_FILTER_SELECT_REFERRAL", "MY_WALLET_SUMMARY_FILTER_SELECT_REFUND",
      "MY_WALLET_SUMMARY_FILTER_SELECT_BONUS", "MY_WALLET_SUMMARY_FILTER_SELECT_TRAVEL_CREDIT", "MY_WALLET_SUMMARY_FILTER_SELECT_BUY_GIFT_CARD"};
    boolean b = verifyTwoList(addListActualFromListXpath(MY_WALLET_SUMMARY_FILTER_SELECT_LIST, MY_WALLET_SUMMARY_FILTER_SELECT_DYNAMIC), addListExpectByKey(content));
    if (!b) {
      System.out.println("Text at Summary Filter Wrong");
    }
    return b;
  }

  public boolean verifyWithDrawOption() {
    String[] content = {"MY_WALLET_WITHDRAW_SELECT_CRYPTO", "MY_WALLET_WITHDRAW_MINIMUM", "MY_WALLET_WITHDRAW_MAX_24HOURS", "MY_WALLET_WITHDRAW_ADDRESS_LABEL", "MY_WALLET_WITHDRAW_ADDRESS_SAVE_TXT",
      "MY_WALLET_WITHDRAW_MEMO_LABEL", "MY_WALLET_WITHDRAW_MEMO_NO_TXT", "MY_WALLET_WITHDRAW_AMOUNT_LABEL", "MY_WALLET_WITHDRAW_AVAILABLE_WITHDRAW",
      "MY_WALLET_WITHDRAW_USE_MAX", "MY_WALLET_WITHDRAW_TRANSACTION", "MY_WALLET_WITHDRAW_GET", "MY_WALLET_WITHDRAW_NOTE", "MY_WALLET_WITHDRAW_HAVE_READ", "MY_WALLET_WITHDRAW_SUBMIT", "MY_WALLET_DEPOSIT_DATE"};
    String[] xpath = {MY_WALLET_WITHDRAW_SELECT_CRYPTO, MY_WALLET_WITHDRAW_MINIMUM, MY_WALLET_WITHDRAW_MAX_24HOURS, MY_WALLET_WITHDRAW_ADDRESS_LABEL, MY_WALLET_WITHDRAW_ADDRESS_SAVE_TXT,
      MY_WALLET_WITHDRAW_MEMO_LABEL, MY_WALLET_WITHDRAW_MEMO_NO_TXT, MY_WALLET_WITHDRAW_AMOUNT_LABEL, MY_WALLET_WITHDRAW_AVAILABLE_WITHDRAW,
      MY_WALLET_WITHDRAW_USE_MAX, MY_WALLET_WITHDRAW_TRANSACTION, MY_WALLET_WITHDRAW_GET, MY_WALLET_WITHDRAW_NOTE, MY_WALLET_WITHDRAW_HAVE_READ, MY_WALLET_WITHDRAW_SUBMIT,
      MY_WALLET_WITHDRAW_DATE};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at WithDraw Option Wrong");
    }
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifyTextHolderWithDrawOption() {
    String[] content = {"MY_WALLET_WITHDRAW_ADDRESS_HOLDER", "MY_WALLET_WITHDRAW_MEMO_HOLDER", "MY_WALLET_WITHDRAW_AMOUNT_HOLDER",};
    String[] xpath = {MY_WALLET_WITHDRAW_ADDRESS_HOLDER, MY_WALLET_WITHDRAW_MEMO_HOLDER, MY_WALLET_WITHDRAW_AMOUNT_HOLDER};
    if (!verifyTwoListByAttribute(content, xpath, "placeholder")) {
      System.out.println("Text at Holder WithDraw Option Wrong");
    }
    return verifyTwoListByAttribute(content, xpath, "placeholder");
  }

  public void verifyInvalidAddress(String address) {
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_ADDRESS_HOLDER);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_ADDRESS_HOLDER, address);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    boolean b1 = verifyTextByKey("MY_WALLET_WITHDRAW_ADDRESS_ERROR_MES", MY_WALLET_WITHDRAW_ADDRESS_ERROR_MES);
    boolean b2 = verifyTextByKey("MY_WALLET_WITHDRAW_ADDRESS_ERROR_EMPTY", MY_WALLET_WITHDRAW_ADDRESS_ERROR_MES);
    if (b1 || b2) {
      System.out.println("Error message Address correct");
    } else {
      System.out.println("Error message Address WRONG");
    }
  }

  public void verifyInvalidMemo(String memo) {
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_MEMO_HOLDER);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_MEMO_HOLDER, memo);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    boolean b1 = verifyTextByKey("MY_WALLET_WITHDRAW_MEMO_HOLDER_ERROR_MES", MY_WALLET_WITHDRAW_MEMO_HOLDER_ERROR_MES);
    boolean b2 = verifyTextByKey("MY_WALLET_WITHDRAW_MEMO_HOLDER_ERROR_EMPTY", MY_WALLET_WITHDRAW_MEMO_HOLDER_ERROR_MES);
    if (b1 || b2) {
      System.out.println("Error message Memo correct");
    } else {
      System.out.println("Error message Memo WRONG");
    }
  }

  public void verifyInvalidAmount(String amount) {
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_AMOUNT_HOLDER);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_AMOUNT_HOLDER, amount);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    boolean b1 = verifyTextByKey("MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_EMPTY", MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_MES);
    boolean b2 = verifyTextByKey("MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_MES", MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_MES);
    boolean b3 = verifyTextByKey("MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_MIN", MY_WALLET_WITHDRAW_AMOUNT_HOLDER_ERROR_MES);
    if (b1 || b2 || b3) {
      System.out.println("Error message Amount correct");
    } else {
      System.out.println("Error message Amount WRONG");
    }
  }

  public void verifyInvalidSaveAddress(String saveAddress) {
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_ADDRESS_SAVE_CHECKBOX);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER, saveAddress);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);

    boolean error = verifyTextByKey("MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER_ERROR_MES", MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER_ERROR_MES);
    boolean label = verifyTextByKey("MY_WALLET_WITHDRAW_SAVE_CHECKBOX_LABEL", MY_WALLET_WITHDRAW_SAVE_CHECKBOX_LABEL);
    boolean holder = StringUtils.contains(getAttribute(driver, MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER, "placeholder"), "MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER");
    if (label && holder && error) {
      System.out.println("Error message Save Address correct");
    } else {
      System.out.println("Error message New Address WRONG");
    }
  }

  public void verifyPopUpMessageSuccess() {
    try {
      String[] content = {"MY_WALLET_WITHDRAW_MESSAGE_TITLE_SUCCESS", "MY_WALLET_WITHDRAW_MESSAGE_CONTENT_SUCCESS"};

      if (!verifyContentPopup(content)) {
        System.out.println("Message withDraw success correct");
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  public void withDrawSuccessSaveAddress(String address, String memo, String amount, String saveAddress) {
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_ADDRESS_HOLDER, address);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_MEMO_HOLDER, memo);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_AMOUNT_HOLDER, amount);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_ADDRESS_SAVE_CHECKBOX);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_SAVE_CHECKBOX_HOLDER, saveAddress + randomData());
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_HAVE_READ_CHECKBOX);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    System.out.println("WithDraw when no save address success");
    verifyPopUpMessageSuccess();
  }

  public void withDrawSuccessNoSaveAddress(String address, String memo, String amount) {
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_ADDRESS_HOLDER, address);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_MEMO_HOLDER, memo);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_AMOUNT_HOLDER, amount);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_HAVE_READ_CHECKBOX);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    verifyPopUpMessageSuccess();
  }

  public void withDrawSuccessUseMax(String address, String memo) {
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_ADDRESS_HOLDER, address);
    sendkeysToElement(driver, MY_WALLET_WITHDRAW_MEMO_HOLDER, memo);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_USE_MAX);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_HAVE_READ_CHECKBOX);
    clickToElementByJavascript(driver, MY_WALLET_WITHDRAW_SUBMIT);
    System.out.println("WithDraw when use max success");
    verifyPopUpMessageSuccess();
  }

  public ConfirmWithDrawPage openGmailTabToClickConfirmBtn() {
    System.out.println("current title: " + driver.getTitle());
    ((JavascriptExecutor) driver).executeScript("window.open()");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get(GOOGLE_LOGIN_URL);
    clickToElement(driver, "//span[@class='bog']/span[text()='Withdraw request confirmation']");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      scrollToBottomPage(driver);
      clickToElement(driver, EMAIL_WITHDRAW_REQUEST_CONFIRMATION_BUTTON);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return new ConfirmWithDrawPage(driver);
  }

  public ConfirmWithDrawPage openGmailTabToClickLink() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get(GOOGLE_LOGIN_URL);
    clickToElement(driver, "//span[@id=':2m']/span[text()='Withdraw request confirmation']");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      scrollToBottomPage(driver);
      clickToElement(driver, EMAIL_WITHDRAW_REQUEST_CONFIRMATION_LINK);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return new ConfirmWithDrawPage(driver);
  }

  public boolean verifyDepositOption() {
    String[] content = {"MY_WALLET_DEPOSIT_SELECT_CRYPTO_TXT", "MY_WALLET_DEPOSIT_BEP2_TAB", "MY_WALLET_DEPOSIT_NEP5_TAB", "CHECKOUT_PAYMENT_WALLET_AVA_NOTE", "PAYMENT_AVA_DEPOSIT_ADDRESS",
      "PAYMENT_AVA_DEPOSIT_MEMO", "MY_WALLET_DEPOSIT_DATE"};
    String[] xpath = {MY_WALLET_DEPOSIT_SELECT_CRYPTO_TXT, MY_WALLET_DEPOSIT_BEP2_TAB, MY_WALLET_DEPOSIT_NEP5_TAB, MY_WALLET_DEPOSIT_CONTENT, MY_WALLET_DEPOSIT_ADDRESS, MY_WALLET_DEPOSIT_MEMO,
      MY_WALLET_DEPOSIT_DATE};
    return verifyTwoListByKey(content, xpath);
  }
}
