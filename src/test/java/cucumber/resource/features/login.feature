Feature: Login
  Scenario: Failed Login Invalid Credentials
    Given User on Login Page
    When User input wrong username
    And User input wrong password
    And User click button Login
    Then User get error invalid username or password

  Scenario: Failed Login Empty Username
    Given User on Login Page
    When User input empty username
    And User input password
    And User click button Login
    Then User get error username is required

  Scenario: Failed Login Empty Password
    Given User on Login Page
    When User input username
    And User input empty password
    And User click button Login
    Then User get error password is required

  Scenario: Success Login
    Given User on Login Page
    When User input username
    And User input password
    And User click button Login
    Then User get success login