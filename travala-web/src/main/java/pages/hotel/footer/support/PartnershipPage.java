package pages.hotel.footer.support;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.footer.support.PartnershipPageUI.*;
import static commons.CommonHotelURL.*;

public class PartnershipPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;

  public PartnershipPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextPartnerShip() {
    String[] menu = {"PARTNER_SHIP_MENU1", "PARTNER_SHIP_MENU2", "PARTNER_SHIP_MENU3", "PARTNER_SHIP_MENU4", "PARTNER_SHIP_MENU5",
      "PARTNER_SHIP_MENU6", "PARTNER_SHIP_MENU7", "PARTNER_SHIP_MENU8", "PARTNER_SHIP_MENU9", "PARTNER_SHIP_MENU10"};
    String[] title = {"PARTNER_SHIP_TITLE1", "PARTNER_SHIP_TITLE2", "PARTNER_SHIP_TITLE3", "PARTNER_SHIP_TITLE4", "PARTNER_SHIP_TITLE5",
      "PARTNER_SHIP_TITLE6", "PARTNER_SHIP_TITLE7", "PARTNER_SHIP_TITLE8", "PARTNER_SHIP_TITLE9", "PARTNER_SHIP_TITLE10"};
    String[] content = {"PARTNER_SHIP_CONTENT1", "PARTNER_SHIP_CONTENT2", "PARTNER_SHIP_CONTENT3", "PARTNER_SHIP_CONTENT4", "PARTNER_SHIP_CONTENT5",
      "PARTNER_SHIP_CONTENT6", "PARTNER_SHIP_CONTENT7", "PARTNER_SHIP_CONTENT8", "PARTNER_SHIP_CONTENT9", "PARTNER_SHIP_CONTENT10", "PARTNER_SHIP_CONTENT11",
      "PARTNER_SHIP_CONTENT12", "PARTNER_SHIP_CONTENT13", "PARTNER_SHIP_CONTENT14",
      "PARTNER_SHIP_CONTENT15", "PARTNER_SHIP_CONTENT16", "PARTNER_SHIP_CONTENT17", "PARTNER_SHIP_CONTENT18", "PARTNER_SHIP_CONTENT19",
      "PARTNER_SHIP_CONTENT20", "PARTNER_SHIP_CONTENT21", "PARTNER_SHIP_CONTENT22", "PARTNER_SHIP_CONTENT23", "PARTNER_SHIP_CONTENT24",
      "PARTNER_SHIP_CONTENT25", "PARTNER_SHIP_CONTENT26", "PARTNER_SHIP_CONTENT27", "PARTNER_SHIP_CONTENT28", "PARTNER_SHIP_CONTENT29",
      "PARTNER_SHIP_CONTENT30", "PARTNER_SHIP_CONTENT31", "PARTNER_SHIP_CONTENT32", "PARTNER_SHIP_CONTENT33", "PARTNER_SHIP_CONTENT34",
      "PARTNER_SHIP_CONTENT35", "PARTNER_SHIP_CONTENT36", "PARTNER_SHIP_CONTENT37", "PARTNER_SHIP_CONTENT38"};
    boolean b1 = verifyListItemByListExpect(menu, PARTNER_SHIP_MENU_LIST, PARTNER_SHIP_MENU_DYNAMIC);
    if (!b1) {
      System.out.println("Text at Menu partner ship wrong! ");
    }
    boolean b2 = verifyListItemByListExpect(title, PARTNER_SHIP_TITLE_LIST, PARTNER_SHIP_TITLE_DYNAMIC);
    if (!b2) {
      System.out.println("Text at title partner ship wrong! ");
    }
    boolean b3 = verifyListItemByListExpect(content, PARTNER_SHIP_CONTENT_LIST, PARTNER_SHIP_CONTENT_DYNAMIC);
    if (!b3) {
      System.out.println("Text at content title partner ship wrong! ");
    }
    String[] subContent = {"PARTNER_SHIP_TITLE", "PARTNER_SHIP_SUB_CONTENT1", "PARTNER_SHIP_SUB_CONTENT2"};
    String[] xpath = {PARTNER_SHIP_TITLE, PARTNER_SHIP_SUB_CONTENT1, PARTNER_SHIP_SUB_CONTENT2};
    boolean b4 = verifyTwoListByKey(subContent, xpath);
    if (!b4) {
      System.out.println("Text at sub content partner ship wrong! ");
    }
    check = b1 && b2 && b3 & b4&& verifyUrlPage(PARTNER_SHIP_PATH);
    if (!check) {
      System.out.println("Text at partner ship  wrong! ");
    }
    return check;
  }


}
