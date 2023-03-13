package pages.hotel.footer.travala;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.travala.GiftCardTermPageUI.*;

public class TravelGiftCardTermPage extends CommonHotelPages {
  WebDriver driver;

  public TravelGiftCardTermPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyContentOnThisPage() {
    String[] expectIndex = {"TERM_GIFT_CARD_INDEX1", "TERM_GIFT_CARD_INDEX2", "TERM_GIFT_CARD_INDEX3", "TERM_GIFT_CARD_INDEX4", "TERM_GIFT_CARD_INDEX5", "TERM_GIFT_CARD_INDEX6",
      "TERM_GIFT_CARD_INDEX7"};
    String[] expectContent = {"TERM_GIFT_CARD_CONTENT1", "TERM_GIFT_CARD_CONTENT2", "TERM_GIFT_CARD_CONTENT3", "TERM_GIFT_CARD_CONTENT4", "TERM_GIFT_CARD_CONTENT5",
      "TERM_GIFT_CARD_CONTENT6","TERM_GIFT_CARD_CONTENT7","TERM_GIFT_CARD_CONTENT8"};
    boolean b = StringUtils.contains(getTextFromReadFile("TERM_GIFT_CARD_TITLE"), getTextElement(driver,TERM_GIFT_CARD_TITLE));
    boolean b1 = verifyListItemByListExpect(expectIndex, TERM_GIFT_CARD_INDEX_LIST, TERM_GIFT_CARD_INDEX_DYNAMIC);
    boolean b2 = verifyListItemByListExpect(expectContent, TERM_GIFT_CARD_CONTENT_LIST, TERM_GIFT_CARD_CONTENT_DYNAMIC);
    if(b && b1 && b2){
      System.out.println("Content Travel Gift Card Term Correct");
    } else {
      System.out.println("Content Travel Gift Card Term Wrong");
    }
  }

}
