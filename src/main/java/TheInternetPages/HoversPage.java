package TheInternetPages;

import PageObject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class HoversPage extends BasePageObject {

    @FindBy(xpath = "//div[@class=\'figure\']")
    List<WebElement> users;

    public HoversPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void hoverUser(int userPosition){
        WebElement user = users.get(userPosition);
        Actions action = new Actions(driver);
        action.moveToElement(user).perform();
    }


    public String getUserName(int userPosition){

        WebElement user = users.get(userPosition);
        this.hoverUser(userPosition);

        return user.findElement(By.className("figcaption")).findElement(By.tagName("h5")).getText();
    }

}
