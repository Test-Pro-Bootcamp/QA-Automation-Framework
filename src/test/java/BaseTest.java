import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    /* @BeforeMethod
     static void setupClass(){
         WebDriverManager.chromedriver().setup();
     }*/
    @BeforeMethod
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    protected static void navigateToPage(){
        String url = "https://bbb.testpro.io/";
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
