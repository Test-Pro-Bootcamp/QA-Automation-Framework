

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;


public class BaseTest {
    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe")


        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {

        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public void tearBrowser() {


    }



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


    @DataProvider(name = "invalidCredentials")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"invalid@gmail.com", "invalidPass"},
                {"d@gmail.com", ""},
  
    }

    public void login(){


        provideEmail("kaflimeerim@gmail.com");

        provideEmail("demo@class.com");

        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
