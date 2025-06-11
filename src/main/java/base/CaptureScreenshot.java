package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
   static WebDriver driver=null;
    public static void LaunchBrowser() throws IOException {
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        CaptureScreenshot.getScreenshot();
    }
    public static void getScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile= screenshot.getScreenshotAs(OutputType.FILE);
        File destFile= new File("C:\\Users\\Naba\\IdeaProjects\\HybridTestAutomation\\screenshot\\screenshot.png");
        FileUtils.copyFile(scrFile, destFile);
    }

    public static void main(String[] args) throws IOException {
        CaptureScreenshot.LaunchBrowser();
    }

}

