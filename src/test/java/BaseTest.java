

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
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
  static   WebDriver driver;
   static String url;
   static WebDriverWait wait;
   static Actions actions;
   static   ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }else {
            System.setProperty("webdriver.chrome.driver","chromedriver");


        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        if(BaseURL==null)
            BaseURL = "https://bbb.testpro.io";

      // driver = new ChromeDriver();
       System.setProperty("webdriver,gecko.driver","geckodriver.exe");
       //driver = new FirefoxDriver();
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

       // actions = new Actions(getDriver());
       // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(url);
    }

    public static WebDriver getDriver(){
        return threadDriver.get();

    }

    public static WebDriver lambdatest() throws  MalformedURLException{
        String username = "kaflimeerim";
        String authkey = "4uTND22oefflFCwcG2UPZKcldHLFjUOwF5KLdCBmq4Uh7koXrB";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform","Windows 10");
        caps.setCapability("browserName","Chrome");
        caps.setCapability("version","106.0");
        caps.setCapability("resolution","1024x768");
        caps.setCapability("build","TestNG With Java");
      //   caps.setCapability("name",this.getClass().getName());
        caps.setCapability("plugin","git-testing");
        return  new RemoteWebDriver(new URL("https://"+username+ ":" + authkey + hub),caps);
    }


    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
         DesiredCapabilities caps = new DesiredCapabilities();
         String gridURL = "192.168.1.155:4444.";
        switch (browser){
            case "firefox":
                System.setProperty("webdriver,gecko.driver","geckodriver.exe");
                return driver = new FirefoxDriver();
            case  "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName","safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdatest();


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


    @DataProvider(name = "invalidCredentials")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"invalid@gmail.com", "invalidPass"},
                {"d@gmail.com", ""},

        };
    }

    public void login(){


        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
