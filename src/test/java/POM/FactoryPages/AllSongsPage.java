package POM.FactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    @FindBy(css = ".btn-shuffle-all")
    WebElement shuffleBtnLocator;
    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[15]")
    WebElement chosenSongLocator;

    public AllSongsPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    public void shuffleSongs() {
        shuffleBtnLocator.click();
    }

    public void doubleClickChosenSong() {
        actions.doubleClick(chosenSongLocator).perform();
    }

    public void contextClickChosenSong() {
        actions.contextClick(chosenSongLocator).perform();
    }
}
