Feature: Check display property info at checkout page when search property


  Scenario Outline: Verify LANGUAGE displayed on checkout page when select a day
    When I input property into textbox Search "<PropertyTxt>"
    And I click on Search button to link Property page
    And I verify text on the top page when select a day
    And I verify text on the Available Room part
    And I verify tool tip of add wishlist when not login
    And I verify tooltip of payment and fee at package when not login
    And I verify text on the first package part when select a day
    And I verify text on the hotel description part
    
    Examples:
      | PropertyTxt       |
      | InterContinental London Park Lane |

  Scenario:  Verify LANGUAGE displayed on checkout page when property no have package
    When I input destination and choose a property and link to check-out page
    And I verify text on the top page when no have package

  Scenario Outline: Verify LANGUAGE displayed on checkout page when select more than a day
    When I input destination and choose a property and link to check-out page
    And I verify text on the top page when select more than a day
    And I add property to wishlist and verify text
    And I verify text on the Available Room part
    And I verify text at filter part
    And I verify text on the first package part when select more than a day
    And I verify tooltip of payment and fee at package when not login
    And I verify text on the hotel description part
    
    Examples:
      | PropertyTxt                    | day |
      | Sofitel Legend Metropole Hanoi | 2   |
  @Property_language
  Scenario Outline:  LOGIN_STANDAR_Verify LANGUAGE displayed on checkout page when select a day
    When I input property into textbox Search "<PropertyTxt>"
        And I click on Search button to link Property page
    When I input destination and choose a property and link to check-out page
    And I verify text on the top page when select a day
    And I verify text on the Available Room part
   And I verify text at filter part
    And I verify text on the first package part when select a day
    And I verify tooltip of payment and fee at package when login
    And I verify text on the hotel description part
    And I logout to system
    
    Examples:
      | PropertyTxt          |
      | Sofitel Saigon Plaza |


  Scenario Outline:  LOGIN_SMART_Verify LANGUAGE displayed on checkout page when select a day
    When I login to system by travala email
    When I input property into textbox Search "<PropertyTxt>"
    And I click on Search button to link Property page
    And I verify text on the top page when select a day
    And I verify text on the Available Room part
    And I verify text at filter part
    And I verify text on the first package part when select a day
    And I verify tooltip of payment and fee at package when login
    And I verify text on the hotel description part
    And I logout to system
    
    Examples:
      | PropertyTxt                       | 
      | InterContinental London Park Lane | 
  @Property11
  Scenario Outline:  LOGIN_STANDAR_Verify LANGUAGE displayed on checkout page when select more than a day
    When I login to system by travala email
#    When I input property into textbox Search "<PropertyTxt>"
    And I click on Search button to link Property page
    And I verify text on the top page when select more than a day
    And I verify text on the Available Room part
   And I verify text at filter part
    And I verify text on the first package part when select more than a day
    And I verify tooltip of payment and fee at package when login
    And I verify text on the hotel description part
    And I logout to system
    
    Examples:
      | PropertyTxt             | day |
      | Hilton London Metropole | 3   | 

  Scenario Outline:  LOGIN_SMART_Verify LANGUAGE displayed on checkout page when select more than a day
    When I login to system by travala email
    When I input property into textbox Search "<PropertyTxt>"
    And I click on Search button to link Property page
    And I verify text on the top page when select more than a day
    And I verify text on the Available Room part
   And I verify text at filter part
    And I verify text on the first package part when select more than a day
    And I verify tooltip of payment and fee at package when login
    And I verify text on the hotel description part
    And I logout to system
    
    Examples:
      | PropertyTxt           | day | 
      | Corus Hyde Park Hotel | 3   | 

  Scenario Outline: Verify best price package info at checkout page with property page when select same day
    When I input property into textbox Search "<PropertyTxt>"
#    And I select check in is same day and check out is "<day>"
    And I click on Search button to link Property page
    And I click on Book Now button at best price package
    Then I verify the "<PropertyTxt>" is displayed at checkout page
    And I verify per night is "<perNight>" with checkout page
    And I verify original price at checkout page with property page
#    And I verify checkin day and checkout "<day>" at checkout page
    And I verify Price per night at checkout page with property page
    And I verify Refundability at checkout page with property page
    And I verify Booking price at checkout page with property page
    And I verify Room type at checkout page with property page
    And I verify booking price and total charge at checkout page
    
    Examples:
      | PropertyTxt         | perNight        | day |
      | Pullman Hanoi Hotel | Price per night | 1   |

#
#  Scenario Outline: Verify best price package info at checkout page with property page when select greater a day
#    When I input property into textbox Search "<PropertyTxt>"
#    And I select check in is same day and check out is "<day>"
#    And I click on Search button to link Property page
#    And I click on Book Now button at best price package
#    Then I verify the "<PropertyTxt>" is displayed at checkout page
#    And I verify checkin day and checkout "<day>" at checkout page
#    And I verify Price per night at checkout page with property page
#    And I verify Refundability at checkout page with property page
#    And I verify Booking price at checkout page with property page
#    And I verify Room type at checkout page with property page
#    And I verify booking price and total charge at checkout page
#    
#    Examples:
#      | PropertyTxt                   | day |
#      | Park Plaza County Hall London | 3   |

#  Scenario Outline: ACC_STANDER_TOTAL_PRICE LESS THAN 100$ No Voucher_Verify property info
#    Given I navigate to Travala site
##    When I click on icon language and select language
#    When I input property into textbox Search "<PropertyTxt>"
#    And I select check in is same day and check out is "<day>"
#    And I click on Search button to link Property page
##    And I verify package no voucher and click on Book Now button at best price package
#    Then I verify the "<PropertyTxt>" is displayed at checkout page
#    And I verify checkin day and checkout "<day>" at checkout page
#    And I verify original price at checkout page with property page
#    And I verify Price per night at checkout page with property page
#    And I verify Refundability at checkout page with property page
#    And I verify Booking price at checkout page with property page
#    And I verify Room type at checkout page with property page
#    And I verify booking price and total charge at checkout page
#    Examples:
#      | PropertyTxt                       | day |
#      | Peridot Grand Hotel & Spa by AIRA | 1   |

