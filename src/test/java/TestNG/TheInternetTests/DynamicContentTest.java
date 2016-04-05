package TestNG.TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.DynamicContentHidePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Created by francisco.moreno on 04/02/2016.
 */
public class DynamicContentTest  extends BaseTestCase {


    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    public void testAppearsDynamicHideElement() throws Exception {


        DynamicContentHidePage dynamicPage = new DynamicContentHidePage(driver);

        dynamicPage.clickStart();

        String mensaje = dynamicPage.getHiddenMessage();

        assertEquals("Hello World!", mensaje, "El mensaje mostrado no es correcto");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
