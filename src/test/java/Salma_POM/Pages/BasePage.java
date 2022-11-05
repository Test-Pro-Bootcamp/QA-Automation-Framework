package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //Locators
    By clickAllSongsBtn = By.xpath("//a[@class='songs']");
    By clickFavoritesBtn = By.xpath("//a[text()='Favorites']");


    //Constructor method
    public BasePage(WebDriver givenDriver){
        driver=givenDriver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
    public void clickOnAllSongs(){
        WebElement allSongsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clickAllSongsBtn));
        allSongsElement.click();
    }

    public void clickOnFavorites(){
        WebElement favoritesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clickFavoritesBtn));
        favoritesElement.click();
    }
}
