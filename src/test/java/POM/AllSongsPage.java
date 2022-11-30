package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AllSongsPage extends BasePage {
    @FindBy(xpath ="//input[@type='search']")
    WebElement searchField;
    @FindBy(xpath = "//ul/article/span[2]/span[1]")
    WebElement mySelectedSong;
    @FindBy(xpath = "//span[text()='Play']")
    WebElement playButton;
    @FindBy(xpath = "//img[@alt='Sound bars']")
    WebElement visualizer;
    @FindBy(xpath="//div[@class='results']/section[@class='songs']")
    WebElement songsResultsSection;
    @FindBy(xpath="//div[@class='results']/section[@class='artists']")
    WebElement artistsResultsSection;
    @FindBy(xpath="//div[@class='results']/section[@class='albums']")
    WebElement albumsResultsSection;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void search(String songName) {
        waitAndActionsClickWebElement(searchField);
        searchField.sendKeys(songName);
    }
    public void playSelectedSong() {
        waitAndContextClickWebElement(mySelectedSong);
        playButton.click();
    }
    public boolean playingOfTheSongIsDisplayed() {
        waitForVisibilityOfElement(visualizer);
        return visualizer.isDisplayed();
    }
    public void validatePlayOfTheSong() {
        Assert.assertTrue(visualizer.isDisplayed());
    }
    public boolean songsResultsSectionIsDisplayed(){
        waitForVisibilityOfElement(songsResultsSection);
        return songsResultsSection.isDisplayed();
    }
    public void validateSongsResultsSection(){
            Assert.assertTrue(songsResultsSectionIsDisplayed());

    }
    public boolean artistsResultsSectionIsDisplayed(){
        waitForVisibilityOfElement(artistsResultsSection);
        return artistsResultsSection.isDisplayed();
    }
    public void validateArtistsResultsSection(){
        Assert.assertTrue(artistsResultsSectionIsDisplayed());
    }
    public boolean albumsResultsSectionIsDisplayed(){
        waitForVisibilityOfElement(albumsResultsSection);
        return albumsResultsSection.isDisplayed();
    }
    public void validateAlbumsResultsSection(){
        Assert.assertTrue(albumsResultsSectionIsDisplayed());
    }
    public boolean searchedSongIsDisplayed(){
        waitForVisibilityOfElement(mySelectedSong);
        return mySelectedSong.isDisplayed();
    }
    public void validateSearchedSong(){
        Assert.assertTrue(searchedSongIsDisplayed());
    }
    public String getTextFirstSongFromSearchResults() {
        return mySelectedSong.getText();
    }
    public String getTextForSongsResultsSection(){
        waitForVisibilityOfElement(songsResultsSection);
        return songsResultsSection.getText();
    }
}