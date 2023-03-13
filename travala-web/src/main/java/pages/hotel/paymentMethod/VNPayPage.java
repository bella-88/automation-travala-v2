package pages.hotel.paymentMethod;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class VNPayPage extends AbstractPage {
  WebDriver driver;

  public VNPayPage(WebDriver driver_) {
    this.driver = driver_;
    driver_.manage().deleteAllCookies();
  }
}

