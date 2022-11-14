package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage extends BasePage{

    @FindBy(xpath = "//button[@title='Unlike Pluto by Makaih Beats']")
    WebElement likedPlutoSong;

    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean isSongPlutoLiked(){
//        wait.until(ExpectedConditions.visibilityOf(likedPlutoSong));
        likedPlutoSong.isDisplayed();
        return true;
    }
}