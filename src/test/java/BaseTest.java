import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    static Actions actions;
    static WebDriverWait wait;
    static String url;
    static ThreadLocal<WebDriver> threadDriver;
    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");

        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        if (BaseURL == null) {
            BaseURL = "https://bbb.testpro.io";
        }
        if(threadDriver == null) {
            threadDriver = new ThreadLocal<>();
        }
        threadDriver.set(driver);

        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        url = "https://bbb.testpro.io";
        getDriver().get(url);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
    }
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }

    public static WebDriver lambdaTest() throws MalformedURLException {

        String username = "holostenco.yuliya";
        String accessKey = "7gmiIpWm1kIVzfjdYR9iEk3WkbBwYwGdXt9p8hQ6NSyHMCymHg";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "107.0");
        capabilities.setCapability("platform", "Windows 11");
        capabilities.setCapability("resolution", "1920x1080");
        capabilities.setCapability("build", "TestNG with Java");
        capabilities.setCapability("plugin", "git-testing");
        capabilities.setCapability("video", true); // To enable video recording
        return new RemoteWebDriver(new URL("http://" + username + accessKey + hub), capabilities);

    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.159:4444";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();

        }
    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }
}