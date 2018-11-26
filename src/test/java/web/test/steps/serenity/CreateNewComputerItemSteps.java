package web.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import web.test.helpers.CommonUtils;
import web.test.helpers.ItemType;
import web.test.pages.CreateUpdateComputerItemPage;

import java.util.Map;


public class CreateNewComputerItemSteps {

    CreateUpdateComputerItemPage createNewComputerItemPage;

    @Step
    public void shouldBeAbleToCreateNewComputerItem(Map<String, String> computerItem) {
        computerItem.keySet().forEach(itemType -> CommonUtils.enterItemType(createNewComputerItemPage, itemType, computerItem));
        createNewComputerItemPage.clickCreateOrSaveThisButton();
    }


}