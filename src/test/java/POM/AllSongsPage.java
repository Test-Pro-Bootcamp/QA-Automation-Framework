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
    private String searchPhrase = "Waiting On A Train";

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void search() {
        waitAndActionsClickWebElement(searchField);
        searchField.sendKeys(searchPhrase);
    }
    public void playSelectedSong() {
        waitAndContextClickWebElement(mySelectedSong);
        playButton.click();
    }
    public boolean playingOfTheSongIsDisplayed() {
        waitForVisibilityOfElement(visualizer);
        return visualizer.isDisplayed();
    }
}