package TheInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by francisco.moreno on 03/02/2016.
 */
public class HomePage {

    //Using By locator for PageObject

    WebDriver driver;

    private By loginLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage(){

        driver.findElement(loginLink).click();

        return new LoginPage(this.driver);
    }
}
