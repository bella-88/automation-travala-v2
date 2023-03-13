package pages.hotel.NFT;

import commons.hotel.CommonHotelPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import static constants.hotel.contentNFT.ConstBuyNFT.*;
import static interfaces.hotel.NFT.MyNFTPageUI.*;


public class MyNFTPage extends CommonHotelPages {
  WebDriver driver;
  boolean status;
  boolean check = true;
  private MyNFTPage buyNFTPage;


  public MyNFTPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyListAmountNFT() {
    List<String> listExp = new ArrayList<>();
    int i = 1;
    while (i < 11) {
      String exp = String.format(CONST_AMOUNT_NFT, i).trim();
      if (StringUtils.contains(exp, "NFT")) {
        listExp.add(exp);
      }
      i++;
    }
    wait1sTime();
    List<String> act = getValueFromDropDown(driver, AMOUNT_NFT_DROPDOWN, AMOUNT_NFT_LIST_DYNAMIC);
    if (!verifyTwoList(act, listExp)) {
      System.out.println("List amount NFT wrong");
    } else {
      System.out.println("List amount NFT correct");
    }
  }

  public boolean verifyBalanceBuyNft(String coin) {
    boolean status = true;
    try {
      Double totalPrice = Double.valueOf(getTextElement(driver, NFT_TOTAL_PRICE).replace("US$", "").replace(",", ""));
      String st1 = getTextElement(driver, String.format(NFT_MY_WALLET_BALANCE, coin)).replaceAll("US\\$", "").replace(",", "").replaceAll("\\(", "").replaceAll("\\)", "");
      Double balanceWallet = (Double.valueOf(st1.trim()));
      if (balanceWallet < totalPrice) {
        System.out.println("You don't have enough " + coin + " to buy NFT");
        status = false;
      }
    } catch (NumberFormatException ex) { // handle your exception
      System.out.println("error format");
    }

    return status;
  }

  public void verifyBuyNftByWallet(String coin) {

//  selectDropDownByText(driver,AMOUNT_NFT_DROPDOWN,AMOUNT_NFT_LIST_DYNAMIC,"3 NFT" );
    clickToElementByJavascript(driver, NFT_MY_WALLET_BTN);
    clickElementByDynamicLocator(driver, NFT_MY_WALLET_COIN, coin);
    if (verifyBalanceBuyNft(coin)) {
      System.out.println("You can buy NFT");
      clickToElementByJavascript(driver, NFT_MINT_BTN);
    }
  }
}
