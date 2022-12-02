import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.chromium.HasNetworkConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
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
import java.util.Map;

public class BaseTest {

    static WebDriver driver;
    static String url;
    static WebDriverWait wait;
    static Actions actions;

    static ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }


    }

    @BeforeMethod
    // Send a parameter for 'baseURL' specified in XML
    // Make baseURL parameter optional, if it is null, then set it to something)

    public static void launchBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");


//    threadDriver = new ThreadLocal<RemoteWebDriver>();
//    threadDriver.set(new RemoteWebDriver(new URL("http://192.168.1.67:1234"), capabilities));


        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

//    actions = new Actions(getDriver());
//    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        url = "https://bbb.testpro.io/";
        getDriver().get(url);

    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }


    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "khaledzamanqa";
        String authkey = "e33oiUgYlTNRArFJpW8NCYZmvEzDi9jIQC6qvdHg4UOxL82EHd";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("resolution","1440x900");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "13.0");
        caps.setCapability("build", "TestNG With Java");
//    caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public static WebDriver pickBrowser(String brwsr) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.67:1234";

        switch (brwsr) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
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

    public void clickSubmitBtn() {
        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = getDriver().findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
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

    public void login(){
        provideEmail("yuliyakis85@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}