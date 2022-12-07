import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    String url;
    Actions actions;

    By usernameLocator = By.xpath("//*[@type='email']");
    By passwordLocator = By.xpath("//*[@type='password']");
    By loginButton = By.xpath("//*[@type='submit']");
    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public void providePassword(String password ) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator)).sendKeys(password);
    }
    public void provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameLocator)).sendKeys(email);
    }
    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public void logIn(){
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmitBtn();
    }
}