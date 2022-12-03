package POM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

import javax.swing.*;


public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='songs active']")
    WebElement allSongsList;

    @FindBy(xpath = "//table[@class='items']//tr[@class='song-item']//td[@class='title']")
    WebElement songFromTheList;

    @FindBy(xpath = "//button[@class='btn-add-to']")
    WebElement addToList;

    @FindBy(xpath = "//section[@id='songsWrapper']//li[@class='favorites'] ")
    WebElement addToFavoritesPlaylist;
    @FindBy(xpath = "//a[@class='active']")
    WebElement favoritesPlaylist;

    public HomePage(WebDriver sentDriver) {super(sentDriver);}


    public void addSongToTheFavoritesPlaylist() {
        allSongsList.click();
        songFromTheList.click();
        addToList.click();
        addToFavoritesPlaylist.click();
        favoritesPlaylist.click();







    }
}
