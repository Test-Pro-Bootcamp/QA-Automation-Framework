package POM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.List;

public class FavoritesPage extends BasePage {
    @FindBys(
            @FindBy(xpath = "//section[@id='favoritesWrapper']//tr[@class='song-item']")
    )
    List<WebElement> favePlaylistItems;

    @FindBy (xpath = "//div[@class='song-list-wrap main-scroll-wrap favorites']")
    WebElement highlightAllFaves;


    @FindBy(xpath = "//button[@title='Unlike Pluto by Makaih Beats']")
    WebElement likedPlutoSong;

    @FindBy(xpath = "//button[@title='Unlike BornKing by Makaih Beats']")
    WebElement likedBornKingSong;

    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap favorites']//button[@title='Unlike Epic Song by BoxCat Games']")
    WebElement likedEpicSong;

    @FindBy(xpath = "//div[contains(text(),'No favorites')]")
    WebElement noFaves;

    @FindBy(xpath = "//div[@class='item-container']//button[@title='Unlike Dark Days by Grav']")
    WebElement likedSong;

    @FindBy(xpath = "//li[@class='download']")
    WebElement downloadOption;


    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean isSongPlutoLiked() {
        wait.until(ExpectedConditions.visibilityOf(likedPlutoSong)).isDisplayed();
        return true;
    }

    public boolean isSongBornKingLiked() {
        wait.until(ExpectedConditions.visibilityOf(likedBornKingSong)).isDisplayed();
        return true;
    }

    public boolean isSongEpicLiked() {
        wait.until(ExpectedConditions.visibilityOf(likedEpicSong)).isDisplayed();
        return true;
    }

    public boolean noFavesDisplayed() {
        noFaves.isDisplayed();
        return true;
    }

    public boolean likedSongDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(likedSong)).isDisplayed();
        return true;
    }

    public boolean threeLikedSongs() {
        return favePlaylistItems.size() == 3;
    }
    public void deleteAllLikedSongs() {
        wait.until(ExpectedConditions.visibilityOf(highlightAllFaves)).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }
    public FavoritesPage rightClickBornKingHeart() {
//        WebElement heartBtnBornKing = driver.findElement(By.xpath("//button[@title='Unlike BornKing by Makaih Beats']"));
        actions.contextClick(likedBornKingSong).perform();
        return this;
    }

    public boolean isDownloadOptionThere() {
        wait.until(ExpectedConditions.visibilityOf(downloadOption)).isDisplayed();
        return true;
    }
}