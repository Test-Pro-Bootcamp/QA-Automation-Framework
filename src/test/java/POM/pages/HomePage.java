package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage extends BasePage{
    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;

    @FindBy(xpath="//a[contains(text(),'Nozima')]")
    WebElement nozimaPlaylist ;

    @FindBy(xpath = "//input[@name='name']")
    WebElement smartPNameInput ;

    @FindBy(xpath = "//select[contains(@name,'model')]/option[contains(text(),'Album')]")
    WebElement clickAlbumOption;

    @FindBy (xpath = "//input[contains(@name,'value')]")
    WebElement optionFieldInput;

    @FindBy (xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;


    String url = "https://bbb.testpro.io/";

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public String homepageURL(){

        return url;
    }

    public HomePage createPlaylist(String newPlaylistName) {
        driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(newPlaylistName, Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
        return this;
    }

    public HomePage doubleClickPlaylistName() {
        WebElement danaPlaylist = driver.findElement(By.xpath("//input[@name='name']"));
        actions.doubleClick(danaPlaylist).perform();
        danaPlaylist.sendKeys("Updated Playlist", Keys.ENTER);
        return this;
    }

    public HomePage editPlaylist() {
        driver.findElement(By.xpath("//li[text()='Edit']")).click();
        return this;
    }

    public HomePage rightClickOnPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//a[contains(text(),'Dana')]"));
        actions.contextClick(playlist).perform();
        return this;
    }

    public HomePage hoverOver() {
        WebElement playlist = driver.findElement(By.xpath("//a[contains(text(),'Dana')]"));
        actions.moveToElement(playlist).perform();
        return this;
    }

    public int getNumberOfPlaylist() {
        return playlists.size();
    }

    public HomePage goToMyPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(nozimaPlaylist)).click();
        return this;
    }

    public HomePage clickDeleteBtn() {
        WebElement deletePB = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePB.click();
        return this;
    }

    public HomePage createSmartPlaylist() {
        driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'New Smart Playlist')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(smartPNameInput)).sendKeys("My Smart List");
        wait.until(ExpectedConditions.visibilityOf(clickAlbumOption)).click();
        optionFieldInput.click();
        optionFieldInput.sendKeys("Airbit");
        saveBtn.click();

        return this;
    }
}