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
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (enabled=true, priority = 1)// (priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest () {

        login();
        //checkAvatar();
        // driver.findelement(how to find the element)
        // |
        // var = how to find element
        // driver.findelement(var)

//        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
//
//
//        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        WebElement avatarIcon = driver.findElement(avatarIconLocator);
//        Assert.assertTrue(avatarIcon.isDisplayed());
        By playlistLocator = By.cssSelector("#playlists h1");
//        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));
    }

    @Test(enabled = true, priority = 2)
    public void LoginInvalidEmailPasswordTest () throws InterruptedException {
        provideEmail("dem@class.com");
        providePassword("");
        clickSubmitBtn();

        // Vd
        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = true)
    public void LoginValidEmailEmptyPasswordTest () {

        provideEmail("demo@class.com");
        //providePassword("");
        clickSubmitBtn();
    }

    @Test(enabled = true)
    public void SwitchToSongsMenu () throws InterruptedException {

        //By avatarSelector = By.cssSelector("[alt='Avatar of student']");
        login();

        //By songMenuSelector = By.className("songs");
       // By allButtonSelector = By.className("btn-shuffle-all");

        WebElement songMenuSelector = wait.until(ExpectedConditions.elementToBeClickable( By.className("songs")));
        //WebElement songsMenu = driver.findElement(songMenuSelector);
        //driver.findElement(songMenuSelector).click(); //refactor ths
//        wait.until(ExpectedConditions.elementToBeClickable(songMenuSelector));
        songMenuSelector.click();
        WebElement allButtonSelector = wait.until(ExpectedConditions.elementToBeClickable( By.className("btn-shuffle-all")));
        //wait.until(ExpectedConditions.elementToBeClickable(songMenuSelector));
        Assert.assertTrue(allButtonSelector.isDisplayed());


        //driver.quit();
    }

    @Test(enabled = true)
    public void SearchSong () throws InterruptedException {
        login();
//
        //By searchBarSelector = By.id("searchForm");
       // By allButtonSelector = By.className("btn-shuffle-all");

        WebElement searchBarSelector =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchBarSelector.click();
        // WebElement songsMenu = driver.findElement(songMenuSelector);
        searchBarSelector.sendKeys("Veggie Straws");
       // driver.findElement(searchBarSelector).sendKeys("Veggie Straws");
        //Assert.assertTrue(driver.findElement().isDisplayed());


    }

}
