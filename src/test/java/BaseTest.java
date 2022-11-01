
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    String url;
    Actions actions;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        url = baseURL;
        driver.get(url);

    }
    @AfterMethod
    public void quitBrowser(){

        driver.quit();
    }


    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
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
    public void logIn(){
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public void clickAllSongs() {
        WebElement clickAllSongsBtn = driver.findElement(By.xpath("//a[@class='songs']"));
        clickAllSongsBtn.click();
         WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.song-list-wrap.main-scroll-wrap.all-songs")));
        Assert.assertTrue(allSongs.isDisplayed());

    }


    @DataProvider(name="invalidCredentials")
    public static Object [][] getCredentials(){
       return new Object[][]{
               {"invalid@class.com", "invalidPass"},
               {"d@class.com", ""},
               {"",""}
       };
    }
}

