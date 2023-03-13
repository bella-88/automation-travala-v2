package interfaces.hotel.coinLanding;

public class CHRPageUI {
    public static final String CHR_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
    public static final String CHR_USE_CASE_ITEM_TITLE = "//div[contains(@class,'CHR_useCaseItem')]//h5[not(@class)] | //div[contains(@class,'CHR_useCaseItem')]//h5[contains(@class, 'CHR_useCaseItemLeft')]";
    public static final String CHR_USE_CASE_ITEM_CONTENT = "//div[contains(@class,'CHR_useCaseItem')]//p";
}
