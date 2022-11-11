import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.chromium.HasNetworkConditions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;

    static ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            // System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
    }

    @BeforeMethod
    // Send a parameter for 'baseURL' specified in XML
    @Parameters({"baseURL"})
    // Make baseURL parameter optional, if it is null, then set it to something)
    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        // driver = new ChromeDriver();
        driver = pickBrowser();

        if(threadDriver == null) {
            threadDriver = new ThreadLocal<>();
        }
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        // thread.sleep(60000) -- will wait 60s always
        url = baseURL;
        getDriver().get(url);

    }

    public static WebDriver getDriver() {
        WebDriver webDriver = threadDriver.get();
        return webDriver;
    }

    private static WebDriver pickBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.20:4444";

        String browser = System.getProperty("browser");
        WebDriver webDriver = null;

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                webDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
                break;
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                webDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            case "cloud":
                webDriver = getLambdaTestDriver();
                break;
            default:
                webDriver = new ChromeDriver();
        }

        return webDriver;
    }

    private static WebDriver getLambdaTestDriver() throws MalformedURLException {
        String userName = "jyoti.thapa92";
        String authKey = "isSBt9VnPk6P8NkgS5J4r1as3AkOzMDN94SMxiGCaagTBNknhf";
        String hub = "@hub.lambdatest.com/wd/hub";
        String url = "https://" + userName + ":" + authKey + hub;

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "108.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL(url), caps);
    }

    @AfterMethod
    public static void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public static void clickSubmitBtn() {
        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public static void provideEmail(String email) {
        WebElement emailField = getDriver().findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }

    public static void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
