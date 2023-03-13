package interfaces.hotel.coinLanding;

public class USDTPageUI {
  public static final String USDT_BANNER_TITLE1="//div[contains(@class,'bannerContent')]/h1";
  public static final String USDT_BANNER_TITLE2="//div[contains(@class,'bannerContent')]/p";
  public static final String USDT_TEAM_CONTENT="//div[contains(@id,'team')]/p";
  public static final String USDT_USE_CASE_TITLE="//div[contains(@class,'useTravelContent')]/div/h4";
  public static final String USDT_MORE_CASE_TITLE="//div[contains(@class,'container')]/h4/div";
  public static final String USDT_WHAT_IS_TITLE="//h2[contains(@class,'whatTitle')]";

  public static final String USDT_MORE_CASE_SUB_TITLE_LIST ="//div[contains(@class,'useTravel')]/div/h5";
  public static final String USDT_MORE_CASE_SUB_TITLE_DYNAMIC ="(//div[contains(@class,'useTravel')]/div/h5)[%s]";

  public static final String USDT_TITLE_LIST ="//div[contains(@class,'FilecoinFil')]/div/h2";
  public static final String USDT_TITLE_DYNAMIC ="(//div[contains(@class,'FilecoinFil')]/div/h2)[%s]";

  public static final String USDT_TEAM_ITEM_TITLE_LIST="//div[contains(@class,'teamItem')]/h5";
  public static final String USDT_TEAM_ITEM_TITLE_DYNAMIC="(//div[contains(@class,'teamItem')]/h5)[%s]";

  public static final String USDT_TEAM_ITEM_POSITION_LIST="//div[contains(@class,'teamItem')]/span";
  public static final String USDT_TEAM_ITEM_POSITION_DYNAMIC="(//div[contains(@class,'teamItem')]/span)[%s]";

  public static final String USDT_FAQ_FIRST="(//div[contains(@id,'token-block')]/div/h5)[1]";
  public static final String USDT_FAQ_DYNAMIC="(//div[contains(@id,'token-block')]/div/h5)[%s]";
}
