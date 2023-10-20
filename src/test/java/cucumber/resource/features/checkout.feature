Feature: Checkout
  Scenario Outline: Checkout with valid data
    Given User is on Your Cart Page
    When User clicks on Checkout button
    And User fill the form with <firstName>, <lastName>, <postalCode>
    And User clicks on Continue button
    And User clicks on Finish button
    Then User should be on Checkout Complete Page

    Examples:
      | firstName | lastName | postalCode |
      | John      | Doe      | 12345      |
      | Jane      | Doe      | 67890      |

  Scenario Outline: Checkout with invalid data
    Given User is on Your Cart Page
    When User clicks on Checkout button
    And User fill the form with <firstName>, <lastName>, <postalCode>
    And User clicks on Continue button
    Then User should see <errorStatus> message

    Examples:
      | firstName | lastName | postalCode | errorStatus |
      |           |          |            | firstName   |
      |           | lalala   | 12345      | firstName   |
      | lalala    |          | 67890      | lastName    |
      | lalala    | lalala   |            | postalCode  |