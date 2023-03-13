package pages.hotel.footer.resources;

import org.openqa.selenium.WebDriver;

import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.CAREERS_PATH;
import static interfaces.hotel.footer.resources.CareersPageUI.*;

public class CareersPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public CareersPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextCareers() {
    String[] banner = {"CAREER_BANNER", "CAREER_BANNER_BTN", "CAREER_TITLE_LIFE"};
    String[] xpath = {CAREER_BANNER, CAREER_BANNER_BTN, CAREER_TITLE_LIFE};
    if (!verifyTwoListByKey(banner, xpath) && verifyTextByKey("CAREER_BANNER_SUB", CAREER_BANNER_SUB)) {
      System.out.println("Text at Banner Careers Page wrong! ");
    }
    String[] title = {"CAREER_TITLE1", "CAREER_TITLE2", "CAREER_TITLE3", "CAREER_TITLE4", "CAREER_TITLE5"};
//    boolean b1 = verifyListItemByListExpect(title, CAREER_TITLE_LIST, CAREER_TITLE_DYNAMIC);
//
//    if (!b1) {
//      System.out.println("Text at title Careers Page wrong! ");
//    }
    String[] contentTitle = {"CAREER_CONTENT1", "CAREER_CONTENT2", "CAREER_CONTENT3", "CAREER_CONTENT4", "CAREER_CONTENT5", "CAREER_CONTENT6", "CAREER_CONTENT7", "CAREER_CONTENT8"};
//    boolean b2 = verifyListItemByListExpect(contentTitle, CAREER_CONTENT_LIST, CAREER_CONTENT_DYNAMIC);
//    if (!b2) {
//      System.out.println("Text at Content Careers Page wrong! ");
//    }
    String[] subTitle = {"CAREER_SUB_TITLE1", "CAREER_SUB_TITLE2", "CAREER_SUB_TITLE3", "CAREER_SUB_TITLE4", "CAREER_SUB_TITLE5", "CAREER_SUB_TITLE6"};
//    boolean b3 = verifyListItemByListExpect(subTitle, CAREER_SUB_TITLE_LIST, CAREER_SUB_TITLE_DYNAMIC);
//    if (!b3) {
//      System.out.println("Text at Sub Title Careers Page wrong! ");
//    }
    String[] subContent = {"CAREER_SUB_CONTENT1", "CAREER_SUB_CONTENT2", "CAREER_SUB_CONTENT3", "CAREER_SUB_CONTENT4", "CAREER_SUB_CONTENT5", "CAREER_SUB_CONTENT6"};
//    boolean b4 = verifyListItemByListExpect(subContent, CAREER_SUB_CONTENT_LIST, CAREER_SUB_CONTENT_DYNAMIC);
//    if (!b4) {
//      System.out.println("Text at Sub Content Careers Page wrong! ");
//    }
    String[] apply = {"CAREER_APPLY1", "CAREER_APPLY2", "CAREER_APPLY3", "CAREER_APPLY4"};
    boolean b5 = verifyListItemByListExpect(apply, CAREER_APPLY_LIST, CAREER_APPLY_DYNAMIC);
//    if (!b5) {
//      System.out.println("Text at Apply Careers Page wrong! ");
//    }

    if (!(verifyUrlPage(CAREERS_PATH) && compareTwoListByKey(title, CAREER_TITLE_LIST) && compareTwoListByKey(contentTitle, CAREER_CONTENT_LIST) && compareTwoListByKey(subTitle,
      CAREER_SUB_TITLE_LIST)&&compareTwoListByKey(subContent, CAREER_SUB_CONTENT_LIST)&&compareTwoListByKey(apply, CAREER_APPLY_LIST))) {
      System.out.println("Text at Careers Page wrong! ");
    }else {
      System.out.println("Text at Careers Page correct! ");
    }
  }

}
