
Feature: Verify text display on My PROFILE FUNCTION
  @Profile
  Scenario: Verify text display on My Account page when login with Standrad Account
    When I login to system by travala email
    And I link to My Account and verify text at left menu on this page
    And I click on Tiger NFT and verify the text on the Overview tab

  Scenario: Verify text display at MY WALLET Page
    And I click on My Wallet and link to this page
    And I verify text on the overview option
    And I verify text on the summary option
    And I verify text on the withdraw option
    And I verify text on the deposit option

  Scenario: Verify display information at MY SMART Page
    And I click on My Smart and verify text on this page
    And I active acc to smart account and verify text

  Scenario: Verify display information at MY WISHLIST Page
    And I verify text at my wishlist for stay and activities tab
    And I verify remove item at my wishlist

  Scenario: Verify display information at MY BOOKING Page
    And I link to my booking and open stay option
    And I verify display text when click on view booking button
    And I verify info at booking summary page

    Scenario: Verify display information at MY INVITE Page
    And I verify text in the Invite People tab
    And I verify the text on the Invite Detail page with acc no have invited acc
    And I verify message popup when input email to invite
    And I verify navigate link on my Invite page
    And I verify Referral page when click on link at invite people


#  Scenario: Verify text display At My Account and CHANGE EMAIL && CHANGE PASSWORD
#    When I login to system by travala email
#    And I click on My Account and link to this page
#    Then I verify text on the tab Personal Details and update address success
#    And I verify text on the tab Connect Account
#    And I verify text on the tab Settings
#    And I verify text on the tab Security
#    And I verify change email with input invalid email and password
#    And I verify change email with input valid email and password


#
#
#  Scenario Outline: Verify text display At My Account CHANGE PASSWORD
#    And I verify when input invalid "<newPassword>" and "<confirmPassword>" to change password
#    Examples:
#      | newPassword | confirmPassword |
#      |             | advdad          |
#      | a           | advdad          |
##      | 12345       | 12345           |
##      | ABCDR       | ABCDR           |
##      | ABC    DR   | ABC    DR       |
##      | @#$%&*      | @#$%&*          |
##      | abcd@12345B | abcd   @12345B    |
##      | abcB#34     | abcB#34         |


#  Scenario Outline: Verify My Wallet when input invalid textbox on WithDraw option
#    And I click on My Wallet and link to this page
#    And I verify input invalid "<invalidAddress>" and "<invalidMemo>" and"<invalidAmount>" and "<saveAddress>"
#    Examples:
#      | invalidAddress  | invalidMemo | invalidAmount | saveAddress |
#      | abfsd           | !@!@#@#@@   | 2000000000    |             |
#      | tbnb1zeq335mf3p | !@!@#@#@@   | 0.001         |             |
#
#
#  Scenario Outline: Verify MY Wallet when withdraw when NO SAVE ADDRESS at my Wallet page
#    And I click on My Wallet and link to this page
#    And I verify withdraw success with "<Address>" and "<Memo>" and"<Amount>"
##    And I open gmail tab to confirm withDraw
#    Examples:
#      | Address                                     | Memo         | Amount |
#      | tbnb1zeq335mf3pk4f8lxwnwmefjk09cw85gvjlnf5x | AVA_D_000259 | 100    |
#
#
#  Scenario Outline: Verify My Wallet when withdraw when SAVE ADDRESS at my Wallet page
#    And I click on My Wallet and link to this page
#    And I verify withdraw success when save address "<Address>" and "<Memo>" and"<Amount>" and"<saveAddress>"
##    And I open gmail tab to confirm withDraw
#
#    Examples:
#      | Address                                     | Memo         | Amount | saveAddress |
#      | tbnb1zeq335mf3pk4f8lxwnwmefjk09cw85gvjlnf5x | AVA_D_000259 | 100    | test        |
#
#
#  Scenario Outline: Verify My Wallet when withdraw when USE MAX at my Wallet page
#    And I click on My Wallet and link to this page
#    And I verify withdraw success when use max "<Address>" and "<Memo>"
##    And I open gmail tab to confirm withDraw
#    Examples:
#      | Address                                     | Memo         |
#      | tbnb1zeq335mf3pk4f8lxwnwmefjk09cw85gvjlnf5x | AVA_D_000259 |
#
#
#  Scenario: Verify text display when user have booking at My Booking page
#    And I click on my booking and link to this page
#    And I verify display text when user no have booking
