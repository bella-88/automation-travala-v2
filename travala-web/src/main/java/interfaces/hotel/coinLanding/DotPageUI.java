package interfaces.hotel.coinLanding;

public class DotPageUI {
  public static final String DOT_BANNER_TITLE1="//div[contains(@class,'bannerContent')]/h1";
  public static final String DOT_BANNER_TITLE2="//div[contains(@class,'bannerContent')]/p";
  public static final String DOT_TEAM_CONTENT="//div[contains(@id,'team')]/p";
  public static final String DOT_USE_CASE_TITLE="//div[contains(@class,'useTravelContent')]/div/h4";
  public static final String DOT_MORE_CASE_TITLE="//div[contains(@class,'container')]/h4/div";
  public static final String DOT_WHAT_IS_TITLE="//h2[contains(@class,'whatTitle')]";

  public static final String DOT_MORE_CASE_SUB_TITLE_LIST ="//div[contains(@class,'useTravel')]/div/h5";
  public static final String DOT_MORE_CASE_SUB_TITLE_DYNAMIC ="(//div[contains(@class,'useTravel')]/div/h5)[%s]";

  public static final String DOT_TITLE_LIST ="//div[contains(@class,'FilecoinFil')]/div/h2";
   public static final String DOT_TITLE_DYNAMIC ="(//div[contains(@class,'FilecoinFil')]/div/h2)[%s]";

  public static final String DOT_TEAM_ITEM_TITLE_LIST="//div[contains(@class,'teamItem')]/h5";
  public static final String DOT_TEAM_ITEM_TITLE_DYNAMIC="(//div[contains(@class,'teamItem')]/h5)[%s]";

  public static final String DOT_TEAM_ITEM_POSITION_LIST="//div[contains(@class,'teamItem')]/span";
  public static final String DOT_TEAM_ITEM_POSITION_DYNAMIC="(//div[contains(@class,'teamItem')]/span)[%s]";

  public static final String DOT_FAQ_FIRST="(//div[contains(@id,'token-block')]/div/h5)[1]";
  public static final String DOT_FAQ_DYNAMIC="(//div[contains(@id,'token-block')]/div/h5)[%s]";

  public static final String DOT_CONTENT_LIST="//div[contains(@class,'FilecoinFil')]/div/p";
  public static final String DOT_CONTENT_DYNAMIC="(//div[contains(@class,'FilecoinFil')]/div/p)[%s]";
  public static final String DOT_URL_LINKIN="//div[contains(@class,'_brand')]/a[contains(@href,'linkedin.com')]";
  public static final String DOT_URL_LINKIN_DYNAMIC="(//div[contains(@class,'_brand')]/a[contains(@href,'linkedin.com')])[%s]";
  public static final String DOT_URL_TRAVALA="//a[text()='Travala.com']";
  public static final String DOT_URL_WALLET="//div[contains(@class,'sliderItem')]/a/span";
  public static final String DOT_URL_WALLET_DYNAMIC="(//div[contains(@class,'sliderItem')]/a/span)[%s]";


}
