package wearetests.core;

import com.weare.pages.LoginPage;
import jdk.jfr.Label;
import org.junit.jupiter.api.BeforeEach;
import wearetests.enums.WEAreTestData;

public abstract class AuthenticatedBaseWebTest extends BaseWebTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        authenticateUser();
    }

    protected void authenticateUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                WEAreTestData.STANDARD_USER_PASSWORD.getValue()
        );
        System.out.println("User authenticated successfully.");
    }
}

