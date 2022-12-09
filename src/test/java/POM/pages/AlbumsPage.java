package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlbumsPage extends BasePage{

    @FindBy(xpath = "//section[@id='albumsWrapper']//a[contains(text(),'Makaih')]")
    WebElement artistMakaih;
    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap album']//button[contains(@title,'Like Pluto')]")
    WebElement heartBtnPluto;
    @FindBy(xpath = "//button[@title='Like BornKing by Makaih Beats']")
    WebElement heartBtnBornKing;

    String urlAlbumsPage = "https://bbb.testpro.io/#!/albums";

    public AlbumsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public String getUrlAlbumsPage() {

        return urlAlbumsPage;
    }
    public AlbumsPage clickArtist(){
        wait.until(ExpectedConditions.elementToBeClickable(artistMakaih)).click();
//        artistMakaih.click();
        return this;
    }
    public AlbumsPage clickHeartBtnPluto(){
        wait.until(ExpectedConditions.elementToBeClickable(heartBtnPluto)).click();
//        heartBtnPluto.click();
        return this;
    }

    public AlbumsPage clickHeartBtnBornKing() {
        wait.until(ExpectedConditions.visibilityOf(heartBtnBornKing)).click();
//        heartBtnPluto.click();
        return this;
    }
}