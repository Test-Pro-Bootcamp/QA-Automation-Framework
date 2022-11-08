package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By createNewPlaylistButtonLocator = By.xpath("//*[@title='Create a new playlist']");
    private By newPlaylistDropdownMenuElementLocator = By.xpath("//*[contains(text(),\"New Playlist\")]");
    private By newPlaylistNameFieldLocator = By.xpath("//*[contains(@placeholder, 'to save')]");
    private By popUpMessageLocator = By.cssSelector("div.success.show");
    private String myPlaylistName = "Iulia's Playlist1";
    private By avatarLocator = By.cssSelector("img.avatar");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public String getConfirmationPopUpText() {
        WebElement notificationMessage = driver.findElement(popUpMessageLocator);
        waitForVisibilityOfElement(notificationMessage);
        return driver.findElement(popUpMessageLocator).getText();
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

        WebElement newPlaylistFromDropdownMenu = driver.findElement(newPlaylistDropdownMenuElementLocator);
        newPlaylistFromDropdownMenu.click();
    }
    public void enterNewPlaylistName(){
        WebElement newPlaylistNameField = driver.findElement(newPlaylistNameFieldLocator);
        waitForVisibilityOfElement(newPlaylistNameField).click();
        newPlaylistNameField.sendKeys(myPlaylistName + "\n");
    }
}
