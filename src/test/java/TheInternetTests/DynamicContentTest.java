package TheInternetTests;

import Test.Utils.DriverFactory;
import TheInternetPages.DynamicContentHidePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Created by francisco.moreno on 04/02/2016.
 */
public class DynamicContentTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);

    }

    @Test
    public void testAppearsDynamicHideElement() throws Exception {

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicContentHidePage dynamicPage = new DynamicContentHidePage(driver);

        dynamicPage.clickStart();

        String mensaje = dynamicPage.getHiddenMessage();

        assertEquals("Hello World!", mensaje,"El mensaje mostrado no es correcto");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
}
