package pages.hotel.NFT;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.NFT.ActiveNFTPageUI.*;


public class ActiveNFTPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;
  boolean check = true;


  public ActiveNFTPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage() {
    String[] heading = {"ACTIVE_NFT_PAGE_HEADING", "ACTIVE_NFT_PAGE_TITLE_BANNER", "ACTIVE_NFT_PAGE_BANNER_PARAGRAPH", "ACTIVE_NFT_PAGE_HEADING_MEMBERSHIP"
                      , "ACTIVE_NFT_PAGE_ACTIVE_SMART_DIAMOND_BUTTON", "ACTIVE_NFT_PAGE_HEADING_BENEFITS", "ACTIVE_NFT_PAGE_HEADING_HOW_TO_ACTIVE"};
    String[] xpathsOfHeading = {ACTIVE_NFT_HEADING, ACTIVE_NFT_BANNER, ACTIVE_NFT_SUB_BANNER, ACTIVE_NFT_MEMBERSHIP_TITLE, ACTIVE_NFT_MEMBERSHIP_ACTIVE_BUTTON
                      , ACTIVE_NFT_BENEFITS_TITLE, ACTIVE_NFT_HOW_TO_ACTIVE_TITLE};

    boolean isHeadingCorrect = verifyTwoListByKey(heading, xpathsOfHeading);

    String[] membership = {"ACTIVE_NFT_PAGE_CONTENT1_MEMBERSHIP", "ACTIVE_NFT_PAGE_CONTENT2_MEMBERSHIP", "ACTIVE_NFT_PAGE_CONTENT3_MEMBERSHIP"};
    boolean isMembershipCorrect = verifyListItemByListExpect(membership, ACTIVE_NFT_MEMBERSHIP_CONTENT_LIST, ACTIVE_NFT_MEMBERSHIP_CONTENT_DYNAMIC);

    String[] benefitsTitle = {"ACTIVE_NFT_PAGE_AVATAR_TITLE", "ACTIVE_NFT_PAGE_VOTING_RIGHTS_TITLE", "ACTIVE_NFT_PAGE_AMBASSADOR_BONUS_TITLE", "ACTIVE_NFT_PAGE_TRVL_AIRDROPS_TITLE", "ACTIVE_NFT_PAGE_LOYALTY_REWARDS_TITLE"
            , "ACTIVE_NFT_PAGE_CONCIERGE_ACCESS_TITLE", "ACTIVE_NFT_PAGE_AVA_PAYMENT_TITLE", "ACTIVE_NFT_PAGE_METAVERSES_TITLE", "ACTIVE_NFT_PAGE_PROOF_TRAVEL_TITLE", "ACTIVE_NFT_PAGE_TRAVEL_DROPS_TITLE"};

    boolean isBenefitsTitleCorrect = verifyListItemByListExpect(benefitsTitle, ACTIVE_NFT_BENEFITS_LIST_TITLE, ACTIVE_NFT_BENEFITS_LIST_TITLE_DYNAMIC);

    String[] benefitsContent = {"ACTIVE_NFT_PAGE_AVATAR_PARAGRAPH", "ACTIVE_NFT_PAGE_VOTING_RIGHTS_PARAGRAPH", "ACTIVE_NFT_PAGE_AMBASSADOR_BONUS_PARAGRAPH", "ACTIVE_NFT_PAGE_TRVL_AIRDROPS_PARAGRAPH", "ACTIVE_NFT_PAGE_LOYALTY_REWARDS_PARAGRAPH"
            , "ACTIVE_NFT_PAGE_CONCIERGE_ACCESS_PARAGRAPH", "ACTIVE_NFT_PAGE_AVA_PAYMENT_PARAGRAPH", "ACTIVE_NFT_PAGE_METAVERSES_PARAGRAPH", "ACTIVE_NFT_PAGE_PROOF_TRAVEL_PARAGRAPH", "ACTIVE_NFT_PAGE_TRAVEL_DROPS_PARAGRAPH"};
    boolean isBenefitsContentCorrect = verifyListItemByListExpect(benefitsContent, ACTIVE_NFT_BENEFITS_LIST_CONTENT, ACTIVE_NFT_BENEFITS_LIST_CONTENT_DYNAMIC);

    String[] contentStepsHowToActive = {"ACTIVE_NFT_PAGE_STEP1_CONTENT", "ACTIVE_NFT_PAGE_STEP2_CONTENT", "ACTIVE_NFT_PAGE_STEP3_CONTENT", "ACTIVE_NFT_PAGE_STEP4_CONTENT"};
    boolean isContentStepHowToActiveCorrect = verifyListItemByListExpect(contentStepsHowToActive, ACTIVE_NFT_HOW_TO_LIST_STEP, ACTIVE_NFT_HOW_TO_LIST_STEP_DYNAMIC);


    check = isHeadingCorrect && isMembershipCorrect && isBenefitsTitleCorrect && isBenefitsContentCorrect && isContentStepHowToActiveCorrect;
    if (!check) {
      System.out.println("Content at Active NFT page wrong");
    } else {
      System.out.println("Content at Active NFT page correct");
    }
  }
}
