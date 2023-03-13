package pages.hotel;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import commons.hotel.CommonHotelPages;
import java.util.ArrayList;
import java.util.List;

import static commons.CommonDataHotel.*;
import static commons.CommonsTravalaXpath.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.SearchPageUI.*;

public class SearchPage extends CommonHotelPages {
  WebDriver driver;
  static boolean check = true;
  static boolean status = true;

  public SearchPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void inputHotelSearch(String element) {
    WebElement searchHotelTextBox = driver.findElement(By.xpath(SEARCH_HOTELS_NAME_TXT));
    searchHotelTextBox.click();
    searchHotelTextBox.clear();
    searchHotelTextBox.sendKeys(element);
    wait300Time();
  }

  public void inputHotelName() {
    List<String> hotelName = new ArrayList<>();
    hotelName.add("Amsterdam Noord Apartments");
    hotelName.add("Amsterdam South Hostel");
    hotelName.add("Amsterdam West Hotel");
    hotelName.add("Amsterdam East Hotel");
    for (String element : hotelName
    ) {
      int i = 0;
      while (i < hotelName.size()) {
        inputHotelSearch(element);
        if (checkShowElement(driver, "//div[contains(@class,'ItemContent_content')]") == 0) {
          System.out.println(element + " is not belong location above!");
          inputHotelSearch(element);
        } else {
          clickToElementByJavascript(driver, "//div[contains(@class,'ItemContent_content')]");
        }
        i++;
      }
    }
  }

  public void verifyCountHotel(Integer expectCountHotel, Integer countHotelActual) {
    String[] location = getAttribute(driver, SEARCH_TXT_TITLE, "value").split(",");
    if ((countHotelActual > expectCountHotel) || (countHotelActual == expectCountHotel)) {
      System.out.println("The number hotel at" + location[1] + " is displayed correct: " + countHotelActual);
    } else {
      System.out.println("The number hotel " + location[1] + " is displayed wrong: " + countHotelActual);
    }
  }

  public void verifyDisplayResultSearchPage(Integer expectCountHotel) {
    String[] location = getAttribute(driver, SEARCH_TXT_TITLE, "value").split(",");
    Integer countHotelActual = Integer.parseInt(getTextElement(driver, COUNT_RESULTS_HOTEL).trim());
    if (countHotelActual == 0) {
      if (checkShowElement(driver, RESULTS_SEARCH_FAILED_TXT) != 0) {
        System.out.println("THERE ARE NO RESULTS FOR " + location[1]);
        inputLocationSearch("Lon Don");
        clickSearchHotelBtn(driver);
        verifyCountHotel(expectCountHotel, countHotelActual);
      }
    } else {
      verifyCountHotel(expectCountHotel, countHotelActual);
    }

  }

  public boolean verifyHotelName(String hotelName) {
    List<WebElement> listHotel = driver.findElements(By.xpath(HOTELS_NAME_LINK_PROPERTY));
    int i = 0;
    while (i < listHotel.size()) {
      if (StringUtils.contains(listHotel.get(i).getText(), hotelName)) {
        status = true;
      } else {
        status = false;
        break;
      }
      i++;
    }
    return status;
  }

  public PropertyPage clickAnyPropertyDisplayed(String locator) {
    List<WebElement> listProperty = driver.findElements(By.xpath(LIST_PROPERTY));
    if (listProperty.size() > 0) {
      List<WebElement> listHotel = driver.findElements(By.xpath(locator));
      listHotel.get(0).click();
    } else {
      System.out.println("Don't have property");
    }
    return new PropertyPage(driver);
  }

  public PropertyPage clickChooseRoomBtn() {
    WebElement elm = driver.findElement(By.xpath(CHOOSE_ROOM_BTN));
    elm.click();
    return new PropertyPage(driver);
  }

  //=================================VERIFY VIEW SEARCH RESULT================================================

  //=================================VERIFY SORT================================================
  public boolean verifySortText() {
    String[] content = {"SORT_PRICE", "SORT_PRICE_RATING", "SORT_PRICE_DISTANCE", "SORT_PRICE_PROPERTY", "SORT_PRICE_TOP_RATE", "SORT_PRICE_DISTANCE1"};
    if (!verifyListItemByListExpect(content, SORT_LIST, SORT_LIST_DYNAMIC)) {
      System.out.println("Sort items at search result is wrong ");
    }
    return check;
  }

  public boolean sortLowToHighByPrice() {
    List<WebElement> elm = driver.findElements(By.xpath(SEARCH_PRICE_PROPERTY));
    int j = 0;
    boolean sort = true;
//    System.out.println("===============sortLowToHighByPrice=========");
    while (j < elm.size() - 1) {
      if (Double.parseDouble(elm.get(j).getText().replaceAll(",", "")) <= Double.parseDouble(elm.get(j + 1).getText().replaceAll(",", ""))) {
        sort = true;
      } else {
        System.out.println(Double.parseDouble(elm.get(j).getText().replaceAll(",", "")));
        System.out.println(Double.parseDouble(elm.get(j + 1).getText().replaceAll(",", "")));
        sort = false;
      }
      j++;
    }
    wait100Time();
    return sort;
  }

  public boolean sortHighToLowByPrice() {
    boolean sort = true;
    List<WebElement> elm = driver.findElements(By.xpath(SEARCH_PRICE_PROPERTY));
    int j = 0;
//    System.out.println("===============sortHighToLowByPrice=========");
    while (j < elm.size() - 1) {
      if (Double.parseDouble(elm.get(j).getText().replaceAll(",", "")) >= Double.parseDouble(elm.get(j + 1).getText().replaceAll(",", ""))) {
        sort = true;
      } else {
        System.out.println(Double.parseDouble(elm.get(j).getText().replaceAll(",", "")));
        System.out.println(Double.parseDouble(elm.get(j + 1).getText().replaceAll(",", "")));
        sort = false;
      }
      j++;
    }
    wait100Time();
    return sort;
  }

  public void verifySortByPrice() {
    clickToElementByJavascript(driver, SORT_BY_PRICE);
    wait100Time();
    if (sortHighToLowByPrice()) {
      System.out.println("Display price High to Low correct");
    } else {
      System.out.println("Display price High to Low wrong");
    }
    clickToElementByJavascript(driver, SORTED_BY_PRICE);
    wait100Time();
    if (sortLowToHighByPrice()) {
      System.out.println("Display price Low to High correct");
    } else {
      System.out.println("Display price Low to High wrong");
    }
//    waitFoElementVisible(driver, BOOKING_PRICE_PROPERTY_FIRST);
//    Double priceMinFilter = Double.parseDouble(getAttributeByName(driver, PRICE_MIN_TEXTBOX, "value").replace(",", "").trim());
//    Double priceMaxFilter = Double.parseDouble(getAttributeByName(driver, PRICE_MAX_TEXTBOX, "value").replace(",", "").trim());
//    double priceProperty = Double.parseDouble(getTextElement(driver, BOOKING_PRICE_PROPERTY_FIRST).replace(",", "").trim());
//    if ((priceMinFilter <= priceProperty) || (priceMaxFilter >= priceProperty)) {
////      clickToElement(driver, SORTED_BY_PRICE);
//      wait5sTime();
//      waitFoElementVisible(driver, BOOKING_PRICE_PROPERTY_FIRST);
//      clickToElement(driver, SORTED_BY_PRICE);
//    } else {
//      System.out.println("Price min/max display at filter wrong");
//    }
//    if (priceProperty == priceMaxFilter) {
//      if (sortDesByPriceProperty()) {
//        System.out.println("Sort price by des correct");
//      } else {
//        System.out.println("Sort price by des wrong");
//      }
//    }
//    clickToElement(driver, SORTED_BY_PRICE);
//    if ((priceProperty > priceMinFilter) || (priceProperty == priceMinFilter)) {
//
//    }
  }

  public void verifySortByDistance() {
    clickToElement(driver, SORT_BY_DISTANCE);
    waitFoElementVisible(driver, SEARCH_DISTANCE_PROPERTY);
    List<WebElement> elm = driver.findElements(By.xpath(SEARCH_DISTANCE_PROPERTY));
    for (int j = 0; j < elm.size() - 1; j++) {
      boolean b = Double.parseDouble(getTextBySplit(elm.get(j).getText(), "km", 0)) < Double.parseDouble(getTextBySplit(elm.get(j + 1).getText(), "km", 0));
      boolean b1 = Double.parseDouble(getTextBySplit(elm.get(j).getText(), "km", 0)) == Double.parseDouble(getTextBySplit(elm.get(j + 1).getText(), "km", 0));
      if (b || b1) {
        status = true;
      } else {
        System.out.println("Distance of property " + j + " is: " + Double.parseDouble(getTextBySplit(elm.get(j).getText(), "km", 0)));
        System.out.println("Distance of property " + j + 1 + " is: " + Double.parseDouble(getTextBySplit(elm.get(j + 1).getText(), "km", 0)));
        status = false;
      }
    }
    if (status) {
      System.out.println("Sort by distance correct");
    } else {
      System.out.println("Sort by distance wrong");
    }
  }

  public void verifySortByPropertyRank() {
    clickToElement(driver, SORT_BY_RANK);
    waitFoElementVisible(driver, FIRST_PROPERTY);
  }

  public void verifySortByRating() {
    clickToElement(driver, SORT_BY_RATING);
    waitFoElementVisible(driver, FIRST_PROPERTY);

  }

  //=================================VERIFY TEXT FILTER================================================
  public boolean verifyTextFilterSearchPage() {
    String[] content = {"MATCH_YOUR_SEARCH_RESULT", "MENU_BestPrice", "RESET_FILTER",
      "Filter_MIN", "Filter_MAX", "Filter_BestPrice_Content"};
    String[] xpath = {MATCH_YOUR_SEARCH_RESULT, BEST_PRICE_LINK, SEARCH_RESULT_RESET_FILTER_BTN,
      SEARCH_RESULT_SIDE_PRICE_MIN, SEARCH_RESULT_SIDE_PRICE_MAX, FILTER_BEST_PRICE};
    return verifyTwoListByKey(content, xpath) && verifyTextByKey("SEARCH_HOTEL_TEXT", SEARCH_RESULT_HEADER_MENU);
  }

  public void verifyListOptionFilter() {
    String[] listOptionExpect = {"Filter_PricePerNight", "Filter_Popular", "FILTER_PROPERTY_FILTER_LABEL", "Filter_StarRating", "FILTER_GUESS_REVIEW",
      "Filter_Amenities", "Filter_HotelChain", "PROPERTY_ROOM_BOARDS", "Filter_Room_Type", "PROPERTY_ROOM_CLASSES", "Filter_Payment_Type", "OYO_UK_FILTER_TXT",
      "HOTEL_CHAIN1", "HOTEL_CHAIN2", "HOTEL_CHAIN3"};
    boolean check = compareTwoListByKey(listOptionExpect, FILTER_OPTION_LIST);
    if (!check) {
      System.out.println("Display list filter at search result wrong");
    } else {
      System.out.println("Display list filter at search result correct");
    }
  }

  public void verifyDisplayDetailFilter() {
    verifyDisplayPopularFilter();
    verifyTextPropertyFilter();
    verifyTextAmenitiesFilter();
    verifyTextGuestReViewFilter();
    verifyTextPaymentTypeFilter();
    clickToElementByJavascript(driver, "//h3[text()='Room Boards']");
    clickToElementByJavascript(driver, "//h3[text()='Room Types']");
    clickToElementByJavascript(driver, "//h3[text()='Room Classes']");
    clickToElementByJavascript(driver, "//h3[text()='Hotel Chain']");
    verifyRoomBoardFilter();
    verifyRoomTypeFilter();
    verifyRoomClassFilter();
    verifyTextHotelChainFilter();
  }

  public void verifyDisplayPopularFilter() {
    String[] listPopularExpect = {"FREE_BREAKFAST_FILTER_TXT", "REFUNDABLE_FILTER_TXT", "EXCELLENT_RATING_TEXT", "RATING_FIVE_START_RATING_FILTER_TXT", "POPULAR_FILTER1",
      "VACATION_RENTAL_FILTER_TXT", "ESSENTIAL_WORK_FILTER_TXT", "PAY_AT_PROPERTY_FILTER_TEXT", "FREE_BREAKFAST_FILTER", "MEMBER_PRICE_FILTER", "POPULAR_FILTER", "PROPERTY_ROOM_INCLUDE"};
    if (!compareTwoListByKey(listPopularExpect, FILTER_POPULAR_LIST)) {
      System.out.println("Popular filter is display wrong!");
    }
  }

  public void verifyTextPropertyFilter() {
    String[] listPropertyExpect = {"PROPERTY_HOSTEL_FILTER_TXT", "PROPERTY_APARTHOTEL_FILTER_TXT", "PROPERTY_CONDO_FILTER_TXT", "PROPERTY_VILLA_FILTER_TXT", "PROPERTY_FILTER_TXT",
      "PROPERTY_APARTMENT_FILTER_TXT", "PROPERTY_HOTEL_FILTER_TXT", "PROPERTY_LODGE_FILTER_TXT", "PROPERTY_CAMPSITE_FILTER_TXT", "PROPERTY_RESORT_FILTER_TXT",
      "PROPERTY_BED_BREAKFAST_FILTER_TXT", "PROPERTY_GUEST_HOUSE_FILTER_TXT", "PROPERTY_CRUISE_FILTER_TXT", "PROPERTY_PRIVATE_FILTER_TXT", "PROPERTY_INN_FILTER_TXT",
      "PROPERTY_CHALET_FILTER_TXT", "PROPERTY_COUNTRY_HOUSE_FILTER_TXT", "PROPERTY_FILTER_TXT1", "PROPERTY_FILTER_TXT2", "PROPERTY_FILTER_TXT3", "PROPERTY_FILTER_TXT4"};
    if (!compareTwoListByKey(listPropertyExpect, FILTER_PROPERTY_LIST)) {
      System.out.println("Property type filter is wrong ");
    }
  }

  public void verifyTextAmenitiesFilter() {
    if (checkShowElement(driver, SHOW_MORE_AMENITIES) != 0) {
      clickToElementByJavascript(driver, SHOW_MORE_AMENITIES);
    }
    String[] listAmenitiesExpect = {"PET_SITING_FILTER_TXT", "BAR_FILTER_TXT", "DRY_CLEAN_FILTER_TXT", "FACILITIES_FILTER_TXT", "LUGGAGE_FILTER_TXT",
      "SPA_SURCHARGE_FILTER_TXT", "PET_GROOMING_FILTER_TXT", "SWIMMING_FILTER_TXT", "TOUR_FILTER_TXT", "SMOKE_FILTER_TXT", "SPA_FILTER_TXT", "FREE_FILTER_TXT"
      , "AMENITIES1", "AMENITIES2", "AMENITIES3", "AMENITIES4", "AMENITIES5", "AMENITIES6", "AMENITIES7", "AMENITIES8", "AMENITIES9", "AMENITIES10", "AMENITIES11",
      "AMENITIES12", "AMENITIES13", "AMENITIES14", "AMENITIES15", "AMENITIES16", "AMENITIES17", "AMENITIES18", "AMENITIES19"};
    if (!compareTwoListByKey(listAmenitiesExpect, FILTER_AMENITIES_LIST)) {
      System.out.println("Amenities filter is wrong ");
    }
  }

  public void verifyTextGuestReViewFilter() {
    String[] listGuestReviewExpect = {"NO_RATING_FILTER_TXT", "REVIEW_FAIR", "GOOD_FILTER_TXT", "REVIEW_VERY_GOOD", "REVIEW_EXCELLENT"};
    if (!compareTwoListByKey(listGuestReviewExpect, FILTER_GUEST_REVIEW_LIST)) {
      System.out.println("Guest ReView filter is wrong ");
    }
  }

  public void verifyTextPaymentTypeFilter() {
    String[] listGuestReviewExpect = {"REFUNDABLE_FILTER_TXT", "POPULAR_FILTER"};
    if (!compareTwoListByKey(listGuestReviewExpect, FILTER_PAYMENT_TYPE_LIST)) {
      System.out.println("Payment Type filter is wrong ");
    }
  }

  public boolean verifyTextStartRatingFilter() {
    String[] listGuestReviewExpect = {"NO_RATING_FILTER_TXT", "REVIEW_FAIR", "GOOD_FILTER_TXT", "REVIEW_VERY_GOOD", "REVIEW_EXCELLENT"};
    boolean check = compareTwoListByKey(listGuestReviewExpect, FILTER_GUEST_REVIEW_LIST);
    if (!check) {
      System.out.println("Guest ReView filter is wrong ");
    }
    return check;
  }

  public void verifyRoomBoardFilter() {
    String[] listBoardExpect = {"FILTER_ROOM_BOARD_FREE", "PROPERTY_ROOM_ONLY", "FILTER_ROOM_BOARD_HALF", "FILTER_ROOM_BOARD_FULL", "FILTER_ROOM_BOARD_ALL", "PROPERTY_ROOM_INCLUDE"};
    if (!compareTwoListByKey(listBoardExpect, FILTER_ROOM_BOARDS_LIST)) {
      System.out.println("Room Board filter is wrong ");
    }
  }

  public void verifyRoomTypeFilter() {
    String[] listTypeExpect = {"FILTER_ROOM_TYPE_HONEY", "FILTER_ROOM_TYPE_DOUBLE", "FILTER_ROOM_TYPE_TRIPLE", "FILTER_ROOM_TYPE_TWIN", "FILTER_ROOM_TYPE_FAMILY",
      "FILTER_ROOM_TYPE_DORM", "FILTER_ROOM_TYPE_SUITE", "FILTER_ROOM_TYPE_MOBILITY"};
    if (!compareTwoListByKey(listTypeExpect, FILTER_ROOM_TYPE_LIST)) {
      System.out.println("Room Type filter is wrong ");
    }
  }

  public void verifyRoomClassFilter() {
    String[] listClassExpect = {"FILTER_ROOM_CLASS_CLUB", "FILTER_ROOM_CLASS_DELUXE", "FILTER_ROOM_CLASS_BUSINESS",
      "FILTER_ROOM_CLASS_LUXURY", "FILTER_ROOM_CLASS_CORNER", "FILTER_ROOM_CLASS_EXECUTIVE", "FILTER_ROOM_CLASS_SUPERIOR", "FILTER_ROOM_CLASS_PREMIER"};
    if (!compareTwoListByKey(listClassExpect, FILTER_ROOM_CLASS_LIST)) {
      System.out.println("Room Class filter is wrong ");
    }
  }

  public void verifyTextHotelChainFilter() {
    String[] listHotelChainExpect = {"ROSE_WOOD_FILTER_TXT", "INDEPENDENT_FILTER_TXT", "HOTEL_RESORT_FILTER_TXT", "RED_DOOR_CLEAN_FILTER_TXT", "HOTEL_PARTNER_FILTER_TXT",
      "ACCOR_FILTER_TXT", "TREEBO_FILTER_TXT", "SAND_FILTER_TXT", "ROYAL_FILTER_TXT", "LEMON_TREE_FILTER_TXT", "FILTER_CHAIN5", "FILTER_CHAIN6", "HOTEL_CHAIN_FILTER6",
      "SAROVAR_FILTER_TXT", "GINGER_FILTER_TXT", "PARK_FILTER_TXT", "LEELA_FILTER_TXT", "HYATT_HOTEL_FILTER_TXT", "FILTER_CHAIN3", "FILTER_CHAIN4", "FILTER_CHAIN7", "FILTER_CHAIN8",
      "IHG_FILTER_TXT", "MARRIOTT_FILTER_TXT", "NIKKO_HOTEL_FILTER_TXT", "ASCOTT_FILTER_TXT", "ZUZU_FILTER_TXT", "FILTER_CHAIN1", "FILTER_CHAIN2", "HOTEL_CHAIN_FILTER7",
      "FRASE_FILTER_TXT", "TRAVEL_FILTER_TXT", "OYO_FILTER_TXT", "MELIA_FILTER_TXT", "HILTON_FILTER_TXT", "WYNDHAM_FILTER_TXT", "HOTEL_CHAIN_FILTER1", "HOTEL_CHAIN_FILTER2",
      "HOTEL_CHAIN_FILTER3", "HOTEL_CHAIN_FILTER4", "HOTEL_CHAIN_FILTER5", "HOTEL_CHAIN_FILTER6", "HOTEL_CHAIN2", "OYO_UK_FILTER_TXT", "HOTEL_CHAIN1", "HOTEL_CHAIN3"};
    if (!compareTwoListByKey(listHotelChainExpect, FILTER_HOTEL_CHAIN_LIST)) {
      System.out.println("Hotel Chain filter is wrong ");
    }
  }

  public void verifyOptionFilter() {
    List<WebElement> element = driver.findElements(By.xpath(FILTER_EXPAND_OPTION));
    for (int i = 0; i < element.size(); i++) {
      element.get(i).click();
    }
    verifyRoomBoardFilter();
    verifyRoomTypeFilter();
    verifyRoomClassFilter();
    verifyTextHotelChainFilter();
  }

  //========================CHECK CONDITION FILTER=========================================
  public void inputPriceToFilter() {
    driver.findElement(By.xpath(PRICE_MIN_TEXTBOX)).clear();
    clickToElement(driver, PRICE_MIN_TEXTBOX);
    sendkeysToElement(driver, PRICE_MIN_TEXTBOX, getAttribute(driver, PRICE_MAX_TEXTBOX, "value"));
  }

  public boolean checkDisplayFilterCondition(String locator, String expectText) {
    List<WebElement> listProperty = driver.findElements(By.xpath(LIST_PROPERTY));
    boolean checkFilterCondition = true;
    if (listProperty.size() > 0) {
      for (WebElement property : listProperty) {
        String getActualText = driver.findElement(By.xpath(locator)).getText();
        if (!StringUtils.equals(getActualText, expectText)) {
          System.out.println("Actual condition: " + getActualText);
          System.out.println("Expect condition: " + expectText);
          checkFilterCondition = false;
          break;
        } else {
          checkFilterCondition = true;
        }
      }
    }
    return checkFilterCondition;
  }

  public void verifyFilterFreeBreakfast() {
    wait100Time();
    clickToElementByJavascript(driver, FREE_BREAKFAST_CHECKBOX);
    if (checkDisplayFilterCondition(FREE_BREAKFAST_CONDITION, FREE_BREAKFAST_EXPECT_TEXT)) {
      System.out.println("Display properties when filter according to free breakfast correct!");
    } else {
      System.out.println("Display properties when filter according to free breakfast incorrect!");
    }
    clickToElementByAction(driver, RESET_FILTER_BTN);
  }

  public void verifyFilterExcellentRating() {
    clickToElementByAction(driver, EXCELLENT_RATING_FILTER_CHECKBOX);
    if (checkDisplayFilterCondition(EXCELLENT_RATING_CONDITION, EXCELLENT_EXPECT_TEXT)) {
      System.out.println("Display properties when filter according to Excellent Rating correct!");
    } else {
      System.out.println("Display properties when filter according to Excellent Rating incorrect!");
    }
    clickToElementByAction(driver, RESET_FILTER_BTN);
  }

  public int getStarNumber(String locator, String attribute, String value) {
    List<WebElement> starExp = driver.findElements(By.xpath(locator));
    int i = 1;
    int star = 0;
    while (i < starExp.size() + 1) {
      String act = getAttribute(driver, locator, attribute);
      if (StringUtils.contains(act, value)) {
        star = star + 1;
      }
      i++;
    }
    return star;
  }

  public void verifyStarRatingFilter(String starRating) {
    wait300Time();
    clickToElementByJavascript(driver, String.format(STAR_RATING_CHECKBOX, Integer.parseInt(starRating)));
    List<WebElement> elements = driver.findElements(By.xpath(STAR_RATING_GROUP));
    int i = 1;
    int starAct = 0;
    boolean b = true;
    while (i < elements.size() + 1) {
      starAct = getStarNumber(String.format(STAR_RATING_DYNAMIC, i), "style", "color: rgb(255, 168, 0); font-size: 12px;");
      if (starAct != Integer.parseInt(starRating)) {
        b = false;
      }
      i++;
    }
    if (b) {
      System.out.println("Display properties when filter according to " + starRating + " Star Rating is correct!");
    } else {
      System.out.println("Star rating of property at position is: " + starAct);
      System.out.println("Display properties when filter according to " + starRating + " Star Rating is incorrect!");
    }
    clickToElementByAction(driver, RESET_FILTER_BTN);
  }

  public void verifyAmenitiesFilter() {
    clickToElementByJavascript(driver, AMENITIES_FILTER_CHECKBOX);
    wait300Time();
    List<WebElement> elements = driver.findElements(By.xpath(AMENITIES_FILTER_LIST));
    boolean b = true;
    String amenities = getTextElement(driver, AMENITIES_FILTER_EXPECT);
    int i = 1;
    while (i < elements.size() + 1) {
      if (!StringUtils.contains(getAttribute(driver, String.format(AMENITIES_FILTER_DYNAMIC, i), "title"), amenities)) {
        System.out.println("Amenities is shown at property: " + getAttribute(driver, String.format(AMENITIES_FILTER_DYNAMIC, i), "title"));
        System.out.println("Amenities Exp: " + amenities);
        b = false;
      }
      i = i + 3;
    }
    if (b) {
      System.out.println("Display properties has Amenities is " + amenities + " correct!");
    } else {
      System.out.println("Display properties has Amenities is " + amenities + " incorrect!");
    }
    clickToElementByAction(driver, RESET_FILTER_BTN);
  }

  //=================================VERIFY TEXT AT PROPERTY================================================
  public void verifyTextReviewProperty() {
    String[] content = {"REVIEW_VERY_GOOD", "REVIEW_EXCELLENT", "REVIEW_FAIR", "REVIEW_GOOD"};
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      expect.add(getTextFromReadFile(content[i]));
    }
    List<WebElement> listOptionActual = driver.findElements(By.xpath(SEARCH_RESULT_REVIEW));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String actual = getTextElement(driver, SEARCH_RESULT_REVIEW);
      listActual.add(actual);
    }
    boolean check = true;
    for (String actual : listActual
    ) {
      if (!expect.contains(actual)) {
        System.out.println(" Review at property failed: " + actual);
        check = false;
      }
    }
    if (check) {
      System.out.println("Review title at list property of search result correct");
    } else {
      System.out.println("Review title at property list property of search result wrong");
    }
  }

  public void verifyTextGuestReviewProperty() {
    List<String> expect = new ArrayList<>();
    expect.add(getTextFromReadFile("REVIEW_SUB_REVIEW"));
    List<WebElement> listOptionActual = driver.findElements(By.xpath(SEARCH_RESULT_GUEST_REVIEW));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String actual = getTextBySplitLimitSegment(getTextElement(driver, SEARCH_RESULT_GUEST_REVIEW), " ", 1);
      listActual.add(actual);
    }
    for (String actual : listActual
    ) {
      if (!expect.contains(actual)) {
        System.out.println(" Guest Review ACTUAL: " + actual);
        check = false;
      }
    }
    if (check) {
      System.out.println("Guest review at list property of search result correct");
    } else {
      System.out.println("Guest review at list property of search result wrong");
    }
  }

  public void verifyTextAmenitiesProperty() {
    String[] listAmenitiesPropertyExpect = {"SEARCH_RESULT_AMENITIES1", "SEARCH_RESULT_AMENITIES2", "SEARCH_RESULT_AMENITIES3", "SEARCH_RESULT_AMENITIES4", "SEARCH_RESULT_AMENITIES5",
      "SEARCH_RESULT_AMENITIES6", "SEARCH_RESULT_AMENITIES7", "SEARCH_RESULT_AMENITIES8", "SEARCH_RESULT_AMENITIES9", "AMENITIES1", "AMENITIES2", "AMENITIES3", "AMENITIES4", "AMENITIES5", "AMENITIES6", "AMENITIES7", "AMENITIES8", "AMENITIES9", "AMENITIES10", "AMENITIES11",
      "AMENITIES12", "AMENITIES13", "AMENITIES14", "AMENITIES15", "AMENITIES16", "AMENITIES17", "AMENITIES18", "AMENITIES19"};
    List<WebElement> listOptionActual = driver.findElements(By.xpath(SEARCH_RESULT_LIST_AMENITIES));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String xpathActual = String.format(SEARCH_RESULT_LIST_AMENITIES_DYNAMIC, i);
      String actual = getAttribute(driver, xpathActual, "alt");
      listActual.add(actual);
    }
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < listAmenitiesPropertyExpect.length; i++) {
      expect.add(getTextFromReadFile(listAmenitiesPropertyExpect[i]));
    }
    for (String element : listActual
    ) {
      if (!expect.contains(element)) {
        System.out.println(" Amenities ACTUAL: " + element);
        check = false;
      }
    }
    if (!check) {
      System.out.println("Amenities at property of search result is wrong ");
    } else {
      System.out.println("Amenities at property of search result is correct ");
    }
  }

  public void verifyTextFirstProperty() {
    String[] listRefundExpect = {"REFUNDABLE_FILTER_TXT", "PROPERTY_BREAKFAST"};
    boolean refund = verifyListItemByListExpect(listRefundExpect, SEARCH_RESULT_REFUND_LIST, SEARCH_RESULT_REFUND_DYNAMIC);
    String[] listGiveBack = {"PROPERTY_GIVE_BACK_STANDAR", "PROPERTY_GIVE_BACK_SMART"};
    boolean giveback = verifyListItemByListExpect(listGiveBack, SEARCH_RESULT_GIVEBACK_LIST, SEARCH_RESULT_GIVEBACK_DYNAMIC);
    boolean a = StringUtils.contains(getTextElement(driver, SEARCH_RESULT_SEE_MAP_FIRST), getTextFromReadFile("SEE_MAP_TEXT"));
    boolean a1 = StringUtils.contains(getTextElement(driver, BOOK_NOW_BUTTON_FIRST), getTextFromReadFile("BOOK_NOW"));
    boolean a2 = StringUtils.contains(getTextElement(driver, SEARCH_PROPERTY_FROM_FIRST), getTextFromReadFile("PRICE_FROM"));
    boolean a3 = StringUtils.contains(getTextBySplit(getTextElement(driver, SEARCH_PROPERTY_PER_NIGHT_FIRST), ",", 0), getTextFromReadFile("SEARCH_RESULT_PER_NIGHTS"));
    if (refund && giveback && a && a1 && a2 && a3) {
      System.out.println("Text at first property of search result correct! ");
    } else {
      System.out.println("Text at first property of search result wrong! ");
    }
  }

  public boolean verifyTextAtProperty() {
    String[] listRefundExpect = {"REFUNDABLE_FILTER_TXT", "PROPERTY_BREAKFAST"};
    boolean refund = verifyListItemByListExpect(listRefundExpect, SEARCH_RESULT_REFUND_LIST, SEARCH_RESULT_REFUND_DYNAMIC);
    String[] listGiveBack = {"PROPERTY_GIVE_BACK_STANDAR", "PROPERTY_GIVE_BACK_SMART"};
    boolean giveback = verifyListItemByListExpect(listGiveBack, SEARCH_RESULT_GIVEBACK_LIST, SEARCH_RESULT_GIVEBACK_DYNAMIC);
    boolean seeMap = verifyContentWithListActual(SEARCH_RESULT_SEE_MAP_LIST, "SEE_MAP_TEXT");
    boolean bookNow = verifyContentWithListActual(BOOK_NOW_BUTTON, "BOOK_NOW");
    boolean priceFrom = verifyContentWithListActual(SEARCH_PROPERTY_FROM_TXT, "PRICE_FROM");
    boolean perNight = verifyContentWithListActual(SEARCH_PROPERTY_PER_NIGHT_TXT, "SEARCH_RESULT_PER_NIGHT");
    boolean check = refund && giveback && seeMap && bookNow && priceFrom && perNight;
    if (!check) {
      System.out.println("Text at property of search result wrong! ");
    }
    return check;
  }

  public boolean verifyTextEventSale() {
    boolean check = true;
    boolean c = StringUtils.contains(getTextToolTip(driver, PRICE_BEFORE_SALE_FIRST, PRICE_TOOL_TIP).trim(), getTextFromReadFile("BEFORE_SALE_PRICE_TOOL_TIP"));
    boolean b = StringUtils.contains(getTextToolTip(driver, SEARCH_RESULT_EVENT_SALE_FIRST, EVENT_SALE_TOOL_TIP).trim(),
      getTextFromReadFile("NOT_LOGIN_EVENT_SALE_WEEKEND_TOOL_TIP"));
    if (b) {
      check = true;
    } else {
      System.out.println(" PRICE_BEFORE_SALE_FIRST actual:" + getTextToolTip(driver, PRICE_BEFORE_SALE_FIRST, PRICE_TOOL_TIP));
      System.out.println(" PRICE_BEFORE_SALE_FIRST exp:" + getTextFromReadFile("BEFORE_SALE_PRICE_TOOL_TIP"));
      System.out.println("============================");
      System.out.println(" EVENT_SALE_TOOL_TIP actual:" + getTextToolTip(driver, SEARCH_RESULT_EVENT_SALE_FIRST, EVENT_SALE_TOOL_TIP));
      System.out.println(" GIVEBACK_TOOL_TIP exp:" + getTextFromReadFile("NOT_LOGIN_EVENT_SALE_WEEKEND_TOOL_TIP"));
      System.out.println("============================");
      check = false;
    }
    if (!check) {
      System.out.println("Event sale is wrong ");
    }
    return check;
  }

  public void verifyToolTipPackageNotLogin() {
    if (!StringUtils.contains(removeBreakString(getTextToolTip(driver, GIVEBACK_TOOL_TIP, GIVEBACK_TOOL_TIP_CONTENT)), getTextFromReadFile("NOT_LOGIN_GIVE_BACK_TOOL_TIP"))) {
      System.out.println(" GIVEBACK_TOOL_TIP actual:" + getTextToolTip(driver, GIVEBACK_TOOL_TIP, GIVEBACK_TOOL_TIP_CONTENT).trim());
      System.out.println(" GIVEBACK_TOOL_TIP exp:" + getTextFromReadFile("NOT_LOGIN_GIVE_BACK_TOOL_TIP"));
      System.out.println("Tool tip at property when not login is wrong ");
    }
    if (!StringUtils.contains(removeBreakString(getTextElement(driver, FREE_BREAKFAST_PROPERTY)), getTextFromReadFile("PROPERTY_ROOM_INCLUDE"))) {
      System.out.println(" FREE_BREAKFAST_FILTER_FIRST actual:" + getTextElement(driver, FREE_BREAKFAST_PROPERTY));
      System.out.println(" FREE_BREAKFAST_FILTER_FIRST exp:" + getTextFromReadFile("PROPERTY_ROOM_INCLUDE"));
      System.out.println("Tool tip at property when not login is wrong ");
    }
  }

  public void verifyListPromotionsNotLogin() {
    String[] content = {"ITEM_LOW_PRICE", "ITEM_LOW_PRICE_SUB", "ITEM_GIVEBACK_BOOKING", "ITEM_GIVEBACK_BOOKING_SUB", "MY_INVITE_PEOPLE_TITLE_MAIN", "Invite_BANNER_TITLE2", "ITEM_GET_UP", "ITEM_GET_UP_SUB"};
    String[] xpath = {ITEM_PROMOTION_LOW_PRICE, ITEM_PROMOTION_LOW_PRICE_SUB, ITEM_PROMOTION_GIVEBACK, ITEM_PROMOTION_GIVEBACK_SUB, ITEM_INVITE, ITEM_INVITE_SUB, ITEM_GET_UP, ITEM_GET_UP_SUB};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("List Promotions at list property of search result is wrong ");
    } else {
      System.out.println("List Promotions at list property of search result is correct ");
    }
  }

  public void verifyListPromotionsLogin() {
    String[] content = {"MY_INVITE_PEOPLE_TITLE_MAIN", "Invite_BANNER_TITLE2", "ITEM_GET_UP", "ITEM_GET_UP_SUB"};
    String[] xpath = {ITEM_PROMOTION_LOW_PRICE, ITEM_PROMOTION_LOW_PRICE_SUB, ITEM_PROMOTION_GIVEBACK, ITEM_PROMOTION_GIVEBACK_SUB};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("List Promotions at list property of search result is wrong ");
    } else {
      System.out.println("List Promotions at list property of search result is correct ");
    }
  }

  public boolean verifyNoMesHotel() {
    String[] content = {"NO_HOTEL_MES_TITLE", "NO_HOTEL_MES_SUB"};
    String[] xpath = {NO_RESULTS_MES_TITLE, NO_RESULTS_MES_SUB};
    return verifyTwoListByKey(content, xpath);
  }

  public boolean verifyNoMesFilter() {
    String[] content = {"NO_FILTER_MES_TITLE", "NO_FILTER_MES_SUB", "RESET_FILTER"};
    String[] xpath = {NO_RESULTS_MES_TITLE, NO_RESULTS_MES_SUB, OK_RELOAD_BUTTON};
    return verifyTwoListByKey(content, xpath);
  }

  public void searchRandomDestination() {
    inputLocationSearch("Ho Chi Minh");
    clickToElementByJavascript(driver, LANDING_SEARCH_BUTTON);
    waitFoElementVisible(driver, COUNT_RESULTS_HOTEL);
  }

  public void verifyClickOnSeeMap() {
    verifyTextByKey("MINI_MAP_VIEW", MINI_MAP_VIEW);
    clickToElementByJavascript(driver, MINI_MAP_VIEW);
    waitFoElementVisible(driver, MAP_VIEW_SEARCH_RESULT_TXT);
    boolean b = StringUtils.contains(getTextBySplitLimitSegment(getTextElement(driver, MAP_VIEW_SEARCH_RESULT_TXT), " ", 1), getTextFromReadFile("MAP_VIEW_SEARCH_RESULT_TXT"));
    String[] listFilterMap = {"SORT_PRICE", "MAP_VIEW_FILTER1", "Filter_Popular", "Filter_Payment_Type", "MAP_VIEW_FILTER2", "MAP_VIEW_FILTER3", "MAP_VIEW_FILTER4"};
    if (compareTwoListByKey(listFilterMap, MAP_VIEW_FILTER_LIST) && b && verifyTextByKey("MAP_VIEW_CLOSE_BTN", MAP_VIEW_CLOSE_BTN) && verifyTextByKey("MAP_VIEW_FILTER_LABEL",
      MAP_VIEW_FILTER_LABEL) && verifyTextByKey("MAP_VIEW_FILTER_LABEL", MAP_VIEW_FILTER_LABEL) && verifyTextByKeyWithAttribute("MAP_VIEW_SEARCH_TXT", MAP_VIEW_SEARCH_TXT,
      "placeholder") && verifyTextByKey("MAP_VIEW_SEE_MORE_BTN", MAP_VIEW_SEE_MORE_BTN)) {
      System.out.println("Text when view Map View of Search Result correct");
    } else {
      System.out.println("Text when view Map View of Search Result wrong");
    }
    List<WebElement> elements = driver.findElements(By.xpath(MAP_VIEW_LIST_HOTEL));
    if (elements.size() != 15) {
      System.out.println("Display first number result wrong!");
    }
    int size = 15;
    clickToElementByJavascript(driver, MAP_VIEW_SEE_MORE_BTN);
    if (size * 2 == elements.size()) {
      System.out.println("Display list result correct after click on See More");
    }
    clickToElementByJavascript(driver, MAP_VIEW_CLOSE_BTN);
  }

  public void searchByDestination(String destination) {
    inputLocationSearch(destination);
    clickSearchHotelBtn(driver);
  }

  public List<String> getListHotelInSearchResult() {
    jsWaitForPageToLoad(driver, 5);
    wait5sTime();
    List<String> listHotels = new ArrayList<>();
    List<WebElement> elements = driver.findElements(By.xpath(LIST_PROPERTY_NAME));
    for (WebElement element : elements) {
      scrollToWebElement(driver, element);
      listHotels.add(element.getText());
    }
    return listHotels;
  }

  public void verifyListHotelAfterSortByProperty(List<String> listHotelExpect, String sortProperty) {
    scrollToTopPage(driver);
    switch (sortProperty) {
      case "Property Rank" :
        WebElement eleSortRank = driver.findElement(By.xpath(SORT_BY_RANK));
        eleSortRank.click();
        Assert.assertTrue(eleSortRank.getAttribute("class").contains("active"));
        break;
      case "Rating (Highest first)":
        WebElement eleSortRatingHighest = driver.findElement(By.xpath(SORT_BY_RATING));
        eleSortRatingHighest.click();
        Assert.assertTrue(eleSortRatingHighest.getAttribute("class").contains("active"));
        Assert.assertTrue(eleSortRatingHighest.getText().contains("Rating (Highest first)"));
        break;
      case "Rating (Lowest first)":
        WebElement eleSortRatingLowest = driver.findElement(By.xpath(SORT_BY_RATING));
        eleSortRatingLowest.click();
        Assert.assertTrue(eleSortRatingLowest.getAttribute("class").contains("active"));
        Assert.assertTrue(eleSortRatingLowest.getText().contains("Rating (Highest first)"));
        eleSortRatingLowest.click();
        Assert.assertTrue(eleSortRatingLowest.getText().contains("Rating (Lowest first)"));
        break;
      case "Price (High to low)":
        WebElement eleSortPriceHigh = driver.findElement(By.xpath(SORT_BY_PRICE));
        eleSortPriceHigh.click();
        Assert.assertTrue(eleSortPriceHigh.getAttribute("class").contains("active"));
        Assert.assertTrue(eleSortPriceHigh.getText().contains("Price (High to low)"));
        break;
      case "Price (Low to high)":
        WebElement eleSortPriceLow = driver.findElement(By.xpath(SORT_BY_PRICE));
        eleSortPriceLow.click();
        Assert.assertTrue(eleSortPriceLow.getAttribute("class").contains("active"));
        Assert.assertTrue(eleSortPriceLow.getText().contains("Price (High to low)"));
        eleSortPriceLow.click();
        Assert.assertTrue(eleSortPriceLow.getText().contains("Price (Low to high)"));
        break;
      case "Distance from downtown":
        WebElement eleSortDistance = driver.findElement(By.xpath(SORT_BY_DISTANCE));
        eleSortDistance.click();
        Assert.assertTrue(eleSortDistance.getAttribute("class").contains("active"));
        break;
      case "Top Rated":
        WebElement eleSortTopRated = driver.findElement(By.xpath(SORT_BY_TOP_RATE));
        eleSortTopRated.click();
        Assert.assertTrue(eleSortTopRated.getAttribute("class").contains("active"));
        break;
      default:
        System.out.println("Condition sort is not existing");
        break;
    }
    Assert.assertEquals(getListHotelInSearchResult(), listHotelExpect);
  }
}
