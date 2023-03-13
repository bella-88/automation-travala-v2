package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.TimeZone;

public class AbstractTest {
  WebDriver driver;
  public final Log log;

  public AbstractTest() {
    log = LogFactory.getLog(getClass());
  }


  public int randomDataAccountID() {
    Random rand = new Random();

    int number = rand.nextInt(2) - 1;
    return number;
  }

  protected boolean verifyTrue(boolean condition) {
    return verifyPassed(condition, false);
  }

  protected boolean verifyPassed(boolean condition, boolean flag) {
    boolean pass = true;
    if (flag == false) {
      try {
        if (condition == true) {
          log.info("======Passed========");
        } else {
          log.info("=======Failed========");
        }
        Assert.assertTrue(condition);
      } catch (Throwable e) {
        pass = false;
        Reporter.getCurrentTestResult().setThrowable(e);
      }
    } else {
      Assert.assertTrue(condition);
    }
    return pass;
  }

  protected boolean verifyFalse(boolean condition) {
    return verifyFailed(condition, false);
  }

  protected boolean verifyFailed(boolean condition, boolean flag) {
    boolean pass = true;
    if (flag == false) {
      try {
        if (condition == false) {
          log.info("=======Passed=======");
        } else {
          log.info("=======Failed========");
        }
        Assert.assertTrue(condition);
      } catch (Throwable e) {
        pass = false;
        Reporter.getCurrentTestResult().setThrowable(e);
      }
    } else {
      Assert.assertTrue(condition);
    }
    return pass;
  }

  protected boolean verifyEqual(Object actual, Object expected) {
    return checkEquals(actual, expected);
  }

  protected boolean verifyEqualsFlag(Object actual, Object expected, boolean flag) {
    boolean pass = true;
    if (flag == false) {
      try {
        Assert.assertEquals(actual, expected);
      } catch (Throwable e) {
        pass = false;
        Reporter.getCurrentTestResult().setThrowable(e);
      }
    } else {
      Assert.assertEquals(actual, expected);
    }
    return pass;
  }

  protected boolean verifyEquals(Object actual, Object expected, boolean flag) {
    return verifyEqualsFlag(actual, expected, flag);
  }

  private boolean checkEquals(Object actual, Object expected) {
    boolean pass = true;
    boolean status;
    try {
      if (actual instanceof String && expected instanceof String) {
        status = (actual.equals(expected));
      } else {
        status = (actual == expected);
      }

      log.info("Compare value = " + status);
      if (status) {
        log.info("===PASSED===");
      } else {
        log.info("===FAILED===");
      }
//			Assert.assertEquals(actual, expected, "Value is not matching!");
    } catch (Throwable e) {
      pass = false;

    }
    return pass;
  }

  private String getCurrentDay() {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    String todayStr = Integer.toString(todayInt);
    return todayStr;
  }

  private static HashMap<String, Object> aMap;

  static {
    aMap = new HashMap<String, Object>();
    aMap.put("HaNoi", "350");
    aMap.put("HaLong", "320");
  }

//  public boolean equalLists(List<String> a, List<String> b) {
//    if (a == null && b == null) {
//      return true;
//    }
//    if ((a == null && b != null) || (a != null && b == null)) {
//      return false;
//    }
//    Collections.sort(a);
//    Collections.sort(b);
//  }
}
