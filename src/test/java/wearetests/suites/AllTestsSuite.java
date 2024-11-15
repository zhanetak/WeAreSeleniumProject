package wearetests.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import wearetests.web.HomePageTests;
import wearetests.web.LatestPostsTests;
import wearetests.web.LoginTests;
import wearetests.web.RegisterNewUser;

@Suite
@SelectClasses({
        RegisterNewUser.class,
        LoginTests.class,
        HomePageTests.class,
        LatestPostsTests.class,
})
public class AllTestsSuite {
}


