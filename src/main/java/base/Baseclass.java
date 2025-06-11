package base;
import org.openqa.selenium.WebDriver;

public class Baseclass extends DriverCall {
    public void initiateBrowser(String browser) {
        DriverCall.setBrowser(browser); // Set the browser name dynamically
        WebDriver driver = DriverCall.getDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        DriverCall.removeDriver();
    }

}