package pages.hotel;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.hotel.CommonHotelPages;
import pages.hotel.NFT.ActiveNFTPage;
import pages.hotel.NotFoundPage;
import pages.hotel.RegisterPage;
import pages.hotel.SearchPage;
import pages.hotel.footer.travala.*;
import pages.hotel.footer.community.*;
import pages.hotel.footer.resources.*;
import pages.hotel.footer.support.*;
import pages.hotel.footer.useful.*;

import java.util.ArrayList;
import java.util.List;

import static commons.CommonDataTravala.CURRENCY_PAYMENT_LANDING;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.SearchPageUI.COUNT_RESULTS_HOTEL;
import static interfaces.hotel.footer.useful.PaymentOptionsPageUI.LIST_TOKEN;

public class LandingPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;
  boolean check = true;
  private CountryPage countryPage;
  private SearchPage searchPage;
  private AboutUsPage aboutUsPage;
  private AvaTokenPage avaTokenPage;
  private SmartProgramPage smartProgramPage;
  private SmartTermPage smartTermPage;
  private InviteProgramPage inviteProgramPage;
  private InviteTermPage inviteTermPage;
  private PriceGuaranteePage priceGuaranteePage;
  private AffiliateProgramPage affiliateProgramPage;
  private TravelCreditPage travelCreditPage;
  private TravelGiftCardPage travelGiftCardPage;
  private TravelMemberPage travelMemberPage;
  private HelpCenterPage helpCenterPage;
  private MyTripPage myTripPage;
  private TermsConditionsPage termsConditionsPage;
  private PrivacyPolicyPage privacyPolicyPage;
  private CookiePolicyPage cookiePolicyPage;
  private ContactUsPage contactUsPage;
  private MobileAppsPage mobileAppsPage;
  private BusinessTravelPage businessTravelPage;
  private PaymentOptionsPage paymentOptionsPage;
  private BinaceTravelPage binaceTravelPage;
  private BuyCryptoPage buyCryptoPage;
  private PartnerNetworkPage partnerNetworkPage;
  private BugReportPage bugReportPage;
  private SiteMapPage siteMapPage;
  private OfficalBlogPage officalBlogPage;
  private TravelAdvicesPage travelAdvicesPage;
  private TravelGuidesPage travelGuidesPage;
  private ReadReviewsPage readReviewsPage;
  private OurPartnersPage ourPartnersPage;
  private TwitterPage twitterPage;
  private FacebookPage facebookPage;
  private TelegramPage telegramPage;
  private InstagramPage instagramPage;
  private LinkedinPage linkedinPage;
  private CoinListPage coinListPage;
  private CareersPage careersPage;
  private RegisterPage loginPage;
  private ConciergePage conciergePage;
  private MediaPage mediaPage;
  private PartnershipPage partnershipPage;
  private TravelGiftCardTermPage travelGiftCardTermPage;

  public LandingPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void clickOnLinkHeaderNotLogin() {
    String[] content = {"LANDING_HEADER_ACTIVATE", "LANDING_HEADER_EXPLORE", "LANDING_HEADER_MY_TRIP", "LANDING_HEADER_VOTE", "LANDING_HEADER_LOGIN", "LANDING_HEADER_SIGN_UP"};
    String[] xpath = {HEADER_ACTIVATE_NFT_URL, HEADER_EXPLORE_NFT_URL, HEADER_MY_TRIP_URL, HEADER_GOVERNANCE_URL, LOGIN_ICON_HEADER, HEADER_SIGN_UP_URL};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Item is displayed on Header when not Login wrong!");
    } else {
      System.out.println("Item is displayed on Header when not Login correct!");
    }
    clickToElementByJavascript(driver, HEADER_ACTIVATE_NFT_URL);
    wait1sTime();
    if (!StringUtils.contains(getCurrentUrl(driver), LOGIN_PATH)) {
      System.out.println("Current URL: " + getCurrentUrl(driver));
      System.out.println("Display after click on Activate NFT when Not Login wrong ");
    }
    clickBackToTravala(driver);
    clickToElementByJavascript(driver, HEADER_EXPLORE_NFT_URL);
    wait100Time();
    if (!StringUtils.contains(getCurrentUrl(driver), NFT_PATH)) {
      System.out.println("Current URL: " + getCurrentUrl(driver));
      System.out.println("Display after click on Explore NFT link on header wrong ");
    }
    backToPreviousPage(driver);
    clickToElementByJavascript(driver, HEADER_GOVERNANCE_URL);
    wait1sTime();
    if (!StringUtils.contains(getCurrentUrl(driver), GOVERNANCE_PATH)) {
      System.out.println("Current URL: " + getCurrentUrl(driver));
      System.out.println("Display after click on Governance link on header wrong ");
    }
    clickBackToTravala(driver);
    clickToElementByJavascript(driver, HEADER_SIGN_UP_URL);
    wait300Time();
    if (!StringUtils.contains(getCurrentUrl(driver), REGISTER_PATH)) {
      System.out.println("Current URL: " + getCurrentUrl(driver));
      System.out.println("Display after click on Register link on header wrong ");
    }
    clickBackToTravala(driver);
  }

  public void clickOnLinkHeaderLogin() {
    String[] content = {"LANDING_HEADER_ACTIVATE", "LANDING_HEADER_EXPLORE", "LANDING_HEADER_VOTE"};
    String[] xpath = {HEADER_ACTIVATE_NFT_URL, HEADER_EXPLORE_NFT_URL, HEADER_GOVERNANCE_URL};
    if (!(verifyTwoListByKey(content, xpath) && checkShowElement(driver, HEADER_WALLET_URL) != 0 && checkShowElement(driver, HEADER_AVATAR) != 0)) {
      System.out.println("Item is displayed on Header when Login wrong!");
    } else {
      System.out.println("Item is displayed on Header when Login correct!");
    }
    clickToElementByJavascript(driver, HEADER_ACTIVATE_NFT_URL);
    wait1sTime();
    if (!StringUtils.contains(getCurrentUrl(driver), SMART_PROGRAM_PATH)) {
      System.out.println("Current _ACTIVATE NFT URL: " + getCurrentUrl(driver));
      System.out.println("Display after click on Activate NFT when Login wrong ");
    }
  }

  public void verifyDisplayUrlHeader() {
    if (checkShowElement(driver, LOGIN_ICON_HEADER) != 0) {
      clickOnLinkHeaderNotLogin();
    } else {
      clickOnLinkHeaderLogin();
    }
  }

  public Object clickToFourBenefit(String benefit) {
    boolean b = true;
    boolean b1 = true;
    boolean b2 = true;
    boolean b3 = true;
    clickToElementByJavascript(driver, String.format(LANDING_FOUR_BENEFIT_DYNAMIC, benefit));
    switch (benefit) {
      case "1":
        switchToOtherWindowbyUrl(driver, LANDING_CUSTOMER_SUPPORT_TEXT);
        if (!StringUtils.contains(getCurrentUrl(driver), HELP_CENTER_PATH)) {
          System.out.println("Navigate to customer support wrong!");
          b = false;
        }
        switchTab(driver);
        break;
      case "2":
        wait2sTime();
        switchToOtherWindowbyUrl(driver, PRICE_GUARANTEE_URL);
        if (!StringUtils.contains(getCurrentUrl(driver), PRICE_GUARANTEE_PATH)) {
          System.out.println("Navigate to Best Price Guarantee wrong!");
          b1 = false;
        }
        switchTab(driver);
        break;
      case "3":
        wait1sTime();
        switchToOtherWindowbyUrl(driver, PAYMENT_OPTION_URL);
        if (!StringUtils.contains(getCurrentUrl(driver), PAYMENT_OPTIONS_PATH)) {
          System.out.println("Navigate to Multi-Payment Options wrong!");
          b2 = false;
        }
        switchTab(driver);
        break;
      case "4":
        wait2sTime();
        switchToOtherWindowbyUrl(driver, SMART_PROGRAM_URL);
        if (!StringUtils.contains(getCurrentUrl(driver), SMART_PROGRAM_PATH)) {
          System.out.println("Navigate to Real Value Rewards wrong!");
          b3 = false;
        }
        switchTab(driver);
        break;
      default:
        System.out.println("Please select another benefit ");
        if (!(b && b1 && b2 && b3)) {
          System.out.println("Link to 4 Options at Landing page correct");
        }
        return new Object();
    }
    return new Object();
  }

  public void verifyTitle3Part() {
    String[] content = {"LANDING_CUSTOMER_REVIEW_TITLE", "LANDING_CHOOSE_YOUR", "LANDING_DISCOVER"};
    if (!compareTwoListByKey(content, LANDING_SECTION_LIST)) {
      System.out.println("Text section title at landing page wrong");
    } else {
      System.out.println("Text section title at landing page correct");
    }
  }

  public void verifyDisplayCampaignPart() {
    String[] content = {"FIRST_CAMPAIGN_TITLE", "BANNER_NFT_TITLE", "VOTE_LEARN_MORE"};
    String[] xpath = {CAMPAIGN_FIRST_TITLE, NFT_BANNER_TITLE, NFT_BANNER_LEARN_MORE};
    if (!verifyTwoListByKey(content, xpath)) {
      System.out.println("Text at Banner Campaign Part of Landing page wrong");
    }
    clickToElementByJavascript(driver, CAMPAIGN_FIRST_TITLE);
    wait300Time();
    if (!StringUtils.contains(getCurrentUrl(driver), NFT_PATH)) {
      System.out.println("Link to Campaign Give Away Page Actual: " + getCurrentUrl(driver));
      System.out.println("Link to Campaign Give Away Page Expect: " + NFT_PATH);
    }
    backToPreviousPage(driver);
    clickToElementByJavascript(driver, NFT_BANNER_LEARN_MORE);
    wait300Time();
    if (!StringUtils.contains(getCurrentUrl(driver), NFT_PATH)) {
      System.out.println("Link to NFT Page Actual: " + getCurrentUrl(driver));
      System.out.println("Link to NFT Page Expect: " + NFT_PATH);
    }
    backToPreviousPage(driver);
  }

  public boolean verifySearchErrorMyTrip() {
    clickToElement(driver, LANDING_MY_TRIP_SEARCH);
    boolean b = verifyTextByKey("LANDING_MY_TRIP_ERROR_ORDER", LANDING_MY_TRIP_ERROR_ORDER);
    boolean b1 = verifyTextByKey("LANDING_MY_TRIP_ERROR_ORDER", LANDING_MY_TRIP_ERROR_LAST_NAME);
    if (!b && !b1) {
      System.out.println("EXPECT=" + getTextFromReadFile("LANDING_MY_TRIP_ERROR_ORDER"));
      System.out.println("ACTUAL ORDER=" + getTextElement(driver, LANDING_MY_TRIP_ERROR_LAST_NAME));
      System.out.println("ACTUAL LAST_NAME=" + getTextElement(driver, LANDING_MY_TRIP_ERROR_LAST_NAME));
      System.out.println("=============================================================");
      check = false;
    }
    return check;
  }

  public boolean verifyTextFormMyTrip() {
    boolean hotel = verifyTextByKey("LANDING_MY_TRIP_LIST_HOTEL", LANDING_MY_TRIP_LIST_HOTEL);
    String[] domain = {"LANDING_MY_TRIP_LIST_ACTIVITIES", "LANDING_MY_TRIP_LIST_FLIGHT"};
    boolean listDomain = verifyListItemByListExpect(domain, LANDING_MY_TRIP_LIST_DOMAIN, LANDING_MY_TRIP_DYNAMIC_DOMAIN);
    String[] content = {"LANDING_MY_TRIP_ORDER_NUMBER_LABEL", "LANDING_MY_TRIP_LAST_NAME_LABEL", "LANDING_MY_TRIP_SEARCH"};
    String[] xpath = {LANDING_MY_TRIP_ORDER_NUMBER_LABEL, LANDING_MY_TRIP_LAST_NAME_LABEL, LANDING_MY_TRIP_SEARCH};
    return verifyTwoListByKey(content, xpath) && hotel && listDomain;
  }


  //==========================TOP COUNTRIES===============================================
  public CountryPage clickSearchCountryBtn(String searchTxt) {
    clickToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST);
    System.out.println(searchTxt);
    sendkeysToElement(driver, SEARCH_HOTEL_TEXTBOX_FIRST, searchTxt);
//    WebElement search = driver.findElement(By.xpath(SEARCH_HOTEL_TEXTBOX_COUNTRY));
//    search.sendKeys(searchTxt);

//    WebElement searchCountry = driver.findElement(By.xpath(SELECT_BOX_COUNTRY));
    wait200Time();
//    searchCountry.click();
    clickToElementByJavascript(driver, SEARCH_HOTEL_TEXTBOX_COUNTRY);
    clickSearchHotelBtn(driver);
    return new CountryPage(driver);
  }

  public void clickToCountryPage(String country) {
    clickToElementByJavascript(driver, String.format(TOP_COUNTRY_DYNAMIC, country));
    switch (country) {
      case "Japan":
        switchToWindowByUrlContainsString(driver, "japan");
        wait100Time();
        countryPage.verifyTextCountry("Japan");
        switchTab(driver);
        break;
      case "Indonesia":
        switchToWindowByUrlContainsString(driver, "indonesia");
        wait100Time();
        countryPage.verifyTextCountry("Indonesia");
        switchTab(driver);
        break;
      case "Thailand":
        switchToWindowByUrlContainsString(driver, "thailand");
        wait100Time();
        countryPage.verifyTextCountry("Thailand");
        switchTab(driver);
        break;
      case "Singapore":
        switchToWindowByUrlContainsString(driver, "singapore");
        wait100Time();
//        countryPage.verifyTextCountry("Singapore");
        switchTab(driver);
        break;
      default:
        System.out.println("Please select another language ");
        new Object();
        break;
    }
  }

  public void clickToSearchAndVerifySearchPage() {
    clickSearchHotelBtn(driver);
    waitFoElementVisible(driver, COUNT_RESULTS_HOTEL);
    searchPage= new SearchPage(driver);
    searchPage.verifyDisplayResultSearchPage(400);
    clickBackToTravala(driver);
  }

  public Object clickToDestination(String destination) {
    clickToElementByJavascript(driver, String.format(DESTINATION_DYNAMIC, destination));
    switch (destination) {
      case "Hanoi":
        wait1sTime();
        clickToSearchAndVerifySearchPage();
        break;
      case "Ha Long Bay":
        break;
      case "Ho Chi Minh City":
        wait300Time();
        clickToSearchAndVerifySearchPage();
        break;
      case "Da Nang":
        System.out.println("Da Nang");
        clickToSearchAndVerifySearchPage();
        break;
      case "Phu Quoc Island":
        System.out.println("Phu Quoc");
        clickToSearchAndVerifySearchPage();
        break;
      case "Nha Trang ":
        System.out.println("Nha Trang");
        clickToSearchAndVerifySearchPage();
        break;
      case "Da Lat ":
        System.out.println("Da Lat");
        clickToSearchAndVerifySearchPage();
        break;
      case "Vung Tau   ":
        System.out.println("Vung Tau");
        clickToSearchAndVerifySearchPage();
        break;
      case "Mui Ne":
        System.out.println("Mui Ne");
        clickToSearchAndVerifySearchPage();
        break;
      case "Hoi An ":
        System.out.println("Hoi An");
        clickToSearchAndVerifySearchPage();
        break;
      case "Ninh Binh ":
        System.out.println("Ninh Binh");
        clickToSearchAndVerifySearchPage();
        break;
      case "Sapa":
        System.out.println("Sapa");
        clickToSearchAndVerifySearchPage();
        break;
      default:
        System.out.println("Please select another destination ");
        break;
    }
    return new Object();
  }

  public void verifyDestination() {
    String[] listDestinationExpect = {"LANDING_DESTINATION1", "LANDING_DESTINATION2", "LANDING_DESTINATION3", "LANDING_DESTINATION4", "LANDING_DESTINATION5",
      "LANDING_DESTINATION6", "LANDING_DESTINATION7", "LANDING_DESTINATION8", "LANDING_DESTINATION9", "LANDING_DESTINATION10", "LANDING_DESTINATION11", "LANDING_DESTINATION12"};
    List<String> listActual = new ArrayList<>();
    List<WebElement> listDestinationActual = driver.findElements(By.xpath(LANDING_DESTINATION_LIST));
    for (WebElement e : listDestinationActual) {
      listActual.add(e.getAttribute("alt"));
    }
    if (verifyTwoList(listActual, addListExpectByKey(listDestinationExpect))) {
      System.out.println("Correct");
    } else {
      System.out.println("wrong");
    }
  }

  public boolean verifyDestinationTextHold() {
//    boolean check1 = true;
    String[] destination = {"LANDING_DESTINATION1", "LANDING_DESTINATION2", "LANDING_DESTINATION3", "LANDING_DESTINATION4", "LANDING_DESTINATION5", "LANDING_DESTINATION6",
      "LANDING_DESTINATION7", "LANDING_DESTINATION8", "LANDING_DESTINATION9", "LANDING_DESTINATION10", "LANDING_DESTINATION11", "LANDING_DESTINATION12"};
    List<WebElement> elements = driver.findElements(By.xpath(LANDING_DESTINATION_LIST));
    int i = 1;
    boolean b = true;
    while (i <= elements.size()) {
      String xpath = String.format(LANDING_DESTINATION_DYNAMIC, i);
      System.out.println("xpath: " + xpath);
      String destinationAct = getTextElement(driver, xpath);
      System.out.println("destination: " + destinationAct);
//      for (String des : destination) {
//        if (StringUtils.contains(des, destinationAct)) {
//          System.out.println(destinationAct);
//          b = false;
//        }
//      }
      i++;
    }
//    if(!b){
//      System.out.println("Destination wrong!");
//    }else {
//      System.out.println("Destination correct!");
//    }
//       if(StringUtils.contains(destinationAct,destination[i])){
//
//       }
//      for (String des : listDestinationActual) {
//        listActual.add(e.getAttribute("innerText"));
//      }

//    WebElement destinationFirst = driver.findElement(By.xpath(LANDING_DESTINATION_FIRST));
//    new Actions(driver).moveToElement(destinationFirst).build().perform();
////    destinationFirst.click();
//    boolean startPriceFirst = verifyTextByKey("LANDING_DESTINATION_STARTING_PRICE", LANDING_DESTINATION_STARTING_PRICE_FIRST);
//    boolean searchPropertyFirst = verifyTextByKey("LANDING_DESTINATION_SEARCH_PROPERTY", LANDING_DESTINATION_SEARCH_PROPERTY_FIRST);
//    if (startPriceFirst && searchPropertyFirst) {
//      check = true;
//    } else {
//      System.out.println("EXPECT startPriceFirst=" + getTextFromReadFile("LANDING_DESTINATION_STARTING_PRICE"));
//      System.out.println("ACTUAL startPriceFirst=" + getTextElement(driver, LANDING_DESTINATION_STARTING_PRICE_FIRST));
//      System.out.println("EXPECT searchPropertyFirst=" + getTextFromReadFile("LANDING_DESTINATION_SEARCH_PROPERTY"));
//      System.out.println("ACTUAL searchPropertyFirst=" + getTextElement(driver, LANDING_DESTINATION_SEARCH_PROPERTY_FIRST));
//      System.out.println("=============================================================");
//      check = false;
//    }
//    WebElement destinationLast = driver.findElement(By.xpath(LANDING_DESTINATION_LAST));
//    new Actions(driver).moveToElement(destinationLast).build().perform();
//    boolean startPriceLast = StringUtils.contains(getTextElement(driver, LANDING_DESTINATION_STARTING_PRICE_LAST), getTextFromReadFile("LANDING_DESTINATION_STARTING_PRICE"));
//    boolean searchPropertyLast =verifyTextByKey("LANDING_DESTINATION_SEARCH_PROPERTY",LANDING_DESTINATION_SEARCH_PROPERTY_LAST) ;
//
//    if (startPriceLast && searchPropertyLast) {
//      check1 = true;
//    } else {
//      System.out.println("EXPECT startPriceLast=" + getTextFromReadFile("LANDING_DESTINATION_STARTING_PRICE"));
//      System.out.println("ACTUAL startPriceLast=" + getTextElement(driver, LANDING_DESTINATION_STARTING_PRICE_LAST));
//      System.out.println("EXPECT searchPropertyLast=" + getTextFromReadFile("LANDING_DESTINATION_SEARCH_PROPERTY"));
//      System.out.println("ACTUAL searchPropertyLast=" + getTextElement(driver, LANDING_DESTINATION_SEARCH_PROPERTY_LAST));
//      System.out.println("=============================================================");
//      check1 = false;
//    }
    return b;
  }

  public void verifyDisplayTopCountryTxt() {
    wait1sTime();
    scrollToBottomPage(driver);
    List<WebElement> listTopCountry = driver.findElements(By.xpath(TOP_COUNTRY_LIST));
    if (listTopCountry.size() != 4) {
      System.out.println("Display top country at Landing page wrong");
    }
    clickToCountryPage("Singapore");
  }

  //==========================FOOTER PAGE===============================================

  public Object clickToTravalaColumn(String option) {
    scrollToBottomPage(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, option);
    switch (option) {
      case ABOUT_US_PATH:
        aboutUsPage = new AboutUsPage(driver);
        switchToOtherWindowbyUrl(driver, ABOUT_US_URL);
        aboutUsPage.verifyTextAtAboutPage();
        switchTab(driver);
        break;
      case AVA_TOKEN_PATH:
        avaTokenPage = new AvaTokenPage(driver);
        switchToOtherWindowbyUrl(driver, AVA_TOKEN_URL);
        avaTokenPage.verifyAVATokenPage("AVA");
        switchTab(driver);
        break;
      case INVITE_PATH:
        inviteProgramPage = new InviteProgramPage(driver);
        switchToOtherWindowbyUrl(driver, INVITE_URL);
        wait1sTime();
        inviteProgramPage.verifyTextInvite();
        switchTab(driver);
        break;
      case AFFILIATE_PROGRAM_PATH:
        affiliateProgramPage = new AffiliateProgramPage(driver);
        switchToOtherWindowbyUrl(driver, AFFILIATE_PROGRAM_URL);
        if (affiliateProgramPage.verifyContentTextAffiliateProgramePage()) {
          System.out.println("Content Affiliate Program page correct");
        }
        switchTab(driver);
        break;
      case SMART_PROGRAM_PATH:
        switchToOtherWindowbyUrl(driver, SMART_PROGRAM_URL);
        clickToElementByJavascript(driver, SMART_PROGRAM_LINK_FOOTER);
        smartProgramPage = new SmartProgramPage(driver);
        smartProgramPage.verifyTextLandingSmart();
//        smartProgramPage.clickSmartBtn();
        switchTab(driver);
        break;
      case TRAVEL_CREDITS_PATH:
        travelCreditPage = new TravelCreditPage(driver);
        switchToOtherWindowbyUrl(driver, TRAVEL_CREDITS_URL);
        wait100Time();
        if (travelCreditPage.verifyTextTravelCredits()) {
          System.out.println("Content Travel Credit page correct");
        }
        switchTab(driver);
        break;
      case TRAVEL_GIFT_CARD_PATH:
        travelGiftCardPage = new TravelGiftCardPage(driver);
        switchToOtherWindowbyUrl(driver, TRAVEL_GIFT_CARD_URL);
        if (travelGiftCardPage.verifyTravelGiftCardPage()) {
          System.out.println("Content Travel Gift Card page correct");
        }
        switchTab(driver);
        break;
      case TRAVEL_MEMBER_PATH:
        travelMemberPage = new TravelMemberPage(driver);
        switchToOtherWindowbyUrl(driver, TRAVEL_MEMBER_URL);
        if (travelMemberPage.verifyMemberBenefits()) {
          System.out.println("Content Travel Member Page correct");
        }
        switchTab(driver);
        break;
      case PRICE_GUARANTEE_PATH:
        priceGuaranteePage = new PriceGuaranteePage(driver);
        switchToOtherWindowbyUrl(driver, PRICE_GUARANTEE_URL);
        if (priceGuaranteePage.verifyPriceGuarantee()) {
          System.out.println("Content Best Price Guarantee page correct");
        }
        switchTab(driver);
        break;
      default:
        System.out.println("Please select other page on Travala");
        return new Object();
    }
    return new Object();
  }

  public Object clickToSupportColumn(String option) {
    scrollToBottomPage(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, option);
    switch (option) {
      case TERMS_CONDITIONS_PATH:
        termsConditionsPage = new TermsConditionsPage(driver);
        switchToOtherWindowbyUrl(driver, TERMS_CONDITIONS_URL);
        if (termsConditionsPage.verifyContent()) {
          System.out.println("Term Condition correct");
        }
        switchTab(driver);
        break;
      case PRIVACY_POLICY_PATH:
        switchToOtherWindowbyUrl(driver, PRIVACY_POLICY_URL);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        privacyPolicyPage.verifyContentPage();
        switchTab(driver);
        break;
      case COOKIE_POLICY_PATH:
        cookiePolicyPage = new CookiePolicyPage(driver);
        switchToOtherWindowbyUrl(driver, COOKIE_POLICY_URL);
        if (cookiePolicyPage.getCookiePolicyText()) {
          System.out.println("Cookie Policy page correct");
        }
        switchTab(driver);
        break;
      case CONTACT_US_PATH:
        contactUsPage = new ContactUsPage(driver);
        switchToOtherWindowbyUrl(driver, CONTACT_US_URL);
        contactUsPage.verifyEmptyContent();
        if (contactUsPage.verifyContactUs()) {
          System.out.println(" Contact Us page correct");
        }
        switchTab(driver);
        break;
      case MEDIA_PATH:
        mediaPage = new MediaPage(driver);
        switchToOtherWindowbyUrl(driver, MEDIA_URL);
        mediaPage.verifyTextMedia();
        switchTab(driver);
        break;
      case PARTNER_SHIP_PATH:
        partnershipPage = new PartnershipPage(driver);
        switchToOtherWindowbyUrl(driver, PARTNER_SHIP_URL);
        if (partnershipPage.verifyTextPartnerShip()) {
          System.out.println(" Partner Ship Page correct");
        }
        switchTab(driver);
        break;
      case CONCIERGE:
//        conciergePage = new ConciergePage(driver);
//        switchToOtherWindowbyUrl(driver, CONCIERGE_URL);
//        if (conciergePage.verifyMenuBanner() && conciergePage.verifyTextHomeConierge()) {
//          System.out.println("Text on Concierge Page is displayed correct");
//        }
//        switchTab(driver);
        break;
      default:
        System.out.println("Please select another option at Support ");
        return new Object();
    }
    return new Object();
  }

  public Object clickToUsefulColumn(String option) {
    scrollToLoadMore(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, option);
    switch (option) {
      case MOBILE_APP_PATH:
        switchToOtherWindowbyUrl(driver, MOBILE_APP_URL);
        switchTab(driver);
        break;
      case BUSINESS_TRAVEL_PATH:
        switchToOtherWindowbyUrl(driver, BUSINESS_TRAVEL_URL);
        switchTab(driver);
        break;
      case PAYMENT_OPTIONS_PATH:
        switchToOtherWindowbyUrl(driver, PAYMENT_OPTIONS_URL);
        paymentOptionsPage = new PaymentOptionsPage(driver);
        switchToWindowByUrlContainsString(driver, PAYMENT_OPTIONS_PATH);
        if (paymentOptionsPage.verifyTextOnThisPage() && verifyDisplayListCrypto(LIST_TOKEN, CURRENCY_PAYMENT_LANDING)) {
          System.out.println("Text on Payment Options page is displayed correct");
        }
        switchTab(driver);
        break;
      case BINANCE_TRAVEL_PATH:
        BinaceTravelPage binaceTravelPage = new BinaceTravelPage(driver);
        switchToOtherWindowbyUrl(driver, BINANCE_TRAVEL_URL);
        binaceTravelPage.verifyBannerBinanceTravel();
        binaceTravelPage.verifyNorthAmerica();
        binaceTravelPage.verifyStartPrice();
        binaceTravelPage.verifyTopCountryBinance();
        switchTab(driver);
        break;
      case BUY_CRYPTO_PATH:
        switchToOtherWindowbyUrl(driver, BUY_CRYPTO_URL);
        switchTab(driver);
        break;
      case PARTNER_NETWORK_URL:
        switchToOtherWindowbyUrl(driver, PARTNER_NETWORK_URL);
        switchTab(driver);
        break;
      case BUG_REPORT_URL:
        switchToOtherWindowbyUrl(driver, BUG_REPORT_URL);
        switchTab(driver);
        break;
      case SITEMAP:
        switchToOtherWindowbyUrl(driver, SITEMAP_URL);
        switchTab(driver);
        break;
      case ACTIVE_NFT:
        switchToOtherWindowbyUrl(driver, ACTIVE_NFT_URL);
        ActiveNFTPage activeNFTPage = new ActiveNFTPage(driver);
        switchToLanguage();
        activeNFTPage.verifyTextOnThePage();
        switchTab(driver);
        break;
      default:
        System.out.println("Please select other useful ");
        return new Object();
    }
    return new Object();
  }

  public Object clickToResourcesColumn(String option) {
    scrollToLoadMore(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, option);
    switch (option) {
      case OFFICAL_BLOG_URL:
        switchToOtherWindowbyUrl(driver, OFFICAL_BLOG_URL);
        switchTab(driver);
        break;
      case TRAVEL_ADVICES_URL:
        switchToOtherWindowbyUrl(driver, TRAVEL_ADVICES_URL);
        switchTab(driver);
        break;
      case TRAVEL_GUIDES_URL:
        switchToOtherWindowbyUrl(driver, TRAVEL_GUIDES_URL);
        switchTab(driver);
        break;
      case TRUST_PILOT_URL:
        switchToOtherWindowbyUrl(driver, TRUST_PILOT_URL);
        switchTab(driver);
        break;
      case OUR_PARTNER_URL:
        switchToOtherWindowbyUrl(driver, OUR_PARTNER_URL);
        switchTab(driver);
        break;
      case COIN_LIST_PATH:
        coinListPage = new CoinListPage(driver);
        switchToOtherWindowbyUrl(driver, COIN_LIST_URL);
        if (coinListPage.verifyTextCoinListing()) {
          System.out.println("COIN LISTING page correct");
        } else {
          System.out.println("COIN LISTING page wrong");
        }
        switchTab(driver);
        break;
      case CAREERS_PATH:
        careersPage = new CareersPage(driver);
        switchToOtherWindowbyUrl(driver, CAREERS_URL);
        careersPage.verifyTextCareers();
        switchTab(driver);
        break;
      default:
        System.out.println("Please select other resources ");
        return new Object();
    }
    return new Object();
  }

  public Object clickToCommunityColumn(String option) {
    scrollToLoadMore(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, option);
    wait1sTime();
    switch (option) {
      case TWITTER_URL:
        switchToOtherWindowbyUrl(driver, TWITTER_URL);
        switchTab(driver);
        break;
      case FACEBOOK_URL:
        switchToOtherWindowbyUrl(driver, FACEBOOK_URL);
        switchTab(driver);
        break;
      case TELEGRAM_URL:
        switchToOtherWindowbyUrl(driver, TELEGRAM_URL);
        switchTab(driver);
        break;
      case LINKEDIN_URL:
        linkedinPage = new LinkedinPage(driver);
        switchToOtherWindowbyUrl(driver, LINKEDIN_URL);
        switchTab(driver);
        break;
      case REDDIT_URL:
        switchToOtherWindowbyUrl(driver, REDDIT_URL);
        switchTab(driver);
        break;
      case INSTAGRAM_URL:
        switchToOtherWindowbyUrl(driver, INSTAGRAM_URL);
        switchTab(driver);
        break;
      default:
        System.out.println("Please select other Community");
        return new Object();
    }
    return new Object();
  }

  public NotFoundPage openNewTab() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    wait1sTime();
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get(TRAVALA_404_PAGE);
//    driver.navigate().to(TRAVALA_404_PAGE);
    return new NotFoundPage(driver);
  }




  //  public void verifyListCoinHeader() {
//    clickToElementByJavascript(driver, LANDING_CURRENCY);
//    String[] title = {"LANDING_CURRENCY_FIAT", "LANDING_CURRENCY_CRYPTO"};
//    boolean b = verifyListItemByListExpect(title, LANDING_CURRENCY_FIAT_LIST, LANDING_CURRENCY_FIAT_DYNAMIC);
//    if (!b) {
//      System.out.println("Text at currency popup wrong");
//    }
//    System.out.println("Total Fiat is: " + checkShowElement(driver, LANDING_FIAT_LIST));
//    System.out.println("Total Crypto is: " + checkShowElement(driver, LANDING_CRYPTO_LIST));
//    if (! verifyDisplayCrypto(LANDING_CURRENCY_LIST,LIST_CURRENCY_EXPECT )) {
//      System.out.println("List currency at landing page is displayed wrong");
//    } else {
//      System.out.println("List currency at landing page is displayed correct");
//    }
//    clickToElement(driver, LANDING_CURRENCY_CLOSE_BTN);
//  }
  public void registerAcc() {
    String[] exp = {"thuhuong961@yopmail.com"
      , "thuhuong469@yopmail.com"
      , "thuhuong111@yopmail.com"
      , "thuhuong297@yopmail.com"
      , "thuhuong275@yopmail.com"
      , "thuhuong228@yopmail.com"
      , "thuhuong972@yopmail.com"
      , "thuhuong744@yopmail.com"
      , "thuhuong393@yopmail.com"
      , "thuhuong341@yopmail.com"};
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < exp.length; i++) {
      expect.add(exp[i].trim());
    }
    openNewTab(driver, "https://staging2.travala.com/register");
    for (String email : expect
    ) {
      sendkeysToElement(driver, FIRST_NAME_TXT, randomString());
      sendkeysToElement(driver, LAST_NAME_TXT, randomString());
      sendkeysToElement(driver, REGISTER_EMAIL_TXT, email);
      sendkeysToElement(driver, CREATE_PASSWORD_TXT, "12345678");
      sendkeysToElement(driver, CONFIRM_PASSWORD_TXT, "12345678");
      clickToElementByJavascript(driver, REGISTER_BTN);
      reloadPage(driver);
    }
  }

}
