package TheInternetTests;

import Test.Utils.DriverFactory;
import TheInternetPages.HomePage;
import TheInternetPages.LoginPage;
import TheInternetPages.LoginSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 03/02/2016.
 */
public class LoginTest {

    private WebDriver driver;
    private static boolean remoteDriver;

    String url = "http://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);

        driver.get(url);

    }

    @Test(description = "Intento de login con usuario incorrecto")
    public void testIncorrectUserNameFromHomePage() throws Exception {

        //Arrange
        HomePage homePage = new HomePage(driver);
        String username = "fakeUser";
        String pass = "fakePass";

        //Act
        homePage.navigateToLoginPage().loginAs(username, pass);

        LoginPage loginPage = new LoginPage(driver);
        WebElement mensaje = loginPage.getMensajeError();

        //Assert
        //Comprobamos que se muestra el cajetin de error
        assertTrue(mensaje.isDisplayed(),"No se muestra el mensaje de login incorrecto");

        //El mensaje de error es el esperado
        assertTrue(mensaje.getText().startsWith("Your username is invalid!"),"El mensaje de error no muestra el texto esperado");

        //Como comprobacion adicional, verificamos que seguimos en la misma página.
        //Es decir, efectivamente, no nos hemos logado
        assertTrue(driver.getCurrentUrl().endsWith("login"),"No estamos en la pagina de login");


    }

    @Test
    public void testIncorrectPasswordCorrectUser() throws Exception {
        String username = "tomsmith";
        String password = "fakepass";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.loginAs(username, password);

        WebElement mensaje = loginPage.getMensajeError();
        assertTrue(mensaje.isDisplayed(),"No se muestra el mensaje de login incorrecto");
        assertTrue(mensaje.getText().startsWith("Your password is invalid!"),"El mensaje de error no muestra el texto esperado");
        assertTrue(driver.getCurrentUrl().endsWith("login"),"No estamos en la pagina de login");

    }

    @Test
    public void testLoginCorrecto() throws Exception {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.loginAs(username, password);

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);

        WebElement mensaje = loginSuccessPage.getMensaje();
        assertTrue(mensaje.isDisplayed(),"No se muestra el mensaje de login correcto");
        assertTrue(mensaje.getText().startsWith("You logged into a secure area!"),"El mensaje de exito no muestra el texto esperado");
        assertTrue(driver.getCurrentUrl().endsWith("secure"),"No estamos en la pagina segura");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
