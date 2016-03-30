package TheInternetPages;

import PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class DynamicControlsPage extends BasePageObject {

    @FindBy(id = "btn")
    WebElement btn;

    @FindBy(id = "checkbox")
    WebElement checkbox;

    @FindBy(id = "message")
    WebElement mensaje;

    public DynamicControlsPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickButton(){
        btn.click();
    }

    public String getMensaje(){
        waitForVisibility(mensaje);
        return mensaje.getText();
    }

    public boolean isCheckBoxPresent(){
        return isElementPresent(checkbox, 5);
    }
}
