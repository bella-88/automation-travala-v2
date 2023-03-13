package pages.hotel;

import commons.hotel.CommonHotelPages;
import interfaces.hotel.LandingPageUI;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static commons.CommonsTravalaXpath.*;

import static commons.CommonsTravalaXpath.BANNER_TITLE;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.CountryPageUI.*;
import static interfaces.hotel.HomePageUI.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.SearchPageUI.*;
import static interfaces.hotel.myProfile.MyInvitePageUI.*;
import static interfaces.hotel.myProfile.MyTravelCreditsPageUI.*;


public class HomePage extends CommonHotelPages {
  WebDriver driver;
  SoftAssert softAssert = new SoftAssert();
  public HomePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyLeftMenu() {
    String[] content = {"WELCOME_TO_TRAVALA_TXT", "MENU_INFO_ACC", "LOG_OUT_LINK", "MY_INVITE_PEOPLE_TITLE_MAIN", "Invite_BANNER_TITLE2", "Invite_BANNER_TITLE3"};
    String[] xpath = {MENU_WELCOME, MENU_INFO_ACC, HOME_LOGOUT_MENU, HOME_INVITE_EARN_TEXT, HOME_GIVE_GET_TEXT, HOME_INVITE_BTN};
    boolean b = verifyTwoListByKey(content, xpath);
    String[] menu = {"MY_ACCOUNT_LINK", "MY_BOOKING_LINK", "MY_INVITE_LINK", "MY_SMART_LINK", "MY_TIGER_LINK", "MY_WALLET_LINK", "MY_TRAVEL_CREDIT_LINK", "MY_WISH_LIST_LINK"};
    if ((b && compareTwoListByKey(menu, LEFT_MENU_LIST))) {
      System.out.println("Left menu at My Account is displayed correct! ");
    } else {
      System.out.println("Left menu at My Account is displayed correct! ");
    }
  }

  public void clickToMyMyAccountLink() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    clickToElementByJavascript(driver, MY_ACCOUNT_LINK);
//    verifyLeftMenu();
  }

  public void clickToMyInviteLink() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    clickToElement(driver, MY_INVITE_LINK);
    wait1sTime();
    clickToElementByJavascript(driver, MY_INVITE_INVITE_PEOPLE);
  }

  public void clickToMyTravelCreditsLink() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    clickToElementByJavascript(driver, MY_TRAVEL_CREDIT_MENU_LINK);
    wait100Time();
    clickToElement(driver, MY_TRAVEL_CREDIT_BUY_TAB);
  }

  public void clickToMyTripLink() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    clickToElementByJavascript(driver, MY_TRIP_LINK);
    wait1sTime();
  }

  public void clickToMyWishListLink() {
    clickToElementByJavascript(driver, PROFILE_ICON);
    wait1sTime();
  }

  public void clickToMyBooking() {
    clickToMyMyAccountLink();
    clickToElement(driver, MY_BOOKING_MENU);
    clickToElementByJavascript(driver, MY_BOOKING_SECTION_STAY);
  }


  public void datePicker() {
    String today = getCurrentDaySystem();
    System.out.println("Today is: " + today);
    wait1sTime();
    String today1 = String.valueOf(Integer.valueOf(today) + 1);
    driver.findElement(By.xpath("//table//td[text()='" + today1 + "']")).click();
    driver.findElement(By.xpath("//table//td[text()='" + today + "']")).click();
    driver.findElement(By.xpath(LandingPageUI.CHECKINOUT_DATETIME)).sendKeys(Keys.TAB);
  }

  public void inputCheckInOut(String checkin) {
    sendkeysToElement(driver, LandingPageUI.CHECKINOUT_DATETIME, checkin);
  }

  public void clickToDateTime() {
    driver.findElement(By.cssSelector(LandingPageUI.CHECKINOUT_DATETIME)).click();
  }

  //=====================================ACTIVITIES===================================================

//  public boolean checkDateTimeAct(int day) {
//    boolean b;
//    String dateTimeAct = driver.findElement(By.xpath(DATE_TEXT_HOLDER)).getText().trim();
//    Date date = Calendar.getInstance().getTime();
//    SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
//    Date d = null;
//    try {
//      d = f.parse(dateTimeAct);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    String dateTimeExp = f.format(DateUtils.addDays(date, day));
//    System.out.println("actual day: " + dateTimeAct);
//    System.out.println("expect day:" + dateTimeExp);
//    if (StringUtils.equals(dateTimeExp, dateTimeAct)) {
//      b = true;
//    } else {
//      b = false;
//    }
//    return b;
//  }

  public void verifyNoBooking() {
    boolean checkShowBooking = checkDisplayElement(driver, MY_BOOKING_NO_BOOKING);
    boolean a = StringUtils.contains(getTextElement(driver, MY_BOOKING_NO_BOOKING), getTextFromReadFile("MY_BOOKING_NO_BOOKING"));
    boolean a1 = StringUtils.contains(getTextElement(driver, MY_BOOKING_NO_BOOKING_BTN), getTextFromReadFile("MY_BOOKING_NO_BOOKING_BTN"));
    if (!a || !a1) {
      System.out.println("ACTUAL No Booking Text" + getTextElement(driver, MY_BOOKING_NO_BOOKING));
      System.out.println("EXPECT No Booking Text" + getTextFromReadFile("MY_BOOKING_NO_BOOKING"));
      System.out.println("ACTUAL  No Booking Btn" + getTextElement(driver, MY_BOOKING_NO_BOOKING_BTN));
      System.out.println("EXPECT  No Booking Btn" + getTextFromReadFile("MY_BOOKING_NO_BOOKING_BTN"));
      System.out.println("============================================================");
    }
  }
//=====================================TIGER NFT===================================================

  public void verifyTotalImageSlide() {

  }

  public void verifyClickToButtonOverView() {
    int i = 1;
    List<WebElement> elements = driver.findElements(By.xpath(NFT_OVERVIEW_BUTTON));
    boolean b = true;
    boolean b1 = true;
    while (i < elements.size() + 1) {
      String href = getAttribute(driver, String.format(NFT_OVERVIEW_BUTTON_DYNAMIC, i), "href");
      wait1sTime();
      b = StringUtils.contains(href, NFT_PATH);
      b1 = StringUtils.contains(href, OPENSEA_PATH);
      i++;
    }
    if (b || b1) {
      System.out.println("Link of button on OverView NFT correct ");
    } else {
      System.out.println("Link of button on OverView NFT wrong ");
    }
  }

  public void verifyTextOnOverViewNFT() {
    String[] title = {"SMART_INTRO_DIAMOND_TITLE2", "SMART_INTRO_DIAMOND_TITLE10", "WHITELIST_BENEFIT_SUB_TITLE1", "SMART_INTRO_DIAMOND_TITLE8"
            , "NFT_BENEFIT_TITLE3", "SMART_INTRO_DIAMOND_TITLE4", "SMART_INTRO_DIAMOND_TITLE5", "SMART_INTRO_DIAMOND_TITLE7"};
    boolean bTitle = compareTwoListByKey(title, NFT_OVERVIEW_TITLE);
    if (!bTitle) {
      System.out.println("List Title wrong");
    }
    String[] content = {"NFT_BENEFIT_DESC1", "SMART_INTRO_BENEFIT_CONTENT9", "SMART_INTRO_DIAMOND_SUB_TITLE3", "SMART_INTRO_DIAMOND_SUB_TITLE8"
            , "NFT_BENEFIT_DESC3", "SMART_INTRO_BASIC_SUB_TITLE2", "SMART_INTRO_DIAMOND_SUB_TITLE5", "NFT_BENEFIT_DESC8"};
    boolean bContent = compareTwoListByKey(content, NFT_OVERVIEW_CONTENT);
    if (!bContent) {
      System.out.println("List content Over View NFT wrong");
    }
    String[] subContent = {"NFT_OVERVIEW_SUB_CONTENT1", "NFT_OVERVIEW_SUB_CONTENT2"};
    boolean bSubContent = compareTwoListByKey(subContent, NFT_OVERVIEW_SUB_CONTENT);
    if (!bSubContent) {
      System.out.println("Sub content Over View NFT wrong");
    }
    String[] button = {"NFT_OVERVIEW_BUTTON1", "NFT_OVERVIEW_BUTTON2"};
    String[] overview = {"NFT_OVERVIEW_BANNER1", "NFT_OVERVIEW_BANNER2"};
    String[] xpath = {NFT_OVERVIEW_TITLE1, NFT_OVERVIEW_TITLE2};
    boolean b = verifyTwoListByKey(overview, xpath);
    if ((b && compareTwoListByKey(button, NFT_OVERVIEW_BUTTON) && bContent && bTitle && bSubContent)) {
      System.out.println("Text at Over View NFT is displayed correct! ");
    } else {
      System.out.println("Text at Over View NFT is displayed wrong! ");
    }
  }

  public void verifyOneNft() {
    String[] title = {"NFT_OVERVIEW_TABLE_TITLE1", "NFT_OVERVIEW_TABLE_TITLE2", "NFT_OVERVIEW_TABLE_TITLE3"};
    String[] imgTitle = {"NFT_OVERVIEW_IMG_TITLE1", "NFT_OVERVIEW_IMG_TITLE2", "NFT_OVERVIEW_IMG_TITLE3"};
    boolean bTitle = compareTwoListByKey(title, NFT_OVERVIEW_TABLE_TITLE);
    boolean bImgTitle = compareTwoListByKey(imgTitle, NFT_OVERVIEW_DETAIL_IMG_TITLE);
    if (!bTitle) {
      System.out.println("Text at table NFT wrong");
    }
    if (!bImgTitle) {
      System.out.println("Text at image NFT wrong");
    }
    if (bTitle && bImgTitle) {
      System.out.println("Info of 1 NFT detail is show correct!");
    }
  }

  public void verifyDisplayListNFT() {
    int total = Integer.valueOf(getTextBySplit(getTextElement(driver, NFT_OVERVIEW_TOTAL_ITEM), "Items", 0).replaceAll(" ", ""));
    if (StringUtils.contains(getTextElement(driver, NFT_OVERVIEW_TOTAL_ITEM), "Item")) {
      System.out.println("Display text total items NFT correct");
    } else {
      System.out.println("Display text total items NFT wrong");
    }
    List<WebElement> elements = driver.findElements(By.xpath(NFT_OVERVIEW_LIST_ITEM));
    if (total == elements.size()) {
      System.out.println("Display " + total + " items NFT correct");
    } else {
      System.out.println("Total: " + total);
      System.out.println("List display: " + elements.size());
      System.out.println("Display total items NFT wrong");
    }
    int i = 1;
    boolean b = true;
    while (i < elements.size() + 1) {
      clickElementByDynamicLocator(driver, NFT_OVERVIEW_LIST_ITEM_DYNAMIC, String.valueOf(i));
      if (!verifyTextByKey("NFT_TITLE", "//div[contains(@class,'nftContent')]/h3")) {
        b = false;
      }
      clickToElementByJavascript(driver, NFT_OVERVIEW_BACK_BTN);
      i++;
    }
    if (b) {
      System.out.println("Link to NFT detail and back to previous page correct");
    } else {
      System.out.println("Link to NFT detail and back to previous page wrong");
    }
  }

  public void verifyDisplayOverViewOption() {
    if (checkShowElement(driver, NFT_OVERVIEW_DETAIL_IMG) != 0) {
      verifyOneNft();
    } else {
//      System.out.println("t1: "+checkShowElement(driver, NFT_OVERVIEW_TITLE1));
      if (checkShowElement(driver, NFT_OVERVIEW_TITLE1) != 0) {
        verifyTextOnOverViewNFT();
        verifyClickToButtonOverView();
        verifyTotalImageSlide();
      } else {
        verifyDisplayListNFT();
      }
    }
  }

  public void verifyBalanceOnHeader(String expectBalance) {
    Assert.assertEquals(getTextElement(driver, BALANCE_ON_HEADER).replace("US$", ""), expectBalance);
  }

  public void goToMyTravelCredits() {
    clickToElement(driver, BALANCE_ON_HEADER);
    clickToElement(driver, MY_TRAVEL_CREDIT_MENU_LINK);
  }

  public void verifyContentTextInOverviewTigerNFT() {
    boolean flag = true;
    String[] groupNotDiamond = {"TIGER_NFT_PAGE_NO_NFT_CONNECT_TITLE", "TIGER_NFT_PAGE_NO_NFT_CONNECT_SUB"};
    String[] xpathsOfGroupNotDiamond = {NFT_OVERVIEW_NO_TIGER_NFT_TITLE, NFT_OVERVIEW_NO_TIGER_NFT_CONTENT};
    boolean isGroupNotDiamondCorrect = verifyTwoListByKey(groupNotDiamond, xpathsOfGroupNotDiamond);

    String[] benefits = {"TIGER_NFT_PAGE_JOIN_TO_GET_SMART_DIAMOND_TITLE", "TIGER_NFT_PAGE_SMART_DIAMOND_BENEFIT_DETAIL"};
    String[] xpathBenefits = {NFT_OVERVIEW_SMART_DIAMOND_BENEFITS_TITLE, NFT_OVERVIEW_SMART_DIAMOND_BENEFITS_CONTENT};
    boolean isBenefits = verifyTwoListByKey(benefits, xpathBenefits);

    String[] listBenefitsTitle = {"TIGER_NFT_PAGE_TRAVEL_DROPS_TITLE", "TIGER_NFT_PAGE_PROOF_OF_TRAVEL_TITLE", "TIGER_NFT_PAGE_AMBASSADOR_BONUS_TITLE", "TIGER_NFT_PAGE_TRVL_AIRDROPS_TITLE",
            "TIGER_NFT_PAGE_LOYALTY_REWARDS_TITLE", "TIGER_NFT_PAGE_CONCIERGE_ACCESS_TITLE", "TIGER_NFT_PAGE_AVA_PAYMENT_TITLE", "TIGER_NFT_PAGE_METAVERSES_TITLE"};
    boolean isListBenefitsTitle = verifyListItemByListExpect(listBenefitsTitle, NFT_OVERVIEW_BENEFIT_TITLE_LIST, NFT_OVERVIEW_BENEFIT_TITLE_DYNAMIC);

    String[] listDescOfTitleBenefits = {"TIGER_NFT_PAGE_TRAVEL_DROPS_PARAGRAPH", "TIGER_NFT_PAGE_PROOF_OF_TRAVEL_PARAGRAPH", "TIGER_NFT_PAGE_AMBASSADOR_BONUS_PARAGRAPH", "TIGER_NFT_PAGE_TRVL_AIRDROPS_PARAGRAPH",
            "TIGER_NFT_PAGE_LOYALTY_REWARDS_PARAGRAPH", "TIGER_NFT_PAGE_CONCIERGE_ACCESS_PARAGRAPH", "TIGER_NFT_PAGE_AVA_PAYMENT_PARAGRAPH", "TIGER_NFT_PAGE_METAVERSES_PARAGRAPH"};
    boolean isListDescOfTitleBenefits = verifyListItemByListExpect(listDescOfTitleBenefits, NFT_OVERVIEW_BENEFIT_DESC_LIST, NFT_OVERVIEW_BENEFIT_DESC_DYNAMIC);
    flag = isGroupNotDiamondCorrect && isBenefits && isListBenefitsTitle && isListDescOfTitleBenefits;
    if (flag) {
      System.out.println("Content Tiger NFT page correctly");
    } else {
      System.out.println("Content Tiger NFT page incorrectly");
    }
  }

  public void verifyTextHeaderHomePage() {
    String[] expectHeaderText = {"HEADER_PAGE_STAYS_TAB", "HEADER_PAGE_FLIGHTS_TAB", "HEADER_PAGE_ACTIVITIES_TAB", "HEADER_PAGE_ACTIVATE_NFT_BUTTON", "HEADER_PAGE_EXPLORE_NFT_BUTTON",
            "HEADER_PAGE_MY_TRIP_TAB", "HEADER_PAGE_VOTE_TAB", "HEADER_PAGE_SIGNUP_NOW_BUTTON", "HEADER_PAGE_LOGIN_TAB"};
    String[] listXpathHeader = {LANDING_STAY_LINK, LANDING_FLIGHT_LINK, LANDING_ACTIVITIES_LINK, HEADER_ACTIVATE_NFT_URL, HEADER_EXPLORE_NFT_URL, HEADER_MY_TRIP_URL, HEADER_GOVERNANCE_URL, HEADER_SIGN_UP_URL, HEADER_LOGIN_URL};
    softAssert.assertTrue(verifyTwoListByKey(expectHeaderText, listXpathHeader), "[Header] List texts incorrectly. Please check again!");
    softAssert.assertAll();
  }

  public void verifyTextFooterHomePage() {

    String[] expectFooterText = {"FOOTER_PAGE_DESCRIPTION_PAYMENT_METHOD", "FOOTER_PAGE_TRAVALA_TITLE", "FOOTER_PAGE_SUPPORT_TITLE",
                                "FOOTER_PAGE_USEFUL_LINKS_TITLE", "FOOTER_PAGE_RESOURCES_TITLE", "FOOTER_PAGE_COMMUNITY_TITLE"};
    softAssert.assertTrue(verifyListItemByListExpect(expectFooterText, FOOTER_LIST_TEXT, FOOTER_LIST_TEXT_DYNAMIC), "[Footer] Text is incorrect");

    String[] expectFooterTextInTravalaColumn = {"FOOTER_PAGE_ABOUT_US_IN_TRAVALA", "FOOTER_PAGE_AVA_TOKEN_IN_TRAVALA", "FOOTER_PAGE_SMART_PROGRAM_IN_TRAVALA",
                                                "FOOTER_PAGE_INVITE_PROGRAM_IN_TRAVALA", "FOOTER_PAGE_PRICE_GUARANTEE_IN_TRAVALA", "FOOTER_PAGE_AFFILIATE_PROGRAM_IN_TRAVALA",
                                                "FOOTER_PAGE_TRAVEL_CREDITS_IN_TRAVALA", "FOOTER_PAGE_TRAVEL_GIFT_CARDS_IN_TRAVALA", "FOOTER_PAGE_TRAVALA_MEMBERS_IN_TRAVALA"};
    softAssert.assertTrue(verifyListItemByListExpect(expectFooterTextInTravalaColumn, FOOTER_LIST_TEXT_IN_TRAVALA_COLUMN, FOOTER_LIST_TEXT_IN_TRAVALA_COLUMN_DYNAMIC), "[Footer] Text in Travala column incorrectly");

    String[] exptectFooterTextInSupportColumn = {"FOOTER_PAGE_HELP_CENTER_IN_SUPPORT", "FOOTER_PAGE_MY_TRIP_IN_SUPPORT", "FOOTER_PAGE_TERMS_AND_CONDITIONS_IN_SUPPORT",
                                                "FOOTER_PAGE_PRIVACY_POLICY_IN_SUPPORT", "FOOTER_PAGE_COOKIE_POLICY_IN_SUPPORT", "FOOTER_PAGE_CONTACT_US_IN_SUPPORT",
                                                "FOOTER_PAGE_PARTNERSHIP_IN_SUPPORT", "FOOTER_PAGE_CONCIERGE_IN_SUPPORT", "FOOTER_PAGE_MEDIA_CONTACT_IN_SUPPORT"};
    softAssert.assertTrue(verifyListItemByListExpect(exptectFooterTextInSupportColumn, FOOTER_LIST_TEXT_IN_SUPPORT_COLUMN, FOOTER_LIST_TEXT_IN_SUPPORT_COLUMN_DYNAMIC), "[Footer] Text in Support column incorrectly");

    String[] expectFooterTextInUsefulLinksColumn = {"FOOTER_PAGE_MOBILE_APP_IN_USEFUL_LINKS", "FOOTER_PAGE_BUSINESS_TRAVEL_IN_USEFUL_LINKS", "FOOTER_PAGE_PAYMENT_OPTIONS_IN_USEFUL_LINKS",
                                                   "FOOTER_PAGE_BINANCE_TRAVEL_IN_USEFUL_LINKS", "FOOTER_PAGE_PARTNER_NETWORK_IN_USEFUL_LINKS", "FOOTER_PAGE_BUG_REPORT_IN_USEFUL_LINKS",
                                                    "FOOTER_PAGE_SITEMAP_IN_USEFUL_LINKS", "FOOTER_PAGE_ACTIVE_NFT_IN_USEFUL_LINKS"};
    softAssert.assertTrue(verifyListItemByListExpect(expectFooterTextInUsefulLinksColumn, FOOTER_LIST_TEXT_IN_USEFUL_LINKS_COLUMN, FOOTER_LIST_TEXT_IN_USEFUL_LINKS_COLUMN_DYNAMIC), "[Footer] Text in Useful Links column incorrectly");

    String[] expectFooterTextInResourcesColumn = {"FOOTER_PAGE_OFFICIAL_BLOG_IN_RESOURCES", "FOOTER_PAGE_TRAVEL_ADVICES_IN_RESOURCES", "FOOTER_PAGE_TRAVEL_GUIDES_IN_RESOURCES",
                                                  "FOOTER_PAGE_READ_REVIEWS_IN_RESOURCES", "FOOTER_PAGE_OUR_PARTNERS_IN_RESOURCES", "FOOTER_PAGE_COIN_LISTING_IN_RESOURCES", "FOOTER_PAGE_CAREERS_IN_RESOURCES"};
    softAssert.assertTrue(verifyListItemByListExpect(expectFooterTextInResourcesColumn, FOOTER_LIST_TEXT_IN_RESOURCES_COLUMN, FOOTER_LIST_TEXT_IN_RESOURCES_COLUMN_DYNAMIC), "[Footer] Text in Resource column incorrectly");

    String[] expectFooterTextInCommunityColumn = {"FOOTER_PAGE_TWITTER_IN_COMMUNITY", "FOOTER_PAGE_FACEBOOK_IN_COMMUNITY", "FOOTER_PAGE_TELEGRAM_IN_COMMUNITY",
                                                  "FOOTER_PAGE_INSTAGRAM_IN_COMMUNITY", "FOOTER_PAGE_REDDIT_IN_COMMUNITY", "FOOTER_PAGE_LINKEDIN_IN_COMMUNITY"};
    softAssert.assertTrue(verifyListItemByListExpect(expectFooterTextInCommunityColumn,FOOTER_LIST_TEXT_IN_COMMUNITY_COLUMN, FOOTER_LIST_TEXT_IN_COMMUNITY_COLUMN_DYNAMIC), "[Footer] Text in Community column incorrectly");
    softAssert.assertAll();

  }
  public void verifyTextForEachOptionsInSearchBar() {
    String staysTabExpect =  getTextFromReadFile("HEADER_PAGE_STAYS_TAB");
    String flightsTabExpect =  getTextFromReadFile("HEADER_PAGE_FLIGHTS_TAB");
    String activitiesTabExpect =  getTextFromReadFile("HEADER_PAGE_ACTIVITIES_TAB");

    List<WebElement> listTabInSearchBar = driver.findElements(By.xpath(SEARCH_BAR_LIST_TAB));
    for (int i = 0; i < listTabInSearchBar.size(); i++) {
      WebElement element = listTabInSearchBar.get(i);
      element.click();
      String tabName = element.getText();
      WebElement titleBanner = driver.findElement(By.xpath(BANNER_TITLE));
      WebElement titleSubBanner = driver.findElement(By.xpath(BANNER_TITLE_SUB));
      softAssert.assertTrue(element.getAttribute("class").contains("HomePagePC_headerActive"));
      if(tabName.equals(staysTabExpect)) {
        String titleBannerActual = titleBanner.getText();
        softAssert.assertTrue(titleBannerActual.contains("BOOK") && titleBannerActual.contains("AND SAVE UP TO 40%"), "The title of " + tabName + " incorrectly");
        softAssert.assertEquals(titleSubBanner.getText().replaceAll("\n", " "), "Best Prices Guaranteed On 2,200,000+ Hotels & Accommodations Worldwide", "The sub-title of " + tabName + " incorrectly");
        softAssert.assertEquals(driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX)).getAttribute("placeholder"), "Search for Places or Properties");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_HOTEL_DATE_BLOCK)).isDisplayed(), "Select date is not displayed");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_HOTEL_ROOM_INFO)).isDisplayed(), "Select room is not displayed");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_BAR_BUTTON_SEARCH)).isEnabled(), "Search button is enabled");
      } else if(tabName.equals(flightsTabExpect)) {
        String titleBannerActual = titleBanner.getText();
        softAssert.assertTrue(titleBannerActual.contains("BOOK FLIGHTS WORLDWIDE"), "The title of " + tabName + " incorrectly");
        softAssert.assertEquals(titleSubBanner.getText().replaceAll("\n", " "), "Instantly Search and Book with over 600+ Airlines", "The title of " + tabName + " incorrectly");
        String[] listFlightsType = {"Return", "One way"};
        List<WebElement> eles = driver.findElements(By.xpath(SEARCH_FLIGHTS_SELECT_FLIGHT_TYPE));
        for (int j=0; j<eles.size(); j++) {
          softAssert.assertEquals(listFlightsType[j], eles.get(j).getText(), "Type flights is not same expect");
        }
        softAssert.assertEquals(driver.findElement(By.xpath(SEARCH_FLIGHTS_FROM_LOCATION)).getAttribute("placeholder"), "Flying from");
        softAssert.assertEquals(driver.findElement(By.xpath(SEARCH_FLIGHTS_TO_LOCATION)).getAttribute("placeholder"), "Flying to");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_FLIGHTS_DATE_BLOCK)).isDisplayed(), "Select date is not displayed");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_FLIGHTS_PASSENGER)).isDisplayed(), "Select Passenger is not displayed");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_BAR_BUTTON_SEARCH)).isEnabled(), "Search button is enabled");
      } else if(tabName.equals(activitiesTabExpect)) {
        String titleBannerActual = titleBanner.getText();
        softAssert.assertTrue(titleBannerActual.contains("BOOK") && titleBannerActual.contains("WORLDWIDE"), "The title of " + tabName + " incorrectly");
        softAssert.assertEquals(titleSubBanner.getText().replaceAll("\n", " "), "Best Prices Guaranteed on 410,000+ Activities, Tours and Experiences, Worldwide", "The title of " + tabName + " incorrectly");
        softAssert.assertEquals(driver.findElement(By.xpath(SEARCH_ACTIVITIES_TEXTBOX)).getAttribute("placeholder"), "Find amazing things to do. Anytime, anywhere");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_ACTIVITIES_DATE_BLOCK)).isDisplayed(), "Select date is not displayed");
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_BAR_BUTTON_SEARCH)).isEnabled(), "Search button is enabled");
      } else Assert.fail("Tab name is " + tabName + " not existing");

      softAssert.assertAll();
      System.out.println("Text in Search bar of " + tabName + " correctly");
    }

  }
  public void verifyContentHomePage() {
    String[] listMailFeatureTitle = {"HOME_PAGE_MAIN_FEATURE_TITLE1", "HOME_PAGE_MAIN_FEATURE_TITLE2", "HOME_PAGE_MAIN_FEATURE_TITLE3", "HOME_PAGE_MAIN_FEATURE_TITLE4"};
    String[] listMainFeatureContent = {"HOME_PAGE_MAIN_FEATURE_CONTENT1", "HOME_PAGE_MAIN_FEATURE_CONTENT2", "HOME_PAGE_MAIN_FEATURE_CONTENT3", "HOME_PAGE_MAIN_FEATURE_CONTENT4"};
    String[] listTextInPaymentOptionsSection = {"HOME_PAGE_PAYMENT_OPTIONS_TITLE", "HOME_PAGE_PAYMENT_OPTIONS_DESC"};
    String[] listXpathsInPaymentOptionsSection = {CRYPTO_CURRENT_FRIENDLY_TITLE, CRYPTO_CURRENT_FRIENDLY_CONTENT};
    softAssert.assertTrue(verifyListItemByListExpect(listMailFeatureTitle, HOME_PAGE_MAIN_FEATURE_TITLE, HOME_PAGE_MAIN_FEATURE_TITLE_DYNAMIC), "List main features title incorrectly");
    softAssert.assertTrue(verifyListItemByListExpect(listMainFeatureContent, HOME_PAGE_MAIN_FEATURE_CONTENT, HOME_PAGE_MAIN_FEATURE_CONTENT_DYNAMIC), "List main features content incorrectly");
    softAssert.assertTrue(verifyTwoListByKey(listTextInPaymentOptionsSection, listXpathsInPaymentOptionsSection), "List text in Payment options section incorrectly");
    Map<Integer, String[]> section = new HashMap<>();
    String[] customerReviews = {getTextFromReadFile("HOME_PAGE_CUSTOMER_REVIEWS_TITLE"), getTextFromReadFile("HOME_PAGE_CUSTOMER_REVIEWS_SUBTITLE")};
    String[] listDestination = {getTextFromReadFile("HOME_PAGE_LIST_DESTINATION_TITLE"), getTextFromReadFile("HOME_PAGE_LIST_DESTINATION_SUBTITLE")};
    String[] topCountry = {getTextFromReadFile("HOME_PAGE_TOP_COUNTRY_TITLE"), getTextFromReadFile("HOME_PAGE_TOP_COUNTRY_SUBTITLE")};
    section.put(1, customerReviews);
    section.put(2, listDestination);
    section.put(3, topCountry);
    List<WebElement> listElementTitleOfSection = driver.findElements(By.xpath(HOME_PAGE_SECTION_TITLE_LIST));
    for (int i=0; i<listElementTitleOfSection.size(); i++) {
      String actualResult = listElementTitleOfSection.get(i).getText();
      softAssert.assertTrue(actualResult.contains(section.get(i+1)[0]) && actualResult.contains(section.get(i+1)[1]));
    }
    softAssert.assertAll();
    System.out.println("Content text in Home page correctly");
  }

  public void verifyPageTopCountryInHomePage() {
    List<WebElement> elements = driver.findElements(By.xpath(LANDING_TOP_COUNTRY_DISPLAY));
    for (WebElement element : elements) {
      String countryName = element.getText();
      element.click();
      switchToWindowByUrlContainsString(driver, countryName);
      WebElement titleCountrPage = driver.findElement(By.xpath(COUNTRY_BANNER_TEXT1));
      boolean isDisplayCorrect = titleCountrPage.getText().contains(countryName.toUpperCase());
      softAssert.assertTrue(isDisplayCorrect, "Country page display incorrectly.\nEXPECT: " + countryName.toUpperCase() + "\nACTUAL: "+ titleCountrPage.getText());
      softAssert.assertAll();
      if(isDisplayCorrect) {
        System.out.println(countryName + "page displayed correctly");
      }
      switchTab(driver);
    }
  }

  public void verifyNavigateToSearchResultFromDestinations() {
    Actions actions = new Actions(driver);
    List<WebElement> elements = driver.findElements(By.xpath(LANDING_LIST_DESTINATION_DISPLAY));
    for (int i = 0; i < elements.size(); i++) {
      elements = driver.findElements(By.xpath(LANDING_LIST_DESTINATION_DISPLAY));
      WebElement element = elements.get(i);
      String location = element.findElement(By.xpath(".//h4")).getText();
      actions.moveToElement(element).perform();
      clickToElementByJavascript(driver, element);
      wait2sTime();
      WebElement searchText = driver.findElement(By.xpath(SEARCH_TXT_TITLE));
      softAssert.assertTrue(searchText.getAttribute("value").contains(location), "Text in search box different destination.\n Expect value: "+location+
              "\n Actual value: " + searchText.getAttribute("value") + "\n");
      softAssert.assertAll();
      backToPreviousPage(driver);
      wait2sTime();
    }
  }

  public void verifyDisplayListCoinFromPaymentOptions() {
    WebElement paymentOptionBtn = driver.findElement(By.xpath(""));
    paymentOptionBtn.click();

  }

//  public List<String> getListPropertySuggestionInSearchBox(String text) {
//    List<String> listPropertySuggestion = new ArrayList<>();
//    clickToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
//    WebElement search = driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX_FIRST));
//    search.sendKeys(text);
//    List<WebElement> elements = driver.findElements(By.xpath(LIST_PROPERTIES_SUGGESTION));
//    for (WebElement element : elements) {
//      listPropertySuggestion.add(element.getText().replaceAll("\n", ""));
//    }
//    return listPropertySuggestion;
//  }

}