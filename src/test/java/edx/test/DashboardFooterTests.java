package edx.test;

import edx.configuration.DataProperties;
import edx.context.DashboardFooterContext;
import edx.context.DashboardHeaderContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DashboardFooterTests extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public static void login(){
        DashboardHeaderContext.login();
    }

    @Test
    public void verifyHeadingListElements(){
        assertThat(DashboardFooterContext.getHeadingList(),equalTo(DashboardFooterContext.convertStringToArrayHeadingList()));
    }

    @Test
    public void verifyHeadingColors(){
        assertThat(DashboardFooterContext.getColorEDX(),equalTo(DataProperties.getProperty("headingColor")));
        assertThat(DashboardFooterContext.getColorLegal(),equalTo(DataProperties.getProperty("headingColor")));
        assertThat(DashboardFooterContext.getColorConnect(),equalTo(DataProperties.getProperty("headingColor")));
    }

    @Test
    public void verifyHeadingFont(){
        assertThat(DashboardFooterContext.getFontEdxHeading(), equalTo(DataProperties.getProperty("headingFont")));
        assertThat(DashboardFooterContext.getFontLegalHeading(),equalTo(DataProperties.getProperty("headingFont")));
        assertThat(DashboardFooterContext.getFontConnectHeading(),equalTo(DataProperties.getProperty("headingFont")));
    }

    @Test
    public void verifyEDXListElements(){
        assertThat(DashboardFooterContext.getEdxList(),equalTo(DashboardFooterContext.convertStringToArrayEdxList()));
    }

    @Test
    public void verifyLegalListElements(){
        assertThat(DashboardFooterContext.getLegalList(), equalTo(DashboardFooterContext.convertStringToArrayLegalList()));
    }

    @Test
    public void verifyConnectListElements(){
        assertThat(DashboardFooterContext.getConnectList(),equalTo(DashboardFooterContext.convertStringToArrayConnectList()));
    }

    @Test
    public void verifyThatFooterLogoIsDisplayed(){
        Assert.assertTrue(DashboardFooterContext.isDisplayedFooterLogo());
    }

    @Test
    public void verifyThatSocialMediasHaveCorrectLinks(){
        assertThat(DashboardFooterContext.getFacebookLink(), equalTo(DataProperties.getProperty("facebook")));
        assertThat(DashboardFooterContext.getTwitterLink(), equalTo(DataProperties.getProperty("twitter")));
        assertThat(DashboardFooterContext.getLinkedInLink(), equalTo(DataProperties.getProperty("linkedIn")));
        assertThat(DashboardFooterContext.getInstagramLink(), equalTo(DataProperties.getProperty("instagram")));
        assertThat(DashboardFooterContext.getRedditLink(), equalTo(DataProperties.getProperty("reddit")));

    }


//    @AfterTest(alwaysRun = true)
//    public void openBasicPage(){
//        driver.get(DataProperties.getProperty("logoPage"));
//    }

}
