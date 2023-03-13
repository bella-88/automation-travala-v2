package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.*;
import pages.hotel.coinLanding.LinkPage;
import pages.hotel.footer.useful.PaymentOptionsPage;


import java.util.Currency;

import static commons.CommonTravalaURL.TRAVALA_LIVE_URL;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;

public class LandingPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private LandingPage landingPage;
  private RegisterPage registerPage;
//  private SearchPage searchPage;
  private PropertyPage propertyPage;
  private CountryPage countryPage;
  private String landingPageWindow;
  private RegisterPage loginPage;
  private NotFoundPage notFoundPage;
  private ForgotPasswordPage forgotPasswordPage;
  private HomePage homePage;
  private Currency currency;
  private PaymentOptionsPage paymentOptionsPage;
  private LinkPage linkPage;

  public LandingPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    loginPage = new RegisterPage(driver);
    homePage = new HomePage(driver);
    notFoundPage = new NotFoundPage(driver);
    forgotPasswordPage = new ForgotPasswordPage(driver);
    registerPage = new RegisterPage(driver);
  }

  @When("^I login to system by travala email$")
  public void iLoginToSystemByTravalaEmail() {
    driver.get(TRAVALA_LIVE_URL);
    landingPage.loginWithTravalaAcc();
    switchToLanguage();
  }

  @When("^I login to system travala to check captcha$")
  public void iLoginToSystemTravalaToCheckCaptcha() {
    landingPage.loginEmailCaptcha();
  }

  @When("^I login to system by \"([^\"]*)\" and \"([^\"]*)\"$")
  public void iLoginToSystemByAnd(String user, String password) {
    landingPage.loginToSystem(user, password);
  }

  @And("^I login with acc doesnt have enough BUSD to payment$")
  public void iLoginWithAccDoesntHaveEnoughBUSDToPayment() {
    landingPage.loginWithBellaAcc();
  }

  //================INPUT CONDITION TO SEARCH BAR=========================

  @And("^I input property into textbox Search \"([^\"]*)\"$")
  public void i_input_property_into_textbox_search_something(String propertyTxt) {
    inputPropertySearch(propertyTxt);
    datePickerAnyDayHotel(randomDay());
//    selectTwoRoom();
  }

  @When("^I input destination and choose default check-in and room$")
  public void iInputDestinationAndChooseDefaultCheckInAndRoom() {
    inputLocationSearch(randomDestination());
  }

  @And("^I input destination and choose check-in and check-out greater than one night$")
  public void iInputDestinationAndChooseCheckInAndCheckOutGreaterThanOneNight() {
    inputLocationSearch(randomDestination());
    datePickerAnyDayHotel(randomDay());
  }

  @And("^I input destination and choose date time and room greater than one$")
  public void iInputDestinationAndChooseDateTimeAndRoomGreaterThanOne() {
    inputLocationSearch(randomDestination());
    datePickerAnyDayHotel(randomDay());
//    selectTwoRoom();
  }

  @And("^I input destination and choose room greater than one room$")
  public void iInputDestinationAndChooseRoomGreaterThanOneRoom() {
    inputLocationSearch(randomDestination());
    datePickerAnyDayHotel(randomDay());
  }

  @And("^I input property into textbox Search \"([^\"]*)\" and choose full option \"([^\"]*)\"$")
  public void iInputPropertyIntoTextboxSearchAndChooseFullOption(String propertyTxt, int day) {
    inputPropertySearch(propertyTxt);
    datePickerAnyDayHotel(randomDay());
//    selectTwoRoom();
  }

  @And("^I input country and verify text on that page$")
  public void iInputCountryAndVerifyTextOnThatPage() {
    String country = randomCountry();
//    inputLocationSearch(country);
    landingPage.clickSearchCountryBtn(country);
    countryPage = new CountryPage(driver);
    countryPage.verifyNavigateToCountryPage(country);
    countryPage.verifyTextCountry(country);
  }
  @When("^I click on forgot password link$")
  public void i_click_on_forgot_password_link() {
    registerPage.clickForgotPassword();
    wait1sTime();
    forgotPasswordPage.verifyTextForgotPassword();
  }

  @And("^I input \"([^\"]*)\" to textbox and verify text on this page$")
  public void i_input_something_to_textbox_and_verify_text_on_this_page(String email) {
    forgotPasswordPage.inputEmailToForgotPassword(email);
    clickBackToTravala(driver);
  }

  @When("^I click on Register link and verify displayed text on this page$")
  public void i_click_on_register_link_and_verify_displayed_text_on_this_page() {
    registerPage.verifyRegisterForm();
  }

  @And("^I input empty the textbox on this form and verify error message on this form$")
  public void i_input_empty_the_textbox_on_this_form_and_verify_error_message_on_this_form() {
    registerPage.verifyEmptyRegister();
  }

  @And("^I input invalid new password and confirm new password on this form$")
  public void iInputInvalidNewPasswordAndConfirmNewPasswordOnThisForm() {
  }

  @When("^I click on any destination on the landing page and verify navigate that page$")
  public void iClickOnAnyDestinationOnTheLandingPageAndVerifyNavigateThatPage() {
    landingPage.clickToDestination("Da Nang");
  }

  @And("^I verify text displayed when don't input hotel and click on search button$")
  public void i_verify_text_displayed_when_dont_input_hotel_and_click_on_search_button() {
//    verifyErrorSearch(LANDING_SEARCH_BUTTON);
  }

  @And("^I verify text on my trip and search invalid order$")
  public void i_verify_text_on_my_trip_and_search_invalid_order() {
    landingPage.clickToElementByJavascript(driver, LANDING_MY_TRIP_LINK);
//    && landingPage.verifySearchErrorMyTrip()
    if (landingPage.verifyTextFormMyTrip()) {
      System.out.println("Text on MY TRIP is displayed correct");
    } else {
      System.out.println("Text on MY TRIP is displayed wrong");
    }
    landingPage.clickToElementByJavascript(driver, LANDING_MY_TRIP_CLOSE);
  }

  @And("^I verify text on title of Customer Review Choose You and Discover$")
  public void i_verify_text_on_title_of_customer_review_choose_you_and_discover() {
    landingPage.verifyTitle3Part();
  }

  @And("^I verify text at destination when move mouse to destination$")
  public void i_verify_text_at_destination_when_move_mouse_to_destination() {
    landingPage.verifyDestination();
//    landingPage.verifyDestinationTextHold();
//    if (landingPage.verifyDestinationTextHold() && landingPage.verifyDestination()) {
//      System.out.println("Text on destination when move mouse to destination is displayed correct");
//    } else {
//      System.out.println("Text on destination when move mouse to destination is displayed wrong");
//    }
  }


  @When("^I input invalid keyword to textbox search and verify display message$")
  public void iInputInvalidKeywordToTextboxSearchAndVerifyDisplayMessage() {
    clickToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
    WebElement element = driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX_FIRST));
    element.sendKeys(randomString());
    if (verifyTextByKey("SEARCH_NO_RESULT", NO_RESULT_SEARCH)) {
      System.out.println("Show message when input Invalid keyword to Search correct");
    } else {
      System.out.println("Show message when input Invalid keyword to Search wrong");
    }
    clickToElementByJavascript(driver, NO_RESULT_SEARCH_CLOSE);
  }

  @And("^I verify text of search bar on the landing page$")
  public void i_verify_text_of_search_bar_on_the_landing_page() {
    verifyTextSearchBar();
  }
  //================================VERIFY LANGUAGE TOP COUNTRY==================================================================================


  @And("^I click any country and verify text of country page$")
  public void iClickAnyCountryAndVerifyTextOfCountryPage() {
    landingPage.verifyDisplayTopCountryTxt();
  }

  //==========================NOT FOUND PAGE=============================
  @And("^I navigate to not found page and verify text on this page$")
  public void iNavigateToNotFoundPageAndVerifyTextOnThisPage() {
    landingPage.openNewTab();
    notFoundPage = new NotFoundPage(driver);
    notFoundPage.verifyText();
    if (verifyDisplayTextAtFooter()) {
      System.out.println("404 Not Found is displayed correct! ");
    }
    clickBackToTravala(driver);
  }

  @When("^I click on any link at Travala column and verify display on that page$")
  public void i_click_on_any_link_at_travala_column_and_verify_display_on_that_page() {
    landingPage.clickToTravalaColumn(ABOUT_US_PATH);
    landingPage.clickToTravalaColumn(AVA_TOKEN_PATH);
    landingPage.clickToTravalaColumn(PRICE_GUARANTEE_PATH);
    landingPage.clickToTravalaColumn(AFFILIATE_PROGRAM_PATH);
    landingPage.clickToTravalaColumn(TRAVEL_CREDITS_PATH);
    landingPage.clickToTravalaColumn(TRAVEL_GIFT_CARD_PATH);
    landingPage.clickToTravalaColumn(TRAVEL_MEMBER_PATH);
  }

  @And("^I click on any link at Support column and verify display on that page$")
  public void i_click_on_any_link_at_support_column_and_verify_display_on_that_page() {
    landingPage.clickToSupportColumn(HELP_CENTER_PATH);
    landingPage.clickToSupportColumn(TERMS_CONDITIONS_PATH);
    landingPage.clickToSupportColumn(PRIVACY_POLICY_PATH);
    landingPage.clickToSupportColumn(COOKIE_POLICY_PATH);
    landingPage.clickToSupportColumn(CONTACT_US_PATH);
    landingPage.clickToSupportColumn(PARTNER_SHIP_PATH);
    landingPage.clickToSupportColumn(CONCIERGE);
    landingPage.clickToSupportColumn(MEDIA_PATH);
  }

  @And("^I click on any link at Useful column and verify display on that page$")
  public void i_click_on_any_link_at_useful_column_and_verify_display_on_that_page() {
    landingPage.clickToUsefulColumn(MOBILE_APP_PATH);
    landingPage.clickToUsefulColumn(BUSINESS_TRAVEL_PATH);
    landingPage.clickToUsefulColumn(PAYMENT_OPTIONS_PATH);
    landingPage.clickToUsefulColumn(BINANCE_TRAVEL_PATH);
    landingPage.clickToUsefulColumn(PARTNER_NETWORK_URL);
    landingPage.clickToUsefulColumn(SITEMAP);
    landingPage.clickToUsefulColumn(BUG_REPORT_URL);
  }

  @And("^I click on any link at Resources column and verify display on that page$")
  public void i_click_on_any_link_at_resources_column_and_verify_display_on_that_page() {
    landingPage.clickToResourcesColumn(OFFICAL_BLOG_URL);
    landingPage.clickToResourcesColumn(TRAVEL_ADVICES_URL);
    landingPage.clickToResourcesColumn(TRAVEL_GUIDES_URL);
    landingPage.clickToResourcesColumn(TRAVEL_GUIDES_URL);
    landingPage.clickToResourcesColumn(TRUST_PILOT_URL);
    landingPage.clickToResourcesColumn(OUR_PARTNER_URL);
    landingPage.clickToResourcesColumn(COIN_LIST_PATH);
    landingPage.clickToResourcesColumn(CAREERS_PATH);
  }

  @And("^I click on any link at Community column and verify display on that page$")
  public void i_click_on_any_link_at_community_column_and_verify_display_on_that_page() {
    landingPage.clickToCommunityColumn(TWITTER);
    landingPage.clickToCommunityColumn(FACEBOOK);
    landingPage.clickToCommunityColumn(TELEGRAM);
    landingPage.clickToCommunityColumn(INSTAGRAM);
    landingPage.clickToCommunityColumn(REDDIT);
    landingPage.clickToCommunityColumn(LINKEDIN);
  }

  @And("^I verify display and navigate page four option on the landing page$")
  public void iVerifyDisplayAndNavigatePageFourOptionOnTheLandingPage() {
    verifyFourOptionLandingPage();
    landingPage.clickToFourBenefit("1");
    landingPage.clickToFourBenefit("2");
    landingPage.clickToFourBenefit("3");
    landingPage.clickToFourBenefit("4");
  }

  @And("^I verify navigate to page when click on banner$")
  public void iVerifyNavigateToPageWhenClickOnBanner() {
    clickToElementByJavascript(driver, "//a[contains(@class,'BannerMaldive')]");
  }

  @And("^I verify the links on the header when not login$")
  public void iVerifyTheLinksOnTheHeaderWhenNotLogin() {

  }

  @And("^I verify the links on the header when login$")
  public void iVerifyTheLinksOnTheHeaderWhenLogin() {

  }

  @And("^I verify navigate to page when click on url on header$")
  public void iVerifyNavigateToPageWhenClickOnUrlOnHeader() {
    landingPage.verifyDisplayUrlHeader();
  }

  @And("^I verify navigate to page when click on url domain on header$")
  public void iVerifyNavigateToPageWhenClickOnUrlDomainOnHeader() {
    verifyClickOnURLDomainHeader();
  }

  @When("^I search \"([^\"]*)\" and \"([^\"]*)\" at header part$")
  public void iSearchAndAtHeaderPart(String language, String coin) {
    clickToElementByJavascript(driver, GLOBE_ICON_HEADER);
//    verifySearchLanguageHeader(language);
    verifySearchCoinHeader(coin);
  }

  @And("^I verify result displayed after search$")
  public void iVerifyResultDisplayedAfterSearch() {
  }

  @When("^I verify text on Campaign Part of Landing page$")
  public void iVerifyTextOnCampaignPartOfLandingPage() {
    landingPage.verifyDisplayCampaignPart();
    switchToOtherWindowbyUrl(driver, TRAVALA_LIVE_URL);
  }


}