package enumerable;

public enum  Env {
  LIVE("www.travala.com/"),
  CERT("cert.travala.com"),
  STG("staging2.gfzunbtj.com"),
  LANGUAGE("new-language.herokuapp.com"),
  HEROKU("travala-pr-564.herokuapp.com/"),
  HEROKU1("travala-pr-162.herokuapp.com/?AB_VARIATION_15371=2"),
  NFT("travala-pr-2153.herokuapp.com"),
  WHITELIST("travala-pr-1994.herokuapp.com"),
  SMART("");

  private final String env;

  Env(String name) {
    this.env = name;
  }

  public String getEnv() {

    return  this.env;
  }

}
