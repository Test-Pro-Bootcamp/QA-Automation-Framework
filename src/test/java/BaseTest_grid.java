import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import static com.sun.tools.doclint.Entity.cap;

public class BaseTest_grid {

     WebDriver driver;
      String url;
       WebDriverWait wait;
       Actions actions;

     //ThreadLocal<WebDriver> threadDriver;




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
    @Parameters({"baseURL"})
    // Make baseURL parameter optional, if it is null, then set it to something)
    public  void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
       // driver = new FirefoxDriver();
        //driver = new SafariDriver();


        driver = pickBrowser(System.getProperty("browser"));
        //when we have driver
//        threadDriver  = new ThreadLocal<>();
//        threadDriver.set(driver);
//        actions = new Actions(getDriver());
        actions= new Actions(driver);

        // Wait for an element to show up for max of X seconds
        // implicitlyWait(Duration.ofSeconds(60) will wait for UP to 60 seconds
        // if element comes up after 1 second, it will move on
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       //driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      // wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        // thread.sleep(60000) -- will wait 60s always
        url = baseURL;
        //getDriver().get(url);
         driver.get(url);
    }

//    public static WebDriver getDriver() {
//        return threadDriver.get();
//    }
  //use terminal to run gradle clean test -Dbrowser=safari

    public static WebDriver lambdaTest() MalformedURLException{


        String username = "trangoishi99";
        String accessKey = "";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("version", "92.0");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("resolution","1024x768");
            capabilities.setCapability("build", "First Test");
            capabilities.setCapability("name", "Sample Test");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs

            return  new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.64:4444";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();

        }
    }


    @AfterMethod
    public void tearDownBrowser() {
//        getDriver().quit();
//        threadDriver.remove();
        driver.quit();
    }
    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
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
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
