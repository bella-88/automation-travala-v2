package configs;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigResourceBundle {
  private static final String PROPERTIES_FILE = "/configLanguage.properties";
  private static Properties properties = new Properties();

  public static ConfigResourceBundle getInstance() {
    final ConfigResourceBundle configResourceBundle = new ConfigResourceBundle();
    configResourceBundle.loadProperties(configResourceBundle.getPropertiesFile());
    return configResourceBundle;
  }

  private InputStream getPropertiesFile() {
    return this.getClass().getResourceAsStream(PROPERTIES_FILE);
  }

  private void loadProperties(InputStream propertiesStream) {
    try {
      InputStreamReader isr = new InputStreamReader(propertiesStream, "UTF-8");
      properties.load(isr);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public String getProperty(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }

  public void setProperty(String key, String value) {
    properties.setProperty(key, value);
  }
  /* Cach cu k work
  public static final ConfigResourceBundle CONFIG_RESOURCE = getInstance(System.getProperty("language"));
  private final ResourceBundle resourceBundle;
  public ConfigResourceBundle(String language) {
    Locale locale;
    if ("vi".equals(language)) {
      locale = new Locale("vi", "VI");
    } else if ("us".equals(language)) {
      locale = Locale.ENGLISH;
    } else if ("cn".equals(language)) {
      locale = Locale.CHINA;
    } else {
      locale = Locale.US;
    }
    resourceBundle = ResourceBundle.getBundle("language", locale);
  }
  public static ConfigResourceBundle getInstance(String language) {
    return new ConfigResourceBundle(language);
  }
  public String getValue(String key) {
    return resourceBundle.getString(key);
  }
   */
}