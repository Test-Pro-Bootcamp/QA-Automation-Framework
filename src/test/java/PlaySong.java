import POM.pages.AllSongPage;
import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest {


    @Test
    public void playSong()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongPage songsPage = new AllSongPage(driver);
       // login();
        loginPage.login();
        //chooseAllSongs();
        homePage.clickOnAllSongs();
        //contextClickFirstSong();
        songsPage.contextClickFirstSong();
       // choosePlay();
        songsPage.playFromContextMenu();
       // Assert.assertTrue(isSongPlaying());
        Assert.assertTrue(songsPage.isSongPlaying());
    }

//
    private void chooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid= 'sound-bar-play'"));
        return soundBarVisualizer.isDisplayed();
    }


     @Test
  void hoverOverPlayButton()  {

        login();
        chooseAllSongs();
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



