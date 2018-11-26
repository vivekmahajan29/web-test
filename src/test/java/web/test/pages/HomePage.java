package web.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import web.test.helpers.MessageType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HomePage extends PageObject {

    private static final String COMPUTER_DELETED_MSG = "Done! Computer has been deleted";
    private static final String NO_COMPUTERS_FOUND_MSG = "No computers found";

    @FindBy(id = "add")
    private WebElementFacade addNewComputer;

    @FindBy(className = "computers")
    private WebElementFacade searchedComputers;

    @FindBy(className = "alert-message")
    private WebElementFacade alertMessage;

    @FindBy(id = "searchbox")
    private WebElementFacade filterByComputerName;

    @FindBy(id = "searchsubmit")
    private WebElementFacade filterByName;

    @FindBy(className = "well")
    private WebElementFacade nothingToDisplay;


    public void clickAddNewComputerButton() {
        addNewComputer.click();
    }

    public boolean searchedComputerItemFound(Map<String, String> expectedComputerItem) {
        return searchedComputers.then(By.tagName("tbody"))
                .thenFindAll(By.tagName("tr"))
                .stream()
                .anyMatch(row -> {
                    List<String> actualComputerItem = new ArrayList<>();
                    row.thenFindAll(By.tagName("td")).forEach(detail -> actualComputerItem.add(detail.getText()));

                    List<String> expectedItem = new ArrayList<String>(expectedComputerItem.values());
                    return expectedItem.equals(actualComputerItem);
                });
    }

    public boolean foundComputerIsSuccessfullyCreatedMsg(String computerName, MessageType type) {
        StringBuilder msgBuilder = new StringBuilder("Done! Computer ");
        String msg = (MessageType.CREATED.getValue().equals(type.getValue())) ? " has been created" : " has been updated";
        msgBuilder.append(computerName).append(msg);
        return alertMessage.waitUntilVisible().getText().equals(msgBuilder.toString());
    }

    public void filterByComputerName(String computerName) {
        filterByComputerName.type(computerName);
        filterByName.click();
    }

    public int getSizeOfComputerItemsFound() {
        return find(By.className("computers"))
                .then(By.tagName("tbody"))
                .thenFindAll(By.tagName("tr")).size();
    }

    public void openComputerItem(String computerName) {
        find(By.className("computers"))
                .then(By.tagName("tbody"))
                .thenFindAll(By.tagName("tr")).get(0)
                .thenFindAll(By.tagName("td")).get(0)
                .then(By.linkText(computerName))
                .click();
    }

    public boolean foundComputerHasBeenDeletedMsg() {
        return alertMessage.waitUntilVisible().getText().equals(COMPUTER_DELETED_MSG);
    }

    public boolean isNoComputersFoundMsgPresent() {
        try {
            waitForTextToAppear(NO_COMPUTERS_FOUND_MSG);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}