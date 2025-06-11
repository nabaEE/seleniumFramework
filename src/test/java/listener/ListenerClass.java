package listener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.CommonMethods;

import java.io.IOException;

public class ListenerClass implements ITestListener  {


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        try {
            CommonMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        try {
            CommonMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
