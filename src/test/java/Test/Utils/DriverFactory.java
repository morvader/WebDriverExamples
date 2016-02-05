package Test.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by francisco.moreno on 04/02/2016.
 */


public class DriverFactory {

    public enum Browsers {FIREFOX, CHROME}

    static String remoteURL = "http://192.168.99.100:32769/wd/hub";

    public static WebDriver getDriver(Browsers browser) throws MalformedURLException {
        boolean remote = checkRemoteExecution();

        switch (browser) {
            case FIREFOX:
                if (remote)
                    return new RemoteWebDriver(new URL(remoteURL),
                            DesiredCapabilities.firefox());
                return new FirefoxDriver();
            case CHROME:
                if (remote)
                    return new RemoteWebDriver(new URL(remoteURL),
                            DesiredCapabilities.chrome());
                else {
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                    return new ChromeDriver();
                }
            default:
                return null;
        }

    }

    private static boolean checkRemoteExecution() {
        String remoto = System.getProperty("remoto");
        boolean remoteDriver = false;
        if (remoto == null || remoto.isEmpty()) {
            remoteDriver = false;
        } else if (remoto.equals("si"))
            remoteDriver = true;

        return remoteDriver;
    }
}
