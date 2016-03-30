package GoogleTests;

import Google.GoogleSearchImagesPage;
import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import Test.Utils.ScreenShotListener;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * Created by francisco.moreno on 08/02/2016.
 */

@Listeners(ScreenShotListener.class)
public class GoogleImageSearchTest extends BaseTestCase{



    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.CHROME);
    }

    @Test(description = "Visitar la página del COIIPA partiendo de su imagen")
    public void testSearchCoiipaImage() throws Exception {
        driver.get("http://www.google.com");

        GoogleSearchImagesPage googleImageSearch = new GoogleSearchImagesPage(driver);

        googleImageSearch.search("coiipa");
        googleImageSearch.gotoImages();

        googleImageSearch.clickOnNImagen(0);

        googleImageSearch.navigateNextImage();
        //googleImageSearch.navigateNextImage();

        googleImageSearch.visitCurrentImagePage();

        try {
            //En enlace se abre una nueva pestaña
            //Debemos comprobar la URL en la nueva ventana
            googleImageSearch.switchToNewTab();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("http://coiipa.org"));

        }catch (TimeoutException to){
            fail("No estamos en la pagina del oficial del COIIPA");
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}
