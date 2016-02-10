package TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.DynamicControlsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class DynamicControlsTest  extends BaseTestCase {

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test(description = "Comprobar que el chceck box aparece y desaparece al pulsar el botón")
    public void testCheckBoxApareceDesapare() throws Exception {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);

        assertTrue(dynamicControlsPage.isCheckBoxPresent(), "El checkbox no esta presente al inicio");

        dynamicControlsPage.clickButton();

        String mensaje = dynamicControlsPage.getMensaje();
        assertEquals(mensaje, "It's gone!");
        assertFalse(dynamicControlsPage.isCheckBoxPresent(), "El checkbox está presente después de pulsar el botón que lo hace desparacer");


        dynamicControlsPage.clickButton();
        mensaje = dynamicControlsPage.getMensaje();
        assertEquals(mensaje, "It's back!");
        assertTrue(dynamicControlsPage.isCheckBoxPresent(), "El checkbox no está  presente después de pulsar el botón que lo hace aparacer");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }
}
