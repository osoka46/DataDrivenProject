package utilities;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


public class TestUtil extends TestBase {
    public static String screenShotPath;


    public static String captureScreenShot(String testCaseName) {
        LocalDateTime dateTime=LocalDateTime.now();
        testCaseName=dateTime.withNano(0).toString()+testCaseName;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/src/test/java/screenShots/" + testCaseName + ".png";


        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseName;

    }

    public static boolean isTestRunnable(String testName, ExcelReader reader)
    {
        //check from RunMode sheet if test case should run, then check on listener class on test start method if this method return true.
        return true;
    }

   /* public static void captureScreenShot(String testCaseName, WebDriver driver) {


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String destinationFile = System.getProperty("user.dir") + "/src/test/java/screenShotReports/" + testCaseName + ".png";
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}
