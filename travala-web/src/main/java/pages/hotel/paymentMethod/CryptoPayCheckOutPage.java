package pages.hotel.paymentMethod;

import commons.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CryptoPayCheckOutPage extends AbstractPage {
  WebDriver driver;

  public CryptoPayCheckOutPage(WebDriver driver_) {
    this.driver = driver_;
    }
  public String getTextCryptoPayPage(String locator) {
    return driver.findElement(By.xpath(locator)).getText();
  }
}

