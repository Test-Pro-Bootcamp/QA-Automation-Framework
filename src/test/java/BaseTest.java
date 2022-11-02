import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    static String newPlaylistName = "Nozima's Songs";

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    public void logIn(String email, String password ){
    driver.findElement(By.xpath("//*[@type='email']")).sendKeys(email);
    driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void createPlaylist(){
        driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(newPlaylistName,Keys.ENTER);
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected static void goToMyPlaylist() {
        WebElement nozimaPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Nozima')]"));
        nozimaPlaylist.click();
    }

    protected static void selectMyPlaylist() {
        WebElement myPlaylist = driver.findElement(By.xpath("//li[@class='playlist']"));
        myPlaylist.click();
    }

    protected static void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addToBtn.click();
    }

    protected static void clickSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        song.click();
    }

    public void clickAllSongsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All Songs']"))).click();
    }
}
