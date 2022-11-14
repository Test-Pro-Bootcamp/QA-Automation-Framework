package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlbumsPage extends BasePage{
    @FindBy(xpath = "//section[@id='albumsWrapper']//a[contains(text(),'Makaih')]")
    WebElement artistMakaih;
    @FindBy(xpath = "//button[contains(@title,'Like Pluto')]")
    WebElement heartBtnPluto;


    public AlbumsPage(WebDriver givenDriver){
        super(givenDriver);
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
}