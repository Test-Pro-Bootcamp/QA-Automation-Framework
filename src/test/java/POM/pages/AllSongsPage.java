package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    By shufleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By chosenSongLocator = By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]");

    public AllSongsPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    public void shuffleSongs(){
        driver.findElement(shufleBtnLocator).click();
    }
    public void doubleClickChosenSong(){
        WebElement chosenSongLocator = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]"));
        actions.doubleClick( chosenSongLocator).perform();
    }
    public AllSongsPage choseASong(){
        driver.findElement((By) chosenSongLocator).click();
        return new AllSongsPage(driver);
    }
}
