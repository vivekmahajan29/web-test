package web.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class CreateUpdateComputerItemPage extends PageObject {

    @FindBy(id="name")
    private WebElementFacade computerName;

    @FindBy(id="introduced")
    private WebElementFacade introducedDate;

    @FindBy(id="discontinued")
    private WebElementFacade discontinuedDate;

    @FindBy(id="company")
    private WebElementFacade company;

    @FindBy(className="btn")
    private WebElementFacade createOrSaveThisComputer;

    @FindBy(className="danger")
    private WebElementFacade deleteThisComputer;

    public void clickDeleteThisComputer() {
        deleteThisComputer.waitUntilClickable().click();
    }

    public void enterComputerName(String name) {
        computerName.type(name);
    }

    public void enterIntroducedDate(String date) {
        introducedDate.type(date);
    }

    public void enterDiscontinuedDate(String date) {
        discontinuedDate.type(date);
    }

    public void selectCompany(String name) {
        company.selectByVisibleText(name);
    }

    public void clickCreateOrSaveThisButton() {
        createOrSaveThisComputer.click();
    }

}