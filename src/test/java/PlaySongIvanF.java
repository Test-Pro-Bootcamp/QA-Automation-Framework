import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class PlaySongIvanF extends BaseTestIvan{
    @Test
   public void playSong()  {
        emailLogin();
        clickAllSongs();
        getContextMenu();
        clickPlayMenuBt();
        verifyVisualizer();
   }

    private void verifyVisualizer() {
        By playBarLocator = By.cssSelector("[data-testid='sound-bar-play']");
        WebElement visualizer = driver.findElement(playBarLocator);
        Assert.assertTrue(visualizer.isDisplayed());
    }

    private void clickPlayMenuBt() {
        By playItemLocator = By.cssSelector(".playback");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playItemLocator));
        driver.findElement(playItemLocator).click();

    }

    private void getContextMenu() {
        By songLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(songLocator));
        WebElement firstSong = driver.findElement(songLocator);
        actions.contextClick(firstSong).perform();
    }

    private void clickAllSongs() {
        By allSongsSelectors = By.cssSelector(".menu .songs");
        driver.findElement(allSongsSelectors).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSongsSelectors));
    }
    @Test
    void hoverOverPlayButton(){
        emailLogin();
        clickAllSongs();
        hoverPlay();
        hoverPlay().click();
    }

    private WebElement hoverPlay() {
        WebElement play= driver.findElement(By.cssSelector("[data-testid=\"play-btn\"]"));
        actions.moveToElement(play).perform();
        return play;
    }
    @Test
    public void listOfSongWebElements(){
        emailLogin();
        choosePlayListByName("super");
        getListOfTheSongs();
        Assert.assertEquals(getListOfTheSongs().size(),3);



    }

    private List getListOfTheSongs() {
        return driver.findElements(By.cssSelector("#playlistWrapper td.title"));
    }

    private void choosePlayListByName(String name) {
        By playListLocator = By.xpath( "//a[contains(text(), '" + name + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListLocator)).click();


    }
    @Test
    public void changeNameOfPlyList() {

        emailLogin();
        doubleClickPlayList();
        enterPlayListName();
        Assert.assertTrue(doesPlayListExist());
    }

    private boolean doesPlayListExist() {
        WebElement playListElement = driver.findElement(By.xpath("//a[text()='Super3333']"));
        return playListElement.isDisplayed();
    }

    private void enterPlayListName(){
        By playListInputfield = By.cssSelector("input[name='name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListInputfield));
        WebElement playListInput = driver.findElement(By.cssSelector("input[name='name']"));
        playListInput.sendKeys((Keys.chord(Keys.COMMAND,"a", Keys.BACK_SPACE)));
        playListInput.sendKeys("Super3333");
        playListInput.sendKeys(Keys.ENTER);

    }

    private void doubleClickPlayList() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        WebElement element = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        actions.doubleClick(element).perform();

    }

}
