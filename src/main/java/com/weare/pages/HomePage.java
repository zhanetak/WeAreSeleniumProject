package com.weare.pages;

import com.weare.utils.WebElementUtils;
import org.openqa.selenium.By;
import com.weare.testframework.core.Driver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final By ADD_NEW_POST_BUTTON = By.xpath("//*[@id='ftco-nav']/ul/li[8]/a");
    private static final By MESSAGE_FIELD = By.id("message");
    private static final By SAVE_POST_BUTTON = By.xpath("/html/body/section[1]/div/div/div/div/ul/div/form/div[3]/input");

    public HomePage(Driver driver) {
        super(driver, "/"); // Pass driver and the specific page URL
    }


    public void submitMessageToANewPost(String message) {
        WebElementUtils.clickElement(driver.getWebDriver(), ADD_NEW_POST_BUTTON, 10);
        WebElementUtils.sendKeys(driver.getWebDriver(), MESSAGE_FIELD, message, 10);
        WebElementUtils.clickElement(driver.getWebDriver(), SAVE_POST_BUTTON, 10);
    }

    public WebElement findElementByMessage(String message) {
        By messageLocator = By.xpath(String.format("//*[contains(text(), '%s')]", message));
        return WebElementUtils.waitForElement(driver.getWebDriver(), messageLocator, 10);
    }
}

