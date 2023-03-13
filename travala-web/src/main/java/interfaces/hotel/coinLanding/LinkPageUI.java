package interfaces.hotel.coinLanding;

public class LinkPageUI {

  public static final String LINK_TEAM_CONTENT="//div[contains(@id,'token-block')]/p";
  public static final String LINK_WHAT_IS_TITLE="//img[contains(@src,'logo.png')]/following-sibling::div/h2";
  public static final String LINK_TOKEN_PRICE="//div[contains(@class,'currentPrice')]";

  public static final String LINK_USE_CASE_SUB1 = "//div[contains(@class,'useTravelContent')]/div/h4";

  public static final String LINK_MORE_USE_CASE_SUB="//p[contains(@class,'moreUseCaseDesMB')]";

  public static final String LINK_URL_LINKIN_OTHER1="(//div[contains(@class,'teamItem')]/p/a)[1]";
  public static final String LINK_URL_LINKIN_OTHER2="(//div[contains(@class,'teamItem')]/p/a)[2]";
  public static final String LINK_URL_PAYMENT="//div[contains(@class,'useAvaTravel')]/div/p/a";
  public static final String LINK_URL_TRAVALA="//a[text()='Travala.com']";
  public static final String LINK_URL_WALLET="//div[contains(@class,'sliderItem')]/a/span";
  public static final String LINK_URL_WALLET_DYNAMIC="(//div[contains(@class,'sliderItem')]/a/span)[%s]";


}
