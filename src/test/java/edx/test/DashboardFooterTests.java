package edx.test;

import edx.configuration.DataProperties;
import edx.context.DashboardFooterContext;
import edx.context.DashboardHeaderContext;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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


    @AfterTest(alwaysRun = true)
    public void openBasicPage(){
        driver.get(DataProperties.getProperty("logoPage"));
    }

}
