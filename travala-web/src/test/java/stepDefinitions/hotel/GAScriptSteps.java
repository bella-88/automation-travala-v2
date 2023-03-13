package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.footer.resources.*;
import pages.hotel.footer.support.*;
import pages.hotel.footer.travala.*;
import pages.hotel.footer.useful.*;

import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.PropertyPageUI.*;
import static interfaces.hotel.SearchPageUI.*;
import static interfaces.hotel.SearchPageUI.SEARCH_RESULT_HEADER_MENU;
import static interfaces.hotel.footer.travala.InvitePageUI.*;
import static interfaces.hotel.footer.travala.SmartPageUI.*;

import pages.hotel.*;
public class GAScriptSteps extends CommonHotelPages {
  static WebDriver driver;

  private SmartProgramPage smartProgramPage;
  private SmartTermPage smartTermPage;
  private InviteTermPage inviteTermPage;
  private InviteProgramPage inviteProgramPage;
  private PropertyPage propertyPage;
  private LandingPage landingPage;
  private SearchPage searchPage;
  private HomePage homePage;
//  ActBookingPage actBookingPage;
//  FlightSearchPage flightsearchPage;
//  FlightBookingPage  flightBookingPage;
  private CheckOutPage checkOutPage;
  private String searchTxt = "Ha Noi";
  private String searchProperty = "Sofitel Legend Metropole Hanoi";

  public GAScriptSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    homePage = new HomePage(driver);
//    ActDetailPage actDetailPage = new ActDetailPage(driver);
//     actBookingPage = new ActBookingPage(driver);
//     flightsearchPage= new FlightSearchPage(driver);
//      flightBookingPage = new FlightBookingPage(driver);
  }

  @When("^I open landing page and verify test script GA$")
  public void i_open_landing_page_and_verify_test_script_ga() {
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Landing page");
    } else {
      System.out.println("Script GA isn't displayed at Landing page");
    }
  }

  @And("^I verify test script GA at search page$")
  public void iVerifyTestScriptGAAtSearchPage() {
    inputLocationSearch(searchTxt);
    clickSearchHotelBtn(driver);
    switchToWindowByUrlContainsString(driver, HOTEL_SEARCH);
    searchPage= new SearchPage(driver);
    switchToWindowByUrlContainsString(driver, getTextElement(driver, SEARCH_RESULT_HEADER_MENU));
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Search page");
    } else {
      System.out.println("Script GA isn't displayed at Search page");
    }
  }

//  @And("^I verify test script GA at property page$")
//  public void iVerifyTestScriptGAAtPropertyPage() {
//    clickToElementByAction(driver, FIRST_PROPERTY);
//    switchToWindowByUrlContainsString(driver, HOTEL_PROPERTY);
//    propertyPage = new PropertyPage(driver);
//    clickToElement(driver, BEST_PRICE_BOOK_NOW_FIRST);
//    switchToWindowByUrlContainsString(driver, HOTEL_CHECKOUT);
//    waitFoElementVisible(driver, NAME_LINK_TOTAL_CHARGE);
//    System.out.println("Link to property correct====" + getTextElement(driver, NAME_LINK_TOTAL_CHARGE) + "=====");
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Property page");
//    } else {
//      System.out.println("Script GA isn't displayed at Property page");
//    }
//    clickBackToTravala(driver);
//  }

  @And("^I click on about us link and verify test script GA$")
  public void i_click_on_about_us_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(ABOUT_US_PATH);
    AboutUsPage aboutUsPage = new AboutUsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at About us page");
    } else {
      System.out.println("Script GA isn't displayed at About us page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on AVA token link and verify test script GA$")
  public void i_click_on_ava_token_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(AVA_TOKEN_PATH);
    AvaTokenPage avaTokenPage = new AvaTokenPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at AVA token page");
    } else {
      System.out.println("Script GA isn't displayed at AVA token page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on invite program and verify test script GA$")
  public void i_click_on_invite_program_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(INVITE_PATH);
    switchToWindowByUrlContainsString(driver, INVITE_URL);
    inviteProgramPage = new InviteProgramPage(driver);

    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at invite program page");
    } else {
      System.out.println("Script GA isn't displayed at invite program page");
    }
  }

  @And("^I click on Invite Term link and verify test script GA$")
  public void i_click_on_invite_term_link_and_verify_test_script_ga() {
    scrollToElement(driver, INVITE_FOOTER_TERM);
    clickToElement(driver, INVITE_FOOTER_TERM);
    inviteTermPage = new InviteTermPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Invite Term page");
    } else {
      System.out.println("Script GA isn't displayed at Invite Term page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on smart program and verify test script GA$")
  public void i_click_on_smart_program_and_verify_test_script_ga() {
    smartProgramPage = new SmartProgramPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at smart program page");
    } else {
      System.out.println("Script GA isn't displayed at smart program page");
    }
  }

  @And("^I click on Smart Term link and verify test script GA$")
  public void i_click_on_smart_term_link_and_verify_test_script_ga() {
    clickToElement(driver, SMART_PROGRAM_TERM_LINK);
    smartTermPage = new SmartTermPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Smart Term page");
    } else {
      System.out.println("Script GA isn't displayed at Smart Term page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Price Guarantee link and verify test script GA$")
  public void i_click_on_price_guarantee_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(INVITE_PATH);
    PriceGuaranteePage priceGuaranteePage = new PriceGuaranteePage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Price Guarantee page");
    } else {
      System.out.println("Script GA isn't displayed at Price Guarantee page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Travel credits link and verify test script GA$")
  public void i_click_on_travel_credits_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(TRAVEL_CREDITS_PATH);
    TravelCreditPage travelCreditPage = new TravelCreditPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Travel credits  page");
    } else {
      System.out.println("Script GA isn't displayed at Travel credits  page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Travel Gift card link and verify test script GA$")
  public void i_click_on_travel_gift_card_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(TRAVEL_GIFT_CARD_PATH);
    TravelGiftCardPage travelGiftCardPage = new TravelGiftCardPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Travel Gift page");
    } else {
      System.out.println("Script GA isn't displayed at Travel Gift page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Contact us link and verify test script GA$")
  public void i_click_on_contact_us_link_and_verify_test_script_ga() {
    landingPage.clickToUsefulColumn(CONTACT_US_PATH);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Contact us  page");
    } else {
      System.out.println("Script GA isn't displayed at Contact us  page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Binance Travel link and verify test script GA$")
  public void i_click_on_binance_travel_link_and_verify_test_script_ga() {
    landingPage.clickToUsefulColumn(BINANCE_TRAVEL_PATH);
    BinaceTravelPage binaceTravelPage = new BinaceTravelPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Binance Travel page");
    } else {
      System.out.println("Script GA isn't displayed at Binance Travel page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Help Center link and verify test script GA$")
  public void iClickOnHelpCenterLinkAndVerifyTestScriptGA() {
    landingPage.clickToSupportColumn(HELP_CENTER_PATH);
    HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Help Center page");
    } else {
      System.out.println("Script GA isn't displayed at Help Center page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Affiliate Program link and verify test script GA$")
  public void i_click_on_affiliate_program_link_and_verify_test_script_ga() {
    landingPage.clickToTravalaColumn(AFFILIATE_PROGRAM_PATH);
    AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Affiliate Program page");
    } else {
      System.out.println("Script GA isn't displayed at Affiliate Program page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Terms & Conditions link and verify test script GA$")
  public void i_click_on_terms_conditions_link_and_verify_test_script_ga() {
    landingPage.clickToSupportColumn(TERMS_CONDITIONS_PATH);
    TermsConditionsPage termsConditionsPage = new TermsConditionsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Terms & Conditions page");
    } else {
      System.out.println("Script GA isn't displayed at Terms & Conditions page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Privacy Policy link and verify test script GA$")
  public void i_click_on_privacy_policy_link_and_verify_test_script_ga() {
    landingPage.clickToSupportColumn(PRIVACY_POLICY_PATH);
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Privacy Policy page");
    } else {
      System.out.println("Script GA isn't displayed at Privacy Policy page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Travel Member link and verify test script GA$")
  public void i_click_on_travel_member_link_and_verify_test_script_ga() {
    landingPage.clickToUsefulColumn(TRAVEL_MEMBER_PATH);
    TravelMemberPage travelMemberPage = new TravelMemberPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Travel Member page");
    } else {
      System.out.println("Script GA isn't displayed at Travel Member page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Cookie Policy link and verify test script GA$")
  public void i_click_on_cookie_policy_link_and_verify_test_script_ga() {
    landingPage.clickToSupportColumn(COOKIE_POLICY_PATH);
    CookiePolicyPage cookiePolicyPage = new CookiePolicyPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Cookie Policy page");
    } else {
      System.out.println("Script GA isn't displayed at Cookie Policy page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Mobile Apps link and verify test script GA$")
  public void i_click_on_mobile_apps_link_and_verify_test_script_ga() {
    landingPage.clickToUsefulColumn(MOBILE_APP_PATH);
    MobileAppsPage mobileAppsPage = new MobileAppsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at  Mobile Apps page");
    } else {
      System.out.println("Script GA isn't displayed at  Mobile Apps page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Payment Options link and verify test script GA$")
  public void i_click_on_payment_options_link_and_verify_test_script_ga() {
    landingPage.clickToSupportColumn(PAYMENT_OPTIONS_PATH);
    PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Payment Options page");
    } else {
      System.out.println("Script GA isn't displayed at Payment Options page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Business Travel link and verify test script GA$")
  public void i_click_on_business_travel_link_and_verify_test_script_ga() {
    landingPage.clickToUsefulColumn(BUSINESS_TRAVEL_PATH);
    BusinessTravelPage businessTravelPage = new BusinessTravelPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Business Travel page");
    } else {
      System.out.println("Script GA isn't displayed at Business Travel page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Official Blog link and verify test script GA$")
  public void i_click_on_official_blog_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(OFFICAL_BLOG);
    OfficalBlogPage officalBlogPage = new OfficalBlogPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Official Blog page");
    } else {
      System.out.println("Script GA isn't displayed at Official Blog page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Travel Advices link and verify test script GA$")
  public void i_click_on_travel_advices_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(TRAVEL_ADVICES);
    TravelAdvicesPage travelAdvicesPage = new TravelAdvicesPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Travel Advices page");
    } else {
      System.out.println("Script GA isn't displayed at Travel Advices page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Travel Guides link and verify test script GA$")
  public void i_click_on_travel_guides_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(TRAVEL_GUIDES);
    TravelGuidesPage travelGuidesPage = new TravelGuidesPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Travel Guides page");
    } else {
      System.out.println("Script GA isn't displayed at Travel Guides page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Read Reviews link and verify test script GA$")
  public void i_click_on_read_reviews_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(TRUST_PILOT);
    ReadReviewsPage readReviewsPage = new ReadReviewsPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Read Reviews page");
    } else {
      System.out.println("Script GA isn't displayed at Read Reviews page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Our Partners link and verify test script GA$")
  public void i_click_on_our_partners_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(OUR_PARTNER);
    OurPartnersPage ourPartnersPage = new OurPartnersPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Our Partners page");
    } else {
      System.out.println("Script GA isn't displayed at Our Partners page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on Coin listing link and verify test script GA$")
  public void i_click_on_coin_listing_link_and_verify_test_script_ga() {
    landingPage.clickToResourcesColumn(COIN_LIST_PATH);
    CoinListPage coinListPage = new CoinListPage(driver);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at Coin listing page");
    } else {
      System.out.println("Script GA isn't displayed at Coin listing page");
    }
    clickBackToTravala(driver);
  }

  @And("^I click on My Account and and verify test script GA$")
  public void i_click_on_my_account_and_and_verify_test_script_ga() {
    homePage.clickToMyMyAccountLink();
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Account page");
    } else {
      System.out.println("Script GA isn't displayed at My Account page");
    }
  }

  @And("^I click on my invite link and verify test script GA$")
  public void i_click_on_my_invite_link_and_verify_test_script_ga() {
    clickToElement(driver, MY_INVITE_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Account page");
    } else {
      System.out.println("Script GA isn't displayed at My Account page");
    }
  }

  @And("^I verify Referral page and verify test script GA$")
  public void i_verify_referral_page_and_verify_test_script_ga() {

  }

  @And("^I click on My Wallet and verify test script GA$")
  public void i_click_on_my_wallet_and_verify_test_script_ga() {
    clickToElement(driver, MY_WALLET_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Wallet page");
    } else {
      System.out.println("Script GA isn't displayed at My Wallet page");
    }
  }

  @And("^I click on My Travel Credit and verify test script GA$")
  public void i_click_on_my_travel_credit_and_verify_test_script_ga() {
    clickToElement(driver, MY_TRAVEL_CREDIT_MENU_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Travel Credit page");
    } else {
      System.out.println("Script GA isn't displayed at My Travel Credit page");
    }
  }

  @And("^I click on My Smart and verify test script GA$")
  public void i_click_on_my_smart_and_verify_test_script_ga() {
    clickToElement(driver, MY_SMART_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Smart page");
    } else {
      System.out.println("Script GA isn't displayed at My Smart page");
    }
  }

  @And("^I click on My wishlist and verify test script GA$")
  public void i_click_on_my_wishlist_and_verify_test_script_ga() {
    clickToElement(driver, MY_WISHLIST_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My WishList page");
    } else {
      System.out.println("Script GA isn't displayed at My WishList page");
    }
  }

  @And("^I click on my booking and verify test script GA$")
  public void i_click_on_my_booking_and_verify_test_script_ga() {
    clickToElementByJavascript(driver, MY_BOOKING_LINK);
    if (verifyScriptGA(driver)) {
      System.out.println("Script GA is displayed at My Booking page");
    } else {
      System.out.println("Script GA isn't displayed at My Booking page");
    }
    clickBackToTravala(driver);
  }

//  @When("^I input destination and verify test script GA on search Activities page$")
//  public void iInputDestinationAndVerifyTestScriptGAOnSearchActivitiesPage() {
//    landingPage.clickToSearchAct();
////    clickSearchActivitiesButton();
//    switchToWindowByUrlContainsString(driver, ACT_SEARCH);
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Search Activities page");
//    } else {
//      System.out.println("Script GA isn't displayed at Search Activities page");
//    }
//    clickBackToTravala(driver);
//  }
//
//  @And("^I input activities and verify test script GA on detail Activities page$")
//  public void iInputActivitiesAndVerifyTestScriptGAOnDetailActivitiesPage() {
//    actDetailPage.clickToSearchDetailAct();
//    actDetailPage.select2Adults();
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Detail Activities page");
//    } else {
//      System.out.println("Script GA isn't displayed at Detail Activities page");
//    }
//
//  }

//  @And("^I click on the package to link to booking and verify test script GA on this page$")
//  public void iClickOnThePackageToLinkToBookingAndVerifyTestScriptGAOnThisPage() {
//    actDetailPage.clickBookNowButton();
//    switchToWindowByUrlContainsString(driver, ACT_BOOKING);
//    waitFoElementVisible(driver, NAME_LINK_TOTAL_CHARGE);
//    System.out.println("Link to booking activities: " + getTextElement(driver, NAME_LINK_TOTAL_CHARGE));
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Booking Activities page");
//    } else {
//      System.out.println("Script GA isn't displayed at Booking Activities page");
//    }
//    clickBackToTravala(driver);
//  }


//  @And("^I select flight option to input destination and verify test script GA on flight page$")
//  public void iSelectFlightOptionToInputDestinationAndVerifyTestScriptGAOnFlightPage() {
//    landingPage.clickToSearchFlight();
//    flightsearchPage= new FlightSearchPage(driver);
//    switchToWindowByUrlContainsString(driver, FLIGHT_SEARCH);
//    waitFoElementVisible(driver, FLIGHT_SEARCH_RESULT_TXT);
//    System.out.println("get text search flight: " + getTextElement(driver, FLIGHT_SEARCH_RESULT_TXT));
//    wait5sTime();
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Search Flight page");
//    } else {
//      System.out.println("Script GA isn't displayed at Search Flight page");
//    }
//  }
//
//  @And("^I click on select flight and verify test script GA on booking page$")
//  public void iClickOnSelectFlightAndVerifyTestScriptGAOnBookingPage() {
//    flightSearchPage.selectReturnFlight();
//    switchToWindowByUrlContainsString(driver, FLIGHT_PASSENGER);
//    System.out.println("Link to Passenger detail: " + getTextElement(driver, FLIGHT_BOOKING_PRICE));
//    if (verifyScriptGA(driver)) {
//      System.out.println("Script GA is displayed at Passenger Detail page");
//    } else {
//      System.out.println("Script GA isn't displayed at Passenger Detail page");
//    }
//  }
}
