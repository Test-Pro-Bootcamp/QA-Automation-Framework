import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.time.Duration;


public class BaseTest {

    static WebDriver driver;
    static String url;
    static WebDriverWait wait;

    public static void browserConfigs() {

        driver.get(url);
        url = "https://bbb.testpro.io/";
        driver.manage().window().maximize();
        provideEmail("dankoyankaa@gmail.com");
        providePassword("te$t$tudent");
    }

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

    @DataProvider(name = "loginProvider")
    public static Object[][] credentials() {
        return new Object[][]{
                {"dankoyanka@gmail.com", "te$t$tudent" },
        };

    }

    public static void provideEmail(String email) {
        WebElement emailField = BaseTest.driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = BaseTest.driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmitBtn() {
        WebElement loginButton = BaseTest.driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public static void deletePlaylist()  {

        WebDriverWait locatePlaylist = new WebDriverWait(driver, Duration.ofSeconds(10));
        locatePlaylist.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li[@class='playlist playlist']"))).click();


        WebDriverWait clickDelete = new WebDriverWait(driver, Duration.ofSeconds(10));
        clickDelete.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@class='del btn-delete-playlist']"))).click();
//
//        WebDriverWait okDeleteBtn = new WebDriverWait(driver, Duration.ofSeconds(10));
////        okDeleteBtn.until(ExpectedConditions.elementToBeClickable
//                (By.xpath("//button[@class='ok']"))).click();
    }


    public WebElement getConfirmationPopUpText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return driver.findElement(By.cssSelector("div.success.show"));
    }

//    public WebElement confirmDelete() {
//        WebElement confirmDelete = driver.findElement
//                (By.xpath(" //div[@class='success show']"));
//        Assert.assertTrue(confirmDelete.isDisplayed());
//        return confirmDelete;
    }



//        WebElement confirmDelete = driver.findElement
//                (By.xpath(" //div[@class='success show']"));
//        Assert.assertTrue(confirmDelete.isDisplayed());
//    }



//    public void login( String email, String password) throws InterruptedException {
//
//        WebElement emailAddressField = driver.findElement(By.xpath("//input[@type='email']"));
//        emailAddressField.sendKeys(email);
//        Thread.sleep(2000);
//
//        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
//        passwordField.sendKeys(password);
//        Thread.sleep(2000);
//
//        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        loginButton.click();
//

