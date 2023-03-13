
Feature: Verify Function Buy Gift Card
  @BuyGifGCard
  Scenario Outline: Verify LANGUAGE displayed when input invalid textbox at Gift Card page
    And I navigate to buy gift card page
    And I verify text on Buy Gift Card page
    And I verify text on this page when input invalid amount Gift Card
    And I input invalid "<invalidEmail>" to contact and verify text displayed
    And I input invalid "<invalidEmail>" to Recipient and verify text displayed
    And I verify text at payment part in the buy gift card page
    Examples:
      | invalidEmail |
      | a            |

  Scenario: Verify displayed when buy GC and payment by Credit Card
    And I input valid information to buy GC
    And I verify buy gift card payment by Credit Card and verify content email


  Scenario: Verify displayed when buy GC to SEND AS GIFT and payment by Credit Card
    And I navigate to buy gift card page
    And I input valid information to buy GC
    And I input valid information Recipient person
    And I verify buy gift card to send as Gift payment by Credit Card and verify content email

  Scenario: Verify displayed when buy GC and payment by Crypto
    And I navigate to buy gift card page
    And I input valid information to buy GC
    And I verify buy gift card when payment by Crypto

  Scenario Outline: Verify displayed when buy GC to SEND AS GIFT and payment by Crypto <coin>
    And I navigate to buy gift card page
    And I input valid information to buy GC
    And I input valid information Recipient person
    And I verify buy gift card to send as Gift when payment by Crypto with "<coin>"
    Examples:
      | coin |
      | XRP  |


  Scenario: Login to system
    When I login to system by travala email

  Scenario: Verify displayed when buy GC and payment by My Wallet
    And I navigate to buy gift card page
    And I input valid information to buy GC
    And I verify buy gift card when payment by My Wallet
#  @BuyGifGCard
  Scenario Outline: Verify displayed when buy GC to SEND AS GIFT and payment by My Wallet
    And I navigate to buy gift card page
    And I input valid information to buy GC
    And I input valid information Recipient person
    And I verify buy gift card to send as Gift payment by My Wallet with "<coin>" and verify content email
    Examples:
      | coin |
      | BUSD |

  Scenario: Verify CONTENT at Term Gift Card Page
    And I click on Travel Gift Card Term link and verify displayed text on this page
