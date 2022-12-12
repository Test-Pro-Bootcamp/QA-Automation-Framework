package Intern.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritePageIntern extends BasePageIntern {

    public FavoritePageIntern(WebDriver givenDriver) {
        super(givenDriver);
    }
    public FavoritePageIntern selectSong(String songName) {
        driver.findElement(By.xpath("//section[@id='favoritesWrapper']//td[text()=" + songName+ "]"));
        return this;
    }
    public FavoritePageIntern deleteAllFavSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']")));
        WebElement favList = driver.findElement(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']"));
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.DELETE));
        return this;
    }

//    public void addSongtoFavorites() {
//
//    }
//    private getSongLocator() {
//
//    }
//    public void getSongText() {
//    }
//
//    public void checkSongInFavList() {
//    }
}
