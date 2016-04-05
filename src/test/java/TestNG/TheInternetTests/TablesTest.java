package TestNG.TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.TablesPage;
import TheInternetPages.Utils.RowContactDataTable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.testng.Assert.assertEquals;

/**
 * Created by Moreno on 03/04/2016.
 */
public class TablesTest extends BaseTestCase {

    String url = "http://the-internet.herokuapp.com/tables";

    TablesPage tablesPage;

    ArrayList<RowContactDataTable> expectedContacts;

    @BeforeClass
    public void setUpData() {
        expectedContacts = new ArrayList<RowContactDataTable>();
        expectedContacts.add(new RowContactDataTable("Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"));
        expectedContacts.add(new RowContactDataTable("Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com"));
        expectedContacts.add(new RowContactDataTable("Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com"));
        expectedContacts.add(new RowContactDataTable("Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com"));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get(url);
        tablesPage = new TablesPage(driver);
    }

    @Test
    public void testCheckCompleteNameAndMail() throws Exception {
        ArrayList<RowContactDataTable> actualTableDate = tablesPage.getAnnotatedTableData();

        //Comparamos datos en el mismo orden
        assertEquals(expectedContacts, actualTableDate, "Los datos de la tabla no son correctos");
    }

    @Test
    public void testCheckCompleteNameAndMailOrderedByLastName() throws Exception {
        ArrayList<RowContactDataTable> dataOrderByLastName = expectedContacts;

        //Odenamos nuestros resultados esperados por apellido
        Collections.sort(dataOrderByLastName, new Comparator<RowContactDataTable>() {
            public int compare(RowContactDataTable o1, RowContactDataTable o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });

        tablesPage.orderAnnotatedTableByColumn(TablesPage.tableColumns.LAST_NAME);

        ArrayList<RowContactDataTable> actualTableDate = tablesPage.getAnnotatedTableData();

        //Comparamos datos en el mismo orden
        assertEquals(dataOrderByLastName, actualTableDate, "Los datos no están ordenador correctamente");
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
