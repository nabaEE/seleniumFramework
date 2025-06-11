package utilities;

import base.DriverCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}