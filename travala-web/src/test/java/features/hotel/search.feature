
Feature: Check display SEARCH PAGE
#=======================FUCTION SEARCH======================================

  Scenario: Verify TEXT AT SEARCH RESULT when NOT LOGIN
    When I input invalid keyword to textbox search and verify display message
    And I verify text displayed when don't input hotel and click on search button
    And I verify text of search bar on the landing page
    When I input destination and choose default check-in and room
    And I click on Search button and verify search result page
    And I verify display list filter on search result page
    And I verify text on sort part
    And I verify text at property on search result page when not login
    And I verify display when click on See map view
    And I verify display property list when sort by property rank
    And I verify display property list when sort by price
    And I verify display property list when sort by rating
    And I verify display property list when sort by distance
    And I click to first property at search result

  @Search
  Scenario Outline: Check display at Search Result when FILTER
    When I input destination and choose default check-in and room
    And I click on Search button and verify search result page
    And I verify detail display every filter on search result page
    And I click on free breakfast filters and verify display property with free breakfast option
    And I click on excellent filters and verify display property with excellent option
    And I click on star rating filters and verify display property with "<starRating>" star rating option
    And I click on refundable filters and verify display property with refundable option
    Examples:
      | starRating |
      | 5          |

  Scenario: Check display at Search Result when choose Check-In Check-Out and Room
    When I input destination and choose default check-in and room
    And I click on Search button and verify search result page
    And I input destination and choose check-in and check-out greater than one night
    And I click on Search button and verify search result page
    And I input destination and choose room greater than one room
    And I click on Search button and verify search result page
    And I input destination and choose date time and room greater than one
    And I click on Search button and verify search result page

#//=======================SEARCH COUNTRY========================================

#  Scenario: Verify search result when search Location at COUNTRY PAGE
#    And I input country and verify text on that page
#    When I input destination and choose default check-in and room
#    And I click on Search button and verify search result page
#    And I click to first property at search result
#
#
#  Scenario Outline: Verify search result when search Property at COUNTRY PAGE
#    And I input country and verify text on that page
#    When I input "<PropertyTxt>" and navigate to checkout page
#    Examples:
#      | PropertyTxt                      |
#      | Vinpearl Resort & Golf Phu Quoc  |
#      | Muong Thanh Luxury Da Nang Hotel |

#  Scenario Outline: Verify display filter list at search result with KATANOX Data
#    When I input location into Textbox Search "<SearchTxt>" and no choose anything
#    And I click on Search button and verify search result page
#    And I verify display filter list at search result page
#    And I input "<hoteName>" to search hotel textbox in the search result
#
#    Examples:
#      | SearchTxt                                | hoteName                   |
##      | Zeeburgerdijk Amsterdam Netherlands      | Amsterdam Noord Apartments |
#      | Kamperfoelieweg 13 Amsterdam Netherlands | Amsterdam South Hostel     |
##      | Churchill-laan Amsterdam Netherlands     | Amsterdam West Hotel       |
##      | Jan Evertsenstraat Amsterdam Netherlands | Amsterdam East Hotel       |
