package interfaces.hotel.coinLanding;

public class DAIPageUI {
  public static final String DAI_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
  public static final String DAI_USE_CASE_ITEM_TITLE = "//div[contains(@class,'DAI_useCaseItem')]//h5[not(@class)] | //div[contains(@class,'DAI_useCaseItem')]//h5[contains(@class, 'DAI_useCaseItemLeft')]";
  public static final String DAI_USE_CASE_ITEM_CONTENT = "//div[contains(@class,'DAI_useCaseItem')]//p";
}
