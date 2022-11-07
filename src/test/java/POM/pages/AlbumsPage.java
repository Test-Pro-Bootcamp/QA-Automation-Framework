package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumsPage extends BasePage{
    @FindBy(xpath = "//section[@id='albumsWrapper']//a[contains(text(),'Makaih')]")
    WebElement artistMakaih;
    @FindBy(xpath = "//button[contains(@title,'Like Pluto')]")
    WebElement heartBtnPluto;
    @FindBy(xpath = "//button[@title='Unlike Pluto by Makaih Beats']")
    WebElement likedPlutoSong;

    public AlbumsPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public AlbumsPage clickArtist(){
        artistMakaih.click();
        return this;
    }
    public AlbumsPage clickHeartBtnPluto(){
        heartBtnPluto.click();
        return this;
    }
    public boolean isSongPlutoLiked(){
        likedPlutoSong.isDisplayed();
        return true;
    }
}
