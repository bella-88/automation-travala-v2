@Vote
Feature: Verify text Governance page

  Scenario: Verify text at Governance page
    When I link to Governance page
    And I verify display number vote and list recent vote
    And I verify display list vote when click on View All button
  And I verify display title vote at recent proposal and view all vote
#    When I verify display text on governance page when not login
#    When I login to system by travala email
#    And I verify display text on governance page
