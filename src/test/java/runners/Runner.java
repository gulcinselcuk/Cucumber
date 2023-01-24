package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        monochrome=true,
        features = "./src/test/resources/features",//"PATH OF FEATURES FOLDER"
        glue = "stepdefinitions",//PATH OF STEPDEFINITIONS FOLDER
        dryRun = false ,//if dryRun=True. run dry.just give me the missing step definitions. don't run the test cases.
        tags ="@data_tables"
)

public class Runner {
}


/*
When you run Runner, it will go to feature file, and start execution from top to bottom.
If there is any step matching, Java will find that matching 'stepdefinition', and it will be executed.
If there is no match then Cucumber will generate template for us in the console.
 */
