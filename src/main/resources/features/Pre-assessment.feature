Feature: Test Pre-assessment page functionality.


  @Add_evidence
  Scenario: Verify successful evidence addition.
    Given Assessor is on the home page
    When Assessor clicks on "Add Evidence" button
    And Assessor enters evidence details on popup.
    And Assessor select Document from "select document" drop down on popup.
    And Assessor enters the required Page no on popup.
    And Assessor clicks on "Add evidence" button on popup.
    Then Popup will get close and evidence will get add in evidence section.
    When Assessor clicks on added evidence Accordion
    Then Added evidence description , location and page no by should be displayed


  @Submit_Assessment
  Scenario: Verify successful Assessment submission.
    Given Assessor is on the home page
    When Assessor selects DA criteria "DA2" from criteria section
    And Assessor selects sub criteria "DA2.6"
    And Assessor clicks on Submit button
    Then Criteria assessment should get submit and % bar should get update


  @Evidence_Review
  Scenario: Verify evidence review selection and submission.
    Given Assessor is on the home page
    When Assessor selects DA criteria "DA2" from criteria section
    And Assessor selects sub criteria "DA2.2"
    And Assessor select Sufficient and clicks on Submit button.
    Then evidence review should be Sufficient.

  @Rationale
  Scenario: Verify rationale contents updation.
    Given Assessor is on the home page
    When Assessor updates the rationale content.
    And Assessor clicks on Submit button
    Then rationale contents should get updates

  @Assessor_Question
  Scenario: Verify Assessor question contents updation.
    Given Assessor is on the home page
    When Assessor updates the assessor question.
    And Assessor clicks on Submit button
    Then assessor question contents should get updates