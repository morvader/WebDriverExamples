package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public class GoogleSearchImagesPage extends GoogleSearchPage{

    @FindBy(partialLinkText = "Im")
    WebElement imagenesLink;

    @FindBy(xpath = ".//*[@id=\'rg_s\']/div")
    List<WebElement> results;

    @FindBy (id = "irc_ra")
    WebElement navigateNextImage;

    @FindBy (id = "irc_la")
    WebElement navigatePreviousImage;

    @FindBy(linkText = "Visitar página")
    WebElement visitPage;

    public GoogleSearchImagesPage(WebDriver driver) {
        super(driver);
    }

    public void gotoImages(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(imagenesLink));
        imagenesLink.click();
    }

    public void clickOnNImagen(int imagePos){
        WebElement imagen = results.get(imagePos);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(imagen));

        imagen.click();
    }

    public void navigateNextImage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(navigateNextImage));
        navigateNextImage.click();
    }

    public void navigatePreviousImage(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(navigatePreviousImage));
        navigatePreviousImage.click();
    }

    public void visitCurrentImagePage(){
        visitPage.click();
    }
}
