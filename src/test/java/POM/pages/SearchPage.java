package POM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class SearchPage extends BasePage {

    @FindBy(css = ".songs .details")
    WebElement foundPlutoSong;

    @FindBy(css = ".artists .item.compact")
    WebElement foundMakaihArtist;

    @FindBy(css = ".albums .item.compact")
    WebElement foundAirbitAlbum;

    @FindBy(xpath = "//section[@class='songs']//p[contains(text(),'None')]")
    WebElement noneFound;

    @FindBy(css = ".jumbo-icon .fa.fa-search")
    WebElement magnifier;

    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SearchPage searchForSong(String songName) {
        searchField.sendKeys(songName.trim(), Keys.ENTER);
        return this;
    }

    public String convertToLowerCase(String searchKeyword){
        String searchResult = searchKeyword.toLowerCase();
        return  searchResult;
    }

    public SearchPage enterSearchKeyword(String searchValue) {
        searchField.sendKeys(convertToLowerCase(searchValue));
        return this;
    }
    public boolean plutoFound() {
        wait.until(ExpectedConditions.visibilityOf(foundPlutoSong));
        return true;
    }

    public SearchPage searchByArtist() {
        searchField.sendKeys("Makaih", Keys.ENTER);
        return this;
    }

    public boolean makaihFound() {
        wait.until(ExpectedConditions.visibilityOf(foundMakaihArtist));
        return true;
    }

    public SearchPage searchByAlbum() {
        searchField.sendKeys("Airbit", Keys.ENTER);
        return this;
    }

    public boolean airbitFound() {
        wait.until(ExpectedConditions.visibilityOf(foundAirbitAlbum));
        return true;
    }

    public boolean noneFoundDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(noneFound));
        return true;
    }
    public SearchPage clearSearchInput() {
        searchField.sendKeys(Keys.CONTROL,"a",Keys.CONTROL, "x", Keys.CONTROL, "r");
        return this;
    }

    public boolean allClear() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        wait.until(ExpectedConditions.visibilityOf(magnifier));
        return true;
    }
}
