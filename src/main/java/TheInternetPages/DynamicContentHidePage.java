package TheInternetPages;

import PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 04/02/2016.
 */
public class DynamicContentHidePage extends BasePageObject {

    @FindBy(xpath = "//button")
    private WebElement starButton;

    @FindBy(xpath = "//div[@id=\'finish\']/h4")
    private WebElement hiddenMessage;


    public DynamicContentHidePage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStart(){
        starButton.click();
    }

    public String getHiddenMessage(){

        waitForVisibility(hiddenMessage);

        String mensaje = hiddenMessage.getText();

        return mensaje;
    }
}
