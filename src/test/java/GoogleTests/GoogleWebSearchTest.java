package GoogleTests;

import Google.GoogleSearchPage;
import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class GoogleWebSearchTest extends BaseTestCase{

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
    }

    @Test(description = "Buscar y navegar a la web del COIIPA")
    public void testSearchCoiipa() throws Exception {
        driver.get("http://www.google.com");
        GoogleSearchPage googleSearch = new GoogleSearchPage(driver);

        googleSearch.search("coiipa");

        String textoPrimerResultado = googleSearch.getResultText(0);

        assertTrue(textoPrimerResultado.startsWith("Colegio Oficial de Ingenieros en Informática del Principado"), "El primer resultado no contiene el texto esperado");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
