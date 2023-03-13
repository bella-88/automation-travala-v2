package interfaces.hotel.NFT;

public class BuyNFTPageUI {

  //=================================HEADER====================================

  public static final String NFT_FAQ_CONTENT_DYNAMIC = "(//div[contains(@class,'collapsible-content')])[%s]";
  public static final String AMOUNT_NFT_DROPDOWN = "//div[contains(@class,'SelectNft_select')]";
  public static final String AMOUNT_NFT_LIST_DYNAMIC= "//ul[contains(@class,'listOption')]/li";

  public static final String NFT_MY_WALLET_BTN = "//img[contains(@src,'my-wallet')]";
  public static final String NFT_META_MASK_BTN = "//button/img[contains(@src,'metamask')]";
  public static final String NFT_MY_WALLET_COIN = "//div[contains(@class,'paymentOptionItem')]/div/h4[text()='%s']";
  public static final String NFT_MY_WALLET_BALANCE= "//h4[text()='%s']/following-sibling::p";
  public static final String NFT_TOTAL_PRICE = "(//p[contains(@class,'totalPrice')]/span)[2]";
  public static final String NFT_MINT_BTN = "//button[contains(@class,'BuyNft_button')]";
  public static final String NFT_POP_UP_VIEW_TRANSACTION_BTN = "//button[contains(@class,'AlertPopup_button')]";

}