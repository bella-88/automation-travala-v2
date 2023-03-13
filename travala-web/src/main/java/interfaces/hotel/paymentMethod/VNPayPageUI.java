package interfaces.hotel.paymentMethod;

public class VNPayPageUI {
  public static String language = System.getProperty("language");
  {
    System.out.println("language: " + language);
  }
  public static final String TITLE_TEXT = "(//div[@class='title']/h2)[position()=1]";
  public static final String PAYMENT_VIA_MOBILE = "(//div[@class='title-bottom']/h2)[position()=1]";
  public static final String PRICE_MOBILE = "//div[@class='price  text-center hidden_mobile']";



}
