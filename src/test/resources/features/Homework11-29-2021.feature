Feature: Homework for SQL 11-29-2021

  Background:
    When user logged in with valid admin credentials

  @hw
  Scenario: US 12345: Verify that all job titles are displayed in Ascending order in HRMS Application (Must be verified against DB)
    When user moves their mouse to Admin option
    And moves their mouse to Job dropdown
    And clicks on Job Titles
    Then user verifies that job titles are displayed in Ascending order in HRMS Application
    And it is verified against DB