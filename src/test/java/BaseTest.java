import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

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


        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }

   // @BeforeTest
   // public void login() {
       // By emailLocator = By.xpath("//input[@placeholder='Email Address']");
        //wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
       // WebElement emailField = driver.findElement(emailLocator);
       // emailField.click();
       // emailField.sendKeys("holostenco.yuliya@gmail.com");

       // By passwordLocator = By.xpath("//input[@type='password']");
       // wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
       // WebElement passwordField = driver.findElement(passwordLocator);
        //passwordField.click();
        //passwordField.sendKeys("te$t$tudent");

       // By submitButtonLocator = By.xpath("//button[@type='submit']");
       // wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
       // driver.findElement(submitButtonLocator).click();





    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}
