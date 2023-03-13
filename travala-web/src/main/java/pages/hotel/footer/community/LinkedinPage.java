package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LinkedinPage extends AbstractPage {
  WebDriver driver;

  public LinkedinPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getLinkedinUrl(WebDriver driver) {
    String actualLinkedinText = getCurrentUrl(driver);
    return actualLinkedinText;
  }
}
