package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class InstagramPage extends AbstractPage {
  WebDriver driver;

  public InstagramPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getInstagramUrl(WebDriver driver) {
    String actualInstagramText = getCurrentUrl(driver);
    return actualInstagramText;
  }
}
