package web.test.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import web.test.steps.serenity.HomePageSteps;
import web.test.steps.serenity.UpdateComputerItemSteps;

import java.util.Map;

public class UpdateComputerItemStepDef {

    @Steps
    UpdateComputerItemSteps updateComputerItemSteps;

    @Steps
    HomePageSteps homePageSteps;

    @When("^I am able to update details of \"([^\"]*)\" with$")
    public void updateComputerItem(String computerName, Map<String, String> details) {
        updateComputerItemSteps.shouldBeAbleToUpdateComputerItem(computerName, details);
        homePageSteps.shouldGetComputerUpdatedSuccessMsg(computerName);
    }
}
