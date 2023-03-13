Feature: Verify display on PAYMENT page
  @payment
  Scenario Outline: Check display LANDING PAGE of COIN
    When I click on payment options button and verify list token with "<coin>" on that page
    And I click on "<coin>" link and verify text on this page
    Examples:
      | coin |
#      | 1INCH |
#      | BIFI |
#      | BCH |
#      | POOLZ |
#      | NTVRK |
#      | ILV |
#      | SFUND |
#      | XNO |
#      | XDC |
#      | XRP |
#      | NEAR |
#      | DOT |
#      | LINK |
#      | MX |
#      | HBAR |
#      | GAL  |
#      | USDD |
#      | FRONT |
#      | CHR   |
#      |  XLM   |
#      |  XYO   |
#      |  NFTB  |
#      |  XCUR  |
#      |  STRAX  |
#      | DAI  |
#      | TUSD |
      | OM |
      | JASMY |

  Scenario: Login to system Travala
    When I login to system by travala email

  Scenario Outline: Verify display a COIN (TTC-41) at payment method when add new COIN
    When I get rate of "<coin>" on the market cap page
    And I verify display currencies, search and rate of "<coin>" list at header part
#    And I verify display list crypto at checkout page and booking hotel by "<coin>"
#    And I verify display "<coin>" and list crypto and AVA at travel credit
#    And I verify display "<coin>" and list crypto and AVA at buy gift card
#    When I click on payment options button and verify list token with "<coin>" on that page
    Examples:
      | coin  |
      | adfsdf   |
#      | 1INCH   |
#      | FTT  |
#      | POOLZ |


  Scenario Outline: Verify display when a COIN (TTC-41) at payment method when add new COIN
    When I click on payment options button and verify list token with "<coin>" on that page
    And I verify display "<coin>" and list crypto and AVA at buy gift card
    When I get rate of "<coin>" on the market cap page
    And I verify display "<coin>" and AVA always in the first place on Currency Header
#    When I login to system by travala email
#    And I verify display currencies, search and rate of "<coin>" list at header part
#    And I verify display list crypto at checkout page and booking hotel by "<coin>"
#    And I verify display "<coin>" and list crypto and AVA at travel credit
    Examples:
      | coin  |
#      | UST  |
#      | FTT  |
      | POOLZ |