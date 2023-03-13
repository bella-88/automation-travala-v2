package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.NFT.BuyNFTPage;
import pages.hotel.NFT.CampaignTermsPage;
import pages.hotel.NFT.NFTLandingPage;
import pages.hotel.NFT.NFTTermsConditionsPage;

import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.*;
import static interfaces.hotel.NFT.NFTLandingPageUI.NFT_GIVE_AWAY_TERM_LINK;


public class NFTPageSteps extends CommonHotelPages {
  static WebDriver driver;
  private NFTLandingPage nftLandingPage;
  private BuyNFTPage buyNFTPage;

  public NFTPageSteps() {
    driver = HooksHotel.openBrowserTravala();
    super.setDriver(driver);
    nftLandingPage = new NFTLandingPage(driver);
    buyNFTPage = new BuyNFTPage(driver);
  }

  @And("^I verify text at Landing NFT page when not login$")
  public void iVerifyTextAtLandingNFTPageWhenNotLogin() {
    clickToElementByJavascript(driver, BUY_NFT_HEADER);
    switchToLanguage();
    nftLandingPage.verifyContentTextAtNFTLanding();
  }

  @When("^I login to NFT page by Smart acc$")
  public void iLoginToNFTPageBySmartAcc() {
    nftLandingPage.loginNFTBySmartAcc();
    clickToElementByJavascript(driver, BUY_NFT_HEADER);
    nftLandingPage.verifyTextAtNFTLanding();
  }


  @When("^I login to NFT page with Basic account$")
  public void iLoginToNFTPageWithBasicAccount() {
    nftLandingPage.loginNFTByBasicAcc();
    nftLandingPage.verifyTextAtNFTLanding();
  }

  @And("^I verify display when acc has not register whitelist$")
  public void iVerifyDisplayWhenAccHasNotRegisterWhitelist() {

  }

  @And("^I verify display when valid acc buy nft by My Wallet$")
  public void iVerifyDisplayWhenValidAccBuyNftByMyWallet() {
    nftLandingPage.clickBuyNFTBtn();
    buyNFTPage.verifyListAmountNFT();
    buyNFTPage.verifyBuyNftByWallet("AVA");
  }

  @And("^I verify display term page from the link on the page$")
  public void iVerifyDisplayTermPageFromTheLinkOnThePage() {
//    nftLandingPage.clickBuyNFTBtn();
//    clickToElementByJavascript(driver, NFT_TERM_LINK);
    openNewTab(driver,"https://travala-pr-158.herokuapp.com/nft-terms");
    NFTTermsConditionsPage nftTermsConditionsPage = new NFTTermsConditionsPage(driver);
    switchToWindowByUrlContainsString(driver, NFT_TERM_PATH);

    nftTermsConditionsPage.verifyContent();
  }

  @And("^I verify text on Campaign Give Away Term page$")
  public void iVerifyTextOnCampaignGiveAwayTermPage() {
    clickToElementByJavascript(driver, NFT_GIVE_AWAY_TERM_LINK);
    CampaignTermsPage campaignTermsPage = new CampaignTermsPage(driver);
    switchToWindowByUrlContainsString(driver, MALDIVES_PATH);
    campaignTermsPage.verifyContent();
  }

}