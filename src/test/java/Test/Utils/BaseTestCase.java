package Test.Utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by francisco.moreno on 08/02/2016.
 */
public abstract class BaseTestCase {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }
}
