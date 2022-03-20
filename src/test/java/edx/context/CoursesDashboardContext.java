package edx.context;

import edx.configuration.ConfProperties;
import edx.page.CoursesDashboard;

import static edx.test.BaseTest.driver;

public class CoursesDashboardContext {
    public static CoursesDashboard coursesDashboard = new CoursesDashboard(driver);

    /**
     * get empty dashboard message if courses are absent for user
     */
    public static String getEmptyDashboardMessage(){
        try {
            return coursesDashboard.getEmptyMessage();
        } catch (Exception e) {
            // FIXME: add some logs
            return "The Empty Dashboard is not displayed";
        }
    }

    /**
     * check that 'Explore Courses' button is enabled
     */
    public static Boolean isEnabledExploreCourses(){
        return coursesDashboard.isEnabledExploreCourses();
    }

    /**
     * get colors from 'Explore Courses' button
     */
    public static String getBackgroundExploreCoursesButton(){
        return coursesDashboard.getColorExploreCoursesButton();
    }

    public static String getFontExploreCoursesButton(){
        return coursesDashboard.getFontExploreCoursesButton();
    }

    /**
     * methods for Courses Advertise element
     */
    public static Boolean isDisplayedCourseAdvertise(){
        return coursesDashboard.isDisplayedCourseAdvertise();
    }

    public static String getAdvertiseMessage(){
        return coursesDashboard.getAdvertiseMessage();
    }

    public static Boolean isEnabledExploreNewCourses() {
        return coursesDashboard.isEnabledExploreNewCourses();
    }

    /**
     * method to add the course to the dashboard
     */
    public static void addCourseToTheDashboard(){
        coursesDashboard.clickOnExploreCourses();
        coursesDashboard.getCurrentPage();
        coursesDashboard.clickOnCourse();
        coursesDashboard.clickOnEnrollButton();
        coursesDashboard.clickOnContinueButton();
    }

    /**
     * method to unenroll from course
     */
    public static void unenrollFromCourse(){
        coursesDashboard.openSettings();
        coursesDashboard.clickOnUnenroll();
        coursesDashboard.clickOnUnenrollOption();
        coursesDashboard.clickOnEnrollButton();
        coursesDashboard.clickOnSubmit();
        coursesDashboard.clickOnClose();
        driver.navigate().refresh();
    }

    /**
     * method to navigate to the Dashboard page
     */
    public static void navigateToTheDashboardPage(){
        driver.get(ConfProperties.getProperty("dashboardPage"));
    }

    /**
     * method to check that course is displayed on the Course Dashboard
     */
    public static Boolean isDisplayedDashboardWithCourse(){
        return coursesDashboard.isDisplayedDashboardWithCourse();
    }

}
