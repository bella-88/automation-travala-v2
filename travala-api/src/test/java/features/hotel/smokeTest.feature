
Feature: SMOKE Test API Travala Site
#  //=====================NEW UPDATED FROM 1 DEC 2022================================================
  #  //=====================VERIFY HOME PAGE================================================
#  @Smoke-Test
  Scenario: Smoke test for Home Page
    And Verify text in the Home page
#    And Verify displayed when click on 4 option bellow search bar
    And Verify displayed when click on TOP COUNTRY at the landing page
    And Verify navigate when click on any destination
    And Verify display list coin when click on payment options

  @Smoke-Test-api
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