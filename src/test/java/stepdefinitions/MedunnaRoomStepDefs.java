package stepdefinitions;

import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.ReusableMethods;

public class MedunnaRoomStepDefs {
    MedunnaHomePage medunnaHomePage=new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage=new MedunnaRoomPage();
    @When("click on Items&Titles")
    public void clickOnItemsTitles() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.itemsAndTitles.click();


    }

}