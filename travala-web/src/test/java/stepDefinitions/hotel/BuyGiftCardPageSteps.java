package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.HomePage;
import pages.hotel.LandingPage;
import pages.hotel.footer.travala.BuyGiftCardPage;
import pages.hotel.footer.travala.TravelGiftCardPage;
import pages.hotel.footer.travala.TravelGiftCardTermPage;

public class BuyGiftCardPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private HomePage homePage;
  private TravelGiftCardPage travelGiftCardPage;
  private BuyGiftCardPage buyGiftCardPage;
  private String paymentPriceCrypto;
  private String firstName;
  private String nameRecipient;
  private String lastName;
  private String yopMail;
  private String amountGc;
  private LandingPage landingPage;
  private TravelGiftCardTermPage travelGiftCardTermPage;
  private String messageGift = "Huong88 Thank you so much for everything";

  //  @Before
  public BuyGiftCardPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    travelGiftCardPage = new TravelGiftCardPage(driver);
    buyGiftCardPage = new BuyGiftCardPage(driver);
    travelGiftCardTermPage = new TravelGiftCardTermPage(driver);
    switchToLanguage();
  }

  @And("^I verify text on Buy Gift Card page$")
  public void i_verify_text_on_buy_gift_card_page() {
    wait300Time();
    switchToLanguage();
    buyGiftCardPage.verifyTextBuyGCPage();
  }

  @And("^I input valid information to buy GC$")
  public void iInputValidInformationToBuyGC() {
    amountGc = randomNumber();
    inputAmount(amountGc);
    yopMail = randomYopMail();
    firstName = randomString();
    lastName = randomString();
    buyGiftCardPage.inputContactDetail(randomString(), randomString(), yopMail);
  }

  @And("^I verify text on this page when input invalid amount Gift Card$")
  public void i_verify_text_on_this_page_when_input_invalid_amount_gift_card() {
    buyGiftCardPage.verifyInputInvalidAmount();
  }

  @And("^I input invalid \"([^\"]*)\" to contact and verify text displayed$")
  public void i_input_invalid_something_to_contact_and_verify_text_displayed(String email) {
    buyGiftCardPage.verifyInputContactForm(email);
  }

  @And("^I input invalid \"([^\"]*)\" to Recipient and verify text displayed$")
  public void i_input_invalid_something_to_recipient_and_verify_text_displayed(String invalidEmail) {
    buyGiftCardPage.verifyInputRecipientForm(invalidEmail);
  }

  @And("^I input valid information Recipient person$")
  public void iInputValidInformationRecipientPerson() {
    nameRecipient = randomString();
    yopMail = randomYopMail();
    buyGiftCardPage.inputRecipient(nameRecipient, yopMail, messageGift);
  }

  @And("^I verify text at payment part in the buy gift card page$")
  public void iVerifyTextAtPaymentPartInTheBuyGiftCardPage() {
//    buyGiftCardPage.verifyTextPaymentGC();
    for (int i = 0; i<=500; i++) {
      openNewTab(driver, "https://travala-pr-162.herokuapp.com/buy-gift-cards/?AB_VARIATION_15371=1");
      buyGiftCardPage.verifyTextAtPurchaseGC();
    }

  }

  @And("^I verify buy gift card payment by Credit Card and verify content email$")
  public void iVerifyBuyGiftCardPaymentByCreditCardAndVerifyContentEmail() {
    buyGiftCardPage.verifyEmailBuyByCreditCard(yopMail);
  }

  @And("^I verify buy gift card to send as Gift payment by Credit Card and verify content email$")
  public void iVerifyBuyGiftCardToSendAsGiftPaymentByCreditCardAndVerifyContentEmail() {
    buyGiftCardPage.verifyEmailBuyByCreditCardSendAsGift(yopMail, messageGift);
  }

  @And("^I verify buy gift card when payment by Crypto$")
  public void iVerifyBuyGiftCardWhenPaymentByCrypto() {
    String coin = randomCrypto();
    buyGiftCardPage.verifyBuyGCByCrypto(coin, yopMail);
  }

  @And("^I verify buy gift card to send as Gift when payment by Crypto with \"([^\"]*)\"$")
  public void iVerifyBuyGiftCardToSendAsGiftWhenPaymentByCryptoWith(String coin) {
    buyGiftCardPage.verifyBuyGCSendAsGiftByCrypto(coin, yopMail, messageGift);
  }

  @And("^I verify buy gift card when payment by My Wallet$")
  public void iVerifyBuyGiftCardWhenPaymentByMyWallet() {
    String coinWallet = randomWallet();
    buyGiftCardPage.verifyEmailBuyByWallet(coinWallet, yopMail);
  }

  @And("^I verify buy gift card to send as Gift payment by My Wallet with \"([^\"]*)\" and verify content email$")
  public void iVerifyBuyGiftCardToSendAsGiftPaymentByMyWalletWithAndVerifyContentEmail(String coin) throws Throwable {
    buyGiftCardPage.verifyEmailBuyByWalletSendAsGift(coin, yopMail, messageGift);
  }

  @And("^I navigate to buy gift card page$")
  public void iNavigateToBuyGiftCardPage() {
    clickOnUrlToLinkBuyGC();
  }
}
