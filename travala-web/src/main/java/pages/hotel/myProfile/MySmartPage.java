package pages.hotel.myProfile;


import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static interfaces.hotel.myProfile.MySmartPageUI.*;
import static interfaces.hotel.myProfile.MySmartPageUI.TITLE_INTRODUCE;


public class MySmartPage extends CommonHotelPages {
  WebDriver driver;

  public MySmartPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyActiveSmartAcc() {
    clickToElementByJavascript(driver, TITLE_INTRODUCE);
    clickToElementByJavascript(driver, MY_SMART_TOTAL_BALANCE_ICON);
    String st = getTextElement(driver, MY_SMART_AVA_BALANCE_ICON);
    clickToElement(driver, MY_SMART_ACTIVE_BTN);
    String[] content = {"MY_SMART_ACTIVE_TITLE", "MY_SMART_ACTIVE_CONTENT_CONFIRM", "SETTING_CHANGE_EMAIL_CONTINUE", "MY_SMART_ACTIVE_CANCEL_BTN"};
    String[] xpath = {MY_SMART_ACTIVE_TITLE, MY_SMART_ACTIVE_CONTENT, MY_SMART_ACTIVE_CONFIRM_BTN, MY_SMART_ACTIVE_CANCEL_BTN};
    boolean check1 = verifyTwoListByKey(content, xpath);
    if (!check1) {
      System.out.println("Content message Smart Member Activation wrong! ");
    } else {
      clickToElement(driver, MY_SMART_ACTIVE_CONFIRM_BTN);
      if (getBalanceAva(st) > 250) {
        boolean b = StringUtils.contains(getTextElement(driver, MY_SMART_ACTIVE_CONTENT), getTextFromReadFile("MY_SMART_ACTIVE_CONTENT_CONFIRM"));
        if (!b) {
          System.out.println("Content EXPECT=" + getTextFromReadFile("MY_SMART_ACTIVE_CONTENT_CONFIRM"));
          System.out.println("ACTUAL=" + getTextElement(driver, MY_SMART_ACTIVE_CONTENT));
          System.out.println("Text on pop up confirm active smart wrong");
        }
        wait1sTime();
      } else {
        String[] confirmSmartExp = {"MY_SMART_ACTIVE_TITLE_AVA", "MY_SMART_ACTIVE_CONTENT_AVA", "MY_SMART_ACTIVE_NOTE_AVA", "PAYMENT_AVA_DEPOSIT_ADDRESS", "PAYMENT_AVA_DEPOSIT_MEMO"};
        String[] confirmSmartAct = {MY_SMART_ACTIVE_TITLE_AVA, MY_SMART_ACTIVE_CONTENT_AVA, MY_SMART_ACTIVE_NOTE_AVA, MY_SMART_ACTIVE_ADDRESS_AVA, MY_SMART_ACTIVE_MEMO_AVA};
        if (!verifyTwoListByKey(confirmSmartExp, confirmSmartAct)) {
          System.out.println("Content deposit active smart is wrong!");
        } else {
          System.out.println("Content deposit active smart is correct!");
        }
      }
    }
  }

  public void verifyTextIntroSmart() {
    String[] exp = {"SMART_INTRO_TITLE1", "SMART_INTRO_TITLE3", "SMART_INTRO_SUB_TITLE1", "SMART_INTRO_CONTENT_TITLE1", "INTRO_WORK_BENEFIT_TITLE", "INTRO_LEARN_MORE_LINK"};
    String[] xpath = {INTRO_TITLE1, INTRO_TITLE2, INTRO_SMART_SUB, INTRO_CONTENT1, INTRO_WORK_BENEFIT_TITLE, INTRO_LEARN_MORE_LINK};
    String[] titleExp = {"INTRO_WORK_BENEFIT_CONTENT1", "INTRO_WORK_BENEFIT_CONTENT2", "INTRO_WORK_BENEFIT_CONTENT3"};
    boolean title = compareTwoListByKey(titleExp, INTRO_WORK_BENEFIT_CONTENT);
    boolean status = title && verifyTextByKey("SMART_INTRO_CONTENT_TITLE5", INTRO_CONTENT2) && verifyTwoListByKey(exp, xpath) && verifyTableContent();
    if (!status) {
      System.out.println("Text at Introduce Tab at My Smart wrong");
    }else {
      System.out.println("Text at Introduce Tab at My Smart correct");
    }
  }

  public void verifyTextWhiteListTab(){
    String[] titleExp = {"WHITELIST_TITLE1", "WHITELIST_TITLE2", "WHITELIST_DESC", "WHITELIST_PARAGRAPH1", "WHITELIST_PARAGRAPH2", "WHITELIST_PARAGRAPH3",
      "WHITELIST_BENEFIT_PLATINUM_TITLE", "WHITELIST_BENEFIT_PLATINUM_TXT", "WHITELIST_BENEFIT_PLATINUM_BTN"};
    String[] xpath = {WHITELIST_TITLE1, WHITELIST_TITLE2, WHITELIST_DESC, WHITELIST_PARAGRAPH1, WHITELIST_PARAGRAPH2, WHITELIST_PARAGRAPH3,
      WHITELIST_BENEFIT_PLATINUM_TITLE, WHITELIST_BENEFIT_PLATINUM_TXT, WHITELIST_BENEFIT_PLATINUM_BTN};
    boolean content = verifyTwoListByKey(titleExp, xpath);
    String[] itemExp = {"WHITELIST_PARAGRAPH_ITEM1", "WHITELIST_PARAGRAPH_ITEM2", "WHITELIST_PARAGRAPH_ITEM3", "WHITELIST_PARAGRAPH_ITEM4"};
    boolean item = compareTwoListByKey(itemExp, WHITELIST_PARAGRAPH_ITEM);
    String[] benefitSubContentExp = {"SMART_INTRO_DIAMOND_SUB_TITLE1", "SMART_INTRO_DIAMOND_SUB_TITLE3", "SMART_INTRO_DIAMOND_SUB_TITLE4", "WHITELIST_BENEFIT_SUB_CONTENT5",
      "SMART_INTRO_DIAMOND_SUB_TITLE7", "WHITELIST_BENEFIT_SUB_CONTENT8", "WHITELIST_BENEFIT_SUB_CONTENT6", "WHITELIST_BENEFIT_SUB_CONTENT7", "WHITELIST_BENEFIT_SUB_CONTENT9",
      "WHITELIST_BENEFIT_SUB_CONTENT10"};
    boolean benefitSubContent = compareTwoListByKey(benefitSubContentExp, WHITELIST_BENEFIT_SUB_CONTENT);
    String[] diamond = {"SMART_INTRO_DIAMOND_TITLE1", "SMART_INTRO_DIAMOND_TITLE2", "WHITELIST_BENEFIT_SUB_TITLE1", "SMART_INTRO_DIAMOND_TITLE4",
      "SMART_INTRO_DIAMOND_TITLE5", "SMART_INTRO_DIAMOND_TITLE6", "SMART_INTRO_DIAMOND_TITLE7", "SMART_INTRO_DIAMOND_TITLE8", "SMART_INTRO_DIAMOND_TITLE9",
      "SMART_INTRO_DIAMOND_TITLE10"};
    boolean subTitle = compareTwoListByKey(diamond, WHITELIST_BENEFIT_SUB_TITLE);
    String[] bonusBenefitExp = {"WHITELIST_BENEFIT_BONUS1", "WHITELIST_BENEFIT_BONUS2", "WHITELIST_BENEFIT_BONUS3"};
    boolean bonusBenefit = compareTwoListByKey(bonusBenefitExp, WHITELIST_BENEFIT_SUB_BONUS_CONTENT);
    boolean check = content && item && benefitSubContent && subTitle && bonusBenefit;
    if (!check) {
      System.out.println("Text at Whitelist Tab at My Smart wrong");
    } else {
      System.out.println("Text at Whitelist Tab at My Smart correct");
    }
  }

  public void verifyTextAirdrop() {
    boolean check = true;
    String[] contentExp = {"AIRDROP_CONTENT1", "AIRDROP_CONTENT2", "AIRDROP_CONTENT3", "AIRDROP_CONTENT4", "AIRDROP_CONTENT5", "AIRDROP_CONTENT6"};
    boolean content = compareTwoListByKey(contentExp, AIRDROP_CONTENT);
    if (!content) {
      System.out.println("Text at content of Airdrop tab wrong");
    }
    String[] noteContentExp = {"AIRDROP_NOTE_CONTENT2", "AIRDROP_NOTE_CONTENT3", "AIRDROP_NOTE_CONTENT4", "AIRDROP_NOTE_CONTENT5", "AIRDROP_NOTE_CONTENT6",
      "AIRDROP_NOTE_CONTENT7", "AIRDROP_NOTE_CONTENT8", "AIRDROP_NOTE_CONTENT9", "AIRDROP_NOTE_CONTENT10"};
    boolean noteContent = compareTwoListByKey(noteContentExp, AIRDROP_NOTE_CONTENT);
    if (!noteContent) {
      System.out.println("Text at detail content of TRVL (BEP20) Airdrop 3 wrong");
    }
    String[] getAirdropExp = {"AIRDROP_GET_AIRDROP_STEP1", "AIRDROP_GET_AIRDROP_STEP2", "AIRDROP_GET_AIRDROP_STEP3"};
    boolean getAirdrop = compareTwoListByKey(getAirdropExp, AIRDROP_GET_AIRDROP_STEP);
    String[] exp = {"AIRDROP_TITLE1", "AIRDROP_TITLE2", "AIRDROP_BANNER1", "AIRDROP_TITLE1", "AIRDROP_SUB_TITLE", "AIRDROP_NOTE_RED", "AIRDROP_INPUT_LABEL", "AIRDROP_COUNT_DOWN_TXT"};
    String[] xpath = {AIRDROP_TITLE1, AIRDROP_TITLE2, AIRDROP_BANNER1, AIRDROP_BANNER2, AIRDROP_SUB_TITLE, AIRDROP_NOTE_RED, AIRDROP_INPUT_LABEL, AIRDROP_COUNT_DOWN_TXT};
    String contractTxt = getTextBySplit(getTextElement(driver, AIRDROP_CONTRACT_TXT), ":", 0);
    String numberContract = getTextBySplit(getTextElement(driver, AIRDROP_CONTRACT_TXT), ":", 1).trim().replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("br", "").replaceAll("\\r", "");
    boolean b = StringUtils.contains(getTextFromReadFile("AIRDROP_CONTRACT_TXT"), contractTxt);
    if (!b) {
      System.out.println("Text at contract wrong");
    }
    boolean b1 = StringUtils.contains(getTextFromReadFile("AIRDROP_CONTRACT_NUMBER"), numberContract);
    if (!b1) {
      System.out.println("Actual: " + numberContract);
      System.out.println("Exp: " + getTextFromReadFile("AIRDROP_CONTRACT_NUMBER"));
      System.out.println("Number contract wrong");
    }
    check = getAirdrop && noteContent && content && verifyTwoListByKey(exp, xpath) && b && b1;
    if (!check) {
      System.out.println("Text at AirDrop Tab wrong");
    } else {
      System.out.println("Text at AirDrop Tab correct");
    }
  }

  public void verifyFAQSmart() {
    clickToElementByJavascript(driver, WHITELIST_FAQ_TITLE_FIRST);
    clickToListElement(driver, WHITELIST_FAQ_TITLE_LIST);
    String[] titleFAQ = {"WHITELIST_FAQ_QUESTION1", "WHITELIST_FAQ_QUESTION2", "WHITELIST_FAQ_QUESTION3", "WHITELIST_FAQ_QUESTION4", "WHITELIST_FAQ_QUESTION5"};
    boolean t = compareTwoListByKey(titleFAQ, WHITELIST_FAQ_TITLE);
    String[] faqContent = {"WHITELIST_FAQ_CONTENT1", "WHITELIST_FAQ_CONTENT2", "WHITELIST_FAQ_CONTENT3", "WHITELIST_FAQ_CONTENT4", "WHITELIST_FAQ_CONTENT5"};
    boolean a = compareTwoListByKey(faqContent, WHITELIST_FAQ_CONTENT) && verifyTextByKey("WHITELIST_FAQ_TITLE", WHITELIST_FAQ_SECTION);
    if (!(t && a)) {
      System.out.println("faq wrong");
    }
  }

  public void verifyInputWalletAddressAirdrop() {
    sendkeysToTxt(AIRDROP_INPUT_TXT, randomString());
    verifyTextByKey("AIRDROP_ERROR_TXT", AIRDROP_ERROR_TXT);
  }

  public void verifyTextMySmart() {
    int i = 0;
    List<WebElement> elements = driver.findElements(By.xpath(TITLE_LIST));
    while (i < elements.size()) {
      clickElementByDynamicLocator(driver,TITLE_DYNAMIC,String.valueOf(i+1) );
      wait300Time();
      switch (i) {
        case 0:
          verifyTextIntroSmart();
          break;
        case 1:
          verifyTextAirdrop();
          break;
        default:
          System.out.println("Please click to other option at My Smart! ");
          break;
      }
      i++;
    }
  }
}
