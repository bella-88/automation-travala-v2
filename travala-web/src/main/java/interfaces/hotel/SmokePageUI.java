package interfaces.hotel;

public class SmokePageUI {
  public static final String INPUT_EMAIL_TXT = "//input[@id='login']";
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
  public static final String CANONICAL_TAG = "//link[@rel='canonical']";
  public static final String A_TAG_NOT_HREF_LINK = "//a[not(@href)]";
  public static final String A_TAG_HAVE_HREF_LINK = "//a[@href]";
  public static final String A_TAG_NOT_DOMAIN_TRAVALA = "//a[@target='_blank' and starts-with(@href, 'https') and not(starts-with(@href, 'https://www.travala.com'))]";
}
