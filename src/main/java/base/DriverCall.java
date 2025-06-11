package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverCall {
    private static final ThreadLocal<String> browserName = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static WebDriver getDriver() {
        if (threadDriver.get() == null) {
            String browser = browserName.get();
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                threadDriver.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                threadDriver.set(new EdgeDriver());
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return threadDriver.get();
    }

    public static void removeDriver() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
            browserName.remove();
        }
    }
}
