package edx.page;

import edx.configuration.ConfProperties;
import edx.configuration.DataProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static edx.test.BaseTest.driver;

public class DashboardHeader extends BasePage{
    public WebDriver driver;
    public WebDriverWait wait;

    public DashboardHeader(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    /**
     * elements and methods for LOGIN
     */
    @FindBy(xpath = "//*[@id='emailOrUsername']")
    private WebElement username;

    public void inputLogin(){
        username.sendKeys(DataProperties.getProperty("username"));
    }

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    public void inputPassword(){
        password.sendKeys(DataProperties.getProperty("password"));
    }

    @FindBy(xpath = "//*[@class='pgn__stateful-btn pgn__stateful-btn-state-default login-button-width btn btn-brand']")
    private WebElement signIn;

    public void clickSignIn(){
        signIn.click();
    }


    /**
     * search edX logo
     */
    @FindBy(xpath = "//*[@class='logo']")
    private WebElement edXLogo;

    /**
     * search Courses tab
     */
    @FindBy(xpath = "//div[@class='main']//a[text()[contains(.,'Courses')]]")
    private WebElement coursesTab;


    /**
     * search Program tab
     */
    @FindBy(xpath = "//div[@class='main']//a[@class='tab-nav-link']")
    private WebElement programTab;

    /**
     * search Discover Now tab
     */
    @FindBy(xpath = "//div[@class='main']//a[@class='tab-nav-link discover-new-link']")
    private WebElement discoverNewTab;

    /**
     * search Help tab
     */
    @FindBy(xpath = "//div[@class='secondary']//a[@class='help-link']")
    private WebElement helpLink;

    /**
     * search Username menu
     */
    @FindBy(xpath = "//*[@class='username']")
    private WebElement usernameMenu;

    /**
     * search user menu toggle
     */
    @FindBy(xpath = "//*[@class='toggle-user-dropdown']")
    private WebElement userDropdown;

    /**
     * search Username dropdown
     */
    @FindBy(xpath = "//*[@class='fa fa-caret-down']")
    private WebElement usernameDropdown;

    /**
     * search Dashboard user menu
     */
    @FindBy(xpath = "//div[@class='dropdown-user-menu']//a[text()[contains(.,'Dashboard')]]")
    private WebElement dashboardUserMenu;

    /**
     * search Profile user menu
     */
    @FindBy(xpath = "//div[@class='dropdown-user-menu']//a[text()[contains(.,'Profile')]]")
    private WebElement profileUserMenu;

    /**
     * search Account user menu
     */
    @FindBy(xpath = "//div[@class='dropdown-user-menu']//a[text()[contains(.,'Account')]]")
    private WebElement accountUserMenu;

    /**
     * search Order History user menu
     */
    @FindBy(xpath = "//div[@class='dropdown-user-menu']//a[text()[contains(.,'Order History')]]")
    private WebElement orderHistoryUserMenu;

    /**
     * search Sign Oun user menu
     */
    @FindBy(xpath = "//div[@class='dropdown-user-menu']//a[text()[contains(.,'Sign Out')]]")
    private WebElement SignOutUserMenu;

    /**
     * methods to check that tabs are displayed on the Global Header
     */
    public boolean isDisplayedCourseTab(){
        return this.isDisplayed(coursesTab);
    }

    public boolean isDisplayedProgramTab(){
        return this.isDisplayed(programTab);
    }

    public boolean isDisplayedDiscoverNowTab(){
        return this.isDisplayed(discoverNewTab);
    }

    /**
     * conditional to check that elements are displayed
     * @return elements are/aren't displayed
     */

    public boolean headerElementsAreDisplayed(){
        return this.isDisplayedCourseTab() && this.isDisplayedProgramTab() && this.isDisplayedDiscoverNowTab();
    }

    /**
     * methods to get titles of tabs
     */
    public String getTextCourses(){
        return coursesTab.getText();
    }

    public String getTextProgram(){return programTab.getText(); }

    public String getTextDiscoverNow(){
        return discoverNewTab.getText();
    }

    /**
     * method click to the edX logo
     */
    public void clickOnLogo(){
        edXLogo.click();
    }

    /**
     * method to open the user menu
     */
    public void openUserMenu(){
        userDropdown.click();
    }

    /**
     * methods to get titles of user menu elements
     */

    public String getTextDashboard(){return dashboardUserMenu.getText();}

    public String getTextProfile(){return profileUserMenu.getText();}

    public String getTextAccount(){return accountUserMenu.getText();}

    public String getTextOrderHistory(){return orderHistoryUserMenu.getText();}

    public String getTextSignOut(){return SignOutUserMenu.getText();}

    /**
     * method to open the Program Dashboard
     */
    public void openProgramDashboard(){
        programTab.click();
    }

    /**
     * method to open Search page
     */
    public void openSearchPage(){
        discoverNewTab.click();
    }

    /**
     * method to open Course page
     */
    public void openCoursePage(){
        coursesTab.click();
    }

    /**
     * method to open the Support page upon selection Help tab
     */
    public void openSupportPage(){
        helpLink.click();
    }

    /**
     * method to switch tabs
     */
    public void switchTab(){
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
    }



}


