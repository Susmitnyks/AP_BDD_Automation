Feature: Test login and logout functionality

  @Login_test_case
  Scenario: Verify successful login with valid credentials
    Given User is on the login page
    When User select the learner
    And User select the AM1 assessment
    Then User is navigated to home page
