package com.weare.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtils {
    public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickElement(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = waitForElement(driver, locator, timeoutInSeconds);
        element.click();
    }

    public static void sendKeys(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        WebElement element = waitForElement(driver, locator, timeoutInSeconds);
        element.sendKeys(text);
    }

    public static String getText(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = waitForElement(driver, locator, timeoutInSeconds);
        return element.getText();
    }
}

