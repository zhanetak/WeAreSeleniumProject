package com.weare.pages;

import com.weare.testframework.config.ConfigLoader;
import com.weare.testframework.core.Driver;

public abstract class BasePage {
    protected final Driver driver;
    private final String pageUrl;

    public BasePage(Driver driver, String pageUrl) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null.");
        }
        this.driver = driver;
        this.pageUrl = pageUrl;
    }

    public void navigate() {
        if (driver.getWebDriver() == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        driver.getWebDriver().get(getBasePageUrl() + pageUrl);
    }

    public String getBasePageUrl() {
        return ConfigLoader.getBaseUrl();
    }
}
