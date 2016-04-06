package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        waitForElementClickable(imagenesLink);
        imagenesLink.click();
    }

    public void clickOnNImagen(int imagePos){
        WebElement imagen = results.get(imagePos);

        waitForElementClickable(imagen);

        imagen.click();
    }

    public void navigateNextImage(){
        waitForElementClickable(navigateNextImage);
        navigateNextImage.click();
    }

    public void navigatePreviousImage(){

        waitForElementClickable(navigatePreviousImage);
        navigatePreviousImage.click();
    }

    public void visitCurrentImagePage(){
        waitForElementClickable(visitPage);
        visitPage.click();
    }
}
