package interfaces.hotel;

public class CountryPageUI {
 public static final String COUNTRY_BANNER_TEXT1 = "//div[contains(@class,'CountryPagePC_topBannerTitle')]/h1";
 public static final String COUNTRY_BANNER_TEXT2 = "///div[contains(@class,'CountryPagePC_topBannerTitle')]/h2";
 public static final String COUNTRY_BENEFIT_ITEM_LIST = "//div[contains(@class,'benefitItem')]/h4";
 public static final String COUNTRY_BENEFIT_ITEM_DYNAMIC = "(//div[contains(@class,'benefitItem')]/h4)[%s]";
 public static final String COUNTRY_BENEFIT_CONTENT_LIST = "//div[contains(@class,'benefitItem')]/p";
 public static final String COUNTRY_BENEFIT_CONTENT_DYNAMIC = "(//div[contains(@class,'benefitItem')]/p)[%s]";
 public static final String ADULT_HOLDER = "//div[@class='TvlSearchBoxPC_block___149G8 ']/span";
 public static final String SEARCH_BUTTON = "//button[@class='TvlSearchBoxPC_searchBtn___3McoI']";

 public static final String INFORMATION_COUNTRY = "(//h3[contains(@class,'sectionTitle')])[1]";
 public static final String INFORMATION_ITEM_LIST = "(//h3[contains(@class,'sectionTitle')])[1]/following-sibling::div/strong";
 public static final String INFORMATION_ITEM_DYNAMIC = "((//h3[contains(@class,'sectionTitle')])[1]/following-sibling::div/strong)[%s]";
 public static final String DESTINATION_COUNTRY = "(//div[contains(@class,'listDestination')])/preceding-sibling::h3";
 public static final String DESTINATION_COUNTRY_LIST = "//div[contains(@class,'label')]/div";
 public static final String DESTINATION_COUNTRY_DYNAMIC = "(//div[contains(@class,'label')]/div)[%s]";
 public static final String SUGGESTION_COUNTRY = "(//section[contains(@class,'hotelSuggestions')])/div/h3";
 public static final String SUGGESTION_COUNTRY_LIST = "(//div[contains(@class,'listHotels')])/ul/li";
 public static final String SUGGESTION_COUNTRY_DYNAMIC = "((//div[contains(@class,'listHotels')])/ul/li)[%s]";
 public static final String BOOK_COUNTRY = "(//section[contains(@class,'bookedHotels')])/div/h3";
 public static final String DISCOVER_COUNTRY = "(//section[contains(@class,'discoverRegions')])/div/h3";
 public static final String COUNTRY_TITLE = "//section[contains(@class,'CountryPagePC_topBanner')]/div/h1";
  public static final String INFOR_COUNTRY = "//div[@class='CountryPagePC_info___1jz0b']/h3";

  public static final String COUNTRY_PAGE_PART_TITLE = "(//h3[@class='CountryPagePC_sectionTitle___33ErS'])";
 public static final String COUNTRY_PAGE_PART_TITLE_DYNAMIC = "(//h3[@class='CountryPagePC_sectionTitle___33ErS'])[%s]";

}

