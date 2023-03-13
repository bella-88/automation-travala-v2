package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FacebookPage extends AbstractPage {
  WebDriver driver;

  public FacebookPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getFacebookUrl(WebDriver driver) {
    String actualFacebookText = getCurrentUrl(driver);
    return actualFacebookText;
  }
}
