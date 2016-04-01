package TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by francisco.moreno on 01/04/2016.
 */
public class TablesTest extends BaseTestCase {

    String url = "http://the-internet.herokuapp.com/tables";

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get(url);
    }

    @Test
    public void testCheckAllCompleteNameAndMail() throws Exception {


    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}
