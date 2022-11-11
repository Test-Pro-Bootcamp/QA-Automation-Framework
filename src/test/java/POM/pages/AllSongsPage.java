package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    //Locators
    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By firstSongLocator = By.xpath("//section[@id='songsWrapper']//tr[@class='song-item'][1]/td[2]");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPage shuffle(){
        driver.findElement(shuffleBtnLocator).click();
        return this;
    }

    public void doubleClickFirstSong() {
        WebElement firstSong = driver.findElement(firstSongLocator);
        actions.doubleClick(firstSong).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarPlayLocator));
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
