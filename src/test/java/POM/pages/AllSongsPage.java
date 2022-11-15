package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//button[contains(@title,'Shuffle')]")
    WebElement shuffleBtn;
    @FindBy(xpath = "//button[contains(@title,'Clear')]")
    WebElement clearBtn;
    @FindBy(xpath = "//div[contains(@class, 'playing')]")
    WebElement playingSong;
    @FindBy(xpath = "//tr[@class='song-item']//td[contains(text(),'a Beat')]")
    WebElement bestSong;

    String urlAllSongsPage = "https://bbb.testpro.io/#!/songs";

    public AllSongsPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public String getUrlAllSongsPage(){

        return urlAllSongsPage;
    }
    public AllSongsPage clickShuffleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(shuffleBtn)).click();
        return this;
    }
    public AllSongsPage clickToPlaySong(){
        actions.doubleClick(bestSong).perform();
        return this;
    }
    public boolean songIsPlaying(){
        wait.until(ExpectedConditions.visibilityOf(playingSong));
        return true;
    }
    public boolean clearBtnIsDisplayed(){
        clearBtn.isDisplayed();
        return true;
    }
}