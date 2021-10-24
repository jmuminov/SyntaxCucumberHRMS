Feature: Login validation

  Scenario: Valid admin login
    Given user is navigated to HRMS
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

  Scenario: Valid ess login
    Given user is navigated to HRMS
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  Scenario: Valid username and invalid password
    Given user is navigated to HRMS
    When user enters valid username and invalid password
    And user clicks on login button
    Then user see invalid credentials message on login page