package TheInternetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by francisco.moreno on 04/02/2016.
 */
public class DynamicContentHidePage {
    WebDriver driver;

    @FindBy(xpath = "//button")
    private WebElement starButton;

    @FindBy(xpath = "//div[@id=\'finish\']/h4")
    private WebElement hiddenMessage;


    public DynamicContentHidePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStart(){
        starButton.click();
    }

    public String getHiddenMessage(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hiddenMessage));

        String mensaje = hiddenMessage.getText();

        return mensaje;
    }
}
