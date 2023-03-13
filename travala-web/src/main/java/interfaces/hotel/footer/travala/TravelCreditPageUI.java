package interfaces.hotel.footer.travala;

public class TravelCreditPageUI {
  public static final String TRAVEL_CREDITS_TITLE ="//h1[contains(@class,'TravelCreditLandingPagePC_title')]";
  public static final String BUY_TRAVEL_CREDITS_BTN="//a[contains(@class,'btnBuyCredit')]";
  public static final String TRAVEL_CREDITS_BANNER="//p[contains(@class,'bannerTitle')]";
  public static final String TRAVEL_CREDITS_BANNER_SUB="//p[contains(@class,'bannerSub')]";

  public static final String TRAVEL_CREDITS_SECTION_LIST="//div[contains(@class,'contentWrapper')]/section/h2";

  public static final String TRAVEL_CREDITS_SECTION_DYNAMIC="(//div[contains(@class,'contentWrapper')]/section/h2)[%s]";
  public static final String TRAVEL_CREDITS_SECTION_CONTENT="//section[contains(@class,'section')]/div/div/p";
  public static final String TRAVEL_CREDITS_SECTION_CONTENT_DYNAMIC="(//section[contains(@class,'section')]/div/div/p)[%s]";
  public static final String TRAVEL_CREDITS_FAQ_LIST="//section[contains(@class,'sectionFaq')]/ul/li/h3";
  public static final String TRAVEL_CREDITS_FAQ_DYNAMIC="(//section[contains(@class,'sectionFaq')]/ul/li/h3)[%s]";
  public static final String TRAVEL_CREDITS_FAQ_CONTENT_LIST="//section[contains(@class,'sectionFaq')]/ul/li/p";
  public static final String TRAVEL_CREDITS_FAQ_CONTENT_DYNAMIC="(//section[contains(@class,'sectionFaq')]/ul/li/p)[%s]";

    public static final String TRAVEL_CREDITS_CONTENT_SUB1="(//div[contains(@class,'contentWrapper')]/section/p)[1]";
    public static final String TRAVEL_CREDITS_CONTENT_SUB2="(//div[contains(@class,'contentWrapper')]/section/p)[2]";
  public static final String TRAVEL_CREDITS_TERM_CONTENT_LIST="//section[contains(@class,'sectionTerms')]/ul/li";
  public static final String TRAVEL_CREDITS_TERM_CONTENT_DYNAMIC="(//section[contains(@class,'sectionTerms')]/ul/li)[%s]";


}
