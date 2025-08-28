package favbet.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

    public static String takeScreenshot(WebDriver driver, String methodName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String relativePath = "screenshots/" + methodName + "_" + timestamp + ".png";
        String fullPath = System.getProperty("user.dir") + File.separator + relativePath;

        new File(System.getProperty("user.dir") + File.separator + "screenshots").mkdirs();
        FileUtils.copyFile(srcFile, new File(fullPath));

        return relativePath;
    }
}
