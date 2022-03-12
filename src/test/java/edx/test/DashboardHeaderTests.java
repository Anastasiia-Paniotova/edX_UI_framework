package edx.test;

import edx.configuration.DataProperties;
import edx.context.DashboardHeaderContext;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DashboardHeaderTests extends BaseTest{

    @BeforeClass (alwaysRun = true)
    public static void login(){
        DashboardHeaderContext.login();
    }

    @Test
    public void verifyThatMainTabsAreDisplayed(){
        Assert.assertTrue(DashboardHeaderContext.areDisplayedMainTitles());
    }

    @Test (dependsOnMethods = "verifyThatMainTabsAreDisplayed")
    public void verifyMainTabTitles(){
        assertThat(DashboardHeaderContext.getMainTitles(),
                is(DashboardHeaderContext.convertStringToArrayMainTabs()));
    }

    @Test
    public void verifyPageUponClickOnLogo(){
        assertThat(DashboardHeaderContext.getPageUponClickingOnLogo(),
                equalTo(DataProperties.getProperty("logoPage")));
    }

    @Test
    public void verifyListOfTitlesUserMenu(){
        assertThat(DashboardHeaderContext.getUserMenuTitles(),
                is(DashboardHeaderContext.convertStringToArrayUserMenu()));
    }

    @Test
    public void verifyThatProgramDashboardIsOpened(){
        assertThat(DashboardHeaderContext.getPageUponClickingProgramTab(),
                equalTo(DataProperties.getProperty("programDashboard")));
    }

    @Test
    public void verifyThatSearchPageIsOpenedUponDiscoverNew(){
        assertThat(DashboardHeaderContext.getSearchPageUponClickingDiscoverNewTab(),
                anyOf
                        (equalTo(DataProperties.getProperty("discoverNewPage")),
                         equalTo(DataProperties.getProperty("discoverNewPageNew"))));
    }

    @Test
    public void verifyThatCourseDashboardIsOpenedUponCourses(){
        assertThat(DashboardHeaderContext.getPageUponClickingCoursesTab(),
                equalTo(DataProperties.getProperty("logoPage")));
    }

    @Test(priority = 1)
    public void verifyThatSupportPageIsOpened(){
        driver.get(DataProperties.getProperty("logoPage"));
        assertThat(DashboardHeaderContext.getPageUponClickingHelpTab(),
                equalTo(DataProperties.getProperty("supportPage")));
    }

    @AfterTest(alwaysRun = true)
    public void openBasicPage(){
        driver.get(DataProperties.getProperty("logoPage"));
    }

}
