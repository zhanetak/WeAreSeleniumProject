package wearetests.web;

import com.weare.pages.LoginPage;
import com.weare.testframework.config.ConfigLoader;
import com.weare.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import wearetests.core.BaseWebTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterNewUserTests extends BaseWebTest {

    @Test
    public void testRegisterNewUser() {
        LoginPage loginPage = new LoginPage(driver);

        // Generate unique user credentials
        String uniqueUsername = TestDataGenerator.generateUniqueUsername();
        String email = ConfigLoader.get("fixedEmail", "" );
        String password = "Test123456";

        // Save credentials in the shared TestContext
        getTestContext().setUsername(uniqueUsername);
        getTestContext().setEmail(email);
        getTestContext().setPassword(password);

        // Perform the registration action
        loginPage.createNewUser(uniqueUsername, email, password);

        String welcomeMessage = loginPage.getWelcomeMessageText();
        assertEquals("Welcome to our community.", welcomeMessage,
                "The welcome message text did not match the expected value.");

        System.out.println("Registration test passed with username: " + uniqueUsername);
    }
}

