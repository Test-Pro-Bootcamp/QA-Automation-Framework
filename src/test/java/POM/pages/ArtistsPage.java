package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArtistsPage extends BasePage {

    @FindBy(xpath = "//article[@title='BoxCat Games' and @class='item full']")
    WebElement artistBoxCatGames;

    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap queue']//button[@title='Like Epic Song by BoxCat Games']")
    WebElement epicSongByBCG;

    public ArtistsPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public ArtistsPage clickBoxCatGamesArtist(){
        wait.until(ExpectedConditions.elementToBeClickable(artistBoxCatGames)).click();
        return this;
    }
    public ArtistsPage clickHeartBtnEpic(){
        wait.until(ExpectedConditions.elementToBeClickable(epicSongByBCG)).click();
        return this;
    }
}
