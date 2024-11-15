package com.weare.testframework.core;

import com.weare.testframework.config.ConfigLoader;
import com.weare.testframework.enums.BrowserMode;
import com.weare.testframework.enums.BrowserType;

public class DriverManager {

    private static final ThreadLocal<Driver> driverThreadLocal = new ThreadLocal<>();

    public static Driver getDriver() {
        if (driverThreadLocal.get() == null) {
            driverThreadLocal.set(createDriver());
        }
        return driverThreadLocal.get();
    }

    private static Driver createDriver() {
        BrowserType browserType = ConfigLoader.getBrowserType();
        BrowserMode browserMode = ConfigLoader.getBrowserMode();
        int timeout = ConfigLoader.getTimeout();
        return new Driver(BrowserFactory.createBrowser(browserType, browserMode), timeout);
    }

    public static void quitDriver() {
        Driver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}