package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pages.hotel.*;
import pages.hotel.coinLanding.*;
import pages.hotel.footer.travala.BuyGiftCardPage;
import pages.hotel.footer.travala.TravelCreditPage;
import pages.hotel.footer.travala.TravelGiftCardPage;
import pages.hotel.footer.useful.PaymentOptionsPage;
import pages.hotel.myProfile.MyTravelCreditsPage;

import java.text.DecimalFormat;

import static commons.CommonDataTravala.*;
import static commons.CommonsTravalaXpath.*;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.PropertyPageUI.BEST_PRICE_BOOK_NOW_FIRST;
import static interfaces.hotel.SearchPageUI.*;
import static interfaces.hotel.footer.useful.PaymentOptionsPageUI.*;

public class PaymentOptionSteps extends CommonHotelPages {
  WebDriver driver;
String getIconCoin = null;
  Double rateUs;
  Double rateCoinMarket = 5.37;
  ;
  Double rateExp;
  Double rateAct;
  private LandingPage landingPage;
  private String landingPageWindow;
  private CreditCardPage creditCardPage;
  private SwipePage swipePage;
  private CryptoPage cryptoPage;
  private TrustYouPage trustYouPage;
  private VnPayPage vnPayPage;
  private ETHPage ethPage;
  private XRPPage xrpPage;
  private USDTPage usdtPage;
  private BCHPage bchPage;
  private LTCPage ltcPage;
  private EOSPage eosPage;
  private BNBPage bnbPage;
  private LinkPage linkPage;
  private XMRPage xmrPage;
  private VETPage vetPage;
  private XLMPage xlmPage;
  private ADAPage adaPage;
  private TRXPage trxPage;
  private SXPPage sxpPage;
  private STPTPage stptPage;
  private USDCPage usdcPage;
  private DASHPage dashPage;
  private XEMPage xemPage;
  private BATPage batPage;
  private ZilPage zilPage;
  private BUSDPage busdPage;
  private PAXPage paxPage;
  private WAVESPage wavesPage;
  private XDCPage tusdPage;
  private ARKPage arkPage;
  private DAIPage daiPage;
  private NANOPage nanoPage;
  private DGBPage dgbPage;
  private KMDPage kmdPage;
  private XZCPage xzcPage;
  private GUSDPage gusdPage;
  private SearchPage searchPage;
  private PropertyPage propertyPage;
  private TravelCreditPage travelCreditPage;
  private TravelGiftCardPage travelGiftCardPage;
  private BuyGiftCardPage buyGiftCardPage;
  private CheckOutPage checkOutPage;
  private PaymentOptionsPage paymentOptionsPage;
  private HomePage homePage;
  private MyTravelCreditsPage myTravelCreditsPage;
  private FilPage filPage;
  private RegisterPage registerPage;


  public PaymentOptionSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    searchPage= new SearchPage(driver);
    propertyPage = new PropertyPage(driver);
    travelCreditPage = new TravelCreditPage(driver);
    travelGiftCardPage = new TravelGiftCardPage(driver);
    checkOutPage = new CheckOutPage(driver);
    paymentOptionsPage = new PaymentOptionsPage(driver);
    homePage = new HomePage(driver);
    myTravelCreditsPage = new MyTravelCreditsPage(driver);
    buyGiftCardPage = new BuyGiftCardPage(driver);
    linkPage = new LinkPage(driver);
    filPage = new FilPage(driver);
    registerPage = new RegisterPage(driver);
  }

  @And("^I click on Travel Credit and verify display \"([^\"]*)\" at payment by crypto$")
  public void iClickOnTravelCreditAndVerifyDisplayAtPaymentByCrypto(String coin) throws Throwable {
    homePage.clickToMyMyAccountLink();
    homePage.clickToMyTravelCreditsLink();
    inputAmount("100");
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    if (!verifyDisplayListCrypto(CRYPTO_COIN_NAME_LIST, LIST_CRYPTO_PAYMENT)) {
      System.out.println(coin + " at buy travel credit page is displayed wrong");
    } else {
      System.out.println(coin + " at buy travel credit page is displayed correct");
    }
  }

  @And("^I click on \"([^\"]*)\" link and verify text on this page$")
  public void iClickOnLinkAndVerifyTextOnThisPage(String coinName) throws Throwable {
    paymentOptionsPage.clickToCoinAtPaymentPage(coinName);
  }

  @When("^I get rate of \"([^\"]*)\" on the market cap page$")
  public void iGetRateOfOnTheMarketCapPage(String coin) throws Throwable {
//    rateCoinMarket=   checkRateCoin(coin);
    rateCoinMarket=0.9657;
  }

//  Travala.com’s intuitive booking experience is designed to be familiar and simple to navigate. Travelers simply choose their desired travel product(s), enter their details, and select from the variety of available payment options, including traditional credit and debit cards, BTC, and 40+ other cryptocurrencies.
//  Travala.com’s intuitive booking experience is designed to be familiar and simple to navigate. Travellers simply choose their desired travel product(s), enter their details, and select from the variety of available payment options, including traditional credit and debit cards, BTC, and 40+ other cryptocurrencies.

  @And("^I verify display currencies, search and rate of \"([^\"]*)\" list at header part$")
  public void iVerifyDisplayCurrenciesSearchAndRateOfListAtHeaderPart(String coin) throws Throwable {
    searchPage.searchRandomDestination();
    rateUs = Double.parseDouble(getTextElement(driver, SEARCH_RESULT_FIRST_PRICE));
    getIconCoin = verifySearchCoinHeader(coin);
    String getCoinSearch = getTextBySplit(getAttribute(driver, SEARCH_RESULT_ICON_FIRST_COIN, "src"), "logo/", 1);
    if (!StringUtils.contains(getCoinSearch, getIconCoin)) {
      System.out.println("act coin at search result: "+getCoinSearch);
      System.out.println("exp coin from header: "+getIconCoin);
      System.out.println("Display coin at search result wrong");
    }
    DecimalFormat df = new DecimalFormat("#.##");
    rateExp = Double.parseDouble(df.format(rateUs / rateCoinMarket));
    rateAct = Double.parseDouble(getTextElement(driver, SEARCH_RESULT_FIRST_PRICE).replaceAll(",", ""));
    if (rateAct > rateExp) {
      System.out.println("Rate of " + coin + " Market Cap is: " + rateExp);
      System.out.println("Rate of " + coin + " Travala is: " + rateAct);
      System.out.println("Rate of " + coin + " on Travala greater than on Market Cap: " + df.format(rateAct - rateExp));
    } else {
      System.out.println("Rate of " + coin + " Market Cap is: " + rateExp);
      System.out.println("Rate of " + coin + " Travala is: " + rateAct);
      System.out.println("Rate of " + coin + " on Travala less than on Market Cap: " + df.format(rateExp - rateAct));
    }
  }

  @And("^I verify display list crypto at checkout page and booking hotel by \"([^\"]*)\"$")
  public void iVerifyDisplayListCryptoAtCheckoutPageAndBookingHotelBy(String coin) throws Throwable {
    wait300Time();
    clickToElementByJavascript(driver, FIRST_PROPERTY);
    switchToWindowByUrlContainsString(driver, HOTEL_PROPERTY);
    clickToElementByJavascript(driver, BEST_PRICE_BOOK_NOW_FIRST);
    checkOutPage.verifyDisplayLogoCrypto(coin);
    checkOutPage.verifyPopUpCrypto(coin);
  }

  @When("^I click on payment options button and verify list token with \"([^\"]*)\" on that page$")
  public void iClickOnPaymentOptionsButtonAndVerifyListTokenWithOnThatPage(String coin) throws Throwable {
    registerPage.closeSignUpJourneyPopUp();
    scrollToBottomPage(driver);
    clickToElement(driver, PAYMENT_OPTION_BTN);
    switchToWindowByUrlContainsString(driver, PAYMENT_OPTIONS_PATH);
    wait2sTime();
    if (!verifyDisplayListCrypto(LIST_TOKEN, CURRENCY_PAYMENT_LANDING)) {
      System.out.println("List coin at payment landing page with " + coin + " wrong");
    } else {
      System.out.println("List coin at payment landing page with " + coin + " correct");
    }
    switchTab(driver);
  }

  @And("^I verify display \"([^\"]*)\" and AVA always in the first place on Currency Header$")
  public void iVerifyDisplayAndAVAAlwaysInTheFirstPlaceOnCurrencyHeader(String coin) {
    verifyListCurrencyHeader(coin);
  }

  @And("^I verify display \"([^\"]*)\" and list crypto and AVA at buy gift card$")
  public void iVerifyDisplayAndListCryptoAndAVAAtBuyGiftCard(String coin) {
    scrollToBottomPage(driver);
    clickToElementByJavascript(driver, GIFT_CARD_FOOTER_LINK);
    switchToOtherWindowbyUrl(driver, TRAVEL_GIFT_CARD_PATH);
    travelGiftCardPage.clickToBuyGiftCardLink();
    switchToOtherWindowbyUrl(driver, BUY_GIFT_CARD_PATH);
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    selectCoinFromCryptoOption(coin);
    clickBackToTravala(driver);
  }

  @And("^I verify display \"([^\"]*)\" and list crypto and AVA at travel credit$")
  public void iVerifyDisplayAndListCryptoAndAVAAtTravelCredit(String coin) {
    homePage.clickToMyTravelCreditsLink();
    wait1sTime();
    switchToOtherWindowbyUrl(driver, TRAVEL_CREDITS_PATH);
    clickToElementByJavascript(driver, CRYPTO_OPTION);
    selectCoinFromCryptoOption(coin);
    clickBackToTravala(driver);
  }
}
