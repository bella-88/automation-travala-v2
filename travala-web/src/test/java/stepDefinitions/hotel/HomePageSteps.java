package stepDefinitions.hotel;


import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.ConfirmWithDrawPage;
import pages.hotel.HomePage;
import pages.hotel.myProfile.*;

import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelXpath.ACTIVITIES_TAB;

public class HomePageSteps extends CommonHotelPages {
  static WebDriver driver;

  private String homePageWindow;
  private HomePage homePage;
  private MyBookingPage myBookingPage;
  private MyAccountPage myAccountPage;
  private MyInvitePage myInvitePage;
  private MySmartPage mySmartPage;
  private MyTravelCreditsPage myTravelCreditsPage;
  private MyWalletPage myWalletPage;
  private ConfirmWithDrawPage confirmWithDrawPage;
  private MyWishListPage myWishListPage;

  public HomePageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    homePage = new HomePage(driver);
    myTravelCreditsPage = new MyTravelCreditsPage(driver);
    myAccountPage = new MyAccountPage(driver);
    mySmartPage = new MySmartPage(driver);
    myWalletPage = new MyWalletPage(driver);
    myInvitePage = new MyInvitePage(driver);
    myBookingPage = new MyBookingPage(driver);
  }

  @And("^I click on My Account and link to this page$")
  public void i_click_on_my_account_and_link_to_this_page() {
    homePage.clickToMyMyAccountLink();
  }

  @And("^I click on My Wallet and link to this page$")
  public void i_click_on_my_wallet_and_link_to_this_page() {
    clickToElement(driver, MY_WALLET_LINK);
    switchToLanguage();
  }

  @And("^I logout to system$")
  public void i_logout_to_system() {
    logoutAcc();
  }

  //=========================================ACTIVITIES===========================================================
  @Given("^I access to Travala site and click on Activities tab$")
  public void i_access_to_travala_site_and_click_on_activities_tab() {
    clickToElement(driver, ACTIVITIES_TAB);
  }

//  @And("^verify default value at date is today plus \"([^\"]*)\"$")
//  public void verify_default_value_at_date_is_today_plus_something(int day) {
//    if (homePage.checkDateTimeAct(day)) {
//      System.out.println("Display default date activities correct ");
//    } else {
//      System.out.println("Display default date activities wrong ");
//    }
//  }

  @When("^I input destination \"([^\"]*)\" to search textbox$")
  public void i_input_destination_something_to_search_textbox(String destination) {
//    inputDestination(destination);
  }

  @When("^I input activities \"([^\"]*)\" to search textbox$")
  public void i_input_activities_something_to_search_textbox(String activities) {
//    inputActivities(activities);
//    homePage.inputOneActivities(activities);
  }




  @When("^I input \"([^\"]*)\" to search textbox and scroll to suggestion max$")
  public void i_input_something_to_search_textbox_and_scroll_to_suggestion_max(String destination) {
//    if (inputDestinationWithSuggestion(destination) == 3) {
//      System.out.println("Show max suggestion is 3");
//    } else {
//      System.out.println("Don't show max suggestion is 3");
//    }
  }



  @Then("^I verify display show suggestion max is 3$")
  public void i_verify_display_show_suggestion_max_is_3() {


  }

  @And("^I select current day$")
  public void i_select_current_day() {
//    clickToElement(driver, DATE_TEXT_HOLDER);
//    clickToElementByJavascript(driver, CURRENT_DAY);
  }

  @Then("^I verify text on landing page of activities$")
  public void i_verify_text_on_landing_page_of_activities() {
//    boolean b = StringUtils.contains(getAttribute(driver, ACT_INPUT_TEXTBOX, "placeholder"), getTextFromReadFile("SEARCH_ACT_TXT"));
//    if ( !(verifyDisplayTextAtFooter() && !b) ){
//      System.out.println("Text on landing Activities Wrong! ");
//    } else {
//      System.out.println("Text on landing Activities correct! ");
//    }
//    verifyFourOptionLandingPage();
  }

  @And("^I verify text displayed when don't input activities and click on search button$")
  public void i_verify_text_displayed_when_dont_input_activities_and_click_on_search_button() {
//    verifyErrorSearch(ACT_SEARCH_BUTTON);
  }

  @And("^Verify text in the Home page$")
  public void verify_text_in_the_home_page() {
    homePage.verifyTextHeaderHomePage();
    homePage.verifyTextFooterHomePage();
    homePage.verifyTextForEachOptionsInSearchBar();
    homePage.verifyContentHomePage();
  }

  @And("^Verify displayed when click on TOP COUNTRY at the landing page$")
  public void verify_displayed_when_click_on_top_country_at_the_landing_page() {
    homePage.verifyPageTopCountryInHomePage();
  }

  @And("^Verify navigate when click on any destination$")
  public void verify_navigate_when_click_on_any_destination() {
    homePage.verifyNavigateToSearchResultFromDestinations();
  }

  @And("^Verify display list coin when click on payment options$")
  public void verify_display_list_coin_when_click_on_payment_options() {
    homePage.verifyDisplayListCoinFromPaymentOptions();
  }


}
