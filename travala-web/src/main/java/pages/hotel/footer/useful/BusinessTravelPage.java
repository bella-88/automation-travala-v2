package pages.hotel.footer.useful;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

import static interfaces.hotel.footer.useful.BusinessTravelPageUI.BUSINESS_TRAVEL_TXT;

public class BusinessTravelPage extends AbstractPage {
  WebDriver driver;

  public BusinessTravelPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getBusinessTravelText() {
    String actualBusinessTravelText = getTextElement(driver, BUSINESS_TRAVEL_TXT);
    return actualBusinessTravelText;
  }
}
