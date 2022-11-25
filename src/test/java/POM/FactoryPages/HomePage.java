package POM.FactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css="img.avatar")
    WebElement avatarLocator;
    @FindBy(css="[data-testid = 'sound-bar-play']")
    WebElement soundBarPlayLocator;
    @FindBy(css="li a.songs")
    WebElement allSongsMenuItemLocator;

    public HomePage(WebDriver sentDriver) {
        super  (sentDriver);
    }

    public WebElement getUserAvatar(){
        return avatarLocator;
    }

    public boolean isUserAvatarDisplayed(){
        return avatarLocator.isDisplayed();
    }
    public boolean isSongPlaying() {
        return soundBarPlayLocator.isDisplayed();
    }

    public void clickOnAllSongs() {
        allSongsMenuItemLocator.click();
    }
}