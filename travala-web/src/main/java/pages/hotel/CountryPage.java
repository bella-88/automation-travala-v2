package pages.hotel;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;
import static interfaces.hotel.CountryPageUI.*;

public class CountryPage extends CommonHotelPages {
  WebDriver driver;
  private boolean b = true;
  private int i = 1;

  public CountryPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyNavigateToCountryPage(String country) {
    String[] spl = getTextElement(driver, COUNTRY_TITLE).split(" ");
    if (StringUtils.contains(country.toUpperCase(), spl[3])) {
      System.out.println("Navigate to country page of " + country.toUpperCase() + " correct");
    } else {
      System.out.println("Expect: " + country.toUpperCase());
      System.out.println("Actual: " + spl[4]);
      System.out.println("Navigate to country page of " + country.toUpperCase() + " wrong");
    }
  }

  public void getSubTitle() {
    String st = getTextElement(driver, COUNTRY_BANNER_TEXT2);
    String[] a = st.split(" ");
    a[5] = "";
    String title = "";
    for (int i = 0; i < a.length; i++) {
      title = title.concat(a[i]) + " ";
    }
    boolean b = StringUtils.equals(getTextFromReadFile("COUNTRY_BANNER_TEXT2"), title.trim());
    if (!b) {
      System.out.println("TITLE EXPECT:" + getTextFromReadFile("COUNTRY_BANNER_TEXT2") + ":");
      System.out.println("TITLE ACTUAL:" + title.trim() + ":");
    }
  }

  public void verifyTextCountry(String country) {
    verifyBenefitCountryPage(country);
    verifyInformationCountry(country);
    getSubTitle();
    verifyDiscoverCountry(country);
    verifyDestinationCountry(country);
    verifySuggestionCountry(country);
    System.out.println("=============================================================");
  }

  public void verifyDiscoverCountry(String country) {
    if (checkShowElement(driver, DISCOVER_COUNTRY) == 0) {
      System.out.println(country + " is not shown Discover");
    } else {
      String expectDiscover = getTextFromReadFile("DISCOVER_REGION") + " " + country;
      if (StringUtils.contains(expectDiscover, getTextElement(driver, DISCOVER_COUNTRY))) {
        System.out.println(country + " is shown Discover correct");
      } else {
        System.out.println("Actual: " + getTextElement(driver, DISCOVER_COUNTRY));
        System.out.println("Expect: " + expectDiscover);
        System.out.println(country + " is shown Discover wrong");
      }
    }
  }

  public void verifyBenefitCountryPage(String country) {
    String expectCountry = getTextFromReadFile("TITLE_COUNTRY") + " " + country.toUpperCase();
    boolean verifyTitle = StringUtils.contains(expectCountry, getTextElement(driver, COUNTRY_BANNER_TEXT1));
    String[] listItemBenefit = {"LandingPage_CustomerSupport", "LandingPage_MultiPaymentOption", "LandingPage_RealValueRewards", "MENU_BestPrice"};
    String[] listContentBenefit = {"LandingPage_CustomerSupport_Content", "LandingPage_RealValueRewards_Content", "LandingPage_BestPriceGuarantee_Content", "LandingPage_MultiPaymentOption_Content"};
    boolean verifyItem = verifyListItemByListExpect(listItemBenefit, COUNTRY_BENEFIT_ITEM_LIST, COUNTRY_BENEFIT_ITEM_DYNAMIC);
    boolean verifyContent = verifyListItemByListExpect(listContentBenefit, COUNTRY_BENEFIT_CONTENT_LIST, COUNTRY_BENEFIT_CONTENT_DYNAMIC);
    if (!verifyTitle || !verifyItem || !verifyContent) {
      System.out.println("Text at benefit of Country " + country + " is displayed wrong! ");
      if (!verifyTitle) {
        System.out.println("Title expect: " + expectCountry);
        System.out.println("Title act: " + getTextElement(driver, COUNTRY_BANNER_TEXT1));
      }
      if (!verifyItem) {
        System.out.println("Item at benefits wrong");
      }
      if (!verifyContent) {
        System.out.println("Content at benefits wrong");
      }
    }
  }

  public void verifyInformationCountry(String country) {
    String expectInfoCountry = getTextFromReadFile("INFORMATION_COUNTRY") + " " + country;
    String actInfoCountry = getTextElement(driver, INFORMATION_COUNTRY);
    boolean verifyTitleInfo = StringUtils.contains(expectInfoCountry.toUpperCase(), actInfoCountry.toUpperCase());
    String[] expectInfo = {"ACCOMMODATION", "POPULAR_CITY", "CAPITAL", "POPULATION"};
    boolean verifyItemInfo = verifyListItemByListExpect(expectInfo, INFORMATION_ITEM_LIST, INFORMATION_ITEM_DYNAMIC);
    if (!verifyTitleInfo) {
      System.out.println("Title at Info wrong");
    }
    if (!verifyItemInfo) {
      System.out.println("Item at Info wrong");
    }
    if (verifyItemInfo && verifyTitleInfo) {
      System.out.println("Text at Information of Country " + country + " is displayed correct! ");
    } else {
      System.out.println("Text at Information of Country " + country + " is displayed wrong! ");
    }
  }

  public void verifyDestinationCountry(String country) {
    boolean b = true;
    boolean verifyDestination = true;
    if (checkShowElement(driver, DESTINATION_COUNTRY) == 0) {
      System.out.println(country + " is not shown destination");
    } else {
      String expectDestination = getTextFromReadFile("DESTINATION_COUNTRY") + " " + country;
      verifyDestination = StringUtils.contains(expectDestination, getTextElement(driver, DESTINATION_COUNTRY));
      while (i <= checkShowElement(driver, DESTINATION_COUNTRY_LIST)) {
        String xpathActual = String.format(DESTINATION_COUNTRY_DYNAMIC, i);
        String actual = getTextBySplitLimitSegment(getTextElement(driver, xpathActual), " ", 1);
        if (!StringUtils.contains(getTextFromReadFile("DESTINATION_LABEL"), actual)) {
          b = false;
        }
        i++;
      }
    }
    if (!b || !verifyDestination) {
      System.out.println(country + " is shown destination wrong");
    } else {
      System.out.println(country + " is shown destination correct");
    }
  }

  public void verifySuggestionCountry(String country) {
    boolean verifySuggestion = true;
    String expectBooked = getTextFromReadFile("JUST_BOOK") + " " + country;
    boolean verifyBooked = StringUtils.contains(expectBooked, getTextElement(driver, BOOK_COUNTRY));
    if (!verifyBooked) {
      System.out.println(getTextElement(driver, BOOK_COUNTRY));
      System.out.println(expectBooked);
    }
    if (checkShowElement(driver, DESTINATION_COUNTRY) == 0) {
      System.out.println(country + " is not shown suggestion");
    } else {
      verifySuggestion = StringUtils.contains(getTextFromReadFile("SUGGESTION_TITLE"), getTextElement(driver, SUGGESTION_COUNTRY));
      String expect = getTextFromReadFile("SUGGESTION_HOTEL") + " " + country;
      while (i <= checkShowElement(driver, SUGGESTION_COUNTRY_LIST)) {
        String xpathActual = String.format(SUGGESTION_COUNTRY_DYNAMIC, i);
        String actual = getTextElement(driver, xpathActual).substring(2);
        if (!StringUtils.contains(expect, actual)) {
          b = false;
        }
        i++;
      }
      if (!verifySuggestion || !b) {
        System.out.println(country + " is shown suggestion wrong");
      } else {
        System.out.println(country + " is shown suggestion correct");
      }
    }
  }
}
