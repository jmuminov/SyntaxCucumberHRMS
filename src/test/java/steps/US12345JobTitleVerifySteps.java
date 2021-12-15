package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.DashBoardPage;
import utils.CommonMethods;

public class US12345JobTitleVerifySteps extends CommonMethods {

    @When("user moves their mouse to Admin option")
    public void user_moves_their_mouse_to_admin_option() {
        DashBoardPage dash = new DashBoardPage();
        Actions action = new Actions(driver);
        action.moveToElement(dash.adminOption).perform();
    }

    @When("moves their mouse to Job dropdown")
    public void moves_their_mouse_to_job_dropdown() {
        DashBoardPage dash = new DashBoardPage();
        Actions action = new Actions(driver);
        action.moveToElement(dash.jobDD).perform();
    }
    @When("clicks on Job Titles")
    public void clicks_on_job_titles() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.jobTitle);
    }
    @Then("user verifies that job titles are displayed in Ascending order in HRMS Application")
    public void user_verifies_that_job_titles_are_displayed_in_ascending_order_in_hrms_application() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("it is verified against DB")
    public void it_is_verified_against_db() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
