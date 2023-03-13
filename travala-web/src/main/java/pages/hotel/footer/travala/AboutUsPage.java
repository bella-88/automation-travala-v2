package pages.hotel.footer.travala;

import org.openqa.selenium.WebDriver;

import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.travala.AboutUsPageUI.ABOUT_US_CONTENT_LIST;

public class AboutUsPage extends CommonHotelPages {
  WebDriver driver;

  public AboutUsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyTextAtAboutPage() {
    String[] content = {"AboutUs_FirstContents", "AboutUs_SecondContents", "AboutUs_ThirdContents", "AboutUs_FourthContents", "MENU_AboutUs_TITLE",
      "AboutUs_ViewMoreBtn", "AboutUs_ViewMoreContent2","AboutUs_ViewMoreContent1","AboutUs_ViewMore_Content"};
    if (compareTwoListByKey(content,ABOUT_US_CONTENT_LIST)&& verifyUrlPage(ABOUT_US_PATH)) {
      System.out.println("Text at About page correct");
    } else {
      System.out.println("Text at About page wrong");
    }
  }
}
