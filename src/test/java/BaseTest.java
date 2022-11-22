

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
import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;


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
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        if(BaseURL==null)
            BaseURL = "https://bbb.testpro.io";

      // driver = new ChromeDriver();
       System.setProperty("webdriver,gecko.driver","geckodriver.exe");
       //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        url = BaseURL;
        driver.get(url);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
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


            default:
                return driver = new ChromeDriver();



        }
    }

    @AfterMethod
    public void tearBrowser() {
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
