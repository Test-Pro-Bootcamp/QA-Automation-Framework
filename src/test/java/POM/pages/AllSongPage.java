package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongPage extends BasePage {

    //Locators
    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By firstSongLocator = By.cssSelector(".play");

    public AllSongPage(WebDriver givenDriver){

        super(givenDriver);
    }

    public AllSongPage shuffle() {
        driver.findElement(shuffleBtnLocator).click();
        return this;
    }

    public void doubleClickFirstSong() {

        actions.doubleClick(driver.findElement(firstSongLocator)).perform();
    }

    }

