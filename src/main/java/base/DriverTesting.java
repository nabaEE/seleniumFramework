package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DriverTesting {
    static WebDriver driver=null;

    public static WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        return null;
    }

    public static void main(String[] args) {
        driver = DriverTesting.getDriver("Chrome");
        assert driver != null;
        driver.get("https://www.yahoo.com");
        System.out.println("Browser has launched successfully");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[name='p']")).sendKeys("Hello");
        driver.findElement(By.id("ybar-search")).click();
        Set<String> allSessions = driver.getWindowHandles();
        String parentWin = driver.getWindowHandle();
        for (String allSession : allSessions) {
            if (!allSession.equals(parentWin)) {
                driver.switchTo().window(allSession);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                String title= driver.getTitle();
                System.out.println("My title is :"+title);
                WebElement myValue = driver.findElement(By.cssSelector("input[id='yschsp']"));
                DriverTesting.verifyElementToVisible(myValue, 20);
                String valueText= myValue.getAttribute("value");
                System.out.println(valueText);
                driver.close();
            }
        }
        driver.switchTo().window(parentWin);
        System.out.println("Parent window title is "+driver.getTitle());

//        driver.quit();
    }

    public static void verifyElementToVisible(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
