package pages.hotel;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ConfirmWithDrawPage extends AbstractPage {
  WebDriver driver;

  public ConfirmWithDrawPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public void backToMyWallet() {
    switchToOtherWindowbyTitle(driver,"My Wallet | Travala.com");

  }

}
