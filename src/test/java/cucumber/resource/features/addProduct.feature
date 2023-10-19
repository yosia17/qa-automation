Feature: Add a product to the cart
  Scenario Outline: Add a product to the cart
    Given User is on the product page
    When User add <product> to cart
    And User go to the cart
    Then I should see the <product> in the cart

    Examples:
      | product             |
      | Sauce Labs Backpack |