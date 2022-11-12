package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private By createNewPlaylistButtonLocator = By.xpath("//*[@title='Create a new playlist']");
    private By newPlaylistDropdownMenuElementLocator = By.xpath("//*[contains(text(),\"New Playlist\")]");
    private By newPlaylistNameFieldLocator = By.xpath("//*[contains(@placeholder, 'to save')]");
    private By playlistLocator =By.xpath("//ul//li[@class='playlist playlist']");
   private By playlistToBeDeletedLocator = By.xpath("//li[text()='Delete']");
    private By popUpMessageLocator = By.cssSelector("div.success.show");
    private String myPlaylistName = "Iulia's Playlist";
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
        waitForElementToBeClickable(driver.findElement(createNewPlaylistButtonLocator)).click();
        waitForElementToBeClickable(driver.findElement(newPlaylistDropdownMenuElementLocator)).click();

    }
    public void enterNewPlaylistName(){
        waitForVisibilityOfElement(driver.findElement(newPlaylistNameFieldLocator)).click();
        driver.findElement(newPlaylistNameFieldLocator).sendKeys(myPlaylistName + "\n");
    }
    public void chooseAPlaylist(){
        waitAndContextClickWebElement(driver.findElement(playlistLocator));
    }
    public void deleteSelectedPlaylist(){
        waitForElementToBeClickable(driver.findElement(playlistToBeDeletedLocator)).click();
    }
    }
