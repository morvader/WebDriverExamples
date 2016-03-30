package TheInternetPages;

import PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 30/03/2016.
 */
public class JavascriptAlertsPage extends BasePageObject {

    @FindBy(xpath = "(//button)[1]")
    WebElement jsAlertButton;

    @FindBy(xpath = "(//button)[2]")
    WebElement jsConfirmButton;

    @FindBy(xpath = "(//button)[3]")
    WebElement jsPromtButton;

    @FindBy(id = "result")
    WebElement result;

    public JavascriptAlertsPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnJsAlertButton() {
        jsAlertButton.click();
    }

    public void clickOnJsConfirmButton() {
        jsConfirmButton.click();
    }

    public void clickOnJsPromtButton() {
        jsPromtButton.click();
    }

    public Boolean isAlertPresent() {
        return isAlertPresent(5);
    }

    public String getResultText() {
        waitForVisibility(result);
        return result.getText();
    }

}
