package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.driver_factory;
import pages.homepage;
import pages.loginpage;

import java.io.IOException;

public class MyStepdefs extends driver_factory {
    WebDriver driver=getdriver();
    loginpage lp=new loginpage(driver);
    homepage hp=new homepage(driver);

    public MyStepdefs() throws IOException, InterruptedException {
    }
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() throws IOException, InterruptedException {
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
    public void userIsNavigatedToHomePage() {
        lp.click_submit_btn();
        lp.verify_homepage();
    }


    @When("Assessor clicks on {string} button")
    public void assessorClicksOnButton(String arg0) {
        hp.click_add_evidence();
    }

    @And("Assessor enters evidence details on popup.")
    public void assessorEntersEvidenceDetailsOnPopup() {
      hp.enter_evidence();
    }


    @Given("Assessor is on the home page")
    public void assessorIsOnTheHomePage() throws IOException, InterruptedException {
        lp.launch();
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
    public void assessorClicksOnButtonOnPopup(String arg0) {
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
}
