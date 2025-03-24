Feature: Shopping cart operations on SauceDemo

  Scenario: User adds a product to the cart
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    Then the cart icon should show "1"

  Scenario: User views the shopping cart
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And the user opens the cart
    Then the cart should contain "Sauce Labs Backpack"

  Scenario: User removes a product from the cart
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And the user opens the cart
    And the user removes the product "Sauce Labs Backpack"
    Then the cart should be empty
