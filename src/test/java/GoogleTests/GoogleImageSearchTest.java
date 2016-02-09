package GoogleTests;

import Google.GoogleSearchImagesPage;
import Test.Utils.DriverFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class GoogleImageSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void testSearchCoiipaImage() throws Exception {
        driver.get("http://www.google.com");

        GoogleSearchImagesPage googleImageSearch = new GoogleSearchImagesPage(driver);

        googleImageSearch.search("coiipa");
        googleImageSearch.gotoImages();

        googleImageSearch.clickOnNImagen(0);

        googleImageSearch.navigateNextImage();
        googleImageSearch.navigateNextImage();

        googleImageSearch.visitCurrentImagePage();

        try {
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
