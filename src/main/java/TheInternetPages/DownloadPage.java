package TheInternetPages;

import PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by francisco.moreno on 30/03/2016.
 */
public class DownloadPage extends BasePageObject {

    @FindBy(css = ".example>a")
    WebElement downloadLink;

    public DownloadPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadLink() {
        downloadLink.click();
    }

    public String getFileName() {
        return downloadLink.getText();
    }
}
