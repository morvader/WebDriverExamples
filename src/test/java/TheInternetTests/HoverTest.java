package TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.HoversPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class HoverTest extends BaseTestCase{

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @Test (description = "Comprobar que los datos del usuario 2 son correctos")
    public void testDatosCorrectorUsuario2() throws Exception {
        HoversPage hoversPage = new HoversPage(driver);

        String userName= hoversPage.getUserName(1);

        assertEquals(userName, "name: user2", "El nombre del usuario 2 no es correcto");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        driver.quit();
    }
}
