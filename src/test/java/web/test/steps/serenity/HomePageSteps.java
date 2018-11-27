package web.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import web.test.helpers.MessageType;
import web.test.pages.Navigation;
import web.test.pages.HomePage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps {

    HomePage homePage;
    Navigation navigation;

    @Step
    public void getHomePage() {
        navigation.getHomePage();
    }

    @Step
    public void getAddComputerPage() {
        homePage.clickAddNewComputerButton();
    }

    @Step
    public void searchComputer(String computerName) {
        homePage.filterByComputerName(computerName);
    }

    @Step
    public void shouldGetComputerCreatedSuccessMsg(String computerName) {
        assertThat(homePage.foundComputerIsSuccessfullyCreatedMsg(computerName, MessageType.CREATED)).isEqualTo(Boolean.TRUE);
    }

    @Step
    public void shouldGetComputerUpdatedSuccessMsg(String computerName) {
        assertThat(homePage.foundComputerIsSuccessfullyCreatedMsg(computerName, MessageType.UPDATED)).isEqualTo(Boolean.TRUE);
    }

    @Step
    public void shouldGetComputerItemDetails(Map<String, String> computerItem) {
        assertThat(homePage.searchedComputerItemFound(computerItem)).isEqualTo(Boolean.TRUE);
    }
}