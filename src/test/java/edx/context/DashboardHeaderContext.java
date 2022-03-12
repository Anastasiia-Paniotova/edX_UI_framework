package edx.context;

import edx.configuration.DataProperties;
import edx.page.DashboardHeader;

import java.util.ArrayList;
import java.util.Arrays;

import static edx.test.BaseTest.driver;

public class DashboardHeaderContext {
    public static DashboardHeader dashboardHeader = new DashboardHeader(driver);

    /**
     * login
     */

    public static void login(){
        dashboardHeader.inputLogin();
        dashboardHeader.inputPassword();
        dashboardHeader.clickSignIn();
    }
    /**
     * method to check that main tabs are displayed
     */
    public static Boolean areDisplayedMainTitles(){
        return dashboardHeader.headerElementsAreDisplayed();
    }
    /**
     * method to convert data from file as String to Array
     */
    public static ArrayList convertStringToArrayMainTabs(){
        String mainTabsString = DataProperties.getProperty("globalHeaderTabs");
        return new ArrayList<>(Arrays.asList(mainTabsString.split(",")));
    }

    /**
     * method to get titles of main tabs
     */
    public static ArrayList getMainTitles(){
        ArrayList<String> headerMainElements = new ArrayList<String>();
        headerMainElements.add(dashboardHeader.getTextCourses());
        headerMainElements.add(dashboardHeader.getTextProgram());
        headerMainElements.add(dashboardHeader.getTextDiscoverNow());
        return headerMainElements;
    }

    /**
     * method to verify page upon clicking on main edXLogo
     */

    public static String getPageUponClickingOnLogo(){
        dashboardHeader.clickOnLogo();
        return driver.getCurrentUrl();
    }
    /**
     * method to get titles of user menu
     */
    public static ArrayList getUserMenuTitles(){
        ArrayList<String> userMenuTitles = new ArrayList<>();
        dashboardHeader.openUserMenu();
        userMenuTitles.add(dashboardHeader.getTextDashboard());
        userMenuTitles.add(dashboardHeader.getTextProfile());
        userMenuTitles.add(dashboardHeader.getTextProfile());
        userMenuTitles.add(dashboardHeader.getTextAccount());
        userMenuTitles.add(dashboardHeader.getTextOrderHistory());
        userMenuTitles.add(dashboardHeader.getTextSignOut());
        return userMenuTitles;
    }

    /**
     * method to convert data from User Menu list as String to Array
     */
    public static ArrayList convertStringToArrayUserMenu(){
        String mainTabsString = DataProperties.getProperty("userMenuList");
        return new ArrayList<>(Arrays.asList(mainTabsString.split(",")));
    }

    /**
     * method to verify that Program Dashboard is opened upon selection Program tab
     */
    public static String getPageUponClickingProgramTab(){
        dashboardHeader.openProgramDashboard();
        return driver.getCurrentUrl();
    }

    /**
     * method to verify that Search page is opened upon selection Discover new tab
     */
    public static String getSearchPageUponClickingDiscoverNewTab(){
        dashboardHeader.openSearchPage();

        return driver.getCurrentUrl();
    }

    /**
     * method to verify that Courses Dashboard is opened upon selection Courses tab
     */
    public static String getPageUponClickingCoursesTab(){
        dashboardHeader.openCoursePage();
        return driver.getCurrentUrl();
    }

    /**
     * method to verify that Support page is opened upon selection Help Tab
     */
    public static String getPageUponClickingHelpTab(){
        dashboardHeader.openSupportPage();
        dashboardHeader.switchTab();
        return driver.getCurrentUrl();
    }




}
