package wearetests.core;

import com.weare.pages.LoginPage;
import com.weare.testframework.config.ConfigLoader;
import com.weare.testframework.core.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import wearetests.enums.WEAreTestData;

public abstract class AuthenticatedBaseWebTest extends BaseWebTest {

    @Override
    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver(); // Fetch driver from DriverManager
        driver.getWebDriver().get(ConfigLoader.getBaseUrl());
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

