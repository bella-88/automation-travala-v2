package interfaces.hotel.coinLanding;

public class TUSDPageUI {
  public static final String TUSD_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
  public static final String TUSD_USE_CASE_ITEM_TITLE = "//div[contains(@class,'TrueUSD_useCaseItem')]//h5[not(@class)] | //div[contains(@class,'TrueUSD_useCaseItem')]//h5[contains(@class, 'TrueUSD_useCaseItemLeft')]";
  public static final String TUSD_USE_CASE_ITEM_CONTENT = "//div[contains(@class,'TrueUSD_useCaseItem')]//p";
}
