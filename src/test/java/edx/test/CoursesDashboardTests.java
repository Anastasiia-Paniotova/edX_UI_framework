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

    @Test(priority = 1)
    public static void verifyTheMessageForEmptyDashboard(){
        assertThat(CoursesDashboardContext.getEmptyDashboardMessage(),
                equalTo(DataProperties.getProperty("emptyDashboardMessage")));
    }

    @Test(priority = 2)
    public static void checkTheExploreCoursesButton(){
        Assert.assertTrue(CoursesDashboardContext.isEnabledExploreCourses());
    }

    @Test(priority = 3)
    public static void checkStyleForTheExploreCoursesButton(){
        assertThat(CoursesDashboardContext.getBackgroundExploreCoursesButton(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("backgroundExploreCoursesButton")));
        assertThat(CoursesDashboardContext.getFontExploreCoursesButton(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("fontExploreCoursesButton")));
    }

    @Test(priority = 4)
    public static void checkThatCoursesAdvertiseElementIsPresent(){
        Assert.assertTrue(CoursesDashboardContext.isDisplayedCourseAdvertise());
    }

    @Test(priority = 5)
    public static void checkAdvertiseMessage(){
        assertThat(CoursesDashboardContext.getAdvertiseMessage(),
                equalToIgnoringWhiteSpace(DataProperties.getProperty("advertiseMessage")));
    }

    @Test(priority = 6)
    public static void verifyThatExploreNewCoursesIsEnabled(){
        Assert.assertTrue(CoursesDashboardContext.isEnabledExploreNewCourses());
    }

    @Test(priority = 7)
    public static void addNewCourseToTheEmptyDashboardAndVerifyThatTheCourseISDisplayed(){
        CoursesDashboardContext.addCourseToTheDashboard();
        CoursesDashboardContext.navigateToTheDashboardPage();
        Assert.assertTrue(CoursesDashboardContext.isDisplayedDashboardWithCourse());
    }

//    //(dependsOnMethods = "addNewCourseToTheEmptyDashboardAndVerifyThatTheCourseISDisplayed")
//    @Test
//    public static void verifyThatCorrespondingCourseIsOpened(){
////        assertThat(CoursesDashboardContext.clickOnTheViewCourseAndCheckTheCourseTextAttributes(),
////                equalTo(CoursesDashboardContext.getCourseTitle()));
//
//        System.out.println(CoursesDashboardContext.getInfoAndIdUniversityLearningEdx());
//
////        assertThat(CoursesDashboardContext.getInfoAndIdUniversityLearningEdx(),
////                equalTo(CoursesDashboardContext.getIdCourse()));

//    }


}
