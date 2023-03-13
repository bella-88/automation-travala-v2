package stepDefinitions.hotel;


import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.*;
import pages.hotel.myProfile.MyTravelCreditsPage;
//import pages.hotel.CheckOutPage;
//import pages.hotel.HomePage;
//import pages.hotel.PropertyPage;
//import pages.hotel.RegisterPage;
//import pages.hotel.myProfile.MyTravelCreditsPage;


import static commons.CommonHotelURL.*;
import static commons.CommonsTravalaXpath.*;
import static interfaces.hotel.CheckOutPageUI.CHECKOUT_PROCESS_PAYMENT_BTN;
import static interfaces.hotel.SearchPageUI.FIRST_CHOOSE_ROOM_BUTTON_IN_SEARCH_RESULT;
//import static commons.CommonHotelURL.*;
//import static interfaces.CheckOutPageUI.CHECKOUT_PROCESS_PAYMENT_BTN;
//import static interfaces.SearchPageUI.*;

public class LoginPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private static final String PREFIX_EMAIL_SIGN_UP = "travala-tes";
  private static final String DOMAIN_MAILSAC = "@mailsac.com";
  private static final String PASSWORD_SIGN_UP = "Travala@123";

  public LoginPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
  }

  @When("^I click on Login link$")
  public void i_click_on_login_link() {
    driver.findElement(By.xpath(LOGIN_LINK)).click();
  }

  @And("^I click on Login button$")
  public void i_click_on_login_button() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebElement a = driver.findElement(By.xpath("//iframe[@role]"));
    driver.switchTo().frame(a);
    driver.findElement(By.xpath("//div[@class=\"rc-anchor-center-item rc-anchor-checkbox-holder\"]/span")).click();
    driver.switchTo().defaultContent();
    clickElement(driver, LOGIN_BTN);
  }

  @Then("^I verify Homepage displayed$")
  public void i_verify_homepage_displayed() {
    driver.quit();
  }
  @When("^I verify testcase$")
  public void i_verify_testcase() {
    String st = "MembershipMembership Memb";
    System.out.println("size string: "+ st.length());
  }

  @Given("^Open browser with url includes \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
  public void open_browser_with_url_includes(String utm_campaign, String utm_term, String utm_content, String camp_voucher,
                                             String camp_voucher_discount, String camp_credit, String camp_code) throws Throwable {
    String campaign = "utm_campaign=" + utm_campaign;
    String term = "utm_term=" + utm_term;
    String content = "utm_content=" + utm_content;
    String campVoucher = "camp_voucher=" + camp_voucher;
    String campVoucherDiscount = "camp_voucher_discount=" + camp_voucher_discount;
    String campCredit = "camp_credit=" + camp_credit;
    String campCode = "camp_code=" + camp_code;
    String domain = "https://travala-pr-265.herokuapp.com?";

    String url = domain + campaign + "&" + term + "&" + content + "&" + campVoucher + "&" + campVoucherDiscount + "&" + campCredit + "&" + campCode;
    System.out.println("URL " + url);
    openNewTab(driver, url);
  }

  @When("^I sign up or login successfully by partner journey \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
  public void i_sign_up_or_login_successfully_by_partner_journey(String utm_campaign, String utm_term, String camp_voucher_discount, String camp_credit) throws Throwable {
    String email = PREFIX_EMAIL_SIGN_UP + getCurrentDateTime("yyyyMMddHHmmss") + DOMAIN_MAILSAC;
    String password = PASSWORD_SIGN_UP;
    RegisterPage registerPage = new RegisterPage(driver);
//    registerPage.verifyLoginRegisterJourneyPopUpDisplayed(utm_campaign, utm_term, camp_voucher_discount, camp_credit);
//    registerPage.doRegisterJourney(email, password);
  }

  @Then("^Verify to receive bonus reward after sign up \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
  public void verify_to_receive_bonus_reward_after_sign_up(String utm_term, String camp_voucher, String camp_voucher_discount, String camp_credit) throws Throwable {
    switch (utm_term) {
      case "credit":
        String expectNote = "Bonus rewards for signup\n" + "Expired at " +
                getDateTimePlusDayByTimezone("dd/MM/yyyy - hh:mm", "GMT", 90) +" GMT";
        HomePage homePage = new HomePage(driver);
        homePage.verifyBalanceOnHeader(camp_credit);
        homePage.goToMyTravelCredits();

        MyTravelCreditsPage myTravelCreditsPage = new MyTravelCreditsPage(driver);
        myTravelCreditsPage.verifyBalanceInMyTravelCredits(camp_credit);
        myTravelCreditsPage.verifyTransactionInMyTravelCredits(expectNote);
        System.out.println("Receive US$" + camp_credit + " in My Travel Credits");
        break;
      case "discount":
        //Search a hotel
        inputLocationSearch(randomDestination());
        clickSearchHotelBtn(driver);
        switchToWindowByUrlContainsString(driver, SEARCH_PATH);
//        waitFoElementVisible(driver, FIRST_PROPERTY );
        wait1sTime();
        clickToElement(driver, FIRST_CHOOSE_ROOM_BUTTON_IN_SEARCH_RESULT);
        switchToWindowByUrlContainsString(driver, PROPERTY_PATH);
        PropertyPage propertyPage = new PropertyPage(driver);
        propertyPage.clickBookNowBtn();

        //Input customer info
       CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.inputCustomserInformation(1);
        clickToElement(driver, CHECKOUT_PROCESS_PAYMENT_BTN);
        wait100Time();
        System.out.println("Receive a voucher discount " + camp_voucher_discount);
        break;
      default:
        System.out.println("No promo code or discount to customer.");
        break;
    }
  }

}
