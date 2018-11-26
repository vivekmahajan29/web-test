package web.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import web.test.pages.CreateUpdateComputerItemPage;

import java.util.Map;


public class CreateNewComputerItemSteps {

    CreateUpdateComputerItemPage createNewComputerItemPage;

    @Step
    public void shouldBeAbleToCreateNewComputerItem(Map<String,String> computerItem) {
        createNewComputerItemPage.enterComputerName(computerItem.get("Computer name"));
        createNewComputerItemPage.enterIntroducedDate(computerItem.get("Introduced date"));
        createNewComputerItemPage.enterDiscontinuedDate(computerItem.get("Discontinued date"));
        createNewComputerItemPage.selectCompany(computerItem.get("Company"));
        createNewComputerItemPage.clickCreateOrSaveThisButton();
    }

}