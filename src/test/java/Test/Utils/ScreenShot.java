package Test.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Moreno on 07/02/2016.
 */
public class ScreenShot{

    static public void takeScreenShot(String fileName, WebDriver driver) throws IOException {

        fileName += "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());

        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./Screenshots/"+ fileName +".png"));
    }
}
