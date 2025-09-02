package com.weare.testframework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.weare.testframework.enums.BrowserMode;
import com.weare.testframework.enums.BrowserType;

public class BrowserFactory {
    public static WebDriver createBrowser(BrowserType browserType, BrowserMode browserMode) {
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (browserMode == BrowserMode.HEADLESS) chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserMode == BrowserMode.HEADLESS) firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                if (browserMode == BrowserMode.HEADLESS) edgeOptions.addArguments("--headless");
                return new EdgeDriver(edgeOptions);
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }
}

