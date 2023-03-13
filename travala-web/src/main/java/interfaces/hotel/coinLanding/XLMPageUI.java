package interfaces.hotel.coinLanding;

public class XLMPageUI {
  public static final String XLM_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
  public static final String XLM_USE_CASE_ITEM_TITLE = "//div[contains(@class,'XLM_useCaseItem')]//h5[not(@class)] | //div[contains(@class,'XLM_useCaseItem')]//h5[contains(@class, 'XLM_useCaseItemLeft')]";
  public static final String XLM_USE_CASE_ITEM_CONTENT = "//div[contains(@class,'XLM_useCaseItem')]//p";
}
