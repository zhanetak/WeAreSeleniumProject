package wearetests.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import wearetests.web.*;

@Suite
@SelectClasses({
        RegisterNewUser.class,
        LoginTests.class,
        HomePageTests.class,
        LatestPostsTests.class,
        DeleteTests.class
})
public class AllTestsSuite {

}


