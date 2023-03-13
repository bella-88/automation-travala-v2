package interfaces.hotel.footer.support;

public class ContactUsPageUI  {

  public static final String CONTACT_US_TXT="//h1[contains(text(),'Contact us')]";
  public static final String CONTACT_LINK1="(//div[contains(@class,'breadcrumb')]/span)[1]";
  public static final String CONTACT_LINK2="(//div[contains(@class,'breadcrumb')]/span)[2]";
  public static final String CONTACT_TITLE="//h1[contains(@class,'page-title')]";
  public static final String CONTACT_YOUR_NAME_LABEL ="(//div[contains(@class,'FormContact_customFormPC')]/div/label)[1]";
  public static final String CONTACT_YOUR_NAME_TXT ="//input[@name='your_name']";
  public static final String CONTACT_INVALID_YOUR_NAME="//input[@name='your_name']/following-sibling::small";
  public static final String CONTACT_EMAIL_LABEL ="(//div[contains(@class,'FormContact_customFormPC')]/div/label)[2]";
  public static final String CONTACT_EMAIL_TXT ="//input[@name='your_email']";
  public static final String CONTACT_INVALID_EMAIL="//input[@type='email']/following-sibling::small";
  public static final String CONTACT_YOUR_MESSAGE_LABEL="//div[contains(@class,'FormContact_customFormPC')]/following-sibling::label";
  public static final String CONTACT_YOUR_MESSAGE_TXT="//textarea[@name='your_message']";
  public static final String CONTACT_INVALID_YOUR_MESSAGE="//textarea[@name='your_message']/following-sibling::small";
  public static final String CONTACT_SUBMIT="//form[contains(@class,'FormContact_form')]/button";
  public static final String CONTACT_ABOUT_US="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_INVITE="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_SMART="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_BEST_PRICE="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_TRAVEL_GIFT_CARD="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_TRAVEL_CREDIT="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_PAYMENT="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_PRIVACY="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_COOKIE="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_CONTACT="(//a[contains(@href,'about-us')])[1]";
  public static final String CONTACT_TERM="(//a[contains(@href,'about-us')])[1]";

}
