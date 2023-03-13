package interfaces.hotel;

public class CheckOutPageUI {

  //========================LANGUAGE CONTACT CHECKOUT ===============================================
  public static final String CHECKOUT_STEP1 = "(//span[contains(@class,'StepList_title')])[1]";
  public static final String CHECKOUT_STEP2 = "(//span[contains(@class,'StepList_title')])[2]";
  public static final String CHECKOUT_STEP3 = "(//span[contains(@class,'StepList_title')])[3]";
  public static final String CHECKOUT_NOTE_SECURE = "//div[contains(@class,'secureCheckout')]";
  public static final String CHECKOUT_NOTE_LOGIN = "//div[contains(@class,'BookingPagePC_loginSuggest')]";
  public static final String CHECKOUT_CONTACT_INFO = "//h2[contains(@id,'checkoutDetailForm')]";
  public static final String CHECKOUT_FIRST_NAME_LABEL = "//input[@name='user_first_name']/preceding-sibling::label";
  public static final String CHECKOUT_LAST_NAME_LABEL = "//input[@name='user_last_name']/preceding-sibling::label";
  public static final String CHECKOUT_PHONE_LABEL = "//div[contains(@class,'TvlPhoneSelectPC')]/preceding-sibling::label";
  public static final String CHECKOUT_EMAIL_LABEL = "//input[contains(@name,'user_email')]/preceding-sibling::label";
  public static final String CHECKOUT_NOTE_BOOKING = "//p[contains(@class,'BookingFormInfo_emailConfirm')]";
  public static final String CHECKOUT_BED_PREFERENCE = "(//div[contains(@class,'BookingFormInfo_formGroup')]/following-sibling::h2)[1]";
  public static final String CHECKOUT_RESERVATION_NAME = "//h2[@id='checkoutReservationForm']";
  public static final String CHECKOUT_RESERVATION_NAME_SUB = "//p[contains(@class,'reservationDesc')]";

  public static final String PHONE_OPTION = "//div[@class='TvlCountrySelectPC_listItem___vkP8z']//span";
  public static final String FIRST_NAME_TXT = "//input[@name='user_first_name']";
  public static final String FIRST_ROOM_GUEST_NAME_TXT = "//input[@name='room_guests[0].adult_first_name']";
  public static final String LAST_NAME_TXT = "//input[@name='user_last_name']";
  public static final String LAST_ROOM_GUEST_NAME_TXT = "//input[@name='room_guests[0].adult_last_name']";
  public static final String EMAIL_TEXTBOX = "//input[@name='user_email']";
  public static final String FIRST_NAME_TEXTBOX_BY_ROOM = "(//input[@name='user_first_name'])[%s]";
  public static final String LAST_NAME_TEXTBOX_BY_ROOM = "(//input[@name='user_last_name'])[%s]";
  public static final String PHONE_NUMBER_TEXTBOX = "//input[@class='TvlPhoneSelectPC_input__2rTww']";
  public static final String ICON_SELECT_PHONE_COUNTRY = "//div[contains(@class, 'TvlPhoneSelectPC_countrySelect')]";
  public static final String SELECT_PHONE_COUNTRY_BY_COUNTRY_NAME = "//div[contains(@class, 'TvlCountrySelectPC_listItem')]/span[contains(text(),'%s')]";
  public static final String CHECKOUT_STEP_1_ACTIVE = "//span[contains(@class, 'StepList_active') and text()='1']";
  public static final String CHECKOUT_STEP_2_ACTIVE = "//span[contains(@class, 'StepList_active') and text()='2']";

  //========================LANGUAGE RESERVATION CHECKOUT ===============================================

  public static final String RESERVATION_ROOM_TITLE_LIST = "//div[contains(@class,'titleRoom')]";
  public static final String RESERVATION_ROOM_TITLE_DYNAMIC = "(//div[contains(@class,'titleRoom')])[%s]";
  public static final String RESERVATION_FIRST_NAME_LABEL_LIST = "//input[contains(@name,'adult_first_name')]//preceding-sibling::label";
  public static final String RESERVATION_LAST_NAME_LABEL_LIST = "//input[contains(@name,'adult_last_name')]//preceding-sibling::label";
  public static final String RESERVATION_LAST_NAME_LABEL_DYNAMIC = "(//input[contains(@name,'adult_last_name')]//preceding-sibling::label)[%s]";
  public static final String CHECKOUT_ADDITIONAL_LABEL_LIST = "//label[contains(@class,'AdditionalRequest_title')]";
  public static final String ROOM_GUEST_LIST = "//input[contains(@name,'room_guests')]";


  //========================LANGUAGE PAYMENT DETAIL CHECKOUT ===============================================
  public static final String CHECKOUT_SELECT_PAYMENT_TXT = "//ul[contains(@id,'checkoutPaymentNav')]/preceding-sibling::h2";
  public static final String CHECKOUT_PROCESS_PAYMENT_BTN = "//div[contains(@class,'BookingFormInfo')]/button";
  public static final String  CHECKOUT_TERM_CONDITION = "//div[contains(@class,'AgreeTerm_container')]/h2";
  public static final String CHECKOUT_TERM_CONDITION_SUB = "(//div[contains(@class,'AgreeTerm_container')]/h2)/following-sibling::p";

  public static final String CHECKOUT_PAYMENT_DETAIL_ROOM_TYPE = "(//div[contains(@class,'SideInfo_roomInfo')]/div)[1]";
  public static final String CHECKOUT_PAYMENT_DETAIL_MEAL_TYPE = "(//div[contains(@class,'SideInfo_roomInfo')]/div)[3]";
  public static final String CHECKOUT_PAYMENT_DETAIL_REFUND = "(//div[contains(@class,'SideInfo_roomInfo')]/div)[5]";
  public static final String CHECKOUT_PAYMENT_CHECK_IN_LABEL = "(//div[contains(@class,'SideInfo_dates')]/div)[1]/span";
  public static final String CHECKOUT_PAYMENT_CHECK_OUT_LABEL = "(//div[contains(@class,'SideInfo_dates')]/div)[2]/span";
  public static final String CHECKOUT_PAYMENT_FULL_PAYMENT_MESSAGE = "//div[contains(@class,'fullPaymentMsg')]/i";
  public static final String CHECKOUT_PAYMENT_CANCEL_POLICY_BTN = "//button[contains(@class,'SideInfo_cancellation')]";
  public static final String CHECKOUT_PAYMENT_IMPORTANT_POLICY_BTN = "//button[contains(@class,'SideInfo_cancellation')]/following-sibling::button";
  public static final String CHECKOUT_PAYMENT_GIVEBACK_TOOLTIP = "//div[contains(@class,'SideInfo_giveback')]/p/span";
  public static final String CHECKOUT_PAYMENT_DETAIL_LABEL = "//h4[contains(@class,'SideInfo_blockTitle')]";
  public static final String CHECKOUT_TOTAL_CHARGE_LABEL = "//div[contains(@class,'TotalCharge_title')]";
  public static final String CHECKOUT_TOTAL_CHARGE_WALLET = "//div[contains(@class,'priceColumn')]/span/span";
  public static final String CHECKOUT_CREDIT_CARD_FEE = "//div[contains(@class,'TotalCharge_fees')]/div";
  public static final String CHECKOUT_TOTAL_CHARGE_LOGO = "//div[contains(@class,'priceColumn')]/span/img";
  public static final String CHECKOUT_TOTAL_CHARGE_TC_AMOUNT = "//div[contains(@class,'mainPrice')]//span/span[not(contains(text(),'US$'))]";
  public static final String CHECKOUT_TOTAL_CHARGE_CRYPTO_AMOUNT = "//div[contains(@class,'TotalCharge_priceWrapper')]//span/span[not(contains(text(),'US$'))]";
  public static final String CHECKOUT_BEST_PRICE_CONTENT = "//div[contains(@class,'BestPriceGuarantee_content')]/p";


  //========================PARTIAL_VOUCHER CHECKOUT ===============================================
  public static final String CHECKOUT_PARTIAL_VOUCHER_TITLE = "//div[contains(@id,'partialPayment')]/preceding-sibling::h2";
  public static final String CHECKOUT_PARTIAL_PAYMENT_LABEL = "//label[contains(@class,'PartialPayment')]/span";
  public static final String CHECKOUT_PARTIAL_PAYMENT_CHECKBOX = "//label[contains(@class,'PartialPayment')]/input";
  public static final String CHECKOUT_PARTIAL_VOUCHER_SUB = "//p[contains(@class,'VoucherForm_title')]";
  public static final String CHECKOUT_VOUCHER_CODE_TXT = "//input[contains(@class,'VoucherForm_input')]";
  public static final String CHECKOUT_VOUCHER_CODE_ADD_BTN = "//button[contains(@class,'VoucherForm_addBtn')]";
  public static final String CHECKOUT_PARTIAL_AVA_TITLE = "//p[contains(@class,'avaTitle')]";
  public static final String CHECKOUT_PARTIAL_VALUE_TXT = "//input[contains(@name,'partial_value')]";
  public static final String CHECKOUT_PARTIAL_AVA_REMAIN = "(//div[contains(@class,'PartialPayment')]/span)[1]";
  public static final String CHECKOUT_PARTIAL_AVA_BTN = "//div[contains(@class,'partialInput')]/button";

  public static final String CHECKOUT_PARTIAL_TITLE = "//div[contains(@id,'partialPayment')]/preceding-sibling::h2";
  public static final String CHECKOUT_PARTIAL_SUB = "//label[contains(@class,'PartialPayment_label')]/span";
  public static final String POPUP_BOOKING_PROCESS_TITLE = "//p[contains(@class,'TvlLoadingOverlay_content')]";
  public static final String CHECKOUT_POP_UP_SUCCESS_CONTENT = "//p[contains(@class,'TvlLoadingOverlay_content')]";
  public static final String POPUP_BOOKING_PROCESS_SUB_CONTENT = "//p[contains(@class,'TvlLoadingOverlay_content')]";

  //========================SELECT PAYMENT===============================================
  public static final String APP_CRYPTO_BUTTON = "//input[@value='crypto_com']";
  public static final String UTRUST_BUTTON = "//ul[@id='checkoutPaymentNav']//input[@value='utrust']";

  public static final String PAYMENT_BUTTON = "//input[@value='%s']";
  public static final String CHECK_OUT_TYPE_PAYMENT = "//ul[@id='checkoutPaymentNav']/li/label/input";
  public static final String CHECK_OUT_TYPE_PAYMENT_DYNAMIC = "(//ul[@id='checkoutPaymentNav']/li/label/input)[%s]";

  public static final String COMPLETE_RESERVATION_BUTTON_OLD = "//button[@type='submit']/div";
  public static final String COMPLETE_RESERVATION_BUTTON = "//button[@type='submit']";
  public static final String PAYMENT_SENT_BTN = "//button[contains(@class,'PopupConfirmBtn')]";
  public static final String CHECKOUT_PAYMENT_NOTE_CONTENT = "//p[contains(@class,'paymentInstruction')]";
  public static final String CHECKOUT_PAYMENT_IMPORTANT = "//p[contains(@class,'importantAttention')]";
  public static final String CHECKOUT_NOTE_REFUND_CRYPTO = "//div[contains(@class,'NoteCryptoRefund')]/h4";
  public static final String CHECKOUT_NOTE_REFUND_CRYPTO_CONTENT = "//div[contains(@class,'NoteCryptoRefund')]/p";


  //========================MY WALLET===============================================

  public static final String CHECKOUT_WALLET_RADIO_DYNAMIC = "//input[@name='ava_payment' and @value='%s']";
  public static final String CHECKOUT_WALLET_MAIN_BALANCE_DYNAMIC = "//input[contains(@value,'%s')]/preceding-sibling::p/span[contains(@class,'mainBalance')]";

  public static final String CHECKOUT_PAYMENT_WALLET_DISCOUNT = "//span[contains(@class,'coinDiscount')]";
  public static final String CHECKOUT_PAYMENT_WALLET_WARNING = "//p[contains(@class,'warningMessage')]/span";

  public static final String BOOKING_WALLET_POPUP_TITLE = "//div[contains(@class,'wallet-confirm-content')]/h4";
  public static final String BOOKING_WALLET_POPUP_CONTENT = "//div[contains(@class,'wallet-confirm-content')]/p";
  public static final String BOOKING_WALLET_POPUP_OK_BTN = "(//div[contains(@class,'wallet-confirm-content')]/button)[2]";
  public static final String BOOKING_WALLET_POPUP_OK_CANCEL = "(//div[contains(@class,'wallet-confirm-content')]/button)[1]";
  //========================CREDIT CARD===============================================
  public static final String CREDIT_CARD_WARNING = "//div[contains(@class,'warningMessage')]";
  //========================TRAVEL CREDIT ===============================================

  public static final String CHECKOUT_PAYMENT_TC_BALANCE_LABEL = "//p[contains(@class,'balance')]/b";
  public static final String CHECKOUT_PAYMENT_TC_BALANCE = "(//p[contains(@class,'TravelCredit_balance')]/span)[1]";
  public static final String CHECKOUT_PAYMENT_BUY_TC_BTN = "//a[contains(@class,'TravelCredit_btnBuy')]";
  public static final String CHECKOUT_PAYMENT_BUY_TC_BTNs = "//a[contains(@href,'my-travel-credits')]";
  public static final String CHECKOUT_TC_INSUFFICIENT_FUND_NOTE = "//p[contains(@class,'TravelCredit_insufficientFund')]";
  public static final String CHECKOUT_TC_BALANCE_TC = "(//p[contains(@class,'TravelCredit_balance')]/span)[1]";

  //========================CRYPTO===============================================
  public static final String CRYPTO_POPUP_TITLE_CHECKOUT = "//div[contains(@class,'hotelName')]/h2";
  public static final String CRYPTO_POPUP_PAYMENT_TITLE = "(//div[contains(@class,'paymentAmount')]/p)[1]";
  public static final String CRYPTO_POPUP_PAYMENT_CONTENT = "//p[contains(@class,'indicatedAmount')]";
  public static final String CRYPTO_POPUP_LABEL1 = "(//div[contains(@class,'address')]/div/label)[1]";
  public static final String CRYPTO_POPUP_LABEL2 = "(//div[contains(@class,'address')]/div/label)[2]";
  public static final String CRYPTO_POPUP_COIN = "//span[contains(@class,'typeTotalPrice')]";

  //========================CRYPTO.COM ===============================================
  public static final String CRYPTO_TEXT = "//p[@class='TvlPaymentWidget_paymentInstruction___1DEqb']";
  public static final String CRYPTO_PAY_BUTTON = "//button[@class='CheckoutButton_submitCryptoPay___8-3Oh']//img";
  public static final String PARTIAL_VOUCHER_TEXT = "//label[@class='PartialPayment_label___1Uw8H']";
  public static final String RESERVATION_TERMS_TEXT = "//div[@class='AgreeTerm_container___3JMCe']/h2";
  public static final String BOOKING_CONDITION_LINK = "//div[@class='AgreeTerm_container___3JMCe']//a[contains(text(),'Booking Conditions')]";
  public static final String TERM_CONDITION_LINK = "//div[@class='AgreeTerm_container___3JMCe']//a[contains(text(),'Terms and Conditions')]";
  public static final String PRIVACY_POLICY_LINK = "//div[@class='AgreeTerm_container___3JMCe']//a[contains(text(),'Privacy Policy')]";
  public static final String PARTIAL_PAYMENT_CHECKBOX = "//input[@name='partial_enable']";
  public static final String COUNT_DOWN_CLOCK = "//div[@class='BookingPagePC_countdownClock___2V9CH']/span";
  public static final String PAYMENT_AMOUNT_TEXT = "(//div[@class='BookingPagePC_paymentAmount___1CpVQ']/p)[position()=2]";
  public static final String COIN_AMOUNT_TEXT = "//div[@class='BookingPagePC_addressWrapper___3hX0-']//p[@class='BookingPagePC_code___3A8iK']";
  public static final String ADDRESS_WALLET_COIN_SYSTEM_TEXT = "//div[@class='BookingPagePC_addressWrapper___3hX0- BookingPagePC_walletAddressCustom___3QL6e']//p";
  public static final String ROOM_TYPE_TEXT = "//span[contains(text(),'Room type')]";
  public static final String MONEY_AMOUNT_TEXT_EXPECT = "//span[contains(text(),'Room type')]";
  public static final String CRYPTO_AMOUNT_TEXT_EXPECT = "//span[contains(text(),'Room type')]";




}
