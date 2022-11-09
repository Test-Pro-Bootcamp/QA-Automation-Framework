

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.time.Duration;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.chromium.HasNetworkConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    String url;
    WebDriverWait wait;


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

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        url = BaseURL;
        driver.get(url);
    }

    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void clickSubmitBtn() {


        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

    }

    public void providePassword(String password) {

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

    }

    public void provideEmail(String email) {

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);


    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"invalid@gmail.com", "invalidPass"},
                {"d@gmail.com", ""},
                {"", ""},

        

    public void login(){


         provideEmail("kaflimeerim@gmail.com");
         providePassword("te$t$tudent");
         clickSubmitBtn();
    }
}
      
