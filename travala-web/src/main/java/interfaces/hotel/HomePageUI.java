package interfaces.hotel;

public class HomePageUI {

  public static final String HOME_LOGOUT_MENU = "//button[contains(@class,'logOut')]";
  public static final String HOME_INVITE_EARN_TEXT = "//div[contains(@class,'InviteBanner')]/h3";
  public static final String HOME_GIVE_GET_TEXT = "//div[contains(@class,'InviteBanner')]/p";
  public static final String HOME_INVITE_BTN = "//div[contains(@class,'InviteBanner')]/a";
  public static final String MY_ACCOUNT_TITLE = "//p[@class='MyProfilePC_title___1fq9h']";
  public static final String PERSONAL_DETAIL = "//li[@class='MyProfilePC_active___1qI9E']";
  public static final String CONNECT_ACCOUNT = "//li[@class='MyProfilePC_active___1qI9E']/following-sibling::li[1]";
  public static final String SETTING = "//ul[@class='MyProfilePC_tabWrapper___3LNJH']/li[3]";
  public static final String SECURITY = "//ul[@class='MyProfilePC_tabWrapper___3LNJH']/li[4]";
  //========================PERSONAL_DETAIL===============
  public static final String PERSONAL_DETAIL_NOTE_TITLE = "//div[contains(@class,'PersonalInfo_note')]/h3";
  public static final String PERSONAL_DETAIL_NOTE_CONTENT = "//div[contains(@class,'PersonalInfo_note')]/p";
  public static final String PERSONAL_DETAIL_LABEL_DYNAMIC = "(//div[contains(@class,'formGroup')]/label)[%s]";
  public static final String PERSONAL_DETAIL_AFFILIATE_HOLDER = "//input[@name='affiliate_code']";
  public static final String PERSONAL_DETAIL_PASSPORT_ID = "//h4[contains(@class,'passportId')]";
  public static final String PERSONAL_DETAIL_PASSPORT_CONTENT = "//p[contains(@class,'passportIdNote')]";
  public static final String PERSONAL_DETAIL_ADDRESS_HOLDER = "//input[@name='address']";
  public static final String PERSONAL_DETAIL_PHONE_TXT = "//input[@class='TvlPhoneSelectPC_input___117PZ']";
  public static final String PERSONAL_DETAIL_CITY_HOLDER = "//input[@name='city']";
  public static final String PERSONAL_DETAIL_AFFILIATE = "//div[contains(@class,'formGroup')]/label/span";
  public static final String PERSONAL_DETAIL_LABEL = "//div[contains(@class,'formGroup')]/label";
  public static final String PERSONAL_DETAIL_AFFILIATE_LINK = "//a[@href='/affiliate-program']";
  public static final String PERSONAL_DETAIL_ZIP_CODE_HOLDER = "//input[@name='zip_code']";
  public static final String PERSONAL_DETAIL_PASSPORT_SELECT = "//select[@name='document_type']";
  public static final String PERSONAL_TITLE_SELECT_BOX = "//select[@name='username_prefix']";
  public static final String PERSONAL_TITLE_SELECT_ITEM = "//select[@name='username_prefix']/option[@value]";
  public static final String PERSONAL_DETAIL_SAVE_BTN = "//div[contains(@class,'PersonalInfo_btnSave')]/button";
   public static final String PERSONAL_CONGRATULATION_OK = "//button[contains(@class,'TvlPopup_confirmBtn')]";

   public static final String CONNECT_ACC_SOCIAL_NETWORK_TITLE = "//h4[@class='ConnectAccounts_title___3sG2I']";
  public static final String CONNECT_ACC_SOCIAL_NETWORK_SUB = "//p[@class='ConnectAccounts_subTitle___1VAna']";
  public static final String CONNECT_ACC_BTN = "//ul[contains(@class,'socialList')]/li/button";
  public static final String CONNECT_ACC_BTN_DYNAMIC = "(//ul[contains(@class,'socialList')]/li/button)[%s]";


  public static final String CHANGE_EMAIL_LABEL = "//img[contains(@src,'setting_email')]/following-sibling::div/h3";
  public static final String CHANGE_EMAIL_CURRENT_LABEL = "//img[contains(@src,'setting_email')]/following-sibling::div/p";

  public static final String CHANGE_PASS_LABEL = "//img[contains(@src,'setting_password')]/following-sibling::div/h3";
  public static final String CHANGE_PASS_CONTENT = "//img[contains(@src,'setting_password')]/following-sibling::div/p";

  public static final String CHANGE_EMAIL_BTN = "//img[contains(@src,'setting_email')]/following-sibling::button";
  public static final String CHANGE_PASS_BTN = "//img[contains(@src,'setting_password')]/following-sibling::button";

  public static final String CURRENT_PASSWORD_TXT = "//input[@name='password']";
  public static final String NEW_PASSWORD_TXT = "//input[@name='new_password']";
  public static final String NEW_CONFIRM_PASSWORD_TXT = "//input[@name='new_password_confirm']";
  public static final String POPUP_CHANGE_PASSWORD_BTN = "//div[contains(@class,'PopupSave')]/button";
  public static final String SETTING_PASSWORD_TITLE = "//div[contains(@class,'blockContainer')]/div/h3";
  public static final String SETTING_PASSWORD_CONTENT = "//div[contains(@class,'blockContainer')]/div/p";
  public static final String SETTING_LABEL_TXT = "//div[contains(@class,'formGroup')]/label";
  public static final String SETTING_LABEL_TXT_DYNAMIC = "(//div[contains(@class,'formGroup')]/label)[%s]";




  public static final String SETTING_VALID_PASSWORD_TXT = "//span[contains(@class,'pwdValid')]";

  public static final String NEW_PASSWORD_CONDITION = "//div[contains(@class,'condition-password')]/p";
  public static final String NEW_PASSWORD_MESSAGE_ERROR = "//input[@name='new_password']/parent::div/following-sibling::span";
  public static final String CONFIRM_PASSWORD_MESSAGE_ERROR = "(//input[@name='new_password_confirm']/parent::div/following-sibling::span)[1]";

  public static final String POPUP_PASSWORD_ERROR_TITLE = "//div[contains(@class,'popup-content')]/h3";
  public static final String POPUP_PASSWORD_ERROR_CONTENT = "(//div[contains(@class,'popup-content')]/div)[1]";
  public static final String POPUP_PASSWORD_ERROR_OK = "(//div[contains(@class,'popup-content')]/div)[2]";
  public static final String SETTING_NEW_EMAIL_TXT = "//input[@name='new_email']";

  //==========================POPUP CHANGE_EMAIL_SUCCESS==================================================
  public static final String CHANGE_EMAIL_SUCCESS_TITLE = "//div[contains(@class,'CodeConfirm')]/h3";
  public static final String CHANGE_EMAIL_SUCCESS_CONTENT = "//div[contains(@class,'CodeConfirm')]/p";
  public static final String CHANGE_EMAIL_VERIFY_TITLE= "//div[contains(@class,'CodeConfirm')]/preceding-sibling::strong";
  public static final String CHANGE_EMAIL_INPUT_CODE= "//div[contains(@class,'CodeConfirm')]/input";
  public static final String CHANGE_EMAIL_SEND_CODE_BTN= "//div[contains(@class,'DigitCode')]/span";
  public static final String CHANGE_EMAIL_CONFIRM_TXT= "//div[contains(@class,'CodeConfirm_half')]/following-sibling::p";
  public static final String CHANGE_EMAIL_SUBMIT= "//button[contains(@type,'submit')]";
  public static final String CHANGE_EMAIL_INVALID_CODE= "//span[contains(@class,'Confirm_error')]";
  public static final String SETTING_CHANGE_EMAIL_CLOSE_BTN= "//div[contains(@class,'DigitCodeConfirm_close')]//*[name()='svg']";
  public static final String SETTING_LOGIN_PASSWORD_TXT = "//input[@name='login_password']";
  public static final String SETTING_CHANGE_EMAIL_RESEND_BTN = "(//div[contains(@class,'changeEmailAlert')]/button)[1]";
  public static final String SETTING_CHANGE_EMAIL_CANCEL_BTN = "(//div[contains(@class,'changeEmailAlert')]/button)[2]";
  public static final String SETTING_CHANGE_EMAIL_TITLE = "//div[@class='Setting_changeEmailWrapper___3kgyz']/h3";


  public static final String SETTING_INPUT_PASSWORD = "//input[@name='login_password']";
  public static final String SETTING_NEW_PASSWORD_MES = "(//div[@class='Setting_formGroup___34sax'])[3]/span";
  public static final String SECURITY_AUTHEN_GOOGLE = "//div[@class='Security_container___2AJwe']/div/p[1]";
  public static final String SECURITY_AUTHEN_GOOGLE_USE = "//div[@class='Security_container___2AJwe']/div/p[2]";

  //==========================MY BOOKING PAGE==================================================
  public static final String MY_BOOKING_TITLE = "//div[contains(@class,'SectionBookingList_containerPC')]/h3";
  public static final String MY_BOOKING_NO_BOOKING = "//div[contains(@class,'MyBookings_noBookingsPC')]/h3";
  public static final String MY_BOOKING_NO_BOOKING_BTN = "//div[contains(@class,'MyBookings_noBookingsPC')]/a";
  public static final String MY_BOOKING_SECTION_STAY = "//img[contains(@src,'hotel')]";
  public static final String MY_BOOKING_SECTION_FLIGHTS = "/img[contains(@src,'flight')]";
  public static final String MY_BOOKING_SECTION_ACTIVITIES = "//img[contains(@src,'activities')]";

  //=====================================TIGER NFT===================================================
  public static final String NFT_OVERVIEW_TITLE1 = "//div[contains(@class,'nftSlider')]/following-sibling::h2";
  public static final String NFT_OVERVIEW_SUB_CONTENT = "//div[contains(@class,'nftSlider')]/following-sibling::p";
  public static final String NFT_OVERVIEW_BUTTON = "//div[contains(@class,'button')]/a";
  public static final String NFT_OVERVIEW_BUTTON_DYNAMIC = "//div[contains(@class,'button')]/a[%s]";
  public static final String NFT_OVERVIEW_TITLE2 = "//div[contains(@class,'nftSlider')]/following-sibling::h3";
  public static final String NFT_OVERVIEW_TITLE = "//div[contains(@class,'title')]/h4";
  public static final String NFT_OVERVIEW_SLIDE_IMG = "//div[contains(@class,'title')]/h4";
  public static final String NFT_OVERVIEW_CONTENT = "//div[contains(@class,'title')]/p";
  public static final String NFT_OVERVIEW_TOTAL_ITEM = "//div[contains(@class,'Overview_brand')]";
  public static final String NFT_OVERVIEW_LIST_ITEM = "//div[contains(@class,'listNft')]/div";
  public static final String NFT_OVERVIEW_LIST_ITEM_DYNAMIC = "(//div[contains(@class,'listNft')]/div/div)[%s]";
  public static final String NFT_OVERVIEW_BACK_BTN = "//div[contains(@class,'Overview_brand')]";
  public static final String NFT_OVERVIEW_TABLE_TITLE = "//div[contains(@class,'nftContent')]//tr/th";
  public static final String NFT_OVERVIEW_DETAIL_IMG_TITLE = "//div[contains(@class,'nftImage')]/p/strong";
  public static final String NFT_OVERVIEW_DETAIL_IMG = "//div[contains(@class,'Overview_img')]";

  public static final String BALANCE_ON_HEADER = "//li/div[contains(@class, 'TvlTopHeader_totalBalanceBtn')]";
  public static final String NFT_OVERVIEW_NO_TIGER_NFT_TITLE = "//div[contains(@class,'nftSlider')]/following-sibling::h2";
  public static final String NFT_OVERVIEW_NO_TIGER_NFT_CONTENT = "(//div[contains(@class,'nftSlider')]/following-sibling::p)[1]";
  public static final String NFT_OVERVIEW_SMART_DIAMOND_BENEFITS_TITLE = "//div[contains(@class,'nftSlider')]/following-sibling::h3";
  public static final String NFT_OVERVIEW_SMART_DIAMOND_BENEFITS_CONTENT = "(//div[contains(@class,'nftSlider')]/following-sibling::p)[2]";
  public static final String NFT_OVERVIEW_BENEFIT_TITLE_LIST = "//div[contains(@class,'NftOverview_benefitAll')]//div[contains(@class, 'title')]/h4";
  public static final String NFT_OVERVIEW_BENEFIT_TITLE_DYNAMIC = "(//div[contains(@class,'NftOverview_benefitAll')]//div[contains(@class, 'title')]/h4)[%s]";
  public static final String NFT_OVERVIEW_BENEFIT_DESC_LIST = "//div[contains(@class,'NftOverview_benefitAll')]//div[contains(@class, 'title')]/p";
  public static final String NFT_OVERVIEW_BENEFIT_DESC_DYNAMIC = "(//div[contains(@class,'NftOverview_benefitAll')]//div[contains(@class, 'title')]/p)[%s]";

}
