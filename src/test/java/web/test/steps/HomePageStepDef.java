package web.test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import web.test.steps.serenity.CreateNewComputerItemSteps;
import web.test.steps.serenity.DeleteComputerItemSteps;
import web.test.steps.serenity.HomePageSteps;

import java.util.Map;

public class HomePageStepDef {

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    CreateNewComputerItemSteps createNewComputerItemSteps;

    @Steps
    DeleteComputerItemSteps deleteComputerItemSteps;

    @Given("^I am on application home page$")
    public void homePage() {
        homePageSteps.getHomePage();
    }

    @And("^I find nothing for \"([^\"]*)\" item in search$")
    public void noItemFound(String computerName) {
        deleteComputerItemSteps.shouldBeAbleToDeleteComputerItem(computerName);
    }

    @When("^I search by computer name \"([^\"]*)\"$")
    public void iSearchByComputerName(String computerName) {
        homePageSteps.searchComputer(computerName);
    }

    @Then("^I should be able to successfully view its details$")
    public void detailsRelatedToComputerItem(Map<String, String> computerItem) {
        homePageSteps.shouldGetComputerItemDetails(computerItem);
    }

}
