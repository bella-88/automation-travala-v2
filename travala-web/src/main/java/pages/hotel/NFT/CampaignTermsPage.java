package pages.hotel.NFT;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;
import static interfaces.hotel.NFT.CampaignGiveAwayTermsPageUI.*;

public class CampaignTermsPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;


  public CampaignTermsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyContent() {
    String[] title = {"CAMPAIGN_TERM_TITLE1", "CAMPAIGN_TERM_TITLE2", "CAMPAIGN_TERM_TITLE3", "CAMPAIGN_TERM_TITLE4", "CAMPAIGN_TERM_TITLE5", "CAMPAIGN_TERM_TITLE6", "CAMPAIGN_TERM_TITLE7",
      "CAMPAIGN_TERM_TITLE8", "CAMPAIGN_TERM_TITLE9", "CAMPAIGN_TERM_TITLE10"};
    boolean bTitle =compareTwoListByKey(title, CAMPAIGN_GIVE_AWAY_TERM_TITLE_LIST) ;
    if (!bTitle) {
      System.out.println("Text at Title of Campaign GiveAway Term wrong! ");
    }
    String[] content = {"CAMPAIGN_TERM_CONTENT1", "CAMPAIGN_TERM_CONTENT2", "CAMPAIGN_TERM_CONTENT3", "CAMPAIGN_TERM_CONTENT4", "CAMPAIGN_TERM_CONTENT5",
      "CAMPAIGN_TERM_CONTENT6", "CAMPAIGN_TERM_CONTENT7", "CAMPAIGN_TERM_CONTENT8", "CAMPAIGN_TERM_CONTENT9", "CAMPAIGN_TERM_CONTENT10"};
    boolean bContent =compareTwoListByKey(content, CAMPAIGN_GIVE_AWAY_TERM_CONTENT_LIST);
    if (!bContent) {
      System.out.println("Text at Content of Campaign GiveAway Term wrong! ");
    }
    String[] subContent =  { "CAMPAIGN_TERM_SUB_CONTENT2", "CAMPAIGN_TERM_SUB_CONTENT3", "CAMPAIGN_TERM_SUB_CONTENT4", "CAMPAIGN_TERM_SUB_CONTENT5"};
    boolean bSubContent =compareTwoListByKey(subContent, CAMPAIGN_GIVE_AWAY_TERM_SUB_CONTENT_LIST);
    if (!bSubContent) {
      System.out.println("Text at Sub Content The Prize of Campaign GiveAway Term wrong! ");
    }
    String[] subContent1 =  {"CAMPAIGN_TERM_SUB_CONTENT1",  "CAMPAIGN_TERM_SUB_CONTENT6", "CAMPAIGN_TERM_SUB_CONTENT7",
      "CAMPAIGN_TERM_SUB_CONTENT8", "CAMPAIGN_TERM_SUB_CONTENT9", "CAMPAIGN_TERM_SUB_CONTENT10","CAMPAIGN_TERM_SUB_CONTENT11"};
    boolean bSubContent1 =compareTwoListByKey(subContent1, CAMPAIGN_GIVE_AWAY_TERM_SUB1_CONTENT_LIST);
    if (!bSubContent1) {
      System.out.println("Text at Sub Content 1 The Prize of Campaign GiveAway Term wrong! ");
    }
    check = bTitle && bContent &&bSubContent ;
    if (check) {
      System.out.println("Text at Campaign GiveAway Term correct! ");
    } else {
      System.out.println("Text at Campaign GiveAway Term wrong! ");
    }
    return check;
  }


}
