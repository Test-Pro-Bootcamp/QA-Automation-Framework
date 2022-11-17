package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    //Locators
    //By clickAllSongsBtn = By.xpath("//a[@class='songs']");
    //By clickFavoritesBtn = By.xpath("//a[text()='Favorites']");
    //Locators with page factory
    @FindBy(xpath = "//li//a[@class='songs']")
    WebElement clickAllSongsBtn;
    @FindBy(xpath = "//a[text()='Favorites']")
    WebElement clickFavoritesBtn;



    //Constructor method
    public BasePage(WebDriver givenDriver){
        driver=givenDriver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void clickOnAllSongs(){
//        WebElement allSongsElement = driver.findElement(clickAllSongsBtn);
//        allSongsElement.click();
        clickAllSongsBtn.click();
    }

    public void clickOnFavorites(){
//        WebElement favoritesElement = driver.findElement(clickFavoritesBtn);
//        favoritesElement.click();
        clickFavoritesBtn.click();

    }
}
