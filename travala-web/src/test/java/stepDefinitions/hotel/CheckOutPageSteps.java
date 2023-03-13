package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.BookingSummaryPage;
import pages.hotel.CheckOutPage;
import pages.hotel.PropertyPage;
import pages.hotel.SearchPage;
import pages.hotel.paymentMethod.CryptoPayCheckOutPage;
import pages.hotel.paymentMethod.VNPayPage;


import static commons.CommonDataTravala.BOOKING_STATUS_PROCESS;
import static commons.CommonsTravalaXpath.*;
import static interfaces.hotel.BookingSummaryPageUI.*;
import static interfaces.hotel.CheckOutPageUI.*;
import static interfaces.hotel.LandingPageUI.*;

public class CheckOutPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private PropertyPage propertyPage;
  private CheckOutPage checkOutPage;
  private CryptoPayCheckOutPage cryptoPayCheckOutPage;
  private BookingSummaryPage bookingSummaryPage;
  private SearchPage searchPage;
  private VNPayPage vnPayPage;
  private String totalChargeCheckOut;
  private String totalChargeTCCheckOut;

  public CheckOutPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    propertyPage = new PropertyPage(driver);
    checkOutPage = new CheckOutPage(driver);
  searchPage= new SearchPage(driver);
    bookingSummaryPage = new BookingSummaryPage(driver);
  }

  @When("^I input \"([^\"]*)\" and navigate to checkout page$")
  public void iInputAndNavigateToCheckoutPage(String propertyTxt) {
    inputPropertySearch(propertyTxt);
    clickToElementByJavascript(driver,LANDING_SEARCH_BUTTON);
    propertyPage.clickBookNowBtn();
  }

  @And("^I input valid contact information$")
  public void i_input_valid_contact_information() throws Throwable {
    checkOutPage.inputContactNotLogin();
    checkOutPage.inputToRoomGuest();
  }

  @When("^I input \"([^\"]*)\" with select three person and navigate to checkout page$")
  public void iInputWithSelectThreePersonAndNavigateToCheckoutPage(String propertyTxt) throws Throwable {
    inputPropertySearch(propertyTxt);
//    selectTwoRoom();
//    selectTwoRoom();
//    clickSearchPropertyButton(driver);
    clickToElementByJavascript(driver,LANDING_SEARCH_BUTTON);
    propertyPage.clickBookNowBtn();
  }

  @And("^I input information for Reservation$")
  public void iInputInformationForReservation() {
    checkOutPage.inputToRoomGuest();
    clickToElement(driver, CHECKOUT_PROCESS_PAYMENT_BTN);
    wait100Time();
  }

  @And("^I verify text at contact part in the checkout page when not login$")
  public void iVerifyTextAtContactPartInTheCheckoutPageWhenNotLogin() {
    if (checkOutPage.verifyContactRoomLogin()) {
      checkOutPage.verifyReservationText();
      System.out.println("Text at check out when login Correct");
    }
  }

  @And("^I verify booking hotel when payment by Credit Card$")
  public void iVerifyBookingHotelWhenPaymentByCreditCard() {
    clickToElementByJavascript(driver, CREDIT_CARD_OPTION);
      verifyTextByKey("CHECKOUT_CREDIT_CARD_FEE",CHECKOUT_CREDIT_CARD_FEE);
//    if (checkShowElement(driver, CHECKOUT_TOTAL_CHARGE_LOGO) == 0) {
//      totalChargeTCCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT);
//    } else {
//      totalChargeTCCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT);
//    }
//    inputCreditCard(VALID_CARD_NUMBER, VALID_EXP_DATE, VALID_CVC);
//    clickToElementByJavascript(driver, COMPLETE_RESERVATION_BUTTON);
//    wait2sTime();
//    if(checkShowElement(driver, CREDIT_CARD_WARNING)==0) {
//      switchToWindowByUrlContainsString(driver, HOTEL_BOOKING_SUMMARY);
//      if (bookingSummaryPage.verifyInfoBookingSummary()) {
//        bookingSummaryPage.verifyPaymentMethodBooking(totalChargeTCCheckOut);
//        System.out.println("Booking hotel success when payment by Credit Card Correct");
//      }
//    }else {
//      System.out.println("Card Number invalid");
//    }
    clickBackToTravala(driver);
  }

  @Then("^I verify info at checkout page and popup when dont have enough \"([^\"]*)\" to payment$")
  public void iVerifyInfoAtCheckoutPageAndPopupWhenDontHaveEnoughToPayment(String coin) throws Throwable {
    clickToElementByJavascript(driver, MY_WALLET_OPTION);
    wait100Time();
    checkOutPage.verifyTextWalletCheckOut(coin);
    if (checkOutPage.getTotalCharge(CHECKOUT_TOTAL_CHARGE_WALLET) > checkOutPage.getWalletBalance(coin)) {
      System.out.println("You don't have " + coin + " to Payment");
    }
  }

  @Then("^I verify info at checkout page and popup when payment by \"([^\"]*)\" Wallet$")
  public void iVerifyInfoAtCheckoutPageAndPopupWhenPaymentByWallet(String coin) throws Throwable {
    clickToElementByJavascript(driver, MY_WALLET_OPTION);
    checkOutPage.verifyTextWalletCheckOut(coin);
    if (checkShowElement(driver, CHECKOUT_TOTAL_CHARGE_LOGO) == 0) {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT);
    } else {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT);
    }
    checkOutPage.paymentBookingByWallet(coin);
  }

  @Then("^I verify info at checkout page when dont have Travel Credit to payment$")
  public void iVerifyInfoAtCheckoutPageWhenDontHaveTravelCreditToPayment() {
    clickToElementByJavascript(driver, TRAVEL_CREDIT_OPTION);
    checkOutPage.verifyTextTravelOption();
    if (checkOutPage.getTotalCharge(CHECKOUT_TOTAL_CHARGE_TC_AMOUNT) > checkOutPage.getTotalCharge(CHECKOUT_PAYMENT_TC_BALANCE)) {
      System.out.println("You don't have Travel Credit to Payment");
    }
    clickBackToTravala(driver);
  }

  @Then("^I verify info at checkout page and popup when payment by Travel Credit$")
  public void iVerifyInfoAtCheckoutPageAndPopupWhenPaymentByTravelCredit() {
    clickToElementByJavascript(driver, TRAVEL_CREDIT_OPTION);
    checkOutPage.verifyTextTravelOption();
    if (checkShowElement(driver, CHECKOUT_TOTAL_CHARGE_LOGO) == 0) {
      totalChargeTCCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT);
    } else {
      totalChargeTCCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT);
    }
    checkOutPage.bookingByTravelCredit();
  }

  @And("^I verify popup crypto when payment by \"([^\"]*)\" and information at booking summary$")
  public void iVerifyPopupCryptoWhenPaymentByAndInformationAtBookingSummary(String coin) {
    checkOutPage.verifyDisplayLogoCrypto(coin);
    if (checkShowElement(driver, CHECKOUT_TOTAL_CHARGE_LOGO) == 0) {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT);
    } else {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT);
    }
    checkOutPage.verifyPopUpCrypto(coin);
    checkOutPage.verifyPopUpCryptoWithNowPayment(coin);
    wait2sTime();
  }


  @And("^I verify payment by \"([^\"]*)\" by Now Payment$")
  public void iVerifyPaymentByByNowPayment(String coin) throws Throwable {
    checkOutPage.verifyDisplayLogoCrypto(coin);
    if (checkShowElement(driver, CHECKOUT_TOTAL_CHARGE_LOGO) == 0) {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_TC_AMOUNT);
    } else {
      totalChargeCheckOut = getTextElement(driver, CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT);
    }
    checkOutPage.verifyPopUpCryptoWithNowPayment(coin);
    switchTab(driver);
  }

  @And("^I verify info at booking summary page when payment by Travel Credit$")
  public void iVerifyInfoAtBookingSummaryPageWhenPaymentByTravelCredit() {
    if (bookingSummaryPage.verifyInfoBookingSummary()) {
      bookingSummaryPage.verifyPaymentMethodBooking(totalChargeCheckOut);
      System.out.println("Booking hotel when payment by Travel Credit Correct");
    }
    clickBackToTravala(driver);
  }

  @And("^I verify info at booking summary page when payment by Credit Card$")
  public void iVerifyInfoAtBookingSummaryPageWhenPaymentByCreditCard() {
    if (bookingSummaryPage.verifyInfoBookingSummary()) {
      bookingSummaryPage.verifyPaymentMethodBooking(totalChargeCheckOut);
      System.out.println("Booking hotel when payment by Credit Card Correct");
    }
    clickBackToTravala(driver);
  }

  @And("^I verify info at booking summary page when payment by Wallet$")
  public void iVerifyInfoAtBookingSummaryPageWhenPaymentByWallet() {
    if (bookingSummaryPage.verifyInfoBookingSummary()) {
      bookingSummaryPage.verifyPaymentMethodBooking(totalChargeCheckOut);
      System.out.println("Booking hotel when payment by Wallet Correct");
    }
    clickBackToTravala(driver);
  }

  @And("^I verify info at booking summary page when payment Crypto$")
  public void iVerifyInfoAtBookingSummaryPageWhenPaymentCrypto() {
    if (bookingSummaryPage.verifyInfoBookingSummary()) {
//      bookingSummaryPage.verifyPaymentMethodBooking(totalChargeCheckOut);
      System.out.println("Booking hotel when payment by Crypto Correct");
    }
    clickBackToTravala(driver);
  }

  @When("^I click on cancel order at utrust page and verify booking status$")
  public void i_click_on_cancel_order_at_utrust_page_and_verify_booking_status() throws Throwable {
//    cryptoPayCheckOutPage.clickCancelOrderButton();
    bookingSummaryPage = new BookingSummaryPage(driver);
    Thread.sleep(7000);
    System.out.println("status: " + bookingSummaryPage.getTextElement(driver, BOOKING_STATUS).trim());
    boolean b3 = StringUtils.equals(BOOKING_STATUS_PROCESS, bookingSummaryPage.getTextElement(driver, BOOKING_STATUS).trim());
    if (b3) {
      System.out.println("Booking is cancelled! ");
    } else {
      System.out.println("Fail utrust booking");
    }
    clickBackToTravala(driver);
  }


  @And("^I select Utrust option and verify text at Utrust form$")
  public void i_select_utrust_option_and_verify_text_at_utrust_form() throws Throwable {
//    checkOutPage.clickToPaymentOption(UTRUST_BUTTON);
//    Double expectTotalUtrust = Double.parseDouble(checkOutPage.getTotalChargeCheckOut());
//    String expectRoomTypeUtrust = checkOutPage.getRoomTypeCheckOut();
//    checkOutPage.clickUtrustPay();
//    utrustCheckOutPage = new UtrustCheckOutPage(driver);
//    utrustCheckOutPage.waitFoElementVisible(driver, WAITING_TEXT);
//    Double actualTotalPayment = Double.parseDouble(utrustCheckOutPage.getTextUtrustPage(TOTAL_PAYMENT_UTRUST_TEXT).substring(1));
//    String actualRoomType = utrustCheckOutPage.getTextUtrustPage(ROOM_TYPE_UTRUST_TEXT).substring(3);
//    boolean b2 = StringUtils.equals(expectRoomTypeUtrust, actualRoomType);
//    System.out.println("expect total " + expectTotalUtrust.getClass().getSimpleName());
//    System.out.println("actual total " + actualTotalPayment.getClass().getSimpleName());
//    System.out.println("expect room " + expectRoomTypeUtrust);
//    System.out.println("actual room " + actualRoomType);
//    if ((Double.compare(expectTotalUtrust, actualTotalPayment) == 0) && b2) {
//      System.out.println("Display info UTRUST when booking correct! ");
//    } else {
//      System.out.println("Display info UTRUST  when booking incorrect! ");
//    }
    //    checkOutPage.clickToPaymentOption(UTRUST_BUTTON);
//    utrustCheckOutPage.switchToOtherWindowByContent(driver, CONTEN_PAGE_UTRUST);
  }

  @And("^I verify text at checkout page when login$")
  public void iVerifyTextAtCheckoutPageWhenLogin() {
//    checkOutPage.verifyReservationText();
    checkOutPage.verifyTextPaymentOptionNotLogin();
//    checkOutPage.verifyTextAtPaymentDetail();
  }

  @And("^I verify text at checkout when payment by Credit Card$")
  public void iVerifyTextAtCheckoutWhenPaymentByCreditCard() {
    clickToElementByJavascript(driver, CREDIT_CARD_OPTION);
    verifyTextByKey("CHECKOUT_CREDIT_CARD_FEE",CHECKOUT_CREDIT_CARD_FEE);
  }

}
