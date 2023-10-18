Feature: Login
  Scenario: Success Login
    Given User on Login Page
    When User input username
    And User input password
    And User click button Login
    Then User get success login


  Scenario Outline: Failed Login Invalid Credentials
    Given User on Login Page
    When User input wrong username <username>
    And User input wrong password <password>
    And User click button Login
    Then User get error <errorMessage> message

      Examples:
        | username      | password     | errorMessage                                                |
        | lalala        | lalala       | Username and password do not match any user in this service |
        | standard_user |              | Password is required                                        |
        |               | secret_sauce | Username is required                                        |

