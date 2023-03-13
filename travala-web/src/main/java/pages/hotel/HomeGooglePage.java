package pages.hotel;

import commons.AbstractPage;
import org.openqa.selenium.*;


public class HomeGooglePage extends AbstractPage {
  WebDriver driver;

  public HomeGooglePage(WebDriver driver_) {
    this.driver = driver_;
  }

  public void clickToSelectGmail() {
    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
    driver.findElement(By.linkText("https://mail.google.com/mail")).sendKeys(selectLinkOpeninNewTab);

    WebElement element = driver.findElement(By.xpath("//*[name()='svg' and @class='gb_Xe']"));
    element.click();
//    waitElement(driver,"//ul[@class='LVal7b u4RcUd']");
    clickToElementByJavascript(driver, "//span[text()='Gmail']");
  }

  public void linkToGmail() {

    ((JavascriptExecutor)driver).executeScript("window.open()");
    driver.get("https://mail.google.com");
//    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//    driver.switchTo().window(tabs.get(1));
////    driver.get("http://google.com");
////    Actions newTab = new Actions(driver);
////    newTab.sendKeys(Keys.CONTROL + "t").perform();
//
//    WebElement element = driver.findElement(By.xpath("//*[name()='svg' and @class='gb_Xe']"));
//    clickToElement(driver,"//*[name()='svg' and @class='gb_Xe']");
//    try {
//      Thread.sleep(5000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    waitElement(driver,"//ul[@class='LVal7b u4RcUd']");
//    clickToElementByJavascript(driver,"//span[@class='MrEfLc' and @pid='23']");
//    return new GmailPage(driver);
  }
}
