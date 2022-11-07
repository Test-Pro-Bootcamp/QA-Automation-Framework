package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//button[@title='Shuffle all songs']")
    WebElement shuffleBtn;
    @FindBy(xpath = "//button[contains(@title,'Clear')]")
    WebElement clearBtn;
    @FindBy(xpath = "//div[contains(@class, 'playing')]")
    WebElement playingSong;
    @FindBy(xpath = "//tr[@class='song-item']//td[contains(text(),'a Beat')]")
    WebElement bestSong;

    public AllSongsPage (WebDriver givenDriver){
        super(givenDriver);
    }
    public AllSongsPage clickShuffleBtn(){
        shuffleBtn.click();
        return this;
    }
    public AllSongsPage clickToPlaySong(){
        actions.doubleClick(bestSong).perform();
        return this;
    }
    public boolean songIsPlaying(){
        playingSong.isDisplayed();
        return true;
    }
    public boolean clearBtnIsDisplayed(){
        clearBtn.isDisplayed();
        return true;
    }
}
