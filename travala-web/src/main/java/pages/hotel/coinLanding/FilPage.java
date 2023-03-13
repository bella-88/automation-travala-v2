package pages.hotel.coinLanding;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import static interfaces.hotel.coinLanding.FilPageUI.*;

public class FilPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public FilPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextBanner(String banner) {
    boolean a = StringUtils.contains(getTextFromReadFile(banner), getTextElement(driver, FIL_BANNER_TITLE1));
    String getDomain = getTextBySplit(getTextElement(driver, FIL_BANNER_TITLE1), " ", 1);
    if (!a) {
      System.out.println("Title1 " + getDomain + " exp: " + getTextFromReadFile(banner));
      System.out.println("Title1 " + getDomain + " act: " + getTextElement(driver, FIL_BANNER_TITLE1));
    }
    return a;
  }

  public boolean verifyUseCase() {
    String[] contentExp = {"FIL_TEAM_TITLE", "FIL_TEAM_CONTENT", "FIL_USE_CASE_TITLE", "FIL_MORE_CASE_TITLE"};
    String[] xpathAct = {FIL_TEAM_TITLE, FIL_TEAM_CONTENT, FIL_USE_CASE_TITLE, FIL_MORE_CASE_TITLE};
    boolean b = verifyTwoListByKey(contentExp, xpathAct);

    String[] titleMoreUseCase = {"FIL_MORE_USE_CASE_TITLE1", "FIL_MORE_USE_CASE_TITLE2"};
    boolean b2 = verifyListItemByListExpect(titleMoreUseCase, FIL_MORE_CASE_SUB_TITLE_LIST, FIL_MORE_CASE_SUB_TITLE_DYNAMIC);
    if (!b2) {
      System.out.println("FIL_MORE_CASE_SUB_TITLE_LIST wrong! ");
    }

    String[] titleSection = {"FIL_TITLE_SECTION1", "FIL_TITLE_SECTION2", "FIL_TITLE_SECTION3",
      "FIL_TITLE_SECTION4", "FIL_TITLE_SECTION5", "FIL_TITLE_SECTION6", "FIL_TITLE_SECTION7", "FIL_TITLE_SECTION8"};
    boolean b4 = verifyListItemByListExpect(titleSection, FIL_TITLE_LIST, FIL_TITLE_DYNAMIC);
    if (!b4) {
      System.out.println("TITLE_SECTION wrong! ");
    }
    String[] nameTeam = {"FIL_TEAM_ITEM_TITLE1", "FIL_TEAM_ITEM_TITLE2", "FIL_TEAM_ITEM_TITLE3", "FIL_TEAM_ITEM_TITLE4", "FIL_TEAM_ITEM_TITLE5"};
    boolean b6 = verifyListItemByListExpect(nameTeam, FIL_TEAM_ITEM_TITLE_LIST, FIL_TEAM_ITEM_TITLE_DYNAMIC);
    if (!b6) {
      System.out.println("TEAM_ITEM_TITLE1 wrong! ");
    }

    String[] positionTeam = {"FIL_TEAM_ITEM_POSITION1", "FIL_TEAM_ITEM_POSITION2", "FIL_TEAM_ITEM_POSITION3", "FIL_TEAM_ITEM_POSITION4", "FIL_TEAM_ITEM_POSITION5"};
    boolean b7 = verifyListItemByListExpect(positionTeam, FIL_TEAM_ITEM_POSITION_LIST, FIL_TEAM_ITEM_POSITION_DYNAMIC);
    if (!b7) {
      System.out.println("TEAM_ITEM_POSITION1 wrong! ");
    }

    String[] titleFAQ = {"FIL_FAQ_TITLE1", "FIL_FAQ_TITLE2", "FIL_FAQ_TITLE3", "FIL_FAQ_TITLE4"};
    boolean b9 = verifyListItemByListExpect(titleFAQ, FIL_FAQ_LIST, FIL_FAQ_DYNAMIC);
    if (!b9) {
      System.out.println("FAQ_TITLE1 wrong! ");
    }
    status = b && b2 && b4 && b6 && b7 && b9;
    return status;
  }

  public boolean verifyTextOnThePage() {
    clickToListElement(driver, FIL_FAQ_LIST);
    String[] contentAllPage = {"FIL_CONTENT0", "FIL_CONTENT1", "FIL_CONTENT2", "FIL_BANNER_TITLE2", "FIL_CONTENT3", "FIL_CONTENT4", "FIL_CONTENT5", "FIL_CONTENT6", "FIL_CONTENT7",
      "FIL_CONTENT8", "FIL_CONTENT9", "FIL_CONTENT10", "FIL_CONTENT11", "FIL_CONTENT12", "FIL_CONTENT13", "FIL_TEAM_ITEM_DES1", "FIL_TEAM_ITEM_DES2", "FIL_TEAM_ITEM_DES3",
      "FIL_TEAM_ITEM_DES4", "FIL_TEAM_ITEM_DES5", "FIL_CONTENT14", "FIL_CONTENT", "FIL_BANNER_TITLE_ACTIVITIES2", "FIL_BANNER_TITLE_FLIGHT2",
      "FIL_WHAT_IS_CONTENT", "FIL_USE_CASE_CONTENT1", "FIL_USE_CASE_CONTENT2", "FIL_MORE_USE_CASE_CONTENT1", "FIL_MORE_USE_CASE_CONTENT2", "FIL_CONTENT5", "FIL_CONTENT6", "FIL_CONTENT7",};
    boolean b10 = verifyListItemByListExpect(contentAllPage, FIL_CONTENT_LIST, FIL_CONTENT_DYNAMIC);
    if (!b10) {
      System.out.println("FIL_CONTENT wrong! ");
    }
    return b10;
  }




}
