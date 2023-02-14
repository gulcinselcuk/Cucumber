package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.SQLException;

public class DatabaseStepDefinitions {

    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
        //creating database connections using database utility class
        DBUtils.createConnection();

    }

    @Given("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String column, String table) {
//        String query ="SELECT * FROM jhi_user"; //hard coded
        String query= "SELECT "+column+" FROM "+table+" Order By Id"; //dynamic query
        //Running the query using DBUtil class
        DBUtils.executeQuery(query);
    }

    @Then("user reads all the column {string} data")
    public void user_reads_all_the_column_data(String column) throws Exception {
        //using resultset,get the object from the database
        DBUtils.getResultset().next();//going to the next row
        Object object1=DBUtils.getResultset().getObject(column);
        System.out.println(object1);
        DBUtils.getResultset().next();
        Object object2=DBUtils.getResultset().getObject(column);
        System.out.println(object2);


        int rowNum=2;
        while (DBUtils.getResultset().next()){ //continue to go to the next row until there is no more row
            Object currentRowObject=DBUtils.getResultset().getObject(column);
            System.out.println("Row "+rowNum+" data => "+currentRowObject);
            rowNum++;
        }

        System.out.println("Row count : "+rowNum);
        System.out.println("Row count : "+DBUtils.getRowCount());


    }

}
