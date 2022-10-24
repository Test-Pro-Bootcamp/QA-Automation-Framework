import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {


    static WebDriver driver;
    static String newPlaylistName = "Nozima's Songs";
    
    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }


    public static void clickSubmitBtn() {
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
    }

    public static void enterPassword(String password) {
            WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
            passwordField.click();
            passwordField.sendKeys(password);
    }

    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
            emailField.sendKeys(email);
    }

    public static void clickNewPlaylistBtn() {
        WebElement newPButton = driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']"));
        newPButton.click();
    }

    public static void clickDropDown() {
        WebElement dropDownOption = driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]"));
        dropDownOption.click();
    }

    public static void enterPlayListName() {
        WebElement playNameField = driver.findElement(By.xpath("//input[@name='name']"));
        playNameField.sendKeys(newPlaylistName);
        playNameField.sendKeys(Keys.ENTER);
    }

    @BeforeMethod
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    }