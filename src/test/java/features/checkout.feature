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

