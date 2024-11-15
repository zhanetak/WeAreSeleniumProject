package wearetests.core;

import com.weare.testframework.config.ConfigLoader;
import com.weare.testframework.core.Driver;
import com.weare.testframework.core.DriverManager;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseWebTest {

    @Getter
    protected static final TestContext testContext = new TestContext(); // Shared context
    protected Driver driver;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up driver...");
        driver = DriverManager.getDriver(); // Fetch driver from DriverManager
        driver.getWebDriver().get(ConfigLoader.getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            System.out.println("Quitting driver...");
            DriverManager.quitDriver(); // Properly quit the driver
        } else {
            System.out.println("Driver was not initialized; skipping cleanup.");
        }
    }
}
