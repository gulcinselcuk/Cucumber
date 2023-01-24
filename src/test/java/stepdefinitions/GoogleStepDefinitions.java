package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();

    @Given("user on the google home page")
    public void user_on_the_google_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));

        try {
            googlePage.popUpAccept.click();//accept pop up if visible. Catch the error and continue if not visible
        } catch (Exception e) {
        }
    }

    @When("user search for iPhone")
    public void user_search_for_i_phone() {
        googlePage.searchBox
                .sendKeys("iPhone" + Keys.ENTER);
    }

    @Then("verify page title contains iPhone")
    public void verify_page_title_contains_i_phone() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iPhone"));

    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();

    }

    @When("user search for TeaPot")
    public void user_search_for_TeaPot() {
        googlePage.searchBox.sendKeys("TeaPot" + Keys.ENTER);
    }

    @Then("verify page title contains TeaPot")
    public void verify_page_title_contains_TeaPot() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("TeaPot"));

    }

    @When("user search for {string} on google")
    public void user_search_for_on_google(String string){
        googlePage.searchBox.sendKeys(string+Keys.ENTER);
    }

    @Then("verify page title contains {string}")
    public void verify_page_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

}
