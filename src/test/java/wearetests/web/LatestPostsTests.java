package wearetests.web;

import com.weare.pages.LatestPostsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import wearetests.core.AuthenticatedBaseWebTest;

import static org.junit.jupiter.api.Assertions.*;

public class LatestPostsTests extends AuthenticatedBaseWebTest {
    @Test
    public void testLikeLatestPost() {
        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.likeLatestPost();

        //Assert
        WebElement likeButton = driver.findElement(latestPostsPage.getLatestPostLocator()).findElement(latestPostsPage.getLikeButtonLocator());
        assertNotNull(likeButton, "The like button was not found.");

        String likeButtonValue = likeButton.getDomProperty("value");
        assertEquals("Dislike", likeButtonValue, "The like button did not change to 'Dislike' after liking the post.");

        System.out.println("Test for liking the latest post passed.");
    }

    @Test
    public void testCommentOnLatestPost() {
        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        String comment = "This is a test comment " + System.currentTimeMillis();
        latestPostsPage.commentOnPost(comment);

        assertNotNull(driver.getWebDriver().findElement(latestPostsPage.getCommentLocator(comment)),
                "The comment was not posted on the latest post.");
        System.out.println("Test for commenting on the latest post passed.");
    }

    @Test
    public void testLikeComment(){
        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.exploreLatestPost();

        //Act
        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.clickLikeCommentsButton();

        //Assert
        String buttonValue = latestPostsPage.getCommentLikeButtonValue();
        assertEquals("Dislike", buttonValue, "The like button for the comment did not change to 'Dislike'.");

        System.out.println("Test for verifying the comment like button passed.");
    }
}


