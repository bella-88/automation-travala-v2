package stepsDefinitions.hotel;

import com.mashape.unirest.http.exceptions.UnirestException;

import commons.CommonTravalaPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import cucumberOptions.HooksApi;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.hotel.*;
import pages.search.SearchingAPI;
import pages.search.SuggestionAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmokeApiTestSteps extends CommonTravalaPages {
  static WebDriver driver;
  static String email;
  private SmokePage smokePage;
  private HomePage homePage;
  private LandingPage landingPage;
  private SearchPage searchPage;
  private SuggestionAPI suggestionAPI;
  private SearchingAPI searchingAPI;
  private RegisterPage registerPage;
  private List<String> dataExpect;
  private String locationIdFirstInListLocation;

  public SmokeApiTestSteps() {
    driver = HooksApi.openBrowserTravala();
    super.setDriver(driver);
    smokePage = new SmokePage(driver);
    landingPage = new LandingPage(driver);
    searchPage= new SearchPage(driver);

    suggestionAPI = new SuggestionAPI();
    searchingAPI = new SearchingAPI();
  }

  @When("^I create email by yopmail$")
  public void iCreateEmailByYopmail() {
    smokePage.createYopMail();
//   email= smokePage.getYopEmail();
  }



  @And("^At home page, i search hotel with \"([^\"]*)\" and verify list hotel in search result page$")
  public void search_hotel_with_destination_and_verify_list_hotel_in_search_result_page(String destinationName) {
//    registerPage.closeSignUpJourneyPopUp();
    openNewTab(driver, getEvn());
    searchPage.searchByDestination(destinationName);
    List<String> listHotelActual = searchPage.getListHotelInSearchResult();
    Assert.assertEquals(dataExpect, listHotelActual);
  }

  @And("^I use api to get list hotel expect with \"([^\"]*)\"$")
  public void i_use_api_to_get_list_hotel_expect_with_destionation(String textSearch) throws UnirestException {
    HashMap<String, Map<String, String>> listLocation =  suggestionAPI.getListLocationByText(textSearch);
    locationIdFirstInListLocation = listLocation.get("listLocationId").get("location-id1");
    dataExpect = searchingAPI.getListHotelNameByLocation(locationIdFirstInListLocation);
  }

  @And("^I use api to get list property expect with \"([^\"]*)\"$")
  public void i_use_api_to_get_list_property(String text) throws UnirestException {
    ArrayList<Map<String, Object>> data = suggestionAPI.getListPropertyByText(text);
    List<String> dataExpectOfPropertySuggestion = new ArrayList<>();
    for (int i=0; i<data.size(); i++) {
      String propertyInfo = data.get(i).get("name")  + (String) data.get(i).get("city_name") + ", " + data.get(i).get("country_name");
      dataExpectOfPropertySuggestion.add(propertyInfo);
    }

    dataExpect = dataExpectOfPropertySuggestion;
  }

  @And("^At home page, i search hotel with \"([^\"]*)\" and verify list property suggestion$")
  public void verify_list_property_suggestion_in_search_box(String text) {
    registerPage.closeSignUpJourneyPopUp();
    List<String> listPropertyActual = homePage.getListPropertySuggestionInSearchBox(text);
    Assert.assertEquals(dataExpect, listPropertyActual, "List property the same expect.\nActual: " + listPropertyActual + "\nExpect: " + dataExpect);
  }

  @And("^Check display when sort by property \"([^\"]*)\"$")
  public void verify_list_search_result_when_sort_by_property(String propertySort) throws UnirestException {
    List<String> expectListHotelAfterSort = searchingAPI.getListHotelNameAfterSortByProperty(propertySort, locationIdFirstInListLocation);
    searchPage.verifyListHotelAfterSortByProperty(expectListHotelAfterSort, propertySort);
  }
}