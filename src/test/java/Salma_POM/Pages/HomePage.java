package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    //Declaring Locators
    //By avatarLocator = By.cssSelector("img.avatar");
    //By soundBarLocator = By.xpath("//img[@alt='Sound bars']");
    //Locators with Page Factory
    @FindBy(css="img.avatar")
    WebElement avatarImage;
    @FindBy(xpath = "//img[@alt='Sound bars']")
    WebElement soundBar;
    @FindBy(xpath = "//i[@data-testid='sidebar-create-playlist-btn']")
    WebElement addPlaylist;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy(xpath = "//*[@id='playlists']/form/input")
    WebElement newPlaylistTextField;
    @FindBy(xpath="//section[@id='playlists']")
    WebElement playlistSection;
    @FindBy(xpath="//div[@class='success show']")
    WebElement newPlaylistPopUp;
    String playlistName= "MyPlaylist";
    String shortPlaylist = "pl";
    String longPlaylist = "NewCollection";


    //Constructor method
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver,this);
    }

    //Getting user avatar
    public WebElement getUserAvatar(){
        // return driver.findElement(avatarLocator);
        return avatarImage;
    }
    //Method to verify user avatar is displayed
    public boolean isUserAvatarDisplayed(){
       wait.until(ExpectedConditions.visibilityOf(avatarImage));
        return avatarImage.isDisplayed();
    }

    public boolean isSongPlaying(){
        return wait.until(ExpectedConditions.visibilityOf(soundBar)).isDisplayed();

    }

    public void clickPlusBtn() {
        addPlaylist.click();
    }

    public void clickNewPlaylist() {
       newPlaylist.click();
    }

    public void enterNewPlaylistName() {
       wait.until(ExpectedConditions.visibilityOf(newPlaylistTextField)).sendKeys(playlistName);
       newPlaylistTextField.sendKeys(Keys.ENTER);
    }
    public void enterShortNewPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(newPlaylistTextField)).sendKeys(shortPlaylist);
        newPlaylistTextField.sendKeys(Keys.ENTER);
    }
    public void enterLongNewPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(newPlaylistTextField)).sendKeys(longPlaylist);
        newPlaylistTextField.sendKeys(Keys.ENTER);
    }

    public boolean isNewPlaylistAdded(){
        wait.until(ExpectedConditions.invisibilityOf(newPlaylistTextField));
        return playlistSection.getText().contains(playlistName);
    }
    public boolean isNewPlaylistPopUp(){
        return wait.until(ExpectedConditions.visibilityOf(newPlaylistPopUp)).isDisplayed();
    }
}