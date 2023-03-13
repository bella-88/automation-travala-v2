package pages.hotel.footer.useful;

import commons.AbstractPage;
import interfaces.hotel.footer.useful.MobileAppsPageUI;
import org.openqa.selenium.WebDriver;

public class MobileAppsPage extends AbstractPage {
  WebDriver driver;

  public MobileAppsPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public String getMobileAppsText() {
    String actualMobileAppsText = getTextElement(driver, MobileAppsPageUI.MOBILE_APP_TXT);
    return actualMobileAppsText;
  }
}
