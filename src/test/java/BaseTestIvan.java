import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class  BaseTestIvan {

    WebDriver driver;
    WebDriverWait wait;
    String url;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = "https://bbb.testpro.io/";
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

    public void emailLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.sendKeys("fedorov.ivan@hotmail.com");
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();



    }
    public void newPlaylist() {
        WebElement newPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='fa fa-plus-circle create']")));
        newPlayList.click();
        WebElement createPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='New Playlist']")));
        createPlayList.click();
        WebElement inputPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='↵ to save']")));
        inputPlayList.click();
        inputPlayList.sendKeys("super");
        inputPlayList.sendKeys(Keys.RETURN);
    }

    @DataProvider( name="invalidCredentials")
    public static Object[][] getCredentials(){
        return new Object[][]{
                {"invalid@class.com", "invalispass"},{"dfdfs@clas.com", ""},{"",""}
        };

    }
}
