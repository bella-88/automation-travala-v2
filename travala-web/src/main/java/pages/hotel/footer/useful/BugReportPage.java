package pages.hotel.footer.useful;

import commons.AbstractPage;

import interfaces.hotel.footer.useful.BugReportPageUI;
import org.openqa.selenium.WebDriver;

public class BugReportPage extends AbstractPage {
  WebDriver driver;

  public BugReportPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public String getBugReporText() {
    String actualBugReporText = getTextElement(driver, BugReportPageUI.BUG_REPORT_TXT);
    return actualBugReporText;
  }
  public String getCurrentBugReportUrl(WebDriver driver) {
    return getCurrentUrl(driver);
  }
}
