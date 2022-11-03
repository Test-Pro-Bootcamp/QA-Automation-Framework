import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;


public class BaseTest {

    static WebDriver driver;
    static String url;
    static WebDriverWait wait;
    static Actions action;

    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void getBrowser(String baseURL) {
        driver = new ChromeDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    @DataProvider(name = "loginProvider")
    public static Object[][] credentials() {
        return new Object[][]{
                {"dankoyanka@gmail.com", "te$t$tudent"},
        };
    }

    public static void provideEmail(String email) {
       wait.until(ExpectedConditions.visibilityOfElementLocated
               (By.xpath("//input[@type='email']"))).sendKeys(email);;
    }

    public static void providePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@type='password']"))).sendKeys(password);;
    }

    public static void clickSubmitBtn() {
        WebElement loginButton = BaseTest.driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }



    public void doubleClickChoosePlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(webElement).perform();
    }

    public void choosePlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    }

    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Party Hits");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean locateNewPlaylistName() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Party Hits']"));
        return playlistElement.isDisplayed();
    }
}



