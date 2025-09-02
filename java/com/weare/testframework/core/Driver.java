package com.weare.testframework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Driver {

    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private final Actions actions;

    public Driver(WebDriver driver, int timeoutSeconds) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        this.actions = new Actions(driver);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    public void click(By locator) {
        WebElement element = findElement(locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
    }

    public void quit() {
        webDriver.quit();
    }
}
