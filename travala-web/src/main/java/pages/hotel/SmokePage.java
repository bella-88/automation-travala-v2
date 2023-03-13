package pages.hotel;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static commons.CommonTravalaURL.YOP_MAIL_URL;
import static interfaces.hotel.LandingPageUI.*;
import static interfaces.hotel.SmokePageUI.*;

public class SmokePage extends CommonHotelPages {
  WebDriver driver;
  static boolean check = true;
  static boolean status = true;

  public SmokePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }
  public void selectLanguage(String language) {
    driver.findElement(By.xpath(LANGUAGE_ICON)).click();
    switch (language) {
      case "es-flag":
        System.out.println("ES language");
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        wait300Time();
        break;
      case "us-flag":
        System.out.println("US language");
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        wait1sTime();
        break;
      case "en-flag":
        System.out.println("UK language");
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        wait1sTime();
        break;
      case "vn-flag":
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        wait100Time();
        break;
      case "de-flag":
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        break;
      case "fr-flag":
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        wait2sTime();
        break;
      case "kr-flag":
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        System.out.println("");
        break;
      case "cn-flag":
        System.out.println("");
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        break;
      case "ru-flag":
        System.out.println("  ");
        clickToElementByDynamicLocatorWithJS(driver, DESTINATION_LANGUAGE, language);
        break;
      default:
        System.out.println("Please select another language ");
        break;
    }
  }


  public void verifyNFTOnOpenSea() {
    String str = "https://opensea.io/assets/0x55700cd2e91f39bc56f589b346dac12a7907ea08/%d";
    for (int i = 901; i <= 1000; i++) {
      String url = String.format(str, i);
      openNewTab(driver, url);
      clickToElement(driver, "(//div[contains(@class,'item--collection-toolbar-wrapper')]/div/button/div/i)[1]");
      System.out.println("url: " + url);
      wait300Time();
    }
  }

  public void verifyNFTOnLookSrare() {
    String str = "https://looksrare.org/collections/0x55700cd2E91f39bc56F589B346daC12a7907eA08/%s";
    for (int i = 903; i <= 1000; i++) {
      String url = String.format(str, i);
      openNewTab(driver, url);
      clickToElement(driver, "(//button[contains(@id,'popover-trigger')])[2]//*[name()='svg']");
      System.out.println("url: " + url);
      wait300Time();
    }
  }

  public void verifyNFTOnRarible() {
    String str = "https://rarible.com/token/0x55700cd2e91f39bc56f589b346dac12a7907ea08:%d?tab=details";
    for (int i = 716; i <= 1000; i++) {
      String url = String.format(str, i);
      openNewTab(driver, url);
      clickToElement(driver, "//button[contains(@data-marker,'root/appPage/token/sidebar/header/actions/trigger')]//*[name()='svg']");
      wait100Time();
      clickToElement(driver, "//div[text()='Refresh Metadata']");
      System.out.println("url: " + url);
      wait300Time();
    }
  }

  public void verifyWalletNFT() {

   String [] exp = null;
    openNewTab(driver, "https://etherscan.io/");
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < exp.length; i++) {
      expect.add(exp[i].trim());
    }
    clickToElement(driver, "//input[@id='txtSearchInput']");

    for (String wallet : expect
    ) {
      System.out.println(wallet);
      sendkeysToElement(driver, "//input[@id='txtSearchInput']", wallet);
      clickToElementByJavascript(driver, "//div[@class='input-group-append']/button");
      switchToOtherWindowbyUrl(driver, "https://etherscan.io/");
      wait100Time();
      String act = getTextElement(driver, "//div[contains(@class,'align-items-center')]/div/h1") + " " + wallet;
      if (StringUtils.contains(act, "Address")) {
        System.out.println("Wallet Valid");
      } else {
        System.out.println("Actual: " + act);
        System.out.println("INVALID");
      }
      backToPreviousPage(driver);
      wait100Time();
    }
//    sendkeysToElement(driver,"//input[@id='txtSearchInput']","0x7503cf5f5ef21e0bead6628dcf9198bc2c869ca0");
//    sendkeysToElement(driver,"//input[@id='txtSearchInput']","0x7503cf5f5ef21e0bead6628dcf9198bc2c869ca0");
//    clickToElementByJavascript(driver,"//div[@class='input-group-append']/button");
//    switchToOtherWindowbyUrl(driver,"https://etherscan.io/");
//    wait100Time();
//    String act = getTextElement(driver,"//div[contains(@class,'align-items-center')]/div/h1");
//    if(StringUtils.contains(act,"Address")){
//      System.out.println("Valid");
//    } else {
//      System.out.println("Actual: "+ act);
//      System.out.println("INVALID");
//    }


  }

  public void createYopMail() {
    int i = 1;
    while (i < 100) {
//      openNewTab(driver, YOP_MAIL_URL);
//      clearTextBox(driver,INPUT_EMAIL_TXT);
//      clickToElement(driver, INPUT_EMAIL_TXT);
//      sendkeysToElement(driver, INPUT_EMAIL_TXT, randomYopMail());
//
      System.out.println(randomYopMail() + "@yopmail.com");
//      backToPreviousPage(driver);
      i++;
    }
  }

  public String getYopEmail() {
    openNewTab(driver, YOP_MAIL_URL);
    switchToWindowByUrlContainsString(driver, "https://yopmail.com/en/wm");
    String email = getTextElement(driver, YOP_MAIL_NAME);
    return email;
  }

  public void confirmRegisterAccByYopMail() {
    String[] exp = {"thuhuong538@yopmail.com"
    };
    List<String> expect = new ArrayList<>();
    for (int i = 0; i < exp.length; i++) {
      expect.add(exp[i].trim());
    }
    for (String email : expect
    ) {
      openNewTab(driver, YOP_MAIL_URL);
      for (int i = 1; i < 2; i++) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");
        //Switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(YOP_MAIL_URL);
        clearTextBox(driver, INPUT_EMAIL_TXT);
        sendkeysToElement(driver, INPUT_EMAIL_TXT, email);
        clickToElement(driver, CONTINUE_BTN);
      }
//      clickToElement(driver,CONFIRM_LINK);
      wait1sTime();
    }
  }

  public void splitTextAtLanguage() {
    String st = "\"WALLET1\"=  Ec4f93a158f27C3b3481f5754B0D9B1f3Cf366d2\n" +
      "  \"WALLET2\"=  CE11942c34Bb02a889d8049D56a16E30313CbF6f\n" +
      "  \"WALLET3\"=  eAaeA99A6d9d84104017b0720BE2a1AAF39e30cf\n" +
      "  \"WALLET1007\"=  dEfbF2ff87B09B194B26B05FF4fED7E8aB30743b";
//    Pattern MY_PATTERN = Pattern.compile("([A-Z_1-9]*=)");
//
//    Matcher m = MY_PATTERN.matcher(st);
//    while (m.find()) {
//      String s = m.group(1);
//      System.out.println("s: "+s);
//      // s now contains "LINK..."
//    }

    String[] result = st.split("\\r\\n|\\r|\\n");
    for (String s : result) {
      String ns = s.replaceAll("[^=]*$", " ");
      System.out.println("0000" + ns + "000");
    }
//    to add " and $$$$ vao sau chuoi "
//    TERM_SUB_CONTENT3 ="Travala Limited, UNIT H, GROVE MILL, ECCLESTON. UK. PR7 5TZ$$$$
//    for (String s : result) {
//      String ns = s.replaceAll("=", " =\"");
//      System.out.println(ns + "$$$$");
//    }
//    Pattern pattern = Pattern.compile(st1, Pattern.CASE_INSENSITIVE);
//    String[] result = st.split("\tern.compile(st1, Pattern.CASE_INSENSITIVE);

//      st.replaceFirst("[^=]*$","0000");
//    System.out.println("st1: "+ st);

//    List<String> listActual = new ArrayList<>();
//    String st1 = "[^=]*$";??
//
///    String st1 = "([A-Z_1-9]*=)";

//    System.out.println("st1: "+ st.replace("\n\" +","===="));

//    System.out.println("st1: "+ st.replace("[^=]*$","===="));

//int c= 0;
//    for (int i = 0; i < st.length(); i++) {
//      if(){
//        c++;
//      }
//      System.out.println("c "+c);
//    }
//      if (st1.contains(st)) {
//        System.out.println("st1: "+ st.replace("[^=]*$"," "));
//      }
//      listActual.add(st1);
//    }
//    System.out.println(" actual: "+ listActual);
//String rg =".*(=)"; //kiểm tra chuỗi bắt đầu bằng ký tự bất kỳ và kết thúc bằng ký tự =
//    String reverse = new StringBuffer(st).
//      reverse().toString();
//    String st1 = "([A-Z_1-9]*=)";
//    String st1 = "[^=]*$";// lấy chuỗi sau số =
//    System.out.println("==="+ st.replace(st1," "));
//    Regex.Replace(text, pattern, string.Empty ));
//    String st1 = "([A-Z_1-9]*=)";// lấy chuỗi đầu đến =
//    String st1 = "^[^=]*";
//    Pattern pattern = Pattern.compile(st1, Pattern.CASE_INSENSITIVE);
//    String[] result = pattern.split(st);
//    for(String s: result)    {
//      System.out.println(" ==="+ s);
  }

  public void testStringText() {
    String st1 = "TravalaSKFKAJSSFJFSFSASSD vuSKFKAJSSFJFSFSASSDDAKDD";
    String st2 = "KX6ZUFE0";
    String actual = st1.replaceAll("\\r\\n|\\r|\\n", " ").trim();
    boolean t = org.apache.commons.lang3.StringUtils.contains(actual, "Travala") && org.apache.commons.lang3.StringUtils.contains(actual, "vu");
    boolean t1 = st2.matches("[\\w0-9A-Z]*");
    System.out.println("st1: " + t);
    System.out.println("st2: " + t1);
    if (!t || !t1) {
      System.out.println("not add");
    }
  }

  public void verifyTagBankAtFooter() {
    String tagExp = "nofollow noopener noreferrer";
    boolean tag = true;
    List<WebElement> elements = driver.findElements(By.xpath(COLUMN_COMMUNITY_LIST));
    int i = 1;
    while (i < elements.size() + 1) {
      String tagAct = getAttribute(driver, String.format(COLUMN_COMMUNITY_DYNAMIC, i), "rel");
      String href = getAttribute(driver, String.format(COLUMN_COMMUNITY_DYNAMIC, i), "href");
      if (!StringUtils.contains(href,"https://www.travala.com" )) {
        System.out.println("Link of footer is : "+ href);
        System.out.println("Rel Tag is: "+ tagAct);
        tag = false;
      }
      i++;
    }
    if (tag) {
      System.out.println("Link at footer page contain rel tag name");
    } else {
      System.out.println("Link at footer page NOT contain rel tag name");
    }
  }

  public boolean verifyTagBankAtMedia() {
    String tagExp = "nofollow noopener noreferrer";
    boolean tag = true;
    List<WebElement> elements = driver.findElements(By.xpath("//a[@target='_blank' and not(contains(@href,'https://www.travala.com'))]"));
    int i = 1;
    System.out.println("There are "+ elements.size()+ " url contain REL tag");
    while (i < elements.size() + 1) {
      String tagAct = getAttribute(driver, String.format("(//a[@target='_blank' and not(contains(@href,'https://www.travala.com'))])[%s]", i), "rel");
      String href = getAttribute(driver, String.format("(//a[@target='_blank' and not(contains(@href,'https://www.travala.com'))])[%s]", i), "href");
      if (!StringUtils.contains(href,"https://www.travala.com" )) {
        System.out.println("Link is: "+ href);
        System.out.println("Rel Tag is: "+ tagAct);
        tag = false;
      }
      i++;
    }
    return tag;
  }

  public void getNameFace() {
    openNewTab(driver, "https://www.facebook.com");
    clickToElement(driver, "//input[@id='email']");
    sendkeysToElement(driver, "//input[@id='email']", "vuongtamthao99@gmail.com");
    clickToElement(driver, "//input[@id='pass']");
    sendkeysToElement(driver, "//input[@id='pass']", "");
    clickToElement(driver, "//button[@name='login']");
    switchToOtherWindowbyUrl(driver, "facebook.com");
    clickToElement(driver, "//span[contains(text(),'Bạn bè')]");
    clickToElement(driver, "//span[contains(text(),'Tất cả bạn bè')]");
    scrollToBottomPage(driver);
    wait5sTime();
    List<WebElement> element = driver.findElements(By.xpath("//div//*[name()='svg' and @data-visualcompletion='ignore-dynamic']"));
    int i = 1;
    System.out.println("List friends: " + element.size());
    String xpath = "(//div//*[name()='svg' and @data-visualcompletion='ignore-dynamic'])[%s]";
    while (i < element.size()) {
      System.out.println("Name Face " + i + " :" + getAttribute(driver, String.format(xpath, i), "aria-label"));
      wait1sTime();
      i++;
    }
  }

  public void verifyCanonicalLinkOfPage() {
    WebElement element = driver.findElement(By.xpath(CANONICAL_TAG));
    String link = element.getAttribute("href");
    System.out.println(link);
  }
  public void verifyAddedTheHrefLinkToAllTheTagA() {
//    ArrayList<String> totalTabs = new ArrayList<String>(driver.getWindowHandles());
    List<WebElement> elementsATagNotHrefLink = driver.findElements(By.xpath(A_TAG_NOT_HREF_LINK));
    Assert.assertFalse(elementsATagNotHrefLink.size() > 0);
    System.out.println("Not existing tag a not href link");
    List<WebElement> elementsATagHaveHrefLink = driver.findElements((By.xpath(A_TAG_HAVE_HREF_LINK)));
    Assert.assertTrue(elementsATagHaveHrefLink.size() > 0);
    System.out.println("Total tag a have href link: " + String.valueOf(elementsATagHaveHrefLink.size()));
//    for (WebElement element : elementsATagHaveHrefLink) {
//      String hrefLink = element.getAttribute("href");
//      System.out.println("The href link: " + hrefLink);
//      element.click();
//      ArrayList<String> totalTabsAfterClick = new ArrayList<String>(driver.getWindowHandles());
//      if(totalTabsAfterClick.size() > totalTabs.size()) {
//        switchTab(driver);
//        Assert.assertEquals(getCurrentUrl(driver), hrefLink);
//        driver.close();
//      } else {
//        Assert.assertEquals(getCurrentUrl(driver), hrefLink);
//        backToPreviousPage(driver);
//      }
//    }
  }

  public void verifyAddedRefEqualsNoopenerNoreferrer(String endpoint) {
    jsWaitForPageToLoad(driver, 10000);
    List<WebElement> elements = driver.findElements(By.xpath(A_TAG_NOT_DOMAIN_TRAVALA));
    int correct = 1;
    int incorrect = 1;
    for (WebElement element : elements) {
      if(element.getAttribute("rel").contains("noopener noreferrer")) {
        correct += 1;
      } else {
        incorrect +=1;
      }
    }
    System.out.println("Total the tag are "+ elements.size()+ " in the page " + endpoint + "\nThis page have " +(correct-1)+ " is correctly.\nAnd " + (incorrect-1) + " is incorrectly");
  }
}
