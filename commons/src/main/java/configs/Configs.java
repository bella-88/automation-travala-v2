package configs;

//import com.typesafe.config.Config;
//import com.typesafe.config.ConfigFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.*;
//import java.util.concurrent.atomic.AtomicReference;
//

public class Configs {
//  private static final Logger log = LoggerFactory.getLogger(Configs.class);
//  private static final Config systemProperties = ConfigFactory.systemProperties();
//  private static final Config systemEnvironment = ConfigFactory.systemEnvironment();
//  private static final AtomicReference<Config> propertiesRef = new AtomicReference<>(null);

  private Configs() {
  }

//  public static Config properties() {
//    return propertiesRef.get();
//  }
//
//  public static Config systemProperties() {
//    return systemProperties;
//  }
//
//  public static Config systemEnvironment() {
//    return systemEnvironment;
//  }
//
//  public static Builder newBuilder() {
//    return new Builder();
//  }
//
//  public static class Builder {
//    private Config conf = ConfigFactory.empty();
//    public Builder withResource(String resource) {
//      Config resourceConfig = ConfigFactory.parseResources(resource);
//      String empty = resourceConfig.entrySet().size() == 0 ? " contains no values" : "";
//      conf = conf.withFallback(resourceConfig);
//      log.info("Loaded config file from resource ({}){}", resource, empty);
//      return this;
//    }
//    public Config build() {
//      // Resolve substitutions.
//      conf = conf.resolve();
//      if (log.isDebugEnabled()) {
//        log.debug("Logging properties. Make sure sensitive data such as passwords or secrets are not logged!");
//        log.debug(conf.root().render());
//      }
//      return conf;
//    }
//  }

}
