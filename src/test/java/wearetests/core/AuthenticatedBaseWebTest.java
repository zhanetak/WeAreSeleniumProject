package wearetests.core;

import com.weare.pages.LoginPage;
import jdk.jfr.Label;
import org.junit.jupiter.api.BeforeEach;
import wearetests.enums.WEAreTestData;
import io.qameta.allure.Allure;

public abstract class AuthenticatedBaseWebTest extends BaseWebTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        authenticateUser();
    }

    protected void authenticateUser() {
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Logging in as a standard user", () -> {
            loginPage.login(
                    WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                    WEAreTestData.STANDARD_USER_PASSWORD.getValue()
            );
        });

        Allure.step("User authenticated successfully.");
        System.out.println("User authenticated successfully.");
    }
}