package steps;

import io.cucumber.java.en.Then;
import utils.DBUtils;
import utils.GlobalVariables;

public class DBSteps {

    @Then("query database and get data")
    public void query_database_and_get_data() {
        GlobalVariables.mapDataFromDb = DBUtils.mapFromDataBase("SELECT emp_firstname, emp_middle_name, emp_lastname FROM hs_hr_employees WHERE employee_id = " + GlobalVariables.empId);
    }

}
