package pages.hotel.footer.travala;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.footer.travala.TermFlightPaidPageUI.*;

public class TermFlightPaid extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public TermFlightPaid(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextOnThePage() {
//    String[] header = {"ACTIVE_NFT_HEADING", "ACTIVE_NFT_BANNER", "ACTIVE_NFT_SUB_BANNER"};
//    String[] xpath = {ACTIVE_NFT_HEADING, ACTIVE_NFT_BANNER, ACTIVE_NFT_SUB_BANNER};
//    boolean bheader = verifyTwoListByKey(header, xpath);
    String[] title = {"FLIGHT_PAID_TITLE1", "FLIGHT_PAID_TITLE2", "FLIGHT_PAID_TITLE3","FLIGHT_PAID_TITLE4"};
    boolean bTitle = compareTwoListByKey(title, FLIGHT_PAID_TITLE);
    String[] content = { "FLIGHT_PAID_CONTENT1", "FLIGHT_PAID_CONTENT2", "FLIGHT_PAID_CONTENT3", "FLIGHT_PAID_CONTENT4"
      , "FLIGHT_PAID_CONTENT5", "FLIGHT_PAID_CONTENT6", "FLIGHT_PAID_CONTENT7", "FLIGHT_PAID_CONTENT8", "FLIGHT_PAID_CONTENT9", "FLIGHT_PAID_CONTENT10"
      , "FLIGHT_PAID_CONTENT11", "FLIGHT_PAID_CONTENT12", "FLIGHT_PAID_CONTENT13", "FLIGHT_PAID_CONTENT14", "FLIGHT_PAID_CONTENT16", "FLIGHT_PAID_CONTENT17"
      , "FLIGHT_PAID_CONTENT18", "FLIGHT_PAID_CONTENT19", "FLIGHT_PAID_CONTENT20", "FLIGHT_PAID_CONTENT21", "FLIGHT_PAID_CONTENT22", "FLIGHT_PAID_CONTENT23"};
    String[] subTitle = { "FLIGHT_PAID_SUB_TITLE1", "FLIGHT_PAID_SUB_TITLE2"};
    boolean bSubTitle = compareTwoListByKey(subTitle, FLIGHT_PAID_SUB_TITLE);

    boolean bContent = compareTwoListByKey(content, FLIGHT_PAID_CONTENT);
    String[] subContent = {  "FLIGHT_PAID_SUB_CONTENT1","FLIGHT_PAID_SUB_CONTENT2","FLIGHT_PAID_SUB_CONTENT3","FLIGHT_PAID_SUB_CONTENT4","FLIGHT_PAID_SUB_CONTENT5"
      ,"FLIGHT_PAID_SUB_CONTENT6","FLIGHT_PAID_SUB_CONTENT7","FLIGHT_PAID_SUB_CONTENT8","FLIGHT_PAID_SUB_CONTENT9","FLIGHT_PAID_SUB_CONTENT10"
      ,"FLIGHT_PAID_SUB_CONTENT11","FLIGHT_PAID_SUB_CONTENT12","FLIGHT_PAID_SUB_CONTENT13","FLIGHT_PAID_SUB_CONTENT14","FLIGHT_PAID_SUB_CONTENT16","FLIGHT_PAID_SUB_CONTENT17"
      ,"FLIGHT_PAID_SUB_CONTENT18","FLIGHT_PAID_SUB_CONTENT19","FLIGHT_PAID_SUB_CONTENT20","FLIGHT_PAID_SUB_CONTENT21","FLIGHT_PAID_SUB_CONTENT22",
      "FLIGHT_PAID_SUB_CONTENT23","FLIGHT_PAID_SUB_CONTENT24"};
    verifyMetaPage("FLIGHT_PAID_META");
    boolean bsubContent = compareTwoListByKey(subContent, FLIGHT_PAID_SUB_CONTENT);
    status = bTitle && bSubTitle&& bContent && bsubContent ;
    if (!status) {
      System.out.println("Content at TravelSmart Protection Term page wrong");
    } else {
      System.out.println("Content at TravelSmart Protection Term page correct");
    }
    switchTab(driver);
  }

}
