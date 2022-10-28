import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    public void getBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    public void login( String email, String password) throws InterruptedException {

        WebElement emailAddressField = driver.findElement(By.xpath("//input[@type='email']"));
        emailAddressField.sendKeys(email);
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
    }

