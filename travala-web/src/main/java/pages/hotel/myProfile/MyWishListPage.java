package pages.hotel.myProfile;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static commons.CommonHotelXpath.*;
import static interfaces.hotel.myProfile.MyWishListPageUI.*;


public class MyWishListPage extends CommonHotelPages {
  WebDriver driver;

  public MyWishListPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public int getTotalItem(String itemXpath) {
    int totalItemAct = Integer.parseInt(getTextBySplit(getTextElement(driver, itemXpath), " ", 0));
    return totalItemAct;
  }

  public void verifyItemSaved(String itemXpath, String codeOneExp, String codeExp) {
    String expOneSave = getTextFromReadFile(codeOneExp);
    String exp = getTextFromReadFile(codeExp);
    if (getTotalItem(itemXpath) == 1) {
      if (!StringUtils.contains(getTotalItem(itemXpath) + " " + expOneSave, getTextElement(driver, itemXpath))) {
        System.out.println("Act: " + getTextElement(driver, itemXpath));
        System.out.println("Exp: " + getTotalItem(itemXpath) + " " + expOneSave);
        System.out.println(expOneSave + " is displayed wrong");
      }
    } else {
      if (!StringUtils.contains(getTotalItem(itemXpath) + " " + exp, getTextElement(driver, itemXpath))) {
        System.out.println("Act: " + getTextElement(driver, itemXpath));
        System.out.println("Exp: " + getTotalItem(itemXpath) + " " + exp);
        System.out.println(exp + " is displayed wrong");
      }
    }
    if (getTotalItem(itemXpath) != 0) {
      List<WebElement> elements = driver.findElements(By.xpath(MY_WISHLIST_LIST_ITEM));
      if (elements.size() == getTotalItem(itemXpath)) {
        System.out.println("List " + exp + " is displayed correct");
      } else {
        System.out.println("Item Act: " + getTotalItem(itemXpath));
        System.out.println("Item Exp: " + elements.size());
        System.out.println("List " + exp + "  is displayed wrong");
      }
    }
  }

  public void verifyStayTab() {
    wait300Time();
    if (getTotalItem(MY_WISHLIST_STAY_TOTAl_ITEM) == 0) {
      String[] content = {"MY_WISH_LIST_TITLE", "MY_WISH_LIST_STEP_GET_STARTED", "MY_WISH_LIST_HOTEL_STEP_ONE", "MY_WISH_LIST_HOTEL_STEP_TWO", "MY_WISH_LIST_HOTEL_STEP_THREE"};
      String[] xpath = {MY_WISH_LIST_TITLE, MY_WISH_LIST_STEP_GET_STARTED, MY_WISH_LIST_STEP_ONE, MY_WISH_LIST_STEP_TWO, MY_WISH_LIST_STEP_THREE};
      boolean b = StringUtils.contains(getTextFromReadFile("MY_WISH_LIST_STAY_TOTAL"), getTextBySplitLimitSegment(getTextElement(driver, MY_WISH_LIST_HOTEL_SAVED), " ", 1));
      if (verifyTwoListByKey(content, xpath) && b) {
        System.out.println("Text on Stay tab at My Wishlist no has hotel correct");
      } else {
        System.out.println("Text on Stay tab at My Wishlist no has hotel wrong");
      }
    }else {
      verifyItemSaved(MY_WISHLIST_STAY_TOTAl_ITEM, "MY_WISH_LIST_STAY_ONE", "MY_WISH_LIST_STAY_TOTAL");
//      List<WebElement> elements = driver.findElements(By.xpath(MY_WISHLIST_LIST_HOTEL));

//      if(getTotalItem(MY_WISHLIST_STAY_TOTAl_ITEM)==elements.size()){
//        System.out.println("Display property saved in my wishlist correct!");
//      }else {
//        System.out.println("Display property saved in my wishlist wrong!");
//      }

    }
  }

  public void verifyActivitiesTab() {
    verifyItemSaved(MY_WISHLIST_ACT_TOTAl_ITEM, "MY_WISH_LIST_ACT_ONE", "MY_WISH_LIST_ACT_TOTAL");
    String[] step = {"MY_WISH_LIST_HOTEL_STEP_ONE", "MY_WISHLIST_ACT_STEP2", "MY_WISHLIST_ACT_STEP3"};
    if (getTotalItem(MY_WISHLIST_ACT_TOTAl_ITEM) == 0) {
      if (verifyTextByKey("MY_WISH_LIST_STEP_GET_STARTED", MY_WISHLIST_ACT_TXT) && compareTwoListByKey(step, MY_WISHLIST_ACT_STEP_LIST)) {
        System.out.println("Text at Activities tab no has Activities correct");
      } else {
        System.out.println("Text at Activities tab no has Activities wrong");
      }
    }
  }

  public void verifyDisplayMyWishList() {
    wait300Time();
    String[] tab = {"MY_WISH_LIST_ACTIVITIES", "MY_WISH_LIST_HOTEL"};
    if (!compareTwoListByKey(tab, MY_WISHLIST_TAB_LIST)) {
      System.out.println("Text on tab of My WishList wrong");
    }
    verifyStayTab();
    clickToElementByJavascript(driver, MY_WISHLIST_TAB_DYNAMIC);
    verifyActivitiesTab();
  }

  public void verifyRemoveItem() {
    wait300Time();
    if (getTotalItem(MY_WISHLIST_STAY_TOTAl_ITEM) != 0) {
      List<WebElement> elements = driver.findElements(By.xpath(MY_WISHLIST_LIST_ITEM));
      int totalBefore = elements.size();
      System.out.println("Before remove has " + totalBefore+ " properties saved!");
      clickToElementByJavascript(driver, MY_WISHLIST_CLOSE_FIRST);
      reloadPage(driver);
      System.out.println("after: "+elements.size());
      System.out.println("After remove has " + elements.size()+ " properties saved!");
      if (totalBefore != elements.size()) {
        System.out.println("Remove item at Stay wrong");
      } else {
        System.out.println("Remove item at Stay correct");
      }
    }
  }

}
