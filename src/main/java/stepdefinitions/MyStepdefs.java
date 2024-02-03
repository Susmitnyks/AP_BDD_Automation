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
        System.out.println("success when");

    }

    @And("User select the AM{int} assesment")
    public void userSelectTheAMAssesment(int arg0) {
        System.out.println("success and");
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() {
        System.out.println("success then");
    }
}
