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
import java.time.Duration;

public class BaseTestIntern {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;



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
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "geckodriver");

        actions = new Actions(driver);

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
        provideEmail("trangoishi99@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
