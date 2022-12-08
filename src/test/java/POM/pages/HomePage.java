package POM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'All Songs')]")
    WebElement allSongsList;

    @FindBy(xpath = "//table[@class='items']//tr[@class='song-item']//td[@class='title']")
    WebElement songFromTheList;

    @FindBy(xpath = "//button[@class='btn-add-to']")
    WebElement addToList;

    @FindBy(xpath = "//section[@id='songsWrapper']//li[@class='favorites'] ")
    WebElement addToFavoritesPlaylist;
    @FindBy(xpath = "//li[@class='playlist favorites']")
    WebElement favoritesPlaylist;

    @FindBy(xpath = "//section[@id='favoritesWrapper']//td[@class='title']")
    WebElement addedSong;

    @FindBy(xpath = "//section[@id='favoritesWrapper']//i[@data-test='btn-like-liked']")
    WebElement unlikeBtn;

    @FindBy(xpath = "//i[@class='fa fa-frown-o']")
    public
    WebElement emptyListIcon;

    @FindBy(xpath = "//section[@id='favoritesWrapper']//i[@class='fa fa-heart text-maroon'] ")
    List<WebElement> ListOfElements;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBar;

    @FindBy(xpath = "//section[@data-testid='song-excerpts']//h1")
    WebElement songsSectionResults;

    @FindBy(xpath = "//span[contains(text(),'Search Results')]")
    WebElement searchResults;

    @FindBy(xpath = "//section[@data-testid='artist-excerpts']/h1")
    WebElement artistSectionResults;



    public HomePage(WebDriver sentDriver) {super(sentDriver);}


    public void addSongToTheFavoritesPlaylist() {
        allSongsList.click();
        songFromTheList.click();
        addToList.click();
        addToFavoritesPlaylist.click();
        favoritesPlaylist.click();
    }

    public String getTextAddedSong(){
        return addedSong.getText();

    }

    public void emptyFavoritesPlaylist() {
        favoritesPlaylist.click();
        unlikeBtn.click();
        emptyListIcon.isDisplayed();
    }

    public void clickOnSearchBar() {
        searchBar.click();
        searchBar.sendKeys("dark");

    }

    public boolean isSearchResultsDisplayed() {
        return searchResults.isDisplayed();
    }


    public boolean isSongsSectionResultsDisplayed() {
        return songsSectionResults.isDisplayed();
    }
}

