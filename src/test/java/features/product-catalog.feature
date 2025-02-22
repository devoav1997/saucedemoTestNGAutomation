Feature: Product catalog browsing on SauceDemo

  Scenario: User views product catalog
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    Then the inventory page should be displayed
    And the user should see the product catalog

  Scenario: User filters products by Name (A to Z)
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects filter option "Name (A to Z)"
    Then the products should be sorted by "Name (A to Z)"

  Scenario: User filters products by Price (low to high)
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects filter option "Price (low to high)"
    Then the products should be sorted by "Price (low to high)"

  Scenario: User views product details
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user clicks on product "Sauce Labs Backpack"
    Then the product detail page should be displayed with product name "Sauce Labs Backpack"
