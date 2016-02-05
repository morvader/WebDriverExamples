package TheInternetTests;

import Test.Utils.DriverFactory;
import TheInternetPages.DynamicContentHidePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by francisco.moreno on 04/02/2016.
 */
public class DynamicContentTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.CHROME);

    }

    @Test
    public void testAppearsDynamicHideElement() throws Exception {

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicContentHidePage dynamicPage = new DynamicContentHidePage(driver);

        dynamicPage.clickStart();

        String mensaje = dynamicPage.getHiddenMessage();

        assertEquals("El mensaje mostrado no es correcto", "Hello World!", mensaje);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
