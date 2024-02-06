package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.driver_factory;
import pages.loginpage;

import java.io.IOException;

public class MyStepdefs extends driver_factory {
    WebDriver driver=getdriver();
    loginpage lp=new loginpage(driver);

    public MyStepdefs() throws IOException {
    }
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() throws IOException, InterruptedException {
       lp.launch();
    }

    @When("User select the learner")
    public void userSelectTheLearner() {
        lp.learner_dropdown();

    }

    @And("User select the AM{int} assessment")
    public void userSelectTheAMAssesment(int arg0) {
        lp.assessment_dropdown();
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() {
        lp.click_submit_btn();
    }
}
