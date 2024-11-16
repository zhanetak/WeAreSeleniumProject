package com.weare.pages;

import com.weare.utils.WebElementUtils;
import org.openqa.selenium.By;
import com.weare.testframework.core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static final By SIGN_IN_BUTTON = By.xpath("//*[@id='ftco-nav']/ul/li[2]/a");
    private static final By USERNAME_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.xpath("/html/body/section[1]/div/div/div[2]/form/input[3]");
    private static final By LOGOUT_BUTTON = By.xpath("//a[normalize-space()='LOGOUT']");
    private static final By REGISTER_BUTTON = By.xpath("//a[normalize-space()='REGISTER']");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("confirm");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@value='Register']");
    private static final By REGISTER_USERNAME_INPUT = By.id("name");
    private static final By SUCCESS_MESSAGE = By.cssSelector("h1.mb-3.bread"); // Replace with actual locator


    public LoginPage(Driver driver) {
        super(driver, "/");
    }

    public void login(String username, String password) {

        WebElementUtils.clickElement(driver.getWebDriver(), SIGN_IN_BUTTON, 10);
        WebElementUtils.sendKeys(driver.getWebDriver(), USERNAME_INPUT, username, 10);
        WebElementUtils.sendKeys(driver.getWebDriver(), PASSWORD_INPUT, password, 10);
        WebElementUtils.clickElement(driver.getWebDriver(), LOGIN_BUTTON, 10);
    }

    public boolean isLogoutButtonVisible() {
        return WebElementUtils.waitForElement(driver.getWebDriver(), LOGOUT_BUTTON, 10).isDisplayed();
    }
    public void createNewUser(String username, String email, String password) {
        // Navigate to the registration form
        driver.getWebDriver().findElement(REGISTER_BUTTON).click();

        // Fill in registration details
        driver.getWebDriver().findElement(REGISTER_USERNAME_INPUT).sendKeys(username);
        driver.getWebDriver().findElement(EMAIL_INPUT).sendKeys(email);
        driver.getWebDriver().findElement(PASSWORD_INPUT).sendKeys(password);
        driver.getWebDriver().findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);

        // Submit the registration form
        driver.getWebDriver().findElement(SUBMIT_BUTTON).click();
    }
    public String getWelcomeMessageText() {
        WebElement element = driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE));
        return element.getText();
    }
}

