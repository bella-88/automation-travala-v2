package commons;

import static commons.CommonTravalaPages.getEvn;

public class CommonTravalaURL {

  public CommonTravalaURL() {
  }

  //================================PATH OF URL PAGE==================================

  public static final String LOGIN_PATH = "/login";
  public static final String BOOKING_SUMMARY_PATH = "/booking-summary";
  public static final String NFT_TERM_PATH = "nft-terms";
  public static final String MALDIVES_PATH = "maldives-giveaway-terms-and-conditions";

  public static final String BUY_NFT = "collection/travel-tiger-club-travala";
  //================================URL PAGE==================================
  public static final String YOP_MAIL_URL = "https://yopmail.com/";
  public static final String TRAVALA_LIVE_URL = getEvn();
  public static final String TRAVALA_LOGIN_URL = getEvn() + LOGIN_PATH;
  //WALLET URL LANDING PAGE
  public static final String MATH_WALLET_URL = "https://mathwallet.org/en-us/";
  public static final String COIN_GECKO_URL = "https://www.coingecko.com/vi";
  public static final String COIN_MARKET_URL = "https://coinmarketcap.com/";
}
