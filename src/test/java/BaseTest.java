import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class BaseTest {
    WebDriver driver;


    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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

    public void login(String email, String password) throws InterruptedException {

        WebElement emailAddressField = driver.findElement(By.xpath("//input[@type='email']"));
        emailAddressField.sendKeys(email);
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }
 //start
 public void searchSong(String songTitle) throws InterruptedException{
     WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
     searchField.sendKeys(songTitle);
     Thread.sleep(1500);
 }
    public void createPlaylist() throws InterruptedException {
        WebElement createPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        createPlaylistIcon.click();
        Thread.sleep(2000);
    }
    public String getFirstSongResultText (){
        WebElement firstSongResult = driver.findElement(By.cssSelector(".results .details"));
        return firstSongResult.getText();
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector(".results .details"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSongResult).perform();
        Thread.sleep(2000);
    }
    public String getNotificationText(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }
    public void enterPlaylistName(String playlistName) throws InterruptedException {
        WebElement newPlaylistOption = driver.findElement(By.xpath("//li[text()=('New Playlist')]"));
        newPlaylistOption.click();
        WebElement newPlaylistNameTextField = driver.findElement(By.xpath
                ("//form[@name='create-simple-playlist-form']/input"));
        newPlaylistNameTextField.sendKeys(playlistName);
        Thread.sleep(2000);
        newPlaylistNameTextField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    public void addSongToPlaylist(String playlistName) throws InterruptedException{
        Thread.sleep(4000);
        selectFirstSongResult();
        Actions actions = new Actions(driver);
        WebElement addTo = driver.findElement(By.xpath("//li[contains(text(), 'Add To')]"));
        actions.moveToElement(addTo).perform();
        Thread.sleep(2000);
        WebElement playlistNameElement = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']" +
                "/li[contains(text(),'"+playlistName+"')]"));
        playlistNameElement.click();
        Thread.sleep(2000);
    }

}
