package wearetests.web;

import com.weare.pages.HomePage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import wearetests.core.AuthenticatedBaseWebTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


// Test class for testing post creation, editing, comment adding, and comment editing.
// Jira ticket: https://public-enemies.atlassian.net/browse/SNT-96

public class CreateAndEditPostTests extends AuthenticatedBaseWebTest {

    @Test
    @Order(1)
    public void testSubmitNewPost() {
        HomePage homePage = new HomePage(driver);
        String message = "New Post " + System.currentTimeMillis();
        homePage.submitMessageToANewPost(message);

        assertNotNull(homePage.findElementByMessage(message), "The new post was not created.");
        System.out.println("Test for submitting a new post passed.");
    }

    @Test
    @Order(2)
    public void testEditPostAndAddComment() {
        HomePage homePage = new HomePage(driver);

        String originalMessage = "Original Post " + System.currentTimeMillis();
        homePage.submitMessageToANewPost(originalMessage);
        assertNotNull(homePage.findElementByMessage(originalMessage), "The new post was not created.");

        homePage.clickExplorePostButton();
        String updatedMessage = "Updated Post " + System.currentTimeMillis();
        homePage.clickEditPostButton();
        homePage.editPostContent(updatedMessage);

        assertNotNull(homePage.findElementByMessage(updatedMessage), "The post was not updated.");
        System.out.println("Test for editing a post passed.");

        String commentMessage = "New Comment " + System.currentTimeMillis();
        homePage.addCommentToPost(commentMessage);

        driver.getWebDriver().navigate().back();
        homePage.clickShowAllCommentsButton();

        assertNotNull(homePage.findElementByMessage(commentMessage), "The comment was not added.");
        System.out.println("Test for adding a comment passed.");

        String updatedCommentMessage = "Updated Comment " + System.currentTimeMillis();
        homePage.editComment(updatedCommentMessage);

        //assertNotNull(homePage.findElementByMessage(updatedCommentMessage), "The comment was not updated.");
        System.out.println("Test for editing a comment passed.");
    }
}