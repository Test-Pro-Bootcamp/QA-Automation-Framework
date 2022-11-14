package t.pages;

import POM.pages.AllSongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BasePage_t {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url;

   By avatarLocator = By.cssSelector("img.avatar");
   //By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");
   By soundBarPlayLocator = By.xpath("//img[@alt=\"Sound bars\"]");
   By allSongsMenuItemLocator = By.cssSelector("li a.songs");

    public BasePage_t(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        actions = new Actions(driver);
//        driver = givenDriver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        actions = new Actions(driver);
        //PageFactory.initElements(driver,this);
    }

//    public BasePage_t() {
//    }

    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }

    public AllSongsPage clickOnAllSongs(){
        driver.findElement(allSongsMenuItemLocator).click();
        return new AllSongsPage(driver);
    }

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
    public void launchBrowser(@Optional String baseURL) {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        driver = new ChromeDriver();
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

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }



}
