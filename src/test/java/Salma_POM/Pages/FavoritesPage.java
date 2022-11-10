package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends BasePage{
    String songName = "Waiting On A Train";
   //Locators
    //By favoritesSectionLocator = By.xpath("//div[@class='song-list-wrap main-scroll-wrap favorites']");
    //Locators with Page factory
    @FindBy(xpath="//div[@class='song-list-wrap main-scroll-wrap favorites']")
    WebElement favoritesSection;

    //Constructor Method
    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public String getTextFromFavorites(){
//        WebElement favoritesSection = driver.findElement(favoritesSectionLocator);
//        return favoritesSection.getText();
        return favoritesSection.getText();
    }
    public boolean isSongAddedToFavorites(){
        return getTextFromFavorites().contains(songName);
    }


}
