Feature: Login functionality on SauceDemo

  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters "standard_user" and "secret_sauce"
    And clicks the login button
    Then the inventory page should be displayed

  Scenario: User fails to log in with incorrect username
    Given the user is on the login page
    When the user enters "invalid_user" and "secret_sauce"
    And clicks the login button
    Then an error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario: User fails to log in with incorrect password
    Given the user is on the login page
    When the user enters "standard_user" and "wrong_password"
    And clicks the login button
    Then an error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario: User fails to log in with empty credentials
    Given the user is on the login page
    When the user enters "" and ""
    And clicks the login button
    Then an error message "Epic sadface: Username is required" should be displayed

  Scenario: User fails to log in with empty password
    Given the user is on the login page
    When the user enters "standard_user" and ""
    And clicks the login button
    Then an error message "Epic sadface: Password is required" should be displayed

  Scenario: User fails to log in with empty username
    Given the user is on the login page
    When the user enters "" and "secret_sauce"
    And clicks the login button
    Then an error message "Epic sadface: Username is required" should be displayed

