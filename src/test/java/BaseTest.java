import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
import java.util.Set;

import static java.sql.DriverManager.getDriver;

public class BaseTest {
  static   WebDriver driver;
   static String url;
  static   WebDriverWait Wait;

   static Actions actions;
   static ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//            it should be webdriver
        }
    }

    @BeforeMethod
    public static void launchBrowser() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");

        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver= new FirefoxDriver();
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
//        actions = new Actions(getDriver());
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        url = "https://bbb.testpro.io/";
        getDriver().get(url);
        Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));


    }

    public static WebDriver getDriver() {

        return threadDriver.get();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL =  "http://192.168.1.149:4444";
        switch (browser){
            case    "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver.exe");
                return driver = new FirefoxDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "MicrosoftEdge":
                return driver = new EdgeDriver();
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();
    }


}

    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "shwetambarigupta1882";
        String authKey = "9bvnzOtePCbKod1EzutZ6iUavVIiM9nZ3HwfIVuw76yFXmZc9z";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platform","windows 10");
        caps.setCapability("browser","chrome");
        caps.setCapability("version","106.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build","TestNG");
        caps.setCapability("plugin","git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authKey + hub), caps);

    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public void LogIn() {
        provideEmail("myworld123@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public  void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("myworld123@gmail.com");

    }


}
