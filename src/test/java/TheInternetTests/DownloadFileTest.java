package TheInternetTests;

import Test.Utils.BaseTestCase;
import Test.Utils.DriverFactory;
import TheInternetPages.DownloadPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

/**
 * Created by francisco.moreno on 30/03/2016.
 */
public class DownloadFileTest extends BaseTestCase {

    @BeforeMethod
    public void setUp() throws Exception {
        //Borramos el contenido del directorio
        deleteFiles(new File(DriverFactory.getDownloadsPath()));

        driver = DriverFactory.getDriver(DriverFactory.Browsers.FIREFOX);
        driver.get("http://the-internet.herokuapp.com/download");
    }

    @Test
    public void testDownloadFile() throws Exception {
        DownloadPage downloadPage = new DownloadPage(driver);
        String downloadPath = DriverFactory.getDownloadsPath();

        String downloadFileName = downloadPage.getFileName();

        downloadPage.clickDownloadLink();

        //Esperar a que el fichero termine de decarcarse
        Thread.sleep(10000);

        //Comprobar que el fichero existe y está en la ruta especificada
        File f = new File(downloadPath, downloadFileName);

        System.out.println("Comprobar fichero en: " + f.getAbsolutePath());

        assertTrue(f.exists() && !f.isDirectory(), "El fichero no existe en la ruta especificada");
        assertTrue(f.length() > 0, "El fichero esta vacio");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        driver.quit();
    }

    private void deleteFiles(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();

                }
            }
        }
    }
}
