package edx.context;

import edx.configuration.ConfProperties;
import edx.configuration.DataProperties;
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
    public static void unenrollFromCourse() throws InterruptedException {
        Thread.sleep(5000);
        coursesDashboard.openSettings();
//        coursesDashboard.clickOnUnenroll();
//        coursesDashboard.clickOnUnenrollOption();
//        driver.navigate().refresh();
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

    /**
     * methods to get text from displayed course
     */
    public static String getCourseTitle(){
        return coursesDashboard.getTitleOfCourse();
    }

    public static String getInfoUniversity(){ return coursesDashboard.getInfoUniversity(); }

    public static String getIdCourse(){ return coursesDashboard.getIDCourse(); }

    /**
     * methods to get text of corresponding course after navigation to the learning edx
     */

    public static String clickOnTheViewCourseAndCheckTheCourseTextAttributes() {
        coursesDashboard.clickOnTheViewCourse();
        return coursesDashboard.getTitleOfCourseLearninEdx();
    }

    public static String getInfoAndIdUniversityLearningEdx(){
        if (driver.getCurrentUrl().equals(DataProperties.getProperty("logoPage"))) {
            coursesDashboard.clickOnTheViewCourse();
        }
        return coursesDashboard.getInfoAndIdLearningEdx();
    }





}
