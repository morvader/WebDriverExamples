package TheInternetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Moreno on 07/02/2016.
 */
public class JQueryUIPage {

    WebDriver driver;

    @FindBy(id = "ui-id-2")
    WebElement enabledMenuElement;

    @FindBy(id = "ui-id-5")
    WebElement backtoJQueryMenu;

    @FindBy(id = "ui-id-4")
    WebElement donwloadsElement;

    @FindBy(id = "ui-id-7")
    WebElement downloadCSV;


    public JQueryUIPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void backToJQueryMenu() {
        Actions action = new Actions(driver);

        action.moveToElement(enabledMenuElement).perform();

        backtoJQueryMenu.click();
    }

    public void downloadCSV() {
        Actions action = new Actions(driver);

        action.moveToElement(enabledMenuElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(donwloadsElement));

        action.moveToElement(donwloadsElement).perform();

        wait.until(ExpectedConditions.elementToBeClickable(downloadCSV));

        downloadCSV.click();
    }
}
