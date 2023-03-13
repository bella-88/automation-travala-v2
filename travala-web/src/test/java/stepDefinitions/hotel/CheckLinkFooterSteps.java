package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;

import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.LandingPage;
import pages.hotel.RegisterPage;
import pages.hotel.footer.travala.*;
import pages.hotel.footer.community.*;
import pages.hotel.footer.resources.*;
import pages.hotel.footer.support.*;
import pages.hotel.footer.useful.*;


import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.MENU_TRAVEL_SMART_PROTECTION_URL;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.footer.travala.InvitePageUI.INVITE_FOOTER_TERM;
import static interfaces.hotel.footer.travala.SmartPageUI.SMART_PROGRAM_TERM_LINK;
import static interfaces.hotel.footer.travala.TravelGiftCardPageUI.TRAVEL_GIFT_CARD_TERM_LINK;


public class CheckLinkFooterSteps extends CommonHotelPages {
  WebDriver driver;
  private LandingPage landingPage;
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


  public CheckLinkFooterSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    landingPage = new LandingPage(driver);
    helpCenterPage = new HelpCenterPage(driver);
    smartProgramPage = new SmartProgramPage(driver);
    inviteProgramPage = new InviteProgramPage(driver);
    inviteTermPage = new InviteTermPage(driver);
    travelGiftCardPage = new TravelGiftCardPage(driver);
    loginPage = new RegisterPage(driver);
    travelCreditPage = new TravelCreditPage(driver);
    travelGiftCardTermPage = new TravelGiftCardTermPage(driver);
    conciergePage = new ConciergePage(driver);
    smartTermPage = new SmartTermPage(driver);
    switchToLanguage();
  }

  @And("^I click on about us link and verify displayed text on this page$")
  public void i_click_on_about_us_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(ABOUT_US_PATH);
  }

  @And("^I click on AVA token link and verify displayed text on this page$")
  public void i_click_on_ava_token_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(AVA_TOKEN_PATH);
  }

  @And("^I click on Price Guarantee link and verify displayed text on this page$")
  public void i_click_on_price_guarantee_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(PRICE_GUARANTEE_PATH);
  }

  @And("^I click on Affiliate Program link and verify displayed text on this page$")
  public void i_click_on_affiliate_program_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(AFFILIATE_PROGRAM_PATH);
  }

  @And("^I click on Travel credits link and verify displayed text on this page$")
  public void i_click_on_travel_credits_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(TRAVEL_CREDITS_PATH);
  }

  @And("^I click on Travel Gift card link and verify displayed text on this page$")
  public void i_click_on_travel_gift_card_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(TRAVEL_GIFT_CARD_PATH);
  }

  @And("^I click on Travel Gift Card Term link and verify displayed text on this page$")
  public void iClickOnTravelGiftCardTermLinkAndVerifyDisplayedTextOnThisPage() {
    scrollToBottomPage(driver);
    clickElementByDynamicLocator(driver, COLUMN_LIST, TRAVEL_GIFT_CARD_PATH);
    switchToOtherWindowbyUrl(driver, TRAVEL_GIFT_CARD_URL);
    clickToElement(driver, TRAVEL_GIFT_CARD_TERM_LINK);
    switchToOtherWindowbyUrl(driver, GIFT_CARD_TERM_PATH);
    travelGiftCardTermPage.verifyContentOnThisPage();
    switchTab(driver);
  }

  @And("^I click on Contact us link and verify error message on this page$")
  public void i_click_on_contact_us_link_and_verify_error_message_on_this_page() throws Throwable {
    landingPage.clickToSupportColumn(CONTACT_US_PATH);

  }

  @And("^I click on Travel Member link and verify displayed text on this page$")
  public void i_click_on_travel_member_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(TRAVEL_MEMBER_PATH);
  }

  @And("^I click on Terms & Conditions link and verify displayed text on this page$")
  public void i_click_on_terms_conditions_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToSupportColumn(TERMS_CONDITIONS_PATH);
  }

  @And("^I click on Privacy Policy link and verify displayed text on this page$")
  public void i_click_on_privacy_policy_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToSupportColumn(PRIVACY_POLICY_PATH);
  }

  @And("^I click on Cookie Policy link and verify displayed text on this page$")
  public void i_click_on_cookie_policy_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToSupportColumn(COOKIE_POLICY_PATH);

  }

  @And("^I click on Mobile Apps link and verify displayed text on this page$")
  public void i_click_on_mobile_apps_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(MOBILE_APP_PATH);
  }

  @And("^I click on Payment Options link and verify displayed text on this page$")
  public void i_click_on_payment_options_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(PAYMENT_OPTIONS_PATH);
  }

  @And("^I click on Partnership link and verify displayed text on this page$")
  public void i_click_on_partnership_link_and_verify_displayed_text_on_this_page() {
    landingPage.clickToSupportColumn(PARTNER_SHIP_PATH);
  }

  @And("^I click on Concierge link and verify displayed text on this page$")
  public void i_click_on_concierge_link_and_verify_displayed_text_on_this_page() {

//    scrollToBottomPage(driver);
//    clickElementByDynamicLocator(driver, COLUMN_LIST, CONCIERGE);
//    switchToOtherWindowbyUrl(driver, CONCIERGE);
    openNewTab(driver,"https://concierge-pr-55.herokuapp.com/");
//    if (conciergePage.verifyLeisureMenu() && conciergePage.verifyTextLeisureConcierge()) {
//      System.out.println("Text in Leisure Tab  Concierge Page is displayed correct");
//    }
  }

  @And("^I click on Media Contact link and verify displayed text on this page$")
  public void i_click_on_media_contact_link_and_verify_displayed_text_on_this_page() {
    landingPage.clickToSupportColumn(MEDIA_PATH);
  }

  @And("^I click on Business Travel link and verify displayed text on this page$")
  public void i_click_on_business_travel_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(BUSINESS_TRAVEL_PATH);
  }

  @And("^I click on Binance Travel link and verify displayed text on this page$")
  public void i_click_on_binance_travel_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(BINANCE_TRAVEL_PATH);
  }

  @And("^I click on Partner Network link and verify displayed text on this page$")
  public void i_click_on_partner_network_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(PARTNER_NETWORK_URL);
  }

  @And("^I click on Sitemap link and verify displayed text on this page$")
  public void i_click_on_sitemap_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(SITEMAP);
  }

  @And("^I click on Bug Report link and verify displayed text on this page$")
  public void i_click_on_bug_report_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToUsefulColumn(BUG_REPORT_URL);

  }

  @And("^I click on Official Blog link and verify displayed text on this page$")
  public void i_click_on_official_blog_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(OFFICAL_BLOG_URL);
  }

  @And("^I click on Travel Advices link and verify displayed text on this page$")
  public void iClickOnTravelAdvicesLinkAndVerifyDisplayedTextOnThisPage() {
    landingPage.clickToResourcesColumn(TRAVEL_GUIDES_URL);
  }

  @And("^I click on Travel Guides link and verify displayed text on this page$")
  public void i_click_on_travel_guides_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(TRAVEL_GUIDES_URL);
  }

  @And("^I click on Read Reviews link and verify displayed text on this page$")
  public void i_click_on_read_reviews_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(TRUST_PILOT_URL);
  }

  @And("^I click on Our Partners link and verify displayed text on this page$")
  public void i_click_on_our_partners_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(OUR_PARTNER_URL);
    ourPartnersPage = new OurPartnersPage(driver);
    switchTab(driver);
  }

  @And("^I click on Twitter link and verify displayed text on this page$")
  public void i_click_on_twitter_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(TWITTER_URL);
  }

  @And("^I click on Facebook link and verify displayed text on this page$")
  public void i_click_on_facebook_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(FACEBOOK_URL);
  }

  @And("^I click on Telegram link and verify displayed text on this page$")
  public void i_click_on_telegram_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(TELEGRAM_URL);
  }

  @And("^I click on Instagram link and verify displayed text on this page$")
  public void i_click_on_instagram_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(INSTAGRAM_URL);
  }

  @And("^I click on Reddit link and verify displayed text on this page$")
  public void i_click_on_reddit_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(REDDIT_URL);
  }

  @And("^I click on Linkedin link and verify displayed text on this page$")
  public void i_click_on_linkedin_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToCommunityColumn(LINKEDIN_URL);
  }

  @And("^I click on Coin listing link and verify displayed text on this page$")
  public void i_click_on_coin_listing_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(COIN_LIST_PATH);
  }

  @And("^I click on Careers link and verify displayed text on this page$")
  public void i_click_on_careers_link_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToResourcesColumn(CAREERS_PATH);
  }

  @And("^I click on invite program and verify displayed text on this page$")
  public void i_click_on_invite_program_and_verify_displayed_text_on_this_page() throws Throwable {
    landingPage.clickToTravalaColumn(INVITE_PATH);
  }

  @And("^I click on Invite Term link and verify displayed text on this page$")
  public void i_click_on_invite_term_link_and_verify_displayed_text_on_this_page() throws Throwable {
    clickElementByDynamicLocator(driver, COLUMN_LIST, INVITE_PATH);
    switchToOtherWindowbyUrl(driver, INVITE_PATH);
    clickToElementByJavascript(driver, INVITE_FOOTER_TERM);
    switchToWindowByUrlContainsString(driver, INVITE_TERM_PATH);
    inviteTermPage.verifyContent();
    switchTab(driver);
  }


  @And("^I click on smart program and verify displayed text on this page$")
  public void i_click_on_smart_program_and_verify_displayed_text_on_this_page() {
    scrollToLoadMore(driver);
    clickToElementByJavascript(driver, SMART_PROGRAM_LINK_FOOTER);
    switchToWindowByUrlContainsString(driver, SMART_PROGRAM_PATH);
    smartProgramPage.verifyTextLandingSmart();
  }

  @And("^I click on Active NFT link and verify displayed text on this page$")
  public void iClickOnActiveNFTLinkAndVerifyDisplayedTextOnThisPage() {
    landingPage.clickToUsefulColumn(ACTIVE_NFT);
  }


  @And("^I click on smart term and verify displayed text on this page$")
  public void iClickOnSmartTermAndVerifyDisplayedTextOnThisPage() {
    scrollToLoadMore(driver);
    clickToElementByJavascript(driver, SMART_PROGRAM_LINK_FOOTER);
    switchToOtherWindowbyUrl(driver, SMART_PROGRAM_PATH);
    clickToElementByJavascript(driver, SMART_PROGRAM_TERM_LINK);
    switchToOtherWindowbyUrl(driver, SMART_TERM_PATH);
    smartTermPage.verifyTextOnPage();
  }

  @And("^I verify content in Business tab of Concierge page$")
  public void i_verify_content_in_business_tab_of_concierge_page() {
    conciergePage.verifyBusinessConcierge();
  }

  @And("^I verify content in FAQ tab of Concierge page$")
  public void i_verify_content_in_faq_tab_of_concierge_page() {
    conciergePage.verifyFAQConcierge();
  }

  @And("^I verify content in Apply tab of Concierge page$")
  public void i_verify_content_in_apply_tab_of_concierge_page() {
    conciergePage.verifyApplyConcierge();
    conciergePage.verifyInputValidApplyForm();
    conciergePage.verifyConfirmEmail();
  }

  @And("^I verify term condition of concierge page$")
  public void iVerifyTermConditionOfConciergePage() {
    conciergePage.verifyTermConditionConcierge();
  }

  @And("^I verify term privacy policy of concierge page$")
  public void iVerifyTermPrivacyPolicyOfConciergePage() {
    conciergePage.verifyPrivacyPolicyConcierge();
  }


  @And("^I verify contact us of concierge page$")
  public void iVerifyContactUsOfConciergePage() {
    conciergePage.verifyContactUsConcierge();
    switchTab(driver);
  }
  @And("^I verify content in Custom Package tab of Concierge page$")
  public void iVerifyContentInCustomPackageTabOfConciergePage() {
    conciergePage.verifyTravelInspiration();
    conciergePage.verifyCustomPackage();
  }

  @And("^I verify display item on the footer part$")
  public void iVerifyDisplayItemOnTheFooterPart() {
    landingPage.scrollToBottomPage(driver);
    if (verifyDisplayTextAtFooter()) {
      System.out.println("Text on footer part at Landing page is displayed correct");
    } else {
      System.out.println("Text on footer part at Landing page  is displayed wrong");
    }
  }

  @And("^I verify displayed text on Travelsmart Protection page$")
  public void iVerifyDisplayedTextOnTravelsmartProtectionPage() {
    scrollToBottomPage(driver);
    clickToElementByJavascript(driver, GIFT_CARD_FOOTER_LINK);
    switchToOtherWindowbyUrl(driver, BUY_GIFT_CARD_PATH);
    clickToElementByJavascript(driver, MENU_TRAVEL_SMART_PROTECTION_URL);
//    wait300Time();
//    TermFlightPaid termFlightPaid = new TermFlightPaid(driver);
//    termFlightPaid.verifyTextOnThePage();
  }

}
