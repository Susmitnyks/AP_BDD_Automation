package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.driver_factory;
import pages.homepage;
import pages.loginpage;

import java.awt.*;
import java.io.IOException;

public class MyStepdefs extends driver_factory {
    WebDriver driver=getdriver();
    loginpage lp=new loginpage(driver);
    homepage hp=new homepage(driver);

    public MyStepdefs() throws IOException, InterruptedException {
    }
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() throws IOException, InterruptedException, AWTException {
       lp.launch();
    }

    @When("User select the learner")
    public void userSelectTheLearner() throws InterruptedException {
        lp.learner_dropdown();

    }

    @And("User select the AM{int} assessment")
    public void userSelectTheAMAssesment(int arg0) throws InterruptedException {
        lp.assessment_dropdown();
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() throws InterruptedException {
        lp.click_submit_btn();
        lp.verify_homepage();
    }


    @When("Assessor clicks on {string} button")
    public void assessorClicksOnButton(String arg0) throws InterruptedException {
        hp.click_add_evidence();
    }

    @And("Assessor enters evidence details on popup.")
    public void assessorEntersEvidenceDetailsOnPopup() throws InterruptedException {
      hp.enter_evidence();
    }


    @Given("Assessor is on the home page")
    public void assessorIsOnTheHomePage() throws IOException, InterruptedException, AWTException {
        lp.launch();
        lp.Microsoft_login();
        lp.learner_dropdown();
        lp.assessment_dropdown();
        lp.click_submit_btn();
        lp.verify_homepage();
    }

    @And("Assessor select Document from {string} drop down on popup.")
    public void assessorSelectDocumentFromDropDownOnPopup(String arg0) throws InterruptedException {
        hp.select_doc();
    }

    @And("Assessor enters the required Page no on popup.")
    public void assessorEntersTheRequiredPageNoOnPopup() {
        hp.enter_pageno();
    }

    @And("Assessor clicks on {string} button on popup.")
    public void assessorClicksOnButtonOnPopup(String arg0) throws InterruptedException {
        hp.add_evidence_btn_click_popup();
    }

    @Then("Popup will get close and evidence will get add in evidence section.")
    public void popupWillGetCloseAndEvidenceWillGetAddInEvidenceSection() throws InterruptedException {
        hp.verify_added_evidence();
    }

    @When("Assessor clicks on added evidence Accordion")
    public void assessorClicksOnAddedEvidenceAccordion() throws InterruptedException {
        hp.click_added_evidence();

    }

    @Then("Added evidence description , location and page no by should be displayed")
    public void addedEvidenceDecriptionLocationAndPageNoShouldBeDisplayed() throws InterruptedException {
        hp.verify_evidence();

    }

    @Given("Assessor selects DA criteria {string} from criteria section")
    public void assessorSelectsDACriteriaFromDropDown(String criteriaText) throws InterruptedException {
        hp.select_da_criteria(criteriaText);
    }


    @When("Assessor selects {string} in Evidence Review")
    public void assessorSelectsInEvidenceReview(String arg0) {
        hp.click_evidence_review_insuff();
    }

    @Given("Test given")
    public void testGiven() {
        System.out.println("Success");
    }

    @When("User clicks on the Microsoft login button")
    public void userClicksOnTheMicrosoftLoginButton() throws InterruptedException, AWTException {
     lp.Microsoft_login();
    }

    @And("Assessor clicks on Submit button")
    public void assessorClicksOnSubmitButton() throws InterruptedException {
     hp.click_submit();
    }

    @Then("Criteria assessment should get submit and % bar should get update")
    public void criteriaAssessmentShouldGetSubmitAndBarShouldGetUpdate() throws InterruptedException {
        hp.per_bar();

    }

    @And("Assessor selects sub criteria {string}")
    public void assessorSelectsSubCriteria(String criteriaText) throws InterruptedException {
        hp.select_da_sub_criteria(criteriaText);

    }

    @And("Assessor select Sufficient and clicks on Submit button.")
    public void assessorSelectSufficientAndClicksOnSubmitButton() throws InterruptedException {
        hp.click_evd_review_suff();
        hp.click_submit();


       /*  String class_name = buttonElement.getAttribute("class");
       selected class : class="focus:outline-none disabled:cursor-not-allowed disabled:opacity-75 flex-shrink-0 font-medium rounded-md text-sm gap-x-2 px-3 py-2 shadow-sm text-white dark:text-gray-900 bg-green-500 hover:bg-green-600 disabled:bg-green-500 dark:bg-green-400 dark:hover:bg-green-500 dark:disabled:bg-green-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-green-500 dark:focus-visible:outline-green-400 inline-flex items-center uppercase flex-auto justify-center"

        not selected :
        class="focus:outline-none focus-visible:outline-0 disabled:cursor-not-allowed disabled:opacity-75 flex-shrink-0 font-medium rounded-md text-sm gap-x-2 px-3 py-2 shadow-sm ring-1 ring-inset ring-gray-300 dark:ring-gray-700 text-gray-900 dark:text-white bg-white hover:bg-gray-50 disabled:bg-white dark:bg-gray-900 dark:hover:bg-gray-800/50 dark:disabled:bg-gray-900 focus-visible:ring-2 focus-visible:ring-primary-500 dark:focus-visible:ring-primary-400 inline-flex items-center uppercase flex-auto justify-center"
    */
    }

    @Then("evidence review should be Sufficient.")
    public void evidenceReviewShouldBeSufficient() throws InterruptedException {
        hp.select_da_criteria("DA2");
        hp.select_da_sub_criteria("DA2.2");
        hp.check_review();

    }

    @When("Assessor updates the rationale content.")
    public void assessorUpdatesTheRationaleContent() throws InterruptedException {
        hp.update_rationale();
    }

    @Then("rationale contents should get updates")
    public void rationaleContentsShouldGetUpdates() {
        hp.check_rationale();
    }

    @When("Assessor updates the assessor question.")
    public void assessorUpdatesTheAssessorQuestion() throws InterruptedException {
        hp.update_ass_quest();
    }

    @Then("assessor question contents should get updates")
    public void assessorQuestionContentsShouldGetUpdates() {
        hp.check_ass_question();
    }
}
