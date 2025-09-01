package wearetests.web;

import com.weare.pages.LatestPostsPage;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import wearetests.core.AuthenticatedBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteTests extends AuthenticatedBaseWebTest {


    @Label("JIRA ID: SNT-93")
    @Test
    public void testDeleteComment(){
        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.exploreLatestPost();


        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.clickDeleteCommentsButton();
        WebElement dropdown = driver.findElement(By.id("StringListId"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Delete comment");

        latestPostsPage.clickConfirmDeletePostButton();

        WebElement confirmationMessage = driver.findElement(By.xpath("//h1[@class='mb-3 bread']"));
        String actualText = confirmationMessage.getText();
        assertEquals("Comment deleted successfully", actualText);
        System.out.println("Test for comment deletion passed.");
    }

    @Label("JIRA ID: SNT-94")
    @Test
    public void testDeletePost() {

        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.exploreLatestPost();
        latestPostsPage.clickDeletePostButton();

        WebElement dropdown = driver.findElement(By.id("StringListId"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Delete post");

        latestPostsPage.clickConfirmDeletePostButton();
        WebElement confirmationMessage = driver.findElement(By.xpath("//h1[@class='mb-3 bread']"));
        String actualText = confirmationMessage.getText();
        assertEquals("Post deleted successfully", actualText);
        System.out.println("Test for post deletion passed.");
    }
}
