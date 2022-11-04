import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class naldoury_BaseTest {

    public WebDriver driver;
    public String url = "https://bbb.testpro.io/";

    @BeforeSuite
    public void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        adjusted chrome window to full screen
        driver.get(url);
    }



    public void setEmailField(String email) {
        WebElement emailField = driver.findElement(new By.ByCssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(new By.ByCssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void submit() {
        WebElement submitButton = driver.findElement(new By.ByCssSelector("[type='submit']"));
        submitButton.submit();
//        WebElement avatarIcon = driver.findElement( By.className("avatar"));
//        Assert.assertTrue(avatarIcon.isDisplayed());
    }

//    public void logIn() {
//        setEmailField(email);
//        setPassword(password);
//        submit();
//    }






















}
