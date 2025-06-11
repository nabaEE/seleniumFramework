package utilities;

import base.DriverCall;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonMethods {

    public WebElement getElement(By by){

        WebDriverWait wait = new WebDriverWait(DriverCall.getDriver(), Duration.ofSeconds(20));
        WebElement element= wait.until(ExpectedConditions.visibilityOf(
                DriverCall.getDriver().findElement(by)));
        if(!element.isDisplayed()){
            wait.pollingEvery(Duration.ofSeconds(2));
            return element;
        }
        return element;
    }

    public static void getScreenshot(String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) DriverCall.getDriver();
        File scrFile= screenshot.getScreenshotAs(OutputType.FILE);
        File destFile= new File("C:\\Users\\Naba\\IdeaProjects\\HybridTestAutomation\\screenshot\\"+fileName+".png");
        FileUtils.copyFile(scrFile, destFile);
    }
}