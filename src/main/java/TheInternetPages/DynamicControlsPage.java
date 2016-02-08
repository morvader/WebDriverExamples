package TheInternetPages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class DynamicControlsPage {

    WebDriver driver;

    @FindBy(id = "btn")
    WebElement btn;

    @FindBy(id = "checkbox")
    WebElement checkbox;

    @FindBy(id = "message")
    WebElement mensaje;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickButton(){
        btn.click();
    }

    public String getMensaje(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(mensaje));
        return mensaje.getText();
    }

    public boolean isCheckBoxPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.visibilityOf(checkbox));
            return true;
        }catch (TimeoutException to){
            return false;
        }
    }
}
