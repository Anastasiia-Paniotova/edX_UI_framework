package edx.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoursesDashboard extends BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public CoursesDashboard(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * search My Courses heading
     */
    @FindBy(xpath = "//*[@class='header-courses']")
    private WebElement myCoursesHeading;

    /**
     * search EMPTY dashboard element
     */
    @FindBy(xpath = "//*[@class='empty-dashboard-message']")
    private WebElement emptyDashboard;

    /**
     * search message for empty dashboard
     */
    @FindBy(xpath = "//*[@class='empty-dashboard-message']//p")
    private WebElement emptyDashboardMessage;

    /**
     * search dashboard with course
     */
    @FindBy(xpath = "//div[@class='course-container']")
    private WebElement dashboardWithCourse;

    /**
     * search 'Explore Course' button
     */
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement exploreCoursesButton;

    /**
     * search the Course Advertise component
     */
    @FindBy(xpath = "//*[@class='course-advertise']")
    private WebElement courseAdvertise;

    /**
     * search advertise message
     */
    @FindBy(xpath = "//*[@class='advertise-message']")
    private WebElement advertiseMessage;

    /**
     * search 'Explore New Course' button
     */
    @FindBy(xpath = "//*[@class='btn-neutral']")
    private WebElement exploreNewCourseButton;

    /**
     * search the View Course button
     */
    @FindBy(xpath = "//div[@class='continue-button']")
    private WebElement viewCourseButton;

    /**
     * search course's setting
     */
    @FindBy(xpath = "//*[@class='action action-more']")
    private WebElement settings;

    /**
     * search unenroll option
     */
    @FindBy(xpath = "//*[@class='action action-unenroll']")
    private WebElement unenroll;

    /**
     * search unenroll button
     */
    @FindBy(xpath = "//*[@class='submit-button']")
    private WebElement unenrollButton;

    /**
     * search Submit reason button
     */
    @FindBy(xpath = "//*[@class='submit_reasons']")
    private WebElement submitReason;

    @FindBy(xpath = "//section[@id='unenroll-modal']//button[@class='close-modal']/span[@class='icon fa fa-remove']")
    private WebElement closeOption;


    //ToDo: should be in another class for Search page?
    /**
     * search the first course on the Search page
     */
    @FindBy(xpath = "//*[@class='d-flex flex-column d-card-wrapper'][1]")
    private WebElement availableCourse;

    //ToDo: should be in another class for Course Page
    @FindBy(xpath = "//div[@class='course-about desktop course-info-content']" +
            "/div[@class='course-selection mt-md-4 container-mw-lg container-fluid']//button[@label='Enroll']")
    private WebElement enrollButton;


    @FindBy(xpath = "//button[@id='track_selection_audit']")
    private WebElement continueButton;

    /**
     * get empty dashboard message
     */
    public String getEmptyMessage() {
        return emptyDashboardMessage.getText();
    }

    /**
     * check that 'Explore Courses' button is enabled
     */
    public Boolean isEnabledExploreCourses() {
        return exploreCoursesButton.isEnabled();
    }

    /**
     * get style for 'Explore Courses' button
     */
    public String getColorExploreCoursesButton() {
        return exploreCoursesButton.getCssValue("background-color");
    }

    public String getFontExploreCoursesButton() {
        return exploreCoursesButton.getCssValue("color");
    }

    /**
     * check that Course Advertise exists on the page
     */
    public Boolean isDisplayedCourseAdvertise() {
        return courseAdvertise.isDisplayed();
    }

    /**
     * get text from Advertise message component
     */
    public String getAdvertiseMessage() {
        return advertiseMessage.getText();
    }

    /**
     * check that 'Explore New Course' button is enabled
     */
    public Boolean isEnabledExploreNewCourses() {
        return exploreNewCourseButton.isEnabled();
    }

    /**
     * click on the 'Explore Course' button
     */
    public void clickOnExploreCourses() {
        exploreCoursesButton.click();
    }

    /**
     * get current page
     */
    public String getCurrentPage() {
        return driver.getCurrentUrl();
    }

    /**
     * select the course
     */
    public void clickOnCourse(){
        availableCourse.click();
    }

    public void clickOnEnrollButton(){
        enrollButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    /**
     * selected course is displayed on the Dashboard page
     */
    public Boolean isDisplayedDashboardWithCourse(){
        return dashboardWithCourse.isDisplayed();
    }

    /**
     * clicks on the unenroll options
     */
    public void openSettings(){ settings.click(); }

    public void clickOnUnenroll(){ unenroll.click(); }

    public void clickOnUnenrollOption(){ unenrollButton.click(); }

    public void clickOnSubmit(){ submitReason.click(); }

    public void clickOnClose(){ closeOption.click(); }


}