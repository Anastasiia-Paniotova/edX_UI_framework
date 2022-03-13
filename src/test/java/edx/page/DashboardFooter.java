package edx.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardFooter extends BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public DashboardFooter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * search Logo on the footer
     */
    @FindBy(xpath = "//div[@class='edx-footer-logo']//img[@alt='edX Home Page']")
    private WebElement logoFooter;

    /**
     * search ALL heading elements in list
     */
    @FindBy(xpath = "//*[@class='heading']")
    private List<WebElement> headingList;

    /**
     * search edX heading
     */
    @FindBy(xpath = "//*[text()='edX']")
    private WebElement edXHeading;

    /**
     * search Legal heading
     */
    @FindBy(xpath = "//*[text()='Legal']")
    private WebElement legalHeading;

    /**
     * search Connect heading
     */
    @FindBy(xpath = "//*[text()='Connect']")
    private WebElement connectHeading;

    /**
     * search edX list elements
     */
    @FindBy(xpath = "//div[@class='ml-xl-0 col-lg-10 ml-lg-auto col-md-12 column-2-2 col-sm-10 full-height column-styles']" +
            "//ul[@class='list-unstyled clear-margins  ']//li//a")
    private List<WebElement> edxList;

    /**
     * search Legal list elements
     */
    @FindBy(xpath = "//div[@class='col-xl-4 col-lg-4 col-md-4 col-sm-12 col-xs-12 column-2-1 second-div-border column-styles ']" +
            "//ul[@class='list-unstyled clear-margins  ']//li//a")
    private List<WebElement> legalList;

    /**
     * search Connect list elements
     */
    @FindBy(xpath = "//div[@class='col-lg-12 col-md-12 col-sm-10 full-height column-2-2 column-styles']//li//a")
    private List<WebElement> connectList;

    /**
     * search social media links
     *
     */
    @FindBy(xpath = "//*[@title='Facebook']")
    private WebElement facebookIcon;

    @FindBy(xpath = "//*[@title='Twitter']")
    private WebElement twitterIcon;

    @FindBy(xpath = "//*[@title='LinkedIn']")
    private WebElement linkedInIcon;

    @FindBy(xpath = "//*[@title='Instagram']")
    private WebElement instagramIcon;

    @FindBy(xpath = "//*[@title='Reddit']")
    private WebElement redditIcon;


    /**
     * get text from Heading list elements
     */
    public ArrayList getHeadingList(){
        ArrayList<String> headingArray = new ArrayList<>();
        for(WebElement element : headingList) {
            headingArray.add(element.getText());
        }
        return headingArray;
    }

    /**
     * get text from edX list elements
     */
    public ArrayList getEDXList(){
        ArrayList<String> edxArray = new ArrayList<>();
        for (WebElement element : edxList) {
            edxArray.add(element.getText());
        }
        return edxArray;
    }

    /**
     * get text from Legal list elements
     */
    public ArrayList getLegalList(){
        ArrayList<String> legalArray = new ArrayList<>();
        for (WebElement element : legalList) {
            legalArray.add(element.getText());
        }
        return legalArray;
    }

    /**
     * get text from Connect list elements
     */
    public ArrayList getConnectList(){
        ArrayList<String> connectArray = new ArrayList<>();
        for (WebElement element : connectList) {
            connectArray.add(element.getText());
        }
        return connectArray;
    }

    /**
     * method to check that edX logo is displayed
     */
    public Boolean isDisplayedEDXLogoOnFooter(){
        return logoFooter.isDisplayed();
    }

    /**
     * method to get colors for footer heading
     */
    public String getColorEdx(){ return edXHeading.getCssValue("color"); }

    public String getColorLegal(){
        return legalHeading.getCssValue("color");
    }

    public String getColorConnect(){
        return legalHeading.getCssValue("color");
    }

    /**
     * methods to get font for footer heading
     */
    public String getFontEdx() { return edXHeading.getCssValue("font"); }

    public String getFontLegal() { return legalHeading.getCssValue("font"); }

    public String getFontConnect() { return legalHeading.getCssValue("font"); }

    /**
     * get links from social media
     */
    public String getLinkFacebook() { return facebookIcon.getAttribute("href"); }

    public String getLinkTwitter() { return twitterIcon.getAttribute("href"); }

    public String getLinkLinkedIn() { return linkedInIcon.getAttribute("href"); }

    public String getLinkInstagram() {return instagramIcon.getAttribute("href"); }

    public String getLinkReddit() {return redditIcon.getAttribute("href"); }












}