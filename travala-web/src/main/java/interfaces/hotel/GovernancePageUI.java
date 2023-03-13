package interfaces.hotel;

public class GovernancePageUI {

  //========================LANGUAGE CONTACT CHECKOUT ===============================================
  public static final String GOVERNANCE_HEADER = "//a[contains(@href,'governance')]";
  public static final String GOVERNANCE_TITLE = "//div[contains(@class,'GovernancePagePC_title')]";
  public static final String GOVERNANCE_PROPOSAL_NUMBER = "//div[contains(@class,'proposals')]/div/div/div[contains(@class,'number')]";
  public static final String GOVERNANCE_PROPOSAL_VIEW_ALL_BTN = "//div[contains(@class,'proposals')]/div/div[contains(@class,'viewAllBtn')]/div";
  public static final String GOVERNANCE_PROPOSAL_LIST = "//div[contains(@class,'proposalTitle')]/span";
  public static final String GOVERNANCE_PROPOSAL_DYNAMIC = "(//div[contains(@class,'proposalTitle')]/span)[%s]";
  public static final String GOVERNANCE_PROPOSAL_NAME_1 = "(//div[contains(@class,'proposalTitle')]/span)[1]";
  public static final String GOVERNANCE_PROPOSAL_NAME_2 = "(//div[contains(@class,'proposalTitle')]/span)[2]";
  public static final String GOVERNANCE_PROPOSAL_NAME_3 = "(//div[contains(@class,'proposalTitle')]/span)[3]";
  public static final String GOVERNANCE_PROPOSAL_NAME_4 = "(//div[contains(@class,'proposalTitle')]/span)[4]";
  public static final String GOVERNANCE_PROPOSAL_STATUS = "//span[contains(@class,'votingStatus')]";
  public static final String GOVERNANCE_PROPOSAL_TIME = "//span[contains(@class,'postedTime')]";
  public static final String GOVERNANCE_PROPOSAL_DES = "//div[contains(@class,'ellipsisText')]";

//========================DETAIL VOTE ===============================================
public static final String VOTE_DETAIL_NAME = "//div[contains(@class,'proposalTitle')]";
public static final String VOTE_DETAIL_SHARE_LABEL = "//div[contains(@class,'shareLine')]";
public static final String VOTE_DETAIL_SHARE_LIST = "//div[contains(@class,'shareLine')]/a";
public static final String VOTE_DETAIL_LABEL = "//div[contains(@class,'mainContent')]/div[contains(@class,'infoBlock')]/div[(contains(@class,'title'))]";
public static final String VOTE_DETAIL_DES = "//div[contains(@class,'mainContent')]/div[contains(@class,'infoBlock')]/div[(contains(@class,'content'))]/p";
public static final String VOTE_DETAIL_SUB_TITLE = "//div[contains(@class,'mainDetail')]/h3";
public static final String VOTE_DETAIL_SUB_CONTENT = "//div[contains(@class,'mainDetail')]/p";
public static final String VOTE_DETAIL_SUB_LEVEL1_CONTENT = "//div[contains(@class,'mainDetail')]/ul/li";

}
