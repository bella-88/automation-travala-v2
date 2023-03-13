package interfaces.hotel.NFT;

public class NFTTermsConditionsPageUI {
  public static final String NFT_TERM_TITLE_LIST ="//div[contains(@class,'pageContent')]/strong/strong";
  public static final String NFT_TERM_TITLE_DYNAMIC ="(//div[contains(@class,'pageContent')]/strong/strong)[%s]";

  public static final String NFT_TERM_CONTENT_LIST="//div[contains(@class,'pageContent')]/p";
  public static final String NFT_TERM_CONTENT_DYNAMIC="(//div[contains(@class,'pageContent')]/p)[%s]";

  public static final String NFT_TERM_SUB_CONTENT_LIST ="//div[contains(@class,'pageContent')]/ol/li";
  public static final String NFT_TERM_SUB_CONTENT_DYNAMIC ="(//div[contains(@class,'pageContent')]/ol/li)[%s]";

  public static final String NFT_TERM_SUB1_CONTENT_LIST="//div[contains(@class,'pageContent')]/ol/li/ol/li";
  public static final String NFT_TERM_SUB1_CONTENT_DYNAMIC="(//div[contains(@class,'pageContent')]/ol/li/ol/li)[%s]";
}
