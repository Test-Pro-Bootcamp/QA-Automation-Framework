import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;
    String url;
    String email="holostenco.yuliya@gmail.com";
    String Password="te$t$tudent";


    @BeforeSuite

    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        }
    }

    @BeforeClass
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }




   protected WebElement waitForElementToBeClickable(WebElement iuliasWebElementLocator) {
      return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
             ExpectedConditions.elementToBeClickable(iuliasWebElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
               .visibilityOf(webElementLocator));
    }




    @AfterMethod
        public void tearDownBrowser() {
            driver.quit();
            driver = null;
        }
    }