package edx.test;

import edx.configuration.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public static void setup() {
        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Professional\\Desktop\\edX_UI\\chrome_webdriver\\chromedriver.exe");
//        //создание экземпляра драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("dashboardPage"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
