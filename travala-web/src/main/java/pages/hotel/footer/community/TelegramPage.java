package pages.hotel.footer.community;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TelegramPage extends AbstractPage {
  WebDriver driver;

  public TelegramPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getTelegramUrl(WebDriver driver) {
    String actualTelegramText = getCurrentUrl(driver);
    return actualTelegramText;
  }
}
