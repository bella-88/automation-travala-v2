package interfaces.hotel.footer.travala;

public class BuyGiftCardPageUI {
    public static final String BUY_GIFT_CARDS_TITLE="//div[contains(@class,'BuyGiftCardPagePC_container')]/h1";
    public static final String BUY_GIFT_CARDS_SECTION_VALUE="(//div[contains(@class,'BuyGiftCard_section')]/h3)[1]";
    public static final String BUY_GIFT_CARDS_SECTION_VALUE_SUB1="(//p[contains(@class,'BuyGiftCard_label')])[1]";
    public static final String BUY_GIFT_CARDS_SECTION_VALUE_SUB2="(//p[contains(@class,'BuyGiftCard_label')])[2]";
    public static final String BUY_GIFT_CARDS_SECTION_VALUE_SUB3="//p[contains(@class,'BuyGiftCard_largeOrder')]";

    public static final String BUY_GIFT_CARDS_SECTION_CONTACT="(//div[contains(@class,'BuyGiftCard_section')]/h3)[2]";
    public static final String BUY_GIFT_CARDS_SECTION_CONTACT_CONTENT="//input[@name='buyer_first_name']/preceding-sibling::p";
    public static final String BUY_GIFT_CARDS_CONTACT_FIRST_NAME ="//input[@name='buyer_first_name']";
    public static final String BUY_GIFT_CARDS_CONTACT_LAST_NAME ="//input[@name='buyer_last_name']";
    public static final String BUY_GIFT_CARDS_CONTACT_EMAIL ="//input[@name='buyer_email']";
    public static final String BUY_GIFT_CARDS_ERROR_EMAIL="(//span[@class='error-message'])[2]";
    public static final String BUY_GIFT_CARDS_SEND_A_GIFT="//div[contains(@class,'giftCheckboxContainer')]/span";
    public static final String BUY_GIFT_CARDS_TOOL_TIP="//div[contains(@class,'giftCheckboxContainer')]/img";
    public static final String BUY_GIFT_CARDS_TOOL_TIP_CONTENT="//div[contains(@class,'tvl-tooltip-pc-content')]";
    public static final String BUY_GIFT_CARDS_SHOW_RECIPIENT_CHECKBOX ="//input[@name='show_recipient']";
    public static final String BUY_GIFT_CARDS_RECIPIENT_NAME ="//input[@name='recipient_name']";
    public static final String BUY_GIFT_CARDS_RECIPIENT_EMAIL ="//input[@name='recipient_email']";
    public static final String BUY_GIFT_CARDS_RECIPIENT_EMAIL_ERROR ="//input[@name='recipient_email']/following-sibling::span";
    public static final String BUY_GIFT_CARDS_RECIPIENT_MESSAGE ="//input[@name='message']";

    public static final String BUY_GIFT_CARDS_SECTION_PAYMENT="(//div[contains(@class,'BuyGiftCard_section')]/h3)[3]";
    public static final String BUY_GIFT_CARDS_SECTION_PAYMENT_CREDIT="(//div[contains(@class,'BuyGiftCard_section')]/h3)[3]";

    public static final String BUY_GIFT_CARDS_ITEM="(//div[contains(@class,'BuyGiftCard_line')])[1]/label";
    public static final String BUY_GIFT_CARDS_SUB_TOTAL_LABEL ="(//div[contains(@class,'BuyGiftCard_line')])[2]/label";
    public static final String BUY_GIFT_CARDS_SUB_TOTAL ="(//div[contains(@class,'BuyGiftCard_content')]/div/span)[2]";
    public static final String BUY_GIFT_CARDS_TOTAL_LABEL ="(//div[contains(@class,'BuyGiftCard_line')])[3]/label";
    public static final String BUY_GIFT_CARDS_TOTAL_CHARGE="//div[contains(@class,'totalInfo')]/div/div/span/span";
    public static final String BUY_GIFT_CARDS_TERM="//p[contains(@class,'BuyGiftCard_agreeTerm')]";
    public static final String BUY_GIFT_CARDS_PURCHASE_BTN="//div[contains(@class,'GiftCard_total')]/button";
    public static final String BUY_GC_PURCHASE_LABEL ="//p[contains(@class,'BuyGiftCard_line')]/label";
    public static final String BUY_GC_PURCHASE_LABEL_DYNAMIC ="(//p[contains(@class,'BuyGiftCard_line')]/label)[%s]";

    public static final String BUY_GC_PAYMENT_METHOD_LIST ="//ul[@id='checkoutPaymentNav']/li";
    public static final String BUY_GC_PAYMENT_METHOD_DYNAMIC ="(//ul[@id='checkoutPaymentNav']/li)[%s]";
    public static final String BUY_GC_PAYMENT_METHOD_VALUE="(//ul[@id='checkoutPaymentNav']/li)[%s]/label/input";
    public static final String BUY_GC_WALLET_LIST="//p[contains(@class,'Wallet_balance')]//following-sibling::input";
    public static final String BUY_GC_WALLET_VALUE="(//p[contains(@class,'Wallet_balance')]//following-sibling::input)[%s]";
    public static final String BUY_GC_PURCHASE_BTN ="//div[contains(@class,'totalInfo')]/button";
    public static final String BUY_GIFT_PURCHASE_POPUP_TITLE="//h3[contains(@class,'TvlPopup_title')]";
    public static final String BUY_GIFT_PURCHASE_POPUP_CONTENT="(//h3[contains(@class,'TvlPopup_title')]/following-sibling::div)[1]";
    public static final String BUY_GIFT_PURCHASE_POPUP_BTN="(//h3[contains(@class,'TvlPopup_title')]/following-sibling::div)[2]/button";
    public static final String BUY_GIFT_PURCHASE_CRYPTO_SELECT_ERROR="//div[contains(@class,'Crypto_container')]/span";
    public static final String BUY_GC_CRYPTO_PAYMENT_AMOUNT="//div[contains(@class,'totalInfo')]/div/div/span/span";
    public static final String BUY_GC_CRYPTO_ADDRESS="(//div[contains(@class,'cryptoBox')]/div)[3]/div/div/span";
    public static final String BUY_GC_CRYPTO_MEMO_LABEL="(//div[contains(@class,'cryptoBox')]/div)[4]";
    public static final String BUY_GC_CRYPTO_MEMO="(//div[contains(@class,'cryptoBox')]/div)[4]/div/div/span";



  }
