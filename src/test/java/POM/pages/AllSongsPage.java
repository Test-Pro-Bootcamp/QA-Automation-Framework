package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage{
    By shuffleBtn = By.xpath("//button[@title='Shuffle all songs']");
    By clearBtn = By.xpath("//button[contains(@title,'Clear')]");
    By playingSong = By.xpath("//div[contains(@class, 'playing')]");
    By bestSong = By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]");

    public AllSongsPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public void clickShuffleBtn(){
        driver.findElement(shuffleBtn).click();
    }

    public void clickToPlaySong(){
        actions.doubleClick(driver.findElement(bestSong)).perform();
    }

    public boolean songIsPlaying(){
        driver.findElement(playingSong).isDisplayed();
        return true;
    }
    public boolean clearBtnIsDisplayed(){
        driver.findElement(clearBtn).isDisplayed();
        return true;
    }
}
