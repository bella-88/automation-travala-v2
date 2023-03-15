@landing
Feature: Verify text display on LANDING PAGE


  Scenario: Verify LANGUAGE displayed on landing page
#    And I verify navigate to page when click on url domain on header
#    And I verify navigate to page when click on url on header
#    And I verify display and navigate page four option on the landing page
#    And I verify text on title of Customer Review Choose You and Discover
#    And I verify text on Campaign Part of Landing page
#    And I click any country and verify text of country page
#    And I verify display item on the footer part
        And I verify text on my trip and search invalid order
    And I verify text at destination when move mouse to destination
    When I click on any destination on the landing page and verify navigate that page

  Scenario Outline: Verify display when Search at header part
    When I search "<language>" and "<coin>" at header part
    And I verify result displayed after search
    Examples:
      | language | coin |
      |  Deutsch |ava|

  Scenario: Verify LANGUAGE displayed at 404 Page
    And I navigate to not found page and verify text on this page

  Scenario Outline: Verify LANGUAGE displayed on forgot password at landing page
    When I click on forgot password link
    And I input "<email>" to textbox and verify text on this page
    Examples:
      | email                   |
      | bella.travala@gmail.com |

  Scenario: Verify LANGUAGE displayed when input invalid textbox on REGISTER page
    When I click on Register link and verify displayed text on this page
    And I input empty the textbox on this form and verify error message on this form
    And I input invalid new password and confirm new password on this form






