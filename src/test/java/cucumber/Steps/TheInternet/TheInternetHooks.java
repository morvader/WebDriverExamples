package cucumber.Steps.TheInternet;

import Test.Utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

/**
 * Created by francisco.moreno on 04/04/2016.
 */
public class TheInternetHooks {

    public static WebDriver driver;

    @Before
    public void openBrowser() throws MalformedURLException {
        System.out.println("Browser Init");
        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();

    }
}
