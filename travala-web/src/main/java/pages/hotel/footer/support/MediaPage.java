package pages.hotel.footer.support;

import org.openqa.selenium.WebDriver;

import commons.hotel.CommonHotelPages;

import static interfaces.hotel.footer.support.MediaPageUI.*;

public class MediaPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public MediaPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextMedia() {
      check = verifyTextInTheWorldSection() && verifyTextInAboutUs() && verifyTextInOurGrowthAndOurAudience() && verifyTextInPersonalities() && verifyTextInQuestionDetailsAndOther();
    if (check) {
      System.out.println("Media Page is displayed correct");
    }
  }

  private boolean verifyTextInTheWorldSection() {
    String[] contentBanner = {"MEDIA_CONTACT_BANNER_TITLE", "MEDIA_CONTACT_BANNER_SUB_TITLE", "MEDIA_CONTACT_QUOTE_CONTENT"};
    String[] xpathOfContentBanner = {MEDIA_TITLE, MEDIA_SUB_TITLE, MEDIA_QUOTE_CONTENT};
    boolean isContentBanner = verifyTwoListByKey(contentBanner, xpathOfContentBanner);

    String[] listTitle = {"MEDIA_CONTACT_ORGANIC_MEDIA_TITLE", "MEDIA_CONTACT_TRAVEL_PARTNERS_TITLE", "MEDIA_CONTACT_BLOCKCHAIN_PARTNERS_TITLE", "MEDIA_CONTACT_INFLUENCERS_TITLE"};
    boolean isListTitle = verifyListItemByListExpect(listTitle, MEDIA_WORLD_LIST, MEDIA_WORLD_DYNAMIC);
    String[] listContentInTitle = {"MEDIA_CONTACT_ORGANIC_MEDIA_DESC", "MEDIA_CONTACT_TRAVEL_PARTNERS_DESC", "MEDIA_CONTACT_BLOCKCHAIN_PARTNERS_DESC", "MEDIA_CONTACT_INFLUENCERS_DESC"};
    boolean isListContentInTitle = verifyListItemByListExpect(listContentInTitle, MEDIA_WORLD_CONTENT_LIST, MEDIA_WORLD_CONTENT_DYNAMIC);
    check = isContentBanner && isListTitle && isListContentInTitle;
    if(!check) {
      System.out.println("Content in Banner incorrectly");
    }
    return check;
  }

  private boolean verifyTextInAboutUs() {
    String[] listTitleInAboutUs = {"MEDIA_CONTACT_WHO_TALKS_ABOUT_US_TITLE", "MEDIA_CONTACT_ACTIVE_COMMUNITY_TITLE"};
    String[] listSubTitleInAboutUs = { "MEDIA_CONTACT_WHO_TALKS_ABOUT_US_SUB_TITLE", "MEDIA_CONTACT_ACTIVE_COMMUNITY_SUB_TITLE"};
    boolean isTitleInAboutUs = verifyListItemByListExpect(listTitleInAboutUs, MEDIA_ABOUT_LIST, MEDIA_ABOUT_DYNAMIC);
    boolean isSubTitleInAboutUs = verifyListItemByListExpect(listSubTitleInAboutUs, MEDIA_ABOUT_CONTENT_LIST, MEDIA_ABOUT_CONTENT_DYNAMIC);

    String[] expectListContentInFamousPerson = {"MEDIA_CONTACT_PERSION_DESC_CZ_BINANCE", "MEDIA_CONTACT_PERSION_DESC_AMANDA_CERNY", "MEDIA_CONTACT_PERSION_DESC_ELLIO_TRADES", "MEDIA_CONTACT_PERSION_DESC_MARIE_JAKE",
                                                "MEDIA_CONTACT_PERSION_DESC_JUSTIN_SUN", "MEDIA_CONTACT_PERSION_DESC_DAVID_GOKHSHTEIN", "MEDIA_CONTACT_PERSION_DESC_THE_CRYPTO_DOG", "MEDIA_CONTACT_PERSION_DESC_SCOTT_MELKER"};
    boolean isContentInFamousPerson = verifyListItemByListExpect(expectListContentInFamousPerson, MEDIA_PERSON_CONTENT_LIST, MEDIA_PERSON_CONTENT_DYNAMIC);

    String[] expectListFollowersInFamousPerson = {"MEDIA_CONTACT_PERSION_FOLLOWERS_CZ_BINANCE", "MEDIA_CONTACT_PERSION_FOLLOWERS_AMANDA_CERNY", "MEDIA_CONTACT_PERSION_FOLLOWERS_ELLIO_TRADES", "MEDIA_CONTACT_PERSION_FOLLOWERS_MARIE_JAKE",
                                                "MEDIA_CONTACT_PERSION_FOLLOWERS_JUSTIN_SUN", "MEDIA_CONTACT_PERSION_FOLLOWERS_DAVID_GOKHSHTEIN", "MEDIA_CONTACT_PERSION_FOLLOWERS_THE_CRYPTO_DOG", "MEDIA_CONTACT_PERSION_FOLLOWERS_SCOTT_MELKER"};
    boolean isListFollowersInFamousPerson = verifyListItemByListExpect(expectListFollowersInFamousPerson, MEDIA_PERSON_FOLLOW_LIST, MEDIA_PERSON_FOLLOW_DYNAMIC);
    check = isTitleInAboutUs && isSubTitleInAboutUs && isContentInFamousPerson && isListFollowersInFamousPerson;
    if(!check) {
      System.out.println("Content in About Us incorrectly");
    }
    return check;
  }

  private boolean verifyTextInOurGrowthAndOurAudience() {
    String[] listTextInOurGrowth = {"MEDIA_CONTACT_OUR_GROWTH_TITLE", "MEDIA_CONTACT_OUR_GROWTH_CONTENT1", "MEDIA_CONTACT_OUR_GROWTH_CONTENT2"};
    String[] listXpathInOurGrowth = {MEDIA_GROWTH, MEDIA_GROWTH_CONTENT1, MEDIA_GROWTH_CONTENT2};
    boolean isTextInOurGrowth = verifyTwoListByKey(listTextInOurGrowth, listXpathInOurGrowth);

    String[] listTextInOurAudience = {"MEDIA_CONTACT_OUR_AUDIENCE_TITLE", "MEDIA_CONTACT_OUR_AUDIENCE_CONTENT1", "MEDIA_CONTACT_OUR_AUDIENCE_CONTENT2"};
    String[] listXpathInOurAudience = {MEDIA_AUDIENCE_TITLE, MEDIA_AUDIENCE_CONTENT1, MEDIA_AUDIENCE_CONTENT2};
    boolean isTextInOurAudience = verifyTwoListByKey(listTextInOurAudience, listXpathInOurAudience);
    check = isTextInOurGrowth && isTextInOurAudience;
    if(!check) {
      System.out.println("Content in Our Growth & Our Audience incorrectly");
    }
    return check;
  }

  private boolean verifyTextInPersonalities() {
    String[] listTitleInPersonalities = {"MEDIA_CONTACT_PERSONALITIES_TITLE", "MEDIA_CONTACT_BOOK_OUR_PERSONALITIES_TITLE", "MEDIA_CONTACT_WANT_TO_WORK_TITLE", "MEDIA_CONTACT_MEDIA_KIT_TITLE", "MEDIA_CONTACT_APPLY_BUTTON", "MEDIA_CONTACT_DOWNLOAD_BUTTON"};
    String[] xpathOfListTitleInPersonalities = {MEDIA_PERSONALITY, MEDIA_BOOK_OUR_PERSONALITIES_TITLE, MEDIA_WANT_TO_WORK_TITLE, MEDIA_KIT, MEDIA_APPLY_BUTTON, MEDIA_KIT_LINK};
    boolean isListTitle = verifyTwoListByKey(listTitleInPersonalities, xpathOfListTitleInPersonalities);

    String[] listPosition = {"MEDIA_CONTACT_JUAN_OTERO_POSITION_TITLE", "MEDIA_CONTACT_DREW_CURRAH_POSITION_TITLE", "MEDIA_CONTACT_SAM_WOOLLARD_POSITION_TITLE"};
    boolean isListPosition = verifyListItemByListExpect(listPosition, MEDIA_PERSONAL_TITLE_LIST, MEDIA_PERSONAL_TITLE_DYNAMIC);
    String[] listDescriptionOfPosition = {"MEDIA_CONTACT_JUAN_OTERO_DESC", "MEDIA_CONTACT_DREW_CURRAH_DESC", "MEDIA_CONTACT_SAM_WOOLLARD_DESC"};
    boolean isListDescOfPosition = verifyListItemByListExpect(listDescriptionOfPosition, MEDIA_PERSONAL_CONTENT_LIST, MEDIA_PERSONAL_CONTENT_DYNAMIC);
    String[] listContentInBookOurPersonalities = {"MEDIA_CONTACT_BOOK_OUR_PERSONALITIES_CONTENT1", "MEDIA_CONTACT_BOOK_OUR_PERSONALITIES_CONTENT2", "MEDIA_CONTACT_BOOK_OUR_PERSONALITIES_CONTENT3", "MEDIA_CONTACT_BOOK_OUR_PERSONALITIES_CONTENT4"};
    boolean isListContentInBookOurPersonalities = verifyListItemByListExpect(listContentInBookOurPersonalities, MEDIA_BOOK_OUR_LIST, MEDIA_BOOK_OUR_DYNAMIC);
    String[] listOptionTitle = {"MEDIA_CONTACT_AFFILIATE_PARTNER_PROGRAM_TITLE", "MEDIA_CONTACT_INVITE_PROGRAM_TITLE", "MEDIA_CONTACT_OUR_SOCIAL_HANDLES_TITLE"};
    boolean isListOptionTitle = verifyListItemByListExpect(listOptionTitle, MEDIA_ITEM_TITLE_LIST, MEDIA_ITEM_TITLE_DYNAMIC);
    String[] listOptionContent = {"MEDIA_CONTACT_AFFILIATE_PARTNER_PROGRAM_DESC", "MEDIA_CONTACT_INVITE_PROGRAM_DESC"};
    boolean isListOptionContent = verifyListItemByListExpect(listOptionContent, MEDIA_ITEM_CONTENT_LIST, MEDIA_ITEM_CONTENT_DYNAMIC);
    check = isListTitle && isListPosition && isListDescOfPosition && isListContentInBookOurPersonalities && isListOptionTitle && isListOptionContent;
    if(!check) {
      System.out.println("Content in Personalities incorrectly");
    }
    return check;
  }

  private boolean verifyTextInQuestionDetailsAndOther() {
    String[] listTitle = {"MEDIA_CONTACT_HOW_TO_GET_INVOLVED_TITLE", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_TITLE", "MEDIA_CONTACT_WHAT_TO_AVOID_TITLE", "MEDIA_CONTACT_HOW_TALKING_ABOUT_TITLE", "MEDIA_CONTACT_OTHER_WAYS_TITLE"};
    boolean isListTitle = verifyListItemByListExpect(listTitle, MEDIA_QUESTION_DETAIL_TITLE_LIST, MEDIA_QUESTION_DETAIL_TITLE_DYNAMIC);

    String[] listContent = {"MEDIA_CONTACT_HOW_TO_GET_INVOLVED_CONTENT", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT1", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT2", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT3",
            "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT4", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT5", "MEDIA_CONTACT_WHAT_WE_LOOK_FOR_CONTENT6", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT1", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT2",
            "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT3", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT4", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT5", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT6", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT7",
            "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT8", "MEDIA_CONTACT_WHAT_TO_AVOID_CONTENT9", "MEDIA_CONTACT_HOW_TALKING_ABOUT_CONTENT1", "MEDIA_CONTACT_HOW_TALKING_ABOUT_CONTENT2"};
    boolean isListContent = verifyListItemByListExpect(listContent, MEDIA_QUESTION_DETAIL_CONTENT_LIST, MEDIA_QUESTION_DETAIL_CONTENT_DYNAMIC);
    String[] listItemOfOtherWays = {"MEDIA_CONTACT_OTHER_WAYS_ITEM1", "MEDIA_CONTACT_OTHER_WAYS_ITEM2", "MEDIA_CONTACT_OTHER_WAYS_ITEM3"};
    boolean isItemOfOtherWays = verifyListItemByListExpect(listItemOfOtherWays, MEDIA_OTHER_LINK_LIST, MEDIA_OTHER_LINK_DYNAMIC);
    check = isListTitle && isListContent && isItemOfOtherWays;
    if(!check) {
      System.out.println("Content in Question Details incorrectly");
    }
    return check;
  }
}
