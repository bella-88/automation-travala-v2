package interfaces.hotel.myProfile;

public class MyTravelCreditsPageUI {
  //===================MY TRAVEL CREDIT ===========================
  public static final String MY_TRAVEL_CREDIT_BANNER = "//p[contains(@class,'Balance_title')]/span";
  public static final String MY_TRAVEL_CREDIT_TOTAL_AMOUNT = "//p[contains(@class, 'CreditBalance_totalAmount')]/span[not(@class)]";
  public static final String MY_TRAVEL_CREDIT_PROMO_AMOUNT = "//p[span[text()='Promo Amount']]/../span/span[2]";
  public static final String MY_TRAVEL_CREDIT_PERMANENT_AMOUNT = "//p[contains(text(), 'Permanent Amount')]/../span/span[2]";
  public static final String MY_TRAVEL_CREDIT_BANNER_AVAILABLE_AMOUNT = "(//p[contains(@class,'itemTitle')])[1]";
  public static final String MY_TRAVEL_CREDIT_BANNER_PENDING_AMOUNT = "(//p[contains(@class,'itemTitle')])[2]";
  public static final String MY_TRAVEL_CREDIT_BUY_TAB = "(//ul[contains(@class,'TravelCreditsPagePC_tabWrapper')]/li)[1]";
  public static final String MY_TRAVEL_CREDIT_SUMMARY_TAB = "(//ul[contains(@class,'TravelCreditsPagePC_tabWrapper')]/li)[2]";
  public static final String MY_TRAVEL_CREDIT_REDEEM_TAB = "(//ul[contains(@class,'TravelCreditsPagePC_tabWrapper')]/li)[3]";
  public static final String MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT = "(//div[contains(@class,'BuyCredit_section')]/h3)[1]";
  public static final String MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUB = "(//p[contains(@class,'BuyCredit_label')])[1]";
  public static final String MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_NOTE = "(//p[contains(@class,'BuyCredit_noteRate')])[1]";
  public static final String MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_OTHER = "(//p[contains(@class,'BuyCredit_label')])[2]";
  public static final String MY_TRAVEL_CREDIT_BUY_GIFT_CARD_LINK = "//a[contains(@href,'buy-gift-cards')]";
  public static final String MY_TRAVEL_CREDIT_AMOUNT50 = "//div[contains(@class,'amountWrapper')]/label/span[text()='50']";
  public static final String MY_TRAVEL_CREDIT_AMOUNT100 = "//div[contains(@class,'amountWrapper')]/label/span[text()='100']";

  public static final String MY_TRAVEL_CREDIT_BUY_YOUR_AMOUNT_SUPPORT = "//p[contains(@class,'BuyCredit_largeOrder')]";
  public static final String MY_TRAVEL_CREDIT_BUY_SELECT_PAYMENT = "(//div[contains(@class,'BuyCredit_section')]/h3)[2]";
  public static final String MY_TRAVEL_CREDIT_AVA_BALANCE = "(//p[contains(@class,'AvaWallet_walletName')]/span)[1]";
  public static final String MY_TRAVEL_CREDIT_BNB_BALANCE = "(//p[contains(@class,'AvaWallet_walletName')]/span)[2]";
  public static final String MY_TRAVEL_CREDIT_BUSD_BALANCE = "(//p[contains(@class,'AvaWallet_walletName')]/span)[3]";
  public static final String MY_TRAVEL_CREDIT_NOTICE_NOTE_MEMO = "//p[contains(@class,'DepositInformation_warningMessage')]/span";
  public static final String MY_TRAVEL_CREDIT_DEPOSIT_ADDRESS = "(//div[contains(@class,'DepositInformation_addressGroup')]/div)[1]";
  public static final String MY_TRAVEL_CREDIT_DEPOSIT_MEMO = "(//div[contains(@class,'DepositInformation_addressGroup')]/div)[2]";

  public static final String PURCHASE_TC_TITLE = "//div[contains(@class,'BuyCredit_purchase')]/h3";
  public static final String PURCHASE_TC_LABEL = "//div[contains(@class,'Credit_line')]/label";
  public static final String PURCHASE_TC_ITEM_LABEL = "(//div[contains(@class,'BuyCredit_line')]/label)[1]";
  public static final String PURCHASE_TC_AMOUNT_LABEL = "(//div[contains(@class,'BuyCredit_line')]/span)[1]";
  public static final String PURCHASE_TC_SUB_TOTAL_LABEL = "(//div[contains(@class,'BuyCredit_line')]/label)[2]";
  public static final String PURCHASE_TC_TOTAL_LABEL = "//div[contains(@class,'BuyCredit_totalPrice')]/label";
  public static final String MY_TC_TOTAL_TC = "(//p[contains(@class,'totalAmount')]/span)[1]";

    public static final String MY_TRAVEL_SUMMARY_FILTER_TXT = "(//p[contains(@class,'Summary_label')])[1]";
  public static final String MY_TRAVEL_SUMMARY_FILTER_LIST = "(//div[contains(@class,'Summary_selectedValue')])[1]";
  public static final String MY_TRAVEL_SUMMARY_STATUS_TXT = "(//p[contains(@class,'Summary_label')])[2]";
  public static final String MY_TRAVEL_SUMMARY_STATUS_LIST = "(//div[contains(@class,'Summary_selectedValue')])[2]";
  public static final String MY_TRAVEL_SUMMARY_DATE_TXT = "(//p[contains(@class,'Summary_label')])[3]";
  public static final String MY_TRAVEL_SUMMARY_DATE_LIST = "(//div[contains(@class,'Summary_selectedValue')])[3]";
  public static final String MY_TRAVEL_SUMMARY_TYPE_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[1]";
  public static final String MY_TRAVEL_SUMMARY_STATUS_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[2]";
  public static final String MY_TRAVEL_SUMMARY_AMOUNT_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[3]";
  public static final String MY_TRAVEL_SUMMARY_DATE_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[4]";
  public static final String MY_TRAVEL_SUMMARY_NOTE_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[5]";
  public static final String MY_TRAVEL_SUMMARY_INFO_HEADER = "//div[contains(@class,'Summary_tableContainer')]/table/thead/tr/th[6]";
  public static final String MY_TRAVEL_REDEEM_TC = "//div[contains(@class,'RedeemGift_contentWrapper')]/h3";
  public static final String MY_TRAVEL_REDEEM_CONTENT = "//div[contains(@class,'RedeemGift_contentWrapper')]/p";
  public static final String MY_TRAVEL_REDEEM_TXT = "//input[@name='code']";
  public static final String MY_TRAVEL_REDEEM_GIFT_CARD_BTN = "//div[contains(@class,'RedeemGift_btnWrapper')]/button";
  public static final String MY_TRAVEL_REDEEM_GIFT_CARD_LINK = "//a[contains(@href,'/buy-gift-cards')]";

  public static final String AMOUNT_BUTTON_LIST = "//input[@name='preset_amount']/following-sibling::span";
  public static final String SUB_TOTAL_TC = "(//span[contains(@class,'TvlPrice_container')])[position()=2]/span[2]";
  public static final String TOTAL_TC = "(//span[contains(@class,'TvlPrice_container')])[position()=2]/span[2]";
  public static final String PRICE_PAYMENT_AMOUNT = "//span[@style='font-size: 15px;']";

  public static final String BUY_TC_PAYMENT_AMOUNT = "(//div[contains(@class,'purchase')]/div)[2]/span";
  public static final String BUY_TC_PAYMENT_TOTAL_PRICE = "//div[contains(@class,'totalPrice')]/div/span";
  public static final String BUY_TC_PAYMENT_SUB_TOTAL_PRICE = "//p[contains(@class,'subPrice')]/span";
  //=========================POPUP BUY CRYPTO SUCCESS=======================
  public static final String BUY_TC_CRYPTO_SELECT_LABEL = "//div[contains(@class,'selectCrypto')]/h3";
  public static final String BUY_TC_CRYPTO_SELECT_HOLDER = "(//div[contains(@class,'Crypto_selected')]/span)[1]";
  public static final String BUY_TC_CRYPTO_SELECT_NETWORK_HOLDER = "(//div[contains(@class,'Crypto_selected')]/span)[2]";
  public static final String BUY_TC_CRYPTO_SELECT_NETWORK_LABEL = "//div[contains(@class,'selectNetwork')]/h3";
  public static final String BUY_TC_POPUP_ERROR_PAYMENT = "(//div[contains(@class,'tooltip-popup-content')]/div)[1]";
  public static final String BUY_TC_POPUP_ERROR_PAYMENT_BTN = "(//div[contains(@class,'tooltip-popup-content')]/div)[2]/button";
  public static final String BUY_TC_POPUP_TITLE = "//div[contains(@class,'Processing_title')]/h3";
  public static final String BUY_TC_CRYPTO_POPUP_TOTAL = "//p[contains(@class,'totalPrice')]/label";
  public static final String BUY_TC_CRYPTO_POPUP_SUB_TOTAL = "(//p[contains(@class,'Processing_line')]/label)[2]";
  public static final String BUY_TC_CRYPTO_POPUP_DISCOUNT = "(//p[contains(@class,'Processing_line')]/label)[3]";

  public static final String BUY_TC_CRYPTO_POPUP_AMOUNT = "//p[contains(@class,'Processing_label')]/span";
  public static final String BUY_TC_CRYPTO_POPUP_CONTENT = "//p[contains(@class,'boxTitle')]";
  public static final String BUY_TC_CRYPTO_POPUP_NETWORK = "(//div[contains(@class,'Processing_value')]//div/label)[1]";
  public static final String BUY_TC_CRYPTO_POPUP_WALLET = "(//div[contains(@class,'Processing_value')]//div/label)[2]";
  public static final String BUY_TC_CRYPTO_POPUP_EXPIRES_TIME = "//p[contains(@class,'PaymentProcessing_expireMsg')]";
  public static final String BUY_TC_CRYPTO_CLOSE_BTN = "//div[contains(@class,'Processing_container')]/button//*[name()='svg']";
  public static final String BUY_TC_CRYPTO_POPUP_TOTAL_PRICE = "//p[contains(@class,'totalPrice')]/span";
  public static final String BUY_TC_CRYPTO_POPUP_TOTAL_COIN = "//p[contains(@class,'Processing_price')]/b";
  public static final String CRYPTO_MESSAGE_ENOUGH_CRYPTO_BTN = "(//div[contains(@class,'tvl-tooltip-popup-content')]/div)[1]";
  public static final String BUY_TC_MESSAGE_ENOUGH_CRYPTO = "(//div[contains(@class,'tvl-tooltip-popup-content')]/div)[2]";

  //======================BUY TC FROM CREDIT CARD=========================
  public static final String MY_TRAVEL_CREDIT_CARD_PROCESS_TXT = "//div[contains(@class,'BuyCredit_viewLatest')]";
  public static final String MY_TC_TRANSACTION_LIST = "(//tr[contains(@class,'transactionRow')])[1]/td";
  public static final String MY_TC_PURCHASE_TYPE = "((//tr[contains(@class,'transactionRow')])[1]/td)[1]";
  public static final String MY_TC_PURCHASE_STATUS = "((//tr[contains(@class,'transactionRow')])[1]/td)[2]";
  public static final String MY_TC_SUMMARY_NOTE = "((//tr[contains(@class,'HistoryItem_transactionRow')])[1]/td)[5]";
  public static final String MY_TC_SUMMARY_DATE = "((//tr[contains(@class,'HistoryItem_transactionRow')])[1]/td)[4]";
  public static final String MY_TC_SUMMARY_AMOUNT = "((//tr[contains(@class,'HistoryItem_transactionRow')])[1]/td)[3]";
  public static final String MY_TC_SUMMARY_INFORMATION = "(//td[contains(@class,'transactionInfo')]/div/p)[1]/span";
  public static final String MY_TC_SUMMARY_CRYPTO_NO = "(//td[contains(@class,'transactionInfo')]/div/p)[2]/span";
  public static final String PURCHASE_CREDITS_BTN = "//div[contains(@class,'totalPrice')]/following-sibling::button";
  //======================BUY TC FROM WALLET=========================
  public static final String AVA_PAYMENT_WALLET = "//input[@value='AVA']";
  public static final String PAYMENT_AMOUNT_TXT = "//div[contains(@class,'remind-msg ng-scope' and contains(text(),'Send the indicated amount')]";
  public static final String ADDRESS_WALLET_TXT = "//div[contains(@class,'modal-dialog ']//label[text()='Wallet Address']";
  public static final String PAYMENT_WALLET_COIN = "//input[@value='%s']";
  public static final String MY_TC_WALLET_PAYMENT = "//input[@name='ava_payment']";
  public static final String MY_TC_WALLET_PAYMENT_DYNAMIC = "(//input[@name='ava_payment'])[%s]";
  public static final String MY_TC_PAYMENT_INSUFFICIENT_FUND = "//p[contains(@class,'insufficientFund')]";
  public static final String WALLET_TC_PAYMENT_NOTE = "//ul[contains(@class,'Information_note')]/li";
  public static final String WALLET_TC_PAYMENT_ADDRESS = "(//div[contains(@class,'DepositInformation')]/div/h5)[1]";
  public static final String WALLET_TC_PAYMENT_MEMO = "(//div[contains(@class,'DepositInformation')]/div/h5)[2]";
  public static final String MY_TC_PAYMENT_MEMO = "(//div[contains(@class,'Information')]///h5)[2]";

  public static final String POP_UP_NOT_ENOUGH_TC = "(//div[contains(@class,'popup-content')]/div)[2]";
  public static final String CONFIRM_POP_UP_BTN = "//button[contains(@class,'confirmBtn')]";
  public static final String MY_TC_PAYMENT_WALLET_WARNING_MEMO = "//p[contains(@class,'DepositInformation_warningMessage')]/span";
  public static final String MY_TC_PAYMENT_WALLET_ADDRESS = "(//div[contains(@class,'DepositInformation_addressGroup')]/div/h5)[1]";
  public static final String MY_TC_PAYMENT_WALLET_MEMO = "(//div[contains(@class,'DepositInformation_addressGroup')]/div/h5)[2]";
  public static final String MY_TC_PAYMENT_WALLET_MEMO_TOOLTIP = "//p[contains(@class,'AvaWallet_insufficientFund___OtunU']";
  public static final String BUY_TC_WALLET_NOTE_DEPOSIT = "(//ul[contains(@class,'DepositInformation_note')]/li)[1]";
  public static final String BUY_TC_WALLET_NOTE_NETWORK = "(//ul[contains(@class,'DepositInformation_note')]/li)[2]";
  public static final String BUY_TC_WALLET_NOTE_MEMO = "(//ul[contains(@class,'DepositInformation_note')]/li)[3]";

  //======================REDEEM GIFT CARD TAB=========================
  public static final String REDEEM_GIFT_CARD_MORE_URL = "//div[contains(@class,'RedeemGift_content')]/p/a";
  public static final String REDEEM_BUY_GIFT_CARD_URL = "//div[contains(@class,'RedeemGift')]/a";
  public static final String REDEEM_CODE_TXT = "//input[@name='code']";
  public static final String REDEEM_GIFT_CARD_BTN = "//button[@type='submit']";
  public static final String REDEEM_ERROR_CODE_TXT = "//span[contains(@class,'error-message')]";
  public static final String SUMMARY_TAB_IN_MY_TRAVEL_CREDITS = "//ul[contains(@class, 'TravelCreditsPagePC_tabWrapper')]/li[text()='Summary']";
  public static final String REWARD_BONUS_TRANSACTION_IN_MY_TRAVEL_CREDIT = "//tr[td[text()=\"Bonus Reward\"]]/td[contains(@class, 'HistoryItem_note')]";

}
