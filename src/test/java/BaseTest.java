import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url = "https://bbb.testpro.io/";
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
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public void providePassword(String password ) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void provideEmail(String email) {
        driver.findElement(usernameLocator).sendKeys(email);
    }
    public void clickSubmitBtn() {
        driver.findElement(loginButton).click();
    }
    public void logIn(){
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmitBtn();
    }
}