
package configs;

  import java.util.Locale;
  import java.util.PropertyResourceBundle;
  import java.util.ResourceBundle;

public class ReaderConfigLanguage {
  private static String language = ConfigResourceBundle.getInstance().getProperty("locale.language");
  private static String country = ConfigResourceBundle.getInstance().getProperty("locale.country");
  private static ResourceBundle resourceBundle = null;
  private static Locale locale = null;

  public static String getStringLanguage(String code) {
    locale = new Locale(language, country);
    resourceBundle = PropertyResourceBundle.getBundle("languageTest", locale);
    String mesage = resourceBundle.getString(code).trim();
    return mesage;
  }
}