@GAScriptSteps
Feature: Verify us in sprint

  @TRAVO-15371
  Scenario: Verify text when payment by Credit Card and Login
    When I login to system by travala email
#    When I input destination and choose a property and link to check-out page
#    And I verify text at checkout when payment by Credit Card
    When I navigate to My Travel Credit page
    And I verify text on buy travel credit tab
#    And I verify text at payment part in the buy gift card page

  @TRAVO-15348
  Scenario: Update language for the pages Activate NFT/Explore NFT/Tiger NFT/AVA Token/Affiliate Program/Travala Members/Media Contact
    And I verify text at Landing NFT page when not login
    And I click on Active NFT link and verify displayed text on this page
    And I click on Affiliate Program link and verify displayed text on this page
    And I click on AVA token link and verify displayed text on this page
    And I click on Media Contact link and verify displayed text on this page
    And I click on Travel Member link and verify displayed text on this page
    When I login to system by travala email
    And I click on Tiger NFT and verify the text on the Overview tab


  @14844
  Scenario Outline: Verify US 14844
    When I login to system travala to check captcha
    Examples:
      | email                     |password|
      | Aira Boutique Hanoi Hotel & Spa |  |
  Scenario Outline: Verify US 13619
    When I input "<PropertyTxt>" and navigate to checkout page
    And I verify text at checkout page when login
    Examples:
      | PropertyTxt                     |
      | Aira Boutique Hanoi Hotel & Spa |

  Scenario: Verify displayed banner Maldives on landing page
    When I click on Register link and verify displayed text on this page
    And I verify navigate to page when click on banner
    And I verify the links on the header when not login
    And I verify the links on the header when login

  Scenario: Verify create acc on YopMail to send withdraw request
    When I create email by yopmail
    And I input valid information on the textbox to register acc
    And I confirm email to finsish register acc

  Scenario: Verify list valid wallet when whitelist NFT
    And I verify wallet address when whitelist NFT

  Scenario: Check display attribute on the link of the pages
    When I verify links at the footer part
    And I verify links at my profile page
    And I verify links at my travel credit page
    And I verify links at coin listing page
    And I verify links at invite page
    And I verify links at media page
    And I verify links at mobile app page

  Scenario: Verify display script GA at HOTEL Domain
    When I open landing page and verify test script GA
    And I click on about us link and verify test script GA
    And I click on AVA token link and verify test script GA
    And I click on invite program and verify test script GA
    And I click on Invite Term link and verify test script GA
    And I click on smart program and verify test script GA
    And I click on Smart Term link and verify test script GA
    And I click on Price Guarantee link and verify test script GA
    And I click on Travel credits link and verify test script GA
    And I click on Travel Gift card link and verify test script GA
    And I click on Contact us link and verify test script GA
    And I click on Binance Travel link and verify test script GA
    And  I click on Help Center link and verify test script GA
    And I click on Affiliate Program link and verify test script GA
    And I click on Terms & Conditions link and verify test script GA
    And I click on Privacy Policy link and verify test script GA
    And I click on Travel Member link and verify test script GA
    And I click on Cookie Policy link and verify test script GA
    And I click on Mobile Apps link and verify test script GA
    And I click on Payment Options link and verify test script GA
    And I click on Business Travel link and verify test script GA
    And I click on Official Blog link and verify test script GA
    And I click on Travel Advices link and verify test script GA
    And I click on Travel Guides link and verify test script GA
    And I click on Read Reviews link and verify test script GA
    And I click on Our Partners link and verify test script GA
    And I click on Coin listing link and verify test script GA
    And I verify test script GA at search page
    And I verify test script GA at property page
    When I login to system by travala email
    And I click on My Account and and verify test script GA
    And I click on my invite link and verify test script GA
    And I verify Referral page and verify test script GA
    And I click on My Wallet and verify test script GA
    And I click on My Travel Credit and verify test script GA
    And I click on My Smart and verify test script GA
    And I click on My wishlist and verify test script GA
    And I click on my booking and verify test script GA


  Scenario: Verify display script GA at Activities Domain
    When I input destination and verify test script GA on search Activities page
    And I input activities and verify test script GA on detail Activities page
    And I click on the package to link to booking and verify test script GA on this page


  Scenario: Verify display script GA at FLIGHT Domain
    And I select flight option to input destination and verify test script GA on flight page
    And I click on select flight and verify test script GA on booking page

  @TRAVA-15836
  Scenario Outline: As a customer goes to Travala from partner campaign with promo code, I want to sign up/ log in successfully , so that I will get bonus reward
    Given Open browser with url includes "<utm_campaign>", "<utm_term>", "<utm_content>", "<camp_voucher>", "<camp_voucher_discount>", "<camp_credit>", "<camp_code>"
    When I sign up or login successfully by partner journey "<utm_campaign>", "<utm_term>", "<camp_voucher_discount>", "<camp_credit>"
    Then Verify to receive bonus reward after sign up "<utm_term>", "<camp_voucher>", "<camp_voucher_discount>", "<camp_credit>"
    Examples:
    | utm_campaign | utm_term | utm_content | camp_voucher | camp_voucher_discount | camp_credit | camp_code        |
    | ETH          | credit   |             |              |                       | 15          | PARIS_CONFERENCE |
    | ETH          | discount |             | BECKTEST     |         10            |             |     BECKTEST     |
    | ETH          | none     |             |              |                       |             |                  |

  @TRAVO-SEO
  Scenario Outline: As the FE team, I will casing the URL to lower case, so that we won't get the error when the URL has Upper case inside
#    And Verify page display correctly and "<end_point>" auto change to Lowercase
#    And Verify Canonical tag for each "<end_point>"
#    And Verify added the href link to all the tag a for each "<end_point>"
    And Verify added ref equal noopener noreferrer to all external link using target equals _blank for each "<end_point>"
    Examples:
    | end_point |
    |           |
    | about-us |
    | activate-nft |
    | active |
    | activities |
    | affiliate-program |
    | app |
    | ava |
    | best-price-guarantee |
    | binance |
    | binanceus |
    | bitcoinexchange |
    | booking-terms |
    | business |
    | buy-gift-cards |
    | careers |
    | coin-listing |
    | confirm-withdraw |
    | contact-us |
    | cookie-policy |
    | crowdfund |
    | flights |
    | forgot-password |
    | gift-card-terms |
    | gift-cards |
    | governance |
    | invite |
    | invite-terms |
    | login |
    | media-contact |
    | members |
    | mint-nft |
    | my-booking-trip |
    | my-bookings |
    | my-business-bookings |
    | my-invite |
    | my-nft |
    | my-profile |
    | my-travel-credits |
    | my-wallet |
    | my-wishlist |
    | nft |
    | partnership |
    | payment-options |
    | privacy-policy |
    | register |
    | register-awesome |
    | reset-password |
    | smart |
    | smart-discounts |
    | smart-program |
    | smart-terms |
    | terms-and-conditions |
    | travel-credits |
    | travelsmart-protection |
    | payment/1inch |
    | payment/bifi |
    | payment/bch |
    | payment/poolz |
    | payment/ntvrk |
    | payment/ilv |
    | payment/sfund |
    | payment/xno |
    | payment/xdc |
    | payment/xrp |
    | payment/near |
    | payment/dot |
    | payment/link |
    | payment/mx |
    | payment/hbar |
    | payment/gal  |
    | payment/usdd |
    | payment/front |
    | payment/chr   |
    | payment/xlm   |
    | payment/xyo   |
    | payment/nftb  |
    | payment/xcur  |