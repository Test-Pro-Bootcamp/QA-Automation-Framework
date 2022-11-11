import POM.pages.AllSongsPage;
import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = false, priority = 0)
    public void LoginEmptyEmailPasswordTest () {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

/*    @Test (enabled=true, priority = 1)// (priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest () {

        login();

        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
        By playlistLocator = By.cssSelector("#playlists h1");

        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
        WebElement avatarIcon = getDriver().findElement(avatarIconLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(playlistLocator), "PLAYLISTS"));
    }*/

    // Test with POM
    @Test
    public void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }

    // Test with POM for allpage
    @Test
    public void Shuffle(){
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = loginPage.login();

        homePage.clickOnAllSongs()
                .shuffle();
        Assert.assertTrue(homePage.isSongPlaying());

    }

    @Test
    public void PlayASongFromAllSongs() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homey = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        //Step1: Login
        loginPage.login();
        //Step2: Click on All Songs
        homey.clickOnAllSongs();
        //Step3: double click on first song
        allSongsPage.doubleClickFirstSong();
        //Step4: check if song is playing
        Assert.assertTrue(homey.isSongPlaying());
    }


    @Test(enabled = false, priority = 2)
    public void LoginInvalidEmailPasswordTest () throws InterruptedException {
        provideEmail("dem@class.com");
        providePassword("");
        clickSubmitBtn();

        // Vd
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test(enabled = false)
    public void LoginValidEmailEmptyPasswordTest () {
        WebDriver driver;
        driver = new ChromeDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        getDriver().get(url);

        WebElement emailField = getDriver().findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        passwordField.click();

        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement avatarIcon = getDriver().findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        getDriver().quit();
    }

    @Test(enabled = false)
    public void SwitchToSongsMenu () throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        getDriver().get(url);
        By emailSelector = By.cssSelector("[type='email']");
        WebElement emailField = getDriver().findElement(emailSelector);
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        By avatarSelector = By.cssSelector("[alt='Avatar of student']");
        By songMenuSelector = By.className("songs");
        By allButtonSelector = By.className("btn-shuffle-all");

        emailField.click();
        emailField.sendKeys("demo@class.com");
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        submitButton.click();
        Assert.assertTrue(getDriver().findElement(avatarSelector).isDisplayed());
        getDriver().findElement(songMenuSelector).click();
        Assert.assertTrue(getDriver().findElement(allButtonSelector).isDisplayed());
        Thread.sleep(2000);

        getDriver().quit();
    }

    @Test(enabled = false)
    public void SearchSong () throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        getDriver().get(url);
        By emailSelector = By.cssSelector("[type='email']");
        WebElement emailField = getDriver().findElement(emailSelector);
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        By avatarSelector = By.cssSelector("[alt='Avatar of student']");
        By searchBarSelector = By.id("searchForm");
        By allButtonSelector = By.className("btn-shuffle-all");

        emailField.click();
        emailField.sendKeys("demo@class.com");
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        submitButton.click();
        Assert.assertTrue(getDriver().findElement(avatarSelector).isDisplayed());
        getDriver().findElement(searchBarSelector).click();
        getDriver().findElement(searchBarSelector).sendKeys("Veggie Straws");
        Thread.sleep(5000);


        url = "https://bbb.testpro.io/";
        getDriver().get(url);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        getDriver().quit();
    }

}
