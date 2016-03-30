package PageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by francisco.moreno on 30/03/2016.
 */
public class BasePageObject {

    protected WebDriver driver;

    public void waitForElementClickable(WebElement webElement, Integer... timeout) {
        int timeOut = timeout.length > 0 ? timeout[0] : 10;
        waitForCondition(ExpectedConditions.elementToBeClickable(webElement), timeOut);

    }

    public void waitForVisibility(WebElement webElement, Integer... timeout) {
        int timeOut = timeout.length > 0 ? timeout[0] : 10;
        waitForCondition(ExpectedConditions.visibilityOf(webElement), timeOut);
    }

    public Boolean isElementPresent(WebElement webElement, Integer... timeout) {
        try {
            waitForVisibility(webElement, timeout);
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    private void waitForCondition(ExpectedCondition<WebElement> condition, int timeOut) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
        wait.until(condition);
    }
}
