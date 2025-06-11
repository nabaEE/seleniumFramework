package base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorTest {

    public static void testExecutor(){
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://www.selenium.dev/");
        WebElement element= driver.findElement(By.xpath("//a[text()='Open Collective']"));
        driver.manage().window().maximize();
        JavascriptExecutor executor= (JavascriptExecutor) driver;
       executor.executeScript("arguments[0].scrollIntoView(true);", element);
//        executor.executeScript("window.scrollBy(0,1000);");
        executor.executeScript("arguments[0].click();",element);

        String eText= element.getText();
        System.out.println(eText);
       // driver.quit();
    }

    public static void main(String[] args) {
        JavascriptExecutorTest.testExecutor();
    }
}


