package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritesPage extends BasePage{

    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public FavoritesPage selectSong(String songName){
        favSongs(songName).get(0).click();
        return this;
    }

    public boolean isSongRemoved(String songName) {
        return favSongs(songName).size() == 0;
    }

    public FavoritesPage deleteSong(String songName) {
        selectSong(songName);
        favSongs(songName).get(0).sendKeys(Keys.DELETE);
        return this;
    }

    public FavoritesPage deleteSelectedSong(String songName) {
        favSongs(songName).get(0).sendKeys(Keys.DELETE);
        return this;
    }

    private By getFavSongSelector(String songName){
        return By.xpath("//*[@id='favoritesWrapper']//td[text()='" +songName+ "']");
    }

    private List<WebElement> favSongs(String songName){
        return driver.findElements(getFavSongSelector(songName));
    }
}
