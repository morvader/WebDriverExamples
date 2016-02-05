package TheInternetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 03/02/2016.
 */
public class LoginPage {

    WebDriver driver;

    @FindBy (id="username")
    private WebElement usernameInput;

    @FindBy (id="password")
    private WebElement passwordInput;

    @FindBy (xpath=".//*[@id=\'login\']/button")
    private WebElement loginButton;

    @FindBy (css=".flash.error")
    private WebElement mensajeError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String user, String pass){
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);

        loginButton.click();
    }

    public WebElement getMensajeError(){
        return mensajeError;
    }
}
