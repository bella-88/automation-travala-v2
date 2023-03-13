package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TwitterPage extends AbstractPage {
  WebDriver driver;

  public TwitterPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getTwitterUrl(WebDriver driver) {
    String actualTwitterText = getCurrentUrl(driver);
    return actualTwitterText;
  }
}
