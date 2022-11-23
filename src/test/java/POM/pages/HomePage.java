package POM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    //Web Elements
    @FindBy(xpath="//button[@data-testid='home-view-all-recently-played-btn']")
    WebElement viewAllBtn;

    @FindBy(xpath="//img[contains(@alt,'Avatar of')]")
    WebElement myAvatarIcon;

    @FindBy(css="#searchForm>input")
    WebElement searchForm;

    @FindBy(xpath="//h1/i[@role=\"button\"]")
    WebElement createNewPlaylistBtn;

    @FindBy(xpath="//li[contains(text(), 'New Playlist')]")
    WebElement newPlaylistOption;

    @FindBy(xpath="//form/input[@name]")
    WebElement newPlaylistForm;

    public HomePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public ViewAllPage clickViewAllSongs() {
        viewAllBtn.click();
        return new ViewAllPage(driver);
    }

    public HomePage clickViewMyProfile() {
        this.myAvatarIcon.click();
        return this;
    }

    public HomePage searchSong(String songName) {
        searchForm.sendKeys(songName);
        return this;
    }

    public HomePage createNewPlaylist(String playlistName) {
        createNewPlaylistBtn.click();
        newPlaylistOption.click();
        newPlaylistForm.sendKeys(playlistName);
        newPlaylistForm.sendKeys(Keys.RETURN);
        return this;
    }

}
