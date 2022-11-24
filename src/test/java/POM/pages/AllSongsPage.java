package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage {

    By shufleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By chosenSongLocator = By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[15]");

    public AllSongsPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    public void shuffleSongs() {
        driver.findElement(shufleBtnLocator).click();
    }

    public void doubleClickChosenSong() {
        actions.doubleClick(driver.findElement(chosenSongLocator)).perform();
    }

    public void choseASong() {
        driver.findElement((By) chosenSongLocator).click();
    }
}
