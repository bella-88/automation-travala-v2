package interfaces.hotel.footer.travala;

public class SmartPageUI {

  public static final String INTRO_TITLE ="//div[contains(@class,'mainContent')]/h3";
  public static final String INTRO_SUB_TITLE ="//div[contains(@class,'mainContent')]/h4";
  public static final String INTRO_CONTENT="//div[contains(@class,'mainContent')]/p";
  public static final String INTRO_BENEFIT_TITLE ="//div[contains(@class,'listOptionItem')]/h3";
  public static final String INTRO_BENEFIT_CONTENT ="//div[contains(@class,'listOptionItem')]/p";
  
   public static final String FAQS_SMART_PROGRAM = "//div[contains(@class,'Smart_questions')]/h3";
  public static final String FAQS_SMART_PROGRAM_QUESTION_LIST = "//div[contains(@class,'Smart_questions')]/h4";
  public static final String FAQS_SMART_PROGRAM_QUESTION_DYNAMIC = "//div[contains(@class,'Smart_questions')]/h4[%s]";
  public static final String FAQS_SMART_ANSWERS_LIST = "//div[contains(@class,'Smart_questions')]/p";
  public static final String FAQS_SMART_ANSWERS_DYNAMIC = "//div[contains(@class,'Smart_questions')]/p[%s]";

  public static final String ACTIVE_BOOK_STAY = "//div[contains(@class,'Smart_smartProgramFooter')]/h3";
  public static final String SMART_PROGRAM_BTN = "//div[contains(@class,'Smart_smartProgramFooter')]/a[1]";
  public static final String JOIN_US_SUB = "//div[contains(@class,'Smart_smartProgramFooter')]/p";
  public static final String SMART_PROGRAM_TERM_LINK = "//a[@href='/smart-terms']";
  public static final String SMART_PROGRAM_HERE_LINK = "(//div[contains(@class,'Smart_questions')]/p)[1]/a";
  public static final String SMART_PROGRAM_MY_SMART_LINK ="(//div[contains(@class,'Smart_questions')]/p)[2]/a";
  public static final String SMART_PROGRAM_SMART_NOW_BTN ="//a[contains(@class,'Smart_linkSmart')]";
  public static final String SMART_INTRODUCTION_TAB ="//li[contains(@class,'active')]/span";




}
