package com.weare.pages;


import com.weare.utils.WebElementUtils;
import org.openqa.selenium.By;
import com.weare.testframework.core.Driver;
import org.openqa.selenium.WebElement;

public class LatestPostsPage extends BasePage {

    private static final By LATEST_POST = By.xpath("(//div[@class='col-md-12'])[1]");
    private static final By LIKE_BUTTON = By.className("fa-heart");
    private static final By COMMENT_INPUT = By.xpath("//textarea[@id='message']");
    private static final By POST_COMMENT_BUTTON = By.xpath("//input[@value='Post Comment']");
    private static final By EXPLORE_POST_BUTTON = By.linkText("Explore this post");
    private static final By DELETE_POST_BUTTON = By.xpath("//a[text()='Delete post']");
    private static final By CONFIRM_DELETE_BUTTON = By.xpath("//input[@value='Submit']");


    public LatestPostsPage(Driver driver) {
        super(driver, "/posts");
    }

    public void navigate() {
        super.navigate();
    }

    public void likeLatestPost() {
        WebElement latestPostElement = driver.findElement(LATEST_POST);
        WebElement likeButton = latestPostElement.findElement(LIKE_BUTTON);
        likeButton.click();
    }

    public void commentOnPost(String comment) {
        WebElement latestPostElement = driver.findElement(LATEST_POST);
        WebElement exploreThisPostElement = latestPostElement.findElement(EXPLORE_POST_BUTTON);
        exploreThisPostElement.click();

        WebElementUtils.sendKeys(driver.getWebDriver(), COMMENT_INPUT, comment, 10);
        WebElementUtils.clickElement(driver.getWebDriver(), POST_COMMENT_BUTTON, 10);
    }

    public void exploreLatestPost() {
        WebElement latestPostElement = driver.findElement(LATEST_POST);
        WebElement exploreThisPostElement = latestPostElement.findElement(EXPLORE_POST_BUTTON);
        exploreThisPostElement.click();
    }

    // New: Dynamically returns the locator for the latest post
    public By getLatestPostLocator() {
        return LATEST_POST;
    }

    // New: Dynamically returns the locator for a comment containing the specified text
    public By getCommentLocator(String comment) {
        return By.xpath(String.format("//*[contains(text(), '%s')]", comment));
    }
    public void clickDeletePostButton() {
        WebElement deletePostButton = driver.findElement(DELETE_POST_BUTTON);
        deletePostButton.click();
    }
    public void clickConfirmDeletePostButton() {
        WebElement confirmDeletePostButton = driver.findElement(CONFIRM_DELETE_BUTTON);
        confirmDeletePostButton.click();
    }
}


