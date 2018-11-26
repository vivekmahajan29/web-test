package web.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import web.test.pages.CreateUpdateComputerItemPage;
import web.test.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteComputerItemSteps {

    HomePage homePage;
    CreateUpdateComputerItemPage editComputerItemPage;

    @Step
    public void shouldBeAbleToDeleteComputerItem(String computerName) {
        homePage.filterByComputerName(computerName);
        if (!homePage.isNoComputersFoundMsgPresent()) {
            int numberOfTimesToDelete = homePage.getSizeOfComputerItemsFound();
            while (numberOfTimesToDelete > 0) {
                deleteComputerItem(computerName);
                numberOfTimesToDelete--;
                if (numberOfTimesToDelete != 0)
                    homePage.filterByComputerName(computerName);
            }
        }
    }

    private void deleteComputerItem(String computerName) {
        homePage.openComputerItem(computerName);
        editComputerItemPage.clickDeleteThisComputer();
        assertThat(homePage.foundComputerHasBeenDeletedMsg()).isEqualTo(Boolean.TRUE);
    }

}