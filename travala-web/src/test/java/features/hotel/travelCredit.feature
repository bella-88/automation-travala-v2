@BuyTravelCredit
Feature: Verify Function Buy Travel Credit

  Scenario: I verify text on the Travel Credit page
    When I login to system by travala email
    When I navigate to My Travel Credit page
    And I verify text on buy travel credit tab
    And I verify text on summary tab
    And I verify text on redeem gift card tab
    And I verify navigate page when click on link in Redeem Gift Card Tab
    And I verify message when input invalid Gift Card in Redeem Gift Card Tab

  Scenario: Verify display text at payment when buy Travel Credit
    And I verify buy travel credits when payment by Credit Card
    And I verify buy travel credit when payment by Crypto
    And I verify buy travel credit when payment by Wallet
