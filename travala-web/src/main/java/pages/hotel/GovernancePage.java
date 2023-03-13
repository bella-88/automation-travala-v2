package pages.hotel;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import static interfaces.hotel.GovernancePageUI.*;

public class GovernancePage extends CommonHotelPages {
  WebDriver driver;


  public GovernancePage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public String getNumberVoteDetail() {
    List<WebElement> elements = driver.findElements(By.xpath(GOVERNANCE_PROPOSAL_LIST));
    return String.valueOf(elements.size());
  }

  public String getNumberVoteProposal() {
    return getTextElement(driver, GOVERNANCE_PROPOSAL_NUMBER);
  }

  public void verifyNumberProposal() {
    if (!StringUtils.equals(getNumberVoteProposal(), getNumberVoteDetail())) {
      System.out.println("Number Vote: " + getNumberVoteProposal());
      System.out.println("List Recent: " + getNumberVoteDetail());
      System.out.println("Display number Vote and list vote at Recent proposals Wrong!");
    } else {
      System.out.println("Display number Vote and list vote at Recent proposals correct!");
    }
  }

  public void verifyDisplayListVote(String numberVote) {
    clickToElement(driver, GOVERNANCE_PROPOSAL_VIEW_ALL_BTN);
    if (!StringUtils.contains(numberVote, getNumberVoteDetail())) {
      System.out.println("Number Vote: " + numberVote);
      System.out.println("List Vote: " + getNumberVoteDetail());
      System.out.println("Display number Vote and list Vote proposals Wrong!");
    } else {
      System.out.println("Display number Vote and list vote proposals correct!");
    }
  }

  public void verifyTitleVote() {

  }

  public void verifyVoteBattleCake() {
    wait200Time();
  }

  public void verifyVoteBattleShib() {
    wait200Time();
  }

  public void verifyVoteNFT() {
    wait200Time();
  }

  public void verifyVoteRefresh() {
    String[] xpath = {VOTE_DETAIL_NAME, GOVERNANCE_PROPOSAL_STATUS, GOVERNANCE_PROPOSAL_TIME, VOTE_DETAIL_DES};
    String[] content = {"REFRESH_VOTE_NAME", "REFRESH_VOTE_STATUS", "REFRESH_VOTE_TIME", "REFRESH_VOTE_DES"};
    String[] subTitle = {"REFRESH_VOTE_SUB_TITLE1", "REFRESH_VOTE_SUB_TITLE2", "REFRESH_VOTE_SUB_TITLE3", "REFRESH_VOTE_SUB_TITLE4", "REFRESH_VOTE_SUB_TITLE5"};
    String[] subContent = {"REFRESH_VOTE_SUB_CONTENT1", "REFRESH_VOTE_SUB_CONTENT2", "REFRESH_VOTE_SUB_CONTENT3", "REFRESH_VOTE_SUB_CONTENT4", "REFRESH_VOTE_SUB_CONTENT5",
      " REFRESH_VOTE_SUB_CONTENT6", " REFRESH_VOTE_SUB_CONTENT7", " REFRESH_VOTE_SUB_CONTENT8", " REFRESH_VOTE_SUB_CONTENT9", " REFRESH_VOTE_SUB_CONTENT10"};
    String[] subLevel1Content = {"VOTE_DETAIL_SUB_LEVEL1_CONTENT1", "VOTE_DETAIL_SUB_LEVEL1_CONTENT2", "VOTE_DETAIL_SUB_LEVEL1_CONTENT3", "VOTE_DETAIL_SUB_LEVEL1_CONTENT4", "VOTE_DETAIL_SUB_LEVEL1_CONTENT5",
      "VOTE_DETAIL_SUB_LEVEL1_CONTENT6", "VOTE_DETAIL_SUB_LEVEL1_CONTENT7", "VOTE_DETAIL_SUB_LEVEL1_CONTENT8", "VOTE_DETAIL_SUB_LEVEL1_CONTENT9", "VOTE_DETAIL_SUB_LEVEL1_CONTENT10",
      "VOTE_DETAIL_SUB_LEVEL1_CONTENT11", " VOTE_DETAIL_SUB_LEVEL1_CONTENT12", " VOTE_DETAIL_SUB_LEVEL1_CONTENT13", " VOTE_DETAIL_SUB_LEVEL1_CONTENT14", " VOTE_DETAIL_SUB_LEVEL1_CONTENT15"};
    if (verifyTwoListByKey(content, xpath) && compareTwoListByKey(subTitle, VOTE_DETAIL_SUB_TITLE) && compareTwoListByKey(subContent, VOTE_DETAIL_SUB_CONTENT) && compareTwoListByKey(subLevel1Content,
      VOTE_DETAIL_SUB_LEVEL1_CONTENT)) {
      System.out.println("Content at Vote Refresh correct! ");
    } else {
      System.out.println("Content at Vote Refresh wrong! ");
    }
    wait200Time();
  }

  public void verifyVoteDetail() {
    List<WebElement> elements = driver.findElements(By.xpath(GOVERNANCE_PROPOSAL_LIST));
    int i = 1;
    System.out.println("size: " + elements.size());
    while (i <= elements.size()) {
      String xpath = String.format(GOVERNANCE_PROPOSAL_DYNAMIC, i);
      clickToElementByJavascript(driver, xpath);
      System.out.println("xpath: " + xpath);
      String voteName = getTextElement(driver, xpath);
      System.out.println("name: " + voteName);
      switch (voteName) {
        case "Proposal #2 - Travala.com Brand Refresh Proposal":
          verifyVoteRefresh();
          backToPreviousPage(driver);
          break;
        case "Proposal #1 - Develop and launch Travel NFTs":
          verifyVoteNFT();
          backToPreviousPage(driver);
          break;
        case "Travala.com Token Battle: FLOKI vs SHIB":
          verifyVoteBattleShib();
          backToPreviousPage(driver);
          break;
        case "Travala.com Token Battle: CAKE vs FLOKI":
          verifyVoteBattleCake();
          backToPreviousPage(driver);
          break;
        default:
          System.out.println("Please click on another vote");
      }
      i++;
    }
  }
}
