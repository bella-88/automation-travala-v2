package interfaces.hotel;

public class YopMailPageUI {
  //========================================EMAIL BUY GIFT CARD SUCCESS=========================================
  public static final String IFRAME_EMAIL = "//iframe[contains(@name,'ifmail')]";
  public static final String TITLE_INBOX_EMAIL_TXT = "(//div[contains(@class,'lmfd')]/span)[2]";
  public static final String TITLE_EMAIL_TXT = "//div[contains(@class,'ellipsis nw b')]";
  public static final String NAME_RECEIVED = "((//div[@id='mail']/div/div/div)[2]/p)[1]";
  public static final String THANK_YOU_TXT = "((//div[@id='mail']/div/div/div)[2]/p)[2]";
  public static final String CONTENT_TXT = "((//div[@id='mail']/div/div/div)[2]/p)[3]";
  public static final String GIFT_CARD_CODE_TXT = "((//div[@id='mail']/div/div/div)[2]/div)[2]/span";
  public static final String DETAIL_PURCHASE_TXT = "((//div[@id='mail']/div/div/div)[2]/strong)/strong/strong";
  public static final String DETAIL_PURCHASE_LIST = "((//div[@id='mail']/div/div/div)[2]/strong)/strong/ul/li";
  public static final String DETAIL_PURCHASE_DYNAMIC = "(((//div[@id='mail']/div/div/div)[2]/strong)/strong/ul/li)[%s]";
  public static final String DETAIL_PURCHASE_FIRST_NAME = "(((//div[@id='mail']/div/div/div)[2]/strong)/strong/ul/li)[1]";
  public static final String REDEEM_GC_TXT = "((//div[@id='mail']/div/div/div)[2]/strong)/strong/div/div/strong";
  public static final String REDEEM_GC_STEP = "((//div[@id='mail']/div/div/div)[2]/strong)/strong/div/div/ul/li";
  public static final String NOTE_REDEEM_TXT = "(((//div[@id='mail']/div/div/div)[2]/strong)/strong/p)[2]";
  public static final String NOTE_REDEEM_SUPPORT_TXT = "(((//div[@id='mail']/div/div/div)[2]/strong)/strong/p)[3]";
  public static final String BEST_WISH_TXT = "((//div[@id='mail']/div/div/div)[2]/strong)/strong/span";
  public static final String FOOTER_MAIL = "(((//div[@id='mail']/div/div/div)[2]/strong)/strong/p)[4]";

  //========================================EMAIL BUY GIFT CARD PROCESS=========================================
  public static final String NAME_RECEIVED_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[1]";
  public static final String THANK_YOU_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[2]";
  public static final String INFORMED_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[3]";
  public static final String PAYMENT_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[4]";
  public static final String SUPPORT_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[13]";
  public static final String DETAIL_PAYMENT_LIST = "((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span";
  public static final String DETAIL_PAYMENT_DYNAMIC = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[%s]";
  public static final String DETAIL_PAYMENT_FIST_NAME_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[5]";
  public static final String DETAIL_PAYMENT_LAST_NAME_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[6]";
  public static final String DETAIL_PAYMENT_GC_AMOUNT_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[7]";
  public static final String DETAIL_PAYMENT_METHOD_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[8]";
  public static final String DETAIL_PAYMENT_AMOUNT_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[9]";
  public static final String DETAIL_PAYMENT_ADDRESS_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[10]";
  public static final String DETAIL_PAYMENT_MEMO_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[11]";
  public static final String DETAIL_PAYMENT_EXPIRY_TIME_PROCESS = "(((//div[@id='mail']/div/table/tbody/tr)[2]/td/table/tbody/tr)[2]/td/table/tbody/tr/td/span)[12]";

  //========================================EMAIL BUY GIFT CARD SEND A GIFT=========================================
  public static final String BUY_GC_SEND_GIFT_MESSAGE_LABLE = "//span[@style='line-height: 1.47; font-weight: 500']";
  public static final String BUY_GC_SEND_GIFT_MESSAGE = "//span[@style='line-height: 1.47; font-weight: 700; font-style: italic']";
  public static final String BUY_GC_SEND_GIFT_CONTENT = "//span[@style='line-height: 1.47; font-weight: 500']/parent::div/following-sibling::p";
  public static final String BUY_GC_SEND_GIFT_REDEEM_TITLE = "(//span[@style='line-height: 1.47; font-weight: 500']/parent::div/following-sibling::div)[1]/div/strong";
  public static final String BUY_GC_SEND_GIFT_REDEEM_STEP = "(//span[@style='line-height: 1.47; font-weight: 500']/parent::div/following-sibling::div)[1]/div/ul/li";





  public static final String EMAIL_WELCOME = "//div[@class='lms']";
  public static final String CONFIRM_LINK = "//a[text()='Confirm email']";
  public static final String CONTINUE_BTN = "//button[@class='md']";
  public static final String YOP_MAIL_NAME = "//div[@class='ycptalias']/div[@class='bname']";
  public static final String NEXT_EMAIL_BTN = "//div[@id='identifierNext']//button";
  public static final String NEXT_PASSWORD_BTN = "//div[@id='passwordNext']//button";
  public static final String PASSWORD_TXT = "//div[@id='password']";
  public static final String SIGN_IN_TXT = "//*[@data-a11y-title-piece='headingText' and text()='Sign in']";
  public static final String SIGN_IN_PASSWORD_TXT = "//section[@class='aTzEhb ']//div[contains(text(),'To continue, first verify it's you')]";
  //====================LOGIN WITH GOOGLE=====================
  public static final String CONTINUE_WITH_GOOGLE_BTN = "//i[@class='fa fa-google']";
  public static final String EMAIL_TEXTBOX = "//input[@id='identifierId']";
  public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
  public static final String CONTINUE_BUTTON = "(//button[@type='button' and @jsname='LgbsSe'])[position()=1]";
}
