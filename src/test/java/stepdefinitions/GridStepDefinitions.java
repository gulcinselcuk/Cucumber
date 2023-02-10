package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefinitions {
    WebDriver driver;
    @Given("user is on the application_url using chrome")
    public void user_is_on_the_application_url_using_chrome() throws MalformedURLException {
 //     Running my test case on a remote machine(selenium grid) using chrome on local host
        //     Selenium grid url
        URL remoteURL=new URL("http://192.168.1.17:4444");
 //     Create remote webdriver
        driver=new RemoteWebDriver(remoteURL,new ChromeOptions());
 //     Grid steps are done...Rest is the same as normal tests cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");

    }
    @Then("verify the page title contains {string}")
    public void verify_the_page_title_contains(String string) {
        Assert.assertTrue(driver.getTitle().contains(string));

    }

    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }
    @Given("user is on the application_url using firefox")
    public void user_is_on_the_application_url_using_firefox() throws MalformedURLException {
       // Running my test case on a remote machine(selenium grid) using firefox on local host
        //     Selenium grid url
        URL remoteURL=new URL("http://192.168.1.17:4444");
        //     Create remote webdriver
        driver=new RemoteWebDriver(remoteURL,new FirefoxOptions());
        //     Grid steps are done...Rest is the same as normal tests cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");

    }



}
