package Homework;

import POM.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Homework19 extends BasePage {

    public Homework19(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void deletePL(){
        createPL();
        chosePL();
        getPlaylistLink();
        deleteChosenPL();
        verifyRemovedPL();
    }
    private void createPL() {
        WebElement createNewPlayListsButton = driver.findElement( By.xpath("//*[@id=\"playlists\"]/h1/i"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userBadge\"]/a[1]/img")));
        createNewPlayListsButton.click();
        createNewPlayListsButton.click();

        WebElement createNewPlayLists = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        createNewPlayLists.click();
        WebElement createNewPlayListsKeyField = driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input"));
        createNewPlayListsKeyField.click();
        createNewPlayListsKeyField.sendKeys("PlayListsForDeleting");
        createNewPlayListsKeyField.submit();

        WebElement PlayListsForDeleting = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        Assert.assertTrue(PlayListsForDeleting.isDisplayed());
    }
    private void chosePL(){

        WebElement chosePL = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        chosePL.click();
    }
    private void getPlaylistLink() {

        WebElement getPlaylistLink = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        getPlaylistLink.click();
        driver.navigate().refresh();
    }
    private void deleteChosenPL(){

        WebElement getPlaylistLink = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        getPlaylistLink.click();
        driver.navigate().refresh();
        WebElement deleteChosenPL = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button"));
        deleteChosenPL.click();
    }
    private void verifyRemovedPL (){

        WebElement verifyRemovedPL = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        Assert.assertEquals(true, verifyRemovedPL.isDisplayed());
    }

}