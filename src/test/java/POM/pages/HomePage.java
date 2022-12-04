package POM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}

