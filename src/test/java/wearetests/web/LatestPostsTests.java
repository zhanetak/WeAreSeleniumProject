package wearetests.web;

import com.weare.pages.LatestPostsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import wearetests.core.AuthenticatedBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LatestPostsTests extends AuthenticatedBaseWebTest {

    @Test
    public void testLikeLatestPost() {
        LatestPostsPage latestPostsPage = new LatestPostsPage(driver);
        latestPostsPage.navigate();
        latestPostsPage.likeLatestPost();

        //Assert!
        //TODO

//        assertNotNull(driver.getWebDriver().findElement(latestPostsPage.getLatestPostLocator()),
//                "The like action was not performed on the latest post.");
//        System.out.println("Test for liking the latest post passed.");
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

        //TODO
    }
}


