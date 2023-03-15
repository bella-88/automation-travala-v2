package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/features/hotel",
  format = {"json:target/cucumber.json", "html:target"},
  glue = "stepDefinitions",
  monochrome = true,
  plugin = {"pretty:target/cucumber-report/report.html", "json:target/cucumber-report.json"},
  snippets = SnippetType.CAMELCASE,
//  tags = {"    @Vote"}
//  tags = {"    @BuyTravelCredit, @BuyGifGCard"}
//  tags = {"      @nft"}
  tags = {"      @Concierge"}
//  tags = {" @BuyGifGCard"}
//  tags = {"     @TRAVO-15371"}
//  tags = {"@TRAVO-15348"}
//  tags = {"     @CheckOut"}
//  tags = {"      @Property"}
//  tags = {"@footer"}
//  tags = {"@payment"}
//  tags = {"@BuyTravelCredit"}
//  tags = {"      @Search"}
//  tags = {"@landing"}
//  tags = {"          @nft, @Footer, @BuyGifGCard,  @BuyTravelCredit"}
//  tags = {"         , @footer, , @BuyTravelCredit"}
//  tags = {"               @CheckOut1"}
//        tags = {"@TRAVO-15909"}
//  tags = {"@TRAVA-15836"}
//  tags = {"@TRAVO-16083"}
//tags = {"@Smoke-Test"}
)

public class TestRunner {
}
