package Factory.pages;

import POM.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPageF extends BasePageF {

    //Locators
    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By firstSongLocator = By.cssSelector(".play");

    public AllSongsPageF(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPageF shuffle(){
        driver.findElement(shuffleBtnLocator).click();
        return this;
    }

    public void doubleClickFirstSong() {
        actions.doubleClick(driver.findElement(firstSongLocator));
    }

    public void contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }

    public void playFromContextMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }

    //Shuffle
    //Add to Favorite
    //PlaySong
    //SortByTitle
}
