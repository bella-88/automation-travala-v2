package pages.hotel.footer.resources;

import commons.AbstractPage;
import interfaces.hotel.footer.resources.OfficalBlogPageUI;
import org.openqa.selenium.WebDriver;

public class OfficalBlogPage extends AbstractPage {
  WebDriver driver;

  public OfficalBlogPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public String getOfficalBlogText() {
    String actualOfficalBlogText = getTextElement(driver, OfficalBlogPageUI.OFFICAL_BLOG_TXT);
    return actualOfficalBlogText;
  }
}
