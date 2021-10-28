package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.firstName, "Batch");
        sendText(aep.middleName, "10");
        sendText(aep.lastName, "The Best");
    }
    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage aep = new AddEmployeePage();
        click(aep.createLoginCheckBox);
    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.createUsername, "batch10username");
        sendText(aep.createPassword, "Hum@nhrm123");
        sendText(aep.rePassword,"Hum@nhrm123");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage aep = new AddEmployeePage();
        click(aep.saveBtn);
    }
    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("Employee is added Successfully");
    }
    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.employeeID, "");
    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }
    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.firstName, firstName);
        sendText(aep.middleName, middleName);
        sendText(aep.lastName, lastName);
    }
    @And("user enters {string} {string} and {string} for an employee")
    public void userEntersAndForAnEmployee(String firstName, String middleName, String lastName) {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.firstName, firstName);
        sendText(aep.middleName, middleName);
        sendText(aep.lastName, lastName);
    }
    @When("I add multiple employees and verify them that user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeeName : employeeNames) {
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage aep = new AddEmployeePage();
            sendText(aep.firstName, valueFirstName);
            sendText(aep.middleName, valueMiddleName);
            sendText(aep.lastName, valueLastName);
            click(aep.saveBtn);

            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(1000);
        }
    }
}
