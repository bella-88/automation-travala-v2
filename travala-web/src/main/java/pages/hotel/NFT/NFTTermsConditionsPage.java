package pages.hotel.NFT;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.NFT.NFTTermsConditionsPageUI.*;


public class NFTTermsConditionsPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;


  public NFTTermsConditionsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyContent() {
    String[] title = {"NFT_TERM_TITLE1", "NFT_TERM_TITLE2", "NFT_TERM_TITLE3", "NFT_TERM_TITLE4", "NFT_TERM_TITLE5", "NFT_TERM_TITLE6", "NFT_TERM_TITLE7",
      "NFT_TERM_TITLE8", "NFT_TERM_TITLE9", "NFT_TERM_TITLE10", "NFT_TERM_TITLE11", "NFT_TERM_TITLE12", "NFT_TERM_TITLE13", "NFT_TERM_TITLE14", "NFT_TERM_TITLE15",
      "NFT_TERM_TITLE16", "NFT_TERM_TITLE17"};
    boolean btitle = verifyListItemByListExpect(title, NFT_TERM_TITLE_LIST, NFT_TERM_TITLE_DYNAMIC);
    if (!btitle) {
      System.out.println("Text at Title of NFT Term wrong! ");
    }

    String[] content = {"NFT_TERM_CONTENT1", "NFT_TERM_CONTENT2", "NFT_TERM_CONTENT3",
      "NFT_TERM_CONTENT4", "NFT_TERM_CONTENT5", "NFT_TERM_CONTENT6", "NFT_TERM_CONTENT7", "NFT_TERM_CONTENT8", "NFT_TERM_CONTENT9", "NFT_TERM_CONTENT10", "NFT_TERM_CONTENT11",
      "NFT_TERM_CONTENT12", "NFT_TERM_CONTENT13", "NFT_TERM_CONTENT14", "NFT_TERM_CONTENT15", "NFT_TERM_CONTENT16", "NFT_TERM_CONTENT17", "NFT_TERM_CONTENT18", "NFT_TERM_CONTENT19",
      "NFT_TERM_CONTENT20", "NFT_TERM_CONTENT21", "NFT_TERM_CONTENT22", "NFT_TERM_CONTENT23", "NFT_TERM_CONTENT24", "NFT_TERM_CONTENT25", "NFT_TERM_CONTENT26", "NFT_TERM_CONTENT27",
      "NFT_TERM_CONTENT28", "NFT_TERM_CONTENT29", "NFT_TERM_CONTENT30", "NFT_TERM_CONTENT31", "NFT_TERM_CONTENT32", "NFT_TERM_CONTENT33"};
    boolean bContent = verifyTwoList(addListActualFromListXpath(NFT_TERM_CONTENT_LIST), addListExpectByKey(content));
    if (!bContent) {
      System.out.println("Text at Content of NFT Term wrong! ");
    }
    String[] subContent = {"NFT_TERM_SUB_CONTENT1", "NFT_TERM_SUB_CONTENT2", "NFT_TERM_SUB_CONTENT3",
      "NFT_TERM_SUB_CONTENT4", "NFT_TERM_SUB_CONTENT5", "NFT_TERM_SUB_CONTENT6", "NFT_TERM_SUB_CONTENT7", "NFT_TERM_SUB_CONTENT8", "NFT_TERM_SUB_CONTENT9", "NFT_TERM_SUB_CONTENT10", "NFT_TERM_SUB_CONTENT11",
      "NFT_TERM_SUB_CONTENT12", "NFT_TERM_SUB_CONTENT13", "NFT_TERM_SUB_CONTENT14", "NFT_TERM_SUB_CONTENT15", "NFT_TERM_SUB_CONTENT16", "NFT_TERM_SUB_CONTENT17", "NFT_TERM_SUB_CONTENT18", "NFT_TERM_SUB_CONTENT19",
      "NFT_TERM_SUB_CONTENT20", "NFT_TERM_SUB_CONTENT21", "NFT_TERM_SUB_CONTENT22", "NFT_TERM_SUB_CONTENT23", "NFT_TERM_SUB_CONTENT24", "NFT_TERM_SUB_CONTENT25", "NFT_TERM_SUB_CONTENT26", "NFT_TERM_SUB_CONTENT27",
      "NFT_TERM_SUB_CONTENT28", "NFT_TERM_SUB_CONTENT29", "NFT_TERM_SUB_CONTENT30", "NFT_TERM_SUB_CONTENT31", "NFT_TERM_SUB_CONTENT32", "NFT_TERM_SUB_CONTENT33", "NFT_TERM_SUB_CONTENT34", "NFT_TERM_SUB_CONTENT35",
      "NFT_TERM_SUB_CONTENT36", "NFT_TERM_SUB_CONTENT37", "NFT_TERM_SUB_CONTENT38", "NFT_TERM_SUB_CONTENT39", "NFT_TERM_SUB_CONTENT40", "NFT_TERM_SUB_CONTENT41", "NFT_TERM_SUB_CONTENT42", "NFT_TERM_SUB_CONTENT43",
      "NFT_TERM_SUB_CONTENT44", "NFT_TERM_SUB_CONTENT45", "NFT_TERM_SUB_CONTENT46"};
    boolean bSubContent=  verifyTwoList(addListActualFromListXpath(NFT_TERM_SUB_CONTENT_LIST), addListExpectByKey(subContent));
    if (!bSubContent) {
      System.out.println("Text at Sub Content of NFT Term wrong! ");
    }
//
    String[] sub1Content = {"NFT_TERM_SUB1_CONTENT1", "NFT_TERM_SUB1_CONTENT2", "NFT_TERM_SUB1_CONTENT3",
      "NFT_TERM_SUB1_CONTENT4", "NFT_TERM_SUB1_CONTENT5", "NFT_TERM_SUB1_CONTENT6", "NFT_TERM_SUB1_CONTENT7", "NFT_TERM_SUB1_CONTENT8", "NFT_TERM_SUB1_CONTENT9", "NFT_TERM_SUB1_CONTENT10", "NFT_TERM_SUB1_CONTENT11",
      "NFT_TERM_SUB1_CONTENT12", "NFT_TERM_SUB1_CONTENT13", "NFT_TERM_SUB1_CONTENT14", "NFT_TERM_SUB1_CONTENT15", "NFT_TERM_SUB1_CONTENT16", "NFT_TERM_SUB1_CONTENT17", "NFT_TERM_SUB1_CONTENT18", "NFT_TERM_SUB1_CONTENT19",
      "NFT_TERM_SUB1_CONTENT20", "NFT_TERM_SUB1_CONTENT21", "NFT_TERM_SUB1_CONTENT22", "NFT_TERM_SUB1_CONTENT23", "NFT_TERM_SUB1_CONTENT24", "NFT_TERM_SUB1_CONTENT25", "NFT_TERM_SUB1_CONTENT26", "NFT_TERM_SUB1_CONTENT27",
      "NFT_TERM_SUB1_CONTENT28", "NFT_TERM_SUB1_CONTENT29", "NFT_TERM_SUB1_CONTENT30", "NFT_TERM_SUB1_CONTENT31", "NFT_TERM_SUB1_CONTENT32", "NFT_TERM_SUB1_CONTENT33", "NFT_TERM_SUB1_CONTENT34"};
    boolean b1 = verifyTwoList(addListActualFromListXpath(NFT_TERM_SUB1_CONTENT_LIST, NFT_TERM_SUB1_CONTENT_DYNAMIC), addListExpectByKey(sub1Content));
    if (!b1) {
      System.out.println("Text at Sub 1 Content of NFT Term wrong! ");
    }
   boolean meta = StringUtils.contains("NFT Purchase Agreement and Platform Terms of Use | Travala.com", getTitlePage(driver));
//    System.out.println("title: "+ getTitlePage(driver));
//    System.out.println("meta: "+ g(driver));
    check = btitle && bContent && bSubContent && b1&& meta;
    if (check) {
      System.out.println("Text at NFT Term correct! ");
    } else {
      System.out.println("Text at NFT Term wrong! ");
    }
    return check;
  }


}
