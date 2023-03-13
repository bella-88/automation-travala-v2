package pages.hotel.footer.travala;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


import static commons.CommonDataTravala.*;
import static commons.CommonTravalaURL.YOP_MAIL_URL;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelXpath.*;
import static interfaces.hotel.YopMailPageUI.*;
import static interfaces.hotel.footer.travala.BuyGiftCardPageUI.*;
import static interfaces.hotel.myProfile.MyTravelCreditsPageUI.*;


public class BuyGiftCardPage extends CommonHotelPages {
  WebDriver driver;
  List<String> getInforBuyGCExp = new ArrayList<String>();

  public BuyGiftCardPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextBuyGCPage() {
    String[] content = {"BUY_GIFT_CARDS_TITLE", "BUY_GIFT_CARDS_SECTION_VALUE", "BUY_GIFT_CARDS_SECTION_VALUE_SUB1", "BUY_GIFT_CARDS_SECTION_VALUE_SUB2", "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUPPORT",
      "BUY_GIFT_CARDS_SECTION_CONTACT", "BUY_GIFT_CARDS_SECTION_CONTACT_CONTENT", "BUY_GIFT_CARDS_SECTION_PAYMENT",    "BUY_GIFT_CARDS_SEND_A_GIFT", "PURCHASE_ITEM_LABEL",
      "PURCHASE_SUB_TOTAL_LABEL", "PURCHASE_TOTAL_LABEL", "BUY_GIFT_CARDS_ITEM", "BUY_GIFT_CARDS_PURCHASE_BTN"};
    String[] xpath = {BUY_GIFT_CARDS_TITLE, BUY_GIFT_CARDS_SECTION_VALUE, BUY_GIFT_CARDS_SECTION_VALUE_SUB1, BUY_GIFT_CARDS_SECTION_VALUE_SUB2, BUY_GIFT_CARDS_SECTION_VALUE_SUB3,
      BUY_GIFT_CARDS_SECTION_CONTACT, BUY_GIFT_CARDS_SECTION_CONTACT_CONTENT, BUY_GIFT_CARDS_SECTION_PAYMENT, BUY_GIFT_CARDS_SEND_A_GIFT, BUY_GIFT_CARDS_ITEM, BUY_GIFT_CARDS_SUB_TOTAL_LABEL,
      BUY_GIFT_CARDS_TOTAL_LABEL, BUY_GIFT_CARDS_TERM, BUY_GIFT_CARDS_PURCHASE_BTN};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text on Buy GC page wrong!");
    }
  }

  public void verifyInputContactForm(String invalidEmail) {
    String[] content = {"BUY_GIFT_CARDS_FIRST_NAME", "BUY_GIFT_CARDS_LAST_NAME", "BUY_GIFT_CARDS_EMAIL"};
    String[] xpath = {BUY_GIFT_CARDS_CONTACT_FIRST_NAME, BUY_GIFT_CARDS_CONTACT_LAST_NAME, BUY_GIFT_CARDS_CONTACT_EMAIL};
    boolean contact = verifyTwoListByAttribute(content, xpath, "placeholder");
    sendkeysToElement(driver, BUY_GIFT_CARDS_CONTACT_EMAIL, invalidEmail);
    clickToElement(driver, BUY_GIFT_CARDS_CONTACT_FIRST_NAME);
    if (!(verifyTextByKey("EMAIL_ERROR", BUY_GIFT_CARDS_ERROR_EMAIL) && contact)) {
      System.out.println("Message when input invalid email at Contact form wrong");
    } else {
      System.out.println("Message when input invalid email at Contact form correct");
    }
  }

  public void verifyInputRecipientForm(String invalidEmail) {
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_SHOW_RECIPIENT_CHECKBOX);
    String[] content = {"BUY_GIFT_CARDS_RECIPIENT_NAME", "BUY_GIFT_CARDS_RECIPIENT_EMAIL", "BUY_GIFT_CARDS_RECIPIENT_MESSAGE"};
    String[] xpath = {BUY_GIFT_CARDS_RECIPIENT_NAME, BUY_GIFT_CARDS_RECIPIENT_EMAIL, BUY_GIFT_CARDS_RECIPIENT_MESSAGE};
    boolean recipient = verifyTwoListByAttribute(content, xpath, "placeholder");
    sendkeysToElement(driver, BUY_GIFT_CARDS_RECIPIENT_EMAIL, invalidEmail);
    sendkeysToElement(driver, BUY_GIFT_CARDS_RECIPIENT_MESSAGE, "thanks");
    if (!(verifyTextByKey("EMAIL_ERROR", BUY_GIFT_CARDS_RECIPIENT_EMAIL_ERROR) && recipient)) {
      System.out.println("ACTUAL Error Email: " + getTextElement(driver, BUY_GIFT_CARDS_RECIPIENT_EMAIL_ERROR));
    } else {
      System.out.println("Message when input invalid email at Recipient form correct");
    }
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_SHOW_RECIPIENT_CHECKBOX);
  }

  public void verifyInputInvalidAmount() {
    verifyTextInvalidAmount("BUY_GIFT_CARDS_ERROR_MESSAGE_AMOUNT_MIN", "BUY_GIFT_CARDS_ERROR_MESSAGE_AMOUNT_MAX");
  }

  public void inputContactDetail(String firstName, String lastName, String email) {
    sendkeysToElement(driver, BUY_GIFT_CARDS_CONTACT_FIRST_NAME, firstName);
    wait300Time();
    WebElement last = driver.findElement(By.xpath(BUY_GIFT_CARDS_CONTACT_EMAIL));
    setAttribute(last, "value", " ");
    last.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    sendkeysToElement(driver, BUY_GIFT_CARDS_CONTACT_LAST_NAME, lastName);
    wait300Time();

    WebElement element = driver.findElement(By.xpath(BUY_GIFT_CARDS_CONTACT_EMAIL));
//    setAttribute(element,"value"," ");
//    element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    setAttribute(element, "value", " ");
// if(StringUtils.contains( getAttribute(driver,BUY_GIFT_CARDS_CONTACT_EMAIL,"value"),"@gmail.com")){
//   getAttribute(driver,BUY_GIFT_CARDS_CONTACT_EMAIL,"value").replaceAll("@gmail.com","@yopmail.com");
// }

    sendkeysToElement(driver, BUY_GIFT_CARDS_CONTACT_EMAIL, email);
  }

  public void inputRecipient(String recipientName, String recipientEmail, String recipientMessage) {
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_SHOW_RECIPIENT_CHECKBOX);
    sendkeysToElement(driver, BUY_GIFT_CARDS_RECIPIENT_NAME, recipientName);
    wait300Time();
    sendkeysToElement(driver, BUY_GIFT_CARDS_RECIPIENT_EMAIL, recipientEmail);
    wait300Time();
    sendkeysToElement(driver, BUY_GIFT_CARDS_RECIPIENT_MESSAGE, recipientMessage);
  }

  public boolean verifyPopUpBuyGCByCrypto() {
    String[] content = {"GIFT_CARD_CRYPTO_POPUP_TITLE", "CRYPTO_POPUP_EXPIRES_TIME", "PURCHASE_TOTAL_LABEL", "PURCHASE_SUB_TOTAL_LABEL", "CRYPTO_POPUP_PAYMENT_AMOUNT",
      "CRYPTO_POPUP_PAYMENT_CONTENT", "CRYPTO_POPUP_NETWORK", "CRYPTO_POPUP_ADDRESS"};
    String[] xpath = {BUY_TC_POPUP_TITLE, BUY_TC_CRYPTO_POPUP_EXPIRES_TIME, BUY_TC_CRYPTO_POPUP_TOTAL, BUY_TC_CRYPTO_POPUP_SUB_TOTAL, BUY_TC_CRYPTO_POPUP_AMOUNT,
      BUY_TC_CRYPTO_POPUP_CONTENT, BUY_TC_CRYPTO_POPUP_NETWORK, BUY_TC_CRYPTO_POPUP_WALLET};
    if (checkShowElement(driver, BUY_TC_CRYPTO_POPUP_DISCOUNT) != 0) {
      verifyTextByKey("CRYPTO_POPUP_DISCOUNT", BUY_TC_CRYPTO_POPUP_DISCOUNT);
    }
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifyBalanceGC(String coin) {
    return Float.valueOf(getTextElement(driver, BUY_GIFT_CARDS_TOTAL_CHARGE).replaceAll(",", "")) > getWalletBalance(coin);
  }

  public void verifyTextWalletBuyGC(String coin) {
    String[] labelWallet = {"MY_WALLET_BALANCE_AVA", "MY_TC_PAYMENT_WALLET_BNB", "MY_TC_PAYMENT_WALLET_BUSD"};
    boolean label = compareTwoListByKey(labelWallet, PAYMENT_WALLET_NAME_LIST);
    String[] infoExpect = {"PAYMENT_DEPOSIT_ADDRESS", "PAYMENT_DEPOSIT_MEMO", "WALLET_NOT_ENOUGH"};
    String[] xpathWallet = {PAYMENT_WALLET_ADDRESS, PAYMENT_WALLET_MEMO, PAYMENT_ENOUGH_FUND};
    System.out.println("label: " + label);
    System.out.println("verifyTextNotEnoughCoin: " + verifyTextNotEnoughCoin(infoExpect, xpathWallet, coin));
    if (label && verifyTextNotEnoughCoin(infoExpect, xpathWallet, coin)) {
      System.out.println("Text at My Wallet when buy GC wrong! ");
    }
  }

  public void verifyTextAtPurchaseGC() {
    inputAmount(randomNumber());
    boolean credit = true;
    boolean crypto = true;
    boolean wallet = true;
    List<WebElement> elements = driver.findElements(By.xpath(PAYMENT_METHOD_LIST));
    int i = 1;
    while (i < elements.size() + 1) {
      String xpathMethod = String.format(PAYMENT_METHOD_LIST_LABEL, i);
      clickToElementByJavascript(driver, xpathMethod);
      String methodPayment = getTextElement(driver, xpathMethod);
      switch (methodPayment) {
        case "Credit Card":
          String[] contentFee = {"PURCHASE_DISCOUNT_LABEL", "PURCHASE_FEE_LABEL", "PURCHASE_SERVICE_LABEL"};
          credit = verifyTextCreditCardOption(driver) &&  compareTwoListByKey(contentFee, BUY_GC_PURCHASE_LABEL) && verifyTextByKey("PAYMENT_CREDIT_CARD_LABEL", xpathMethod);
          if(!credit){
            System.out.println("Text credit card fee at Buy GC wrong!");
          }else {
            System.out.println("Text credit card fee at Buy GC correct!");
          }
          break;
        case "Crypto":
//          String[] contentCrypto = {"CRYPTO_SELECT_LABEL", "CRYPTO_SELECT_HOLDER", "CRYPTO_SELECT_NETWORK_LABEL", "CRYPTO_SELECT_NETWORK_LABEL"};
//          String[] xpathCrypto = {BUY_TC_CRYPTO_SELECT_LABEL, BUY_TC_CRYPTO_SELECT_HOLDER, BUY_TC_CRYPTO_SELECT_NETWORK_HOLDER, BUY_TC_CRYPTO_SELECT_NETWORK_LABEL};
//          crypto = verifyTwoListByKey(contentCrypto, xpathCrypto) && verifyTextByKey("MY_WALLET_SUMMARY_CRYPTO", xpathMethod);
          break;
        case "My Wallet":
//          String[] contentWallet = {"BUY_TC_WALLET_NOTE_DEPOSIT", "BUY_TC_WALLET_NOTE_NETWORK", "BUY_TC_WALLET_NOTE_MEMO"};
//          String[] xpathWallet = {BUY_TC_WALLET_NOTE_DEPOSIT, BUY_TC_WALLET_NOTE_NETWORK, BUY_TC_WALLET_NOTE_MEMO};
//          wallet = verifyTwoListByKey(contentWallet, xpathWallet) && verifyTextByKey("MY_WALLET_MY_WALLET_TTTLE", xpathMethod);
          break;
      }
      i++;
    }
    if ( credit && crypto && wallet) {
      System.out.println("Text at Payment when buy GC correct!");
    } else {
      System.out.println("Text at Payment when buy GC wrong!");
    }
  }

  public void verifyTextPaymentGC() {
    boolean credit = verifyTextCreditCardOption(driver);
    clickToElementByJavascript(driver, CREDIT_CARD_OPTION);
    verifyDisplayLogoCrypto("BTC");
    if (!credit) {
      System.out.println("Text at payment method when buy GC wrong");
    } else {
      System.out.println("Text at payment method when buy GC correct");
    }
  }

  public void linkToYopMail(String yopMail) {
    openNewTab(driver, YOP_MAIL_URL);
    switchToOtherWindowbyUrl(driver, YOP_MAIL_URL);
    sendkeysToElement(driver, YOP_MAIL_TXT, yopMail);
    wait5sTime();
    clickToElement(driver, YOP_MAIL_SUBMIT_BTN);
    wait5sTime();
  }

  public List<String> getDetailPurchaseExp(String coin) {
    List<String> listExp = new ArrayList<String>();
    listExp.add(getAttribute(driver, BUY_GIFT_CARDS_CONTACT_FIRST_NAME, "value"));
    listExp.add(getAttribute(driver, BUY_GIFT_CARDS_CONTACT_LAST_NAME, "value"));
    listExp.add(getTextElement(driver, BUY_GIFT_CARDS_SUB_TOTAL).replace("US$", "US$ "));
    listExp.add(getDateTimeNow("EEE, dd MMM yyyy"));
    List<WebElement> elements = driver.findElements(By.xpath(BUY_GC_PAYMENT_METHOD_LIST));
    int i = 1;
    String getMethod = null;
    while (i < elements.size() + 1) {
      if (StringUtils.contains(getAttribute(driver, String.format(BUY_GC_PAYMENT_METHOD_DYNAMIC, i), "class"), "_active_")) {
        getMethod = getAttribute(driver, String.format(BUY_GC_PAYMENT_METHOD_VALUE, i), "value");
      }
      i++;
    }
    System.out.println("Payment method: " + getMethod);
    switch (getMethod) {
      case "credit_cards":
        listExp.add("Credit Card");
        break;
      case "crypto":
        listExp.add("Crypto");
        break;
      case "wallet":
        listExp.add("My Wallet - " + coin);
        break;
//        List<WebElement> elements1 = driver.findElements(By.xpath(BUY_GC_WALLET_LIST));
//        int j = 1;
//        String checkWallet = null;
//        System.out.println("size; "+elements1.size());
//        while (j <= elements1.size() ) {
//          String xpath = String.format(BUY_GC_WALLET_VALUE, i);
//          System.out.println(xpath);
//          if (StringUtils.contains(getAttribute(driver,xpath , "checked"), "")) {
//            checkWallet = getAttribute(driver, xpath, "value");
//          }
//          j++;
//        }

    }
    return listExp;
  }

  public boolean verifyDetailPurchaseOnMail(List<String> listExp) {
    boolean status = true;
    List<String> getInformationBuyGCAct = addListActualAfterSplitText(DETAIL_PURCHASE_LIST, DETAIL_PURCHASE_DYNAMIC, ":", 1);
    for (String element : getInformationBuyGCAct) {
      if (!listExp.contains(element.trim())) {
        System.out.println("Actual Detail Purchase Success failed:" + element);
        status = false;
      }
    }
    return status;
  }

  public void verifyPopupSendEmailSuccess() {
    if (!(verifyTextByKey("BUY_GIFT_PURCHASE_POPUP_TITLE_SUCCESS", BUY_GIFT_PURCHASE_POPUP_TITLE) && verifyTextByKey("BUY_GIFT_PURCHASE_POPUP_CONTENT_SUCCESS", BUY_GIFT_PURCHASE_POPUP_CONTENT))) {
      System.out.println("Content PopUp Purchase Completed wrong");
    }
    clickToElementByJavascript(driver, BUY_GIFT_PURCHASE_POPUP_BTN);
  }

  public void verifyTextOnEmailSuccess(List<String> listExp) {
    reloadPage(driver);
    switchToIframe(driver, IFRAME_EMAIL);
    String[] xpathTks = {TITLE_EMAIL_TXT, THANK_YOU_TXT, CONTENT_TXT, DETAIL_PURCHASE_TXT, REDEEM_GC_TXT, NOTE_REDEEM_TXT, NOTE_REDEEM_SUPPORT_TXT, BEST_WISH_TXT};
    String[] contentTks = {"BUY_GC_TITLE_EMAIL_SUCCESS", "THANK_YOU_TXT", "BUY_GC_CONTENT_SUCCESS", "DETAIL_PURCHASE_TXT", "REDEEM_GC_TXT", "NOTE_REDEEM_TXT", "NOTE_REDEEM_SUPPORT_TXT", "BEST_WISH_TXT"};
    boolean text = verifyTwoListByKey(contentTks, xpathTks);
    boolean footer = verifyTextByKey("FOOTER_MAIL", FOOTER_MAIL);
    boolean name = StringUtils.contains(getTextBySplit(getTextElement(driver, NAME_RECEIVED), " ", 1).replaceAll(",", "").trim(),
      getTextBySplit(getTextElement(driver, DETAIL_PURCHASE_FIRST_NAME), ":", 1).trim());
    if (!name) {
      System.out.println("Actual First Name: " + getTextBySplit(getTextElement(driver, NAME_RECEIVED), " ", 1).replaceAll(",", ""));
      System.out.println("Expect First Name: " + getTextBySplit(getTextElement(driver, DETAIL_PURCHASE_FIRST_NAME), ":", 1));
    }
    String[] redeemStep = {"REDEEM_GC_STEP1", "REDEEM_GC_STEP2", "REDEEM_GC_STEP3", "REDEEM_GC_STEP4"};
    boolean step = compareTwoListByKey(redeemStep, REDEEM_GC_STEP);
    boolean detailPurchase = verifyDetailPurchaseOnMail(listExp);
    driver.switchTo().parentFrame();
    if (!(text && step && detailPurchase && footer && name)) {
      System.out.println("Text on mail Purchase GC Successfully wrong");
    } else {
      System.out.println("Text on mail Purchase GC Successfully correct");
    }
  }

  public void verifyEmailBuyByCreditCard(String yopMail) {
    inputCreditCard(VALID_CARD_NUMBER, VALID_EXP_DATE, VALID_CVC);
    wait100Time();
    getInforBuyGCExp = getDetailPurchaseExp("Credit Card");
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
    if (StringUtils.contains(getCurrentUrl(driver), "staging") || StringUtils.contains(getCurrentUrl(driver), "heroku")) {
      verifyPopupSendEmailSuccess();
      wait5sTime();
      linkToYopMail(yopMail);
      wait5sTime();
      verifyTextOnEmailSuccess(getInforBuyGCExp);
    } else {
      System.out.println("The number card invalid on Live environment");
    }
  }

  public void verifyEmailBuyByCreditCardSendAsGift(String yopMail, String giftMessage) {
    inputCreditCard(VALID_CARD_NUMBER, VALID_EXP_DATE, VALID_CVC);
    wait100Time();
    getInforBuyGCExp = getDetailPurchaseExp("Credit Card");
    String firstName = getAttribute(driver, BUY_GIFT_CARDS_CONTACT_FIRST_NAME, "value");
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
    if (StringUtils.contains(getCurrentUrl(driver), "staging") || StringUtils.contains(getCurrentUrl(driver), "heroku")) {
      verifyPopupSendEmailSuccess();
      wait5sTime();
      linkToYopMail(yopMail);
      wait5sTime();
      verifyEmailSendAsGiftN(giftMessage, firstName);
    } else {
      System.out.println("The number card invalid on Live environment");
    }
  }

  public void clickOnCoinWalletToPayment(String coinWallet) {
    clickToElementByJavascript(driver, MY_WALLET_OPTION);
    verifyNameWallet();
    String xpathCoin = String.format(WALLET_COIN_CHECKBOX, coinWallet);
    clickToElementByJavascript(driver, xpathCoin);
  }

  public void verifyEmailBuyByWallet(String coinWallet, String yopMail) {
    clickOnCoinWalletToPayment(coinWallet);
    boolean b = true;
    if (verifyBalanceGC(coinWallet)) {
      System.out.println("===You don't have " + coinWallet + " to buy Gift Card===");
      verifyTextWalletBuyGC(coinWallet);
    } else {
      System.out.println("===You have " + coinWallet + " to buy Gift Card===");
      getInforBuyGCExp = getDetailPurchaseExp(coinWallet);
      for (int i = 0; i < getInforBuyGCExp.size(); i++) {
        if (!StringUtils.contains(getInforBuyGCExp.get(i), "My Wallet")) {
          System.out.println(getInforBuyGCExp.get(i));
          b = false;
        }
      }
      if (!b) {
        System.out.println("Buy GC by Wallet is Error!");
      } else {
        clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
        verifyPopupSendEmailSuccess();
        wait5sTime();
        wait2sTime();
        linkToYopMail(yopMail);
        wait5sTime();
        verifyTextOnEmailSuccess(getInforBuyGCExp);
      }
    }
  }

  public void verifyEmailBuyByWalletSendAsGift(String coinWallet, String yopMail, String giftMessage) {
    clickOnCoinWalletToPayment(coinWallet);
    if (verifyBalanceGC(coinWallet)) {
      System.out.println("===You don't have " + coinWallet + " in wallet to buy Gift Card===");
    } else {
      clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
      verifyPopupSendEmailSuccess();
      wait5sTime();
      wait5sTime();
      linkToYopMail(yopMail);
      wait5sTime();
      if (verifyEmailSendAsGift(giftMessage)) {
        System.out.println("Email when buy GC to send as Gift payment by Wallet with " + coinWallet + "correct");
      }
    }
  }

  public void verifyTextOnEmailProcess(List<String> listExp) {
    switchToIframe(driver, IFRAME_EMAIL);
    String[] xpathTks = {TITLE_EMAIL_TXT, THANK_YOU_PROCESS, INFORMED_PROCESS, PAYMENT_PROCESS, SUPPORT_PROCESS};
    String[] contentTks = {"BUY_GC_TITLE_EMAIL_PROCESS", "THANK_YOU_TXT", "INFORMED_PROCESS", "PAYMENT_PROCESS", "NOTE_REDEEM_SUPPORT_TXT"};
    boolean text = verifyTwoListByKey(contentTks, xpathTks);
    int i = 5;
    List<String> listAct = new ArrayList<String>();
    List<WebElement> element = driver.findElements(By.xpath(DETAIL_PAYMENT_LIST));
    while (i <= element.size() - 1) {
      String xpath = String.format(DETAIL_PAYMENT_DYNAMIC, i);
      listAct.add(getTextBySplit(getTextElement(driver, xpath), ":", 1));
      i++;
    }
    boolean b = true;
    for (String detail : listAct) {
      if (!listExp.contains(detail.trim())) {
        System.out.println("Actual Detail Purchase Processing failed:" + detail);
        b = false;
      }
    }
    driver.switchTo().parentFrame();
    if (!(text && b)) {
      System.out.println("Text on mail Purchase GC Processing wrong");
    } else {
      System.out.println("Text on mail Purchase GC Processing correct");
    }
  }

  public List<String> getDetailPurchaseCryptoExp(String coin) {
    List<String> listExp = new ArrayList<String>();
    listExp.add(getAttribute(driver, BUY_GIFT_CARDS_CONTACT_FIRST_NAME, "value"));
    listExp.add(getAttribute(driver, BUY_GIFT_CARDS_CONTACT_LAST_NAME, "value"));
    listExp.add(getTextElement(driver, BUY_GIFT_CARDS_SUB_TOTAL).replace("US$", "US$ "));
    listExp.add((getTextElement(driver, INPUT_CRYPTO_SELECTED) + " " + "(" + getTextElement(driver, INPUT_CRYPTO_NETWORK_SELECTED) + ")").trim());
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
    wait1sTime();
    if (checkShowElement(driver, POPUP_ERROR_CONTENT) != 0) {
      System.out.println("The message is: " + getTextElement(driver, POPUP_ERROR_CONTENT));
      System.out.println("======Error payment by " + coin + " when buy gift card===========");
      clickToElement(driver, POPUP_CLOSE_BTN);
      clickBackToTravala(driver);
    } else {
      listExp.add(getTextElement(driver, BUY_GC_CRYPTO_PAYMENT_AMOUNT));
      listExp.add(getTextElement(driver, BUY_GC_CRYPTO_ADDRESS));
      if (checkShowElement(driver, BUY_GC_CRYPTO_MEMO_LABEL) != 0) {
        listExp.add(getTextElement(driver, BUY_GC_CRYPTO_MEMO));
      }
      listExp.add((getTextElement(driver, BUY_TC_CRYPTO_POPUP_EXPIRES_TIME).replaceAll("Expires within", "").trim()));
      if (!verifyPopUpBuyGCByCrypto()) {
        System.out.println("Content in Crypto Popup when buy Gift Card wrong! ");
      }
      reloadPage(driver);
      for (int i = 0; i < listExp.size(); i++) {
        System.out.println(listExp.get(i));
      }
    }
    return listExp;
  }

  public void verifyBuyGCByCrypto(String coin, String yopMail) {
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    selectCoinFromCryptoOption(coin);
    wait300Time();
    getInforBuyGCExp = getDetailPurchaseCryptoExp(coin);
    wait2sTime();
    linkToYopMail(yopMail);
    verifyTextOnEmailProcess(getInforBuyGCExp);
  }

  public void verifyBuyGCSendAsGiftByCrypto(String coin, String yopMail, String giftMessage) {
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    selectCoinFromCryptoOption(coin);
    wait300Time();
    clickToElementByJavascript(driver, BUY_GIFT_CARDS_PURCHASE_BTN);
    if (checkShowElement(driver, POPUP_ERROR_CONTENT) != 0) {
      System.out.println("The message is: " + getTextElement(driver, POPUP_ERROR_CONTENT));
      System.out.println("======Error payment by " + coin + " when buy gift card===========");
      clickToElement(driver, POPUP_CLOSE_BTN);
      clickBackToTravala(driver);
    } else {
      if (!verifyPopUpBuyGCByCrypto()) {
        System.out.println("Content in Crypto Popup when buy Gift Card wrong! ");
      }
      wait2sTime();
      wait5sTime();
      wait5sTime();
      linkToYopMail(yopMail);
      verifyEmailSendAsGift(giftMessage);
    }
  }

  public boolean verifyEmailSendAsGift(String giftMessage) {
    reloadPage(driver);
    switchToIframe(driver, IFRAME_EMAIL);
    String[] xpath = {TITLE_EMAIL_TXT, BUY_GC_SEND_GIFT_MESSAGE_LABLE, BUY_GC_SEND_GIFT_REDEEM_TITLE, BUY_GC_SEND_GIFT_MESSAGE, REDEEM_GC_TXT, NOTE_REDEEM_TXT, NOTE_REDEEM_SUPPORT_TXT, BEST_WISH_TXT};
    String[] content = {"BUY_GC_SEND_GIFT_TITLE_EMAIL", "BUY_GC_SEND_GIFT_MESSAGE_LABLE", "TRAVEL_GIFT_CARD_QUESTION2_CONTENT2", "REDEEM_GC_TXT", "NOTE_REDEEM_TXT", "NOTE_REDEEM_SUPPORT_TXT", "BEST_WISH_TXT"};
    boolean text = verifyTwoListByKey(content, xpath);
    getTextElement(driver, TITLE_EMAIL_TXT);
    boolean message = StringUtils.contains(getTextElement(driver, BUY_GC_SEND_GIFT_MESSAGE).replace("\"", ""), giftMessage);
    String[] contentMail = {"BUY_GC_SEND_GIFT_CONTENT1", "BUY_GC_SEND_GIFT_CONTENT2", "BUY_GC_SEND_GIFT_CONTENT3", "BUY_GC_SEND_GIFT_CONTENT4"};
    boolean bContent = compareTwoListByKey(contentMail, BUY_GC_SEND_GIFT_CONTENT);
    String[] contentStep = {"REDEEM_GC_STEP1", "REDEEM_GC_STEP2", "REDEEM_GC_STEP3", "REDEEM_GC_STEP4"};
    boolean bCStep = compareTwoListByKey(contentStep, BUY_GC_SEND_GIFT_REDEEM_STEP);
    driver.switchTo().parentFrame();
    if (!(message && text && bContent && bCStep)) {
      System.out.println("Text on mail Purchase GC to send as Gift wrong");
    }
    return message && text && bContent && bCStep;
  }

  public boolean verifyEmailSendAsGiftN(String giftMessage, String firstName) {
    reloadPage(driver);
    switchToIframe(driver, IFRAME_EMAIL);
    boolean firstNameB = StringUtils.contains(getTextElement(driver, TITLE_EMAIL_TXT), firstName + " " + getTextFromReadFile("BUY_GC_SEND_GIFT_TITLE_EMAIL"));
    boolean giftMessB = StringUtils.contains(getTextElement(driver, BUY_GC_SEND_GIFT_MESSAGE), giftMessage);
    String[] xpath = {BUY_GC_SEND_GIFT_MESSAGE_LABLE, BUY_GC_SEND_GIFT_REDEEM_TITLE, REDEEM_GC_TXT, NOTE_REDEEM_TXT, NOTE_REDEEM_SUPPORT_TXT, BEST_WISH_TXT};
    String[] content = {"BUY_GC_SEND_GIFT_MESSAGE_LABLE", "TRAVEL_GIFT_CARD_QUESTION2_CONTENT2", "REDEEM_GC_TXT", "NOTE_REDEEM_TXT", "NOTE_REDEEM_SUPPORT_TXT", "BEST_WISH_TXT"};
    boolean text = verifyTwoListByKey(content, xpath);
    getTextElement(driver, TITLE_EMAIL_TXT);
    boolean message = StringUtils.contains(getTextElement(driver, BUY_GC_SEND_GIFT_MESSAGE).replace("\"", ""), giftMessage);
    String[] contentMail = {"BUY_GC_SEND_GIFT_CONTENT1", "BUY_GC_SEND_GIFT_CONTENT2", "BUY_GC_SEND_GIFT_CONTENT3", "BUY_GC_SEND_GIFT_CONTENT4"};
    boolean bContent = compareTwoListByKey(contentMail, BUY_GC_SEND_GIFT_CONTENT);
    String[] contentStep = {"REDEEM_GC_STEP1", "REDEEM_GC_STEP2", "REDEEM_GC_STEP3", "REDEEM_GC_STEP4"};
    boolean bCStep = compareTwoListByKey(contentStep, BUY_GC_SEND_GIFT_REDEEM_STEP);
    driver.switchTo().parentFrame();
    if (!(message && text && bContent && bCStep)) {
      System.out.println("Text on mail Purchase GC to send as Gift wrong");
    }
    return message && text && bContent && bCStep;
  }

  public void verifyContentMail() {
    linkToYopMail("thuhuong671");
    linkToYopMail("thuhuong283");
    linkToYopMail("thuhuong535");
//    linkToYopMail("thuhuong123"); send gc success
    List<String> listExp = new ArrayList<String>();
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE1"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE2"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE3"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE4"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE5"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE5"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE5"));
    listExp.add(getTextFromReadFile("DETAIL_PURCHASE5"));
    verifyTextOnEmailProcess(listExp);
  }

}
