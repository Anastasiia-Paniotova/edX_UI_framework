package edx.context;

import edx.configuration.DataProperties;
import edx.page.DashboardFooter;

import java.util.ArrayList;
import java.util.Arrays;

import static edx.test.BaseTest.driver;

public class DashboardFooterContext {
    public static DashboardFooter dashboardFooter = new DashboardFooter(driver);

    /**
     * verify elements in the heading list
     */
    public static ArrayList getHeadingList() {
        return dashboardFooter.getHeadingList();
    }

    /**
     * method to convert Heading data from file as String to Array
     */
    public static ArrayList convertStringToArrayHeadingList(){
        String edXList = DataProperties.getProperty("headingList");
        return new ArrayList<>(Arrays.asList(edXList.split(",")));
    }

    /**
     * verify elements in the edx list
     */
    public static ArrayList getEdxList(){
        return dashboardFooter.getEDXList();
    }

    /**
     * method to convert edx data from file as String to Array
     */
    public static ArrayList convertStringToArrayEdxList(){
        String edXList = DataProperties.getProperty("edXListFooter");
        return new ArrayList<>(Arrays.asList(edXList.split(",")));
    }

    /**
     * verify elements in the Legal list
     */
    public static ArrayList getLegalList(){
        return dashboardFooter.getLegalList();
    }

    /**
     * method to convert edx data from file as String to Array
     */
    public static ArrayList convertStringToArrayLegalList(){
        String legalList = DataProperties.getProperty("legalListFooter");
        return new ArrayList<>(Arrays.asList(legalList.split(",")));
    }

    /**
     * verify elements in the Connect list
     */
    public static ArrayList getConnectList(){
        return dashboardFooter.getConnectList();
    }

    /**
     * method to convert Connect data from file as String to Array
     */
    public static ArrayList convertStringToArrayConnectList(){
        String connectList = DataProperties.getProperty("connectListFooter");
        return new ArrayList<>(Arrays.asList(connectList.split(",")));
    }

    /**
     * check that the edX logo is displayed on the Footer
     */
    public static Boolean isDisplayedFooterLogo(){
        return dashboardFooter.isDisplayedEDXLogoOnFooter();
    }

    /**
     * methods to get colors for edX/Logo/Component heading
     */
    public static String getColorEDX(){ return dashboardFooter.getColorEdx(); }

    public static String getColorLegal(){
        return dashboardFooter.getColorLegal();
    }

    public static String getColorConnect(){
        return dashboardFooter.getColorConnect();
    }

    /**
     * methods to get font for edX/Logo/Component heading
     */
    public static String getFontEdxHeading(){ return dashboardFooter.getFontEdx(); }

    public static String getFontLegalHeading(){ return dashboardFooter.getFontLegal(); }

    public static String getFontConnectHeading(){ return dashboardFooter.getFontConnect(); }

    /**
     * methods to get links from social media
     */
    public static String getFacebookLink(){ return  dashboardFooter.getLinkFacebook(); }

    public static String getTwitterLink() { return dashboardFooter.getLinkTwitter(); }

    public static String getInstagramLink() { return dashboardFooter.getLinkInstagram(); }

    public static String getLinkedInLink() { return dashboardFooter.getLinkLinkedIn(); }

    public static String getRedditLink() { return dashboardFooter.getLinkReddit(); }

}
