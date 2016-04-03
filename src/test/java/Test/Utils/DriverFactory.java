package Test.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by francisco.moreno on 04/02/2016.
 */


public class DriverFactory {

    public enum Browsers {FIREFOX, CHROME}

    static String remoteURL = "http://192.168.99.100:32769/wd/hub";

    //static String remoteURL = "http://localhost:4444/wd/hub";

    public static WebDriver getDriver(Browsers browser) throws MalformedURLException {
        boolean remote = checkRemoteExecution();

        switch (browser) {
            case FIREFOX:
                if (remote)
                    return new RemoteWebDriver(new URL(remoteURL),
                            DesiredCapabilities.firefox());
                return new FirefoxDriver(getFirefoxProfile());
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

    public static String getDownloadsPath() {
        String property = "java.io.tmpdir";
        String tempDir = System.getProperty(property);

        //Path currentRelativePath = Paths.get("");
        //File file1 = new File(currentRelativePath.toAbsolutePath().toString());
        File file1 = new File(tempDir);
        File file2 = new File(file1, "/testDownloads");
        return file2.getPath();
    }

    private static FirefoxProfile getFirefoxProfile() {

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", getDownloadsPath());
        profile.setPreference("browser.helperApps.neverAsk.openFile",
                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg," +
                        "text/html,text/plain,application/msword,application/xml,application/octet-stream," +
                        "application/x-unknown,binary/octet-stream, application/binary,");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg," +
                        "text/html,text/plain,application/msword,application/xml,application/octet-stream," +
                        "application/x-unknown,binary/octet-stream, application/binary,");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", true);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("pdfjs.disabled", true);

        return profile;
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
