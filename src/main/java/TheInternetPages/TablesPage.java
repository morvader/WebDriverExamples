package TheInternetPages;

import PageObject.BasePageObject;
import TheInternetPages.Utils.RowContactDataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moreno on 03/04/2016.
 */
public class TablesPage extends BasePageObject {

    public enum tableColumns {
        LAST_NAME,
        FIRT_NAME,
        EMAIL,
        DUE,
        WEBSITE
    }

    public final String lastNameClass = "last-name";
    public final String fistNameClass = "first-name";
    public final String emailClass = "email";
    public final String dueClass = "dues";
    public final String webClass = "web-site";

    @FindBy(id = "table2")
    WebElement annotatedTable;

    public TablesPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArrayList<RowContactDataTable> getAnnotatedTableData() {
        ArrayList<RowContactDataTable> dataTable = new ArrayList<RowContactDataTable>();

        List<WebElement> tableRows = annotatedTable.findElements(By.cssSelector("tbody > tr"));

        for (WebElement row : tableRows) {
            dataTable.add(tableRowToData(row));
        }

        return dataTable;
    }

    public void orderAnnotatedTableByColumn(tableColumns columnName) {
        String classSelector = "";
        switch (columnName) {
            case LAST_NAME:
                classSelector = lastNameClass;
                break;
            case FIRT_NAME:
                classSelector = fistNameClass;
                break;
            case EMAIL:
                classSelector = emailClass;
                break;
            case DUE:
                classSelector = dueClass;
                break;
            case WEBSITE:
                classSelector = webClass;
                break;
            default:
                classSelector = "";
        }

        if (classSelector.equals("")) return;

        annotatedTable.findElement(By.cssSelector(".header > " + "." + classSelector)).click();
    }

    private RowContactDataTable tableRowToData(WebElement row) {
        RowContactDataTable rowData = new RowContactDataTable();

        rowData.lastName = row.findElement(By.className(lastNameClass)).getText();
        rowData.firstName = row.findElement(By.className(fistNameClass)).getText();
        rowData.email = row.findElement(By.className(emailClass)).getText();
        rowData.due = row.findElement(By.className(dueClass)).getText();
        rowData.webSite = row.findElement(By.className(webClass)).getText();

        return rowData;
    }


}
