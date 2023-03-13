package interfaces.hotel.footer.travala;

public class AvaTokenPageUI {
  public static final String AVA_BANNER_TITLE="//div[contains(@class,'bannerContent')]/div/h1";
  public static final String AVA_BANNER_SUB_TITLE="//div[contains(@class,'bannerContent')]/div/p";
  public static final String AVA_SEARCH_TAB_STAYS = "//div[contains(@class,'TravalaWalletAva_tabHeader')]//img[contains(@src, 'hotel')]/following-sibling::span";
  public static final String AVA_SEARCH_TAB_FLIGHTS = "//div[contains(@class,'TravalaWalletAva_tabHeader')]//img[contains(@src, 'flight')]/following-sibling::span";
  public static final String AVA_SEARCH_TAB_ACTIVITIES = "//div[contains(@class,'TravalaWalletAva_tabHeader')]//img[contains(@src, 'activities')]/following-sibling::span";
  public static final String AVA_SEARCH_BUTTON = "//div[contains(@class,'TvlSearchBoxPC')]//button";
  public static final String AVA_WHAT_TITLE="//div[@id='token-block-what']//h2";
  public static final String AVA_WHAT_CONTENT="//div[@id='token-block-what']/div/p";
  public static final String AVA_CURRENT_PRICE="(//div[@id='token-block-what']//div[contains(@class, 'marketSupply')]//p)[1]";
  public static final String AVA_MARKET_CAP="(//div[@id='token-block-what']//div[contains(@class, 'marketSupply')]//p)[2]";
  public static final String AVA_CIRCULATING_SUPPLY="(//div[@id='token-block-what']//div[contains(@class, 'marketSupply')]//p)[3]";
  public static final String AVA_TOTAL_SUPPLY="(//div[@id='token-block-what']//div[contains(@class, 'marketSupply')]//p)[4]";
  public static final String AVA_TITLE_MISSION="//div[contains(@id,'mission')]/div/h2";
  public static final String AVA_MISSION_CONTENT1="(//div[contains(@id,'mission')]/div/p)[1]";
  public static final String AVA_MISSION_CONTENT2="(//div[contains(@id,'mission')]/div/p)[2]";

  public static final String AVA_MARKETS_TITLE = "//div[@id='token-block-metrics']/h2";
  public static final String AVA_SOURCE_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[1]";
  public static final String AVA_PAIRS_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[2]";
  public static final String AVA_PRICE_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[3]";
  public static final String AVA_VOLUME_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[4]";
  public static final String AVA_SPREAD_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[5]";
  public static final String AVA_LAST_TRADED_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[6]";
  public static final String AVA_TRUST_SCORE_IN_MARKETS = "(//div[@id='token-block-metrics']//div[contains(@class, 'title')])[7]";

  public static final String AVA_TRAVEL_BOOKING_TITLE = "//div[@id='token-block-use']//div[contains(@class, 'useAvaTravel')]//h4";
  public static final String AVA_TRAVEL_BOOKING_DESC1 = "//div[@id='token-block-use']//div[contains(@class, 'useAvaTravel')]//p[1]";
  public static final String AVA_TRAVEL_BOOKING_DESC2 = "//div[@id='token-block-use']//div[contains(@class, 'useAvaTravel')]//p[2]";
  public static final String AVA_THE_SMART_PROGRAM_TITLE = "//div[@id='token-block-use']/div/h4[1]";
  public static final String AVA_THE_SMART_PROGRAM_DESC = "//div[@id='token-block-use']/div/p[1]";

  public static final String AVA_THE_SMART_PROGRAM_TITLE_LIST="//div[@id='token-block-use']//div[contains(@class, 'useAvaSmart')]//h5";
  public static final String AVA_THE_SMART_PROGRAM_TITLE_DYNAMIC="(//div[@id='token-block-use']//div[contains(@class, 'useAvaSmart')]//h5)[%s]";
  public static final String AVA_THE_SMART_PROGRAM_CONTENT_LIST="//div[@id='token-block-use']//div[contains(@class, 'useAvaSmart')]//p";
  public static final String AVA_THE_SMART_PROGRAM_CONTENT_DYNAMIC="(//div[@id='token-block-use']//div[contains(@class, 'useAvaSmart')]//p)[%s]";
  public static final String AVA_USE_CASE_TITLE="//div[contains(@id,'token-block-use')]//h2";
  public static final String AVA_MORE_TITLE="//div[@id='token-block-use']//h4/span";
  public static final String AVA_MORE_SUB_TITLE="(//div[@id='token-block-use']//p[contains(@class, 'subTitle')])[2]";
  public static final String AVA_MORE_USE_CASE_TITLE_LIST="//div[contains(@class,'useAvaMore')]/div/h5";
  public static final String AVA_MORE_USE_CASE_TITLE_DYNAMIC="(//div[contains(@class,'useAvaMore')]/div/h5)[%s]";
  public static final String AVA_MORE_USE_CASE_CONTENT_LIST="//div[contains(@class,'useAvaMore')]/div/p";
  public static final String AVA_MORE_USE_CASE_CONTENT_DYNAMIC="(//div[contains(@class,'useAvaMore')]/div/p)[%s]";
  public static final String AVA_HOW_TO_PAY_STEP_LIST="//div[contains(@class,'payAva')]/div/p";
  public static final String AVA_HOW_TO_PAY_STEP_DYNAMIC="(//div[contains(@class,'payAva')]/div/p)[%s]";
  public static final String AVA_FAQS_TITLE="//div[contains(@id,'faqs')]/h2";
  public static final String AVA_STORE_TITLE="//div[contains(@id,'store')]/div/h2";
  public static final String AVA_STORE_SUB1="//div[contains(@id,'store')]/div/p";
  public static final String AVA_STORE_SUB2="//p[contains(@class,'Ava_content')]";
  public static final String AVA_TRADE_TITLE="//div[contains(@id,'trade')]/div/h2";
  public static final String AVA_TRADE_SUB="//div[contains(@id,'trade')]/div/p";
  public static final String AVA_HOW_TO_PAY_TITLE="//div[contains(@id,'pay')]/h2";
  public static final String AVA_FAQS_QUESTION_LIST="//div[contains(@class,'faqs')]//h5";
  public static final String AVA_FAQS_QUESTION_DYNAMIC= "(//div[contains(@class,'faqs')]//h5)[%s]";
  public static final String AVA_FAQS_ANSWER_LIST = "//div[contains(@class,'faqs')]//p";
  public static final String AVA_FAQS_ANSWER_DYNAMIC = "(//div[contains(@class,'faqs')]//p)[%s]";


}
