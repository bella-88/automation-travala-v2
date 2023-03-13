package interfaces.hotel.footer.support;

public class MediaPageUI {
  public static final String MEDIA_TITLE="//div[contains(@class,'bannerContent')]/h1";
  public static final String MEDIA_SUB_TITLE="//div[contains(@class,'bannerContent')]/p";
  public static final String MEDIA_GROWTH="//div[contains(@class,'ourGrowth')]/div/h3";
  public static final String MEDIA_GROWTH_CONTENT1 = "//div[contains(@class,'ourGrowth')]//p[1]";
  public static final String MEDIA_GROWTH_CONTENT2 = "//div[contains(@class,'ourGrowth')]//p[2]";
  public static final String MEDIA_AUDIENCE_TITLE="//div[contains(@class,'ourAudienceContent')]/h3";
  public static final String MEDIA_AUDIENCE_CONTENT1="(//div[contains(@class,'ourAudienceContent')]//p)[1]";
  public static final String MEDIA_AUDIENCE_CONTENT2="(//div[contains(@class,'ourAudienceContent')]//p)[2]";
  public static final String MEDIA_PERSONALITY="//div[contains(@class,'personality')]/h3";
  public static final String MEDIA_KIT="//div[contains(@class,'mediaKit')]/h3";
  public static final String MEDIA_KIT_LINK="//div[contains(@class,'mediaKit')]/a";
  public static final String MEDIA_WORLD_LIST="//div[contains(@class,'MediaContact_theWorld')]/div/h4";
  public static final String MEDIA_WORLD_DYNAMIC="(//div[contains(@class,'MediaContact_theWorld')]/div/h4)[%s]";

  public static final String MEDIA_WORLD_CONTENT_LIST="//div[contains(@class,'MediaContact_theWorld')]/div/p";
  public static final String MEDIA_WORLD_CONTENT_DYNAMIC="(//div[contains(@class,'MediaContact_theWorld')]/div/p)[%s]";
  public static final String MEDIA_QUOTE_CONTENT = "//div[contains(@class,'MediaContact_theWorld')]/div/h5";

  public static final String MEDIA_ABOUT_LIST="//div[contains(@class,'MediaContact_aboutUs')]/h3";
  public static final String MEDIA_ABOUT_DYNAMIC="(//div[contains(@class,'MediaContact_aboutUs')]/h3)[%s]";

  public static final String MEDIA_ABOUT_CONTENT_LIST="//div[contains(@class,'MediaContact_aboutUs')]/p";
  public static final String MEDIA_ABOUT_CONTENT_DYNAMIC="(//div[contains(@class,'MediaContact_aboutUs')]/p)[%s]";

  public static final String MEDIA_PERSON_CONTENT_LIST="//div[contains(@class,'personItem')]/p";
  public static final String MEDIA_PERSON_CONTENT_DYNAMIC="(//div[contains(@class,'personItem')]/p)[%s]";

  public static final String MEDIA_PERSON_FOLLOW_LIST="//div[contains(@class,'personItem')]/strong";
  public static final String MEDIA_PERSON_FOLLOW_DYNAMIC="(//div[contains(@class,'personItem')]/strong)[%s]";

  public static final String MEDIA_PERSONAL_TITLE_LIST="//div[contains(@class,'personalityItem')]/h5";
  public static final String MEDIA_PERSONAL_TITLE_DYNAMIC="(//div[contains(@class,'personalityItem')]/h5)[%s]";

  public static final String MEDIA_PERSONAL_CONTENT_LIST="//div[contains(@class,'personalityItem')]/p";
  public static final String MEDIA_PERSONAL_CONTENT_DYNAMIC="(//div[contains(@class,'personalityItem')]/p)[%s]";

  public static final String MEDIA_BOOK_OUR_LIST="//div[contains(@class,'personality')]/ul/li";
  public static final String MEDIA_BOOK_OUR_DYNAMIC="(//div[contains(@class,'personality')]/ul/li)[%s]";

  public static final String MEDIA_ITEM_TITLE_LIST="//div[contains(@class,'optionItem')]/h4";
  public static final String MEDIA_ITEM_TITLE_DYNAMIC="(//div[contains(@class,'optionItem')]/h4)[%s]";

  public static final String MEDIA_ITEM_CONTENT_LIST="//div[contains(@class,'optionItem')]/a/preceding-sibling::p";
  public static final String MEDIA_ITEM_CONTENT_DYNAMIC="(//div[contains(@class,'optionItem')]/a/preceding-sibling::p)[%s]";
  public static final String MEDIA_OTHER_LINK_LIST="//div[contains(@class,'otherWay')]/div/a";
  public static final String MEDIA_OTHER_LINK_DYNAMIC="(//div[contains(@class,'otherWay')]/div/a)[%s]";
  public static final String MEDIA_BOOK_OUR_PERSONALITIES_TITLE = "//div[contains(@class,'MediaContact_personality__iF7Ul')]/h4";
  public static final String MEDIA_WANT_TO_WORK_TITLE = "//div[contains(@class,'question')]/h3";
  public static final String MEDIA_APPLY_BUTTON = "//div[contains(@class,'question')]/a";
  public static final String MEDIA_QUESTION_DETAIL_TITLE_LIST="//div[contains(@class,'questionDetails')]//h4 | //h3[contains(@class, 'titleOther')]";
  public static final String MEDIA_QUESTION_DETAIL_TITLE_DYNAMIC="(//div[contains(@class,'questionDetails')]//h4 | //h3[contains(@class, 'titleOther')])[%s]";
  public static final String MEDIA_QUESTION_DETAIL_CONTENT_LIST="//div[contains(@class,'questionDetails')]//ul/li";
  public static final String MEDIA_QUESTION_DETAIL_CONTENT_DYNAMIC="(//div[contains(@class,'questionDetails')]//ul/li)[%s]";
}
