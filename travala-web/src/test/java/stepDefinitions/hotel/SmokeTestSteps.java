package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.hotel.CheckOutPage;
import pages.hotel.LandingPage;
import pages.hotel.*;

import java.util.*;

import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;

public class SmokeTestSteps extends CommonHotelPages {
  static WebDriver driver;
  static String email;
  private SmokePage smokePage;
  private LandingPage landingPage;
  private CheckOutPage checkOutPage;
  private HomePage homePage;
  private SearchPage searchPage;

  private RegisterPage registerPage;
  private List<String> dataExpect;
  private String locationIdFirstInListLocation;

  public SmokeTestSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    smokePage = new SmokePage(driver);
    landingPage = new LandingPage(driver);
    searchPage= new SearchPage(driver);
    checkOutPage = new CheckOutPage(driver);
    homePage = new HomePage(driver);
    registerPage = new RegisterPage(driver);

  }

  @When("^I create email by yopmail$")
  public void iCreateEmailByYopmail() {
    smokePage.createYopMail();
//   email= smokePage.getYopEmail();
  }

  @And("^I input valid information on the textbox to register acc$")
  public void iInputValidInformationOnTheTextboxToRegisterAcc() {
//    smokePage.verifyNFTOnOpenSea();
//    smokePage.verifyNFTOnLookSrare();
    smokePage.verifyNFTOnRarible();

//    landingPage.registerAcc();
  }

  @And("^I confirm email to finsish register acc$")
  public void iConfirmEmailToFinsishRegisterAcc() {
    smokePage.confirmRegisterAccByYopMail();
  }

  @And("^I verify wallet address when whitelist NFT$")
  public void iVerifyWalletAddressWhenWhitelistNFT() {
    smokePage.verifyWalletNFT();
    //    smokePage.testStringText();
    smokePage.splitTextAtLanguage();
  }



  @When("^I verify links at the footer part$")
  public void i_verify_links_at_the_footer_part() {
    smokePage.verifyTagBankAtFooter();
  }

  @And("^I verify links at my profile page$")
  public void i_verify_links_at_my_profile_page() {
    loginWithTravalaAcc();
    homePage.clickToMyMyAccountLink();
  }

  @And("^I verify links at my travel credit page$")
  public void i_verify_links_at_my_travel_credit_page() {

  }

  @And("^I verify links at coin listing page$")
  public void i_verify_links_at_coin_listing_page() {

  }

  @And("^I verify links at invite page$")
  public void i_verify_links_at_invite_page() {
    homePage.clickToMyInviteLink();
    if ( smokePage.verifyTagBankAtMedia()) {
      System.out.println("=======Link at Invite page contain rel tag name=======");
    } else {
      System.out.println("=======Link at Invite page NOT contain rel tag name=======");
    }
    backToPreviousPage(driver);
  }

  @And("^I verify links at media page$")
  public void i_verify_links_at_media_page() {
    clickElementByDynamicLocator(driver, COLUMN_LIST, MEDIA_PATH);
    wait5sTime();
    if ( smokePage.verifyTagBankAtMedia()) {
      System.out.println("=======Link at Media page contain rel tag name=======");
    } else {
      System.out.println("=======Link at Media page NOT contain rel tag name=======");
    }
  }

  @And("^I verify links at mobile app page$")
  public void i_verify_links_at_mobile_app_page() {
    clickElementByDynamicLocator(driver, COLUMN_LIST, MOBILE_APP_PATH);
    if ( smokePage.verifyTagBankAtMedia()) {
      System.out.println("=======Link at Mobile App page contain rel tag name=======");
    } else {
      System.out.println("=======Link at Mobile App page NOT contain rel tag name=======");
    }
  }

  @And("^Verify page display correctly and \"([^\"]*)\" auto change to Lowercase$")
  public void verify_page_display_and_auto_change_url_to_lowercase(String endpoint) {
    //Verify auto change from Uppercase to Lowercase
    String expectURLLowercase = (getEvn() + endpoint).toLowerCase();
    String urlUppercase = (getEvn() + endpoint).toUpperCase();
    System.out.println(urlUppercase);
    openNewTab(driver, urlUppercase);
    String actualURL = getCurrentUrl(driver);
    if(actualURL.contains("login")) {
      loginWithTravalaByEmail("travala09091988@gmail.com", "travala2020");
      actualURL = getCurrentUrl(driver);
    }
    Assert.assertEquals(expectURLLowercase, actualURL);

    //Verify auto change from AlternativeCase to Lowercase
    String url = getEvn() + endpoint;
    String urlAlternativeCase = toAlternativeString(url);
    System.out.println(urlAlternativeCase);
    openNewTab(driver, urlAlternativeCase);
    actualURL = getCurrentUrl(driver);
    Assert.assertEquals(actualURL, expectURLLowercase);
  }

  @And("^Verify Canonical tag for each \"([^\"]*)\"$")
  public void verify_canonical_tag_for_each_page(String endpoint) {
    switchTab(driver);
    String url = getEvn() + endpoint;
    openNewTab(driver, url);
    smokePage.verifyCanonicalLinkOfPage();
  }

  @And("^Verify added the href link to all the tag a for each \"([^\"]*)\"$")
  public void verify_added_the_href_link_to_all_the_tag_a(String endpoint) {
    String url = getEvn() + endpoint;
    openNewTab(driver, url);
    smokePage.verifyAddedTheHrefLinkToAllTheTagA();
  }

  @And("^Verify added ref equal noopener noreferrer to all external link using target equals _blank for each \"([^\"]*)\"$")
  public void verifyAddedRefEqualsNoopenerNoreferrerToAllExternalLink(String endpoint) {
    String url = getEvn() + endpoint;
    openNewTab(driver, url);
    String urlCurrent = getCurrentUrl(driver);
    if(urlCurrent.contains("login")) {
      loginWithTravalaByEmail("travala09091988@gmail.com", "travala2020");
    }
    smokePage.verifyAddedRefEqualsNoopenerNoreferrer(url);
  }

  @And("^At home page, i search hotel with \"([^\"]*)\" and verify list hotel in search result page$")
  public void search_hotel_with_destination_and_verify_list_hotel_in_search_result_page(String destinationName) {
//    registerPage.closeSignUpJourneyPopUp();
    openNewTab(driver, getEvn());
    searchPage.searchByDestination(destinationName);
    List<String> listHotelActual = searchPage.getListHotelInSearchResult();
    Assert.assertEquals(dataExpect, listHotelActual);
  }


}