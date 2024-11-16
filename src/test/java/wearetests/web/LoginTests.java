package wearetests.web;

import com.weare.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import wearetests.core.BaseWebTest;
import wearetests.enums.WEAreTestData;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseWebTest {

    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                WEAreTestData.STANDARD_USER_PASSWORD.getValue()
        );

        assertTrue(loginPage.isLogoutButtonVisible(),
                "The login action did not result in the LOGOUT button being visible.");
        System.out.println("Test for valid login passed.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invaliduser", "wrongpassword");

        assertTrue(Objects.requireNonNull(driver.getWebDriver().getCurrentUrl()).contains("login?error"),
                "The invalid login did not show the expected error.");
        System.out.println("Test for invalid login passed.");
    }
}


