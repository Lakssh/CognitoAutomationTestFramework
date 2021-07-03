package org.cognito.corelayer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.cognito.orchestrationlayer.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DriverFactory {

    public static WebDriver getWebDriver(Browser browser) {
        WebDriver driver = null;
        switch(browser){

            case CHROME:
                WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--silent");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                ChromeOptions chOptions = new ChromeOptions();
                chOptions.addArguments("--headless");
                chOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chOptions);
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
                Assert.fail("Web Driver not initialized");
        }

        return driver;
    }

    public static WebDriver setRemoteWebDriver() {
        //Yet to be defined
        WebDriver driver = null;
        return driver;
    }

    public static WebDriver setMobileWebDriver() {
        //Yet to be defined
        WebDriver driver = null;
        return driver;
    }
}
