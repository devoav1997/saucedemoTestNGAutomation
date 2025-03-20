Feature: Checkout functionality on SauceDemo

  Scenario: User selects a product and completes the checkout process
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And proceeds to checkout
    And fills in the checkout information with "John" "Doe" "12345"
    And completes the purchase
    Then a confirmation message "Thank you for your order!" should be displayed


  Scenario: User fails to checkout with empty first name
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And proceeds to checkout
    And fills in the checkout information with "" "Doe" "12345"
    And clicks the continue button
    Then an error message "Error: First Name is required" should be displayed

  Scenario: User fails to checkout with empty last name
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And proceeds to checkout
    And fills in the checkout information with "John" "" "12345"
    And clicks the continue button
    Then an error message "Error: Last Name is required" should be displayed

  Scenario: User fails to checkout with empty postal code
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    And the user selects a product "Sauce Labs Backpack"
    And adds the product to the cart
    And proceeds to checkout
    And fills in the checkout information with "John" "Doe" ""
    And clicks the continue button
    Then an error message "Error: Postal Code is required" should be displayed