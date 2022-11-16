package PagesIvaF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsIvan extends BasePageIvan {
    @FindBy (css = ".btn-shuffle-all")
    WebElement shuffleBtnLocator;
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement firstSongLocator;


    public AllSongsIvan(WebDriver givenDriver) {

        super(givenDriver);
    }
    public AllSongsIvan shuffle()
        {
        wait.until(ExpectedConditions.visibilityOf(shuffleBtnLocator));
        shuffleBtnLocator.click();
        return this;
    }

    public AllSongsIvan doubleClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOf(firstSongLocator));
        actions.doubleClick(firstSongLocator).perform();
        return this;

    }
    public AllSongsIvan contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
        return this;
    }

    public AllSongsIvan playFromContextMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
        return this;
    }
    public WebElement hoverPlay() {
        WebElement play= driver.findElement(By.cssSelector("[data-testid=\"play-btn\"]"));
        actions.moveToElement(play).perform();
        return play;
    }

}
