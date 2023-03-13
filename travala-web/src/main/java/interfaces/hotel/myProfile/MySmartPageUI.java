package interfaces.hotel.myProfile;

public class MySmartPageUI {
  public static String language = System.getProperty("language");
  {
    System.out.println("language: " + language);
  }
  public static final String USER_NAME_LOGGED = "//*[@class='home-hero__subtitle ng-scope']";
  public static final String MY_SMART_PROGRAM_BANNER = "//h5[@class='SmartProgramPage_title___2BtKr']";
  public static final String MY_SMART_BANNER_LEVEL_SUB = "//div[@class='SmartProgramPage_subtitle___b4hqa']/span[1]";
  public static final String MY_SMART_BANNER_ACTIVE_STATUS = "//div[@class='SmartProgramPage_subtitle___b4hqa']/span[2]";
  public static final String MY_SMART_BANNER_ACTIVE_TIME = "//div[@class='SmartProgramPage_subtitle___b4hqa']/span[2]/time";
  public static final String MY_SMART_TITLE = "//div[contains(@class,'SmartProgramPage_header')]/following-sibling::div/h1";
  public static final String MY_SMART_SUB_TITLE = "//div[contains(@class,'SmartProgramPage_header')]/following-sibling::div/h3[1]";
  public static final String MY_SMART_CONTENT = "//div[contains(@class,'SmartProgramPage_header')]/following-sibling::div/p[1]";
  public static final String MY_SMART_CONTENT1 = "//div[contains(@class,'SmartProgramPage_header')]/following-sibling::div/p[2]";
  public static final String MY_SMART_SUB_TITLE1 = "//div[contains(@class,'SmartProgramPage_header')]/following-sibling::div/h3[2]";
  public static final String MY_SMART_LEVEL1_TITLE = "(//span[@class='SmartInfoTabHeader_level___Ld4bC'])[1]";
  public static final String MY_SMART_LEVEL2_TITLE = "(//span[@class='SmartInfoTabHeader_level___Ld4bC'])[2]";
  public static final String MY_SMART_LEVEL3_TITLE = "(//span[@class='SmartInfoTabHeader_level___Ld4bC'])[3]";
  public static final String MY_SMART_LEVEL4_TITLE = "(//span[@class='SmartInfoTabHeader_level___Ld4bC'])[4]";
  public static final String MY_SMART_LEVEL5_TITLE = "(//span[@class='SmartInfoTabHeader_level___Ld4bC'])[5]";
  public static final String MY_SMART_DISCOUNT_TITLE = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/h4)[1]";
  public static final String MY_SMART_DISCOUNT_CONTENT = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/p)[1]";
  public static final String MY_SMART_LOYALTY_TITLE = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/h4)[2]";
  public static final String MY_SMART_LOYALTY_CONTENT = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/p)[2]";
  public static final String MY_SMART_BONUS_TITLE = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/h4)[3]";
  public static final String MY_SMART_BONUS_CONTENT = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/p)[3]";
  public static final String MY_SMART_PAYMENT_TITLE = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/h4)[4]";
  public static final String MY_SMART_PAYMENT_CONTENT = "(//div[@class='SmartProgramPage_programBenefit___1GgRN']/p)[4]";
  public static final String MY_SMART_STATUS_ACC = "//button[@class='btn btn-primary btn-toggle-active']";

  public static final String MY_SMART_CHANGE_LEVEL = "//button[@class='btn btn-primary btn-change-level']";
  public static final String MY_SMART_BENEFITS = "//div[@class='SmartProgramPage_howItWorks___1g91w']/h2";
  public static final String MY_SMART_FEATURE1 = "//div[@id='feature1']";
  public static final String MY_SMART_FEATURE2 = "//div[@id='feature2']";
  public static final String MY_SMART_FEATURE3 = "//div[@id='feature3']";
  public static final String MY_SMART_FEATURE4 = "//div[@id='feature4']";
  public static final String MY_SMART_LEARN_MORE_LINK = "//a[@href='smart']";
  //==============ACTIVE SMART================
  public static final String MY_SMART_ACTIVE_BTN = "(//div[contains(@class,'buttonGroup')])/button";
  public static final String MY_SMART_ACTIVE_TITLE = "(//h3[contains(@class,'TvlPopup_title')])";
  public static final String MY_SMART_ACTIVE_CONTENT = "((//h3[contains(@class,'TvlPopup_title')])/following-sibling::div)[1]";
  public static final String MY_SMART_ACTIVE_CONFIRM_BTN = "(//button[contains(@class,'TvlPopup_confirmBtn')])";
  public static final String MY_SMART_ACTIVE_CANCEL_BTN = "(//button[contains(@class,'TvlPopup_cancelBtn')])";
  public static final String MY_SMART_TOTAL_BALANCE_ICON = "//div[contains(@class,'TvlTopHeader_totalBalanceBtn')]";
  public static final String MY_SMART_AVA_BALANCE_ICON = "(//div[contains(@class,'walletListTitle')]/following-sibling::a)[1]";
  public static final String MY_SMART_ACTIVE_TITLE_AVA = "//h3[contains(@class,'TvlPopup_title___LMjCB')]";
  public static final String MY_SMART_ACTIVE_CONTENT_AVA = "//div[contains(@class,'smart-deposit-content')]/p";
  public static final String MY_SMART_ACTIVE_NOTE_AVA = "//p[contains(@class,'DepositInformation_warningMessage')]/span";
  public static final String MY_SMART_ACTIVE_ADDRESS_AVA = "(//div[contains(@class,'addressGroup')]/div/h5)[1]";
  public static final String MY_SMART_ACTIVE_MEMO_AVA = "(//div[contains(@class,'addressGroup')]/div/h5)[2]";

  public static final String TITLE_LIST ="//ul[contains(@class,'listPageSmart')]/li/span";
  public static final String TITLE_DYNAMIC ="(//ul[contains(@class,'listPageSmart')]/li/span)[%s]";
  public static final String TITLE_INTRODUCE ="(//ul[contains(@class,'listPageSmart')]/li/span)[1]";
  //======================================INTRODUCE SMART=====================================
  public static final String INTRO_TITLE1 ="//div[contains(@class,'static-page')]/div/h1";
  public static final String INTRO_TITLE2 ="//h3[contains(@class,'LevelTitle')]";
  public static final String INTRO_SMART_SUB="//div[contains(@class,'static-page')]/div/h3";
  public static final String INTRO_CONTENT1 ="//video[contains(@preload,'metadata')]//preceding-sibling::p";
  public static final String INTRO_CONTENT2 ="//p[contains(@class,'textWithLink')]";
  public static final String INTRO_WORK_BENEFIT_TITLE ="//div[contains(@class,'howItWorks')]/h2";
  public static final String INTRO_WORK_BENEFIT_CONTENT ="//div[contains(@class,'feature')]/p";
  public static final String INTRO_LEARN_MORE_LINK ="//a[contains(@class,'learnMore')]";

  public static final String INTRO_TABLE_TITLE="//div[contains(@class,'Header_noIcon')]";
  public static final String INTRO_TABLE_TXT="//span[contains(@class,'Header_noIcon')]";
  public static final String INTRO_ICON_TABLE="//div[contains(@class,'Header_noIcon')]/img";
  public static final String INTRO_ICON_TABLE_DYNAMIC="(//div[contains(@class,'Header_noIcon')]/img)[%s]";
  public static final String INTRO_TABLE_CONTENT_TITLE="//div[contains(@class,'programBenefit')]/h4";
  public static final String INTRO_TABLE_CONTENT_SUB_TITLE="//div[contains(@class,'programBenefit')]/p";
  //======================================WHITELIST NFT TAB=====================================

  public static final String WHITELIST_TITLE1 ="(//h3[contains(@class,'LevelTitle')])[1]";
  public static final String WHITELIST_TITLE2 ="(//h3[contains(@class,'LevelTitle')])[2]";
  public static final String WHITELIST_DESC ="//h4[contains(@class,'Desc')]";
  public static final String WHITELIST_PARAGRAPH1 ="(//div[contains(@class,'listTab_paragraph')]/p)[1]";
  public static final String WHITELIST_PARAGRAPH2 ="(//div[contains(@class,'listTab_paragraph')]/p)[2]";
  public static final String WHITELIST_PARAGRAPH3 ="//h3[contains(@class,'LevelTitle')]/following-sibling::p";
  public static final String WHITELIST_PARAGRAPH_ITEM ="//div[contains(@class,'listTab_paragraph')]/ul/li";

  public static final String WHITELIST_BENEFIT_SUB_TITLE ="//div[contains(@class,'Benefits_text')]/h3";
  public static final String WHITELIST_BENEFIT_SUB_CONTENT ="//div[contains(@class,'Benefits_text')]/p";
  public static final String WHITELIST_BENEFIT_SUB_BONUS_CONTENT ="//div[contains(@class,'Benefits_text')]/div/p";
  public static final String WHITELIST_BENEFIT_PLATINUM_TITLE="//div[contains(@class,'bePlatinum')]/div/h5";
  public static final String WHITELIST_BENEFIT_PLATINUM_TXT ="//div[contains(@class,'bePlatinum')]/div/p";
  public static final String WHITELIST_BENEFIT_PLATINUM_BTN ="//div[contains(@class,'bePlatinum')]/button";
  //======================================WHITELIST NFT TAB=====================================
  public static final String AIRDROP_BANNER1 ="//div[contains(@class,'banner')]/h2";
  public static final String AIRDROP_BANNER2 ="//div[contains(@class,'banner')]/h3";
  public static final String AIRDROP_TITLE1 ="(//div[contains(@class,'trvlAirdrop')]/h2)[1]";
  public static final String AIRDROP_TITLE2 ="(//div[contains(@class,'trvlAirdrop')]/h2)[2]";
  public static final String AIRDROP_COUNT_DOWN_TXT ="//div[contains(@class,'flipClock')]/following-sibling::h3";
  public static final String AIRDROP_CONTENT ="//div[contains(@class,'Countdown')]/following-sibling::p";
  public static final String AIRDROP_SUB_TITLE ="//div[contains(@class,'Countdown')]/following-sibling::strong";
  public static final String AIRDROP_NOTE_RED ="//i[@class='red']";
  public static final String AIRDROP_INPUT_LABEL ="//div[contains(@class,'FormInputTrvl')]/h4";
  public static final String AIRDROP_INPUT_TXT ="//div[contains(@class,'groupSubmit')]/div/input";
  public static final String AIRDROP_ERROR_TXT ="//div[contains(@class,'groupSubmit')]/div/span";
  public static final String AIRDROP_SUBMIT_BTN ="//button[contains(@class,'InputTrvl')]";
  public static final String AIRDROP_NOTE_CONTENT ="//div[contains(@class,'banner')]/following-sibling::ul/li";
  public static final String AIRDROP_GET_AIRDROP_STEP ="//div[contains(@class,'stepItem')]";
  public static final String AIRDROP_CONTRACT_TXT ="//p[contains(@class,'contractAddress')]";
  public static final String WHITELIST_FAQ_TITLE_FIRST ="(//label[contains(@class,'title')]/h3)[1]";
  public static final String WHITELIST_FAQ_SECTION ="//section[contains(@class,'faqs')]/h2";
  public static final String WHITELIST_FAQ_TITLE ="//label[contains(@class,'title')]/h3";
  public static final String WHITELIST_FAQ_TITLE_LIST ="//label[contains(@class,'title')]/img[contains(@class,'secondIcon')]";
  public static final String WHITELIST_FAQ_CONTENT ="//div[contains(@class,'desc')]";


}
