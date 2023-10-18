Feature: Logout
  Scenario: User can logout
    Given User is logged in
    When User clicks on burger menu
    And User clicks on logout button
    Then User is logged out