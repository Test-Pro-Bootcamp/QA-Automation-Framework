import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    Actions actions;
    public String url;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        //driver = new ChromeDriver();
        driver = pickBrowser(System.getProperty("browser"));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        url = BaseURL;
        driver.get(url);
    }
    private WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.33:4444";
        switch (browser){
            case "firefox":
                return driver = new FirefoxDriver();
            case "edge":
                return driver = new ChromeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),capabilities);
            default:
                return driver = new EdgeDriver();
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    public void navigateToPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public static void provideEmail(String email){
        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton=driver.findElement(By.xpath("//*[@type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
}
