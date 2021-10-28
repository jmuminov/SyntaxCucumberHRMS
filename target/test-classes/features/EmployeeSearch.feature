Feature: Search employee

  @regression @sprint4
  Scenario: search employee by id
    And user logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee id
    And click on search button
    Then user see employee information is displayed

  @regression @spring5
  Scenario: search employee by name
    And user logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee name
    And click on search button
    Then user see employee information is displayed