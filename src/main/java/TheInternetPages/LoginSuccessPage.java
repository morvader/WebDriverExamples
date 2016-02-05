package TheInternetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 03/02/2016.
 */
public class LoginSuccessPage {

    WebDriver driver;

    @FindBy (css=".flash.success")
    private WebElement mensajeExito;

    @FindBy (css=".button.secondary.radius")
    private WebElement logOutButton;

    public LoginSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOut(){
        logOutButton.click();
    }

    public WebElement getMensaje(){
        return mensajeExito;
    }
}
