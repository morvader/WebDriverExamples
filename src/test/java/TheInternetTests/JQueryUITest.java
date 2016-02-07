package TheInternetTests;

import Test.Utils.DriverFactory;
import Test.Utils.ScreenShot;
import TheInternetPages.JQueryUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Moreno on 07/02/2016.
 */
public class JQueryUITest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
    }

    @Test(description = "Desplegar menu y hacer clik en volver a la pagina de menu de jquery")
    public void testBackToJQueryMenu() throws Exception {

        JQueryUIPage jQueryUIPage = new JQueryUIPage(driver);

        jQueryUIPage.backToJQueryMenu();

        assertTrue(driver.getCurrentUrl().endsWith("jqueryui"),"No estamos en la pagina del menu de jquery");
        assertEquals(driver.findElement(By.tagName("h3")).getText(), "JQuery UI", "No se muestra el texto del menu de JQuery");

    }

    @Test(description = "Descarga de fichero CSV mediante acciones de menu")
    public void testDownloadCSV() throws Exception {


        JQueryUIPage jQueryUIPage = new JQueryUIPage(driver);

        jQueryUIPage.downloadCSV();


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            ScreenShot.takeScreenShot(result.getName(), this.driver);
        }
        driver.quit();

    }
}
