package interfaces.hotel.footer.travala;

public class AffiliateProgramPageUI {
  //==================BANNER=============================

  public static final String AFFILIATE_BANNER_TXT_HEADING = "//div[contains(@class,'hero-text')]//h1";
  public static final String AFFILIATE_BANNER_TXT_SUB_HEADING1 = "//div[contains(@class,'hero-text')]//p[1]";
  public static final String AFFILIATE_BANNER_TXT_SUB_HEADING2 = "//div[contains(@class,'hero-text')]//p[2]";
  public static final String AFFILIATE_SIGN_UP = "//a[contains(@class,'sign-up')]";
  //==================PART 1=============================
  public static final String AFFILIATE_WHAT_IS_AFFILIATE_TITLE_TXT = "//div[@class='flex-1']/h3";
  public static final String AFFILIATE_WHAT_IS_AFFILIATE_CONTENT_TXT = "//div[@class='flex-1']/p[1]";
  public static final String AFFILIATE_WHAT_IS_AFFILIATE_CONTENT_TXT_DYNAMIC = "(//div[@class='flex-1']/p)[%s]";

  public static final String AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_HEADING_TXT = "//div[@id='advantages']//h3";
  public static final String AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_TXT_LIST = "//div[@id='advantages']//div[@class='block']//h4";
  public static final String AFFILIATE_WHY_JOIN_AFFILIATE_TITLE_TXT_DYNAMIC = "(//div[@id='advantages']//div[@class='block']//h4)[%s]";
  public static final String AFFILIATE_WHY_JOIN_AFFILIATE_CONTENT_TXT_LIST = "//div[@id='advantages']//div[@class='block']//p";
  public static final String AFFILIATE_WHY_JOIN_AFFILIATE_CONTENT_TXT_DYNAMIC = "(//div[@id='advantages']//div[@class='block']//p)[%s]";


  public static final String AFFILIATE_HOW_DO_IT_WORK_HEADING = "//div[@id='how-to']//h3";
  public static final String AFFILIATE_HOW_DO_IT_WORK_TITLE_TXT_LIST = "//div[@id='how-to']//div[@class='block']//h4";
  public static final String AFFILIATE_HOW_DO_IT_WORK_TITLE_TXT_DYNAMIC = "(//div[@id='how-to']//div[@class='block']//h4)[%s]";
  public static final String AFFILIATE_HOW_DO_IT_WORK_CONTENT_TXT_LIST = "//div[@id='how-to']//div[@class='block']//p";
  public static final String AFFILIATE_HOW_DO_IT_WORK_CONTENT_TXT_LIST_DYNAMIC = "(//div[@id='how-to']//div[@class='block']//p)[%s]";

  public static final String AFFILIATE_COMMISSIONS_HEADING = "//div[@id='commissions']//h3";
  public static final String AFFILIATE_COMMISSIONS_CONTENT_TXT_1 = "(//div[@id='commissions']//div[@class='content']/*[not(self::div)])[1]";
  public static final String AFFILIATE_COMMISSIONS_PARTNER_LEVEL = "//div[@id='commissions']//div[@class='table']/div[1]";
  public static final String AFFILIATE_COMMISSIONS_COMMISSIONS_PERCENT = "//div[@id='commissions']//div[@class='table']/div[2]";
  public static final String AFFILIATE_COMMISSIONS_GOLD_LEVEL = "//div[@id='commissions']//div[@class='table values']//div[1]";
  public static final String AFFILIATE_COMMISSIONS_CONTENT_TXT_2 = "(//div[@id='commissions']//div[@class='content']/*[not(self::div)])[2]";


  public static final String AFFILIATE_FAQS_HEADING = "//div[@id='faqs-block']//h3";
  public static final String AFFILIATE_FAQS_TITLE_TXT_LIST = "//div[@id='faqs-block']//li/b";
  public static final String AFFILIATE_FAQS_TITLE_TXT_DYNAMIC = "(//div[@id='faqs-block']//li/b)[%s]";
  public static final String AFFILIATE_FAQS_CONTENT_TXT_LIST = "//div[@id='faqs-block']//li/p";
  public static final String AFFILIATE_FAQS_CONTENT_TXT_DYNAMIC = "(//div[@id='faqs-block']//li/p)[%s]";


}
