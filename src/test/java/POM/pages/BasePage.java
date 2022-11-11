package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//a[contains(text(),'Songs')]")
    WebElement allSongsMenuItem;
    @FindBy(xpath = "//a[contains(text(),'Albums')]")
    WebElement albumsMenuItem;

    @FindBy(xpath = "//a[text()='Favorites']")
    WebElement favoritesMenuItem;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsMenuItem)).click();
        return this;
    }

    public BasePage clickAlbums() {
        wait.until(ExpectedConditions.elementToBeClickable(albumsMenuItem)).click();
        return this;
    }

    public BasePage clickFavorites() {
        wait.until(ExpectedConditions.elementToBeClickable(favoritesMenuItem)).click();
        return this;
    }
}

