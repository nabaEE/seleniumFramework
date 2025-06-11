package base;

import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
public class RemoteWebDriverTest {
        public static void main(String[] args) throws Exception {
            // Specify the URL of the Selenium Grid Hub
            String hubURL = "http://<hub-ip>:4444"; // Replace <hub-ip> with your Hub's IP

            // Set desired capabilities for the browser
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.valueOf("WINDOWS"));

            // Create RemoteWebDriver instance to connect to the Hub
            WebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);

            try {
                // Navigate to a website
                driver.get("https://example.com");

                // Perform actions (Example: Verify the page title)
                String pageTitle = driver.getTitle();
                System.out.println("Page Title: " + pageTitle);

                // Example: Interact with an element (if present)
                WebElement element = driver.findElement(By.tagName("h1"));
                System.out.println("Header Text: " + element.getText());
                Actions actions = new Actions(driver);
//                actions.keyDown(Keys.SHIFT).sendKeys("txt").keyUp(fdgdf).keyDown()

            } finally {
                // Close the browser
                driver.quit();
            }
        }
    }

