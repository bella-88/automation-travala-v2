package interfaces.hotel.coinLanding;

public class STRAXPageUI {
    public static final String STRAX_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
    public static final String STRAX_USE_CASE_ITEM_TITLE = "//div[contains(@class,'STRAX_useCaseItem')]//h5[not(@class)] | //div[contains(@class,'STRAX_useCaseItem')]//h5[contains(@class, 'STRAX_useCaseItemLeft')]";
    public static final String STRAX_USE_CASE_ITEM_CONTENT = "//div[contains(@class,'STRAX_useCaseItem')]//p";
}
