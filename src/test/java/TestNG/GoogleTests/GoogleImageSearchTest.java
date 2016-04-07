package TestNG.GoogleTests;

import Google.GoogleSearchImagesPage;
import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import Test.Utils.ScreenShotListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 08/02/2016.
 */

@Listeners(ScreenShotListener.class)
public class GoogleImageSearchTest extends BaseTestCase{



    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get("http://www.google.com");
    }

    @Test(description = "Visitar la página del COIIPA partiendo de su imagen")
    public void testSearchCoiipaImage() throws Exception {

        String expectedURL = "http://coiipa.org/";

        GoogleSearchImagesPage googleImageSearch = new GoogleSearchImagesPage(driver);

        googleImageSearch.search("coiipa");
        googleImageSearch.gotoImages();

        googleImageSearch.clickOnNImagen(0);

        googleImageSearch.navigateNextImage();
        googleImageSearch.navigateNextImage();

        googleImageSearch.visitCurrentImagePage();

        //En enlace se abre una nueva pestaña
        //Debemos comprobar la URL en la nueva ventana
        googleImageSearch.switchToNewTab();

        assertTrue(googleImageSearch.checkCurrentURLIs(expectedURL), "No estamos en la pagina del oficial del COIIPA. La url es " + driver.getCurrentUrl());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}
