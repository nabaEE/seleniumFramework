package tests;

import base.Baseclass;
import base.DriverCall;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.CommonMethods;
import utilities.Locators;

public class LoginPageTest extends Baseclass {

    Baseclass baseclass;
    CommonMethods commonMethods;
    Locators locators;
    @Parameters("browser")
    @BeforeMethod
    public void browserLaunchForEachTest(String browser){
        baseclass= new Baseclass();
        baseclass.initiateBrowser(browser);
        commonMethods= new CommonMethods();
        locators = new Locators();
        System.out.println("URL loaded");
    }

    @AfterMethod
    public void closeBrowser(){
    baseclass.closeBrowser();
    }

    @Test
    public void verifyTitle(){
     String title=   DriverCall.getDriver().getTitle();
     System.out.println("The title is :"+title);
    }

    @Test
    public void checkDashboardUrl(){
        String cUrl= DriverCall.getDriver().getCurrentUrl();
        Assert.assertEquals(cUrl,"https://www.selenium.dev/");
        System.out.println("The title is :"+cUrl);
    }

    @Test
    public void verifyPageHeading(){
       String pagePara=commonMethods.getElement(locators.pageHeadingLoc).getText();
        Assert.assertEquals(pagePara,"Selenium automates browsers. That's it!");
        System.out.println(pagePara);
    }
}
