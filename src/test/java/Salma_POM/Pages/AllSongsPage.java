package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    String songName = "Waiting On A Train";
//Locators
//    By shuffleBtnLocator = By.xpath("//button[@data-test='btn-shuffle-all']");
//   // By firstSongLocator = By.xpath(" //*[@id='songsWrapper']//div[1]/table/tr[1]");
//    By firstSongLocator = By.cssSelector(" tr.song-item");
//    By songLocator = By.xpath("//td[contains(text() , '"+ songName + "')]");
//    By addToBtnLocator = By.cssSelector("button.btn-add-to");
    //  By favoritesDropDownLocator = By.xpath("//section[@id='songsWrapper']//li[@class='favorites']");
    //Locators with Page factory

    @FindBy(xpath=" //button[@data-test='btn-shuffle-all']")
    WebElement shuffleBtn;
    @FindBy(xpath="//td[contains(text(),'Waiting On A Train')]")
    WebElement songElement;
    @FindBy(css="button.btn-add-to")
    WebElement addToBtn;
    @FindBy (xpath ="//section[@id='songsWrapper']//li[@class='favorites']")
    WebElement favoritesDropDown;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void shuffle(){
//        driver.findElement(shuffleBtnLocator).click();
        wait.until(ExpectedConditions.visibilityOf(shuffleBtn));
        shuffleBtn.click();
    }

    public void doubleClickSong() {
//        WebElement firstSongElement = driver.findElement(firstSongLocator);
//      actions.doubleClick(firstSongElement).perform();
        wait.until(ExpectedConditions.visibilityOf(songElement)).isDisplayed();
        actions.doubleClick(songElement).perform();
    }

    public void chooseSongFromAllSongs() {
//        WebElement songElement = driver.findElement(songLocator);
//        songElement.click();
        songElement.click();
    }
    public void clickAddToButton(){
//        WebElement addToBtn = driver.findElement(addToBtnLocator);
//        addToBtn.click();
        wait.until(ExpectedConditions.visibilityOf(addToBtn));
        addToBtn.click();
    }
    public void chooseFavoritesFromMenu(){
//        WebElement favoritesDropDown = driver.findElement(favoritesDropDownLocator);
//        favoritesDropDown.click();
        favoritesDropDown.click();
    }

}