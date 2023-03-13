package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.CheckOutPage;
import pages.hotel.HomePage;
import pages.hotel.PropertyPage;
import pages.hotel.myProfile.MyTravelCreditsPage;


import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.HOTEL_PROPERTY;
import static commons.CommonHotelURL.TRAVEL_CREDITS_PATH;
import static interfaces.hotel.CheckOutPageUI.*;
import static interfaces.hotel.PropertyPageUI.BEST_PRICE_BOOK_NOW_FIRST;
import static interfaces.hotel.SearchPageUI.FIRST_PROPERTY;


public class MyTravelCreditPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private MyTravelCreditsPage myTravelCreditsPage;
  private HomePage homePage;
  private CheckOutPage checkOutPage;
  private PropertyPage propertyPage;

  //  @Before
  public MyTravelCreditPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    myTravelCreditsPage = new MyTravelCreditsPage(driver);
    homePage = new HomePage(driver);
    propertyPage = new PropertyPage(driver);
    checkOutPage = new CheckOutPage(driver);
  }

  @When("^I navigate to My Travel Credit page$")
  public void iNavigateToMyTravelCreditPage() {
    homePage.clickToMyTravelCreditsLink();
  }

  @And("^I input amount travel credits \"([^\"]*)\"$")
  public void i_input_amount_travel_credits_something(String amountTC) {
    inputAmount(amountTC);
  }

  //===============Verify LANGUAGE =============================
  @And("^I verify text on buy travel credit tab$")
  public void


  i_verify_text_on_buy_travel_credit_tab() {
//    myTravelCreditsPage.verifyTextSelectAmountTC();
    myTravelCreditsPage.verifyTextAtPurchaseTC();
  }

  @And("^I verify text on summary tab$")
  public void i_verify_text_on_summary_tab() {
    myTravelCreditsPage.verifyTextSummaryTab();
  }

  @And("^I verify text on redeem gift card tab$")
  public void i_verify_text_on_redeem_gift_card_tab() {
    myTravelCreditsPage.verifyTextRedeemTab();
  }

  @And("^I verify navigate page when click on link in Redeem Gift Card Tab$")
  public void iVerifyNavigatePageWhenClickOnLinkInRedeemGiftCardTab() {
    myTravelCreditsPage.verifyNavigatePageWhenClickOnURL();
  }

  @And("^I verify message when input invalid Gift Card in Redeem Gift Card Tab$")
  public void iVerifyMessageWhenInputInvalidGiftCardInRedeemGiftCardTab() {
    myTravelCreditsPage.verifyTextInputRedeemCode();
  }

  @And("^I verify text at payment part in the Travel Credit page$")
  public void iVerifyTextAtPaymentPartInTheTravelCreditPage() {
    myTravelCreditsPage.verifyTextAtPurchaseTC();
  }

  @And("^I verify buy travel credits when payment by Credit Card$")
  public void iVerifyBuyTravelCreditsWhenPaymentByCreditCard() {
    myTravelCreditsPage.verifyPaymentTCByCreditsCard();
  }

  @And("^I verify buy travel credit when payment by Crypto$")
  public void iVerifyBuyTravelCreditWhenPaymentByCrypto() {
    myTravelCreditsPage.verifyPaymentTCByCrypto();
  }

  @And("^I verify buy travel credit when payment by Wallet$")
  public void iVerifyBuyTravelCreditWhenPaymentByWallet() {
    myTravelCreditsPage.verifyPaymentTCByWallet();
  }

  @When("^I back to homepage and navigate to property page with \"([^\"]*)\"$")
  public void iBackToHomepageAndNavigateToPropertyPageWith(String propertyTxt) {
    clickBackToTravala(driver);
    inputLocationSearch("Ha Noi");
    clickSearchHotelBtn(driver);
    clickToElementByJavascript(driver, FIRST_PROPERTY);
    wait1sTime();
    switchToOtherWindowbyUrl(driver, HOTEL_PROPERTY);
    clickToElementByJavascript(driver, BEST_PRICE_BOOK_NOW_FIRST);
  }

  @And("^I select Buy Travel credit at checkout page and navigate to this page$")
  public void iSelectBuyTravelCreditAtCheckoutPageAndNavigateToThisPage() {
    clickToElementByJavascript(driver, TRAVEL_CREDIT_OPTION);
//if(Double.valueOf( getTextElement(driver,CHECKOUT_TC_BALANCE_TC))<Double.valueOf(getTextElement(driver,CHECKOUT_TOTAL_CHARGE_TC_AMOUNT))){
    if (checkShowElement(driver, CHECKOUT_TC_INSUFFICIENT_FUND_NOTE) == 1) {
      clickToElementByJavascript(driver, CHECKOUT_PAYMENT_BUY_TC_BTN);
      switchToOtherWindowbyUrl(driver, TRAVEL_CREDITS_PATH);
      System.out.println(getCurrentUrl(driver));
      System.out.println(StringUtils.contains(TRAVEL_CREDITS_PATH, getCurrentUrl(driver)));
      if (StringUtils.contains(getCurrentUrl(driver), TRAVEL_CREDITS_PATH)) {
        System.out.println("Link to Buy TC from Check-out page correct");
      } else {
        System.out.println("Link to Buy TC from Check-out page wrong");
      }
    } else {
      System.out.println("You have enough TC to payment");
    }
  }

}
