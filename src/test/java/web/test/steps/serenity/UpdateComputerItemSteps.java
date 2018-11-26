package web.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import web.test.helpers.CommonUtils;
import web.test.pages.CreateUpdateComputerItemPage;
import web.test.pages.HomePage;

import java.util.Map;


public class UpdateComputerItemSteps {

    HomePage homePage;
    CreateUpdateComputerItemPage updateComputerItemPage;


    @Step
    public void shouldBeAbleToUpdateComputerItem(String computerName, Map<String, String> computerItem) {
        homePage.filterByComputerName(computerName);
        homePage.openComputerItem(computerName);
        computerItem.keySet().forEach(itemType -> CommonUtils.enterItemType(updateComputerItemPage, itemType, computerItem));
        updateComputerItemPage.clickCreateOrSaveThisButton();
    }

}