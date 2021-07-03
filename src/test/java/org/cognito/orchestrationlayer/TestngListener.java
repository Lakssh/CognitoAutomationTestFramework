package org.cognito.orchestrationlayer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cognito.corelayer.DriverFactory;
import org.cognito.orchestrationlayer.enums.Browser;
import org.cognito.orchestrationlayer.enums.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Map;

public class TestngListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        Logger Log = LogManager.getLogger("io.github.bonigarcia.wdm.WebDriverManager");
        Log.isEnabled(Level.ERROR);

        setTestParameters(result);
        WebDriver driver = DriverFactory.getWebDriver(TestParameters.getBrowser());
        DriverManager.getInstance().setDriver(driver);

    }

    public void setTestParameters(ITestResult result) {
        Map<String, String> allParameters = result.getTestContext().getCurrentXmlTest().getAllParameters();
        Browser browser = Browser.valueOf(allParameters.get("browser"));
        ExecutionMode executionMode = ExecutionMode.valueOf(allParameters.get("executionMode"));
        TestParameters.setBrowser(browser);
        TestParameters.setExecutionMode(executionMode);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
