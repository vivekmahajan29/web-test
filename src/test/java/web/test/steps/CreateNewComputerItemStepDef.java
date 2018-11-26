package web.test.steps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import web.test.steps.serenity.CreateNewComputerItemSteps;
import web.test.steps.serenity.HomePageSteps;

import java.util.Map;

public class CreateNewComputerItemStepDef {


    @Steps
    CreateNewComputerItemSteps createNewComputerItemSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Then("^I should be able to successfully create new computer item as$")
    public void createNewComputerItem(Map<String, String> computerItem) {
        homePageSteps.getAddComputerPage();
        createNewComputerItemSteps.shouldBeAbleToCreateNewComputerItem(computerItem);
        homePageSteps.shouldGetComputerCreatedSuccessMsg(computerItem.get("Computer name"));
    }



}
