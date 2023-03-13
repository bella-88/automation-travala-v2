package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.BookingSummaryPage;
import pages.hotel.ConfirmWithDrawPage;
import pages.hotel.HomePage;
import pages.hotel.MyReferralPage;
import pages.hotel.myProfile.*;

import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.BOOKING_SUMMARY_PATH;
import static commons.CommonHotelURL.SMART_PROGRAM_PATH;
import static interfaces.hotel.HomePageUI.*;
import static interfaces.hotel.HomePageUI.SETTING;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.myProfile.MyWalletPageUI.*;

public class MyProfileSteps extends CommonHotelPages {
  WebDriver driver;
  private HomePage homePage;
  private MyAccountPage myAccountPage;
  private MyInvitePage myInvitePage;
  private MySmartPage mySmartPage;
  private MyWalletPage myWalletPage;
  private ConfirmWithDrawPage confirmWithDrawPage;
  private MyWishListPage myWishListPage;
  private MyBookingPage myBookingPage;
  private MyTravelCreditsPage myTravelCreditsPage;
  private MyReferralPage myReferralPage;
  private BookingSummaryPage bookingSummaryPage;

  public MyProfileSteps() {
    driver = HooksHotel.openBrowserTravala();
    homePage = new HomePage(driver);
    myAccountPage = new MyAccountPage(driver);
    myWalletPage = new MyWalletPage(driver);
    myWishListPage = new MyWishListPage(driver);
    myInvitePage = new MyInvitePage(driver);
    myTravelCreditsPage = new MyTravelCreditsPage(driver);
    mySmartPage = new MySmartPage(driver);
    myBookingPage = new MyBookingPage(driver);
    myReferralPage = new MyReferralPage(driver);
    bookingSummaryPage = new BookingSummaryPage(driver);
    clickToElementByJavascript(driver, GLOBE_ICON_HEADER);
    clickElementByDynamicLocator(driver, LANGUAGE_OPTION, LANGUAGE);
  }

  //=============================================MY ACCOUNT============================================
  @Then("^I verify text on the tab Personal Details and update address success$")
  public void i_verify_text_on_the_tab_personal_details_and_update_address_success() {
    if (myAccountPage.verifyPersonalDetail()) {
      myAccountPage.verifyMessageUpdatePersonalDetail();
      System.out.println("=======Text on MY ACCOUNT - PERSONAL DETAIL CORRECT=======");
    }
  }

  @And("^I verify text on the tab Settings$")
  public void i_verify_text_on_the_tab_settings() {
    clickToElementByJavascript(driver, SETTING);
    if (myAccountPage.verifySettingTab()) {
      System.out.println("=======Text on MY ACCOUNT - SETTING CORRECT=======");
    }
  }

  @And("^I verify text on the tab Connect Account$")
  public void i_to_verify_text_on_the_tab_connect_account() {
    clickToElementByJavascript(driver, CONNECT_ACCOUNT);
    if (myAccountPage.verifyConnectAccount()) {
      System.out.println("=======Text on MY ACCOUNT - CONNECT ACCOUNT CORRECT======");
    }
  }

  @And("^I verify text on the tab Security$")
  public void i_verify_text_on_the_tab_security() {
    clickToElementByJavascript(driver, SECURITY);
    if (myAccountPage.verifyTextAtSecurityTab()) {
      System.out.println("=======Text on MY ACCOUNT - SECURITY CORRECT=======");
    } else {
      System.out.println("=======Text on MY ACCOUNT - SECURITY WRONG=======");
    }
  }

  @And("^I select tab settings at my account page$")
  public void i_select_tab_settings_at_my_account_page() {
    clickToElementByJavascript(driver, SETTING);
  }

  @And("^I verify change email with input invalid email and password$")
  public void iVerifyChangeEmailWithInputInvalidEmailAndPassword() {
    clickToElementByJavascript(driver, CHANGE_EMAIL_BTN);
    myAccountPage.verifyChangeEmail();
  }

  @And("^I verify change email with input valid email and password$")
  public void iVerifyChangeEmailWithInputValidEmailAndPassword() {
    clickToElementByJavascript(driver, CHANGE_EMAIL_BTN);
    myAccountPage.verifyChangeEmailSuccess();
  }

  @And("^I select change password on Setting option$")
  public void iSelectChangePasswordOnSettingOption() {
    homePage.clickToMyMyAccountLink();
    clickToElementByJavascript(driver, SETTING);
    clickToElementByJavascript(driver, CHANGE_PASS_BTN);
  }

  @And("^I verify when input invalid \"([^\"]*)\" and \"([^\"]*)\" to change password$")
  public void iVerifyWhenInputInvalidAndToChangePassword(String newPassword, String confirmPassword) throws Throwable {
    myAccountPage.verifyErrorWhenInputInvalidPassWord(newPassword, confirmPassword);
    reloadPage(driver);
  }

  //=============================================MY INVITE============================================
  @And("^I verify message popup when input email to invite$")
  public void i_verify_message_popup_when_input_email_to_invite() {
    myInvitePage.verifyValidEmailInvite();
  }

  @And("^I verify text in the Invite People tab$")
  public void iVerifyTextInTheInvitePeopleTab() {
    waitFoElementClickable(driver, MY_INVITE_LINK);
    clickToElement(driver, MY_INVITE_LINK);
    myInvitePage.verifyInvitePeople();
  }

  @And("^I verify the text on the Invite Detail page with acc no have invited acc$")
  public void i_verify_the_text_on_the_invite_detail_page_with_acc_no_have_invited_acc() {
    myInvitePage.verifyInviteDetail();

  }
  @And("^I verify navigate link on my Invite page$")
  public void iVerifyNavigateLinkOnMyInvitePage() {
    myInvitePage.verifyNavigateLink();
  }

  @And("^I verify Referral page when click on link at invite people$")
  public void i_verify_referral_page_when_click_on_link_at_invite_people() {
//    String urlReferral = myInvitePage.openReferralPage();
    openNewTab(driver, myInvitePage.openReferralPage());
    myReferralPage.verifyReferralPage();
  }

  @And("^I active acc to smart account and verify text$")
  public void i_active_acc_to_smart_account_and_verify_text() {
//    mySmartPage.verifyActiveSmartAcc();
  }

  @And("^I verify text on the overview option$")
  public void i_verify_text_on_the_overview_option() {
    if (myWalletPage.verifyOverviewWallet()) {
      System.out.println("Text on MY Wallet OverView is displayed correct");
    }
  }

  @And("^I verify text on the summary option$")
  public void i_verify_text_on_the_summary_option() {
    clickToElement(driver, MY_WALLET_SUMMARY_TAB);
    if (myWalletPage.verifySummaryWallet() && myWalletPage.verifySummaryFilter()) {
      System.out.println("Text on MY Wallet Summary is displayed correct");
    }
  }

  @And("^I verify text on the deposit option$")
  public void i_verify_text_on_the_deposit_option() {
    clickToElement(driver, MY_WALLET_DEPOSIT_TAB);
    if (myWalletPage.verifyHeaderTable() && myWalletPage.verifyDepositOption()) {
      System.out.println(" Text at DEPOSIT option correct");
    }
  }

  @And("^I verify text on the withdraw option$")
  public void i_verify_text_on_the_withdraw_option() {
    clickToElement(driver, MY_WALLET_WITHDRAW_TAB);
    if (myWalletPage.verifyWithDrawOption() && myWalletPage.verifyTextHolderWithDrawOption() && myWalletPage.verifyHeaderTable()) {
      System.out.println(" Text at WithDraw option correct");
    }
  }

  @And("^I verify input invalid \"([^\"]*)\" and \"([^\"]*)\" and\"([^\"]*)\" and \"([^\"]*)\"$")
  public void i_verify_input_invalid_something_and_something_andsomething_and_something(String invalidAddress, String invalidMemo, String invalidAmount, String saveAddress) {
    clickToElement(driver, MY_WALLET_WITHDRAW_TAB);
    myWalletPage.verifyInvalidAddress(invalidAddress);
    myWalletPage.verifyInvalidMemo(invalidMemo);
    myWalletPage.verifyInvalidAmount(invalidAmount);
    myWalletPage.verifyInvalidSaveAddress(saveAddress);
  }

  @And("^I verify withdraw success with \"([^\"]*)\" and \"([^\"]*)\" and\"([^\"]*)\"$")
  public void i_verify_withdraw_success_with_something_and_something_andsomething(String address, String memo, String amount) {
    clickToElement(driver, MY_WALLET_WITHDRAW_TAB);
    myWalletPage.navigateToWithDrawOption();
    myWalletPage.withDrawSuccessNoSaveAddress(address, memo, amount);
  }

  @And("^I verify withdraw success when save address \"([^\"]*)\" and \"([^\"]*)\" and\"([^\"]*)\" and\"([^\"]*)\"$")
  public void i_verify_withdraw_success_when_save_address_something_and_something_andsomething_andsomething(String address, String memo, String amount, String saveAddress) {
    clickToElement(driver, MY_WALLET_WITHDRAW_TAB);
    myWalletPage.withDrawSuccessSaveAddress(address, memo, amount, saveAddress);
  }

  @And("^I verify withdraw success when use max \"([^\"]*)\" and \"([^\"]*)\"$")
  public void i_verify_withdraw_success_when_use_max_something_and_something(String address, String memo) {
    clickToElement(driver, MY_WALLET_WITHDRAW_TAB);
    myWalletPage.withDrawSuccessUseMax(address, memo);
  }

  @And("^I open gmail tab to confirm withDraw$")
  public void i_open_gmail_tab_to_confirm_withdraw() {
    myWalletPage.openGmailTabToClickConfirmBtn();
    confirmWithDrawPage = new ConfirmWithDrawPage(driver);
  }

  @And("^I verify text at my wishlist for stay and activities tab$")
  public void iVerifyTextAtMyWishlistForStayAndActivitiesTab() {
    clickToElementByJavascript(driver, MY_WISHLIST_LINK);
    myWishListPage.verifyDisplayMyWishList();
  }

  @And("^I verify remove item at my wishlist$")
  public void iVerifyRemoveItemAtMyWishlist() {
    myWishListPage.verifyRemoveItem();
  }

  @And("^I link to my booking and open stay option$")
  public void iLinkToMyBookingAndOpenStayOption() {
    homePage.clickToMyBooking();
    myBookingPage.clickViewBooking();
    switchToWindowByUrlContainsString(driver, BOOKING_SUMMARY_PATH);
    bookingSummaryPage.verifyTextHotelInfoBooking();
    bookingSummaryPage.verifyTextPaymentBooking();
//    myBookingPage.clickBookAgain();
//    System.out.println("Status booking: " + bookingSummaryPage.getStatusBookingSummary());
    switchTab(driver);
  }


  @And("^I verify display text when click on view booking button$")
  public void i_verify_display_text_when_click_on_view_booking_button() {

  }


  @And("^I verify info at booking summary page$")
  public void iVerifyInfoAtBookingSummaryPage() {
//    bookingSummaryPage.verifyTextPaymentBooking();
  }


  @And("^I link to My Account and verify text at left menu on this page$")
  public void iLinkToMyAccountAndVerifyTextAtLeftMenuOnThisPage() {
    homePage.clickToMyMyAccountLink();
  }

  @And("^I click on My Smart and verify text on this page$")
  public void iClickOnMySmartAndVerifyTextOnThisPage() {
    clickToElement(driver, MY_SMART_LINK);
    switchToWindowByUrlContainsString(driver, SMART_PROGRAM_PATH);
    mySmartPage.verifyTextMySmart();
  }

  @And("^I click on Tiger NFT and verify the text on the Overview tab$")
  public void iClickOnTigerNFTAndVerifyTheTextOnTheOverviewTab() {
    homePage.clickToMyMyAccountLink();
    clickToElement(driver, TIGER_NFT_LINK);
//    switchToWindowByUrlContainsString(driver, MY_NFT_PATH);
    homePage.verifyContentTextInOverviewTigerNFT();
    switchTab(driver);
  }

}
