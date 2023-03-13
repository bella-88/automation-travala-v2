package pages.hotel.footer.resources;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.resources.CoinListingPageUI.*;

public class CoinListPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;

  public CoinListPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextCoinListing() {
    String[] banner = {"LISTING_BANNER", "LISTING_BENEFITS", "LISTING_CONTENT_STUDY_CASE", "LISTING_TRAVEL_PARTNER",
      "LISTING_OUR_PARTNER", "LISTING_SUPPORTING", "LISTING_SUPPORTING_SUB", "TRAVEL_GIFT_CARD_FAQ"};
    String[] xpath = {LISTING_BANNER, LISTING_BENEFITS, LISTING_CONTENT_STUDY_CASE, LISTING_TRAVEL_PARTNER,
      LISTING_OUR_PARTNER, LISTING_SUPPORTING, LISTING_SUPPORTING_SUB, LISTING_FAQ};
    boolean t = StringUtils.contains(getTextFromReadFile("LISTING_BANNER_TITLE"), getTextElement(driver, LISTING_BANNER_TITLE).replaceAll("\\r\\n|\\r|\\n", " "));
    boolean b = verifyTwoListByKey(banner, xpath);
    if (!b ||!t) {
      System.out.println("Text at Banner Coin Listing Page wrong! ");
    }
    String[] button = {"LISTING_BANNER_BTN"};
    boolean b1 = verifyListItemByListExpect(button, LISTING_BANNER_BTN_LIST, LISTING_BANNER_BTN_DYNAMIC);
    if (!b1) {
      System.out.println("Text at button Coin Listing Page wrong! ");
    }
    String[] contactList = {"LISTING_CONTACT1", "LISTING_CONTACT2"};
    boolean b2 = verifyListItemByListExpect(contactList, LISTING_CONTACT_LIST, LISTING_CONTACT_DYNAMIC);
    if (!b2) {
      System.out.println("Text at Contact Coin Listing Page wrong! ");
    }
    String[] title = {"LISTING_TITLE1", "LISTING_TITLE2", "LISTING_TITLE3", "LISTING_TITLE4", "LISTING_TITLE5", "LISTING_TITLE6", "LISTING_TITLE7",
      "LISTING_TITLE8", "LISTING_TITLE9", "LISTING_TITLE10", "LISTING_TITLE11", "LISTING_TITLE12", "LISTING_TITLE13"};
    boolean b3 = verifyListItemByListExpect(title, LISTING_TITLE_LIST, LISTING_TITLE_DYNAMIC);
    if (!b3) {
      System.out.println("Text at Title Coin Listing Page wrong! ");
    }
    clickToElement(driver,LISTING_FAQ_FIRST);
    clickToShowAllItems(LISTING_FAQ_LIST);
    String[] titleFAQ = {"LISTING_FAQ1", "LISTING_FAQ2", "LISTING_FAQ3", "LISTING_FAQ4"};
    boolean b7 = verifyListItemByListExpect(titleFAQ, LISTING_FAQ_LIST, LISTING_FAQ_DYNAMIC);
    if (!b7) {
      System.out.println("Text at Title FAQ Coin Listing Page wrong! ");
    }
    String[] subContent = {"LISTING_CONTENT1", "LISTING_CONTENT2", "LISTING_CONTENT3", "LISTING_CONTENT4", "LISTING_CONTENT5", "LISTING_CONTENT6",
      "LISTING_CONTENT7", "LISTING_CONTENT8", "LISTING_CONTENT9", "LISTING_CONTENT10", "LISTING_CONTENT11", "LISTING_CONTENT12",
      "LISTING_CONTENT13", "LISTING_CONTENT14", "LISTING_CONTENT15", "LISTING_CONTENT16", "LISTING_CONTENT17"};
    boolean b4 = verifyListItemByListExpect(subContent, LISTING_CONTENT_LIST, LISTING_CONTENT_DYNAMIC);
    if (!b4) {
      System.out.println("Text at Content Title Coin Listing Page wrong! ");
    }
    String[] partner = {"LISTING_PARTNER1", "LISTING_PARTNER2", "LISTING_PARTNER3"};
    boolean b5 = verifyListItemByListExpect(partner, LISTING_PARTNER_LIST, LISTING_PARTNER_DYNAMIC);
    if (!b5) {
      System.out.println("Text at Partner Content Coin Listing Page wrong! ");
    }
    String[] partnerTitle = {"LISTING_PARTNER_TITLE1", "LISTING_PARTNER_TITLE2"};
    boolean b6 = verifyListItemByListExpect(partnerTitle, LISTING_PARTNER_TITLE_LIST, LISTING_PARTNER_TITLE_DYNAMIC);
    if (!b5) {
      System.out.println("Text at Partner Title Coin Listing Page wrong! ");
    }
    return b && b1 && b2 && b3 && b4 && b5 && b6 && b7&& verifyUrlPage(COIN_LIST_PATH);
  }
}
