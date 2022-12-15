package Homework;

import POM.FactoryPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Homework20 extends BasePage {


    public Homework20(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void playSongFromPlaylist() {
        openPlaylist();
        selectAndLaunchTheSong();
        verifySongPlaying();
    }

    public void openPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'ITS ALIVE!!!!!')]")));
        WebElement openPlaylist = driver.findElement(By.xpath("//a[contains(text(), 'ITS ALIVE!!!!!')]"));
        openPlaylist.click();
    }

    public void selectAndLaunchTheSong() {
        WebElement selectAndLaunchTheSong = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[3]"));
        actions.contextClick(selectAndLaunchTheSong).perform();
        actions.contextClick(selectAndLaunchTheSong).perform();
        WebElement hitPlayBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[1]"));
        hitPlayBtn.click();
    }

    public void verifySongPlaying() {
        WebElement soundBars = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div/img"));
        Assert.assertEquals(true, soundBars.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div/img")));
    }
}