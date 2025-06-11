package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverCall {
    // ThreadLocal for WebDriver instance
   static String browserName= "Chrome";
    private static final ThreadLocal<WebDriver> threadDriver = ThreadLocal.withInitial(() -> {
       if(browserName.equalsIgnoreCase("Chrome")) {
           WebDriverManager.chromedriver().setup();
           return new ChromeDriver();
       } else if(browserName.equalsIgnoreCase("edge")){
           WebDriverManager.edgedriver().setup();
           return new EdgeDriver();
       }
        return new ChromeDriver();
    });

    // Getter method to access the WebDriver instance
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    // Clean up WebDriver instance for the thread
    public static void removeDriver() {
        threadDriver.get().quit();
        threadDriver.remove();
    }
}