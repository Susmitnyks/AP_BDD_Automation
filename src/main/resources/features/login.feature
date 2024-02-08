Feature: Verify login and Select learner's submission attempt ID.

  @Login_test_case
  Scenario: Verify successful login and learner submission selection
    Given User is on the login page
    When User select the learner
    And User select the AM1 assessment
    Then User is navigated to home page
