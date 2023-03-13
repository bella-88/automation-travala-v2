package pages.hotel.myProfile;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.hotel.footer.travala.BuyGiftCardPage;

import java.util.List;


import static commons.CommonDataTravala.*;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.*;
import static interfaces.hotel.CheckOutPageUI.*;
import static interfaces.hotel.footer.travala.BuyGiftCardPageUI.*;

import static interfaces.hotel.footer.travala.TravelGiftCardPageUI.*;
import static interfaces.hotel.myProfile.MyTravelCreditsPageUI.*;

public class MyTravelCreditsPage extends CommonHotelPages {
  WebDriver driver;

  public MyTravelCreditsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextAtPurchaseTC() {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_AMOUNT50);
    String[] contentPurchase = {"MY_TRAVEL_CREDIT_PURCHASE", "MY_TRAVEL_CREDIT_PURCHASE_AMOUNT_LABEL", "MY_TRAVEL_CREDIT_PURCHASE_CREDITS_BTN"};
    String[] xpath = {PURCHASE_TC_TITLE, PURCHASE_TC_AMOUNT_LABEL, PURCHASE_CREDITS_BTN};
    boolean purchase = verifyTwoListByKey(contentPurchase, xpath);
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
          String[] contentFee = {"PURCHASE_ITEM_LABEL", "PURCHASE_SUB_TOTAL_LABEL", "PURCHASE_TOTAL_LABEL"};
          credit = verifyTextCreditCardOption(driver) && compareTwoListByKey(contentFee, PURCHASE_TC_LABEL) && verifyTextByKey("PAYMENT_CREDIT_CARD_LABEL", xpathMethod);
          if (!credit) {
            System.out.println("Text credit card at Buy TC wrong!");
          } else {
            System.out.println("Text credit card at Buy TC correct!");
          }
          break;
        case "Crypto":
          String[] contentCrypto = {"CRYPTO_SELECT_LABEL", "CRYPTO_SELECT_HOLDER", "CRYPTO_SELECT_NETWORK_LABEL", "CRYPTO_SELECT_NETWORK_LABEL"};
          String[] xpathCrypto = {BUY_TC_CRYPTO_SELECT_LABEL, BUY_TC_CRYPTO_SELECT_HOLDER, BUY_TC_CRYPTO_SELECT_NETWORK_HOLDER, BUY_TC_CRYPTO_SELECT_NETWORK_LABEL};
          crypto = verifyTwoListByKey(contentCrypto, xpathCrypto) && verifyTextByKey("MY_WALLET_SUMMARY_CRYPTO", xpathMethod);
          if (!crypto) {
            System.out.println("Text crypto at Buy TC wrong!");
          } else {
            System.out.println("Text crypto at Buy TC correct!");
          }
          break;
        case "My Wallet":
          String[] contentWallet = {"BUY_TC_WALLET_NOTE_DEPOSIT", "BUY_TC_WALLET_NOTE_NETWORK", "BUY_TC_WALLET_NOTE_MEMO"};
          String[] xpathWallet = {BUY_TC_WALLET_NOTE_DEPOSIT, BUY_TC_WALLET_NOTE_NETWORK, BUY_TC_WALLET_NOTE_MEMO};
          wallet = verifyTwoListByKey(contentWallet, xpathWallet) && verifyTextByKey("MY_WALLET_MY_WALLET_TTTLE", xpathMethod);
          if (!wallet) {
            System.out.println("Text wallet at Buy TC wrong!");
          } else {
            System.out.println("Text wallet at Buy TC correct!");
          }
          break;
      }
      i++;
    }
//    if (purchase && credit && crypto && wallet) {
//      System.out.println("Text at Payment when buy TC correct!");
//    } else {
//      System.out.println("Text at Payment when buy TC wrong!");
//    }
  }

  public void verifyTextPaymentWalletTC() {
    clickToElementByJavascript(driver, MY_WALLET_OPTION);
    reloadPage(driver);
    verifyWalletName();
    int i = 1;
    List<WebElement> elements = driver.findElements(By.xpath(MY_TC_WALLET_PAYMENT));
    boolean a = true;
    boolean b = true;
    boolean c = true;
    while (i < elements.size() + 1) {
      clickElementByDynamicLocator(driver, MY_TC_WALLET_PAYMENT_DYNAMIC, String.valueOf(i));
      String coin = getAttribute(driver, String.format(MY_TC_WALLET_PAYMENT_DYNAMIC, i), "value");
      String[] xpath = {MY_TC_PAYMENT_INSUFFICIENT_FUND, WALLET_TC_PAYMENT_ADDRESS, WALLET_TC_PAYMENT_MEMO};
      String[] informationNote = {"WALLET_TC_PAYMENT_NOTE2", "WALLET_TC_PAYMENT_NOTE1", "WALLET_TC_PAYMENT_NOTE3"};
      String[] content = {"WALLET_TC_WALLET_NOT_ENOUGH", "PAYMENT_DEPOSIT_ADDRESS", "PAYMENT_DEPOSIT_MEMO"};
      switch (coin) {
        case "AVA":
          if (!(verifyTwoListByConst(xpath, addListExpectAfterFormatFromKey(content, coin)) && compareTwoListByConst(addListExpectAfterFormatFromKey(informationNote, coin), WALLET_TC_PAYMENT_NOTE))) {
            a = false;
            System.out.println("BUY TC - Text at payment method of wallet by AVA wrong");
          }
          break;
        case "BNB":
          b = false;
          if (!(verifyTwoListByConst(xpath, addListExpectAfterFormatFromKey(content, coin)) && compareTwoListByConst(addListExpectAfterFormatFromKey(informationNote, coin), WALLET_TC_PAYMENT_NOTE))) {
            System.out.println("BUY TC - Text at payment method of wallet by BNB wrong");
          }
          break;
        case "BUSD":
          c = false;
          if (!(verifyTwoListByConst(xpath, addListExpectAfterFormatFromKey(content, coin)) && compareTwoListByConst(addListExpectAfterFormatFromKey(informationNote, coin), WALLET_TC_PAYMENT_NOTE))) {
            System.out.println("BUY TC - Text at payment method of wallet by BUSD wrong");
          }
          break;
        default:
          System.out.println("Can not choice a coin at my wallet when buy TC");
          break;
      }
      i++;
    }
    if (a && b && c) {
      System.out.println("Display text at payment method of Travel Credit page correct");
    } else {
      System.out.println("Display text at payment method of Travel Credit page wrong");
    }
  }

  public String getTotalPrice() {
    return getTextElement(driver, BUY_TC_PAYMENT_TOTAL_PRICE);
  }

  public String getTotalTC() {
    return getTextElement(driver, MY_TC_TOTAL_TC).replaceAll(",", "");
  }

  public String getAmountTC() {
    return getTextElement(driver, BUY_TC_PAYMENT_AMOUNT).replaceAll("US", "").substring(1);
  }

  public boolean verifyStatusNoteInfoTransaction(String beforePrice, String coin) {
    boolean noteCC = true;
    boolean noteC = true;
    boolean noteW = true;
    String noteTx = getTextElement(driver, MY_TC_SUMMARY_NOTE);
    if (StringUtils.contains(noteTx, "My Wallet")) {
      String[] statusWallet = {"SUMMARY_STATUS_PROCESS", "SUMMARY_STATUS_SUCCESS"};
      boolean noteWallet = true;
      if (!StringUtils.contains(noteTx, getTextFromReadFile("MY_TC_SUMMARY_NOTE_WALLET") + " " + coin)) {
        System.out.println("ACTUAL Note TX With Wallet: " + getTextElement(driver, MY_TC_SUMMARY_NOTE));
        System.out.println("EXPECT Note TX With Wallet: " + getTextFromReadFile("MY_TC_SUMMARY_NOTE_WALLET") + " " + coin);
        noteWallet = false;
      }
      if (!(noteWallet && verifyListExpectWithItem(statusWallet, MY_TC_PURCHASE_STATUS) && verifyTextByKey("MY_TC_SUMMARY_INFO_TRANSACTION", MY_TC_SUMMARY_INFORMATION))) {
        noteW = false;
      }
    }
    if (StringUtils.contains(noteTx, "US$")) {
      if (!StringUtils.contains(noteTx, getTextFromReadFile("MY_TC_SUMMARY_NOTE") + " " + beforePrice)) {
        System.out.println("ACTUAL Note TX With Credit Card: " + getTextElement(driver, MY_TC_SUMMARY_NOTE));
        System.out.println("EXPECT Note TX With Credit Card: " + getTextFromReadFile("MY_TC_SUMMARY_NOTE") + " " + beforePrice);
        noteCC = false;
      }
    }
    if (StringUtils.contains(noteTx, "Token")) {
      boolean note = true;
      String[] statusCrypto = {"SUMMARY_STATUS_PROCESS", "SUMMARY_STATUS_FAILED", "SUMMARY_STATUS_EXPIRED"};
      if (!StringUtils.contains(noteTx, getTextFromReadFile("MY_TC_SUMMARY_NOTE") + "  " + beforePrice + " " + coin)) {
        System.out.println("ACTUAL Note TX With Crypto: " + getTextElement(driver, MY_TC_SUMMARY_NOTE));
        System.out.println("EXPECT Note TX With Crypto: " + getTextFromReadFile("MY_TC_SUMMARY_NOTE") + "  " + beforePrice + " " + coin);
        note = false;
      }
      if (!(note && verifyListExpectWithItem(statusCrypto, MY_TC_PURCHASE_STATUS) && verifyTextByKey("MY_TC_SUMMARY_INFO_ADDRESS", MY_TC_SUMMARY_INFORMATION) && verifyTextByKey(
        "MY_TC_SUMMARY_INFO_TRANSACTION", MY_TC_SUMMARY_CRYPTO_NO))) {
        noteC = false;
      }
    }
    return noteC && noteCC && noteW;
  }

  public boolean verifyAmountTransaction(String beforeAmount) {
    boolean amountTX = true;
    if (!StringUtils.contains(getTextElement(driver, MY_TC_SUMMARY_AMOUNT), beforeAmount.trim())) {
      System.out.println("ACTUAL: " + getTextElement(driver, MY_TC_SUMMARY_AMOUNT));
      System.out.println("EXPECT: " + beforeAmount.trim());
      System.out.println("Amount Transaction buy TC wrong");
      amountTX = false;
    }
    return amountTX;
  }

  public void verifyTextTransactionBuyTC(String beforeAmount, String beforePrice, String beforeTC, String coin) {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_SUMMARY_TAB);
    wait1sTime();
    boolean dateTX = true;
    if (!(StringUtils.contains(getTextElement(driver, MY_TC_SUMMARY_DATE).trim(), getDateTimeNow("dd/MM/yyyy").trim()))) {
      System.out.println("Actual Date Transaction after buy TC: " + getTextElement(driver, MY_TC_SUMMARY_DATE));
      System.out.println("Expect Date Transaction after buy TC: " + getDateTimeNow("dd/MM/yyyy"));
      dateTX = false;
    }
    if (verifyTextByKey("MY_TC_TYPE", MY_TC_PURCHASE_TYPE) && verifyAmountTransaction(beforeAmount) && verifyStatusNoteInfoTransaction(beforePrice, coin) && dateTX) {
      System.out.println("Text Transaction After buy TC correct!");
    } else {
      System.out.println("Text Transaction After buy TC wrong!");
    }

  }

  public void verifyTextSelectAmountTC() {
    wait300Time();
    verifyTextInvalidAmount("MY_TRAVEL_CREDIT_ERROR_MESSAGE_AMOUNT_MIN", "MY_TRAVEL_CREDIT_ERROR_MESSAGE_AMOUNT_MAX");
    String[] content = {"MY_TRAVEL_CREDIT_BANNER", "MY_TRAVEL_CREDIT_BANNER_AVAILABLE_AMOUNT", "MY_TRAVEL_CREDIT_BANNER_PENDING_AMOUNT", "MY_TRAVEL_CREDIT_BUY_TAB",
      "MY_TRAVEL_CREDIT_SUMMARY_TAB", "MY_TRAVEL_CREDIT_REDEEM_TAB", "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT", "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUB",
      "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_NOTE", "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_OTHER", "MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUPPORT", "MY_TRAVEL_CREDIT_BUY_SELECT_PAYMENT"};
    String[] xpath = {MY_TRAVEL_CREDIT_BANNER, MY_TRAVEL_CREDIT_BANNER_AVAILABLE_AMOUNT, MY_TRAVEL_CREDIT_BANNER_PENDING_AMOUNT, MY_TRAVEL_CREDIT_BUY_TAB, MY_TRAVEL_CREDIT_SUMMARY_TAB,
      MY_TRAVEL_CREDIT_REDEEM_TAB, MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT, MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUB, MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_NOTE, MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_OTHER,
      MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUPPORT, MY_TRAVEL_CREDIT_BUY_SELECT_PAYMENT};
    if (verifyTwoListByKey(content, xpath)) {
      System.out.println("Text on Select amount Buy TC correct");
    } else {
      System.out.println("Text on Select amount Buy TC wrong");
    }
  }

  public void verifyTextRedeemTab() {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_REDEEM_TAB);
    wait1sTime();
    String[] content = {"MY_TRAVEL_REDEEM_TC", "MY_TRAVEL_REDEEM_CONTENT", "MY_TRAVEL_REDEEM_GIFT_CARD_BTN", "MY_TRAVEL_REDEEM_GIFT_CARD_LINK"};
    boolean a = StringUtils.contains(getAttribute(driver, MY_TRAVEL_REDEEM_TXT, "placeholder"), getTextFromReadFile("MY_TRAVEL_REDEEM_TXT"));
    if (!a) {
      System.out.println("Actual: Redeem textbox holder: " + getAttribute(driver, MY_TRAVEL_REDEEM_TXT, "placeholder"));
      System.out.println("Expect: Redeem textbox holder: " + getTextFromReadFile("MY_TRAVEL_REDEEM_TXT"));
    }
    wait1sTime();
    String[] xpath = {MY_TRAVEL_REDEEM_TC, MY_TRAVEL_REDEEM_CONTENT, MY_TRAVEL_REDEEM_GIFT_CARD_BTN, MY_TRAVEL_REDEEM_GIFT_CARD_LINK};
    if (verifyTwoListByKey(content, xpath) && a) {
      System.out.println("REDEEM Tab at My TC CORRECT");
    } else {
      System.out.println("REDEEM Tab at My TC WRONG");
    }
  }

  public void verifyTextSummaryTab() {
    wait1sTime();
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_SUMMARY_TAB);
    String[] content = {"MY_TRAVEL_SUMMARY_FILTER_TXT", "MY_TRAVEL_SUMMARY_FILTER_LIST", "MY_WALLET_SUMMARY_STATUS_HEADER", "MY_TRAVEL_SUMMARY_STATUS_LIST",
      "MY_WALLET_DEPOSIT_DATE1", "MY_WALLET_SUMMARY_TYPE_HEADER", "MY_WALLET_SUMMARY_STATUS_HEADER", "MY_WALLET_SUMMARY_AMOUNT_HEADER",
      "MY_WALLET_SUMMARY_DATE_HEADER", "MY_WALLET_SUMMARY_NOTE_HEADER", "MY_WALLET_SUMMARY_INFO_HEADER"};
    String[] xpath = {MY_TRAVEL_SUMMARY_FILTER_TXT, MY_TRAVEL_SUMMARY_FILTER_LIST, MY_TRAVEL_SUMMARY_STATUS_TXT, MY_TRAVEL_SUMMARY_STATUS_LIST, MY_TRAVEL_SUMMARY_DATE_TXT,
      MY_TRAVEL_SUMMARY_TYPE_HEADER, MY_TRAVEL_SUMMARY_STATUS_HEADER, MY_TRAVEL_SUMMARY_AMOUNT_HEADER, MY_TRAVEL_SUMMARY_DATE_HEADER,
      MY_TRAVEL_SUMMARY_NOTE_HEADER, MY_TRAVEL_SUMMARY_INFO_HEADER};
    if (verifyTwoListByKey(content, xpath)) {
      System.out.println("SUMMARY TAB at My TC CORRECT");
    } else {
      System.out.println("SUMMARY TAB at My TC WRONG");
    }
  }

  public void verifyPaymentTCByCreditsCard() {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_BUY_TAB);
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_AMOUNT50);
    inputCreditCard(VALID_CARD_NUMBER, VALID_EXP_DATE, VALID_CVC);
    String beforeTC = getTotalTC();
    String beforePrice = getTotalPrice();
    String beforeAmount = getAmountTC();
    System.out.println("Number TC Before: " + beforeTC);
    System.out.println("Price Before: " + beforePrice);
    System.out.println("Amount TC Purchase: " + beforeAmount);
    clickToElement(driver, PURCHASE_SUBMIT_BTN);
    wait1sTime();
    if (checkShowElement(driver, CREDIT_CARD_WARNING) == 0) {
      System.out.println("Buy TC payment by Credit Card Success!");
      verifyTextTransactionBuyTC(beforeAmount, beforePrice, beforeTC, "Credit Card");
    } else {
      System.out.println("Card Number invalid! Can not payment TC by Credit Card");
    }
    reloadPage(driver);
  }

  public Double selectCryptoToPayment(String coin) {
    sendkeysToElement(driver, INPUT_CRYPTO_TXT, coin);
    wait300Time();
    String xpath = String.format(CRYPTO_DYNAMIC, coin);
    String miniPriceText = getTextElement(driver, String.format(CRYPTO_MINI_PRICE, coin));
    Double minPrice = null;
    if (StringUtils.contains(miniPriceText, "Minimum")) {
      minPrice = Double.valueOf(miniPriceText.trim().replaceAll("Minimum payment:", "").replace(coin, "").replace(":", ""));
    } else if (StringUtils.contains(miniPriceText, "maintenance")) {
      System.out.println(coin + " is Maintenance. Please select other coin!");
      selectCryptoToPayment(randomCrypto());
    }
    clickToElementByJavascript(driver, xpath);
    wait1sTime();
    return minPrice;
  }

  public void verifyPaymentTCByCrypto() {
    String coin = randomCrypto();
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_AMOUNT100);
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    clickToElementByJavascript(driver, SELECT_CRYPTO_TXT);
    verifyDisplayAVAFirstPlace(CRYPTO_COIN_NAME_FIRST, "AVA Travala");
    Double minPrice = selectCryptoToPayment(coin);
    String beforeTC = getTotalTC();
    String beforePrice = getTotalPrice();
    String subTotalPrice = getTextElement(driver, BUY_TC_PAYMENT_SUB_TOTAL_PRICE);
    String beforeAmount = getAmountTC();
    wait300Time();
    clickToElementByJavascript(driver, PURCHASE_SUBMIT_BTN);
    wait300Time();
    if (checkShowElement(driver, BUY_TC_POPUP_ERROR_PAYMENT) != 0) {
      switch (getTextElement(driver, BUY_TC_POPUP_ERROR_PAYMENT)) {
        case "The payment method is not supported!":
          System.out.println("The payment method is not supported with: " + coin);
          break;
        case "Could not create payment now!":
          System.out.println(" Could not create payment now with: " + coin);
          break;
      }
      clickToElementByJavascript(driver, BUY_TC_POPUP_ERROR_PAYMENT_BTN);
    } else {
      wait300Time();
      String[] content = {"TC_CRYPTO_POPUP_TITLE", "CRYPTO_POPUP_EXPIRES_TIME", "PURCHASE_TOTAL_LABEL", "PURCHASE_SUB_TOTAL_LABEL", "CRYPTO_POPUP_PAYMENT_AMOUNT", "CRYPTO_POPUP_PAYMENT_CONTENT", "CRYPTO_POPUP_NETWORK", "CRYPTO_POPUP_ADDRESS"};
      String[] xpath = {BUY_TC_POPUP_TITLE, BUY_TC_CRYPTO_POPUP_EXPIRES_TIME, BUY_TC_CRYPTO_POPUP_TOTAL, BUY_TC_CRYPTO_POPUP_SUB_TOTAL, BUY_TC_CRYPTO_POPUP_AMOUNT, BUY_TC_CRYPTO_POPUP_CONTENT, BUY_TC_CRYPTO_POPUP_NETWORK, BUY_TC_CRYPTO_POPUP_WALLET};
      if (checkShowElement(driver, BUY_TC_CRYPTO_POPUP_DISCOUNT) != 0) {
        verifyTextByKey("CRYPTO_POPUP_DISCOUNT", BUY_TC_CRYPTO_POPUP_DISCOUNT);
      }
      if (!(verifyTwoListByKey(content, xpath) && (verifyTextByGetTextElement(getTotalPrice(), BUY_TC_CRYPTO_POPUP_TOTAL_COIN) && verifyTextByGetTextElement(subTotalPrice,
        BUY_TC_CRYPTO_POPUP_TOTAL_PRICE)))) {
        System.out.println("Text on popup buy TC by " + coin + " wrong!");
      } else {
        System.out.println("Text on popup buy TC by " + coin + " correct!");
      }
    }
    reloadPage(driver);
    wait300Time();
    System.out.println("Verify Transaction When Buy TC By Crypto with " + coin);
    verifyTextTransactionBuyTC(beforeAmount, beforePrice, beforeTC, coin);
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_BUY_TAB);
  }

  public void verifyPaymentTCByWallet() {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_AMOUNT50);
    clickToElementByJavascript(driver, MY_WALLET_OPTION);
    String coin = randomWallet();
    clickToElementByJavascript(driver, String.format(CHECKOUT_WALLET_RADIO_DYNAMIC, coin));
    String beforeTC = getTotalTC();
    String beforeAmount = getAmountTC();
    Double beforeTotalPrice = Double.parseDouble(getTotalPrice());
    if (beforeTotalPrice <= getWalletBalance(coin)) {
      clickToElementByJavascript(driver, PURCHASE_SUBMIT_BTN);
      System.out.println("Verify Transaction When Buy TC By Wallet with " + coin);
      wait1sTime();
      verifyTextTransactionBuyTC(beforeAmount, String.valueOf(beforeTotalPrice), beforeTC, coin);
    } else {
      System.out.println("Don't have enough " + coin + " to payment ");
    }
  }

  public BuyGiftCardPage clickOnRedeemToLinkBuyGiftCard() {
    clickToElement(driver, MY_TRAVEL_CREDIT_REDEEM_TAB);
    clickToElement(driver, MY_TRAVEL_CREDIT_BUY_GIFT_CARD_LINK);
    return new BuyGiftCardPage(driver);
  }

  public void verifyNavigatePageWhenClickOnURL() {
    clickToElementByJavascript(driver, REDEEM_GIFT_CARD_MORE_URL);
    switchToOtherWindowbyUrl(driver, TRAVEL_GIFT_CARD_PATH);
    boolean a = true;
    boolean b = true;
    if (!verifyTextByKey("TRAVEL_GIFT_CARD_TITLE", TRAVEL_GIFT_CARDS_TITLE)) {
      System.out.println("Navigate to Gift Card page from URL on Redeem Gift Card Tab wrong");
      b = false;
    }
    switchTab(driver);
    clickToElementByJavascript(driver, REDEEM_BUY_GIFT_CARD_URL);
    if (!verifyTextByKey("TRAVEL_GIFT_CARD_BUY_TGC_BTN", BUY_GIFT_CARDS_TITLE)) {
      System.out.println("Navigate to Buy Gift Card page from URL on Redeem Gift Card Tab wrong");
      a = false;
    }
    backToPreviousPage(driver);
    if (a && b) {
      System.out.println("Navigate to page from URL on Redeem Gift Card Tab Correct!");
    }
  }

  public void verifyTextInputRedeemCode() {
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_REDEEM_TAB);
    sendkeysToElement(driver, REDEEM_CODE_TXT, randomString());
    clickToElementByJavascript(driver, REDEEM_GIFT_CARD_BTN);
    if (!verifyTextByKey("REDEEM_ERROR_CODE_TXT", REDEEM_ERROR_CODE_TXT)) {
      System.out.println("Error message when input Invalid Redeem Code Wrong");
    }
  }

  public void verifyBalanceInMyTravelCredits(String expectBalance) {
    String actualTotalAmount = getTextElement(driver, MY_TRAVEL_CREDIT_TOTAL_AMOUNT);
    Assert.assertEquals(actualTotalAmount, expectBalance, "Total Amount the same expect: "+ actualTotalAmount);

    String actualPromoAmount = getTextElement(driver, MY_TRAVEL_CREDIT_PROMO_AMOUNT);
    Assert.assertEquals(actualPromoAmount, expectBalance, "Promo Amount the same expect: "+ actualPromoAmount);

    String actualPermanentAmount = getTextElement(driver, MY_TRAVEL_CREDIT_PERMANENT_AMOUNT);
    int expectPermanentAmount = Integer.parseInt(actualTotalAmount) - Integer.parseInt(actualPromoAmount);
    Assert.assertEquals(Integer.parseInt(actualPermanentAmount), expectPermanentAmount, "Permanent Amount the same expect: " + actualPermanentAmount);
  }

  public  void verifyTransactionInMyTravelCredits(String expectNote) {
    clickToElement(driver, SUMMARY_TAB_IN_MY_TRAVEL_CREDITS);
    String actualNote = getTextElement(driver, REWARD_BONUS_TRANSACTION_IN_MY_TRAVEL_CREDIT);
    Assert.assertEquals(actualNote, expectNote);
  }
}
