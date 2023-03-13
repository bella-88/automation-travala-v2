Feature: Validate info at checkout page when booking hotel from search property

  @Property
  Scenario: Verify text at checkout page
    When I input destination and choose a property and link to check-out page
    And I input information for Reservation

#  Scenario Outline:  Verify CHECK OUT page when Not Login
#When I input "<PropertyTxt>" with select three person and navigate to checkout page
#    And I verify text at contact part in the checkout page when not login
#    And I verify text at payment part in the checkout page when not login
#    And I input valid contact information
#    Then I verify info at checkout page and popup when payment by "<coin>"
#    And I verify info at booking summary page when payment Crypto
#    Examples:
#      | PropertyTxt           |coin|
#      | Mercure Hanoi La Gare |  DOT  |
    #    ==========================VERIFY DISPLAY WHEN PAYMENT BY CRYPTO================================


  Scenario:Login to system Travala by Email
    When I login to system by travala email

  @TRAVO-15909
  Scenario Outline: Verify payment by CRYPTO Success when Login
    When I login to system by travala email
    When I input destination and choose a property and link to check-out page
    And I input information for Reservation
    And I verify payment by "<coin>" by Now Payment
#    And I verify info at booking summary page when payment Crypto
    Examples:
      | coin |
#      | AVA           |
#      | ADA  |
#      | BTC           |
      | USDD |



#    ==========================VERIFY DISPLAY WHEN PAYMENT BY MY WALLET================================

  Scenario Outline: Verify payment by MY WALLET when don't have enough Balance
    When I login to system by travala email
    When I input destination and choose a property and link to check-out page
    And I input information for Reservation
    Then I verify info at checkout page and popup when dont have enough "<coin>" to payment
    Examples:
      | PropertyTxt                     | coin |
      | Aira Boutique Hanoi Hotel & Spa | AVA  |

#    ==========================VERIFY DISPLAY WHEN PAYMENT BY TRAVEL CREDIT================================

  Scenario Outline: Verify payment by TRAVEL CREDIT Success when don't have enough Balance
    When I login to system by travala email
    When I input destination and choose a property and link to check-out page
    And I input information for Reservation
    Then I verify info at checkout page when dont have Travel Credit to payment
    Examples:
      | PropertyTxt                          |
      | Park Plaza Westminster Bridge London |


  Scenario Outline: Verify payment by MY WALLET Success when enough Balance
    When I login to system by travala email
    When I input destination and choose a property and link to check-out page
    And I input information for Reservation
    Then I verify info at checkout page and popup when payment by "<coin>" Wallet
    And I verify info at booking summary page when payment by Wallet
    Examples:
      | PropertyTxt                     | coin |
      | Aira Boutique Hanoi Hotel & Spa |    AVA  |

  Scenario: Verify payment by TRAVEL CREDIT Success when enough Balance
    When I input destination and choose a property and link to check-out page
#    And I input information for Reservation
#    Then I verify info at checkout page and popup when payment by Travel Credit
#    And I verify info at booking summary page when payment by Travel Credit
#    Examples:
#      | PropertyTxt                          |
#      | Park Plaza Westminster Bridge London |

  #    ==========================VERIFY DISPLAY WHEN PAYMENT BY CREDIT CARD================================

  Scenario:  Verify booking Success when payment by Credit Card and Not Login
    When I input destination and choose a property and link to check-out page
    And I verify text at contact part in the checkout page when not login
    And I verify info at booking summary page when payment by Credit Card

  @CheckOut
  Scenario: Verify text when payment by Credit Card and Login
    When I login to system by travala email
    When I input destination and choose a property and link to check-out page
    And I verify text at checkout when payment by Credit Card

#    ==========================VERIFY DISPLAY WHEN PAYMENT BY UTRUST================================
#  Scenario Outline: Verify payment by UTRUST Success when Login
#    When I click on icon language and select language at landing page
#    When I input "<PropertyTxt>" and navigate to checkout page
#    And I select Utrust option and verify text at Utrust form
#    And I verify display when payment by Utrust
#    Examples:
#      | PropertyTxt                     |
#      | Aira Boutique Hanoi Hotel & Spa |

#  Scenario Outline: Verify payment by UTRUST Success when Login
#    When I click on icon language and select language at landing page
#    When I input "<PropertyTxt>" and navigate to checkout page
#    And I select VNPay option and verify text at VNPay form
#    And I verify display when payment by VNPay
#    Examples:
#      | PropertyTxt                     |
#      | Aira Boutique Hanoi Hotel & Spa |
#
#  Scenario Outline: Verify payment by UTRUST after Cancel Order when Login
#    When I click on icon language and select language at landing page
#    When I input "<PropertyTxt>" and navigate to checkout page
#    And I select Utrust option and verify text at Utrust form
#    When I click on cancel order at utrust page and verify booking status
#    Examples:
#      | PropertyTxt                     |
#      | Aira Boutique Hanoi Hotel & Spa |
##    ==========================VERIFY DISPLAY WHEN PAYMENT BY APP CRYPTO================================
#  Scenario Outline: Verify payment by APP CRYPTO Success when Login
#    When I click on icon language and select language at landing page
#    When I input "<PropertyTxt>" and navigate to checkout page
#    And I select App Crypto option and verify text at App Crypto form
#    And I verify display when payment by App Crypto
#    Examples:
#      | PropertyTxt                     |
#      | Aira Boutique Hanoi Hotel & Spa |


#    ==========================VERIFY TEXT ON THE PAGE WHEN NOT LOGIN================================

