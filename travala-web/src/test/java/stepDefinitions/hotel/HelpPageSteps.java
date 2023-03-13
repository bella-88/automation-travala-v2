package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.LandingPage;
import pages.hotel.footer.support.HelpCenterPage;


import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;

public class HelpPageSteps extends CommonHotelPages {
  WebDriver driver;
  private LandingPage landingPage;

  private HelpCenterPage helpCenterPage;

  public HelpPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    landingPage = new LandingPage(driver);
    helpCenterPage = new HelpCenterPage(driver);
    switchToLanguage();
  }

  @When("^I click on Help Center link$")
  public void i_click_on_help_center_link() {
    landingPage.clickToSupportColumn(HELP_CENTER_PATH);
  }

  @And("^I click on common question and verify displayed text on this page$")
  public void i_click_on_common_question_and_verify_displayed_text_on_this_page() throws Throwable {
    scrollToBottomPage(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, HELP_CENTER_PATH);
    switchToOtherWindowbyUrl(driver, HELP_CENTER_URL);
    helpCenterPage.verifyHelpPage();
//    helpCenterPage.verifyListCommon();
  }

  @And("^I click on Stays and verify displayed text on this page$")
  public void i_click_on_Stays_and_verify_displayed_text_on_this_page() throws Throwable {
    helpCenterPage.verifyStayMenu();
  }

  @And("^I click on Flights and verify displayed text on this page$")
  public void i_click_on_flights_and_verify_displayed_text_on_this_page() throws Throwable {
    helpCenterPage.verifyFlightsMenu();
  }

  @And("^I click on Activities and verify displayed text on this page$")
  public void i_click_on_activities_and_verify_displayed_text_on_this_page() throws Throwable {
    helpCenterPage.verifyActivitiesMenu();
  }


  @And("^I click on best price and verify displayed text on this page$")
  public void i_click_on_best_price_and_verify_displayed_text_on_this_page() throws Throwable {
    helpCenterPage.verifyContentBestPriceQuestion();
  }

  @And("^I click on smart program at menu and verify displayed text on this page$")
  public void i_click_on_smart_program_at_menu_and_verify_displayed_text_on_this_page() throws Throwable {
    helpCenterPage.verifyListSmartQuestion();
  }

  @And("^I click on invite program at menu and verify displayed text on this page$")
  public void i_click_on_invite_program_at_menu_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListInviteQuestion()) {
      System.out.println("List question and answers in  invite program correct");
    }
  }

  @And("^I click on gift card and verify displayed text on this page$")
  public void i_click_on_gift_card_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListGiftCardQuestion()) {
      System.out.println("List question and answers in  gift card correct");
    }
  }

  @And("^I click on credit and verify displayed text on this page$")
  public void i_click_on_credit_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListCreditQuestion()) {
      System.out.println("List question and answers in travel credit correct");
    }
  }

  @And("^I click on discount voucher and verify displayed text on this page$")
  public void i_click_on_discount_voucher_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListDiscountQuestion()) {
      System.out.println("List question and answers in  discount correct");
    }
  }

  @And("^I click on Registration and verify displayed text on this page$")
  public void i_click_on_registration_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListRegistrationQuestion()) {
      System.out.println("List question and answers in Registration correct");
    }
  }

  @And("^I click on special request and verify displayed text on this page$")
  public void i_click_on_special_request_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListSpecialRequestQuestion()) {
      System.out.println("List question and answers in special request correct");
    }
  }

  @And("^I click on contact and verify displayed text on this page$")
  public void i_click_on_contact_and_verify_displayed_text_on_this_page() throws Throwable {
    if (helpCenterPage.verifyListContactQuestion()) {
      System.out.println("List question and answers in  contact correct");
    }
  }


}
