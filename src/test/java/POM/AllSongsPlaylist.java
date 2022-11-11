package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPlaylist extends BasePage{

    @FindBy(css = "[type='email']")
    WebElement emailInputField;
    @FindBy(css = "[type='password']")
    WebElement passwordInputField;
    @FindBy(css = "[type='submit']")
    WebElement submitButtonField;

    @FindBy(xpath = "//a[@class ='songs']")
    WebElement allSongs;

    @FindBy(xpath = "//section[@id ='songsWrapper']//tr[@class = 'song-item selected']")
    WebElement playFirstSong;
     @FindBy(css = ".playback")
     WebElement clickPlay;

    public AllSongsPlaylist(WebDriver mainDriver) {
        super(mainDriver);
    }

    public AllSongsPlaylist provideOwnEmail(String email) {
        emailInputField.sendKeys(email);
        return this;
    }
    public AllSongsPlaylist provideNewPassword(String password){
        passwordInputField.sendKeys(password);
        return this;
    }
    public AllSongsPlaylist clickSubmitBton() {
        submitButtonField.click();
        return this;
    }
    public void login() {
        provideOwnEmail("nargiza10041@gmail.com");
        provideNewPassword("te$t$tudent");
        clickSubmitBton();

    }
    public AllSongsPlaylist chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOf(allSongs)).click();
        return this;
    }
    public AllSongsPlaylist contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOf(playFirstSong));
        actions.contextClick(playFirstSong).perform();
        return this;
    }

    public void choosePlay() {
        wait.until(ExpectedConditions.visibilityOf(clickPlay)).click();

    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }
}
