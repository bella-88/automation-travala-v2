package interfaces.hotel.footer.support;

public class ConciergePageUI {
  public static final String CONCIERGE_HEADER_MENU_LIST="//ul[contains(@class,'Header_menu')]/li/a";
  public static final String CONCIERGE_HEADER_MENU_DYNAMIC="(//ul[contains(@class,'Header_menu')]/li/a)[%s]";
 public static final String CONCIERGE_TITLE_LIST="//h2[contains(@class,'title')]";
  public static final String CONCIERGE_TITLE_DYNAMIC="(//h2[contains(@class,'title')])[%s]";
  public static final String CONCIERGE_WE_ARE1="(//p[contains(@class,'WeAre')])[1]";
  public static final String CONCIERGE_WE_ARE2="(//p[contains(@class,'WeAre')])[2]";
  public static final String CONCIERGE_SERVICES_LIST="//ul[contains(@class,'collectionList')]/li/span";
  public static final String CONCIERGE_SERVICES_DYNAMIC="(//ul[contains(@class,'collectionList')]/li/span)[%s]";
  public static final String CONCIERGE_SERVICES="//h2[contains(@class,'collectionHeader')]";
  public static final String CONCIERGE_SUB_CONCIERGE="//p[contains(@class,'WhyConcierge_subtitle')]";
  public static final String CONCIERGE_CONCIERGE_TITLE_LIST="//h2[contains(@class,'cardTitle')]";
  public static final String CONCIERGE_CONCIERGE_TITLE_DYNAMIC="(//h2[contains(@class,'cardTitle')])[%s]";
  public static final String CONCIERGE_CONCIERGE_DESC_LIST="//p[contains(@class,'cardDescription')]";
  public static final String CONCIERGE_CONCIERGE_DESC_DYNAMIC="(//p[contains(@class,'cardDescription')])[%s]";
 public static final String CONCIERGE_GUIDE_LIST="//ol[contains(@class,'guide')]/li";
  public static final String CONCIERGE_GUIDE_DYNAMIC="(//ol[contains(@class,'guide')]/li)[%s]";
  public static final String CONCIERGE_FOOTER_LIST="(//div[contains(@class,'Footer_container')]/ul/li/a)";
  public static final String CONCIERGE_FOOTER_DYNAMIC="(//div[contains(@class,'Footer_container')]/ul/li/a)[%s]";
  public static final String CONCIERGE_CONTENT_LIST="//p[contains(@class,'description')]";
  public static final String CONCIERGE_CONTENT_SERVICES="(//p[contains(@class,'ExclusiveServiceSlider_description')])[%s]";
  public static final String CONCIERGE_CONTENT_TEST="//div[contains(@class,'Testimonial_dots')]/ul/li";
  public static final String CONCIERGE_CONTENT_TEST_LIST="(//div[contains(@class,'Testimonial_dots')]/ul/li)[%s]";
  public static final String CONCIERGE_CONTENT_TEST_DYNAMIC="(//p[contains(@class,'Testimonial_description')])[%s]";
  public static final String CONCIERGE_TRAVEL_INSPIRATION_TITLE_POST="//div[contains(@class,'Inspiration_title')]";
  public static final String CONCIERGE_TRAVEL_INSPIRATION_POST_DYNAMIC="(//div[contains(@class,'Inspiration_title')])[%s]";
  public static final String INSPIRATION_TITLE="//div[contains(@class,'content')]/h2";
  public static final String INSPIRATION_SUB_TITLE="//div[contains(@class,'content')]/h3";
  public static final String INSPIRATION_CONTENT="//div[contains(@class,'content')]/p";
  public static final String INSPIRATION_DETAIL_TITLE="//h1[contains(@class,'Blog_title')]";
  public static final String TRAVEL_INSPIRATION_LINK_FOOTER="//a[@href='/travel-inspiration']";
  public static final String CONCIERGE_TERM_LINK_FOOTER ="//a[@href='/terms-and-conditions']";
  public static final String CONCIERGE_PRIVACY_LINK_FOOTER ="//a[@href='/privacy-policy']";
  public static final String CONCIERGE_CONTACT_US_LINK_FOOTER ="//a[@href='/contact-us']";
 //===========================TERM TAB ===============================================
  public static final String CONCIERGE_TERM_BANNER ="//div[contains(@class,'TermsAndConditions')]/div/h1";
  public static final String CONCIERGE_TERM_DATE_UPDATE ="//div[contains(@class,'TermsAndConditions')]/div/strong";
  public static final String CONCIERGE_TERM_CONTENT="//div[contains(@class,'TermsAndConditions')]/div/p";
  public static final String CONCIERGE_TERM_TITLE="//div[contains(@class,'TermsAndConditions')]/div/h2";
  public static final String CONCIERGE_TERM_SUB_CONTENT="//div[contains(@class,'TermsAndConditions')]/div/ul/li";
 //===========================PRIVACY TAB ===============================================
 public static final String CONCIERGE_PRIVACY_BANNER ="//div[contains(@class,'PrivacyPolicy')]/div/h1";
 public static final String CONCIERGE_PRIVACY_DATE_UPDATE ="//div[contains(@class,'PrivacyPolicy')]/div/strong";
 public static final String CONCIERGE_PRIVACY_CONTENT="//div[contains(@class,'PrivacyPolicy')]/div/p";
 public static final String CONCIERGE_PRIVACY_TITLE="//div[contains(@class,'PrivacyPolicy')]/div/h2";
 public static final String CONCIERGE_PRIVACY_SUB_CONTENT="//div[contains(@class,'PrivacyPolicy')]/div/ul/li";

 //===========================FAQ TAB ===============================================
 public static final String CONCIERGE_FAQ_URL="//a[@href='/faqs']";
 public static final String CONCIERGE_BUSINESS_HEADER="//ul[contains(@class,'Header')]/li/a[@href='/business']";
 public static final String CONCIERGE_APPLY_HEADER="//ul[contains(@class,'Header')]/li/a[@href='/apply']";
 public static final String CONCIERGE_FAQ_BANNER="//div[contains(@class,'Faqs')]/div/h1";
 public static final String CONCIERGE_FAQ_QUESTION_LIST="//div[contains(@class,'listQuestion')]/p";
 public static final String CONCIERGE_FAQ_TITLE="//div[contains(@class,'Faqs_questionDetails')]/div/h3";
 public static final String CONCIERGE_FAQ_CONTENT="//div[contains(@class,'Faqs_questionDetails')]/div/p";
 //===========================APPLY TAB ===============================================
 public static final String CONCIERGE_APPLY_STEP="//div[contains(@class,'step')]/span";
 public static final String CONCIERGE_APPLY_FIRST_NAME="//input[@name='first_name']";
 public static final String CONCIERGE_APPLY_LAST_NAME="//input[@name='last_name']";
 public static final String CONCIERGE_APPLY_EMAIL="//input[@name='email']";
 public static final String CONCIERGE_APPLY_TELEGRAM="//input[@name='telegram_handle']";
 public static final String CONCIERGE_APPLY_PHONE="//input[@name='input_phone']";
 public static final String CONCIERGE_APPLY_PHONE_FLAG="//div[contains(@class,'countryLabel')]/div";
 public static final String CONCIERGE_APPLY_PHONE_SELECT_COUNTRY="//input[@placeholder='Select your country']";
 public static final String CONCIERGE_APPLY_PHONE_ITEM="//div[contains(@class,'listItem')]/span";
 public static final String CONCIERGE_APPLY_NEXT_BTN="(//div[contains(@class,'submit')]/button)[1]";
 public static final String CONCIERGE_APPLY_ERROR_MESSAGE="//div[@class='error-mesage']";
 public static final String CONCIERGE_APPLY_QUESTION1="//div[contains(@class,'ChoosePayment')]/h4/span";
 public static final String CONCIERGE_APPLY_QUESTION2="//div[contains(@class,'Apply_lowerCase')]/label";
 public static final String CONCIERGE_APPLY_AGREE_LABEL="//label[contains(@class,'agree')]";
 public static final String CONCIERGE_APPLY_AGREE_TEXT="//label[contains(@class,'agree')]/preceding-sibling::p";
 public static final String CONCIERGE_APPLY_BTN="(//div[contains(@class,'submit')]/button)[2]";
 public static final String CONCIERGE_APPLY_PAYMENT_SELECT="//div[contains(@class,'Payment_selected')]";
 public static final String CONCIERGE_APPLY_PAYMENT_LIST="//ul[contains(@class,'listOption')]/li/span";
 public static final String CONCIERGE_APPLY_PAYMENT_FIRST="(//ul[contains(@class,'listOption')]/li/span)[1]";
 public static final String CONCIERGE_APPLY_CONFIRM_EMAIL_BANNER="//div[contains(@class,'formStep3')]/h2";
 public static final String CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT1="(//div[contains(@class,'formStep3')]/p)[1]";
 public static final String CONCIERGE_APPLY_CONFIRM_EMAIL_CONTENT2="(//div[contains(@class,'formStep3')]/p)[2]";
 public static final String CONCIERGE_APPLY_CONFIRM_EDIT_EMAIL_BTN="//div[contains(@class,'Apply_action')]/span";
 public static final String CONCIERGE_APPLY_CONFIRM_RESEND_EMAIL_BTN="//div[contains(@class,'Apply_action')]/button";
 public static final String CONCIERGE_APPLY_CONFIRM_CONTACT_US="//div[contains(@class,'Apply_action')]/button";

//===========================CUSTOM PACKAGE TAB ===============================================
public static final String CONCIERGE_PACKAGE_TITLE="//div[contains(@class,'Destinations_title')]";
public static final String CONCIERGE_PACKAGE_BLOG_TITLE="//div[contains(@class,'BlogCard_title')]";
public static final String CONCIERGE_PACKAGE_BLOG_DES="//div[contains(@class,'BlogCard_description')]";
public static final String CONCIERGE_PACKAGE_DOWNLOAD_="//div[contains(@class,'BlogCard_downloadPDF')]";
}
