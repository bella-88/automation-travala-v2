package commons;

import configs.ConfigResourceBundle;

import java.util.Random;

public class CommonDataTravala {

//
//  public static final String ENVIRONMENT = "STG";
  public static final String ENVIRONMENT = "LIVE";
//  public static final String ENVIRONMENT = "NFT";
//  public static final String ENVIRONMENT = "SMART";
//  public static final String ENVIRONMENT = "HEROKU";
//  public static final String LANGUAGE = "fr";
  public static final String GET_LANGUAGE = ConfigResourceBundle.getInstance().getProperty("locale.country");
//  public static final String CONSTANT_LANGUAGE = Flag.valueOf(LANGUAGE).getFlg() + "-flag";
public static final int HIGHLIGHT_ELEMENT_TIMEOUT_FOR_DEMO = 100;
  public static final String MAILSAC_API_KEY = "k_3aZiFhh4gDmFxmzd3h8XNdQefPLnOPe08KyqFrSqLIcaw9873"; //Account mailsac: tien.infotech@gmail.com/trantien1993

  //===================================================ACCOUNT TEST=======================================================
  public static final String EMAIL_BUSINESS= "phucpi1694@gmail.com";
  public static final String PASSWORD_BUSINESS = "Time@123";
  public static final String EMAIL_TRAVALA_ACC = "travala09091988@gmail.com";
  public static final String EMAIL_BELLA_ACC = "bella01090913@gmail.com";
  public static final String PASSWORD_ACC = "travala2020";
  public static final String EMAIL_IRIS_ACC = "meirisnguyen@gmail.com";

  public static final String PASSWORD_IRIS_ACC = "12345678";
  public static final String EMAIL_TEST_ACC = "checksmartx@yopmail.com";
  public static final String PASSWORD_TEST_ACC = "12345678";
  public static final String EMAIL_TEST1_ACC = "checksmart1@yopmail.com";
  public static final String PASSWORD_TEST2_ACC = "Bella@1234";
  //===================================================INVALID PASSWORD=======================================================

  public static final String PASSWORD_ONLY_NUMBER = "12345678";
  public static final String PASSWORD_ONLY_UPPERCASE = "ABCDRQETYUIO";
  public static final String PASSWORD_ONLY_LOWERCASE = "advdadthgkuop";
  public static final String PASSWORD_ONLY_SPACE = "ABC    DRAbd   n@123";
  public static final String PASSWORD_ONLY_SPECIAL = "@#$%&*";
  public static final String PASSWORD_LENGTH_MIN = "abcB#34";
  public static final String PASSWORD_LENGTH_MAX = "aadhcg1234567vbbcBADET123DBHGKIOUYTRACLD#1234567TGHJIKLOP89034";
  //===================================================BUY GIFT CARD=======================================================
  public static final String FIRST_NAME = "bella";
  public static final String LAST_NAME = "vu";


  //===================================================PAYMENT BY WALLET=======================================================
  public static final String LABEL_COIN = "(%s)";
  public static final String WALLET_AVA = "AVA";
  public static final String WALLET_BNB = "BNB";
  public static final String WALLET_BUSD = "BUSD";
  public static final String INVALID_SEARCH_CURRENCY = "ADCAAAAAAAA";
  public static final int LONG_TIMEOUT = 30;
  public static final int LONG_TIMEOUT_ADJUST = 20;

  //=========================BOOKING STATUS==========================================
  public static final String BOOKING_STATUS_PROCESS = "Processing";
  public static final String BOOKING_STATUS_EXPIRED = "Expired";
  public static final String BOOKING_STATUS_CANCEL = "Cancelled";
  public static final String BOOKING_STATUS_FAILED = "Failed";
  public static final String[] listFiat ={"US Dollar USD - US$", "Pound Sterling GBP - £", "Euro EUR - €", "Australian Dollar AUD - AU$",
  "Singapore Dollar SGD - SG$", "Canadian Dollar CAD - CA$", "HK Dollar HKD - HK$", "New Zealand Dollar NZD - NZ$", "Chinese Yuan CNY - CNY", "Indian Rupee INR - ₹",
  "Vietnamese Dong VND - ₫", "UAE Dirham AED - د.إ", "Korean Won KRW - ₩"};

  public static final String[] CURRENCY_HEADER={ "Bitcoin BTC", "Ethereum ETH", "Tether USDT", "Binance Coin BNB", "USD Coin USDC", "1inch 1INCH",
    "Cardano ADA", "XRP XRP", "Dogecoin DOGE", "Pokadot DOT", "SHIB (Erc20) SHIB", "TerraUSD UST", "Binance USD BUSD", "DAI DAI", "Litecoin LTC", "Chainlink LINK",
    "NEAR Protocol NEAR", "TRON TRX", "Fantom FTM", "Bitcoin Cash BCH", "Stellar XLM", "Decentraland MANA", "VeChain VET", "Filecoin FIL", "Elrond EGLD", "Tezos XTZ",
    "Harmony ONE", "EOS EOS", "PancakeSwap CAKE", "TrueUSD TUSD", "Basic Attention Token BAT", "Chiliz CHZ", "Dash DASH", "Pax Dollar USDP", "Waves WAVES",
    "NEM XEM", "XDC Network XDC", "IoTeX IOTX", "Velas VLX", "QTUM QTUM", "Zilliqa ZIL", "GateToken GT", "OCEAN OCEAN", "Nano XNO", "DigiByte DGB", "Chromia CHR",
    "XYO XYO", "Gemini GUSD", "Swipe SXP", "Cartesi CTSI", "MX Token MX", "Verge XVG", "SuperFarm SUPER", "DAO Maker DAO", "Stratis STRAX", "FUNToken FUN", "ARK ARK",
    "Standard Tokenization Protocol STPT", "Klever KLV", "Toko Token TKO", "ARPA Chain ARPA", "Komodo KMD", "Travala AVA", "Firo FIRO", "Groestlcoin GRS", "Bella Protocol BEL",
    "LGCY Network LGCY", "MANTRA DAO OM", "Newscrypto Coin NWC", "Frontier FRONT", "Curate XCUR", "Viberate VIB", "Kishu Inu KISHU", "TRVL (Erc20) TRVL","NFTb NFTB",
  "Hedera HBAR","Illuvium ILV","Polkadot DOT","Shiba Inu SHIB","UNI UNI","NEO NEO","Kucoin Shares KCS","Zcoin XZC","Seedify.fund SFUND", "Tokocrypto TKO",
    "Floki Inu FLOKI","Netvrk NTVRK","Dtravel TRVL","Gala GALA", "Poolz Finance POOLZ","Solana SOL","FTX Token FTT","Beefy Finance BIFI"};

  public static final String[] CURRENCY_PAYMENT_LANDING = {"AVA", "CREDIT CARD", "Binance Pay", "Crypto.com Pay","XCAD","HOTCROSS",
    "Wechat Pay", "UTrust", "VnPay", "BTC", "BTC (Lightning)", "ETH", "USDT", "BNB", "USDC", "ADA", "XRP", "DOGE", "DOT", "SHIB (Erc20)", "UST", "BUSD", "DAI",
    "LTC", "LINK", "NEAR", "TRX", "FTM", "BCH", "XLM", "MANA", "VET", "FIL", "eGLD", "XMR", "XTZ", "ONE", "EOS", "PancakeSwap", "TUSD", "BAT", "CHZ", "DASH","GAL",
    "USDP", "WAVES", "XEM", "XDC", "IOTX", "VLX", "QTUM", "ZIL", "GT", "OCEAN", "XNO", "DGB", "CHR", "XYO", "GUSD", "Swipe Card", "CTSI", "MX", "XVG", "SUPER",
    "DAO", "STRAX", "FUN", "ARK", "STPT", "KLV", "TKO", "ARPA", "KMD", "FIRO", "GRS", "BEL", "LGCY", "OM", "NWC", "FRONT", "XCUR", "VIB", "KISHU","BIFI","1INCH",
    "TRVL (Erc20)","NFTB","HBAR","ILV","PAYPAL","WeChat Pay","Shiba Inu","SXP","NEO","XZC","Floki Inu","Dtravel" ,"GALA","SFUND","NTVRK","POOLZ","SOL","FTT","APE", "1INCH (Bep20)", "MX"};


  public static final String[] LIST_CRYPTO_PAYMENT = {"AVA Travala","BTC Bitcoin","ETH Ethereum","USDT Tether","BNB BNB","BIFI Beefy Finance"
    ,"USDC USD Coin","XRP XRP","ADA Cardano","BUSD Binance USD","DOT DOT","DOGE DogeCoin","UST TerraUSD","SHIB Shiba Inu","DAI DAI","LTC Litecoin"
    ,"NEAR NEAR","TRX TRON","LINK Chainlink","BCH Bitcoin Cash","XLM Stellar","MANA Decentraland","HBAR Hedera","EGLD eGLD","XMR Monero"
    ,"FIL Filecoin", "VET VeChain","WAVES Waves","FTM Fantom","XTZ Tezos","EOS EOS","CAKE PancakeSwap","GALA Gala","TUSD TrueUSD","ONE Harmony"
    ,"BAT Basic Attention Token","CHZ Chiliz","DASH Dash","USDP Pax Dollar","XEM NEM","XDC XDC Network","IOTX IoTeX","SXP Swipe","QTUM QTUM","ZIL Zil"
    ,"VLX Velas","GT GateToken","ILV Illuvium","GUSD GUSD","DGB DigiByte","OCEAN OCEAN","SUPER SuperFarm","NANO Nano","XYO XYO","CHR Chromia"
    ,"MX MX Token","XVG Verge","CTSI Cartesi","DAO DAO","STPT Standard Tokenization Protocol","STRAX Stratis","SFUND Seedify.fund","FUN FUNToken"
    ,"ARK ARK","ARPA ARPA Chain","KLV Klever","TKO Tokocrypto","KMD Komodo","FIRO Firo","GRS Groestlcoin","BEL Bella Protocol","FRONT FRONT"
    ,"OM MANTRA DAO","NWC Newscrypto Coin","LGCY LGCY","NFTB NFTb","XCUR Curate","VIB Viberate","NTVRK Netvrk","KISHU Kishu Inu","TRVL Dtravel"
    ,"POOLZ Poolz Finance","NEO NEO", "FLOKI Floki Inu", "NEAR NEAR Protocol","SOL Solana","FTT FTX Token", "1INCH 1inch", "APE ApeCoin", "SXP Solar", "GAL Project Galaxy"
    ,"XCAD XCAD Network", "USDD USDD", "HOTCROSS Hotcross"};



  public static final String[] PAYMENT_BOOKING_SUMMARY ={"AVA", "Credit card", "Binance Pay",
    "Crypto.com Pay", "Wechat Pay", "UTrust", "VnPay", "BTC", "ETH", "BNB", "USDT (Erc20)", "USDT (Trc20)", "ADA", "XRP", "DOT", "DOGE", "USDC", "LINK",
    "LTC", "BUSD (Erc20)", "BCH", "XLM", "VET", "FIL", "TRX", "FTM (Mainnet)", "FTM (Erc20)", "DAI", "eGLD", "XTZ", "MANA", "XMR", "EOS", "ONE", "UST",
    "WAVES", "CHZ", "BAT", "DASH", "XEM", "QTUM", "IOTX", "ZIL", "TUSD", "USDP", "DGB", "VLX", "OCEAN", "GT", "Swipe Card", "XVG", "CTSI", "STRAX",
    "ARK", "CHR", "SUPER", "TKO", "FUN", "STPT", "MX", "LGCY", "GUSD", "KLV", "KMD", "NWC", "FIRO", "DAO", "OM", "GRS", "FRONT", "XCUR", "VIB", "KISHU",
    "BUSD (Bep20)", "XNO","PAYPAL","WeChat Pay","BTC (Lightning)","Travel Credits","SXP","PancakeSwap","NEO","XZC","SHIB (Erc20)","TRVL (Erc20)",
    "Dtravel","Shiba Inu","Floki Inu","BTC (On-chain)"};


  //===================================================PAYMENT BY CREDIT CARD=======================================================
  public static final String VALID_CARD_NUMBER = "4242 4242 4242 4242";
  public static final String VALID_CVC = "123";
  public static final String VALID_EXP_DATE = "1230";
  public static final String INVALID_CARD_NUMBER = "1111 1221 2333 1211 ";
  public static final String INVALID_CVC = "123";
  public static final String INVALID_EXP_DATE = "1210";

  //===================================================SCRIPT GA=======================================================
  public static String ST = "  (function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':";
  public static String ST1 = "     new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],";
  public static String ST2 = "   j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=";
  public static String ST3 = "  'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);";
  public static String ST4 = "   })(window,document,'script','dataLayer','GTM-WLTWL87');";
  public static String ST5 = "    window.dataLayer = window.dataLayer || [];";
  public static String ST6 = "   function gtag(){dataLayer.push(arguments);}";
  public static String ST7 = "    gtag('js', new Date());";
  public static String ST8 = "  gtag('config', 'UA-125056991-2', {";
  public static String ST9 = "  transport_url: 'https://sgtm.travala.com'";
  //==================BODY=========================
  public static String  ST_BODY= "<noscript><iframe src=";
  public static String  ST_BODY1= "https://www.googletagmanager.com/ns.html?id=GTM-WLTWL87";
  public static String  ST_BODY2= "height=\"0\" width=\"0\" style=\"display:none;visibility:hidden\"></iframe></noscript>";

  public static int randomData() {
    Random rand = new Random();
    int number = rand.nextInt(100000) + 1;
    return number;
  }
}
