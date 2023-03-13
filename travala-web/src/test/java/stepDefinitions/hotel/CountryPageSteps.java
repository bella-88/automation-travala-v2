package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.CountryPage;
import pages.hotel.LandingPage;

import static commons.CommonHotelURL.SINGAPORE_URL;
import static interfaces.hotel.CountryPageUI.INFOR_COUNTRY;

public class CountryPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private LandingPage landingPage;
  private CountryPage countryPage;
  private String landingPageWindow;
public CountryPageSteps(){
  driver = HooksHotel.openBrowserTravala();
  super.setDriver(driver);
  countryPage = new CountryPage(driver);

}

  @Then("^I verify the information displayed \"([^\"]*)\"$")
  public void i_verify_the_information_displayed_something(String expectedCountry) throws Throwable {
    String actualCountry = getTextElement(driver, INFOR_COUNTRY).trim();
    if (StringUtils.equals(actualCountry, expectedCountry)) {
      System.out.println("Display country page correct");
    } else {
      System.out.println("Display country page failed");
    }
    backToPreviousPage(driver);
  }

  @Then("^I verify text of search bar on the country page$")
  public void i_verify_text_of_search_bar_on_the_country_page() throws Throwable {

    boolean titleCountry = StringUtils.equals(getTextFromReadFile("LandingPage_CustomerSupport"), getTextElement(driver, INFOR_COUNTRY).trim());
    boolean subTitleCountry = StringUtils.equals(getTextFromReadFile("LandingPage_CustomerSupport"), getTextElement(driver, INFOR_COUNTRY).trim());
    System.out.println("titleCountry" + titleCountry);
    System.out.println("subTitleCountry" + subTitleCountry);
    if (titleCountry && subTitleCountry) {
      System.out.println("Text on country page is displayed correct");
    } else {
      System.out.println("Text on country page is displayed wrong");
    }
  }

  @When("^I click on Singapore link and input location \"([^\"]*)\" to search box$")
  public void i_click_on_singapore_link_and_input_location_something_to_search_box(String searchTxt) throws Throwable {
    landingPage.clickToCountryPage("4");
    landingPage.switchToOtherWindowbyUrl(driver, SINGAPORE_URL);
    inputLocationSearch(searchTxt);
  }

  @And("^I select \"([^\"]*)\" day to check in-out$")
  public void i_select_something_day_to_check_inout(Integer day) throws Throwable {
    datePickerAnyDayHotel( day);
  }

  @When("^I click on Singapore link and input property \"([^\"]*)\" to search box$")
  public void i_click_on_singapore_link_and_input_property_something_to_search_box(String propertyTxt) {
    landingPage.clickToCountryPage("4");
    landingPage.switchToOtherWindowbyUrl(driver, SINGAPORE_URL);
    inputPropertySearch( propertyTxt);
  }

  @When("^I click on any top \"([^\"]*)\"$")
  public void i_click_on_any_top_something(String country) throws Throwable {
    landingPage.clickToCountryPage(country);
  }

  @And("^I click on any region of that country$")
  public void i_click_on_any_region_of_that_country() throws Throwable {

  }

}
