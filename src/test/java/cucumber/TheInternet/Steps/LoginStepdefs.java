package cucumber.TheInternet.Steps;

import TheInternetPages.LoginPage;
import TheInternetPages.LoginSuccessPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 04/04/2016.
 */
public class LoginStepdefs {

    private String loginURL = "http://the-internet.herokuapp.com/login";
    private LoginPage loginPage;
    private String login;
    private String pass;
    private WebDriver driver;

    public LoginStepdefs() {
        driver = Hooks.driver;
    }

    @Given("^un usuario con credenciales incorrectas$")
    public void unUsuarioConCredencialesIncorrectas() throws Throwable {
        login = "fakeUser";
        pass = "fakePass";
    }

    @When("^intenta logarse$")
    public void intentaLogarse() throws Throwable {
        driver.get(loginURL);
        loginPage = new LoginPage(driver);

        loginPage.loginAs(login, pass);
    }

    @Then("^se muestra un mensaje de error$")
    public void seMuestraUnMensajeDeError() throws Throwable {
        WebElement mensajeError = loginPage.getMensajeError();
        assertTrue(mensajeError.isDisplayed(), "No se muestra el mensaje de login incorrecto");
        assertTrue(mensajeError.getText().startsWith("Your username is invalid!"), "El mensaje de error no muestra el texto esperado");
        assertTrue(driver.getCurrentUrl().endsWith("login"), "No estamos en la pagina de login");
    }


    @Given("^un usuario con credenciales correctas$")
    public void unUsuarioConCredencialesCorrectas() throws Throwable {
        login = "tomsmith";
        pass = "SuperSecretPassword!";
    }

    @Then("^accede a su seccion personal$")
    public void accedeASuSeccionPersonal() throws Throwable {
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);

        WebElement mensaje = loginSuccessPage.getMensaje();
        assertTrue(mensaje.isDisplayed(), "No se muestra el mensaje de login correcto");
        assertTrue(mensaje.getText().startsWith("You logged into a secure area!"), "El mensaje de exito no muestra el texto esperado");
        assertTrue(driver.getCurrentUrl().endsWith("secure"), "No estamos en la pagina segura");
    }
}
