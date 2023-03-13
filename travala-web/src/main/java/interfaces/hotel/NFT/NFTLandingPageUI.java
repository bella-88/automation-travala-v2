package interfaces.hotel.NFT;

public class NFTLandingPageUI {

  //=================================BANNER NFT LANDING PAGE====================================
  public static final String NFT_HEADER_LIST = "//ul[contains(@id,'header')]/li/a";
  public static final String NFT_BANNER_TITLE = "//div[contains(@class,'wrapper')]/h1";
  public static final String NFT_BANNER_SUB_TITLE = "//div[contains(@class,'wrapper')]/p";
  public static final String NFT_BANNER_BUY_NFT_BTN = "//div[contains(@class,'wrapper')]//button";
  public static final String NFT_IMG_WRAPPER = "//div[contains(@class,'imgWrapper')]";

  public static final String NFT_INTRODUCING_TITLE = "//section[contains(@class,'whatIs')]/h2";
  public static final String NFT_INTRODUCING_CONTENT = "//section[contains(@class,'whatIs')]/p";

  //=================================BENEFIT NFT LANDING PAGE====================================
  public static final String NFT_BENEFIT_TITLE = "//div[contains(@class,'headingWrapper')]/h2";
  public static final String NFT_BENEFIT_SUB_TITLE = "//div[contains(@class,'headingWrapper')]/p";
  public static final String NFT_BENIFIT_TITLE_LIST = "//div[contains(@class, 'NftLandingPage_topRow')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_bottomRow')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_leftColumn')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_rightColumn')]//div[contains(@class, 'title')]";
  public static final String NFT_BENIFIT_TITLE_DYNAMIC = "(//div[contains(@class, 'NftLandingPage_topRow')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_bottomRow')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_leftColumn')]//div[contains(@class, 'title')] | //div[contains(@class, 'NftLandingPage_rightColumn')]//div[contains(@class, 'title')])[%s]";
  public static final String NFT_BENIFIT_DESC_LIST = "//div[contains(@class, 'NftLandingPage_topRow')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_bottomRow')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_leftColumn')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_rightColumn')]//div[contains(@class, 'desc')]";
  public static final String NFT_BENIFIT_DESC_DYNAMIC = "(//div[contains(@class, 'NftLandingPage_topRow')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_bottomRow')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_leftColumn')]//div[contains(@class, 'desc')] | //div[contains(@class, 'NftLandingPage_rightColumn')]//div[contains(@class, 'desc')])[%s]";
  public static final String NFT_BENEFIT_RIGHT_TITLE = "//div[contains(@class,'rightColumn')]/div/div[contains(@class,'title')]";
  public static final String NFT_BENEFIT_BOTTOM_TITLE = "//div[contains(@class,'bottomRow')]/div/div[contains(@class,'title')]";
  public static final String NFT_BENEFIT_LEFT_TITLE = "//div[contains(@class,'leftColumn')]/div/div[contains(@class,'title')]";
  public static final String NFT_BENEFIT_DESC = "//div[contains(@class,'impressBlock')]/div[contains(@class,'desc')]";

  //=================================SALE MECHANIC NFT LANDING PAGE====================================
  public static final String NFT_SALE_PRICE ="//div[contains(@class,'mechanics')]/div/h3";
  public static final String NFT_SALE_PAYMENT_OPTION ="//div[contains(@class,'mechanics')]/div/h4";
  public static final String NFT_SALE_PAYMENT_OPTION_CONTENT ="//div[contains(@class,'mechanics')]/div/p";
  public static final String NFT_HOW_TO_MINT_TITLE ="//section[contains(@class,'howItWork')]/div/h2";
  public static final String NFT_HOW_TO_MINT_SUB_TITLE ="//section[contains(@class,'howItWork')]/div/div/div/div/h4";
  public static final String NFT_HOW_TO_MINT1_LIST ="//section[contains(@class,'howItWork')]/div/div/div/div/ul/li";
  public static final String NFT_HOW_TO_MINT_LIST ="//section[contains(@class,'howItWork')]/div/div/div/div/p";
  //=================================CAMPAIGN GIVEAWAY NFT LANDING PAGE====================================

  public static final String CAMPAIGN_GIVEAWAY_TITLE = "//div[contains(@class,'NftLandingPage_title')]/h2";
  public static final String CAMPAIGN_GIVEAWAY_SUB_TITLE = "//div[contains(@class,'NftLandingPage_title')]/h5";
  public static final String CAMPAIGN_GIVEAWAY_CONTENT = "//div[contains(@class,'NftLandingPage_title')]/p";
  public static final String CAMPAIGN_GIVEAWAY_PACKAGE_TITLE = "//div[contains(@class,'NftLandingPage_title')]/parent::div/h4";
  public static final String CAMPAIGN_GIVEAWAY_PACKAGE_LIST_CONTENT = "//div[contains(@class,'NftLandingPage_title')]/parent::div/ul/li/b";
  public static final String CAMPAIGN_GIVEAWAY_PACKAGE_CONTENT1 = "(//div[contains(@class,'NftLandingPage_title')]/parent::div/p)[1]";
  public static final String CAMPAIGN_GIVEAWAY_PACKAGE_CONTENT2 = "(//div[contains(@class,'NftLandingPage_title')]/parent::div/p)[2]";

  public static final String BUY_NFT_BTN = "//div[contains(@class,'wrapper')]/button";

  public static final String NFT_FAQ_TITLE= "//section[contains(@class,'faq')]/div/h2";
  public static final String NFT_FAQ_TITLE_FIRST= "(//div[contains(@class,'questionBlock')]/label/h3)[1]";
  public static final String NFT_FAQ_TITLE_LIST = "//div[contains(@class,'questionBlock')]/label/h3";
  public static final String NFT_FAQ_TITLE_DYNAMIC = "(//div[contains(@class,'questionBlock')]/label/h3)[%s]";
  public static final String NFT_FAQ_CONTENT_LIST = "//div[contains(@class,'collapsible-content')]/div";
  public static final String NFT_FAQ_CONTENT_DYNAMIC = "(//div[contains(@class,'collapsible-content')]/div)[%s]";
  public static final String NFT_FAQ_QUESTION_LIST = "//div[contains(@class, 'NftLandingPage_questionList')]//h3";
  public static final String NFT_FAQ_QUESTION_DYNAMIC = "(//div[contains(@class, 'NftLandingPage_questionList')]//h3)[%s]";

  public static final String NFT_FAQ_ANSWER_LIST = "//div[contains(@class, 'NftLandingPage_questionList')]//div[contains(@class, 'NftLandingPage_desc')]";
  public static final String NFT_FAQ_ANSWER_DYNAMIC = "(//div[contains(@class, 'NftLandingPage_questionList')]//div[contains(@class, 'NftLandingPage_desc')])[%s]";
  public static final String NFT_GIVE_AWAY_TERM_LINK = "//a[contains(@href,'giveaway-terms')]";
  public static final String NFT_TERM_LINK = "//a[contains(@href,'nft-terms')]";
  public static final String NFT_JOIN_NFT_TITLE = "//section[contains(@class, 'NftLandingPage_enjoyNft')]//h2";
  public static final String NFT_JOIN_NFT_SUB = "//section[contains(@class, 'NftLandingPage_enjoyNft')]//p";
  public static final String NFT_JOIN_NFT_BUTTON_BUY_NFT = "//section[contains(@class, 'NftLandingPage_enjoyNft')]//button";
}