package pages.hotel.footer.support;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MyTripPage extends AbstractPage {
  WebDriver driver;

  public MyTripPage(WebDriver driver_) {
    this.driver = driver_;
  }
}
