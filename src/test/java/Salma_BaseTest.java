import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class Salma_BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static String url;
    static Actions actions;
    static ThreadLocal<WebDriver> threadDriver; //for parallel testing


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
        //driver= new FirefoxDriver();
        //driver = new SafariDriver()
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        //systemProperty "browser", System.getProperty("browser")  --> add this to build.gradle
        //driver = pickBrowser("firefox");
        //driver = pickBrowser("safari");
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        url = baseURL;
        getDriver().get(url); //instead of driver.get(url)

    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriver lambdaTest() throws MalformedURLException{
        String userName = "salma.ayad.87";
        String authKey="IcmOreM615dMUWDKF0rd0XW0Xjvl9Ezk0Ky4XJlp9qfdXPV1Rs";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "107.0");
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("resolution","1280x1024");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("plugin", "git-testing");
        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey + hub), caps);
    }
    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.12:4444.";
        //we got this by running "java -jar selenium-server-4.6.0.jar standalone" in terminal
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver= new FirefoxDriver();
            case "safari":
                return driver= new SafariDriver();
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
    public void quitBrowser(){
        //driver.quit();
        getDriver().quit();
        threadDriver.remove();
    }


    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
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
    public void logIn(){
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public void clickAllSongs() {
        WebElement clickAllSongsBtn = driver.findElement(By.xpath("//a[@class='songs']"));
        clickAllSongsBtn.click();
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.song-list-wrap.main-scroll-wrap.all-songs")));
        Assert.assertTrue(allSongs.isDisplayed());

    }


    @DataProvider(name="invalidCredentials")
    public static Object [][] getCredentials(){
        return new Object[][]{
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"",""}
        };
    }
}



