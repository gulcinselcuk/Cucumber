package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    //    Hooks is used to run before and after each Scenario or Scenario Outline.

    @Before     //use from io.cucumber.java
    public void setUpScenario(){
//        System.out.println("Before Method");
    }


    @After      //use from io.cucumber.java
    public void tearDownScenario(Scenario scenario){     //like Listener, it understands if a scenario is pass, failed or skipped
//        System.out.println("After Method");
        if(scenario.isFailed()) {       //capturing the screenshot when a scenario fails and attaching it to report
            final byte[] failedScreenshot =   ((TakesScreenshot) Driver.getDriver()).getScreenshotAs((OutputType.BYTES));
            scenario.attach(failedScreenshot,"image/png","failed_scenario"+scenario.getName()+"");
            Driver.closeDriver();
        }
    }


    //This Before hooks only runs for @smoke_test tagged scenarious.
//    @Before (value = "@smoke_tests")  //it can be used
    @Before ("@smoke_tests")
    public void setUpSmokeScenarious(){
        System.out.println("Run for only Smoke Test Scenarious");
    }



    //This After hooks only runs for @smoke_test tagged scenarious.
    @After ("@smoke_tests")
    public void tearDownSmokeScenarious(){
        System.out.println("Run for only Smoke Test Scenarious");
    }



}

    /*

What is hooks?
    Hooks is a class that runs Before or After each Scenario
Why do you use?
    I use hooks class to generate the reports with screenshot.
    My after method especially helpful to capture screenshot when a Scenario fails automatically.
What is in it?
    It has Before and After methods. I have reports method to capture the screenshot


        Conditional Hooks
        We can say after annotation :
        @After  ("@browser and not @headless")    -->run @browser tags, but not run @headless tags



     */