package commons;
import configs.ReaderConfigLanguage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static commons.CommonDataTravala.HIGHLIGHT_ELEMENT_TIMEOUT_FOR_DEMO;
import static commons.CommonDataTravala.LONG_TIMEOUT;

public class AbstractPage {
  WebElement element;
  List<WebElement> elements;
  JavascriptExecutor javascriptExecutor;
  WebDriverWait waitExplicit;
  By byLocator;
  Set<String> allWindows;
  boolean status;
  boolean check = true;
  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


  public void getAnyUrl(WebDriver driver, String url) {
    driver.get(url);
  }

  public void openNewTab(WebDriver driver, String url) {
    driver.navigate().to(url);
    wait300Time();
  }

  public void clearTextbox(WebDriver driver, String locator, String value) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.clear();
  }

  //======================================GET INFOMATION FROM ELEMENT===========================================================
  public String getTitlePage(WebDriver driver) {
    return driver.getTitle();
  }

  public String getCurrentUrl(WebDriver driver) {
    return driver.getCurrentUrl();
  }

  //======================================NAVIGATE PAGE===========================================================
  public void backToPreviousPage(WebDriver driver) {
    driver.navigate().back();
  }

  public void reloadPage(WebDriver driver) {
    driver.navigate().refresh();
  }

  public void highlightElement(WebDriver driver, String locator) {
    javascriptExecutor = (JavascriptExecutor) driver;
    element = driver.findElement(By.xpath(locator));
    String originalStyle = element.getAttribute("Style");
    javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", "border:3px solid red; border-style: dashed;");
    try {
      Thread.sleep(HIGHLIGHT_ELEMENT_TIMEOUT_FOR_DEMO);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);
  }

  public void scrollToBottomPage(WebDriver driver) {
    javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
  }

  public void scrollToElement(WebDriver driver, String locator) {
    javascriptExecutor = (JavascriptExecutor) driver;
    element = driver.findElement(By.xpath(locator));
    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void scrollToWebElement(WebDriver driver, WebElement element) {
    javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void scrollToTopPage(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
  }
  public void scrollToLoadMore(WebDriver driver) {
    try {
      long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
      while (true) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        if (newHeight == lastHeight) {
          break;
        }
        lastHeight = newHeight;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  //  private boolean isVisibleInViewport(WebElement element) {
//    Object data;
//    return (boolean)((JavascriptExecutor)data).executeScript(
//      "var elem = arguments[0],                 " +
//        "  box = elem.getBoundingClientRect(),    " +
//        "  cx = box.left + box.width / 2,         " +
//        "  cy = box.top + box.height / 2,         " +
//        "  e = document.elementFromPoint(cx, cy); " +
//        "for (; e; e = e.parentElement) {         " +
//        "  if (e === elem)                        " +
//        "    return true;                         " +
//        "}                                        " +
//        "return false;                            "
//      , element);
//  }
  //======================================CLICK - SENDKEYS TO ELEMENT===========================================================
  public void clearTextBox(WebDriver driver, String locator) {
    sendkeysToElement(driver, locator, Keys.CONTROL + "A");
    sendkeysToElementByKey(driver, locator, Keys.BACK_SPACE);
  }

  public void clickElement(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    waitForAllElementsPresence(driver, locator);
    element.click();
  }

  public void clickToElement(WebDriver driver, String locator) {
    highlightElement(driver, locator);
    WebDriverWait wait = new WebDriverWait(driver, 60);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    if(element.isEnabled()) {
      element.click();
    }
    wait300Time();
  }

  public void clickToListElement(WebDriver driver, String listXp) {
    List<WebElement> elements = driver.findElements(By.xpath(listXp));
    for (WebElement i : elements) {
      i.click();
      wait100Time();
    }
  }

  public void clickToElementByDynamicLocatorWithJS(WebDriver driver, String locator, String value) {
    locator = String.format(locator, value);
    highlightElement(driver, locator);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    javascriptExecutor = (JavascriptExecutor) driver;
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    javascriptExecutor.executeScript("arguments[0].click();", element);
  }

  public void clickElementByDynamicLocator(WebDriver driver, String locator, String value) {
    locator = String.format(locator, value);
    waitFoElementVisible(driver, locator);
    highlightElement(driver, locator);
    clickToElementByJavascript(driver, locator);
  }

  //Sendkey bằng javascript
  public void sendKeysToElementByJavascript(WebDriver driver, String locator, String value) {
    locator = String.format(locator, value);
    highlightElement(driver, locator);
    WebDriverWait wait = new WebDriverWait(driver, 5);
    javascriptExecutor = (JavascriptExecutor) driver;
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    javascriptExecutor.executeScript("arguments[0].value='" + value + "'", element);
    wait2sTime();
  }

  public void clickToElementByJavascript(WebDriver driver, String locator) {
    waitForAllElementsPresence(driver, locator);
    javascriptExecutor = (JavascriptExecutor) driver;
    WebElement element = driver.findElement(By.xpath(locator));
    javascriptExecutor.executeScript("arguments[0].click();", element);
  }

  public void clickToElementByJavascript(WebDriver driver, WebElement element) {
    javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("arguments[0].click();", element);
  }

  public void clickToElementByAction(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().perform();
  }

  public void getTextWhenMoveToElement(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().perform();
  }

  public void clickToElement(WebDriver driver, String locator, String value) {
    locator = String.format(locator, value);
    WebElement element = driver.findElement(By.xpath(locator));
    element.click();
  }

  public void sendkeysToElement(WebDriver driver, String locator, String text) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.clear();
    element.click();
    element.sendKeys(text);
  }

  public void sendkeysToElementByKey(WebDriver driver, String locator, Keys text) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.sendKeys(text);
  }

  public void sendkeysToElementByCSS(WebDriver driver, String locator, String text) {
    WebElement element = driver.findElement(By.cssSelector(locator));
    element.click();
    WebElement element1 = driver.findElement(By.cssSelector(locator));
    element1.sendKeys(text);
  }

  public void sendkeysToElementById(WebDriver driver, String locator, String text) {
    WebElement element = driver.findElement(By.id(locator));
    element.sendKeys(text);
  }

  public void sendkeysToListElement(WebDriver driver, String locator, String dynamicXpath, String text) {
    List<WebElement> elements = driver.findElements(By.xpath(locator));
    if (elements.size() != 0) {
      for (int i = 1; i < elements.size() + 1; i++) {
        String xpath = String.format(dynamicXpath, i);
        sendkeysToElement(driver, xpath, text);
        wait2sTime();
      }
    } else {
      System.out.println("Element don't shown");
    }
  }

  public void sendkeysToElementAtTravala(WebDriver driver, String locator, String value) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.sendKeys(value);
    element.sendKeys(Keys.TAB);
  }

  //======================================DROPDOWN-OPTION-RADIO-CHECKBOX===========================================================
  public void selectItemDropdown(WebDriver driver, String locator, String item) {
    Select select = new Select(driver.findElement(By.xpath(locator)));
    select.selectByVisibleText(item);
  }

  public void selectValueDropdown(WebDriver driver, String locator, String value) {
    Select select = new Select(driver.findElement(By.xpath(locator)));
    select.selectByVisibleText(value);
  }

  public void selectByIndexDropdown(WebDriver driver, String locator, int index) {
    Select select = new Select(driver.findElement(By.xpath(locator)));
    select.selectByIndex(index);
  }

  public void clickToDropDown(WebDriver driver, String locator) {
    WebElement dropdown = driver.findElement(By.xpath(locator));
    dropdown.click();
  }

  public void selectToOptionByItem(WebDriver driver, String locatorDropdown, String locatorOption, int item) {
    WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
    List<WebElement> options = dropdown.findElements(By.xpath(locatorOption));
    options.get(item).click();
  }

  public void selectOptionByItem(WebDriver driver, String locatorDropdown, int item) {
    Select select = new Select(driver.findElement(By.xpath(locatorDropdown)));
    select.selectByIndex(item);
  }

  public void selectDropDownByText(WebDriver driver, String locatorDropdown, String locatorOption, String value) {
    WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
    dropdown.click();
    wait100Time();
    List<WebElement> options = dropdown.findElements(By.xpath(locatorOption));
    int i = 0;
    while (i < options.size()) {
      if (StringUtils.contains(value, options.get(i).getText())) {
        options.get(i).click();
        break;
      }
    }
  }

  public int clickToDropdownGetSizeDropDown(WebDriver driver, String locatorDropdown, String locatorOption) {
    WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
    dropdown.click();
    List<WebElement> options = dropdown.findElements(By.xpath(locatorOption));
    return options.size();
  }

  public List<String> getValueFromDropDown(WebDriver driver, String locatorDropdown, String locatorOption) {
    WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
    dropdown.click();
    wait100Time();
    List<String> listValue = new ArrayList<>();
    List<WebElement> options = dropdown.findElements(By.xpath(locatorOption));
//    System.out.println("size: "+ options.size());
    for (int i = 0; i < options.size(); i++) {
//      System.out.println("test: "+options.get(i).getText());
      listValue.add(options.get(i).getText().trim());
    }
    return listValue;
  }

  public void selectRadioButton(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.isSelected();
  }

  public boolean verifyRadioCheck(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    status = false;
    if (element.isSelected()) {
      status = true;
    } else {
      status = false;
    }
    return status;
  }

  public void unCheckToCheckBox(WebDriver driver, String locator) {
    element = driver.findElement(By.xpath(locator));
    if (element.isSelected()) {
      element.click();
    }
  }

  public void checkToCheckBox(WebDriver driver, String locator) {
    element = driver.findElement(By.xpath(locator));
    if (!element.isSelected()) {
      element.click();
    }
  }

  public String getTextElement(WebDriver driver, String locator) {
    return driver.findElement(By.xpath(locator)).getText(); //.replaceAll("<br>", "").replaceAll("\\r\\n|\\r|\\n", " ");
  }

  public String getTextElementByName(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.name(locator));
    return element.getText();
  }

  public String getAttribute(WebDriver driver, String locator, String attribute) {
    WebElement element = driver.findElement(By.xpath(locator));
    return element.getAttribute(attribute);
  }

  public String getAttributeByName(WebDriver driver, String locator, String attribute) {
    WebElement element = driver.findElement(By.name(locator));
    return element.getAttribute(attribute);
  }

  public void clearTextElement(WebDriver driver, String locator) {
    element = driver.findElement(By.xpath(locator));
    element.clear();
  }

  //======================================WAITING===========================================================
  public void wait300Time() {
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void wait1sTime() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void wait2sTime() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void wait100Time() {
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void wait200Time() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void wait5sTime() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void jsWaitForPageToLoad(WebDriver driver, int timeOutInSeconds) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String jsCommand = "return document.readyState";
    // Validate readyState before doing any waits
    if (js.executeScript(jsCommand).toString().equals("complete")) {
      return;
    }
    for (int i = 0; i < timeOutInSeconds; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (js.executeScript(jsCommand).toString().equals("complete")) {
        break;
      }
    }
  }

  public void waitForSpinningSearch(WebDriver driver, int numSpin, int timeOutInSecs, String locator) {
    boolean isSpinning = false;
    int size = 0;
    int spinOnPage = driver.findElements(By.xpath(locator)).size();
    for (int nSpin = 1; nSpin < timeOutInSecs; nSpin++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      size = driver.findElements(By.xpath(locator)).size();
      if (size == spinOnPage + 1) {
        isSpinning = true;
      }
      if ((size == spinOnPage) && isSpinning) {
        break;
      }
    }
  }

  public void waitForAllElementsPresence(WebDriver driver, String locator) {
    waitExplicit = new WebDriverWait(driver, LONG_TIMEOUT);
    byLocator = By.xpath(locator);
    waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
  }

  public void waitElementToBeClickAble(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
  }

  public void waitElement(WebDriver driver, String locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  public void waitForAllElementsPresenceById(WebDriver driver, String locator) {
    waitExplicit = new WebDriverWait(driver, LONG_TIMEOUT);
    byLocator = By.id(locator);
    waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
  }

  public void waitForElementVisible(WebDriver driver, String locator, String value) {
    locator = String.format(locator, value);
    WebElement element = driver.findElement(By.xpath(locator));
    WebDriverWait wait = new WebDriverWait(driver, 30);
  }

  public void waitForElementClickable(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    WebDriverWait wait = new WebDriverWait(driver, 30);
  }

  public void waitFoElementInvisible(WebDriver driver, String locator) {
    WebDriverWait wait = new WebDriverWait(driver, 50);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
  }

  public void waitFoElementVisible(WebDriver driver, String locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    wait2sTime();
  }

  public void waitFoElementClickable(WebDriver driver, String locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitForAlertPresence(WebDriver driver) {
    waitExplicit = new WebDriverWait(driver, LONG_TIMEOUT);
    waitExplicit.until(ExpectedConditions.alertIsPresent());
  }

  //======================================CHECK DISPLAY EMLEMENT===========================================================
  public static boolean isDisplayedElement(WebElement element) {
    try {
      if (element.isDisplayed()) {
        return element.isDisplayed();
      }
    } catch (NoSuchSessionException ex) {
      return false;
    }
    return false;
  }

  public WebElement checkIsDisplayElement(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    while (!isDisplayedElement(element)) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Element is not visible yet");
    }
    return element;
  }

  public boolean isElementDisplayed(WebDriver driver, String locator) {
    boolean flag = true;
    try {
      Thread.sleep(1000);
      flag = driver.findElement(By.xpath(locator)).isDisplayed();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      flag = false;
    }
    return flag;
  }

  public boolean checkDisplayedElementByXpath(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    boolean check = true;
    wait2sTime();
    if (!element.isDisplayed()) {
      System.out.println("element is not displayed");
      check = false;
    }
    return check;
  }

  public int checkShowElement(WebDriver driver, String locator) {
    List<WebElement> elements = driver.findElements(By.xpath(locator));
    return elements.size();
  }

  public boolean checkDisplayElement(WebDriver driver, String yourLocator) {
    try {
      WebElement locator;
      locator = driver.findElement(By.xpath(yourLocator));
      return locator.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean checkDisplayPackage(WebDriver driver, String locator) {
    boolean checkPackage;
    List<WebElement> listPackage = driver.findElements(By.xpath(locator));
    if (listPackage.size() > 0) {
      checkPackage = true;
    } else {
      checkPackage = false;
    }
    return checkPackage;
  }

  //======================================HANDLE WINDOWN===========================================================

  public void switchTab(WebDriver driver) {
    try {
      Set<String> windows = driver.getWindowHandles();
      Iterator<String> iter = windows.iterator();
      String[] winNames = new String[windows.size()];
      int i = 0;
      while (iter.hasNext()) {
        winNames[i] = iter.next();
        i++;
      }
      if (winNames.length > 1) {
        for (i = winNames.length; i > 1; i--) {
          driver.switchTo().window(winNames[i - 1]);
          driver.close();
        }
      }
      driver.switchTo().window(winNames[0]);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void switchToOtherWindowbyTitle(WebDriver driver, String title) {
    allWindows = driver.getWindowHandles();
    for (String runWindows : allWindows) {
      driver.switchTo().window(runWindows);
      String currentWindow = driver.getTitle();
      if (currentWindow.equals(title)) {
        break;
      }
    }
  }

  public void switchToOtherWindowbyUrl(WebDriver driver, String url) {
    allWindows = driver.getWindowHandles();
    for (String runWindows : allWindows) {
      driver.switchTo().window(runWindows);
      String currentWindow = driver.getCurrentUrl();
      if (currentWindow.equals(url)) {
        break;
      }
    }
  }


  public void switchToWindowByUrlContainsString(WebDriver driver, String url) {
    allWindows = driver.getWindowHandles();
    for (String runWindows : allWindows) {
      driver.switchTo().window(runWindows);
      String st = driver.getCurrentUrl();
      if (st.contains(url)) {
        break;
      }
    }
  }


  //======================================ALERT POPUP===========================================================
  public void acceptAlert(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, 1);
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  public void acceptAnyAlert(WebDriver driver) {
    waitForAlertPresence(driver);
    acceptAlert(driver);
  }

  public String getTextAlert(WebDriver driver) {
    return driver.switchTo().alert().getText();
  }
//  public String getTextFromElement(WebDriver driver, String locator) {
//    Alert alert = driver.switchTo().alert();
//    return driver.switchTo().alert().getText(locator);
//  }

  public boolean checkTextAlert(WebDriver driver) {
    boolean condition = false;
    if (driver.switchTo().alert().getText().contains("Wallet Address")) {
      condition = true;
    } else {
      condition = false;
    }
    return condition;
  }

  public String getSubString(String st) {
    String getSubString;
    st = st.substring(2);
    return st;
  }

  public String getTextBySplitLimitSegment(String parentStr, String splitStr, int position) {
    String segments[] = parentStr.split(splitStr, 2);
    return segments[position];
  }

  public String getTextBySplit(String parentStr, String splitStr, int position) {
    String segments[] = parentStr.split(splitStr);
    return segments[position];
  }


  public String getTextAnyAlert(WebDriver driver) {
    waitForAlertPresence(driver);
    return getTextAlert(driver);
  }

  public void switchToIframe(WebDriver driver, String locator) {
    driver.switchTo().defaultContent();
    element = driver.findElement(By.xpath(locator));
    driver.switchTo().frame(element);
  }

  public String getTextToolTip(WebDriver driver, String locatorIcon, String locatorToolTip) {
    Actions actions = new Actions(driver);
    WebElement element = driver.findElement(By.xpath(locatorIcon));
    actions.moveToElement(element).build().perform();
    wait5sTime();
    WebElement getText = driver.findElement(By.xpath(locatorToolTip));
    return getText.getText();
  }

  public void setAttribute(WebElement element, String attributeName, String value) {
    WrapsDriver wrappedElement = (WrapsDriver) element;
    JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
    driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
  }

  //======================================DATE TIME===========================================================
  //Get current day of date is plus
  public String getDayAfterPlusDate(int date) {
    Date currentDay = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDay);
    calendar.add(Calendar.DATE, date);
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    String todayStr = Integer.toString(todayInt);
    return todayStr;
  }

  public static String getDatePlus(int datePlus, String formatDate) {
    DateFormat dateFormat = new SimpleDateFormat(formatDate);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DATE, datePlus);
    return dateFormat.format(calendar.getTime());
  }

  public String getCurrentDayPlusByCalendar(int date) {
    Date currentDay = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDay);
//    int datePlus = date + 3;
    calendar.add(Calendar.DATE, date);
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    String todayStr = Integer.toString(todayInt);
    return todayStr;
  }

  public String getCurrentMonthByCalendar(int month) {
    Date currentMonth = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentMonth);
    calendar.add(Calendar.DATE, month);
    int todayInt = calendar.get(Calendar.MONTH) + 1;
    String todayStr = Integer.toString(todayInt);
    return todayStr;
  }

  public long getNumberOfDateBetweenTwoDates(String d1, String d2) {
    LocalDate date1 = LocalDate.parse(d1, DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date2 = LocalDate.parse(d2, DateTimeFormatter.ISO_LOCAL_DATE);
    Duration diff = Duration.between(date1.atStartOfDay(), date1.atStartOfDay());
    //Co 2 cach get so ngay giua 2 ngay bat ky
    //ChronoUnit.DAYS.between(d1, d2)
    //return ChronoUnit.DAYS.between(LocalDate.parse(d1), LocalDate.parse(d2)));
    return diff.toDays();
  }

  //Get current day of system
  public String getDateTimeSystem() {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int dateTime = calendar.get(Calendar.ALL_STYLES);
    String dateTimeStr = Integer.toString(dateTime);
    return dateTimeStr;
  }

  //Get current day of system
  public String getCurrentDaySystem() {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    String todayStr = Integer.toString(todayInt);
    return todayStr;
  }

  //Get current month of system
  public String getCurrentMonthSystem() {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int monthInt = calendar.get(Calendar.MONTH);
    String monthStr = Integer.toString(monthInt);
    return monthStr;
  }

  //Get current year of system
  public String getCurrentYearSystem() {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int yearInt = calendar.get(Calendar.YEAR);
    String yearStr = Integer.toString(yearInt);
    return yearStr;
  }

  public String getDateTimeNow(String formatDateTime) {
    SimpleDateFormat formatter = new SimpleDateFormat(formatDateTime);
    Date date = new Date();
    return formatter.format(date);
  }

  public Date getDateSystem() {
    Date date = new Date();
    return date;
  }

  public boolean verifyTitleSelectBox(WebDriver driver, String locator) {
    WebElement dropdown = driver.findElement(By.xpath(locator));
    dropdown.click();
    wait1sTime();
    List<WebElement> options = dropdown.findElements(By.xpath(locator));
    boolean status = true;
    for (int i = 0; i < options.size(); i++) {
      boolean b1 = StringUtils.contains(options.get(i).getText(), "Mr");
      boolean b2 = StringUtils.contains(options.get(i).getText(), "Ms");
      boolean b3 = StringUtils.contains(options.get(i).getText(), "Mrs");
      if ((b1) && (b2) && (b3)) {
        status = true;
        System.out.println("Display 3 title correct Mr, Ms, Mrs");
      } else {
        System.out.println("Display 3 title wrong Mr, Ms, Mrs");
        status = false;
      }
    }
    return status;
  }

  public void selectItemByText(WebDriver driver, String locator, String value) {
    List<WebElement> elements = driver.findElements(By.xpath(locator));
    int i = 0;
    while (i < elements.size()) {
      if (StringUtils.equals(elements.get(i).getText(), value)) {
        elements.get(i).click();
        break;
      }
      i++;
    }
  }


  public boolean verifyListElement(WebDriver driver, String locator, String code) {
    boolean check = true;
    List<WebElement> listReview = driver.findElements(By.xpath(locator));
    int i = 0;
    while (i < listReview.size()) {
      boolean a = StringUtils.contains(listReview.get(i).getText(), ReaderConfigLanguage.getStringLanguage(code));
      if (!a) {
        System.out.println("ACTUAL: " + listReview.get(i).getText());
        System.out.println("EXPECT: " + ReaderConfigLanguage.getStringLanguage(code));
        check = false;
        break;
      }
      i++;
    }
    return check;
  }

  public String randomString() {
    char[] chars = "adahhfkaldalds".toCharArray();
    StringBuilder sb = new StringBuilder(5);
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public String randomNumber() {
    char[] phone = "123456789".toCharArray();
    StringBuilder sb = new StringBuilder(9);
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      char c = phone[random.nextInt(phone.length)];
      sb.append(c);
    }
    return sb.toString();
  }

  public int randomDay() {
    char[] phone = "12345".toCharArray();
    StringBuilder sb = new StringBuilder(5);
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      char c = phone[random.nextInt(phone.length)];
      sb.append(c);
    }
    return Integer.parseInt(sb.toString());
  }

  public String randomDestination(){
     String[] SEARCH_DESTINATION={ "Paris", "Jakarta", "Amsterdam", "Shanghai", "GUANGZHOU", "BEIJING",
       "ha noi", "lon don", "ho chi minh", "hongkong", "sydney"};
     Random random = new Random();
    String str = SEARCH_DESTINATION[random.nextInt(11)];
    System.out.println("======Search Result For Destination: "+str+ " =====" );
     return str;
  }

  public String randomCountry(){
    String[] SEARCH_COUNTRY={ "CHINA", "Thailand", "Australia", "Vietnam", "USK"};
    Random random = new Random();
    String str = SEARCH_COUNTRY[random.nextInt(5)];
    System.out.println("======Search Result For Country: "+str+ " =====" );
    return str;
  }
  public String randomCrypto(){
    String[] Crypto= {" AVA", " BTC", " ETH", " USDT", " USDC", " BNB", " XRP", " BUSD", " SOL", " ADA", " DOGE", " DOT", " TRX",
      " DAI", " SHIB", " LTC", " NEAR", " FTT", " BCH", " LINK", " XLM", " XMR", " VET", " EGLD", " HBAR", " FIL", " XTZ", " MANA", " EOS", " TUSD", " CAKE",
      " USDP", " WAVES", " BAT", " FTM", " ZIL", " DASH", " CHZ", " XDC", " ONE", " GALA", " XEM", " QTUM", " GT ", " GUSD", " IOTX", " ILV", " SXP", " VLX",
      " DGB", " NANO", " MX ", " DAO", " OCEAN", " XYO", " FUN", " CHR", " CTSI", " SUPER", " KLV", " STPT", " STRAX", " XVG", " ARK", " BIFI", " ARPA",
      " SFUND", " TKO", " GRS", " KMD", " OM ", " FIRO", " FRONT", " NWC", " BEL", " LGCY", " POOLZ", " NFTB", " VIB", " XCUR", " KISHU", " NTVRK", " TRVL"};
    Random random = new Random();
    String str = Crypto[random.nextInt(60)].trim();
    System.out.println("======Payment by Crypto with: "+str+ " =====" );
    return str;
  }
  public String randomWallet(){
    String[] Wallet={ "AVA", "BNB", "BUSD"};
    Random random = new Random();
    String str = Wallet[random.nextInt(3)];
    System.out.println("======Payment by Wallet with: "+str+ " =====" );
    return str;
  }
  public String randomEmail() {
    String randomEmail = "bella" + randomNumber() + "@travala.com";
    return randomEmail;
  }

  public String randomYopMail() {
    Random rand = new Random();
    rand.nextInt(999);
    String randomEmail = "thuhuong" + randomNumber() + "@yopmail.com";
    return randomEmail;
  }

  public Integer getBalanceAva(String st) {
    System.out.println("before balance: " + st);
    String a = getTextBySplit(st, "\\(", 0);
    System.out.println("after balance: " + a);
    Integer balance = 0;
    if (a.contains(".")) {
      if (getTextBySplit(a, "\\.", 0).contains(",")) {
        balance = Integer.parseInt(getTextBySplit(a, "\\.", 0).replace(",", ""));
      } else {
        balance = Integer.parseInt(getTextBySplit(a, "\\.", 0));
      }
    } else if (!a.contains(".")) {
      if (a.contains(",")) {
        balance = Integer.parseInt(a.replace(",", ""));
      } else {
        balance = Integer.parseInt(a);
      }
    }
    System.out.println("Balance Ava: " + balance);
    return balance;
  }

  public void readExcelFile() {
//    FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads");
//    WorkBook workBook = Wor
  }

  public void screenImageError(WebDriver driver) {
    Random rand = new Random();
    int number = rand.nextInt(9999) - 1;
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(scrFile, new File(("C:\\Bella\\Imagebug\\anh" + number + ".jpg")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean verifyPassWithLength(String passWord) {
    String regex = "(?=\\S+$).{8,64}$";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public boolean verifyPassWithAtLeastLowerCase(String passWord) {
    String regex = "(?=.*[a-z])";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public boolean verifyPassWithAtLeastUpCase(String passWord) {
    String regex = "(?=.*[A-Z])";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public boolean verifyPassWithAtLeastNumber(String passWord) {
    String regex = "^(?=.*[0-9])";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public boolean verifyPassWithAtLeastSpecialCharacter(String passWord) {
    String regex = "(?=.*[&+!@#$%=])";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public boolean verifyPassNoSpace(String passWord) {
    String regex = "(?=\\S+$)";
    Pattern p = Pattern.compile(regex);
    if (passWord == null) {
      return false;
    }
    Matcher m = p.matcher(passWord);
    return m.matches();
  }

  public String toAlternativeString(String string) {
    String text = "";
    String[] arrText = string.split("");
    for (int i=0; i < arrText.length; i++) {
      if(i%2==0) {
        text += arrText[i].toUpperCase();
      } else {
        text += arrText[i].toLowerCase();
      }
    }
    return text;
  }
}
