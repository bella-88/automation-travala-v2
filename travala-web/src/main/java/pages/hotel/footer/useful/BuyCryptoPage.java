package pages.hotel.footer.useful;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BuyCryptoPage extends AbstractPage {
  WebDriver driver;

  public BuyCryptoPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getCurrentBuyCryptotUrl(WebDriver driver) {
    return getCurrentUrl(driver);
  }
}
