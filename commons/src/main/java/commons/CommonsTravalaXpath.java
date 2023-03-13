package commons;

public class CommonsTravalaXpath {
  //========LOGIN=========
  public static final String BACK_TO_TRAVAL_LINK = "//img[contains(@src,'travala_black')]";
  public static final String LANDING_EMAIL_TXT = "//input[@name='email']";
  public static final String LANDING_PASSWORD_TXT = "//input[@name='password']";
  public static final String LANDING_LOGIN_BTN = "//button[@type='submit']";
  public static final String LOGIN_LINK="//a[@class='social-auth login ng-scope']";
  public static final String USERNAME_TXT="//div[@class='form-group input-wrapper']//input[@name='email']";
  public static final String PASSWORD_TXT="//input[@name='password']";
  public static final String LOGIN_BTN="//button[@class='btn btn-primary ng-scope']";
  public static final String FORGOT_PASSWORD_BTN="//a[@class='login-action ng-scope']";
  public static final String LOGIN_TITLE="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";
  public static final String LOGIN_EMAIL_TXT="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";
  public static final String LOGIN_PASSWORD_TXT="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";
  public static final String LOGIN_FORGOT_PASSWORD_LINK="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";
  public static final String LOGIN_REGISTER_TXT="//p[@class='LoginPC_conditionMsg___1Twcq']";
  public static final String LOGIN_REGISTER_LINK="//p[@class='LoginPC_conditionMsg___1Twcq']/a";
  public static final String LOGIN_BINANCE_BTN="//a[@class='SocialLogin_binanceBtn___3FB3G ']";
  public static final String LOGIN_FACEBOOK_BTN="//button[@class='SocialLogin_btnFacebook___mPw-W  metro']";
  public static final String LOGIN_GOOGLE_BTN="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";
  public static final String LOGIN_WECHAT_BTN="//div[@class='SocialLoginPagePC_container___N_apr']/section/h1";

  //====HEADER=====
  public static final String GLOBE_ICON_HEADER = "(//img[contains(@src,'globe')])[1]";
  public static final String CURRENCY_LIST = "//div[contains(@class,'styles_tabs')]/div";
  public static final String LANGUAGE_OPTION = "//img[starts-with(@alt,'%s')]";
  public static final String LANGUAGE_LIST = "//div[contains(@class,'styles_title')]/div";
  public static final String CURRENCY_OPTION = "//div[@data-tab-value='currency']";
  public static final String CURRENCY_TXT_LIST = "//span[contains(@class,'listTitle')]";
  public static final String LANDING_CURRENCY_LIST = "(//span[contains(@class,'listTitle')])[2]/following-sibling::div/div/div";
  public static final String LANDING_FIAT_LIST = "//span[contains(@class,'listTitle')]/preceding-sibling::div/div/div";
  public static final String LANDING_CURRENCY_FIRST = "((//span[contains(@class,'listTitle')])[2]/following-sibling::div/div/div)[1]";
  public static final String LANDING_CURRENCY_CLOSE_BTN = "//img[contains(@src,'close2')]";
  public static final String TOP_HEADER_DOMAIN = "(//ul[contains(@class,'TopHeader')])[1]/li/a";
  public static final String TOP_HEADER_DOMAIN_LIST = "((//ul[contains(@class,'TopHeader')])[1]/li/a)[%s]";
  public static final String LIST_DOMAIN_ACTIVE = "(//div[contains(@class,'tabHeader')]/div)[%s]";

  //===================HEADER LANDING PAGE=======================
  public static final String LOGIN_ICON_HEADER = "//li[contains(@class,'loginNavItem')]";
  public static final String SEARCH_CURRENCY_TXT = "//input[@name='search_currency']";
  public static final String HEADER_CURRENCIES_OPTION = "//div[@data-tab-value='currency']";
  public static final String SEARCH_NOT_FOUND_HEADER = "//span[contains(@class,'notFoundHeader')]";
  public static final String SEARCH_NOT_FOUND_MESSAGE = "//span[contains(@class,'notFoundMessage')]";
  public static final String POPUP_CURRENCY_CLOSE = "//div[contains(@class,'LanguageSelect_closeBtn')]/img";
  public static final String SEARCH_CURRENCY_HAVE_RESULT = "//span[contains(@class,'currencySelectTitle')]";
  public static final String HEADER_CURRENCY_RESULT = "//div[contains(@class,'LanguageSelect_title')]";
  public static final String HEADER_CURRENCY_RESULT_COIN = "//img[contains(@class,'LanguageSelect_icon')]";
  public static final String HEADER_LANGUAGE_RESULT = "//div[contains(@class,'styles_title')]/div";
  public static final String SEARCH_CURRENCIES_TITLE = "//span[contains(@class,'listTitle')]";
  public static final String SEARCH_CURRENCY_ICON = "//div[contains(@class,'styles_title')]/preceding-sibling::img";


  public static final String BANNER_TITLE = "//h1[contains(@class,'heroTitle')]";
  public static final String BANNER_SUB_TITLE = "//h2[contains(@class,'heroSubTitle')]";

  //==========================MENU HOME PAGE======================
  public static final String MY_BOOKING_MENU = "//img[contains(@src,'my-booking')]";
  public static final String PROFILE_ICON = "//div[contains(@class,'TopHeader_avatar')]";

  //==========================MENU PROFILE PAGE======================
  public static final String MY_ACCOUNT_LINK = "//a[contains(@href,'my-profile')]";
  public static final String MENU_WELCOME = "//div[contains(@class,'accountInfo')]/div/h2";
  public static final String MENU_INFO_ACC = "//div[contains(@class,'accountInfo')]/div/p";
  public static final String LEFT_MENU_LIST = "//div[contains(@class,'menuSidebar')]/a/span";
  public static final String MY_BOOKING_LINK = "//div[contains(@class,'profileMenu')]/a[contains(@href,'bookings')]";
  public static final String MY_INVITE_LINK = "//a[contains(@href,'my-invite')]/span";

  public static final String MY_SMART_LINK = "//a[contains(@href,'smart-program')]";
  public static final String MY_WALLET_LINK = "//a[contains(@href,'my-wallet')]";
  public static final String MY_TRAVEL_CREDIT_LINK = "//div[contains(@class,'connectWalletBtn')]/following-sibling::a[@href='/my-travel-credits']";
  public static final String MY_TRAVEL_CREDIT_MENU_LINK = "//a[contains(@href,'/my-travel-credits')]";
  public static final String MY_TRIP_LINK = "//span[contains(@class,'myTrip')]";
  public static final String MY_WISHLIST_LINK = "//a[contains(@href,'my-wishlist')]";
  public static final String TIGER_NFT_LINK = "//a[contains(@href,'my-nft')]";
  public static final String LOG_OUT_BTN = "//button[contains(@class,'logoutBtn')]";
  public static final String LOG_OUT_BTN_LIST = "(//button[contains(@class,'logoutBtn')])[%s]";


  public static final String CONSTANT_POPUP_MES_TITLE = "//h3[@class='TvlPopup_title___LMjCB']";
  public static final String CONSTANT_POPUP_MES_CONTENT = "//h3[@class='TvlPopup_title___LMjCB']/following-sibling::div[1]";
  public static final String CONSTANT_POPUP_MES_OK_BTN = "//button[contains(@class,'undefined')]";


  public static final String GIVEBACK_TOOL_TIP_CONTENT = "//span[contains(@class,'PromotionInfoPC_content')]";
  public static final String VIEW_CONTROL_GRID = "//div[contains(@class,'viewControl')]/button[2]";
  public static final String VIEW_CONTROL_LIST = "//div[contains(@class,'viewControl')]/button[3]";

  //=============BOOKING SUMM==============
  public static final String BOOKING_SUMMARY_STATUS = "//span[contains(@class,'StatusBar_status')]";

  //=====================================================PAYMENT OPTION============================================================
  public static final String PAYMENT_METHOD_LIST_LABEL = "(//ul[@id='checkoutPaymentNav']/li/label)[%s]";
  public static final String PAYMENT_METHOD_LIST = "//input[@name='selected_payment']";
  public static final String PAYMENT_METHOD_DYNAMIC = "(//input[@name='selected_payment'])[%s]";
  public static final String CREDIT_CARD_OPTION = "//input[@value='credit_cards']";
  public static final String MY_WALLET_OPTION = "//input[@value='wallet']";
  public static final String CRYPTO_OPTION = "//input[@value='crypto']";
  public static final String PURCHASE_SUBMIT_BTN = "//div[contains(@class,'totalPrice')]/following-sibling::button";
  public static final String TRAVEL_CREDIT_OPTION = "//input[@value='travel_credits']";
  public static final String VNPAY_BUTTON = "//input[@value='vnpay']";
  public static final String BINANCE_PAY_BUTTON = "//input[@value='binance_pay']";


  //=====================================================MY WALLET==========================================
  public static final String WALLET_COIN_CHECKBOX = "//input[contains(@name,'payment') and @value='%s']";
  public static final String CHECKOUT_WALLET_CONFIRM_OK = "(//img[contains(@src,'wallet-checkout-confirm')]/following-sibling::button)[2]";
  public static final String CHECKOUT_WALLET_CONFIRM_CANCEL = "(//img[contains(@src,'wallet-checkout-confirm')]/following-sibling::button)[1]";
  public static final String CHECKOUT_BUY_TRAVEL_CREDIT = "//a[contains(@href,'tab=buy')]";

  public static final String PAYMENT_WALLET_NAME_LIST = "//p[contains(@class,'walletName')]/span";
  public static final String PAYMENT_WALLET_NAME_DYNAMIC = "(//p[contains(@class,'walletName')]/span)[%s]";
  public static final String PAYMENT_NOT_ENOUGH = "//p[contains(@class,'insufficientFund')]";
  public static final String CRYPTO_COIN_LABEL = "//div[contains(@class,'coinName')]/span";
  public static final String PAYMENT_WALLET_ADDRESS = "(//div[contains(@class,'Information')]//h5)[1]";
  public static final String PAYMENT_WALLET_MEMO = "(//div[contains(@class,'Information')]//h5)[2]";
  public static final String PAYMENT_ENOUGH_FUND = "//p[contains(@class,'insufficientFund')]";
  public static final String CHECKOUT_CRYPTO_COIN_DYNAMIC = "((//div[contains(@class,'Crypto_coinList')])[2]/div)[2]/label/input[@value='%s']";
  public static final String CRYPTO_COIN_NAME_LIST = "//div[contains(@class,'Crypto_coinName')]/span";
  public static final String CRYPTO_COIN_NAME= "//div[contains(@class,'coinName')]";
  public static final String CRYPTO_COIN_DYNAMIC= "//div[contains(@class,'coinName')]";
  public static final String CRYPTO_COIN_NAME_FIRST= "(//div[contains(@class,'coinName')])[1]";

  public static final String CREDIT_CARD_PAYMENT = "(//input[@name='selected_payment'])[1]";


  //=====================================================CREDIT CARD==========================================
  public static final String PURCHASE_FEE_LABEL = "//p[contains(@class,'BuyCredit_line')]/label";
  public static final String IFRAME_CARD_NUMBER = "//iframe[contains(@name,'__privateStripeFrame')]";
  public static final String CARD_NUMBER_TXT = "//input[@name='cardnumber']";
  public static final String EXP_DATE_TXT = "//input[@name='exp-date']";
  public static final String CVC_TXT = "//input[@name='cvc']";
  public static final String INVALID_MESSAGE = "//div[@role='alert']";
  public static final String NOTE_CREDIT_CARD_TXT = "//p[contains(@class,'CreditCard_stripMsg')]";
  public static final String CARD_NUMBER_LABEL = "//label[contains(@class,'CreditCard_cardNumberLabel')]";
}
