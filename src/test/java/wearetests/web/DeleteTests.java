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
    public void testDeletePost() {

        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.exploreLatestPost();
        latestPostsPage.clickDeletePostButton();

        // Locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("StringListId"));
        // Create a Select object
        Select select = new Select(dropdown);
        // Select "Delete post" by visible text
        select.selectByVisibleText("Delete post");

        latestPostsPage.clickConfirmDeletePostButton();
        // Locate the element
        WebElement confirmationMessage = driver.findElement(By.xpath("//h1[@class='mb-3 bread']"));
        // Get the text of the element
        String actualText = confirmationMessage.getText();
        // Assert that the text matches
        assertEquals("Post deleted successfully", actualText);
        System.out.println("Test for post deletion passed.");
    }
}
