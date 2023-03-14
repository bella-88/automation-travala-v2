package cucumberOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static commons.CommonTravalaURL.TRAVALA_LIVE_URL;

public class HooksHotel {
  //Run for many thread
  private static WebDriver driver;

  private static final Logger LOGGER = Logger.getLogger(HooksHotel.class.getName());


  private static class BrowserCleanupTravala implements Runnable {
    public void run() {
      closeTravala();
    }
  }
    @Before
  public synchronized static WebDriver openBrowserTravala() {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
      chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
      chromeOptions.setExperimentalOption("useAutomationExtension", false);
      chromeOptions.addArguments("--remote-allow-origins=*");

      chromeOptions.addArguments("--no-sandbox");
      if(System.getProperty("os.name").startsWith("Linux")) {
          chromeOptions.addArguments("--headless"); //!!!should be enabled for Jenkins
          chromeOptions.addArguments("--disable-dev-shm-usage"); //!!!should be enabled for Jenkins
          chromeOptions.addArguments("--window-size=1920x1080"); //!!!should be enabled for Jenkins
      }
      Map<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("credentials_enable_service", false);
      prefs.put("profile.password_manager_enabled", false);
      chromeOptions.setExperimentalOption("prefs", prefs);
//    chromeOptions.setExperimentalOption("useAutomationExtension", false);
//    chromeOptions.addArguments("disable-extensions");
//    chromeOptions.addArguments("disable-infobars");
//    chromeOptions.AddAdditionalCapability("useAutomationExtension", false);
//    chromeOptions.AddExcludedArgument("enable-automation");
//      if (!System.getProperty("os.name").startsWith("Windows")) {
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--headless");
//        //        Set incognito mode
//        chromeOptions.addArguments("--incognito");
//      }
      if (driver == null) {
        try {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver(chromeOptions);
        } catch (UnreachableBrowserException e) {
          driver = new ChromeDriver(chromeOptions);
        } catch (WebDriverException e) {
          driver = new ChromeDriver(chromeOptions);
        } finally {
          Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanupTravala()));
        }
        driver.manage().deleteAllCookies();
        driver.get(TRAVALA_LIVE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        LOGGER.info("===============STARTED THE BROWSER TRAVALA =====================");
      }
      return driver;
    }
    @After
    public static void closeTravala() {
      try {
        LOGGER.info("===============CLOSED THE BROWSER TRAVALA =====================");
        openBrowserTravala().quit();
        driver = null;
        LOGGER.info("Closing the browser");
      } catch (UnreachableBrowserException e) {
        LOGGER.info("Cannot close browser: unreachable browser");
      }
    }
//  public static WebDriver getDriver() {
//    return driver;
//  }
//
//
//  // create new browser
//  public static WebDriver createBrowser() {
//    WebDriver driver;
//    driver = createChromeDriver();
//    addAllBrowserSetup(driver);
//    return driver;
//  }
//  public static WebDriver getCurrentDriver() {
//    if (driver == null) {
//      driver = createBrowser();
//    }
//    return driver;
//  }
//  //Add all browser setup
//  private static void addAllBrowserSetup(WebDriver driver) {
//    driver.manage().deleteAllCookies();
//    driver.get(TRAVALA_LIVE_URL);
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.manage().window().setPosition(new Point(0, 0));
//    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    org.openqa.selenium.Dimension dim = new org.openqa.selenium.Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
//    driver.manage().window().setSize(dim);
//    driver.manage().deleteAllCookies();
//    driver.get(SMART_PROGRAM_URL);
//
//  }
//
//  private static WebDriver createChromeDriver() {
//    WebDriverManager.chromedriver().setup();
//    return new ChromeDriver();
//  }
//
//  @Before
//  public static void BeforeScenario() {
//    try {
//      driver = getCurrentDriver();
//      driver.manage().window().maximize();
//      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }
//  public static void closeCurrentBrowser() {
//    if (driver != null) {
//      driver.quit();
//    }
//    driver = null;
//  }
//  @After
//  public static void AfterScenario() {
//    closeCurrentBrowser();
//  }
//@Before
//  public synchronized static WebDriver openBrowser() {
//  if(driver == null){
//    WebDriverManager.chromedriver().setup();
//    driver = new ChromeDriver();
////    Runtime.getRuntime().addShutdownHook(new Thread( new BrowserCleanup()));
//    driver.get(TRAVALA_LIVE_URL);
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    System.out.println("===================START BROWSER===================");
//  }
//  return driver;
//}

//@After
//  public void closeBrowser(WebDriver driver) {
//  if(driver!=null) {
//    driver.quit();
//    System.gc();
//    if(driver.toString().toLowerCase().contains("chrome")) {
//      String cmd = "taskkill/IM chrome"
//    }
//  }
//}

//  @Before
//  public static void BeforeScenario() {
//    String webdriver = System.getProperty("webdriver", "chrome");
//    switch (webdriver) {
//      case "chrome":
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        break;
////      case "firefox":
////        WebDriverManager.firefoxdriver().setup();
////        driver = new FirefoxDriver();
////        break;
////      case "opera":
////        WebDriverManager.operadriver().setup();
////        driver = new OperaDriver();
////        break;
////      case "edge":
////        WebDriverManager.edgedriver().setup();
////        driver = new EdgeDriver();
////        break;
////      case "ie":
////        WebDriverManager.iedriver().setup();
////        driver = new InternetExplorerDriver();
//      default:
//        throw new RuntimeException("Unsupported webdriver" + webdriver);
//    }
//    driver.manage().deleteAllCookies();
//    driver.manage().window().maximize();
//  }

//  ///======================================
//  @After
//  public void closeBrowser(WebDriver driver) {
//    try {
//      if (driver != null) {
//        driver.quit();
//        System.gc();
//        if (driver.toString().toLowerCase().contains("chrome")) {
//          String cmd = "taskkill /IM chromedriver.exe/C";
//          Process process = Runtime.getRuntime().exec(cmd);
//          process.waitFor();
//        }
//        System.out.println("=======Quit Browser========");
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//      System.out.println(e.getMessage());
//    }
//  }
////  Reporter.loadXMLConfig(new File("config/report.xml"));

}
