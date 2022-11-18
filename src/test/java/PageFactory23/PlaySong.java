package PageFactory23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaySong extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        LoginPage1 loginPage = new LoginPage1(driver);
        AllSongsPage songsPage = new AllSongsPage(driver);
        BasePage1 homePage = new HomePage1(driver);

        loginPage.login();
        homePage.clickOnAllSongs();
        songsPage.contextClickFirstSong();
        songsPage.playFromContextMenu();
        Assert.assertTrue(songsPage.isSongPlaying());
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    @Test
    void hoverOverPlayButton() {
        login();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
        hoverPlay().click();
        Assert.assertTrue(isSongPlaying());
    }

    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return play;
    }
}
