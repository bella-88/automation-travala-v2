package pages.hotel.NFT;

import commons.hotel.CommonHotelPages;
import org.openqa.selenium.WebDriver;

public class NFTHomePage extends CommonHotelPages {
  WebDriver driver;
  boolean status;
  boolean check = true;
private NFTHomePage nftHomePage;

  public NFTHomePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
    nftHomePage = new NFTHomePage(driver);
  }

}
