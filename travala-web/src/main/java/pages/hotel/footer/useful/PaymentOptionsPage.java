package pages.hotel.footer.useful;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.coinLanding.*;
import pages.hotel.footer.travala.AvaTokenPage;

import java.util.List;

import static commons.CommonHotelURL.*;
import static commons.CommonHotelXpath.*;
import static interfaces.hotel.footer.useful.PaymentOptionsPageUI.*;


public class PaymentOptionsPage extends CommonHotelPages {
  WebDriver driver;
  boolean status = true;

  public PaymentOptionsPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public boolean verifyTextOnThisPage() {
    wait1sTime();
    String[] content = {"FOOTER_PAGE_PAYMENT_OPTION", "PAYMENT_OPTIONS_TITLE", "PAYMENT_OPTIONS_SUB"};
    String[] xpath = {LINK_STATIC_PAGE, PAYMENT_OPTIONS_TITLE, PAYMENT_OPTIONS_SUB_TITLE};
    status = verifyTwoListByKey(content, xpath) && verifyUrlPage(PAYMENT_OPTIONS_PATH);
    if (!status) {
      System.out.println("Text at payment option wrong! ");
    }
    return status;
  }

  public void clickToCoinAtPayment(String listXpath) {
    int count = 0;
    List<WebElement> elements = driver.findElements(By.xpath(listXpath));
    for (int i = 1; i < elements.size() + 1; i++) {
      String xpath = String.format(LIST_TOKEN, i);
      clickToElementByJavascript(driver, xpath);
      wait1sTime();
      if (StringUtils.contains(getCurrentUrl(driver), "payment")) {
        count = count + 1;
      }
      switchToWindowByUrlContainsString(driver, "payment");
      switchTab(driver);
    }
    System.out.println("There are " + count + " pages is displayed! ");
  }

  public void clickToCoinAtPaymentPage(String coin) {
    String xpath = String.format(LIST_COIN_PAYMENT, coin);
    scrollToElement(driver, xpath);
    clickToElementByJavascript(driver, xpath);
    switch (coin) {
      case "BCH":
        BCHPage bchPage = new BCHPage(driver);
        switchToWindowByUrlContainsString(driver, BCH_URL);
        bchPage.verifyTextOnBCHPage(coin);
        switchTab(driver);
        break;
      case "BIFI":
        BiFiPage biFiPage = new BiFiPage(driver);
        switchToWindowByUrlContainsString(driver, BIFI_URL);
        wait100Time();
        biFiPage.verifyTextOnBifiPage(coin);
        switchTab(driver);
        break;
      case "1INCH":
        InchPage inchPage = new InchPage(driver);
        switchToWindowByUrlContainsString(driver, BIFI_URL);
        wait100Time();
        inchPage.verifyTextOnInchPage(coin);
        switchTab(driver);
        break;
      case "POOLZ":
        POOLZPage poolzPage = new POOLZPage(driver);
        switchToOtherWindowbyUrl(driver, POOLZ_URL);
        wait100Time();
        poolzPage.verifyTextOnPoolzPage(coin);
        switchTab(driver);
        break;
      case "NTVRK":
        NTVRKPage ntvrkPage = new NTVRKPage(driver);
        switchToOtherWindowbyUrl(driver, NTVRK_URL);
        wait100Time();
        ntvrkPage.verifyTextOnNTVRKPage(coin);
        switchTab(driver);
        break;
      case "ILV":
        ILVPage ilvPage = new ILVPage(driver);
        switchToOtherWindowbyUrl(driver, ILV_URL);
        wait100Time();
        ilvPage.verifyTextOnILVPage(coin);
        switchTab(driver);
        break;
      case "SFUND":
        SFundPage sFundPage = new SFundPage(driver);
        switchToOtherWindowbyUrl(driver, SFUND_URL);
        wait100Time();
        sFundPage.verifyTextOnSFundPage(coin);
        switchTab(driver);
        break;
      case "XNO":
        NANOPage nanoPage = new NANOPage(driver);
        switchToOtherWindowbyUrl(driver, NANO_URL);
        wait100Time();
        nanoPage.verifyTextOnNanoPage(coin);
        switchTab(driver);
        break;
      case "XDC":
        XDCPage xdcPage = new XDCPage(driver);
        switchToOtherWindowbyUrl(driver, XDC_URL);
        wait100Time();
        xdcPage.verifyTextOnXDCPage(coin);
        switchTab(driver);
        break;
      case "USDT (Erc20)":
        USDTPage usdtPage = new USDTPage(driver);
        switchToOtherWindowbyUrl(driver, USDT_ERC_URL);
        wait100Time();
        usdtPage.verifyTextOnUsdtPage("USDT (Erc20)");
        switchTab(driver);
        break;
      case "AVA":
        AvaTokenPage avaTokenPage = new AvaTokenPage(driver);
        switchToOtherWindowbyUrl(driver, AVA_TOKEN_URL);
        wait100Time();
        avaTokenPage.verifyAVATokenPage("AVA");
        switchTab(driver);
        break;
      case "BTC":
        BTCPage btcPage = new BTCPage(driver);
        switchToOtherWindowbyUrl(driver, BTC_URL);
        wait100Time();
        switchTab(driver);
        break;
      case "LINK":
        LinkPage linkPage = new LinkPage(driver);
        switchToOtherWindowbyUrl(driver, LINK_URL);
        linkPage.verifyTextOnLinkPage(coin);
        switchTab(driver);
        break;
      case "FIL":
        FilPage filPage = new FilPage(driver);
        switchToOtherWindowbyUrl(driver, FIL_URL);
        switchTab(driver);
        break;
      case "DOT":
        DotPage dotPage = new DotPage(driver);
        switchToOtherWindowbyUrl(driver, DOT_URL);
        wait100Time();
        dotPage.verifyTextOnDotPage("DOT");
        switchTab(driver);
        break;
      case "ADA":
        ADAPage adaPage = new ADAPage(driver);
        switchToOtherWindowbyUrl(driver, ADA_URL);
        wait100Time();
        adaPage.verifyTextOnADAPage("ADA");
        switchTab(driver);
        break;
      case "XRP":
        XRPPage xrpPage = new XRPPage(driver);
        switchToOtherWindowbyUrl(driver, XRP_URL);
        wait100Time();
        xrpPage.verifyTextOnXRPPage(coin);
        switchTab(driver);
        break;
      case "NEAR":
        NearPage nearPage = new NearPage(driver);
        switchToOtherWindowbyUrl(driver, NEAR_URL);
        wait100Time();
        nearPage.verifyTextOnNearPage(coin);
        switchTab(driver);
        break;
      case "MX":
        MXPage mxPage = new MXPage(driver);
        switchToOtherWindowbyUrl(driver, MX_URL);
        wait100Time();
        mxPage.verifyTextOnMXPage(coin);
        switchTab(driver);
        break;
      case "HBAR":
        HBARPage hbarPage = new HBARPage(driver);
        switchToOtherWindowbyUrl(driver, HBAR_URL);
        wait100Time();
        hbarPage.verifyTextOnHBARPage(coin);
        switchTab(driver);
        break;
      case "GAL":
        GALPage galPage = new GALPage(driver);
        switchToOtherWindowbyUrl(driver, GAL_URL);
        wait100Time();
        galPage.verifyTextOnGALPage(coin);
        switchTab(driver);
        break;
      case "USDD":
        USDDPage usddPage = new USDDPage(driver);
        switchToOtherWindowbyUrl(driver, USDD_URL);
        wait100Time();
        usddPage.verifyTextOnUSDDPage(coin);
        switchTab(driver);
        break;
      case "FRONT":
        FRONTPage frontPage = new FRONTPage(driver);
        switchToOtherWindowbyUrl(driver, FRONT_URL);
        wait100Time();
        frontPage.verifyTextOnFRONTPage(coin);
        switchTab(driver);
        break;
      case "CHR":
        CHRPage chrPage = new CHRPage(driver);
        switchToOtherWindowbyUrl(driver, CHR_URL);
        wait100Time();
        chrPage.verifyTextOnCHRPage(coin);
        switchTab(driver);
        break;
      case "XLM":
        XLMPage xlmPage = new XLMPage(driver);
        switchToOtherWindowbyUrl(driver, XLM_URL);
        wait100Time();
        xlmPage.verifyTextOnXLMPage(coin);
        switchTab(driver);
        break;
      case "XYO":
        XYOPage xyoPage = new XYOPage(driver);
        switchToOtherWindowbyUrl(driver, XYO_URL);
        wait100Time();
        xyoPage.verifyTextOnXYOPage(coin);
        switchTab(driver);
        break;
      case "NFTB":
        NFTBPage nftbPage = new NFTBPage(driver);
        switchToOtherWindowbyUrl(driver, NFTB_URL);
        wait100Time();
        nftbPage.verifyTextOnNFTBPage(coin);
        switchTab(driver);
        break;
      case "XCUR":
        XCURPage xcurPage = new XCURPage(driver);
        switchToOtherWindowbyUrl(driver, XCUR_URL);
        wait100Time();
        xcurPage.verifyTextOnXCURPage(coin);
        switchTab(driver);
        break;
      case "STRAX":
        STRAXPage straxPage = new STRAXPage(driver);
        switchToOtherWindowbyUrl(driver, STRAX_URL);
        wait100Time();
        straxPage.verifyTextOnSTRAXPage(coin);
        switchTab(driver);
        break;
      case "DAI":
        DAIPage daiPage = new DAIPage(driver);
        switchToOtherWindowbyUrl(driver, DAI_URL);
        wait100Time();
        daiPage.verifyTextOnDAIPage(coin);
        switchTab(driver);
        break;
      case "TUSD":
        TUSDPage tusdPage = new TUSDPage(driver);
        switchToOtherWindowbyUrl(driver, TUSD_URL);
        wait100Time();
        tusdPage.verifyTextOnTUSDPage(coin);
        switchTab(driver);
        break;
      case "OM":
        OMPage omPage = new OMPage(driver);
        switchToOtherWindowbyUrl(driver, OM_URL);
        wait100Time();
        omPage.verifyTextOnOMPage(coin);
        switchTab(driver);
        break;
      case "JASMY":
        JASMYPage jasmyPage = new JASMYPage(driver);
        switchToOtherWindowbyUrl(driver, JASMY_URL);
        wait100Time();
        jasmyPage.verifyTextOnJASMYPage(coin);
        switchTab(driver);
        break;
      default:
        System.out.println("Please select another Coin ");
        new Object();
        break;
    }
  }

}

