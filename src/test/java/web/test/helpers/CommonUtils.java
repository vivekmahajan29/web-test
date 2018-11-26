package web.test.helpers;

import web.test.pages.CreateUpdateComputerItemPage;

import java.util.Map;

public class CommonUtils {

    public synchronized static void enterItemType(CreateUpdateComputerItemPage createUpdateComputerItemPage, String itemType, Map<String, String> computerItem) {
        switch (itemType) {
            case ItemType.COMPUTER_NAME:
                createUpdateComputerItemPage.enterComputerName(computerItem.get("Computer name"));
                break;
            case ItemType.INTRODUCED:
                createUpdateComputerItemPage.enterIntroducedDate(computerItem.get("Introduced date"));
                break;
            case ItemType.INTRODUCED_DATE:
                createUpdateComputerItemPage.enterIntroducedDate(computerItem.get("Introduced date"));
                break;
            case ItemType.DISCONTINUED:
                createUpdateComputerItemPage.enterDiscontinuedDate(computerItem.get("Discontinued date"));
                break;
            case ItemType.DISCONTINUED_DATE:
                createUpdateComputerItemPage.enterDiscontinuedDate(computerItem.get("Discontinued date"));
                break;
            case ItemType.COMPANY:
                createUpdateComputerItemPage.selectCompany(computerItem.get("Company"));

        }
    }
}
