package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;
public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("user is on {string} page")
    public void user_is_on_page(String string) {
        Driver.getDriver().get(string);
    }

    @Given("user enters customer_email and customer_password")
    public void user_enters_customer_email_and_customer_password(DataTable credentials) {
////        1. GET DATA AS LIST OF STRING
//        List<String> customerData = credentials.row(1);//row index start at 0
////        System.out.println(customerData.get(0));
////        System.out.println(customerData.get(1));
////        System.out.println(credentials.row(1).get(0));//2nd row 1st col
////        System.out.println(credentials.row(1).get(1));//2nd row 2nd col
//        loginPage.username.sendKeys(customerData.get(0));
//        loginPage.password.sendKeys(customerData.get(1));
//        loginPage.loginButton.click();
//        2. GET DATA AS <LIST<MAP<STRING,STRING>>
        List<Map<String,String>> customerData =  credentials.asMaps(String.class,String.class);
//        System.out.println(customerData);
        for (Map<String,String> each : customerData){
            loginPage.username.sendKeys(each.get("username"));
            loginPage.password.sendKeys(each.get("password"));
            loginPage.loginButton.click();
        }
    }
    @Then("verify the application login is successful")
    public void verify_the_application_login_is_successful() {
        Assert.assertTrue(homePage.userID.isDisplayed());
    }
}