package TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.JavascriptAlertsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 30/03/2016.
 */
public class JavascritpAlertsTest extends BaseTestCase {

    String url = "http://the-internet.herokuapp.com/javascript_alerts";

    JavascriptAlertsPage alertsPage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get(url);

        alertsPage = new JavascriptAlertsPage(driver);
    }

    @Test
    public void testAlert() throws Exception {
        alertsPage.clickOnJsAlertButton();

        //Comprobar que se muestra la alerta y que el texto de la misma el correcto
        assertTrue(alertsPage.isAlertPresent(), "No se muestra la alerta");
        assertEquals(alertsPage.getAlertText(), "I am a JS Alert", "El texto de la alerta no es correcto");

        alertsPage.confirmAlert();

        assertEquals(alertsPage.getResultText(), "You successfuly clicked an alert", "El texto de confirmacion no coincide");
    }

    @Test
    public void testOkConfirmAlert() throws Exception {
        alertsPage.clickOnJsConfirmButton();

        assertTrue(alertsPage.isAlertPresent(), "No se muestra la alerta");
        assertEquals(alertsPage.getAlertText(), "I am a JS Confirm", "El texto de la alerta no es correcto");

        alertsPage.confirmAlert();

        assertEquals(alertsPage.getResultText(), "You clicked: Ok", "El texto de confirmacion no coincide");
    }

    @Test
    public void testCancelConfirmAlert() throws Exception {
        alertsPage.clickOnJsConfirmButton();

        assertTrue(alertsPage.isAlertPresent(), "No se muestra la alerta");
        assertEquals(alertsPage.getAlertText(), "I am a JS Confirm", "El texto de la alerta no es correcto");

        alertsPage.dismissAlert();

        assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "El texto de confirmacion no coincide");
    }

    @Test
    public void testPromtAlert() throws Exception {
        alertsPage.clickOnJsPromtButton();

        assertTrue(alertsPage.isAlertPresent(), "No se muestra la alerta");
        assertEquals(alertsPage.getAlertText(), "I am a JS prompt", "El texto de la alerta no es correcto");

        String promtText = "Testing promt alert";

        alertsPage.setPromtAlertText(promtText);
        alertsPage.confirmAlert();

        assertEquals(alertsPage.getResultText(), "You entered: " + promtText, "El texto mostrado no coincide con el introducido");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
