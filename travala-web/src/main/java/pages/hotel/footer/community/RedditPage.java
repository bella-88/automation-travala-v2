package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RedditPage extends AbstractPage {
  WebDriver driver;

  public RedditPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getRedditUrl(WebDriver driver) {
    String actualRedditText = getCurrentUrl(driver);
    return actualRedditText;
  }
}
