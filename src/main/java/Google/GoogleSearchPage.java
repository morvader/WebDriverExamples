package Google;

import PageObject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class GoogleSearchPage extends BasePageObject {

    @FindBy(name = "q")
    protected WebElement searchField;

    @FindBy(id = "resultStats")
    WebElement resultStats;

    @FindBy(className = "rc")
    List<WebElement> results;

    public GoogleSearchPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String field){
        searchField.sendKeys(field);

        searchField.sendKeys(Keys.ENTER);
    }

    public String getResultText(int resultPosition){
        waitForVisibility(resultStats);

        WebElement posResult = results.get(resultPosition);

        return posResult.findElement(By.tagName("h3")).getText();
    }

    public String getLink(int resultPosition){

        waitForVisibility(resultStats);

        WebElement posResult = results.get(resultPosition);

        return posResult.findElement(By.className("_Rm")).getText();
    }

}
