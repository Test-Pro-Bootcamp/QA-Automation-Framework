package PagesIvaF;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageIvan extends BasePageIvan {
    By avatarLocator = By.cssSelector("img.avatar");
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createPlaylistButton;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistOption;

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;




    public HomePageIvan(WebDriver givenDriver){
        super(givenDriver);

    }
    public WebElement getUserAvatar()
    {
        return driver.findElement(avatarLocator);
    }
    public boolean isUserAvatarDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarLocator)).isDisplayed();

        return driver.findElement(avatarLocator).isDisplayed();
    }
    public void createPlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.RETURN);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
    }

    public int getNumberOfPlaylist() {
        return playlists.size();
    }

}
