package com.weare.pages;

import com.weare.utils.WebElementUtils;
import org.openqa.selenium.By;
import com.weare.testframework.core.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final By ADD_NEW_POST_BUTTON = By.xpath("//*[@id='ftco-nav']/ul/li[8]/a");
    private static final By MESSAGE_FIELD = By.id("message");
    private static final By SAVE_POST_BUTTON = By.xpath("/html/body/section[1]/div/div/div/div/ul/div/form/div[3]/input");
    private static final By EXPLORE_POST_BUTTON = By.linkText("Explore this post");
    private static final By EDIT_POST_BUTTON = By.xpath("//a[text()='Edit post']");
    private static final By EDIT_POST_TEXTBOX = By.xpath("//textarea[@id='message']");
    private static final By COMMENT_TEXT_AREA = By.xpath("//textarea[@id='message']"); // Adjust if different
    private static final By POST_NEW_COMMENT_BUTTON = By.xpath("//input[@value='Post Comment']");
    private static final By SHOW_ALL_COMMENTS_BUTTON = By.xpath("//button[text()='Show Comments']");
    private static final By EDIT_COMMENT_BUTTON = By.xpath("//a[text()='Edit comment']");
    private static final By EDIT_COMMENT_TEXTBOX = By.xpath("//textarea[@id='message']"); // Adjust if different
    private static final By EDIT_COMMENT_SUBMIT_BUTTON = By.xpath("//input[@value='Edit Comment']");



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

    public void clickExplorePostButton() {
        WebElementUtils.clickElement(driver.getWebDriver(), EXPLORE_POST_BUTTON, 10);
    }

    public void clickEditPostButton() {
        WebElementUtils.clickElement(driver.getWebDriver(), EDIT_POST_BUTTON, 10);
    }

    public void editPostContent(String newContent) {
        WebElement editTextbox = WebElementUtils.waitForElement(driver.getWebDriver(), EDIT_POST_TEXTBOX, 10);
        editTextbox.clear();
        editTextbox.sendKeys(newContent);
        WebElementUtils.clickElement(driver.getWebDriver(), SAVE_POST_BUTTON, 10);
    }

    public void addCommentToPost(String comment) {
        WebElementUtils.sendKeys(driver.getWebDriver(), COMMENT_TEXT_AREA, comment, 10);
        WebElementUtils.clickElement(driver.getWebDriver(), POST_NEW_COMMENT_BUTTON, 10);
    }

    public void clickShowAllCommentsButton() {
        WebElement showComments = driver.findElement(SHOW_ALL_COMMENTS_BUTTON);
        showComments.click();
    }

    public void editComment(String updatedComment) {
        WebElementUtils.clickElement(driver.getWebDriver(), EDIT_COMMENT_BUTTON, 10);
        WebElementUtils.sendKeys(driver.getWebDriver(), EDIT_COMMENT_TEXTBOX, updatedComment, 10);
        WebElementUtils.clickElement(driver.getWebDriver(), EDIT_COMMENT_SUBMIT_BUTTON, 10);
    }
}
