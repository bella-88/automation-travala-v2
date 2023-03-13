
Feature: SMOKE Test Travala Site
#//=====================VERIFY LANDING PAGE================================================
  @CheckOut1
  Scenario:Login to system Travala by Email
    When I login to system by travala email

  @CheckOut1
  Scenario Outline: Verify payment by CRYPTO Success when Login
    And I input destination and link to checkout page
    And I input information for Reservation
    And I verify payment by "<coin>" by Now Payment
    Examples:
      | coin          |
#      | AVA           |
      | BTC           |
      | ETH           |
      | USDT          |
      | USDC          |
      | BNB           |
      | XRP           |
      | BUSD          |
      | SOL           |
      | ADA           |
      | DOGE          |
      | DOT           |
      | TRX           |
      | DAI           |
      | SHIB          |
      | LTC           |
      | NEAR          |
      | FTT           |
      | BCH           |
      | LINK          |
      | XLM           |
      | XMR           |
      | VET           |
      | EGLD          |
      | HBAR          |
      | FIL           |
      | XTZ           |
      | MANA          |
      | EOS           |
      | TUSD          |
      | CAKE          |
      | USDP          |
      | WAVES         |
      | BAT           |
      | FTM           |
      | ZIL           |
      | DASH          |
      | CHZ           |
      | XDC           |
      | ONE           |
      | GALA          |
      | XEM           |
      | QTUM          |
      | GT            |
      | GUSD          |
      | IOTX          |
      | ILV           |
      | SXP           |
      | VLX           |
      | DGB           |
      | NANO          |
      | MX            |
      | DAO           |
      | OCEAN         |
      | XYO           |
      | FUN           |
      | CHR           |
      | CTSI          |
      | SUPER         |
      | KLV           |
      | STPT          |
      | STRAX         |
      | XVG           |
      | ARK           |
      | BIFI          |
      | ARPA          |
      | SFUND         |
      | TKO           |
      | GRS           |
      | KMD           |
      | OM |
      | FIRO          |
      | FRONT         |
      | NWC           |
      | BEL           |
      | LGCY          |
      | POOLZ         |
      | NFTB          |
      | VIB           |
      | XCUR          |
      | KISHU         |
      | NTVRK         |
      | TRVL          |
  Scenario Outline: Verify LANGUAGE displayed on landing page
    Then I verify text of search bar on the landing page
    And I verify text on title of Customer Review Choose You and Discover
    And I verify text at destination when move mouse to destination
    And I verify display item on the footer part
    When I click on any destination on the landing page and verify navigate that page
    And I click any country and verify text of country page
    And I click on Search button to link Property page
    And I back to travala site
    Examples:
      | destination | day | PropertyTxt                      |
      | ho chi minh | 1   | Muong Thanh Luxury Da Nang Hotel |

#  //=====================VERIFY SEARCH PAGE================================================

  Scenario Outline: Verify SEARCH AT SEARCH PAGE when no choose date and room
    When I input location into Textbox Search "<SearchTxt>" and no choose anything
    And I click on Search button and verify search result page
    And I input "<destination>" into textbox Search on search result page
    And I click on Search button and verify search result page
    And I click to first property at search result
    Examples:
      | SearchTxt | destination |
      | CHONGQING | SHENZHEN    |

  Scenario Outline: Verify search result when search Location at COUNTRY PAGE
    And I input country to textbox Search "<country>" and verify navigate country page
    And I verify text on the "<country>" country page
    When I input location into Textbox Search "<destination>" and choose full option "<day>"
    And I click on Search button and verify search result page
    And I click to first property at search result
    Examples:
      | country   | destination | day |
      | China     | xiem riep   | 1   |

#  //=====================VERIFY BOOKING HOTEL================================================

  Scenario: Login to system
    When I login to system by travala email

  Scenario Outline: Verify payment by CRYPTO
    When I input "<PropertyTxt>" and navigate to checkout page
    And I input information for Reservation
    And I verify popup crypto when payment by "<coin>" and information at booking summary
    Examples:
      | PropertyTxt                     | coin |
      | Aira Boutique Hanoi Hotel & Spa | DOT  |

  Scenario Outline: Verify payment by MY WALLET when don't have enough Balance
    When I input "<PropertyTxt>" and navigate to checkout page
    And I input information for Reservation
    Then I verify info at checkout page and popup when dont have enough "<coin>" to payment
    Examples:
      | PropertyTxt                     | coin |
      | Aira Boutique Hanoi Hotel & Spa | AVA  |

  Scenario Outline: Verify payment by TRAVEL CREDIT when don't have enough Balance
    When I input "<PropertyTxt>" and navigate to checkout page
    And I input information for Reservation
    Then I verify info at checkout page when dont have Travel Credit to payment
    Examples:
      | PropertyTxt                     |
      | Aira Boutique Hanoi Hotel & Spa |

  Scenario Outline: Verify payment by MY WALLET Success when enough Balance
    When I login to system by travala email
    When I input "<PropertyTxt>" and navigate to checkout page
    And I input information for Reservation
    Then I verify info at checkout page and popup when payment by "<coin>" Wallet
    And I verify info at booking summary page when payment by Wallet
    Examples:
      | PropertyTxt                     | coin |
      | Aira Boutique Hanoi Hotel & Spa | AVA  |

  Scenario Outline:  Verify booking Success when payment by Credit Card and Not Login
    When I input "<PropertyTxt>" and navigate to checkout page
    And I verify text at contact part in the checkout page when not login
    And I verify info at booking summary page when payment by Credit Card
    Examples:
      | PropertyTxt           |
      | Mercure Hanoi La Gare |
#

  Scenario Outline: Verify content when buy Gift Card by MY WALLET
    And I navigate to buy gift card page
    And I input amount Gift Cards "<amountGC>"
    And I verify buy gift card when payment by Crypto with "<coin>"
    And I navigate to buy gift card page
    And I input amount Gift Cards "<amountGC>"
    And I verify buy gift card when payment by My Wallet with "<coin>"
    Examples:
      | amountGC | coin |
      | 68       | AVA  |
  @smokeTest
  Scenario: Verify navigate when click on Link of the page at the Footer
    When I click on any link at Travala column and verify display on that page
    And I click on any link at Support column and verify display on that page
    And I click on any link at Useful column and verify display on that page
    And I click on any link at Resources column and verify display on that page
    And I click on any link at Community column and verify display on that page

#  //=====================NEW UPDATED FROM 1 DEC 2022================================================
  #  //=====================VERIFY HOME PAGE================================================
#  @Smoke-Test
  Scenario: Smoke test for Home Page
    And Verify text in the Home page
#    And Verify displayed when click on 4 option bellow search bar
    And Verify displayed when click on TOP COUNTRY at the landing page
    And Verify navigate when click on any destination
    And Verify display list coin when click on payment options

  @Smoke-Test
  Scenario Outline: Verify result search when search by destination in result page
    And I use api to get list hotel expect with "<destination_name>"
    And At home page, i search hotel with "<destination_name>" and verify list hotel in search result page
#    And Check display when sort by property "<property_sort>"
    Examples:
      | destination_name  | start_date   | end_date  | room     | property_sort          |
#      | Ha noi            | default      | default   | default  | Property Rank          |
#      | Bangkok           | default      | default   | default  | Rating (Highest first) |
#      | Paris             | default      | default   | default  | Rating (Lowest first)  |
#      | London            | default      | default   | default  | Price (High to low)    |
      | Bali              | default      | default   | default  | Price (Low to high)    |
      | Tunis             | default      | default   | default  | Distance from downtown |
      | Roma              | default      | default   | default  | Top Rated              |



#  @Smoke-Test
  Scenario Outline: Check when by Property from Search textbox
    And I use api to get list property expect with "<content_text>"
    And At home page, i search hotel with "<content_text>" and verify list property suggestion
    Examples:
      | content_text      |
      | Ha noi            |