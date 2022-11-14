import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class BaseTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;
    static ThreadLocal<WebDriver> threadDriver;

    static String newPlaylistName = "Nozima's Songs";


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
    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        driver = pickBrowser(System.getProperty("browser"));
        actions = new Actions(driver);
        // Make webdriver load the pages REALLY slow
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        ChromiumNetworkConditions networkConditions = new ChromiumNetworkConditions();
//        networkConditions.setDownloadThroughput(100 * 1024);
//        networkConditions.setUploadThroughput(500 * 1024);
//        networkConditions.setLatency(Duration.ofMillis(5000));
//        ((HasNetworkConditions) augmentedDriver).setNetworkConditions(networkConditions);
        // (comment out above lines to remove throttling)

        // Wait for an element to show up for max of X seconds
        // implicitlyWait(Duration.ofSeconds(60) will wait for UP to 60 seconds
        // if element comes up after 1 second, it will move on
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // thread.sleep(60000) -- will wait 60s always
        url = baseURL;
        driver.get(url);

    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.2:4444";
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
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
            default:
                return driver = new ChromeDriver();
        }
    }

    public void logIn(String email, String password) {
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void createPlaylist() {
        driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(newPlaylistName, Keys.ENTER);
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");//setting system properties of FirefoxDriver
//        driver = new FirefoxDriver(); //creating an object of FireFox Driver (FireFox Driver declaration)
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        getDriver().get(BaseURL);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "nozishka86";
        String authkey = "6P2kntJAyxKhTfJZ2jxDSD34Rr3GEtJpbfyefcZ4IQbppC6TMD";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("resolution","1440x900");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "106.0");
        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://localhost:4444/";

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "MicrosoftEdge":
                System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
                return driver = new EdgeDriver();
            case "grid-edge":
                capabilities.setCapability("browserName", "MicrosoftEdge");
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
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    protected static void goToMyPlaylist() {
        WebElement nozimaPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Nozima')]"));
        nozimaPlaylist.click();
    }

    protected static void selectMyPlaylist() {
        WebElement myPlaylist = driver.findElement(By.xpath("//li[@class='playlist']"));
        myPlaylist.click();
    }

    protected static void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[contains(@title,'Add')]"));
        addToBtn.click();
    }

    protected static void clickSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        song.click();
    }

    public static void clickAllSongsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All Songs']"))).click();
    }
}

//    @DataProvider(name = "invalidCredentials")
//    public static Object[][] getCredentials() {
//        return new Object[][]{
//                {"invalid@class.com", "invalidPass"},
//                {"d@class.com", ""},
//                {"", ""}
//        };
//    }
//}





