Feature: Login functionality on SauceDemo

  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    Then the inventory page should be displayed
