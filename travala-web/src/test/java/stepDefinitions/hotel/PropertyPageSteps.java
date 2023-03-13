package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.CheckOutPage;
import pages.hotel.LandingPage;
import pages.hotel.PropertyPage;


import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.PropertyPageUI.*;
import static interfaces.hotel.SearchPageUI.*;

public class PropertyPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private LandingPage landingPage;
  private PropertyPage propertyPage;
  private CheckOutPage checkOutPage;
  String roomTypeAtProperty;
  String refundabilityAtProperty;
  String pricePerNightAtProperty;
  String originalPriceAtProperty;
  String bookingPriceAtProperty;
  String perNightAtProperty;
  String perNightOnTopAtProperty;
  int numbperNightTextAtProperty;
  boolean displayEvent;

//  @Before
  public PropertyPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    propertyPage = new PropertyPage(driver);
    checkOutPage = new CheckOutPage(driver);
  }

//  @After
//  public void teardown() {
//    Set<String> windowHandles = driver.getWindowHandles();
//    String firstTab = (String) windowHandles.iterator().next();
//    String lastTab = null;
//    for (Iterator iter = windowHandles.iterator(); iter.hasNext(); ) {
//      lastTab = (String) iter.next();
//    }
//    if (!firstTab.equals(lastTab)) {
//      driver.close();
//    } else {
//      driver.switchTo().window(firstTab);
//    }
//  }

  @And("^I click on Search button to link Property page$")
  public void i_click_on_search_button_to_link_property_page() throws Throwable {
    wait1sTime();
    clickToElementByJavascript(driver,LANDING_SEARCH_BUTTON);
  }

  @When("^I input destination and choose a property and link to check-out page$")
  public void iInputDestinationAndChooseAPropertyAndLinkToCheckOutPage() {
    inputLocationSearch(randomDestination());
    clickSearchHotelBtn(driver);
    switchToWindowByUrlContainsString(driver, SEARCH_PATH);
    waitFoElementVisible(driver,FIRST_PROPERTY );
    wait1sTime();
    clickToElement(driver, FIRST_PROPERTY);
    switchToWindowByUrlContainsString(driver, PROPERTY_PATH);
    propertyPage.clickBookNowBtn();
  }

  @And("^I add property to wishlist and verify text$")
  public void i_add_property_to_wishlist_and_verify_text() throws Throwable {
//    if (propertyPage.verifyTextAddFavourites()) {
//      System.out.println("Text displayed when add property to wishlist correct");
//    } else {
//      System.out.println("Text displayed when add property to wishlist wrong ");
//    }
  }

  @And("^I verify text on the top page when select a day$")
  public void i_verify_text_on_the_top_page_when_select_a_day() throws Throwable {
    if (propertyPage.verifyInfoHotelTop() && propertyPage.verifyPerNight() && propertyPage.verifyCountReviewTop()) {
      System.out.println("Text at top page is displayed correct");
    } else {
      System.out.println("Text at top page is displayed wrong ");
    }
  }
  @And("^I verify text on the top page when no have package$")
  public void i_verify_text_on_the_top_page_when_no_have_package() throws Throwable {
    if (propertyPage.verifyNoHavePackage()) {
      System.out.println("Text at top page when no have package is displayed correct");
    } else {
      System.out.println("Text at top page when no have package is displayed wrong ");
    }
  }

  @And("^I verify text on the Available Room part$")
  public void i_verify_text_on_the_available_room_part() throws Throwable {
    if (propertyPage.verifyAvailiableRoom()&& propertyPage.verifyUpdateSearch()) {
      System.out.println("Text at Available Room/Filter is displayed correct");
    } else {
      System.out.println("Text at Available Room/Filter is displayed wrong ");
    }

  }

  @And("^I verify tool tip of add wishlist when not login$")
  public void i_verify_tool_tip_of_add_wishlist_when_not_login() throws Throwable {
//    if (propertyPage.verifyAddWishListNotLogin()) {
//      System.out.println("Text at tool tip of add wishlist when not login is displayed correct");
//    } else {
//      System.out.println("Text at tool tip of add wishlist when not login is displayed wrong ");
//    }
  }

  @And("^I verify text at filter part$")
  public void i_verify_text_at_filter_part() throws Throwable {
    if (propertyPage.verifyFilterProperty()) {
      System.out.println("Text at filter is displayed correct");
    } else {
      System.out.println("Text at filter is displayed wrong ");
    }
  }

  @And("^I verify text on the first package part when select a day$")
  public void i_verify_text_on_the_first_package_part_when_select_a_day() throws Throwable {
    if (propertyPage.verifyPackageNotLogin() && propertyPage.verifyPerNight() && propertyPage.verifyRoom()) {
      System.out.println("Text at the first package is displayed correct");
    } else {
      System.out.println("Text at the first package is displayed wrong ");
    }
  }

  @And("^I verify tooltip of payment and fee at package when not login$")
  public void i_verify_tooltip_of_payment_and_fee_at_package_when_not_login() throws Throwable {
    if (propertyPage.verifyTextToolTipPaymentNotLogin() && propertyPage.verifyTextToolTipTaxFee()) {
      System.out.println("Tooltip at payment and fee when not login is displayed correct");
    } else {
      System.out.println("Tooltip at payment and fee when not login is displayed wrong ");
    }
  }
  @And("^I verify tooltip of payment and fee at package when login$")
  public void i_verify_tooltip_of_payment_and_fee_at_package_when_login() throws Throwable {
    if (propertyPage.verifyTextToolTipPaymentLogin() && propertyPage.verifyTextToolTipTaxFee()) {
      System.out.println("Tooltip at payment and fee when login is displayed correct");
    } else {
      System.out.println("Tooltip at payment and fee when login  is displayed wrong ");
    }
  }

  @And("^I verify text on the hotel description part$")
  public void i_verify_text_on_the_hotel_description_part() throws Throwable {
    if (propertyPage.verifyHotelDescription() && propertyPage.verifyReviewBottomLogin()) {
      System.out.println("Text at the hotel_description is displayed correct");
    } else {
      System.out.println("Text at the hotel_description is displayed wrong ");
    }
  }

  @And("^I verify text on the top page when select more than a day$")
  public void i_verify_text_on_the_top_page_when_select_more_than_a_day() throws Throwable {
    if (propertyPage.verifyInfoHotelTop() && propertyPage.verifyPerNights() && propertyPage.verifyCountReviewTop()) {
      System.out.println("Text at Info Hotel when select more than a day is displayed correct");
    } else {
      System.out.println("Text at Info Hotel when select more than a day is displayed wrong ");
    }
  }

  @And("^I verify text on the first package part when select more than a day$")
  public void i_verify_text_on_the_first_package_part_when_select_more_than_a_day() throws Throwable {
    if (propertyPage.verifyPackageNotLogin() && propertyPage.verifyPerNights() && propertyPage.verifyRefundable() && propertyPage.verifyRoom() && propertyPage.verifyRoom()) {
      System.out.println("Text at the first package when select more than a day is displayed correct");
    } else {
      System.out.println("Text at the first package  when select more than a day is displayed wrong ");
    }
  }


  @And("^I click on Book Now button at best price package$")
  public void i_click_on_book_now_button_at_best_price_package() throws Throwable {
    Thread.sleep(2000);

    //Get Info package
//    bookingPriceAtProperty = propertyPage.getBookingPriceText().trim();
//    refundabilityAtProperty = propertyPage.getRefundabilityAtProperty().trim();
//    roomTypeAtProperty = propertyPage.getRoomTypeAtProperty().trim();
//    perNightAtProperty = propertyPage.getPerNightText().trim();
//    perNightOnTopAtProperty = propertyPage.getPerNightTextOnTop().trim();
//    numbperNightTextAtProperty = propertyPage.getNumberNight();
//    originalPriceAtProperty = propertyPage.getOriginalPriceAtProperty().trim();
//    displayEvent = propertyPage.checkDisplayEventSale();
    clickToElement(driver, BEST_PRICE_BOOK_NOW_FIRST);
//    checkOutPage.switchToOtherWindowByContent(driver, CHECKOUT_CONTENT_PAGE);
  }



}



