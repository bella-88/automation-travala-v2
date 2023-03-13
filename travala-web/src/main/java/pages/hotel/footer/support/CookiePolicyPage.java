package pages.hotel.footer.support;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.support.CookiePolicyPageUI.*;

public class CookiePolicyPage extends CommonHotelPages {
  WebDriver driver;
boolean status = true;
  public CookiePolicyPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }
  public boolean getCookiePolicyText() {
    status = StringUtils.contains(getTextFromReadFile("COOKIES_CONTENT"), getTextElement(driver, COOKIE_MAIN_TITLE).replaceAll("\\r\\n|\\r|\\n", " "));
    if(!status){
      System.out.println("Expect Content: "+ getTextFromReadFile("COOKIES_CONTENT"));
      System.out.println("Actual Content: "+ getTextElement(driver, COOKIE_MAIN_TITLE).replaceAll("\\r\\n|\\r|\\n", " "));
    }
    return status&& verifyUrlPage(COOKIE_POLICY_PATH);
  }
}
