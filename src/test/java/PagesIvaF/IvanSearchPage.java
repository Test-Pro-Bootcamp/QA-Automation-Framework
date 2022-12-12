package PagesIvaF;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IvanSearchPage extends BasePageIvan{

    @FindBy(xpath = "//p[contains(text(),'None')]")
    WebElement notFound;
    @FindBy(css = ".songs .details")
    WebElement takeHandSong;

    @FindBy(css = ".artists .item.compact")
    WebElement foundArtist;

    @FindBy(css = ".albums .item.compact")
    WebElement foundAlbum;

    @FindBy(xpath = "//body/div[@id='app']/div[@id='main']/div[@id='mainWrapper']/section[@id='mainContent']/section[@id='searchExcerptsWrapper']/div[1]/div[1]/section[1]/ul[1]/article[1]/span[2]")
    WebElement textSong;



    @FindBy(css = ".jumbo-icon .fa.fa-search")
    WebElement magnifier;


    public IvanSearchPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public IvanSearchPage searchForSong(String songName) {
        searchArea.sendKeys(songName.trim(), Keys.ENTER);
        return this;
    }
    public boolean noneFoundDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(notFound));
        return true;
    }

    public boolean takeHandSongFound() {
        wait.until(ExpectedConditions.visibilityOf(takeHandSong));
        return true;
    }

    public IvanSearchPage searchByArtist() {
        searchArea.sendKeys("Lobo Loco", Keys.ENTER);
        return this;
    }

    public boolean artistFound() {
        wait.until(ExpectedConditions.visibilityOf(foundArtist));
        return true;
    }


    public boolean albumFound() {
        wait.until(ExpectedConditions.visibilityOf(foundAlbum));
        return true;
    }


    public IvanSearchPage clearSearchInput() {
        searchArea.sendKeys(Keys.COMMAND,"a");
        searchArea.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public boolean allClear() {
        searchArea.getText().isEmpty();
        return true;
    }
    public String getTextFromSearch(){
        return textSong.getText().toLowerCase();
    }

}
