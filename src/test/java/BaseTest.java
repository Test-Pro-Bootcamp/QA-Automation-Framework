import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    String url;
    ThreadLocal<WebDriver> threadDriver;

   protected String myEmail = "holostenco.yuliya@gmail.com";
   protected String myPassword = "te$t$tudent";

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeClass
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
       // ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--disable-notifications");
//System.setProperty("webdriver.gecko.driver", "geckodriver");
//driver= new FirefoxDriver();
       driver = pickBrowser(System.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);

    }

   // public WebDriver getDriver(){
      //  return threadDriver.get();
   // }
    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        String gridURL="http://192.168.1.159:4444";
        switch(browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver");
                return  driver=new FirefoxDriver();
            case "safari":
                return driver= new SafariDriver();
            case "grid-safari":
                capabilities.setCapability("browserName","safari");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-firefox":
                capabilities.setCapability("browserName","firefox");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName","chrome");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                return driver=new ChromeDriver();

       }
    }
    @AfterMethod
        public void tearDownBrowser() {
            driver.quit();
        }
    }