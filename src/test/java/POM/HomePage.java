package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    By createNewPlaylistButtonLocator = By.xpath("//*[@title='Create a new playlist']");
    By popUpMessageLocator = By.cssSelector("div.success.show");
    String myPlaylistName = "Iulia's Playlist1";
    By avatarLocator = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getAvatarIcon() {
        return driver.findElement(avatarLocator);
    }

    public boolean userAvatarIsDisplayed() {
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public void createNewPlaylist() {
        WebElement createANewPlaylistElement = driver.findElement(createNewPlaylistButtonLocator);
        waitForElementToBeClickable(createANewPlaylistElement).click();

        WebElement newPlaylistLink = driver.findElement(By.xpath("//*[contains(text(),\"New Playlist\")]"));
        newPlaylistLink.click();

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[contains(@placeholder, 'to save')]"));
        waitForVisibilityOfElement(newPlaylistNameField).click();
        newPlaylistNameField.sendKeys(myPlaylistName + "\n");
    }
}
