package edx.test;

import edx.configuration.DataProperties;
import edx.context.CoursesDashboardContext;
import edx.context.DashboardHeaderContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoursesDashboardTests extends BaseTest{

    @BeforeClass(alwaysRun = true)
    public static void login(){
        DashboardHeaderContext.login();
    }

    @Test
    public static void verifyTheMessageForEmptyDashboard(){
        assertThat(CoursesDashboardContext.getEmptyDashboardMessage(),
                equalTo(DataProperties.getProperty("emptyDashboardMessage")));
    }

    @Test
    public static void checkTheExploreCoursesButton(){
        Assert.assertTrue(CoursesDashboardContext.isEnabledExploreCourses());
    }

    @Test(dependsOnMethods = "checkTheExploreCoursesButton")
    public static void checkStyleForTheExploreCoursesButton(){
        assertThat(CoursesDashboardContext.getBackgroundExploreCoursesButton(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("backgroundExploreCoursesButton")));
        assertThat(CoursesDashboardContext.getFontExploreCoursesButton(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("fontExploreCoursesButton")));
    }

    @Test
    public static void checkThatCoursesAdvertiseElementIsPresent(){
        Assert.assertTrue(CoursesDashboardContext.isDisplayedCourseAdvertise());
    }

    @Test(dependsOnMethods = "checkThatCoursesAdvertiseElementIsPresent")
    public static void checkAdvertiseMessage(){
        assertThat(CoursesDashboardContext.getAdvertiseMessage(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("advertiseMessage")));
    }

    @Test
    public static void verifyThatExploreNewCoursesIsEnabled(){
        Assert.assertTrue(CoursesDashboardContext.isEnabledExploreNewCourses());
    }

    @Test
    public static void addNewCourseToTheEmptyDashboardAndVerifyThatTheCourseISDisplayed(){
        CoursesDashboardContext.addCourseToTheDashboard();
        CoursesDashboardContext.navigateToTheDashboardPage();
        Assert.assertTrue(CoursesDashboardContext.isDisplayedDashboardWithCourse());
    }

    @Test
    public static void unenrollFromCourse(){
        CoursesDashboardContext.unenrollFromCourse();
    }



}
