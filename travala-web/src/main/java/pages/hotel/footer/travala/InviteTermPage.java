package pages.hotel.footer.travala;

import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;

import static interfaces.hotel.footer.travala.InviteTermPageUI.*;

public class InviteTermPage extends CommonHotelPages {
  WebDriver driver;

  public InviteTermPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyContent() {
    String[] title = {"INVITE_TERM2", "INVITE_TERM3", "INVITE_TERM4", "INVITE_TERM5",
      "INVITE_TERM6", "INVITE_TERM7", "INVITE_TERM9", "INVITE_TERM10", "INVITE_TERM11"};
    boolean bTitle = compareTwoListByKey(title, INVITE_TERM_TITLE);
    if (!bTitle) {
      System.out.println("Title on the page wrong");
    }
    String[] contentTerm = {"INVITE_TERM_CONTENT1", "INVITE_TERM_CONTENT2", "INVITE_TERM_CONTENT3", "INVITE_TERM_CONTENT4",
      "INVITE_TERM_CONTENT5", "INVITE_TERM_CONTENT6", "INVITE_TERM_CONTENT7", "INVITE_TERM_CONTENT8",
      "INVITE_TERM_CONTENT9", "INVITE_TERM_CONTENT10", "INVITE_TERM_CONTENT11", "INVITE_TERM_CONTENT12",
      "INVITE_TERM_CONTENT13", "INVITE_TERM_CONTENT14", "INVITE_TERM_CONTENT15", "INVITE_TERM_CONTENT16"};
    boolean bContent = compareTwoListByKey(contentTerm, INVITE_TERM_CONTENT);
    if (!bContent) {
      System.out.println("Content Term on the page wrong");
    }
    String[] content = {"TERM_MAIN_LINK1", "INVITE_TERM_LINK1", "INVITE_HEADING", "INVITE_TERM_TITLE"};
    String[] xpath = {INVITE_TERM_LINK, INVITE_TERM_LINK1, INVITE_HEADING, INVITE_TERM_BANNER};
    if (!(bTitle && bContent && verifyTwoListByKey(content, xpath))) {
      System.out.println("Content on the Invite Term wrong");
    } else {
      System.out.println("Content on the Invite Term correct");
    }
  }


}
