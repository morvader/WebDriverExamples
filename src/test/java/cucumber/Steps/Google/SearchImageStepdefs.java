package cucumber.Steps.Google;

import Google.GoogleSearchImagesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.fail;

/**
 * Created by francisco.moreno on 06/04/2016.
 */
public class SearchImageStepdefs {

    WebDriver driver;
    private GoogleSearchImagesPage googleSearchImagesPage;

    public SearchImageStepdefs() {
        driver = GoogleHooks.driver;
    }

    @Given("^Busco imagen por el \"(.+)\"$")
    public void buscoImagenPorEl(String campoABuscar) throws Throwable {
        driver.get("http://google.es");
        googleSearchImagesPage = new GoogleSearchImagesPage(driver);
        googleSearchImagesPage.search(campoABuscar);

    }

    @When("^navego hasta la imagen \"(.+)\"$")
    public void navegoHastaLaImagen(String posicionImagen) throws Throwable {
        googleSearchImagesPage.gotoImages();
        googleSearchImagesPage.clickOnNImagen(Integer.parseInt(posicionImagen) - 1);
    }

    @Then("^llego a la \"(.+)\" deseada$")
    public void llegoALaDeseada(String urlWebDeseada) throws Throwable {
        googleSearchImagesPage.visitCurrentImagePage();

        try {
            //En enlace se abre una nueva pestaña
            //Debemos comprobar la URL en la nueva ventana
            googleSearchImagesPage.switchToNewTab();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlToBe(urlWebDeseada));

        } catch (TimeoutException to) {
            fail("No estamos en la web deseada");
        }
    }
}
