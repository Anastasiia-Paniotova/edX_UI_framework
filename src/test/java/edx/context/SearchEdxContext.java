package edx.context;
import edx.page.SearchEdx;

import static edx.test.BaseTest.driver;

public class SearchEdxContext {
    public static SearchEdx searchEdx = new SearchEdx(driver);
}
