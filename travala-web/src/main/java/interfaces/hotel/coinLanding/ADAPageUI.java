package interfaces.hotel.coinLanding;

public class ADAPageUI {
  public static final String ADA_WHAT_IS_TITLE = "//div[contains(@id,'block-what')]/h2";
  public static final String ADA_BANNER_TITLE1 = "//div[contains(@class,'bannerContent')]/h1";
  public static final String ADA_BANNER_TITLE2 = "//div[contains(@class,'bannerContent')]/p";
  public static final String ADA_FAQ_CONTENT_LINK = "//div[contains(@id,'block-faqs')]/div/p/a";
  public static final String ADA_FAQ_CONTENT_LINK_DYNAMIC = "(//div[contains(@id,'block-faqs')]/div/p/a)[%s]";
}
