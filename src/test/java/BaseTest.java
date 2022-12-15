import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    static WebDriver driver;
    static Actions actions;

    static String url;

    static WebDriverWait wait;
    static ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
    }

    @BeforeMethod
    public static void launchBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "browser");

        threadDriver = new ThreadLocal<>();
        driver = pickBrowser("browser");
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(7));
        url = "https://bbb.testpro.io";
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://26.94.92.112:5555";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdatest();
            default:
                return driver = new ChromeDriver();
        }
    }

    public static WebDriver lambdatest() throws MalformedURLException {
        String username = "chulkov.e91";
        String accessKey = "ldR6SHzMVyB7PVtn0Obz8jaGwL66uzLlKUbv9thh6m8pyQWIYo";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "106.0");
        capabilities.setCapability("resolution", "1024x768");
        capabilities.setCapability("build", "First Test");

//        capabilities.setCapability("name", this.getClass().getName());

        capabilities.setCapability("plugin", "git-testing");

        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), capabilities);
    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();

    }
}