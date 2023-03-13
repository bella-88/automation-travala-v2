package pages.hotel.footer.useful;

import commons.AbstractPage;

import interfaces.hotel.footer.useful.SiteMapPageUI;
import org.openqa.selenium.WebDriver;

public class SiteMapPage extends AbstractPage {
  WebDriver driver;

  public SiteMapPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getSiteMapText() {
    String actualSiteMapText = getTextElement(driver, SiteMapPageUI.POPULAR_COUNTRIES_TERRITORIES_TXT);
    return actualSiteMapText;
  }
}
