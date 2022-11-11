package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    String songName = "Waiting On A Train";
//Locators
    By shuffleBtnLocator = By.xpath("//section[@id='songsWrapper']//i[@class='fa fa-random']");
   // By firstSongLocator = By.xpath(" //*[@id='songsWrapper']//div[1]/table/tr[1]");
    By firstSongLocator = By.cssSelector(" tr.song-item");
    By songLocator = By.xpath("//td[contains(text() , '"+ songName + "')]");
    By addToBtnLocator = By.cssSelector("button.btn-add-to");
    By favoritesDropDownLocator = By.xpath("//section[@id='songsWrapper']//li[@class='favorites']");
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void shuffle(){
        driver.findElement(shuffleBtnLocator).click();
    }

    public void doubleClickFirstSong(){
        WebElement firstSongElement = driver.findElement(firstSongLocator);
        actions.doubleClick(firstSongElement).perform();
    }

    public void chooseSongFromAllSongs() {
        WebElement songElement = driver.findElement(songLocator);
        songElement.click();
    }
    public void clickAddToButton(){
        WebElement addToBtn = driver.findElement(addToBtnLocator);
        addToBtn.click();
    }
    public void chooseFavoritesFromMenu(){
        WebElement favoritesDropDown = driver.findElement(favoritesDropDownLocator);
        favoritesDropDown.click();
    }

}
