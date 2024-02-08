Feature: Test Add Evidence Functionality

  @Add_evidence
  Scenario: Verify successful evidence addition.
    Given Assessor is on the home page
    When Assessor clicks on "Add Evidence" button
    And Assessor enters evidence details on popup.
    And Assessor select Document from "select document" drop down on popup.
    And Assessor enters the required Page no on popup.
    And Assessor clicks on "Add evidence" button on popup.
    Then Popup will get close and evidence will get add in evidence section.