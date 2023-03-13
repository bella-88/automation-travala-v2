package pages.hotel.footer.resources;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ReadReviewsPage extends AbstractPage {
  WebDriver driver;

  public ReadReviewsPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public String getReadReviewsUrl() {
    String currentUrl = getCurrentUrl(driver);
    return currentUrl;
  }
}
