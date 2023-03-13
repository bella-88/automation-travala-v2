package interfaces.hotel.NFT;

public class ActiveNFTPageUI {


  public static final String ACTIVE_NFT_HEADING = "//h1[contains(@class,'heading')]";
  public static final String ACTIVE_NFT_BANNER = "//div[contains(@class,'banner')]/h2";
  public static final String ACTIVE_NFT_SUB_BANNER = "//div[contains(@class,'banner')]/p";
  public static final String ACTIVE_NFT_MEMBERSHIP_TITLE = "(//article/h3)[1]";
  public static final String ACTIVE_NFT_MEMBERSHIP_ACTIVE_BUTTON = "//main//div/button";

  public static final String ACTIVE_NFT_MEMBERSHIP_CONTENT_LIST = "//article/p";
  public static final String ACTIVE_NFT_MEMBERSHIP_CONTENT_DYNAMIC = "(//article/p)[%s]";

  public static final String ACTIVE_NFT_BENEFITS_TITLE = "(//article/h3)[2]";
  public static final String ACTIVE_NFT_HOW_TO_ACTIVE_TITLE = "(//article/h3)[3]";

  public static final String ACTIVE_NFT_BENEFITS_LIST_TITLE = "//article[2]//h4";
  public static final String ACTIVE_NFT_BENEFITS_LIST_TITLE_DYNAMIC = "(//article[2]//h4)[%s]";
  public static final String ACTIVE_NFT_BENEFITS_LIST_CONTENT = "//article[2]//p";
  public static final String ACTIVE_NFT_BENEFITS_LIST_CONTENT_DYNAMIC = "(//article[2]//p)[%s]";
  public static final String ACTIVE_NFT_HOW_TO_LIST_STEP = "//article[3]//p";
  public static final String ACTIVE_NFT_HOW_TO_LIST_STEP_DYNAMIC = "(//article[3]//p)[%s]";

}