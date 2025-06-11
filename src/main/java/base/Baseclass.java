package base;
import org.openqa.selenium.WebDriver;

public class Baseclass extends DriverCall {
    WebDriver driver = DriverCall.getDriver();
    public void initiateBrowser() {
        // Setup WebDriver based on browserName
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        DriverCall.removeDriver();
    }

}