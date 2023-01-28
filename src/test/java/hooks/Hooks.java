package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
    Hooks is used to run before and after each SCENARIO or SCENARIO OUTLINE.
     */
    @Before
    public void setUpScenario() {
        //System.out.println("Before Method");
    }

    @After
    public void tearUpScenario(Scenario scenario) {
        //System.out.println("After Method");
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario");
            Driver.closeDriver();
        }
    }


    //this before hooks only runs for @smoke_test tagged scenarios
    @Before("@smoke_tests")
    public void setUpSmokeScenario(){
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }

    //this after hooks only runs for @smoke_tats tagged scenarios

    @After("@smoke_tests")
    public void tearDownSmokeScenario(){
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }


}
