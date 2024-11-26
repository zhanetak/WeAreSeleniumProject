package wearetests.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import wearetests.web.*;

@Suite
@SelectClasses({
        RegisterNewUserTests.class,
        LoginTests.class,
        CreateAndEditPostTests.class,
        LatestPostsTests.class,
        DeleteTests.class
})
public class AllTestsSuite {
}
