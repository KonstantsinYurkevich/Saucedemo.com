package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utiles.AllureUtils;

public class TestListener implements ITestListener {
    //TODO CREATE TEST RUN USING API(ADD TEST CASES TOO)
    RemoteWebDriver driver;


    public void onStart(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
        driver = BaseTest.getDriver();
        System.out.println(String.format("Test started:%s", result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        AllureUtils.takeScreenshot(driver);
        System.out.println(String.format("Test Passed:%s", result.getName()));
    }

    //TODO API REQUEST TO SET STATUS OF TEST CASE
    public void onTestFailure(ITestResult result) {
        AllureUtils.takeScreenshot(driver);
        System.out.println(String.format("Test Failed:%s", result.getName()));
    }

    public void onFinish(ITestContext context) {
        System.out.println();
        System.out.println(String.format("++++++++++++Tests class run complete++++++++++++"));
    }

}
