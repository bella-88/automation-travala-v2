package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.CheckOutPage;
import pages.hotel.PropertyPage;
import pages.hotel.SearchPage;


import static commons.CommonDataHotel.FREE_BREAKFAST_EXPECT_TEXT;
import static commons.CommonHotelURL.HOTEL_PROPERTY;
import static interfaces.hotel.PropertyPageUI.PROPERTY_TITLE;
import static interfaces.hotel.SearchPageUI.*;

public class SearchPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private SearchPage searchPage;
  private PropertyPage propertyPage;
  private CheckOutPage checkOutPage;


  public SearchPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    searchPage= new SearchPage(driver);
    propertyPage = new PropertyPage(driver);
  }

  @Then("^I verify text on search result page$")
  public void i_verify_text_on_search_result_page() {
    if (searchPage.checkDisplayedElementByXpath(driver, OK_RELOAD_BUTTON) && searchPage.verifyNoMesHotel()) {
      System.out.println("Message is displayed correct");
    }
  }

  @And("^I verify display list filter on search result page$")
  public void iVerifyDisplayListFilterOnSearchResultPage() {
    searchPage.verifyTextFilterSearchPage();
    searchPage.verifyListOptionFilter();
  }

  @And("^I verify detail display every filter on search result page$")
  public void iVerifyDetailDisplayEveryFilterOnSearchResultPage() {
    searchPage.verifyDisplayDetailFilter();
  }

  @And("^I verify text on sort part$")
  public void i_verify_text_on_sort_part() throws Throwable {
    searchPage.verifySortText();
  }

  @And("^I verify text at property on search result page when not login$")
  public void iVerifyTextAtPropertyOnSearchResultPageWhenNotLogin() {
    searchPage.verifyTextAmenitiesProperty();
    searchPage.verifyTextReviewProperty();
    searchPage.verifyTextGuestReviewProperty();
    searchPage.verifyTextAtProperty();
    searchPage.verifyToolTipPackageNotLogin();
    searchPage.verifyListPromotionsNotLogin();
  }


  @And("^I click on Search button and verify search result page$")
  public void iClickOnSearchButtonAndVerifySearchResultPage() {
    clickSearchHotelBtn(driver);
    waitFoElementVisible(driver, COUNT_RESULTS_HOTEL);
    searchPage.verifyDisplayResultSearchPage(400);
  }

  @And("^I click to first property at search result$")
  public void iClickToFirstPropertyAtSearchResult() {
    clickToElementByJavascript(driver, FIRST_PROPERTY);
    String nameExpect = searchPage.getTextElement(driver, FIRST_PROPERTY);
    switchToWindowByUrlContainsString(driver, HOTEL_PROPERTY);
    waitFoElementVisible(driver, PROPERTY_TITLE);
    if (StringUtils.contains(nameExpect, propertyPage.getTextElement(driver, PROPERTY_TITLE))) {
      System.out.println("Navigate to property page correct");
    } else {
      System.out.println("Navigate to property page wrong");
    }
    clickBackToTravala(driver);
  }
  //===============POPULAR FILTER=====================

  @And("^I back to travala site$")
  public void iBackToTravalaSite() {
    clickBackToTravala(driver);
  }

  //===================VERIFY SORT AT SEARCH RESULT=========================
  @And("^I verify display property list when sort by property rank$")
  public void iVerifyDisplayPropertyListWhenSortByPropertyRank() {
    searchPage.verifySortByPropertyRank();
  }

  @And("^I verify display property list when sort by price$")
  public void iVerifyDisplayPropertyListWhenSortByPrice() {
    searchPage.verifySortByPrice();
  }

  @And("^I verify display property list when sort by rating$")
  public void iVerifyDisplayPropertyListWhenSortByRating() {
    searchPage.verifySortByRating();
  }

  @And("^I verify display property list when sort by distance$")
  public void iVerifyDisplayPropertyListWhenSortByDistance() {
    searchPage.verifySortByDistance();
  }

  //===================VERIFY FILTER SEARCH RESULT=========================

  @And("^I click on free breakfast filters and verify display property with free breakfast option$")
  public void iClickOnFreeBreakfastFiltersAndVerifyDisplayPropertyWithFreeBreakfastOption() {
    searchPage.verifyFilterFreeBreakfast();
  }

  @And("^I click on refundable filters and verify display property with refundable option$")
  public void iClickOnRefundableFiltersAndVerifyDisplayPropertyWithRefundableOption() {
    clickToElementByAction(driver, REFUNDABLE_FILTER_CHECKBOX);
    propertyPage.waitLoadingPackages();
    if (searchPage.checkDisplayFilterCondition(FREE_BREAKFAST_CONDITION, FREE_BREAKFAST_EXPECT_TEXT)) {
      System.out.println("Display properties when filter according to  has refundable correct!");
    } else {
      System.out.println("Display properties has refundable incorrect!");
    }
  }

  @And("^I click on excellent filters and verify display property with excellent option$")
  public void iClickOnExcellentFiltersAndVerifyDisplayPropertyWithExcellentOption() {
    searchPage.verifyFilterExcellentRating();
  }


  @And("^I click on amenities filters and verify display property with amenities option$")
  public void iClickOnAmenitiesFiltersAndVerifyDisplayPropertyWithAmenitiesOption() {
    searchPage.verifyAmenitiesFilter();
  }

  @And("^I click on star rating filters and verify display property with \"([^\"]*)\" star rating option$")
  public void iClickOnStarRatingFiltersAndVerifyDisplayPropertyWithStarRatingOption(String starRating) {
    searchPage.verifyStarRatingFilter(starRating);
  }

  @And("^I input \"([^\"]*)\" to search hotel textbox in the search result$")
  public void iInputToSearchHotelTextboxInTheSearchResult(String hotelName) throws Throwable {
    searchPage.inputHotelName();
    searchPage.waitFoElementInvisible(driver, LOADING_SEARCH_RESULT_ICON);
  }

  @And("^I verify display filter list at search result page$")
  public void iVerifyDisplayFilterListAtSearchResultPage() {
    searchPage. verifyListOptionFilter();;
    wait1sTime();
  }

  @And("^I verify display when click on See map view$")
  public void iVerifyDisplayWhenClickOnSeeMapView() {
    searchPage. verifyClickOnSeeMap();
  }


}
