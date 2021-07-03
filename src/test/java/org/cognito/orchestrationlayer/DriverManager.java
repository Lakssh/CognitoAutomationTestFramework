package org.cognito.orchestrationlayer;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {
    }

    private final static DriverManager instance = new DriverManager();

    public static DriverManager getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public WebDriver getDriver() {
        return DriverManager.driver.get();
    }

    public void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
