package pages.hotel.footer.support;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import commons.hotel.CommonHotelPages;

import static commons.CommonHotelURL.*;
import static interfaces.hotel.footer.support.TermsConditionsPageUI.*;

public class TermsConditionsPage extends CommonHotelPages {
  WebDriver driver;
  boolean check = true;


  public TermsConditionsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyContent() {
    String[] content = {"TERM_SUB_CONTENT1",
      "TERM_SUB_CONTENT4", "TERM_SUB_CONTENT5", "TERM_SUB_CONTENT6", "TERM_SUB_CONTENT7", "TERM_SUB_CONTENT8", "TERM_SUB_CONTENT9", "TERM_SUB_CONTENT10", "TERM_SUB_CONTENT11",
      "TERM_SUB_CONTENT12", "TERM_SUB_CONTENT13", "TERM_SUB_CONTENT14", "TERM_SUB_CONTENT15", "TERM_SUB_CONTENT16", "TERM_SUB_CONTENT17", "TERM_SUB_CONTENT18", "TERM_SUB_CONTENT19",
      "TERM_SUB_CONTENT20", "TERM_SUB_CONTENT21", "TERM_SUB_CONTENT22", "TERM_SUB_CONTENT23", "TERM_SUB_CONTENT24", "TERM_SUB_CONTENT25", "TERM_SUB_CONTENT26", "TERM_SUB_CONTENT27",
      "TERM_SUB_CONTENT28", "TERM_SUB_CONTENT29", "TERM_SUB_CONTENT30", "TERM_SUB_CONTENT31", "TERM_SUB_CONTENT32", "TERM_SUB_CONTENT33", "TERM_SUB_CONTENT34", "TERM_SUB_CONTENT35",
      "TERM_SUB_CONTENT36", "TERM_SUB_CONTENT37", "TERM_SUB_CONTENT38", "TERM_SUB_CONTENT39", "TERM_SUB_CONTENT40", "TERM_SUB_CONTENT41", "TERM_SUB_CONTENT42", "TERM_SUB_CONTENT43",
      "TERM_SUB_CONTENT44", "TERM_SUB_CONTENT45", "TERM_SUB_CONTENT46", "TERM_SUB_CONTENT47", "TERM_SUB_CONTENT48", "TERM_SUB_CONTENT49", "TERM_SUB_CONTENT50", "TERM_SUB_CONTENT51",
      "TERM_SUB_CONTENT52", "TERM_SUB_CONTENT53", "TERM_SUB_CONTENT54", "TERM_SUB_CONTENT55", "TERM_SUB_CONTENT56", "TERM_SUB_CONTENT57", "TERM_SUB_CONTENT58", "TERM_SUB_CONTENT59",
      "TERM_SUB_CONTENT60", "TERM_SUB_CONTENT61", "TERM_SUB_CONTENT62", "TERM_SUB_CONTENT63", "TERM_SUB_CONTENT64", "TERM_SUB_CONTENT65", "TERM_SUB_CONTENT66", "TERM_SUB_CONTENT67",
      "TERM_SUB_CONTENT68", "TERM_SUB_CONTENT69", "TERM_SUB_CONTENT70", "TERM_SUB_CONTENT71", "TERM_SUB_CONTENT72", "TERM_SUB_CONTENT73", "TERM_SUB_CONTENT74", "TERM_SUB_CONTENT75", "TERM_SUB_CONTENT76",
      "TERM_SUB_CONTENT77", "TERM_SUB_CONTENT78", "TERM_SUB_CONTENT79", "TERM_SUB_CONTENT80", "TERM_SUB_CONTENT81", "TERM_SUB_CONTENT82", "TERM_SUB_CONTENT83", "TERM_SUB_CONTENT84",
      "TERM_SUB_CONTENT85", "TERM_SUB_CONTENT86", "TERM_SUB_CONTENT87", "TERM_SUB_CONTENT88", "TERM_SUB_CONTENT89", "TERM_SUB_CONTENT90", "TERM_SUB_CONTENT91", "TERM_SUB_CONTENT92",
      "TERM_SUB_CONTENT93", "TERM_SUB_CONTENT94", "TERM_SUB_CONTENT95", "TERM_SUB_CONTENT96", "TERM_SUB_CONTENT97", "TERM_SUB_CONTENT98", "TERM_SUB_CONTENT99", "TERM_SUB_CONTENT100",
      "TERM_SUB_CONTENT101", "TERM_SUB_CONTENT102", "TERM_SUB_CONTENT103", "TERM_SUB_CONTENT104", "TERM_SUB_CONTENT105", "TERM_SUB_CONTENT106", "TERM_SUB_CONTENT107",
      "TERM_SUB_CONTENT108", "TERM_SUB_CONTENT109", "TERM_SUB_CONTENT110", "TERM_SUB_CONTENT111", "TERM_SUB_CONTENT112", "TERM_SUB_CONTENT113", "TERM_SUB_CONTENT114", "TERM_SUB_CONTENT115",
      "TERM_SUB_CONTENT116", "TERM_SUB_CONTENT117", "TERM_SUB_CONTENT118", "TERM_SUB_CONTENT119"};
    List<WebElement> listOptionActual = driver.findElements(By.xpath(TERM_CONTENT_LIST));
    List<String> listActual = new ArrayList<>();
    for (int i = 1; i < listOptionActual.size() + 1; i++) {
      String xpathActual = String.format(TERM_CONTENT_DYNAMIC, i);
      String actual = getTextElement(driver, xpathActual).trim().replaceAll("\\r\\n|\\r|\\n", " ");
      if (!StringUtils.isEmpty(actual) || !StringUtils.isBlank(actual)) {
        listActual.add(actual);
      }
    }
    for (String element : listActual
    ) {
      if (! addListExpectByKey(content).contains(element)) {
        System.out.println("ACTUAL: " + element);
        System.out.println("EXPECT: " +  addListExpectByKey(content).contains(element));
        check = false;
      }
    }
    if (!check) {
      System.out.println("Text at Content Term wrong! ");
    }
    String[] title = {"TERM_SUB_TITLE1", "TERM_SUB_TITLE2", "TERM_SUB_TITLE3", "TERM_SUB_TITLE4", "TERM_SUB_TITLE5", "TERM_SUB_TITLE6", "TERM_SUB_TITLE7",
      "TERM_SUB_TITLE8", "TERM_SUB_TITLE9", "TERM_SUB_TITLE10", "TERM_SUB_TITLE11", "TERM_SUB_TITLE12", "TERM_SUB_TITLE13", "TERM_SUB_TITLE14"};
    if (!verifyListItemByListExpect(title, TERM_TITLE_LIST, TERM_TITLE_DYNAMIC)) {
      System.out.println("Text at Title Term wrong! ");
    }
    return check && verifyListItemByListExpect(title, TERM_TITLE_LIST, TERM_TITLE_DYNAMIC)&& verifyUrlPage(TERMS_CONDITIONS_PATH);
  }


}
