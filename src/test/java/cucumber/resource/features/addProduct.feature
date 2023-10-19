Feature: Add a product to the cart
  Scenario Outline: Add a product to the cart
    Given User is on the product page
    When User add <product> to cart
    And User go to the cart
    Then User should see the <product> in the cart

    Examples:
      | product                  |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |