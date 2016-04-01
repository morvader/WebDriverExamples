package TheInternetPages;

import PageObject.BasePageObject;
import TheInternetPages.Utils.RowTableData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco.moreno on 01/04/2016.
 */
public class TablesPage extends BasePageObject {

    @FindBy(id = "table2")
    WebElement annotatedTable;

    public TablesPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RowTableData[] getAnnotatedTableData() {
        ArrayList<RowTableData> dataRows = new ArrayList<RowTableData>();
        List<WebElement> rows = annotatedTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            dataRows.add(tableRowToData(row));
        }

        return (RowTableData[]) dataRows.toArray();
    }

    private RowTableData tableRowToData(WebElement row) {
        RowTableData dataRow = new RowTableData();

        dataRow.lastName = row.findElement(By.className("last-name")).getText();
        dataRow.firstName = row.findElement(By.className("first-name")).getText();
        dataRow.email = row.findElement(By.className("email")).getText();
        dataRow.due = row.findElement(By.className("dues")).getText();
        dataRow.web = row.findElement(By.className("web-site")).getText();

        return dataRow;
    }
}
