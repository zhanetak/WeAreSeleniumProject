package wearetests.web;

import com.weare.pages.HomePage;
import org.junit.jupiter.api.Test;
import wearetests.core.AuthenticatedBaseWebTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomePageTests extends AuthenticatedBaseWebTest {

    @Test
    public void testSubmitNewPost() {
        HomePage homePage = new HomePage(driver);
        String message = "New Post " + System.currentTimeMillis();
        homePage.submitMessageToANewPost(message);

        assertNotNull(homePage.findElementByMessage(message), "The new post was not created.");
        System.out.println("Test for submitting a new post passed.");
    }
}