package stepDefinitions.hotel;

import commons.hotel.CommonHotelPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.HooksHotel;
import org.openqa.selenium.WebDriver;
import pages.hotel.GovernancePage;

import static interfaces.hotel.GovernancePageUI.GOVERNANCE_HEADER;

public class GovernancePageSteps extends CommonHotelPages {
  WebDriver driver;
  private GovernancePage governancePage;
  static String numberVote;

  public GovernancePageSteps() {
    driver = HooksHotel.openBrowserTravala();
    governancePage = new GovernancePage(driver);
  }

  @When("^I link to Governance page$")
  public void iLinkToGovernancePage() {
    clickToElement(driver, GOVERNANCE_HEADER);
  }
  @And("^I verify display number vote and list recent vote$")
  public void iVerifyDisplayNumberVoteAndListRecentVote() {
    governancePage.verifyNumberProposal();
  }

  @And("^I verify display list vote when click on View All button$")
  public void iVerifyDisplayListVoteWhenClickOnViewAllButton() {
    numberVote =  governancePage.getNumberVoteProposal();
    governancePage.verifyDisplayListVote(numberVote);
  }
  @And("^I verify display title vote at recent proposal and view all vote$")
  public void iVerifyDisplayTitleVoteAtRecentProposalAndViewAllVote() {
    governancePage.verifyVoteDetail();
  }
  @When("^I verify display text on governance page when not login$")
  public void iVerifyDisplayTextOnGovernancePageWhenNotLogin() {
  }


  @And("^I verify display text on governance page$")
  public void iVerifyDisplayTextOnGovernancePage() {
  }
}
